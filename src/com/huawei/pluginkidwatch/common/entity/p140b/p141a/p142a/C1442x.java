package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.HandleFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: HandleFenceBuilder */
public class C1442x extends C1418a {
    private String f3319k = "HandleFenceBuilder";
    private HandleFenceIOEntityModel f3320l;

    public C1442x(HandleFenceIOEntityModel handleFenceIOEntityModel) {
        this.f3320l = handleFenceIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3320l);
        if (this.f3320l != null) {
            stringBuffer.append("&fenceId=");
            stringBuffer.append(this.f3320l.fenceId);
            stringBuffer.append("&type=");
            stringBuffer.append(this.f3320l.type);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3319k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel handleFenceIOEntityModel = new HandleFenceIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (HandleFenceIOEntityModel) this.j.fromJson(str, HandleFenceIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                handleFenceIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3319k, "Exception e = " + e.getMessage());
            }
        }
        return handleFenceIOEntityModel;
    }
}
