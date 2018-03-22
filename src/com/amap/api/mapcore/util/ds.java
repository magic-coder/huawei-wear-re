package com.amap.api.mapcore.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: HttpUrlUtil */
class ds implements HostnameVerifier {
    final /* synthetic */ dm f11743a;

    ds(dm dmVar) {
        this.f11743a = dmVar;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify("*.amap.com", sSLSession);
    }
}
