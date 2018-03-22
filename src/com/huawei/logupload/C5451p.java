package com.huawei.logupload;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.logupload.a.a;
import com.huawei.logupload.a.c;
import com.huawei.logupload.c.b;
import com.huawei.logupload.c.f;
import com.huawei.logupload.p090c.C5441e;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Uploading */
public class C5451p {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m26123a(java.io.File r20, com.huawei.logupload.LogUpload r21) {
        /*
        r19 = this;
        r6 = new java.util.TreeMap;
        r6.<init>();
        r4 = r21.s();
        r5 = r21.r();
        r2 = r20.length();
        r7 = java.lang.String.valueOf(r2);
        r2 = "LogUpload Service";
        r3 = new java.lang.StringBuilder;
        r8 = "nspFileSize";
        r3.<init>(r8);
        r3 = r3.append(r7);
        r3 = r3.toString();
        com.huawei.logupload.c.f.b(r2, r3);
        r2 = r20.length();
        r8 = 1024000; // 0xfa000 float:1.43493E-39 double:5.05923E-318;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x008c;
    L_0x0034:
        r2 = 0;
        r3 = r2;
    L_0x0036:
        r2 = "http://";
        r10 = 4096000; // 0x3e8000 float:5.739719E-39 double:2.023693E-317;
        r8 = r20.length();
        r12 = r21.u();
        r13 = new java.lang.StringBuilder;
        r2 = java.lang.String.valueOf(r2);
        r13.<init>(r2);
        r2 = r21.t();
        r2 = r13.append(r2);
        r13 = r21.p();
        r2 = r2.append(r13);
        r2 = r2.toString();
        r13 = 2;
        if (r12 != r13) goto L_0x0076;
    L_0x0063:
        r13 = new java.lang.StringBuilder;
        r2 = java.lang.String.valueOf(r2);
        r13.<init>(r2);
        r2 = "?resume";
        r2 = r13.append(r2);
        r2 = r2.toString();
    L_0x0076:
        r13 = "http.keepAlive";
        r14 = "false";
        java.lang.System.setProperty(r13, r14);
        r13 = new java.net.URL;
        r13.<init>(r2);
        r2 = r13.openConnection();
        r2 = (java.net.HttpURLConnection) r2;
        if (r2 != 0) goto L_0x008f;
    L_0x008a:
        r2 = -1;
    L_0x008b:
        return r2;
    L_0x008c:
        r2 = 1;
        r3 = r2;
        goto L_0x0036;
    L_0x008f:
        r13 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2.setConnectTimeout(r13);
        r13 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2.setReadTimeout(r13);
        r13 = 1;
        r2.setDoInput(r13);
        r13 = 1;
        r2.setDoOutput(r13);
        r13 = 0;
        r2.setUseCaches(r13);
        r13 = "PUT";
        r2.setRequestMethod(r13);
        r13 = "Connection";
        r14 = "Keep-Alive";
        r2.setRequestProperty(r13, r14);
        r13 = "Charset";
        r14 = "UTF-8";
        r2.setRequestProperty(r13, r14);
        r13 = "Content-Type";
        r14 = "binary/octet-stream";
        r2.setRequestProperty(r13, r14);
        r13 = "Expect";
        r14 = "100-continue";
        r2.setRequestProperty(r13, r14);
        r13 = "User-Agent";
        r14 = "PHONE_SERVICE";
        r2.setRequestProperty(r13, r14);
        r13 = r4.length();
        if (r13 <= 0) goto L_0x00eb;
    L_0x00d3:
        r13 = "nsp-callback";
        r2.setRequestProperty(r13, r4);
        r13 = "nsp-callback-status";
        r14 = "200";
        r2.setRequestProperty(r13, r14);
        r13 = "nsp-callback";
        r6.put(r13, r4);
        r4 = "nsp-callback-Status";
        r13 = "200";
        r6.put(r4, r13);
    L_0x00eb:
        r4 = "nsp-ts";
        r2.setRequestProperty(r4, r5);
        r4 = "nsp-ts";
        r6.put(r4, r5);
        r4 = "LogUpload Service";
        r13 = new java.lang.StringBuilder;
        r14 = "nspTs";
        r13.<init>(r14);
        r5 = r13.append(r5);
        r5 = r5.toString();
        com.huawei.logupload.c.f.b(r4, r5);
        r4 = "LogUpload Service";
        r5 = new java.lang.StringBuilder;
        r13 = "type";
        r5.<init>(r13);
        r5 = r5.append(r12);
        r5 = r5.toString();
        com.huawei.logupload.c.f.b(r4, r5);
        r4 = 0;
        if (r12 != 0) goto L_0x02be;
    L_0x0122:
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 <= 0) goto L_0x02be;
    L_0x0126:
        r8 = 1;
        r8 = r10 - r8;
        r13 = new java.lang.StringBuilder;
        r14 = java.lang.String.valueOf(r4);
        r13.<init>(r14);
        r14 = "-";
        r13 = r13.append(r14);
        r8 = r13.append(r8);
        r9 = "/";
        r8 = r8.append(r9);
        r8 = r8.append(r7);
        r8 = r8.toString();
        r9 = "LogUpload Service";
        r13 = new java.lang.StringBuilder;
        r14 = "nspContentRange";
        r13.<init>(r14);
        r13 = r13.append(r8);
        r13 = r13.toString();
        com.huawei.logupload.c.f.b(r9, r13);
        r9 = "nsp-content-range";
        r2.setRequestProperty(r9, r8);
        r9 = "nsp-content-range";
        r6.put(r9, r8);
    L_0x0169:
        r8 = com.huawei.logupload.p090c.C5442g.m26096a(r20);
        r9 = "nsp-file-md5";
        r2.setRequestProperty(r9, r8);
        r9 = "nsp-file-md5";
        r6.put(r9, r8);
        r8 = "LogUpload Service";
        r9 = new java.lang.StringBuilder;
        r13 = "nspFileSize";
        r9.<init>(r13);
        r9 = r9.append(r7);
        r9 = r9.toString();
        com.huawei.logupload.c.f.b(r8, r9);
        r8 = "nsp-file-size";
        r2.setRequestProperty(r8, r7);
        r8 = "nsp-file-size";
        r6.put(r8, r7);
        r0 = r19;
        r1 = r21;
        r6 = r0.m26121a(r1, r6);
        r7 = "nsp-sig";
        r2.setRequestProperty(r7, r6);
        r6 = 2;
        if (r12 == r6) goto L_0x0208;
    L_0x01a5:
        r9 = new java.io.DataOutputStream;
        r6 = r2.getOutputStream();
        r9.<init>(r6);
        r6 = "LogUpload Service";
        r7 = "getOutputStream";
        com.huawei.logupload.c.f.b(r6, r7);
        r7 = 0;
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r13 = new byte[r6];
        r8 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ RuntimeException -> 0x03b0, IOException -> 0x03fd, Exception -> 0x0463, all -> 0x04b8 }
        r0 = r20;
        r6.<init>(r0);	 Catch:{ RuntimeException -> 0x03b0, IOException -> 0x03fd, Exception -> 0x0463, all -> 0x04b8 }
        r7 = 1;
        if (r12 != r7) goto L_0x074f;
    L_0x01c5:
        r4 = r6.skip(r4);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r7 = "LogUpload Service";
        r12 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r14 = "skip";
        r12.<init>(r14);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r4 = r12.append(r4);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r4 = r4.toString();	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        com.huawei.logupload.c.f.b(r7, r4);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r4 = r8;
    L_0x01df:
        r5 = r6.read(r13);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r7 = -1;
        if (r5 != r7) goto L_0x03a4;
    L_0x01e6:
        r4 = "LogUpload Service";
        r5 = "ds.flush()";
        com.huawei.logupload.c.f.b(r4, r5);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r9.flush();	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r4 = "LogUpload Service";
        r5 = "ds.flush() end";
        com.huawei.logupload.c.f.b(r4, r5);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r4 = "LogUpload Service";
        r5 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r4, r5);
        r4 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r6, r4);
        r4 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r4);
    L_0x0208:
        r13 = 0;
        r12 = -1;
        r6 = 0;
        r8 = 0;
        r5 = 0;
        r4 = 0;
        r10 = "LogUpload Service";
        r11 = " statusLine before";
        com.huawei.logupload.c.f.b(r10, r11);	 Catch:{ IOException -> 0x0716, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0716, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r6 = 0;
        r6 = r2.getHeaderField(r6);	 Catch:{ IOException -> 0x071f, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r5 = 0;
        r5 = r2.getHeaderFieldKey(r5);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r7 = "LogUpload Service";
        r14 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r15 = "statusLine";
        r14.<init>(r15);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r14 = r14.append(r6);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r14 = r14.toString();	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        com.huawei.logupload.c.f.b(r7, r14);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r7 = "LogUpload Service";
        r14 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r15 = "statusLinekey";
        r14.<init>(r15);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r5 = r14.append(r5);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        com.huawei.logupload.c.f.b(r7, r5);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r5 = 0;
        r5 = r2.getHeaderField(r5);	 Catch:{ IOException -> 0x0727, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r4 = "LogUpload Service";
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x072e, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r14 = "statusLine2";
        r7.<init>(r14);	 Catch:{ IOException -> 0x072e, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r7 = r7.append(r5);	 Catch:{ IOException -> 0x072e, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r7 = r7.toString();	 Catch:{ IOException -> 0x072e, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        com.huawei.logupload.c.f.b(r4, r7);	 Catch:{ IOException -> 0x072e, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x072e, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r4 = r2.getResponseCode();	 Catch:{ IOException -> 0x072e, RuntimeException -> 0x0650, Exception -> 0x069f, all -> 0x06ee }
        r7 = "LogUpload Service";
        r12 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0734, RuntimeException -> 0x0705, Exception -> 0x06f6, all -> 0x06ee }
        r14 = "返回码";
        r12.<init>(r14);	 Catch:{ IOException -> 0x0734, RuntimeException -> 0x0705, Exception -> 0x06f6, all -> 0x06ee }
        r12 = r12.append(r4);	 Catch:{ IOException -> 0x0734, RuntimeException -> 0x0705, Exception -> 0x06f6, all -> 0x06ee }
        r12 = r12.toString();	 Catch:{ IOException -> 0x0734, RuntimeException -> 0x0705, Exception -> 0x06f6, all -> 0x06ee }
        com.huawei.logupload.c.f.b(r7, r12);	 Catch:{ IOException -> 0x0734, RuntimeException -> 0x0705, Exception -> 0x06f6, all -> 0x06ee }
        r7 = r2.getInputStream();	 Catch:{ IOException -> 0x0734, RuntimeException -> 0x0705, Exception -> 0x06f6, all -> 0x06ee }
        r2 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r2.<init>();	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r12 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r12 = new byte[r12];	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
    L_0x0293:
        r13 = r7.read(r12);	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r14 = -1;
        if (r14 != r13) goto L_0x04cc;
    L_0x029a:
        r12 = "LogUpload Service";
        r13 = "读取完毕";
        com.huawei.logupload.c.f.b(r12, r13);	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r2 = r2.toString();	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r12 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
        if (r4 != r12) goto L_0x02b6;
    L_0x02aa:
        r12 = "LogUpload Service";
        r13 = "parserContentRange";
        com.huawei.logupload.c.f.b(r12, r13);	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r0 = r21;
        com.huawei.logupload.C5451p.m26122a(r2, r0);	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
    L_0x02b6:
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r7, r2);
        r2 = r4;
        goto L_0x008b;
    L_0x02be:
        r8 = 1;
        if (r12 != r8) goto L_0x0169;
    L_0x02c1:
        r4 = r20.length();
        r8 = 1;
        r8 = r4 - r8;
        r4 = "LogUpload Service";
        r5 = new java.lang.StringBuilder;
        r13 = "endPos";
        r5.<init>(r13);
        r5 = r5.append(r8);
        r5 = r5.toString();
        com.huawei.logupload.c.f.b(r4, r5);
        r0 = r19;
        r1 = r21;
        r4 = r0.m26120a(r1);
        r13 = "LogUpload Service";
        r14 = new java.lang.StringBuilder;
        r15 = "startPos";
        r14.<init>(r15);
        r14 = r14.append(r4);
        r14 = r14.toString();
        com.huawei.logupload.c.f.b(r13, r14);
        r14 = r8 - r4;
        r16 = 1;
        r14 = r14 + r16;
        r13 = "LogUpload Service";
        r16 = new java.lang.StringBuilder;
        r17 = "transfLength";
        r16.<init>(r17);
        r0 = r16;
        r16 = r0.append(r14);
        r16 = r16.toString();
        r0 = r16;
        com.huawei.logupload.c.f.b(r13, r0);
        r13 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r13 > 0) goto L_0x035e;
    L_0x031d:
        r13 = new java.lang.StringBuilder;
        r14 = java.lang.String.valueOf(r4);
        r13.<init>(r14);
        r14 = "-";
        r13 = r13.append(r14);
        r8 = r13.append(r8);
        r9 = "/";
        r8 = r8.append(r9);
        r8 = r8.append(r7);
        r8 = r8.toString();
        r9 = "LogUpload Service";
        r13 = new java.lang.StringBuilder;
        r14 = "nspContentRange";
        r13.<init>(r14);
        r13 = r13.append(r8);
        r13 = r13.toString();
        com.huawei.logupload.c.f.b(r9, r13);
        r9 = "nsp-content-range";
        r2.setRequestProperty(r9, r8);
        r9 = "nsp-content-range";
        r6.put(r9, r8);
        goto L_0x0169;
    L_0x035e:
        r8 = r4 + r10;
        r14 = 1;
        r8 = r8 - r14;
        r13 = new java.lang.StringBuilder;
        r14 = java.lang.String.valueOf(r4);
        r13.<init>(r14);
        r14 = "-";
        r13 = r13.append(r14);
        r8 = r13.append(r8);
        r9 = "/";
        r8 = r8.append(r9);
        r8 = r8.append(r7);
        r8 = r8.toString();
        r9 = "LogUpload Service";
        r13 = new java.lang.StringBuilder;
        r14 = "nspContentRange";
        r13.<init>(r14);
        r13 = r13.append(r8);
        r13 = r13.toString();
        com.huawei.logupload.c.f.b(r9, r13);
        r9 = "nsp-content-range";
        r2.setRequestProperty(r9, r8);
        r9 = "nsp-content-range";
        r6.put(r9, r8);
        goto L_0x0169;
    L_0x03a4:
        r7 = 0;
        r9.write(r13, r7, r5);	 Catch:{ RuntimeException -> 0x074b, IOException -> 0x0748, Exception -> 0x0745 }
        r4 = r4 + r5;
        r14 = (long) r4;
        r5 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r5 < 0) goto L_0x01df;
    L_0x03ae:
        goto L_0x01e6;
    L_0x03b0:
        r2 = move-exception;
        r2 = r7;
    L_0x03b2:
        r4 = r21.F();	 Catch:{ all -> 0x0740 }
        if (r4 == 0) goto L_0x03d3;
    L_0x03b8:
        r4 = r21.F();	 Catch:{ all -> 0x0740 }
        r5 = 4;
        if (r4 == r5) goto L_0x03d3;
    L_0x03bf:
        r3 = "LogUpload Service";
        r4 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r3, r4);
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r2, r3);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r2);
        r2 = -3;
        goto L_0x008b;
    L_0x03d3:
        if (r3 == 0) goto L_0x03e9;
    L_0x03d5:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0740 }
        r4 = r21.f();	 Catch:{ all -> 0x0740 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x0740 }
        r3.<init>(r4);	 Catch:{ all -> 0x0740 }
        r3 = r3.toString();	 Catch:{ all -> 0x0740 }
        com.huawei.logupload.c.h.b(r3);	 Catch:{ all -> 0x0740 }
    L_0x03e9:
        r3 = "LogUpload Service";
        r4 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r3, r4);
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r2, r3);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r2);
        r2 = -1;
        goto L_0x008b;
    L_0x03fd:
        r2 = move-exception;
        r6 = r7;
    L_0x03ff:
        r4 = "LogUpload Service";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x073d }
        r7 = "type = 1 IOException";
        r5.<init>(r7);	 Catch:{ all -> 0x073d }
        r2 = r2.getMessage();	 Catch:{ all -> 0x073d }
        r2 = r5.append(r2);	 Catch:{ all -> 0x073d }
        r2 = r2.toString();	 Catch:{ all -> 0x073d }
        com.huawei.logupload.c.f.b(r4, r2);	 Catch:{ all -> 0x073d }
        r2 = r21.F();	 Catch:{ all -> 0x073d }
        if (r2 == 0) goto L_0x0439;
    L_0x041e:
        r2 = r21.F();	 Catch:{ all -> 0x073d }
        r4 = 4;
        if (r2 == r4) goto L_0x0439;
    L_0x0425:
        r2 = "LogUpload Service";
        r3 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r2, r3);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r6, r2);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r2);
        r2 = -3;
        goto L_0x008b;
    L_0x0439:
        if (r3 == 0) goto L_0x044f;
    L_0x043b:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x073d }
        r4 = r21.f();	 Catch:{ all -> 0x073d }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x073d }
        r2.<init>(r3);	 Catch:{ all -> 0x073d }
        r2 = r2.toString();	 Catch:{ all -> 0x073d }
        com.huawei.logupload.c.h.b(r2);	 Catch:{ all -> 0x073d }
    L_0x044f:
        r2 = "LogUpload Service";
        r3 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r2, r3);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r6, r2);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r2);
        r2 = -1;
        goto L_0x008b;
    L_0x0463:
        r2 = move-exception;
        r6 = r7;
    L_0x0465:
        r2 = "LogUpload Service";
        r4 = "type = 1 Exception";
        com.huawei.logupload.c.f.b(r2, r4);	 Catch:{ all -> 0x073d }
        r2 = r21.F();	 Catch:{ all -> 0x073d }
        if (r2 == 0) goto L_0x048e;
    L_0x0473:
        r2 = r21.F();	 Catch:{ all -> 0x073d }
        r4 = 4;
        if (r2 == r4) goto L_0x048e;
    L_0x047a:
        r2 = "LogUpload Service";
        r3 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r2, r3);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r6, r2);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r2);
        r2 = -3;
        goto L_0x008b;
    L_0x048e:
        if (r3 == 0) goto L_0x04a4;
    L_0x0490:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x073d }
        r4 = r21.f();	 Catch:{ all -> 0x073d }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x073d }
        r2.<init>(r3);	 Catch:{ all -> 0x073d }
        r2 = r2.toString();	 Catch:{ all -> 0x073d }
        com.huawei.logupload.c.h.b(r2);	 Catch:{ all -> 0x073d }
    L_0x04a4:
        r2 = "LogUpload Service";
        r3 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r2, r3);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r6, r2);
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r2);
        r2 = -1;
        goto L_0x008b;
    L_0x04b8:
        r2 = move-exception;
        r6 = r7;
    L_0x04ba:
        r3 = "LogUpload Service";
        r4 = "CommonUtils.closeDataOutputStream";
        com.huawei.logupload.c.f.b(r3, r4);
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r6, r3);
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r9, r3);
        throw r2;
    L_0x04cc:
        r14 = new java.lang.String;	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r15 = 0;
        r16 = "utf-8";
        r0 = r16;
        r14.<init>(r12, r15, r13, r0);	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        r2.append(r14);	 Catch:{ IOException -> 0x04dc, RuntimeException -> 0x070d, Exception -> 0x06fd }
        goto L_0x0293;
    L_0x04dc:
        r2 = move-exception;
        r18 = r2;
        r2 = r4;
        r4 = r18;
    L_0x04e2:
        r12 = "LogUpload Service";
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0620 }
        r14 = "uploading 获取服务器响应  IOException";
        r13.<init>(r14);	 Catch:{ all -> 0x0620 }
        r14 = r4.getMessage();	 Catch:{ all -> 0x0620 }
        r13 = r13.append(r14);	 Catch:{ all -> 0x0620 }
        r13 = r13.toString();	 Catch:{ all -> 0x0620 }
        com.huawei.logupload.c.f.b(r12, r13);	 Catch:{ all -> 0x0620 }
        r12 = "LogUpload Service";
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0620 }
        r14 = "code = ";
        r13.<init>(r14);	 Catch:{ all -> 0x0620 }
        r13 = r13.append(r2);	 Catch:{ all -> 0x0620 }
        r14 = "mLogUploadInfo.getUserType()";
        r13 = r13.append(r14);	 Catch:{ all -> 0x0620 }
        r14 = r21.F();	 Catch:{ all -> 0x0620 }
        r13 = r13.append(r14);	 Catch:{ all -> 0x0620 }
        r13 = r13.toString();	 Catch:{ all -> 0x0620 }
        com.huawei.logupload.c.f.b(r12, r13);	 Catch:{ all -> 0x0620 }
        r4.printStackTrace();	 Catch:{ all -> 0x0620 }
        r4 = "LogUpload Service";
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0620 }
        r13 = "afterTime - beforeTime:";
        r12.<init>(r13);	 Catch:{ all -> 0x0620 }
        r14 = r8 - r10;
        r12 = r12.append(r14);	 Catch:{ all -> 0x0620 }
        r12 = r12.toString();	 Catch:{ all -> 0x0620 }
        com.huawei.logupload.c.f.d(r4, r12);	 Catch:{ all -> 0x0620 }
        r8 = r8 - r10;
        r10 = 600000; // 0x927c0 float:8.40779E-40 double:2.964394E-318;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 < 0) goto L_0x05e0;
    L_0x053e:
        if (r6 != 0) goto L_0x05e0;
    L_0x0540:
        if (r5 != 0) goto L_0x05e0;
    L_0x0542:
        r4 = com.huawei.logupload.c.c.c();	 Catch:{ all -> 0x0620 }
        r4.clear();	 Catch:{ all -> 0x0620 }
        r4 = 0;
        com.huawei.logupload.c.c.a(r4);	 Catch:{ all -> 0x0620 }
        com.huawei.logupload.c.h.e();	 Catch:{ all -> 0x0620 }
        r4 = com.huawei.logupload.c.c.i();	 Catch:{ all -> 0x0620 }
        r5 = 1;
        if (r4 == r5) goto L_0x05f9;
    L_0x0557:
        r4 = new android.content.Intent;	 Catch:{ all -> 0x0620 }
        r4.<init>();	 Catch:{ all -> 0x0620 }
        r5 = "com.example.logupload.progress";
        r4.setAction(r5);	 Catch:{ all -> 0x0620 }
        r5 = r21.C();	 Catch:{ all -> 0x0620 }
        r4.setPackage(r5);	 Catch:{ all -> 0x0620 }
        r5 = "exception";
        r6 = "2";
        r4.putExtra(r5, r6);	 Catch:{ all -> 0x0620 }
        r5 = "mLogUploadInfo";
        r0 = r21;
        r4.putExtra(r5, r0);	 Catch:{ all -> 0x0620 }
        r5 = "exception";
        r6 = "2";
        com.huawei.logupload.c.f.a(r5, r6);	 Catch:{ all -> 0x0620 }
        r5 = com.huawei.logupload.c.b.a();	 Catch:{ all -> 0x0620 }
        r5 = r5.b();	 Catch:{ all -> 0x0620 }
        r5 = r5.getBaseContext();	 Catch:{ all -> 0x0620 }
        r5.sendBroadcast(r4);	 Catch:{ all -> 0x0620 }
    L_0x058c:
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        android.os.SystemClock.sleep(r4);	 Catch:{ all -> 0x0620 }
        r4 = "LogUpload Service";
        r5 = "start to kill process!";
        com.huawei.logupload.c.f.d(r4, r5);	 Catch:{ all -> 0x0620 }
        r4 = com.huawei.logupload.c.c.c();	 Catch:{ all -> 0x0620 }
        r4.clear();	 Catch:{ all -> 0x0620 }
        r4 = 0;
        com.huawei.logupload.c.c.a(r4);	 Catch:{ all -> 0x0620 }
        r4 = -1;
        com.huawei.logupload.c.c.c(r4);	 Catch:{ all -> 0x0620 }
        r4 = 0;
        com.huawei.logupload.c.c.b(r4);	 Catch:{ all -> 0x0620 }
        r4 = com.huawei.logupload.c.b.a();	 Catch:{ all -> 0x0620 }
        r4 = r4.b();	 Catch:{ all -> 0x0620 }
        r5 = new android.content.Intent;	 Catch:{ all -> 0x0620 }
        r6 = com.huawei.logupload.c.b.a();	 Catch:{ all -> 0x0620 }
        r6 = r6.b();	 Catch:{ all -> 0x0620 }
        r8 = com.huawei.logupload.LogUploadReceive.class;
        r5.<init>(r6, r8);	 Catch:{ all -> 0x0620 }
        r4.stopService(r5);	 Catch:{ all -> 0x0620 }
        r4 = com.huawei.logupload.c.b.a();	 Catch:{ all -> 0x0620 }
        r4 = r4.b();	 Catch:{ all -> 0x0620 }
        r5 = new android.content.Intent;	 Catch:{ all -> 0x0620 }
        r6 = com.huawei.logupload.c.b.a();	 Catch:{ all -> 0x0620 }
        r6 = r6.b();	 Catch:{ all -> 0x0620 }
        r8 = com.huawei.logupload.LogUploadService.class;
        r5.<init>(r6, r8);	 Catch:{ all -> 0x0620 }
        r4.stopService(r5);	 Catch:{ all -> 0x0620 }
    L_0x05e0:
        r4 = r21.F();	 Catch:{ all -> 0x0620 }
        if (r4 == 0) goto L_0x0627;
    L_0x05e6:
        r4 = r21.F();	 Catch:{ all -> 0x0620 }
        r5 = 4;
        if (r4 == r5) goto L_0x0627;
    L_0x05ed:
        r3 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 == r3) goto L_0x0649;
    L_0x05f1:
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r7, r2);
        r2 = -3;
        goto L_0x008b;
    L_0x05f9:
        r4 = new android.content.Intent;	 Catch:{ all -> 0x0620 }
        r5 = "com.huawei.phoneservice.AUTOUPLOAD_DELETE";
        r4.<init>(r5);	 Catch:{ all -> 0x0620 }
        r5 = com.huawei.logupload.c.b.a();	 Catch:{ all -> 0x0620 }
        r5 = r5.b();	 Catch:{ all -> 0x0620 }
        r6 = "com.huawei.feedback.component.AutoUploadService";
        r4.setClassName(r5, r6);	 Catch:{ all -> 0x0620 }
        r5 = "isuploadsuccess";
        r6 = 0;
        r4.putExtra(r5, r6);	 Catch:{ all -> 0x0620 }
        r5 = com.huawei.logupload.c.b.a();	 Catch:{ all -> 0x0620 }
        r5 = r5.b();	 Catch:{ all -> 0x0620 }
        r5.startService(r4);	 Catch:{ all -> 0x0620 }
        goto L_0x058c;
    L_0x0620:
        r2 = move-exception;
    L_0x0621:
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r7, r3);
        throw r2;
    L_0x0627:
        r4 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 == r4) goto L_0x0649;
    L_0x062b:
        if (r3 == 0) goto L_0x0641;
    L_0x062d:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0620 }
        r4 = r21.f();	 Catch:{ all -> 0x0620 }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x0620 }
        r2.<init>(r3);	 Catch:{ all -> 0x0620 }
        r2 = r2.toString();	 Catch:{ all -> 0x0620 }
        com.huawei.logupload.c.h.b(r2);	 Catch:{ all -> 0x0620 }
    L_0x0641:
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r7, r2);
        r2 = -1;
        goto L_0x008b;
    L_0x0649:
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r7, r3);
        goto L_0x008b;
    L_0x0650:
        r2 = move-exception;
        r4 = r2;
        r2 = r12;
    L_0x0653:
        r5 = "LogUpload Service";
        r6 = "Uploading RuntimeException";
        com.huawei.logupload.c.f.b(r5, r6);	 Catch:{ all -> 0x06f2 }
        r4.printStackTrace();	 Catch:{ all -> 0x06f2 }
        r4 = r21.F();	 Catch:{ all -> 0x06f2 }
        if (r4 == 0) goto L_0x0676;
    L_0x0663:
        r4 = r21.F();	 Catch:{ all -> 0x06f2 }
        r5 = 4;
        if (r4 == r5) goto L_0x0676;
    L_0x066a:
        r3 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 == r3) goto L_0x0698;
    L_0x066e:
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r13, r2);
        r2 = -3;
        goto L_0x008b;
    L_0x0676:
        r4 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 == r4) goto L_0x0698;
    L_0x067a:
        if (r3 == 0) goto L_0x0690;
    L_0x067c:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x06f2 }
        r4 = r21.f();	 Catch:{ all -> 0x06f2 }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x06f2 }
        r2.<init>(r3);	 Catch:{ all -> 0x06f2 }
        r2 = r2.toString();	 Catch:{ all -> 0x06f2 }
        com.huawei.logupload.c.h.b(r2);	 Catch:{ all -> 0x06f2 }
    L_0x0690:
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r13, r2);
        r2 = -1;
        goto L_0x008b;
    L_0x0698:
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r13, r3);
        goto L_0x008b;
    L_0x069f:
        r2 = move-exception;
        r4 = r2;
        r2 = r12;
    L_0x06a2:
        r4.printStackTrace();	 Catch:{ all -> 0x06f2 }
        r4 = "LogUpload Service";
        r5 = "Uploading Exception";
        com.huawei.logupload.c.f.b(r4, r5);	 Catch:{ all -> 0x06f2 }
        r4 = r21.F();	 Catch:{ all -> 0x06f2 }
        if (r4 == 0) goto L_0x06c5;
    L_0x06b2:
        r4 = r21.F();	 Catch:{ all -> 0x06f2 }
        r5 = 4;
        if (r4 == r5) goto L_0x06c5;
    L_0x06b9:
        r3 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 == r3) goto L_0x06e7;
    L_0x06bd:
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r13, r2);
        r2 = -3;
        goto L_0x008b;
    L_0x06c5:
        r4 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 == r4) goto L_0x06e7;
    L_0x06c9:
        if (r3 == 0) goto L_0x06df;
    L_0x06cb:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x06f2 }
        r4 = r21.f();	 Catch:{ all -> 0x06f2 }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x06f2 }
        r2.<init>(r3);	 Catch:{ all -> 0x06f2 }
        r2 = r2.toString();	 Catch:{ all -> 0x06f2 }
        com.huawei.logupload.c.h.b(r2);	 Catch:{ all -> 0x06f2 }
    L_0x06df:
        r2 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r13, r2);
        r2 = -1;
        goto L_0x008b;
    L_0x06e7:
        r3 = "LogUpload Service";
        com.huawei.logupload.c.h.a(r13, r3);
        goto L_0x008b;
    L_0x06ee:
        r2 = move-exception;
        r7 = r13;
        goto L_0x0621;
    L_0x06f2:
        r2 = move-exception;
        r7 = r13;
        goto L_0x0621;
    L_0x06f6:
        r2 = move-exception;
        r18 = r2;
        r2 = r4;
        r4 = r18;
        goto L_0x06a2;
    L_0x06fd:
        r2 = move-exception;
        r13 = r7;
        r18 = r4;
        r4 = r2;
        r2 = r18;
        goto L_0x06a2;
    L_0x0705:
        r2 = move-exception;
        r18 = r2;
        r2 = r4;
        r4 = r18;
        goto L_0x0653;
    L_0x070d:
        r2 = move-exception;
        r13 = r7;
        r18 = r4;
        r4 = r2;
        r2 = r18;
        goto L_0x0653;
    L_0x0716:
        r2 = move-exception;
        r10 = r6;
        r6 = r5;
        r7 = r13;
        r5 = r4;
        r4 = r2;
        r2 = r12;
        goto L_0x04e2;
    L_0x071f:
        r2 = move-exception;
        r6 = r5;
        r7 = r13;
        r5 = r4;
        r4 = r2;
        r2 = r12;
        goto L_0x04e2;
    L_0x0727:
        r2 = move-exception;
        r5 = r4;
        r7 = r13;
        r4 = r2;
        r2 = r12;
        goto L_0x04e2;
    L_0x072e:
        r2 = move-exception;
        r4 = r2;
        r7 = r13;
        r2 = r12;
        goto L_0x04e2;
    L_0x0734:
        r2 = move-exception;
        r7 = r13;
        r18 = r4;
        r4 = r2;
        r2 = r18;
        goto L_0x04e2;
    L_0x073d:
        r2 = move-exception;
        goto L_0x04ba;
    L_0x0740:
        r3 = move-exception;
        r6 = r2;
        r2 = r3;
        goto L_0x04ba;
    L_0x0745:
        r2 = move-exception;
        goto L_0x0465;
    L_0x0748:
        r2 = move-exception;
        goto L_0x03ff;
    L_0x074b:
        r2 = move-exception;
        r2 = r6;
        goto L_0x03b2;
    L_0x074f:
        r4 = r8;
        goto L_0x01df;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.logupload.p.a(java.io.File, com.huawei.logupload.LogUpload):int");
    }

    private String m26121a(LogUpload logUpload, TreeMap<String, String> treeMap) {
        String str;
        int u = logUpload.u();
        String str2 = HttpPut.METHOD_NAME;
        String str3 = "";
        StringBuffer stringBuffer = new StringBuffer();
        Set keySet = treeMap.keySet();
        if (keySet != null) {
            for (Object next : keySet) {
                Object obj = treeMap.get(next);
                stringBuffer.append(SNBConstant.FILTER);
                stringBuffer.append(next.toString().toLowerCase());
                stringBuffer.append("=");
                stringBuffer.append(obj.toString());
            }
        }
        str3 = stringBuffer.substring(1).toString();
        if (u == 2) {
            str = logUpload.p() + "?resume";
        } else {
            str = logUpload.p();
        }
        try {
            str = new StringBuilder(String.valueOf(str2)).append(SNBConstant.FILTER).append(URLEncoder.encode(str, GameManager.DEFAULT_CHARSET)).append(SNBConstant.FILTER).append(URLEncoder.encode(str3, GameManager.DEFAULT_CHARSET)).toString();
        } catch (UnsupportedEncodingException e) {
            str = null;
        }
        str2 = logUpload.n();
        if (str2 == null) {
            return null;
        }
        byte[] a;
        try {
            a = C5441e.m26093a(str, str2);
        } catch (Exception e2) {
            a = null;
        }
        if (a != null) {
            return Base64.encodeToString(a, 2);
        }
        return null;
    }

    private long m26120a(LogUpload logUpload) {
        long j = 0;
        String v = logUpload.v();
        if (v != null) {
            f.b("LogUpload Service", "completeRange" + v);
            String[] split = v.split("]");
            for (String substring : split) {
                String[] split2 = substring.substring(1).split(",");
                int intValue = Integer.valueOf(split2[0]).intValue();
                int intValue2 = Integer.valueOf(split2[1]).intValue();
                if (intValue == 0) {
                    j = (long) (intValue2 + 1);
                }
            }
        }
        return j;
    }

    public static void m26122a(String str, LogUpload logUpload) {
        Object obj = null;
        f.b("LogUpload Service", "rsp = " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    String stringBuffer;
                    int i = jSONObject.getInt("upload_status");
                    if (i == 2) {
                        f.b("LogUpload Service", "断点文件不存在，需要重新上传");
                    } else if (i == 1) {
                        try {
                            JSONArray jSONArray = jSONObject.getJSONArray("completed_range");
                            StringBuffer stringBuffer2 = new StringBuffer();
                            f.b("LogUpload Service", "rangeArray.length()" + jSONArray.length());
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                obj = new StringBuilder(String.valueOf(obj)).append(jSONArray.getJSONArray(i2).toString()).toString();
                                stringBuffer2.append(jSONArray.getJSONArray(i2).toString());
                                f.b("LogUpload Service", "rangeArray :" + jSONArray.getJSONArray(i2).toString());
                            }
                            stringBuffer = stringBuffer2.toString();
                        } catch (JSONException e) {
                            f.b("LogUpload Service", "JSONException");
                        }
                    }
                    f.b("LogUpload Service", "contentRanger" + stringBuffer);
                    logUpload.n(stringBuffer);
                    c cVar = new c(b.a().b().getBaseContext());
                    synchronized (com.huawei.logupload.c.c.a) {
                        a.a(cVar, logUpload, false);
                    }
                } catch (Exception e2) {
                    if (f.a(4)) {
                        f.d("LogUpload Service", e2.getMessage());
                    }
                }
            } catch (JSONException e3) {
                if (f.a(4)) {
                    f.d("LogUpload Service", e3.getMessage());
                }
            }
        } else if (f.a(4)) {
            f.d("LogUpload Service", "Input param invalid.");
        }
    }
}
