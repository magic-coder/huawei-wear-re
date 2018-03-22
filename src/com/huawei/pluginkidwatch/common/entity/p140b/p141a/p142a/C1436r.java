package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetDeviceBuilder */
public class C1436r extends C1418a {
    private String f3307k = "GetDeviceBuilder";
    private GetDeviceModel f3308l;

    public C1436r(GetDeviceModel getDeviceModel) {
        this.f3308l = getDeviceModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3308l);
        if (this.f3308l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3308l.deviceCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3307k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel baseEntityModel;
        C2538c.m12674b(this.f3307k, "getdevice stream : " + str);
        BaseEntityModel getDeviceModel = new GetDeviceModel();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    baseEntityModel = (GetDeviceModel) this.j.fromJson(str, GetDeviceModel.class);
                    return baseEntityModel;
                }
            } catch (JsonSyntaxException e) {
                getDeviceModel.retCode = -1;
                getDeviceModel.retMsg = "error happened in makeResponseEntity";
                C2538c.m12680e(this.f3307k, "Exception e = " + e.getMessage());
                return getDeviceModel;
            }
        }
        baseEntityModel = getDeviceModel;
        return baseEntityModel;
    }
}
