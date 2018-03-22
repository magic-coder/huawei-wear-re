package com.huawei.hwcommonmodel.p064d.p406a;

import android.Manifest.permission;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: PermissionsManager */
public class C4718b {
    private static final String f17259a = C4718b.class.getSimpleName();
    private static C4718b f17260e = null;
    private static final Object f17261f = new Object();
    private final Set<String> f17262b = new HashSet(1);
    private final Set<String> f17263c = new HashSet(1);
    private final List<WeakReference<C4719c>> f17264d = new ArrayList(1);

    public static C4718b m22594a() {
        C4718b c4718b;
        synchronized (f17261f) {
            if (f17260e == null) {
                f17260e = new C4718b();
            }
            c4718b = f17260e;
        }
        return c4718b;
    }

    private C4718b() {
        m22597b();
    }

    private void m22597b() {
        synchronized (f17261f) {
            for (Field field : permission.class.getFields()) {
                Object obj;
                try {
                    obj = (String) field.get("");
                } catch (Throwable e) {
                    Log.e(f17259a, "Could not access field", e);
                    obj = null;
                }
                this.f17263c.add(obj);
            }
        }
    }

    private void m22596a(@NonNull String[] strArr, @Nullable C4719c c4719c) {
        synchronized (f17261f) {
            if (c4719c == null) {
                return;
            }
            c4719c.m22606a(strArr);
            this.f17264d.add(new WeakReference(c4719c));
        }
    }

    private void m22595a(@Nullable C4719c c4719c) {
        synchronized (f17261f) {
            Iterator it = this.f17264d.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() == c4719c || weakReference.get() == null) {
                    it.remove();
                }
            }
        }
    }

    public boolean m22603a(@Nullable Context context, @NonNull String str) {
        boolean z;
        synchronized (f17261f) {
            if (context != null) {
                if (ActivityCompat.checkSelfPermission(context, str) == 0 || !this.f17263c.contains(str)) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m22600a(@android.support.annotation.Nullable android.app.Activity r5, @android.support.annotation.NonNull java.lang.String[] r6, @android.support.annotation.Nullable com.huawei.hwcommonmodel.p064d.p406a.C4719c r7) {
        /*
        r4 = this;
        r1 = f17261f;
        monitor-enter(r1);
        if (r5 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);	 Catch:{ all -> 0x0015 }
    L_0x0006:
        return;
    L_0x0007:
        r4.m22596a(r6, r7);	 Catch:{ all -> 0x0015 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0015 }
        r2 = 23;
        if (r0 >= r2) goto L_0x0018;
    L_0x0010:
        r4.m22598b(r5, r6, r7);	 Catch:{ all -> 0x0015 }
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0015 }
        goto L_0x0006;
    L_0x0015:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0015 }
        throw r0;
    L_0x0018:
        r2 = r4.m22599c(r5, r6, r7);	 Catch:{ all -> 0x0015 }
        r0 = r2.isEmpty();	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x0026;
    L_0x0022:
        r4.m22595a(r7);	 Catch:{ all -> 0x0015 }
        goto L_0x0013;
    L_0x0026:
        r0 = r2.size();	 Catch:{ all -> 0x0015 }
        r0 = new java.lang.String[r0];	 Catch:{ all -> 0x0015 }
        r0 = r2.toArray(r0);	 Catch:{ all -> 0x0015 }
        r0 = (java.lang.String[]) r0;	 Catch:{ all -> 0x0015 }
        r3 = r4.f17262b;	 Catch:{ all -> 0x0015 }
        r3.addAll(r2);	 Catch:{ all -> 0x0015 }
        r2 = 1;
        android.support.v4.app.ActivityCompat.requestPermissions(r5, r0, r2);	 Catch:{ all -> 0x0015 }
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwcommonmodel.d.a.b.a(android.app.Activity, java.lang.String[], com.huawei.hwcommonmodel.d.a.c):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m22601a(@android.support.annotation.NonNull android.support.v4.app.Fragment r5, @android.support.annotation.NonNull java.lang.String[] r6, @android.support.annotation.Nullable com.huawei.hwcommonmodel.p064d.p406a.C4719c r7) {
        /*
        r4 = this;
        r1 = f17261f;
        monitor-enter(r1);
        r0 = r5.getActivity();	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
    L_0x000a:
        return;
    L_0x000b:
        r4.m22596a(r6, r7);	 Catch:{ all -> 0x0019 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0019 }
        r3 = 23;
        if (r2 >= r3) goto L_0x001c;
    L_0x0014:
        r4.m22598b(r0, r6, r7);	 Catch:{ all -> 0x0019 }
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x000a;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r0;
    L_0x001c:
        r2 = r4.m22599c(r0, r6, r7);	 Catch:{ all -> 0x0019 }
        r0 = r2.isEmpty();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x002a;
    L_0x0026:
        r4.m22595a(r7);	 Catch:{ all -> 0x0019 }
        goto L_0x0017;
    L_0x002a:
        r0 = r2.size();	 Catch:{ all -> 0x0019 }
        r0 = new java.lang.String[r0];	 Catch:{ all -> 0x0019 }
        r0 = r2.toArray(r0);	 Catch:{ all -> 0x0019 }
        r0 = (java.lang.String[]) r0;	 Catch:{ all -> 0x0019 }
        r3 = r4.f17262b;	 Catch:{ all -> 0x0019 }
        r3.addAll(r2);	 Catch:{ all -> 0x0019 }
        r2 = 1;
        r5.requestPermissions(r0, r2);	 Catch:{ all -> 0x0019 }
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwcommonmodel.d.a.b.a(android.support.v4.app.Fragment, java.lang.String[], com.huawei.hwcommonmodel.d.a.c):void");
    }

    public void m22602a(@NonNull String[] strArr, @NonNull int[] iArr) {
        synchronized (f17261f) {
            int length;
            int length2 = strArr.length;
            if (iArr.length < length2) {
                length = iArr.length;
            } else {
                length = length2;
            }
            Iterator it = this.f17264d.iterator();
            while (it.hasNext()) {
                C4719c c4719c = (C4719c) ((WeakReference) it.next()).get();
                int i = 0;
                while (i < length) {
                    if (c4719c == null || c4719c.m22607a(strArr[i], iArr[i])) {
                        it.remove();
                        break;
                    }
                    i++;
                }
            }
            for (length2 = 0; length2 < length; length2++) {
                this.f17262b.remove(strArr[length2]);
            }
        }
    }

    private void m22598b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable C4719c c4719c) {
        for (String str : strArr) {
            if (c4719c != null) {
                if (!this.f17263c.contains(str)) {
                    c4719c.m22608a(str, C4717a.NOT_FOUND);
                } else if (ActivityCompat.checkSelfPermission(activity, str) != 0) {
                    c4719c.m22608a(str, C4717a.DENIED);
                } else {
                    c4719c.m22608a(str, C4717a.GRANTED);
                }
            }
        }
    }

    @NonNull
    private List<String> m22599c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable C4719c c4719c) {
        List<String> arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f17263c.contains(str)) {
                if (ActivityCompat.checkSelfPermission(activity, str) != 0) {
                    if (!this.f17262b.contains(str)) {
                        arrayList.add(str);
                    }
                } else if (c4719c != null) {
                    c4719c.m22608a(str, C4717a.GRANTED);
                }
            } else if (c4719c != null) {
                c4719c.m22608a(str, C4717a.NOT_FOUND);
            }
        }
        return arrayList;
    }
}
