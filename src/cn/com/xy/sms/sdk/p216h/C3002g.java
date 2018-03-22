package cn.com.xy.sms.sdk.p216h;

import cn.com.xy.sms.sdk.p215g.C2982a;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class C3002g implements HostnameVerifier {
    private /* synthetic */ C3001f f10162a;

    C3002g(C3001f c3001f) {
        this.f10162a = c3001f;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            C2982a.m13415a("Https", "hostName: " + str, null);
            if (this.f10162a.f10161f == 0 && str != null && (str.indexOf("duoqu.in") != -1 || str.indexOf("bizport.cn") != -1)) {
                return true;
            }
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return defaultHostnameVerifier != null ? defaultHostnameVerifier.verify(str, sSLSession) : false;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "verify: " + th.getMessage(), th);
            return false;
        }
    }
}
