package com.huawei.openalliance.ad.p112a.p113a;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;

public class C1240g extends C1212b {
    private String _id;
    private String url;

    public C1240g(String str) {
        this.url = str;
        this.rspClass = C1241h.class;
    }

    public String getUrl() {
        return this.url;
    }

    public String get_id() {
        return this._id;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void set_id(String str) {
        this._id = str;
    }
}
