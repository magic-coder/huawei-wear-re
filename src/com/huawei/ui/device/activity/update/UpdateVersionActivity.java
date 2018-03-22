package com.huawei.ui.device.activity.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.n.a;
import com.huawei.n.b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.j;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.device.views.device.RoundProgressImageView;
import com.huawei.ui.main.stories.about.activity.AboutActivity;
import java.util.HashMap;
import java.util.Map;

public class UpdateVersionActivity extends BaseActivity implements OnClickListener {
    private int f7713A = 0;
    private boolean f7714B = true;
    private RoundProgressImageView f7715C;
    private u f7716D = null;
    private u f7717E = null;
    private u f7718F = null;
    private BroadcastReceiver f7719G = new C2172f(this);
    private final BroadcastReceiver f7720H = new C2178l(this);
    private Context f7721a = null;
    private CustomTitleBar f7722b;
    private ImageView f7723c;
    private RelativeLayout f7724d;
    private TextView f7725e;
    private TextView f7726f;
    private TextView f7727g;
    private LinearLayout f7728h;
    private Button f7729i;
    private TextView f7730j;
    private LinearLayout f7731k;
    private TextView f7732l;
    private TextView f7733m;
    private ImageView f7734n;
    private RelativeLayout f7735o;
    private TextView f7736p;
    private TextView f7737q;
    private TextView f7738r;
    private LinearLayout f7739s;
    private TextView f7740t;
    private TextView f7741u;
    private ah f7742v;
    private BroadcastReceiver f7743w = null;
    private u f7744x = null;
    private TextView f7745y;
    private boolean f7746z = false;

    private void m11132a(Intent intent) {
        int intExtra = intent.getIntExtra("state", -1);
        int intExtra2 = intent.getIntExtra("result", -1);
        String stringExtra = intent.getStringExtra("content");
        C2538c.m12677c("UpdateVersionActivity", "updateAppState: state = " + intExtra + ", result = " + intExtra2);
        m11130a(intExtra, intExtra2, stringExtra, intent);
        m11131a(intExtra, stringExtra);
        m11129a(intExtra, intExtra2);
    }

    private void m11130a(int i, int i2, String str, Intent intent) {
        switch (i) {
            case 10:
                C2538c.m12677c("UpdateVersionActivity", "STATE_CHECK_NEW_VERSION_START: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                return;
            case 11:
                C2538c.m12677c("UpdateVersionActivity", "STATE_CHECK_NEW_VERSION_FAILED: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                int i3 = this.f7742v.f6876k;
                ah ahVar = this.f7742v;
                if (i3 == 1) {
                    String str2 = "";
                    if (i2 == 0) {
                        C2538c.m12677c("UpdateVersionActivity", "No New Version");
                        m11157i();
                        this.f7742v.m10349p();
                        return;
                    }
                    m11136a(str2, i2);
                    return;
                }
                return;
            case 12:
                C2538c.m12677c("UpdateVersionActivity", "STATE_CHECK_NEW_VERSION_SUCCESS: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                C2538c.m12677c("UpdateVersionActivity", "手动消息中心 ");
                this.f7742v.m10332b(Boolean.valueOf(true));
                this.f7742v.f6866a = i2;
                this.f7742v.f6868c = c.a(this.f7721a, (long) i2);
                this.f7742v.f6867b = str;
                C2538c.m12677c("UpdateVersionActivity", "STATE_CHECK_NEW_VERSION_SUCCESS: mBandNewVersion = " + this.f7742v.f6867b);
                this.f7746z = intent.getBooleanExtra("isForced", false);
                if (this.f7746z && ah.m10316a(this.f7721a).m10356w()) {
                    this.f7746z = false;
                    C2538c.m12677c("UpdateVersionActivity", "isBetweenOneDay isForce = " + this.f7746z);
                }
                this.f7713A = intent.getIntExtra("minAppCode", 0);
                C2538c.m12677c("UpdateVersionActivity", "check success! isForced:" + this.f7746z + " minCode: " + this.f7713A);
                return;
            default:
                return;
        }
    }

    private void m11131a(int i, String str) {
        ah ahVar;
        ah ahVar2;
        int i2;
        switch (i) {
            case 20:
                C2538c.m12677c("UpdateVersionActivity", "STATE_DOWNLOAD_APP_START: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                ahVar = this.f7742v;
                ahVar2 = this.f7742v;
                ahVar.f6876k = 3;
                return;
            case 30:
                C2538c.m12677c("UpdateVersionActivity", "STATE_FETCH_CHANGELOG_START: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                i2 = this.f7742v.f6876k;
                ahVar2 = this.f7742v;
                if (i2 == 1) {
                    ahVar = this.f7742v;
                    ahVar2 = this.f7742v;
                    ahVar.f6876k = 2;
                    return;
                }
                return;
            case 31:
                C2538c.m12677c("UpdateVersionActivity", "STATE_FETCH_CHANGELOG_FAILED: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                i2 = this.f7742v.f6876k;
                ahVar2 = this.f7742v;
                if (i2 == 2) {
                    m11142b(this.f7721a.getString(i.IDS_update_get_changelog_failed));
                    return;
                }
                return;
            case 32:
                C2538c.m12677c("UpdateVersionActivity", "STATE_FETCH_CHANGELOG_SUCCESS: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                i2 = this.f7742v.f6876k;
                ahVar2 = this.f7742v;
                if (i2 == 2) {
                    this.f7742v.f6869d = this.f7742v.m10324a(str);
                    C2538c.m12677c("UpdateVersionActivity", "STATE_CHECK_NEW_VERSION_SUCCESS: mBandNewFeatureContent = " + this.f7742v.f6869d);
                    m11158j();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m11129a(int i, int i2) {
        switch (i) {
            case 21:
                C2538c.m12677c("UpdateVersionActivity", "STATE_DOWNLOAD_APP_PROGRESS: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                int i3 = this.f7742v.f6876k;
                ah ahVar = this.f7742v;
                if (i3 == 0) {
                    ah ahVar2 = this.f7742v;
                    ahVar = this.f7742v;
                    ahVar2.f6876k = 3;
                }
                m11140b(i2);
                return;
            case 22:
                C2538c.m12677c("UpdateVersionActivity", "STATE_DOWNLOAD_APP_FAILED: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
                String str = "";
                int i4 = this.f7742v.f6876k;
                ah ahVar3 = this.f7742v;
                if (i4 == 3) {
                    C2538c.m12677c("UpdateVersionActivity", "STATE_DOWNLOAD_APP_FAILED: result = " + i2);
                    str = m11128a(i2);
                }
                m11142b(str);
                return;
            case 23:
                C2538c.m12677c("UpdateVersionActivity", "STATE_DOWNLOAD_APP_SUCCESS: ");
                m11160l();
                m11139b();
                finish();
                return;
            default:
                return;
        }
    }

    private void m11136a(String str, int i) {
        String string;
        if (1 == i) {
            string = this.f7721a.getResources().getString(i.IDS_update_network_error);
            m11135a(string);
        } else if (2 == i) {
            string = this.f7721a.getResources().getString(i.IDS_update_server_error);
        } else if (4 == i) {
            string = this.f7721a.getString(i.IDS_settings_firmware_upgrade_phone_low_battery);
        } else {
            string = this.f7721a.getResources().getString(i.IDS_update_unknown_error);
        }
        m11142b(string);
    }

    private String m11128a(int i) {
        String str = "";
        switch (i) {
            case 1:
                return this.f7721a.getString(i.IDS_update_download_check_failed);
            case 3:
                return this.f7721a.getString(i.IDS_update_network_error);
            case 4:
                return this.f7721a.getString(i.IDS_settings_firmware_upgrade_phone_low_battery);
            default:
                return this.f7721a.getString(i.IDS_update_download_failed);
        }
    }

    private void m11139b() {
        C2538c.m12677c("UpdateVersionActivity", " enterDeviceOtaActivity():");
        Intent intent = new Intent();
        intent.setClass(this.f7721a, DeviceOtaActivity.class);
        this.f7721a.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7721a = this;
        C2538c.m12677c("UpdateVersionActivity", "onCreate()");
        C2538c.m12677c("UpdateVersionActivity", "isForced :" + this.f7746z);
        this.f7742v = ah.m10316a(this.f7721a);
        setContentView(f.activity_update_version);
        m11149e();
        m11145c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_app_check_new_version_state");
        this.f7721a.registerReceiver(this.f7719G, intentFilter, C0976c.f1642a, null);
    }

    private void m11145c() {
        C2538c.m12677c("UpdateVersionActivity", "enter initUpdate()  ");
        ah ahVar = this.f7742v;
        ah ahVar2 = this.f7742v;
        ahVar.f6876k = 0;
        m11154g();
        m11166r();
        this.f7742v.m10328a(true);
    }

    protected void onResume() {
        C2538c.m12677c("UpdateVersionActivity", "onResume()");
        super.onResume();
    }

    public void onBackPressed() {
        C2538c.m12677c("UpdateVersionActivity", "onBackPressed()  ");
        if (this.f7742v != null) {
            int i = this.f7742v.f6876k;
            C2538c.m12677c("UpdateVersionActivity", "onBackPressed() status = " + i);
            C2538c.m12677c("UpdateVersionActivity", "onBackPressed() isForcedUpdate = " + this.f7746z);
            if (i == 0) {
                super.onBackPressed();
            } else if (this.f7746z) {
                m11146c(this.f7742v.f6874i);
                super.onBackPressed();
            } else if (i == 3) {
                m11164p();
            } else {
                super.onBackPressed();
            }
        }
    }

    protected void onDestroy() {
        C0977d.m3575n(this.f7721a);
        super.onDestroy();
        m11167s();
        m11168t();
        m11148d();
        if (this.f7742v != null) {
            C2538c.m12677c("UpdateVersionActivity", "ondestroy updateInteractor release");
            this.f7742v.m10352s();
            this.f7742v = null;
        }
        this.f7721a = null;
        C2538c.m12677c("UpdateVersionActivity", "onDestroy()");
    }

    private void m11148d() {
        if (this.f7716D != null) {
            this.f7716D.dismiss();
            this.f7716D = null;
        }
        if (this.f7718F != null) {
            this.f7718F.dismiss();
            this.f7718F = null;
        }
        if (this.f7717E != null) {
            this.f7717E.dismiss();
            this.f7717E = null;
        }
    }

    private void m11149e() {
        C2538c.m12677c("UpdateVersionActivity", "Enter initView!");
        this.f7715C = (RoundProgressImageView) d.a(this, e.center_ota_download);
        this.f7715C.setVisibility(0);
        this.f7722b = (CustomTitleBar) d.a(this, e.update_title);
        this.f7723c = (ImageView) d.a(this, e.image_check_logo);
        this.f7724d = (RelativeLayout) d.a(this, e.rele_circle_download);
        this.f7724d.setVisibility(8);
        this.f7725e = (TextView) d.a(this, e.text_percent);
        this.f7726f = (TextView) d.a(this, e.text_per_sign);
        this.f7726f.setText("%");
        this.f7726f.setVisibility(8);
        this.f7727g = (TextView) d.a(this, e.text_circle_tip);
        this.f7728h = (LinearLayout) d.a(this, e.rela_failed);
        this.f7729i = (Button) d.a(this, e.button);
        this.f7729i.setOnClickListener(this);
        this.f7729i.setClickable(true);
        this.f7730j = (TextView) d.a(this, e.text_new_version_tip);
        this.f7731k = (LinearLayout) d.a(this, e.lin_tip);
        this.f7731k.setVisibility(8);
        this.f7732l = (TextView) d.a(this, e.text_tip);
        this.f7733m = (TextView) d.a(this, e.text_tip_content);
        this.f7740t = (TextView) d.a(this, e.text_new_feature);
        this.f7741u = (TextView) d.a(this, e.text_new_feature_content);
        this.f7739s = (LinearLayout) d.a(this, e.lin_new_feature);
        this.f7739s.setVisibility(8);
        this.f7734n = (ImageView) d.a(this, e.imageview_line);
        this.f7734n.setVisibility(8);
        this.f7745y = (TextView) d.a(this, e.failed_message);
        this.f7735o = (RelativeLayout) d.a(this, e.rela_device_version);
        this.f7736p = (TextView) d.a(this, e.text_device_version);
        this.f7737q = (TextView) d.a(this, e.text_device_version_num);
        this.f7738r = (TextView) d.a(this, e.text_device_version_size);
        this.f7722b.setTitleText(this.f7721a.getResources().getString(i.IDS_ota_update_band_update));
        this.f7722b.setLeftButtonOnClickListener(new C2173g(this));
        this.f7735o.setVisibility(0);
        if (this.f7742v.f6873h != null) {
            this.f7737q.setText(this.f7742v.f6873h);
        }
        m11152f();
    }

    private void m11152f() {
        C2538c.m12677c("UpdateVersionActivity", "Enter showDeviceType() deviceType " + this.f7742v.f6871f);
        this.f7742v.f6875j = this.f7742v.m10346m();
        if (this.f7742v.f6875j != null) {
            this.f7742v.f6871f = this.f7742v.f6875j.getProductType();
        }
        C2538c.m12677c("UpdateVersionActivity", "Enter showDeviceType() getProductType() productType " + this.f7742v.f6871f);
        b a = a.a(this.f7742v.f6871f);
        if (a.d() != 0) {
            this.f7723c.setImageDrawable(this.f7721a.getResources().getDrawable(a.d()));
        }
    }

    public void onClick(View view) {
        C2538c.m12677c("UpdateVersionActivity", "onclick " + this.f7742v.f6876k);
        if (view.getId() == e.button) {
            int i = this.f7742v.f6876k;
            ah ahVar = this.f7742v;
            if (i == 0) {
                C2538c.m12677c("UpdateVersionActivity", "mUpdateInteractors.STATUS_INITIAL ");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action_app_check_new_version_state");
                this.f7721a.registerReceiver(this.f7719G, intentFilter, C0976c.f1642a, null);
                m11154g();
            }
            i = this.f7742v.f6876k;
            ahVar = this.f7742v;
            if (i == 2) {
                C2538c.m12677c("UpdateVersionActivity", "mUpdateInteractors.STATUS_PULL_CHANGE_LOG");
                m11162n();
            }
        }
    }

    private void m11154g() {
        m11155h();
        m11161m();
        Map hashMap = new HashMap();
        hashMap.put("state", "device");
        com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cF.a(), hashMap, 0);
    }

    private void m11155h() {
        C2538c.m12677c("UpdateVersionActivity", "Enter initViewForCheck! ");
        this.f7722b.setTitleText(this.f7721a.getResources().getString(i.IDS_ota_update_band_update));
        this.f7735o.setVisibility(0);
        if (this.f7742v.f6873h != null) {
            this.f7737q.setText(this.f7742v.f6873h);
        }
        m11152f();
        this.f7723c.setVisibility(0);
        this.f7715C.m11281a();
        this.f7724d.setVisibility(8);
        this.f7728h.setVisibility(8);
        this.f7731k.setVisibility(8);
        this.f7734n.setVisibility(8);
        this.f7729i.getBackground().setAlpha(150);
        this.f7729i.setClickable(false);
        this.f7729i.setText(i.IDS_ota_update_state_checking);
        this.f7729i.setTextColor(856530939);
    }

    private void m11157i() {
        C2538c.m12677c("UpdateVersionActivity", "Enter initViewForNoVersion! ");
        this.f7729i.getBackground().setAlpha(255);
        this.f7729i.setClickable(true);
        this.f7729i.setTextColor(-15884293);
        this.f7729i.setText(i.IDS_ota_update_button_check_version);
        this.f7730j.setText(i.IDS_ota_update_state_no_new_version);
        this.f7730j.setVisibility(0);
        this.f7715C.m11284c();
        ah ahVar = this.f7742v;
        ah ahVar2 = this.f7742v;
        ahVar.f6876k = 0;
    }

    private void m11135a(String str) {
        C2538c.m12677c("UpdateVersionActivity", "Enter initViewForNoNetwork! ");
        this.f7729i.getBackground().setAlpha(255);
        this.f7729i.setClickable(true);
        this.f7729i.setTextColor(-15884293);
        this.f7729i.setText(i.IDS_retry);
        this.f7731k.setVisibility(0);
        this.f7732l.setText(this.f7721a.getString(i.IDS_service_area_notice_title));
        this.f7733m.setText(str);
        this.f7734n.setVisibility(0);
        this.f7715C.m11284c();
    }

    private void m11158j() {
        C2538c.m12677c("UpdateVersionActivity", "Enter showAppNewVersion");
        this.f7729i.getBackground().setAlpha(255);
        this.f7729i.setClickable(true);
        this.f7729i.setTextColor(-15884293);
        this.f7729i.setText(i.IDS_device_manager_update_health);
        this.f7730j.setText(i.IDS_ota_update_new_version);
        this.f7730j.setVisibility(0);
        this.f7739s.setVisibility(0);
        this.f7735o.setVisibility(0);
        this.f7736p.setText(i.IDS_ota_update_new_version);
        this.f7737q.setText(this.f7742v.f6867b);
        this.f7738r.setText(this.f7742v.f6868c);
        this.f7738r.setVisibility(0);
        this.f7741u.setText(this.f7742v.f6869d);
        this.f7715C.m11284c();
    }

    private void m11159k() {
        C2538c.m12677c("UpdateVersionActivity", "Enter initViewForDownload!");
        this.f7723c.setVisibility(8);
        this.f7728h.setVisibility(8);
        this.f7731k.setVisibility(8);
        this.f7724d.setVisibility(0);
        m11140b(0);
        this.f7734n.setVisibility(8);
        this.f7729i.getBackground().setAlpha(150);
        this.f7729i.setClickable(false);
        this.f7729i.setTextColor(856530939);
        this.f7730j.setVisibility(4);
    }

    private void m11140b(int i) {
        C2538c.m12677c("UpdateVersionActivity", "Enter showAppDownloadProgress progress = " + i);
        this.f7727g.setText(i.IDS_update_downloading);
        C2538c.m12677c("UpdateVersionActivity", "Enter showAppDownloadProgress percentNum = " + r0 + "text:" + C0956c.m3343a(this.f7721a, "[\\d]", C0956c.m3344a((double) i, 2, 0), j.percent_number_style_num, j.percent_number_style_sign));
        this.f7725e.setText(C0956c.m3343a(this.f7721a, "[\\d]", r0, j.percent_number_style_num, j.percent_number_style_sign));
        this.f7715C.m11282a((float) i);
    }

    private void m11160l() {
        this.f7727g.setText(i.IDS_settings_firmware_upgrade_talk_band_succeed);
        this.f7727g.setVisibility(0);
        m11140b(100);
        this.f7729i.getBackground().setAlpha(150);
        this.f7729i.setClickable(false);
        this.f7729i.setTextColor(856530939);
    }

    private void m11142b(String str) {
        ah ahVar;
        C2538c.m12677c("UpdateVersionActivity", "showErrorMsg(): tipText = " + str);
        this.f7715C.m11284c();
        this.f7723c.setVisibility(8);
        m11140b(0);
        this.f7724d.setVisibility(8);
        this.f7728h.setVisibility(0);
        this.f7729i.getBackground().setAlpha(255);
        this.f7729i.setClickable(true);
        this.f7729i.setTextColor(-15884293);
        this.f7729i.setText(this.f7721a.getText(i.IDS_retry));
        this.f7731k.setVisibility(0);
        this.f7732l.setText(this.f7721a.getString(i.IDS_settings_restore_factory_settings_dialog_title));
        this.f7733m.setText(str);
        this.f7734n.setVisibility(0);
        int i = this.f7742v.f6876k;
        ah ahVar2 = this.f7742v;
        if (i != 1) {
            i = this.f7742v.f6876k;
            ahVar2 = this.f7742v;
            if (i != 2) {
                i = this.f7742v.f6876k;
                ahVar2 = this.f7742v;
                if (i == 3) {
                    this.f7745y.setText(i.IDS_update_download_failed);
                } else {
                    this.f7745y.setText("");
                }
                C2538c.m12677c("UpdateVersionActivity", "showErrorMsg() mUpdateStatus :" + this.f7742v.f6876k);
                ahVar = this.f7742v;
                ahVar2 = this.f7742v;
                ahVar.f6876k = 0;
            }
        }
        this.f7745y.setText(i.IDS_ota_check_version_failed_title);
        C2538c.m12677c("UpdateVersionActivity", "showErrorMsg() mUpdateStatus :" + this.f7742v.f6876k);
        ahVar = this.f7742v;
        ahVar2 = this.f7742v;
        ahVar.f6876k = 0;
    }

    private void m11161m() {
        C2538c.m12677c("UpdateVersionActivity", "doCheckAppNewVersion: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k + "isConnected:" + this.f7714B);
        int i = this.f7742v.f6876k;
        ah ahVar = this.f7742v;
        if (i == 0) {
            ah ahVar2 = this.f7742v;
            ahVar = this.f7742v;
            ahVar2.f6876k = 1;
        }
        if (this.f7714B) {
            this.f7742v.m10338e();
        } else {
            m11142b(this.f7721a.getString(i.IDS_music_management_disconnection));
        }
    }

    private void m11162n() {
        C2538c.m12677c("UpdateVersionActivity", "handleAppNewVersionOK: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
        if (this.f7713A > 0) {
            C2538c.m12677c("UpdateVersionActivity", "curversioncode :" + C0977d.m3550d(this.f7721a));
            if (this.f7713A > C0977d.m3550d(this.f7721a)) {
                m11170a();
                return;
            }
        }
        C2538c.m12677c("UpdateVersionActivity", "handleAppNewVersionOK: mUpdateInteractors.bandNewVersionNumSize = " + this.f7742v.f6866a);
        C2538c.m12677c("UpdateVersionActivity", "handleAppNewVersionOK: checkMemory = " + this.f7742v.m10330a((long) this.f7742v.f6866a));
        if (this.f7742v.m10330a((long) this.f7742v.f6866a)) {
            C2538c.m12677c("UpdateVersionActivity", "handleAppNewVersionOK: wifiConnected = " + this.f7742v.m10343j());
            if (this.f7742v.m10343j()) {
                m11165q();
                return;
            } else if (this.f7742v.m10344k()) {
                m11163o();
                return;
            } else {
                m11165q();
                return;
            }
        }
        m11142b(this.f7721a.getString(i.IDS_update_low_memory));
    }

    private void m11163o() {
        if (this.f7721a != null && this.f7717E == null) {
            this.f7717E = new w(this.f7721a).a(i.IDS_service_area_notice_title).b(i.IDS_ota_update_is_roaming).a(i.IDS_settings_button_cancal, new C2175i(this)).b(i.IDS_contact_confirm, new C2174h(this)).a();
            this.f7717E.setCancelable(true);
            this.f7717E.show();
        }
    }

    private void m11164p() {
        if (this.f7721a != null && this.f7716D == null) {
            this.f7716D = new w(this.f7721a).a(i.IDS_service_area_notice_title).b(i.IDS_settings_firmware_upgrade_ensure_exit).a(i.IDS_settings_button_cancal, new C2177k(this)).b(i.IDS_settings_button_ok, new C2176j(this)).a();
            this.f7716D.setCancelable(true);
            this.f7716D.show();
        }
    }

    private void m11165q() {
        C2538c.m12677c("UpdateVersionActivity", "doDownloadAppFile: mUpdateInteractors.mUpdateStatus = " + this.f7742v.f6876k);
        m11159k();
        this.f7742v.m10340g();
        this.f7742v.m10339f();
    }

    private void m11166r() {
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        this.f7743w = this.f7720H;
        this.f7721a.registerReceiver(this.f7720H, intentFilter, C0976c.f1642a, null);
    }

    private void m11167s() {
        if (this.f7743w != null) {
            try {
                this.f7721a.unregisterReceiver(this.f7720H);
                this.f7743w = null;
            } catch (IllegalArgumentException e) {
                C2538c.m12677c("UpdateVersionActivity", e.getMessage());
            } catch (RuntimeException e2) {
                C2538c.m12677c("UpdateVersionActivity", e2.getMessage());
            }
        }
    }

    private void m11168t() {
        if (this.f7719G != null) {
            try {
                this.f7721a.unregisterReceiver(this.f7719G);
                this.f7719G = null;
            } catch (IllegalArgumentException e) {
                C2538c.m12677c("UpdateVersionActivity", e.getMessage());
            }
        }
    }

    public void m11170a() {
        C2538c.m12677c("UpdateVersionActivity", "Enter showAppVersionISLow");
        if (this.f7721a != null && this.f7718F == null) {
            this.f7718F = new w(this.f7721a).a(i.IDS_update_band_new_version_title2).b(i.IDS_update_band_message_string).a(i.IDS_settings_button_cancal, new C2180n(this)).b(i.IDS_update_new_version_to_upgrade_app, new C2179m(this)).a();
            this.f7718F.setCancelable(true);
            this.f7718F.show();
        }
    }

    private void m11169u() {
        C2538c.m12677c("UpdateVersionActivity", " enterUpdateActivity():");
        Intent intent = new Intent();
        intent.setClass(this.f7721a, AboutActivity.class);
        this.f7721a.startActivity(intent);
    }

    private void m11146c(String str) {
        C2538c.m12677c("UpdateVersionActivity", "showForcedUpdateDialog deviceName:" + str);
        Intent intent = new Intent();
        intent.putExtra("deviceName", str);
        intent.putExtra("isForced", true);
        intent.setClass(this.f7721a, BandUpdateDialogActivity.class);
        this.f7721a.startActivity(intent);
    }
}
