package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: EasyTracker */
public class C0338p extends bh {
    private static C0338p f200a;
    private static String f201b;
    private final ao f202c;
    private boolean f203d;
    private boolean f204e;
    private int f205f;
    private long f206g;
    private long f207h;
    private Context f208i;
    private final Map<String, String> f209j;
    private av f210k;
    private bd f211l;
    private l f212m;
    private Timer f213n;
    private TimerTask f214o;
    private boolean f215p;
    private boolean f216q;

    private C0338p(Context context) {
        this(context, new aw(context), ao.a(context), C0339w.m259a(), null);
    }

    private C0338p(Context context, av avVar, ao aoVar, bd bdVar, bi biVar) {
        String str = "easy_tracker";
        if (biVar == null) {
            biVar = aoVar;
        }
        super(str, null, biVar);
        this.f204e = false;
        this.f205f = 0;
        this.f209j = new HashMap();
        this.f215p = false;
        this.f216q = false;
        if (f201b != null) {
            avVar.d(f201b);
        }
        this.f202c = aoVar;
        m249a(context, avVar, bdVar);
        this.f212m = new q(this);
    }

    public static C0338p m248a(Context context) {
        if (f200a == null) {
            f200a = new C0338p(context);
        }
        return f200a;
    }

    boolean m256a() {
        return this.f206g == 0 || (this.f206g > 0 && this.f212m.a() > this.f207h + this.f206g);
    }

    private void m252c() {
        ar.c("Starting EasyTracker.");
        String a = this.f210k.a("ga_trackingId");
        if (TextUtils.isEmpty(a)) {
            a = this.f210k.a("ga_api_key");
        }
        a("&tid", a);
        ar.c("[EasyTracker] trackingId loaded: " + a);
        a = this.f210k.a("ga_appName");
        if (!TextUtils.isEmpty(a)) {
            ar.c("[EasyTracker] app name loaded: " + a);
            a("&an", a);
        }
        a = this.f210k.a("ga_appVersion");
        if (a != null) {
            ar.c("[EasyTracker] app version loaded: " + a);
            a("&av", a);
        }
        a = this.f210k.a("ga_logLevel");
        if (a != null) {
            at a2 = m247a(a);
            if (a2 != null) {
                ar.c("[EasyTracker] log level loaded: " + a2);
                this.f202c.d().a(a2);
            }
        }
        Double b = this.f210k.b("ga_sampleFrequency");
        if (b == null) {
            b = new Double((double) this.f210k.a("ga_sampleRate", 100));
        }
        if (b.doubleValue() != 100.0d) {
            a("&sf", Double.toString(b.doubleValue()));
        }
        ar.c("[EasyTracker] sample rate loaded: " + b);
        int a3 = this.f210k.a("ga_dispatchPeriod", 1800);
        ar.c("[EasyTracker] dispatch period loaded: " + a3);
        this.f211l.mo1733a(a3);
        this.f206g = (long) (this.f210k.a("ga_sessionTimeout", 30) * 1000);
        ar.c("[EasyTracker] session timeout loaded: " + this.f206g);
        boolean z = this.f210k.c("ga_autoActivityTracking") || this.f210k.c("ga_auto_activity_tracking");
        this.f204e = z;
        ar.c("[EasyTracker] auto activity tracking loaded: " + this.f204e);
        z = this.f210k.c("ga_anonymizeIp");
        if (z) {
            a("&aip", "1");
            ar.c("[EasyTracker] anonymize ip loaded: " + z);
        }
        this.f203d = this.f210k.c("ga_reportUncaughtExceptions");
        if (this.f203d) {
            Thread.setDefaultUncaughtExceptionHandler(new t(this, this.f211l, Thread.getDefaultUncaughtExceptionHandler(), this.f208i));
            ar.c("[EasyTracker] report uncaught exceptions loaded: " + this.f203d);
        }
        this.f202c.a(this.f210k.c("ga_dryRun"));
    }

    private at m247a(String str) {
        try {
            return at.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private void m249a(Context context, av avVar, bd bdVar) {
        if (context == null) {
            ar.a("Context cannot be null");
        }
        this.f208i = context.getApplicationContext();
        this.f211l = bdVar;
        this.f210k = avVar;
        m252c();
    }

    public void m254a(Activity activity) {
        am.a().a(an.ai);
        m253d();
        if (!this.f215p && this.f205f == 0 && m256a()) {
            this.f216q = true;
        }
        this.f215p = true;
        this.f205f++;
        if (this.f204e) {
            Map hashMap = new HashMap();
            hashMap.put("&t", "appview");
            am.a().a(true);
            a("&cd", m251c(activity));
            m255a(hashMap);
            am.a().a(false);
        }
    }

    public void m258b(Activity activity) {
        am.a().a(an.aj);
        this.f205f--;
        this.f205f = Math.max(0, this.f205f);
        this.f207h = this.f212m.a();
        if (this.f205f == 0) {
            m253d();
            this.f214o = new r(this, null);
            this.f213n = new Timer("waitForActivityStart");
            this.f213n.schedule(this.f214o, 1000);
        }
    }

    @Deprecated
    public void m257b() {
        this.f211l.mo1735c();
    }

    private synchronized void m253d() {
        if (this.f213n != null) {
            this.f213n.cancel();
            this.f213n = null;
        }
    }

    private String m251c(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        if (this.f209j.containsKey(canonicalName)) {
            return (String) this.f209j.get(canonicalName);
        }
        String a = this.f210k.a(canonicalName);
        if (a == null) {
            a = canonicalName;
        }
        this.f209j.put(canonicalName, a);
        return a;
    }

    public void m255a(Map<String, String> map) {
        if (this.f216q) {
            map.put("&sc", "start");
            this.f216q = false;
        }
        super.a(map);
    }
}
