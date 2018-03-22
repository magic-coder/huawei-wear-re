package com.huawei.hwid.openapi.out;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5248c;

public abstract class ResReqHandler implements Runnable {
    private static final String TAG = C5213b.f18818a;
    Bundle bd = null;
    Handler handler = null;
    boolean isNeedRun = true;

    public ResReqHandler() {
        if (Looper.myLooper() != null) {
            this.handler = new Handler();
        }
    }

    public final void finish(Bundle bundle) {
        try {
            this.bd = bundle;
            if (!this.isNeedRun) {
                return;
            }
            if (this.handler != null) {
                this.handler.post(this);
            } else {
                onComplete(bundle);
            }
        } catch (Throwable th) {
            C5248c.m25448b(TAG, th.toString(), th);
        }
    }

    public abstract void onComplete(Bundle bundle);

    public final void run() {
        onComplete(this.bd);
    }

    public final void setStop() {
        this.isNeedRun = false;
    }
}
