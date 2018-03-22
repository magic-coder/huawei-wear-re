package com.huawei.appmarket.sdk.service.download.bean;

import android.net.NetworkInfo;

public class C4315f {
    public long f16043a;
    public long f16044b;
    public String f16045c = "";
    public boolean f16046d = false;
    final /* synthetic */ DownloadTask f16047e;
    private String f16048f = "";

    public C4315f(DownloadTask downloadTask) {
        this.f16047e = downloadTask;
    }

    public void m20788a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            String subtypeName = networkInfo.getSubtypeName();
            if (subtypeName == null || subtypeName.length() <= 0) {
                subtypeName = networkInfo.getTypeName();
            }
            if (!this.f16048f.equals(subtypeName)) {
                this.f16048f = subtypeName;
                this.f16045c += this.f16048f + "/";
            }
        }
    }
}
