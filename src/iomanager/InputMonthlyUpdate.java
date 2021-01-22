package iomanager;

import java.util.ArrayList;

public class InputMonthlyUpdate {

    private final ArrayList<InputConsumer> newConsumers;
    private final ArrayList<InputDistributorChange> distributorChanges;
    private final ArrayList<InputProducerChange> producerChanges;

    public InputMonthlyUpdate() {
        this.newConsumers = null;
        this.distributorChanges = null;
        this.producerChanges = null;
    }


    /**
     * @return
     */
    public ArrayList<InputConsumer> getNewConsumers() {
        return newConsumers;
    }

    /**
     * @return
     */
    public ArrayList<InputDistributorChange> getDistributorChanges() {
        return distributorChanges;
    }

    /**
     * @return
     */
    public ArrayList<InputProducerChange> getProducerChanges() {
        return producerChanges;
    }
}
