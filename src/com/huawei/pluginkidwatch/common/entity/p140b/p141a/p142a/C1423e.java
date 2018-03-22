package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.AddWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchContactModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: AddWatchContactBuilder */
public class C1423e extends C1418a {
    private String f3281k = "AddWatchContactBuilder";
    private AddWatchContactIOEntityModel f3282l;

    public C1423e(AddWatchContactIOEntityModel addWatchContactIOEntityModel) {
        this.f3282l = addWatchContactIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3282l);
        if (this.f3282l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3282l.deviceCode);
            stringBuffer.append("&contact=");
            stringBuffer.append(this.j.toJson(this.f3282l.contact));
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3281k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel baseEntityModel;
        C2538c.m12680e(this.f3281k, "addContact response : " + str);
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
                C2538c.m12680e(this.f3281k, "Exception e = " + e.getMessage());
                return watchContactModel;
            }
        }
        baseEntityModel = watchContactModel;
        return baseEntityModel;
    }
}
