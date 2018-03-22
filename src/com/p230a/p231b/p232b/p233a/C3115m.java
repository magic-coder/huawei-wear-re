package com.p230a.p231b.p232b.p233a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public abstract class C3115m implements Comparable {
    private int f10436a = -1;
    private final ac f10437b;
    private final int f10438c;
    private final String f10439d;
    private final int f10440e;
    private final C3070q f10441f;
    private Integer f10442g;
    private C3117o f10443h;
    private boolean f10444i;
    private boolean f10445j;
    private boolean f10446k;
    private long f10447l;
    private C3106t f10448m;
    private C3104c f10449n;

    public C3115m(int i, String str, C3070q c3070q) {
        this.f10437b = ac.f10404a ? new ac() : null;
        this.f10444i = true;
        this.f10445j = false;
        this.f10446k = false;
        this.f10447l = 0;
        this.f10449n = null;
        this.f10438c = i;
        this.f10439d = str;
        this.f10441f = c3070q;
        m13871a(new C3107e());
        this.f10440e = TextUtils.isEmpty(str) ? 0 : Uri.parse(str).getHost().hashCode();
    }

    private static byte[] m13862a(Map map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public int m13864a(C3115m c3115m) {
        C3116n q = m13892q();
        C3116n q2 = c3115m.m13892q();
        return q == q2 ? this.f10442g.intValue() - c3115m.f10442g.intValue() : q2.ordinal() - q.ordinal();
    }

    protected abstract C3118p mo3662a(C3112j c3112j);

    protected C3102w m13866a(C3102w c3102w) {
        return c3102w;
    }

    public Map mo3663a() {
        return Collections.emptyMap();
    }

    public final void m13868a(int i) {
        this.f10442g = Integer.valueOf(i);
    }

    public void m13869a(C3104c c3104c) {
        this.f10449n = c3104c;
    }

    public void m13870a(C3117o c3117o) {
        this.f10443h = c3117o;
    }

    public void m13871a(C3106t c3106t) {
        this.f10448m = c3106t;
    }

    protected abstract void mo3664a(Object obj);

    public void m13873a(String str) {
        if (ac.f10404a) {
            this.f10437b.m13843a(str, Thread.currentThread().getId());
        } else if (this.f10447l == 0) {
            this.f10447l = SystemClock.elapsedRealtime();
        }
    }

    public final void m13874a(boolean z) {
        this.f10444i = z;
    }

    public String mo3665b() {
        return "application/x-www-form-urlencoded; charset=" + m13890o();
    }

    public void m13876b(C3102w c3102w) {
        if (this.f10441f != null) {
            this.f10441f.mo3640a(c3102w);
        }
    }

    final void m13877b(String str) {
        if (this.f10443h != null) {
            this.f10443h.m13900b(this);
        }
        if (ac.f10404a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new ab(this, str, id));
                return;
            }
            this.f10437b.m13843a(str, id);
            this.f10437b.m13842a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f10447l >= 3000) {
            C3121x.m13907b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f10447l), toString());
        }
    }

    public byte[] mo3666c() {
        Map n = m13889n();
        return (n == null || n.size() <= 0) ? null : C3115m.m13862a(n, m13890o());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return m13864a((C3115m) obj);
    }

    public int m13879d() {
        return this.f10438c;
    }

    public int m13880e() {
        return this.f10440e;
    }

    public String m13881f() {
        return this.f10439d;
    }

    public String m13882g() {
        return m13881f();
    }

    public C3104c m13883h() {
        return this.f10449n;
    }

    public boolean m13884i() {
        return this.f10445j;
    }

    protected Map m13885j() {
        return m13889n();
    }

    protected String m13886k() {
        return m13890o();
    }

    public String m13887l() {
        return mo3665b();
    }

    public byte[] m13888m() {
        Map j = m13885j();
        return (j == null || j.size() <= 0) ? null : C3115m.m13862a(j, m13886k());
    }

    protected Map m13889n() {
        return null;
    }

    protected String m13890o() {
        return GameManager.DEFAULT_CHARSET;
    }

    public final boolean m13891p() {
        return this.f10444i;
    }

    public C3116n m13892q() {
        return C3116n.NORMAL;
    }

    public final int m13893r() {
        return this.f10448m.mo3656a();
    }

    public C3106t m13894s() {
        return this.f10448m;
    }

    public void m13895t() {
        this.f10446k = true;
    }

    public final String toString() {
        return new StringBuilder(String.valueOf(this.f10445j ? "[X] " : "[ ] ")).append(m13881f()).append(HwAccountConstants.BLANK).append("0x" + Integer.toHexString(m13880e())).append(HwAccountConstants.BLANK).append(m13892q()).append(HwAccountConstants.BLANK).append(this.f10442g).toString();
    }

    public boolean m13896u() {
        return this.f10446k;
    }
}
