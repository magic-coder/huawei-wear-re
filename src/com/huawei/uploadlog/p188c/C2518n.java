package com.huawei.uploadlog.p188c;

import com.huawei.androidcommon.utils.FileUtils;

/* compiled from: Utils */
final class C2518n implements Runnable {
    final /* synthetic */ String f9001a;

    C2518n(String str) {
        this.f9001a = str;
    }

    public void run() {
        if (this.f9001a != null) {
            FileUtils.deleteFile(this.f9001a);
        }
    }
}
