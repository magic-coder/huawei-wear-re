package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeleteWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: DeleteWatchContactBuilder */
public class C1428j extends C1418a {
    private String f3291k = "DeleteWatchContactBuilder";
    private DeleteWatchContactIOEntityModel f3292l;

    public C1428j(DeleteWatchContactIOEntityModel deleteWatchContactIOEntityModel) {
        this.f3292l = deleteWatchContactIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3292l);
        if (this.f3292l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3292l.deviceCode);
            stringBuffer.append("&contactId=");
            stringBuffer.append(this.f3292l.id);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3291k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel deleteWatchContactIOEntityModel = new DeleteWatchContactIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (DeleteWatchContactIOEntityModel) this.j.fromJson(str, DeleteWatchContactIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                deleteWatchContactIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3291k, "Exception e = " + e.getMessage());
            }
        }
        return deleteWatchContactIOEntityModel;
    }
}
