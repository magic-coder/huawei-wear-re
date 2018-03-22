package com.huawei.pluginkidwatch.plugin.feature.antiloss.service;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: KidWatchService */
class C1797b extends Handler {
    final /* synthetic */ KidWatchService f4955a;

    public C1797b(KidWatchService kidWatchService) {
        this.f4955a = kidWatchService;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 101:
                C2538c.m12674b("KidWatchService", "curKWBtDevice retry connecting ++++++++++++++++++");
                if (this.f4955a.f4946b != null && this.f4955a.f4946b.m8305l()) {
                    this.f4955a.f4946b.m8293c(this.f4955a.f4953i);
                    return;
                }
                return;
            case 102:
            case 103:
                if (this.f4955a.f4949e != null) {
                    this.f4955a.m8580e();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
