package com.huawei.hwid.core.p430b.p431a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: RequestManager */
class C5142e extends Thread {
    private C5125a f18570a;
    private Handler f18571b;
    private String f18572c;
    private Context f18573d;

    public C5142e(Context context, C5125a c5125a, Handler handler, String str) {
        this.f18570a = c5125a;
        this.f18572c = str;
        this.f18573d = context;
        this.f18571b = handler;
    }

    public void run() {
        try {
            if (this.f18571b != null) {
                Bundle a = C5141d.m24810a(this.f18573d, this.f18570a, this.f18572c);
                Message obtainMessage = this.f18571b.obtainMessage(0);
                if ((this.f18573d instanceof Activity) && ((Activity) this.f18573d).isFinishing()) {
                    C5165e.m24911d("RequestManager", "context is finished !!", null);
                    return;
                }
                obtainMessage.obj = a;
                this.f18571b.sendMessage(obtainMessage);
            }
        } catch (Throwable e) {
            C5165e.m24911d("RequestManager", e.getMessage(), e);
        }
    }
}
