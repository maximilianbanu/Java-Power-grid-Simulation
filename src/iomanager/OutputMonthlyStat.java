package iomanager;

import java.util.ArrayList;

public class OutputMonthlyStat {
    private final int month;
    private final ArrayList<Integer> distributorsIds;

    public OutputMonthlyStat(final int month, final ArrayList<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds;
    }

    /**
     * @return
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return
     */
    public ArrayList<Integer> getDistributorsIds() {
        return distributorsIds;
    }
}
