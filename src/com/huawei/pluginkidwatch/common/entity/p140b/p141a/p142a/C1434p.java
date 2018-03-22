package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateOModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateRetIOModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetCommonStateBuilder */
public class C1434p extends C1418a {
    private String f3303k = "GetCommonStateBuilder";
    private CommonStateOModel f3304l;

    public C1434p(CommonStateOModel commonStateOModel) {
        this.f3304l = commonStateOModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3304l);
        if (this.f3304l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3304l.deviceCode);
            stringBuffer.append("&type=");
            stringBuffer.append(this.f3304l.type);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3303k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonStateRetIOModel = new CommonStateRetIOModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonStateRetIOModel) this.j.fromJson(str, CommonStateRetIOModel.class);
            } catch (JsonSyntaxException e) {
                commonStateRetIOModel.retCode = -1;
                C2538c.m12680e(this.f3303k, e.getMessage());
            }
        }
        return commonStateRetIOModel;
    }
}
