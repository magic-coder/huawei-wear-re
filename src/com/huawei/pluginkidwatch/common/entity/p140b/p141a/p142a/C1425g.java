package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceInfosIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: BindDeviceInfosBuilder */
public class C1425g extends C1418a {
    private String f3285k = "BindDeviceInfosBuilder";
    private BindDeviceInfosIOEntityModel f3286l;

    public C1425g(BindDeviceInfosIOEntityModel bindDeviceInfosIOEntityModel) {
        this.f3286l = bindDeviceInfosIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3286l);
        if (this.f3286l != null) {
            stringBuffer.append("");
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3285k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel bindDeviceInfosIOEntityModel = new BindDeviceInfosIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (BindDeviceInfosIOEntityModel) this.j.fromJson(str, BindDeviceInfosIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                bindDeviceInfosIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3285k, "Exception e = " + e.getMessage());
            }
        }
        return bindDeviceInfosIOEntityModel;
    }
}
