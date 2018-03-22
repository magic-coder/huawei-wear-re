package com.tencent.open.p542b;

import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6403p;

/* compiled from: ProGuard */
public class C6376e {
    public static int m29150a(String str) {
        int a = C6403p.m29203a(C6395h.m29184a(), str).m29212a("Common_BusinessReportFrequency");
        if (a == 0) {
            return 100;
        }
        return a;
    }

    public static int m29149a() {
        int a = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Common_HttpRetryCount");
        if (a == 0) {
            return 2;
        }
        return a;
    }
}
