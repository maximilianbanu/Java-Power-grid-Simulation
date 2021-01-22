package producermanager;

import players.Producer;

import java.util.ArrayList;

public interface ProducerSortStrategy {
    /**
     * @param producers
     * @return
     */
    ArrayList<Producer> findNewProducers(ArrayList<Producer> producers);
}
