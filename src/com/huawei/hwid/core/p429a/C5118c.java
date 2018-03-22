package com.huawei.hwid.core.p429a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.p432a.C5128b;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: OpLogUtil */
public class C5118c {
    private static boolean f18452a = true;
    private static int f18453b = 0;
    private static volatile int f18454c = 0;

    public static synchronized void m24666a(C5117b c5117b, Context context) {
        synchronized (C5118c.class) {
            C5165e.m24906b("OpLogUtil", "recordOpLog");
            if (!(c5117b == null || context == null)) {
                f18453b = c5117b.m24660a();
                if (f18454c == 0) {
                    C5116a.m24648a(context).m24652a(c5117b);
                    C5118c.m24667b(context);
                } else if (1 == f18454c) {
                    C5116a.m24648a(context).m24655b(c5117b);
                }
            }
        }
    }

    private static synchronized void m24667b(Context context) {
        synchronized (C5118c.class) {
            if (f18452a && C5166b.m24924a(context) && !C5116a.m24648a(context).m24654b().isEmpty()) {
                C5125a c5128b = new C5128b(C5116a.m24648a(context).toString());
                if (f18453b > 0 && f18453b <= 999) {
                    c5128b.m24690c(f18453b);
                }
                c5128b.mo4627a(context, c5128b, null, null);
                f18454c = 1;
            }
        }
    }

    public static synchronized void m24664a(Context context) {
        synchronized (C5118c.class) {
            if (!C5116a.m24648a(context).m24656c().isEmpty()) {
                C5116a.m24648a(context).m24657d();
                C5118c.m24667b(context);
            }
        }
    }

    public static synchronized void m24663a(int i) {
        synchronized (C5118c.class) {
            f18454c = i;
        }
    }

    public static synchronized void m24665a(Bundle bundle, Context context) {
        synchronized (C5118c.class) {
            if (bundle != null) {
                C5118c.m24666a(new C5117b(bundle, context), context);
            }
        }
    }
}
