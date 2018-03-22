package com.huawei.hwcloudmodel.model.unite;

import java.util.Arrays;

public class DelHealthDataReq {
    private String[] recordIds;

    public String[] getRecordIds() {
        return (String[]) this.recordIds.clone();
    }

    public void setRecordIds(String[] strArr) {
        this.recordIds = (String[]) strArr.clone();
    }

    public String toString() {
        return "DelHealthDataReq{recordIds=" + Arrays.toString(this.recordIds) + '}';
    }
}
