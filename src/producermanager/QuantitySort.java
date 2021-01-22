package producermanager;

import players.Producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuantitySort implements ProducerSortStrategy, Comparator<Producer> {

    /**
     * Compartor constructed in order to sort the producer list for a distributor who
     * uses "QUANTITY" strategy, choosing the prodcers with the highest quantity.
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(Producer a, Producer b) {
        if (a.getEnergyPerDistributor() != b.getEnergyPerDistributor()) {
            return -Integer.compare(a.getEnergyPerDistributor(),
                    b.getEnergyPerDistributor());
        } else {
            return Integer.compare(a.getId(), b.getId());
        }
    }

    /**
     *
     * @param producers
     * @return
     */
    @Override
    public ArrayList<Producer> findNewProducers(final ArrayList<Producer> producers) {
        ArrayList<Producer> sortedProducers = new ArrayList<>(producers);
        Collections.sort(sortedProducers, this::compare);
        return sortedProducers;
    }
}
