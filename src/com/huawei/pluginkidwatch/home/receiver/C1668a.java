package com.huawei.pluginkidwatch.home.receiver;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.SynchronizePushIOEntityModel;
import com.huawei.pluginkidwatch.home.p156b.C1644x;

/* compiled from: LoopVoiceReceiver */
class C1668a extends Thread {
    final /* synthetic */ Context f4368a;
    final /* synthetic */ LoopVoiceReceiver f4369b;

    C1668a(LoopVoiceReceiver loopVoiceReceiver, Context context) {
        this.f4369b = loopVoiceReceiver;
        this.f4368a = context;
    }

    public void run() {
        C2538c.m12674b("LoopVoiceReceiver_KidWatchPushReceiver", "=========push processReceive  content ===");
        SynchronizePushIOEntityModel synchronizePushIOEntityModel = new SynchronizePushIOEntityModel();
        synchronizePushIOEntityModel.id = "9223372036854775807";
        new C1644x().m7783a(synchronizePushIOEntityModel, synchronizePushIOEntityModel.id, this.f4368a);
    }
}
