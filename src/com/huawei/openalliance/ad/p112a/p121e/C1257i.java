package com.huawei.openalliance.ad.p112a.p121e;

import android.content.Context;
import com.huawei.openalliance.ad.utils.db.bean.MaterialRecord;

public class C1257i implements Runnable {
    private Context f2670a;
    private MaterialRecord f2671b;
    private String f2672c;

    public C1257i(Context context, MaterialRecord materialRecord, String str) {
        this.f2670a = context;
        this.f2671b = materialRecord;
        this.f2672c = str;
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r0 = r9.f2670a;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = r9.f2671b;
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r9.f2672c;
        r0 = com.huawei.openalliance.ad.utils.C1365i.m6081a(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r1 = 0;
        r2 = com.huawei.openalliance.ad.p112a.p122h.C1287e.m5689d();	 Catch:{ all -> 0x007d }
        r0 = r9.f2670a;	 Catch:{ all -> 0x007d }
        r1 = com.huawei.openalliance.ad.utils.db.C1357a.m5982a(r0);	 Catch:{ all -> 0x007d }
        r0 = new android.content.ContentValues;	 Catch:{ all -> 0x007d }
        r0.<init>();	 Catch:{ all -> 0x007d }
        r4 = "displayCount";	 Catch:{ all -> 0x007d }
        r5 = r9.f2671b;	 Catch:{ all -> 0x007d }
        r5 = r5.m6045l();	 Catch:{ all -> 0x007d }
        r5 = r5 + 1;	 Catch:{ all -> 0x007d }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x007d }
        r0.put(r4, r5);	 Catch:{ all -> 0x007d }
        r4 = "isPriority";	 Catch:{ all -> 0x007d }
        r5 = 1;	 Catch:{ all -> 0x007d }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x007d }
        r0.put(r4, r5);	 Catch:{ all -> 0x007d }
        r4 = "lastShowTime";	 Catch:{ all -> 0x007d }
        r5 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x007d }
        r0.put(r4, r5);	 Catch:{ all -> 0x007d }
        r4 = r9.f2672c;	 Catch:{ all -> 0x007d }
        r5 = "materialId = ?";	 Catch:{ all -> 0x007d }
        r6 = 1;	 Catch:{ all -> 0x007d }
        r6 = new java.lang.String[r6];	 Catch:{ all -> 0x007d }
        r7 = 0;	 Catch:{ all -> 0x007d }
        r8 = r9.f2671b;	 Catch:{ all -> 0x007d }
        r8 = r8.m6022d();	 Catch:{ all -> 0x007d }
        r6[r7] = r8;	 Catch:{ all -> 0x007d }
        r1.m5986a(r4, r0, r5, r6);	 Catch:{ all -> 0x007d }
        r0.clear();	 Catch:{ all -> 0x007d }
        r4 = "lastShowTime";	 Catch:{ all -> 0x007d }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x007d }
        r0.put(r4, r2);	 Catch:{ all -> 0x007d }
        r2 = r9.f2672c;	 Catch:{ all -> 0x007d }
        r3 = "taskId = ?";	 Catch:{ all -> 0x007d }
        r4 = 1;	 Catch:{ all -> 0x007d }
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x007d }
        r5 = 0;	 Catch:{ all -> 0x007d }
        r6 = r9.f2671b;	 Catch:{ all -> 0x007d }
        r6 = r6.m6026e();	 Catch:{ all -> 0x007d }
        r4[r5] = r6;	 Catch:{ all -> 0x007d }
        r1.m5986a(r2, r0, r3, r4);	 Catch:{ all -> 0x007d }
        if (r1 == 0) goto L_0x0010;
    L_0x0079:
        r1.close();
        goto L_0x0010;
    L_0x007d:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0083;
    L_0x0080:
        r1.close();
    L_0x0083:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.a.e.i.run():void");
    }
}
