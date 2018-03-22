package com.huawei.ui.device.activity.adddevice;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.g.a.b;
import com.huawei.g.a.v;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwbtsdk.p057b.p058a.C4604c;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.nfc.PluginPay;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.p137a.C1383f;
import com.huawei.sim.a;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.activity.pairing.DevicePairGuideActivity;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1973a;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1996x;
import com.huawei.ui.device.views.device.C2203i;
import com.huawei.ui.device.views.p172a.C2185a;
import com.huawei.ui.device.views.p172a.C2186b;
import com.huawei.ui.device.views.p172a.C2187c;
import com.huawei.ui.device.views.p172a.C2188d;
import com.huawei.ui.main.stories.about.p179a.C2279a;
import com.huawei.ui.main.stories.guide.p181a.C2378a;
import com.huawei.ui.main.stories.lightcloud.LightCloud;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddDeviceActivity extends BaseActivity {
    private View f6976A;
    private LinearLayout f6977B;
    private LinearLayout f6978C;
    private int f6979D = 0;
    private u f6980E = null;
    private boolean f6981F = false;
    private String f6982G;
    private String f6983H;
    private BluetoothAdapter f6984I = null;
    private Handler f6985J = new C2009k(this);
    private C2279a f6986K;
    private Context f6987L = null;
    private boolean f6988M = false;
    private String f6989N = "";
    private int f6990O = 0;
    private String f6991P = "";
    private boolean f6992Q = false;
    private C4604c f6993R = new C1999a(this);
    private final BroadcastReceiver f6994S = new C2004f(this);
    private OnItemClickListener f6995T = new C2007i(this);
    private Context f6996a;
    private ListView f6997b;
    private C1988p f6998c;
    private int f6999d;
    private ArrayList<C2188d> f7000e = new ArrayList();
    private C2186b f7001f = null;
    private ArrayList<C2187c> f7002g = new ArrayList();
    private C2185a f7003h = null;
    private CustomTitleBar f7004i;
    private CustomTitleBar f7005j;
    private String f7006k = "";
    private boolean f7007l = false;
    private boolean f7008m = false;
    private String[] f7009n = new String[0];
    private String[] f7010o = new String[0];
    private String[] f7011p = new String[0];
    private String[] f7012q = new String[0];
    private C2203i f7013r;
    private List<BluetoothDevice> f7014s = new ArrayList();
    private C4600d f7015t;
    private ListView f7016u;
    private ImageView f7017v;
    private ImageView f7018w;
    private TextView f7019x;
    private AnimationDrawable f7020y;
    private AnimationDrawable f7021z;

    private void m10479a() {
        C2538c.m12661a("01", 0, "AddDeviceActivity", "onDeviceDiscoveryFinished");
        if (this.f6985J != null) {
            this.f6985J.sendEmptyMessage(10);
        }
    }

    private static void m10512d(int i, AddDeviceActivity addDeviceActivity) {
        switch (i) {
            case 11:
                addDeviceActivity.m10542w();
                return;
            case 12:
                addDeviceActivity.m10541v();
                return;
            case 13:
                addDeviceActivity.f7015t.d();
                addDeviceActivity.f7021z.stop();
                addDeviceActivity.f7017v.setVisibility(8);
                addDeviceActivity.m10480a(11);
                addDeviceActivity.m10480a(12);
                return;
            default:
                return;
        }
    }

    private static void m10516e(int i, AddDeviceActivity addDeviceActivity) {
        switch (i) {
            case 14:
                addDeviceActivity.m10492a(false);
                return;
            case 21:
                addDeviceActivity.m10491a(BaseApplication.m2632b().getString(i.IDS_btsdk_turn_on_location_BT));
                return;
            case 22:
                addDeviceActivity.m10491a(BaseApplication.m2632b().getString(i.IDS_btsdk_turn_on_location));
                return;
            case 23:
                addDeviceActivity.m10491a(BaseApplication.m2632b().getString(i.IDS_btsdk_turn_on_BT));
                return;
            default:
                return;
        }
    }

    private static void m10519f(int i, AddDeviceActivity addDeviceActivity) {
        switch (i) {
            case 24:
                addDeviceActivity.m10496b();
                return;
            case 25:
                addDeviceActivity.m10492a(false);
                addDeviceActivity.m10501b(false);
                return;
            case 26:
                addDeviceActivity.m10521g();
                return;
            case 27:
                if (addDeviceActivity.f7014s.size() > 0) {
                    addDeviceActivity.m10501b(true);
                    addDeviceActivity.m10506c(addDeviceActivity.f7014s.size());
                    return;
                }
                addDeviceActivity.m10501b(false);
                return;
            case 28:
                addDeviceActivity.f7021z.stop();
                addDeviceActivity.f7017v.clearAnimation();
                addDeviceActivity.m10501b(false);
                addDeviceActivity.m10492a(false);
                if (addDeviceActivity.f7014s != null) {
                    addDeviceActivity.f7014s.clear();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m10480a(int i) {
        this.f6985J.removeMessages(i);
    }

    private void m10496b() {
        if (this.f6984I == null) {
            this.f6984I = BluetoothAdapter.getDefaultAdapter();
            if (this.f6984I == null) {
                return;
            }
        }
        if (!this.f6984I.isEnabled()) {
            this.f6984I.enable();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6996a = BaseApplication.m2632b();
        this.f6987L = this;
        C2538c.m12677c("AddDeviceActivity", "onCreate()");
        setContentView(f.activity_select_device_black);
        this.f7015t = C4600d.a();
        this.f7015t.a(this.f6996a);
        m10523h();
        if (this.f7007l || this.f7008m) {
            this.f6977B.setVisibility(8);
        } else {
            m10492a(true);
            m10501b(false);
            m10524i();
        }
        m10511d();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new C2000b(this, newSingleThreadExecutor));
    }

    private void m10505c() {
        if (!C0969i.m3482a(60)) {
            C2538c.m12677c("AddDeviceActivity", "initLightCloud not support");
        } else if (C0977d.m3555e(BaseApplication.m2632b())) {
            LightCloud.getInstance(BaseApplication.m2632b()).doRefreshBatch(new C2002d(this));
        } else {
            C2538c.m12677c("AddDeviceActivity", "no net to lightcloud");
        }
    }

    private void m10511d() {
        m10515e();
        this.f6986K = C2279a.m11722a();
        this.f6985J.post(new C2003e(this));
    }

    private void m10515e() {
        C2538c.m12677c("AddDeviceActivity", "registerAutoCheckBroadcast()");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_band_auto_check_new_version_result");
        intentFilter.addAction(C0976c.f1642a);
        registerReceiver(this.f6994S, intentFilter, C0976c.f1642a, null);
    }

    private void m10518f() {
        C2538c.m12677c("AddDeviceActivity", "autoCheckAppNewVersionService() siteID:" + C0969i.m3481a());
        if (C0969i.m3481a() == 0) {
            this.f6986K.m11733b();
            return;
        }
        C2538c.m12677c("AddDeviceActivity", "autoCheckAppNewVersionService() not in china !");
    }

    protected void onRestart() {
        C2538c.m12677c("AddDeviceActivity", "onRestart()  is need goto : " + this.f6988M);
        super.onRestart();
        if (this.f6988M && this.f6986K != null) {
            this.f6986K.m11729a(this.f6987L, this.f6989N, this.f6990O, this.f6991P, Boolean.valueOf(this.f6992Q));
            this.f6988M = false;
        }
    }

    private void m10521g() {
        C2538c.m12677c("AddDeviceActivity", "===123===Enter startScanAllDevices");
        m10529k();
    }

    private void m10492a(boolean z) {
        C2538c.m12677c("AddDeviceActivity", "===123===showScanListView  showFirstView" + z);
        if (z) {
            this.f6978C.setVisibility(0);
            this.f7020y.start();
            return;
        }
        this.f6978C.setVisibility(8);
        this.f7020y.stop();
        this.f7018w.clearAnimation();
    }

    private void m10501b(boolean z) {
        C2538c.m12677c("AddDeviceActivity", "===123===showScanListView  isShow" + z);
        if (z) {
            this.f6977B.setVisibility(0);
            this.f6976A.setVisibility(0);
            return;
        }
        this.f6977B.setVisibility(8);
        this.f6976A.setVisibility(8);
    }

    private void m10523h() {
        m10526j();
        m10531l();
        m10532m();
    }

    private void m10491a(String str) {
        C2538c.m12677c("AddDeviceActivity", "===123===Enter showBTOrGPSDialog Already show! mDialogContent" + this.f6979D);
        if (this.f6980E == null || !this.f6980E.isShowing()) {
            this.f6980E = new w(this).a(i.IDS_service_area_notice_title).b(str).a(i.IDS_settings_button_ok, new C2006h(this)).b(i.IDS_settings_button_cancal, new C2005g(this)).a();
            this.f6980E.setCancelable(false);
            if (!this.f6980E.isShowing()) {
                this.f6980E.show();
                return;
            }
            return;
        }
        C2538c.m12677c("AddDeviceActivity", "===123===showBTOrGPSDialog Already show!");
    }

    private void m10510c(boolean z) {
        C2538c.m12677c("AddDeviceActivity", "===123===enableBTSwitch enable" + z);
        if (z) {
            this.f6985J.sendEmptyMessage(24);
        } else {
            this.f6985J.sendEmptyMessage(25);
        }
    }

    private void m10524i() {
        int c = this.f7015t.c();
        C2538c.m12677c("AddDeviceActivity", "===123===btSwitchState = " + c);
        if (1 == c) {
            m10544a(this.f6996a);
        } else if (3 == c) {
            m10499b(this.f6996a);
        } else if (4 == c) {
            this.f6985J.sendEmptyMessage(26);
        } else {
            this.f6985J.sendEmptyMessage(28);
        }
    }

    private void m10499b(Context context) {
        C2538c.m12677c("AddDeviceActivity", "===123===showDiscoverDeviceDialog isGPSLocationEnable = " + C1973a.m10287a(context));
        if (C1973a.m10287a(context)) {
            this.f6985J.sendEmptyMessage(26);
            return;
        }
        this.f6979D = 22;
        this.f6985J.sendEmptyMessage(22);
    }

    public void m10544a(Context context) {
        C2538c.m12677c("AddDeviceActivity", "===123==showBTSwitchEnableDialog isGPSLocationEnable = " + C1973a.m10287a(context));
        if (C1973a.m10287a(context)) {
            this.f6979D = 23;
            this.f6985J.sendEmptyMessage(23);
            return;
        }
        this.f6979D = 21;
        this.f6985J.sendEmptyMessage(21);
    }

    private void m10526j() {
        this.f6978C = (LinearLayout) com.huawei.ui.commonui.d.d.a(this, e.pair_guide_scan_loading_view);
        this.f6977B = (LinearLayout) com.huawei.ui.commonui.d.d.a(this, e.pair_guide_scan_linearlayout);
        this.f6976A = com.huawei.ui.commonui.d.d.a(this, e.pair_guide_scan_text_device_seach_bottom_view);
        this.f7016u = (ListView) com.huawei.ui.commonui.d.d.a(this, e.pair_guide_scan_custom_listview);
        this.f7017v = (ImageView) com.huawei.ui.commonui.d.d.a(this, e.pair_guide_scan_text_image);
        this.f7018w = (ImageView) com.huawei.ui.commonui.d.d.a(this, e.pair_guide_scan_loading_image);
        this.f7019x = (TextView) com.huawei.ui.commonui.d.d.a(this, e.pair_guide_scan_text);
        this.f7019x.setText(this.f6996a.getString(i.IDS_device_pair_scan_title_text).toUpperCase());
        this.f7021z = (AnimationDrawable) this.f6996a.getResources().getDrawable(com.huawei.ui.device.d.app_update_checking);
        this.f7020y = (AnimationDrawable) this.f6996a.getResources().getDrawable(com.huawei.ui.device.d.app_update_checking);
        this.f7017v.setBackground(this.f7021z);
        this.f7018w.setBackground(this.f7020y);
        this.f7013r = new C2203i(this.f6996a);
        m10490a(this.f7013r);
        this.f7016u.setAdapter(this.f7013r);
        this.f7004i = (CustomTitleBar) com.huawei.ui.commonui.d.d.a(this, e.select_device_title_bar);
        this.f7005j = (CustomTitleBar) com.huawei.ui.commonui.d.d.a(this, e.select_device_detail_title_bar);
        this.f6997b = (ListView) com.huawei.ui.commonui.d.d.a(this, e.list_setup_device);
    }

    private void m10529k() {
        this.f7016u.setOnItemClickListener(this.f6995T);
        if (C1973a.m10286a(this, 2)) {
            m10540u();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.m12677c("AddDeviceActivity", "===123====onRequestPermissionsResult requestCode=" + i);
        switch (i) {
            case 11:
                if (iArr == null || iArr.length <= 0) {
                    this.f6985J.sendEmptyMessage(28);
                    C2538c.m12661a("01", 0, "AddDeviceActivity", "grantResults is null or length is incorrect.");
                    return;
                }
                m10540u();
                return;
            default:
                return;
        }
    }

    private void m10482a(int i, String str) {
        C2538c.m12677c("AddDeviceActivity", "===123==enterDevicePairGuide deviceType=" + i + "deviceName" + str);
        this.f6985J.sendEmptyMessageDelayed(28, 2000);
        Intent intent = new Intent(this.f6996a, DevicePairGuideActivity.class);
        if (this.f7006k != null && this.f7006k.equals("personalbasicinfosetting")) {
            intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
        }
        intent.putExtra("pairGuideProductType", i);
        intent.putExtra("pairGuideProductName", str);
        intent.putExtra("pairGuideFromScanList", true);
        intent.putExtra("pairGuideSelectName", this.f6982G);
        intent.putExtra("pairGuideSelectAddress", this.f6983H);
        startActivityForResult(intent, 1);
    }

    private void m10531l() {
        this.f6998c = C1988p.m10381a(BaseApplication.m2632b());
        Intent intent = getIntent();
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        this.f7007l = intent.getBooleanExtra("KEY_ANROIDWEAR_OPEN_ESIM_FLAG", false);
        c2378a.m12003h(this.f7007l);
        this.f7008m = intent.getBooleanExtra("KEY_ANROIDWEAR_OPEN_WALLET_FLAG", false);
        c2378a.m12005i(this.f7008m);
        C2538c.m12677c("AddDeviceActivity", "isAndroidWearOpenApp: " + this.f7007l);
        C2538c.m12677c("AddDeviceActivity", "isAndroidWearOpenWallet: " + this.f7008m);
        List c = C1973a.m10289c();
        this.f7009n = (String[]) c.toArray(new String[c.size()]);
        c = C1973a.m10284a();
        this.f7010o = (String[]) c.toArray(new String[c.size()]);
        c = C1973a.m10291e();
        this.f7011p = (String[]) c.toArray(new String[c.size()]);
        c = C1973a.m10293g();
        this.f7012q = (String[]) c.toArray(new String[c.size()]);
    }

    private void m10532m() {
        this.f7004i = (CustomTitleBar) com.huawei.ui.commonui.d.d.a(this, e.select_device_title_bar);
        this.f7005j = (CustomTitleBar) com.huawei.ui.commonui.d.d.a(this, e.select_device_detail_title_bar);
        this.f7006k = getIntent().getStringExtra("personalbasicinfosettingflag");
        C2538c.m12677c("AddDeviceActivity", "initListView() personalBasicInfoSettingflag = " + this.f7006k);
        if (this.f7006k == null || !this.f7006k.equals("personalbasicinfosetting")) {
            this.f7004i.setVisibility(8);
            this.f7005j.setVisibility(0);
        } else {
            this.f7004i.setVisibility(0);
            this.f7005j.setVisibility(8);
            C1383f.m6188a(this.f6996a).m6193c();
        }
        this.f6997b = (ListView) com.huawei.ui.commonui.d.d.a(this, e.list_setup_device);
        if (this.f7007l || this.f7008m) {
            m10534o();
        } else {
            m10533n();
        }
    }

    private void m10533n() {
        C2538c.m12677c("AddDeviceActivity", "initSelectDeviceList");
        if (!this.f7000e.isEmpty()) {
            C2538c.m12677c("AddDeviceActivity", "initSelectDeviceList() mList.clear()");
            this.f7000e.clear();
        }
        m10484a(1, this.f6996a.getString(i.IDS_add_device_smart_watch), this.f7009n, g.ic_add_device_watch);
        m10484a(2, this.f6996a.getString(i.IDS_add_device_smart_band), this.f7010o, g.ic_add_device_band);
        if (C1996x.m10457a(this.f6996a) && !C0970w.m3489b()) {
            m10484a(3, this.f6996a.getString(i.IDS_add_device_kids_watch), this.f7011p, g.ic_add_device_kid);
        }
        if (this.f7012q.length != 0) {
            m10484a(4, this.f6996a.getString(i.IDS_add_device_smart_headphones), this.f7012q, g.ic_add_device_earphone);
        }
        if (!(m10535p() || this.f7006k == null || !this.f7006k.equals("personalbasicinfosetting"))) {
            C2538c.m12677c("AddDeviceActivity", "show no device");
            m10484a(5, "", this.f7009n, 100);
        }
        this.f7001f = new C2186b(this, this.f7000e);
        this.f6997b.setAdapter(this.f7001f);
    }

    private void m10534o() {
        C2538c.m12677c("AddDeviceActivity", "initSelectDeviceListAndroidWear");
        if (!this.f7002g.isEmpty()) {
            C2538c.m12677c("AddDeviceActivity", "initSelectDeviceListAndroidWear() mList.clear()");
            this.f7002g.clear();
        }
        m10483a(10, this.f6996a.getString(i.IDS_app_display_name_porc), this.f6996a.getString(i.IDS_porsche_design_content), g.device_icon_leo2);
        m10483a(10, this.f6996a.getString(i.IDS_app_display_name_leo), this.f6996a.getString(i.IDS_huaweiwatch2_content), g.device_icon_leo);
        this.f7003h = new C2185a(this, this.f7002g);
        this.f6997b.setAdapter(this.f7003h);
    }

    private boolean m10535p() {
        List b = C1988p.m10381a(BaseApplication.m2632b()).m10392b();
        if (b == null || b.size() <= 0) {
            return false;
        }
        return true;
    }

    private void m10483a(int i, String str, String str2, int i2) {
        C2187c a = C1973a.m10282a(i, str, str2, i2);
        a.m11204a(new C2010l(this, a));
        this.f7002g.add(a);
    }

    private void m10484a(int i, String str, String[] strArr, int i2) {
        C2188d a = C1973a.m10283a(i, str, strArr, i2);
        a.m11214a(new C2011m(this, a));
        this.f7000e.add(a);
    }

    protected void onStop() {
        C2538c.m12677c("AddDeviceActivity", "===123===Enter onStop");
        super.onStop();
    }

    protected void onDestroy() {
        C2538c.m12677c("AddDeviceActivity", "===123===Enter onDestroy");
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        this.f7007l = false;
        this.f7008m = false;
        c2378a.m12003h(false);
        c2378a.m12005i(false);
        this.f7017v.clearAnimation();
        this.f7018w.clearAnimation();
        this.f7015t.d();
        m10480a(11);
        m10480a(12);
        this.f6985J.removeCallbacksAndMessages(null);
        if (this.f7014s != null) {
            this.f7014s.clear();
        }
        C2538c.m12677c("AddDeviceActivity", "onDestroy(): getAndroidWearOpenEsimFlagInSharePreference :" + c2378a.m12004h());
        super.onDestroy();
        C2538c.m12677c("AddDeviceActivity", "onDestroy()");
        m10543x();
        C0977d.m3575n(this.f6996a);
    }

    public void onBackPressed() {
        super.onBackPressed();
        C2538c.m12677c("AddDeviceActivity", " onBackPressed() ");
    }

    protected void onStart() {
        C2538c.m12677c("AddDeviceActivity", " onStart() ");
        super.onStart();
    }

    protected void onResume() {
        C2538c.m12677c("AddDeviceActivity", " onResume() ");
        super.onResume();
    }

    private void m10536q() {
        Intent intent = new Intent();
        intent.setClassName(this.f6996a, "com.huawei.bone.root.MainActivity");
        startActivity(intent);
        finish();
    }

    private void m10537r() {
        Intent intent = new Intent(this.f6996a, DevicePairGuideActivity.class);
        if (this.f7006k != null && this.f7006k.equals("personalbasicinfosetting")) {
            intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
        }
        if (3 == this.f6999d || 10 == this.f6999d) {
            DeviceInfo a = this.f6998c.m10384a();
            if (a != null) {
                C2538c.m12677c("AddDeviceActivity", "enterW1PairGuide deviceInfo=========" + a.toString());
                if ((a.getProductType() == 3 || a.getProductType() == 10) && 2 == a.getDeviceConnectState()) {
                    intent.putExtra("pairGuideW1Success", true);
                }
            }
        } else {
            intent.putExtra("pairGuideW1Success", false);
        }
        if (10 == this.f6999d) {
            intent.putExtra("pairGuideProductType", 10);
            intent.putExtra("pairGuideProductName", this.f6996a.getString(i.IDS_app_display_name_leo));
        } else {
            intent.putExtra("pairGuideProductType", 3);
            intent.putExtra("pairGuideProductName", this.f6996a.getString(i.IDS_app_display_name_w1));
        }
        intent.putExtra("pairGuideFromScanList", false);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C2538c.m12677c("AddDeviceActivity", "Enter onActivityResult():personalBasicInfoSettingflag = " + this.f7006k);
        if (1 == i && i2 == 2) {
            setResult(2);
            if (this.f7006k != null && this.f7006k.equals("personalbasicinfosetting")) {
                Intent intent2 = new Intent();
                intent2.setClassName(this.f6996a, "com.huawei.bone.root.MainActivity");
                startActivity(intent2);
            }
            if (this.f7007l) {
                m10539t();
            }
            if (this.f7008m) {
                m10538s();
            }
            finish();
        }
        C2538c.m12677c("AddDeviceActivity", "===123===Enter onActivityResult():REQUEST_GPS_LOCATION = " + i + "isGotoNextPage" + this.f6981F);
        if (11 == i && !this.f6981F) {
            m10521g();
        }
        super.onActivityResult(i, i2, intent);
    }

    private void m10538s() {
        PluginPay instance = PluginPay.getInstance(this.f6987L);
        instance.setAdapter(b.a());
        instance.goToCardListActivity();
    }

    private void m10539t() {
        a a = a.a(this.f6987L);
        a.setAdapter(v.a());
        a.a();
    }

    private void m10497b(int i) {
        C1973a.m10285a(this, i, this.f7006k);
    }

    private void m10485a(long j) {
        if (j >= 0) {
            this.f6983H = ((BluetoothDevice) this.f7014s.get((int) j)).getAddress();
            this.f6982G = ((BluetoothDevice) this.f7014s.get((int) j)).getName();
            if (this.f6982G == null) {
                this.f6985J.sendEmptyMessage(28);
                return;
            }
            this.f6981F = true;
            C1988p c1988p = this.f6998c;
            int a = C1988p.m10380a(this.f6982G);
            C1988p c1988p2 = this.f6998c;
            C1988p c1988p3 = this.f6998c;
            m10482a(a, c1988p2.m10391b(C1988p.m10380a(this.f6982G)));
        }
    }

    private void m10540u() {
        C2538c.m12677c("AddDeviceActivity", "===123==Enter startScanDevices");
        if (this.f7014s != null) {
            this.f7014s.clear();
            this.f7013r.m11329a(this.f7014s);
        }
        this.f7021z.start();
        m10492a(true);
        this.f6985J.sendEmptyMessageDelayed(14, 3000);
        this.f6985J.sendEmptyMessage(12);
        this.f6985J.sendEmptyMessageDelayed(13, 10000);
    }

    private void m10541v() {
        C2538c.m12677c("AddDeviceActivity", "===123==Enter scanBRDevice");
        C4600d dVar = this.f7015t;
        C1988p c1988p = this.f6998c;
        dVar.a(C1988p.m10382f(), 2, this.f6993R);
        C2203i c2203i = this.f7013r;
        c1988p = this.f6998c;
        c2203i.m11331b(C1988p.m10382f());
        this.f6985J.sendEmptyMessageDelayed(11, 2000);
    }

    private void m10542w() {
        C2538c.m12677c("AddDeviceActivity", "===123==Enter scanBLEDevice");
        C4600d dVar = this.f7015t;
        C1988p c1988p = this.f6998c;
        dVar.a(C1988p.m10383g(), 1, this.f6993R);
        C2203i c2203i = this.f7013r;
        c1988p = this.f6998c;
        c2203i.m11331b(C1988p.m10382f());
        this.f6985J.sendEmptyMessageDelayed(12, 6000);
    }

    private synchronized void m10486a(BluetoothDevice bluetoothDevice) {
        boolean z;
        String name = bluetoothDevice.getName();
        for (BluetoothDevice bluetoothDevice2 : this.f7014s) {
            if (bluetoothDevice2 != null && bluetoothDevice2.getAddress() != null && bluetoothDevice2.getAddress().equals(bluetoothDevice.getAddress())) {
                z = true;
                break;
            }
        }
        z = false;
        C2538c.m12661a("01", 0, "AddDeviceActivity", "addDeviceToList, flag =" + z);
        if (!z) {
            if (this.f7013r != null && this.f7013r.m11330a(name) && m10503b(name)) {
                this.f7014s.add(bluetoothDevice);
                this.f6985J.post(new C2008j(this));
                this.f6985J.sendEmptyMessage(27);
            }
        }
    }

    private boolean m10503b(String str) {
        if (this.f6998c.m10394c().equals(str)) {
            return false;
        }
        return true;
    }

    private void m10506c(int i) {
        View view = this.f7013r.getView(0, null, this.f7016u);
        view.measure(0, 0);
        view.getMeasuredHeight();
        int measuredHeight = view.getMeasuredHeight();
        int dividerHeight = this.f7016u.getDividerHeight();
        LayoutParams layoutParams = this.f7016u.getLayoutParams();
        layoutParams.width = -1;
        if (i > 2) {
            layoutParams.height = (measuredHeight + dividerHeight) * 3;
        } else {
            layoutParams.height = (measuredHeight + dividerHeight) * i;
        }
        this.f7016u.setLayoutParams(layoutParams);
    }

    private void m10490a(C2203i c2203i) {
        C2538c.m12677c("AddDeviceActivity", "===123==Enter  = setDeviceScanListAdapter mBTDeviceList" + this.f7014s);
        this.f7013r = c2203i;
        this.f7013r.m11329a(this.f7014s);
    }

    private void m10543x() {
        try {
            unregisterReceiver(this.f6994S);
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("AddDeviceActivity", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("AddDeviceActivity", e2.getMessage());
        }
    }
}
