package com.huawei.common.applog;

import android.util.Log;
import com.huawei.common.applog.bean.C4348a;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: AppLogManager */
public final class C4347a {
    private static C4347a f16162a = new C4347a();
    private static final Object f16163j = new Object();
    private String f16164b;
    private int f16165c = -1;
    private int f16166d = -1;
    private boolean f16167e = false;
    private BlockingQueue<C4348a> f16168f = new ArrayBlockingQueue(256);
    private C4344a f16169g = new C4344a(this);
    private boolean f16170h = false;
    private boolean f16171i = false;

    /* compiled from: AppLogManager */
    class C4344a extends Thread {
        final /* synthetic */ C4347a f16138a;

        C4344a(C4347a c4347a) {
            this.f16138a = c4347a;
        }

        public void run() {
            C4347a c4347a = this.f16138a;
            try {
                C4354c.m20927a(c4347a.f16165c, c4347a.f16164b, c4347a.f16166d, true);
            } catch (IOException e) {
                Log.i("AppLogManager", "LogWrite init IOException");
            }
            while (c4347a.f16170h) {
                try {
                    C4348a c4348a;
                    if (this.f16138a.f16167e) {
                        c4348a = (C4348a) c4347a.f16168f.poll();
                        if (c4348a != null) {
                            C4354c.m20929a(c4348a.m20908a(), c4348a.m20909b(), c4348a.m20910c(), null);
                            C4354c.m20926a();
                        } else {
                            Log.i("AppLogManager", "PrintWoker poll timeout , shutdown");
                            C4354c.m20926a();
                            c4348a = (C4348a) c4347a.f16168f.take();
                            C4354c.m20929a(c4348a.m20908a(), c4348a.m20909b(), c4348a.m20910c(), null);
                            C4354c.m20926a();
                        }
                    } else {
                        c4348a = (C4348a) c4347a.f16168f.poll(60, TimeUnit.SECONDS);
                        if (c4348a != null) {
                            C4354c.m20929a(c4348a.m20908a(), c4348a.m20909b(), c4348a.m20910c(), null);
                        } else {
                            Log.i("AppLogManager", "PrintWoker poll timeout , shutdown");
                            C4354c.m20929a("I", "AppLogManager", "PrintWoker poll timeout , shutdown", null);
                            C4354c.m20926a();
                            c4348a = (C4348a) c4347a.f16168f.take();
                            C4354c.m20929a(c4348a.m20908a(), c4348a.m20909b(), c4348a.m20910c(), null);
                        }
                    }
                } catch (InterruptedException e2) {
                    Log.i("AppLogManager", "PrintWoker InterruptedException");
                } catch (Exception e3) {
                    Log.i("AppLogManager", "PrintWoker IllegalMonitorStateException");
                } catch (Error e4) {
                    Log.i("AppLogManager", "PrintWoker Error");
                }
            }
            Log.i("AppLogManager", "PrintWoker end.");
            C4354c.m20929a("I", "AppLogManager", "PrintWoker end.", null);
            C4354c.m20926a();
            this.f16138a.f16170h = false;
        }
    }

    private C4347a() {
        Log.i("AppLogManager", "AppLogManager onCreate");
    }

    public static C4347a m20898a() {
        return f16162a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m20906a(android.content.Context r4, int r5, java.lang.String r6, int r7, boolean r8) {
        /*
        r3 = this;
        r1 = f16163j;
        monitor-enter(r1);
        r0 = r3.f16171i;	 Catch:{ all -> 0x004f }
        if (r0 != 0) goto L_0x0055;
    L_0x0007:
        r0 = "AppLogManager";
        r2 = "first init";
        android.util.Log.i(r0, r2);	 Catch:{ all -> 0x004f }
        r0 = 1;
        r3.f16171i = r0;	 Catch:{ all -> 0x004f }
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x004f }
        if (r0 == 0) goto L_0x0052;
    L_0x0017:
        if (r4 == 0) goto L_0x001f;
    L_0x0019:
        r0 = r4.getFilesDir();	 Catch:{ all -> 0x004f }
        if (r0 != 0) goto L_0x0021;
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
    L_0x0020:
        return;
    L_0x0021:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004f }
        r0.<init>();	 Catch:{ all -> 0x004f }
        r2 = r4.getFilesDir();	 Catch:{ all -> 0x004f }
        r2 = r2.getPath();	 Catch:{ all -> 0x004f }
        r0 = r0.append(r2);	 Catch:{ all -> 0x004f }
        r2 = java.io.File.separator;	 Catch:{ all -> 0x004f }
        r0 = r0.append(r2);	 Catch:{ all -> 0x004f }
        r2 = "feedbacklogs";
        r0 = r0.append(r2);	 Catch:{ all -> 0x004f }
        r0 = r0.toString();	 Catch:{ all -> 0x004f }
        r3.f16164b = r0;	 Catch:{ all -> 0x004f }
    L_0x0044:
        r3.f16165c = r5;	 Catch:{ all -> 0x004f }
        r3.f16166d = r7;	 Catch:{ all -> 0x004f }
        r3.f16167e = r8;	 Catch:{ all -> 0x004f }
        r3.m20901b();	 Catch:{ all -> 0x004f }
    L_0x004d:
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        goto L_0x0020;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        throw r0;
    L_0x0052:
        r3.f16164b = r6;	 Catch:{ all -> 0x004f }
        goto L_0x0044;
    L_0x0055:
        r0 = "AppLogManager";
        r2 = "already init";
        android.util.Log.i(r0, r2);	 Catch:{ all -> 0x004f }
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.common.applog.a.a(android.content.Context, int, java.lang.String, int, boolean):void");
    }

    private void m20901b() {
        try {
            if (!this.f16170h) {
                Log.i("AppLogManager", "worker start");
                this.f16170h = true;
                this.f16169g.start();
            }
        } catch (IllegalThreadStateException e) {
            Log.i("AppLogManager", "worker IllegalThreadStateException");
            this.f16170h = false;
        } catch (Exception e2) {
            Log.i("AppLogManager", "worker IllegalThreadStateException");
            this.f16170h = false;
        }
    }

    public boolean m20907a(C4348a c4348a) {
        return this.f16168f.offer(c4348a);
    }
}
