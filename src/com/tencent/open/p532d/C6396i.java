package com.tencent.open.p532d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.connect.p193b.C6284w;
import com.tencent.connect.p531a.C6244a;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6286a;
import com.unionpay.tsmservice.data.Constant;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyStore;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: ProGuard */
public class C6396i {
    private static final String f22229a = C6396i.class.getName();

    private C6396i() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject m29196a(com.tencent.connect.p193b.C6284w r20, android.content.Context r21, java.lang.String r22, android.os.Bundle r23, java.lang.String r24) throws java.io.IOException, org.json.JSONException, com.tencent.open.p532d.C6402o, com.tencent.open.p532d.C6399l {
        /*
        r4 = "openSDK_LOG";
        r5 = "OpenApi request";
        com.tencent.open.p541a.C6367n.m29104a(r4, r5);
        r4 = r22.toLowerCase();
        r5 = "http";
        r4 = r4.startsWith(r5);
        if (r4 != 0) goto L_0x01c1;
    L_0x0013:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.open.p532d.C6405r.m29214a();
        r6 = "https://openmobile.qq.com/";
        r0 = r21;
        r5 = r5.m29215a(r0, r6);
        r4 = r4.append(r5);
        r0 = r22;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = com.tencent.open.p532d.C6405r.m29214a();
        r7 = "https://openmobile.qq.com/";
        r0 = r21;
        r6 = r6.m29215a(r0, r7);
        r5 = r5.append(r6);
        r0 = r22;
        r5 = r5.append(r0);
        r5 = r5.toString();
    L_0x0051:
        r0 = r21;
        r1 = r20;
        r2 = r22;
        com.tencent.open.p532d.C6396i.m29197a(r0, r1, r2);
        r10 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();
        r7 = 0;
        r6 = r20.m28849b();
        r0 = r21;
        r6 = com.tencent.open.p532d.C6403p.m29203a(r0, r6);
        r11 = "Common_HttpRetryCount";
        r6 = r6.m29212a(r11);
        r11 = "OpenConfig_test";
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = "config 1:Common_HttpRetryCount            config_value:";
        r12 = r12.append(r13);
        r12 = r12.append(r6);
        r13 = "   appid:";
        r12 = r12.append(r13);
        r13 = r20.m28849b();
        r12 = r12.append(r13);
        r13 = "     url:";
        r12 = r12.append(r13);
        r12 = r12.append(r5);
        r12 = r12.toString();
        com.tencent.open.p541a.C6367n.m29107b(r11, r12);
        if (r6 != 0) goto L_0x00ff;
    L_0x00a2:
        r6 = 3;
        r13 = r6;
    L_0x00a4:
        r6 = "OpenConfig_test";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "config 1:Common_HttpRetryCount            result_value:";
        r11 = r11.append(r12);
        r11 = r11.append(r13);
        r12 = "   appid:";
        r11 = r11.append(r12);
        r12 = r20.m28849b();
        r11 = r11.append(r12);
        r12 = "     url:";
        r11 = r11.append(r12);
        r11 = r11.append(r5);
        r11 = r11.toString();
        com.tencent.open.p541a.C6367n.m29107b(r6, r11);
        r18 = r7;
        r6 = r8;
        r8 = r18;
        r9 = r10;
    L_0x00da:
        r14 = r8 + 1;
        r0 = r21;
        r1 = r24;
        r2 = r23;
        r10 = com.tencent.open.p532d.C6396i.m29190a(r0, r4, r1, r2);	 Catch:{ ConnectTimeoutException -> 0x01b7, SocketTimeoutException -> 0x01b1, l -> 0x014b, o -> 0x0173, MalformedURLException -> 0x0178, IOException -> 0x018a, JSONException -> 0x019f }
        r8 = r10.f22213a;	 Catch:{ ConnectTimeoutException -> 0x01b7, SocketTimeoutException -> 0x01b1, l -> 0x014b, o -> 0x0173, MalformedURLException -> 0x0178, IOException -> 0x018a, JSONException -> 0x019f }
        r15 = com.tencent.open.p532d.C6412y.m29260d(r8);	 Catch:{ ConnectTimeoutException -> 0x01b7, SocketTimeoutException -> 0x01b1, l -> 0x014b, o -> 0x0173, MalformedURLException -> 0x0178, IOException -> 0x018a, JSONException -> 0x019f }
        r8 = "ret";
        r12 = r15.getInt(r8);	 Catch:{ JSONException -> 0x0101, ConnectTimeoutException -> 0x0104, SocketTimeoutException -> 0x012a, l -> 0x014b, o -> 0x0173, MalformedURLException -> 0x0178, IOException -> 0x018a }
    L_0x00f2:
        r8 = r10.f22214b;	 Catch:{ ConnectTimeoutException -> 0x0104, SocketTimeoutException -> 0x012a, l -> 0x014b, o -> 0x0173, MalformedURLException -> 0x0178, IOException -> 0x018a, JSONException -> 0x019f }
        r10 = r10.f22215c;	 Catch:{ ConnectTimeoutException -> 0x0104, SocketTimeoutException -> 0x012a, l -> 0x014b, o -> 0x0173, MalformedURLException -> 0x0178, IOException -> 0x018a, JSONException -> 0x019f }
        r13 = r15;
    L_0x00f7:
        r4 = com.tencent.open.p542b.C6378g.m29155a();
        r4.m29158a(r5, r6, r8, r10, r12);
        return r13;
    L_0x00ff:
        r13 = r6;
        goto L_0x00a4;
    L_0x0101:
        r8 = move-exception;
        r12 = -4;
        goto L_0x00f2;
    L_0x0104:
        r8 = move-exception;
        r16 = r15;
        r15 = r8;
    L_0x0108:
        r15.printStackTrace();
        r12 = -7;
        r8 = 0;
        r10 = 0;
        if (r14 >= r13) goto L_0x0122;
    L_0x0112:
        r6 = android.os.SystemClock.elapsedRealtime();
        r18 = r8;
        r8 = r16;
        r16 = r18;
    L_0x011c:
        if (r14 < r13) goto L_0x01bd;
    L_0x011e:
        r13 = r8;
        r8 = r16;
        goto L_0x00f7;
    L_0x0122:
        r4 = com.tencent.open.p542b.C6378g.m29155a();
        r4.m29158a(r5, r6, r8, r10, r12);
        throw r15;
    L_0x012a:
        r8 = move-exception;
        r16 = r15;
        r15 = r8;
    L_0x012e:
        r15.printStackTrace();
        r12 = -8;
        r8 = 0;
        r10 = 0;
        if (r14 >= r13) goto L_0x0143;
    L_0x0138:
        r6 = android.os.SystemClock.elapsedRealtime();
        r18 = r8;
        r8 = r16;
        r16 = r18;
        goto L_0x011c;
    L_0x0143:
        r4 = com.tencent.open.p542b.C6378g.m29155a();
        r4.m29158a(r5, r6, r8, r10, r12);
        throw r15;
    L_0x014b:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r4 = r13.getMessage();
        r8 = "http status code error:";
        r9 = "";
        r4 = r4.replace(r8, r9);	 Catch:{ Exception -> 0x016c }
        r12 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x016c }
    L_0x0160:
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.p542b.C6378g.m29155a();
        r4.m29158a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x016c:
        r4 = move-exception;
        r4.printStackTrace();
        r12 = -9;
        goto L_0x0160;
    L_0x0173:
        r4 = move-exception;
        r4.printStackTrace();
        throw r4;
    L_0x0178:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r12 = -3;
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.p542b.C6378g.m29155a();
        r4.m29158a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x018a:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r12 = com.tencent.open.p532d.C6396i.m29189a(r13);
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.p542b.C6378g.m29155a();
        r4.m29158a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x019f:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r12 = -4;
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.p542b.C6378g.m29155a();
        r4.m29158a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x01b1:
        r8 = move-exception;
        r15 = r8;
        r16 = r9;
        goto L_0x012e;
    L_0x01b7:
        r8 = move-exception;
        r15 = r8;
        r16 = r9;
        goto L_0x0108;
    L_0x01bd:
        r9 = r8;
        r8 = r14;
        goto L_0x00da;
    L_0x01c1:
        r5 = r22;
        r4 = r22;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.d.i.a(com.tencent.connect.b.w, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void m29198a(C6284w c6284w, Context context, String str, Bundle bundle, String str2, C6286a c6286a) {
        C6367n.m29104a("openSDK_LOG", "OpenApi requestAsync");
        new C6397j(c6284w, context, str, bundle, str2, c6286a).start();
    }

    private static void m29197a(Context context, C6284w c6284w, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            C6244a.m28698a(context, c6284w, "requireApi", str);
        }
    }

    public static int m29189a(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        if (iOException instanceof ZipException) {
            return -54;
        }
        return -2;
    }

    public static aa m29190a(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, C6402o, C6399l {
        Bundle bundle2;
        HttpUriRequest httpUriRequest;
        int i;
        int size;
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    throw new C6402o("network unavailable");
                }
            }
        }
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        String str3 = "";
        str3 = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        HttpClient a = C6396i.m29195a(context, str3, str);
        int length;
        if (str2.equals(HttpGet.METHOD_NAME)) {
            String a2 = C6396i.m29192a(bundle2);
            length = 0 + a2.length();
            C6367n.m29107b(f22229a, "-->openUrl2 before url =" + str);
            if (str.indexOf(LocationInfo.NA) == -1) {
                str3 = str + LocationInfo.NA;
            } else {
                str3 = str + SNBConstant.FILTER;
            }
            C6367n.m29107b(f22229a, "-->openUrl2 encodedParam =" + a2 + " -- url = " + str3);
            HttpUriRequest httpGet = new HttpGet(str3 + a2);
            httpGet.addHeader("Accept-Encoding", "gzip");
            int i2 = length;
            httpUriRequest = httpGet;
            i = i2;
        } else if (str2.equals(HttpPost.METHOD_NAME)) {
            Object obj;
            HttpPost httpPost = new HttpPost(str);
            httpPost.addHeader("Accept-Encoding", "gzip");
            Bundle bundle3 = new Bundle();
            for (String str32 : bundle2.keySet()) {
                obj = bundle2.get(str32);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str32, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey(Constant.KEY_METHOD)) {
                bundle2.putString(Constant.KEY_METHOD, str2);
            }
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpPost.setHeader("Connection", "Keep-Alive");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(C6412y.m29269k("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(C6412y.m29269k(C6396i.m29193a(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                size = bundle3.size();
                byteArrayOutputStream.write(C6412y.m29269k("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                length = -1;
                for (String str322 : bundle3.keySet()) {
                    length++;
                    byteArrayOutputStream.write(C6412y.m29269k("Content-Disposition: form-data; name=\"" + str322 + "\"; filename=\"" + str322 + "\"" + "\r\n"));
                    byteArrayOutputStream.write(C6412y.m29269k("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str322);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (length < size - 1) {
                        byteArrayOutputStream.write(C6412y.m29269k("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(C6412y.m29269k("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            i = toByteArray.length + 0;
            byteArrayOutputStream.close();
            httpPost.setEntity(new ByteArrayEntity(toByteArray));
            obj = httpPost;
        } else {
            httpUriRequest = null;
            i = 0;
        }
        HttpResponse execute = a.execute(httpUriRequest);
        size = execute.getStatusLine().getStatusCode();
        if (size == 200) {
            return new aa(C6396i.m29194a(execute), i);
        }
        throw new C6399l("http status code error:" + size);
    }

    private static String m29194a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream inputStream;
        String str = "";
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") <= -1) {
            inputStream = content;
        } else {
            inputStream = new GZIPInputStream(content);
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return new String(byteArrayOutputStream.toByteArray(), GameManager.DEFAULT_CHARSET);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static HttpClient m29195a(Context context, String str, String str2) {
        C6403p a;
        int a2;
        int i = 0;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (VERSION.SDK_INT < 16) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                SocketFactory c6398k = new C6398k(instance);
                c6398k.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", c6398k, 443));
            } catch (Exception e) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        HttpParams basicHttpParams = new BasicHttpParams();
        if (context != null) {
            a = C6403p.m29203a(context, str);
        } else {
            a = null;
        }
        if (a != null) {
            a2 = a.m29212a("Common_HttpConnectionTimeout");
            i = a.m29212a("Common_SocketConnectionTimeout");
        } else {
            a2 = 0;
        }
        if (a2 == 0) {
            a2 = 15000;
        }
        if (i == 0) {
            i = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, a2);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, GameManager.DEFAULT_CHARSET);
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + VERSION.SDK + HwAccountConstants.SPLIIT_UNDERLINE + Build.DEVICE + HwAccountConstants.SPLIIT_UNDERLINE + VERSION.RELEASE);
        HttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        C6401n a3 = C6396i.m29191a(context);
        if (a3 != null) {
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(a3.f22238a, a3.f22239b));
        }
        return defaultHttpClient;
    }

    public static String m29192a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            Object obj2 = bundle.get(str);
            if ((obj2 instanceof String) || (obj2 instanceof String[])) {
                Object obj3;
                if (obj2 instanceof String[]) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(SNBConstant.FILTER);
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                stringBuilder.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                stringBuilder.append(URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                        obj3 = obj;
                    }
                } else {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(SNBConstant.FILTER);
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                    obj3 = obj;
                }
                obj = obj3;
            }
        }
        return stringBuilder.toString();
    }

    public static String m29193a(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String str2 : bundle.keySet()) {
            int i2 = i + 1;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"" + "\r\n" + "\r\n" + ((String) obj));
                if (i2 < size - 1) {
                    stringBuilder.append("\r\n--" + str + "\r\n");
                }
                i = i2;
            } else {
                i = i2;
            }
        }
        return stringBuilder.toString();
    }

    public static C6401n m29191a(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 0) {
            Object c = C6396i.m29200c(context);
            int b = C6396i.m29199b(context);
            if (!TextUtils.isEmpty(c) && b >= 0) {
                return new C6401n(c, b);
            }
        }
        return null;
    }

    private static int m29199b(Context context) {
        int i = -1;
        if (VERSION.SDK_INT >= 11) {
            Object property = System.getProperty("http.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return i;
            }
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException e) {
                return i;
            }
        } else if (context == null) {
            return Proxy.getDefaultPort();
        } else {
            i = Proxy.getPort(context);
            if (i < 0) {
                return Proxy.getDefaultPort();
            }
            return i;
        }
    }

    private static String m29200c(Context context) {
        if (VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        if (context == null) {
            return Proxy.getDefaultHost();
        }
        String host = Proxy.getHost(context);
        if (TextUtils.isEmpty(host)) {
            return Proxy.getDefaultHost();
        }
        return host;
    }
}
