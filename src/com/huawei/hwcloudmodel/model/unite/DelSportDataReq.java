package com.huawei.hwcloudmodel.model.unite;

import java.util.Arrays;

public class DelSportDataReq {
    private String[] recordIds;

    public String[] getRecordIds() {
        return (String[]) this.recordIds.clone();
    }

    public void setRecordIds(String[] strArr) {
        this.recordIds = (String[]) strArr.clone();
    }

    public String toString() {
        return "DelSportDataReq{recordIds=" + Arrays.toString(this.recordIds) + '}';
    }
}
