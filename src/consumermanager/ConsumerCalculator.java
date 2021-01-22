package consumermanager;

import players.Consumer;
import players.Contract;
import players.Distributor;

import java.util.ArrayList;

public class ConsumerCalculator {

    /**
     *
     * Payment method handles the losses and gains of consumers and distributors, happening at the
     * end of the turn, by using a PaymentTool object which applies the payment strategy, in case
     * the consumer is in debt or not
     *
     *
     * @param consumer consumer who has to make the payment
     * @param contract contract linked to the consumer
     * @param distributors list of distributors
     */

    public void paymentMethod(final Consumer consumer, final Contract contract,
                              final ArrayList<Distributor> distributors) {
        PaymentTool paymentTool = null;
        if (consumer.getDebtToPay() == 0) {
            paymentTool = new PaymentTool(new NoDebtCase());
        } else {
            paymentTool = new PaymentTool(new DebtCase());
        }
        paymentTool.applyPayment(consumer, contract, distributors);
    }

    /**
     * Query for the contract belonging to a certain consumer, made to handle the
     * removal of finished contracts/ contracts of consumer who have gone bankrupt.
     *
     * @param consumer consumer who has the contract
     * @param distributors list of distributors
     * @return the appropriate contract / null if the contract has been erased
     */
    public Contract findBelongingContract(final Consumer consumer,
                                          final ArrayList<Distributor> distributors) {
        for (Distributor distributor : distributors) {
            for (Contract contract : distributor.getContractList()) {
                if (contract.getBelongingConsumer().equals(consumer)) {
                    return contract;
                }
            }
        }
        return null;
    }

}
