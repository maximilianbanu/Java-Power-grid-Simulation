package producermanager;

import players.Distributor;
import players.Producer;

import java.util.ArrayList;

public class ProducerCalculator {


    /**
     * Method to query the list of producers in order to find enough producers, based on
     * the criteria of the distributor, to suffice the energy needed. The query uses
     * different comparators for each type of strategy the distributor uses.
     *
     * @param producers
     * @param distributor
     */
    public void findNewProducers(final ArrayList<Producer> producers, Distributor distributor) {
        int currentEnergy = 0;
        ProducerSortTool sortTool = null;
        int energyRequired = distributor.getEnergyNeededKW();
        if (distributor.getProducerStrategy().equals("GREEN")) {
            sortTool = new ProducerSortTool(new GreenSort());
        }
        if (distributor.getProducerStrategy().equals("PRICE")) {
            sortTool = new ProducerSortTool(new PriceSort());
        }
        if (distributor.getProducerStrategy().equals("QUANTITY")) {
            sortTool = new ProducerSortTool(new QuantitySort());
        }
        ArrayList<Producer> sortedProducers = sortTool.applySort(producers);
        for (Producer producer : sortedProducers) {
            if (producer.getCurrentNrDistributors() < producer.getMaxDistributors()) {
                producer.setCurrentNrDistributors(producer.getCurrentNrDistributors() + 1);
                currentEnergy += producer.getEnergyPerDistributor();
                distributor.getProducerList().add(producer);
                producer.addObserver(distributor);
                if (currentEnergy >= energyRequired) {
                    break;
                }
            }
        }
    }

    /**
     *
     * Method to clear the list of producers the distributor is currently subscribed to,
     * in case one of his current producers gets a monthly change in his distributed
     * energy quanitity. The method also makes sure to remove the distributor from
     * the observer list of each producer.
     *
     * @param distributor
     */
    public void clearProducers(Distributor distributor) {
        for (Producer producer : distributor.getProducerList()) {
            producer.setCurrentNrDistributors(producer.getCurrentNrDistributors() - 1);
            producer.deleteObserver(distributor);
        }
        distributor.getProducerList().clear();
    }
}
