package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.SynchronizePushIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: SynchronizePushInfoBuilder */
public class af extends C1418a {
    private String f3256k = "SynchronizePushInfoBuilder";
    private SynchronizePushIOEntityModel f3257l;

    public af(SynchronizePushIOEntityModel synchronizePushIOEntityModel) {
        this.f3257l = synchronizePushIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3257l);
        if (this.f3257l != null) {
            stringBuffer.append("&id=");
            stringBuffer.append(this.f3257l.id);
            stringBuffer.append("&type=1");
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3256k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel synchronizePushIOEntityModel = new SynchronizePushIOEntityModel();
        if (str != null && str.length() > 2) {
            try {
                return (SynchronizePushIOEntityModel) this.j.fromJson(str, SynchronizePushIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                synchronizePushIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3256k, "Exception e = " + e.getMessage());
            }
        }
        return synchronizePushIOEntityModel;
    }
}
