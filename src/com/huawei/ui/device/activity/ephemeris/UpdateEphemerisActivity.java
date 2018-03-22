package com.huawei.ui.device.activity.ephemeris;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.views.device.RoundProgressImageView;

public class UpdateEphemerisActivity extends BaseActivity implements OnClickListener {
    private int f7200A = -1;
    private int f7201B = 0;
    private final BroadcastReceiver f7202C = new C2059c(this);
    private int f7203a = 38208;
    private Handler f7204b = new Handler();
    private Context f7205c = null;
    private CustomTitleBar f7206d;
    private ImageView f7207e;
    private RelativeLayout f7208f;
    private TextView f7209g;
    private TextView f7210h;
    private TextView f7211i;
    private LinearLayout f7212j;
    private Button f7213k;
    private TextView f7214l;
    private LinearLayout f7215m;
    private TextView f7216n;
    private TextView f7217o;
    private ImageView f7218p;
    private RelativeLayout f7219q;
    private TextView f7220r;
    private TextView f7221s;
    private TextView f7222t;
    private LinearLayout f7223u;
    private TextView f7224v;
    private ImageView f7225w;
    private TextView f7226x;
    private RoundProgressImageView f7227y;
    private C1988p f7228z = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.m12677c("UpdateEphemerisActivity", "onCreate() eph");
        this.f7205c = this;
        this.f7200A = -1;
        setContentView(f.activity_update_ephemeris);
        m10713b();
        m10706a();
    }

    private void m10706a() {
        C2538c.m12677c("UpdateEphemerisActivity", "enter eph initUpdate()  ");
        this.f7228z = C1988p.m10381a(BaseApplication.m2632b());
        m10727h();
        this.f7201B = 0;
    }

    protected void onResume() {
        C2538c.m12677c("UpdateEphemerisActivity", "onResume()");
        super.onResume();
    }

    protected void onDestroy() {
        if (this.f7204b != null) {
            this.f7204b.removeCallbacksAndMessages(null);
        }
        C0977d.m3575n(this.f7205c);
        super.onDestroy();
        m10730k();
        this.f7205c = null;
        C2538c.m12677c("UpdateEphemerisActivity", "eph onDestroy()");
    }

    private void m10713b() {
        C2538c.m12677c("UpdateEphemerisActivity", "Enter eph initView!");
        this.f7227y = (RoundProgressImageView) d.a(this, e.center_ota_download);
        this.f7227y.setVisibility(0);
        this.f7206d = (CustomTitleBar) d.a(this, e.update_title);
        this.f7207e = (ImageView) d.a(this, e.image_check_logo);
        this.f7208f = (RelativeLayout) d.a(this, e.rele_circle_download);
        this.f7208f.setVisibility(8);
        this.f7209g = (TextView) d.a(this, e.text_percent);
        this.f7209g.setVisibility(8);
        this.f7210h = (TextView) d.a(this, e.text_per_sign);
        this.f7210h.setText("%");
        this.f7210h.setVisibility(8);
        this.f7211i = (TextView) d.a(this, e.text_circle_tip);
        this.f7212j = (LinearLayout) d.a(this, e.rela_failed);
        this.f7225w = (ImageView) d.a(this, e.ic_update_icon);
        this.f7226x = (TextView) d.a(this, e.iv_update_message);
        this.f7213k = (Button) d.a(this, e.button);
        this.f7213k.setOnClickListener(this);
        this.f7213k.setClickable(true);
        this.f7214l = (TextView) d.a(this, e.text_new_version_tip);
        this.f7214l.setVisibility(4);
        this.f7215m = (LinearLayout) d.a(this, e.lin_tip);
        this.f7215m.setVisibility(8);
        this.f7216n = (TextView) d.a(this, e.text_tip);
        this.f7217o = (TextView) d.a(this, e.text_tip_content);
        this.f7224v = (TextView) d.a(this, e.text_new_feature_content);
        this.f7223u = (LinearLayout) d.a(this, e.lin_new_feature);
        this.f7223u.setVisibility(0);
        this.f7218p = (ImageView) d.a(this, e.imageview_line);
        this.f7218p.setVisibility(8);
        this.f7219q = (RelativeLayout) d.a(this, e.rela_device_version);
        this.f7219q.setVisibility(8);
        this.f7220r = (TextView) d.a(this, e.text_device_version);
        this.f7220r.setVisibility(8);
        this.f7221s = (TextView) d.a(this, e.text_device_version_num);
        this.f7222t = (TextView) d.a(this, e.text_device_version_size);
        this.f7206d.setTitleText(this.f7205c.getResources().getString(i.IDS_mphmemris_memu_update_title));
        this.f7206d.setLeftButtonOnClickListener(new C2057a(this));
        this.f7224v.setText(getResources().getString(i.IDS_mphmemris_update_instruction_content_one_part) + "\n" + getResources().getString(i.IDS_mphmemris_update_instruction_content_two_part));
        this.f7224v.setVisibility(0);
    }

    public void onClick(View view) {
        C2538c.m12677c("UpdateEphemerisActivity", "eph onclick  !!!");
        if (view.getId() == e.button) {
            switch (this.f7200A) {
                case -1:
                case 4:
                    if (!C0977d.m3555e(getApplicationContext())) {
                        a.a(BaseApplication.m2632b(), i.IDS_confirm_network_whether_connected);
                        return;
                    } else if (this.f7228z == null || 2 != this.f7228z.m10396d()) {
                        a.a(BaseApplication.m2632b(), i.IDS_connect_device_fail);
                        return;
                    } else {
                        m10716b("com.huawei.bone.ephemeris.checkUpdate");
                        m10717c();
                        return;
                    }
                case 5:
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    private void m10717c() {
        C2538c.m12677c("UpdateEphemerisActivity", "Enter eph initViewForCheck! ");
        this.f7200A = 1;
        C2538c.m12677c("UpdateEphemerisActivity", "initViewForCheck change mCurState = " + this.f7200A);
        this.f7227y.m11281a();
        this.f7207e.setVisibility(8);
        this.f7219q.setVisibility(8);
        this.f7212j.setVisibility(8);
        this.f7215m.setVisibility(8);
        this.f7218p.setVisibility(8);
        this.f7214l.setVisibility(4);
        this.f7208f.setVisibility(0);
        this.f7211i.setVisibility(0);
        this.f7211i.setText(i.IDS_app_location_update_downloading);
        this.f7213k.getBackground().setAlpha(150);
        this.f7213k.setClickable(false);
        this.f7213k.setText(i.IDS_device_manager_update_health);
        this.f7213k.setTextColor(856530939);
        if (this.f7204b != null) {
            this.f7204b.postDelayed(new C2058b(this), 12000);
        }
    }

    private void m10719d() {
        C2538c.m12677c("UpdateEphemerisActivity", "Enter eph initViewForNoVersion! ");
        this.f7200A = -1;
        C2538c.m12677c("UpdateEphemerisActivity", "initViewForNoVersion change mCurState = " + this.f7200A);
        if (this.f7204b != null) {
            this.f7204b.removeCallbacksAndMessages(null);
        }
        this.f7227y.m11284c();
        this.f7207e.setVisibility(8);
        this.f7212j.setVisibility(8);
        this.f7215m.setVisibility(8);
        this.f7218p.setVisibility(8);
        this.f7219q.setVisibility(8);
        this.f7214l.setVisibility(0);
        this.f7214l.setText(i.IDS_settings_app_update_new);
        this.f7208f.setVisibility(0);
        this.f7211i.setText(i.IDS_ota_update_state_no_new_version);
        this.f7211i.setVisibility(0);
        this.f7213k.getBackground().setAlpha(255);
        this.f7213k.setClickable(true);
        this.f7213k.setTextColor(-15884293);
        this.f7213k.setText(i.IDS_retry);
    }

    private void m10722e() {
        C2538c.m12677c("UpdateEphemerisActivity", "Enter eph showNewVersionUpdate ! mEphInfoSize = " + this.f7203a);
        this.f7200A = 3;
        if (!this.f7227y.m11283b()) {
            this.f7227y.m11281a();
        }
        this.f7201B = 0;
        this.f7212j.setVisibility(8);
        this.f7214l.setVisibility(4);
        this.f7208f.setVisibility(0);
        this.f7211i.setText(i.IDS_app_update_updating);
        this.f7211i.setVisibility(0);
        this.f7215m.setVisibility(0);
        this.f7216n.setText(this.f7205c.getString(i.IDS_health_start_note));
        this.f7217o.setText(String.format(this.f7205c.getString(i.IDS_settings_firmware_upgrade_transfer_details), new Object[]{this.f7205c.getString(i.IDS_device_wearable_device)}));
        this.f7218p.setVisibility(0);
        this.f7219q.setVisibility(0);
        this.f7221s.setText(i.IDS_app_update_size);
        if (this.f7203a <= 0) {
            this.f7203a = 38208;
        }
        this.f7222t.setText(c.a(this.f7205c, (long) this.f7203a));
        this.f7222t.setVisibility(0);
        this.f7213k.getBackground().setAlpha(150);
        this.f7213k.setClickable(false);
        this.f7213k.setText(i.IDS_device_manager_update_health);
        this.f7213k.setTextColor(856530939);
    }

    private void m10723f() {
        C2538c.m12677c("UpdateEphemerisActivity", "Enter eph showUpdateSuccess !");
        this.f7200A = 5;
        C2538c.m12677c("UpdateEphemerisActivity", "showUpdateSuccess change mCurState = " + this.f7200A);
        if (this.f7204b != null) {
            this.f7204b.removeCallbacksAndMessages(null);
        }
        this.f7201B = 0;
        this.f7227y.m11284c();
        this.f7207e.setVisibility(8);
        this.f7215m.setVisibility(8);
        this.f7218p.setVisibility(8);
        this.f7208f.setVisibility(8);
        this.f7219q.setVisibility(8);
        this.f7214l.setVisibility(4);
        this.f7211i.setVisibility(8);
        this.f7211i.setText(i.IDS_mphmemris_update_success);
        this.f7212j.setVisibility(0);
        this.f7225w.setImageResource(g.ic_update_successful);
        this.f7226x.setText(i.IDS_mphmemris_update_success);
        this.f7213k.getBackground().setAlpha(255);
        this.f7213k.setClickable(true);
        this.f7213k.setTextColor(-15884293);
        this.f7213k.setText(i.IDS_install_finish);
    }

    private void m10711a(String str) {
        C2538c.m12677c("UpdateEphemerisActivity", "eph showErrorMsg(): tipText = " + str);
        this.f7200A = 4;
        C2538c.m12677c("UpdateEphemerisActivity", "showErrorMsg change mCurState = " + this.f7200A);
        if (this.f7204b != null) {
            this.f7204b.removeCallbacksAndMessages(null);
        }
        this.f7201B = 0;
        this.f7227y.m11284c();
        this.f7207e.setVisibility(8);
        this.f7208f.setVisibility(8);
        this.f7214l.setVisibility(4);
        this.f7219q.setVisibility(0);
        this.f7212j.setVisibility(0);
        this.f7225w.setImageResource(g.ic_update_failed);
        this.f7226x.setText(i.IDS_mphmemris_update_fail);
        this.f7215m.setVisibility(0);
        this.f7216n.setText(this.f7205c.getString(i.IDS_mphmemris_update_fail));
        this.f7217o.setText(str);
        this.f7218p.setVisibility(0);
        this.f7213k.getBackground().setAlpha(255);
        this.f7213k.setClickable(true);
        this.f7213k.setTextColor(-15884293);
        this.f7213k.setText(this.f7205c.getText(i.IDS_retry));
    }

    private void m10725g() {
        C2538c.m12677c("UpdateEphemerisActivity", "eph showErrorUINoMsg");
        this.f7200A = 4;
        C2538c.m12677c("UpdateEphemerisActivity", "showErrorUINoMsg change mCurState = " + this.f7200A);
        if (this.f7204b != null) {
            this.f7204b.removeCallbacksAndMessages(null);
        }
        this.f7201B = 0;
        this.f7227y.m11284c();
        this.f7207e.setVisibility(8);
        this.f7208f.setVisibility(8);
        this.f7218p.setVisibility(8);
        this.f7215m.setVisibility(8);
        this.f7214l.setVisibility(4);
        this.f7219q.setVisibility(8);
        this.f7216n.setText(this.f7205c.getString(i.IDS_mphmemris_update_fail));
        this.f7212j.setVisibility(0);
        this.f7225w.setImageResource(g.ic_update_failed);
        this.f7226x.setText(i.IDS_mphmemris_update_fail);
        this.f7213k.getBackground().setAlpha(255);
        this.f7213k.setClickable(true);
        this.f7213k.setTextColor(-15884293);
        this.f7213k.setText(this.f7205c.getText(i.IDS_retry));
    }

    private void m10727h() {
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.ephemeris.currentState.updating");
        intentFilter.addAction("com.huawei.bone.ephemeris.currentState.update.sucess");
        intentFilter.addAction("com.huawei.bone.ephemeris.currentState.update.fail");
        this.f7205c.registerReceiver(this.f7202C, intentFilter, C0976c.f1642a, null);
    }

    private void m10707a(Intent intent) {
        Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
        if (parcelableExtra != null) {
            if (parcelableExtra instanceof DeviceInfo) {
                DeviceInfo deviceInfo;
                try {
                    deviceInfo = (DeviceInfo) parcelableExtra;
                } catch (ClassCastException e) {
                    C2538c.m12677c("UpdateEphemerisActivity", "eph ClassCastException e.getmessage:" + e.getMessage());
                    deviceInfo = null;
                }
                if (deviceInfo == null) {
                    C2538c.m12677c("UpdateEphemerisActivity", "eph deviceInfo is null return");
                    return;
                }
                C2538c.m12677c("UpdateEphemerisActivity", "eph mLocalStateChangedReceiver(): state = " + deviceInfo.getDeviceConnectState() + ",deviceInfo = " + deviceInfo.toString());
                switch (deviceInfo.getDeviceConnectState()) {
                    case 2:
                        return;
                    case 3:
                        if (3 == this.f7200A) {
                            m10711a(this.f7205c.getString(i.IDS_music_management_disconnection));
                            return;
                        }
                        return;
                    case 4:
                        if (3 == this.f7200A) {
                            m10711a(this.f7205c.getString(i.IDS_device_switch_device_connect_fail));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            C2538c.m12677c("UpdateEphemerisActivity", "eph parcelableExtra instanceof DeviceInfo !");
        }
    }

    private void m10728i() {
        C2538c.m12677c("UpdateEphemerisActivity", "eph delayTensShowSuccessUI ");
        if (3 == this.f7200A) {
            if (this.f7204b != null) {
                this.f7204b.removeCallbacksAndMessages(null);
            }
            this.f7201B = 1;
            if (this.f7204b != null) {
                this.f7204b.postDelayed(new C2060d(this), 10000);
            }
        }
    }

    private void m10729j() {
        C2538c.m12677c("UpdateEphemerisActivity", "eph delayFivesShowSuccessUI ");
        if (3 == this.f7200A) {
            if (this.f7204b != null) {
                this.f7204b.removeCallbacksAndMessages(null);
            }
            this.f7201B = 0;
            if (this.f7204b != null) {
                this.f7204b.postDelayed(new C2061e(this), 5000);
            }
        }
    }

    private void m10714b(Intent intent) {
        C2538c.m12677c("UpdateEphemerisActivity", "Enter processBroadcastActionUpdating mCurState = " + this.f7200A);
        if (1 == this.f7200A || 3 == this.f7200A) {
            if (this.f7204b != null) {
                this.f7204b.removeCallbacksAndMessages(null);
                this.f7204b.postDelayed(new C2062f(this), 120000);
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                this.f7203a = extras.getInt("key_eph_info_size", 38208);
            }
            this.f7200A = 3;
            C2538c.m12677c("UpdateEphemerisActivity", "processBroadcastActionUpdating change mCurState = " + this.f7200A);
            m10722e();
            return;
        }
        C2538c.m12677c("UpdateEphemerisActivity", "processBroadcastActionUpdating return !!!");
    }

    private void m10730k() {
        if (this.f7202C != null) {
            try {
                this.f7205c.unregisterReceiver(this.f7202C);
            } catch (IllegalArgumentException e) {
                C2538c.m12677c("UpdateEphemerisActivity", e.getMessage());
            } catch (RuntimeException e2) {
                C2538c.m12677c("UpdateEphemerisActivity", e2.getMessage());
            }
        }
    }

    private void m10716b(String str) {
        C2538c.m12677c("UpdateEphemerisActivity", "eph sendBroadcastUpdateState intentAction = " + str);
        Context b = BaseApplication.m2632b();
        if (b != null) {
            b.sendBroadcast(new Intent(str), C0976c.f1642a);
        }
    }
}
