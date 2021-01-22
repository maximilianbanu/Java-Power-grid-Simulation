package gamelogic;

import iomanager.FullInput;
import players.Consumer;
import players.ConsumerSingletonFactory;
import players.Distributor;
import players.Producer;

import java.util.ArrayList;

public class GameSimulation {

    private final GameTracker gameTracker = new GameTracker();

    private final ArrayList<Consumer> consumers;
    private final ArrayList<Distributor> distributors;
    private final ArrayList<Producer> producers;
    private final ConsumerSingletonFactory consumerFactory;
    private final FullInput fullInput;
    private boolean gameOverState;

    public GameSimulation(final ArrayList<Consumer> consumers,
                          final ArrayList<Distributor> distributors,
                          final ArrayList<Producer> producers,
                          final ConsumerSingletonFactory consumerFactory,
                          final FullInput fullInput) {

        this.consumers = consumers;
        this.distributors = distributors;
        this.producers = producers;
        this.consumerFactory = consumerFactory;
        this.fullInput = fullInput;
        this.gameOverState = false;
    }

    /**
     *
     * Runs the initial round of the game.
     *
     */
    public void runInitialRound() {
        gameTracker.initializeGame(consumers, distributors, producers);
    }

    /**
     *
     * Runs a round of the game according to the round number,
     * while checking to see if the
     *
     * @param roundNr current round number
     */
    public void runStandardRound(int roundNr) {
        boolean gameOver = true;
        gameTracker.startOfTurn(roundNr, fullInput, consumerFactory, consumers,
                distributors);
        gameTracker.endOfTurn(roundNr, fullInput, consumers, distributors, producers);
        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                gameOver = false;
                break;
            }
        }
        this.gameOverState = gameOver;
    }

    /**
     * Getter to communicate to main if the game is over.
     */
    public boolean isGameOver() {
        return gameOverState;
    }
}
