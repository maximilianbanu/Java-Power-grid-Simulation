package players;

public class Consumer {
    private final int id;
    private int budget;
    private final int monthlyIncome;
    private boolean isBankrupt;
    private int debtToPay;
    private Distributor distributorInDebt;

    /**
     * @param id
     * @param initialBudget
     * @param monthlyIncome
     */
    public Consumer(final int id, final int initialBudget, final int monthlyIncome) {
        this.id = id;
        this.budget = initialBudget;
        this.monthlyIncome = monthlyIncome;
        this.isBankrupt = false;
        this.debtToPay = 0;
        this.distributorInDebt = null;
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
    public int getMonthlyIncome() {
        return monthlyIncome;
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
    public int getDebtToPay() {
        return debtToPay;
    }

    /**
     * @param debtToPay
     */
    public void setDebtToPay(final int debtToPay) {
        this.debtToPay = debtToPay;
    }

    /**
     * @return
     */
    public Distributor getDistributorInDebt() {
        return distributorInDebt;
    }

    /**
     * @param distributorInDebt
     */
    public void setDistributorInDebt(final Distributor distributorInDebt) {
        this.distributorInDebt = distributorInDebt;
    }

}
