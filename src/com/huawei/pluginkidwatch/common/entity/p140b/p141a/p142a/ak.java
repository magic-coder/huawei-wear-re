package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.VerifyBindCodeModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: VerifyBindCodeBuilder */
public class ak extends C1418a {
    private String f3267k = "VerifyBindCodeBuilder";
    private VerifyBindCodeModel f3268l;

    public ak(VerifyBindCodeModel verifyBindCodeModel) {
        this.f3268l = verifyBindCodeModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3268l);
        if (this.f3268l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3268l.deviceCode);
            stringBuffer.append("&securityCode=");
            stringBuffer.append(this.f3268l.securityCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3267k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonRetOModel = new CommonRetOModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonRetOModel) this.j.fromJson(str, CommonRetOModel.class);
            } catch (JsonSyntaxException e) {
                commonRetOModel.retCode = -1;
                C2538c.m12680e(this.f3267k, "Exception e = " + e.getMessage());
            }
        }
        return commonRetOModel;
    }
}
