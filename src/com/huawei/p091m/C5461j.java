package com.huawei.p091m;

import android.os.RemoteException;
import com.google.gson.Gson;
import com.huawei.hwcommonservice.model.CoreSleepRRDataInfo;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

/* compiled from: HwCoreSleepMgr */
class C5461j implements Runnable {
    final /* synthetic */ CoreSleepRRDataInfo f19308a;
    final /* synthetic */ d f19309b;

    C5461j(d dVar, CoreSleepRRDataInfo coreSleepRRDataInfo) {
        this.f19309b = dVar;
        this.f19308a = coreSleepRRDataInfo;
    }

    public void run() {
        try {
            String toJson = new Gson().toJson(this.f19308a);
            int ceil = (int) Math.ceil(((double) toJson.length()) / 102400.0d);
            for (int i = 0; i < ceil - 1; i++) {
                d.h(this.f19309b).a(0, ceil, i, toJson.substring(i * 102400, (i + 1) * 102400));
                C2538c.c("HwCoreSleepMgr", new Object[]{"wangtuo sleep maxcount:", Integer.valueOf(ceil), ";currentIndex:", Integer.valueOf(i), ";content:", toJson.substring(i * 102400, (i + 1) * 102400)});
            }
            d.h(this.f19309b).a(0, ceil, ceil - 1, toJson.substring((ceil - 1) * 102400, toJson.length()));
            C2538c.c("HwCoreSleepMgr", new Object[]{"wangtuo sleep maxcount:", Integer.valueOf(ceil), ";currentIndex:", Integer.valueOf(ceil - 1), ";content:", toJson.substring((ceil - 1) * 102400, toJson.length())});
            d.a(this.f19309b, null);
        } catch (RemoteException e) {
            C2538c.c("HwCoreSleepMgr", new Object[]{"RemoteException  ", e});
        }
    }
}
