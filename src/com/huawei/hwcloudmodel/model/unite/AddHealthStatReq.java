package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

public class AddHealthStatReq {
    private List<ProfessionalSleepTotal> professionalSleepTotal;
    private List<SleepTotal> sleepTotal;
    private String timeZone;

    public List<SleepTotal> getSleepTotal() {
        return this.sleepTotal;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public List<ProfessionalSleepTotal> getProfessionalSleepTotal() {
        return this.professionalSleepTotal;
    }

    public void setSleepTotal(List<SleepTotal> list) {
        this.sleepTotal = list;
    }

    public void setProfessionalSleepTotal(List<ProfessionalSleepTotal> list) {
        this.professionalSleepTotal = list;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String toString() {
        return "AddHealthStatReq{sleepTotal=" + this.sleepTotal + ", professionalSleepTotal=" + this.professionalSleepTotal + ", timeZone='" + this.timeZone + '\'' + '}';
    }
}
