package com.huawei.appmarket;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.appmarket.service.deamon.download.C4331e;
import com.huawei.appmarket.service.deamon.download.DownloadService;
import com.huawei.appmarket.service.p376a.p377a.C4321a;
import com.huawei.appmarket.service.p378b.C4322a;

class C4235b extends Handler {
    final /* synthetic */ C4234a f15882a;

    C4235b(C4234a c4234a) {
        this.f15882a = c4234a;
    }

    public void handleMessage(Message message) {
        DownloadService b;
        switch (message.what) {
            case 9:
                C4321a c4321a = (C4321a) message.obj;
                if (c4321a != null) {
                    b = C4331e.m20857a().m20859b();
                    if (this.f15882a.f15877d != null && b != null) {
                        this.f15882a.m20520a(this.f15882a.f15877d, b, c4321a.f16089q, c4321a.f16074b, c4321a.f16075c, c4321a.f16084l + "", c4321a.f16086n, c4321a.f16073a, true);
                        return;
                    }
                    return;
                }
                return;
            case 16:
                b = C4331e.m20857a().m20859b();
                if (b != null) {
                    String str = this.f15882a.f15875a[C4322a.m20826a()][0];
                    String str2 = this.f15882a.f15875a[C4322a.m20826a()][1];
                    String str3 = this.f15882a.f15875a[C4322a.m20826a()][2];
                    String str4 = this.f15882a.f15875a[C4322a.m20826a()][3];
                    C4234a c4234a = this.f15882a;
                    Context a = this.f15882a.f15877d;
                    c4234a.m20520a(a, b, str, "华为应用市场 ", "com.huawei.appmarket", str2, str3, str4, true);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
