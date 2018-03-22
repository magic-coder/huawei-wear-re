package com.huawei.cloudservice.opensdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hwid.core.p435d.p437b.C5165e;

public abstract class ResReqHandler implements Runnable {
    boolean f16135a = true;
    private Bundle f16136b = null;
    private Handler f16137c = null;

    public abstract void onComplete(Bundle bundle);

    public ResReqHandler() {
        if (Looper.myLooper() != null) {
            this.f16137c = new Handler();
        }
    }

    public final void setStop() {
        this.f16135a = false;
    }

    public final void finish(Bundle bundle) {
        try {
            this.f16136b = bundle;
            if (!this.f16135a) {
                return;
            }
            if (this.f16137c != null) {
                this.f16137c.post(this);
            } else {
                onComplete(bundle);
            }
        } catch (Throwable th) {
            C5165e.m24910d("ResReqHandler", th.getMessage());
        }
    }

    public final void run() {
        onComplete(this.f16136b);
    }
}
