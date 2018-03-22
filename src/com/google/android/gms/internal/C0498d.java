package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.C0467l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class C0498d implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final C0498d f678a = new C0498d();
    private final AtomicBoolean f679b = new AtomicBoolean();
    private final AtomicBoolean f680c = new AtomicBoolean();
    private final ArrayList<C0495e> f681d = new ArrayList();
    private boolean f682e = false;

    private C0498d() {
    }

    public static C0498d m1183a() {
        return f678a;
    }

    public static void m1184a(Application application) {
        synchronized (f678a) {
            if (!f678a.f682e) {
                application.registerActivityLifecycleCallbacks(f678a);
                application.registerComponentCallbacks(f678a);
                f678a.f682e = true;
            }
        }
    }

    private void m1185b(boolean z) {
        synchronized (f678a) {
            Iterator it = this.f681d.iterator();
            while (it.hasNext()) {
                ((C0495e) it.next()).mo1834a(z);
            }
        }
    }

    public void m1186a(C0495e c0495e) {
        synchronized (f678a) {
            this.f681d.add(c0495e);
        }
    }

    @TargetApi(16)
    public boolean m1187a(boolean z) {
        if (!this.f680c.get()) {
            if (!C0467l.m827c()) {
                return z;
            }
            RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f680c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f679b.set(true);
            }
        }
        return m1188b();
    }

    public boolean m1188b() {
        return this.f679b.get();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f679b.compareAndSet(true, false);
        this.f680c.set(true);
        if (compareAndSet) {
            m1185b(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f679b.compareAndSet(true, false);
        this.f680c.set(true);
        if (compareAndSet) {
            m1185b(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.f679b.compareAndSet(false, true)) {
            this.f680c.set(true);
            m1185b(true);
        }
    }
}
