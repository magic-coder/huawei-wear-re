package com.huawei.wallet.ui.idencard.camera.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.wallet.utils.log.LogC;
import java.lang.ref.WeakReference;

public abstract class BaseCaptureActivityHandler extends Handler {
    private WeakReference<BaseCaptureActivity> f21514a;
    private DecodeThread f21515b;
    private State f21516c;
    private boolean f21517d;

    enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    protected abstract DecodeThread mo5175a(BaseCaptureActivity baseCaptureActivity);

    public BaseCaptureActivityHandler(BaseCaptureActivity baseCaptureActivity) {
        this.f21514a = new WeakReference(baseCaptureActivity);
        this.f21515b = mo5175a(baseCaptureActivity);
        m28356a();
    }

    public void m28356a() {
        this.f21516c = State.SUCCESS;
        this.f21517d = false;
        CameraManager.m28405a().m28419e();
        m28354c();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        BaseCaptureActivity baseCaptureActivity = (BaseCaptureActivity) this.f21514a.get();
        if (baseCaptureActivity == null) {
            LogC.m28532c("BaseCaptureActivityHandler baseCaptureActivity is null. ", false);
            return;
        }
        switch (message.what) {
            case 1:
                if (this.f21516c == State.PREVIEW && !this.f21517d) {
                    this.f21517d = true;
                    LogC.m28530b("request auto focus message", false);
                    CameraManager.m28405a().m28416b(this, 7);
                    return;
                }
                return;
            case 3:
                LogC.m28530b("Got restart preview message", false);
                m28354c();
                return;
            case 4:
                LogC.m28530b("Got decode succeeded message", false);
                this.f21516c = State.SUCCESS;
                Bundle data = message.getData();
                baseCaptureActivity.mo5168a(message.obj, data == null ? System.currentTimeMillis() : data.getLong("beginTime"));
                return;
            case 5:
                LogC.m28530b("Got decode failed message", false);
                this.f21516c = State.PREVIEW;
                CameraManager.m28405a().m28412a(this.f21515b.m28380a(), 2);
                return;
            case 7:
                this.f21517d = false;
                LogC.m28530b("response auto focus message", false);
                if (this.f21515b == null || this.f21515b.getState() == java.lang.Thread.State.TERMINATED) {
                    LogC.m28532c("Got focus but decodeThread had died", false);
                    return;
                } else if (message.obj instanceof Boolean) {
                    boolean booleanValue = ((Boolean) message.obj).booleanValue();
                    if (this.f21515b.getState() != java.lang.Thread.State.TERMINATED) {
                        this.f21515b.m28380a().obtainMessage(7, Boolean.valueOf(booleanValue)).sendToTarget();
                        return;
                    }
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void m28357b() {
        this.f21516c = State.DONE;
        CameraManager.m28405a().m28420f();
        Message.obtain(this.f21515b.m28380a(), 6).sendToTarget();
        try {
            this.f21515b.join();
        } catch (InterruptedException e) {
            LogC.m28530b("stop decodeThread ,exit Camera", false);
        }
        removeMessages(4);
        removeMessages(5);
        removeMessages(7);
        CameraManager.m28405a().m28417c();
    }

    private void m28354c() {
        if (!this.f21515b.isAlive()) {
            this.f21515b.start();
        }
        if (this.f21516c == State.SUCCESS) {
            this.f21516c = State.PREVIEW;
            CameraManager.m28405a().m28412a(this.f21515b.m28380a(), 2);
            CameraManager.m28405a().m28416b(this, 7);
        }
    }
}
