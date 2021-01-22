package producermanager;

import players.Producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GreenSort implements ProducerSortStrategy, Comparator<Producer> {

    /**
     * Compartor constructed in order to sort the producer list for a distributor who
     * uses "GREEN" strategy, prioritizing renewable energy, than price, than quantity.
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(Producer a, Producer b) {
        if (a.getEnergyType().isRenewable() && !b.getEnergyType().isRenewable()) {
            return -1;
        } else if (!a.getEnergyType().isRenewable() && b.getEnergyType().isRenewable()) {
            return 1;
        } else {
            if (a.getPriceKW() != b.getPriceKW()) {
                return Double.compare(a.getPriceKW(), b.getPriceKW());
            } else {
                if (a.getEnergyPerDistributor() != b.getEnergyPerDistributor()) {
                    return -Integer.compare(a.getEnergyPerDistributor(),
                            b.getEnergyPerDistributor());
                } else {
                    return Integer.compare(a.getId(), b.getId());
                }
            }
        }
    }

    /**
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
