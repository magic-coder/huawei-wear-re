package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import com.huawei.hwversionmgr.a.a;
import com.huawei.hwversionmgr.a.e;
import com.huawei.hwversionmgr.utils.b.f;
import com.huawei.hwversionmgr.utils.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.huawei.p190v.C2538c;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

/* compiled from: DownloadThread */
public class C5390m implements Runnable {
    private static String f19168l;
    private static boolean f19169m = false;
    private Context f19170a;
    private Handler f19171b;
    private String f19172c;
    private String f19173d;
    private long f19174e;
    private long f19175f;
    private String f19176g;
    private long f19177h;
    private String f19178i;
    private String f19179j;
    private String f19180k;
    private Boolean f19181n;

    public C5390m(Context context, Handler handler, Boolean bool) {
        this.f19170a = context;
        this.f19171b = handler;
        this.f19181n = bool;
    }

    private long m25940b() {
        if (this.f19173d != null) {
            File file = new File(this.f19173d);
            if (file.exists()) {
                return file.length();
            }
        }
        return 0;
    }

    private void m25943c() {
        this.f19176g = m25926a(this.f19181n).j;
        this.f19173d = this.f19170a.getFilesDir() + File.separator + this.f19176g;
        this.f19174e = m25926a(this.f19181n).m;
        this.f19175f = m25926a(this.f19181n).q;
        this.f19178i = m25926a(this.f19181n).s;
        this.f19179j = m25926a(this.f19181n).n;
        this.f19180k = m25926a(this.f19181n).r;
        f19168l = m25926a(this.f19181n).c;
        c.d(this.f19173d);
        this.f19177h = m25940b();
        C2538c.b("DownloadThread", new Object[]{"downloadedFileSize=" + this.f19177h});
        this.f19172c = m25926a(this.f19181n).u;
        C2538c.b("DownloadThread", new Object[]{"downloadURL=" + this.f19172c + "isApp:" + this.f19181n});
    }

    private e m25926a(Boolean bool) {
        if (bool.booleanValue()) {
            return c.i();
        }
        return c.j();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r22 = this;
        r2 = "DownloadThread";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "DownloadThread begin !!!";
        r3[r4] = r5;
        com.huawei.v.c.b(r2, r3);
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r22.m25943c();	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r0 = r22;
        r2 = r0.f19172c;	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        if (r2 != 0) goto L_0x0041;
    L_0x0019:
        r2 = "DownloadThread";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r7 = 0;
        r8 = "the download uri is null";
        r6[r7] = r8;	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        com.huawei.v.c.b(r2, r6);	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r2 = 2;
        r0 = r22;
        r0.m25928a(r2);	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r2 = "DownloadThread";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r7 = 0;
        r8 = "the download uri is null, set the state to DOWNLOADING_STATE_END";
        r6[r7] = r8;	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        com.huawei.v.c.b(r2, r6);	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r0 = r22;
        r0.m25934a(r5, r4, r3);
    L_0x0040:
        return;
    L_0x0041:
        r8 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r8.<init>();	 Catch:{ RuntimeException -> 0x038b, Exception -> 0x037c, all -> 0x036b }
        r3 = new com.huawei.hwversionmgr.a.a;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r3.<init>();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r0 = r22;
        r6 = r0.f19174e;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r3.b = r6;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r0 = r22;
        r14 = r0.m25927a(r8);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        if (r14 != 0) goto L_0x005f;
    L_0x0059:
        r0 = r22;
        r0.m25934a(r5, r4, r8);
        goto L_0x0040;
    L_0x005f:
        r2 = "DownloadThread";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r7 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r9.<init>();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r10 = "Range size=";
        r9 = r9.append(r10);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r0 = r22;
        r10 = r0.f19177h;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r9 = r9.append(r10);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r9 = r9.toString();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r6[r7] = r9;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        com.huawei.v.c.b(r2, r6);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r2 = "Range";
        r6 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r6.<init>();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r7 = "bytes=";
        r6 = r6.append(r7);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r0 = r22;
        r10 = r0.f19177h;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r6 = r6.append(r10);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r7 = "-";
        r6 = r6.append(r7);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r6 = r6.toString();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r14.addHeader(r2, r6);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r2 = com.huawei.hwversionmgr.utils.c.g();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r6 = "DownloadThread";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r9 = 0;
        r10 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r10.<init>();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r11 = "DownloadThread retryNum is ";
        r10 = r10.append(r11);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r10 = r10.append(r2);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r10 = r10.toString();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r7[r9] = r10;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        com.huawei.v.c.b(r6, r7);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r2 = r8.execute(r14);	 Catch:{ IOException -> 0x01a9 }
        r6 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r15 = new byte[r6];	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r2 = r2.getEntity();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r10 = r2.getContent();	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r0 = r22;
        r2 = r0.f19170a;	 Catch:{ FileNotFoundException -> 0x01c3 }
        r0 = r22;
        r5 = r0.f19176g;	 Catch:{ FileNotFoundException -> 0x01c3 }
        r6 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
        r9 = r2.openFileOutput(r5, r6);	 Catch:{ FileNotFoundException -> 0x01c3 }
        r0 = r22;
        r4 = r0.f19174e;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r0 = r22;
        r12 = r0.f19177h;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = "DownloadThread";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r7 = 0;
        r11 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11.<init>();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r16 = "fileTotalSize = ";
        r0 = r16;
        r11 = r11.append(r0);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = r11.append(r4);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r16 = ", currentDownloadSize = ";
        r0 = r16;
        r11 = r11.append(r0);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = r11.append(r12);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = r11.toString();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r6[r7] = r11;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r2, r6);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r6 = 0;
        r2 = 0;
        r21 = r6;
        r6 = r12;
        r12 = r21;
    L_0x011f:
        r13 = com.huawei.hwversionmgr.utils.c.g();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = r10.read(r15);	 Catch:{ IOException -> 0x01e8 }
    L_0x0127:
        r16 = "DownloadThread";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r17 = r0;
        r18 = 0;
        r19 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r19.<init>();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r20 = "currentReadCount = ";
        r19 = r19.append(r20);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r0 = r19;
        r19 = r0.append(r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r19 = r19.toString();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r17[r18] = r19;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r16, r17);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r16 = -1;
        r0 = r16;
        if (r11 != r0) goto L_0x0248;
    L_0x0153:
        r2 = "DownloadThread";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r12 = 0;
        r15 = "download cancel";
        r11[r12] = r15;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r2, r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r0 = r22;
        r2 = r0.f19170a;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = com.huawei.hwversionmgr.utils.c.b(r2);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        if (r2 != 0) goto L_0x0201;
    L_0x016a:
        r0 = r22;
        r0.m25944c(r13);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
    L_0x016f:
        r14.abort();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = 1;
    L_0x0173:
        r11 = com.huawei.hwversionmgr.utils.p084b.C5390m.m25938a();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        if (r11 == 0) goto L_0x018e;
    L_0x0179:
        r2 = 9;
        r0 = r22;
        r0.m25928a(r2);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = "DownloadThread";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r12 = 0;
        r13 = "cancel download, set the state to DOWNLOADING_STATE_END";
        r11[r12] = r13;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r2, r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = 1;
    L_0x018e:
        if (r2 != 0) goto L_0x0195;
    L_0x0190:
        r2 = r22;
        r2.m25931a(r3, r4, r6);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
    L_0x0195:
        r0 = r22;
        r0.m25934a(r10, r9, r8);
    L_0x019a:
        r2 = "DownloadThread";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "download end";
        r3[r4] = r5;
        com.huawei.v.c.b(r2, r3);
        goto L_0x0040;
    L_0x01a9:
        r3 = move-exception;
        r3 = "DownloadThread";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r7 = 0;
        r9 = "connect failed, IOException";
        r6[r7] = r9;	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        com.huawei.v.c.b(r3, r6);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r0 = r22;
        r0.m25936a(r14, r8, r2);	 Catch:{ RuntimeException -> 0x038e, Exception -> 0x0382, all -> 0x0370 }
        r0 = r22;
        r0.m25934a(r5, r4, r8);
        goto L_0x0040;
    L_0x01c3:
        r2 = move-exception;
        r2 = "DownloadThread";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ RuntimeException -> 0x0392, Exception -> 0x0387, all -> 0x0374 }
        r5 = 0;
        r6 = "download failed:FileNotFoundException";
        r3[r5] = r6;	 Catch:{ RuntimeException -> 0x0392, Exception -> 0x0387, all -> 0x0374 }
        com.huawei.v.c.b(r2, r3);	 Catch:{ RuntimeException -> 0x0392, Exception -> 0x0387, all -> 0x0374 }
        r14.abort();	 Catch:{ RuntimeException -> 0x0392, Exception -> 0x0387, all -> 0x0374 }
        r2 = r8.getConnectionManager();	 Catch:{ RuntimeException -> 0x0392, Exception -> 0x0387, all -> 0x0374 }
        r2.shutdown();	 Catch:{ RuntimeException -> 0x0392, Exception -> 0x0387, all -> 0x0374 }
        r2 = 4;
        r0 = r22;
        r0.m25928a(r2);	 Catch:{ RuntimeException -> 0x0392, Exception -> 0x0387, all -> 0x0374 }
        r0 = r22;
        r0.m25934a(r10, r4, r8);
        goto L_0x0040;
    L_0x01e8:
        r11 = move-exception;
        r11 = "DownloadThread";
        r16 = 1;
        r0 = r16;
        r0 = new java.lang.Object[r0];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r16 = r0;
        r17 = 0;
        r18 = "download failed  InputStream error:IOException";
        r16[r17] = r18;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r0 = r16;
        com.huawei.v.c.b(r11, r0);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = -1;
        goto L_0x0127;
    L_0x0201:
        r0 = r22;
        r0.m25941b(r13);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        goto L_0x016f;
    L_0x0208:
        r2 = move-exception;
        r3 = r8;
        r4 = r9;
        r5 = r10;
    L_0x020c:
        r6 = "DownloadThread";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0377 }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0377 }
        r9.<init>();	 Catch:{ all -> 0x0377 }
        r10 = "RuntimeException e1 ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x0377 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0377 }
        r2 = r9.append(r2);	 Catch:{ all -> 0x0377 }
        r2 = r2.toString();	 Catch:{ all -> 0x0377 }
        r7[r8] = r2;	 Catch:{ all -> 0x0377 }
        com.huawei.v.c.e(r6, r7);	 Catch:{ all -> 0x0377 }
        r2 = 6;
        r0 = r22;
        r0.m25928a(r2);	 Catch:{ all -> 0x0377 }
        r2 = "DownloadThread";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0377 }
        r7 = 0;
        r8 = "RuntimeException Exception, set the state to DOWNLOADING_STATE_END";
        r6[r7] = r8;	 Catch:{ all -> 0x0377 }
        com.huawei.v.c.e(r2, r6);	 Catch:{ all -> 0x0377 }
        r0 = r22;
        r0.m25934a(r5, r4, r3);
        goto L_0x019a;
    L_0x0248:
        r13 = com.huawei.hwversionmgr.utils.p084b.C5390m.m25938a();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        if (r13 == 0) goto L_0x029d;
    L_0x024e:
        r11 = "DownloadThread";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r13 = 0;
        r15 = "download cancel";
        r12[r13] = r15;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r11, r12);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r14.abort();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        goto L_0x0173;
    L_0x0260:
        r2 = move-exception;
    L_0x0261:
        r3 = "DownloadThread";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0364 }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0364 }
        r6.<init>();	 Catch:{ all -> 0x0364 }
        r7 = "Exception is ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0364 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0364 }
        r2 = r6.append(r2);	 Catch:{ all -> 0x0364 }
        r2 = r2.toString();	 Catch:{ all -> 0x0364 }
        r4[r5] = r2;	 Catch:{ all -> 0x0364 }
        com.huawei.v.c.e(r3, r4);	 Catch:{ all -> 0x0364 }
        r2 = 6;
        r0 = r22;
        r0.m25928a(r2);	 Catch:{ all -> 0x0364 }
        r2 = "DownloadThread";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0364 }
        r4 = 0;
        r5 = "Unknown Exception, set the state to DOWNLOADING_STATE_END";
        r3[r4] = r5;	 Catch:{ all -> 0x0364 }
        com.huawei.v.c.e(r2, r3);	 Catch:{ all -> 0x0364 }
        r0 = r22;
        r0.m25934a(r10, r9, r8);
        goto L_0x019a;
    L_0x029d:
        r13 = "DownloadThread";
        r16 = 1;
        r0 = r16;
        r0 = new java.lang.Object[r0];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r16 = r0;
        r17 = 0;
        r18 = "getFile content success,so init retry time";
        r16[r17] = r18;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r0 = r16;
        com.huawei.v.c.b(r13, r0);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r13 = 0;
        com.huawei.hwversionmgr.utils.c.b(r13);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        if (r9 == 0) goto L_0x02ec;
    L_0x02b8:
        r13 = 0;
        r9.write(r15, r13, r11);	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r9.flush();	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r0 = (long) r11;	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r16 = r0;
        r6 = r6 + r16;
        r13 = "DownloadThread";
        r16 = 1;
        r0 = r16;
        r0 = new java.lang.Object[r0];	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r16 = r0;
        r17 = 0;
        r18 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r18.<init>();	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r19 = "Write currentReadCount = ";
        r18 = r18.append(r19);	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r0 = r18;
        r11 = r0.append(r11);	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r11 = r11.toString();	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r16[r17] = r11;	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
        r0 = r16;
        com.huawei.v.c.b(r13, r0);	 Catch:{ IOException -> 0x0301, IndexOutOfBoundsException -> 0x031b }
    L_0x02ec:
        r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r11 >= 0) goto L_0x0335;
    L_0x02f0:
        r11 = r12 % 20;
        if (r11 != 0) goto L_0x02fc;
    L_0x02f4:
        r3.a = r6;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = 7;
        r0 = r22;
        r0.m25935a(r3, r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
    L_0x02fc:
        r11 = r12 + 1;
        r12 = r11;
        goto L_0x011f;
    L_0x0301:
        r2 = move-exception;
        r2 = "DownloadThread";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r12 = 0;
        r13 = "download failed OutputStream error: IOException";
        r11[r12] = r13;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r2, r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r14.abort();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = 5;
        r0 = r22;
        r0.m25928a(r2);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = 1;
        goto L_0x0173;
    L_0x031b:
        r2 = move-exception;
        r2 = "DownloadThread";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r12 = 0;
        r13 = "download failed OutputStream error: IndexOutOfBoundsException";
        r11[r12] = r13;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r2, r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r14.abort();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = 5;
        r0 = r22;
        r0.m25928a(r2);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r2 = 1;
        goto L_0x0173;
    L_0x0335:
        r11 = "DownloadThread";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r13 = 0;
        r15 = "download complete";
        r12[r13] = r15;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r11, r12);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r14.abort();	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r3.a = r6;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = 7;
        r0 = r22;
        r0.m25935a(r3, r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = 1;
        com.huawei.hwversionmgr.utils.c.a(r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = 0;
        com.huawei.hwversionmgr.utils.c.a(r11);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r11 = "DownloadThread";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        r13 = 0;
        r14 = "download complete, set the state to DOWNLOADING_STATE_END";
        r12[r13] = r14;	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        com.huawei.v.c.b(r11, r12);	 Catch:{ RuntimeException -> 0x0208, Exception -> 0x0260 }
        goto L_0x0173;
    L_0x0364:
        r2 = move-exception;
    L_0x0365:
        r0 = r22;
        r0.m25934a(r10, r9, r8);
        throw r2;
    L_0x036b:
        r2 = move-exception;
        r8 = r3;
        r9 = r4;
        r10 = r5;
        goto L_0x0365;
    L_0x0370:
        r2 = move-exception;
        r9 = r4;
        r10 = r5;
        goto L_0x0365;
    L_0x0374:
        r2 = move-exception;
        r9 = r4;
        goto L_0x0365;
    L_0x0377:
        r2 = move-exception;
        r8 = r3;
        r9 = r4;
        r10 = r5;
        goto L_0x0365;
    L_0x037c:
        r2 = move-exception;
        r8 = r3;
        r9 = r4;
        r10 = r5;
        goto L_0x0261;
    L_0x0382:
        r2 = move-exception;
        r9 = r4;
        r10 = r5;
        goto L_0x0261;
    L_0x0387:
        r2 = move-exception;
        r9 = r4;
        goto L_0x0261;
    L_0x038b:
        r2 = move-exception;
        goto L_0x020c;
    L_0x038e:
        r2 = move-exception;
        r3 = r8;
        goto L_0x020c;
    L_0x0392:
        r2 = move-exception;
        r3 = r8;
        r5 = r10;
        goto L_0x020c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwversionmgr.utils.b.m.run():void");
    }

    private void m25931a(a aVar, long j, long j2) {
        if (j2 >= j) {
            m25930a(aVar);
        } else {
            C2538c.b("DownloadThread", new Object[]{"currentDownloadSize < fileTotalSize"});
            c.d(this.f19173d);
            m25935a(null, 6);
        }
        c.a(false);
        c.a(1);
    }

    private void m25930a(a aVar) {
        String file = this.f19170a.getFilesDir().toString();
        C2538c.b("DownloadThread", new Object[]{"newAppDir : " + (this.f19170a.getFilesDir() + File.separator + c.h() + "(new).apk") + ";HwSelfUpdateUtility.applicationInfo.STORAGEPATH :" + this.f19173d});
        if (!m25945d()) {
            m25942b(aVar);
        } else if (this.f19173d == null) {
            m25942b(aVar);
        } else if (this.f19173d.endsWith(".dat")) {
            C2538c.b("DownloadThread", new Object[]{"update package for patch "});
            m25932a(aVar, file, r1);
        } else {
            aVar.e = this.f19173d;
            aVar.c = this.f19180k;
            aVar.d = this.f19179j;
            C2538c.b("DownloadThread", new Object[]{"dowaload complete and verify success"});
            m25935a(aVar, 8);
            C5390m.m25929a(this.f19170a);
        }
    }

    private void m25934a(InputStream inputStream, OutputStream outputStream, HttpClient httpClient) {
        C2538c.b("DownloadThread", new Object[]{"in finally"});
        if (httpClient != null) {
            C2538c.b("DownloadThread", new Object[]{"httpClient close"});
            httpClient.getConnectionManager().shutdown();
        }
        if (outputStream != null) {
            try {
                C2538c.b("DownloadThread", new Object[]{"outputStream close"});
                outputStream.close();
            } catch (IOException e) {
                C2538c.e("DownloadThread", new Object[]{"outputStream Exception is " + e.getMessage()});
            }
        }
        if (inputStream != null) {
            try {
                C2538c.b("DownloadThread", new Object[]{"inputStream close"});
                inputStream.close();
            } catch (IOException e2) {
                C2538c.e("DownloadThread", new Object[]{"inputStream Exception is " + e2.getMessage()});
            }
        }
    }

    private void m25942b(a aVar) {
        C2538c.b("DownloadThread", new Object[]{"verify md5 failed"});
        c.d(this.f19173d);
        m25935a(aVar, 1);
    }

    private void m25932a(a aVar, String str, String str2) {
        long length;
        String str3 = null;
        try {
            str3 = this.f19170a.getPackageManager().getApplicationInfo(c.h(), 0).sourceDir;
            length = new File(str3).length();
            try {
                C2538c.b("DownloadThread", new Object[]{"oldAppDir:" + str3 + ",oldAppSize:" + length + ";"});
            } catch (NameNotFoundException e) {
                C2538c.b("DownloadThread", new Object[]{c.h() + " apk is not exists !"});
                C2538c.b("DownloadThread", new Object[]{"NEWBYTESIZE apk size = " + this.f19175f + "; oldAppSize = " + length});
                if (this.f19175f != 0) {
                }
                C2538c.b("DownloadThread", new Object[]{"HwSelfUpdateUtility.applicationInfo.NEWBYTESIZE == 0 || oldAppSize == 0"});
                c.d(this.f19173d);
                m25935a(aVar, 1);
                return;
            }
        } catch (NameNotFoundException e2) {
            length = 0;
            C2538c.b("DownloadThread", new Object[]{c.h() + " apk is not exists !"});
            C2538c.b("DownloadThread", new Object[]{"NEWBYTESIZE apk size = " + this.f19175f + "; oldAppSize = " + length});
            if (this.f19175f != 0) {
            }
            C2538c.b("DownloadThread", new Object[]{"HwSelfUpdateUtility.applicationInfo.NEWBYTESIZE == 0 || oldAppSize == 0"});
            c.d(this.f19173d);
            m25935a(aVar, 1);
            return;
        }
        C2538c.b("DownloadThread", new Object[]{"NEWBYTESIZE apk size = " + this.f19175f + "; oldAppSize = " + length});
        if (this.f19175f != 0 || length == 0) {
            C2538c.b("DownloadThread", new Object[]{"HwSelfUpdateUtility.applicationInfo.NEWBYTESIZE == 0 || oldAppSize == 0"});
            c.d(this.f19173d);
            m25935a(aVar, 1);
            return;
        }
        m25933a(aVar, str, str2, length, str3);
    }

    private void m25933a(a aVar, String str, String str2, long j, String str3) {
        C2538c.b("DownloadThread", new Object[]{"availableSize = " + c.c(str)});
        if (c.c(str) <= this.f19175f + j) {
            C2538c.b("DownloadThread", new Object[]{"availableSize is not enough to patch"});
            c.d(this.f19173d);
            m25935a(aVar, 1);
            return;
        }
        C2538c.b("DownloadThread", new Object[]{"availableSize is enough to patch"});
        c cVar = new c();
        if (str3 == null || str2 == null) {
            C2538c.b("DownloadThread", new Object[]{"oldAppDir or newAppDir or HwSelfUpdateUtility.applicationInfo.STORAGEPATH is null"});
            c.d(this.f19173d);
            m25935a(aVar, 1);
            return;
        }
        c.d(str2);
        c.a(this.f19170a, c.h());
        C2538c.b("DownloadThread", new Object[]{"patchResult :" + cVar.a(this.f19170a, str3, str2, this.f19173d)});
        if (cVar.a(this.f19170a, str3, str2, this.f19173d) == 0) {
            C2538c.b("DownloadThread", new Object[]{"patch success and going to delete patch file :" + this.f19173d});
            c.d(this.f19173d);
            if (m25939a(str2)) {
                C2538c.b("DownloadThread", new Object[]{"verify newmd5 success"});
                aVar.e = str2;
                aVar.c = this.f19178i;
                aVar.d = this.f19179j;
                m25935a(aVar, 8);
                C5390m.m25929a(this.f19170a);
                return;
            }
            C2538c.b("DownloadThread", new Object[]{"verify newmd5 failed"});
            m25935a(aVar, 1);
            return;
        }
        C2538c.b("DownloadThread", new Object[]{"patch failed"});
        c.d(this.f19173d);
        m25935a(aVar, 1);
    }

    private void m25928a(int i) {
        c.d(this.f19173d);
        c.a(1);
        c.a(false);
        m25935a(null, i);
    }

    private void m25941b(int i) {
        if (i < 3) {
            C2538c.b("DownloadThread", new Object[]{"download cancel,network is connect but not avaiable, set the state to DOWNLOADING_STATE_RETRY"});
            c.a(3);
            c.a(false);
            return;
        }
        C2538c.b("DownloadThread", new Object[]{"download cancel,network is connect but not avaiable, set the state to DOWNLOADING_STATE_END"});
        c.d(this.f19173d);
        c.a(1);
        c.a(false);
        m25935a(null, 3);
    }

    private void m25944c(int i) {
        C2538c.b("DownloadThread", new Object[]{"download cancel,network is not avaiable"});
        if (i < 3) {
            C2538c.b("DownloadThread", new Object[]{"download cancel,network is not avaiable, set the state to DOWNLOADING_STATE_RETRY"});
            c.a(3);
            c.a(false);
            return;
        }
        C2538c.b("DownloadThread", new Object[]{"download cancel,network is not avaiable, set the state to DOWNLOADING_STATE_END"});
        c.d(this.f19173d);
        c.a(1);
        c.a(false);
        m25935a(null, 3);
    }

    @Nullable
    private HttpGet m25927a(HttpClient httpClient) {
        try {
            HttpGet httpGet = new HttpGet(this.f19172c);
            c.a(httpGet, httpClient, this.f19170a);
            httpGet.getParams().setIntParameter("http.socket.timeout", 20000);
            httpGet.getParams().setIntParameter("http.connection.timeout", 20000);
            httpGet.getParams().setIntParameter("http.socket.buffer-size", 8192);
            return httpGet;
        } catch (IllegalArgumentException e) {
            C2538c.b("DownloadThread", new Object[]{"download failed, IllegalArgumentException"});
            c.d(this.f19173d);
            c.a(1);
            c.a(false);
            m25935a(null, 2);
            return null;
        }
    }

    private void m25936a(HttpGet httpGet, HttpClient httpClient, int i) {
        if (i < 3) {
            C2538c.b("DownloadThread", new Object[]{"connect failed, set the state to DOWNLOADING_STATE_RETRY"});
            c.a(3);
            c.a(false);
        } else {
            C2538c.b("DownloadThread", new Object[]{"connect failed, set the state to DOWNLOADING_STATE_END and sendMessage DOWNLOAD_FAILED_CONNECT_ERROR"});
            m25928a(3);
        }
        httpGet.abort();
        httpClient.getConnectionManager().shutdown();
    }

    private void m25935a(Object obj, int i) {
        if (this.f19171b != null) {
            Message message = new Message();
            message.obj = obj;
            message.what = i;
            this.f19171b.sendMessage(message);
        }
    }

    private boolean m25945d() {
        String str = this.f19180k;
        String a = com.huawei.hwversionmgr.utils.e.a(this.f19173d);
        C2538c.b("DownloadThread", new Object[]{"srcMd5=" + str + " ,path=" + r3});
        if (str.equals(a)) {
            C2538c.b("DownloadThread", new Object[]{"verify md5 success"});
            return true;
        }
        C2538c.b("DownloadThread", new Object[]{"verify md5 failed"});
        return false;
    }

    private boolean m25939a(String str) {
        String str2 = this.f19178i;
        String a = com.huawei.hwversionmgr.utils.e.a(str);
        if (str2.equals("")) {
            C2538c.b("DownloadThread", new Object[]{"HwSelfUpdateUtility.applicationInfo.NEWMD5 is null"});
            return false;
        }
        C2538c.b("DownloadThread", new Object[]{"srcMd5=" + str2 + " ,path=" + str});
        if (str2.equals(a)) {
            C2538c.b("DownloadThread", new Object[]{"verify newmd5 success"});
            return true;
        }
        C2538c.b("DownloadThread", new Object[]{"verify newmd5 failed"});
        return false;
    }

    public static boolean m25938a() {
        return f19169m;
    }

    public static void m25937a(boolean z) {
        f19169m = z;
    }

    public static void m25929a(Context context) {
        com.huawei.hwversionmgr.a.c cVar = new com.huawei.hwversionmgr.a.c();
        cVar.a = 2;
        cVar.b = c.c(context);
        cVar.c = f19168l;
        cVar.d = c.a(c.h(), context);
        cVar.e = "";
        new Thread(new f(context, cVar)).start();
    }
}
