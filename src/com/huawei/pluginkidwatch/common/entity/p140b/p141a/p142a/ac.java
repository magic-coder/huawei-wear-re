package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.entity.model.SetDeviceProfileModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: SetDeviceProfileInfoBuilder */
public class ac extends C1418a {
    private String f3250k = "SetDeviceProfileInfoBuilder";
    private SetDeviceProfileModel f3251l;

    public ac(SetDeviceProfileModel setDeviceProfileModel) {
        this.f3251l = setDeviceProfileModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3251l);
        if (this.f3251l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3251l.deviceCode);
            stringBuffer.append("&deviceProfile=");
            stringBuffer.append(this.j.toJson(this.f3251l));
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3250k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonRetIModel = new CommonRetIModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonRetIModel) this.j.fromJson(str, CommonRetIModel.class);
            } catch (JsonSyntaxException e) {
                C2538c.m12680e(this.f3250k, "Exception e = " + e.getMessage());
                commonRetIModel.retCode = -1;
            }
        }
        return commonRetIModel;
    }
}
