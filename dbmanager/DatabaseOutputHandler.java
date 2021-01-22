package dbmanager;

import iomanager.*;
import players.*;

import java.util.ArrayList;

public class DatabaseOutputHandler {

    /**
     * Writes the consumer database to the output.
     */
    public void writeConsumers(ArrayList<Consumer> consumers,
                                ArrayList<OutputConsumer> outputConsumers) {
        for (Consumer consumer : consumers) {
            OutputConsumer outputConsumer = new OutputConsumer(consumer.getId(),
                    consumer.isBankrupt(),
                    consumer.getBudget());
            outputConsumers.add(outputConsumer);
        }
    }

    /**
     * Writes the distributor database to the output.
     */
    public void writeDistributors(ArrayList<Distributor> distributors,
                                   ArrayList<OutputDistributor> outputDistributors) {
        for (Distributor distributor : distributors) {
            ArrayList<OutputContract> outputContracts = new ArrayList<>();
            for (Contract contract : distributor.getContractList()) {
                OutputContract outputContract = new OutputContract(contract.getConsumerId(),
                        contract.getPrice(),
                        contract.getRemainedContractMonths());
                outputContracts.add(outputContract);
            }
            OutputDistributor outputDistributor = new OutputDistributor(distributor.getId(),
                    distributor.getEnergyNeededKW(), distributor.getPrice(),
                    distributor.getBudget(), distributor.getProducerStrategy(),
                    distributor.isBankrupt(), outputContracts);
            outputDistributors.add(outputDistributor);
        }
    }

    /**
     * Writes the producer database to the output.
     */
    public void writeProducers(ArrayList<Producer> producers,
                                ArrayList<OutputProducer> outputProducers) {
        for (Producer producer : producers) {
            ArrayList<OutputMonthlyStat> outputMonthlyStats = new ArrayList<>();
            for (MonthlyStat monthlyStat : producer.getMonthlyStats()) {
                OutputMonthlyStat outputMonthlyStat = new OutputMonthlyStat(monthlyStat.getMonth(),
                        monthlyStat.getDistributorsIds());
                outputMonthlyStats.add(outputMonthlyStat);
            }
            OutputProducer outputProducer = new OutputProducer(producer.getId(),
                    producer.getEnergyType(), producer.getMaxDistributors(),
                    producer.getPriceKW(), producer.getEnergyPerDistributor(),
                    outputMonthlyStats);
            outputProducers.add(outputProducer);
        }
    }
}
