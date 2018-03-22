package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceProfileRetModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetDeviceProfileInfoBuilder */
public class C1437s extends C1418a {
    private String f3309k = "GetDeviceProfileInfoBuilder";
    private GetDeviceProfileRetModel f3310l;

    public C1437s(GetDeviceProfileRetModel getDeviceProfileRetModel) {
        this.f3310l = getDeviceProfileRetModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3310l);
        if (this.f3310l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3310l.deviceCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3309k, "++++ GetDeviceProfileInfoBuilder model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel getDeviceProfileRetModel = new GetDeviceProfileRetModel();
        if (str != null && str.length() > 0) {
            try {
                return (GetDeviceProfileRetModel) this.j.fromJson(str, GetDeviceProfileRetModel.class);
            } catch (JsonSyntaxException e) {
                getDeviceProfileRetModel.retCode = -1;
                C2538c.m12680e(this.f3309k, "Exception e = " + e.getMessage());
            }
        }
        return getDeviceProfileRetModel;
    }
}
