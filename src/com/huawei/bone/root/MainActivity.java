package com.huawei.bone.root;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.huawei.bone.C6753R;
import com.huawei.bone.p551a.C6754a;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoReq;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicedfxmanager.utils.MaintenanceUtil;
import com.huawei.hwservicesmgr.a.q;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.a.f;
import com.huawei.pluginmessagecenter.j;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.homewear21.a.cf;
import com.huawei.ui.main.stories.about.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class MainActivity extends BaseActivity {
    private ViewPager f23210a;
    private ArrayList<Fragment> f23211b;
    private a f23212c;
    private com.huawei.ui.homewear21.a.a f23213d;
    private LocalBroadcastManager f23214e;
    private DrawerLayout f23215f;
    private FrameLayout f23216g;
    private cf f23217h;
    private HandlerThread f23218i = null;
    private Handler f23219j = null;
    private Context f23220k = null;
    private Handler f23221l;
    private boolean f23222m = false;
    private String f23223n = "";
    private int f23224o = 0;
    private String f23225p = "";
    private boolean f23226q = false;
    private Runnable f23227r = new C6782a(this);
    private DrawerListener f23228s = new C6784c(this);
    private final BroadcastReceiver f23229t = new C6785d(this);
    private final BroadcastReceiver f23230u = new C6786e(this);
    private final BroadcastReceiver f23231v = new C6789h(this);
    private final BroadcastReceiver f23232w = new C6791j(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter onCreate"});
        this.f23220k = this;
        overridePendingTransition(C6753R.anim.activity_no_animation, C6753R.anim.activity_no_animation);
        setContentView(C6753R.layout.activity_main);
        this.f23221l = new C6794m(getMainLooper(), this);
        this.f23221l.sendEmptyMessageDelayed(100, 8000);
        this.f23218i = new HandlerThread("MainActivity");
        this.f23218i.start();
        this.f23219j = new Handler(this.f23218i.getLooper());
        m30107a();
        m30117c();
        m30119d();
        m30136q();
        this.f23219j.postDelayed(this.f23227r, 1500);
    }

    private void m30107a() {
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        com.huawei.l.a.c.a().a(this.f23220k, com.huawei.hwcommonmodel.b.a.T.a(), hashMap, 0);
    }

    private void m30114b() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter check"});
        com.huawei.hwcloudmodel.mgr.a.a(BaseApplication.b()).a(new GetUserMergeInfoReq(), new C6783b(this));
    }

    private void m30117c() {
        m30130k();
        m30132m();
        m30128i();
        this.f23212c = a.a();
        m30127h();
        f.a(this).c();
        j.a(this).setAdapter(new com.huawei.g.a.a());
        j.a(this).init(this);
        m30134o();
        if (com.huawei.hwappdfxmgr.f.c.c()) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"UploadLogUtil.deviceLogExists"});
            new MaintenanceUtil().cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
            com.huawei.hwappdfxmgr.a.a(this).a(false);
        }
    }

    private void m30119d() {
        this.f23215f = (DrawerLayout) findViewById(C6753R.id.main_drawer_layout);
        this.f23216g = (FrameLayout) findViewById(C6753R.id.huaweiwear_main_left_menu);
        m30123f();
        m30125g();
    }

    protected void onDestroy() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"App on onDestroy."});
        this.f23221l.removeCallbacksAndMessages(null);
        this.f23219j.removeCallbacksAndMessages(null);
        super.onDestroy();
        com.huawei.ui.main.stories.nps.interactors.a.a(BaseApplication.b());
        com.huawei.ui.main.stories.nps.interactors.a.a(false);
        m30131l();
        unregisterReceiver(this.f23229t);
        m30133n();
        m30135p();
        j.a(this).finish();
        m30120e();
        q.b(this);
        com.huawei.hwbasemgr.a.finishAll();
    }

    public void onBackPressed() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"App on back pressed."});
        super.onBackPressed();
        finish();
    }

    private void m30120e() {
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        com.huawei.l.a.c.a().a(this.f23220k, com.huawei.hwcommonmodel.b.a.U.a(), hashMap, 0);
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Analytics BI click for App exit"});
    }

    private void m30123f() {
        this.f23210a = (ViewPager) findViewById(C6753R.id.viewpager);
        this.f23211b = new ArrayList();
        this.f23213d = new com.huawei.ui.homewear21.a.a(this.f23215f, this.f23216g);
        this.f23211b.add(this.f23213d);
        this.f23210a.setAdapter(new C6796o(getSupportFragmentManager(), this.f23211b));
    }

    private void m30125g() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"==========Enter initDrawerLayout()"});
        this.f23215f.setScrimColor(getResources().getColor(C6753R.color.menu_bg_colors_side));
        this.f23215f.setDrawerShadow(getResources().getDrawable(C6753R.drawable.kw_pic_shadow2), 3);
        this.f23217h = new C6795n(this.f23215f, this.f23216g);
        getFragmentManager().beginTransaction().replace(C6753R.id.huaweiwear_main_left_menu, this.f23217h).commitAllowingStateLoss();
        this.f23215f.setDrawerListener(this.f23228s);
    }

    private void m30127h() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"autoCheckAppNewVersionService() siteID:" + i.a()});
        if (i.a() == 0) {
            this.f23212c.b();
            return;
        }
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"autoCheckAppNewVersionService() not in china !"});
    }

    protected void onRestart() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"onRestart()  is need goto : " + this.f23222m});
        super.onRestart();
        if (this.f23222m && this.f23212c != null) {
            this.f23212c.a(this.f23220k, this.f23223n, this.f23224o, this.f23225p, Boolean.valueOf(this.f23226q));
            this.f23222m = false;
        }
    }

    private void m30128i() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"registerAutoCheckBroadcast()"});
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_band_auto_check_new_version_result");
        intentFilter.addAction(com.huawei.hwcommonmodel.b.c.a);
        registerReceiver(this.f23229t, intentFilter, com.huawei.hwcommonmodel.b.c.a, null);
    }

    private void m30129j() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter checkMigrageNotice"});
        Executors.newSingleThreadExecutor().execute(new C6787f(this));
    }

    private void m30108a(Context context) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter showHandleMigrateDialog"});
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.c(context);
        aVar.b(context.getString(C6753R.string.IDS_migrage_show_other_account_migrate_successful));
        aVar.c(context.getString(C6753R.string.IDS_migrage_home_mograte_success));
        aVar.a(context.getString(C6753R.string.IDS_common_notification_know_tips), new C6788g(this, aVar));
        if (aVar.isShowing()) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"showHandleMigrateDialog on click 2"});
            return;
        }
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"showHandleMigrateDialog on click 1"});
        aVar.b();
        aVar.setCancelable(false);
    }

    private void m30130k() {
        this.f23214e = LocalBroadcastManager.getInstance(BaseApplication.b());
        if (this.f23214e == null || this.f23230u == null) {
            C2538c.e("MainActivity", new Object[]{"registerLocalBroadcast() if (null == mLocalBroadcastManager || null == mBroadcastReceiver)"});
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.plugin.account.login");
        intentFilter.addAction("com.huawei.plugin.account.login.st.to.at");
        intentFilter.addAction("com.huawei.migrate.action.migrate.success");
        this.f23214e.registerReceiver(this.f23230u, intentFilter);
    }

    private void m30131l() {
        try {
            if (this.f23214e == null || this.f23230u == null) {
                C2538c.a("MainUI", 0, "MainActivity", new Object[]{"unregisterLocalBroadcast() if (mLocalBroadcastManager == null || mBroadcastReceiver == null)"});
                return;
            }
            this.f23214e.unregisterReceiver(this.f23230u);
            this.f23214e = null;
        } catch (Exception e) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{e.getMessage()});
        }
    }

    private void m30132m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
        registerReceiver(this.f23231v, intentFilter);
    }

    private void m30133n() {
        try {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter unregisterNonLocalBroadcast()!"});
            unregisterReceiver(this.f23231v);
        } catch (IllegalArgumentException e) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{e.getMessage()});
        } catch (RuntimeException e2) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{e2.getMessage()});
        }
    }

    private void m30134o() {
        if (i.a(48)) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter registerWifiBroadcast()!"});
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            registerReceiver(this.f23232w, intentFilter);
        }
    }

    private void m30135p() {
        if (i.a(48)) {
            try {
                C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter unregisterWifiBroadcast()!"});
                unregisterReceiver(this.f23232w);
            } catch (IllegalArgumentException e) {
                C2538c.a("MainUI", 0, "MainActivity", new Object[]{e.getMessage()});
            } catch (RuntimeException e2) {
                C2538c.a("MainUI", 0, "MainActivity", new Object[]{e2.getMessage()});
            }
        }
    }

    private void m30136q() {
        com.huawei.login.ui.login.a.a(this);
        this.f23217h.a(this.f23220k);
        this.f23217h.c();
    }

    protected void setStatusBar() {
        C6754a.m30024a(this, (DrawerLayout) findViewById(C6753R.id.main_drawer_layout), getResources().getColor(C6753R.color.common_white_50alpha), 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f23215f.isDrawerOpen(this.f23216g)) {
                C2538c.b("MainActivity", new Object[]{"======关闭抽屉"});
                this.f23215f.closeDrawers();
                return false;
            }
            C2538c.b("MainActivity", new Object[]{"=======没有抽屉打开"});
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"onNewIntent"});
        if (intent.getBooleanExtra("KEY_ANROIDWEAR_OPEN_ESIM_FLAG", false)) {
            new com.huawei.ui.main.stories.guide.a.a(BaseApplication.b()).h(true);
            if (this.f23213d != null) {
                this.f23213d.a();
            }
        } else if (intent.getBooleanExtra("KEY_ANROIDWEAR_OPEN_WALLET_FLAG", false)) {
            new com.huawei.ui.main.stories.guide.a.a(BaseApplication.b()).i(true);
            if (this.f23213d != null) {
                this.f23213d.d();
            }
        }
        super.onNewIntent(intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
    }
}
