package com.huawei.ui.main.stories.settings.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.ab.C0630m;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.login.p087a.C1092a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.x;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.commonui.dialog.j;
import com.huawei.ui.commonui.dialog.l;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.main.e;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.h;
import com.huawei.ui.main.k;
import com.huawei.ui.main.stories.account.activity.ThirdPartyLoginActivity;
import com.huawei.ui.main.stories.p177a.p178a.C2278b;
import com.huawei.ui.main.stories.settings.p185a.C2460a;
import com.huawei.ui.main.stories.settings.p185a.C2465f;
import java.util.HashMap;

public class PersonalPrivacySettingsActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {
    private static final String f8910a = PersonalPrivacySettingsActivity.class.getSimpleName();
    private j f8911A;
    private l f8912B;
    private boolean[] f8913C = new boolean[]{true, false};
    private int f8914D = 0;
    private a f8915E;
    private Handler f8916F = new C2495q(this, this);
    private OnCheckedChangeListener f8917G = new C2487i(this);
    private OnItemClickListener f8918H = new C2483e(this);
    private CustomTitleBar f8919b;
    private Switch f8920c;
    private Switch f8921d;
    private a f8922e;
    private a f8923f;
    private a f8924g;
    private int f8925h = -1;
    private C2460a f8926i;
    private boolean f8927j = true;
    private Context f8928k;
    private RelativeLayout f8929l;
    private RelativeLayout f8930m;
    private RelativeLayout f8931n;
    private RelativeLayout f8932o;
    private RelativeLayout f8933p;
    private View f8934q;
    private x f8935r;
    private Switch f8936s;
    private C2278b f8937t;
    private boolean f8938u = false;
    private TextView f8939v;
    private C2465f f8940w;
    private int f8941x;
    private int f8942y;
    private int f8943z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.m12677c(f8910a, "enter onCreate():");
        this.f8928k = this;
        this.f8935r = (x) C1971j.m10236a(this.f8928k).getAdapter();
        if (this.f8935r == null) {
            C2538c.m12677c(f8910a, "messagecenter adapter is null! reset init it");
            C1971j.m10236a((Context) this).setAdapter(new com.huawei.g.a.a());
            C1971j.m10236a((Context) this).init(this);
        }
        this.f8926i = C2460a.m12288a(getApplicationContext());
        this.f8940w = new C2465f(this.f8928k, this.f8916F);
        this.f8937t = new C2278b();
        m12374d();
    }

    @TargetApi(14)
    private void m12374d() {
        C2538c.m12677c(f8910a, "enter initView()...");
        setContentView(g.activity_user_profile_privacy_settings);
        this.f8919b = (CustomTitleBar) d.a(this, f.personal_privacy_set_titlebar);
        this.f8919b.setLeftButtonOnClickListener(new C2481c(this));
        this.f8929l = (RelativeLayout) d.a(this, f.privacy_sync_profile_to_cloud_switch_layout);
        this.f8930m = (RelativeLayout) d.a(this, f.clear_cloud_profile_data_linear_layout);
        this.f8931n = (RelativeLayout) d.a(this, f.get_original_data);
        this.f8934q = d.a(this, f.below_line_get_original_data);
        this.f8933p = (RelativeLayout) d.a(this, f.setting_logout);
        this.f8933p.setVisibility(8);
        this.f8932o = (RelativeLayout) d.a(this, f.settings_unit_relative_layout);
        this.f8932o.setOnClickListener(this);
        this.f8939v = (TextView) d.a(this, f.unit_value);
        this.f8930m.setOnClickListener(this);
        this.f8931n.setOnClickListener(this);
        this.f8933p.setOnClickListener(this);
        this.f8920c = (Switch) d.a(this, f.get_data_from_band_switch_button);
        this.f8921d = (Switch) d.a(this, f.sync_profile_to_cloud_switch_button);
        this.f8920c.setOnClickListener(this);
        this.f8921d.setOnClickListener(this);
        String a = this.f8926i.m12295a(4);
        String a2 = this.f8926i.m12295a(2);
        C2538c.m12677c(f8910a, "initView... privacyBluetooth = " + a + ", privacyBaseInfo = " + a2);
        Switch switchR = this.f8920c;
        boolean z = ("".equals(a) || "false".equals(a)) ? false : true;
        switchR.setChecked(z);
        switchR = this.f8921d;
        if ("".equals(a2) || "false".equals(a2)) {
            z = false;
        } else {
            z = true;
        }
        switchR.setChecked(z);
        this.f8920c.setOnCheckedChangeListener(this);
        this.f8921d.setOnCheckedChangeListener(this);
        if (C0970w.m3489b()) {
            d.a(this, f.privacy_sync_profile_to_cloud_line).setVisibility(8);
            this.f8929l.setVisibility(8);
        }
        int b = C1093a.m4739a(this.f8928k).m4749b();
        if (!C0969i.m3482a(57)) {
            this.f8931n.setVisibility(8);
            this.f8934q.setVisibility(8);
        }
        z = (b == 0 || b == -1) ? false : true;
        C2538c.m12677c(f8910a, "login third type! login type is:" + b, ", isThirdLogin = ", Boolean.valueOf(z));
        C2538c.m12677c(f8910a, "getIfAccountArea res:" + C0630m.m2297a(BaseApplication.m2632b()).m2320e());
        if (!C0630m.m2297a(BaseApplication.m2632b()).m2320e()) {
            this.f8933p.setVisibility(8);
        } else if (z) {
            this.f8933p.setVisibility(0);
        } else {
            this.f8916F.sendEmptyMessageDelayed(1, 400);
        }
        if (c.e(this.f8928k)) {
            ((ImageView) d.a(this, f.clear_cloud_profile_view1)).setBackgroundResource(e.ic_previous);
            ((ImageView) d.a(this, f.unit_right_arrow)).setBackgroundResource(h.btn_list_leftarrow);
        }
        this.f8936s = (Switch) d.a(this, f.switch_wlan);
        this.f8936s.setOnCheckedChangeListener(this.f8917G);
        C2538c.m12677c(f8910a, "initView mWlanSwitch isOpen = " + this.f8937t.m11721a());
        this.f8936s.setChecked(z);
        if (C0969i.m3482a(35)) {
            this.f8932o.setVisibility(0);
            this.f8916F.sendEmptyMessage(0);
            return;
        }
        this.f8932o.setVisibility(8);
    }

    private void m12357a(int i, int i2) {
        if (this.f8924g == null) {
            a aVar = new a(this.f8928k, k.app_update_dialogActivity);
            this.f8924g = a.b(this.f8928k);
            this.f8924g.b(this.f8928k.getString(com.huawei.ui.main.j.IDS_settings_restore_factory_settings_dialog_title));
            this.f8924g.c(this.f8928k.getString(i));
            this.f8924g.b(this.f8928k.getString(com.huawei.ui.main.j.IDS_settings_button_cancal), new C2488j(this));
            this.f8924g.a(this.f8928k.getString(i2), new C2489k(this));
            this.f8924g.b();
        }
    }

    private void m12358a(String str) {
        if (this.f8923f == null) {
            a aVar = new a(this.f8928k, k.app_update_dialogActivity);
            this.f8923f = a.b(this.f8928k);
            this.f8923f.b(this.f8928k.getString(com.huawei.ui.main.j.IDS_settings_restore_factory_settings_dialog_title));
            this.f8923f.c(str);
            this.f8923f.b(this.f8928k.getString(com.huawei.ui.main.j.IDS_settings_button_cancal), new C2490l(this));
            this.f8923f.a(this.f8928k.getString(com.huawei.ui.main.j.IDS_settings_button_ok), new C2491m(this));
            this.f8923f.b();
        }
    }

    private void m12359a(boolean z) {
        if (this.f8925h == f.get_data_from_band_switch_button) {
            this.f8920c.setChecked(z);
        } else if (this.f8925h == f.sync_profile_to_cloud_switch_button) {
            this.f8921d.setChecked(z);
        }
    }

    private void m12366b(boolean z) {
        this.f8935r = (x) C1971j.m10236a(this.f8928k).getAdapter();
        if (this.f8935r == null) {
            C2538c.m12677c(f8910a, "messagecenter adapter is null, reset init it");
            C1971j.m10236a((Context) this).setAdapter(new com.huawei.g.a.a());
            C1971j.m10236a((Context) this).init(this);
        }
        int i = -1;
        if (this.f8925h == f.sync_profile_to_cloud_switch_button) {
            i = 2;
            this.f8926i.m12299a("special_type_profile_data", z);
        } else if (this.f8925h == f.clear_cloud_profile_data_linear_layout) {
            m12356a(104);
            return;
        }
        C2538c.m12677c(f8910a, "privacyId = " + i + ", isOpen = " + z);
        this.f8926i.m12298a(i, z);
    }

    private void m12356a(int i) {
        C2538c.m12677c(f8910a, "clearPersonalPrivacySettingProfileOrFitness... privacyId = " + i);
        m12386j();
        this.f8926i.m12297a(i, new C2492n(this));
    }

    public void onClick(View view) {
        this.f8925h = view.getId();
        if (this.f8925h == f.clear_cloud_profile_data_linear_layout) {
            m12357a(com.huawei.ui.main.j.IDS_device_cloud_Erase_your_profile_cloud_tip, com.huawei.ui.main.j.IDS_device_privacy_clear);
        } else if (this.f8925h == f.get_original_data) {
            Intent intent = new Intent();
            intent.setClass(this.f8928k, ThirdPartyLoginActivity.class);
            this.f8928k.startActivity(intent);
            com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.de.a(), new HashMap(), 0);
        } else if (this.f8925h == f.setting_logout) {
            m12375e();
        } else if (this.f8925h == f.settings_unit_relative_layout) {
            m12392a();
        }
    }

    private void m12375e() {
        C2538c.m12677c(f8910a, "Enter showLogoutDialog");
        if (this.f8915E == null || !this.f8915E.isShowing()) {
            a aVar = new a(this.f8928k, k.app_update_dialogActivity);
            this.f8915E = a.b(this.f8928k);
            this.f8915E.b(this.f8928k.getString(com.huawei.ui.main.j.IDS_service_area_notice_title));
            this.f8915E.c(this.f8928k.getString(com.huawei.ui.main.j.IDS_main_logout_note));
            this.f8915E.a(this.f8928k.getString(com.huawei.ui.main.j.IDS_yes), new C2493o(this));
            this.f8915E.b(this.f8928k.getString(com.huawei.ui.main.j.IDS_no), new C2494p(this));
            if (!this.f8915E.isShowing()) {
                this.f8915E.b();
                this.f8915E.setCancelable(false);
                return;
            }
            return;
        }
        C2538c.m12677c(f8910a, "Enter isShowing return");
    }

    public void m12392a() {
        C2538c.m12677c(f8910a, "editUnit():");
        String[] strArr = new String[]{this.f8928k.getString(com.huawei.ui.main.j.IDS_system_set_metric), this.f8928k.getString(com.huawei.ui.main.j.IDS_system_set_imperial)};
        if (this.f8911A == null) {
            this.f8912B = new l(this);
            this.f8911A = this.f8912B.a(this.f8928k.getString(com.huawei.ui.main.j.IDS_system_set_unit)).a(strArr, this.f8913C, null, this.f8918H, false).a(this.f8928k.getString(com.huawei.ui.main.j.IDS_settings_button_cancal), new C2482d(this)).b();
        }
        this.f8911A.show();
        C2538c.m12677c(f8910a, "show UnitDialog():");
    }

    private void m12377f() {
        if (!isFinishing() && this.f8911A != null) {
            this.f8911A.cancel();
            this.f8911A = null;
            this.f8912B = null;
        }
    }

    private void m12380g() {
        C2538c.m12677c(f8910a, "selectUnit() unit = " + this.f8914D);
        if (1 == this.f8914D) {
            this.f8938u = true;
            m12364b(1);
        } else {
            this.f8938u = false;
            m12364b(0);
        }
        C2538c.m12677c(f8910a, "ok,selectUnit():用户选择unitSetFlag = " + this.f8938u);
        boolean a = C0956c.m3349a();
        C2538c.m12677c(f8910a, "selectUnit():从UnitUtil获取的是: " + a);
        if (a != this.f8938u) {
            C2538c.m12677c(f8910a, "selectUnit():用户选择单位 change！");
            C0956c.m3348a(this.f8938u);
            this.f8916F.sendEmptyMessage(0);
            this.f8940w.m12337m();
            m12371c(this.f8938u);
            return;
        }
        C2538c.m12677c(f8910a, "selectUnit():unitSet not change！");
    }

    private void m12364b(int i) {
        for (int i2 = 0; i2 < this.f8913C.length; i2++) {
            this.f8913C[i2] = false;
        }
        this.f8913C[i] = true;
    }

    private void m12371c(boolean z) {
        C2538c.m12674b(f8910a, "enter uploadUnitSet():");
        this.f8940w.m12319a(new C2484f(this, z));
    }

    private void m12382h() {
        C2538c.m12677c(f8910a, "Enter checkHwid");
        if (!C1092a.m4717b(BaseApplication.m2632b())) {
            C2538c.m12677c(f8910a, "show mLougout 3");
            this.f8933p.setVisibility(0);
        } else if (C1092a.m4721c(BaseApplication.m2632b())) {
            new C1092a(BaseApplication.m2632b(), null).m4732a(this.f8928k, new C2486h(this));
        } else {
            C2538c.m12677c(f8910a, "show mLougout 2");
            this.f8933p.setVisibility(0);
        }
    }

    private void m12384i() {
        boolean a = C0956c.m3349a();
        C2538c.m12677c(f8910a, "updateUnit():isShowImperialUnit()--- flag = " + a);
        if (a) {
            this.f8939v.setText(this.f8928k.getString(com.huawei.ui.main.j.IDS_system_set_imperial));
            m12364b(1);
            return;
        }
        this.f8939v.setText(this.f8928k.getString(com.huawei.ui.main.j.IDS_system_set_metric));
        m12364b(0);
    }

    private void m12386j() {
        if (this.f8922e == null) {
            a aVar = new a(this.f8928k, k.app_update_dialogActivity);
            this.f8922e = a.a(this.f8928k);
            this.f8922e.a(this.f8928k.getString(com.huawei.ui.main.j.IDS_sns_waiting));
            this.f8922e.a();
        }
        if (!isFinishing() && this.f8922e != null) {
            this.f8922e.a();
            C2538c.m12677c(f8910a, "showLoadingDialog... mLoadingDialog.show()");
        }
    }

    public void m12393b() {
        if (!isFinishing() && this.f8922e != null) {
            this.f8922e.dismiss();
            this.f8922e = null;
            C2538c.m12677c(f8910a, "destroy mLoadingDialog");
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f8925h = compoundButton.getId();
        C2538c.m12677c(f8910a, "onCheckedChanged :" + this.f8925h);
        if (!this.f8927j) {
            this.f8927j = true;
        } else if (this.f8925h == f.get_data_from_band_switch_button) {
            C2538c.m12677c(f8910a, "getDataBandBtn.isChecked() = " + z);
            if (z) {
                m12366b(true);
            } else {
                m12357a(com.huawei.ui.main.j.IDS_device_close_get_data_wristband, com.huawei.ui.main.j.IDS_settings_button_ok);
            }
        } else if (this.f8925h == f.sync_profile_to_cloud_switch_button) {
            C2538c.m12677c(f8910a, "syncProfileBtn.isChecked() = " + z);
            if (z) {
                m12358a(getString(com.huawei.ui.main.j.IDS_device_privacy_user_info_upload_cloud) + (C0969i.m3482a(49) ? getString(com.huawei.ui.main.j.IDS_device_privacy_agree_in_Europe) : ""));
            } else {
                m12357a(com.huawei.ui.main.j.IDS_device_close_profile_sync_cloud, com.huawei.ui.main.j.IDS_settings_button_ok);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C0977d.m3575n(this.f8928k);
        m12388k();
        if (this.f8916F != null) {
            this.f8916F.removeCallbacksAndMessages(null);
        }
    }

    private void m12388k() {
        if (this.f8922e != null) {
            this.f8922e.dismiss();
            this.f8922e = null;
        }
        if (this.f8923f != null) {
            this.f8923f.dismiss();
            this.f8923f = null;
        }
        if (this.f8924g != null) {
            this.f8924g.dismiss();
            this.f8924g = null;
        }
    }
}
