package com.huawei.hwappdfxmgr.upload;

import com.google.gson.Gson;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwappdfxmgr.p056f.C4593d;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;

public final class UploadRequest {
    private static final String LOG_TAG = "LogUpload Service";
    private static final String PAUSE_STATUS = "1";

    public static void upLoadEventLog(EvenLogUpload evenLogUpload) {
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        String stringBuffer;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        Exception exception;
        EventUploadResponse eventUploadResponse;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            System.setProperty("http.keepAlive", "false");
            URL url = new URL("http://223.202.123.136:10180/transformCenter/logUpload");
            C2538c.c(LOG_TAG, new Object[]{"==ww==上传到服务器 服务器地址 url=" + url});
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setChunkedStreamingMode(1024000);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------40612316912668");
            httpURLConnection.setRequestProperty("x-huid", evenLogUpload.getHuid());
            httpURLConnection.setRequestProperty("x-version", evenLogUpload.getVersion());
            httpURLConnection.setChunkedStreamingMode(1024000);
            httpURLConnection.setConnectTimeout(SdkConstants.TIME_OUT);
            httpURLConnection.setReadTimeout(SdkConstants.TIME_OUT);
            httpURLConnection.connect();
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.write("\r\n".getBytes("utf-8"));
                Gson gson = new Gson();
                C2538c.e(LOG_TAG, new Object[]{"logUpload " + evenLogUpload.getInfo().toString()});
                UploadFile.addJsonField(gson.toJson(evenLogUpload.getInfo()), dataOutputStream);
                UploadFile.addOctetServiceField(dataOutputStream, evenLogUpload.getPath());
                UploadFile.addEndField(dataOutputStream);
                dataOutputStream.flush();
                inputStream = httpURLConnection.getInputStream();
                try {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        stringBuffer2.append(new String(bArr, 0, read, "utf-8"));
                        C2538c.c(LOG_TAG, new Object[]{"upLoadEventLog 读取" + new String(bArr, 0, read, "utf-8")});
                    }
                    C2538c.c(LOG_TAG, new Object[]{"upLoadEventLog 读取完毕"});
                    stringBuffer = stringBuffer2.toString();
                } catch (RuntimeException e) {
                    runtimeException = e;
                    stringBuffer = null;
                    runtimeException2 = runtimeException;
                } catch (Exception e2) {
                    inputStream2 = inputStream;
                    exception = e2;
                    stringBuffer = null;
                } catch (OutOfMemoryError e3) {
                    stringBuffer = null;
                    inputStream2 = inputStream;
                }
            } catch (RuntimeException e4) {
                inputStream = null;
                runtimeException2 = e4;
                stringBuffer = null;
                try {
                    C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog 异常情况"});
                    C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog exception " + runtimeException2.getMessage()});
                    C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                    C4593d.m21883a(inputStream, LOG_TAG);
                    C4593d.m21882a(dataOutputStream, LOG_TAG);
                    eventUploadResponse = new EventUploadResponse();
                    if (eventUploadResponse.parse(stringBuffer) == 0) {
                    }
                    C2538c.b(LOG_TAG, new Object[]{"异常情况"});
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                    C4593d.m21883a(inputStream2, LOG_TAG);
                    C4593d.m21882a(dataOutputStream, LOG_TAG);
                    throw th;
                }
            } catch (Exception e22) {
                Exception exception2 = e22;
                stringBuffer = null;
                exception = exception2;
                try {
                    C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog exception " + exception.getMessage()});
                    C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                    C4593d.m21883a(inputStream2, LOG_TAG);
                    C4593d.m21882a(dataOutputStream, LOG_TAG);
                    eventUploadResponse = new EventUploadResponse();
                    if (eventUploadResponse.parse(stringBuffer) == 0) {
                    }
                    C2538c.b(LOG_TAG, new Object[]{"异常情况"});
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                    C4593d.m21883a(inputStream2, LOG_TAG);
                    C4593d.m21882a(dataOutputStream, LOG_TAG);
                    throw th;
                }
            } catch (OutOfMemoryError e5) {
                stringBuffer = null;
                C2538c.b(LOG_TAG, new Object[]{" upLoadEventLog OutOfMemoryError"});
                C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                C4593d.m21883a(inputStream2, LOG_TAG);
                C4593d.m21882a(dataOutputStream, LOG_TAG);
                eventUploadResponse = new EventUploadResponse();
                if (eventUploadResponse.parse(stringBuffer) == 0) {
                }
                C2538c.b(LOG_TAG, new Object[]{"异常情况"});
                return;
            }
            try {
                C2538c.c(LOG_TAG, new Object[]{"upLoadEventLog 读取完成 " + stringBuffer});
                C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                C4593d.m21883a(inputStream, LOG_TAG);
                C4593d.m21882a(dataOutputStream, LOG_TAG);
            } catch (RuntimeException e6) {
                runtimeException2 = e6;
                C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog 异常情况"});
                C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog exception " + runtimeException2.getMessage()});
                C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                C4593d.m21883a(inputStream, LOG_TAG);
                C4593d.m21882a(dataOutputStream, LOG_TAG);
                eventUploadResponse = new EventUploadResponse();
                if (eventUploadResponse.parse(stringBuffer) == 0) {
                }
                C2538c.b(LOG_TAG, new Object[]{"异常情况"});
                return;
            } catch (Exception e7) {
                exception = e7;
                inputStream2 = inputStream;
                C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog exception " + exception.getMessage()});
                C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                C4593d.m21883a(inputStream2, LOG_TAG);
                C4593d.m21882a(dataOutputStream, LOG_TAG);
                eventUploadResponse = new EventUploadResponse();
                if (eventUploadResponse.parse(stringBuffer) == 0) {
                }
                C2538c.b(LOG_TAG, new Object[]{"异常情况"});
                return;
            } catch (OutOfMemoryError e8) {
                inputStream2 = inputStream;
                C2538c.b(LOG_TAG, new Object[]{" upLoadEventLog OutOfMemoryError"});
                C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
                C4593d.m21883a(inputStream2, LOG_TAG);
                C4593d.m21882a(dataOutputStream, LOG_TAG);
                eventUploadResponse = new EventUploadResponse();
                if (eventUploadResponse.parse(stringBuffer) == 0) {
                }
                C2538c.b(LOG_TAG, new Object[]{"异常情况"});
                return;
            }
        } catch (RuntimeException e42) {
            dataOutputStream = null;
            inputStream = null;
            runtimeException = e42;
            stringBuffer = null;
            runtimeException2 = runtimeException;
            C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog 异常情况"});
            C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog exception " + runtimeException2.getMessage()});
            C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
            C4593d.m21883a(inputStream, LOG_TAG);
            C4593d.m21882a(dataOutputStream, LOG_TAG);
            eventUploadResponse = new EventUploadResponse();
            if (eventUploadResponse.parse(stringBuffer) == 0) {
            }
            C2538c.b(LOG_TAG, new Object[]{"异常情况"});
            return;
        } catch (Exception e222) {
            dataOutputStream = null;
            exception = e222;
            stringBuffer = null;
            C2538c.e(LOG_TAG, new Object[]{"upLoadEventLog exception " + exception.getMessage()});
            C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
            C4593d.m21883a(inputStream2, LOG_TAG);
            C4593d.m21882a(dataOutputStream, LOG_TAG);
            eventUploadResponse = new EventUploadResponse();
            if (eventUploadResponse.parse(stringBuffer) == 0) {
            }
            C2538c.b(LOG_TAG, new Object[]{"异常情况"});
            return;
        } catch (OutOfMemoryError e9) {
            stringBuffer = null;
            dataOutputStream = null;
            C2538c.b(LOG_TAG, new Object[]{" upLoadEventLog OutOfMemoryError"});
            C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
            C4593d.m21883a(inputStream2, LOG_TAG);
            C4593d.m21882a(dataOutputStream, LOG_TAG);
            eventUploadResponse = new EventUploadResponse();
            if (eventUploadResponse.parse(stringBuffer) == 0) {
            }
            C2538c.b(LOG_TAG, new Object[]{"异常情况"});
            return;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            C2538c.b(LOG_TAG, new Object[]{"upLoadEventLog finally close "});
            C4593d.m21883a(inputStream2, LOG_TAG);
            C4593d.m21882a(dataOutputStream, LOG_TAG);
            throw th;
        }
        eventUploadResponse = new EventUploadResponse();
        if (eventUploadResponse.parse(stringBuffer) == 0 || 10000 != eventUploadResponse.getResultCode()) {
            C2538c.b(LOG_TAG, new Object[]{"异常情况"});
            return;
        }
        C2538c.c(LOG_TAG, new Object[]{"日志分发服务器结果解析正确,数据成功发送"});
        deleteEncryFile(evenLogUpload);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void upLoadHttpsEventLog(com.huawei.hwappdfxmgr.upload.EvenLogUpload r15) {
        /*
        r4 = 0;
        r2 = 0;
        r1 = 0;
        r3 = 1024000; // 0xfa000 float:1.43493E-39 double:5.05923E-318;
        r0 = "http.keepAlive";
        r5 = "false";
        java.lang.System.setProperty(r0, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = new java.net.URL;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = "https://logtransform.hicloud.com/transformCenter/logUpload";
        r0.<init>(r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = "LogUpload Service";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r8.<init>();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r9 = "==ww==上传到服务器 服务器地址 url=";
        r8 = r8.append(r9);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r8 = r8.append(r0);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r8 = r8.toString();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r6[r7] = r8;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        com.huawei.v.c.c(r5, r6);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = "LogUpload Service";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r7 = 0;
        r8 = "==ww== 00000000000000000000000";
        r6[r7] = r8;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        com.huawei.v.c.c(r5, r6);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r0.openConnection();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = "TLSv1.2";
        r5 = javax.net.ssl.SSLContext.getInstance(r5);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r6 = "LogUpload Service";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r8 = 0;
        r9 = "TLSv1.2!";
        r7[r8] = r9;	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        com.huawei.v.c.c(r6, r7);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r6 = 0;
        r7 = 1;
        r7 = new javax.net.ssl.TrustManager[r7];	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r8 = 0;
        r9 = new com.huawei.hwappdfxmgr.f.b;	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r10 = 0;
        r9.<init>(r10);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r7[r8] = r9;	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r8 = 0;
        r5.init(r6, r7, r8);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r5 = r5.getSocketFactory();	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        if (r5 != 0) goto L_0x0095;
    L_0x006f:
        r0 = "LogUpload Service";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r5 = 0;
        r6 = "socketFactory is null error!";
        r3[r5] = r6;	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        com.huawei.v.c.c(r0, r3);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r0 = "LogUpload Service";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r3 = 0;
        r5 = "finally close ";
        r1[r3] = r5;
        com.huawei.v.c.b(r0, r1);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r4, r0);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r0);
    L_0x0094:
        return;
    L_0x0095:
        r6 = "LogUpload Service";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r8 = 0;
        r9 = "HwOucSSLSocketFactory hssocketFactory !";
        r7[r8] = r9;	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        com.huawei.v.c.c(r6, r7);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r6 = new com.huawei.hwversionmgr.utils.b;	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r6.<init>(r5);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r0.setSSLSocketFactory(r6);	 Catch:{ NoSuchAlgorithmException -> 0x01d6, KeyManagementException -> 0x0212, KeyStoreException -> 0x024e }
        r5 = "POST";
        r0.setRequestMethod(r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = 1;
        r0.setDoOutput(r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = 1;
        r0.setDoInput(r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = 0;
        r0.setUseCaches(r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0.setChunkedStreamingMode(r3);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = "Connection";
        r5 = "keep-alive";
        r0.setRequestProperty(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = "Charset";
        r5 = "UTF-8";
        r0.setRequestProperty(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = "Content-Type";
        r5 = "multipart/form-data;boundary=---------------------------40612316912668";
        r0.setRequestProperty(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = "x-huid";
        r5 = r15.getHuid();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0.setRequestProperty(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = "x-version";
        r5 = r15.getVersion();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0.setRequestProperty(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = 1024000; // 0xfa000 float:1.43493E-39 double:5.05923E-318;
        r0.setChunkedStreamingMode(r3);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        r0.setConnectTimeout(r3);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        r0.setReadTimeout(r3);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0.connect();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3 = new java.io.DataOutputStream;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5 = r0.getOutputStream();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r3.<init>(r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r2 = "\r\n";
        r5 = "utf-8";
        r2 = r2.getBytes(r5);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r3.write(r2);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r2 = new com.google.gson.Gson;	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r2.<init>();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r5 = "LogUpload Service";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r8.<init>();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r9 = "logUpload.getInfo() ";
        r8 = r8.append(r9);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r9 = r15.getInfo();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r9 = r9.toString();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r8 = r8.append(r9);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r8 = r8.toString();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r6[r7] = r8;	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        com.huawei.v.c.e(r5, r6);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r5 = r15.getInfo();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r2 = r2.toJson(r5);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        com.huawei.hwappdfxmgr.upload.UploadFile.addJsonField(r2, r3);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r2 = r15.getPath();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        com.huawei.hwappdfxmgr.upload.UploadFile.addOctetServiceField(r3, r2);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        com.huawei.hwappdfxmgr.upload.UploadFile.addEndField(r3);	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r3.flush();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r2 = r0.getInputStream();	 Catch:{ RuntimeException -> 0x03d2, Exception -> 0x03b7, OutOfMemoryError -> 0x03aa, all -> 0x03a0 }
        r0 = new java.lang.StringBuffer;	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r0.<init>();	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r4];	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
    L_0x0161:
        r5 = r2.read(r4);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r6 = -1;
        if (r6 != r5) goto L_0x028a;
    L_0x0168:
        r4 = "LogUpload Service";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r6 = 0;
        r7 = "读取完毕";
        r5[r6] = r7;	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        com.huawei.v.c.c(r4, r5);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r0 = r0.toString();	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r1 = "LogUpload Service";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        r6.<init>();	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        r7 = "读取完成 ";
        r6 = r6.append(r7);	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        r6 = r6.append(r0);	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        r6 = r6.toString();	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        r4[r5] = r6;	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        com.huawei.v.c.c(r1, r4);	 Catch:{ RuntimeException -> 0x03da, Exception -> 0x03c6, OutOfMemoryError -> 0x03b3, all -> 0x03a3 }
        r1 = "LogUpload Service";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "finally close ";
        r4[r5] = r6;
        com.huawei.v.c.b(r1, r4);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r2, r1);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r3, r1);
    L_0x01b0:
        r1 = new com.huawei.hwappdfxmgr.upload.EventUploadResponse;
        r1.<init>();
        r0 = r1.parse(r0);
        if (r0 != 0) goto L_0x0390;
    L_0x01bb:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1 = r1.getResultCode();
        if (r0 != r1) goto L_0x0390;
    L_0x01c3:
        r0 = "LogUpload Service";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "日志分发服务器结果解析正确,数据成功发送";
        r1[r2] = r3;
        com.huawei.v.c.c(r0, r1);
        deleteEncryFile(r15);
        goto L_0x0094;
    L_0x01d6:
        r0 = move-exception;
        r3 = "LogUpload Service";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r7.<init>();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r8 = "NoSuchAlgorithmException ";
        r7 = r7.append(r8);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r0.getMessage();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r7.append(r0);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r0.toString();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5[r6] = r0;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        com.huawei.v.c.c(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = "LogUpload Service";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r3 = 0;
        r5 = "finally close ";
        r1[r3] = r5;
        com.huawei.v.c.b(r0, r1);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r4, r0);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r0);
        goto L_0x0094;
    L_0x0212:
        r0 = move-exception;
        r3 = "LogUpload Service";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r7.<init>();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r8 = "KeyManagementException ";
        r7 = r7.append(r8);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r0.getMessage();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r7.append(r0);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r0.toString();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5[r6] = r0;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        com.huawei.v.c.c(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = "LogUpload Service";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r3 = 0;
        r5 = "finally close ";
        r1[r3] = r5;
        com.huawei.v.c.b(r0, r1);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r4, r0);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r0);
        goto L_0x0094;
    L_0x024e:
        r0 = move-exception;
        r3 = "LogUpload Service";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r7.<init>();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r8 = "KeyStoreException ";
        r7 = r7.append(r8);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r0.getMessage();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r7.append(r0);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = r0.toString();	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r5[r6] = r0;	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        com.huawei.v.c.c(r3, r5);	 Catch:{ RuntimeException -> 0x03cb, Exception -> 0x0310, OutOfMemoryError -> 0x034f }
        r0 = "LogUpload Service";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r3 = 0;
        r5 = "finally close ";
        r1[r3] = r5;
        com.huawei.v.c.b(r0, r1);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r4, r0);
        r0 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r0);
        goto L_0x0094;
    L_0x028a:
        r6 = new java.lang.String;	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r7 = 0;
        r8 = "utf-8";
        r6.<init>(r4, r7, r5, r8);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r0.append(r6);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r6 = "LogUpload Service";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r9.<init>();	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r10 = "读取";
        r9 = r9.append(r10);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r10 = new java.lang.String;	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r11 = 0;
        r12 = "utf-8";
        r10.<init>(r4, r11, r5, r12);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r5 = r9.append(r10);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r5 = r5.toString();	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        r7[r8] = r5;	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        com.huawei.v.c.c(r6, r7);	 Catch:{ RuntimeException -> 0x02c0, Exception -> 0x03be, OutOfMemoryError -> 0x03ae, all -> 0x03a3 }
        goto L_0x0161;
    L_0x02c0:
        r0 = move-exception;
        r13 = r0;
        r0 = r1;
        r1 = r13;
        r14 = r3;
        r3 = r2;
        r2 = r14;
    L_0x02c7:
        r4 = "LogUpload Service";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x03a7 }
        r6 = 0;
        r7 = "异常情况";
        r5[r6] = r7;	 Catch:{ all -> 0x03a7 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ all -> 0x03a7 }
        r4 = "LogUpload Service";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x03a7 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x03a7 }
        r7.<init>();	 Catch:{ all -> 0x03a7 }
        r8 = "exception ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x03a7 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x03a7 }
        r1 = r7.append(r1);	 Catch:{ all -> 0x03a7 }
        r1 = r1.toString();	 Catch:{ all -> 0x03a7 }
        r5[r6] = r1;	 Catch:{ all -> 0x03a7 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ all -> 0x03a7 }
        r1 = "LogUpload Service";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "finally close ";
        r4[r5] = r6;
        com.huawei.v.c.b(r1, r4);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r3, r1);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r1);
        goto L_0x01b0;
    L_0x0310:
        r0 = move-exception;
        r13 = r0;
        r0 = r1;
        r1 = r13;
    L_0x0314:
        r3 = "LogUpload Service";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0377 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0377 }
        r7.<init>();	 Catch:{ all -> 0x0377 }
        r8 = "exception ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0377 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0377 }
        r1 = r7.append(r1);	 Catch:{ all -> 0x0377 }
        r1 = r1.toString();	 Catch:{ all -> 0x0377 }
        r5[r6] = r1;	 Catch:{ all -> 0x0377 }
        com.huawei.v.c.e(r3, r5);	 Catch:{ all -> 0x0377 }
        r1 = "LogUpload Service";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r6 = "finally close ";
        r3[r5] = r6;
        com.huawei.v.c.b(r1, r3);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r4, r1);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r1);
        goto L_0x01b0;
    L_0x034f:
        r0 = move-exception;
        r0 = r1;
    L_0x0351:
        r1 = "LogUpload Service";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0377 }
        r5 = 0;
        r6 = " OutOfMemoryError";
        r3[r5] = r6;	 Catch:{ all -> 0x0377 }
        com.huawei.v.c.b(r1, r3);	 Catch:{ all -> 0x0377 }
        r1 = "LogUpload Service";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r6 = "finally close ";
        r3[r5] = r6;
        com.huawei.v.c.b(r1, r3);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r4, r1);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r1);
        goto L_0x01b0;
    L_0x0377:
        r0 = move-exception;
    L_0x0378:
        r1 = "LogUpload Service";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r6 = "finally close ";
        r3[r5] = r6;
        com.huawei.v.c.b(r1, r3);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21883a(r4, r1);
        r1 = "LogUpload Service";
        com.huawei.hwappdfxmgr.p056f.C4593d.m21882a(r2, r1);
        throw r0;
    L_0x0390:
        r0 = "LogUpload Service";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "异常情况";
        r1[r2] = r3;
        com.huawei.v.c.b(r0, r1);
        goto L_0x0094;
    L_0x03a0:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0378;
    L_0x03a3:
        r0 = move-exception;
        r4 = r2;
        r2 = r3;
        goto L_0x0378;
    L_0x03a7:
        r0 = move-exception;
        r4 = r3;
        goto L_0x0378;
    L_0x03aa:
        r0 = move-exception;
        r0 = r1;
        r2 = r3;
        goto L_0x0351;
    L_0x03ae:
        r0 = move-exception;
        r0 = r1;
        r4 = r2;
        r2 = r3;
        goto L_0x0351;
    L_0x03b3:
        r1 = move-exception;
        r4 = r2;
        r2 = r3;
        goto L_0x0351;
    L_0x03b7:
        r0 = move-exception;
        r2 = r3;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0314;
    L_0x03be:
        r0 = move-exception;
        r4 = r2;
        r2 = r3;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0314;
    L_0x03c6:
        r1 = move-exception;
        r4 = r2;
        r2 = r3;
        goto L_0x0314;
    L_0x03cb:
        r0 = move-exception;
        r3 = r4;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x02c7;
    L_0x03d2:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        r13 = r0;
        r0 = r1;
        r1 = r13;
        goto L_0x02c7;
    L_0x03da:
        r1 = move-exception;
        r13 = r3;
        r3 = r2;
        r2 = r13;
        goto L_0x02c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwappdfxmgr.upload.UploadRequest.upLoadHttpsEventLog(com.huawei.hwappdfxmgr.upload.EvenLogUpload):void");
    }

    public static void deleteEncryFile(EvenLogUpload evenLogUpload) {
        String path = evenLogUpload.getPath();
        C2538c.c(LOG_TAG, new Object[]{"encryfilePath" + path});
        if (path != null && !path.equals("")) {
            File file = new File(path);
            C2538c.c(LOG_TAG, new Object[]{"encryfilePath" + file.getAbsolutePath()});
            if (file.exists() && file.delete()) {
                C2538c.c(LOG_TAG, new Object[]{"文件删除成功！"});
                return;
            }
            C2538c.c(LOG_TAG, new Object[]{"文件不存在 或者 出错！文件删除失败!"});
        }
    }
}
