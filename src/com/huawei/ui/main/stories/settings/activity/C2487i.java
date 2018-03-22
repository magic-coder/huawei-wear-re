package com.huawei.ui.main.stories.settings.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PersonalPrivacySettingsActivity */
class C2487i implements OnCheckedChangeListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8954a;

    C2487i(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8954a = personalPrivacySettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "mCheckAutoUpdate clicked : isChecked = " + z);
        this.f8954a.f8937t.m11720a(z);
        Map hashMap = new HashMap();
        if (z) {
            hashMap.put("click", "1");
            c.a().a(BaseApplication.m2632b(), a.dd.a(), hashMap, 0);
            return;
        }
        hashMap.put("click", "0");
        c.a().a(BaseApplication.m2632b(), a.dd.a(), hashMap, 0);
    }
}
