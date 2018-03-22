package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class bo extends Fragment implements bn {
    private static WeakHashMap<Activity, WeakReference<bo>> f618a = new WeakHashMap();
    private Map<String, bm> f619b = new ArrayMap();
    private int f620c = 0;
    private Bundle f621d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.bo m1102a(android.app.Activity r3) {
        /*
        r0 = f618a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.internal.bo) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "LifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.internal.bo) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.internal.bo;
        r0.<init>();
        r1 = r3.getFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "LifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = f618a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.bo.a(android.app.Activity):com.google.android.gms.internal.bo");
    }

    private void m1104b(String str, @NonNull bm bmVar) {
        if (this.f620c > 0) {
            new Handler(Looper.getMainLooper()).post(new bp(this, bmVar, str));
        }
    }

    public Activity mo1843a() {
        return getActivity();
    }

    public <T extends bm> T mo1844a(String str, Class<T> cls) {
        return (bm) cls.cast(this.f619b.get(str));
    }

    public void mo1845a(String str, @NonNull bm bmVar) {
        if (this.f619b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f619b.put(str, bmVar);
        m1104b(str, bmVar);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (bm a : this.f619b.values()) {
            a.mo1801a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (bm a : this.f619b.values()) {
            a.mo1796a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f620c = 1;
        this.f621d = bundle;
        for (Entry entry : this.f619b.entrySet()) {
            ((bm) entry.getValue()).mo1797a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f620c = 4;
        for (bm g : this.f619b.values()) {
            g.m858g();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f619b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((bm) entry.getValue()).mo1799b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.f620c = 2;
        for (bm a : this.f619b.values()) {
            a.mo1795a();
        }
    }

    public void onStop() {
        super.onStop();
        this.f620c = 3;
        for (bm b : this.f619b.values()) {
            b.mo1798b();
        }
    }
}
