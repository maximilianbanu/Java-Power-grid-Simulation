package consumermanager;

import players.Consumer;
import players.Contract;
import players.Distributor;

import java.util.ArrayList;

public class PaymentTool {

    private PaymentStrategy paymentStrategy;

    public PaymentTool(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Applies the payment strategy.
     */
    public void applyPayment(final Consumer consumer, final Contract contract,
                              final ArrayList<Distributor> distributors) {
        paymentStrategy.paymentCase(consumer, contract, distributors);
    }
}
