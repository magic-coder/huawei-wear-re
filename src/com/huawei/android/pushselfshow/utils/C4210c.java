package com.huawei.android.pushselfshow.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class C4210c extends Handler {
    private WeakReference f15829a;

    public C4210c(C4162d c4162d) {
        this.f15829a = new WeakReference(c4162d);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C4162d c4162d = (C4162d) this.f15829a.get();
        if (c4162d != null) {
            c4162d.mo4386a(message);
        }
    }
}
