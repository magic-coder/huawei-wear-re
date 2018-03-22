package com.huawei.bone.root;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.bone.C6753R;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.webview.LegalInfoWebViewActivity;
import com.huawei.ui.main.stories.about.a.k;
import com.huawei.ui.main.stories.about.activity.legalinformation.PrivacyPolicyActivity;
import com.huawei.ui.main.stories.guide.a.a;
import com.huawei.ui.main.stories.guide.activity.UserImprovePlanActivity;

public class ProtocolAndClauseActivity extends BaseActivity implements OnRequestPermissionsResultCallback {
    private static String[] f23233q = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    Class<?> f23234a = MainActivity.class;
    private Context f23235b;
    private TextView f23236c;
    private TextView f23237d;
    private TextView f23238e;
    private TextView f23239f;
    private TextView f23240g;
    private TextView f23241h;
    private TextView f23242i;
    private CheckBox f23243j;
    private Button f23244k;
    private Button f23245l;
    private a f23246m;
    private int f23247n = -1;
    private boolean f23248o = false;
    private String f23249p = "";
    private Handler f23250r = new C6797p(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23235b = BaseApplication.b();
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"enter onCreate():"});
        setContentView(C6753R.layout.activity_guide_protocol_and_clause21);
        this.f23246m = new a(this.f23235b);
        m30139a();
    }

    private void m30139a() {
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"enter initView()"});
        this.f23237d = (TextView) d.a(this, C6753R.id.terms_and_condition_txt2);
        this.f23238e = (TextView) d.a(this, C6753R.id.terms_and_condition_txt3);
        this.f23239f = (TextView) d.a(this, C6753R.id.terms_and_condition_txt3_1);
        this.f23240g = (TextView) d.a(this, C6753R.id.terms_and_condition_txt4);
        this.f23241h = (TextView) d.a(this, C6753R.id.terms_and_condition_txt5);
        this.f23242i = (TextView) d.a(this, C6753R.id.agree_protocol_and_privacy_txt);
        CharSequence stringBuilder = new StringBuilder("- ");
        stringBuilder.append(this.f23235b.getResources().getString(C6753R.string.IDS_huawei_protocol_term_notice_content_text2_new));
        this.f23237d.setText(stringBuilder);
        stringBuilder = new StringBuilder("- ");
        stringBuilder.append(this.f23235b.getResources().getString(C6753R.string.IDS_huawei_protocol_term_notice_content_text3));
        this.f23238e.setText(stringBuilder);
        if (com.huawei.ui.commonui.d.c.c(this.f23235b)) {
            this.f23239f.setVisibility(0);
            stringBuilder = new StringBuilder("- ");
            stringBuilder.append(this.f23235b.getResources().getString(C6753R.string.IDS_huawei_protocol_term_notice_content_text3_1));
            this.f23239f.setText(stringBuilder);
        }
        stringBuilder = new StringBuilder("- ");
        stringBuilder.append(this.f23235b.getResources().getString(C6753R.string.IDS_huawei_protocol_term_notice_content_text4_new));
        this.f23240g.setText(stringBuilder);
        this.f23241h.setText(C6753R.string.IDS_huawei_protocol_term_notice_content_text5_new);
        String string = this.f23235b.getString(C6753R.string.IDS_huawei_wear_user_protocol_new);
        String string2 = this.f23235b.getString(C6753R.string.IDS_hw_privacy);
        int[] iArr = new int[]{r2.indexOf(string), this.f23235b.getString(C6753R.string.IDS_huawei_protocol_term_notice_content_text6, new Object[]{string, string2}).indexOf(string2)};
        CharSequence spannableString = new SpannableString(this.f23235b.getString(C6753R.string.IDS_huawei_protocol_term_notice_content_text6, new Object[]{string, string2}));
        spannableString.setSpan(new C6798q(this), iArr[0], string.length() + iArr[0], 33);
        spannableString.setSpan(new C6799r(this), iArr[1], string2.length() + iArr[1], 33);
        this.f23242i.setText(spannableString);
        this.f23242i.setMovementMethod(LinkMovementMethod.getInstance());
        this.f23243j = (CheckBox) d.a(this, C6753R.id.agree_checkbox);
        if (com.huawei.ui.commonui.d.c.c(this.f23235b)) {
            this.f23243j.setChecked(true);
            this.f23246m.b(true);
        } else if (i.a(56)) {
            this.f23243j.setChecked(true);
            this.f23246m.b(true);
        } else {
            this.f23243j.setChecked(false);
            this.f23246m.b(false);
        }
        this.f23243j.setOnCheckedChangeListener(new C6800s(this));
        this.f23236c = (TextView) d.a(this, C6753R.id.user_experience_improve_pan_txt_link);
        string = this.f23235b.getString(C6753R.string.IDS_google_user_experience_blue);
        int[] iArr2 = new int[]{this.f23235b.getString(C6753R.string.IDS_google_user_experience_join, new Object[]{string}).indexOf(string)};
        CharSequence spannableString2 = new SpannableString(this.f23235b.getString(C6753R.string.IDS_google_user_experience_join, new Object[]{string}));
        spannableString2.setSpan(new C6801t(this), iArr2[0], string.length() + iArr2[0], 33);
        this.f23236c.setText(spannableString2);
        this.f23236c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f23244k = (Button) d.a(this, C6753R.id.btn_agree);
        this.f23244k.setText(this.f23235b.getString(C6753R.string.IDS_user_permission_ok).toUpperCase());
        this.f23244k.setEnabled(false);
        this.f23244k.setOnClickListener(new C6802u(this));
        this.f23245l = (Button) d.a(this, C6753R.id.btn_disagree);
        this.f23245l.setText(this.f23235b.getString(C6753R.string.IDS_common_disagree).toUpperCase());
        this.f23245l.setOnClickListener(new C6803v(this));
        m30141a(this.f23243j.isChecked());
        m30151f();
        m30142b();
    }

    private void m30142b() {
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"requestPermissions() hasPermission =" + b.a(this.f23235b.getApplicationContext(), f23233q)});
        if (b.a(this.f23235b.getApplicationContext(), f23233q)) {
            C2538c.c("ProtocolAndClauseActivity", new Object[]{"requestPermissions() PERMISSIONS_NEEDED if (!hasPermissionNeeded) ELSE"});
            return;
        }
        b.a(this, f23233q, new C6804w(this));
    }

    private void m30145c() {
        Intent intent = new Intent(this.f23235b, LegalInfoWebViewActivity.class);
        intent.putExtra("LegalInfoWebViewActivity.URL_TYPE_KEY", 1001);
        intent.putExtra("LegalInfoWebViewActivity.TITLE_KEY", this.f23235b.getString(C6753R.string.IDS_huawei_wear_user_protocol));
        intent.putExtra("LegalInfoWebViewActivity.URL_KEY", k.a(this.f23235b));
        startActivity(intent);
    }

    private void m30148d() {
        startActivity(new Intent(this.f23235b, UserImprovePlanActivity.class));
    }

    private void m30149e() {
        startActivity(new Intent(this.f23235b, PrivacyPolicyActivity.class));
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        this.f23244k.setEnabled(true);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m30151f() {
        new Thread(new C6805x(this)).start();
    }

    private void m30141a(boolean z) {
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"refresh Beta View isCheck : " + z});
        if (this.f23243j != null && this.f23244k != null) {
            if (!m30154g()) {
                C2538c.c("ProtocolAndClauseActivity", new Object[]{"refresh Beta View not BetaVersionAPP "});
            } else if (z) {
                this.f23244k.setEnabled(true);
                this.f23244k.setBackgroundResource(C6753R.drawable.common_button_21);
                this.f23244k.setTextColor(this.f23235b.getResources().getColor(C6753R.color.user_profile_btn_text_enable));
            } else {
                this.f23244k.setEnabled(false);
                this.f23244k.setBackgroundResource(C6753R.drawable.btn_popup_dark_disable);
                this.f23244k.setTextColor(this.f23235b.getResources().getColor(C6753R.color.user_profile_btn_text_disenable));
            }
        }
    }

    private boolean m30154g() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"onRequestPermissionsResult()"});
        com.huawei.hwcommonmodel.d.a.b.a().a(strArr, iArr);
    }
}
