package players;

public final class DistributorSingletonFactory {

    private static DistributorSingletonFactory distributorSingletonFactory;

    /**
     * @param id
     * @param cLength
     * @param budget
     * @param infrastruct
     * @return
     */
    public Distributor createDistributor(final int id, final int cLength, final int budget,
                                         final int infrastruct, final int energyNeeded,
                                         final String strategy) {
        return new Distributor(id, cLength, budget, infrastruct, energyNeeded, strategy);
    }

    /**
     * @return
     */
    public static DistributorSingletonFactory getInstance() {
        if (distributorSingletonFactory == null) {
            distributorSingletonFactory = new DistributorSingletonFactory();
        }
        return distributorSingletonFactory;
    }
}
