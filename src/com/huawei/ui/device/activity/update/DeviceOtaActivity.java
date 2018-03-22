package com.huawei.ui.device.activity.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwservicesmgr.C1053k;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.j;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.device.views.device.RoundProgressImageView;

public class DeviceOtaActivity extends BaseActivity implements OnClickListener {
    private static int f7684w = 50;
    private boolean f7685A = true;
    private C1053k f7686B = new C2168b(this);
    private final BroadcastReceiver f7687C = new C2170d(this);
    private Context f7688a = null;
    private RelativeLayout f7689b;
    private TextView f7690c;
    private TextView f7691d;
    private TextView f7692e;
    private LinearLayout f7693f;
    private TextView f7694g;
    private Button f7695h;
    private LinearLayout f7696i;
    private TextView f7697j;
    private TextView f7698k;
    private RelativeLayout f7699l;
    private TextView f7700m;
    private TextView f7701n;
    private LinearLayout f7702o;
    private TextView f7703p;
    private TextView f7704q;
    private ImageView f7705r;
    private ah f7706s;
    private RoundProgressImageView f7707t;
    private BroadcastReceiver f7708u = null;
    private WakeLock f7709v = null;
    private C2171e f7710x;
    private int f7711y = 2;
    private boolean f7712z = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7688a = this;
        C2538c.m12677c("DeviceOtaActivity", "onCreate()");
        this.f7706s = ah.m10316a(this.f7688a);
        this.f7711y = getIntent().getIntExtra("UpdateMode", 3);
        C2538c.m12677c("DeviceOtaActivity", "onCreate() mBandNewVersion = " + this.f7706s.f6867b);
        C2538c.m12677c("DeviceOtaActivity", "onCreate() mBandNewVersionNumSize = " + this.f7706s.f6868c);
        C2538c.m12677c("DeviceOtaActivity", "onCreate() mBandNewFeatureContent = " + this.f7706s.f6869d);
        this.f7710x = new C2171e(this);
        setContentView(f.activity_device_ota);
        m11111b();
        m11122g();
        m11117d();
        m11125j();
    }

    private void m11111b() {
        C2538c.m12677c("DeviceOtaActivity", "Enter initView!");
        this.f7707t = (RoundProgressImageView) d.a(this, e.center_ota_circle);
        this.f7689b = (RelativeLayout) d.a(this, e.rele_percent_ota);
        this.f7690c = (TextView) d.a(this, e.text_percent);
        this.f7691d = (TextView) d.a(this, e.text_per_sign);
        this.f7691d.setText("%");
        this.f7691d.setVisibility(8);
        this.f7692e = (TextView) d.a(this, e.text_circle_tip);
        this.f7693f = (LinearLayout) d.a(this, e.rela_ota_failed);
        this.f7693f.setVisibility(8);
        this.f7694g = (TextView) d.a(this, e.text_ota_failed);
        this.f7699l = (RelativeLayout) d.a(this, e.rela_device_version);
        this.f7700m = (TextView) d.a(this, e.text_device_version_num);
        this.f7700m.setText(this.f7706s.f6867b);
        this.f7701n = (TextView) d.a(this, e.text_device_version_size);
        this.f7701n.setText(this.f7706s.f6868c);
        this.f7696i = (LinearLayout) d.a(this, e.lin_tip);
        this.f7697j = (TextView) d.a(this, e.text_tip);
        this.f7698k = (TextView) d.a(this, e.text_tip_content);
        this.f7698k.setText(String.format(this.f7688a.getString(i.IDS_settings_firmware_upgrade_transfer_details), new Object[]{this.f7706s.f6874i}));
        this.f7705r = (ImageView) d.a(this, e.imageview_line);
        this.f7702o = (LinearLayout) d.a(this, e.lin_new_feature);
        this.f7703p = (TextView) d.a(this, e.text_new_feature);
        this.f7704q = (TextView) d.a(this, e.text_new_feature_content);
        this.f7704q.setText(this.f7706s.f6869d);
        this.f7695h = (Button) d.a(this, e.button);
        this.f7695h.setOnClickListener(this);
        ((CustomTitleBar) d.a(this, e.update_title)).setLeftButtonOnClickListener(new C2167a(this));
        if (this.f7706s.m10354u()) {
            f7684w = 50;
        } else {
            f7684w = 30;
        }
        C2538c.m12677c("DeviceOtaActivity", "battertPercent = " + f7684w);
        m11115c();
    }

    private void m11115c() {
        this.f7689b.setVisibility(0);
        this.f7696i.setVisibility(0);
        this.f7697j.setText(this.f7688a.getString(i.IDS_service_area_notice_title));
        this.f7692e.setText(i.IDS_ota_update_state_upgrading_new);
        this.f7705r.setVisibility(0);
        this.f7702o.setVisibility(0);
        m11112b(0);
        ah ahVar = this.f7706s;
        ah ahVar2 = this.f7706s;
        ahVar.f6876k = 0;
        this.f7695h.getBackground().setAlpha(150);
        this.f7695h.setClickable(false);
        this.f7695h.setTextColor(856530939);
    }

    private void m11112b(int i) {
        C2538c.m12677c("DeviceOtaActivity", "Enter showBandProgress progress = " + i);
        this.f7692e.setText(i.IDS_ota_update_state_upgrading_new);
        this.f7690c.setText(C0956c.m3343a(this.f7688a, "[\\d]", C0956c.m3344a((double) i, 2, 0), j.percent_number_style_num, j.percent_number_style_sign));
        this.f7707t.m11282a((float) i);
    }

    private void m11108a(String str) {
        if (this.f7688a == null) {
            Log.e("LoginActivity", "showOtaErrorMsg() error, contentText = " + str);
            return;
        }
        this.f7712z = true;
        m11112b(0);
        this.f7689b.setVisibility(8);
        this.f7693f.setVisibility(0);
        this.f7697j.setText(i.IDS_settings_firmware_upgrade_talk_band_failed);
        this.f7698k.setText(str);
        ah ahVar = this.f7706s;
        ah ahVar2 = this.f7706s;
        ahVar.f6876k = 0;
        this.f7695h.getBackground().setAlpha(255);
        this.f7695h.setClickable(true);
        this.f7695h.setTextColor(-15884293);
        this.f7695h.setText(i.IDS_retry);
        m11124i();
        this.f7706s.m10335c(Boolean.valueOf(false));
    }

    private void m11117d() {
        DeviceInfo m = this.f7706s.m10346m();
        if (m != null) {
            C2538c.m12677c("DeviceOtaActivity", "deviceInfo = :" + m.toString());
            if (2 == m.getDeviceConnectState()) {
                String h = this.f7706s.m10341h();
                String i = this.f7706s.m10342i();
                C2538c.m12677c("DeviceOtaActivity", "startTransferOtaFile() version = " + h);
                C2538c.m12677c("DeviceOtaActivity", "startTransferOtaFile() updateMode = " + 0);
                C2538c.m12677c("DeviceOtaActivity", "startTransferOtaFile() filePath = " + i);
                ah ahVar = this.f7706s;
                ah ahVar2 = this.f7706s;
                ahVar.f6876k = 11;
                this.f7706s.m10326a(h, 0, i, this.f7686B);
                this.f7712z = false;
                return;
            }
            m11108a(this.f7688a.getString(i.IDS_music_management_disconnection));
        }
    }

    private void m11119e() {
        this.f7705r.setVisibility(8);
        m11112b(100);
        ah ahVar = this.f7706s;
        ah ahVar2 = this.f7706s;
        ahVar.f6876k = 14;
        this.f7695h.getBackground().setAlpha(255);
        this.f7695h.setClickable(true);
        this.f7695h.setTextColor(-15884293);
        this.f7695h.setText(i.IDS_social_clearup_storage_button_finish);
        this.f7692e.setText(i.IDS_settings_firmware_upgrade_band_transfer_finish);
        this.f7698k.setText(String.format(this.f7688a.getString(i.IDS_ota_update_state_finish), new Object[]{this.f7706s.f6874i}));
        if (this.f7710x != null) {
            this.f7710x.removeCallbacksAndMessages(null);
            this.f7710x = null;
        }
        m11123h();
        this.f7706s.m10349p();
        m11124i();
        this.f7706s.m10335c(Boolean.valueOf(true));
    }

    public void onBackPressed() {
        C2538c.m12677c("DeviceOtaActivity", "onBackPressed() status " + this.f7706s.f6876k);
        switch (this.f7706s.f6876k) {
            case 0:
                C2538c.m12677c("DeviceOtaActivity", "onBackPressed() 失败退出 ");
                super.onBackPressed();
                return;
            case 14:
                C2538c.m12677c("DeviceOtaActivity", "onBackPressed() 升级成功退出");
                this.f7706s.m10350q();
                super.onBackPressed();
                return;
            default:
                C2538c.m12677c("DeviceOtaActivity", "onBackPressed 升级过程back键失效 ");
                m11120f();
                return;
        }
    }

    private void m11120f() {
        new w(this.f7688a).a(i.IDS_service_area_notice_title).b(String.format(this.f7688a.getString(i.IDS_settings_firmware_upgrade_transfer_details), new Object[]{this.f7706s.f6874i})).b(i.IDS_common_notification_know_tips, new C2169c(this)).a().show();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f7686B = null;
        try {
            if (this.f7710x != null) {
                this.f7710x.removeCallbacksAndMessages(null);
                this.f7710x = null;
            }
            m11123h();
        } catch (Exception e) {
            C2538c.m12680e("DeviceOtaActivity", "onDestroy Exception", e.getMessage());
        }
        if (this.f7706s != null) {
            C2538c.m12677c("DeviceOtaActivity", "ondestroy updateInteractor release");
            this.f7706s.m10325a(Boolean.valueOf(false));
            this.f7706s.m10352s();
            this.f7706s = null;
        }
        this.f7688a = null;
        C2538c.m12677c("DeviceOtaActivity", "onDestroy()");
        C0977d.m3575n(this.f7688a);
    }

    public void onClick(View view) {
        C2538c.m12677c("DeviceOtaActivity", "onclick ");
        if (view.getId() == e.button) {
            int i = this.f7706s.f6876k;
            ah ahVar = this.f7706s;
            if (i == 0) {
                C2538c.m12677c("DeviceOtaActivity", "STATUS_INITIAL");
                if (this.f7685A) {
                    if (this.f7706s.m10333b(this.f7706s.m10342i())) {
                        C2538c.m12677c("DeviceOtaActivity", "re startTransferOtaFile");
                        m11111b();
                        m11125j();
                        m11117d();
                    } else {
                        C2538c.m12677c("DeviceOtaActivity", "升级文件不存在");
                        finish();
                    }
                } else {
                    m11108a(this.f7688a.getString(i.IDS_device_switch_device_connect_fail));
                    return;
                }
            }
            i = this.f7706s.f6876k;
            ahVar = this.f7706s;
            if (i == 14) {
                C2538c.m12677c("DeviceOtaActivity", "STATUS_OTA_SUCESS");
                this.f7706s.m10350q();
                finish();
                return;
            }
            return;
        }
        C2538c.m12677c("DeviceOtaActivity", "i = " + view.getId());
    }

    private void m11122g() {
        C2538c.m12677c("DeviceOtaActivity", "mFirmwareVersionCallback mDataDeviceInfo updateMode = " + this.f7711y);
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        this.f7708u = this.f7687C;
        this.f7688a.registerReceiver(this.f7687C, intentFilter, C0976c.f1642a, null);
    }

    private void m11123h() {
        if (this.f7708u != null) {
            try {
                unregisterReceiver(this.f7687C);
                this.f7708u = null;
            } catch (IllegalArgumentException e) {
                C2538c.m12677c("DeviceOtaActivity", e.getMessage());
            } catch (RuntimeException e2) {
                C2538c.m12677c("DeviceOtaActivity", e2.getMessage());
            }
        }
    }

    private void m11124i() {
        if (this.f7709v != null && this.f7709v.isHeld()) {
            C2538c.m12677c("DeviceOtaActivity", "upgradeDone, release wacklock.");
            this.f7709v.release();
            this.f7709v = null;
        }
    }

    private void m11125j() {
        if (this.f7709v == null) {
            this.f7709v = ((PowerManager) getSystemService("power")).newWakeLock(1, "DeviceOtaActivity");
            this.f7709v.acquire(600000);
        }
    }
}
