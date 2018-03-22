package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

public class AddMotionPathReq {
    private List<MotionPathDetail> detailInfo;
    private String timeZone;

    public List<MotionPathDetail> getDetailInfo() {
        return this.detailInfo;
    }

    public void setDetailInfo(List<MotionPathDetail> list) {
        this.detailInfo = list;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String toString() {
        return "AddMotionPathReq{detailInfo=" + this.detailInfo + ", timeZone='" + this.timeZone + '\'' + '}';
    }
}
