package com.fenda.hwbracelet.p257a;

import com.fenda.hwbracelet.mode.C3629l;
import com.fenda.p255a.p256a.C3569e;
import com.huawei.p032e.p264a.p265a.p385a.C4383a;
import com.huawei.p032e.p264a.p265a.p385a.C4384b;
import com.huawei.p032e.p264a.p386b.C4389a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: SyncDataParserUtils */
public class C3574d {
    private static C3574d f13675h;
    private List<C3576f> f13676a = new ArrayList();
    private ArrayList<C4384b> f13677b = new ArrayList();
    private ArrayList<C4383a> f13678c = new ArrayList();
    private Calendar f13679d = Calendar.getInstance();
    private C3575e f13680e;
    private int f13681f;
    private C3577g f13682g;

    public void m17941a(java.util.ArrayList<com.fenda.hwbracelet.mode.C3629l> r7, com.huawei.p032e.p264a.p386b.C4389a r8, int r9, int r10) {
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
        r0 = r6.f13677b;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        if (r0 == 0) goto L_0x0009;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
    L_0x0004:
        r0 = r6.f13677b;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r0.clear();	 Catch:{ Exception -> 0x004f, all -> 0x009e }
    L_0x0009:
        r0 = r6.f13678c;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        if (r0 == 0) goto L_0x0012;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
    L_0x000d:
        r0 = r6.f13678c;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r0.clear();	 Catch:{ Exception -> 0x004f, all -> 0x009e }
    L_0x0012:
        r0 = com.fenda.hwbracelet.p257a.C3572b.m17927a(r7, r9, r10);	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r6.f13677b = r0;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r0 = com.fenda.hwbracelet.p257a.C3572b.m17926a(r7);	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r6.f13678c = r0;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        if (r7 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
    L_0x0020:
        r7.clear();	 Catch:{ Exception -> 0x004f, all -> 0x009e }
    L_0x0023:
        if (r8 == 0) goto L_0x002c;
    L_0x0025:
        r0 = r6.f13677b;
        r1 = r6.f13678c;
        r8.mo4599a(r0, r1);
    L_0x002c:
        r0 = r6.f13677b;
        if (r0 == 0) goto L_0x003d;
    L_0x0030:
        r0 = r6.f13677b;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x003d;
    L_0x0038:
        r0 = r6.f13677b;
        r0.clear();
    L_0x003d:
        r0 = r6.f13678c;
        if (r0 == 0) goto L_0x004e;
    L_0x0041:
        r0 = r6.f13678c;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x004e;
    L_0x0049:
        r0 = r6.f13678c;
        r0.clear();
    L_0x004e:
        return;
    L_0x004f:
        r0 = move-exception;
        r1 = "SyncDataParserUtils";	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r2 = 1;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r3 = 0;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r4.<init>();	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r5 = "parseDatabaseRecord Exception: ";	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r0 = r0.toString();	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        r2[r3] = r0;	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        com.huawei.v.c.c(r1, r2);	 Catch:{ Exception -> 0x004f, all -> 0x009e }
        if (r8 == 0) goto L_0x007b;
    L_0x0074:
        r0 = r6.f13677b;
        r1 = r6.f13678c;
        r8.mo4599a(r0, r1);
    L_0x007b:
        r0 = r6.f13677b;
        if (r0 == 0) goto L_0x008c;
    L_0x007f:
        r0 = r6.f13677b;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x008c;
    L_0x0087:
        r0 = r6.f13677b;
        r0.clear();
    L_0x008c:
        r0 = r6.f13678c;
        if (r0 == 0) goto L_0x004e;
    L_0x0090:
        r0 = r6.f13678c;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x004e;
    L_0x0098:
        r0 = r6.f13678c;
        r0.clear();
        goto L_0x004e;
    L_0x009e:
        r0 = move-exception;
        if (r8 == 0) goto L_0x00a8;
    L_0x00a1:
        r1 = r6.f13677b;
        r2 = r6.f13678c;
        r8.mo4599a(r1, r2);
    L_0x00a8:
        r1 = r6.f13677b;
        if (r1 == 0) goto L_0x00b9;
    L_0x00ac:
        r1 = r6.f13677b;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x00b9;
    L_0x00b4:
        r1 = r6.f13677b;
        r1.clear();
    L_0x00b9:
        r1 = r6.f13678c;
        if (r1 == 0) goto L_0x00ca;
    L_0x00bd:
        r1 = r6.f13678c;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x00ca;
    L_0x00c5:
        r1 = r6.f13678c;
        r1.clear();
    L_0x00ca:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fenda.hwbracelet.a.d.a(java.util.ArrayList, com.huawei.e.a.b.a, int, int):void");
    }

    public C3574d() {
        f13675h = this;
    }

    public static C3574d m17934a() {
        if (f13675h == null) {
            f13675h = new C3574d();
        }
        return f13675h;
    }

    public static void m17936b() {
        f13675h = new C3574d();
    }

    public boolean m17943a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            C2538c.e("SyncDataParserUtils", new Object[]{"single data is NULL"});
            return false;
        }
        int length = bArr.length;
        C2538c.c("SyncDataParserUtils", new Object[]{"length: " + length});
        if (length <= 0 || length % 8 != 0) {
            C2538c.e("SyncDataParserUtils", new Object[]{"single data len is wrong"});
            return false;
        }
        while (i < bArr.length) {
            m17937b(Arrays.copyOfRange(bArr, i, i + 8));
            i += 8;
        }
        return true;
    }

    public void m17940a(C4389a c4389a, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f13676a.size(); i3++) {
            long a = ((C3576f) this.f13676a.get(i3)).m17945a().m17944a();
            if (a > 1404057600000L) {
                int i4;
                C2538c.c("SyncDataParserUtils", new Object[]{i3 + "--time: " + a});
                int b = ((C3576f) this.f13676a.get(i3)).m17946b();
                if (((C3576f) this.f13676a.get(i3)).m17947c() == C3577g.SLEEP_DATA) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                arrayList.add(new C3629l(a, b, i4));
            }
        }
        this.f13676a.clear();
        if (C3569e.m17917a(null) != null && arrayList.size() > 0) {
            C3569e.m17917a(null).m17920a(arrayList, ((C3629l) arrayList.get(0)).m18198a(), ((C3629l) arrayList.get(arrayList.size() - 1)).m18198a());
        }
    }

    private void m17937b(byte[] bArr) {
        if (bArr.length == 8) {
            int c = m17938c(Arrays.copyOfRange(bArr, 0, 2));
            int c2 = m17938c(Arrays.copyOfRange(bArr, 2, 3));
            int c3 = m17938c(Arrays.copyOfRange(bArr, 3, 4));
            int c4 = m17938c(Arrays.copyOfRange(bArr, 4, 5));
            int c5 = m17938c(Arrays.copyOfRange(bArr, 5, 6));
            if (m17935a(c, c2, c3, c4, c5)) {
                this.f13680e = new C3575e(c, c2, c3, c4, c5, 0);
                this.f13681f = ((bArr[6] & 127) << 8) + (bArr[7] & 255);
                if (this.f13681f > 0) {
                    c.c("SyncDataParserUtils", new Object[]{"Steps: " + this.f13681f});
                }
                if ((bArr[6] & 128) > 0) {
                    this.f13682g = C3577g.SLEEP_DATA;
                } else {
                    this.f13682g = C3577g.SPORT_DATA;
                }
                this.f13676a.add(new C3576f(this.f13680e, this.f13681f, this.f13682g));
            }
        }
    }

    private boolean m17935a(int i, int i2, int i3, int i4, int i5) {
        Calendar instance = Calendar.getInstance();
        try {
            instance.set(i, i2, i3, i4, i5);
            if (instance.getTimeInMillis() >= 1388419200000L) {
                return true;
            }
        } catch (Exception e) {
            C2538c.c("SyncDataParserUtils", new Object[]{"isDateFormat Exception: " + e.getMessage()});
        }
        C2538c.e("SyncDataParserUtils", new Object[]{"Time error! y:" + i + ", m: " + i2 + ", d:" + i3 + ", h: " + i4 + ", min: " + i5});
        return false;
    }

    private int m17938c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                if ((bArr[i2] & (1 << i3)) > 0) {
                    i += 1 << ((((bArr.length - i2) - 1) * 8) + i3);
                }
            }
        }
        return i;
    }

    public boolean m17942a(C4389a c4389a, byte[] bArr, int i, int i2) {
        int i3 = 0;
        C2538c.c("SyncDataParserUtils", new Object[]{"UpdateDateLength: " + bArr.length});
        if (bArr.length != 8 && bArr.length != 12) {
            return false;
        }
        int c = m17938c(Arrays.copyOfRange(bArr, 0, 2));
        int c2 = m17938c(Arrays.copyOfRange(bArr, 2, 3));
        int c3 = m17938c(Arrays.copyOfRange(bArr, 3, 4));
        int c4 = m17938c(Arrays.copyOfRange(bArr, 4, 5));
        int c5 = m17938c(Arrays.copyOfRange(bArr, 5, 6));
        if (!m17935a(c, c2, c3, c4, c5)) {
            return false;
        }
        long a = m17939a(c, c2, c3, c4, c5, 0);
        if (a <= 1404057600000L) {
            return true;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 6, 8);
        c.c("SyncDataParserUtils", new Object[]{"steps: " + (((copyOfRange[0] & 127) << 8) + (copyOfRange[1] & 255))});
        if ((copyOfRange[0] & 128) > 0) {
            i3 = 1;
        }
        C3629l c3629l = new C3629l(a, c, i3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c3629l);
        if (C3569e.m17917a(null) != null) {
            C3569e.m17917a(null).m17920a(arrayList, a, a);
        }
        return true;
    }

    public long m17939a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f13679d.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.f13679d.set(i, i2 - 1, i3, i4, i5, 0);
        this.f13679d.add(12, i6);
        return (this.f13679d.getTimeInMillis() / FileWatchdog.DEFAULT_DELAY) * FileWatchdog.DEFAULT_DELAY;
    }
}
