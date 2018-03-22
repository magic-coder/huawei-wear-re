package com.huawei.hwcloudmodel.model.unite;

import java.util.Arrays;

public class DelMotionPathReq {
    private String[] recordIds;

    public String[] getRecordIds() {
        return (String[]) this.recordIds.clone();
    }

    public void setRecordIds(String[] strArr) {
        this.recordIds = (String[]) strArr.clone();
    }

    public String toString() {
        return "DelMotionPathReq{recordIds=" + Arrays.toString(this.recordIds) + '}';
    }
}
