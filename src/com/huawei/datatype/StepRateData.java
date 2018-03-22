package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.io.Serializable;

public class StepRateData implements Serializable {
    private static final long serialVersionUID = -1186336294220451546L;
    private int setpRate;
    private long time;

    public StepRateData(long j, int i) {
        this.time = j;
        this.setpRate = i;
    }

    public long getTime() {
        return ((Long) C0978h.a(Long.valueOf(this.time))).longValue();
    }

    public void setTime(long j) {
        this.time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getStepRate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.setpRate))).intValue();
    }

    public void setStepRate(int i) {
        this.setpRate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "StepRateData [time=" + this.time + ", stepRate=" + this.setpRate + "]";
    }
}
