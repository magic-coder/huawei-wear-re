package com.huawei.ui.main.stories.guide.activity;

/* compiled from: BasicInfoSettingActivity */
class C2399u implements Runnable {
    final /* synthetic */ BasicInfoSettingActivity f8667a;

    C2399u(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8667a = basicInfoSettingActivity;
    }

    public void run() {
        if (this.f8667a.f8611q != null && this.f8667a.f8611q.isShowing()) {
            this.f8667a.f8611q.dismiss();
            this.f8667a.f8611q = null;
        }
    }
}
