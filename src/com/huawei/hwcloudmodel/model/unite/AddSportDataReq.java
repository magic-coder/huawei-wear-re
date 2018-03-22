package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

public class AddSportDataReq {
    private List<SportDetail> detailInfo;
    private String timeZone;

    public List<SportDetail> getDetailInfo() {
        return this.detailInfo;
    }

    public void setDetailInfo(List<SportDetail> list) {
        this.detailInfo = list;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String toString() {
        return "AddSportDataReq{detailInfo=" + this.detailInfo + ", timeZone='" + this.timeZone + '\'' + '}';
    }
}
