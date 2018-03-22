package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.entity.model.UploadTMIDIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: UploadTMIDBuilder */
public class ai extends C1418a {
    private String f3263k = "UploadTMIDBuilder";
    private UploadTMIDIOEntityModel f3264l;

    public ai(UploadTMIDIOEntityModel uploadTMIDIOEntityModel) {
        this.f3264l = uploadTMIDIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3264l);
        if (this.f3264l != null) {
            stringBuffer.append("&tmid=");
            stringBuffer.append(this.f3264l.tmid);
            stringBuffer.append("&type=");
            stringBuffer.append(this.f3264l.type);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3263k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonRetIModel = new CommonRetIModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonRetIModel) this.j.fromJson(str, CommonRetIModel.class);
            } catch (JsonSyntaxException e) {
                commonRetIModel.retCode = -1;
                C2538c.m12680e(this.f3263k, "Exception e = " + e.getMessage());
            }
        }
        return commonRetIModel;
    }
}
