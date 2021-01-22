import com.fasterxml.jackson.databind.ObjectMapper;
import dbmanager.DatabaseInputHandler;
import dbmanager.DatabaseOutputHandler;
import gamelogic.GameSimulation;
import iomanager.*;
import players.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() { }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        FullInput fullInput = objectMapper.readValue(new File(args[0]), FullInput.class);

        ArrayList<Consumer> consumers = new ArrayList<>();
        ArrayList<Distributor> distributors = new ArrayList<>();
        ArrayList<Producer> producers = new ArrayList<>();

        ProducerSingletonFactory producerFactory = ProducerSingletonFactory.getInstance();
        DistributorSingletonFactory distributorFactory = DistributorSingletonFactory.getInstance();
        ConsumerSingletonFactory consumerFactory = ConsumerSingletonFactory.getInstance();

        DatabaseInputHandler dbHandler = new DatabaseInputHandler();

       dbHandler.handleConsumers(fullInput, consumers, consumerFactory);
       dbHandler.handleDistributors(fullInput, distributors, distributorFactory);
       dbHandler.handleProducers(fullInput, producers, producerFactory);

        GameSimulation simulator = new GameSimulation(consumers, distributors, producers,
                consumerFactory, fullInput);

        simulator.runInitialRound();

        for (int i = 0; i < fullInput.getNumberOfTurns(); i++) {
            simulator.runStandardRound(i);
            if (simulator.isGameOver()) {
                break;
            }
        }

        ArrayList<OutputConsumer> outputConsumers = new ArrayList<>();
        ArrayList<OutputDistributor> outputDistributors = new ArrayList<>();
        ArrayList<OutputProducer> outputProducers = new ArrayList<>();

        DatabaseOutputHandler outputHandler = new DatabaseOutputHandler();

        outputHandler.writeConsumers(consumers, outputConsumers);
        outputHandler.writeDistributors(distributors, outputDistributors);
        outputHandler.writeProducers(producers, outputProducers);

        FullOutput fullOutput = new FullOutput(outputConsumers,
                outputDistributors, outputProducers);

        String json = new ObjectMapper().writeValueAsString(fullOutput);

        File output = new File(args[1]);
        FileWriter writer = new FileWriter(output);

        writer.write(json);
        writer.close();
    }
}
