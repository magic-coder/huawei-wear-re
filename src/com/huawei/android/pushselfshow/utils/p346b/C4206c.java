package com.huawei.android.pushselfshow.utils.p346b;

import com.huawei.android.pushagent.c.a.e;

class C4206c implements Runnable {
    final /* synthetic */ C4205b f15822a;

    C4206c(C4205b c4205b) {
        this.f15822a = c4205b;
    }

    public void run() {
        try {
            if (!(this.f15822a.f15816b == null || this.f15822a.f15817c == null)) {
                String a = this.f15822a.m20450a(this.f15822a.f15816b, this.f15822a.f15817c, this.f15822a.f15818d);
                e.a("PushSelfShowLog", "getDownloadFileWithHandler success, and localfile =  " + a);
                if (a != null) {
                    this.f15822a.m20452a(a);
                    return;
                }
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "getDownloadFileWithHandler failed ", e);
        }
        this.f15822a.m20451a();
    }
}
