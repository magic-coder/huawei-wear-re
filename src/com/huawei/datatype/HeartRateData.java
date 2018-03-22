package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import java.io.Serializable;

public class HeartRateData implements Serializable {
    private static final long serialVersionUID = -6019653484064737738L;
    private int heartRate;
    private long time;

    public HeartRateData(long j, int i) {
        this.time = j;
        this.heartRate = i;
    }

    public long getTime() {
        return ((Long) C0978h.a(Long.valueOf(this.time))).longValue();
    }

    public void setTime(long j) {
        this.time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getHeartRate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.heartRate))).intValue();
    }

    public void setHeartRate(int i) {
        this.heartRate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "HeartRateData [time=" + this.time + ", heartRate=" + this.heartRate + "]";
    }
}
