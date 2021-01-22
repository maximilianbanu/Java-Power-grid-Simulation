package players;

public class Contract {
    private final int consumerId;
    private final int price;
    private int remainedContractMonths;
    private final int distributorId;
    private Consumer belongingConsumer;

    /**
     * @param consumerId
     * @param price
     * @param remainingContractMonths
     * @param distributorId
     */
    public Contract(final int consumerId, final int price,
                    final int remainingContractMonths, final int distributorId,
                    final Consumer belongingConsumer) {
        this.consumerId = consumerId;
        this.price = price;
        this.remainedContractMonths = remainingContractMonths;
        this.distributorId = distributorId;
        this.belongingConsumer = belongingConsumer;
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

    /**
     * @param remainedContractMonths
     */
    public void setRemainedContractMonths(final int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    /**
     * @return
     */
    public int getDistributorId() {
        return distributorId;
    }

    /**
     * @return
     */
    public Consumer getBelongingConsumer() {
        return belongingConsumer;
    }

}
