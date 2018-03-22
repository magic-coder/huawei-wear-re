package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

public class AddSleepStatReq {
    private List<SleepTotal> sleepTotal;
    private String timeZone;

    public List<SleepTotal> getSleepTotal() {
        return this.sleepTotal;
    }

    public void setSleepTotal(List<SleepTotal> list) {
        this.sleepTotal = list;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String toString() {
        return "AddSportTotalReq{sleepTotal=" + this.sleepTotal + ", timeZone='" + this.timeZone + '\'' + '}';
    }
}
