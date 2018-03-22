package com.huawei.hwcloudmodel.p061c;

import android.os.Build.VERSION;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: HWCloudUtils */
final class C4699l implements HostnameVerifier {
    C4699l() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return VERSION.SDK_INT >= 2;
    }
}
