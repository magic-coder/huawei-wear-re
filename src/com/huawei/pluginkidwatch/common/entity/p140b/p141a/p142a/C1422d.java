package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.AddFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.FenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: AddFenceBuilder */
public class C1422d extends C1418a {
    private String f3279k = "AddFenceBuilder";
    private AddFenceIOEntityModel f3280l;

    public C1422d(AddFenceIOEntityModel addFenceIOEntityModel) {
        this.f3280l = addFenceIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3280l);
        if (this.f3280l != null) {
            stringBuffer.append("&fence=");
            stringBuffer.append(this.j.toJson(this.f3280l));
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3279k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel fenceIOEntityModel = new FenceIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (FenceIOEntityModel) this.j.fromJson(str, FenceIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                fenceIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3279k, "Exception e = " + e.getMessage());
            }
        }
        return fenceIOEntityModel;
    }
}
