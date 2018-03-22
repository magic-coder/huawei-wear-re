package com.cmb.pboc.okhttp;

import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.okhttp.https.HttpsUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.cert.X509Certificate;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    private static String f13442a = OkHttpUtils.class.getSimpleName();
    private static volatile OkHttpUtils f13443b;
    private OkHttpClient f13444c;
    private short f13445d;
    private long f13446e;
    private String f13447f;

    class C35401 implements HostnameVerifier {
        final /* synthetic */ OkHttpUtils f13438a;

        C35401(OkHttpUtils okHttpUtils) {
            this.f13438a = okHttpUtils;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            SSLPeerUnverifiedException e;
            PbocLog.m17738a(OkHttpUtils.f13442a, "hostname: " + str);
            PbocLog.m17738a(OkHttpUtils.f13442a, "CipherSuite: " + sSLSession.getCipherSuite());
            PbocLog.m17738a(OkHttpUtils.f13442a, "CreationTime: " + sSLSession.getCreationTime());
            PbocLog.m17738a(OkHttpUtils.f13442a, "LastAccessedTime: " + sSLSession.getLastAccessedTime());
            PbocLog.m17738a(OkHttpUtils.f13442a, "PacketBufferSize: " + sSLSession.getPacketBufferSize());
            PbocLog.m17738a(OkHttpUtils.f13442a, "PeerHost: " + sSLSession.getPeerHost());
            PbocLog.m17738a(OkHttpUtils.f13442a, "PeerPort: " + sSLSession.getPeerPort());
            PbocLog.m17738a(OkHttpUtils.f13442a, "Protocol: " + sSLSession.getProtocol());
            if (OkHttpUtils.m17747a(str)) {
                return true;
            }
            boolean z;
            try {
                X509Certificate[] peerCertificateChain = sSLSession.getPeerCertificateChain();
                if (peerCertificateChain != null) {
                    int length = peerCertificateChain.length;
                    int i = 0;
                    z = false;
                    while (i < length) {
                        try {
                            String principal = peerCertificateChain[i].getSubjectDN().toString();
                            PbocLog.m17738a(OkHttpUtils.f13442a, "SubjectDN: " + principal);
                            for (String trim : principal.split(",")) {
                                String trim2 = trim2.trim();
                                if (trim2.startsWith("CN=")) {
                                    trim2 = trim2.substring(3);
                                    PbocLog.m17738a(OkHttpUtils.f13442a, trim2);
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

    class C35412 implements Runnable {
        final /* synthetic */ OkHttpUtils f13439a;
        private final /* synthetic */ String f13440b;
        private final /* synthetic */ Map f13441c;

        public void run() {
            try {
                this.f13439a.f13447f = OkHttpUtils.m17744a(this.f13439a, this.f13440b, this.f13441c);
                PbocLog.m17738a(OkHttpUtils.f13442a, "OTA return: " + this.f13439a.f13447f);
                PbocLog.m17738a(OkHttpUtils.f13442a, "Connection takes " + (System.currentTimeMillis() - this.f13439a.f13446e) + " ms");
                this.f13439a.f13445d = (short) 1;
            } catch (Exception e) {
                PbocLog.m17741d(OkHttpUtils.f13442a, e.getMessage());
                throw new Exception(e.getMessage());
            } catch (Exception e2) {
                PbocLog.m17741d(OkHttpUtils.f13442a, e2.getMessage());
                PbocLog.m17738a(OkHttpUtils.f13442a, "Connection takes " + (System.currentTimeMillis() - this.f13439a.f13446e) + " ms");
                this.f13439a.f13445d = (short) 1;
            } catch (Throwable th) {
                PbocLog.m17738a(OkHttpUtils.f13442a, "Connection takes " + (System.currentTimeMillis() - this.f13439a.f13446e) + " ms");
                this.f13439a.f13445d = (short) 1;
            }
        }
    }

    private OkHttpUtils(OkHttpClient okHttpClient) {
        Builder builder = new Builder();
        builder.hostnameVerifier(new C35401(this));
        this.f13444c = builder.build();
    }

    public static OkHttpUtils m17743a() {
        if (f13443b == null) {
            synchronized (OkHttpUtils.class) {
                if (f13443b == null) {
                    f13443b = new OkHttpUtils(null);
                }
            }
        }
        return f13443b;
    }

    static /* synthetic */ String m17744a(OkHttpUtils okHttpUtils, String str, Map map) {
        if (str == null) {
            throw new Exception("url is null!");
        }
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                builder.add((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Response execute = okHttpUtils.f13444c.newCall(new Request.Builder().url(str).post(builder.build()).build()).execute();
        if (execute.isSuccessful()) {
            return execute.body().string();
        }
        throw new IOException("Unexpected code: " + execute);
    }

    protected static boolean m17747a(String str) {
        return "99.1.38.135".equals(str) || "58.61.30.114".equals(str) || "58.61.30.115".equals(str) || "58.61.30.121".equals(str) || "61.144.248.26".equals(str) || "ota.cmbchina.com".equals(str);
    }

    public final void m17750a(String str, Map map, Callback callback) {
        if (str == null) {
            throw new Exception("url is null!");
        }
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                builder.add((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.f13444c.newCall(new Request.Builder().url(str).post(builder.build()).build()).enqueue(callback);
    }

    public final void m17751a(InputStream... inputStreamArr) {
        this.f13444c = this.f13444c.newBuilder().sslSocketFactory(HttpsUtils.m17752a(inputStreamArr, null, null)).build();
    }
}
