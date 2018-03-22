package com.huawei.ui.main.stories.settings.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.h;
import com.huawei.ui.main.j;
import com.huawei.ui.main.k;
import com.huawei.ui.main.stories.settings.p185a.C2465f;

public class PersonalDataSettingsActivity extends BaseActivity implements OnClickListener {
    private Context f8901a;
    private C2465f f8902b;
    private RelativeLayout f8903c;
    private RelativeLayout f8904d;
    private RelativeLayout f8905e;
    private TextView f8906f;
    private TextView f8907g;
    private a f8908h;
    private Handler f8909i = new C2480b(this, this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.m12677c("PersonalDataSettingsActivity", "Enter onCreate()：");
        this.f8901a = this;
        this.f8902b = new C2465f(this.f8901a, this.f8909i);
        m12343a(j.IDS_personal_settings_download_userinfo);
        m12351a();
    }

    public void m12351a() {
        C2538c.m12677c("PersonalDataSettingsActivity", "Enter initView()：");
        setContentView(g.activity_personal_info_settings);
        this.f8903c = (RelativeLayout) d.a(this, f.user_profile_settings_height_relative_layout);
        this.f8904d = (RelativeLayout) d.a(this, f.user_profile_settings_weight_relative_layout);
        this.f8905e = (RelativeLayout) d.a(this, f.user_profile_settings_hobbies_relative_layout);
        this.f8903c.setOnClickListener(this);
        this.f8904d.setOnClickListener(this);
        this.f8905e.setOnClickListener(this);
        this.f8906f = (TextView) d.a(this, f.height_value);
        this.f8907g = (TextView) d.a(this, f.weight_value);
        if (c.e(this.f8901a)) {
            ((ImageView) d.a(this, f.height_right_arrow)).setBackgroundResource(h.ic_arrow_previous);
            ((ImageView) d.a(this, f.weight_right_arrow)).setBackgroundResource(h.ic_arrow_previous);
            ((ImageView) d.a(this, f.hobbies_right_arrow)).setBackgroundResource(h.ic_arrow_previous);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.user_profile_settings_height_relative_layout) {
            this.f8902b.m12332h();
        } else if (id == f.user_profile_settings_weight_relative_layout) {
            this.f8902b.m12334j();
        } else if (id == f.user_profile_settings_hobbies_relative_layout) {
            C2538c.m12677c("PersonalDataSettingsActivity", "i  social ");
        } else {
            C2538c.m12677c("PersonalDataSettingsActivity", "i =" + id);
        }
    }

    private void m12346c() {
        C2538c.m12677c("PersonalDataSettingsActivity", "updateHeight(): " + this.f8902b.m12324c());
        this.f8906f.setText(this.f8902b.m12324c());
    }

    private void m12348d() {
        C2538c.m12677c("PersonalDataSettingsActivity", "updateHeight(): " + this.f8902b.m12331g());
        this.f8907g.setText(this.f8902b.m12331g());
    }

    private void m12343a(int i) {
        if (this.f8908h == null) {
            a aVar = new a(this.f8901a, k.app_update_dialogActivity);
            this.f8908h = a.a(this.f8901a);
            this.f8908h.a(this.f8901a.getString(i));
            this.f8908h.a();
        }
        if (!isFinishing() && this.f8908h != null) {
            this.f8908h.show();
            C2538c.m12677c("PersonalDataSettingsActivity", "mLoadingDialog.show()");
        }
    }

    public void m12352b() {
        if (!isFinishing() && this.f8908h != null && this.f8909i != null) {
            this.f8909i.postDelayed(new C2479a(this), 1500);
        }
    }

    protected void onResume() {
        C2538c.m12677c("PersonalDataSettingsActivity", "Enter onResume()：");
        super.onResume();
        if (C0969i.m3482a(2)) {
            this.f8905e.setVisibility(8);
            this.f8909i.sendEmptyMessageDelayed(1, 300);
            this.f8909i.sendEmptyMessageDelayed(2, 300);
        } else {
            this.f8905e.setVisibility(8);
            this.f8909i.sendEmptyMessageDelayed(1, 300);
            this.f8909i.sendEmptyMessageDelayed(2, 300);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12677c("PersonalDataSettingsActivity", "Enter onDestroy()：");
        if (C0969i.m3482a(35)) {
            this.f8902b.m12337m();
        }
        this.f8902b.m12336l();
        if (this.f8909i != null) {
            this.f8909i.removeCallbacksAndMessages(null);
        }
        C0977d.m3575n(this.f8901a);
        if (this.f8908h != null) {
            this.f8908h.dismiss();
            this.f8908h = null;
        }
    }
}
