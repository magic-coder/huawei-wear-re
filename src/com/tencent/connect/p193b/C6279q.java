package com.tencent.connect.p193b;

import android.os.SystemClock;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p542b.C6378g;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6279q implements C6252b {
    String f21840a;
    String f21841b;
    final /* synthetic */ C6273k f21842c;
    private String f21843d;
    private C6252b f21844e;

    public C6279q(C6273k c6273k, String str, String str2, String str3, C6252b c6252b) {
        this.f21842c = c6273k;
        this.f21843d = str;
        this.f21840a = str2;
        this.f21841b = str3;
        this.f21844e = c6252b;
    }

    private void m28834a(String str) {
        try {
            mo5288a(C6412y.m29260d(str));
        } catch (JSONException e) {
            e.printStackTrace();
            mo5287a(new C6494d(-4, "服务器返回数据格式有误!", str));
        }
    }

    public void mo5288a(Object obj) {
        obj = (JSONObject) obj;
        C6378g.m29155a().m29159a(this.f21843d + "_H5", SystemClock.elapsedRealtime(), 0, 0, obj.optInt("ret", -6), this.f21840a, false);
        if (this.f21844e != null) {
            this.f21844e.mo5288a(obj);
            this.f21844e = null;
        }
    }

    public void mo5287a(C6494d c6494d) {
        String str = c6494d.f22558b != null ? c6494d.f22558b + this.f21840a : this.f21840a;
        C6378g.m29155a().m29159a(this.f21843d + "_H5", SystemClock.elapsedRealtime(), 0, 0, c6494d.f22557a, str, false);
        this.f21842c.m28807a(str);
        if (this.f21844e != null) {
            this.f21844e.mo5287a(c6494d);
            this.f21844e = null;
        }
    }

    public void mo5286a() {
        if (this.f21844e != null) {
            this.f21844e.mo5286a();
            this.f21844e = null;
        }
    }
}
