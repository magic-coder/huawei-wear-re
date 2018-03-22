package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.AbilityIOModel;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import java.util.Map;

/* compiled from: AbilityBuilder */
public class C1419a extends C1418a {
    private String f3244k = "AbilityBuilder";
    private AbilityIOModel f3245l;

    public C1419a(AbilityIOModel abilityIOModel) {
        this.f3245l = abilityIOModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3245l);
        if (this.f3245l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3245l.deviceCode);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3244k, "AbilityBuilder makeRequestStream model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel abilityIOModel = new AbilityIOModel();
        C2538c.m12674b(this.f3244k, "makeResponseEntity strResponse = " + str);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    Map map = (Map) this.j.fromJson(str, new C1420b(this).getType());
                    if (map != null) {
                        abilityIOModel.data = map;
                        abilityIOModel.retCode = 0;
                    } else {
                        abilityIOModel.retCode = -1;
                        abilityIOModel.data = null;
                        abilityIOModel.retMsg = "error happened in makeResponseEntity";
                    }
                }
            } catch (JsonSyntaxException e) {
                abilityIOModel.retCode = -1;
                abilityIOModel.retMsg = "error happened in makeResponseEntity";
                C2538c.m12680e(this.f3244k, "json error! " + e.getMessage());
            }
        }
        return abilityIOModel;
    }
}
