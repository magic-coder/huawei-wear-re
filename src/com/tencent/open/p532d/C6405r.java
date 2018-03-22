package com.tencent.open.p532d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.p541a.C6367n;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
public class C6405r {
    private static final String f22250a = ("openSDK_LOG." + C6405r.class.getName());
    private static C6405r f22251b = null;
    private volatile WeakReference<SharedPreferences> f22252c = null;

    public static synchronized C6405r m29214a() {
        C6405r c6405r;
        synchronized (C6405r.class) {
            if (f22251b == null) {
                f22251b = new C6405r();
            }
            c6405r = f22251b;
        }
        return c6405r;
    }

    public String m29215a(Context context, String str) {
        if (this.f22252c == null || this.f22252c.get() == null) {
            this.f22252c = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            Object host = new URL(str).getHost();
            if (host == null) {
                C6367n.m29112e(f22250a, "Get host error. url=" + str);
            } else {
                Object string = ((SharedPreferences) this.f22252c.get()).getString(host, null);
                if (string == null || host.equals(string)) {
                    C6367n.m29107b(f22250a, "host=" + host + ", envHost=" + string);
                } else {
                    str = str.replace(host, string);
                    C6367n.m29107b(f22250a, "return environment url : " + str);
                }
            }
        } catch (Exception e) {
            C6367n.m29112e(f22250a, "getEnvUrl url=" + str + "error.: " + e.getMessage());
        }
        return str;
    }
}
