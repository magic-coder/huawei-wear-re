package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2483e implements OnItemClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8949a;

    C2483e(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8949a = personalPrivacySettingsActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f8949a.f8914D = i;
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "Unit dialog position = " + i);
        this.f8949a.m12380g();
        this.f8949a.m12377f();
    }
}
