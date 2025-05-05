
package com.exemplo.transacoes_api;

public class EstatisticaResponse {

    private double sum;
    private double avg;
    private double min;
    private double max;
    private long count;

    public EstatisticaResponse(double sum, double avg, double min, double max, long count) {
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public long getCount() {
        return count;
    }
}
