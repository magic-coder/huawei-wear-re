package com.huawei.multisimsdk.multidevicemanager.p105e;

import android.os.Handler;

/* compiled from: AsyncHttpUtils */
class C1178c implements Runnable {
    Handler f2585a;
    C1141i f2586b;
    String f2587c;
    String f2588d;
    final /* synthetic */ C1176a f2589e;

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r1 = 0;
        r0 = com.huawei.multisimsdk.multidevicemanager.p105e.C1180e.m5274a();	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        r2 = r6.f2587c;	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        r3 = r6.f2588d;	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        r0 = r0.m5277a(r2, r3);	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        if (r0 == 0) goto L_0x001d;
    L_0x000f:
        r1 = r6.f2585a;
        r2 = new com.huawei.multisimsdk.multidevicemanager.e.b;
        r3 = r6.f2589e;
        r4 = r6.f2586b;
        r2.<init>(r3, r0, r4);
        r1.post(r2);
    L_0x001d:
        return;
    L_0x001e:
        r0 = move-exception;
        r0 = "AsyncHttpUtils";	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        r2 = "doPostRequest->NoSuchAlgorithmException";	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        com.huawei.multisimsdk.multidevicemanager.p105e.C1183h.m5286d(r0, r2);	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        if (r1 == 0) goto L_0x001d;
    L_0x0028:
        r0 = r6.f2585a;
        r2 = new com.huawei.multisimsdk.multidevicemanager.e.b;
        r3 = r6.f2589e;
        r4 = r6.f2586b;
        r2.<init>(r3, r1, r4);
        r0.post(r2);
        goto L_0x001d;
    L_0x0037:
        r0 = move-exception;
        r0 = "AsyncHttpUtils";	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        r2 = "doPostRequest->KeyManagementException";	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        com.huawei.multisimsdk.multidevicemanager.p105e.C1183h.m5286d(r0, r2);	 Catch:{ NoSuchAlgorithmException -> 0x001e, KeyManagementException -> 0x0037, all -> 0x0050 }
        if (r1 == 0) goto L_0x001d;
    L_0x0041:
        r0 = r6.f2585a;
        r2 = new com.huawei.multisimsdk.multidevicemanager.e.b;
        r3 = r6.f2589e;
        r4 = r6.f2586b;
        r2.<init>(r3, r1, r4);
        r0.post(r2);
        goto L_0x001d;
    L_0x0050:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0061;
    L_0x0053:
        r2 = r6.f2585a;
        r3 = new com.huawei.multisimsdk.multidevicemanager.e.b;
        r4 = r6.f2589e;
        r5 = r6.f2586b;
        r3.<init>(r4, r1, r5);
        r2.post(r3);
    L_0x0061:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.multisimsdk.multidevicemanager.e.c.run():void");
    }

    C1178c(C1176a c1176a, Handler handler, String str, String str2, C1141i c1141i) {
        this.f2589e = c1176a;
        this.f2585a = handler;
        this.f2587c = str;
        this.f2588d = str2;
        this.f2586b = c1141i;
    }
}
