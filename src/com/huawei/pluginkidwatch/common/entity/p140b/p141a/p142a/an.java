package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.ValidateCodeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchSecurityCodeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: WatchSecurityCodeBuidler */
public class an extends C1418a {
    private String f3272k = "WatchSecurityCodeBuidler";
    private WatchSecurityCodeIOEntityModel f3273l;

    public an(WatchSecurityCodeIOEntityModel watchSecurityCodeIOEntityModel) {
        this.f3273l = watchSecurityCodeIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3273l);
        if (this.f3273l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3273l.deviceCode);
            stringBuffer.append("&phoneNum=");
            stringBuffer.append(this.f3273l.phoneNum);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3272k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel validateCodeIOEntityModel = new ValidateCodeIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (ValidateCodeIOEntityModel) this.j.fromJson(str, ValidateCodeIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                validateCodeIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3272k, "Exception e = " + e.getMessage());
            }
        }
        return validateCodeIOEntityModel;
    }
}
