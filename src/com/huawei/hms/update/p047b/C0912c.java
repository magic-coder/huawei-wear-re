package com.huawei.hms.update.p047b;

import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HttpsUtils */
final class C0912c {
    public static void m3189a(HttpsURLConnection httpsURLConnection) {
        SocketFactory a = C0913e.m3190a();
        if (a instanceof SSLSocketFactory) {
            httpsURLConnection.setSSLSocketFactory((SSLSocketFactory) a);
        }
    }
}
