package com.huawei.bone.root;

import com.huawei.hwcommonmodel.datatypes.DeviceInfo;

/* compiled from: MainActivity */
class C6790i implements Runnable {
    final /* synthetic */ DeviceInfo f23329a;
    final /* synthetic */ C6789h f23330b;

    C6790i(C6789h c6789h, DeviceInfo deviceInfo) {
        this.f23330b = c6789h;
        this.f23329a = deviceInfo;
    }

    public void run() {
        this.f23330b.f23328a.f23213d.a(this.f23329a);
    }
}
