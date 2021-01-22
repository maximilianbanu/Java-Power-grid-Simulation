package iomanager;

public class OutputConsumer {
    private final int id;
    private final boolean isBankrupt;
    private final int budget;

    public OutputConsumer(final int id, final boolean isBankrupt,
                          final int budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
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
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * @return
     */
    public int getBudget() {
        return budget;
    }

}
