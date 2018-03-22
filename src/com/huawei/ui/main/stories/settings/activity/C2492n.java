package com.huawei.ui.main.stories.settings.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.main.j;

/* compiled from: PersonalPrivacySettingsActivity */
class C2492n implements IBaseResponseCallback {
    final /* synthetic */ PersonalPrivacySettingsActivity f8959a;

    C2492n(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8959a = personalPrivacySettingsActivity;
    }

    public void onResponse(int i, Object obj) {
        this.f8959a.m12393b();
        if (i == 0) {
            C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "onResponse clearPersonalPrivacySettingProfileOrFitness success ");
            a.b(this.f8959a, j.IDS_music_management_operation_success);
            return;
        }
        C2538c.m12680e(PersonalPrivacySettingsActivity.f8910a, "onResponse clearPersonalPrivacySettingProfileOrFitness failure");
        a.b(this.f8959a, j.IDS_music_management_operation_failed);
    }
}
