package com.huawei.hwcloudmodel.model;

import android.content.Context;
import android.os.Build.VERSION;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.huawei.p190v.C2538c;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class RequestManager {
    private static final String TAG = "RequestManager";
    private static RequestQueue mRequestQueue;

    public class FakeX509TrustManager implements X509TrustManager {
        private static final X509Certificate[] _AcceptedIssuers = new X509Certificate[0];
        private static TrustManager[] trustManagers;

        final class C47121 implements HostnameVerifier {
            C47121() {
            }

            public boolean verify(String str, SSLSession sSLSession) {
                return VERSION.SDK_INT >= 2;
            }
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public boolean isClientTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }

        public boolean isServerTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }

        public X509Certificate[] getAcceptedIssuers() {
            return _AcceptedIssuers;
        }

        public static void allowAllSSL() {
            SSLContext sSLContext = null;
            HttpsURLConnection.setDefaultHostnameVerifier(new C47121());
            if (trustManagers == null) {
                trustManagers = new TrustManager[]{new FakeX509TrustManager()};
            }
            try {
                sSLContext = SSLContext.getInstance(SSLSocketFactory.TLS);
                sSLContext.init(null, trustManagers, new SecureRandom());
            } catch (NoSuchAlgorithmException e) {
                C2538c.c(RequestManager.TAG, new Object[]{"allowAllSSL NoSuchAlgorithmException e : " + e.getMessage()});
            } catch (KeyManagementException e2) {
                C2538c.c(RequestManager.TAG, new Object[]{"allowAllSSL KeyManagementException e : " + e2.getMessage()});
            }
            if (sSLContext != null) {
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
                return;
            }
            C2538c.c(RequestManager.TAG, new Object[]{"context is null"});
        }
    }

    private RequestManager() {
    }

    public static void init(Context context) {
        C2538c.c("testnpsRequestManager", new Object[]{"RequestManager init"});
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        C2538c.c("testnpsRequestManager", new Object[]{"RequestManager getRequestQueue"});
        if (mRequestQueue != null) {
            return mRequestQueue;
        }
        throw new IllegalStateException("RequestQueue not initialized");
    }

    public static void addRequest(Request<?> request, Object obj) {
        if (obj != null) {
            request.setTag(obj);
        }
        if (mRequestQueue == null) {
            C2538c.c("testnpsRequestManager", new Object[]{"RequestManager mRequestQueue Error is null"});
            return;
        }
        C2538c.c(TAG, new Object[]{"RequestManager isTest : " + false});
        mRequestQueue.add(request);
        C2538c.c("testnpsRequestManager", new Object[]{"RequestManager =========uuurrrlll :" + request.getUrl()});
    }

    public static void cancelAll(Object obj) {
        C2538c.c("testnpsRequestManager", new Object[]{"RequestManager cancelAll"});
        mRequestQueue.cancelAll(obj);
    }
}
