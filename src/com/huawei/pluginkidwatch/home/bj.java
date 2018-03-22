package com.huawei.pluginkidwatch.home;

import com.huawei.pluginkidwatch.home.HomeActivity.ReceiverAntilossAlarm;

/* compiled from: HomeActivity */
class bj implements Runnable {
    final /* synthetic */ ReceiverAntilossAlarm f4275a;

    bj(ReceiverAntilossAlarm receiverAntilossAlarm) {
        this.f4275a = receiverAntilossAlarm;
    }

    public void run() {
        this.f4275a.f4102a.m7485P();
    }
}
