package iomanager;

import entities.EnergyType;

import java.util.ArrayList;

public class OutputProducer {
    private final int id;
    private final int maxDistributors;
    private final double priceKW;
    private final EnergyType energyType;
    private final int energyPerDistributor;
    private final ArrayList<OutputMonthlyStat> monthlyStats;

    public OutputProducer(final int id, final EnergyType energyType,
                          final int maxDistributors, final double priceKW,
                          final int energyPerDistributor,
                          final ArrayList<OutputMonthlyStat> monthlyStats) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
        this.monthlyStats = monthlyStats;
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
    public EnergyType getEnergyType() {
        return energyType;
    }

    /**
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * @return
     */
    public ArrayList<OutputMonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }
}
