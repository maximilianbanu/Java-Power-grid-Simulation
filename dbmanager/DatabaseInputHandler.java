package dbmanager;

import iomanager.FullInput;
import iomanager.InputConsumer;
import iomanager.InputDistributor;
import iomanager.InputProducer;
import players.*;

import java.util.ArrayList;

public class DatabaseInputHandler {

    /**
     * Takes the input consumers and adds them to the database.
     */
    public void handleConsumers(FullInput fullInput, ArrayList<Consumer> consumers,
                                 ConsumerSingletonFactory consumerFactory) {
        for (InputConsumer inputConsumer : fullInput.getInitialData().getConsumers()) {
            consumers.add(consumerFactory.createConsumer(inputConsumer.getId(),
                    inputConsumer.getInitialBudget(),
                    inputConsumer.getMonthlyIncome()));
        }
    }

    /**
     * Takse the input distributors and adds them to the database.
     */
    public void handleDistributors(FullInput fullInput, ArrayList<Distributor> distributors,
                                    DistributorSingletonFactory distributorFactory) {
        for (InputDistributor inputDistributor : fullInput.getInitialData().getDistributors()) {
            distributors.add(distributorFactory.createDistributor(inputDistributor.getId(),
                    inputDistributor.getContractLength(),
                    inputDistributor.getInitialBudget(),
                    inputDistributor.getInitialInfrastructureCost(),
                    inputDistributor.getEnergyNeededKW(),
                    inputDistributor.getProducerStrategy()));
        }
    }

    /**
     * Take the input producers and adds them to the database.
     */
    public void handleProducers(FullInput fullInput, ArrayList<Producer> producers,
                                 ProducerSingletonFactory producerFactory) {
        for (InputProducer inputProducer : fullInput.getInitialData().getProducers()) {
            producers.add(producerFactory.createProducer(inputProducer.getId(),
                    inputProducer.getEnergyType(),
                    inputProducer.getMaxDistributors(),
                    inputProducer.getPriceKW(),
                    inputProducer.getEnergyPerDistributor()));
        }
    }
}
