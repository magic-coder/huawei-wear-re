package com.amap.api.mapcore.util;

import android.os.Build.VERSION;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: HttpUrlUtil */
public class dm {
    private static dn f11724a;
    private int f11725b;
    private int f11726c;
    private boolean f11727d;
    private SSLContext f11728e;
    private Proxy f11729f;
    private volatile boolean f11730g;
    private long f11731h;
    private long f11732i;
    private HostnameVerifier f11733j;

    public static void m16068a(dn dnVar) {
        f11724a = dnVar;
    }

    dm(int i, int i2, Proxy proxy, boolean z) {
        this.f11730g = false;
        this.f11731h = -1;
        this.f11732i = 0;
        this.f11733j = new ds(this);
        this.f11725b = i;
        this.f11726c = i2;
        this.f11729f = proxy;
        this.f11727d = z;
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
                instance.init(null, null, null);
                this.f11728e = instance;
            } catch (Throwable e) {
                cd.m15825a(e, "HttpUrlUtil", "HttpUrlUtil");
            } catch (Throwable e2) {
                cd.m15825a(e2, "HttpUtil", "HttpUtil");
            }
        }
    }

    dm(int i, int i2, Proxy proxy) {
        this(i, i2, proxy, false);
    }

    void m16073a() {
        this.f11730g = true;
    }

    void m16074a(long j) {
        this.f11732i = j;
    }

    void m16076b(long j) {
        this.f11731h = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m16075a(java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, com.amap.api.mapcore.util.dl.C3272a r14) {
        /*
        r10 = this;
        r1 = 0;
        r0 = 1;
        r8 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = 0;
        r2 = 0;
        r4 = 0;
        if (r14 != 0) goto L_0x0014;
    L_0x0009:
        if (r1 == 0) goto L_0x000e;
    L_0x000b:
        r2.close();	 Catch:{ IOException -> 0x01c8, Throwable -> 0x01d5 }
    L_0x000e:
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        r4.disconnect();	 Catch:{ Throwable -> 0x01e2 }
    L_0x0013:
        return;
    L_0x0014:
        r2 = m16067a(r13);	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
        r4 = new java.lang.StringBuffer;	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
        r4.<init>();	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
        r4.append(r11);	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
        if (r2 == 0) goto L_0x002b;
    L_0x0022:
        r5 = "?";
        r5 = r4.append(r5);	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
        r5.append(r2);	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
    L_0x002b:
        r2 = r4.toString();	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
        r4 = 0;
        r2 = r10.m16072a(r2, r12, r4);	 Catch:{ ConnectException -> 0x02fd, MalformedURLException -> 0x02f9, UnknownHostException -> 0x02f5, SocketException -> 0x014f, SocketTimeoutException -> 0x016a, IOException -> 0x0185, Throwable -> 0x01a0, all -> 0x01bb }
        r4 = new java.lang.StringBuilder;	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4.<init>();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r5 = "bytes=";
        r4 = r4.append(r5);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r6 = r10.f11732i;	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = r4.append(r6);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r5 = "-";
        r4 = r4.append(r5);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = r4.toString();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r5 = "RANGE";
        r2.setRequestProperty(r5, r4);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r2.connect();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r5 = r2.getResponseCode();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r4) goto L_0x00ea;
    L_0x005f:
        r4 = r0;
    L_0x0060:
        r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r5 == r6) goto L_0x00ed;
    L_0x0064:
        r0 = r0 & r4;
        if (r0 == 0) goto L_0x0091;
    L_0x0067:
        r0 = new com.amap.api.mapcore.util.bl;	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r3.<init>();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = "网络异常原因：";
        r3 = r3.append(r4);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = r2.getResponseMessage();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r3 = r3.append(r4);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = " 网络异常状态码：";
        r3 = r3.append(r4);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r3 = r3.append(r5);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r3 = r3.toString();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r0.<init>(r3);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r14.mo3996a(r0);	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
    L_0x0091:
        r1 = r2.getInputStream();	 Catch:{ ConnectException -> 0x0301, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
    L_0x0099:
        r3 = java.lang.Thread.interrupted();	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        if (r3 != 0) goto L_0x0116;
    L_0x009f:
        r3 = r10.f11730g;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        if (r3 != 0) goto L_0x0116;
    L_0x00a3:
        r3 = 0;
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = r1.read(r0, r3, r4);	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        if (r3 <= 0) goto L_0x0116;
    L_0x00ac:
        r4 = r10.f11731h;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r6 = -1;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x00bc;
    L_0x00b4:
        r4 = r10.f11732i;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r6 = r10.f11731h;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0116;
    L_0x00bc:
        if (r3 != r8) goto L_0x00f0;
    L_0x00be:
        r4 = r10.f11732i;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r14.mo3997a(r0, r4);	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
    L_0x00c3:
        r4 = r10.f11732i;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r6 = (long) r3;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r4 = r4 + r6;
        r10.f11732i = r4;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        goto L_0x0099;
    L_0x00ca:
        r0 = move-exception;
        r9 = r2;
        r2 = r1;
        r1 = r9;
    L_0x00ce:
        r14.mo3996a(r0);	 Catch:{ all -> 0x02e3 }
        if (r2 == 0) goto L_0x00d6;
    L_0x00d3:
        r2.close();	 Catch:{ IOException -> 0x0210, Throwable -> 0x021d }
    L_0x00d6:
        if (r1 == 0) goto L_0x0013;
    L_0x00d8:
        r1.disconnect();	 Catch:{ Throwable -> 0x00dd }
        goto L_0x0013;
    L_0x00dd:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
    L_0x00e5:
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r2);
        goto L_0x0013;
    L_0x00ea:
        r4 = r3;
        goto L_0x0060;
    L_0x00ed:
        r0 = r3;
        goto L_0x0064;
    L_0x00f0:
        r4 = new byte[r3];	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r5 = 0;
        r6 = 0;
        java.lang.System.arraycopy(r0, r5, r4, r6, r3);	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r6 = r10.f11732i;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        r14.mo3997a(r4, r6);	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        goto L_0x00c3;
    L_0x00fd:
        r0 = move-exception;
    L_0x00fe:
        r14.mo3996a(r0);	 Catch:{ all -> 0x02e0 }
        if (r1 == 0) goto L_0x0106;
    L_0x0103:
        r1.close();	 Catch:{ IOException -> 0x022a, Throwable -> 0x0237 }
    L_0x0106:
        if (r2 == 0) goto L_0x0013;
    L_0x0108:
        r2.disconnect();	 Catch:{ Throwable -> 0x010d }
        goto L_0x0013;
    L_0x010d:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x0116:
        r0 = r10.f11730g;	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        if (r0 == 0) goto L_0x0132;
    L_0x011a:
        r14.mo3998d();	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
    L_0x011d:
        if (r1 == 0) goto L_0x0122;
    L_0x011f:
        r1.close();	 Catch:{ IOException -> 0x02c6, Throwable -> 0x02d3 }
    L_0x0122:
        if (r2 == 0) goto L_0x0013;
    L_0x0124:
        r2.disconnect();	 Catch:{ Throwable -> 0x0129 }
        goto L_0x0013;
    L_0x0129:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x0132:
        r14.mo3999e();	 Catch:{ ConnectException -> 0x00ca, MalformedURLException -> 0x00fd, UnknownHostException -> 0x0136, SocketException -> 0x02f2, SocketTimeoutException -> 0x02ef, IOException -> 0x02ec, Throwable -> 0x02e9 }
        goto L_0x011d;
    L_0x0136:
        r0 = move-exception;
    L_0x0137:
        r14.mo3996a(r0);	 Catch:{ all -> 0x02e0 }
        if (r1 == 0) goto L_0x013f;
    L_0x013c:
        r1.close();	 Catch:{ IOException -> 0x0244, Throwable -> 0x0251 }
    L_0x013f:
        if (r2 == 0) goto L_0x0013;
    L_0x0141:
        r2.disconnect();	 Catch:{ Throwable -> 0x0146 }
        goto L_0x0013;
    L_0x0146:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x014f:
        r0 = move-exception;
        r2 = r1;
    L_0x0151:
        r14.mo3996a(r0);	 Catch:{ all -> 0x02e0 }
        if (r1 == 0) goto L_0x0159;
    L_0x0156:
        r1.close();	 Catch:{ IOException -> 0x025e, Throwable -> 0x026b }
    L_0x0159:
        if (r2 == 0) goto L_0x0013;
    L_0x015b:
        r2.disconnect();	 Catch:{ Throwable -> 0x0160 }
        goto L_0x0013;
    L_0x0160:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x016a:
        r0 = move-exception;
        r2 = r1;
    L_0x016c:
        r14.mo3996a(r0);	 Catch:{ all -> 0x02e0 }
        if (r1 == 0) goto L_0x0174;
    L_0x0171:
        r1.close();	 Catch:{ IOException -> 0x0278, Throwable -> 0x0285 }
    L_0x0174:
        if (r2 == 0) goto L_0x0013;
    L_0x0176:
        r2.disconnect();	 Catch:{ Throwable -> 0x017b }
        goto L_0x0013;
    L_0x017b:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x0185:
        r0 = move-exception;
        r2 = r1;
    L_0x0187:
        r14.mo3996a(r0);	 Catch:{ all -> 0x02e0 }
        if (r1 == 0) goto L_0x018f;
    L_0x018c:
        r1.close();	 Catch:{ IOException -> 0x0292, Throwable -> 0x029f }
    L_0x018f:
        if (r2 == 0) goto L_0x0013;
    L_0x0191:
        r2.disconnect();	 Catch:{ Throwable -> 0x0196 }
        goto L_0x0013;
    L_0x0196:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x01a0:
        r0 = move-exception;
        r2 = r1;
    L_0x01a2:
        r14.mo3996a(r0);	 Catch:{ all -> 0x02e0 }
        if (r1 == 0) goto L_0x01aa;
    L_0x01a7:
        r1.close();	 Catch:{ IOException -> 0x02ac, Throwable -> 0x02b9 }
    L_0x01aa:
        if (r2 == 0) goto L_0x0013;
    L_0x01ac:
        r2.disconnect();	 Catch:{ Throwable -> 0x01b1 }
        goto L_0x0013;
    L_0x01b1:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x01bb:
        r0 = move-exception;
        r2 = r1;
    L_0x01bd:
        if (r1 == 0) goto L_0x01c2;
    L_0x01bf:
        r1.close();	 Catch:{ IOException -> 0x01ec, Throwable -> 0x01f8 }
    L_0x01c2:
        if (r2 == 0) goto L_0x01c7;
    L_0x01c4:
        r2.disconnect();	 Catch:{ Throwable -> 0x0204 }
    L_0x01c7:
        throw r0;
    L_0x01c8:
        r0 = move-exception;
        r0.printStackTrace();
        r2 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);
        goto L_0x000e;
    L_0x01d5:
        r0 = move-exception;
        r0.printStackTrace();
        r2 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);
        goto L_0x000e;
    L_0x01e2:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r2 = "makeDownloadGetRequest";
        goto L_0x00e5;
    L_0x01ec:
        r1 = move-exception;
        r1.printStackTrace();
        r3 = "HttpUrlUtil";
        r4 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r1, r3, r4);
        goto L_0x01c2;
    L_0x01f8:
        r1 = move-exception;
        r1.printStackTrace();
        r3 = "HttpUrlUtil";
        r4 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r1, r3, r4);
        goto L_0x01c2;
    L_0x0204:
        r1 = move-exception;
        r1.printStackTrace();
        r2 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r1, r2, r3);
        goto L_0x01c7;
    L_0x0210:
        r0 = move-exception;
        r0.printStackTrace();
        r2 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);
        goto L_0x00d6;
    L_0x021d:
        r0 = move-exception;
        r0.printStackTrace();
        r2 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r2, r3);
        goto L_0x00d6;
    L_0x022a:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0106;
    L_0x0237:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0106;
    L_0x0244:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x013f;
    L_0x0251:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x013f;
    L_0x025e:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0159;
    L_0x026b:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0159;
    L_0x0278:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0174;
    L_0x0285:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0174;
    L_0x0292:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x018f;
    L_0x029f:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x018f;
    L_0x02ac:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x01aa;
    L_0x02b9:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x01aa;
    L_0x02c6:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0122;
    L_0x02d3:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "HttpUrlUtil";
        r3 = "makeDownloadGetRequest";
        com.amap.api.mapcore.util.cd.m15825a(r0, r1, r3);
        goto L_0x0122;
    L_0x02e0:
        r0 = move-exception;
        goto L_0x01bd;
    L_0x02e3:
        r0 = move-exception;
        r9 = r1;
        r1 = r2;
        r2 = r9;
        goto L_0x01bd;
    L_0x02e9:
        r0 = move-exception;
        goto L_0x01a2;
    L_0x02ec:
        r0 = move-exception;
        goto L_0x0187;
    L_0x02ef:
        r0 = move-exception;
        goto L_0x016c;
    L_0x02f2:
        r0 = move-exception;
        goto L_0x0151;
    L_0x02f5:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0137;
    L_0x02f9:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00fe;
    L_0x02fd:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00ce;
    L_0x0301:
        r0 = move-exception;
        r9 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x00ce;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dm.a(java.lang.String, java.util.Map, java.util.Map, com.amap.api.mapcore.util.dl$a):void");
    }

    dr m16070a(String str, Map<String, String> map, Map<String, String> map2) throws bl {
        try {
            String a = m16067a((Map) map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a != null) {
                stringBuffer.append(LocationInfo.NA).append(a);
            }
            HttpURLConnection a2 = m16072a(stringBuffer.toString(), (Map) map, false);
            a2.connect();
            return m16066a(a2);
        } catch (ConnectException e) {
            throw new bl("http连接失败 - ConnectionException");
        } catch (MalformedURLException e2) {
            throw new bl("url异常 - MalformedURLException");
        } catch (UnknownHostException e3) {
            throw new bl("未知主机 - UnKnowHostException");
        } catch (SocketException e4) {
            throw new bl("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e5) {
            throw new bl("socket 连接超时 - SocketTimeoutException");
        } catch (IOException e6) {
            throw new bl("IO 操作异常 - IOException");
        } catch (Throwable th) {
            th.printStackTrace();
            bl blVar = new bl("未知的错误");
        }
    }

    dr m16071a(String str, Map<String, String> map, byte[] bArr) throws bl {
        try {
            HttpURLConnection a = m16072a(str, (Map) map, true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            a.connect();
            return m16066a(a);
        } catch (ConnectException e) {
            e.printStackTrace();
            throw new bl("http连接失败 - ConnectionException");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            throw new bl("url异常 - MalformedURLException");
        } catch (UnknownHostException e3) {
            e3.printStackTrace();
            throw new bl("未知主机 - UnKnowHostException");
        } catch (SocketException e4) {
            e4.printStackTrace();
            throw new bl("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e5) {
            e5.printStackTrace();
            throw new bl("socket 连接超时 - SocketTimeoutException");
        } catch (IOException e6) {
            e6.printStackTrace();
            throw new bl("IO 操作异常 - IOException");
        } catch (Throwable th) {
            cd.m15825a(th, "HttpUrlUtil", "makePostReqeust");
            bl blVar = new bl("未知的错误");
        }
    }

    HttpURLConnection m16072a(String str, Map<String, String> map, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        bq.m15721a();
        URL url = new URL(str);
        if (this.f11729f != null) {
            URLConnection openConnection = url.openConnection(this.f11729f);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.f11727d) {
            httpURLConnection = (HttpsURLConnection) openConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f11728e.getSocketFactory());
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.f11733j);
        } else {
            httpURLConnection = (HttpURLConnection) openConnection;
        }
        if (VERSION.SDK != null && VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        m16069a(map, httpURLConnection);
        if (z) {
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    private dr m16066a(HttpURLConnection httpURLConnection) throws bl, IOException {
        InputStream inputStream;
        InputStream pushbackInputStream;
        IOException e;
        Throwable th;
        InputStream inputStream2;
        PushbackInputStream pushbackInputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            Map headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new bl("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode);
            }
            byte[] bArr;
            InputStream gZIPInputStream;
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    pushbackInputStream = new PushbackInputStream(inputStream, 2);
                } catch (IOException e2) {
                    e = e2;
                    pushbackInputStream = null;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    pushbackInputStream = null;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e3) {
                            cd.m15825a(e3, "HttpUrlUtil", "parseResult");
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e4) {
                            cd.m15825a(e4, "HttpUrlUtil", "parseResult");
                            e4.printStackTrace();
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable e5) {
                            cd.m15825a(e5, "HttpUrlUtil", "parseResult");
                            e5.printStackTrace();
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable e52) {
                            cd.m15825a(e52, "HttpUrlUtil", "parseResult");
                            e52.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable e522) {
                            cd.m15825a(e522, "HttpUrlUtil", "parseResult");
                            e522.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                pushbackInputStream = null;
                inputStream = null;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                pushbackInputStream = null;
                inputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                bArr = new byte[2];
                pushbackInputStream.read(bArr);
                pushbackInputStream.unread(bArr);
                if (bArr[0] == TagName.TRADE_STATUS && bArr[1] == TagName.PAY_CHANNEL_MIN) {
                    gZIPInputStream = new GZIPInputStream(pushbackInputStream);
                } else {
                    gZIPInputStream = pushbackInputStream;
                }
            } catch (IOException e7) {
                e = e7;
                inputStream2 = pushbackInputStream;
                pushbackInputStream = null;
                gZIPInputStream = inputStream2;
                throw e;
            } catch (Throwable th5) {
                th = th5;
                inputStream2 = pushbackInputStream;
                pushbackInputStream = null;
                gZIPInputStream = inputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (f11724a != null) {
                    f11724a.mo4017a();
                }
                dr drVar = new dr();
                drVar.f11741a = byteArrayOutputStream.toByteArray();
                drVar.f11742b = headerFields;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e32) {
                        cd.m15825a(e32, "HttpUrlUtil", "parseResult");
                        e32.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e42) {
                        cd.m15825a(e42, "HttpUrlUtil", "parseResult");
                        e42.printStackTrace();
                    }
                }
                if (pushbackInputStream != null) {
                    try {
                        pushbackInputStream.close();
                    } catch (Throwable e8) {
                        cd.m15825a(e8, "HttpUrlUtil", "parseResult");
                        e8.printStackTrace();
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable e5222) {
                        cd.m15825a(e5222, "HttpUrlUtil", "parseResult");
                        e5222.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e52222) {
                        cd.m15825a(e52222, "HttpUrlUtil", "parseResult");
                        e52222.printStackTrace();
                    }
                }
                return drVar;
            } catch (IOException e9) {
                e = e9;
                inputStream2 = pushbackInputStream;
                pushbackInputStream = gZIPInputStream;
                gZIPInputStream = inputStream2;
                throw e;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = pushbackInputStream;
                pushbackInputStream = gZIPInputStream;
                gZIPInputStream = inputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            pushbackInputStream = null;
            inputStream = null;
            byteArrayOutputStream = null;
            throw e;
        } catch (Throwable th7) {
            th = th7;
            pushbackInputStream = null;
            inputStream = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (pushbackInputStream2 != null) {
                pushbackInputStream2.close();
            }
            if (pushbackInputStream != null) {
                pushbackInputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private void m16069a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
        } catch (Throwable th) {
            cd.m15825a(th, "HttpUrlUtil", "addHeaders");
        }
        httpURLConnection.setConnectTimeout(this.f11725b);
        httpURLConnection.setReadTimeout(this.f11726c);
    }

    static String m16067a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 == null) {
                str2 = "";
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(SNBConstant.FILTER);
            }
            stringBuilder.append(URLEncoder.encode(str));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(str2));
        }
        return stringBuilder.toString();
    }
}
