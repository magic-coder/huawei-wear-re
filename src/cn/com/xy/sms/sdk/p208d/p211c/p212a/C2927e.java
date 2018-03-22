package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import cn.com.xy.sms.p204a.C2899a;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import java.util.HashMap;

final class C2927e implements Runnable {
    private final /* synthetic */ HashMap f9929a;

    C2927e(HashMap hashMap) {
        this.f9929a = hashMap;
    }

    public final void run() {
        try {
            C2899a.m13064a(C2917a.m13105a(), (String) this.f9929a.get(Constants.FIELD_APPLET_CONFIG_NUM), 1, "", null, null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
        }
    }
}
