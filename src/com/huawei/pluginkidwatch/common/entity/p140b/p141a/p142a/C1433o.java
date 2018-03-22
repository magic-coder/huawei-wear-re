package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.AppProfileModel;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: GetAppProfileBuilder */
public class C1433o extends C1418a {
    private String f3301k = "GetAppProfileBuilder";
    private AppProfileModel f3302l;

    public C1433o(AppProfileModel appProfileModel) {
        this.f3302l = appProfileModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3302l);
        if (this.f3302l != null) {
            stringBuffer.append("&appVersion=");
            stringBuffer.append(this.f3302l.appVersion);
            stringBuffer.append("&phoneManufacturer=");
            stringBuffer.append(this.f3302l.phoneManufacturer);
            if (!(this.f3302l.phoneManufacturer == null || this.f3302l.phoneManufacturer.isEmpty())) {
                stringBuffer.append("&phoneModel=");
            }
            stringBuffer.append(this.f3302l.phoneModel);
            C2538c.m12680e(this.f3301k, stringBuffer.toString());
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3301k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel appProfileModel = new AppProfileModel();
        C2538c.m12680e(this.f3301k, str);
        if (str != null && str.length() > 0) {
            try {
                return (AppProfileModel) this.j.fromJson(str, AppProfileModel.class);
            } catch (JsonSyntaxException e) {
                appProfileModel.retCode = -1;
                C2538c.m12680e(this.f3301k, "Exception e = " + e.getMessage());
            }
        }
        return appProfileModel;
    }
}
