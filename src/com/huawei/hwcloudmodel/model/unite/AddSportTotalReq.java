package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

public class AddSportTotalReq {
    private int isForce;
    private String timeZone;
    private List<SportTotal> totalInfo;

    public List<SportTotal> getTotalInfo() {
        return this.totalInfo;
    }

    public void setTotalInfo(List<SportTotal> list) {
        this.totalInfo = list;
    }

    public void setIsForce(int i) {
        this.isForce = i;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String toString() {
        return "AddSportTotalReq{totalInfo=" + this.totalInfo + ", timeZone='" + this.timeZone + ", isForce=" + this.isForce + '\'' + '}';
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public void uadpAddSportTotalReq1() {
    }

    public void uadpAddSportTotalReq2() {
    }

    public void uadpAddSportTotalReq3() {
    }
}
