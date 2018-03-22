package com.huawei.hwbtsdk.p399a;

import com.huawei.hwbtsdk.p057b.p058a.C4604c;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: BTDeviceMgrUtil */
class C4603g implements Runnable {
    final /* synthetic */ int f16852a;
    final /* synthetic */ List f16853b;
    final /* synthetic */ C4604c f16854c;
    final /* synthetic */ C4600d f16855d;

    C4603g(C4600d c4600d, int i, List list, C4604c c4604c) {
        this.f16855d = c4600d;
        this.f16852a = i;
        this.f16853b = list;
        this.f16854c = c4604c;
    }

    public void run() {
        switch (this.f16852a) {
            case 1:
                this.f16855d.m21915d(this.f16853b);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"unPair device and sleep occur exception."});
                }
                this.f16855d.m21904a(this.f16854c);
                return;
            case 2:
                boolean f = this.f16855d.m21924i();
                if (C4600d.f16823d < 18 || !f) {
                    C2538c.b("01", 1, "BTDeviceMgrUtil", new Object[]{"Android version less than JELLY_BEAN_MR2."});
                    return;
                }
                this.f16855d.m21910b(this.f16854c);
                return;
            case 4:
                C2538c.b("01", 1, "BTDeviceMgrUtil", new Object[]{"BT Type is BT_DUAL and not support."});
                return;
            default:
                return;
        }
    }
}
