package players;

public final class ConsumerSingletonFactory {

    private static ConsumerSingletonFactory consumerSingletonFactory;

    /**
     * @param id
     * @param budget
     * @param income
     * @return
     */
    public Consumer createConsumer(final int id, final int budget, final int income) {
        return new Consumer(id, budget, income);
    }

    /**
     * @return
     */
    public static ConsumerSingletonFactory getInstance() {
        if (consumerSingletonFactory == null) {
            consumerSingletonFactory = new ConsumerSingletonFactory();
        }
        return consumerSingletonFactory;
    }
}
