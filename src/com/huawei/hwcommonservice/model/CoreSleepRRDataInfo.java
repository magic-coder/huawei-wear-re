package com.huawei.hwcommonservice.model;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;

public class CoreSleepRRDataInfo {
    private ArrayList<byte[]> mRRDataContent;
    private ArrayList<byte[]> mStatusContent;

    public ArrayList<byte[]> getRRDataContent() {
        return this.mRRDataContent;
    }

    public void setRRDataContent(ArrayList<byte[]> arrayList) {
        this.mRRDataContent = (ArrayList) C0978h.a(arrayList);
    }

    public ArrayList<byte[]> getStatusContent() {
        return this.mStatusContent;
    }

    public void setStatusContent(ArrayList<byte[]> arrayList) {
        this.mStatusContent = (ArrayList) C0978h.a(arrayList);
    }

    public String toJsonString() {
        return "sleep rr string";
    }
}
