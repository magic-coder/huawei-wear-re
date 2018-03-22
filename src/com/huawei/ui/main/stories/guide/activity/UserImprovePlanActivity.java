package com.huawei.ui.main.stories.guide.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;

public class UserImprovePlanActivity extends BaseActivity {
    private Context f8625a;
    private TextView f8626b;
    private TextView f8627c;
    private TextView f8628d;
    private TextView f8629e;
    private TextView f8630f;
    private TextView f8631g;
    private TextView f8632h;
    private TextView f8633i;
    private String f8634j = "www.google.com/policies/privacy/partners/";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.m12677c("UserImprovePlanActivity", "enter onCreate():");
        setContentView(g.activity_user_improvement_plan);
        this.f8625a = BaseApplication.m2632b();
        this.f8626b = (TextView) findViewById(f.improvement_plan_section_start);
        this.f8627c = (TextView) findViewById(f.improvement_plan_section_1);
        this.f8628d = (TextView) findViewById(f.improvement_plan_section_2);
        this.f8629e = (TextView) findViewById(f.improvement_plan_section_3);
        this.f8630f = (TextView) findViewById(f.improvement_plan_section_4);
        this.f8631g = (TextView) findViewById(f.improvement_plan_section_5);
        this.f8632h = (TextView) findViewById(f.improvement_plan_section_6);
        this.f8633i = (TextView) findViewById(f.improvement_plan_section_7);
        if (m12121a()) {
            this.f8626b.setText(j.IDS_userx_plan_msg_1);
            this.f8627c.setText(j.IDS_userx_plan_msg_2);
            this.f8628d.setText(j.IDS_userx_plan_msg_3);
            this.f8629e.setText(j.IDS_userx_plan_msg_4);
            this.f8630f.setText(j.IDS_userx_plan_msg_5new);
            this.f8631g.setText(j.IDS_userx_plan_msg_6);
            this.f8632h.setVisibility(0);
            this.f8633i.setVisibility(0);
            return;
        }
        this.f8626b.setText(j.IDS_userx_plan_msg_not_chinese_1);
        this.f8627c.setText(j.IDS_userx_plan_msg_not_chinese_2);
        String string = getString(j.IDS_userx_plan_msg_not_chinese_3);
        StringBuilder stringBuilder = new StringBuilder(string);
        if (string.contains(this.f8634j)) {
            stringBuilder.insert(string.indexOf("privacy/partners/") + "privacy/partners/".length(), "</a>");
            stringBuilder.insert(string.indexOf(this.f8634j), "<a href =\"http://www.google.com/policies/privacy/partners/\">");
        }
        this.f8628d.setText(Html.fromHtml(stringBuilder.toString()));
        this.f8628d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f8629e.setText(j.IDS_userx_plan_msg_not_chinese_4);
        this.f8630f.setText(j.IDS_userx_plan_msg_not_chinese_5);
        this.f8631g.setText(j.IDS_userx_plan_msg_not_chinese_6);
        this.f8632h.setVisibility(8);
        this.f8633i.setVisibility(8);
    }

    private boolean m12121a() {
        C2538c.m12677c("UserImprovePlanActivity", "isCN()，strCountryCode=" + this.f8625a.getResources().getConfiguration().locale.getCountry());
        if (PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(this.f8625a.getResources().getConfiguration().locale.getCountry())) {
            return true;
        }
        return false;
    }

    protected void onDestroy() {
        C0977d.m3575n(this.f8625a);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }
}
