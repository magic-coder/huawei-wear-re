package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceSOSPhoneIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: DeviceSOSPhoneBuilder */
public class C1430l extends C1418a {
    private String f3295k = "DeviceSOSPhoneBuilder";
    private DeviceSOSPhoneIOEntityModel f3296l;

    public C1430l(DeviceSOSPhoneIOEntityModel deviceSOSPhoneIOEntityModel) {
        this.f3296l = deviceSOSPhoneIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3296l);
        if (this.f3296l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3296l.deviceCode);
            stringBuffer.append("&userPriorityList=");
            stringBuffer.append(this.j.toJson(this.f3296l.userPriorityList));
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3295k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        C2538c.m12674b(this.f3295k, "==ww== DeviceSOSPhoneBuilder==" + str);
        BaseEntityModel deviceSOSPhoneIOEntityModel = new DeviceSOSPhoneIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (DeviceSOSPhoneIOEntityModel) this.j.fromJson(str, DeviceSOSPhoneIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                deviceSOSPhoneIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3295k, "Exception e = " + e.getMessage());
            }
        }
        return deviceSOSPhoneIOEntityModel;
    }
}
