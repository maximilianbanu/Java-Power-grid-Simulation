package distributormanager;

import constants.Constants;
import players.Distributor;
import players.Producer;

import java.util.ArrayList;

public class DistributorCalculator {

    /**
     *
     * Calculates the current price of a distributor, based on infrastructure cost,
     * production cost and the current number of contracts he owns
     *
     * @param distributor distributor in case
     * @return current price of a potential contract formed with the distributor
     */
    public int caculateCurrentPrice(final Distributor distributor) {
        int productionCost = this.calculateProductionCost(distributor);
        int currentProfit = (int) Math.round(Math.floor(Constants.PROFIT_MARGIN
                * productionCost));
        if (distributor.getContractList().isEmpty()) {
            return distributor.getInfrastructureCost() + productionCost
                    + currentProfit;
        } else {
            return (int) Math.round(Math.floor(distributor.getInfrastructureCost()
                    / distributor.getContractList().size()) + productionCost
                    + currentProfit);
        }

    }

    /**
     *
     * Returns the current best distributor a consumer can pick, based on
     * the price of a potential contract
     *
     * @param distributors list of distributors
     * @return the distributor with the smallest current price
     */
    public Distributor findBestDistributor(final ArrayList<Distributor> distributors) {
        int minimalCost = Integer.MAX_VALUE;
        Distributor bestDistributor = null;

        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                if (distributor.getPrice() < minimalCost) {
                    minimalCost = distributor.getPrice();
                    bestDistributor = distributor;
                }
            }
        }
        return bestDistributor;
    }

    /**
     *
     * Calculates the current production cost of the distributor, based on his current list of
     * producers in his subscription.
     *
     * @param distributor
     * @return
     */
    public int calculateProductionCost(final Distributor distributor) {
        double cost = 0;
        for (Producer producer : distributor.getProducerList()) {
            cost += producer.getEnergyPerDistributor() * producer.getPriceKW();
        }
        return (int) Math.round(Math.floor(cost / Constants.COST_DIVIDENT));
    }
}
