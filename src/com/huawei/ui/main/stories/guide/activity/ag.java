package com.huawei.ui.main.stories.guide.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.q.a.a;

/* compiled from: UserExperienceImprovementActivity */
class ag implements OnCheckedChangeListener {
    final /* synthetic */ UserExperienceImprovementActivity f8642a;

    ag(UserExperienceImprovementActivity userExperienceImprovementActivity) {
        this.f8642a = userExperienceImprovementActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f8642a.m12116a(z);
        if (z) {
            this.f8642a.f8622b.m11991b(true);
            a.a(true);
            return;
        }
        this.f8642a.f8622b.m11991b(false);
        a.a(false);
    }
}
