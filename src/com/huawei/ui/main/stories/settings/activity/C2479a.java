package com.huawei.ui.main.stories.settings.activity;

import com.huawei.p190v.C2538c;

/* compiled from: PersonalDataSettingsActivity */
class C2479a implements Runnable {
    final /* synthetic */ PersonalDataSettingsActivity f8944a;

    C2479a(PersonalDataSettingsActivity personalDataSettingsActivity) {
        this.f8944a = personalDataSettingsActivity;
    }

    public void run() {
        if (this.f8944a.f8908h != null) {
            this.f8944a.f8908h.cancel();
            this.f8944a.f8908h = null;
            C2538c.m12677c("PersonalDataSettingsActivity", "destroy mLoadingDialog");
        }
    }
}
