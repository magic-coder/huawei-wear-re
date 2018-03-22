package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;

public class PrivacyNoticeActivity extends BaseActivity {
    private Context f8382a;
    private TextView f8383b;
    private TextView f8384c;
    private TextView f8385d;
    private TextView f8386e;
    private TextView f8387f;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_privacy_notice);
        this.f8382a = this;
        m11829a();
    }

    private void m11829a() {
        this.f8383b = (TextView) d.a(this, f.useragreement_content_text1);
        this.f8384c = (TextView) d.a(this, f.useragreement_content_text2);
        this.f8385d = (TextView) d.a(this, f.useragreement_content_text3);
        this.f8386e = (TextView) d.a(this, f.useragreement_content_text4);
        this.f8387f = (TextView) d.a(this, f.useragreement_content_text5);
        this.f8383b.setText(j.IDS_huawei_protocol_term_notice_content_text1_new);
        CharSequence stringBuilder = new StringBuilder("-");
        stringBuilder.append(this.f8382a.getResources().getString(j.IDS_huawei_protocol_term_notice_content_text2_new));
        this.f8384c.setText(stringBuilder);
        stringBuilder = new StringBuilder("-");
        stringBuilder.append(this.f8382a.getResources().getString(j.IDS_huawei_protocol_term_notice_content_text3));
        this.f8385d.setText(stringBuilder);
        stringBuilder = new StringBuilder("-");
        stringBuilder.append(this.f8382a.getResources().getString(j.IDS_huawei_protocol_term_notice_content_text4_new));
        this.f8386e.setText(stringBuilder);
        this.f8387f.setText(j.IDS_huawei_protocol_term_notice_content_text5_new);
        Button button = (Button) d.a(this, f.privacy_notice_know_button);
        button.setVisibility(0);
        button.setOnClickListener(new C2314b(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        C0977d.m3575n(this.f8382a);
    }
}
