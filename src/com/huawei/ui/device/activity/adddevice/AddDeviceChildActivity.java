package com.huawei.ui.device.activity.adddevice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdevicefontmgr.C1021a;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.hwservicesmgr.C1047b;
import com.huawei.n.b;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.p137a.C1383f;
import com.huawei.u.a;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.activity.pairing.DevicePairGuideActivity;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1973a;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1996x;
import com.huawei.ui.device.views.p172a.C2185a;
import com.huawei.ui.device.views.p172a.C2187c;
import java.util.ArrayList;

public class AddDeviceChildActivity extends BaseActivity {
    private Context f7022a;
    private ListView f7023b;
    private C1988p f7024c;
    private DeviceInfo f7025d;
    private int f7026e;
    private ArrayList<C2187c> f7027f = new ArrayList();
    private C2185a f7028g = null;
    private CustomTitleBar f7029h;
    private CustomTitleBar f7030i;
    private LinearLayout f7031j;
    private View f7032k;
    private String f7033l = "";
    private int f7034m = 0;
    private C1047b f7035n = new C2012n(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7022a = BaseApplication.m2632b();
        C2538c.m12677c("AddDeviceChildActivity", "onCreate()");
        m10548a();
        m10555b();
    }

    private void m10548a() {
        C1026q.m4018a(this.f7022a);
        C1204c.m5370a(this.f7022a);
        a.a();
        com.huawei.i.a.a(this.f7022a);
        com.huawei.h.a.a(this.f7022a);
        C1021a.m3912a(this.f7022a);
        if (this.f7022a != null) {
            this.f7024c = C1988p.m10381a(BaseApplication.m2632b());
        }
        this.f7033l = getIntent().getStringExtra("personalbasicinfosettingflag");
        C2538c.m12677c("AddDeviceChildActivity", "initListView() personalBasicInfoSettingflag = " + this.f7033l);
    }

    private void m10555b() {
        setContentView(f.activity_select_device_black);
        this.f7029h = (CustomTitleBar) d.a(this, e.select_device_title_bar);
        this.f7030i = (CustomTitleBar) d.a(this, e.select_device_detail_title_bar);
        this.f7029h.setVisibility(8);
        this.f7030i.setVisibility(0);
        this.f7023b = (ListView) d.a(this, e.list_setup_device);
        this.f7031j = (LinearLayout) d.a(this, e.pair_guide_scan_linearlayout);
        this.f7032k = d.a(this, e.pair_guide_scan_text_device_seach_bottom_view);
        this.f7031j.setVisibility(8);
        this.f7032k.setVisibility(8);
        m10560c();
    }

    private void m10560c() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f7034m = intent.getIntExtra("style", 0);
            C2538c.m12677c("AddDeviceChildActivity", "initListView() style : " + this.f7034m);
            switch (this.f7034m) {
                case 1:
                    m10561d();
                    return;
                case 2:
                    m10562e();
                    return;
                case 3:
                    m10563f();
                    return;
                case 4:
                    m10564g();
                    return;
                default:
                    return;
            }
        }
    }

    private void m10561d() {
        C2538c.m12677c("AddDeviceChildActivity", "initViewForWatch");
        this.f7030i.setTitleText(this.f7022a.getString(i.IDS_add_device_smart_watch));
        if (!this.f7027f.isEmpty()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForWatch() mList.clear()");
            this.f7027f.clear();
        }
        for (b bVar : C1973a.m10290d()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForWatch() type:" + bVar.g());
            m10550a(bVar.g(), bVar.j(), bVar.h(), bVar.i());
        }
        this.f7028g = new C2185a(this, this.f7027f);
        this.f7023b.setAdapter(this.f7028g);
    }

    private void m10562e() {
        C2538c.m12677c("AddDeviceChildActivity", "initViewForBand");
        this.f7030i.setTitleText(this.f7022a.getString(i.IDS_add_device_smart_band));
        if (!this.f7027f.isEmpty()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForBand() mList.clear()");
            this.f7027f.clear();
        }
        for (b bVar : C1973a.m10288b()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForBand() type:" + bVar.g());
            m10550a(bVar.g(), bVar.j(), bVar.h(), bVar.i());
        }
        this.f7028g = new C2185a(this, this.f7027f);
        this.f7023b.setAdapter(this.f7028g);
    }

    private void m10563f() {
        C2538c.m12677c("AddDeviceChildActivity", "initViewForKid");
        this.f7030i.setTitleText(this.f7022a.getString(i.IDS_add_device_kids_watch));
        if (!this.f7027f.isEmpty()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForKid() mList.clear()");
            this.f7027f.clear();
        }
        for (b bVar : C1973a.m10292f()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForKid() type:" + bVar.g());
            m10550a(bVar.g(), bVar.j(), bVar.h(), bVar.i());
        }
        this.f7028g = new C2185a(this, this.f7027f);
        this.f7023b.setAdapter(this.f7028g);
    }

    private void m10564g() {
        C2538c.m12677c("AddDeviceChildActivity", "initViewForEar");
        this.f7030i.setTitleText(this.f7022a.getString(i.IDS_add_device_smart_headphones));
        if (!this.f7027f.isEmpty()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForEar() mList.clear()");
            this.f7027f.clear();
        }
        for (b bVar : C1973a.m10294h()) {
            C2538c.m12677c("AddDeviceChildActivity", "initViewForEar() type:" + bVar.g());
            m10550a(bVar.g(), bVar.j(), bVar.h(), bVar.i());
        }
        this.f7028g = new C2185a(this, this.f7027f);
        this.f7023b.setAdapter(this.f7028g);
    }

    private void m10550a(int i, String str, String str2, int i2) {
        C2187c a = C1973a.m10282a(i, str, str2, i2);
        a.m11204a(new C2015q(this, a));
        this.f7027f.add(a);
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12677c("AddDeviceChildActivity", "onDestroy()");
    }

    public void onBackPressed() {
        super.onBackPressed();
        C2538c.m12677c("AddDeviceChildActivity", "onBackPressed()");
    }

    protected void onStart() {
        C2538c.m12677c("AddDeviceChildActivity", "onStart()");
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    private void m10552a(int i, String str, boolean z) {
        C2538c.m12677c("AddDeviceChildActivity", "enter hasSelectDevice():需要连接的设备为：" + i);
        this.f7026e = i;
        b a = C1973a.m10281a(i);
        switch (i) {
            case -3:
                m10565h();
                return;
            case -2:
                m10549a(i);
                return;
            case 2:
                m10566i();
                return;
            case 3:
            case 10:
                m10568k();
                return;
            case 9:
                m10567j();
                return;
            default:
                C2538c.m12677c("AddDeviceChildActivity", "start enterDevicePairGuide");
                m10551a(a.g(), a.j(), str, z);
                return;
        }
    }

    private void m10549a(int i) {
        finish();
        if (this.f7024c != null) {
            C1988p c1988p = this.f7024c;
            C1988p c1988p2 = this.f7024c;
            c1988p.m10386a(C1988p.m10379a(i), this.f7022a.getString(i.IDS_messagecenter_color_band_name), C1996x.m10456a(i), this.f7035n, null);
        }
    }

    private void m10565h() {
        Intent intent = new Intent();
        intent.setClassName(this.f7022a, "com.huawei.bone.root.MainActivity");
        startActivity(intent);
        finish();
    }

    private void m10551a(int i, String str, String str2, boolean z) {
        Intent intent = new Intent(this.f7022a, DevicePairGuideActivity.class);
        if (this.f7033l != null && this.f7033l.equals("personalbasicinfosetting")) {
            intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
        }
        intent.putExtra("pairGuideProductType", i);
        intent.putExtra("pairGuideProductName", str);
        intent.putExtra("isPorc", z);
        intent.putExtra("pairGuideSelectName", str2);
        intent.putExtra("pairGuideFromScanList", false);
        startActivityForResult(intent, 1);
    }

    private void m10566i() {
        if (this.f7033l != null && this.f7033l.equals("personalbasicinfosetting") && C1383f.m6188a(this.f7022a).m6194d()) {
            C1383f.m6188a(this.f7022a).m6189a(5);
        } else {
            C1383f.m6188a((Context) this).m6192b(5);
        }
    }

    private void m10567j() {
        if (this.f7033l != null && this.f7033l.equals("personalbasicinfosetting") && C1383f.m6188a(this.f7022a).m6195e()) {
            C1383f.m6188a(this.f7022a).m6189a(7);
        } else {
            C1383f.m6188a((Context) this).m6192b(7);
        }
    }

    private void m10568k() {
        Intent intent = new Intent(this.f7022a, DevicePairGuideActivity.class);
        if (this.f7033l != null && this.f7033l.equals("personalbasicinfosetting")) {
            intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
        }
        intent = m10545a(intent);
        if (10 == this.f7026e) {
            intent.putExtra("pairGuideProductType", 10);
            intent.putExtra("pairGuideProductName", this.f7022a.getString(i.IDS_app_display_name_leo));
        } else {
            intent.putExtra("pairGuideProductType", 3);
            intent.putExtra("pairGuideProductName", this.f7022a.getString(i.IDS_app_display_name_w1));
        }
        intent.putExtra("pairGuideFromScanList", false);
        startActivityForResult(intent, 1);
    }

    private Intent m10545a(Intent intent) {
        if (m10558b(this.f7026e)) {
            DeviceInfo a = this.f7024c.m10384a();
            if (a != null) {
                C2538c.m12677c("AddDeviceChildActivity", "enterW1PairGuide deviceInfo=========" + a.toString());
                if (m10558b(a.getProductType()) && 2 == a.getDeviceConnectState()) {
                    intent.putExtra("pairGuideW1Success", true);
                }
            }
        } else {
            intent.putExtra("pairGuideW1Success", false);
        }
        return intent;
    }

    private boolean m10558b(int i) {
        if (i == 3 || i == 10) {
            return true;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C2538c.m12677c("AddDeviceChildActivity", "Enter onActivityResult():personalBasicInfoSettingflag = " + this.f7033l);
        if (1 == i && i2 == 2) {
            setResult(2);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    private void m10556b(int i, String str, boolean z) {
        int productType = this.f7025d.getProductType();
        String deviceName = this.f7025d.getDeviceName();
        String b = this.f7024c.m10391b(productType);
        if (11 == i && "HUAWEI CM-R1P".equals(deviceName)) {
            b = this.f7022a.getString(i.IDS_huawei_r1_pro_content);
        }
        deviceName = this.f7024c.m10391b(i);
        C2538c.m12677c("AddDeviceChildActivity", "新设备=" + deviceName + ", 旧设备=" + b);
        if (11 == i && ("HUAWEI CM-R1P".equals(str) || this.f7022a.getString(i.IDS_huawei_r1_pro_content).equals(str) || this.f7022a.getString(i.IDS_device_r1_pro_name_title).equals(str))) {
            deviceName = this.f7022a.getString(i.IDS_huawei_r1_pro_content);
        }
        u a = new w(this).a(i.IDS_device_replace_dialog_title_notification).b(String.format(getResources().getString(i.IDS_replace_device_dialog_content), new Object[]{b, deviceName})).b(i.IDS_settings_button_cancal, new C2014p(this)).a(i.IDS_settings_button_ok, new C2013o(this, i, str, z)).a();
        a.setCanceledOnTouchOutside(false);
        a.show();
    }
}
