package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult {
    private int f1373a;
    private Bundle f1374b;

    public BundleResult(int i, Bundle bundle) {
        this.f1373a = i;
        this.f1374b = bundle;
    }

    public int getResultCode() {
        return this.f1373a;
    }

    public Bundle getRspBody() {
        return this.f1374b;
    }

    public void setResultCode(int i) {
        this.f1373a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.f1374b = bundle;
    }
}
