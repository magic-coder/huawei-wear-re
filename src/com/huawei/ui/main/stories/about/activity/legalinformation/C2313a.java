package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.j;

/* compiled from: LegalInformationActivity */
class C2313a implements OnItemClickListener {
    final /* synthetic */ LegalInformationActivity f8399a;

    C2313a(LegalInformationActivity legalInformationActivity) {
        this.f8399a = legalInformationActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = this.f8399a.f8379f[i];
        if (i2 == j.IDS_hw_privacy) {
            this.f8399a.f8376c.startActivity(new Intent(this.f8399a.f8376c, PrivacyPolicyActivity.class));
        } else if (i2 == j.IDS_huawei_wear_user_protocol) {
            this.f8399a.m11815a();
        } else if (i2 == j.IDS_huawei_privacy_notice) {
            this.f8399a.f8376c.startActivity(new Intent(this.f8399a.f8376c, PrivacyNoticeActivity.class));
        } else if (i2 == j.IDS_setting_user_agreement) {
            this.f8399a.m11822b();
        } else if (i2 == j.IDS_setting_software_notice) {
            this.f8399a.m11816a(this.f8399a.f8376c, this.f8399a.m11821b(this.f8399a.f8377d), this.f8399a.f8378e);
        } else {
            C2538c.m12674b("LegalInformationActivity", "itemId = " + i2);
        }
    }
}
