package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

public class AddHealthDataReq {
    private List<HealthDetail> detailInfo;
    private String timeZone;

    public List<HealthDetail> getDetailInfo() {
        return this.detailInfo;
    }

    public void setDetailInfo(List<HealthDetail> list) {
        this.detailInfo = list;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String toString() {
        return "AddHealthDataReq{detailInfo=" + this.detailInfo + ", timeZone='" + this.timeZone + '\'' + '}';
    }
}
