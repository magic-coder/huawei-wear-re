package com.huawei.openalliance.ad.p112a.p113a.p115b;

import com.huawei.openalliance.ad.inter.constant.EventType;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;

public class C1216b extends C1211a {
    private int opTimesInLandingPage__;
    private C1229o paramfromserver__;
    private int rawX__;
    private int rawY__;
    private String seq__;
    private String showid__;
    private long time__;
    private String type__;

    public C1216b(String str, String str2, int i, int i2, C1229o c1229o) {
        this.type__ = str;
        this.showid__ = str2;
        this.paramfromserver__ = c1229o;
        this.time__ = System.currentTimeMillis();
        this.rawX__ = i;
        this.rawY__ = i2;
    }

    public C1216b(String str, String str2, int i, C1229o c1229o) {
        this.type__ = str;
        this.showid__ = str2;
        this.paramfromserver__ = c1229o;
        this.time__ = System.currentTimeMillis();
        this.opTimesInLandingPage__ = i;
    }

    public C1216b(String str, String str2, C1229o c1229o) {
        this.type__ = str;
        this.showid__ = str2;
        this.paramfromserver__ = c1229o;
        this.time__ = System.currentTimeMillis();
    }

    public int getOpTimesInLandingPage__() {
        return this.opTimesInLandingPage__;
    }

    public C1229o getParamfromserver__() {
        return this.paramfromserver__;
    }

    public int getRawX__() {
        return this.rawX__;
    }

    public int getRawY__() {
        return this.rawY__;
    }

    public String getSeq__() {
        return this.seq__;
    }

    public String getShowid__() {
        return this.showid__;
    }

    public long getTime__() {
        return this.time__;
    }

    public String getType__() {
        return this.type__;
    }

    public void setOpTimesInLandingPage__(int i) {
        this.opTimesInLandingPage__ = i;
    }

    public void setParamfromserver__(C1229o c1229o) {
        this.paramfromserver__ = c1229o;
    }

    public void setRawX__(int i) {
        this.rawX__ = i;
    }

    public void setRawY__(int i) {
        this.rawY__ = i;
    }

    public void setSeq__(String str) {
        this.seq__ = str;
    }

    public void setShowid__(String str) {
        this.showid__ = str;
    }

    public void setTime__(long j) {
        this.time__ = j;
    }

    public void setType__(EventType eventType) {
        this.type__ = eventType.value();
    }

    public void setType__(String str) {
        this.type__ = str;
    }
}
