package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.entity.model.GetVoiceModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: VoiceBuidler */
public class al extends C1418a {
    private GetVoiceModel f3269k;

    public al(GetVoiceModel getVoiceModel) {
        this.f3269k = getVoiceModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3269k);
        if (this.f3269k != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3269k.deviceCode);
            stringBuffer.append("&chatMessage=");
            stringBuffer.append(this.j.toJson(this.f3269k.chatMessage));
            return stringBuffer.toString();
        }
        C2538c.m12680e("VoiceBuidler", "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel baseEntityModel;
        BaseEntityModel commonRetIModel = new CommonRetIModel();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    baseEntityModel = (CommonRetIModel) this.j.fromJson(str, CommonRetIModel.class);
                    return baseEntityModel;
                }
            } catch (JsonSyntaxException e) {
                C2538c.m12680e("VoiceBuidler", "json error!!! " + e.getMessage());
                return commonRetIModel;
            }
        }
        baseEntityModel = commonRetIModel;
        return baseEntityModel;
    }
}
