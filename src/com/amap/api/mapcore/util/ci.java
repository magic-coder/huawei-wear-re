package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public class ci {
    static final String f11609a = "/a/";
    static final String f11610b = "b";
    static final String f11611c = "c";
    static final String f11612d = "d";

    /* compiled from: Log */
    final class C33071 implements Runnable {
        final /* synthetic */ int f11603a;
        final /* synthetic */ Context f11604b;
        final /* synthetic */ Throwable f11605c;
        final /* synthetic */ String f11606d;
        final /* synthetic */ String f11607e;

        C33071(int i, Context context, Throwable th, String str, String str2) {
            this.f11603a = i;
            this.f11604b = context;
            this.f11605c = th;
            this.f11606d = str;
            this.f11607e = str2;
        }

        public void run() {
            try {
                cl a = cl.m15857a(this.f11603a);
                if (a != null) {
                    a.m15873a(this.f11604b, this.f11605c, this.f11606d, this.f11607e);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Log */
    final class C33082 implements Runnable {
        final /* synthetic */ Context f11608a;

        C33082(Context context) {
            this.f11608a = context;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r0 = 0;
            r1 = r7.f11608a;	 Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0035, all -> 0x0055 }
            r2 = 0;
            r2 = com.amap.api.mapcore.util.cj.m15838a(r1, r2);	 Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0035, all -> 0x0055 }
            r1 = r7.f11608a;	 Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x0092, all -> 0x007b }
            r3 = 1;
            r1 = com.amap.api.mapcore.util.cj.m15838a(r1, r3);	 Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x0092, all -> 0x007b }
            r3 = r7.f11608a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x0099, all -> 0x0082 }
            r4 = 2;
            r0 = com.amap.api.mapcore.util.cj.m15838a(r3, r4);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x0099, all -> 0x0082 }
            r3 = r7.f11608a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r2.m15850b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r3 = r7.f11608a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r1.m15850b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r3 = r7.f11608a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r0.m15850b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            if (r2 == 0) goto L_0x002a;
        L_0x0027:
            r2.m15851c();
        L_0x002a:
            if (r1 == 0) goto L_0x002f;
        L_0x002c:
            r1.m15851c();
        L_0x002f:
            if (r0 == 0) goto L_0x0034;
        L_0x0031:
            r0.m15851c();
        L_0x0034:
            return;
        L_0x0035:
            r1 = move-exception;
            r2 = r0;
            r3 = r0;
            r6 = r1;
            r1 = r0;
            r0 = r6;
        L_0x003b:
            r4 = "Log";
            r5 = "processLog";
            com.amap.api.mapcore.util.ca.m15831a(r0, r4, r5);	 Catch:{ all -> 0x0090 }
            r0.printStackTrace();	 Catch:{ all -> 0x0090 }
            if (r3 == 0) goto L_0x004a;
        L_0x0047:
            r3.m15851c();
        L_0x004a:
            if (r2 == 0) goto L_0x004f;
        L_0x004c:
            r2.m15851c();
        L_0x004f:
            if (r1 == 0) goto L_0x0034;
        L_0x0051:
            r1.m15851c();
            goto L_0x0034;
        L_0x0055:
            r1 = move-exception;
            r2 = r0;
            r3 = r0;
            r6 = r1;
            r1 = r0;
            r0 = r6;
        L_0x005b:
            if (r3 == 0) goto L_0x0060;
        L_0x005d:
            r3.m15851c();
        L_0x0060:
            if (r2 == 0) goto L_0x0065;
        L_0x0062:
            r2.m15851c();
        L_0x0065:
            if (r1 == 0) goto L_0x006a;
        L_0x0067:
            r1.m15851c();
        L_0x006a:
            throw r0;
        L_0x006b:
            r1 = move-exception;
            r1 = r0;
            r2 = r0;
        L_0x006e:
            if (r2 == 0) goto L_0x0073;
        L_0x0070:
            r2.m15851c();
        L_0x0073:
            if (r1 == 0) goto L_0x0078;
        L_0x0075:
            r1.m15851c();
        L_0x0078:
            if (r0 == 0) goto L_0x0034;
        L_0x007a:
            goto L_0x0031;
        L_0x007b:
            r1 = move-exception;
            r3 = r2;
            r2 = r0;
            r6 = r0;
            r0 = r1;
            r1 = r6;
            goto L_0x005b;
        L_0x0082:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x005b;
        L_0x0089:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x005b;
        L_0x0090:
            r0 = move-exception;
            goto L_0x005b;
        L_0x0092:
            r1 = move-exception;
            r3 = r2;
            r2 = r0;
            r6 = r0;
            r0 = r1;
            r1 = r6;
            goto L_0x003b;
        L_0x0099:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x003b;
        L_0x00a0:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x003b;
        L_0x00a7:
            r1 = move-exception;
            r1 = r0;
            goto L_0x006e;
        L_0x00aa:
            r3 = move-exception;
            goto L_0x006e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ci.2.run():void");
        }
    }

    static void m15903a(Context context, Throwable th, int i, String str, String str2) {
        try {
            ExecutorService a = ca.m15830a();
            if (a != null && !a.isShutdown()) {
                a.submit(new C33071(i, context, th, str, str2));
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    static void m15902a(Context context) {
        try {
            cl a = cl.m15857a(2);
            if (a != null) {
                a.m15872a(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static void m15904b(Context context) {
        try {
            ExecutorService a = ca.m15830a();
            if (a != null && !a.isShutdown()) {
                a.submit(new C33082(context));
            }
        } catch (Throwable th) {
            ca.m15831a(th, "Log", "processLog");
            th.printStackTrace();
        }
    }
}
