package com.huawei.hwid.core.p435d.p437b;

import com.huawei.hwid.core.p435d.p437b.p438a.C5157a;
import com.huawei.hwid.core.p435d.p437b.p438a.C5157a.C5156a;

/* compiled from: LogFile */
public class C5162c {
    private static C5158a f18612a;

    /* compiled from: LogFile */
    public interface C5158a {
        void mo4636a(String str);
    }

    public static void m24887a(C5158a c5158a) {
        f18612a = c5158a;
    }

    private static boolean m24890a(int i) {
        return true;
    }

    public static void m24888a(String str, String str2) {
        if (C5162c.m24890a(3)) {
            C5156a a = C5157a.m24866a(3, str);
            a.m24863a(null).m24862a(str2);
            C5162c.m24886a(a.m24864a());
        }
    }

    public static void m24892b(String str, String str2) {
        if (C5162c.m24890a(4)) {
            C5156a a = C5157a.m24866a(4, str);
            a.m24863a(null).m24862a(str2);
            C5162c.m24886a(a.m24864a());
        }
    }

    public static void m24893c(String str, String str2) {
        if (C5162c.m24890a(6)) {
            C5156a a = C5157a.m24866a(6, str);
            a.m24863a(null).m24862a(str2);
            C5162c.m24886a(a.m24864a());
        }
    }

    public static void m24889a(String str, String str2, Throwable th) {
        if (C5162c.m24890a(6)) {
            C5156a a = C5157a.m24866a(6, str);
            a.m24862a(str2).m24863a(th);
            C5162c.m24886a(a.m24864a());
        }
    }

    private static void m24886a(C5157a c5157a) {
        C5162c.m24891b(c5157a);
        if (f18612a != null) {
            f18612a.mo4636a(c5157a.toString());
        }
    }

    private static void m24891b(C5157a c5157a) {
    }
}
