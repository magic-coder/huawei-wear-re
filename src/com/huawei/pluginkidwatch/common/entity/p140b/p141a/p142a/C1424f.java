package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: BindDeviceBuilder */
public class C1424f extends C1418a {
    private String f3283k = "BindDeviceBuilder";
    private BindDeviceIOEntityModel f3284l;

    public C1424f(BindDeviceIOEntityModel bindDeviceIOEntityModel) {
        this.f3284l = bindDeviceIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3284l);
        if (this.f3284l != null) {
            stringBuffer.append("&nickname=");
            stringBuffer.append(this.f3284l.nickname);
            stringBuffer.append("&imei=");
            stringBuffer.append(this.f3284l.imei);
            stringBuffer.append("&type=");
            stringBuffer.append(this.f3284l.type);
            stringBuffer.append("&bindType=");
            stringBuffer.append(this.f3284l.bindType);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3283k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        C2538c.m12674b(this.f3283k, "==============strResponse: " + str);
        BaseEntityModel bindDeviceIOEntityModel = new BindDeviceIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (BindDeviceIOEntityModel) this.j.fromJson(str, BindDeviceIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                bindDeviceIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3283k, "Exception e = " + e.getMessage());
            }
        }
        return bindDeviceIOEntityModel;
    }
}
