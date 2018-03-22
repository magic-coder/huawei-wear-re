package cn.com.xy.sms.sdk.p220j.p224d;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C3031g implements C2904g {
    private final /* synthetic */ String f10241a;
    private final /* synthetic */ String f10242b;
    private final /* synthetic */ boolean f10243c;

    C3031g(String str, String str2, boolean z) {
        this.f10241a = str;
        this.f10242b = str2;
        this.f10243c = z;
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length > 0 && !"-1".equals(objArr[0].toString())) {
                    C3030f.m13577b(this.f10241a, this.f10242b, this.f10243c);
                    return;
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "checkQueryPubInfoNum: " + th.getMessage(), th);
                return;
            }
        }
        synchronized (C3030f.f10238a) {
            C3030f.f10239b = false;
        }
    }
}
