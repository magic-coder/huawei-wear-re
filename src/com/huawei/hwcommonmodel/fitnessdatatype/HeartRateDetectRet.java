package com.huawei.hwcommonmodel.fitnessdatatype;

public class HeartRateDetectRet {
    private int heartRate;
    private long timeStamp;

    public void setHeartRate(int i) {
        this.heartRate = i;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public int getHeartRate() {
        return this.heartRate;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String toString() {
        return "HeartRateDetectRet{heartRate=" + this.heartRate + ", timeStamp=" + this.timeStamp + '}';
    }
}
