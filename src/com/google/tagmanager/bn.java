package com.google.tagmanager;

import com.google.analytics.p273b.p274a.p275a.C3644b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: ValueEscapeUtil */
class bn {
    static ak<C3644b> m18542a(ak<C3644b> akVar, int... iArr) {
        ak a;
        for (int a2 : iArr) {
            a = m18541a(a, a2);
        }
        return a;
    }

    static String m18543a(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, GameManager.DEFAULT_CHARSET).replaceAll("\\+", "%20");
    }

    private static ak<C3644b> m18541a(ak<C3644b> akVar, int i) {
        if (m18544a((C3644b) akVar.m18468a())) {
            switch (i) {
                case 12:
                    return m18540a((ak) akVar);
                default:
                    C3700z.m18624a("Unsupported Value Escaping: " + i);
                    return akVar;
            }
        }
        C3700z.m18624a("Escaping can only be applied to strings.");
        return akVar;
    }

    private static ak<C3644b> m18540a(ak<C3644b> akVar) {
        try {
            return new ak(bl.m18535c(m18543a(bl.m18531a((C3644b) akVar.m18468a()))), akVar.m18469b());
        } catch (Throwable e) {
            C3700z.m18625a("Escape URI: unsupported encoding", e);
            return akVar;
        }
    }

    private static boolean m18544a(C3644b c3644b) {
        return bl.m18536c(c3644b) instanceof String;
    }
}
