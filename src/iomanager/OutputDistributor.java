package iomanager;

import java.util.ArrayList;

public class OutputDistributor {
    private final int id;
    private final int energyNeededKW;
    private final int contractCost;
    private final int budget;
    private final String producerStrategy;
    private final boolean isBankrupt;
    private final ArrayList<OutputContract> contracts;

    public OutputDistributor(final int id, final int energyNeededKW, final int contractCost,
                             final int budget, final String producerStrategy,
                             final boolean isBankrupt, final ArrayList<OutputContract> contracts) {
        this.id = id;
        this.energyNeededKW = energyNeededKW;
        this.contractCost = contractCost;
        this.budget = budget;
        this.isBankrupt = isBankrupt;
        this.producerStrategy = producerStrategy;
        this.contracts = contracts;
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
    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    /**
     * @return
     */
    public int getContractCost() {
        return contractCost;
    }

    /**
     * @return
     */
    public int getBudget() {
        return budget;
    }

    /**
     * @return
     */
    public String getProducerStrategy() {
        return producerStrategy;
    }

    /**
     * @return
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * @return
     */
    public ArrayList<OutputContract> getContracts() {
        return contracts;
    }

}
