package com.tencent.wxop.stat.p546a;

import android.content.Context;
import com.tencent.p527a.p528a.p529a.p530a.C6243h;
import com.tencent.wxop.stat.C6544v;
import com.tencent.wxop.stat.C6547y;
import com.tencent.wxop.stat.am;
import com.tencent.wxop.stat.p547b.C6508c;
import com.tencent.wxop.stat.p547b.C6517l;
import com.tencent.wxop.stat.p547b.C6523r;
import org.json.JSONObject;

public abstract class C6495d {
    protected static String f22560j = null;
    private C6547y f22561a = null;
    protected String f22562b = null;
    protected long f22563c;
    protected int f22564d;
    protected C6508c f22565e = null;
    protected int f22566f;
    protected String f22567g = null;
    protected String f22568h = null;
    protected String f22569i = null;
    protected boolean f22570k = false;
    protected Context f22571l;

    C6495d(Context context, int i, C6547y c6547y) {
        this.f22571l = context;
        this.f22563c = System.currentTimeMillis() / 1000;
        this.f22564d = i;
        this.f22568h = C6544v.m29827b(context);
        this.f22569i = C6517l.m29756j(context);
        this.f22562b = C6544v.m29816a(context);
        if (c6547y != null) {
            this.f22561a = c6547y;
            if (C6517l.m29742c(c6547y.m29894c())) {
                this.f22562b = c6547y.m29894c();
            }
            if (C6517l.m29742c(c6547y.m29895d())) {
                this.f22568h = c6547y.m29895d();
            }
            if (C6517l.m29742c(c6547y.m29893b())) {
                this.f22569i = c6547y.m29893b();
            }
            this.f22570k = c6547y.m29896e();
        }
        this.f22567g = C6544v.m29835d(context);
        this.f22565e = am.m29668a(context).m29697b(context);
        if (mo5348b() != C6499e.NETWORK_DETECTOR) {
            this.f22566f = C6517l.m29763q(context).intValue();
        } else {
            this.f22566f = -C6499e.NETWORK_DETECTOR.m29642a();
        }
        if (!C6243h.m28695b(f22560j)) {
            String e = C6544v.m29838e(context);
            f22560j = e;
            if (!C6517l.m29742c(e)) {
                f22560j = "0";
            }
        }
    }

    private boolean m29628b(JSONObject jSONObject) {
        boolean z = false;
        try {
            C6523r.m29785a(jSONObject, "ky", this.f22562b);
            jSONObject.put("et", mo5348b().m29642a());
            if (this.f22565e != null) {
                jSONObject.put("ui", this.f22565e.m29712a());
                C6523r.m29785a(jSONObject, "mc", this.f22565e.m29713b());
                int d = this.f22565e.m29715d();
                jSONObject.put("ut", d);
                if (d == 0 && C6517l.m29766t(this.f22571l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            C6523r.m29785a(jSONObject, "cui", this.f22567g);
            if (mo5348b() != C6499e.SESSION_ENV) {
                C6523r.m29785a(jSONObject, "av", this.f22569i);
                C6523r.m29785a(jSONObject, "ch", this.f22568h);
            }
            if (this.f22570k) {
                jSONObject.put("impt", 1);
            }
            C6523r.m29785a(jSONObject, "mid", f22560j);
            jSONObject.put("idx", this.f22566f);
            jSONObject.put("si", this.f22564d);
            jSONObject.put("ts", this.f22563c);
            jSONObject.put("dts", C6517l.m29728a(this.f22571l, false));
            z = mo5347a(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }

    public abstract boolean mo5347a(JSONObject jSONObject);

    public abstract C6499e mo5348b();

    public final long m29631c() {
        return this.f22563c;
    }

    public final C6547y m29632d() {
        return this.f22561a;
    }

    public final Context m29633e() {
        return this.f22571l;
    }

    public final boolean m29634f() {
        return this.f22570k;
    }

    public final String m29635g() {
        try {
            JSONObject jSONObject = new JSONObject();
            m29628b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
