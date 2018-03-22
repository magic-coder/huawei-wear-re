package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class PaceIndexStruct {
    private int paceIndex;
    private int recordId;

    public int getRecordId() {
        return ((Integer) C0978h.a(Integer.valueOf(this.recordId))).intValue();
    }

    public void setRecordId(int i) {
        this.recordId = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getPaceIndex() {
        return ((Integer) C0978h.a(Integer.valueOf(this.paceIndex))).intValue();
    }

    public void setPaceIndex(int i) {
        this.paceIndex = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
