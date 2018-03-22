package com.huawei.hwdatamigrate.hihealth.p416h;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.p395a.C4548a;
import com.huawei.hihealth.data.p396c.C4556c;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hihealth.p394c.C4542d;
import com.huawei.hihealth.p394c.C4545g;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwdatamigrate.hihealth.a.a;
import com.huawei.hwdatamigrate.hihealth.p067c.C4865v;
import com.huawei.hwdatamigrate.hihealth.p068d.C4877i;
import com.huawei.hwdatamigrate.hihealth.p068d.C4880l;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.hwdatamigrate.hihealth.p416h.p417a.C4907a;
import com.huawei.hwdatamigrate.hihealth.p416h.p417a.C4910d;
import com.huawei.hwdatamigrate.hihealth.p416h.p417a.C4913g;
import com.huawei.hwdatamigrate.hihealth.p416h.p417a.C4915i;
import com.huawei.hwdatamigrate.hihealth.p416h.p417a.C4918l;
import com.huawei.hwdatamigrate.hihealth.p416h.p417a.C4921o;
import com.huawei.hwdatamigrate.hihealth.p416h.p418b.C4926a;
import com.huawei.hwdatamigrate.hihealth.p416h.p418b.C4927b;
import com.huawei.hwdatamigrate.hihealth.p416h.p418b.C4928c;
import com.huawei.hwdatamigrate.hihealth.p416h.p418b.C4929d;
import com.huawei.hwdatamigrate.hihealth.p416h.p418b.C4930e;
import com.huawei.hwdatamigrate.hihealth.p416h.p418b.C4931g;
import com.huawei.hwdatamigrate.hihealth.p419i.C4939b;
import com.huawei.p190v.C2538c;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import org.apache.log4j.helpers.UtilLoggingLevel;

/* compiled from: HiHealthDataInsertStore */
public class C4924a {
    private static Context f17976a;
    private C4865v f17977b;
    private C4910d f17978c;
    private C4918l f17979d;
    private C4915i f17980e;
    private C4921o f17981f;
    private C4907a f17982g;
    private C4913g f17983h;
    private C4930e f17984i;
    private C4929d f17985j;
    private C4931g f17986k;
    private C4927b f17987l;
    private C4926a f17988m;
    private C4928c f17989n;
    private C4883o f17990o;
    private C4880l f17991p;
    private ExecutorService f17992q;
    private Queue<HiHealthData> f17993r;
    private BlockingQueue<HiHealthData> f17994s;

    public int m23753a(java.util.List<com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a> r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:29:? in {14, 20, 22, 25, 26, 27, 28, 30, 31} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r9 = 2;
        r8 = 1;
        r2 = 0;
        if (r11 == 0) goto L_0x000b;
    L_0x0005:
        r0 = r11.isEmpty();
        if (r0 == 0) goto L_0x0019;
    L_0x000b:
        r0 = "HiH_HiHealthDataInsertStore";
        r1 = new java.lang.Object[r8];
        r3 = "transferHealthStatData statTables is null";
        r1[r2] = r3;
        com.huawei.v.c.d(r0, r1);
        r1 = 7;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = "HiH_HiHealthDataInsertStore";
        r1 = new java.lang.Object[r9];
        r3 = "transferHealthStatData() statTables size = ";
        r1[r2] = r3;
        r3 = r11.size();
        r3 = java.lang.Integer.valueOf(r3);
        r1[r8] = r3;
        com.huawei.v.c.b(r0, r1);
        r4 = java.lang.System.currentTimeMillis();
        r0 = f17976a;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r0 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r0);	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r0.m23022a();	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r3 = r11.iterator();	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r1 = r2;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
    L_0x0041:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        if (r0 == 0) goto L_0x0058;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
    L_0x0047:
        r0 = r3.next();	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r0 = (com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a) r0;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r6 = r10.f17977b;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r0 = r6.m23618a(r0);	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        if (r0 != 0) goto L_0x00a7;
    L_0x0055:
        r0 = 4;
    L_0x0056:
        r1 = r0;
        goto L_0x0041;
    L_0x0058:
        r0 = f17976a;
        r0 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r0);
        r0.m23023b();
    L_0x0061:
        r0 = "HiH_HiHealthDataInsertStore";
        r3 = new java.lang.Object[r9];
        r6 = "transferHealthStatData() end totalTime = ";
        r3[r2] = r6;
        r6 = java.lang.System.currentTimeMillis();
        r4 = r6 - r4;
        r2 = java.lang.Long.valueOf(r4);
        r3[r8] = r2;
        com.huawei.v.c.b(r0, r3);
        goto L_0x0018;
    L_0x007a:
        r0 = move-exception;
        r1 = "HiH_HiHealthDataInsertStore";	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r3 = 2;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r6 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r7 = "transferHealthStatData e is ";	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r3[r6] = r7;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r6 = 1;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r3[r6] = r0;	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        com.huawei.v.c.d(r1, r3);	 Catch:{ Exception -> 0x007a, all -> 0x009c }
        r1 = 11;
        r0 = f17976a;
        r0 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r0);
        r0.m23023b();
        goto L_0x0061;
    L_0x009c:
        r0 = move-exception;
        r1 = f17976a;
        r1 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r1);
        r1.m23023b();
        throw r0;
    L_0x00a7:
        r0 = r1;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwdatamigrate.hihealth.h.a.a(java.util.List):int");
    }

    public int m23754a(java.util.List<com.huawei.hihealth.HiHealthData> r14, int r15) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:35:? in {19, 25, 27, 30, 31, 32, 33, 34, 36, 37} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r13 = this;
        r12 = 2;
        r11 = 1;
        r7 = 0;
        if (r14 == 0) goto L_0x000d;
    L_0x0005:
        r0 = r14.isEmpty();
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        if (r15 > 0) goto L_0x001b;
    L_0x000d:
        r0 = "HiH_HiHealthDataInsertStore";
        r1 = new java.lang.Object[r11];
        r2 = "saveSyncHealthDetailData datas is null or who <= 0";
        r1[r7] = r2;
        com.huawei.v.c.d(r0, r1);
        r6 = 7;
    L_0x001a:
        return r6;
    L_0x001b:
        r0 = "HiH_HiHealthDataInsertStore";
        r1 = new java.lang.Object[r12];
        r2 = "saveSyncHealthDetailData() datas size is = ";
        r1[r7] = r2;
        r2 = r14.size();
        r2 = java.lang.Integer.valueOf(r2);
        r1[r11] = r2;
        com.huawei.v.c.b(r0, r1);
        r8 = java.lang.System.currentTimeMillis();
        r0 = r13.f17991p;
        r3 = r0.m23646a(r15);
        r0 = "HiH_HiHealthDataInsertStore";
        r1 = new java.lang.Object[r12];
        r2 = "saveSyncHealthDetailData() clients = ";
        r1[r7] = r2;
        r1[r11] = r3;
        com.huawei.v.c.b(r0, r1);
        if (r3 == 0) goto L_0x0051;
    L_0x004b:
        r0 = r3.isEmpty();
        if (r0 == 0) goto L_0x0060;
    L_0x0051:
        r0 = "HiH_HiHealthDataInsertStore";
        r1 = new java.lang.Object[r11];
        r2 = "saveSyncHealthDetailData() null == clients ||clients.isEmpty ()";
        r1[r7] = r2;
        com.huawei.v.c.e(r0, r1);
        r6 = 10;
        goto L_0x001a;
    L_0x0060:
        r0 = f17976a;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r0 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r0);	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r0.m23022a();	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r10 = r14.iterator();	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r6 = r7;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
    L_0x006e:
        r0 = r10.hasNext();	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        if (r0 == 0) goto L_0x008e;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
    L_0x0074:
        r1 = r10.next();	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r1 = (com.huawei.hihealth.HiHealthData) r1;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r2 = r1.getClientID();	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r0 = 1;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r1.setSyncStatus(r0);	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r5 = 0;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r0 = r13;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r4 = r15;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r0 = r0.m23748a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        if (r0 != 0) goto L_0x00dd;
    L_0x008b:
        r0 = 4;
    L_0x008c:
        r6 = r0;
        goto L_0x006e;
    L_0x008e:
        r0 = f17976a;
        r0 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r0);
        r0.m23023b();
    L_0x0097:
        r0 = "HiH_HiHealthDataInsertStore";
        r1 = new java.lang.Object[r12];
        r2 = "saveSyncHealthDetailData() end totalTime = ";
        r1[r7] = r2;
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r8;
        r2 = java.lang.Long.valueOf(r2);
        r1[r11] = r2;
        com.huawei.v.c.b(r0, r1);
        goto L_0x001a;
    L_0x00b0:
        r0 = move-exception;
        r1 = "HiH_HiHealthDataInsertStore";	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r2 = 2;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r3 = 0;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r4 = "saveSyncHealthDetailData e is ";	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r3 = 1;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r2[r3] = r0;	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        com.huawei.v.c.d(r1, r2);	 Catch:{ Exception -> 0x00b0, all -> 0x00d2 }
        r6 = 11;
        r0 = f17976a;
        r0 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r0);
        r0.m23023b();
        goto L_0x0097;
    L_0x00d2:
        r0 = move-exception;
        r1 = f17976a;
        r1 = com.huawei.hwdatamigrate.hihealth.p409b.p410a.C4805a.m23018a(r1);
        r1.m23023b();
        throw r0;
    L_0x00dd:
        r0 = r6;
        goto L_0x008c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwdatamigrate.hihealth.h.a.a(java.util.List, int):int");
    }

    private C4924a() {
        this.f17993r = new ConcurrentLinkedQueue();
        this.f17994s = new PriorityBlockingQueue();
        this.f17977b = C4865v.m23609a(f17976a);
        this.f17978c = new C4910d(f17976a);
        this.f17979d = new C4918l(f17976a);
        this.f17980e = new C4915i(f17976a);
        this.f17981f = new C4921o(f17976a);
        this.f17982g = new C4907a(f17976a);
        this.f17983h = new C4913g(f17976a);
        this.f17990o = C4883o.m23650a(f17976a);
        this.f17991p = C4880l.m23643a(f17976a);
        this.f17984i = new C4930e(f17976a);
        this.f17985j = new C4929d(f17976a);
        this.f17986k = new C4931g(f17976a);
        this.f17987l = new C4927b(f17976a);
        this.f17988m = new C4926a(f17976a);
        this.f17989n = new C4928c(f17976a);
        this.f17992q = Executors.newSingleThreadExecutor();
    }

    public static C4924a m23743a(Context context) {
        f17976a = context.getApplicationContext();
        return C4933c.f18018a;
    }

    public boolean m23756a(HiHealthData hiHealthData, int i, List<Integer> list) {
        if (list == null || list.isEmpty() || i <= 0) {
            C2538c.d("HiH_HiHealthDataInsertStore", new Object[]{"saveOneSyncHealthDetailData clients is null or who <= 0"});
            return false;
        }
        int clientID = hiHealthData.getClientID();
        hiHealthData.setSyncStatus(1);
        return m23748a(hiHealthData, clientID, list, i, 0);
    }

    private synchronized boolean m23748a(HiHealthData hiHealthData, int i, List<Integer> list, int i2, int i3) {
        boolean a;
        int type = hiHealthData.getType();
        switch (C4932b.f18017a[C4556c.m21809b(hiHealthData.getType()).ordinal()]) {
            case 1:
                if (type > UtilLoggingLevel.WARNING_INT) {
                    if (type > 22099) {
                        a = this.f17982g.m23728a(hiHealthData, i, list);
                        break;
                    }
                    a = this.f17981f.m23741a(hiHealthData, i, list);
                    break;
                }
                a = this.f17980e.m23737a(hiHealthData, i, list);
                break;
            case 2:
                if (type >= 2000) {
                    a = this.f17979d.m23739a(hiHealthData, i, list);
                    break;
                }
                a = this.f17978c.m23733a(hiHealthData, i, (List) list);
                break;
            case 3:
                a = m23749b(hiHealthData, i, list);
                break;
            case 4:
                a = m23746a(type, hiHealthData, i, list);
                break;
            case 5:
                a = true;
                break;
            case 6:
                a = m23747a(hiHealthData, i3, i2);
                break;
            default:
                a = false;
                break;
        }
        return a;
    }

    public void m23758b(List<HiHealthData> list) {
        Object a = C4939b.m23803a(list);
        if (a == null || a.isEmpty()) {
            C2538c.b("HiH_HiHealthDataInsertStore", new Object[]{"prepareAsyncHealthDataStat() list is null "});
            return;
        }
        this.f17994s.addAll(a);
        C2538c.b("HiH_HiHealthDataInsertStore", new Object[]{"prepareAsyncHealthDataStat() list size = ", Integer.valueOf(a.size()), ",asyncStatList size = ", Integer.valueOf(this.f17994s.size())});
    }

    public void m23759c(List<HiHealthData> list) {
        Object a = C4939b.m23803a(list);
        if (a == null || a.isEmpty()) {
            C2538c.b("HiH_HiHealthDataInsertStore", new Object[]{"prepareRealTimeHealthDataStat() list is null "});
            return;
        }
        this.f17993r.addAll(a);
        C2538c.b("HiH_HiHealthDataInsertStore", new Object[]{"prepareRealTimeHealthDataStat() list size = ", Integer.valueOf(a.size()), ",realTimeStatList size = ", Integer.valueOf(this.f17993r.size())});
    }

    public void m23755a() {
        if (this.f17994s == null || this.f17994s.isEmpty()) {
            C2538c.d("HiH_HiHealthDataInsertStore", new Object[]{"doAsyncHealthDataStat() statList is null "});
            return;
        }
        C2538c.c("HiH_HiHealthDataInsertStore", new Object[]{"doAsyncHealthDataStat() start "});
        if (this.f17992q.isShutdown()) {
            C2538c.e("HiH_HiHealthDataInsertStore", new Object[]{"doAsyncHealthDataStat singleThreadPool is closed!"});
            return;
        }
        this.f17992q.execute(new C4934d(this));
    }

    public void m23757b() {
        try {
            C4805a.m23018a(f17976a).m23022a();
            m23752e();
        } catch (Exception e) {
            C2538c.d("HiH_HiHealthDataInsertStore", new Object[]{"doRealTimeHealthDataStat() e = ", e.getMessage()});
        } finally {
            C4805a.m23018a(f17976a).m23023b();
        }
    }

    private void m23751d() {
        if (this.f17994s != null && !this.f17994s.isEmpty()) {
            C2538c.c("HiH_HiHealthDataInsertStore", new Object[]{"saveAsynHealthDatasStat() asyncStatList size = ", Integer.valueOf(this.f17994s.size())});
            while (!this.f17994s.isEmpty()) {
                try {
                    m23744a((HiHealthData) this.f17994s.take());
                } catch (InterruptedException e) {
                    C2538c.d("HiH_HiHealthDataInsertStore", new Object[]{"saveAsynHealthDatasStat() e = ", e.getMessage()});
                }
            }
        }
    }

    private void m23752e() {
        if (this.f17993r != null && !this.f17993r.isEmpty()) {
            int size = this.f17993r.size();
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = this.f17993r.iterator();
            while (it.hasNext()) {
                m23744a((HiHealthData) it.next());
                it.remove();
            }
            C2538c.c("HiH_HiHealthDataInsertStore", new Object[]{"saveRealTimeHealthDatasStat() size = ", Integer.valueOf(size), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    private void m23744a(HiHealthData hiHealthData) {
        switch (hiHealthData.getType()) {
            case 2002:
                this.f17987l.m23770a(hiHealthData);
                return;
            case 2018:
                this.f17989n.m23775a(hiHealthData);
                return;
            case 20001:
                this.f17984i.m23791a(hiHealthData);
                return;
            case UtilLoggingLevel.SEVERE_INT /*22000*/:
                this.f17985j.m23780a(hiHealthData);
                return;
            case 22100:
                this.f17988m.m23765a(hiHealthData);
                return;
            case PayStatusCodes.PAY_STATE_PARAM_ERROR /*30001*/:
                this.f17986k.m23794a(hiHealthData);
                return;
            default:
                return;
        }
    }

    private boolean m23746a(int i, HiHealthData hiHealthData, int i2, List<Integer> list) {
        int[] a = C4556c.m21808a(i);
        HiHealthData hiHealthData2 = new HiHealthData();
        hiHealthData2.setStartTime(hiHealthData.getStartTime());
        hiHealthData2.setEndTime(hiHealthData.getEndTime());
        hiHealthData2.setMetaData(hiHealthData.getMetaData());
        hiHealthData2.setSyncStatus(hiHealthData.getSyncStatus());
        int length = a.length;
        int i3 = 0;
        for (int i4 : a) {
            C2538c.b("HiH_HiHealthDataInsertStore", new Object[]{"saveSetData() type = ", Integer.valueOf(i), ", pointType = ", Integer.valueOf(i4)});
            hiHealthData2.setType(i4);
            String a2 = C4548a.m21796a(i4);
            double d = hiHealthData.getDouble(a2);
            if (d <= 0.0d) {
                i3++;
            } else {
                hiHealthData2.setValue(d);
                hiHealthData2.setPointUnit(hiHealthData.getInt(C4548a.m21797a(a2)));
                if (this.f17979d.m23739a(hiHealthData2, i2, list)) {
                    i3++;
                }
            }
        }
        return i3 >= length;
    }

    private boolean m23749b(HiHealthData hiHealthData, int i, List<Integer> list) {
        String str = "";
        switch (hiHealthData.getType()) {
            case PayStatusCodes.PAY_STATE_PARAM_ERROR /*30001*/:
                if (!hiHealthData.getBoolean("is_sequence_zip")) {
                    try {
                        str = C4545g.m21790a(C4877i.m23639a().m23642b(hiHealthData));
                    } catch (IOException e) {
                        C2538c.e("HiH_HiHealthDataInsertStore", new Object[]{"saveSequenceData DATA_SEQUENCE_TRACK compress e = ", e.getMessage()});
                        return false;
                    }
                } else if (hiHealthData.getBoolean("is_dividing")) {
                    C4877i.m23639a().m23641a(hiHealthData);
                    return true;
                } else {
                    str = C4877i.m23639a().m23642b(hiHealthData);
                    hiHealthData.setType(PayStatusCodes.PAY_STATE_PARAM_ERROR);
                }
                hiHealthData.setSequenceData(str);
                break;
            case 30003:
                try {
                    str = C4545g.m21790a(C4542d.m21775a(f17976a, hiHealthData.getSequenceFileUrl()));
                    hiHealthData.setType(PayStatusCodes.PAY_STATE_PARAM_ERROR);
                    hiHealthData.setSequenceData(str);
                    break;
                } catch (IOException e2) {
                    C2538c.e("HiH_HiHealthDataInsertStore", new Object[]{"saveSequenceData DATA_SEQUENCE_TRACK_FILE compress e = ", e2.getMessage()});
                    return false;
                }
        }
        if (C4539a.m21748a(hiHealthData.getSequenceData()) || C4539a.m21748a(hiHealthData.getMetaData())) {
            C2538c.e("HiH_HiHealthDataInsertStore", new Object[]{"saveSequenceData track data error ,track startTime is ", Long.valueOf(hiHealthData.getStartTime())});
            return false;
        }
        C2538c.c("HiH_HiHealthDataInsertStore", new Object[]{"saveSequenceData sequence length = ", Integer.valueOf(hiHealthData.getSequenceData().length()), ", startTime = ", Long.valueOf(hiHealthData.getStartTime())});
        boolean a = this.f17983h.m23735a(hiHealthData, i, list);
        if (!a) {
            return a;
        }
        a.b(f17976a, 2);
        return a;
    }

    private boolean m23747a(HiHealthData hiHealthData, int i, int i2) {
        if (i <= 0) {
            C2538c.d("HiH_HiHealthDataInsertStore", new Object[]{"saveStatData() statClient <= 0"});
            return false;
        }
        C2538c.c("HiH_HiHealthDataInsertStore", new Object[]{"saveStatData() type =", Integer.valueOf(hiHealthData.getType()), ",time = ", Long.valueOf(hiHealthData.getStartTime()), ",statClient = ", Integer.valueOf(i), ",who is ", Integer.valueOf(i2)});
        C4807a c4807a = new C4807a();
        c4807a.m23028a(hiHealthData.getStartTime());
        c4807a.m23036d(i2);
        c4807a.m23042g(hiHealthData.getSyncStatus());
        c4807a.m23031b(hiHealthData.getInt("hihealth_type"));
        c4807a.m23034c(hiHealthData.getType());
        c4807a.m23040f(hiHealthData.getPointUnit());
        c4807a.m23026a(hiHealthData.getValue());
        c4807a.m23038e(i);
        c4807a.m23032b(hiHealthData.getModifiedTime());
        return this.f17977b.m23618a(c4807a);
    }
}
