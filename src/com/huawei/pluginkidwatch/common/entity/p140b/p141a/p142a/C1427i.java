package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.ConfirmBindIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: ConfirmBindBuilder */
public class C1427i extends C1418a {
    private String f3289k = "ConfirmBindBuilder";
    private ConfirmBindIOEntityModel f3290l;

    public C1427i(ConfirmBindIOEntityModel confirmBindIOEntityModel) {
        this.f3290l = confirmBindIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3290l);
        if (this.f3290l != null) {
            stringBuffer.append("&recordId=");
            stringBuffer.append(this.f3290l.recordId);
            stringBuffer.append("&result=");
            stringBuffer.append(this.f3290l.result);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3289k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel confirmBindIOEntityModel = new ConfirmBindIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (ConfirmBindIOEntityModel) this.j.fromJson(str, ConfirmBindIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                confirmBindIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3289k, "Exception e = " + e.getMessage());
            }
        }
        return confirmBindIOEntityModel;
    }
}
