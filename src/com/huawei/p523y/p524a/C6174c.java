package com.huawei.p523y.p524a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.al.C4029b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwservicesmgr.C5368p;
import com.huawei.hwservicesmgr.j;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;
import com.p248b.p249a.p250a.p251a.C3530d;
import com.p248b.p249a.p250a.p251a.C3531e;
import com.p248b.p249a.p250a.p251a.C3532f;
import com.p248b.p249a.p250a.p251a.C3536j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: HWOTAV1Mgr */
public class C6174c extends C6172a {
    private static C6174c f21638a = null;
    private Context f21639b;
    private C3532f f21640c;
    private j f21641d;
    private String f21642e;
    private File f21643f = null;
    private long f21644g = 0;
    private int f21645h = 0;
    private InputStream f21646i = null;
    private int f21647j = 0;
    private int f21648k = 0;
    private Handler f21649l = new Handler(new C6175d(this));

    public static C6174c m28568a(Context context) {
        if (f21638a == null && context != null) {
            f21638a = new C6174c(BaseApplication.b());
        }
        return f21638a;
    }

    private C6174c(Context context) {
        super(context);
        this.f21639b = context;
        this.f21640c = new C3532f(C3536j.BT_GAIA);
    }

    public void mo5184a(String str, int i, String str2, j jVar) {
        this.f21641d = jVar;
        this.f21642e = str2;
        DeviceInfo c = c.a(this.f21639b).c();
        if (c != null) {
            try {
                this.f21640c.m17695a(this.f21649l);
                this.f21640c.m17697a(c.getDeviceIdentify());
                return;
            } catch (IOException e) {
                m28569a(7, null);
                return;
            }
        }
        m28569a(6, null);
    }

    private void m28570a(android.os.Message r10) {
        /* JADX: method processing error */
/*
Error: java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at jadx.core.dex.visitors.ReSugarCode.getEnumMap(ReSugarCode.java:171)
	at jadx.core.dex.visitors.ReSugarCode.processEnumSwitch(ReSugarCode.java:123)
	at jadx.core.dex.visitors.ReSugarCode.process(ReSugarCode.java:68)
	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:52)
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
        r9 = this;
        r8 = 0;
        r7 = 1;
        r0 = r10.obj;
        r0 = (com.p248b.p249a.p250a.p251a.C3531e) r0;
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: handle_the_unhandled: command.getCommandId() = ";
        r3 = r3.append(r4);
        r4 = r0.m17662i();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2[r8] = r3;
        com.huawei.v.c.b(r1, r2);
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: handle_the_unhandled: command.isAcknowledgement() = ";
        r3 = r3.append(r4);
        r4 = r0.m17651a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2[r8] = r3;
        com.huawei.v.c.b(r1, r2);
        r1 = r0.m17651a();
        if (r1 == 0) goto L_0x025f;
    L_0x004c:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: handle_the_unhandled: command.getStatus() = ";
        r3 = r3.append(r4);
        r4 = r0.m17657d();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2[r8] = r3;
        com.huawei.v.c.b(r1, r2);
        r1 = r0.m17657d();
        r2 = com.p248b.p249a.p250a.p251a.C3530d.SUCCESS;
        if (r1 != r2) goto L_0x0134;
    L_0x0074:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: handle_the_unhandled: command.getCommand() = ";
        r3 = r3.append(r4);
        r4 = r0.m17661h();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2[r8] = r3;
        com.huawei.v.c.b(r1, r2);
        r1 = r0.m17661h();
        switch(r1) {
            case 769: goto L_0x00a7;
            case 770: goto L_0x00c8;
            case 771: goto L_0x00e9;
            case 772: goto L_0x010e;
            default: goto L_0x009b;
        };
    L_0x009b:
        r0 = "HWOTAV1Mgr";
        r1 = new java.lang.Object[r7];
        r2 = "gaia: handle_the_unhandled switch default";
        r1[r8] = r2;
        com.huawei.v.c.b(r0, r1);
    L_0x00a6:
        return;
    L_0x00a7:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: RSSI: ";
        r3 = r3.append(r4);
        r0 = r0.m17659f();
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x00c8:
        r0 = r0.m17655c(r7);
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: Battery Level: ";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x00e9:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: ModuleId: ";
        r3 = r3.append(r4);
        r0 = r0.m17658e();
        r0 = java.util.Arrays.toString(r0);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x010e:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: DeviceVersion: ";
        r3 = r3.append(r4);
        r0 = r0.m17658e();
        r0 = java.util.Arrays.toString(r0);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x0134:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: handle_the_unhandled: command.getCommand() = ";
        r3 = r3.append(r4);
        r4 = r0.m17661h();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2[r8] = r3;
        com.huawei.v.c.b(r1, r2);
        r1 = r0.m17662i();
        switch(r1) {
            case 652: goto L_0x00a6;
            case 658: goto L_0x00a6;
            default: goto L_0x015b;
        };
    L_0x015b:
        r1 = r0.m17657d();
        if (r1 != 0) goto L_0x016e;
    L_0x0161:
        r0 = "HWOTAV1Mgr";
        r1 = new java.lang.Object[r7];
        r2 = "gaia: handle_the_unhandled: command.getStatus() == null";
        r1[r8] = r2;
        com.huawei.v.c.e(r0, r1);
        goto L_0x00a6;
    L_0x016e:
        r2 = "HWOTAV1Mgr";
        r3 = new java.lang.Object[r7];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "gaia: value: ";
        r4 = r4.append(r5);
        r4 = r4.append(r1);
        r4 = r4.toString();
        r3[r8] = r4;
        com.huawei.v.c.b(r2, r3);
        r2 = com.huawei.p523y.p524a.C6176e.f21652b;
        r1 = r1.ordinal();
        r1 = r2[r1];
        switch(r1) {
            case 1: goto L_0x01c1;
            case 2: goto L_0x01e7;
            case 3: goto L_0x020d;
            case 4: goto L_0x0233;
            default: goto L_0x0195;
        };
    L_0x0195:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: Command 0x";
        r3 = r3.append(r4);
        r0 = r0.m17661h();
        r0 = r9.m28578c(r0);
        r0 = r3.append(r0);
        r3 = " doesn't work";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x01c1:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: Invalid parameter in command 0x";
        r3 = r3.append(r4);
        r0 = r0.m17662i();
        r0 = r9.m28578c(r0);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x01e7:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: Insufficient resources for command 0x";
        r3 = r3.append(r4);
        r0 = r0.m17662i();
        r0 = r9.m28578c(r0);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x020d:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: Incorrect state for command 0x";
        r3 = r3.append(r4);
        r0 = r0.m17662i();
        r0 = r9.m28578c(r0);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x0233:
        r1 = "HWOTAV1Mgr";
        r2 = new java.lang.Object[r7];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "gaia: Command 0x";
        r3 = r3.append(r4);
        r0 = r0.m17661h();
        r0 = r9.m28578c(r0);
        r0 = r3.append(r0);
        r3 = " is not supported";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r2[r8] = r0;
        com.huawei.v.c.b(r1, r2);
        goto L_0x00a6;
    L_0x025f:
        r1 = r0.m17662i();
        r2 = 16387; // 0x4003 float:2.2963E-41 double:8.0963E-320;
        if (r1 != r2) goto L_0x0335;
    L_0x0267:
        r1 = r0.m17656c();
        if (r1 != 0) goto L_0x0276;
    L_0x026d:
        r0 = 8;
        r1 = "gaia: handle_the_unhandled: command.getEventId() == null";
        r9.m28569a(r0, r1);
        goto L_0x00a6;
    L_0x0276:
        r2 = "HWOTAV1Mgr";
        r3 = new java.lang.Object[r7];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "gaia: EventID = ";
        r4 = r4.append(r5);
        r5 = r1.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3[r8] = r4;
        com.huawei.v.c.b(r2, r3);
        r2 = com.huawei.p523y.p524a.C6176e.f21653c;
        r3 = r1.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x02d0;
            case 2: goto L_0x02f1;
            case 3: goto L_0x030d;
            default: goto L_0x02a1;
        };
    L_0x02a1:
        r2 = "HWOTAV1Mgr";
        r3 = new java.lang.Object[r7];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "gaia: DFU Event ";
        r4 = r4.append(r5);
        r5 = r1.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3[r8] = r4;
        com.huawei.v.c.e(r2, r3);
    L_0x02c1:
        r2 = com.p248b.p249a.p250a.p251a.C3530d.SUCCESS;
        r3 = new int[r7];
        r1 = r1.ordinal();
        r3[r8] = r1;
        r9.m28571a(r0, r2, r3);
        goto L_0x00a6;
    L_0x02d0:
        r2 = "HWOTAV1Mgr";
        r3 = new java.lang.Object[r7];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "gaia: ChargerState: ";
        r4 = r4.append(r5);
        r5 = r0.m17659f();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3[r8] = r4;
        com.huawei.v.c.b(r2, r3);
        goto L_0x02c1;
    L_0x02f1:
        r2 = r0.m17655c(r7);
        r3 = "HWOTAV1Mgr";
        r4 = new java.lang.Object[r7];
        r5 = "gaia: User Action 0x%04X";
        r6 = new java.lang.Object[r7];
        r2 = java.lang.Integer.valueOf(r2);
        r6[r8] = r2;
        r2 = java.lang.String.format(r5, r6);
        r4[r8] = r2;
        com.huawei.v.c.b(r3, r4);
        goto L_0x02c1;
    L_0x030d:
        r2 = "HWOTAV1Mgr";
        r3 = new java.lang.Object[r7];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "gaia: DFU_STATE: state = ";
        r4 = r4.append(r5);
        r5 = r0.m17653b(r7);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3[r8] = r4;
        com.huawei.v.c.b(r2, r3);
        r2 = r0.m17653b(r7);
        r9.m28575b(r2);
        goto L_0x02c1;
    L_0x0335:
        r1 = r0.m17662i();
        r2 = 1584; // 0x630 float:2.22E-42 double:7.826E-321;
        if (r1 != r2) goto L_0x0349;
    L_0x033d:
        r1 = com.p248b.p249a.p250a.p251a.C3530d.SUCCESS;
        r2 = new int[r8];
        r9.m28571a(r0, r1, r2);
        r9.m28581g();
        goto L_0x00a6;
    L_0x0349:
        r1 = com.p248b.p249a.p250a.p251a.C3530d.NOT_SUPPORTED;
        r2 = new int[r8];
        r9.m28571a(r0, r1, r2);
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.y.a.c.a(android.os.Message):void");
    }

    private void m28571a(C3531e c3531e, C3530d c3530d, int... iArr) {
        try {
            this.f21640c.m17696a(c3531e, c3530d, iArr);
        } catch (IOException e) {
            C2538c.e("HWOTAV1Mgr", new Object[]{"sendAcknowledgement() error e = " + e.getMessage()});
        }
    }

    private boolean m28580f() {
        C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: checkFileCrc: mDfuFilePath = " + this.f21642e});
        if (TextUtils.isEmpty(this.f21642e)) {
            return false;
        }
        File file = new File(this.f21642e);
        if (!file.exists()) {
            return false;
        }
        boolean a = m28574a(file);
        C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: checkFileCrc: handleDfuFileSelected return ret = " + a});
        if (a) {
            C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: checkFileCrc: updateFileAbsolutePath = " + this.f21643f.getAbsolutePath() + ", crc = " + this.f21644g});
        }
        return a;
    }

    private void m28581g() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            C2538c.e("HWOTAV1Mgr", new Object[]{"InterruptedException = " + e.getMessage()});
        }
        if (this.f21643f != null) {
            try {
                this.f21645h = (int) this.f21643f.length();
                C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: startDfu: mDfuFile size = " + this.f21645h});
                this.f21640c.m17690a(this.f21645h, (int) this.f21644g);
                return;
            } catch (IOException e2) {
                C2538c.e("HWOTAV1Mgr", new Object[]{"IOException = " + e2.getMessage()});
                return;
            }
        }
        m28569a(9, "DFU升级文件为空");
    }

    private void m28575b(int i) {
        C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: DFU state " + i});
        switch (i) {
            case 0:
                try {
                    C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: setDfuState: mDfuFile size = " + this.f21645h});
                    this.f21647j = ((this.f21645h + 240) - 1) / 240;
                    this.f21648k = 0;
                    C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: setDfuState: chunks_total = " + this.f21647j + ", chunks_done = " + this.f21648k});
                    this.f21646i = new FileInputStream(this.f21643f);
                    m28583i();
                    return;
                } catch (Exception e) {
                    C2538c.e("HWOTAV1Mgr", new Object[]{e.getMessage()});
                    m28569a(10, "OTA传输错误");
                    return;
                }
            case 1:
                m28569a(10, "OTA传输错误");
                return;
            case 2:
                C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: OTA VERIFY IMAGE"});
                return;
            case 3:
                m28569a(11, "OTA校验错误");
                return;
            case 4:
                C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: OTA TRANSFER FINISH"});
                return;
            default:
                return;
        }
    }

    private void m28582h() {
        this.f21648k++;
        C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: anotherChunkDone: chunks_done = " + this.f21648k});
        try {
            this.f21641d.a((this.f21648k * 100) / this.f21647j);
            m28583i();
        } catch (Exception e) {
            C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: anotherChunkDone() e = " + e.getMessage()});
        }
    }

    private void m28583i() {
        byte[] bArr = new byte[240];
        if (this.f21646i != null) {
            try {
                int read = this.f21646i.read(bArr);
                if (read > 0) {
                    this.f21640c.m17699a(bArr, read);
                    return;
                }
                C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: DFU sent done"});
                this.f21646i.close();
                return;
            } catch (Exception e) {
                C2538c.e("HWOTAV1Mgr", new Object[]{"gaia: hurl(): Exception = " + e.getMessage()});
                return;
            }
        }
        C2538c.e("HWOTAV1Mgr", new Object[]{"gaia: hurl(): dfu_stream = null"});
    }

    private boolean m28574a(File file) {
        try {
            this.f21644g = C4029b.m19826a(file);
        } catch (IOException e) {
            this.f21644g = 0;
        }
        if (this.f21644g == 0) {
            C2538c.e("HWOTAV1Mgr", new Object[]{"gaia: Failed to calculate CRC on file."});
            return false;
        }
        this.f21644g = ((this.f21644g & 65535) << 16) | ((this.f21644g & 4294901760L) >> 16);
        this.f21643f = file;
        C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: handleDfuFileSelected: mDfuFile = " + this.f21643f.getName()});
        return true;
    }

    private void m28569a(int i, String str) {
        switch (i) {
            case 0:
                str = "升级文件crc校验错误";
                m28586e();
                break;
            case 6:
                str = "DeviceInfo为空";
                break;
            case 7:
                str = "Gaia包异常";
                break;
            case 8:
                m28586e();
                break;
            case 9:
                m28586e();
                break;
            default:
                str = "";
                m28586e();
                break;
        }
        try {
            this.f21641d.a(i, str);
        } catch (Exception e) {
            C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: reportFail() e = " + e.getMessage()});
        }
    }

    public void m28586e() {
        try {
            C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: disconnectGAIALink"});
            this.f21640c.m17701b();
        } catch (IOException e) {
            C2538c.e("HWOTAV1Mgr", new Object[]{e.getMessage()});
        }
    }

    private String m28578c(int i) {
        return String.format("%04x", new Object[]{Integer.valueOf(i)});
    }

    public void mo5185a(String str, C5368p c5368p) {
        try {
            c5368p.m25849a(109005, "设备不允许升级");
        } catch (Exception e) {
            C2538c.e("HWOTAV1Mgr", new Object[]{"exception e = " + e.getMessage()});
        }
    }
}
