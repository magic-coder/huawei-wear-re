package com.tencent.open;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p542b.C6378g;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6416e implements C6252b {
    String f22274a;
    String f22275b;
    private WeakReference<Context> f22276c;
    private String f22277d;
    private C6252b f22278e;

    public C6416e(Context context, String str, String str2, String str3, C6252b c6252b) {
        this.f22276c = new WeakReference(context);
        this.f22277d = str;
        this.f22274a = str2;
        this.f22275b = str3;
        this.f22278e = c6252b;
    }

    private void m29273a(String str) {
        try {
            mo5288a(C6412y.m29260d(str));
        } catch (JSONException e) {
            e.printStackTrace();
            mo5287a(new C6494d(-4, "服务器返回数据格式有误!", str));
        }
    }

    public void mo5288a(Object obj) {
        obj = (JSONObject) obj;
        C6378g.m29155a().m29159a(this.f22277d + "_H5", SystemClock.elapsedRealtime(), 0, 0, obj.optInt("ret", -6), this.f22274a, false);
        if (this.f22278e != null) {
            this.f22278e.mo5288a(obj);
            this.f22278e = null;
        }
    }

    public void mo5287a(C6494d c6494d) {
        C6378g.m29155a().m29159a(this.f22277d + "_H5", SystemClock.elapsedRealtime(), 0, 0, c6494d.f22557a, c6494d.f22558b != null ? c6494d.f22558b + this.f22274a : this.f22274a, false);
        if (this.f22278e != null) {
            this.f22278e.mo5287a(c6494d);
            this.f22278e = null;
        }
    }

    public void mo5286a() {
        if (this.f22278e != null) {
            this.f22278e.mo5286a();
            this.f22278e = null;
        }
    }
}
