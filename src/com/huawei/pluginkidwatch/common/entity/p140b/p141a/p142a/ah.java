package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import android.content.Context;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UnbindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: UnbindDeviceBuilder */
public class ah extends C1418a {
    private String f3260k = "UnbindDeviceBuilder";
    private UnbindDeviceIOEntityModel f3261l;
    private Context f3262m;

    public ah(UnbindDeviceIOEntityModel unbindDeviceIOEntityModel, Context context) {
        this.f3261l = unbindDeviceIOEntityModel;
        this.f3262m = context;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3261l);
        if (this.f3261l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3261l.deviceCode);
            if (!C1497q.m6944b(this.f3262m, "isunbindself").booleanValue()) {
                stringBuffer.append("&userId=");
                stringBuffer.append(this.f3261l.userId);
            }
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3260k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel unbindDeviceIOEntityModel = new UnbindDeviceIOEntityModel();
        if (str != null && str.length() > 0) {
            try {
                return (UnbindDeviceIOEntityModel) this.j.fromJson(str, UnbindDeviceIOEntityModel.class);
            } catch (JsonSyntaxException e) {
                unbindDeviceIOEntityModel.retCode = -1;
                C2538c.m12680e(this.f3260k, "Exception e = " + e.getMessage());
            }
        }
        return unbindDeviceIOEntityModel;
    }
}
