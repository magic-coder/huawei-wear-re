package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: CommandInfoBuilder */
public class C1426h extends C1418a {
    private String f3287k = "CommandInfoBuilder";
    private CommonRetOModel f3288l;

    public C1426h(CommonRetOModel commonRetOModel) {
        this.f3288l = commonRetOModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3288l);
        if (this.f3288l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3288l.deviceCode);
            if ("com.huawei.watch.sendCommand".equals(this.f3288l.interfaceName)) {
                stringBuffer.append("&type=");
                stringBuffer.append(this.f3288l.type);
            }
            stringBuffer.append("&data=");
            stringBuffer.append(this.f3288l.data);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3287k, "CommandInfoBuilder model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel commonRetIModel = new CommonRetIModel();
        if (str != null && str.length() > 0) {
            try {
                return (CommonRetIModel) this.j.fromJson(str, CommonRetIModel.class);
            } catch (JsonSyntaxException e) {
                commonRetIModel.retCode = -1;
                C2538c.m12680e(this.f3287k, "Exception e = " + e.getMessage());
            }
        }
        return commonRetIModel;
    }
}
