package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.ValidateCodeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: ValidateCodeBuilder */
public class aj extends C1418a {
    private String f3265k = "ValidateCodeBuilder";
    private ValidateCodeIOEntityModel f3266l;

    public aj(ValidateCodeIOEntityModel validateCodeIOEntityModel) {
        this.f3266l = validateCodeIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3266l);
        if (this.f3266l != null) {
            stringBuffer.append("&phoneNum=");
            stringBuffer.append(this.f3266l.phoneNum);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3265k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel validateCodeIOEntityModel = new ValidateCodeIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (ValidateCodeIOEntityModel) this.j.fromJson(str, ValidateCodeIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                validateCodeIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3265k, "Exception e = " + e.getMessage());
            }
        }
        return validateCodeIOEntityModel;
    }
}
