package com.huawei.hwid.core.p435d.p437b;

import android.content.Context;
import android.util.Log;
import com.huawei.hwid.core.p435d.p437b.C5161b.C5160a;
import java.io.File;

/* compiled from: LogHwIDAdpater */
public final class C5164d extends C5161b {
    private static final C5159a f18614b = new C5159a();
    private static C5164d f18615c;

    /* compiled from: LogHwIDAdpater */
    class C5163a extends Thread {
        private Context f18613a;

        C5163a(Context context) {
            this.f18613a = context;
        }

        public void run() {
            String str = "";
            try {
                C5164d.f18614b.m24874a(new File(C5160a.m24876a(this.f18613a), "apphwid.txt"));
                C5162c.m24887a(C5164d.f18614b);
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.e("hwid", "ArrayIndexOutOfBoundsException" + e.getMessage());
            } catch (Exception e2) {
                Log.e("hwid", "Exception" + e2.getMessage());
            }
        }
    }

    public static synchronized C5164d m24897b(Context context) {
        C5164d c5164d;
        synchronized (C5164d.class) {
            if (f18615c == null) {
                f18615c = new C5164d(context);
                a = C5161b.m24880a(context);
            }
            c5164d = f18615c;
        }
        return c5164d;
    }

    private C5164d(Context context) {
        new C5163a(context).start();
    }

    public void mo4637a(String str, String str2) {
        C5164d.m24895a(3, str, str2, null, 2);
        C5162c.m24888a(str, str2);
    }

    public void mo4638a(String str, String str2, Throwable th) {
        C5164d.m24895a(3, str, str2, th, 2);
        C5162c.m24889a(str, str2, th);
    }

    public void mo4639b(String str, String str2) {
        C5164d.m24895a(4, str, str2, null, 2);
        C5162c.m24892b(str, str2);
    }

    public void mo4641c(String str, String str2) {
        C5164d.m24895a(6, str, str2, null, 2);
        C5162c.m24893c(str, str2);
    }

    public void mo4640b(String str, String str2, Throwable th) {
        C5164d.m24895a(6, str, str2, th, 2);
        C5162c.m24889a(str, str2, th);
    }

    private static synchronized void m24895a(int i, String str, String str2, Throwable th, int i2) {
        synchronized (C5164d.class) {
            if (C5164d.m24896a(i)) {
                if (str2 == null) {
                    try {
                        str2 = "";
                    } catch (IllegalArgumentException e) {
                        Log.e("hwid", "println IllegalArgumentException" + e.getMessage());
                    } catch (Exception e2) {
                        Log.e("hwid", "println Exception" + e2.getMessage());
                    }
                }
                Log.println(i, a + str, str2);
            }
        }
    }

    private static boolean m24896a(int i) {
        return Log.isLoggable("hwid", i);
    }
}
