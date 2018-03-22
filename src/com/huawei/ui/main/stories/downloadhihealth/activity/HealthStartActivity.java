package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.c;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwcommonmodel.p064d.C4725b;
import com.huawei.hwcommonmodel.p064d.p406a.C4718b;
import com.huawei.hwcommonmodel.p064d.p406a.C4719c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.ui.commonui.dialog.C6027z;
import com.huawei.ui.commonui.dialog.ab;
import com.huawei.ui.commonui.p513c.C5995a;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.ui.commonui.p514d.C6000d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.main.C6097c;
import com.huawei.ui.main.C6100f;
import com.huawei.ui.main.C6101g;
import com.huawei.ui.main.C6102h;
import com.huawei.ui.main.C6104j;
import com.huawei.ui.main.C6105k;
import com.huawei.ui.main.stories.about.a.a;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import net.sqlcipher.database.SQLiteDatabase;

public class HealthStartActivity extends BaseActivity implements OnRequestPermissionsResultCallback, OnClickListener {
    private static String[] f21078J = new String[]{"android.permission.READ_PHONE_STATE"};
    private static boolean f21079a = true;
    private static boolean f21080b = false;
    private TextView f21081A;
    private boolean f21082B = false;
    private C6027z f21083C;
    private C6022u f21084D;
    private C6022u f21085E;
    private boolean f21086F = false;
    private Handler f21087G = new h(this, this);
    private int f21088H = -1;
    private int f21089I = -1;
    private C4719c f21090K = new a(this);
    private BroadcastReceiver f21091L = new c(this);
    private Context f21092c;
    private TextView f21093d = null;
    private Button f21094e = null;
    private boolean f21095f = false;
    private boolean f21096g = false;
    private CustomTitleBar f21097h;
    private boolean f21098i = false;
    private C6002a f21099j;
    private ImageView f21100k;
    private LinearLayout f21101l;
    private TextView f21102m;
    private TextView f21103n;
    private ProgressBar f21104o;
    private a f21105p;
    private RelativeLayout f21106q;
    private TextView f21107r;
    private TextView f21108s;
    private LinearLayout f21109t;
    private RelativeLayout f21110u;
    private RelativeLayout f21111v;
    private RelativeLayout f21112w;
    private ImageView f21113x;
    private AnimationDrawable f21114y;
    private ImageView f21115z;

    protected void onCreate(Bundle bundle) {
        new com.huawei.ui.main.stories.guide.a.a(BaseApplication.b()).e(true);
        super.onCreate(bundle);
        setContentView(C6101g.activity_health_start);
        this.f21092c = BaseApplication.b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_app_check_new_version_state");
        registerReceiver(this.f21091L, intentFilter, c.a, null);
        m27830b();
    }

    private void m27824a() {
        if (!this.f21086F) {
            C2538c.c("HealthStartActivity", new Object[]{"requestPermissions() hasPermissionNeeded =" + C4725b.m22616a(this.f21092c, f21078J) + " mAppUpdateInteractor = " + this.f21105p});
            if (this.f21105p == null) {
                this.f21105p = a.a();
            }
            if (r0) {
                C2538c.c("HealthStartActivity", new Object[]{"requestPermissions() PERMISSIONS_NEEDED if (!hasPermissionNeeded) ELSE"});
                this.f21105p.d();
                return;
            }
            C4725b.m22614a((Activity) this, f21078J, this.f21090K);
            this.f21086F = true;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.f21105p == null) {
            this.f21105p = a.a();
        }
        this.f21105p.d();
        C4718b.m22594a().m22602a(strArr, iArr);
    }

    private void m27830b() {
        this.f21106q = (RelativeLayout) findViewById(C6100f.health_start_rl);
        this.f21107r = (TextView) findViewById(C6100f.health_start_rl_tv);
        this.f21108s = (TextView) findViewById(C6100f.health_start_r1_11_tv);
        this.f21109t = (LinearLayout) findViewById(C6100f.health_start_rl_ll);
        this.f21081A = (TextView) findViewById(C6100f.health_start_guide_describe_note);
        this.f21115z = (ImageView) findViewById(C6100f.health_start_r1_11_img);
        if (C5999c.m27456e(this)) {
            this.f21115z.setBackgroundResource(C6102h.ic_tip_left);
            this.f21108s.setGravity(3);
        }
        this.f21110u = (RelativeLayout) findViewById(C6100f.health_start_info_rl);
        this.f21111v = (RelativeLayout) findViewById(C6100f.install_successful);
        this.f21112w = (RelativeLayout) findViewById(C6100f.health_start_rl_connect);
        this.f21113x = (ImageView) findViewById(C6100f.health_start_rl_connect_iv);
        this.f21114y = (AnimationDrawable) this.f21113x.getDrawable();
        this.f21081A.setText(getResources().getString(C6104j.IDS_health_start_note) + HwAccountConstants.BLANK + getResources().getString(C6104j.IDS_main_install_health_tip));
        this.f21106q.setOnClickListener(this);
        this.f21109t.setOnClickListener(this);
        this.f21095f = getIntent().getBooleanExtra("is_frome_device_pair_guide_activity_to_enter", false);
        this.f21096g = getIntent().getBooleanExtra("is_frome_update_hihealth_activity_to_enter", false);
        C2538c.c("HealthStartActivity", new Object[]{"onCreate isFromDevicePairToEnter = " + this.f21095f});
        this.f21088H = getIntent().getIntExtra("action_need_download_new_health_app", -1);
        this.f21093d = (TextView) findViewById(C6100f.health_start_button1);
        this.f21093d.setText(getResources().getString(C6104j.IDS_device_open_health_skip).toUpperCase());
        this.f21093d.setOnClickListener(this);
        this.f21094e = (Button) findViewById(C6100f.health_start_button2);
        this.f21094e.setOnClickListener(this);
        if (this.f21095f) {
            this.f21093d.setVisibility(0);
            this.f21106q.setVisibility(8);
            m27833b(false);
            if (d.j(this.f21092c)) {
                this.f21094e.setText(C6104j.IDS_device_manager_update_health);
            } else {
                this.f21094e.setText(C6104j.IDS_device_install_health);
            }
        } else {
            this.f21093d.setVisibility(4);
            PackageInfo k = d.k(this.f21092c);
            this.f21106q.setVisibility(8);
            m27833b(false);
            if (k != null) {
                this.f21089I = k.versionCode;
                C2538c.c("HealthStartActivity", new Object[]{"initView() CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode});
                if (20100000 > k.versionCode || m27849o()) {
                    C2538c.c("HealthStartActivity", new Object[]{"show update health"});
                    this.f21094e.setText(C6104j.IDS_device_manager_update_health);
                } else {
                    C2538c.c("HealthStartActivity", new Object[]{"show open health"});
                    this.f21094e.setText(C6104j.IDS_device_open_health);
                }
            } else {
                this.f21094e.setText(C6104j.IDS_device_install_health);
            }
        }
        this.f21097h = (CustomTitleBar) C6000d.m27460a((Activity) this, C6100f.health_start_title_bar);
        m27835c();
    }

    private void m27835c() {
        if (this.f21095f) {
            this.f21097h.setLeftButtonVisibility(8);
            this.f21098i = true;
            return;
        }
        this.f21097h.setLeftButtonVisibility(0);
        this.f21098i = false;
        this.f21097h.setLeftButtonOnClickListener(new b(this));
    }

    public void onClick(View view) {
        int id = view.getId();
        C2538c.c("HealthStartActivity", new Object[]{"onClick id = " + id});
        if (id == C6100f.health_start_button1) {
            C2538c.c("HealthStartActivity", new Object[]{"health_start_button1 Enter gotoMain "});
            m27847m();
        } else if (id == C6100f.health_start_button2) {
            m27840f();
        } else if (id == C6100f.health_start_rl) {
            m27839e();
        } else if (id == C6100f.health_start_rl_ll) {
            m27837d();
        } else if (id == C6100f.AppUpdateDialog_cancel) {
            m27846l();
        }
    }

    private void m27837d() {
        Intent intent;
        if (VERSION.SDK_INT > 10) {
            intent = new Intent("android.settings.WIFI_SETTINGS");
        } else {
            intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
        }
        startActivity(intent);
    }

    private void m27839e() {
        this.f21106q.setVisibility(8);
        if (d.e(this.f21092c)) {
            this.f21106q.setVisibility(4);
            m27833b(true);
            if (f21079a) {
                Message obtainMessage = this.f21087G.obtainMessage();
                obtainMessage.what = 1;
                Intent intent = new Intent();
                intent.putExtra("state", 12);
                intent.putExtra("result", 0);
                obtainMessage.obj = intent;
                this.f21087G.sendMessage(obtainMessage);
                return;
            }
            m27824a();
            return;
        }
        this.f21106q.setVisibility(0);
        m27833b(false);
        this.f21107r.setText(getResources().getString(C6104j.IDS_health_start_net_not_connect));
        this.f21109t.setVisibility(0);
        m27827a(false);
        this.f21082B = false;
    }

    private void m27840f() {
        this.f21106q.setVisibility(8);
        m27833b(false);
        PackageInfo k = d.k(this.f21092c);
        if (k != null) {
            if (20100000 <= k.versionCode && !m27849o()) {
                C2538c.c("HealthStartActivity", new Object[]{"health_start_button2 Enter gotoMain "});
                C2538c.c("HealthStartActivity", new Object[]{"Enter gotoMain "});
                m27847m();
            } else if (!d.e(this.f21092c)) {
                if (this.f21083C != null) {
                    this.f21083C.cancel();
                }
                this.f21106q.setVisibility(0);
                m27833b(false);
                this.f21107r.setText(getResources().getString(C6104j.IDS_health_start_net_not_connect));
                this.f21109t.setVisibility(0);
                m27827a(false);
                this.f21082B = false;
            } else if (!f21079a) {
                m27841g();
            } else if (i.a(55)) {
                C2538c.c("HealthStartActivity", new Object[]{"Enter gotoChinese "});
                m27850a((Context) this);
            } else {
                C2538c.c("HealthStartActivity", new Object[]{"Enter gotoForenal "});
                m27831b((Context) this);
            }
        } else if (!d.e(this.f21092c)) {
            if (this.f21083C != null) {
                this.f21083C.cancel();
            }
            this.f21106q.setVisibility(0);
            m27833b(false);
            this.f21107r.setText(getResources().getString(C6104j.IDS_health_start_net_not_connect));
            this.f21109t.setVisibility(0);
            m27827a(false);
            this.f21082B = false;
        } else if (!f21079a) {
            m27841g();
        } else if (i.a(55)) {
            C2538c.c("HealthStartActivity", new Object[]{"Enter gotoChinese "});
            m27850a((Context) this);
        } else {
            C2538c.c("HealthStartActivity", new Object[]{"Enter gotoForenal "});
            m27831b((Context) this);
        }
    }

    private void m27841g() {
        if (C4725b.m22616a(this.f21092c, f21078J)) {
            m27842h();
            return;
        }
        m27824a();
        if (this.f21099j == null) {
            C6002a c6002a = new C6002a(this, C6105k.app_update_dialogActivity);
            this.f21099j = C6002a.m27468a((Context) this);
            this.f21099j.m27476a(getResources().getString(C6104j.IDS_getting_file));
            this.f21099j.m27474a();
            this.f21099j.setCancelable(false);
            this.f21099j.show();
            this.f21087G.sendEmptyMessageDelayed(2, 10000);
        } else if (!this.f21099j.isShowing()) {
            this.f21099j.m27476a(getResources().getString(C6104j.IDS_getting_file));
            this.f21099j.m27474a();
            this.f21099j.setCancelable(false);
            this.f21099j.show();
            this.f21087G.sendEmptyMessageDelayed(2, 10000);
        }
    }

    protected void onResume() {
        super.onResume();
        C2538c.c("HealthStartActivity", new Object[]{"onResume()"});
        this.f21106q.setVisibility(8);
        PackageInfo k = d.k(this.f21092c);
        C6002a c6002a;
        if (k != null) {
            if (20100000 <= k.versionCode && !m27849o()) {
                this.f21106q.setVisibility(8);
                this.f21093d.setVisibility(8);
                this.f21110u.setVisibility(8);
                this.f21111v.setVisibility(0);
                this.f21094e.setText(C6104j.IDS_install_finish);
                m27827a(true);
            } else if (d.e(this.f21092c)) {
                if (!f21079a) {
                    m27824a();
                    if (this.f21099j == null) {
                        c6002a = new C6002a(this, C6105k.app_update_dialogActivity);
                        this.f21099j = C6002a.m27468a((Context) this);
                        this.f21099j.m27476a(getResources().getString(C6104j.IDS_getting_file));
                        this.f21099j.m27474a();
                        this.f21099j.setCancelable(false);
                        this.f21099j.show();
                        this.f21087G.sendEmptyMessageDelayed(2, 10000);
                    } else if (!this.f21099j.isShowing()) {
                        this.f21099j.m27476a(getResources().getString(C6104j.IDS_getting_file));
                        this.f21099j.m27474a();
                        this.f21099j.setCancelable(false);
                        this.f21099j.show();
                        this.f21087G.sendEmptyMessageDelayed(2, 10000);
                    }
                }
                this.f21106q.setVisibility(8);
                m27827a(true);
            } else {
                this.f21107r.setText(getResources().getString(C6104j.IDS_health_start_net_not_connect));
                this.f21106q.setVisibility(0);
                this.f21109t.setVisibility(0);
                m27827a(false);
            }
        } else if (d.e(this.f21092c)) {
            if (!f21079a) {
                m27824a();
                if (this.f21099j == null) {
                    c6002a = new C6002a(this, C6105k.app_update_dialogActivity);
                    this.f21099j = C6002a.m27468a((Context) this);
                    this.f21099j.m27476a(getResources().getString(C6104j.IDS_getting_file));
                    this.f21099j.m27474a();
                    this.f21099j.setCancelable(false);
                    this.f21099j.show();
                    this.f21087G.sendEmptyMessageDelayed(2, 10000);
                } else if (!this.f21099j.isShowing()) {
                    this.f21099j.m27476a(getResources().getString(C6104j.IDS_getting_file));
                    this.f21099j.m27474a();
                    this.f21099j.setCancelable(false);
                    this.f21099j.show();
                    this.f21087G.sendEmptyMessageDelayed(2, 10000);
                }
            }
            this.f21106q.setVisibility(8);
            m27827a(true);
        } else {
            this.f21107r.setText(getResources().getString(C6104j.IDS_health_start_net_not_connect));
            this.f21106q.setVisibility(0);
            this.f21109t.setVisibility(0);
            m27827a(false);
        }
    }

    protected void onDestroy() {
        C2538c.c("HealthStartActivity", new Object[]{"onDestroy()"});
        d.n(this.f21092c);
        try {
            unregisterReceiver(this.f21091L);
        } catch (Exception e) {
            C2538c.c("HealthStartActivity", new Object[]{e.getMessage()});
        }
        if (this.f21099j != null) {
            this.f21099j.cancel();
            this.f21099j = null;
        }
        if (this.f21083C != null) {
            this.f21083C.cancel();
            this.f21083C = null;
        }
        super.onDestroy();
        this.f21098i = false;
        if (this.f21087G != null) {
            this.f21087G.removeCallbacksAndMessages(null);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f21098i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onBackPressed() {
        C2538c.c("HealthStartActivity", new Object[]{"onBackPressed()"});
        super.onBackPressed();
        if (this.f21082B) {
            m27846l();
        } else {
            finish();
        }
    }

    private void m27842h() {
        C2538c.c("HealthStartActivity", new Object[]{"handleAppNewVersionOK"});
        C2538c.c("HealthStartActivity", new Object[]{"handleAppNewVersionOK: mAppUpdateInteractor.appNewVersionNumSize = " + this.f21105p.a});
        C2538c.c("HealthStartActivity", new Object[]{"handleAppNewVersionOK: checkMemory = " + this.f21105p.a((long) this.f21105p.a)});
        if (this.f21105p.a((long) this.f21105p.a)) {
            C2538c.c("HealthStartActivity", new Object[]{"handleAppNewVersionOK: wifiConnected = " + this.f21105p.h()});
            if (this.f21105p.h()) {
                m27843i();
                return;
            } else if (this.f21105p.i()) {
                m27845k();
                return;
            } else {
                m27843i();
                return;
            }
        }
        m27825a(this.f21092c.getString(C6104j.IDS_update_low_memory));
    }

    private void m27825a(String str) {
        m27826a(this.f21092c.getString(C6104j.IDS_settings_firmware_upgrade_talk_band_failed), str);
    }

    private void m27826a(String str, String str2) {
        C2538c.c("HealthStartActivity", new Object[]{"showErrorMsg : title = " + str + " tipText = " + str2});
        if (this.f21083C != null) {
            this.f21083C.cancel();
        }
    }

    private void m27843i() {
        C2538c.c("HealthStartActivity", new Object[]{"doDownloadAppFile  isDownloading: " + this.f21082B});
        m27844j();
        this.f21093d.setFocusable(false);
        this.f21093d.setEnabled(false);
        m27827a(false);
        this.f21102m.setText(this.f21092c.getString(C6104j.IDS_app_update_downloading));
        this.f21100k.setOnClickListener(this);
        if (!this.f21082B) {
            this.f21105p.f();
        }
    }

    private void m27844j() {
        View inflate = ((LayoutInflater) this.f21092c.getSystemService("layout_inflater")).inflate(C6101g.activity_health_start_download, null);
        this.f21101l = (LinearLayout) inflate.findViewById(C6100f.AppUpdateDialog_progress_layout);
        this.f21102m = (TextView) inflate.findViewById(C6100f.AppUpdateDialog_progress_text);
        this.f21103n = (TextView) inflate.findViewById(C6100f.AppUpdateDialog_progress);
        this.f21104o = (ProgressBar) inflate.findViewById(C6100f.AppUpdateDialog_progressbar);
        this.f21100k = (ImageView) inflate.findViewById(C6100f.AppUpdateDialog_cancel);
        this.f21100k.setOnClickListener(this);
        ab abVar = new ab(this);
        abVar.m27488a(inflate);
        this.f21083C = abVar.m27491a();
        this.f21083C.setCancelable(false);
        this.f21083C.show();
    }

    private void m27845k() {
        C6024w c6024w = new C6024w(this);
        c6024w.m27595a(getResources().getString(C6104j.IDS_dialog_yes), new d(this));
        c6024w.m27599b(getResources().getString(C6104j.IDS_dialog_no), new e(this));
        this.f21085E = c6024w.m27590a();
        if (!this.f21085E.isShowing()) {
            this.f21085E.show();
        }
    }

    private void m27846l() {
        C6024w c6024w = new C6024w(this);
        c6024w.m27595a(getResources().getString(C6104j.IDS_dialog_yes), new f(this));
        c6024w.m27599b(getResources().getString(C6104j.IDS_dialog_no), new g(this));
        this.f21084D = c6024w.m27590a();
        if (!this.f21084D.isShowing()) {
            this.f21084D.show();
        }
    }

    @TargetApi(23)
    private void m27827a(boolean z) {
        this.f21094e.setEnabled(z);
        this.f21094e.setFocusable(z);
        C2538c.c("HealthStartActivity", new Object[]{"Build.VERSION_CODES.M = 23 Build.VERSION.SDK_INT = " + VERSION.SDK_INT});
        if (z) {
            if (VERSION.SDK_INT < 23) {
                this.f21094e.setTextColor(getResources().getColor(C6097c.download_health_text_color));
            } else {
                this.f21094e.setTextColor(getColor(C6097c.download_health_text_color));
            }
        } else if (VERSION.SDK_INT < 23) {
            this.f21094e.setTextColor(getResources().getColor(C6097c.download_health_text_color_20alpha));
        } else {
            this.f21094e.setTextColor(getColor(C6097c.download_health_text_color_20alpha));
        }
    }

    private void m27833b(boolean z) {
        if (z) {
            this.f21112w.setVisibility(0);
            this.f21114y.start();
            return;
        }
        this.f21112w.setVisibility(8);
        this.f21114y.stop();
    }

    private void m27847m() {
        setResult(2);
        C2538c.c("HealthStartActivity", new Object[]{"enterHome() isFromUpdateHiHealthToEnter = " + this.f21096g});
        if (this.f21096g) {
            Intent intent = new Intent();
            intent.setClassName(this.f21092c, "com.huawei.bone.root.MainActivity");
            startActivity(intent);
        }
        finish();
    }

    public void m27850a(Context context) {
        C2538c.c("HealthStartActivity", new Object[]{"enterHuaweiAppStore():"});
        Boolean.valueOf(false);
        if (d.e(this.f21092c)) {
            C2538c.c("HealthStartActivity", new Object[]{"isInstallFlag =" + Boolean.valueOf(m27828a(m27829b("http://a.vmall.com/exmarket?id=C10414141").setPackage("com.huawei.appmarket")))});
            if (!Boolean.valueOf(m27828a(m27829b("http://a.vmall.com/exmarket?id=C10414141").setPackage("com.huawei.appmarket"))).booleanValue()) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse("http://wap1.hispace.hicloud.com/appdl/C10414141"));
                    startActivity(intent);
                    return;
                } catch (ActivityNotFoundException e) {
                    C5995a.m27435a(context, C6104j.IDS_confirm_intent_action);
                    return;
                }
            }
            return;
        }
        C2538c.c("HealthStartActivity", new Object[]{"Network is not Connected!"});
        C5995a.m27435a(context, C6104j.IDS_confirm_network_whether_connected);
    }

    private boolean m27828a(Intent intent) {
        C2538c.c("HealthStartActivity", new Object[]{" enter openOemAppstore()"});
        if (d.l(this.f21092c)) {
            try {
                Intent intent2 = new Intent("com.huawei.appmarket.intent.action.AppDetail");
                intent2.setPackage("com.huawei.appmarket");
                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent2.putExtra("APP_PACKAGENAME", WeChat.HEALTH_PACKAGE_NAME);
                this.f21092c.startActivity(intent2);
                return true;
            } catch (ActivityNotFoundException e) {
                C2538c.e("HealthStartActivity", new Object[]{"Exception localActivityNotFoundException = " + e.getMessage()});
            }
        }
        return false;
    }

    private Intent m27829b(String str) {
        C2538c.c("HealthStartActivity", new Object[]{"enter createViewIntent():"});
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(276856832);
        return intent;
    }

    private void m27831b(Context context) {
        Intent launchIntentForPackage;
        if (d.m(context)) {
            C2538c.c("HealthStartActivity", new Object[]{"google stone is install"});
            C2538c.c("HealthStartActivity", new Object[]{"google stone uri = http://play.google.com/store/apps/details?id=com.huawei.health"});
            try {
                launchIntentForPackage = this.f21092c.getPackageManager().getLaunchIntentForPackage("com.android.vending");
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity"));
                    launchIntentForPackage.setData(Uri.parse("http://play.google.com/store/apps/details?id=com.huawei.health"));
                    launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    this.f21092c.startActivity(launchIntentForPackage);
                    return;
                }
                C2538c.c("HealthStartActivity", new Object[]{"enterGoogleAppStore is null"});
                return;
            } catch (ActivityNotFoundException e) {
                C2538c.e("HealthStartActivity", new Object[]{"Exception localActivityNotFoundException = " + e.getMessage()});
                return;
            }
        }
        try {
            C2538c.c("HealthStartActivity", new Object[]{"google stone is not install"});
            C2538c.c("HealthStartActivity", new Object[]{"google stone uri = http://play.google.com/store/apps/details?id=com.huawei.health"});
            launchIntentForPackage = new Intent();
            launchIntentForPackage.setAction("android.intent.action.VIEW");
            launchIntentForPackage.setData(Uri.parse("http://play.google.com/store/apps/details?id=com.huawei.health"));
            startActivity(launchIntentForPackage);
        } catch (ActivityNotFoundException e2) {
            C5995a.m27435a(context, C6104j.IDS_confirm_intent_action);
        }
    }

    private int m27848n() {
        PackageInfo k = d.k(this.f21092c);
        if (k == null) {
            return -1;
        }
        C2538c.c("HealthStartActivity", new Object[]{"refresh Health Support getHealthAppVersion packageInfo : " + k});
        C2538c.c("HealthStartActivity", new Object[]{"refresh Health Support getHealthAppVersion versionCode : " + k.versionCode});
        return k.versionCode;
    }

    private boolean m27849o() {
        if (this.f21088H != 1 || m27848n() > this.f21089I) {
            C2538c.c("HealthStartActivity", new Object[]{"refresh Health Support isNendUpdate return false "});
            return false;
        }
        C2538c.c("HealthStartActivity", new Object[]{"refresh Health Support isNendUpdate return true "});
        return true;
    }
}
