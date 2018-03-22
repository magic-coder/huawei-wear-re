package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.PhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetPhoneNumBuilder */
public class C1438t extends C1418a {
    private String f3311k = "GetPhoneNumBuilder";
    private PhoneNumIOEntityModel f3312l;

    public C1438t(PhoneNumIOEntityModel phoneNumIOEntityModel) {
        this.f3312l = phoneNumIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3312l);
        if (this.f3312l != null) {
            stringBuffer.append("");
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3311k, "getPhoneNumBuilder model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonRetOModel = new CommonRetOModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonRetOModel) this.j.fromJson(str, CommonRetOModel.class);
            } catch (JsonSyntaxException e) {
                commonRetOModel.retCode = -1;
                C2538c.m12680e(this.f3311k, "getPhoneNumBuilder model Exception e = " + e.getMessage());
            }
        }
        return commonRetOModel;
    }
}
