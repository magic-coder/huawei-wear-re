package com.huawei.multisimsdk.multidevicemanager.p105e;

import android.os.Build.VERSION;
import com.huawei.multisimsdk.multidevicemanager.p104c.C1134a;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: HttpConnectionUtils */
public class C1180e {
    private static C1180e f2596a;

    public static synchronized C1180e m5274a() {
        C1180e c1180e;
        synchronized (C1180e.class) {
            if (f2596a == null) {
                f2596a = new C1180e();
            }
            c1180e = f2596a;
        }
        return c1180e;
    }

    public String m5277a(String str, String str2) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance;
        HttpURLConnection httpURLConnection;
        String str3;
        int responseCode;
        String a;
        String valueOf;
        Closeable closeable = null;
        try {
            URL url = new URL(str);
            try {
                instance = SSLContext.getInstance(SSLSocketFactory.TLS);
                try {
                    instance.init(null, new TrustManager[]{new C1181f(this)}, null);
                } catch (NoSuchAlgorithmException e) {
                    C1183h.m5286d("HttpConnectionUtils", "doPostRequest->NoSuchAlgorithmException");
                    if (VERSION.SDK_INT < 21) {
                        HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
                    } else {
                        HttpsURLConnection.setDefaultSSLSocketFactory(new C1184j(instance.getSocketFactory()));
                    }
                    HttpsURLConnection.setDefaultHostnameVerifier(new C1182g(this));
                    if (C1183h.f2599a.booleanValue()) {
                        C1183h.m5280a("HttpConnectionUtils", "doPostRequest->url=%s, urlParameters=%s", url, str2);
                    }
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                    httpURLConnection.setRequestProperty("DM-Version", "1.09");
                    if (C1134a.m5053a() != null) {
                        str3 = (String) C1134a.m5053a().get(LogBuilder.KEY_APPKEY);
                        httpURLConnection.setRequestProperty("DM-APP-ID", (String) C1134a.m5053a().get("appid"));
                        httpURLConnection.setRequestProperty("DM-APP-Key", str3);
                    }
                    httpURLConnection.connect();
                    closeable = httpURLConnection.getOutputStream();
                    closeable.write(str2.getBytes());
                    closeable.flush();
                    responseCode = httpURLConnection.getResponseCode();
                    if (200 != responseCode) {
                        a = C1180e.m5275a(httpURLConnection);
                        if (C1183h.f2599a.booleanValue()) {
                            C1183h.m5282b("HttpConnectionUtils", "response: " + a);
                        }
                        httpURLConnection.disconnect();
                        C1183h.m5282b("HttpConnectionUtils", "doPostRequest->success.");
                        C1180e.m5276a(closeable);
                        return a;
                    }
                    C1183h.m5282b("HttpConnectionUtils", "doPostRequest->error responseCode= " + responseCode);
                    valueOf = String.valueOf(responseCode);
                    return valueOf;
                } catch (KeyManagementException e2) {
                    C1183h.m5286d("HttpConnectionUtils", "doPostRequest->KeyManagementException");
                    if (VERSION.SDK_INT < 21) {
                        HttpsURLConnection.setDefaultSSLSocketFactory(new C1184j(instance.getSocketFactory()));
                    } else {
                        HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
                    }
                    HttpsURLConnection.setDefaultHostnameVerifier(new C1182g(this));
                    if (C1183h.f2599a.booleanValue()) {
                        C1183h.m5280a("HttpConnectionUtils", "doPostRequest->url=%s, urlParameters=%s", url, str2);
                    }
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                    httpURLConnection.setRequestProperty("DM-Version", "1.09");
                    if (C1134a.m5053a() != null) {
                        str3 = (String) C1134a.m5053a().get(LogBuilder.KEY_APPKEY);
                        httpURLConnection.setRequestProperty("DM-APP-ID", (String) C1134a.m5053a().get("appid"));
                        httpURLConnection.setRequestProperty("DM-APP-Key", str3);
                    }
                    httpURLConnection.connect();
                    closeable = httpURLConnection.getOutputStream();
                    closeable.write(str2.getBytes());
                    closeable.flush();
                    responseCode = httpURLConnection.getResponseCode();
                    if (200 != responseCode) {
                        C1183h.m5282b("HttpConnectionUtils", "doPostRequest->error responseCode= " + responseCode);
                        valueOf = String.valueOf(responseCode);
                        return valueOf;
                    }
                    a = C1180e.m5275a(httpURLConnection);
                    if (C1183h.f2599a.booleanValue()) {
                        C1183h.m5282b("HttpConnectionUtils", "response: " + a);
                    }
                    httpURLConnection.disconnect();
                    C1183h.m5282b("HttpConnectionUtils", "doPostRequest->success.");
                    C1180e.m5276a(closeable);
                    return a;
                }
            } catch (NoSuchAlgorithmException e3) {
                instance = null;
                C1183h.m5286d("HttpConnectionUtils", "doPostRequest->NoSuchAlgorithmException");
                if (VERSION.SDK_INT < 21) {
                    HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
                } else {
                    HttpsURLConnection.setDefaultSSLSocketFactory(new C1184j(instance.getSocketFactory()));
                }
                HttpsURLConnection.setDefaultHostnameVerifier(new C1182g(this));
                if (C1183h.f2599a.booleanValue()) {
                    C1183h.m5280a("HttpConnectionUtils", "doPostRequest->url=%s, urlParameters=%s", url, str2);
                }
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpURLConnection.setRequestProperty("DM-Version", "1.09");
                if (C1134a.m5053a() != null) {
                    str3 = (String) C1134a.m5053a().get(LogBuilder.KEY_APPKEY);
                    httpURLConnection.setRequestProperty("DM-APP-ID", (String) C1134a.m5053a().get("appid"));
                    httpURLConnection.setRequestProperty("DM-APP-Key", str3);
                }
                httpURLConnection.connect();
                closeable = httpURLConnection.getOutputStream();
                closeable.write(str2.getBytes());
                closeable.flush();
                responseCode = httpURLConnection.getResponseCode();
                if (200 != responseCode) {
                    a = C1180e.m5275a(httpURLConnection);
                    if (C1183h.f2599a.booleanValue()) {
                        C1183h.m5282b("HttpConnectionUtils", "response: " + a);
                    }
                    httpURLConnection.disconnect();
                    C1183h.m5282b("HttpConnectionUtils", "doPostRequest->success.");
                    C1180e.m5276a(closeable);
                    return a;
                }
                C1183h.m5282b("HttpConnectionUtils", "doPostRequest->error responseCode= " + responseCode);
                valueOf = String.valueOf(responseCode);
                return valueOf;
            } catch (KeyManagementException e4) {
                instance = null;
                C1183h.m5286d("HttpConnectionUtils", "doPostRequest->KeyManagementException");
                if (VERSION.SDK_INT < 21) {
                    HttpsURLConnection.setDefaultSSLSocketFactory(new C1184j(instance.getSocketFactory()));
                } else {
                    HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
                }
                HttpsURLConnection.setDefaultHostnameVerifier(new C1182g(this));
                if (C1183h.f2599a.booleanValue()) {
                    C1183h.m5280a("HttpConnectionUtils", "doPostRequest->url=%s, urlParameters=%s", url, str2);
                }
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpURLConnection.setRequestProperty("DM-Version", "1.09");
                if (C1134a.m5053a() != null) {
                    str3 = (String) C1134a.m5053a().get(LogBuilder.KEY_APPKEY);
                    httpURLConnection.setRequestProperty("DM-APP-ID", (String) C1134a.m5053a().get("appid"));
                    httpURLConnection.setRequestProperty("DM-APP-Key", str3);
                }
                httpURLConnection.connect();
                closeable = httpURLConnection.getOutputStream();
                closeable.write(str2.getBytes());
                closeable.flush();
                responseCode = httpURLConnection.getResponseCode();
                if (200 != responseCode) {
                    C1183h.m5282b("HttpConnectionUtils", "doPostRequest->error responseCode= " + responseCode);
                    valueOf = String.valueOf(responseCode);
                    return valueOf;
                }
                a = C1180e.m5275a(httpURLConnection);
                if (C1183h.f2599a.booleanValue()) {
                    C1183h.m5282b("HttpConnectionUtils", "response: " + a);
                }
                httpURLConnection.disconnect();
                C1183h.m5282b("HttpConnectionUtils", "doPostRequest->success.");
                C1180e.m5276a(closeable);
                return a;
            }
            if (VERSION.SDK_INT < 21) {
                HttpsURLConnection.setDefaultSSLSocketFactory(new C1184j(instance.getSocketFactory()));
            } else {
                HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            }
            HttpsURLConnection.setDefaultHostnameVerifier(new C1182g(this));
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5280a("HttpConnectionUtils", "doPostRequest->url=%s, urlParameters=%s", url, str2);
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setRequestProperty("DM-Version", "1.09");
            if (C1134a.m5053a() != null) {
                str3 = (String) C1134a.m5053a().get(LogBuilder.KEY_APPKEY);
                httpURLConnection.setRequestProperty("DM-APP-ID", (String) C1134a.m5053a().get("appid"));
                httpURLConnection.setRequestProperty("DM-APP-Key", str3);
            }
            httpURLConnection.connect();
            closeable = httpURLConnection.getOutputStream();
            closeable.write(str2.getBytes());
            closeable.flush();
            responseCode = httpURLConnection.getResponseCode();
            if (200 != responseCode) {
                C1183h.m5282b("HttpConnectionUtils", "doPostRequest->error responseCode= " + responseCode);
                valueOf = String.valueOf(responseCode);
                return valueOf;
            }
            a = C1180e.m5275a(httpURLConnection);
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b("HttpConnectionUtils", "response: " + a);
            }
            httpURLConnection.disconnect();
            C1183h.m5282b("HttpConnectionUtils", "doPostRequest->success.");
            C1180e.m5276a(closeable);
            return a;
        } catch (IOException e5) {
            valueOf = "HttpConnectionUtils";
            C1183h.m5286d(valueOf, "doPostRequest->IOException");
            return String.valueOf(99);
        } catch (RuntimeException e6) {
            valueOf = "HttpConnectionUtils";
            C1183h.m5286d(valueOf, "doPostRequest->RuntimeException");
            return String.valueOf(99);
        } finally {
            C1180e.m5276a(closeable);
        }
    }

    private static String m5275a(HttpURLConnection httpURLConnection) throws IOException {
        Closeable closeable = null;
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            closeable = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = closeable.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            return byteArrayOutputStream2;
        } finally {
            C1180e.m5276a(closeable);
            C1180e.m5276a(byteArrayOutputStream);
        }
    }

    static void m5276a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                C1183h.m5284c("HttpConnectionUtils", "closeStream->close error");
            }
        }
    }
}
