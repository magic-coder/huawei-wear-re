package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.MotionPathsIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: MotionPathsBuilder */
public class C1444z extends C1418a {
    private String f3323k = "MotionPathsBuilder";
    private MotionPathsIOEntityModel f3324l;

    public C1444z(MotionPathsIOEntityModel motionPathsIOEntityModel) {
        this.f3324l = motionPathsIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3324l);
        if (this.f3324l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3324l.deviceCode);
            stringBuffer.append("&dateEnd=");
            stringBuffer.append(this.f3324l.dateEnd);
            stringBuffer.append("&daysCount=");
            stringBuffer.append(this.f3324l.daysCount);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3323k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel motionPathsIOEntityModel = new MotionPathsIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (MotionPathsIOEntityModel) this.j.fromJson(str, MotionPathsIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                motionPathsIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3323k, "Exception e = " + e.getMessage());
            }
        }
        return motionPathsIOEntityModel;
    }
}
