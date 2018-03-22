package com.huawei.openalliance.ad.p112a.p113a.p115b;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;

public class C1232r extends C1213c {
    private static final String TAG = "Rule";
    private long noShowTime__;
    private int skippedAdMaxTimes__;
    private int skippedAdMinTimes__;
    private int timeScope__;

    public long getNoShowTime__() {
        return this.noShowTime__;
    }

    public int getSkippedAdMaxTimes__() {
        return this.skippedAdMaxTimes__;
    }

    public int getSkippedAdMinTimes__() {
        return this.skippedAdMinTimes__;
    }

    public int getTimeScope__() {
        return this.timeScope__;
    }

    public void setNoShowTime__(long j) {
        this.noShowTime__ = j;
    }

    public void setSkippedAdMaxTimes__(int i) {
        this.skippedAdMaxTimes__ = i;
    }

    public void setSkippedAdMinTimes__(int i) {
        this.skippedAdMinTimes__ = i;
    }

    public void setTimeScope__(int i) {
        this.timeScope__ = i;
    }
}
