package com.huawei.openalliance.ad.p112a.p113a;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1215a;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1230p;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1233s;
import java.util.List;

public class C1235b extends C1213c {
    private List<String> invalidSloganId__;
    private List<String> invalidcontentid__;
    private List<C1215a> multiad__;
    private List<C1230p> premulticontent__;
    private String reason__;
    private int retcode__ = -1;
    private List<C1233s> sloganList__;
    private List<String> todayNoShowContentid__;

    public List<String> getInvalidSloganId__() {
        return this.invalidSloganId__;
    }

    public List<String> getInvalidcontentid__() {
        return this.invalidcontentid__;
    }

    public List<C1215a> getMultiad__() {
        return this.multiad__;
    }

    public List<C1230p> getPremulticontent__() {
        return this.premulticontent__;
    }

    public String getReason__() {
        return this.reason__;
    }

    public int getRetcode__() {
        return this.retcode__;
    }

    public List<C1233s> getSloganList__() {
        return this.sloganList__;
    }

    public List<String> getTodayNoShowContentid__() {
        return this.todayNoShowContentid__;
    }

    public void setInvalidSloganId__(List<String> list) {
        this.invalidSloganId__ = list;
    }

    public void setInvalidcontentid__(List<String> list) {
        this.invalidcontentid__ = list;
    }

    public void setMultiad__(List<C1215a> list) {
        this.multiad__ = list;
    }

    public void setPremulticontent__(List<C1230p> list) {
        this.premulticontent__ = list;
    }

    public void setReason__(String str) {
        this.reason__ = str;
    }

    public void setRetcode__(int i) {
        this.retcode__ = i;
    }

    public void setSloganList__(List<C1233s> list) {
        this.sloganList__ = list;
    }

    public void setTodayNoShowContentid__(List<String> list) {
        this.todayNoShowContentid__ = list;
    }
}
