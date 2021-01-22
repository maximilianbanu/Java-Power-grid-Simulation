package iomanager;

import java.util.ArrayList;

public class InputInitialData {
    private final ArrayList<InputConsumer> consumers;
    private final ArrayList<InputDistributor> distributors;
    private final ArrayList<InputProducer> producers;

    public InputInitialData() {
        this.consumers = null;
        this.distributors = null;
        this.producers = null;
    }

    /**
     * @return
     */
    public ArrayList<InputConsumer> getConsumers() {
        return consumers;
    }

    /**
     * @return
     */
    public ArrayList<InputDistributor> getDistributors() {
        return distributors;
    }

    /**
     * @return
     */
    public ArrayList<InputProducer> getProducers() {
        return producers;
    }
}
