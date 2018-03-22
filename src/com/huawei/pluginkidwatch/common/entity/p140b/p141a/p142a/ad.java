package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchContactModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: SetWatchContactBuilder */
public class ad extends C1418a {
    private String f3252k = "SetWatchContactBuilder";
    private SetWatchContactIOEntityModel f3253l;

    public ad(SetWatchContactIOEntityModel setWatchContactIOEntityModel) {
        this.f3253l = setWatchContactIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3253l);
        if (this.f3253l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3253l.deviceCode);
            stringBuffer.append("&contact=");
            stringBuffer.append(this.j.toJson(this.f3253l));
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3252k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel baseEntityModel;
        C2538c.m12674b(this.f3252k, "setWatchContact strResponse: " + str);
        BaseEntityModel watchContactModel = new WatchContactModel();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    baseEntityModel = (WatchContactModel) this.j.fromJson(str, WatchContactModel.class);
                    return baseEntityModel;
                }
            } catch (JsonSyntaxException e) {
                watchContactModel.retCode = -1;
                watchContactModel.retMsg = "error happened in makeResponseEntity";
                C2538c.m12680e(this.f3252k, "Exception e = " + e.getMessage());
                return watchContactModel;
            }
        }
        baseEntityModel = watchContactModel;
        return baseEntityModel;
    }
}
