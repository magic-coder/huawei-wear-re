package com.huawei.ui.main.stories.settings.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.main.j;
import java.lang.ref.WeakReference;

/* compiled from: PersonalDataSettingsActivity */
class C2480b extends Handler {
    WeakReference<PersonalDataSettingsActivity> f8945a;
    final /* synthetic */ PersonalDataSettingsActivity f8946b;

    C2480b(PersonalDataSettingsActivity personalDataSettingsActivity, PersonalDataSettingsActivity personalDataSettingsActivity2) {
        this.f8946b = personalDataSettingsActivity;
        this.f8945a = new WeakReference(personalDataSettingsActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((PersonalDataSettingsActivity) this.f8945a.get()) != null) {
            C2538c.m12677c("PersonalDataSettingsActivity", "Enter handleMessage() " + message.what);
            switch (message.what) {
                case 0:
                    this.f8946b.m12352b();
                    a.a(this.f8946b.f8901a, this.f8946b.f8901a.getString(j.IDS_activity_personal_information_set_user_info_fail));
                    return;
                case 1:
                    this.f8946b.m12352b();
                    this.f8946b.m12346c();
                    return;
                case 2:
                    this.f8946b.m12352b();
                    this.f8946b.m12348d();
                    return;
                case 5:
                    this.f8946b.m12352b();
                    this.f8946b.m12346c();
                    this.f8946b.m12348d();
                    return;
                case 6:
                    this.f8946b.m12352b();
                    a.a(this.f8946b.f8901a, this.f8946b.f8901a.getString(j.IDS_update_download_failed));
                    return;
                case 7:
                    this.f8946b.m12343a(j.IDS_sns_waiting);
                    return;
                case 8:
                    this.f8946b.f8902b.m12333i();
                    return;
                case 9:
                    this.f8946b.f8902b.m12335k();
                    return;
                default:
                    return;
            }
        }
    }
}
