package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: DeviceBindUsersBuilder */
public class C1429k extends C1418a {
    private String f3293k = "DeviceBindUsersBuilder";
    private DeviceBindUsersIOEntityModel f3294l;

    public C1429k(DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel) {
        this.f3294l = deviceBindUsersIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3294l);
        if (this.f3294l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3294l.deviceCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3293k, "DeviceBindUsersBuilder model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        C2538c.m12674b(this.f3293k, "==WW==  DeviceBindUsersBuilder strResponse=" + str);
        BaseEntityModel deviceBindUsersIOEntityModel = new DeviceBindUsersIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (DeviceBindUsersIOEntityModel) this.j.fromJson(str, DeviceBindUsersIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                deviceBindUsersIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3293k, "Exception e = " + e.getMessage());
            }
        }
        return deviceBindUsersIOEntityModel;
    }
}
