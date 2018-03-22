package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.EditManagerModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: EditmManagerBuilder */
public class C1431m extends C1418a {
    private String f3297k = "EditmManagerBuilder";
    private EditManagerModel f3298l;

    public C1431m(EditManagerModel editManagerModel) {
        this.f3298l = editManagerModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3298l);
        if (this.f3298l != null) {
            stringBuffer.append("&deviceUser=");
            stringBuffer.append(this.j.toJson(this.f3298l.info));
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3297k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel baseEntityModel;
        C2538c.m12674b(this.f3297k, "EditmManagerBuilder stream : " + str);
        BaseEntityModel editManagerModel = new EditManagerModel();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    baseEntityModel = (EditManagerModel) this.j.fromJson(str, EditManagerModel.class);
                    return baseEntityModel;
                }
            } catch (JsonSyntaxException e) {
                editManagerModel.retCode = -1;
                editManagerModel.retMsg = "error happened in makeResponseEntity";
                C2538c.m12680e(this.f3297k, "Exception e = " + e.getMessage());
                return editManagerModel;
            }
        }
        baseEntityModel = editManagerModel;
        return baseEntityModel;
    }
}
