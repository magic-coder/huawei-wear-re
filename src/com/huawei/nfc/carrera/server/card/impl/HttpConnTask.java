package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.aj.p315a.C4023a;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.utils.WalletSSLSocketFactory;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

public abstract class HttpConnTask<Result, RequestParams> {
    private static final int DEFAULT_TIMEOUT = 30000;
    protected static final int ERROR_CODE_CONNECTION_FAILED = -2;
    protected static final int ERROR_CODE_NO_NETWORK = -1;
    protected static final int ERROR_CODE_PARAMS_ERROR = -3;
    protected static final int ERROR_CODE_SERVER_OVERLOAD = -4;
    private static final int SERVER_OVERLOAD_ERRORCODE = 503;
    private static final String TAG = "HttpConnTask";
    private int mConnTimeout = 30000;
    protected Context mContext;
    private int mSocketTimeout = 30000;
    private final String mUrl;

    protected abstract String prepareRequestStr(RequestParams requestParams);

    protected abstract Result readErrorResponse(int i);

    protected abstract Result readSuccessResponse(String str);

    public HttpConnTask(Context context, String str) {
        this.mContext = context;
        this.mUrl = str;
    }

    public HttpConnTask(Context context, String str, int i, int i2) {
        this.mContext = context;
        this.mUrl = str;
        this.mConnTimeout = i;
        this.mSocketTimeout = i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Result processTask(RequestParams r13) {
        /*
        r12 = this;
        r2 = -3;
        r1 = 0;
        r6 = 0;
        r3 = 1;
        r0 = r12.mContext;
        r0 = com.huawei.aj.p315a.p318c.C4026a.m19819a(r0);
        if (r0 != 0) goto L_0x0017;
    L_0x000c:
        r0 = "processTask, no network.";
        com.huawei.nfc.carrera.util.LogX.i(r0);
        r0 = -1;
        r2 = r12.readErrorResponse(r0);
    L_0x0016:
        return r2;
    L_0x0017:
        r0 = r12.prepareRequestStr(r13);
        if (r0 != 0) goto L_0x0027;
    L_0x001d:
        r0 = "processTask, invalid request params.";
        com.huawei.nfc.carrera.util.LogX.i(r0);
        r2 = r12.readErrorResponse(r2);
        goto L_0x0016;
    L_0x0027:
        r2 = "HttpConnTask";
        r3 = new java.lang.Object[r3];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "processTask,requestStr.";
        r4 = r4.append(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3[r6] = r4;
        com.huawei.v.c.c(r2, r3);
        r2 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r3 = r12.mUrl;	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r2.<init>(r3);	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r3 = "HttpConnTask";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r7 = "processTask, check url.";
        r6 = r6.append(r7);	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r6 = r6.append(r2);	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r6 = r6.toString();	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r4[r5] = r6;	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        com.huawei.v.c.c(r3, r4);	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r3 = "https";
        r4 = r2.getProtocol();	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        r3 = r3.equals(r4);	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        if (r3 == 0) goto L_0x013c;
    L_0x0074:
        r4 = r12.openHttpsConnection(r2);	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
    L_0x0078:
        r2 = r12.mConnTimeout;	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r4.setConnectTimeout(r2);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = r12.mSocketTimeout;	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r4.setReadTimeout(r2);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = 1;
        r4.setDoInput(r2);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = 1;
        r4.setDoOutput(r2);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = 0;
        r4.setUseCaches(r2);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = "POST";
        r4.setRequestMethod(r2);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = "Content-Type";
        r3 = "xml/json";
        r4.setRequestProperty(r2, r3);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = "Charset";
        r3 = "UTF-8";
        r4.setRequestProperty(r2, r3);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r4.connect();	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r3 = new java.io.DataOutputStream;	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = r4.getOutputStream();	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r3.<init>(r2);	 Catch:{ MalformedURLException -> 0x02a2, IOException -> 0x0281, NoSuchAlgorithmException -> 0x0258, KeyManagementException -> 0x0234, all -> 0x021b }
        r2 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r5 = "processTask request string : ";
        r2 = r2.append(r5);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = r2.append(r0);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = r2.toString();	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r5 = 1;
        com.huawei.nfc.carrera.util.LogX.i(r2, r5);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = "UTF-8";
        r0 = r0.getBytes(r2);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r3.write(r0);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r3.flush();	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r0 = r4.getResponseCode();	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r5 = "processTask connection result code : ";
        r2 = r2.append(r5);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = r2.append(r0);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = r2.toString();	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r5 = 1;
        com.huawei.nfc.carrera.util.LogX.i(r2, r5);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r0) goto L_0x0177;
    L_0x00f0:
        r2 = r4.getInputStream();	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ MalformedURLException -> 0x02ae, IOException -> 0x028d, NoSuchAlgorithmException -> 0x0266, KeyManagementException -> 0x0240, all -> 0x0225 }
        r0.<init>();	 Catch:{ MalformedURLException -> 0x02ae, IOException -> 0x028d, NoSuchAlgorithmException -> 0x0266, KeyManagementException -> 0x0240, all -> 0x0225 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x026d, KeyManagementException -> 0x0246, all -> 0x022a }
    L_0x00fd:
        r6 = r2.read(r5);	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x026d, KeyManagementException -> 0x0246, all -> 0x022a }
        r7 = -1;
        if (r6 == r7) goto L_0x0142;
    L_0x0104:
        r7 = 0;
        r0.write(r5, r7, r6);	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x026d, KeyManagementException -> 0x0246, all -> 0x022a }
        goto L_0x00fd;
    L_0x0109:
        r1 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r11 = r0;
        r0 = r1;
        r1 = r11;
    L_0x0110:
        r2 = "HttpConnTask";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0232 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0232 }
        r8.<init>();	 Catch:{ all -> 0x0232 }
        r9 = "MalformedURLException.";
        r8 = r8.append(r9);	 Catch:{ all -> 0x0232 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0232 }
        r0 = r8.append(r0);	 Catch:{ all -> 0x0232 }
        r0 = r0.toString();	 Catch:{ all -> 0x0232 }
        r6[r7] = r0;	 Catch:{ all -> 0x0232 }
        com.huawei.v.c.e(r2, r6);	 Catch:{ all -> 0x0232 }
        r0 = -3;
        r2 = r12.readErrorResponse(r0);	 Catch:{ all -> 0x0232 }
        r12.closeStream(r4, r3, r1, r5);
        goto L_0x0016;
    L_0x013c:
        r4 = r12.openHttpConnection(r2);	 Catch:{ MalformedURLException -> 0x029c, IOException -> 0x018b, NoSuchAlgorithmException -> 0x01bb, KeyManagementException -> 0x01e7, all -> 0x0213 }
        goto L_0x0078;
    L_0x0142:
        r5 = r0.toByteArray();	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x026d, KeyManagementException -> 0x0246, all -> 0x022a }
        r6 = new java.lang.String;	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x026d, KeyManagementException -> 0x0246, all -> 0x022a }
        r7 = "UTF-8";
        r6.<init>(r5, r7);	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x026d, KeyManagementException -> 0x0246, all -> 0x022a }
        r1 = r12.readSuccessResponse(r6);	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x026d, KeyManagementException -> 0x0246, all -> 0x022a }
        r5 = "HttpConnTask";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        r8.<init>();	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        r9 = "HttpStatus.SC_OK.result";
        r8 = r8.append(r9);	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        r8 = r8.append(r1);	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        r8 = r8.toString();	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        r6[r7] = r8;	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        com.huawei.v.c.c(r5, r6);	 Catch:{ MalformedURLException -> 0x0109, IOException -> 0x0293, NoSuchAlgorithmException -> 0x0277, KeyManagementException -> 0x024f, all -> 0x022a }
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x0172:
        r12.closeStream(r3, r1, r0, r4);
        goto L_0x0016;
    L_0x0177:
        r2 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r2 != r0) goto L_0x0183;
    L_0x017b:
        r0 = -4;
        r0 = r12.readErrorResponse(r0);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = r0;
        r0 = r1;
        goto L_0x0172;
    L_0x0183:
        r0 = -2;
        r0 = r12.readErrorResponse(r0);	 Catch:{ MalformedURLException -> 0x02a8, IOException -> 0x0287, NoSuchAlgorithmException -> 0x025f, KeyManagementException -> 0x023a, all -> 0x0220 }
        r2 = r0;
        r0 = r1;
        goto L_0x0172;
    L_0x018b:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r5 = r1;
    L_0x018f:
        r2 = "HttpConnTask";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0232 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0232 }
        r8.<init>();	 Catch:{ all -> 0x0232 }
        r9 = "IOException.";
        r8 = r8.append(r9);	 Catch:{ all -> 0x0232 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0232 }
        r0 = r8.append(r0);	 Catch:{ all -> 0x0232 }
        r0 = r0.toString();	 Catch:{ all -> 0x0232 }
        r6[r7] = r0;	 Catch:{ all -> 0x0232 }
        com.huawei.v.c.e(r2, r6);	 Catch:{ all -> 0x0232 }
        r0 = -2;
        r2 = r12.readErrorResponse(r0);	 Catch:{ all -> 0x0232 }
        r12.closeStream(r4, r3, r1, r5);
        goto L_0x0016;
    L_0x01bb:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r5 = r1;
        r2 = r1;
    L_0x01c0:
        r6 = "HttpConnTask";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0232 }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0232 }
        r9.<init>();	 Catch:{ all -> 0x0232 }
        r10 = "NoSuchAlgorithmException.";
        r9 = r9.append(r10);	 Catch:{ all -> 0x0232 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0232 }
        r0 = r9.append(r0);	 Catch:{ all -> 0x0232 }
        r0 = r0.toString();	 Catch:{ all -> 0x0232 }
        r7[r8] = r0;	 Catch:{ all -> 0x0232 }
        com.huawei.v.c.e(r6, r7);	 Catch:{ all -> 0x0232 }
        r12.closeStream(r4, r3, r1, r5);
        goto L_0x0016;
    L_0x01e7:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r5 = r1;
        r2 = r1;
    L_0x01ec:
        r6 = "HttpConnTask";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0232 }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0232 }
        r9.<init>();	 Catch:{ all -> 0x0232 }
        r10 = "KeyManagementException.";
        r9 = r9.append(r10);	 Catch:{ all -> 0x0232 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0232 }
        r0 = r9.append(r0);	 Catch:{ all -> 0x0232 }
        r0 = r0.toString();	 Catch:{ all -> 0x0232 }
        r7[r8] = r0;	 Catch:{ all -> 0x0232 }
        com.huawei.v.c.e(r6, r7);	 Catch:{ all -> 0x0232 }
        r12.closeStream(r4, r3, r1, r5);
        goto L_0x0016;
    L_0x0213:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r5 = r1;
    L_0x0217:
        r12.closeStream(r4, r3, r1, r5);
        throw r0;
    L_0x021b:
        r0 = move-exception;
        r3 = r1;
        r5 = r4;
        r4 = r1;
        goto L_0x0217;
    L_0x0220:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r1;
        goto L_0x0217;
    L_0x0225:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0217;
    L_0x022a:
        r1 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x0217;
    L_0x0232:
        r0 = move-exception;
        goto L_0x0217;
    L_0x0234:
        r0 = move-exception;
        r3 = r1;
        r5 = r4;
        r2 = r1;
        r4 = r1;
        goto L_0x01ec;
    L_0x023a:
        r0 = move-exception;
        r5 = r4;
        r2 = r1;
        r4 = r3;
        r3 = r1;
        goto L_0x01ec;
    L_0x0240:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x01ec;
    L_0x0246:
        r5 = move-exception;
        r11 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x01ec;
    L_0x024f:
        r5 = move-exception;
        r11 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x01ec;
    L_0x0258:
        r0 = move-exception;
        r3 = r1;
        r5 = r4;
        r2 = r1;
        r4 = r1;
        goto L_0x01c0;
    L_0x025f:
        r0 = move-exception;
        r5 = r4;
        r2 = r1;
        r4 = r3;
        r3 = r1;
        goto L_0x01c0;
    L_0x0266:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x01c0;
    L_0x026d:
        r5 = move-exception;
        r11 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x01c0;
    L_0x0277:
        r5 = move-exception;
        r11 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x01c0;
    L_0x0281:
        r0 = move-exception;
        r3 = r1;
        r5 = r4;
        r4 = r1;
        goto L_0x018f;
    L_0x0287:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r1;
        goto L_0x018f;
    L_0x028d:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x018f;
    L_0x0293:
        r1 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x018f;
    L_0x029c:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r5 = r1;
        goto L_0x0110;
    L_0x02a2:
        r0 = move-exception;
        r3 = r1;
        r5 = r4;
        r4 = r1;
        goto L_0x0110;
    L_0x02a8:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r1;
        goto L_0x0110;
    L_0x02ae:
        r0 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0110;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.server.card.impl.HttpConnTask.processTask(java.lang.Object):Result");
    }

    private void closeStream(DataOutputStream dataOutputStream, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream, HttpURLConnection httpURLConnection) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                LogX.e("processTask close stream error1.");
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                LogX.e("processTask close stream error2.");
            }
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                LogX.e("processTask close stream error3.");
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private HttpsURLConnection openHttpsConnection(URL url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        initHttpsConnection(httpsURLConnection);
        return httpsURLConnection;
    }

    private HttpURLConnection openHttpConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private void initHttpsConnection(HttpsURLConnection httpsURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        httpsURLConnection.setSSLSocketFactory(new WalletSSLSocketFactory(new C4023a(this.mContext)));
        httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
    }
}
