package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.MessageQueue;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.huawei.android.pushagent.b.a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p020b.C0647a;

public class C0654b extends Thread {
    public Handler f1180a;
    private MessageQueue f1181b;
    private WakeLock f1182c = ((PowerManager) this.f1183d.getSystemService("power")).newWakeLock(1, "eventLooper");
    private Context f1183d;

    public C0654b(Context context) {
        super("ReceiverDispatcher");
        this.f1183d = context;
    }

    public void m2500a(C0647a c0647a, Intent intent) {
        if (this.f1180a == null) {
            C0657e.m2522d("PushLogAC2712", "ReceiverDispatcher: the handler is null");
            PushService.m2356a().stopService();
            return;
        }
        try {
            if (!this.f1182c.isHeld()) {
                this.f1182c.acquire();
            }
            if (!this.f1180a.postDelayed(new a(this, c0647a, intent), 1)) {
                C0657e.m2520c("PushLogAC2712", "postDelayed runnable error");
                throw new Exception("postDelayed runnable error");
            }
        } catch (Throwable e) {
            try {
                C0657e.m2521c("PushLogAC2712", "dispatchIntent error", e);
                if (this.f1182c.isHeld()) {
                    C0657e.m2517b("PushLogAC2712", "release wakelock after dispatchIntent error");
                    this.f1182c.release();
                }
            } catch (Throwable e2) {
                C0657e.m2521c("PushLogAC2712", "release eventLooper wakelock error", e2);
            }
        }
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        android.os.Looper.prepare();	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0 = new android.os.Handler;	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0.<init>();	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r2.f1180a = r0;	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0 = android.os.Looper.myQueue();	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r2.f1181b = r0;	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0 = r2.f1181b;	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r1 = new com.huawei.android.pushagent.c;	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0.addIdleHandler(r1);	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        android.os.Looper.loop();	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0 = r2.f1182c;
        if (r0 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r2.f1182c;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x002e;
    L_0x0029:
        r0 = r2.f1182c;
        r0.release();
    L_0x002e:
        return;
    L_0x002f:
        r0 = move-exception;
        r1 = "PushLogAC2712";	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0 = com.huawei.android.pushagent.p018c.p019a.C0657e.m2509a(r0);	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        com.huawei.android.pushagent.p018c.p019a.C0657e.m2522d(r1, r0);	 Catch:{ Throwable -> 0x002f, all -> 0x004b }
        r0 = r2.f1182c;
        if (r0 == 0) goto L_0x002e;
    L_0x003d:
        r0 = r2.f1182c;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x002e;
    L_0x0045:
        r0 = r2.f1182c;
        r0.release();
        goto L_0x002e;
    L_0x004b:
        r0 = move-exception;
        r1 = r2.f1182c;
        if (r1 == 0) goto L_0x005d;
    L_0x0050:
        r1 = r2.f1182c;
        r1 = r1.isHeld();
        if (r1 == 0) goto L_0x005d;
    L_0x0058:
        r1 = r2.f1182c;
        r1.release();
    L_0x005d:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.run():void");
    }
}
