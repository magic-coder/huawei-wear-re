package com.huawei.ui.device.activity.update;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.main.stories.p177a.p178a.C2278b;
import com.sina.weibo.sdk.constant.WBConstants;

public class BandUpdateDialogActivity extends Activity implements OnClickListener {
    private Context f7661a = null;
    private LinearLayout f7662b;
    private LinearLayout f7663c;
    private TextView f7664d;
    private TextView f7665e;
    private TextView f7666f;
    private TextView f7667g;
    private TextView f7668h;
    private TextView f7669i;
    private TextView f7670j;
    private TextView f7671k;
    private TextView f7672l;
    private Button f7673m;
    private Button f7674n;
    private Button f7675o;
    private Button f7676p;
    private ah f7677q;
    private boolean f7678r = false;
    private String f7679s;
    private LinearLayout f7680t;
    private CheckBox f7681u;
    private boolean f7682v = false;
    private C2278b f7683w;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7661a = this;
        C2538c.m12677c("BandUpdateDialogActivity", "onCreate()");
        C2538c.m12677c("BandUpdateDialogActivity", "isForced :" + this.f7678r);
        this.f7677q = ah.m10316a(this.f7661a);
        this.f7683w = new C2278b();
        setContentView(f.activity_app_update_dialog);
        Window window = getWindow();
        window.setGravity(80);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        m11102b();
        m11098a();
    }

    private void m11098a() {
        Intent intent = getIntent();
        this.f7678r = intent.getBooleanExtra("isForced", false);
        if (this.f7678r) {
            this.f7679s = intent.getStringExtra("deviceName");
            C2538c.m12677c("BandUpdateDialogActivity", "deviceName: " + this.f7679s);
            m11099a(this.f7679s);
            return;
        }
        this.f7677q.f6867b = intent.getStringExtra("name");
        this.f7677q.f6868c = c.a(this.f7661a, (long) intent.getIntExtra(UploadFile.SIZE_LABEL, 0));
        this.f7677q.f6869d = this.f7677q.m10324a(intent.getStringExtra(WBConstants.ACTION_LOG_TYPE_MESSAGE));
        this.f7682v = intent.getBooleanExtra("show", false);
        C2538c.m12677c("BandUpdateDialogActivity", "initUpdateMode, mIsShowBox = " + this.f7682v);
        if (this.f7682v) {
            this.f7681u.setChecked(true);
            this.f7680t.setVisibility(0);
        } else {
            this.f7680t.setVisibility(8);
        }
        C2538c.m12677c("BandUpdateDialogActivity", "bandNewVersion:", this.f7677q.f6867b, "size:", this.f7677q.f6868c, "detail:", this.f7677q.f6869d);
        m11101a(this.f7677q.f6867b, this.f7677q.f6868c, this.f7677q.f6869d);
    }

    protected void onResume() {
        C2538c.m12677c("BandUpdateDialogActivity", "onResume()");
        super.onResume();
    }

    public void onBackPressed() {
        super.onBackPressed();
        C2538c.m12677c("BandUpdateDialogActivity", "onBackPressed() isForcedUpdate = " + this.f7678r);
        if (this.f7678r) {
            Intent intent = new Intent();
            intent.setAction(BaseActivity.CLEAN_ACTIVITY);
            if (LocalBroadcastManager.getInstance(this.f7661a) != null) {
                LocalBroadcastManager.getInstance(this.f7661a).sendBroadcast(intent);
            }
        }
        finish();
    }

    protected void onDestroy() {
        C0977d.m3575n(this.f7661a);
        super.onDestroy();
        this.f7661a = null;
        if (this.f7677q != null) {
            C2538c.m12677c("BandUpdateDialogActivity", "ondestroy updateInteractor release");
            this.f7677q.m10352s();
            this.f7677q = null;
        }
        C2538c.m12677c("BandUpdateDialogActivity", "onDestroy()");
    }

    private void m11102b() {
        C2538c.m12677c("BandUpdateDialogActivity", "Enter initView!");
        this.f7662b = (LinearLayout) d.a(this, e.AppUpdateDialog_show_changelog);
        this.f7664d = (TextView) d.a(this, e.AppUpdateDialog_changelog_title);
        this.f7665e = (TextView) d.a(this, e.AppUpdateDialog_changelog_version);
        this.f7666f = (TextView) d.a(this, e.AppUpdateDialog_changelog_version_value);
        this.f7667g = (TextView) d.a(this, e.AppUpdateDialog_changelog_size);
        this.f7668h = (TextView) d.a(this, e.AppUpdateDialog_changelog_size_value);
        this.f7669i = (TextView) d.a(this, e.AppUpdateDialog_changelog_detail);
        this.f7670j = (TextView) d.a(this, e.AppUpdateDialog_changelog_context);
        this.f7673m = (Button) d.a(this, e.AppUpdateDialog_show_left);
        this.f7674n = (Button) d.a(this, e.AppUpdateDialog_show_right);
        this.f7663c = (LinearLayout) d.a(this, e.AppUpdateDialog_notification);
        this.f7672l = (TextView) d.a(this, e.AppUpdateDialog_notification_context);
        this.f7671k = (TextView) d.a(this, e.AppUpdateDialog_notification_title);
        this.f7675o = (Button) d.a(this, e.AppUpdateDialog_notification_left);
        this.f7676p = (Button) d.a(this, e.AppUpdateDialog_notification_right);
        this.f7680t = (LinearLayout) d.a(this, e.AppUpdateDialog_ota_auto_update);
        this.f7681u = (CheckBox) d.a(this, e.AppUpdateDialog_checkbox);
    }

    public void onClick(View view) {
        int id = view.getId();
        C2538c.m12677c("BandUpdateDialogActivity", "onclick :" + id);
        if (id == e.AppUpdateDialog_show_left) {
            C2538c.m12677c("BandUpdateDialogActivity", "user choose not update");
            finish();
        } else if (id == e.AppUpdateDialog_show_right) {
            C2538c.m12677c("BandUpdateDialogActivity", "user choose update");
            C2538c.m12677c("BandUpdateDialogActivity", "WLAN update show is " + this.f7682v);
            if (this.f7682v) {
                C2538c.m12677c("BandUpdateDialogActivity", "user choose update mCheckAutoUpdate isChecked = " + this.f7681u.isChecked());
                this.f7683w.m11720a(this.f7681u.isChecked());
            }
            m11103c();
        } else if (id == e.AppUpdateDialog_notification_left) {
            C2538c.m12677c("BandUpdateDialogActivity", "notification user choose cancel  isForced" + this.f7678r);
            if (this.f7678r) {
                Intent intent = new Intent();
                intent.setAction(BaseActivity.CLEAN_ACTIVITY);
                if (LocalBroadcastManager.getInstance(this.f7661a) != null) {
                    LocalBroadcastManager.getInstance(this.f7661a).sendBroadcast(intent);
                }
            }
            finish();
        } else if (id == e.AppUpdateDialog_notification_right) {
            C2538c.m12677c("BandUpdateDialogActivity", "user choose update--forced");
            m11103c();
        }
    }

    private void m11101a(String str, String str2, String str3) {
        C2538c.m12677c("BandUpdateDialogActivity", "Enter showAppNewVersion");
        this.f7662b.setVisibility(0);
        this.f7663c.setVisibility(8);
        this.f7664d.setText(this.f7661a.getString(i.IDS_ota_update_state_check_new_version));
        this.f7665e.setText(this.f7661a.getString(i.IDS_app_update_version));
        this.f7666f.setText(str);
        this.f7667g.setText(this.f7661a.getString(i.IDS_app_update_size));
        this.f7668h.setText(str2);
        this.f7669i.setText(this.f7661a.getString(i.IDS_app_update_detail));
        this.f7670j.setText(str3);
        this.f7673m.setText(this.f7661a.getString(i.IDS_app_update_later));
        this.f7674n.setText(this.f7661a.getString(i.IDS_app_update_now));
        this.f7673m.setOnClickListener(this);
        this.f7674n.setOnClickListener(this);
    }

    private void m11100a(String str, String str2) {
        C2538c.m12677c("BandUpdateDialogActivity", "showErrorMsg : " + str2);
        this.f7662b.setVisibility(8);
        this.f7663c.setVisibility(0);
        this.f7671k.setText(str);
        this.f7672l.setText(str2);
        this.f7675o.setOnClickListener(this);
        this.f7676p.setOnClickListener(this);
    }

    private void m11099a(String str) {
        this.f7675o.setText(this.f7661a.getString(i.IDS_settings_firmware_upgrade_exit));
        this.f7676p.setText(this.f7661a.getString(i.IDS_update_new_version_ok));
        m11100a(this.f7661a.getString(i.IDS_service_area_notice_title), this.f7661a.getString(i.IDS_ota_force_alert_tip));
    }

    private void m11103c() {
        Intent intent = new Intent();
        intent.setClass(this.f7661a, UpdateVersionActivity.class);
        this.f7661a.startActivity(intent);
        finish();
    }
}
