package cn.com.xy.sms.sdk.p208d;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.p211c.C2953t;
import java.util.Map;

final class C2971n implements C2904g {
    private final /* synthetic */ boolean f10059a;
    private final /* synthetic */ Map f10060b;
    private final /* synthetic */ C2953t f10061c;
    private final /* synthetic */ C2904g f10062d;

    C2971n(boolean z, Map map, C2953t c2953t, C2904g c2904g) {
        this.f10059a = z;
        this.f10060b = map;
        this.f10061c = c2953t;
        this.f10062d = c2904g;
    }

    public final void execute(java.lang.Object... r13) {
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
        r12 = this;
        if (r13 == 0) goto L_0x0101;
    L_0x0002:
        r0 = 0;
        r0 = r13[r0];	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "0";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        if (r0 == 0) goto L_0x0295;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x0011:
        r0 = r13.length;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = 2;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        if (r0 != r1) goto L_0x0295;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x0015:
        r0 = 1;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r13[r0];	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = cn.com.xy.sms.sdk.p208d.C2970m.m13338a(r0);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = "解析响应回来的报文 info=";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.append(r0);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        if (r0 == 0) goto L_0x0230;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x002d:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = "response MenuInfo";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.<init>(r4);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.append(r0);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r0.f10025b;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        if (r1 != 0) goto L_0x0172;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x0043:
        r1 = r0.f10026c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        if (r1 != 0) goto L_0x0172;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x004b:
        r1 = r0.f10025b;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r4.f10025b;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r1.equals(r4);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        if (r1 != 0) goto L_0x0172;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x0057:
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r0.f10026c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10026c = r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10027d = r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r0.f10025b;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10025b = r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = 0;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10028e = r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r0.f10029f;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r4 + r2;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10029f = r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r0.f10030g;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2 + r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10030g = r2;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r0.f10024a;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r1.f10025b;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.f10026c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r3.f10027d;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = r3.f10028e;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r6 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r6 = r6.f10029f;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r8 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r8 = r8.f10030g;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10.<init>();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r11 = "version";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10.put(r11, r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "url";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10.put(r1, r2);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "status";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10.put(r1, r2);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "update_time";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10.put(r1, r2);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "delaystart";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10.put(r1, r2);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "delayend";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r10.put(r1, r2);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "tb_menu_list";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = "name = ? ";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = 1;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = 0;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3[r4] = r0;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r1, r10, r2, r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x00fa:
        r0 = r12.f10062d;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "1";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p229l.C3050o.m13669a(r0, r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x0101:
        r0 = r12.f10059a;
        if (r0 == 0) goto L_0x011e;
    L_0x0105:
        r0 = cn.com.xy.sms.sdk.p207c.C2917a.m13105a();
        r1 = "AUTO_UPDATE_DATA";
        r0 = cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13283c(r0, r1);
        if (r0 != 0) goto L_0x011e;
    L_0x0111:
        r0 = r12.f10060b;
        r0 = cn.com.xy.sms.sdk.p216h.C2996a.m13494a(r0);
        if (r0 == 0) goto L_0x011e;
    L_0x0119:
        r0 = r12.f10061c;
        cn.com.xy.sms.sdk.p208d.C2970m.m13343b(r0);
    L_0x011e:
        return;
    L_0x011f:
        r0 = move-exception;
        r1 = "XIAOYUAN";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = "updateMenuInfo: ";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = r0.getMessage();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        goto L_0x00fa;
    L_0x013a:
        r0 = move-exception;
        r1 = "XIAOYUAN";	 Catch:{ all -> 0x01f6 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01f6 }
        r3 = "updateMenuInfo: ";	 Catch:{ all -> 0x01f6 }
        r2.<init>(r3);	 Catch:{ all -> 0x01f6 }
        r3 = r0.getMessage();	 Catch:{ all -> 0x01f6 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x01f6 }
        r2 = r2.toString();	 Catch:{ all -> 0x01f6 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);	 Catch:{ all -> 0x01f6 }
        r0 = r12.f10059a;
        if (r0 == 0) goto L_0x011e;
    L_0x0158:
        r0 = cn.com.xy.sms.sdk.p207c.C2917a.m13105a();
        r1 = "AUTO_UPDATE_DATA";
        r0 = cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13283c(r0, r1);
        if (r0 != 0) goto L_0x011e;
    L_0x0164:
        r0 = r12.f10060b;
        r0 = cn.com.xy.sms.sdk.p216h.C2996a.m13494a(r0);
        if (r0 == 0) goto L_0x011e;
    L_0x016c:
        r0 = r12.f10061c;
        cn.com.xy.sms.sdk.p208d.C2970m.m13343b(r0);
        goto L_0x011e;
    L_0x0172:
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r0.f10029f;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r4 + r2;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10029f = r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r0.f10030g;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2 + r4;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1.f10030g = r2;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r0.f10024a;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r1.f10029f;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r4 = r1.f10030g;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0215 }
        r1.<init>();	 Catch:{ Throwable -> 0x0215 }
        r6 = "update_time";	 Catch:{ Throwable -> 0x0215 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0215 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0215 }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x0215 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x0215 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0215 }
        r1.put(r6, r7);	 Catch:{ Throwable -> 0x0215 }
        r6 = "delaystart";	 Catch:{ Throwable -> 0x0215 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0215 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x0215 }
        r7.<init>(r2);	 Catch:{ Throwable -> 0x0215 }
        r2 = r7.toString();	 Catch:{ Throwable -> 0x0215 }
        r1.put(r6, r2);	 Catch:{ Throwable -> 0x0215 }
        r2 = "delayend";	 Catch:{ Throwable -> 0x0215 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0215 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x0215 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0215 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0215 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x0215 }
        r2 = "tb_menu_list";	 Catch:{ Throwable -> 0x0215 }
        r3 = "name = ? ";	 Catch:{ Throwable -> 0x0215 }
        r4 = 1;	 Catch:{ Throwable -> 0x0215 }
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x0215 }
        r5 = 0;	 Catch:{ Throwable -> 0x0215 }
        r4[r5] = r0;	 Catch:{ Throwable -> 0x0215 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r2, r1, r3, r4);	 Catch:{ Throwable -> 0x0215 }
    L_0x01da:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r1.f10024a;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "和服务器算法一样，无需更新";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0.append(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r12.f10062d;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "0";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p229l.C3050o.m13669a(r0, r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        goto L_0x0101;
    L_0x01f6:
        r0 = move-exception;
        r1 = r12.f10059a;
        if (r1 == 0) goto L_0x0214;
    L_0x01fb:
        r1 = cn.com.xy.sms.sdk.p207c.C2917a.m13105a();
        r2 = "AUTO_UPDATE_DATA";
        r1 = cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13283c(r1, r2);
        if (r1 != 0) goto L_0x0214;
    L_0x0207:
        r1 = r12.f10060b;
        r1 = cn.com.xy.sms.sdk.p216h.C2996a.m13494a(r1);
        if (r1 == 0) goto L_0x0214;
    L_0x020f:
        r1 = r12.f10061c;
        cn.com.xy.sms.sdk.p208d.C2970m.m13343b(r1);
    L_0x0214:
        throw r0;
    L_0x0215:
        r0 = move-exception;
        r1 = "XIAOYUAN";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = "updateTime: ";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = r0.getMessage();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        goto L_0x01da;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x0230:
        r0 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r0.f10024a;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x027a }
        r1.<init>();	 Catch:{ Throwable -> 0x027a }
        r2 = "update_time";	 Catch:{ Throwable -> 0x027a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x027a }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x027a }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x027a }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x027a }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x027a }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x027a }
        r2 = "tb_menu_list";	 Catch:{ Throwable -> 0x027a }
        r3 = "name = ? ";	 Catch:{ Throwable -> 0x027a }
        r4 = 1;	 Catch:{ Throwable -> 0x027a }
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x027a }
        r5 = 0;	 Catch:{ Throwable -> 0x027a }
        r4[r5] = r0;	 Catch:{ Throwable -> 0x027a }
        cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r2, r1, r3, r4);	 Catch:{ Throwable -> 0x027a }
    L_0x025e:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r12.f10061c;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = r1.f10024a;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "和服务器算法一样，无需更新";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0.append(r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r0 = r12.f10062d;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "0";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p229l.C3050o.m13669a(r0, r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        goto L_0x0101;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x027a:
        r0 = move-exception;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "XIAOYUAN";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = "updateTime: ";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r3 = r0.getMessage();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        goto L_0x025e;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
    L_0x0295:
        r0 = r12.f10062d;	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        r1 = "-2";	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        cn.com.xy.sms.sdk.p229l.C3050o.m13669a(r0, r1);	 Catch:{ Throwable -> 0x011f, Throwable -> 0x013a }
        goto L_0x0101;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.n.execute(java.lang.Object[]):void");
    }
}
