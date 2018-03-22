package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class cd extends Fragment implements bn {
    private static WeakHashMap<FragmentActivity, WeakReference<cd>> f650a = new WeakHashMap();
    private Map<String, bm> f651b = new ArrayMap();
    private int f652c = 0;
    private Bundle f653d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.cd m1136a(android.support.v4.app.FragmentActivity r3) {
        /*
        r0 = f650a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.internal.cd) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getSupportFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "SupportLifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.internal.cd) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.internal.cd;
        r0.<init>();
        r1 = r3.getSupportFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "SupportLifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = f650a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cd.a(android.support.v4.app.FragmentActivity):com.google.android.gms.internal.cd");
    }

    private void m1138b(String str, @NonNull bm bmVar) {
        if (this.f652c > 0) {
            new Handler(Looper.getMainLooper()).post(new ce(this, bmVar, str));
        }
    }

    public /* synthetic */ Activity mo1843a() {
        return m1142b();
    }

    public <T extends bm> T mo1844a(String str, Class<T> cls) {
        return (bm) cls.cast(this.f651b.get(str));
    }

    public void mo1845a(String str, @NonNull bm bmVar) {
        if (this.f651b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f651b.put(str, bmVar);
        m1138b(str, bmVar);
    }

    public FragmentActivity m1142b() {
        return getActivity();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (bm a : this.f651b.values()) {
            a.mo1801a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (bm a : this.f651b.values()) {
            a.mo1796a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f652c = 1;
        this.f653d = bundle;
        for (Entry entry : this.f651b.entrySet()) {
            ((bm) entry.getValue()).mo1797a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f652c = 4;
        for (bm g : this.f651b.values()) {
            g.m858g();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f651b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((bm) entry.getValue()).mo1799b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.f652c = 2;
        for (bm a : this.f651b.values()) {
            a.mo1795a();
        }
    }

    public void onStop() {
        super.onStop();
        this.f652c = 3;
        for (bm b : this.f651b.values()) {
            b.mo1798b();
        }
    }
}
