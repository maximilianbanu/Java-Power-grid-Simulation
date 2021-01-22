package consumermanager;

import players.Consumer;
import players.Contract;
import players.Distributor;

import java.util.ArrayList;

public interface PaymentStrategy {

    /**
     *
     * The payment strategy is build so that no matter if the consumer has switched
     * his distributor and has a new contract in the current round, the debt and
     * payment will be delievered to the right distributor.
     *
     * The strategy has 2 approaches: consumer has debt or consumer is free of debt
     *
     * @param consumer
     * @param contract
     * @param distributors
     */
    void paymentCase(Consumer consumer, Contract contract,
                     ArrayList<Distributor> distributors);
}
