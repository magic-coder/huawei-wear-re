package cn.com.xy.sms.sdk.p216h;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p216h.p217a.C2985c;
import cn.com.xy.sms.sdk.p216h.p217a.C2989g;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import org.json.JSONObject;

final class C3004i implements C2904g {
    C3004i() {
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr[0].toString().equals("0") && objArr.length == 2) {
                    JSONObject jSONObject = new JSONObject(objArr[1].toString());
                    String optString = jSONObject.optString(SNBConstant.FIELD_TOKEN);
                    if (optString != null) {
                        C2947n.m13274a("NEWHTTPTOKEN", optString);
                        C2947n.f10009a.put("NEWHTTPTOKEN", optString);
                        byte[] a = C2985c.m13420a(jSONObject.optString("aesKey"));
                        C2947n.m13274a("AESKEY", C2989g.m13432a(a));
                        C2947n.f10009a.put("AESKEY", C2989g.m13432a(a));
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
