package com.cmb.pboc.httpclient;

import com.cmb.pboc.logger.PbocLog;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class HttpsUtil {
    private static final String f13436a = HttpsUtil.class.getSimpleName();
    private static X509HostnameVerifier f13437b = new C35391();

    class C35391 implements X509HostnameVerifier {
        C35391() {
        }

        public void verify(String str, X509Certificate x509Certificate) {
        }

        public void verify(String str, SSLSocket sSLSocket) {
        }

        public void verify(String str, String[] strArr, String[] strArr2) {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            boolean z;
            SSLPeerUnverifiedException e;
            PbocLog.m17738a(HttpsUtil.f13436a, "hostname: " + str);
            PbocLog.m17738a(HttpsUtil.f13436a, "CipherSuite: " + sSLSession.getCipherSuite());
            PbocLog.m17738a(HttpsUtil.f13436a, "CreationTime: " + sSLSession.getCreationTime());
            PbocLog.m17738a(HttpsUtil.f13436a, "LastAccessedTime: " + sSLSession.getLastAccessedTime());
            PbocLog.m17738a(HttpsUtil.f13436a, "PacketBufferSize: " + sSLSession.getPacketBufferSize());
            PbocLog.m17738a(HttpsUtil.f13436a, "PeerHost: " + sSLSession.getPeerHost());
            PbocLog.m17738a(HttpsUtil.f13436a, "PeerPort: " + sSLSession.getPeerPort());
            PbocLog.m17738a(HttpsUtil.f13436a, "Protocol: " + sSLSession.getProtocol());
            if (HttpsUtil.m17735a(str)) {
                return true;
            }
            try {
                javax.security.cert.X509Certificate[] peerCertificateChain = sSLSession.getPeerCertificateChain();
                if (peerCertificateChain != null) {
                    int length = peerCertificateChain.length;
                    int i = 0;
                    z = false;
                    while (i < length) {
                        try {
                            String principal = peerCertificateChain[i].getSubjectDN().toString();
                            PbocLog.m17738a(HttpsUtil.f13436a, "SubjectDN: " + principal);
                            for (String trim : principal.split(",")) {
                                String trim2 = trim2.trim();
                                if (trim2.startsWith("CN=")) {
                                    trim2 = trim2.substring(3);
                                    PbocLog.m17738a(HttpsUtil.f13436a, trim2);
                                    if (trim2.equals(str)) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            i++;
                        } catch (SSLPeerUnverifiedException e2) {
                            e = e2;
                        }
                    }
                } else {
                    z = false;
                }
            } catch (SSLPeerUnverifiedException e3) {
                e = e3;
                z = false;
                e.printStackTrace();
                return z;
            }
            return z;
        }
    }

    private HttpsUtil() {
    }

    public static String m17734a(String str, Map map) {
        HttpClient b;
        HttpHostConnectException e;
        ConnectTimeoutException e2;
        SSLPeerUnverifiedException e3;
        SSLException e4;
        Exception e5;
        Throwable th;
        Object obj;
        PbocLog.m17738a(f13436a, "postSSLRequest");
        if (str == null) {
            PbocLog.m17741d(f13436a, "Request url is null");
            throw new Exception("Request url is null");
        }
        HttpClient httpClient = null;
        try {
            b = m17736b();
            try {
                b.getParams().setParameter("http.connection.timeout", Integer.valueOf(25000));
                b.getParams().setParameter("http.socket.timeout", Integer.valueOf(30000));
                HttpUriRequest httpPost = new HttpPost(str);
                if (map != null) {
                    List arrayList = new ArrayList();
                    for (Entry entry : map.entrySet()) {
                        arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
                    }
                    httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                }
                String entityUtils = EntityUtils.toString(b.execute(httpPost).getEntity(), GameManager.DEFAULT_CHARSET);
                if (entityUtils == null || !entityUtils.startsWith("result")) {
                    PbocLog.m17741d(f13436a, "Http response: " + entityUtils);
                } else {
                    PbocLog.m17738a(f13436a, "Http response ok");
                }
                b.getConnectionManager().shutdown();
                return entityUtils;
            } catch (HttpHostConnectException e6) {
                e = e6;
                httpClient = b;
            } catch (ConnectTimeoutException e7) {
                e2 = e7;
            } catch (SSLPeerUnverifiedException e8) {
                e3 = e8;
            } catch (SSLException e9) {
                e4 = e9;
            } catch (Exception e10) {
                e5 = e10;
            }
        } catch (HttpHostConnectException e11) {
            e = e11;
            try {
                PbocLog.m17741d(f13436a, "HttpHostConnectException: " + e.getMessage());
                throw e;
            } catch (Throwable th2) {
                th = th2;
                b = httpClient;
                b.getConnectionManager().shutdown();
                throw th;
            }
        } catch (ConnectTimeoutException e12) {
            e2 = e12;
            b = null;
            PbocLog.m17741d(f13436a, "ConnectTimeoutException: " + e2.getMessage());
            throw e2;
        } catch (SSLPeerUnverifiedException e13) {
            e3 = e13;
            obj = null;
            PbocLog.m17741d(f13436a, "SSLPeerUnverifiedException: " + e3.getMessage());
            throw e3;
        } catch (SSLException e14) {
            e4 = e14;
            obj = null;
            PbocLog.m17741d(f13436a, "SSLException: " + e4.getMessage());
            throw e4;
        } catch (Exception e15) {
            e5 = e15;
            obj = null;
            PbocLog.m17741d(f13436a, "Other Exception: " + e5.getMessage());
            throw e5;
        } catch (Throwable th3) {
            th = th3;
            b.getConnectionManager().shutdown();
            throw th;
        }
    }

    static /* synthetic */ boolean m17735a(String str) {
        if (!("99.1.38.135".equals(str) || "58.61.30.114".equals(str) || "58.61.30.115".equals(str) || "58.61.30.121".equals(str) || "61.144.248.26".equals(str))) {
            "ota.cmbchina.com".equals(str);
        }
        return true;
    }

    private static HttpClient m17736b() {
        PbocLog.m17738a(f13436a, "in getHttpClient");
        try {
            SocketFactory sSLSocketFactory = new SSLSocketFactory(m17737c());
            sSLSocketFactory.setHostnameVerifier(f13437b);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, GameManager.DEFAULT_CHARSET);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", sSLSocketFactory, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception e) {
            throw new Exception("getHttpClient Error: " + e.getMessage());
        }
    }

    private static KeyStore m17737c() {
        int i = 0;
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
        instance2.load(null);
        InputStream[] inputStreamArr = new InputStream[]{new ByteArrayInputStream(Certificates.f13430a.getBytes(GameManager.DEFAULT_CHARSET)), new ByteArrayInputStream(Certificates.f13431b.getBytes(GameManager.DEFAULT_CHARSET)), new ByteArrayInputStream(Certificates.f13432c.getBytes(GameManager.DEFAULT_CHARSET)), new ByteArrayInputStream(Certificates.f13433d.getBytes(GameManager.DEFAULT_CHARSET)), new ByteArrayInputStream(Certificates.f13434e.getBytes(GameManager.DEFAULT_CHARSET)), new ByteArrayInputStream(Certificates.f13435f.getBytes(GameManager.DEFAULT_CHARSET))};
        int i2 = 0;
        while (i < 6) {
            InputStream inputStream = inputStreamArr[i];
            int i3 = i2 + 1;
            instance2.setCertificateEntry(Integer.toString(i2), instance.generateCertificate(inputStream));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            i++;
            i2 = i3;
        }
        return instance2;
    }
}
