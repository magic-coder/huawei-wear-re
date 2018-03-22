package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;

final class C2929g implements Runnable {
    private final /* synthetic */ int f9930a;
    private final /* synthetic */ String f9931b;
    private final /* synthetic */ String f9932c;
    private final /* synthetic */ int f9933d;
    private final /* synthetic */ String f9934e;
    private final /* synthetic */ String f9935f;
    private final /* synthetic */ int f9936g;

    C2929g(int i, String str, String str2, int i2, String str3, String str4, int i3) {
        this.f9930a = i;
        this.f9931b = str;
        this.f9932c = str2;
        this.f9933d = i2;
        this.f9934e = str3;
        this.f9935f = str4;
        this.f9936g = i3;
    }

    public final void run() {
        try {
            C2922b.m13149b("tb_public_num_info", C2921a.m13130a(null, "pubId", String.valueOf(this.f9930a), "areaCode", this.f9931b, Constants.FIELD_APPLET_CONFIG_NUM, this.f9932c, "ptype", String.valueOf(this.f9933d), "lastloadtime", String.valueOf(System.currentTimeMillis()), "isrulenum", "1", "purpose", this.f9934e, "extend", this.f9935f, "isuse", "1", "nameType", String.valueOf(this.f9936g)), " num = ? and ptype = ? ", new String[]{this.f9932c, String.valueOf(this.f9933d)});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoManager asyncInsertRuleMatchNum: " + th.getMessage(), th);
        }
    }
}
