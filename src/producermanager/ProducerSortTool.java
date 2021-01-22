package producermanager;

import players.Producer;

import java.util.ArrayList;

public class ProducerSortTool {
    private ProducerSortStrategy sortStrategy;

    public ProducerSortTool(ProducerSortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    /**
     *
     * Applies the sort on the producer list based on the strategy chosen.
     *
     * @param producers
     * @return
     */
    public ArrayList<Producer> applySort(ArrayList<Producer> producers) {
        return sortStrategy.findNewProducers(producers);
    }
}
