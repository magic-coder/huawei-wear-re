package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.PhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: PhoneNumBuilder */
public class aa extends C1418a {
    private String f3246k = "PhoneNumBuilder";
    private PhoneNumIOEntityModel f3247l;

    public aa(PhoneNumIOEntityModel phoneNumIOEntityModel) {
        this.f3247l = phoneNumIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3247l);
        if (this.f3247l != null) {
            stringBuffer.append("&phoneNum=");
            stringBuffer.append(this.f3247l.phoneNum);
            stringBuffer.append("&securityCode=");
            stringBuffer.append(this.f3247l.securityCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3246k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel phoneNumIOEntityModel = new PhoneNumIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (PhoneNumIOEntityModel) this.j.fromJson(str, PhoneNumIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                phoneNumIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3246k, "Exception e = " + e.getMessage());
            }
        }
        return phoneNumIOEntityModel;
    }
}
