package consumermanager;

import players.Consumer;
import players.Contract;
import players.Distributor;

import java.util.ArrayList;

public class DebtCase implements PaymentStrategy {

    /**
     *
     * Handles the case in which the consumer is in debt and has to pay the current contract
     * holder or his old one.
     *
     * @param consumer
     * @param contract
     * @param distributors
     */
    @Override
    public void paymentCase(Consumer consumer, Contract contract,
                            ArrayList<Distributor> distributors) {
        if (consumer.getBudget() >= contract.getPrice() + consumer.getDebtToPay()) {
            consumer.setBudget(consumer.getBudget() - consumer.getDebtToPay());
            consumer.getDistributorInDebt().setBudget(consumer.getDistributorInDebt()
                    .getBudget() + consumer.getDebtToPay());
            consumer.setDistributorInDebt(null);
            consumer.setDebtToPay(0);
            consumer.setBudget(consumer.getBudget() - contract.getPrice());
            distributors.get(contract.getDistributorId())
                    .setBudget(distributors.get(contract.getDistributorId()).getBudget()
                            + contract.getPrice());
            contract.setRemainedContractMonths(contract.getRemainedContractMonths() - 1);
        } else {
            consumer.setBankrupt(true);
        }
    }
}
