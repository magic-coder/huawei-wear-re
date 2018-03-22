package com.huawei.openalliance.ad.p112a.p124i.p126a;

import android.os.Handler;
import android.os.Looper;

public class C1293a {
    private C1296h f2740a = null;
    private boolean f2741b = true;
    private Handler f2742c = new Handler(Looper.getMainLooper());
    private C1292a f2743d = new C1292a();

    class C1292a implements Runnable {
        final /* synthetic */ C1293a f2739a;

        private C1292a(C1293a c1293a) {
            this.f2739a = c1293a;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
            r0 = r6.f2739a;
            r0 = r0.f2740a;
            r0 = r0.mo2446e();
            r1 = r6.f2739a;
            r1 = r1.f2743d;
            monitor-enter(r1);
            r2 = r6.f2739a;	 Catch:{ all -> 0x003c }
            r2 = r2.f2741b;	 Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x003a;
        L_0x0019:
            if (r0 >= 0) goto L_0x001d;
        L_0x001b:
            monitor-exit(r1);	 Catch:{ all -> 0x003c }
        L_0x001c:
            return;
        L_0x001d:
            r2 = "GifAnim";
            r3 = 1;
            r3 = new java.lang.String[r3];	 Catch:{ all -> 0x003c }
            r4 = 0;
            r5 = "scheduler";
            r3[r4] = r5;	 Catch:{ all -> 0x003c }
            com.huawei.openalliance.ad.utils.p129b.C1336d.m5886b(r2, r3);	 Catch:{ all -> 0x003c }
            r2 = r6.f2739a;	 Catch:{ all -> 0x003c }
            r2 = r2.f2742c;	 Catch:{ all -> 0x003c }
            r3 = r6.f2739a;	 Catch:{ all -> 0x003c }
            r3 = r3.f2743d;	 Catch:{ all -> 0x003c }
            r4 = (long) r0;	 Catch:{ all -> 0x003c }
            r2.postDelayed(r3, r4);	 Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r1);	 Catch:{ all -> 0x003c }
            goto L_0x001c;
        L_0x003c:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003c }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.i.a.a.a.run():void");
        }
    }

    public C1293a(C1296h c1296h) {
        this.f2740a = c1296h;
    }

    public boolean m5740a() {
        return this.f2741b;
    }

    public void m5741b() {
        synchronized (this.f2743d) {
            this.f2742c.removeCallbacks(this.f2743d);
            this.f2741b = true;
        }
    }

    public void m5742c() {
        if (this.f2740a != null) {
            synchronized (this.f2743d) {
                this.f2741b = false;
                this.f2742c.post(this.f2743d);
            }
        }
    }

    public void m5743d() {
        m5741b();
        this.f2740a = null;
    }
}
