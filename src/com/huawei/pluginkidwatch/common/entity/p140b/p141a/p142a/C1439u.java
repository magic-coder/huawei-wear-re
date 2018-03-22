package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetRewardInfoRetModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetRewardInfoBuilder */
public class C1439u extends C1418a {
    private String f3313k = "GetRewardInfoBuilder";
    private GetRewardInfoRetModel f3314l;

    public C1439u(GetRewardInfoRetModel getRewardInfoRetModel) {
        this.f3314l = getRewardInfoRetModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3314l);
        if (this.f3314l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3314l.deviceCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3313k, "GetRewardInfoBuilder ***** makeRequestStream model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel getRewardInfoRetModel = new GetRewardInfoRetModel();
        if (str != null && str.length() > 0) {
            try {
                return (GetRewardInfoRetModel) this.j.fromJson(str, GetRewardInfoRetModel.class);
            } catch (JsonSyntaxException e) {
                getRewardInfoRetModel.retCode = -1;
                C2538c.m12680e(this.f3313k, "Exception e = " + e.getMessage());
            }
        }
        return getRewardInfoRetModel;
    }
}
