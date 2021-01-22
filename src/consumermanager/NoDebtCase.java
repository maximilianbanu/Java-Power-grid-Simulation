package consumermanager;

import constants.Constants;
import players.Consumer;
import players.Contract;
import players.Distributor;

import java.util.ArrayList;

public class NoDebtCase implements PaymentStrategy {

    /**
     *
     * Handles the case in which the consumer has no debt to pay, making sure
     * to set him in debt if he can't afford the current payment.
     *
     * @param consumer
     * @param contract
     * @param distributors
     */
    @Override
    public void paymentCase(Consumer consumer, Contract contract,
                            ArrayList<Distributor> distributors) {
        if (consumer.getBudget() >= contract.getPrice()) {
            consumer.setBudget(consumer.getBudget() - contract.getPrice());
            distributors.get(contract.getDistributorId()).
                    setBudget(distributors.get(contract.getDistributorId()).getBudget()
                            + contract.getPrice());
        } else {
            consumer.setDebtToPay((int) Math.round(Math.floor(Constants.DEBT_SURPLUS
                    * contract.getPrice())));
            consumer.setDistributorInDebt(distributors.get(contract.getDistributorId()));
        }
        contract.setRemainedContractMonths(contract.getRemainedContractMonths() - 1);
    }
}
