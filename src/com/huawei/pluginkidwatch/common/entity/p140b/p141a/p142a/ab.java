package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.RewardIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: RewardBuilder */
public class ab extends C1418a {
    private String f3248k = "RewardBuilder";
    private RewardIOEntityModel f3249l;

    public ab(RewardIOEntityModel rewardIOEntityModel) {
        this.f3249l = rewardIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3249l);
        if (this.f3249l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3249l.deviceCode);
            stringBuffer.append("&rewardType=");
            stringBuffer.append(this.f3249l.rewardType);
            stringBuffer.append("&count=");
            stringBuffer.append(this.f3249l.count);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3248k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel rewardIOEntityModel = new RewardIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (RewardIOEntityModel) this.j.fromJson(str, RewardIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                rewardIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3248k, "Exception e = " + e.getMessage());
            }
        }
        return rewardIOEntityModel;
    }
}
