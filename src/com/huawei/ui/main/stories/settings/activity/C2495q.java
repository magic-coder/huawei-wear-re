package com.huawei.ui.main.stories.settings.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: PersonalPrivacySettingsActivity */
class C2495q extends Handler {
    WeakReference<PersonalPrivacySettingsActivity> f8962a;
    final /* synthetic */ PersonalPrivacySettingsActivity f8963b;

    C2495q(PersonalPrivacySettingsActivity personalPrivacySettingsActivity, PersonalPrivacySettingsActivity personalPrivacySettingsActivity2) {
        this.f8963b = personalPrivacySettingsActivity;
        this.f8962a = new WeakReference(personalPrivacySettingsActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((PersonalPrivacySettingsActivity) this.f8962a.get()) != null) {
            C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "Enter handleMessage() " + message.what);
            switch (message.what) {
                case 0:
                    this.f8963b.m12384i();
                    return;
                case 1:
                    this.f8963b.m12382h();
                    return;
                default:
                    return;
            }
        }
    }
}
