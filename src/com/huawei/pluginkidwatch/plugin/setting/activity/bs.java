package com.huawei.pluginkidwatch.plugin.setting.activity;

/* compiled from: RewardActivity */
class bs implements Runnable {
    final /* synthetic */ boolean f6643a;
    final /* synthetic */ RewardActivity f6644b;

    bs(RewardActivity rewardActivity, boolean z) {
        this.f6644b = rewardActivity;
        this.f6643a = z;
    }

    public void run() {
        if (this.f6643a) {
            this.f6644b.f6488o.setVisibility(0);
            this.f6644b.f6489p.setVisibility(8);
            return;
        }
        this.f6644b.f6488o.setVisibility(8);
        this.f6644b.f6489p.setVisibility(0);
    }
}
