package iomanager;

import java.util.ArrayList;

public class FullOutput {
    private final ArrayList<OutputConsumer> consumers;
    private final ArrayList<OutputDistributor> distributors;
    private final ArrayList<OutputProducer> energyProducers;

    public FullOutput(final ArrayList<OutputConsumer> consumers,
                      final ArrayList<OutputDistributor> distributors,
                      final ArrayList<OutputProducer> producers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.energyProducers = producers;
    }

    /**
     * @return
     */
    public ArrayList<OutputConsumer> getConsumers() {
        return consumers;
    }

    /**
     * @return
     */
    public ArrayList<OutputDistributor> getDistributors() {
        return distributors;
    }

    /**
     * @return
     */
    public ArrayList<OutputProducer> getEnergyProducers() {
        return energyProducers;
    }
}
