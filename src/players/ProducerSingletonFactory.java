package players;

import entities.EnergyType;

public class ProducerSingletonFactory {

    private static ProducerSingletonFactory producerSingletonFactory;

    /**
     * @param id
     * @param energyType
     * @param maxDistributors
     * @param priceKW
     * @param energyPerDistributor
     * @return
     */
    public Producer createProducer(final int id, final EnergyType energyType,
                                   final int maxDistributors,
                                   final double priceKW,
                                   final int energyPerDistributor) {
        return new Producer(id, energyType, maxDistributors, priceKW, energyPerDistributor);
    }

    /**
     * @return
     */
    public static ProducerSingletonFactory getInstance() {
        if (producerSingletonFactory == null) {
            producerSingletonFactory = new ProducerSingletonFactory();
        }
        return producerSingletonFactory;
    }
}
