package iomanager;

import java.util.ArrayList;

public class FullInput {

    private final int numberOfTurns;
    private final InputInitialData initialData;
    private final ArrayList<InputMonthlyUpdate> monthlyUpdates;

    public FullInput() {
        this.numberOfTurns = 0;
        this.initialData = null;
        this.monthlyUpdates = null;
    }

    /**
     * @return
     */
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    /**
     * @return
     */
    public InputInitialData getInitialData() {
        return initialData;
    }

    /**
     * @return
     */
    public ArrayList<InputMonthlyUpdate> getMonthlyUpdates() {
        return monthlyUpdates;
    }
}
