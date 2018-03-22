package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p215g.C2982a;
import org.json.JSONObject;

final class ab implements C2904g {
    private final /* synthetic */ String f10258a;

    ab(String str) {
        this.f10258a = str;
    }

    public final void execute(Object... objArr) {
        if (objArr != null && objArr[0].toString().equals("0") && objArr.length == 2) {
            try {
                JSONObject jSONObject = new JSONObject(objArr[1].toString());
                jSONObject.get("code");
                if (jSONObject.get("code").equals("200")) {
                    C2917a.m13105a();
                    C2947n.m13274a("LastMenuActionCountActionUpdate", this.f10258a);
                    try {
                        C2922b.m13134a("tb_menu_action", "date < ?", new String[]{this.f10258a});
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                C2982a.m13415a("XIAOYUAN", "MenuActionCountActionUatil: " + th2.getMessage(), th2);
            }
        }
    }
}
