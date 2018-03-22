package com.huawei.wallet.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.wallet.storage.path.PayStorageUtil;
import com.huawei.wallet.utils.log.LogC;
import com.huawei.wallet.utils.log.LogErrorConstant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageDownloadUtil extends AsyncTask<String, Void, String[]> {
    private CallBack f21598a;
    private Context f21599b;
    private int f21600c;

    public interface CallBack {
        void m28451a(String str);

        void m28452b(String str);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m28456a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m28457b((String[]) obj);
    }

    protected String[] m28456a(String... strArr) {
        String str = strArr[0];
        return m28455a(str.trim(), strArr[1]);
    }

    protected void m28457b(String[] strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        if ("0".equals(str)) {
            this.f21598a.m28451a(str2);
        } else {
            this.f21598a.m28452b(str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] m28455a(java.lang.String r10, java.lang.String r11) {
        /*
        r9 = this;
        r2 = 0;
        r0 = 2;
        r1 = new java.lang.String[r0];
        r0 = "-1";
        r1[r2] = r0;
        r0 = 1;
        r2 = "";
        r1[r0] = r2;
        r0 = "image_downloader";
        r0 = android.net.http.AndroidHttpClient.newInstance(r0);
        r4 = new org.apache.http.client.methods.HttpGet;
        r4.<init>(r10);
        r2 = r0.execute(r4);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r3 = r2.getStatusLine();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r3 = r3.getStatusCode();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 == r5) goto L_0x0056;
    L_0x0028:
        r2 = "ImageDownloaderTask";
        r5 = new java.lang.StringBuilder;	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r5.<init>();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r6 = "Error ";
        r5 = r5.append(r6);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r3 = r5.append(r3);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r5 = " while retrieving bitmap from ";
        r3 = r3.append(r5);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r3 = r3.append(r10);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r3 = r3.toString();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r5 = 0;
        com.huawei.wallet.utils.log.LogC.m28528b(r2, r3, r5);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        r2 = r0 instanceof android.net.http.AndroidHttpClient;
        if (r2 == 0) goto L_0x0054;
    L_0x004f:
        r0 = (android.net.http.AndroidHttpClient) r0;
        r0.close();
    L_0x0054:
        r0 = r1;
    L_0x0055:
        return r0;
    L_0x0056:
        r5 = r2.getEntity();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        if (r5 == 0) goto L_0x006c;
    L_0x005c:
        r2 = 0;
        r2 = r5.getContent();	 Catch:{ FileNotFoundException -> 0x00a8, IllegalStateException -> 0x0114, IOException -> 0x013d, all -> 0x015b }
        r9.m28454a(r11, r2, r1);	 Catch:{ FileNotFoundException -> 0x00a8, IllegalStateException -> 0x0114, IOException -> 0x013d }
        if (r2 == 0) goto L_0x0069;
    L_0x0066:
        r2.close();	 Catch:{ IOException -> 0x0077, ClientProtocolException -> 0x0081, IllegalStateException -> 0x00ec }
    L_0x0069:
        r5.consumeContent();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
    L_0x006c:
        r2 = r0 instanceof android.net.http.AndroidHttpClient;
        if (r2 == 0) goto L_0x0075;
    L_0x0070:
        r0 = (android.net.http.AndroidHttpClient) r0;
        r0.close();
    L_0x0075:
        r0 = r1;
        goto L_0x0055;
    L_0x0077:
        r2 = move-exception;
        r2 = "ImageDownloaderTask";
        r3 = "can not close stream";
        r6 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r2, r3, r6);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x0069;
    L_0x0081:
        r2 = move-exception;
        r4.abort();	 Catch:{ all -> 0x0128 }
        r3 = "ImageDownloaderTask";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0128 }
        r4.<init>();	 Catch:{ all -> 0x0128 }
        r5 = "I/O error while retrieving bitmap from ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0128 }
        r4 = r4.append(r10);	 Catch:{ all -> 0x0128 }
        r4 = r4.toString();	 Catch:{ all -> 0x0128 }
        r5 = 0;
        com.huawei.wallet.utils.log.LogC.m28523a(r3, r4, r2, r5);	 Catch:{ all -> 0x0128 }
        r2 = r0 instanceof android.net.http.AndroidHttpClient;
        if (r2 == 0) goto L_0x0075;
    L_0x00a2:
        r0 = (android.net.http.AndroidHttpClient) r0;
        r0.close();
        goto L_0x0075;
    L_0x00a8:
        r3 = move-exception;
        r3 = "ImageDownloaderTask";
        r6 = "streamdecode error.";
        r7 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r3, r6, r7);	 Catch:{ all -> 0x0172 }
        if (r2 == 0) goto L_0x00b7;
    L_0x00b4:
        r2.close();	 Catch:{ IOException -> 0x00e2, ClientProtocolException -> 0x0081, IllegalStateException -> 0x00ec }
    L_0x00b7:
        r5.consumeContent();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x006c;
    L_0x00bb:
        r2 = move-exception;
        r4.abort();	 Catch:{ all -> 0x0128 }
        r3 = "ImageDownloaderTask";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0128 }
        r4.<init>();	 Catch:{ all -> 0x0128 }
        r5 = "I/O error while retrieving bitmap from ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0128 }
        r4 = r4.append(r10);	 Catch:{ all -> 0x0128 }
        r4 = r4.toString();	 Catch:{ all -> 0x0128 }
        r5 = 0;
        com.huawei.wallet.utils.log.LogC.m28523a(r3, r4, r2, r5);	 Catch:{ all -> 0x0128 }
        r2 = r0 instanceof android.net.http.AndroidHttpClient;
        if (r2 == 0) goto L_0x0075;
    L_0x00dc:
        r0 = (android.net.http.AndroidHttpClient) r0;
        r0.close();
        goto L_0x0075;
    L_0x00e2:
        r2 = move-exception;
        r2 = "ImageDownloaderTask";
        r3 = "can not close stream";
        r6 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r2, r3, r6);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x00b7;
    L_0x00ec:
        r2 = move-exception;
        r4.abort();	 Catch:{ all -> 0x0128 }
        r2 = "ImageDownloaderTask";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0128 }
        r3.<init>();	 Catch:{ all -> 0x0128 }
        r4 = "Incorrect URL: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0128 }
        r3 = r3.append(r10);	 Catch:{ all -> 0x0128 }
        r3 = r3.toString();	 Catch:{ all -> 0x0128 }
        r4 = 0;
        com.huawei.wallet.utils.log.LogC.m28531c(r2, r3, r4);	 Catch:{ all -> 0x0128 }
        r2 = r0 instanceof android.net.http.AndroidHttpClient;
        if (r2 == 0) goto L_0x0075;
    L_0x010d:
        r0 = (android.net.http.AndroidHttpClient) r0;
        r0.close();
        goto L_0x0075;
    L_0x0114:
        r3 = move-exception;
        r3 = "ImageDownloaderTask";
        r6 = "streamdecode error.";
        r7 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r3, r6, r7);	 Catch:{ all -> 0x0172 }
        if (r2 == 0) goto L_0x0123;
    L_0x0120:
        r2.close();	 Catch:{ IOException -> 0x0133, ClientProtocolException -> 0x0081, IllegalStateException -> 0x00ec }
    L_0x0123:
        r5.consumeContent();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x006c;
    L_0x0128:
        r1 = move-exception;
        r2 = r0 instanceof android.net.http.AndroidHttpClient;
        if (r2 == 0) goto L_0x0132;
    L_0x012d:
        r0 = (android.net.http.AndroidHttpClient) r0;
        r0.close();
    L_0x0132:
        throw r1;
    L_0x0133:
        r2 = move-exception;
        r2 = "ImageDownloaderTask";
        r3 = "can not close stream";
        r6 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r2, r3, r6);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x0123;
    L_0x013d:
        r3 = move-exception;
        r3 = "ImageDownloaderTask";
        r6 = "streamdecode error.";
        r7 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r3, r6, r7);	 Catch:{ all -> 0x0172 }
        if (r2 == 0) goto L_0x014c;
    L_0x0149:
        r2.close();	 Catch:{ IOException -> 0x0151, ClientProtocolException -> 0x0081, IllegalStateException -> 0x00ec }
    L_0x014c:
        r5.consumeContent();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x006c;
    L_0x0151:
        r2 = move-exception;
        r2 = "ImageDownloaderTask";
        r3 = "can not close stream";
        r6 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r2, r3, r6);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x014c;
    L_0x015b:
        r3 = move-exception;
        r8 = r3;
        r3 = r2;
        r2 = r8;
    L_0x015f:
        if (r3 == 0) goto L_0x0164;
    L_0x0161:
        r3.close();	 Catch:{ IOException -> 0x0168, ClientProtocolException -> 0x0081, IllegalStateException -> 0x00ec }
    L_0x0164:
        r5.consumeContent();	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        throw r2;	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
    L_0x0168:
        r3 = move-exception;
        r3 = "ImageDownloaderTask";
        r6 = "can not close stream";
        r7 = 0;
        com.huawei.wallet.utils.log.LogC.m28533d(r3, r6, r7);	 Catch:{ ClientProtocolException -> 0x0081, IOException -> 0x00bb, IllegalStateException -> 0x00ec }
        goto L_0x0164;
    L_0x0172:
        r3 = move-exception;
        r8 = r3;
        r3 = r2;
        r2 = r8;
        goto L_0x015f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wallet.utils.ImageDownloadUtil.a(java.lang.String, java.lang.String):java.lang.String[]");
    }

    private String m28453a() {
        if (this.f21600c == 1) {
            return PayStorageUtil.m28141b(this.f21599b);
        }
        if (this.f21600c == 2) {
            return PayStorageUtil.m28142c(this.f21599b);
        }
        return "";
    }

    private void m28454a(String str, InputStream inputStream, String[] strArr) {
        FileNotFoundException e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        byte[] bArr = new byte[1024];
        try {
            File file = new File(m28453a());
            if (!file.exists() && file.mkdirs()) {
                LogC.m28533d("ImageDownloaderTask", "saveToFile create dir fail!", false);
            }
            File file2 = new File(file, str);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            while (true) {
                try {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                } catch (IOException e3) {
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
            }
            fileOutputStream2.flush();
            strArr[0] = "0";
            strArr[1] = file2.getCanonicalPath();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    LogC.m28533d("ImageDownloaderTask", "saveToFile IOException", false);
                }
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            try {
                LogC.m28522a("ImageDownloaderTasksaveToFile FileNotFoundException", 907118125, LogErrorConstant.m28535a("ImageDownloadUtil.saveToFile", e.getMessage()), false);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        LogC.m28533d("ImageDownloaderTask", "saveToFile IOException", false);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        LogC.m28533d("ImageDownloaderTask", "saveToFile IOException", false);
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            LogC.m28533d("ImageDownloaderTask", "saveToFile IOException", false);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e9) {
                    LogC.m28533d("ImageDownloaderTask", "saveToFile IOException", false);
                }
            }
        }
    }
}
