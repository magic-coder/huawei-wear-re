package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.PhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchPhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: WatchPhoneNumBuilder */
public class am extends C1418a {
    private String f3270k = "WatchPhoneNumBuilder";
    private WatchPhoneNumIOEntityModel f3271l;

    public am(WatchPhoneNumIOEntityModel watchPhoneNumIOEntityModel) {
        this.f3271l = watchPhoneNumIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3271l);
        if (this.f3271l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3271l.deviceCode);
            stringBuffer.append("&phoneNum=");
            stringBuffer.append(this.f3271l.phoneNum);
            stringBuffer.append("&securityCode=");
            stringBuffer.append(this.f3271l.securityCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3270k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel phoneNumIOEntityModel = new PhoneNumIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (PhoneNumIOEntityModel) this.j.fromJson(str, PhoneNumIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                phoneNumIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3270k, "Exception e = " + e.getMessage());
            }
        }
        return phoneNumIOEntityModel;
    }
}
