package iomanager;

public class InputDistributor {
    private final int id;
    private final int contractLength;
    private final int initialBudget;
    private final int initialInfrastructureCost;
    private final int energyNeededKW;
    private final String producerStrategy;

    public InputDistributor() {
        this.id = 0;
        this.contractLength = 0;
        this.initialBudget = 0;
        this.initialInfrastructureCost = 0;
        this.energyNeededKW = 0;
        this.producerStrategy = null;
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
    public int getContractLength() {
        return contractLength;
    }

    /**
     * @return
     */
    public int getInitialBudget() {
        return initialBudget;
    }


    /**
     * @return
     */
    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }


    /**
     * @return
     */
    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    /**
     * @return
     */
    public String getProducerStrategy() {
        return producerStrategy;
    }
}
