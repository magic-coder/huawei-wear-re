package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: SetWatchSettingBuilder */
public class ae extends C1418a {
    private String f3254k = "SetWatchSettingBuilder";
    private SetWatchSettingIOModel f3255l;

    public ae(SetWatchSettingIOModel setWatchSettingIOModel) {
        this.f3255l = setWatchSettingIOModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3255l);
        if (this.f3255l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3255l.deviceCode);
            stringBuffer.append("&settingMap=");
            String toJson = this.j.toJson(this.f3255l.settingMap);
            C2538c.m12674b(this.f3254k, "============setWatchSettingBuilder makeRequestStream model:", toJson);
            stringBuffer.append(toJson);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3254k, "setWatchSettingBuilder makeRequestStream model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonRetIModel = new CommonRetIModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonRetIModel) this.j.fromJson(str, CommonRetIModel.class);
            } catch (JsonSyntaxException e) {
                commonRetIModel.retCode = -1;
                C2538c.m12680e(this.f3254k, "setWatchSettingBuilder makeResponseEntity Exception e = " + e.getMessage());
            }
        }
        return commonRetIModel;
    }
}
