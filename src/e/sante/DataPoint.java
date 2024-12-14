package e.sante;

import java.sql.Timestamp;

public class DataPoint {
    private Timestamp date;
    private double value;

    public DataPoint(Timestamp date, double value) {
        this.date = date;
        this.value = value;
    }

    public Timestamp getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}