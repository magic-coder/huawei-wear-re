package com.huawei.feedback.logic;

import android.text.TextUtils;
import com.huawei.feedback.FeedbackApi;
import com.huawei.feedback.a.a.c;
import com.huawei.feedback.a.a.e;
import com.huawei.feedback.bean.d;
import java.util.List;

/* compiled from: FeedbackLogic */
public final class C0822f {
    public static synchronized long m2885a(d dVar) {
        long a;
        synchronized (C0822f.class) {
            c a2 = c.a(FeedbackApi.getApplicationcontext());
            e.a(a2);
            a = e.a(a2, dVar);
        }
        return a;
    }

    public static synchronized void m2892b(d dVar) {
        synchronized (C0822f.class) {
            c a = c.a(FeedbackApi.getApplicationcontext());
            e.a(a);
            if (dVar != null) {
                if (dVar.t() == -1) {
                    e.a(a, dVar);
                } else {
                    e.c(a, dVar);
                }
            }
        }
    }

    public static synchronized void m2894c(d dVar) {
        synchronized (C0822f.class) {
            c a = c.a(FeedbackApi.getApplicationcontext());
            e.a(a);
            if (dVar != null) {
                e.b(a, dVar);
            }
        }
    }

    public static synchronized void m2889a(String str, int i) {
        synchronized (C0822f.class) {
            c a = c.a(FeedbackApi.getApplicationcontext());
            e.a(a);
            if (!TextUtils.isEmpty(str)) {
                e.a(a, str, i);
            }
        }
    }

    public static synchronized List<d> m2887a() {
        List<d> b;
        synchronized (C0822f.class) {
            b = e.b(c.a(FeedbackApi.getApplicationcontext()));
        }
        return b;
    }

    public static synchronized d m2886a(String str) {
        d c;
        synchronized (C0822f.class) {
            c = e.c(c.a(FeedbackApi.getApplicationcontext()), str);
        }
        return c;
    }

    public static synchronized List<d> m2890b(String str) {
        List<d> b;
        synchronized (C0822f.class) {
            b = e.b(c.a(FeedbackApi.getApplicationcontext()), str);
        }
        return b;
    }

    public static synchronized void m2891b() {
        synchronized (C0822f.class) {
            e.c(c.a(FeedbackApi.getApplicationcontext()));
        }
    }

    public static synchronized void m2895c(String str) {
        synchronized (C0822f.class) {
            e.d(c.a(FeedbackApi.getApplicationcontext()), str);
        }
    }

    public static synchronized void m2888a(int i) {
        synchronized (C0822f.class) {
            e.a(c.a(FeedbackApi.getApplicationcontext()), i);
        }
    }

    public static synchronized void m2897d(d dVar) {
        synchronized (C0822f.class) {
            new Thread(new o(dVar)).start();
        }
    }

    public static synchronized List<String> m2893c() {
        List<String> d;
        synchronized (C0822f.class) {
            c a = c.a(FeedbackApi.getApplicationcontext());
            e.a(a);
            d = e.d(a);
        }
        return d;
    }

    public static synchronized d m2896d(String str) {
        d e;
        synchronized (C0822f.class) {
            e = e.e(c.a(FeedbackApi.getApplicationcontext()), str);
        }
        return e;
    }
}
