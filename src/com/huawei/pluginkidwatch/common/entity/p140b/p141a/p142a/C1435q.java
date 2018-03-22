package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetContactBuilder */
public class C1435q extends C1418a {
    private String f3305k = "GetContactBuilder";
    private GetContactIOEntityModel f3306l;

    public C1435q(GetContactIOEntityModel getContactIOEntityModel) {
        this.f3306l = getContactIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3306l);
        if (this.f3306l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3306l.deviceCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3305k, "GetContactBuilder makeRequestStream model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel getContactIOEntityModel = new GetContactIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (GetContactIOEntityModel) this.j.fromJson(str, GetContactIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                getContactIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3305k, "Exception e = " + e.getMessage());
            }
        }
        return getContactIOEntityModel;
    }
}
