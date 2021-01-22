package iomanager;

import entities.EnergyType;

public class InputProducer {
    private final int id;
    private final EnergyType energyType;
    private final int maxDistributors;
    private final double priceKW;
    private final int energyPerDistributor;

    public InputProducer() {
        this.id = 0;
        this.energyType = null;
        this.maxDistributors = 0;
        this.priceKW = 0;
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
    public EnergyType getEnergyType() {
        return energyType;
    }

    /**
     * @return
     */
    public int getMaxDistributors() {
        return maxDistributors;
    }

    /**
     * @return
     */
    public double getPriceKW() {
        return priceKW;
    }

    /**
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }
}
