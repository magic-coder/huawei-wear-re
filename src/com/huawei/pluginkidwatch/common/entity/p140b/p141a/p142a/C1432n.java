package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.FenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: FenceBuilder */
public class C1432n extends C1418a {
    private String f3299k = "FenceBuilder";
    private FenceIOEntityModel f3300l;

    public C1432n(FenceIOEntityModel fenceIOEntityModel) {
        this.f3300l = fenceIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3300l);
        if (this.f3300l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3300l.deviceCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3299k, "FenceBuilder model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel fenceIOEntityModel = new FenceIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (FenceIOEntityModel) this.j.fromJson(str, FenceIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                fenceIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3299k, "Exception e = " + e.getMessage());
            }
        }
        return fenceIOEntityModel;
    }
}
