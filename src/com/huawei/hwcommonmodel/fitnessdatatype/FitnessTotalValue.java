package com.huawei.hwcommonmodel.fitnessdatatype;

public class FitnessTotalValue {
    private int all;
    private int climb;
    private int dataType;
    private int ride;
    private int run;
    private int walk;

    public void setAll(int i) {
        this.all = i;
    }

    public int getAll() {
        return this.all;
    }

    public void appendAll(int i) {
        this.all += i;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setWalk(int i) {
        this.walk = i;
    }

    public int getWalk() {
        return this.walk;
    }

    public void setRun(int i) {
        this.run = i;
    }

    public int getRun() {
        return this.run;
    }

    public void setClimb(int i) {
        this.climb = i;
    }

    public int getClimb() {
        return this.climb;
    }

    public void setRide(int i) {
        this.ride = i;
    }

    public int getRide() {
        return this.ride;
    }

    public String toString() {
        return "FitnessTotalValue{dataType=" + this.dataType + ", all=" + this.all + ", walk=" + this.walk + ", run=" + this.run + ", climb=" + this.climb + ", ride=" + this.ride + '}';
    }
}
