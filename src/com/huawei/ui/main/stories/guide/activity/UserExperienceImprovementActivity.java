package com.huawei.ui.main.stories.guide.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.h;
import com.huawei.ui.main.j;
import com.huawei.ui.main.stories.guide.p181a.C2378a;

public class UserExperienceImprovementActivity extends BaseActivity {
    private Context f8621a;
    private C2378a f8622b;
    private TextView f8623c;
    private CheckBox f8624d;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_guide_user_experience_improvement);
        m12113a();
        m12118b();
    }

    private void m12113a() {
        this.f8621a = this;
        this.f8622b = new C2378a(BaseApplication.m2632b());
    }

    private void m12118b() {
        this.f8623c = (TextView) d.a(this, f.guide_user_experience_improvement_join_text);
        String string = this.f8621a.getString(j.IDS_google_user_experience_blue);
        int[] iArr = new int[]{this.f8621a.getString(j.IDS_google_user_experience_join, new Object[]{string}).indexOf(string)};
        CharSequence spannableString = new SpannableString(r1);
        spannableString.setSpan(new af(this), iArr[0], string.length() + iArr[0], 33);
        this.f8623c.setText(spannableString);
        this.f8623c.setMovementMethod(LinkMovementMethod.getInstance());
        C2538c.m12677c("UserExperienceImprovementActivity", "userAgreeFlag = ", Boolean.valueOf(this.f8622b.m11994c()));
        this.f8624d = (CheckBox) d.a(this, f.guide_user_experience_improvement_join_checkbox);
        if (this.f8622b.m11994c()) {
            this.f8624d.setChecked(true);
        } else {
            this.f8624d.setChecked(false);
        }
        m12116a(this.f8624d.isChecked());
        this.f8624d.setOnCheckedChangeListener(new ag(this));
    }

    private void m12119c() {
        this.f8621a.startActivity(new Intent(this.f8621a, UserImprovePlanActivity.class));
    }

    protected void onDestroy() {
        C0977d.m3575n(this.f8621a);
        super.onDestroy();
    }

    private void m12116a(boolean z) {
        C2538c.m12677c("UserExperienceImprovementActivity", "refresh Beta View isCheck : " + z);
        if (this.f8624d != null) {
            if (!m12120d()) {
                C2538c.m12677c("UserExperienceImprovementActivity", "refresh Beta View not BetaVersionAPP ");
            } else if (z) {
                this.f8624d.setEnabled(false);
                this.f8624d.setBackgroundResource(h.ic_check_dark_actived_disable);
            }
        }
    }

    private boolean m12120d() {
        return false;
    }
}
