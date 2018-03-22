package com.huawei.openalliance.ad.p112a.p113a;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;

public class C1236c extends C1212b {
    private String sdkversion__ = "3.4.10.301";
    private String slotid__;
    private String version__ = "3.2";

    public C1236c(String str) {
        this.slotid__ = str;
        this.rspClass = C1237d.class;
    }

    public String getSdkversion__() {
        return this.sdkversion__;
    }

    public String getSlotid__() {
        return this.slotid__;
    }

    public String getVersion__() {
        return this.version__;
    }

    public void setSdkversion__(String str) {
        this.sdkversion__ = str;
    }

    public void setSlotid__(String str) {
        this.slotid__ = str;
    }

    public void setVersion__(String str) {
        this.version__ = str;
    }
}
