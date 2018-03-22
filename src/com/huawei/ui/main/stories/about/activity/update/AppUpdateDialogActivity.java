package com.huawei.ui.main.stories.about.activity.update;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.application.C0975b;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.main.e;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;
import com.huawei.ui.main.stories.about.p179a.C2279a;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import java.util.Map;

public class AppUpdateDialogActivity extends Activity implements OnClickListener {
    private boolean f8417A = false;
    private boolean f8418B = false;
    private boolean f8419C = false;
    private long f8420D = 0;
    private long f8421E = 0;
    private BroadcastReceiver f8422F = new C2328a(this);
    private Context f8423a = null;
    private ImageView f8424b;
    private ImageView f8425c;
    private AnimationDrawable f8426d;
    private LinearLayout f8427e;
    private LinearLayout f8428f;
    private LinearLayout f8429g;
    private LinearLayout f8430h;
    private TextView f8431i;
    private TextView f8432j;
    private TextView f8433k;
    private TextView f8434l;
    private TextView f8435m;
    private TextView f8436n;
    private TextView f8437o;
    private TextView f8438p;
    private TextView f8439q;
    private TextView f8440r;
    private TextView f8441s;
    private TextView f8442t;
    private Button f8443u;
    private Button f8444v;
    private Button f8445w;
    private Button f8446x;
    private ProgressBar f8447y;
    private C2279a f8448z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8423a = this;
        C2538c.m12677c("AppUpdateDialogActivity", "onCreate()");
        this.f8417A = getIntent().getBooleanExtra("isForced", false);
        C2538c.m12677c("AppUpdateDialogActivity", "isForced :" + this.f8417A);
        this.f8448z = C2279a.m11722a();
        setContentView(g.activity_app_update_dialog);
        Window window = getWindow();
        window.setGravity(80);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        m11863d();
        m11852a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_app_check_new_version_state");
        registerReceiver(this.f8422F, intentFilter, C0976c.f1642a, null);
    }

    private void m11852a() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("name");
        int intExtra = intent.getIntExtra(UploadFile.SIZE_LABEL, 0);
        this.f8420D = (long) intExtra;
        String stringExtra2 = intent.getStringExtra(WBConstants.ACTION_LOG_TYPE_MESSAGE);
        C2538c.m12677c("AppUpdateDialogActivity", "appname:", stringExtra, "appsize", Integer.valueOf(intExtra), WBConstants.ACTION_LOG_TYPE_MESSAGE, stringExtra2);
        if (stringExtra == null || intExtra == 0 || stringExtra2 == null) {
            m11858b();
            m11866g();
            return;
        }
        this.f8418B = true;
        this.f8448z.f8274b = stringExtra;
        this.f8448z.f8275c = c.a(this.f8423a, (long) intExtra);
        this.f8448z.f8276d = this.f8448z.m11726a(stringExtra2);
        m11865f();
    }

    protected void onResume() {
        C2538c.m12677c("AppUpdateDialogActivity", "onResume()");
        super.onResume();
    }

    public void onBackPressed() {
        C2538c.m12677c("AppUpdateDialogActivity", "onBackPressed() isForcedUpdate = " + this.f8417A);
        if (this.f8417A) {
            m11869j();
        } else if (this.f8419C) {
            this.f8446x.setText(this.f8423a.getString(j.IDS_settings_button_cancal));
            this.f8445w.setText(this.f8423a.getString(j.IDS_contact_confirm));
            m11857a(this.f8423a.getString(j.IDS_service_area_notice_title), this.f8423a.getString(j.IDS_ota_update_app_updating_exit));
        } else {
            finish();
        }
    }

    private void m11858b() {
        this.f8427e.setVisibility(0);
        this.f8428f.setVisibility(8);
        this.f8429g.setVisibility(8);
        this.f8430h.setVisibility(8);
        this.f8431i.setText(this.f8423a.getString(j.IDS_app_update_check));
        if (!m11862c()) {
            this.f8424b.setImageResource(e.hw_health_loading);
        }
        this.f8426d = (AnimationDrawable) this.f8424b.getDrawable();
        this.f8426d.start();
    }

    private boolean m11862c() {
        if (C0975b.HEALTH == BaseApplication.m2633c()) {
            C2538c.m12677c("AppUpdateDialogActivity", "包名为com.huawei.health");
            return false;
        }
        C2538c.m12677c("AppUpdateDialogActivity", "包名为com.huawei.bone");
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f8448z.m11731a(false);
        try {
            if (this.f8422F != null) {
                this.f8423a.unregisterReceiver(this.f8422F);
            }
        } catch (Exception e) {
            C2538c.m12680e("AppUpdateDialogActivity", "onDestroy Exception", e.getMessage());
        }
        this.f8423a = null;
        C2538c.m12677c("AppUpdateDialogActivity", "onDestroy()");
        C0977d.m3575n(this.f8423a);
    }

    private void m11863d() {
        C2538c.m12677c("AppUpdateDialogActivity", "Enter initView!");
        this.f8427e = (LinearLayout) d.a(this, f.AppUpdateDialog_check_layout);
        this.f8431i = (TextView) d.a(this, f.AppUpdateDialog_check_textView);
        this.f8424b = (ImageView) d.a(this, f.AppUpdateDialog_check_img);
        this.f8436n = (TextView) d.a(this, f.AppUpdateDialog_changelog_size_value);
        this.f8428f = (LinearLayout) d.a(this, f.AppUpdateDialog_show_changelog);
        this.f8432j = (TextView) d.a(this, f.AppUpdateDialog_changelog_title);
        this.f8433k = (TextView) d.a(this, f.AppUpdateDialog_changelog_version);
        this.f8434l = (TextView) d.a(this, f.AppUpdateDialog_changelog_version_value);
        this.f8435m = (TextView) d.a(this, f.AppUpdateDialog_changelog_size);
        this.f8437o = (TextView) d.a(this, f.AppUpdateDialog_changelog_detail);
        this.f8438p = (TextView) d.a(this, f.AppUpdateDialog_changelog_context);
        this.f8443u = (Button) d.a(this, f.AppUpdateDialog_show_left);
        this.f8444v = (Button) d.a(this, f.AppUpdateDialog_show_right);
        if (m11862c()) {
            this.f8444v.setBackgroundDrawable(getResources().getDrawable(e.app_update_button1));
        }
        this.f8429g = (LinearLayout) d.a(this, f.AppUpdateDialog_progress_layout);
        this.f8439q = (TextView) d.a(this, f.AppUpdateDialog_progress_text);
        this.f8440r = (TextView) d.a(this, f.AppUpdateDialog_progress);
        this.f8447y = (ProgressBar) d.a(this, f.AppUpdateDialog_progressbar);
        this.f8425c = (ImageView) d.a(this, f.AppUpdateDialog_cancel);
        this.f8430h = (LinearLayout) d.a(this, f.AppUpdateDialog_notification);
        this.f8442t = (TextView) d.a(this, f.AppUpdateDialog_notification_context);
        this.f8441s = (TextView) d.a(this, f.AppUpdateDialog_notification_title);
        this.f8445w = (Button) d.a(this, f.AppUpdateDialog_notification_left);
        this.f8446x = (Button) d.a(this, f.AppUpdateDialog_notification_right);
    }

    public void onClick(View view) {
        int id = view.getId();
        C2538c.m12677c("AppUpdateDialogActivity", "onclick :" + id);
        if (id == f.AppUpdateDialog_show_left) {
            C2538c.m12677c("AppUpdateDialogActivity", "user choose not update   isForced" + this.f8417A);
            if (this.f8417A) {
                m11869j();
            } else {
                finish();
            }
        } else if (id == f.AppUpdateDialog_show_right) {
            C2538c.m12677c("AppUpdateDialogActivity", "user choose update");
            m11867h();
            Map hashMap = new HashMap();
            hashMap.put("click", "1");
            com.huawei.l.a.c.a().a(BaseApplication.m2632b(), a.ag.a(), hashMap, 0);
        } else if (id == f.AppUpdateDialog_cancel) {
            C2538c.m12677c("AppUpdateDialogActivity", "user choose cancel update   isForced" + this.f8417A);
            if (this.f8417A) {
                m11869j();
                return;
            }
            this.f8446x.setText(this.f8423a.getString(j.IDS_settings_button_cancal));
            this.f8445w.setText(this.f8423a.getString(j.IDS_contact_confirm));
            m11857a(this.f8423a.getString(j.IDS_service_area_notice_title), this.f8423a.getString(j.IDS_ota_update_app_updating_exit));
        } else if (id == f.AppUpdateDialog_notification_left) {
            C2538c.m12677c("AppUpdateDialogActivity", "notification user choose cancel  isForced" + this.f8417A);
            if (this.f8417A) {
                Intent intent = new Intent();
                intent.setAction("golbal_finish_all_kidwatch_activity");
                LocalBroadcastManager.getInstance(this.f8423a).sendBroadcast(intent);
                intent = new Intent();
                intent.setAction(BaseActivity.CLEAN_ACTIVITY);
                LocalBroadcastManager.getInstance(this.f8423a).sendBroadcast(intent);
            }
            if (this.f8419C) {
                this.f8448z.m11739g();
            }
            finish();
        } else if (id == f.AppUpdateDialog_notification_right) {
            C2538c.m12677c("AppUpdateDialogActivity", "notification user choose continue :" + this.f8418B);
            if (this.f8418B) {
                m11868i();
                com.huawei.l.a.c.a().a(BaseApplication.m2632b(), a.db.a(), new HashMap(), 0);
                return;
            }
            m11858b();
            m11866g();
        }
    }

    private void m11854a(Intent intent) {
        int intExtra = intent.getIntExtra("state", -1);
        int intExtra2 = intent.getIntExtra("result", -1);
        this.f8421E = (long) intExtra2;
        String stringExtra = intent.getStringExtra("content");
        C2538c.m12677c("AppUpdateDialogActivity", "updateAppState: state = " + intExtra + ", result = " + intExtra2);
        switch (intExtra) {
            case 11:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_CHECK_NEW_VERSION_FAILED");
                m11864e();
                stringExtra = "";
                m11859b(intExtra2);
                break;
            case 12:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_CHECK_NEW_VERSION_SUCCESS");
                this.f8418B = true;
                this.f8448z.f8273a = intExtra2;
                this.f8421E = (long) intExtra2;
                this.f8448z.f8275c = c.a(this.f8423a, (long) intExtra2);
                this.f8448z.f8274b = stringExtra;
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_CHECK_NEW_VERSION_SUCCESS: mAppNewVersion = " + this.f8448z.f8274b);
                this.f8448z.m11728a(this.f8423a, Boolean.valueOf(true));
                this.f8417A = intent.getBooleanExtra("isForced", false);
                C2538c.m12677c("AppUpdateDialogActivity", "check success!  isForced :" + this.f8417A);
                break;
            case 31:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_FETCH_CHANGELOG_FAILED");
                this.f8418B = false;
                m11864e();
                m11856a(this.f8423a.getString(j.IDS_update_get_changelog_failed));
                break;
            case 32:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_FETCH_CHANGELOG_SUCCESS:");
                this.f8448z.f8276d = this.f8448z.m11726a(stringExtra);
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_CHECK_NEW_VERSION_SUCCESS: mAppNewFeatureContent = " + this.f8448z.f8276d);
                m11864e();
                m11865f();
                break;
        }
        switch (intExtra) {
            case 20:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_DOWNLOAD_APP_START");
                m11861c(0);
                this.f8419C = true;
                return;
            case 21:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_DOWNLOAD_APP_PROGRESS");
                m11861c(intExtra2);
                return;
            case 22:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_DOWNLOAD_APP_FAILED: result = " + intExtra2);
                m11853a(intExtra2);
                this.f8419C = false;
                return;
            case 23:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_DOWNLOAD_APP_SUCCESS");
                this.f8419C = false;
                this.f8448z.m11727a(this.f8423a);
                return;
            case 27:
                C2538c.m12677c("AppUpdateDialogActivity", "app package isSameApkSignatures ");
                finish();
                this.f8448z.m11730a(Boolean.valueOf(true));
                return;
            case 40:
                C2538c.m12677c("AppUpdateDialogActivity", "STATE_INSTALL_APP_FAILED: result=" + intExtra2);
                if (47 == intExtra2) {
                    m11856a(this.f8423a.getString(j.IDS_update_install_failed));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m11853a(int i) {
        switch (i) {
            case 1:
                m11856a(this.f8423a.getString(j.IDS_update_download_check_failed));
                return;
            case 3:
                m11856a(this.f8423a.getString(j.IDS_update_network_error));
                return;
            case 4:
                m11860b(this.f8423a.getString(j.IDS_settings_firmware_upgrade_phone_low_battery));
                return;
            default:
                m11856a(this.f8423a.getString(j.IDS_update_download_failed));
                return;
        }
    }

    private void m11859b(int i) {
        if (i == 0) {
            C2538c.m12677c("AppUpdateDialogActivity", "No New Version");
            com.huawei.ui.commonui.c.a.b(getApplicationContext(), this.f8423a.getString(j.IDS_settings_app_update_new));
            this.f8448z.m11742j();
            finish();
        } else if (1 == i) {
            m11856a(this.f8423a.getResources().getString(j.IDS_update_network_error));
        } else {
            String string;
            if (2 == i) {
                string = this.f8423a.getResources().getString(j.IDS_update_server_error);
            } else {
                string = this.f8423a.getResources().getString(j.IDS_update_unknown_error);
            }
            m11856a(string);
        }
    }

    private void m11864e() {
        if (this.f8426d != null) {
            this.f8426d.stop();
            return;
        }
        C2538c.m12674b("AppUpdateDialogActivity", "anim is null");
    }

    private void m11865f() {
        C2538c.m12677c("AppUpdateDialogActivity", "Enter showAppNewVersion");
        this.f8427e.setVisibility(8);
        this.f8429g.setVisibility(8);
        this.f8428f.setVisibility(0);
        this.f8430h.setVisibility(8);
        this.f8432j.setText(this.f8423a.getString(j.IDS_ota_update_state_check_new_version));
        this.f8433k.setText(this.f8423a.getString(j.IDS_app_update_version));
        this.f8434l.setText(this.f8448z.f8274b);
        this.f8435m.setText(this.f8423a.getString(j.IDS_app_update_size));
        this.f8436n.setText(this.f8448z.f8275c);
        this.f8437o.setText(this.f8423a.getString(j.IDS_app_update_detail));
        this.f8438p.setText(this.f8448z.f8276d);
        this.f8443u.setText(this.f8423a.getString(j.IDS_app_update_later));
        this.f8444v.setText(this.f8423a.getString(j.IDS_app_update_now));
        this.f8444v.setTextColor(getResources().getColor(com.huawei.ui.main.c.startup_white));
        this.f8443u.setOnClickListener(this);
        this.f8444v.setOnClickListener(this);
    }

    private void m11861c(int i) {
        C2538c.m12677c("AppUpdateDialogActivity", "Enter showAppDownloadProgress progress = " + i);
        this.f8440r.setText(String.valueOf(i) + "%");
        this.f8447y.setProgress(i);
    }

    private void m11856a(String str) {
        this.f8445w.setText(this.f8423a.getString(j.IDS_settings_button_cancal));
        this.f8446x.setText(this.f8423a.getString(j.IDS_retry));
        m11857a(this.f8423a.getString(j.IDS_settings_firmware_upgrade_talk_band_failed), str);
        this.f8448z.m11730a(Boolean.valueOf(false));
    }

    private void m11857a(String str, String str2) {
        C2538c.m12677c("AppUpdateDialogActivity", "showErrorMsg : " + str2);
        this.f8427e.setVisibility(8);
        this.f8429g.setVisibility(8);
        this.f8428f.setVisibility(8);
        this.f8430h.setVisibility(0);
        this.f8441s.setText(str);
        this.f8442t.setText(str2);
        this.f8445w.setOnClickListener(this);
        this.f8446x.setOnClickListener(this);
    }

    private void m11866g() {
        C2538c.m12677c("AppUpdateDialogActivity", "doCheckAppNewVersion");
        this.f8448z.m11735c();
    }

    private void m11867h() {
        C2538c.m12677c("AppUpdateDialogActivity", "handleAppNewVersionOK");
        this.f8448z.m11742j();
        C2538c.m12677c("AppUpdateDialogActivity", "handleAppNewVersionOK: mAppUpdateInteractor.appNewVersionNumSize = " + this.f8448z.f8273a);
        C2538c.m12677c("AppUpdateDialogActivity", "handleAppNewVersionOK: checkMemory = " + this.f8448z.m11732a((long) this.f8448z.f8273a));
        if (this.f8448z.m11732a((long) this.f8448z.f8273a)) {
            C2538c.m12677c("AppUpdateDialogActivity", "handleAppNewVersionOK: wifiConnected = " + this.f8448z.m11740h());
            if (this.f8448z.m11740h()) {
                m11868i();
                return;
            } else if (this.f8448z.m11741i()) {
                this.f8445w.setText(this.f8423a.getString(j.IDS_settings_button_cancal));
                this.f8446x.setText(this.f8423a.getString(j.IDS_apphelp_pwindows_continue_button));
                m11857a(this.f8423a.getString(j.IDS_service_area_notice_title), this.f8423a.getString(j.IDS_ota_update_is_roaming));
                return;
            } else {
                m11868i();
                return;
            }
        }
        m11856a(this.f8423a.getString(j.IDS_update_low_memory));
    }

    private void m11868i() {
        C2538c.m12677c("AppUpdateDialogActivity", "doDownloadAppFile  isDownloading: " + this.f8419C);
        this.f8427e.setVisibility(8);
        this.f8429g.setVisibility(0);
        this.f8428f.setVisibility(8);
        this.f8430h.setVisibility(8);
        this.f8439q.setText(this.f8423a.getString(j.IDS_app_update_updating));
        this.f8425c.setOnClickListener(this);
        if (!this.f8419C) {
            this.f8448z.m11737e();
        }
    }

    private void m11869j() {
        this.f8445w.setText(this.f8423a.getString(j.IDS_settings_firmware_upgrade_exit));
        this.f8446x.setText(this.f8423a.getString(j.IDS_update_new_version_ok));
        m11857a(this.f8423a.getString(j.IDS_service_area_notice_title), this.f8423a.getString(j.IDS_ota_force_alert_tip_app));
    }

    private void m11860b(String str) {
        this.f8445w.setText(this.f8423a.getString(j.IDS_common_notification_know_tips));
        this.f8446x.setVisibility(8);
        m11857a(this.f8423a.getString(j.IDS_service_area_notice_title), str);
    }
}
