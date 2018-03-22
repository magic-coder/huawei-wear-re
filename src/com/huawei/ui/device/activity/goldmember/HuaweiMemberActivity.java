package com.huawei.ui.device.activity.goldmember;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.webview.LegalInfoWebViewActivity;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1998z;
import com.huawei.ui.device.p170a.ad;

public class HuaweiMemberActivity extends BaseActivity implements OnClickListener {
    private static String f7279c = "HuaweiMemberActivity";
    private static String f7280d = "putExtraMemAdLevel";
    C1998z f7281a;
    Handler f7282b = new C2082c(this);
    private Button f7283e;
    private CheckBox f7284f;
    private Context f7285g;
    private TextView f7286h;
    private TextView f7287i;
    private TextView f7288j;
    private String f7289k = "";
    private int f7290l;

    protected void onCreate(Bundle bundle) {
        C2538c.m12677c(f7279c, "Enter onCreate()");
        super.onCreate(bundle);
        this.f7285g = this;
        this.f7290l = getIntent().getIntExtra(f7280d, 3);
        this.f7281a = new C1998z(this.f7285g);
        m10767b();
        this.f7282b.sendEmptyMessage(1);
    }

    private void m10767b() {
        C2538c.m12677c(f7279c, "Enter initView()");
        setContentView(f.activity_huawei_member);
        this.f7283e = (Button) d.a(this, e.vip_immediate_activation);
        this.f7283e.setOnClickListener(this);
        this.f7286h = (TextView) d.a(this, e.VIP_agreement_textView);
        String string = this.f7285g.getString(i.IDS_main_sns_golden_member_user_agreement);
        int[] iArr = new int[]{this.f7285g.getString(i.IDS_huawei_member_agree_to, new Object[]{string}).indexOf(string)};
        CharSequence spannableString = new SpannableString(r1);
        spannableString.setSpan(new C2080a(this), iArr[0], string.length() + iArr[0], 33);
        this.f7286h.setText(spannableString);
        this.f7286h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f7288j = (TextView) d.a(this, e.main_sns_enjoy_wonderful_interest_textView);
        this.f7287i = (TextView) d.a(this, e.main_sns_enjoy_wonderful_interest_textView_title);
        this.f7284f = (CheckBox) d.a(this, e.VIP_agreement_checkBox);
    }

    private void m10769c() {
        C2538c.m12677c(f7279c, "enter upActivationDataMember()");
        if (1 == this.f7290l) {
            this.f7289k = getResources().getString(i.IDS_main_sns_ordinary_gold);
        } else if (2 == this.f7290l) {
            this.f7289k = getResources().getString(i.IDS_main_sns_silver_gold);
        } else if (3 == this.f7290l) {
            this.f7289k = getResources().getString(i.IDS_main_sns_member_gold);
        }
        this.f7287i.setText(new SpannableString(getString(i.IDS_main_sns_enjoy_wonderful_interest, new Object[]{this.f7289k})));
        this.f7288j.setText(getResources().getString(i.IDS_main_sns_activate_the_right_to_enjoy1));
        this.f7284f.setOnCheckedChangeListener(new C2081b(this));
    }

    protected void onResume() {
        C2538c.m12677c(f7279c, "Enter onResume()");
        super.onResume();
    }

    protected void onDestroy() {
        C2538c.m12677c(f7279c, "Enter onDestroy()");
        super.onDestroy();
        if (this.f7282b != null) {
            this.f7282b.removeMessages(0);
            this.f7282b.removeMessages(1);
        }
        finish();
    }

    public void onClick(View view) {
        C2538c.m12677c(f7279c, "Enter onClick()");
        if (view.getId() == e.vip_immediate_activation) {
            Intent intent = new Intent();
            intent.addFlags(0);
            intent.setClass(this, VIPMemberActivationActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void m10764a(Context context, String str, String str2) {
        ad adVar = new ad(this.f7285g);
        Intent intent = new Intent(context, LegalInfoWebViewActivity.class);
        intent.putExtra("LegalInfoWebViewActivity.URL_TYPE_KEY", 1002);
        intent.putExtra("LegalInfoWebViewActivity.TITLE_KEY", str2);
        intent.putExtra("LegalInfoWebViewActivity.URL_KEY", adVar.m10299a(str));
        context.startActivity(intent);
    }
}
