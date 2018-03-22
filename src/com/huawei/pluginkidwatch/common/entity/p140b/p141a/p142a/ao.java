package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: WatchStatusInfoBuilder */
public class ao extends C1418a {
    private String f3274k = "WatchStatusInfoBuilder";
    private WatchStatusIOModel f3275l;

    public ao(WatchStatusIOModel watchStatusIOModel) {
        this.f3275l = watchStatusIOModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3275l);
        if (this.f3275l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3275l.deviceCode);
            if (!(this.f3275l.type == null || this.f3275l.type.isEmpty())) {
                stringBuffer.append("&type=");
                stringBuffer.append(this.f3275l.type);
            }
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3274k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel baseEntityModel;
        BaseEntityModel watchStatusIOModel = new WatchStatusIOModel();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    baseEntityModel = (WatchStatusIOModel) this.j.fromJson(str, WatchStatusIOModel.class);
                    return baseEntityModel;
                }
            } catch (JsonSyntaxException e) {
                watchStatusIOModel.retCode = -1;
                watchStatusIOModel.retMsg = "error happened in makeResponseEntity";
                C2538c.m12680e(this.f3274k, "Exception e = " + e.getMessage());
                return watchStatusIOModel;
            }
        }
        baseEntityModel = watchStatusIOModel;
        return baseEntityModel;
    }
}
