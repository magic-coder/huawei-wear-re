package com.huawei.openalliance.ad.p112a.p113a;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import java.util.List;

public class C1238e extends C1212b {
    private List<C1216b> event__;
    private String sdkversion__ = "3.4.10.301";
    private String version__ = "3.2";

    public C1238e(List<C1216b> list) {
        this.event__ = list;
        this.rspClass = C1239f.class;
    }

    public List<C1216b> getEvent__() {
        return this.event__;
    }

    public String getSdkversion__() {
        return this.sdkversion__;
    }

    public String getVersion__() {
        return this.version__;
    }

    public void setEvent__(List<C1216b> list) {
        this.event__ = list;
    }

    public void setSdkversion__(String str) {
        this.sdkversion__ = str;
    }

    public void setVersion__(String str) {
        this.version__ = str;
    }
}
