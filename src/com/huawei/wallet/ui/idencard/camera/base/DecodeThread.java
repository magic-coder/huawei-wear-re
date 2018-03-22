package com.huawei.wallet.ui.idencard.camera.base;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

public abstract class DecodeThread extends Thread {
    private final BaseCaptureActivity f21534a;
    private Handler f21535b;
    private final CountDownLatch f21536c = new CountDownLatch(1);

    protected abstract DecodeHandler mo5179a(BaseCaptureActivity baseCaptureActivity);

    public DecodeThread(BaseCaptureActivity baseCaptureActivity) {
        super("DecodeThread");
        this.f21534a = baseCaptureActivity;
    }

    public Handler m28380a() {
        try {
            this.f21536c.await();
        } catch (InterruptedException e) {
        }
        return this.f21535b;
    }

    public void run() {
        Looper.prepare();
        this.f21535b = mo5179a(this.f21534a);
        this.f21536c.countDown();
        Looper.loop();
    }
}
