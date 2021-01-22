package players;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Distributor implements Observer {
    private final int id;
    private final int contractLength;
    private int budget;
    private int infrastructureCost;
    private final int energyNeededKW;
    private final String producerStrategy;
    private boolean isBankrupt;
    private final ArrayList<Contract> contractList;
    private final ArrayList<Producer> producerList;
    private boolean needsUpdate;
    private int price;

    /**
     * @param id
     * @param contractLength
     * @param initialBudget
     * @param initialInfrastructureCost
     * @param initalEnergyNeededKW
     * @param initialProducerStrategy
     */
    public Distributor(final int id, final int contractLength, final int initialBudget,
                       final int initialInfrastructureCost, final int initalEnergyNeededKW,
                       final String initialProducerStrategy) {
        this.id = id;
        this.contractLength = contractLength;
        this.budget = initialBudget;
        this.infrastructureCost = initialInfrastructureCost;
        this.energyNeededKW = initalEnergyNeededKW;
        this.producerStrategy = initialProducerStrategy;
        this.isBankrupt = false;
        this.contractList = new ArrayList<>();
        this.producerList = new ArrayList<>();
        this.price = 0;
        this.needsUpdate = false;
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
    public int getBudget() {
        return budget;
    }

    /**
     * @param budget
     */
    public void setBudget(final int budget) {
        this.budget = budget;
    }

    /**
     * @return
     */
    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    /**
     * @param infrastructureCost
     */

    public void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
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

    /**
     * @return
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * @param bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * @return
     */
    public ArrayList<Contract> getContractList() {
        return contractList;
    }

    /**
     * @return
     */
    public ArrayList<Producer> getProducerList() {
        return producerList;
    }

    /**
     * @return
     */
    public boolean needsUpdate() {
        return needsUpdate;
    }

    /**
     * @param needsUpdate
     */
    public void setNeedsUpdate(boolean needsUpdate) {
        this.needsUpdate = needsUpdate;
    }

    /**
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(final int price) {
        this.price = price;
    }

    /**
     * Notification to the distributor that a current producer he's subscribed to has
     * changed it's current distributed energy amount, signaling the GameTracker
     * that the respective distributor needs a new set of producers.
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        this.setNeedsUpdate(true);
    }

}
