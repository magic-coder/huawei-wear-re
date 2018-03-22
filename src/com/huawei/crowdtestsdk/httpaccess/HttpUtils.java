package com.huawei.crowdtestsdk.httpaccess;

import android.text.TextUtils;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.uploadlog.p188c.C2511g;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpUtils {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static CookieStore cookieStore = null;
    private static OkHttpClient httpClient = null;
    private static HttpUtils instance;

    final class C07851 implements X509TrustManager {
        C07851() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private HttpUtils() {
        httpClient = getSafeOkHttpClient();
    }

    public static HttpUtils getInstance() {
        if (instance == null) {
            instance = new HttpUtils();
        }
        return instance;
    }

    public HttpResult getData(String str) {
        return get(str);
    }

    public HttpResult postData(String str, String str2, Object obj, Map<String, String> map) {
        return post(str, str2, obj, map);
    }

    private static OkHttpClient getSafeOkHttpClient() {
        C2511g.m12477a(SdkConstants.TAG_HTTP, "[HttpUtils.getSafeOkHttpClient]Start");
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setSslSocketFactory(getUnsafeSSLSocketFactory());
            okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
            okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
            okHttpClient.setWriteTimeout(60, TimeUnit.SECONDS);
            cookieStore = new HttpInMemoryCookieStore();
            okHttpClient.setCookieHandler(new CookieManager(cookieStore, CookiePolicy.ACCEPT_ALL));
            return okHttpClient;
        } catch (Throwable e) {
            C2511g.m12482b(SdkConstants.TAG_HTTP, "[HttpUtils.getOkHttpClient]Exception:", e);
            return null;
        }
    }

    private static SSLSocketFactory getUnsafeSSLSocketFactory() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new C07851()};
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            instance.init(null, trustManagerArr, new SecureRandom());
            sSLSocketFactory = instance.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        }
        return sSLSocketFactory;
    }

    private HttpResult get(String str) {
        Call newCall;
        Object e;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HttpResult httpResult = new HttpResult();
        Closeable body;
        try {
            newCall = httpClient.newCall(new Builder().url(new StringBuilder(str).toString().replace(HwAccountConstants.BLANK, "%20")).build());
            try {
                Response execute = newCall.execute();
                if (execute == null) {
                    C2511g.m12483c(SdkConstants.TAG_HTTP, "[HttpUtils.get]Response is null");
                    IOUtils.close(null);
                    if (newCall != null) {
                        newCall.cancel();
                    }
                    return httpResult;
                }
                httpResult.statusCode = execute.code();
                body = execute.body();
                if (body == null) {
                    try {
                        C2511g.m12483c(SdkConstants.TAG_HTTP, "[HttpUtils.get]Response body is null");
                        IOUtils.close(body);
                        if (newCall != null) {
                            newCall.cancel();
                        }
                        return httpResult;
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.get]IOException:" + e);
                            IOUtils.close(body);
                            if (newCall != null) {
                                newCall.cancel();
                            }
                            return httpResult;
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtils.close(body);
                            if (newCall != null) {
                                newCall.cancel();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.get]Exception:" + e);
                        IOUtils.close(body);
                        if (newCall != null) {
                            newCall.cancel();
                        }
                        return httpResult;
                    }
                }
                httpResult.content = body.string();
                if (execute.isSuccessful()) {
                    IOUtils.close(body);
                    if (newCall != null) {
                        newCall.cancel();
                    }
                    return httpResult;
                }
                C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.get]Error, errorCode=" + httpResult.statusCode);
                IOUtils.close(body);
                if (newCall != null) {
                    newCall.cancel();
                }
                return httpResult;
            } catch (IOException e4) {
                IOException iOException = e4;
                body = null;
                IOException iOException2 = iOException;
                C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.get]IOException:" + e);
                IOUtils.close(body);
                if (newCall != null) {
                    newCall.cancel();
                }
                return httpResult;
            } catch (Exception e5) {
                Exception exception = e5;
                body = null;
                Exception exception2 = exception;
                C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.get]Exception:" + e);
                IOUtils.close(body);
                if (newCall != null) {
                    newCall.cancel();
                }
                return httpResult;
            } catch (Throwable th3) {
                body = null;
                th = th3;
                IOUtils.close(body);
                if (newCall != null) {
                    newCall.cancel();
                }
                throw th;
            }
        } catch (IOException e42) {
            newCall = null;
            e = e42;
            body = null;
            C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.get]IOException:" + e);
            IOUtils.close(body);
            if (newCall != null) {
                newCall.cancel();
            }
            return httpResult;
        } catch (Exception e52) {
            newCall = null;
            e = e52;
            body = null;
            C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.get]Exception:" + e);
            IOUtils.close(body);
            if (newCall != null) {
                newCall.cancel();
            }
            return httpResult;
        } catch (Throwable th32) {
            body = null;
            newCall = null;
            th = th32;
            IOUtils.close(body);
            if (newCall != null) {
                newCall.cancel();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.crowdtestsdk.httpaccess.HttpResult post(java.lang.String r9, java.lang.String r10, java.lang.Object r11, java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
        r8 = this;
        r2 = 0;
        r0 = android.text.TextUtils.isEmpty(r9);
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r2;
    L_0x0008:
        r3 = new com.huawei.crowdtestsdk.httpaccess.HttpResult;
        r3.<init>();
        r0 = r11 instanceof java.util.Map;
        if (r0 == 0) goto L_0x0094;
    L_0x0011:
        r4 = new com.squareup.okhttp.FormEncodingBuilder;
        r4.<init>();
        r11 = (java.util.Map) r11;
        r0 = r11.entrySet();
        r5 = r0.iterator();
    L_0x0020:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x003c;
    L_0x0026:
        r0 = r5.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r4.add(r1, r0);
        goto L_0x0020;
    L_0x003c:
        r0 = r4.build();
    L_0x0040:
        r1 = new com.squareup.okhttp.Request$Builder;
        r1.<init>();
        r1 = r1.url(r9);
        r0 = r1.post(r0);
        r0 = r8.fillHeader(r0, r10, r12);
        r0 = r0.build();
        r1 = httpClient;	 Catch:{ IOException -> 0x00fd, Exception -> 0x0120, all -> 0x0143 }
        r1 = r1.newCall(r0);	 Catch:{ IOException -> 0x00fd, Exception -> 0x0120, all -> 0x0143 }
        r0 = r1.execute();	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        r4 = r0.code();	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        r3.statusCode = r4;	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        r4 = r3.isRedirect();	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        if (r4 == 0) goto L_0x00a1;
    L_0x006b:
        r4 = "BETACLUB_SDK_HTTP";
        r5 = "[HttpUtils.post] ret isRedirect";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r4, r5);	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        r4 = "location";
        r0 = r0.header(r4);	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        r4 = "BETACLUB_SDK_HTTP";
        com.huawei.uploadlog.p188c.C2511g.m12481b(r4, r0);	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        if (r4 == 0) goto L_0x0085;
    L_0x0083:
        r0 = "/";
    L_0x0085:
        r0 = r8.getData(r0);	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        com.huawei.androidcommon.utils.IOUtils.close(r2);
        if (r1 == 0) goto L_0x0091;
    L_0x008e:
        r1.cancel();
    L_0x0091:
        r2 = r0;
        goto L_0x0007;
    L_0x0094:
        r0 = r11 instanceof java.lang.String;
        if (r0 == 0) goto L_0x0161;
    L_0x0098:
        r0 = JSON;
        r11 = (java.lang.String) r11;
        r0 = com.squareup.okhttp.RequestBody.create(r0, r11);
        goto L_0x0040;
    L_0x00a1:
        r2 = r0.body();	 Catch:{ IOException -> 0x0157, Exception -> 0x0155 }
        if (r2 == 0) goto L_0x00ad;
    L_0x00a7:
        r4 = r2.string();	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r3.content = r4;	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
    L_0x00ad:
        r4 = "BETACLUB_SDK_HTTP";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r5.<init>();	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r6 = "[HttpUtils.post] ret.content:";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r6 = r3.content;	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r4, r5);	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r0 = r0.isSuccessful();	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        if (r0 != 0) goto L_0x00f2;
    L_0x00cd:
        r0 = "BETACLUB_SDK_HTTP";
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r4.<init>();	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r5 = "[HttpUtils.post]error, errorCode=";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r5 = r3.statusCode;	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        com.huawei.uploadlog.p188c.C2511g.m12484d(r0, r4);	 Catch:{ IOException -> 0x015c, Exception -> 0x0155 }
        com.huawei.androidcommon.utils.IOUtils.close(r2);
        if (r1 == 0) goto L_0x00ef;
    L_0x00ec:
        r1.cancel();
    L_0x00ef:
        r2 = r3;
        goto L_0x0007;
    L_0x00f2:
        com.huawei.androidcommon.utils.IOUtils.close(r2);
        if (r1 == 0) goto L_0x00fa;
    L_0x00f7:
        r1.cancel();
    L_0x00fa:
        r2 = r3;
        goto L_0x0007;
    L_0x00fd:
        r0 = move-exception;
        r1 = r2;
    L_0x00ff:
        r4 = "BETACLUB_SDK_HTTP";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0150 }
        r5.<init>();	 Catch:{ all -> 0x0150 }
        r6 = "[HttpUtils.post]IOException:";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0150 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x0150 }
        r0 = r0.toString();	 Catch:{ all -> 0x0150 }
        com.huawei.uploadlog.p188c.C2511g.m12484d(r4, r0);	 Catch:{ all -> 0x0150 }
        com.huawei.androidcommon.utils.IOUtils.close(r1);
        if (r2 == 0) goto L_0x00fa;
    L_0x011c:
        r2.cancel();
        goto L_0x00fa;
    L_0x0120:
        r0 = move-exception;
        r1 = r2;
    L_0x0122:
        r4 = "BETACLUB_SDK_HTTP";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014e }
        r5.<init>();	 Catch:{ all -> 0x014e }
        r6 = "[HttpUtils.post]Exception:";
        r5 = r5.append(r6);	 Catch:{ all -> 0x014e }
        r0 = r5.append(r0);	 Catch:{ all -> 0x014e }
        r0 = r0.toString();	 Catch:{ all -> 0x014e }
        com.huawei.uploadlog.p188c.C2511g.m12484d(r4, r0);	 Catch:{ all -> 0x014e }
        com.huawei.androidcommon.utils.IOUtils.close(r2);
        if (r1 == 0) goto L_0x00fa;
    L_0x013f:
        r1.cancel();
        goto L_0x00fa;
    L_0x0143:
        r0 = move-exception;
        r1 = r2;
    L_0x0145:
        com.huawei.androidcommon.utils.IOUtils.close(r2);
        if (r1 == 0) goto L_0x014d;
    L_0x014a:
        r1.cancel();
    L_0x014d:
        throw r0;
    L_0x014e:
        r0 = move-exception;
        goto L_0x0145;
    L_0x0150:
        r0 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0145;
    L_0x0155:
        r0 = move-exception;
        goto L_0x0122;
    L_0x0157:
        r0 = move-exception;
        r7 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x00ff;
    L_0x015c:
        r0 = move-exception;
        r7 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x00ff;
    L_0x0161:
        r0 = r2;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.crowdtestsdk.httpaccess.HttpUtils.post(java.lang.String, java.lang.String, java.lang.Object, java.util.Map):com.huawei.crowdtestsdk.httpaccess.HttpResult");
    }

    private Builder fillHeader(Builder builder, String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            builder.addHeader("Referer", str);
        }
        if (!(map == null || map.isEmpty())) {
            try {
                for (Entry entry : map.entrySet()) {
                    builder.addHeader((String) entry.getKey(), URLEncoder.encode((String) entry.getValue(), "utf-8"));
                }
            } catch (UnsupportedEncodingException e) {
                C2511g.m12484d(SdkConstants.TAG_HTTP, "[HttpUtils.fillHeader]Error!");
            }
        }
        builder.removeHeader("User-Agent").addHeader("User-Agent", "Fut http client").addHeader("Accept", "text/html, application/xhtml+xml, application/xml, image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, application/x-shockwave-flash, */*").addHeader("Accept-Language", "zh-cn").addHeader("Connection", "keep-alive").addHeader("Cache-Control", "max-age=3600").addHeader("IsApp", "1");
        return builder;
    }

    public void clearCookies() {
        if (cookieStore != null) {
            cookieStore.removeAll();
        }
    }
}
