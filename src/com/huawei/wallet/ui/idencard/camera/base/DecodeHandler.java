package com.huawei.wallet.ui.idencard.camera.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.wallet.utils.log.LogC;
import exocr.base.ExBaseCardInfo;

public abstract class DecodeHandler extends Handler {
    public byte[] f21526a;
    protected long f21527b;
    protected boolean f21528c;
    protected int f21529d = 0;
    protected ExBaseCardInfo f21530e;
    private final BaseCaptureActivity f21531f;

    protected abstract boolean mo5178a(byte[] bArr);

    protected DecodeHandler(BaseCaptureActivity baseCaptureActivity) {
        this.f21531f = baseCaptureActivity;
        this.f21526a = new byte[4096];
        this.f21528c = false;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                if (mo5178a((byte[]) message.obj)) {
                    Message obtain = Message.obtain(this.f21531f.mo5171d(), 4, this.f21530e);
                    Bundle bundle = new Bundle();
                    bundle.putLong("beginTime", this.f21527b);
                    obtain.setData(bundle);
                    LogC.m28530b("onPreviewFrame decode time: " + (System.currentTimeMillis() - this.f21527b), false);
                    obtain.sendToTarget();
                    return;
                }
                Message.obtain(this.f21531f.mo5171d(), 5).sendToTarget();
                return;
            case 6:
                Looper.myLooper().quit();
                return;
            case 7:
                if (message.obj instanceof Boolean) {
                    this.f21528c = ((Boolean) message.obj).booleanValue();
                    LogC.m28530b("focus result :" + this.f21528c + "", false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void m28376a() {
        Message.obtain(this.f21531f.mo5171d(), 1).sendToTarget();
    }
}
