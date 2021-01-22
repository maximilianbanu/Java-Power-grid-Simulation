package gamelogic;

import consumermanager.ConsumerCalculator;
import distributormanager.DistributorCalculator;
import producermanager.ProducerCalculator;
import iomanager.*;
import players.*;

import java.util.ArrayList;

public class GameTracker {

    private final DistributorCalculator dCalculator = new DistributorCalculator();
    private final ConsumerCalculator cCalculator = new ConsumerCalculator();
    private final ProducerCalculator pCalculator = new ProducerCalculator();

    /**
     * Method meant to handle the initialization of the game state, in which the best priced
     * distributor is found and all the consumers make from a contract to him
     *
     * @param consumers    list of consumers
     * @param distributors list of distributors
     */
    public void initializeGame(final ArrayList<Consumer> consumers,
                               final ArrayList<Distributor> distributors,
                               final ArrayList<Producer> producers) {

        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                pCalculator.findNewProducers(producers, distributor);
            }
        }

        int minimalCost = Integer.MAX_VALUE;
        Distributor bestDistributor = null;

        for (Distributor distributor : distributors) {
            distributor.setPrice(dCalculator.caculateCurrentPrice(distributor));
            if (distributor.getPrice() < minimalCost) {
                minimalCost = distributor.getPrice();
                bestDistributor = distributor;
            }
        }

        for (Consumer consumer : consumers) {
            consumer.setBudget(consumer.getBudget() + consumer.getMonthlyIncome());
            Contract contract = new Contract(consumer.getId(), minimalCost,
                    bestDistributor.getContractLength(), bestDistributor.getId(),
                    consumer);
            bestDistributor.getContractList().add(contract);
        }

        for (Consumer consumer : consumers) {
            if (!consumer.isBankrupt()) {
                cCalculator.paymentMethod(consumer,
                        cCalculator.findBelongingContract(consumer, distributors), distributors);
            }
        }
        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                distributor.setBudget(distributor.getBudget() - distributor.getInfrastructureCost()
                        - dCalculator.calculateProductionCost(distributor)
                        * (distributor.getContractList().size()));
                if (distributor.getBudget() < 0) {
                    distributor.setBankrupt(true);
                    distributor.getContractList().clear();
                    pCalculator.clearProducers(distributor);
                }
            }
        }

        for (Consumer consumer : consumers) {
            if (cCalculator.findBelongingContract(consumer, distributors) != null) {
                if (consumer.isBankrupt()) {
                    distributors.get(cCalculator.findBelongingContract(consumer, distributors).
                            getDistributorId()).getContractList().
                            remove(cCalculator.findBelongingContract(consumer, distributors));
                }
            }
        }
    }

    /**
     * The start of turn, in which events happen as it follows:
     * <p>
     * - all the monthly updates (new consumers/ production or infrastructure changes get added/made
     * <p>
     * - distributors set their new prices and the best one gets set as best distributor
     * <p>
     * - all the expiring contracts ( 0 months remaining ) are destroyed
     * <p>
     * = all the consumers who don't currently have a contract get a new one at the best distributor
     *
     * @param turnNr          current turn number
     * @param gameInput       the input received
     * @param consumerFactory factory of consumers
     * @param consumers       list of consumers
     * @param distributors    list of distributors
     */
    public void startOfTurn(final int turnNr, final FullInput gameInput,
                            final ConsumerSingletonFactory consumerFactory,
                            final ArrayList<Consumer> consumers,
                            final ArrayList<Distributor> distributors) {

        if (!gameInput.getMonthlyUpdates().get(turnNr).getNewConsumers().isEmpty()) {
            for (InputConsumer newConsumer
                    : gameInput.getMonthlyUpdates().get(turnNr).getNewConsumers()) {
                consumers.add(consumerFactory.createConsumer(newConsumer.getId(),
                        newConsumer.getInitialBudget(),
                        newConsumer.getMonthlyIncome()));
            }
        }
        if (!gameInput.getMonthlyUpdates().get(turnNr).getDistributorChanges().isEmpty()) {
            for (InputDistributorChange newCost
                    : gameInput.getMonthlyUpdates().get(turnNr).getDistributorChanges()) {
                distributors.get(newCost.getId()).
                        setInfrastructureCost(newCost.getInfrastructureCost());
            }
        }

        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                distributor.setPrice(dCalculator.caculateCurrentPrice(distributor));
            }
        }

        for (Consumer consumer : consumers) {
            if (cCalculator.findBelongingContract(consumer, distributors) != null) {
                if (cCalculator.findBelongingContract(consumer, distributors)
                        .getRemainedContractMonths() == 0) {
                    distributors.get(cCalculator.findBelongingContract(consumer, distributors).
                            getDistributorId()).getContractList().
                            remove(cCalculator.findBelongingContract(consumer, distributors));
                }
            }
        }

        Distributor bestDistributor = dCalculator.findBestDistributor(distributors);

        for (Consumer consumer : consumers) {
            if (!consumer.isBankrupt()) {
                consumer.setBudget(consumer.getBudget() + consumer.getMonthlyIncome());
                if (cCalculator.findBelongingContract(consumer, distributors) == null) {
                    Contract contract = new Contract(consumer.getId(), bestDistributor.getPrice(),
                            bestDistributor.getContractLength(), bestDistributor.getId(),
                            consumer);
                    bestDistributor.getContractList().add(contract);
                }
            }
        }

    }

    /**
     * The end of a turn, where 3 things happen:
     * <p>
     * - payments are made by consumers and distributors gain the appropriate amount
     * of money, while also handling debt cases and bankrupcy cases
     * <p>
     * - payments are made by distributors, after they have gained the moeny from
     * consumers, and those who have went bellow 0 are declared bankrupt, and
     * all their contracts are destroyed
     * <p>
     * - all the bankrupt consumers get their contracts destroyed
     *
     * @param consumers    list of consumers
     * @param distributors list of distributors
     */
    public void endOfTurn(final int turnNr, final FullInput gameInput,
                          final ArrayList<Consumer> consumers,
                          final ArrayList<Distributor> distributors,
                          final ArrayList<Producer> producers) {
        for (Consumer consumer : consumers) {
            if (!consumer.isBankrupt()) {
                cCalculator.paymentMethod(consumer,
                        cCalculator.findBelongingContract(consumer, distributors), distributors);
            }
        }
        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                distributor.setBudget(distributor.getBudget() - distributor.getInfrastructureCost()
                        - dCalculator.calculateProductionCost(distributor)
                        * (distributor.getContractList().size()));
                if (distributor.getBudget() < 0) {
                    distributor.setBankrupt(true);
                    distributor.getContractList().clear();
                    pCalculator.clearProducers(distributor);
                }
            }
        }

        for (Consumer consumer : consumers) {
            if (cCalculator.findBelongingContract(consumer, distributors) != null) {
                if (consumer.isBankrupt()) {
                    distributors.get(cCalculator.findBelongingContract(consumer, distributors).
                            getDistributorId()).getContractList().
                            remove(cCalculator.findBelongingContract(consumer, distributors));
                }
            }
        }

        if (!gameInput.getMonthlyUpdates().get(turnNr).getProducerChanges().isEmpty()) {
            for (InputProducerChange newCost
                    : gameInput.getMonthlyUpdates().get(turnNr).getProducerChanges()) {
                producers.get(newCost.getId()).
                        setEnergyPerDistributor(newCost.getEnergyPerDistributor());
                producers.get(newCost.getId()).change();
            }
        }

        for (Distributor distributor : distributors) {
            if (distributor.needsUpdate()) {
                pCalculator.clearProducers(distributor);
                pCalculator.findNewProducers(producers, distributor);
                distributor.setNeedsUpdate(false);
            }
        }


        for (Producer producer : producers) {
            MonthlyStat monthlyStat = new MonthlyStat(turnNr + 1, new ArrayList<>());
            producer.getMonthlyStats().add(monthlyStat);
        }

        for (Distributor distributor : distributors) {
            for (Producer producer : distributor.getProducerList()) {
                producer.getMonthlyStats().get(turnNr).
                        getDistributorsIds().add(distributor.getId());
            }
        }

    }

}
