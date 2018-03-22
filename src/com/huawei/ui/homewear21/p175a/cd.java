package com.huawei.ui.homewear21.p175a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: HomeFragment */
class cd extends Handler {
    private final WeakReference<C2217a> f8106a;

    public cd(Looper looper, C2217a c2217a) {
        super(looper);
        this.f8106a = new WeakReference(c2217a);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2217a c2217a = (C2217a) this.f8106a.get();
        if (c2217a != null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "WeakHandler ");
            C2538c.m12661a("MainUI", 0, "HomeFragment", "WeakHandler msg.what:" + message.what);
            switch (message.what) {
                case 1019:
                    c2217a.bc();
                    return;
                default:
                    C2538c.m12661a("MainUI", 0, "HomeFragment", "WeakHandler default");
                    return;
            }
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "WeakHandler  null");
    }
}
