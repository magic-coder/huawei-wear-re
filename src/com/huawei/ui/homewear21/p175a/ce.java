package com.huawei.ui.homewear21.p175a;

import java.lang.ref.WeakReference;

/* compiled from: HomeFragment */
class ce implements Runnable {
    private final WeakReference<C2217a> f8070a;

    public ce(C2217a c2217a) {
        this.f8070a = new WeakReference(c2217a);
    }

    public void run() {
    }

    public C2217a m11568a() {
        return (C2217a) this.f8070a.get();
    }
}
