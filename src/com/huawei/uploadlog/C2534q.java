package com.huawei.uploadlog;

import android.util.Base64;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.uploadlog.p186a.C2496a;
import com.huawei.uploadlog.p186a.C2497b;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2510f;
import com.huawei.uploadlog.p188c.C2511g;
import com.sina.weibo.sdk.component.GameManager;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Uploading */
public class C2534q {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m12641a(java.io.File r24, com.huawei.uploadlog.LogUpload r25) throws java.lang.Exception {
        /*
        r23 = this;
        r11 = new java.util.TreeMap;
        r11.<init>();
        r8 = r25.getCallbackAddress();
        r9 = r25.getTimeStamp();
        r4 = r24.length();
        r12 = java.lang.String.valueOf(r4);
        r4 = "BETACLUB_SDK";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "[Uploading.upload] nspFileSize=";
        r5 = r5.append(r6);
        r5 = r5.append(r12);
        r5 = r5.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r4, r5);
        r4 = r24.length();
        r6 = 1024000; // 0xfa000 float:1.43493E-39 double:5.05923E-318;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 < 0) goto L_0x00b5;
    L_0x0038:
        r4 = 1;
        r5 = r4;
    L_0x003a:
        r4 = "http://";
        r6 = com.huawei.uploadlog.p188c.C2507c.m12466f();
        r7 = 1;
        if (r6 != r7) goto L_0x00b8;
    L_0x0043:
        r6 = 4096000; // 0x3e8000 float:5.739719E-39 double:2.023693E-317;
    L_0x0046:
        r14 = r24.length();
        r13 = r25.getType();
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r4 = r10.append(r4);
        r10 = r25.getUploadAddress();
        r4 = r4.append(r10);
        r10 = r25.getUploadPath();
        r4 = r4.append(r10);
        r4 = r4.toString();
        r10 = 2;
        if (r13 != r10) goto L_0x0081;
    L_0x006e:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r4 = r10.append(r4);
        r10 = "?resume";
        r4 = r4.append(r10);
        r4 = r4.toString();
    L_0x0081:
        r10 = "BETACLUB_SDK";
        r16 = new java.lang.StringBuilder;
        r16.<init>();
        r17 = "[Uploading.upload] actionUrl=";
        r16 = r16.append(r17);
        r0 = r16;
        r16 = r0.append(r4);
        r16 = r16.toString();
        r0 = r16;
        com.huawei.uploadlog.p188c.C2511g.m12481b(r10, r0);
        r10 = "http.keepAlive";
        r16 = "false";
        r0 = r16;
        java.lang.System.setProperty(r10, r0);
        r10 = new java.net.URL;
        r10.<init>(r4);
        r4 = r10.openConnection();
        r4 = (java.net.HttpURLConnection) r4;
        if (r4 != 0) goto L_0x00bc;
    L_0x00b3:
        r4 = -1;
    L_0x00b4:
        return r4;
    L_0x00b5:
        r4 = 0;
        r5 = r4;
        goto L_0x003a;
    L_0x00b8:
        r6 = 1024000; // 0xfa000 float:1.43493E-39 double:5.05923E-318;
        goto L_0x0046;
    L_0x00bc:
        r10 = com.huawei.uploadlog.p188c.C2517m.m12560a(r14);
        r4.setConnectTimeout(r10);
        r10 = com.huawei.uploadlog.p188c.C2517m.m12560a(r14);
        r4.setReadTimeout(r10);
        r10 = 1;
        r4.setDoInput(r10);
        r10 = 1;
        r4.setDoOutput(r10);
        r10 = 0;
        r4.setUseCaches(r10);
        r10 = "PUT";
        r4.setRequestMethod(r10);
        r10 = "Connection";
        r16 = "Keep-Alive";
        r0 = r16;
        r4.setRequestProperty(r10, r0);
        r10 = "Charset";
        r16 = "UTF-8";
        r0 = r16;
        r4.setRequestProperty(r10, r0);
        r10 = "Content-Type";
        r16 = "binary/octet-stream";
        r0 = r16;
        r4.setRequestProperty(r10, r0);
        r10 = "Expect";
        r16 = "100-continue";
        r0 = r16;
        r4.setRequestProperty(r10, r0);
        r10 = "User-Agent";
        r16 = "PHONE_SERVICE";
        r0 = r16;
        r4.setRequestProperty(r10, r0);
        r10 = r8.length();
        if (r10 <= 0) goto L_0x0144;
    L_0x010e:
        r10 = "nsp-callback";
        r4.setRequestProperty(r10, r8);
        r10 = "nsp-callback-status";
        r16 = "200";
        r0 = r16;
        r4.setRequestProperty(r10, r0);
        r10 = "nsp-callback";
        r11.put(r10, r8);
        r10 = "nsp-callback-Status";
        r16 = "200";
        r0 = r16;
        r11.put(r10, r0);
        r10 = "BETACLUB_SDK";
        r16 = new java.lang.StringBuilder;
        r16.<init>();
        r17 = "nspCallback";
        r16 = r16.append(r17);
        r0 = r16;
        r8 = r0.append(r8);
        r8 = r8.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r10, r8);
    L_0x0144:
        r8 = "nsp-ts";
        r4.setRequestProperty(r8, r9);
        r8 = "nsp-ts";
        r11.put(r8, r9);
        r8 = "BETACLUB_SDK";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r16 = "nspTs";
        r0 = r16;
        r10 = r10.append(r0);
        r9 = r10.append(r9);
        r9 = r9.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r8, r9);
        r8 = "BETACLUB_SDK";
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "[Uploading.upload] type=";
        r9 = r9.append(r10);
        r9 = r9.append(r13);
        r9 = r9.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r8, r9);
        r8 = 0;
        if (r13 != 0) goto L_0x03b5;
    L_0x0184:
        r10 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r10 <= 0) goto L_0x03b5;
    L_0x0188:
        r14 = 1;
        r14 = r6 - r14;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r10 = r10.append(r8);
        r16 = "-";
        r0 = r16;
        r10 = r10.append(r0);
        r10 = r10.append(r14);
        r14 = "/";
        r10 = r10.append(r14);
        r10 = r10.append(r12);
        r10 = r10.toString();
        r14 = "BETACLUB_SDK";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r16 = "nspContentRange";
        r15 = r15.append(r16);
        r15 = r15.append(r10);
        r15 = r15.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);
        r14 = "nsp-content-range";
        r4.setRequestProperty(r14, r10);
        r14 = "nsp-content-range";
        r11.put(r14, r10);
    L_0x01d1:
        r10 = r25.getMd5String();
        r14 = com.huawei.androidcommon.utils.StringUtils.isNullOrEmpty(r10);
        if (r14 == 0) goto L_0x01e4;
    L_0x01db:
        r10 = com.huawei.uploadlog.p188c.C2512h.m12486a(r24);
        r0 = r25;
        r0.setMd5String(r10);
    L_0x01e4:
        r16 = r24.getAbsolutePath();
        r14 = "BETACLUB_SDK";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r17 = "[Uploading.upload] file.getAbsolutePath()=";
        r0 = r17;
        r15 = r15.append(r0);
        r17 = r24.getAbsolutePath();
        r0 = r17;
        r15 = r15.append(r0);
        r15 = r15.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);
        r14 = "BETACLUB_SDK";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r17 = "[Uploading.upload] nspFileMd5=";
        r0 = r17;
        r15 = r15.append(r0);
        r15 = r15.append(r10);
        r15 = r15.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);
        r14 = "nsp-file-md5";
        r4.setRequestProperty(r14, r10);
        r14 = "nsp-file-md5";
        r11.put(r14, r10);
        r10 = "BETACLUB_SDK";
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r15 = "[Uploading.upload] nspFileSize=";
        r14 = r14.append(r15);
        r14 = r14.append(r12);
        r14 = r14.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r10, r14);
        r10 = "nsp-file-size";
        r4.setRequestProperty(r10, r12);
        r10 = "nsp-file-size";
        r11.put(r10, r12);
        r0 = r23;
        r1 = r25;
        r10 = r0.m12639a(r1, r11);
        r11 = "nsp-sig";
        r4.setRequestProperty(r11, r10);
        r11 = "BETACLUB_SDK";
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r14 = "[Uploading.upload] nsp_sig=";
        r12 = r12.append(r14);
        r10 = r12.append(r10);
        r10 = r10.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r11, r10);
        r10 = 2;
        if (r13 == r10) goto L_0x02eb;
    L_0x0276:
        r14 = new java.io.DataOutputStream;
        r10 = r4.getOutputStream();
        r14.<init>(r10);
        r10 = "BETACLUB_SDK";
        r11 = "[Uploading.upload] getOutputStream";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r10, r11);
        r11 = 0;
        r10 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r15 = new byte[r10];
        r12 = 0;
        r10 = new java.io.FileInputStream;	 Catch:{ RuntimeException -> 0x04b8, IOException -> 0x04f4, Exception -> 0x0545, all -> 0x0581 }
        r0 = r24;
        r10.<init>(r0);	 Catch:{ RuntimeException -> 0x04b8, IOException -> 0x04f4, Exception -> 0x0545, all -> 0x0581 }
        r11 = 1;
        if (r13 != r11) goto L_0x02b4;
    L_0x0296:
        r8 = r10.skip(r8);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r11 = "BETACLUB_SDK";
        r13 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r13.<init>();	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r17 = "[Uploading.upload] skip=";
        r0 = r17;
        r13 = r13.append(r0);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r8 = r13.append(r8);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r8 = r8.toString();	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r11, r8);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
    L_0x02b4:
        r8 = r12;
    L_0x02b5:
        r9 = r10.read(r15);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r11 = -1;
        if (r9 == r11) goto L_0x02c9;
    L_0x02bc:
        r11 = 0;
        r14.write(r15, r11, r9);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r14.flush();	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r8 = r8 + r9;
        r12 = (long) r8;	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r9 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r9 < 0) goto L_0x02b5;
    L_0x02c9:
        r6 = "BETACLUB_SDK";
        r7 = "[Uploading.upload] ds.flush()";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r6, r7);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r14.flush();	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r6 = "BETACLUB_SDK";
        r7 = "[Uploading.upload] ds.flush() end";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r6, r7);	 Catch:{ RuntimeException -> 0x07ec, IOException -> 0x07e9, Exception -> 0x07e6 }
        r6 = "BETACLUB_SDK";
        r7 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r6, r7);
        r6 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r10, r6);
        r6 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r6);
    L_0x02eb:
        r15 = 0;
        r14 = -1;
        r8 = 0;
        r10 = 0;
        r7 = 0;
        r6 = 0;
        r12 = "BETACLUB_SDK";
        r13 = " statusLine before";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r12, r13);	 Catch:{ IOException -> 0x07b8, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x07b8, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r8 = 0;
        r8 = r4.getHeaderField(r8);	 Catch:{ IOException -> 0x07c1, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r7 = "BETACLUB_SDK";
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x07c9, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r9.<init>();	 Catch:{ IOException -> 0x07c9, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r17 = "statusLine";
        r0 = r17;
        r9 = r9.append(r0);	 Catch:{ IOException -> 0x07c9, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r9 = r9.append(r8);	 Catch:{ IOException -> 0x07c9, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r9 = r9.toString();	 Catch:{ IOException -> 0x07c9, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r7, r9);	 Catch:{ IOException -> 0x07c9, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r7 = 0;
        r7 = r4.getHeaderField(r7);	 Catch:{ IOException -> 0x07c9, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r6 = "BETACLUB_SDK";
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r9.<init>();	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r17 = "statusLine2";
        r0 = r17;
        r9 = r9.append(r0);	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r9 = r9.append(r7);	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r9 = r9.toString();	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r6, r9);	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r6 = r4.getResponseCode();	 Catch:{ IOException -> 0x07d0, RuntimeException -> 0x0724, Exception -> 0x0759, all -> 0x078e }
        r9 = "BETACLUB_SDK";
        r14 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x07d6, RuntimeException -> 0x07a7, Exception -> 0x0798, all -> 0x078e }
        r14.<init>();	 Catch:{ IOException -> 0x07d6, RuntimeException -> 0x07a7, Exception -> 0x0798, all -> 0x078e }
        r17 = "返回码";
        r0 = r17;
        r14 = r14.append(r0);	 Catch:{ IOException -> 0x07d6, RuntimeException -> 0x07a7, Exception -> 0x0798, all -> 0x078e }
        r14 = r14.append(r6);	 Catch:{ IOException -> 0x07d6, RuntimeException -> 0x07a7, Exception -> 0x0798, all -> 0x078e }
        r14 = r14.toString();	 Catch:{ IOException -> 0x07d6, RuntimeException -> 0x07a7, Exception -> 0x0798, all -> 0x078e }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r9, r14);	 Catch:{ IOException -> 0x07d6, RuntimeException -> 0x07a7, Exception -> 0x0798, all -> 0x078e }
        r9 = r4.getInputStream();	 Catch:{ IOException -> 0x07d6, RuntimeException -> 0x07a7, Exception -> 0x0798, all -> 0x078e }
        r4 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r4.<init>();	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r14 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r14 = new byte[r14];	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
    L_0x036c:
        r15 = r9.read(r14);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r17 = -1;
        r0 = r17;
        if (r0 != r15) goto L_0x0595;
    L_0x0376:
        r14 = "BETACLUB_SDK";
        r15 = "读取完毕";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r14 = "BETACLUB_SDK";
        r15 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r15.<init>();	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r17 = "读取完成 ";
        r0 = r17;
        r15 = r15.append(r0);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r15 = r15.append(r4);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r15 = r15.toString();	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r14 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
        if (r6 != r14) goto L_0x03ad;
    L_0x03a1:
        r14 = "BETACLUB_SDK";
        r15 = "parserContentRange";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r0 = r25;
        com.huawei.uploadlog.C2534q.m12640a(r4, r0);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
    L_0x03ad:
        r4 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r4);
        r4 = r6;
        goto L_0x00b4;
    L_0x03b5:
        r10 = 1;
        if (r13 != r10) goto L_0x01d1;
    L_0x03b8:
        r8 = r24.length();
        r14 = 1;
        r14 = r8 - r14;
        r8 = "BETACLUB_SDK";
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "[Uploading.upload] endPos=";
        r9 = r9.append(r10);
        r9 = r9.append(r14);
        r9 = r9.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r8, r9);
        r0 = r23;
        r1 = r25;
        r8 = r0.m12638a(r1);
        r10 = "BETACLUB_SDK";
        r16 = new java.lang.StringBuilder;
        r16.<init>();
        r17 = "[Uploading.upload] startPos=";
        r16 = r16.append(r17);
        r0 = r16;
        r16 = r0.append(r8);
        r16 = r16.toString();
        r0 = r16;
        com.huawei.uploadlog.p188c.C2511g.m12481b(r10, r0);
        r16 = r14 - r8;
        r18 = 1;
        r16 = r16 + r18;
        r10 = "BETACLUB_SDK";
        r18 = new java.lang.StringBuilder;
        r18.<init>();
        r19 = "[Uploading.upload] transferTotalLength=";
        r18 = r18.append(r19);
        r0 = r18;
        r1 = r16;
        r18 = r0.append(r1);
        r18 = r18.toString();
        r0 = r18;
        com.huawei.uploadlog.p188c.C2511g.m12481b(r10, r0);
        r10 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1));
        if (r10 > 0) goto L_0x046b;
    L_0x0424:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r10 = r10.append(r8);
        r16 = "-";
        r0 = r16;
        r10 = r10.append(r0);
        r10 = r10.append(r14);
        r14 = "/";
        r10 = r10.append(r14);
        r10 = r10.append(r12);
        r10 = r10.toString();
        r14 = "BETACLUB_SDK";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r16 = "[Uploading.upload] nspContentRange=";
        r15 = r15.append(r16);
        r15 = r15.append(r10);
        r15 = r15.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);
        r14 = "nsp-content-range";
        r4.setRequestProperty(r14, r10);
        r14 = "nsp-content-range";
        r11.put(r14, r10);
        goto L_0x01d1;
    L_0x046b:
        r14 = r8 + r6;
        r16 = 1;
        r14 = r14 - r16;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r10 = r10.append(r8);
        r16 = "-";
        r0 = r16;
        r10 = r10.append(r0);
        r10 = r10.append(r14);
        r14 = "/";
        r10 = r10.append(r14);
        r10 = r10.append(r12);
        r10 = r10.toString();
        r14 = "BETACLUB_SDK";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r16 = "[Uploading.upload] nspContentRange=";
        r15 = r15.append(r16);
        r15 = r15.append(r10);
        r15 = r15.toString();
        com.huawei.uploadlog.p188c.C2511g.m12481b(r14, r15);
        r14 = "nsp-content-range";
        r4.setRequestProperty(r14, r10);
        r14 = "nsp-content-range";
        r11.put(r14, r10);
        goto L_0x01d1;
    L_0x04b8:
        r4 = move-exception;
        r6 = r11;
    L_0x04ba:
        r7 = "BetaClub Upload";
        r8 = "[Uploading.upload] error:";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r7, r8, r4);	 Catch:{ all -> 0x07e2 }
        r4 = r25.getUserType();	 Catch:{ all -> 0x07e2 }
        if (r4 == 0) goto L_0x04db;
    L_0x04c7:
        r4 = -3;
        r5 = "BETACLUB_SDK";
        r7 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r7);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r6, r5);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r5);
        goto L_0x00b4;
    L_0x04db:
        if (r5 == 0) goto L_0x04e0;
    L_0x04dd:
        com.huawei.uploadlog.p188c.C2517m.m12582c(r25);	 Catch:{ all -> 0x07e2 }
    L_0x04e0:
        r4 = -1;
        r5 = "BETACLUB_SDK";
        r7 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r7);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r6, r5);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r5);
        goto L_0x00b4;
    L_0x04f4:
        r4 = move-exception;
        r10 = r11;
    L_0x04f6:
        r6 = "BETACLUB_SDK";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x07df }
        r7.<init>();	 Catch:{ all -> 0x07df }
        r8 = "[Uploading.upload] type = 1 IOException";
        r7 = r7.append(r8);	 Catch:{ all -> 0x07df }
        r8 = r4.getMessage();	 Catch:{ all -> 0x07df }
        r7 = r7.append(r8);	 Catch:{ all -> 0x07df }
        r7 = r7.toString();	 Catch:{ all -> 0x07df }
        com.huawei.uploadlog.p188c.C2511g.m12482b(r6, r7, r4);	 Catch:{ all -> 0x07df }
        r4 = r25.getUserType();	 Catch:{ all -> 0x07df }
        if (r4 == 0) goto L_0x052c;
    L_0x0518:
        r4 = -3;
        r5 = "BETACLUB_SDK";
        r6 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r6);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r10, r5);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r5);
        goto L_0x00b4;
    L_0x052c:
        if (r5 == 0) goto L_0x0531;
    L_0x052e:
        com.huawei.uploadlog.p188c.C2517m.m12582c(r25);	 Catch:{ all -> 0x07df }
    L_0x0531:
        r4 = -1;
        r5 = "BETACLUB_SDK";
        r6 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r6);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r10, r5);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r5);
        goto L_0x00b4;
    L_0x0545:
        r4 = move-exception;
        r10 = r11;
    L_0x0547:
        r6 = "BETACLUB_SDK";
        r7 = "[Uploading.upload] type = 1 Exception";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r6, r7, r4);	 Catch:{ all -> 0x07df }
        r4 = r25.getUserType();	 Catch:{ all -> 0x07df }
        if (r4 == 0) goto L_0x0568;
    L_0x0554:
        r4 = -3;
        r5 = "BETACLUB_SDK";
        r6 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r6);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r10, r5);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r5);
        goto L_0x00b4;
    L_0x0568:
        if (r5 == 0) goto L_0x056d;
    L_0x056a:
        com.huawei.uploadlog.p188c.C2517m.m12582c(r25);	 Catch:{ all -> 0x07df }
    L_0x056d:
        r4 = -1;
        r5 = "BETACLUB_SDK";
        r6 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r6);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r10, r5);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r5);
        goto L_0x00b4;
    L_0x0581:
        r4 = move-exception;
        r10 = r11;
    L_0x0583:
        r5 = "BETACLUB_SDK";
        r6 = "[Uploading.upload] CommonUtils.close";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r6);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r10, r5);
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r14, r5);
        throw r4;
    L_0x0595:
        r17 = new java.lang.String;	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r18 = 0;
        r19 = "utf-8";
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r0.<init>(r14, r1, r15, r2);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r0 = r17;
        r4.append(r0);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r17 = "BETACLUB_SDK";
        r18 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r18.<init>();	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r19 = "读取";
        r18 = r18.append(r19);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r19 = new java.lang.String;	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r20 = 0;
        r21 = "utf-8";
        r0 = r19;
        r1 = r20;
        r2 = r21;
        r0.<init>(r14, r1, r15, r2);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r15 = r18.append(r19);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r15 = r15.toString();	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        r0 = r17;
        com.huawei.uploadlog.p188c.C2511g.m12481b(r0, r15);	 Catch:{ IOException -> 0x05d7, RuntimeException -> 0x07b0, Exception -> 0x07a0 }
        goto L_0x036c;
    L_0x05d7:
        r4 = move-exception;
        r22 = r4;
        r4 = r6;
        r6 = r22;
    L_0x05dd:
        r14 = "BETACLUB_SDK";
        r15 = "uploading 获取服务器响应  IOException";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r14, r15, r6);	 Catch:{ all -> 0x0796 }
        r6 = "BETACLUB_SDK";
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0796 }
        r14.<init>();	 Catch:{ all -> 0x0796 }
        r15 = "code = ";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0796 }
        r14 = r14.append(r4);	 Catch:{ all -> 0x0796 }
        r15 = ", mLogUploadInfo.getUserType()=";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0796 }
        r15 = r25.getUserType();	 Catch:{ all -> 0x0796 }
        r14 = r14.append(r15);	 Catch:{ all -> 0x0796 }
        r14 = r14.toString();	 Catch:{ all -> 0x0796 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r6, r14);	 Catch:{ all -> 0x0796 }
        r6 = "BETACLUB_SDK";
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0796 }
        r14.<init>();	 Catch:{ all -> 0x0796 }
        r15 = "afterTime - beforeTime:";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0796 }
        r18 = r10 - r12;
        r0 = r18;
        r14 = r14.append(r0);	 Catch:{ all -> 0x0796 }
        r14 = r14.toString();	 Catch:{ all -> 0x0796 }
        com.huawei.uploadlog.p188c.C2511g.m12484d(r6, r14);	 Catch:{ all -> 0x0796 }
        r10 = r10 - r12;
        r12 = 600000; // 0x927c0 float:8.40779E-40 double:2.964394E-318;
        r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r6 < 0) goto L_0x06fa;
    L_0x062f:
        if (r8 != 0) goto L_0x06fa;
    L_0x0631:
        if (r7 != 0) goto L_0x06fa;
    L_0x0633:
        r6 = com.huawei.uploadlog.p188c.C2507c.m12462c();	 Catch:{ all -> 0x0796 }
        r6.clear();	 Catch:{ all -> 0x0796 }
        r6 = "BETACLUB_SDK";
        r7 = "hhhhhhhhhhhclear";
        com.huawei.uploadlog.p188c.C2511g.m12484d(r6, r7);	 Catch:{ all -> 0x0796 }
        r6 = 0;
        com.huawei.uploadlog.p188c.C2507c.m12457a(r6);	 Catch:{ all -> 0x0796 }
        com.huawei.uploadlog.p188c.C2517m.m12585e();	 Catch:{ all -> 0x0796 }
        r6 = new android.content.Intent;	 Catch:{ all -> 0x0796 }
        r6.<init>();	 Catch:{ all -> 0x0796 }
        r7 = "com.huawei.crowdtestsdk.UPLOAD_PROGRESS";
        r6.setAction(r7);	 Catch:{ all -> 0x0796 }
        r7 = "exception";
        r8 = "2";
        r6.putExtra(r7, r8);	 Catch:{ all -> 0x0796 }
        r7 = "mLogUploadInfo";
        r0 = r25;
        r6.putExtra(r7, r0);	 Catch:{ all -> 0x0796 }
        r7 = "exception";
        r8 = "2";
        com.huawei.uploadlog.p188c.C2511g.m12477a(r7, r8);	 Catch:{ all -> 0x0796 }
        r7 = com.huawei.crowdtestsdk.common.AppContext.getInstance();	 Catch:{ all -> 0x0796 }
        r7 = r7.getApplication();	 Catch:{ all -> 0x0796 }
        r7 = r7.getBaseContext();	 Catch:{ all -> 0x0796 }
        r7.sendBroadcast(r6);	 Catch:{ all -> 0x0796 }
        r6 = com.huawei.crowdtestsdk.common.AppContext.getInstance();	 Catch:{ all -> 0x0796 }
        r6 = r6.getApplication();	 Catch:{ all -> 0x0796 }
        r7 = "";
        r8 = 0;
        r0 = r16;
        com.huawei.uploadlog.p188c.C2517m.m12567a(r6, r7, r0, r8);	 Catch:{ all -> 0x0796 }
        r6 = "BETACLUB_SDK";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0796 }
        r7.<init>();	 Catch:{ all -> 0x0796 }
        r8 = "[Uploading.upload] filePath";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0796 }
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x0796 }
        r7 = r7.toString();	 Catch:{ all -> 0x0796 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r6, r7);	 Catch:{ all -> 0x0796 }
        r6 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        android.os.SystemClock.sleep(r6);	 Catch:{ all -> 0x0796 }
        r6 = "BETACLUB_SDK";
        r7 = "start to kill process!";
        com.huawei.uploadlog.p188c.C2511g.m12484d(r6, r7);	 Catch:{ all -> 0x0796 }
        r6 = com.huawei.uploadlog.p188c.C2507c.m12462c();	 Catch:{ all -> 0x0796 }
        r6.clear();	 Catch:{ all -> 0x0796 }
        r6 = 0;
        com.huawei.uploadlog.p188c.C2507c.m12457a(r6);	 Catch:{ all -> 0x0796 }
        r6 = -1;
        com.huawei.uploadlog.p188c.C2507c.m12463c(r6);	 Catch:{ all -> 0x0796 }
        r6 = 0;
        com.huawei.uploadlog.p188c.C2507c.m12461b(r6);	 Catch:{ all -> 0x0796 }
        r6 = com.huawei.crowdtestsdk.common.AppContext.getInstance();	 Catch:{ all -> 0x0796 }
        r6 = r6.getApplication();	 Catch:{ all -> 0x0796 }
        r7 = new android.content.Intent;	 Catch:{ all -> 0x0796 }
        r8 = com.huawei.crowdtestsdk.common.AppContext.getInstance();	 Catch:{ all -> 0x0796 }
        r8 = r8.getApplication();	 Catch:{ all -> 0x0796 }
        r10 = com.huawei.uploadlog.LogUploadReceive.class;
        r7.<init>(r8, r10);	 Catch:{ all -> 0x0796 }
        r6.stopService(r7);	 Catch:{ all -> 0x0796 }
        r6 = com.huawei.crowdtestsdk.common.AppContext.getInstance();	 Catch:{ all -> 0x0796 }
        r6 = r6.getApplication();	 Catch:{ all -> 0x0796 }
        r7 = new android.content.Intent;	 Catch:{ all -> 0x0796 }
        r8 = com.huawei.crowdtestsdk.common.AppContext.getInstance();	 Catch:{ all -> 0x0796 }
        r8 = r8.getApplication();	 Catch:{ all -> 0x0796 }
        r10 = com.huawei.uploadlog.LogUploadService.class;
        r7.<init>(r8, r10);	 Catch:{ all -> 0x0796 }
        r6.stopService(r7);	 Catch:{ all -> 0x0796 }
        r6 = android.os.Process.myPid();	 Catch:{ all -> 0x0796 }
        android.os.Process.killProcess(r6);	 Catch:{ all -> 0x0796 }
    L_0x06fa:
        r6 = r25.getUserType();	 Catch:{ all -> 0x0796 }
        if (r6 == 0) goto L_0x070c;
    L_0x0700:
        r5 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r5) goto L_0x071d;
    L_0x0704:
        r4 = -3;
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x070c:
        r6 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r6) goto L_0x071d;
    L_0x0710:
        if (r5 == 0) goto L_0x0715;
    L_0x0712:
        com.huawei.uploadlog.p188c.C2517m.m12582c(r25);	 Catch:{ all -> 0x0796 }
    L_0x0715:
        r4 = -1;
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x071d:
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x0724:
        r4 = move-exception;
        r6 = r4;
        r9 = r15;
        r4 = r14;
    L_0x0728:
        r7 = "BETACLUB_SDK";
        r8 = "Uploading RuntimeException";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r7, r8, r6);	 Catch:{ all -> 0x0796 }
        r6 = r25.getUserType();	 Catch:{ all -> 0x0796 }
        if (r6 == 0) goto L_0x0741;
    L_0x0735:
        r5 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r5) goto L_0x0752;
    L_0x0739:
        r4 = -3;
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x0741:
        r6 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r6) goto L_0x0752;
    L_0x0745:
        if (r5 == 0) goto L_0x074a;
    L_0x0747:
        com.huawei.uploadlog.p188c.C2517m.m12582c(r25);	 Catch:{ all -> 0x0796 }
    L_0x074a:
        r4 = -1;
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x0752:
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x0759:
        r4 = move-exception;
        r6 = r4;
        r9 = r15;
        r4 = r14;
    L_0x075d:
        r7 = "BETACLUB_SDK";
        r8 = "Uploading Exception";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r7, r8, r6);	 Catch:{ all -> 0x0796 }
        r6 = r25.getUserType();	 Catch:{ all -> 0x0796 }
        if (r6 == 0) goto L_0x0776;
    L_0x076a:
        r5 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r5) goto L_0x0787;
    L_0x076e:
        r4 = -3;
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x0776:
        r6 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r6) goto L_0x0787;
    L_0x077a:
        if (r5 == 0) goto L_0x077f;
    L_0x077c:
        com.huawei.uploadlog.p188c.C2517m.m12582c(r25);	 Catch:{ all -> 0x0796 }
    L_0x077f:
        r4 = -1;
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x0787:
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        goto L_0x00b4;
    L_0x078e:
        r4 = move-exception;
        r9 = r15;
    L_0x0790:
        r5 = "BETACLUB_SDK";
        com.huawei.uploadlog.p188c.C2517m.m12571a(r9, r5);
        throw r4;
    L_0x0796:
        r4 = move-exception;
        goto L_0x0790;
    L_0x0798:
        r4 = move-exception;
        r9 = r15;
        r22 = r6;
        r6 = r4;
        r4 = r22;
        goto L_0x075d;
    L_0x07a0:
        r4 = move-exception;
        r22 = r4;
        r4 = r6;
        r6 = r22;
        goto L_0x075d;
    L_0x07a7:
        r4 = move-exception;
        r9 = r15;
        r22 = r6;
        r6 = r4;
        r4 = r22;
        goto L_0x0728;
    L_0x07b0:
        r4 = move-exception;
        r22 = r4;
        r4 = r6;
        r6 = r22;
        goto L_0x0728;
    L_0x07b8:
        r4 = move-exception;
        r12 = r8;
        r8 = r7;
        r9 = r15;
        r7 = r6;
        r6 = r4;
        r4 = r14;
        goto L_0x05dd;
    L_0x07c1:
        r4 = move-exception;
        r8 = r7;
        r9 = r15;
        r7 = r6;
        r6 = r4;
        r4 = r14;
        goto L_0x05dd;
    L_0x07c9:
        r4 = move-exception;
        r7 = r6;
        r9 = r15;
        r6 = r4;
        r4 = r14;
        goto L_0x05dd;
    L_0x07d0:
        r4 = move-exception;
        r6 = r4;
        r9 = r15;
        r4 = r14;
        goto L_0x05dd;
    L_0x07d6:
        r4 = move-exception;
        r9 = r15;
        r22 = r6;
        r6 = r4;
        r4 = r22;
        goto L_0x05dd;
    L_0x07df:
        r4 = move-exception;
        goto L_0x0583;
    L_0x07e2:
        r4 = move-exception;
        r10 = r6;
        goto L_0x0583;
    L_0x07e6:
        r4 = move-exception;
        goto L_0x0547;
    L_0x07e9:
        r4 = move-exception;
        goto L_0x04f6;
    L_0x07ec:
        r4 = move-exception;
        r6 = r10;
        goto L_0x04ba;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.q.a(java.io.File, com.huawei.uploadlog.LogUpload):int");
    }

    private String m12639a(LogUpload logUpload, TreeMap<String, String> treeMap) {
        String str;
        int type = logUpload.getType();
        String str2 = HttpPut.METHOD_NAME;
        StringBuffer stringBuffer = new StringBuffer();
        Set keySet = treeMap.keySet();
        if (keySet != null) {
            for (Object next : keySet) {
                C2511g.m12481b("BETACLUB_SDK", "[Uploading.GetNspSig] key=" + next.toString().toLowerCase(Locale.US));
                Object obj = treeMap.get(next);
                C2511g.m12481b("BETACLUB_SDK", "[Uploading.GetNspSig] value=" + obj.toString());
                stringBuffer.append(SNBConstant.FILTER);
                stringBuffer.append(next.toString().toLowerCase(Locale.US));
                stringBuffer.append("=");
                stringBuffer.append(obj.toString());
            }
        }
        String str3 = stringBuffer.substring(1).toString();
        C2511g.m12481b("BETACLUB_SDK", "[Uploading.GetNspSig] tmp=" + str3);
        if (type == 2) {
            str = logUpload.getUploadPath() + "?resume";
        } else {
            str = logUpload.getUploadPath();
        }
        try {
            str = str2 + SNBConstant.FILTER + URLEncoder.encode(str, GameManager.DEFAULT_CHARSET) + SNBConstant.FILTER + URLEncoder.encode(str3, GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[Uploading.GetNspSig] error!", e);
            str = null;
        }
        str2 = logUpload.getAccessToken();
        if (str2 == null) {
            return null;
        }
        byte[] a;
        try {
            a = C2510f.m12474a(str, str2);
        } catch (Throwable e2) {
            C2511g.m12482b("BETACLUB_SDK", "[Uploading.GetNspSig] error!", e2);
            a = null;
        }
        if (a != null) {
            return Base64.encodeToString(a, 2);
        }
        return null;
    }

    private long m12638a(LogUpload logUpload) {
        long j = 0;
        String contentRange = logUpload.getContentRange();
        if (contentRange != null) {
            C2511g.m12481b("BETACLUB_SDK", "[Uploading.GetNpsContentRage] completeRange" + contentRange);
            String[] split = contentRange.split("]");
            for (String substring : split) {
                String[] split2 = substring.substring(1).split(",");
                int parseInt = Integer.parseInt(split2[0]);
                int parseInt2 = Integer.parseInt(split2[1]);
                if (parseInt == 0) {
                    j = (long) (parseInt2 + 1);
                }
            }
        }
        return j;
    }

    public static void m12640a(String str, LogUpload logUpload) {
        Throwable th;
        C2497b c2497b;
        String str2 = null;
        C2511g.m12481b("BETACLUB_SDK", "[Uploading.parserContentRange] rsp = " + str);
        if (StringUtils.isNullOrEmpty(str)) {
            C2511g.m12484d("BETACLUB_SDK", "Input param invalid.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                int i = jSONObject.getInt("upload_status");
                if (i == 2) {
                    C2511g.m12481b("BETACLUB_SDK", "[Uploading.parserContentRange] 断点文件不存在，需要重新上传");
                } else if (i == 1) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("completed_range");
                        StringBuffer stringBuffer = new StringBuffer();
                        C2511g.m12481b("BETACLUB_SDK", "[Uploading.parserContentRange] rangeArray.length()" + jSONArray.length());
                        String str3 = null;
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            try {
                                str3 = str3 + jSONArray.getJSONArray(i2).toString();
                                stringBuffer.append(jSONArray.getJSONArray(i2).toString());
                                C2511g.m12481b("BETACLUB_SDK", "[Uploading.parserContentRange] rangeArray :" + jSONArray.getJSONArray(i2).toString());
                                i2++;
                            } catch (Throwable e) {
                                Throwable th2 = e;
                                str2 = str3;
                                th = th2;
                            }
                        }
                        str2 = stringBuffer.toString();
                    } catch (JSONException e2) {
                        th = e2;
                        C2511g.m12482b("BETACLUB_SDK", "JSONException", th);
                        C2511g.m12481b("BETACLUB_SDK", "[Uploading.parserContentRange] contentRanger" + str2);
                        logUpload.setContentRange(str2);
                        c2497b = new C2497b(AppContext.getInstance().getApplication().getBaseContext());
                        synchronized (C2507c.f8987a) {
                            C2496a.m12418a(c2497b, logUpload, false);
                        }
                    }
                }
                C2511g.m12481b("BETACLUB_SDK", "[Uploading.parserContentRange] contentRanger" + str2);
                logUpload.setContentRange(str2);
                c2497b = new C2497b(AppContext.getInstance().getApplication().getBaseContext());
                synchronized (C2507c.f8987a) {
                    C2496a.m12418a(c2497b, logUpload, false);
                }
            } catch (Throwable e3) {
                C2511g.m12482b("BETACLUB_SDK", "[Uploading.parserContentRange]error", e3);
            }
        } catch (Throwable e32) {
            C2511g.m12482b("BETACLUB_SDK", "[Uploading.parserContentRange]JSONException", e32);
        }
    }
}
