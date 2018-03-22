package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: GoogleAnalytics */
public class ao extends bi {
    private static ao f14126h;
    private boolean f14127a;
    private C3647h f14128b;
    private Context f14129c;
    private bh f14130d;
    private volatile Boolean f14131e;
    private final Map<String, bh> f14132f;
    private as f14133g;

    protected ao(Context context) {
        this(context, ai.m18218a(context));
    }

    private ao(Context context, C3647h c3647h) {
        this.f14131e = Boolean.valueOf(false);
        this.f14132f = new HashMap();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.f14129c = context.getApplicationContext();
        this.f14128b = c3647h;
        C3657i.m18354a(this.f14129c);
        bb.m18313a(this.f14129c);
        C3658j.m18359a(this.f14129c);
        this.f14133g = new C3660m();
    }

    public static ao m18247a(Context context) {
        ao aoVar;
        synchronized (ao.class) {
            if (f14126h == null) {
                f14126h = new ao(context);
            }
            aoVar = f14126h;
        }
        return aoVar;
    }

    static ao m18246a() {
        ao aoVar;
        synchronized (ao.class) {
            aoVar = f14126h;
        }
        return aoVar;
    }

    public void m18251a(boolean z) {
        am.m18240a().m18241a(an.SET_DRY_RUN);
        this.f14127a = z;
    }

    public boolean m18252b() {
        am.m18240a().m18241a(an.GET_DRY_RUN);
        return this.f14127a;
    }

    public bh m18249a(String str, String str2) {
        bh bhVar;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Tracker name cannot be empty");
            }
            bhVar = (bh) this.f14132f.get(str);
            if (bhVar == null) {
                bhVar = new bh(str, str2, this);
                this.f14132f.put(str, bhVar);
                if (this.f14130d == null) {
                    this.f14130d = bhVar;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                bhVar.m18337a("&tid", str2);
            }
            am.m18240a().m18241a(an.GET_TRACKER);
        }
        return bhVar;
    }

    public bh m18248a(String str) {
        return m18249a(str, str);
    }

    void mo4238a(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            bj.m18342a(map, "&ul", bj.m18340a(Locale.getDefault()));
            bj.m18342a(map, "&sr", bb.m18312a().mo4248a("&sr"));
            map.put("&_u", am.m18240a().m18244c());
            am.m18240a().m18243b();
            this.f14128b.mo4234a(map);
        }
    }

    public boolean m18253c() {
        am.m18240a().m18241a(an.GET_APP_OPT_OUT);
        return this.f14131e.booleanValue();
    }

    public as m18254d() {
        return this.f14133g;
    }
}
