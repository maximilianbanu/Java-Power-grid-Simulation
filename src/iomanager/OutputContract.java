package iomanager;

public class OutputContract {
    private final int consumerId;
    private final int price;
    private final int remainedContractMonths;

    public OutputContract(final int consumerId,
                          final int price, final int remainedContractMonths) {
        this.consumerId = consumerId;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    /**
     * @return
     */
    public int getConsumerId() {
        return consumerId;
    }

    /**
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return
     */
    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

}
