package com.huawei.hwcommonmodel.p405c;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;

/* compiled from: BaseHandler */
public abstract class C4716a<T> extends Handler {
    private static final String f17253a = C4716a.class.getSimpleName();
    private WeakReference<T> f17254b;

    protected abstract void m22593a(T t, Message message);

    public C4716a(Looper looper, T t) {
        super(looper);
        this.f17254b = new WeakReference(t);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        Object obj = this.f17254b.get();
        if (obj == null) {
            removeCallbacksAndMessages(null);
        } else if ((obj instanceof Activity) && ((Activity) obj).isFinishing()) {
            removeCallbacksAndMessages(null);
        } else if (VERSION.SDK_INT >= 17 && (obj instanceof Activity) && ((Activity) obj).isDestroyed()) {
            removeCallbacksAndMessages(null);
        } else if (!(obj instanceof Fragment) || ((Fragment) obj).isAdded()) {
            m22593a(obj, message);
        } else {
            removeCallbacksAndMessages(null);
        }
    }
}
