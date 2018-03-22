package com.huawei.openalliance.ad.p112a.p113a.p115b;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;

public class C1218d extends C1211a {
    private int adtype__ = 1;
    private int height__;
    private String slotid__;
    private int test__ = 0;
    private int width__;

    public C1218d(String str, int i, int i2, int i3, boolean z) {
        int i4 = 1;
        this.slotid__ = str;
        this.width__ = i;
        this.height__ = i2;
        if (!z) {
            i4 = 0;
        }
        this.test__ = i4;
        this.adtype__ = i3;
    }

    public int getAdtype__() {
        return this.adtype__;
    }

    public int getHeight__() {
        return this.height__;
    }

    public String getSlotid__() {
        return this.slotid__;
    }

    public int getTest__() {
        return this.test__;
    }

    public int getWidth__() {
        return this.width__;
    }

    public void setAdtype__(int i) {
        this.adtype__ = i;
    }

    public void setHeight__(int i) {
        this.height__ = i;
    }

    public void setSlotid__(String str) {
        this.slotid__ = str;
    }

    public void setTest__(int i) {
        this.test__ = i;
    }

    public void setWidth__(int i) {
        this.width__ = i;
    }
}
