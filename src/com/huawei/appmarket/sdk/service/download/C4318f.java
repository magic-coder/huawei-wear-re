package com.huawei.appmarket.sdk.service.download;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.SparseIntArray;
import com.huawei.appmarket.sdk.foundation.p354a.p355a.C4238a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.C4275a;
import com.huawei.appmarket.sdk.foundation.p367e.C4282b;
import com.huawei.appmarket.sdk.foundation.p367e.p371c.C4285c;
import com.huawei.appmarket.sdk.foundation.pm.smartmerge.C4291a;
import com.huawei.appmarket.sdk.service.download.bean.C4310a;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;
import com.huawei.appmarket.sdk.service.p372b.C4292a;
import com.huawei.appmarket.sdk.service.p373c.C4302j;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class C4318f implements Runnable {
    private int f16060a = 0;
    private SparseIntArray f16061b;
    private DownloadTask f16062c;
    private Handler f16063d;
    private long f16064e = 0;
    private C4308c f16065f = new C4309b();
    private boolean f16066g = false;
    private List<C4310a> f16067h;

    public C4318f(DownloadTask downloadTask, Handler handler) {
        this.f16062c = downloadTask;
        this.f16063d = handler;
    }

    private int m20806a(long j) {
        if (this.f16067h == null) {
            return -1;
        }
        int i = 0;
        while (i < this.f16067h.size()) {
            if (((C4310a) this.f16067h.get(i)).m20779a() == 0 && j >= ((C4310a) this.f16067h.get(i)).f16034b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private long m20807a(long j, long j2) {
        long j3 = 524288;
        if (j2 != -1) {
            long j4 = j2 - j;
            if (524288 >= j4) {
                j3 = j4;
            }
        }
        return j3 + j;
    }

    private long m20808a(HttpResponse httpResponse) throws IOException {
        long j = 0;
        Header lastHeader = httpResponse.getLastHeader("Content-Range");
        if (lastHeader == null) {
            return 0;
        }
        String value = lastHeader.getValue();
        if (!value.startsWith("bytes")) {
            return 0;
        }
        int indexOf = value.indexOf(47);
        if (-1 != indexOf) {
            try {
                j = Long.parseLong(value.substring(indexOf + 1));
                C4241a.m20529a("DownloadRunnable", "get new filelength by Content-Range:" + j + " ,task id:" + this.f16062c.getId());
                return j;
            } catch (NumberFormatException e) {
                C4241a.m20532b("DownloadRunnable", "getEntityLegth NumberFormatException=" + lastHeader);
                return j;
            }
        }
        C4241a.m20532b("DownloadRunnable", "getEntityLegth Content-Range=" + lastHeader);
        return 0;
    }

    private File m20809a(String str, HttpResponse httpResponse) {
        C4241a.m20529a("DownloadRunnable", "downloadPath:" + str);
        File file = new File(str, "tmp");
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            return null;
        }
        File file2;
        String filename;
        if (this.f16062c.getFilepath() != null) {
            file2 = new File(this.f16062c.getFilepath());
            if (file2.exists()) {
                return file2;
            }
            filename = this.f16062c.getFilename();
        } else {
            filename = m20815b(httpResponse);
        }
        File file3 = new File(file, filename);
        if (file3.exists()) {
            file3.delete();
        }
        try {
            file3.createNewFile();
            this.f16062c.setFilepath(file3.getAbsolutePath());
            this.f16062c.setAlreadDownloadSize(0);
            this.f16062c.setStatus(1);
            this.f16063d.sendMessage(this.f16063d.obtainMessage(this.f16062c.getStatus(), this.f16062c));
            file2 = file3;
        } catch (Throwable e) {
            C4241a.m20530a("DownloadRunnable", "create " + this.f16062c.getFilepath() + ", failed!", e);
            file2 = null;
        }
        return file2;
    }

    private void m20810a(C4302j c4302j) {
        HttpParams a = c4302j.m20749a();
        HttpConnectionParams.setConnectionTimeout(a, 10000);
        HttpConnectionParams.setSoTimeout(a, 20000);
        HttpClientParams.setRedirecting(a, true);
        if (C4285c.m20683a(C4292a.m20708a().m20709b())) {
            Log.d("DownloadRunnable", "setConnectParam : wap");
            if (C4285c.m20680a() != null) {
                a.setParameter(ConnRoutePNames.DEFAULT_PROXY, C4285c.m20680a());
            }
        }
    }

    private void m20811a(String str, Header[] headerArr) {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("DownloadTask " + str + " header,taskid:" + this.f16062c.getId() + "{");
        if (headerArr != null) {
            for (int i = 0; i < headerArr.length; i++) {
                stringBuffer.append("\n\t" + headerArr[i].getName() + ":" + headerArr[i].getValue());
            }
        }
        stringBuffer.append("\n}");
        C4241a.m20529a(str, stringBuffer.toString());
    }

    private void m20812a(HttpGet httpGet) {
        HttpParams params = httpGet.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpConnectionParams.setSoTimeout(params, 20000);
        if (C4285c.m20683a(C4292a.m20708a().m20709b())) {
            httpGet.addHeader("Range", "bytes=" + this.f16064e + "-" + m20807a(this.f16064e, -1));
            C4241a.m20529a("DownloadRunnable", "This is WAP Download,taskID:" + this.f16062c.getId());
        } else if (this.f16064e != 0) {
            httpGet.addHeader("Range", "bytes=" + this.f16064e + "-");
        }
    }

    private boolean m20813a(File file) {
        File file2 = new File(this.f16062c.getFilepath());
        String a = C4282b.m20662a(this.f16062c.getPackageName(), C4292a.m20708a().m20709b());
        C4291a c4291a = new C4291a(file2.getAbsolutePath(), this.f16062c.getDiffMD5(), this.f16062c.hash_);
        int a2 = c4291a.m20700a(a, file.getAbsolutePath());
        file2.delete();
        switch (a2) {
            case 0:
                C4241a.m20529a("DownloadRunnable", "Merge sucessfully, task:" + this.f16062c);
                return true;
            case 1:
                this.f16062c.getDownloadFailedReason().f16040b = "Merge failed, error code:" + c4291a.m20699a() + "," + this.f16062c.toSmapleString();
                this.f16062c.getDownloadFailedReason().f16039a = 500;
                C4241a.m20532b("DownloadRunnable", "Merge failed,taskID:" + this.f16062c.getId() + ", error code:" + c4291a.m20699a());
                return false;
            case 2:
                this.f16062c.getDownloadFailedReason().f16040b = "DiffApk md5 NOT match:" + c4291a.m20701b() + "," + this.f16062c.toSmapleString();
                this.f16062c.getDownloadFailedReason().f16039a = 500;
                return false;
            case 3:
                this.f16062c.getDownloadFailedReason().f16040b = "MergeAPK MD5 NOT match:" + c4291a.m20702c() + "," + this.f16062c.toSmapleString();
                this.f16062c.getDownloadFailedReason().f16039a = 500;
                C4241a.m20532b("DownloadRunnable", "MD5 NOT match, newApkMd5:" + c4291a.m20702c() + ", " + this.f16062c);
                return false;
            default:
                return false;
        }
    }

    private boolean m20814a(RandomAccessFile randomAccessFile, int i) {
        long j = 0;
        try {
            long filePointer = randomAccessFile.getFilePointer();
            byte[] bArr = new byte[1024];
            try {
                long j2 = ((C4310a) this.f16067h.get(i)).f16033a;
                long j3 = 1 + (((C4310a) this.f16067h.get(i)).f16034b - ((C4310a) this.f16067h.get(i)).f16033a);
                MessageDigest instance = MessageDigest.getInstance("md5");
                randomAccessFile.seek(j2 - 1);
                while (j < j3) {
                    long j4;
                    int read = randomAccessFile.read(bArr, 0, (int) (PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID + (j2 + j) <= ((C4310a) this.f16067h.get(i)).f16034b ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : ((((C4310a) this.f16067h.get(i)).f16034b - j2) - j) + 1));
                    String a;
                    if (read == -1) {
                        if (j != j3) {
                            ((C4310a) this.f16067h.get(i)).m20780a(-2);
                            break;
                        }
                        a = C4275a.m20647a(instance.digest());
                        if (a.equals(((C4310a) this.f16067h.get(i)).m20781b())) {
                            ((C4310a) this.f16067h.get(i)).m20780a(1);
                            C4241a.m20529a("DownloadRunnable", "silce check success：" + i);
                            j4 = j;
                        } else {
                            ((C4310a) this.f16067h.get(i)).m20780a(-1);
                            randomAccessFile.seek(filePointer);
                            C4241a.m20529a("DownloadRunnable", "silce check error：" + i + ",local:" + a + ",server:" + ((C4310a) this.f16067h.get(i)).m20781b());
                            return false;
                        }
                    }
                    j += (long) read;
                    instance.update(bArr, 0, read);
                    if (j == j3) {
                        a = C4275a.m20647a(instance.digest());
                        if (a.equals(((C4310a) this.f16067h.get(i)).m20781b())) {
                            ((C4310a) this.f16067h.get(i)).m20780a(1);
                            C4241a.m20529a("DownloadRunnable", "silce check success：" + i);
                            j4 = j;
                        } else {
                            ((C4310a) this.f16067h.get(i)).m20780a(-1);
                            randomAccessFile.seek(filePointer);
                            C4241a.m20529a("DownloadRunnable", "silce check error：" + i + ",local:" + a + ",server:" + ((C4310a) this.f16067h.get(i)).m20781b());
                            return false;
                        }
                    }
                    j4 = j;
                    j = j4;
                }
                randomAccessFile.seek(filePointer);
            } catch (Throwable e) {
                Throwable th = e;
                randomAccessFile.seek(filePointer);
                ((C4310a) this.f16067h.get(i)).m20780a(-2);
                C4241a.m20530a("DownloadRunnable", "silce check get MD5 exception", th);
            }
        } catch (Exception e2) {
            C4241a.m20529a("DownloadRunnable", "silce apkFile.getFilePointer Exception");
        }
        return true;
    }

    private String m20815b(HttpResponse httpResponse) {
        Header[] allHeaders = httpResponse.getAllHeaders();
        for (int i = 0; i < allHeaders.length; i++) {
            if ("content-disposition".equalsIgnoreCase(allHeaders[i].getName())) {
                String value = allHeaders[i].getValue();
                if (value == null) {
                    break;
                }
                Matcher matcher = Pattern.compile(".*filename=\"(.*)\"").matcher(value.toLowerCase(Locale.US));
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        }
        String uuid = UUID.randomUUID().toString();
        return this.f16062c.isSmartpatch() ? uuid + ".vcdiff" : uuid + ".apk";
    }

    private C4302j m20816c() {
        C4302j c4302j = new C4302j("HiSpace", C4292a.m20708a().m20709b());
        try {
            C4238a e = C4292a.m20708a().m20712e();
            if (e != null) {
                SocketFactory a = e.m20524a();
                if (a != null) {
                    c4302j.m20751b().getSchemeRegistry().register(new Scheme("https", a, 443));
                }
            }
        } catch (Throwable e2) {
            C4241a.m20530a("DownloadRunnable", "register https scheme handler failed", e2);
        }
        return c4302j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20817d() {
        /*
        r28 = this;
        r9 = 0;
        r8 = 0;
        r5 = 0;
        r4 = 0;
        r17 = 0;
        r0 = r28;
        r6 = r0.f16062c;
        r6.getFileSize();
        r0 = r28;
        r6 = r0.f16062c;
        r6 = r6.getAlreadDownloadSize();
        r0 = r28;
        r0.f16064e = r6;
        r0 = r28;
        r6 = r0.f16062c;
        r6 = r6.getSliceChkList();
        r0 = r28;
        r0.f16067h = r6;
        r16 = 0;
        r7 = 0;
        r10 = 0;
        r14 = r28.m20816c();	 Catch:{ h -> 0x07b8, Exception -> 0x079c, all -> 0x0783 }
        r0 = r28;
        r0.m20810a(r14);	 Catch:{ h -> 0x07c1, Exception -> 0x07a4, all -> 0x0788 }
        r15 = new org.apache.http.client.methods.HttpGet;	 Catch:{ h -> 0x07c1, Exception -> 0x07a4, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07a4, all -> 0x0788 }
        r6 = r6.getUrl();	 Catch:{ h -> 0x07c1, Exception -> 0x07a4, all -> 0x0788 }
        r15.<init>(r6);	 Catch:{ h -> 0x07c1, Exception -> 0x07a4, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6.setHttpGet(r15);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r0.m20812a(r15);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = "request";
        r9 = r15.getAllHeaders();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r0.m20811a(r6, r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r14.m20747a(r15);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        if (r9 != 0) goto L_0x00ab;
    L_0x005c:
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = 8;
        r6.setStatus(r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r6.getDownloadFailedReason();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = "Http response null";
        r6.f16041c = r9;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = "DownloadRunnable";
        r9 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = "task:";
        r9 = r9.append(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r10 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.append(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = " download failed,response null";
        r9 = r9.append(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r6, r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;
        r7 = 0;
        r6.setHttpGet(r7);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r4);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r8);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r5);
        if (r14 == 0) goto L_0x00aa;
    L_0x00a7:
        r14.m20752c();
    L_0x00aa:
        return;
    L_0x00ab:
        r6 = "response";
        r10 = r9.getAllHeaders();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r0.m20811a(r6, r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r9.getStatusLine();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r6.getStatusCode();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 == r10) goto L_0x0193;
    L_0x00c2:
        r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r10 = r9.getStatusLine();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.getStatusCode();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        if (r6 == r10) goto L_0x0193;
    L_0x00ce:
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r6.getFileSize();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = 0;
        r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r6 == 0) goto L_0x0126;
    L_0x00dc:
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r6.getFileSize();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r6.getAlreadDownloadSize();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r6 != 0) goto L_0x0126;
    L_0x00f0:
        r6 = "DownloadRunnable";
        r9 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = "Warning task has download done, continue to processDownloadedTempFile:";
        r9 = r9.append(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r10 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.append(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r6, r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r28.m20818e();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;
        r7 = 0;
        r6.setHttpGet(r7);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r4);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r8);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r5);
        if (r14 == 0) goto L_0x00aa;
    L_0x0122:
        r14.m20752c();
        goto L_0x00aa;
    L_0x0126:
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = 8;
        r6.setStatus(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r6.getDownloadFailedReason();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = "Http StatusCode:";
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = r9.getStatusLine();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6.f16041c = r10;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = "DownloadRunnable";
        r10 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = "task:";
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r11 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = " download failed, status line:";
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.getStatusLine();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r10.append(r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r6, r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;
        r7 = 0;
        r6.setHttpGet(r7);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r4);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r8);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r5);
        if (r14 == 0) goto L_0x00aa;
    L_0x018e:
        r14.m20752c();
        goto L_0x00aa;
    L_0x0193:
        r6 = r9.getEntity();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r10 = r0.f16064e;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r6.getContentLength();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r22 = r10 + r12;
        r10 = "DownloadRunnable";
        r11 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = "file block length:";
        r11 = r11.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r12 = r0.f16064e;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r22 - r12;
        r11 = r11.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = " ,task:";
        r11 = r11.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r12 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r12.getId();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = r11.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = r11.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r10, r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r10 = r0.m20808a(r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = 0;
        r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x01df;
    L_0x01dd:
        r10 = r22;
    L_0x01df:
        r0 = r28;
        r12 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r12.getFileSize();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r18 = 0;
        r12 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1));
        if (r12 != 0) goto L_0x0291;
    L_0x01ed:
        r0 = r28;
        r12 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12.setFileSize(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
    L_0x01f4:
        r0 = r28;
        r10 = r0.f16065f;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r11 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r11.getFileSize();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r11 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = r11.getName();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r7 = r10.mo4410a(r12, r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r7.f16049a;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        if (r10 != 0) goto L_0x0368;
    L_0x0210:
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = 6;
        r6.setStatus(r9);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = 1;
        r10 = 5;
        r6.setInterrupt(r9, r10);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r6.getDownloadFailedReason();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9.<init>();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.append(r7);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r10 = ", ";
        r9 = r9.append(r10);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r10 = r0.f16062c;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.toSmapleString();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.append(r10);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.toString();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r6.f16040b = r9;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r6.getDownloadFailedReason();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        r6.f16039a = r9;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r6 = "DownloadRunnable";
        r0 = r28;
        r9 = r0.f16062c;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.getDownloadFailedReason();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.f16040b;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r6, r9);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r6 = "HiSpace";
        r9 = 5;
        r10 = "SpaceNotEnough";
        r0 = r28;
        r11 = r0.f16062c;	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r11 = r11.getUrl();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r11 = java.net.URI.create(r11);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.service.p373c.C4302j.m20744a(r6, r9, r10, r11);	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;
        r7 = 0;
        r6.setHttpGet(r7);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r4);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r8);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r5);
        if (r14 == 0) goto L_0x00aa;
    L_0x028c:
        r14.m20752c();
        goto L_0x00aa;
    L_0x0291:
        r0 = r28;
        r12 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r12.getFileSize();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r12 == 0) goto L_0x01f4;
    L_0x029d:
        r6 = 1;
        r0 = r28;
        r0.f16066g = r6;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = 0;
        r6.setAlreadDownloadSize(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = 8;
        r6.setStatus(r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r6.getDownloadFailedReason();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = "file length verify failed, server reponse length:";
        r9 = r9.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.append(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6.f16040b = r9;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = r6.getDownloadFailedReason();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = 502; // 0x1f6 float:7.03E-43 double:2.48E-321;
        r6.f16039a = r9;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = "DownloadRunnable";
        r9 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r12 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r12.getDownloadFailedReason();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r12.f16040b;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = ",";
        r9 = r9.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r12 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r9 = r9.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r6, r9);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r6 = "HiSpace";
        r9 = 0;
        r12 = new java.lang.StringBuilder;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12.<init>();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r13 = "APKLengthVerifyError:fileLength=";
        r12 = r12.append(r13);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r12.append(r10);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = ",taskLength=";
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r11 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r12 = r11.getFileSize();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.append(r12);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = ",packageName=";
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r11 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = r11.getPackageName();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.append(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r10 = r10.toString();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r11 = r0.f16062c;	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = r11.getUrl();	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r11 = java.net.URI.create(r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        com.huawei.appmarket.sdk.service.p373c.C4302j.m20744a(r6, r9, r10, r11);	 Catch:{ h -> 0x07c1, Exception -> 0x07ab, all -> 0x0788 }
        r0 = r28;
        r6 = r0.f16062c;
        r7 = 0;
        r6.setHttpGet(r7);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r4);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r8);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r5);
        if (r14 == 0) goto L_0x00aa;
    L_0x0363:
        r14.m20752c();
        goto L_0x00aa;
    L_0x0368:
        r13 = r6.getContent();	 Catch:{ h -> 0x07ca, Exception -> 0x07ab, all -> 0x0788 }
        if (r13 == 0) goto L_0x05ed;
    L_0x036e:
        r6 = r7.f16052d;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        r0 = r28;
        r6 = r0.m20809a(r6, r9);	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        if (r6 != 0) goto L_0x04a0;
    L_0x0378:
        r0 = r28;
        r6 = r0.f16065f;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        r0 = r28;
        r8 = r0.f16062c;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        r10 = r8.getFileSize();	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        r7 = r6.mo4409a(r10);	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        if (r7 == 0) goto L_0x038e;
    L_0x038a:
        r6 = r7.f16049a;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        if (r6 != 0) goto L_0x041f;
    L_0x038e:
        r6 = new java.io.IOException;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        r8 = "create temp file fail, and backup location space not enough";
        r6.<init>(r8);	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        throw r6;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
    L_0x0396:
        r6 = move-exception;
        r10 = r4;
        r11 = r5;
        r4 = r6;
        r5 = r7;
        r6 = r13;
        r7 = r14;
    L_0x039d:
        r8 = "DownloadRunnable";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0794 }
        r9.<init>();	 Catch:{ all -> 0x0794 }
        r12 = "download end with SpaceNotEnough:";
        r9 = r9.append(r12);	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r12 = r0.f16062c;	 Catch:{ all -> 0x0794 }
        r9 = r9.append(r12);	 Catch:{ all -> 0x0794 }
        r9 = r9.toString();	 Catch:{ all -> 0x0794 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20530a(r8, r9, r4);	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ all -> 0x0794 }
        r8 = 6;
        r4.setStatus(r8);	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ all -> 0x0794 }
        r8 = 1;
        r9 = 6;
        r4.setInterrupt(r8, r9);	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ all -> 0x0794 }
        r4 = r4.getDownloadFailedReason();	 Catch:{ all -> 0x0794 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0794 }
        r8.<init>();	 Catch:{ all -> 0x0794 }
        r5 = r8.append(r5);	 Catch:{ all -> 0x0794 }
        r8 = ", ";
        r5 = r5.append(r8);	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r8 = r0.f16062c;	 Catch:{ all -> 0x0794 }
        r8 = r8.toSmapleString();	 Catch:{ all -> 0x0794 }
        r5 = r5.append(r8);	 Catch:{ all -> 0x0794 }
        r5 = r5.toString();	 Catch:{ all -> 0x0794 }
        r4.f16040b = r5;	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ all -> 0x0794 }
        r4 = r4.getDownloadFailedReason();	 Catch:{ all -> 0x0794 }
        r5 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        r4.f16039a = r5;	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r4 = r0.f16065f;	 Catch:{ all -> 0x0794 }
        r5 = 0;
        r4.mo4411a(r5);	 Catch:{ all -> 0x0794 }
        r0 = r28;
        r4 = r0.f16062c;
        r5 = 0;
        r4.setHttpGet(r5);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r10);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r6);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r11);
        if (r7 == 0) goto L_0x00aa;
    L_0x041a:
        r7.m20752c();
        goto L_0x00aa;
    L_0x041f:
        r6 = r7.f16052d;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        r0 = r28;
        r6 = r0.m20809a(r6, r9);	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        if (r6 != 0) goto L_0x04a0;
    L_0x0429:
        r6 = new java.io.IOException;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        r8 = "create temp file fail on backup location";
        r6.<init>(r8);	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
        throw r6;	 Catch:{ h -> 0x0396, Exception -> 0x0431, all -> 0x078c }
    L_0x0431:
        r6 = move-exception;
        r10 = r4;
        r11 = r5;
        r8 = r13;
        r5 = r15;
        r4 = r6;
    L_0x0437:
        if (r5 == 0) goto L_0x0442;
    L_0x0439:
        r6 = r5.isAborted();	 Catch:{ all -> 0x0799 }
        if (r6 != 0) goto L_0x0442;
    L_0x043f:
        r5.abort();	 Catch:{ all -> 0x0799 }
    L_0x0442:
        r5 = "DownloadRunnable";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0799 }
        r6.<init>();	 Catch:{ all -> 0x0799 }
        r7 = "download interrupt with exception:";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0799 }
        r0 = r28;
        r7 = r0.f16062c;	 Catch:{ all -> 0x0799 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0799 }
        r6 = r6.toString();	 Catch:{ all -> 0x0799 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20530a(r5, r6, r4);	 Catch:{ all -> 0x0799 }
        r0 = r28;
        r5 = r0.f16062c;	 Catch:{ all -> 0x0799 }
        r5 = r5.getDownloadFailedReason();	 Catch:{ all -> 0x0799 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0799 }
        r6.<init>();	 Catch:{ all -> 0x0799 }
        r7 = "exception:";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0799 }
        r4 = r4.toString();	 Catch:{ all -> 0x0799 }
        r4 = r6.append(r4);	 Catch:{ all -> 0x0799 }
        r4 = r4.toString();	 Catch:{ all -> 0x0799 }
        r5.f16041c = r4;	 Catch:{ all -> 0x0799 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ all -> 0x0799 }
        r5 = 8;
        r4.setStatus(r5);	 Catch:{ all -> 0x0799 }
        r0 = r28;
        r4 = r0.f16062c;
        r5 = 0;
        r4.setHttpGet(r5);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r10);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r8);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r11);
        if (r14 == 0) goto L_0x00aa;
    L_0x049b:
        r14.m20752c();
        goto L_0x00aa;
    L_0x04a0:
        r12 = r7;
        r0 = r28;
        r8 = r0.f16064e;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r0 = r28;
        r7 = r0.f16062c;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r10 = r7.getAlreadDownloadSize();	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 == 0) goto L_0x04e9;
    L_0x04b1:
        r6 = new java.io.IOException;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r7 = new java.lang.StringBuilder;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r7.<init>();	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r8 = "request length ";
        r7 = r7.append(r8);	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r0 = r28;
        r8 = r0.f16064e;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r7 = r7.append(r8);	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r8 = " greater than the length that have been downloaded:";
        r7 = r7.append(r8);	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r0 = r28;
        r8 = r0.f16062c;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r8 = r8.getAlreadDownloadSize();	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r7 = r7.append(r8);	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r7 = r7.toString();	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r6.<init>(r7);	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        throw r6;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
    L_0x04e0:
        r6 = move-exception;
        r10 = r4;
        r11 = r5;
        r7 = r14;
        r5 = r12;
        r4 = r6;
        r6 = r13;
        goto L_0x039d;
    L_0x04e9:
        r10 = new com.huawei.appmarket.sdk.service.download.g;	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r7 = "rw";
        r10.<init>(r6, r7);	 Catch:{ h -> 0x04e0, Exception -> 0x0431, all -> 0x078c }
        r0 = r28;
        r6 = r0.f16064e;	 Catch:{ h -> 0x07d3, Exception -> 0x07b2, all -> 0x0791 }
        r8 = 0;
        r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r4 == 0) goto L_0x0502;
    L_0x04fb:
        r0 = r28;
        r6 = r0.f16064e;	 Catch:{ h -> 0x07d3, Exception -> 0x07b2, all -> 0x0791 }
        r10.seek(r6);	 Catch:{ h -> 0x07d3, Exception -> 0x07b2, all -> 0x0791 }
    L_0x0502:
        r11 = new java.io.BufferedInputStream;	 Catch:{ h -> 0x07d3, Exception -> 0x07b2, all -> 0x0791 }
        r11.<init>(r13);	 Catch:{ h -> 0x07d3, Exception -> 0x07b2, all -> 0x0791 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r4];	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r24 = r0;
        r6 = 0;
        r4 = 0;
        r0 = r28;
        r8 = r0.f16064e;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r20 = r4;
        r4 = r17;
    L_0x0519:
        r0 = r24;
        r5 = r11.read(r0);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r17 = -1;
        r0 = r17;
        if (r5 == r0) goto L_0x07da;
    L_0x0525:
        r4 = 0;
        r0 = r28;
        r0.f16060a = r4;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = (long) r5;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r18 = r0;
        r18 = r18 + r8;
        r0 = r18;
        r8 = (double) r0;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r26 = r4.getFileSize();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r26;
        r0 = (double) r0;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r26 = r0;
        r8 = r8 / r26;
        r26 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r8 = r8 * r26;
        r0 = (int) r8;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r17 = r0;
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = r4.isInterrupt();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        if (r4 != 0) goto L_0x0558;
    L_0x0552:
        r4 = 100;
        r0 = r17;
        if (r0 <= r4) goto L_0x0605;
    L_0x0558:
        r15.abort();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = r16;
        r5 = r17;
        r6 = r18;
    L_0x0561:
        r0 = r28;
        r8 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8.setProgress(r5);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r5 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = r5.isInterrupt();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        if (r5 != 0) goto L_0x05e2;
    L_0x0572:
        if (r4 == 0) goto L_0x06c9;
    L_0x0574:
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = 5;
        r4.setStatus(r5);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = 1;
        r8 = 9;
        r4.setInterrupt(r5, r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = "DownloadRunnable";
        r5 = new java.lang.StringBuilder;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5.<init>();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = "download error, SliceChkError,";
        r5 = r5.append(r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r8 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = r5.append(r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = r5.toString();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r4, r5);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = "HiSpace";
        r5 = 9;
        r8 = new java.lang.StringBuilder;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8.<init>();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = "SliceChkError:packageName =";
        r8 = r8.append(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r9 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = r9.getPackageName();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = r8.append(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = ",";
        r8 = r8.append(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r9 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = r9.getName();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = r8.append(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = r8.toString();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r9 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = r9.getUrl();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = java.net.URI.create(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        com.huawei.appmarket.sdk.service.p373c.C4302j.m20744a(r4, r5, r8, r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
    L_0x05e2:
        r0 = r28;
        r4 = r0.f16064e;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = r6 - r4;
        r14.m20750a(r4);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = r10;
        r5 = r11;
    L_0x05ed:
        r0 = r28;
        r6 = r0.f16062c;
        r7 = 0;
        r6.setHttpGet(r7);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r4);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r13);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r5);
        if (r14 == 0) goto L_0x00aa;
    L_0x0600:
        r14.m20752c();
        goto L_0x00aa;
    L_0x0605:
        r4 = 0;
        r0 = r24;
        r10.write(r0, r4, r5);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = (long) r5;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = r4 + r20;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r0 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r20 = r0;
        r0 = r20;
        r1 = r18;
        r0.setAlreadDownloadSize(r1);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r0 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r20 = r0;
        r20 = r20.getSliceChkList();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r20;
        r1 = r28;
        r1.f16067h = r0;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r1 = r18;
        r20 = r0.m20806a(r1);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r21 = -1;
        r0 = r20;
        r1 = r21;
        if (r0 == r1) goto L_0x0650;
    L_0x063f:
        r0 = r28;
        r1 = r20;
        r20 = r0.m20814a(r10, r1);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        if (r20 != 0) goto L_0x0650;
    L_0x0649:
        r4 = 1;
        r5 = r17;
        r6 = r18;
        goto L_0x0561;
    L_0x0650:
        r20 = r8 - r6;
        r26 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r20 = (r20 > r26 ? 1 : (r20 == r26 ? 0 : -1));
        if (r20 >= 0) goto L_0x066c;
    L_0x0658:
        r0 = r28;
        r0 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r20 = r0;
        r20 = r20.getProgress();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r20 = r17 - r20;
        r21 = 10;
        r0 = r20;
        r1 = r21;
        if (r0 < r1) goto L_0x06bf;
    L_0x066c:
        r20 = 0;
        r20 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1));
        if (r20 == 0) goto L_0x068a;
    L_0x0672:
        r6 = r8 - r6;
        r20 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r20;
        r6 = (int) r6;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        if (r6 <= 0) goto L_0x06c7;
    L_0x067b:
        r0 = r28;
        r7 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = (long) r6;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r20 = r0;
        r4 = r4 / r20;
        r4 = (int) r4;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r7.setDownloadRate(r4);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = 0;
    L_0x068a:
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r17;
        r6.setProgress(r0);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r6 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r7 = 2;
        r6.setStatus(r7);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r6 = r0.f16063d;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r7 = r0.f16063d;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r0 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r20 = r0;
        r20 = r20.getStatus();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r0 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r21 = r0;
        r0 = r20;
        r1 = r21;
        r7 = r7.obtainMessage(r0, r1);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r6.sendMessage(r7);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r6 = r8;
    L_0x06bf:
        r20 = r4;
        r8 = r18;
        r4 = r17;
        goto L_0x0519;
    L_0x06c7:
        r6 = 1;
        goto L_0x067b;
    L_0x06c9:
        r4 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1));
        if (r4 == 0) goto L_0x0749;
    L_0x06cd:
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = 5;
        r4.setStatus(r5);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = 1;
        r8 = 7;
        r4.setInterrupt(r5, r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = "DownloadRunnable";
        r5 = new java.lang.StringBuilder;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5.<init>();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = "download error, downloaded size ";
        r5 = r5.append(r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = r5.append(r6);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = ", not equal to actual size ";
        r5 = r5.append(r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r22;
        r5 = r5.append(r0);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = ",";
        r5 = r5.append(r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r8 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = r5.append(r8);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = r5.toString();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20532b(r4, r5);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = "HiSpace";
        r5 = 7;
        r8 = new java.lang.StringBuilder;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8.<init>();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = "FileLengthInvalid:downloaded size=";
        r8 = r8.append(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = r8.append(r6);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = ",actual size=";
        r8 = r8.append(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r22;
        r8 = r8.append(r0);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r8 = r8.toString();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r0 = r28;
        r9 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = r9.getUrl();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r9 = java.net.URI.create(r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        com.huawei.appmarket.sdk.service.p373c.C4302j.m20744a(r4, r5, r8, r9);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        goto L_0x05e2;
    L_0x0743:
        r4 = move-exception;
        r5 = r12;
        r6 = r13;
        r7 = r14;
        goto L_0x039d;
    L_0x0749:
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = r4.getFileSize();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r4 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0764;
    L_0x0755:
        r0 = r28;
        r4 = r0.f16062c;	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        r5 = 2;
        r4.setStatus(r5);	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        goto L_0x05e2;
    L_0x075f:
        r4 = move-exception;
        r5 = r15;
        r8 = r13;
        goto L_0x0437;
    L_0x0764:
        r28.m20818e();	 Catch:{ h -> 0x0743, Exception -> 0x075f, all -> 0x0769 }
        goto L_0x05e2;
    L_0x0769:
        r4 = move-exception;
        r5 = r11;
        r8 = r13;
    L_0x076c:
        r0 = r28;
        r6 = r0.f16062c;
        r7 = 0;
        r6.setHttpGet(r7);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20665a(r10);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r8);
        com.huawei.appmarket.sdk.foundation.p367e.C4282b.m20663a(r5);
        if (r14 == 0) goto L_0x0782;
    L_0x077f:
        r14.m20752c();
    L_0x0782:
        throw r4;
    L_0x0783:
        r6 = move-exception;
        r10 = r4;
        r14 = r9;
        r4 = r6;
        goto L_0x076c;
    L_0x0788:
        r6 = move-exception;
        r10 = r4;
        r4 = r6;
        goto L_0x076c;
    L_0x078c:
        r6 = move-exception;
        r10 = r4;
        r8 = r13;
        r4 = r6;
        goto L_0x076c;
    L_0x0791:
        r4 = move-exception;
        r8 = r13;
        goto L_0x076c;
    L_0x0794:
        r4 = move-exception;
        r5 = r11;
        r8 = r6;
        r14 = r7;
        goto L_0x076c;
    L_0x0799:
        r4 = move-exception;
        r5 = r11;
        goto L_0x076c;
    L_0x079c:
        r6 = move-exception;
        r11 = r5;
        r14 = r9;
        r5 = r10;
        r10 = r4;
        r4 = r6;
        goto L_0x0437;
    L_0x07a4:
        r6 = move-exception;
        r11 = r5;
        r5 = r10;
        r10 = r4;
        r4 = r6;
        goto L_0x0437;
    L_0x07ab:
        r6 = move-exception;
        r10 = r4;
        r11 = r5;
        r4 = r6;
        r5 = r15;
        goto L_0x0437;
    L_0x07b2:
        r4 = move-exception;
        r11 = r5;
        r8 = r13;
        r5 = r15;
        goto L_0x0437;
    L_0x07b8:
        r6 = move-exception;
        r10 = r4;
        r11 = r5;
        r4 = r6;
        r5 = r7;
        r6 = r8;
        r7 = r9;
        goto L_0x039d;
    L_0x07c1:
        r6 = move-exception;
        r10 = r4;
        r11 = r5;
        r4 = r6;
        r5 = r7;
        r6 = r8;
        r7 = r14;
        goto L_0x039d;
    L_0x07ca:
        r6 = move-exception;
        r10 = r4;
        r11 = r5;
        r4 = r6;
        r5 = r7;
        r6 = r8;
        r7 = r14;
        goto L_0x039d;
    L_0x07d3:
        r4 = move-exception;
        r11 = r5;
        r6 = r13;
        r7 = r14;
        r5 = r12;
        goto L_0x039d;
    L_0x07da:
        r5 = r4;
        r6 = r8;
        r4 = r16;
        goto L_0x0561;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appmarket.sdk.service.download.f.d():void");
    }

    private void m20818e() {
        File file = new File(this.f16062c.getFilepath());
        String str = m20820a(this.f16062c.getFilepath()) + this.f16062c.getFilename();
        if (file == null || !file.exists()) {
            this.f16062c.setStatus(5);
            this.f16062c.setInterrupt(true, 8);
            this.f16062c.getDownloadFailedReason().f16040b = "Downloaded file not exist:" + file + "," + this.f16062c.toSmapleString();
            this.f16062c.getDownloadFailedReason().f16039a = HttpStatus.SC_NOT_IMPLEMENTED;
            C4241a.m20532b("DownloadRunnable", "Downloaded file not exist:" + this.f16062c);
            return;
        }
        File file2;
        if (!this.f16062c.isSmartpatch() || "apk".equalsIgnoreCase(C4282b.m20667b(file.getName()))) {
            file2 = file;
        } else {
            this.f16062c.setStatus(7);
            this.f16063d.sendMessage(this.f16063d.obtainMessage(this.f16062c.getStatus(), this.f16062c));
            file2 = new File(file.getAbsolutePath() + ".diff");
            if (m20813a(file2)) {
                str = str + ".apk";
            } else {
                this.f16062c.setStatus(5);
                this.f16062c.setInterrupt(true, 8);
                return;
            }
        }
        this.f16062c.setStatus(4);
        this.f16062c.setInterrupt(true, 4);
        this.f16065f.m20771a(this.f16062c.getPackageName(), file2);
        if (!file2.renameTo(new File(str))) {
            str = file2.getAbsolutePath();
        }
        this.f16062c.setFilepath(str);
        this.f16065f.mo4412b(str);
    }

    private void m20819f() {
        if (this.f16062c.getInterruptReason() == 3) {
            this.f16062c.setStatus(3);
        } else if (this.f16062c.getInterruptReason() == 1 || this.f16062c.getInterruptReason() == 2) {
            this.f16062c.setStatus(6);
        }
    }

    public String m20820a(String str) {
        if (str == null) {
            return null;
        }
        File parentFile = new File(str).getParentFile();
        return parentFile != null ? parentFile.getName().equalsIgnoreCase("tmp") ? parentFile.getParent() + File.separator : parentFile.getAbsolutePath() + File.separator : str;
    }

    public void m20821a(C4308c c4308c) {
        this.f16065f = c4308c;
    }

    public boolean m20822a() {
        boolean z = true;
        boolean z2 = false;
        if (m20823b()) {
            z2 = true;
        } else if (this.f16062c.getStatus() == 8) {
            this.f16060a++;
            int i = this.f16061b.get(this.f16060a);
            if (i == 0 || this.f16066g) {
                String b = C4307a.m20759a().m20765b(C4307a.m20761c(this.f16062c.getUrl()));
                this.f16066g = false;
                if (b == null) {
                    C4241a.m20532b("DownloadRunnable", "has retry " + (this.f16060a - 1) + " num, and retry all ip, termilate download." + this.f16062c);
                    this.f16062c.setStatus(5);
                    this.f16062c.getDownloadFailedReason().f16040b = "Network error," + this.f16062c.toSmapleString();
                    this.f16062c.getDownloadFailedReason().f16039a = HttpStatus.SC_BAD_REQUEST;
                    this.f16063d.sendMessage(this.f16063d.obtainMessage(this.f16062c.getStatus(), this.f16062c));
                } else {
                    this.f16060a = 0;
                    this.f16061b = C4307a.m20759a().m20763a(C4307a.m20761c(this.f16062c.getUrl()));
                    this.f16062c.setUrl(C4307a.m20760a(this.f16062c.getUrl(), b));
                    C4241a.m20529a("DownloadRunnable", "change ip and retry download:" + this.f16062c);
                    z = false;
                }
                z2 = z;
            } else {
                this.f16062c.setDownloadRate(0);
                this.f16063d.sendMessage(this.f16063d.obtainMessage(2, this.f16062c));
                try {
                    if (m20823b()) {
                        return true;
                    }
                    synchronized (this.f16062c) {
                        this.f16062c.wait((long) i);
                    }
                    if (m20823b()) {
                        return true;
                    }
                    C4241a.m20529a("DownloadRunnable", this.f16060a + " num retry with taskid:" + this.f16062c.getId());
                } catch (InterruptedException e) {
                }
            }
        }
        return z2;
    }

    protected boolean m20823b() {
        if (!this.f16062c.isInterrupt()) {
            return false;
        }
        this.f16062c.getDownloadQuality().f16044b = System.currentTimeMillis();
        m20819f();
        this.f16063d.sendMessage(this.f16063d.obtainMessage(this.f16062c.getStatus(), this.f16062c));
        C4241a.m20529a("DownloadRunnable", "checkInterrupt:" + this.f16062c);
        return true;
    }

    public void run() {
        this.f16062c.setStatus(1);
        this.f16063d.sendMessage(this.f16063d.obtainMessage(this.f16062c.getStatus(), this.f16062c));
        C4241a.m20529a("DownloadRunnable", "start download Task:" + this.f16062c);
        this.f16061b = C4307a.m20759a().m20763a(C4307a.m20761c(this.f16062c.getUrl()));
        do {
            ConnectivityManager c = C4292a.m20708a().m20710c();
            if (c != null) {
                NetworkInfo activeNetworkInfo = c.getActiveNetworkInfo();
                this.f16062c.getDownloadQuality().m20788a(activeNetworkInfo);
                this.f16062c.addStatisticsParam(activeNetworkInfo);
            }
            m20817d();
        } while (!m20822a());
        if (this.f16062c.getStatus() == 5 || this.f16062c.getStatus() == 3) {
            this.f16062c.deleteDownloadFile();
        }
    }
}
