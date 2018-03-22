package cn.com.xy.sms.p204a;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3037b;
import cn.com.xy.sms.sdk.p229l.C3050o;
import java.util.Map;

final class C2908i implements C2904g {
    private final /* synthetic */ C3037b f9884a;
    private final /* synthetic */ String f9885b;
    private final /* synthetic */ C2905f f9886c;

    C2908i(C3037b c3037b, String str, C2905f c2905f) {
        this.f9884a = c3037b;
        this.f9885b = str;
        this.f9886c = c2905f;
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            try {
                this.f9884a.f10277j.put(this.f9885b, (Map) objArr[0]);
                this.f9884a.f10279l.remove(this.f9885b);
                this.f9884a.f10281n.remove(this.f9885b);
                C2903e.m13076a(this.f9885b);
                C3050o.m13670a(this.f9886c, Integer.valueOf(2), "refresh list", this.f9885b, Integer.valueOf(8));
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "ParseSmsMessage queryRecognisedValueFromApi error:" + th.getLocalizedMessage(), th);
            }
        }
    }
}
