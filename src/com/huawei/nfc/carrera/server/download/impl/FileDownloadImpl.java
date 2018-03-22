package com.huawei.nfc.carrera.server.download.impl;

import android.content.Context;
import com.huawei.nfc.carrera.logic.filedownload.DownLoadListener;
import com.huawei.nfc.carrera.server.download.FileDownloadApi;
import java.io.File;

public class FileDownloadImpl implements FileDownloadApi {
    private static final int DOWNLOAD_CONNECT_TIME_OUT = 30000;
    private static final int DOWNLOAD_READ_TIME_OUT = 30000;
    private static final String DOWNLOAD_URL = "https://mpay.unionpay.com/";
    private static byte[] SYNC_LOCK = new byte[0];
    private long currentSize = 0;
    private volatile boolean isCancel = false;
    private final Context mContext;
    private int progressTemp = 0;

    public FileDownloadImpl(Context context) {
        this.mContext = context;
    }

    public int download(String str, File file) {
        return download(str, file, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int download(java.lang.String r15, java.io.File r16, com.huawei.nfc.carrera.logic.filedownload.DownLoadListener r17) {
        /*
        r14 = this;
        r4 = 0;
        r9 = 0;
        r3 = -2;
        r5 = 1;
        r2 = r14.mContext;
        r2 = com.huawei.aj.p315a.p318c.C4026a.m19819a(r2);
        if (r2 != 0) goto L_0x0013;
    L_0x000c:
        r2 = "download file, but no network.";
        com.huawei.nfc.carrera.util.LogX.w(r2);
        r2 = -1;
    L_0x0012:
        return r2;
    L_0x0013:
        r2 = com.huawei.nfc.carrera.util.StringUtil.isEmpty(r15, r5);
        if (r2 == 0) goto L_0x0020;
    L_0x0019:
        r2 = "download, but remote path is illegal.";
        com.huawei.nfc.carrera.util.LogX.w(r2);
        r2 = r3;
        goto L_0x0012;
    L_0x0020:
        r5 = 0;
        r8 = 0;
        r14.isCancel = r9;
        r2 = new java.net.URL;	 Catch:{ FileNotFoundException -> 0x0213, IOException -> 0x01ad, all -> 0x01d5 }
        r2.<init>(r15);	 Catch:{ FileNotFoundException -> 0x0213, IOException -> 0x01ad, all -> 0x01d5 }
        r2 = r2.openConnection();	 Catch:{ FileNotFoundException -> 0x0213, IOException -> 0x01ad, all -> 0x01d5 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ FileNotFoundException -> 0x0213, IOException -> 0x01ad, all -> 0x01d5 }
        r6 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2.setConnectTimeout(r6);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r6 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2.setReadTimeout(r6);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r6 = 1;
        r2.setDoInput(r6);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r2.connect();	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r6 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r6.<init>();	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r7 = "===123===download,getResponseCode = ";
        r6 = r6.append(r7);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r7 = r2.getResponseCode();	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r6 = r6.append(r7);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r6 = r6.toString();	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        com.huawei.nfc.carrera.util.LogX.w(r6);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r6 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        r7 = r2.getResponseCode();	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        if (r6 != r7) goto L_0x00d4;
    L_0x0062:
        r6 = "Location";
        r6 = r2.getHeaderField(r6);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r7 = 1;
        r7 = com.huawei.nfc.carrera.util.StringUtil.isEmpty(r6, r7);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        if (r7 == 0) goto L_0x008e;
    L_0x006f:
        if (r4 == 0) goto L_0x0074;
    L_0x0071:
        r8.close();	 Catch:{ IOException -> 0x0080 }
    L_0x0074:
        if (r4 == 0) goto L_0x0079;
    L_0x0076:
        r5.close();	 Catch:{ IOException -> 0x0087 }
    L_0x0079:
        if (r2 == 0) goto L_0x007e;
    L_0x007b:
        r2.disconnect();
    L_0x007e:
        r2 = r3;
        goto L_0x0012;
    L_0x0080:
        r6 = move-exception;
        r6 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r6);
        goto L_0x0074;
    L_0x0087:
        r4 = move-exception;
        r4 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r4);
        goto L_0x0079;
    L_0x008e:
        r7 = "https://mpay.unionpay.com/";
        r7 = r6.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        if (r7 != 0) goto L_0x00b6;
    L_0x0096:
        if (r4 == 0) goto L_0x009b;
    L_0x0098:
        r8.close();	 Catch:{ IOException -> 0x00a8 }
    L_0x009b:
        if (r4 == 0) goto L_0x00a0;
    L_0x009d:
        r5.close();	 Catch:{ IOException -> 0x00af }
    L_0x00a0:
        if (r2 == 0) goto L_0x00a5;
    L_0x00a2:
        r2.disconnect();
    L_0x00a5:
        r2 = r3;
        goto L_0x0012;
    L_0x00a8:
        r6 = move-exception;
        r6 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r6);
        goto L_0x009b;
    L_0x00af:
        r4 = move-exception;
        r4 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r4);
        goto L_0x00a0;
    L_0x00b6:
        r3 = new java.net.URL;	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r3.<init>(r6);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r3 = r3.openConnection();	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r0 = r3;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r2 = r0;
        r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2.setConnectTimeout(r3);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2.setReadTimeout(r3);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r3 = 1;
        r2.setDoInput(r3);	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
        r2.connect();	 Catch:{ FileNotFoundException -> 0x0218, IOException -> 0x0207, all -> 0x01f6 }
    L_0x00d4:
        r10 = r2;
        r2 = r10.getContentLength();	 Catch:{ FileNotFoundException -> 0x021f, IOException -> 0x020b, all -> 0x01fb }
        r6 = (long) r2;	 Catch:{ FileNotFoundException -> 0x021f, IOException -> 0x020b, all -> 0x01fb }
        r0 = r17;
        r14.downLoadConnect(r0, r6);	 Catch:{ FileNotFoundException -> 0x021f, IOException -> 0x020b, all -> 0x01fb }
        r12 = r10.getInputStream();	 Catch:{ FileNotFoundException -> 0x021f, IOException -> 0x020b, all -> 0x01fb }
        r2 = r16.getParentFile();	 Catch:{ FileNotFoundException -> 0x0224, IOException -> 0x020e }
        r2 = checkAndMakeDir(r2);	 Catch:{ FileNotFoundException -> 0x0224, IOException -> 0x020e }
        if (r2 != 0) goto L_0x010d;
    L_0x00ed:
        r2 = -4;
        if (r4 == 0) goto L_0x00f3;
    L_0x00f0:
        r8.close();	 Catch:{ IOException -> 0x00ff }
    L_0x00f3:
        if (r12 == 0) goto L_0x00f8;
    L_0x00f5:
        r12.close();	 Catch:{ IOException -> 0x0106 }
    L_0x00f8:
        if (r10 == 0) goto L_0x0012;
    L_0x00fa:
        r10.disconnect();
        goto L_0x0012;
    L_0x00ff:
        r3 = move-exception;
        r3 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x00f3;
    L_0x0106:
        r3 = move-exception;
        r3 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x00f8;
    L_0x010d:
        r11 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0224, IOException -> 0x020e }
        r0 = r16;
        r11.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0224, IOException -> 0x020e }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x014f, IOException -> 0x0210, all -> 0x0200 }
    L_0x0118:
        r8 = r12.read(r2);	 Catch:{ FileNotFoundException -> 0x014f, IOException -> 0x0210, all -> 0x0200 }
        if (r8 <= 0) goto L_0x017f;
    L_0x011e:
        r3 = r14.isCancel;	 Catch:{ FileNotFoundException -> 0x014f, IOException -> 0x0210, all -> 0x0200 }
        if (r3 == 0) goto L_0x0142;
    L_0x0122:
        r2 = -5;
        if (r11 == 0) goto L_0x0128;
    L_0x0125:
        r11.close();	 Catch:{ IOException -> 0x0134 }
    L_0x0128:
        if (r12 == 0) goto L_0x012d;
    L_0x012a:
        r12.close();	 Catch:{ IOException -> 0x013b }
    L_0x012d:
        if (r10 == 0) goto L_0x0012;
    L_0x012f:
        r10.disconnect();
        goto L_0x0012;
    L_0x0134:
        r3 = move-exception;
        r3 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x0128;
    L_0x013b:
        r3 = move-exception;
        r3 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x012d;
    L_0x0142:
        r3 = 0;
        r11.write(r2, r3, r8);	 Catch:{ FileNotFoundException -> 0x014f, IOException -> 0x0210, all -> 0x0200 }
        r3 = r14;
        r4 = r16;
        r5 = r17;
        r3.updateProgress(r4, r5, r6, r8);	 Catch:{ FileNotFoundException -> 0x014f, IOException -> 0x0210, all -> 0x0200 }
        goto L_0x0118;
    L_0x014f:
        r2 = move-exception;
        r3 = r10;
        r4 = r11;
        r5 = r12;
    L_0x0153:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0203 }
        r6.<init>();	 Catch:{ all -> 0x0203 }
        r7 = "download failed, FileNotFoundException.";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0203 }
        r2 = android.util.Log.getStackTraceString(r2);	 Catch:{ all -> 0x0203 }
        r2 = r6.append(r2);	 Catch:{ all -> 0x0203 }
        r2 = r2.toString();	 Catch:{ all -> 0x0203 }
        com.huawei.nfc.carrera.util.LogX.w(r2);	 Catch:{ all -> 0x0203 }
        r2 = -4;
        if (r4 == 0) goto L_0x0173;
    L_0x0170:
        r4.close();	 Catch:{ IOException -> 0x019f }
    L_0x0173:
        if (r5 == 0) goto L_0x0178;
    L_0x0175:
        r5.close();	 Catch:{ IOException -> 0x01a6 }
    L_0x0178:
        if (r3 == 0) goto L_0x0012;
    L_0x017a:
        r3.disconnect();
        goto L_0x0012;
    L_0x017f:
        if (r11 == 0) goto L_0x0184;
    L_0x0181:
        r11.close();	 Catch:{ IOException -> 0x0191 }
    L_0x0184:
        if (r12 == 0) goto L_0x0189;
    L_0x0186:
        r12.close();	 Catch:{ IOException -> 0x0198 }
    L_0x0189:
        if (r10 == 0) goto L_0x018e;
    L_0x018b:
        r10.disconnect();
    L_0x018e:
        r2 = r9;
        goto L_0x0012;
    L_0x0191:
        r2 = move-exception;
        r2 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r2);
        goto L_0x0184;
    L_0x0198:
        r2 = move-exception;
        r2 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r2);
        goto L_0x0189;
    L_0x019f:
        r4 = move-exception;
        r4 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r4);
        goto L_0x0173;
    L_0x01a6:
        r4 = move-exception;
        r4 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r4);
        goto L_0x0178;
    L_0x01ad:
        r2 = move-exception;
        r10 = r4;
        r12 = r4;
    L_0x01b0:
        r2 = "download failed, IOException.";
        com.huawei.nfc.carrera.util.LogX.w(r2);	 Catch:{ all -> 0x01fe }
        r2 = -3;
        if (r4 == 0) goto L_0x01bb;
    L_0x01b8:
        r4.close();	 Catch:{ IOException -> 0x01c7 }
    L_0x01bb:
        if (r12 == 0) goto L_0x01c0;
    L_0x01bd:
        r12.close();	 Catch:{ IOException -> 0x01ce }
    L_0x01c0:
        if (r10 == 0) goto L_0x0012;
    L_0x01c2:
        r10.disconnect();
        goto L_0x0012;
    L_0x01c7:
        r3 = move-exception;
        r3 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x01bb;
    L_0x01ce:
        r3 = move-exception;
        r3 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x01c0;
    L_0x01d5:
        r2 = move-exception;
        r10 = r4;
        r12 = r4;
    L_0x01d8:
        if (r4 == 0) goto L_0x01dd;
    L_0x01da:
        r4.close();	 Catch:{ IOException -> 0x01e8 }
    L_0x01dd:
        if (r12 == 0) goto L_0x01e2;
    L_0x01df:
        r12.close();	 Catch:{ IOException -> 0x01ef }
    L_0x01e2:
        if (r10 == 0) goto L_0x01e7;
    L_0x01e4:
        r10.disconnect();
    L_0x01e7:
        throw r2;
    L_0x01e8:
        r3 = move-exception;
        r3 = "close stream 1 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x01dd;
    L_0x01ef:
        r3 = move-exception;
        r3 = "close stream 2 failed.";
        com.huawei.nfc.carrera.util.LogX.e(r3);
        goto L_0x01e2;
    L_0x01f6:
        r3 = move-exception;
        r10 = r2;
        r12 = r4;
        r2 = r3;
        goto L_0x01d8;
    L_0x01fb:
        r2 = move-exception;
        r12 = r4;
        goto L_0x01d8;
    L_0x01fe:
        r2 = move-exception;
        goto L_0x01d8;
    L_0x0200:
        r2 = move-exception;
        r4 = r11;
        goto L_0x01d8;
    L_0x0203:
        r2 = move-exception;
        r10 = r3;
        r12 = r5;
        goto L_0x01d8;
    L_0x0207:
        r3 = move-exception;
        r10 = r2;
        r12 = r4;
        goto L_0x01b0;
    L_0x020b:
        r2 = move-exception;
        r12 = r4;
        goto L_0x01b0;
    L_0x020e:
        r2 = move-exception;
        goto L_0x01b0;
    L_0x0210:
        r2 = move-exception;
        r4 = r11;
        goto L_0x01b0;
    L_0x0213:
        r2 = move-exception;
        r3 = r4;
        r5 = r4;
        goto L_0x0153;
    L_0x0218:
        r3 = move-exception;
        r5 = r4;
        r13 = r2;
        r2 = r3;
        r3 = r13;
        goto L_0x0153;
    L_0x021f:
        r2 = move-exception;
        r3 = r10;
        r5 = r4;
        goto L_0x0153;
    L_0x0224:
        r2 = move-exception;
        r3 = r10;
        r5 = r12;
        goto L_0x0153;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.server.download.impl.FileDownloadImpl.download(java.lang.String, java.io.File, com.huawei.nfc.carrera.logic.filedownload.DownLoadListener):int");
    }

    private static boolean checkAndMakeDir(File file) {
        if (file == null) {
            return false;
        }
        synchronized (SYNC_LOCK) {
            if (file.exists() || file.mkdirs()) {
                return true;
            }
            return false;
        }
    }

    private void updateProgress(File file, DownLoadListener downLoadListener, long j, int i) {
        this.currentSize += (long) i;
        int i2 = (int) ((this.currentSize * 100) / j);
        if (i2 > this.progressTemp) {
            downProgressMethod(downLoadListener, i2, this.currentSize, file.getAbsolutePath());
            this.progressTemp = i2;
        }
    }

    private void downProgressMethod(DownLoadListener downLoadListener, int i, long j, String str) {
        if (downLoadListener != null) {
            downLoadListener.downProgress(i, j, str);
        }
    }

    private void downLoadConnect(DownLoadListener downLoadListener, long j) {
        if (downLoadListener != null) {
            downLoadListener.downLoadConnected(j);
        }
    }

    public void cancelDownLoad() {
        this.isCancel = true;
    }
}
