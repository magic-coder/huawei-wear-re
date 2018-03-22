package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetWatchSettingBuilder */
public class C1441w extends C1418a {
    private String f3317k = "GetWatchSettingBuilder";
    private GetWatchSettingModel f3318l;

    public C1441w(GetWatchSettingModel getWatchSettingModel) {
        this.f3318l = getWatchSettingModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3318l);
        if (this.f3318l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3318l.deviceCode);
            stringBuffer.append("&settingType=");
            stringBuffer.append(this.f3318l.settingType);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3317k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel getWatchSettingModel = new GetWatchSettingModel();
        if (str != null && str.length() > 0) {
            try {
                return (GetWatchSettingModel) this.j.fromJson(str, GetWatchSettingModel.class);
            } catch (JsonSyntaxException e) {
                getWatchSettingModel.retCode = -1;
                C2538c.m12680e(this.f3317k, "Exception e = " + e.getMessage());
            }
        }
        return getWatchSettingModel;
    }
}
