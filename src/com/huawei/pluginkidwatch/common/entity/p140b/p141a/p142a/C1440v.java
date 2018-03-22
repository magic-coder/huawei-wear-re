package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetTpyeRetModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetTpyeRetBuidler */
public class C1440v extends C1418a {
    private String f3315k = "GetTpyeRetBuidler";
    private GetTpyeRetModel f3316l;

    public C1440v(GetTpyeRetModel getTpyeRetModel) {
        this.f3316l = getTpyeRetModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3316l);
        if (this.f3316l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3316l.deviceCode);
            stringBuffer.append("&phoneNum=");
            stringBuffer.append(this.f3316l.phoneNum);
            stringBuffer.append("&nickname=");
            stringBuffer.append(this.f3316l.nickname);
            stringBuffer.append("&type=");
            stringBuffer.append(this.f3316l.type);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3315k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        C2538c.m12674b(this.f3315k, "==ww==  invite  manager response ==" + str);
        BaseEntityModel getTpyeRetModel = new GetTpyeRetModel();
        if (str != null && str.length() > 0) {
            try {
                return (GetTpyeRetModel) this.j.fromJson(str, GetTpyeRetModel.class);
            } catch (JsonSyntaxException e) {
                getTpyeRetModel.retCode = -1;
                C2538c.m12680e(this.f3315k, "Exception e = " + e.getMessage());
            }
        }
        return getTpyeRetModel;
    }
}
