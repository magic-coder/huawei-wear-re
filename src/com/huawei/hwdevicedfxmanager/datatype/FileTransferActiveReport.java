package com.huawei.hwdevicedfxmanager.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class FileTransferActiveReport {
    private int index = 0;
    private String value = null;

    public int getIndex() {
        return ((Integer) C0978h.a(Integer.valueOf(this.index))).intValue();
    }

    public void setIndex(int i) {
        this.index = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String getValue() {
        return (String) C0978h.a(this.value);
    }

    public void setValue(String str) {
        this.value = (String) C0978h.a(str);
    }
}
