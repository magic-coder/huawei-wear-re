package com.huawei.openalliance.ad.p112a.p113a.p115b;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;

public class C1220f extends C1211a {
    private String mcc__;
    private String mnc__;
    private int networkType__;

    public C1220f(String str, String str2, int i) {
        this.mcc__ = str;
        this.mnc__ = str2;
        this.networkType__ = i;
    }

    public String getMcc__() {
        return this.mcc__;
    }

    public String getMnc__() {
        return this.mnc__;
    }

    public int getNetworkType__() {
        return this.networkType__;
    }

    public void setMcc__(String str) {
        this.mcc__ = str;
    }

    public void setMnc__(String str) {
        this.mnc__ = str;
    }

    public void setNetworkType__(int i) {
        this.networkType__ = i;
    }
}
