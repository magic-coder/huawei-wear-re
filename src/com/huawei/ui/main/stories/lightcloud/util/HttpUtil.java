package com.huawei.ui.main.stories.lightcloud.util;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudHttpCallBack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpUtil {
    private static final String TAG = "UIDV_HttpUtil";
    private static ExecutorService executorService;

    final class C24101 implements Runnable {
        final /* synthetic */ LightCloudHttpCallBack val$callBack;
        final /* synthetic */ String val$param;
        final /* synthetic */ String val$url;

        C24101(String str, String str2, LightCloudHttpCallBack lightCloudHttpCallBack) {
            this.val$url = str;
            this.val$param = str2;
            this.val$callBack = lightCloudHttpCallBack;
        }

        public void run() {
            HttpUtil.doPostReq(this.val$url, this.val$param, this.val$callBack);
        }
    }

    public static void doRefresh(String str, String str2, LightCloudHttpCallBack lightCloudHttpCallBack) {
        C2538c.m12677c(TAG, "pullRefresh");
        if (str == null || str.equals("")) {
            C2538c.m12677c(TAG, "url is null");
        } else if (str2 == null || str2.equals("")) {
            C2538c.m12677c(TAG, "param is null");
        } else {
            if (executorService == null || executorService.isShutdown()) {
                C2538c.m12677c(TAG, "new executorService");
                executorService = Executors.newSingleThreadExecutor();
            }
            executorService.execute(new C24101(str, str2, lightCloudHttpCallBack));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doPostReq(java.lang.String r18, java.lang.String r19, com.huawei.ui.main.stories.lightcloud.service.LightCloudHttpCallBack r20) {
        /*
        r1 = "UIDV_HttpUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "doPostReq";
        r2[r3] = r4;
        com.huawei.p190v.C2538c.m12677c(r1, r2);
        r11 = -1;
        r10 = "";
        r2 = 0;
        r9 = 0;
        r8 = 0;
        r7 = 0;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r0 = r18;
        r1.<init>(r0);	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r6 = "UIDV_HttpUtil";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r13 = 0;
        r14 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r14.<init>();	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r15 = "url = ";
        r14 = r14.append(r15);	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r14 = r14.append(r1);	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r14 = r14.toString();	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r12[r13] = r14;	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        com.huawei.p190v.C2538c.m12674b(r6, r12);	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r1 = r1.openConnection();	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ MalformedURLException -> 0x02c4, IOException -> 0x01f1 }
        r2 = "https";
        r0 = r18;
        r2 = r0.startsWith(r2);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        if (r2 == 0) goto L_0x0063;
    L_0x004d:
        r0 = r1;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = r0;
        r6 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory();	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2.setSSLSocketFactory(r6);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r0 = r1;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = r0;
        r6 = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier();	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2.setHostnameVerifier(r6);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
    L_0x0063:
        r2 = "POST";
        r1.setRequestMethod(r2);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = "UIDV_HttpUtil";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r12 = 0;
        r13 = "setRequestMethod";
        r6[r12] = r13;	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        com.huawei.p190v.C2538c.m12677c(r2, r6);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = "Content-Type";
        r6 = "application/json";
        r1.setRequestProperty(r2, r6);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = 0;
        r1.setUseCaches(r2);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = 1;
        r1.setDoInput(r2);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = 1;
        r1.setDoOutput(r2);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1.setReadTimeout(r2);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1.setConnectTimeout(r2);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r2 = "UIDV_HttpUtil";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r12 = 0;
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r14 = "param = ";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r0 = r19;
        r13 = r13.append(r0);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r6[r12] = r13;	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        com.huawei.p190v.C2538c.m12674b(r2, r6);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        if (r19 == 0) goto L_0x0188;
    L_0x00b4:
        r2 = r19.trim();	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r6 = "";
        r2 = r2.equals(r6);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        if (r2 != 0) goto L_0x0188;
    L_0x00c0:
        r3 = r1.getOutputStream();	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r6 = new java.io.OutputStreamWriter;	 Catch:{ MalformedURLException -> 0x02d0, IOException -> 0x028b, all -> 0x024d }
        r2 = "UTF-8";
        r6.<init>(r3, r2);	 Catch:{ MalformedURLException -> 0x02d0, IOException -> 0x028b, all -> 0x024d }
        r2 = "UIDV_HttpUtil";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r12 = 0;
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r14 = "outputStreamWrite = ";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r13 = r13.append(r6);	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r5[r12] = r13;	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        com.huawei.p190v.C2538c.m12677c(r2, r5);	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r5 = new java.io.PrintWriter;	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r5.<init>(r6);	 Catch:{ MalformedURLException -> 0x02dd, IOException -> 0x0293, all -> 0x0254 }
        r0 = r19;
        r5.print(r0);	 Catch:{ MalformedURLException -> 0x02ed, IOException -> 0x029c, all -> 0x025c }
        r5.flush();	 Catch:{ MalformedURLException -> 0x02ed, IOException -> 0x029c, all -> 0x025c }
        r9 = r5;
        r5 = r6;
    L_0x00f8:
        r1.connect();	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r11 = r1.getResponseCode();	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r2 = "UIDV_HttpUtil";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r12 = 0;
        r13 = "getResponseCode end";
        r6[r12] = r13;	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        com.huawei.p190v.C2538c.m12677c(r2, r6);	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r2 = "UIDV_HttpUtil";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r12 = 0;
        r13 = "connect code = ";
        r6[r12] = r13;	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r12 = 1;
        r13 = java.lang.Integer.valueOf(r11);	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r6[r12] = r13;	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        com.huawei.p190v.C2538c.m12677c(r2, r6);	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r4 = r1.getInputStream();	 Catch:{ MalformedURLException -> 0x0300, IOException -> 0x028b, all -> 0x024d }
        r6 = new java.io.InputStreamReader;	 Catch:{ MalformedURLException -> 0x030d, IOException -> 0x028b, all -> 0x024d }
        r2 = "UTF-8";
        r6.<init>(r4, r2);	 Catch:{ MalformedURLException -> 0x030d, IOException -> 0x028b, all -> 0x024d }
        r7 = new java.io.BufferedReader;	 Catch:{ MalformedURLException -> 0x031a, IOException -> 0x02a6, all -> 0x0265 }
        r7.<init>(r6);	 Catch:{ MalformedURLException -> 0x031a, IOException -> 0x02a6, all -> 0x0265 }
        r2 = new java.lang.StringBuffer;	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
    L_0x0135:
        r8 = r7.readLine();	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        if (r8 == 0) goto L_0x01a3;
    L_0x013b:
        r2.append(r8);	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        goto L_0x0135;
    L_0x013f:
        r2 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r9;
        r9 = r10;
        r10 = r11;
    L_0x014a:
        r11 = "UIDV_HttpUtil";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ all -> 0x0280 }
        r13 = 0;
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0280 }
        r14.<init>();	 Catch:{ all -> 0x0280 }
        r15 = "MalformedURLException :";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0280 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0280 }
        r1 = r14.append(r1);	 Catch:{ all -> 0x0280 }
        r1 = r1.toString();	 Catch:{ all -> 0x0280 }
        r12[r13] = r1;	 Catch:{ all -> 0x0280 }
        com.huawei.p190v.C2538c.m12677c(r11, r12);	 Catch:{ all -> 0x0280 }
        r1 = -1;
        closeHttpURLConnection(r8);
        closeBufferedReader(r6);
        closeOutputStreamWriter(r4);
        closePrintWriter(r7);
        closeInputStreamReader(r5);
        closeInputStream(r3);
        closeOutputStream(r2);
        r0 = r20;
        r0.onResponce(r1, r9);
    L_0x0187:
        return;
    L_0x0188:
        r2 = "UIDV_HttpUtil";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        r12 = 0;
        r13 = "parm is null";
        r6[r12] = r13;	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        com.huawei.p190v.C2538c.m12677c(r2, r6);	 Catch:{ MalformedURLException -> 0x0197, IOException -> 0x028b, all -> 0x024d }
        goto L_0x00f8;
    L_0x0197:
        r2 = move-exception;
        r6 = r8;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r7;
        r7 = r9;
        r9 = r10;
        r10 = r11;
        goto L_0x014a;
    L_0x01a3:
        r8 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        r8.<init>();	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        r8 = r8.append(r10);	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        r2 = r2.toString();	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        r2 = r8.append(r2);	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        r8 = r2.toString();	 Catch:{ MalformedURLException -> 0x013f, IOException -> 0x02af, all -> 0x026d }
        r2 = "UIDV_HttpUtil";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        r12 = 0;
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        r14 = "result = ";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        r13 = r13.append(r8);	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        r10[r12] = r13;	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        com.huawei.p190v.C2538c.m12674b(r2, r10);	 Catch:{ MalformedURLException -> 0x032a, IOException -> 0x02b9, all -> 0x0276 }
        closeHttpURLConnection(r1);
        closeBufferedReader(r7);
        closeOutputStreamWriter(r5);
        closePrintWriter(r9);
        closeInputStreamReader(r6);
        closeInputStream(r4);
        closeOutputStream(r3);
        r0 = r20;
        r0.onResponce(r11, r8);
        goto L_0x0187;
    L_0x01f1:
        r1 = move-exception;
    L_0x01f2:
        r6 = "UIDV_HttpUtil";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ all -> 0x0231 }
        r13 = 0;
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0231 }
        r14.<init>();	 Catch:{ all -> 0x0231 }
        r15 = "IOException :";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0231 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0231 }
        r1 = r14.append(r1);	 Catch:{ all -> 0x0231 }
        r1 = r1.toString();	 Catch:{ all -> 0x0231 }
        r12[r13] = r1;	 Catch:{ all -> 0x0231 }
        com.huawei.p190v.C2538c.m12677c(r6, r12);	 Catch:{ all -> 0x0231 }
        r1 = -1;
        closeHttpURLConnection(r2);
        closeBufferedReader(r8);
        closeOutputStreamWriter(r5);
        closePrintWriter(r9);
        closeInputStreamReader(r7);
        closeInputStream(r4);
        closeOutputStream(r3);
        r0 = r20;
        r0.onResponce(r1, r10);
        goto L_0x0187;
    L_0x0231:
        r1 = move-exception;
    L_0x0232:
        closeHttpURLConnection(r2);
        closeBufferedReader(r8);
        closeOutputStreamWriter(r5);
        closePrintWriter(r9);
        closeInputStreamReader(r7);
        closeInputStream(r4);
        closeOutputStream(r3);
        r0 = r20;
        r0.onResponce(r11, r10);
        throw r1;
    L_0x024d:
        r2 = move-exception;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x0232;
    L_0x0254:
        r2 = move-exception;
        r5 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x0232;
    L_0x025c:
        r2 = move-exception;
        r9 = r5;
        r5 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x0232;
    L_0x0265:
        r2 = move-exception;
        r7 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x0232;
    L_0x026d:
        r2 = move-exception;
        r8 = r7;
        r7 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x0232;
    L_0x0276:
        r2 = move-exception;
        r10 = r8;
        r8 = r7;
        r7 = r6;
        r16 = r1;
        r1 = r2;
        r2 = r16;
        goto L_0x0232;
    L_0x0280:
        r1 = move-exception;
        r11 = r10;
        r10 = r9;
        r9 = r7;
        r7 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r8;
        r8 = r6;
        goto L_0x0232;
    L_0x028b:
        r2 = move-exception;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x01f2;
    L_0x0293:
        r2 = move-exception;
        r5 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x01f2;
    L_0x029c:
        r2 = move-exception;
        r9 = r5;
        r5 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x01f2;
    L_0x02a6:
        r2 = move-exception;
        r7 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x01f2;
    L_0x02af:
        r2 = move-exception;
        r8 = r7;
        r7 = r6;
        r16 = r2;
        r2 = r1;
        r1 = r16;
        goto L_0x01f2;
    L_0x02b9:
        r2 = move-exception;
        r10 = r8;
        r8 = r7;
        r7 = r6;
        r16 = r1;
        r1 = r2;
        r2 = r16;
        goto L_0x01f2;
    L_0x02c4:
        r1 = move-exception;
        r6 = r8;
        r8 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r7;
        r7 = r9;
        r9 = r10;
        r10 = r11;
        goto L_0x014a;
    L_0x02d0:
        r2 = move-exception;
        r6 = r8;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r7;
        r7 = r9;
        r9 = r10;
        r10 = r11;
        goto L_0x014a;
    L_0x02dd:
        r2 = move-exception;
        r5 = r7;
        r7 = r9;
        r9 = r10;
        r10 = r11;
        r16 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r6;
        r6 = r8;
        r8 = r1;
        r1 = r16;
        goto L_0x014a;
    L_0x02ed:
        r2 = move-exception;
        r9 = r10;
        r10 = r11;
        r16 = r4;
        r4 = r6;
        r6 = r8;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r16;
        r17 = r7;
        r7 = r5;
        r5 = r17;
        goto L_0x014a;
    L_0x0300:
        r2 = move-exception;
        r6 = r8;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r7;
        r7 = r9;
        r9 = r10;
        r10 = r11;
        goto L_0x014a;
    L_0x030d:
        r2 = move-exception;
        r6 = r8;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r7;
        r7 = r9;
        r9 = r10;
        r10 = r11;
        goto L_0x014a;
    L_0x031a:
        r2 = move-exception;
        r7 = r9;
        r9 = r10;
        r10 = r11;
        r16 = r5;
        r5 = r6;
        r6 = r8;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r16;
        goto L_0x014a;
    L_0x032a:
        r2 = move-exception;
        r10 = r11;
        r16 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r9;
        r9 = r8;
        r8 = r1;
        r1 = r2;
        r2 = r16;
        goto L_0x014a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.ui.main.stories.lightcloud.util.HttpUtil.doPostReq(java.lang.String, java.lang.String, com.huawei.ui.main.stories.lightcloud.service.LightCloudHttpCallBack):void");
    }

    private static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException:" + e.getMessage());
            }
        }
    }

    private static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException:" + e.getMessage());
            }
        }
    }

    private static void closeHttpURLConnection(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private static void closeBufferedReader(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException :" + e.getMessage());
            }
        }
    }

    private static void closeOutputStreamWriter(OutputStreamWriter outputStreamWriter) {
        if (outputStreamWriter != null) {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException :" + e.getMessage());
            }
        }
    }

    private static void closePrintWriter(PrintWriter printWriter) {
        if (printWriter != null) {
            printWriter.close();
        }
    }

    private static void closeInputStreamReader(InputStreamReader inputStreamReader) {
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                C2538c.m12677c(TAG, "IOException :" + e.getMessage());
            }
        }
    }
}
