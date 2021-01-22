package iomanager;

public class InputProducerChange {

    private final int id;
    private final int energyPerDistributor;

    public InputProducerChange() {
        this.id = 0;
        this.energyPerDistributor = 0;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }
}
