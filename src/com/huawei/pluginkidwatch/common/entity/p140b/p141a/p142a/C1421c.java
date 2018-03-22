package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.entity.model.SetAccompanyUserIEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: AccompanyUserBuilder */
public class C1421c extends C1418a {
    private String f3277k = "AccompanyUserBuilder";
    private SetAccompanyUserIEntityModel f3278l;

    public C1421c(SetAccompanyUserIEntityModel setAccompanyUserIEntityModel) {
        this.f3278l = setAccompanyUserIEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3278l);
        if (this.f3278l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3278l.deviceCode);
            stringBuffer.append("&operation=");
            stringBuffer.append(this.f3278l.operation);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3277k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonRetIModel = new CommonRetIModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonRetIModel) this.j.fromJson(str, CommonRetIModel.class);
            } catch (JsonSyntaxException e) {
                commonRetIModel.retCode = -1;
                C2538c.m12680e(this.f3277k, "Exception e = " + e.getMessage());
            }
        }
        return commonRetIModel;
    }
}
