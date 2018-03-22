package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.os.Handler;
import android.os.Message;

/* compiled from: RewardActivity */
class bw extends Handler {
    final /* synthetic */ RewardActivity f6648a;

    bw(RewardActivity rewardActivity) {
        this.f6648a = rewardActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 6:
                synchronized (this.f6648a.f6497x) {
                    this.f6648a.f6451C.m10156a(this.f6648a.f6497x);
                }
                break;
            case 8:
                this.f6648a.m9995a(this.f6648a.f6496w);
                if (this.f6648a.f6496w != null) {
                    this.f6648a.m9996a(this.f6648a.f6496w.size() <= 0);
                    break;
                }
                break;
        }
        super.handleMessage(message);
    }
}
