package iomanager;

public class InputConsumer {
    private final int id;
    private final int initialBudget;
    private final int monthlyIncome;

    public InputConsumer() {
        this.id = 0;
        this.initialBudget = 0;
        this.monthlyIncome = 0;
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
    public int getInitialBudget() {
        return initialBudget;
    }

    /**
     * @return
     */
    public int getMonthlyIncome() {
        return monthlyIncome;
    }

}
