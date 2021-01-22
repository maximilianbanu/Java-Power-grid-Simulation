package players;

import entities.EnergyType;

import java.util.ArrayList;
import java.util.Observable;

public class Producer extends Observable {
    private int id;
    private EnergyType energyType;
    private int maxDistributors;
    private double priceKW;
    private int energyPerDistributor;
    private int currentNrDistributors;
    private ArrayList<MonthlyStat> monthlyStats;

    /**
     * @param id
     * @param energyType
     * @param maxDistributors
     * @param priceKW
     * @param energyPerDistributor
     */
    public Producer(final int id, final EnergyType energyType,
                    final int maxDistributors, final double priceKW,
                    final int energyPerDistributor) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
        this.currentNrDistributors = 0;
        this.monthlyStats = new ArrayList<>();
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public EnergyType getEnergyType() {
        return energyType;
    }

    /**
     * @param energyType
     */
    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    /**
     * @return
     */
    public int getMaxDistributors() {
        return maxDistributors;
    }

    /**
     * @param maxDistributors
     */
    public void setMaxDistributors(int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    /**
     * @return
     */
    public double getPriceKW() {
        return priceKW;
    }

    /**
     * @param priceKW
     */
    public void setPriceKW(double priceKW) {
        this.priceKW = priceKW;
    }

    /**
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * @param energyPerDistributor
     */
    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    /**
     * @return
     */
    public int getCurrentNrDistributors() {
        return currentNrDistributors;
    }

    /**
     * @param currentNrDistributors
     */
    public void setCurrentNrDistributors(int currentNrDistributors) {
        this.currentNrDistributors = currentNrDistributors;
    }

    /**
     * @return
     */
    public ArrayList<MonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }

    /**
     * @param monthlyStats
     */
    public void setMonthlyStats(ArrayList<MonthlyStat> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    /**
     * Method to apply changes to the observable and notify all the observers in his
     * observer list
     */
    public synchronized void change() {
        super.setChanged();
        notifyObservers();
    }
}
