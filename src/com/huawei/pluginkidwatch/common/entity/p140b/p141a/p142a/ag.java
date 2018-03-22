package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.TransferPrivilegeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: TransferPrivilegeBuilder */
public class ag extends C1418a {
    private String f3258k = "TransferPrivilegeBuilder";
    private TransferPrivilegeIOEntityModel f3259l;

    public ag(TransferPrivilegeIOEntityModel transferPrivilegeIOEntityModel) {
        this.f3259l = transferPrivilegeIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3259l);
        if (this.f3259l != null) {
            stringBuffer.append("&huid=");
            stringBuffer.append(this.f3259l.huid);
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3259l.deviceCode);
            stringBuffer.append("&type=");
            stringBuffer.append(this.f3259l.type);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3258k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel transferPrivilegeIOEntityModel = new TransferPrivilegeIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (TransferPrivilegeIOEntityModel) this.j.fromJson(str, TransferPrivilegeIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                transferPrivilegeIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3258k, "Exception e = " + e.getMessage());
            }
        }
        return transferPrivilegeIOEntityModel;
    }
}
