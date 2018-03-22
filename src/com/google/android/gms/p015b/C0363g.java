package com.google.android.gms.p015b;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

class C0363g<TResult> {
    private final Object f254a = new Object();
    private Queue<C0360f<TResult>> f255b;
    private boolean f256c;

    C0363g() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m316a(@android.support.annotation.NonNull com.google.android.gms.p015b.C0358b<TResult> r3) {
        /*
        r2 = this;
        r1 = r2.f254a;
        monitor-enter(r1);
        r0 = r2.f255b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f256c;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.f256c = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        r1 = r2.f254a;
        monitor-enter(r1);
        r0 = r2.f255b;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (com.google.android.gms.p015b.C0360f) r0;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0029;
    L_0x001e:
        r0 = 0;
        r2.f256c = r0;	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0.mo1737a(r3);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.g.a(com.google.android.gms.b.b):void");
    }

    public void m317a(@NonNull C0360f<TResult> c0360f) {
        synchronized (this.f254a) {
            if (this.f255b == null) {
                this.f255b = new ArrayDeque();
            }
            this.f255b.add(c0360f);
        }
    }
}
