package cn.com.xy.sms.sdk.p229l;

import android.os.Process;

public class C3052q implements Runnable {
    private boolean f10300a;

    public void mo3635a() {
    }

    public boolean mo3636b() {
        return false;
    }

    public void m13689e() {
        Thread.currentThread().setPriority(1);
        Process.setThreadPriority(10);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r5 = this;
        r4 = 0;
        r0 = r5.f10300a;	 Catch:{ Throwable -> 0x002b }
        if (r0 == 0) goto L_0x0008;
    L_0x0005:
        r5.f10300a = r4;
    L_0x0007:
        return;
    L_0x0008:
        monitor-enter(r5);	 Catch:{ Throwable -> 0x002b }
        r0 = r5.f10300a;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0011;
    L_0x000d:
        monitor-exit(r5);	 Catch:{ all -> 0x0028 }
        r5.f10300a = r4;
        goto L_0x0007;
    L_0x0011:
        r0 = 1;
        r5.f10300a = r0;	 Catch:{ all -> 0x0028 }
        monitor-exit(r5);	 Catch:{ all -> 0x0028 }
        r5.m13689e();	 Catch:{ Throwable -> 0x002b }
        r0 = 2;
        r0 = cn.com.xy.sms.sdk.p216h.C2996a.m13492a(r0);	 Catch:{ Throwable -> 0x002b }
        if (r0 == 0) goto L_0x0025;
    L_0x001f:
        r0 = r5.mo3636b();	 Catch:{ Throwable -> 0x002b }
        if (r0 == 0) goto L_0x0047;
    L_0x0025:
        r5.f10300a = r4;
        goto L_0x0007;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ Throwable -> 0x002b }
        throw r0;	 Catch:{ Throwable -> 0x002b }
    L_0x002b:
        r0 = move-exception;
        r1 = "XIAOYUAN";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004d }
        r3 = "BaseRunnable run error:";
        r2.<init>(r3);	 Catch:{ all -> 0x004d }
        r3 = r0.getMessage();	 Catch:{ all -> 0x004d }
        r2 = r2.append(r3);	 Catch:{ all -> 0x004d }
        r2 = r2.toString();	 Catch:{ all -> 0x004d }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);	 Catch:{ all -> 0x004d }
        r5.f10300a = r4;
        goto L_0x0007;
    L_0x0047:
        r5.mo3635a();	 Catch:{ Throwable -> 0x002b }
        r5.f10300a = r4;
        goto L_0x0007;
    L_0x004d:
        r0 = move-exception;
        r5.f10300a = r4;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.l.q.run():void");
    }
}
