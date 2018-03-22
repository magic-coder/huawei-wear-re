package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.aa;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2990h;

final class af implements C2904g {
    private final /* synthetic */ String f10262a;

    af(String str) {
        this.f10262a = str;
    }

    public final void execute(Object... objArr) {
        if (objArr != null && objArr[0].toString().equals("0") && objArr.length == 2 && C2990h.m13440d(objArr[1].toString())) {
            C2947n.m13274a("LastSceneCountActionUpdate", this.f10262a);
            try {
                C2922b.m13134a("tb_popup_action_scene", "date < ?", new String[]{this.f10262a});
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "deleteInfoByDate: " + th.getMessage(), th);
            }
            aa.m13216a(this.f10262a);
        }
    }
}
