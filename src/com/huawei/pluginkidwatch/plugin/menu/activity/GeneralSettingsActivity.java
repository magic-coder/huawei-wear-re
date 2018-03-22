package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.entity.model.UnbindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.j;
import com.huawei.pluginkidwatch.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GeneralSettingsActivity extends KidWatchBaseActivity {
    private OnClickListener f5730A = new eg(this);
    private OnClickListener f5731B = new eh(this);
    private OnClickListener f5732C = new ei(this);
    private Context f5733b;
    private C1413d f5734c = null;
    private ListView f5735d;
    private TextView f5736e;
    private Button f5737f;
    private LinearLayout f5738g;
    private C1507h f5739h;
    private CustomDialog f5740i = null;
    private er f5741j;
    private boolean f5742k = true;
    private boolean f5743l = true;
    private boolean f5744m = true;
    private boolean f5745n = false;
    private Handler f5746o = new Handler();
    private ArrayList<eu> f5747p = new ArrayList();
    private C1507h f5748q = null;
    private LinearLayout f5749r;
    private LinearLayout f5750s;
    private LinearLayout f5751t;
    private CheckBox f5752u;
    private CheckBox f5753v;
    private TextView f5754w;
    private int f5755x = 0;
    private String f5756y = "";
    private Runnable f5757z = new ek(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_general_setting);
        this.f5733b = this;
        this.f5745n = false;
        m9401d();
    }

    private void m9401d() {
        this.f5735d = (ListView) findViewById(g.menu_general_setting_list);
        this.f5741j = new er(this, this, this.f5747p);
        m9405e();
        this.f5735d.setAdapter(this.f5741j);
        this.f5735d.setOnItemClickListener(new ea(this));
        this.f5738g = (LinearLayout) findViewById(g.menu_settings_net_panel);
        this.f5736e = (TextView) findViewById(g.settings_net_tip_view);
        this.f5737f = (Button) findViewById(g.menu_settings_net_restart);
        this.f5737f.setOnClickListener(new ej(this));
        m9414j();
    }

    private void m9405e() {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==ww== get fetchChangeLog = success==showDialog");
        if (this.f5748q == null) {
            this.f5748q = new C1507h(this.f5733b, SdkConstants.REQUEST_CAMERA_VIDEO, 226, h.dialog_navigation_choice_map, m.servicedialog, false);
        }
        m9421m();
    }

    private void m9393a(boolean z) {
        int i;
        int i2 = 8;
        LinearLayout linearLayout = this.f5738g;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        Button button = this.f5737f;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        button.setVisibility(i);
        TextView textView = this.f5736e;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        ListView listView = this.f5735d;
        if (!z) {
            i2 = 0;
        }
        listView.setVisibility(i2);
    }

    private void m9386a(int i, String str, boolean z) {
        if (this.f5734c != null) {
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "===============Enter resetFactory");
            CommonRetOModel commonRetOModel = new CommonRetOModel();
            commonRetOModel.data = str;
            commonRetOModel.deviceCode = C1462f.m6746j();
            commonRetOModel.type = i;
            this.f5734c.mo2473a(commonRetOModel, new el(this, z));
        }
    }

    private void m9407f() {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "===============Enter resetSuccess");
        if (C1462f.m6748k() != null) {
            C1492l.m6911a(getBaseContext(), a.B.a(), !String.valueOf(1).equals(C1462f.m6748k().f3099s) ? "k1" : "k2", C1462f.m6748k().f3096p);
        }
        C1392h.m6283a(this.f5733b, C1462f.m6748k());
        C1392h.m6306d(this.f5733b, C1462f.m6746j());
        C1392h.m6310e(this.f5733b, C1462f.m6746j());
        C1462f.m6718a(null);
        C1462f.m6731d("");
        C1462f.m6722a(true);
        C1497q.m6943a(this.f5733b, "sharedpreferences_watch_device_code", "");
        C1483c.m6824a(this.f5733b, C1680l.IDS_plugin_kidwatch_menu_reset_success);
        finish();
    }

    private void m9408g() {
        if (C1462f.m6754n()) {
            if (this.f5739h == null) {
                this.f5739h = new C1507h(this.f5733b, -1, -1, h.dialog_reset_factory, m.servicedialog, false);
            }
            this.f5739h.show();
            this.f5739h.findViewById(g.common_confirm_dialog_cancle).setOnClickListener(new em(this));
            this.f5739h.findViewById(g.common_confirm_dialog_sure).setOnClickListener(new en(this));
            return;
        }
        C1595v c1595v = new C1595v(this.f5733b);
        c1595v.m7339a(C1680l.IDS_plugin_kidwatch_menu_unbindself_title);
        c1595v.m7348b(C1680l.f4405xefc22b48);
        c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new eo(this));
        c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new ep(this));
        this.f5740i = c1595v.m7338a();
        this.f5740i.show();
    }

    private void m9411h() {
        if (this.f5734c != null) {
            C1506g.m6978a(this.f5733b, this.f5733b.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_unbindself_loading), false);
            UnbindDeviceIOEntityModel unbindDeviceIOEntityModel = new UnbindDeviceIOEntityModel();
            unbindDeviceIOEntityModel.setDeviceCode(C1462f.m6746j());
            C1497q.m6942a(this.f5733b, "isunbindself", Boolean.valueOf(true));
            this.f5734c.mo2499a(unbindDeviceIOEntityModel, new eq(this));
        }
    }

    private void m9413i() {
        if (this.f5747p != null) {
            eu euVar;
            m9393a(false);
            this.f5747p.clear();
            if (C1490j.m6890a("DMS_MuteSwitch")) {
                C2538c.m12674b("AbilitySet", "========== GeneralSetting support Mute switch!");
                euVar = new eu();
                euVar.f6098a = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_shake_remind_title);
                euVar.f6099b = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_shake_remind_content_tip);
                euVar.f6100c = this.f5742k;
                euVar.f6101d = 0;
                euVar.f6102e = "mute_switch_tag";
                this.f5747p.add(euVar);
            }
            if (C1490j.m6890a("DMS_SosSwitch")) {
                C2538c.m12674b("AbilitySet", "========== GeneralSetting support SOS switch!");
                euVar = new eu();
                euVar.f6098a = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_sos_call_help_title);
                String string = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_sos_call_help_content_tip);
                Object[] objArr = new Object[1];
                objArr[0] = getResources().getQuantityString(j.IDS_plugin_kidwatch_common_second_unit, 5, new Object[]{Integer.valueOf(5)});
                euVar.f6099b = String.format(string, objArr);
                euVar.f6100c = this.f5743l;
                euVar.f6101d = 0;
                euVar.f6102e = "sos_switch_tag";
                this.f5747p.add(euVar);
            }
            if (C1490j.m6890a("CS_IncomingcallSwitch")) {
                C2538c.m12677c("AbilitySet", "========== GeneralSetting support incoming reject switch!");
                euVar = new eu();
                euVar.f6098a = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_rejection_incoming_title);
                euVar.f6099b = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_rejection_incoming_content_tip);
                euVar.f6100c = this.f5744m;
                euVar.f6101d = 0;
                euVar.f6102e = "reject_call_tag";
                this.f5747p.add(euVar);
            }
            C2538c.m12677c("KIDWATCH_GeneralSettingsActivity", "===www===AbilitySet mK1DeviceType = " + C1467b.m6787c(this.f5733b));
            if (7 == C1467b.m6787c(this.f5733b)) {
                euVar = new eu();
                euVar.f6098a = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_map_title);
                euVar.f6099b = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_need_choice_map);
                euVar.f6101d = 2;
                euVar.f6102e = "map_reset_tag";
                this.f5747p.add(euVar);
                if (this.f5741j != null) {
                    this.f5741j.m9610a(this.f5747p);
                }
            }
            C2538c.m12674b("===www===AbilitySet KWCache.getWATCH_DEVICE_IMEI()11111" + this.f5756y, new Object[0]);
            if (!"".equals(this.f5756y)) {
                euVar = new eu();
                euVar.f6098a = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_Imei_show_title);
                euVar.f6099b = String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_Imei_show_content), new Object[]{this.f5756y});
                euVar.f6101d = 3;
                euVar.f6102e = "imei_show_tag";
                this.f5747p.add(euVar);
            }
            euVar = new eu();
            if (C1462f.m6754n()) {
                euVar.f6098a = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_reset_factory);
            } else {
                euVar.f6098a = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_unbindself_title);
            }
            euVar.f6101d = 1;
            euVar.f6102e = "reset_factory_tag";
            C2538c.m12674b("===www===AbilitySet  show reset factory or release device", new Object[0]);
            this.f5747p.add(euVar);
        }
    }

    private void m9414j() {
        this.f5745n = false;
        if (this.f5737f != null) {
            this.f5737f.setVisibility(8);
        }
        if (this.f5736e != null) {
            this.f5736e.setText(C1680l.IDS_plugin_kidwatch_menu_peroid_get_data);
        }
        if (this.f5734c == null) {
            this.f5734c = C1417a.m6594a(getApplicationContext());
        }
        m9391a("muteSwitch");
        m9417k();
    }

    private void m9391a(String str) {
        if (this.f5734c == null || !C1483c.m6831b(C1462f.m6746j())) {
            C2538c.m12677c("KIDWATCH_GeneralSettingsActivity", "=========== getGeneralSettingInfoFromCloud deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
            return;
        }
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "========== Enter getGeneralSettingInfoFromCloud");
        GetWatchSettingModel getWatchSettingModel = new GetWatchSettingModel();
        getWatchSettingModel.deviceCode = C1462f.m6746j();
        getWatchSettingModel.settingType = str;
        this.f5734c.mo2487a(getWatchSettingModel, new eb(this, str));
    }

    private void m9417k() {
        if (C1483c.m6831b(C1462f.m6746j())) {
            GetDeviceModel getDeviceModel = new GetDeviceModel();
            getDeviceModel.deviceCode = C1462f.m6746j();
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "===============model.deviceCode" + C1462f.m6746j());
            this.f5734c.mo2482a(getDeviceModel, new ed(this));
            return;
        }
        C2538c.m12677c("KIDWATCH_GeneralSettingsActivity", "=========== getImeiFromCloud deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
    }

    private void m9392a(String str, boolean z) {
        int i = 0;
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "=========Enter changeSettingsInfoState");
        if (z) {
            i = 1;
        }
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        Map hashMap = new HashMap();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        hashMap.put(str, Integer.valueOf(i));
        setWatchSettingIOModel.settingMap = hashMap;
        m9387a(setWatchSettingIOModel, str, z);
    }

    private void m9387a(SetWatchSettingIOModel setWatchSettingIOModel, String str, boolean z) {
        if (this.f5734c != null) {
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==========Enter saveSettingsInfoToCloud");
            this.f5734c.mo2496a(setWatchSettingIOModel, new ee(this, str, z));
        }
    }

    private void m9397b(String str, boolean z) {
        if (str.equals("muteSwitch")) {
            this.f5742k = z;
            if (!this.f5745n) {
                m9391a("SOSSwitch");
            }
        }
        if (str.equals("SOSSwitch")) {
            this.f5743l = z;
            if (!this.f5745n) {
                m9391a("incomingcallswitch");
            }
        }
        if (str.equals("incomingcallswitch")) {
            this.f5744m = z;
            this.f5745n = true;
        }
        if (this.f5746o != null && this.f5745n) {
            this.f5746o.post(new ef(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f5740i != null) {
            this.f5740i.dismiss();
            this.f5740i = null;
        }
        if (this.f5739h != null) {
            this.f5739h.dismiss();
            this.f5739h = null;
        }
        this.f5746o = null;
    }

    private void m9385a(int i) {
        int firstVisiblePosition = this.f5735d.getFirstVisiblePosition();
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", " ====www==== updateAdapterView" + firstVisiblePosition + "itemIndex" + i);
        if (i - firstVisiblePosition >= 0) {
            this.f5741j.m9609a(this.f5735d.getChildAt(i - firstVisiblePosition));
        }
    }

    private void m9419l() {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==ww== get fetchChangeLog = success==showDialog");
        if (!isFinishing() && this.f5748q != null) {
            m9422n();
            this.f5748q.show();
        }
    }

    private void m9421m() {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "Enter generalSettingsActivity initDialogContent");
        this.f5749r = (LinearLayout) this.f5748q.findViewById(g.layout_gaode_map_linearLayout);
        this.f5751t = (LinearLayout) this.f5748q.findViewById(g.layout_no_map_linearLayout);
        this.f5752u = (CheckBox) this.f5748q.findViewById(g.layout_gaode_map_radio);
        this.f5750s = (LinearLayout) this.f5748q.findViewById(g.layout_baidu_map_linearLayout);
        this.f5753v = (CheckBox) this.f5748q.findViewById(g.layout_baidu_map_radio);
        this.f5754w = (TextView) this.f5748q.findViewById(g.menu_setting_navigation_cancle);
        this.f5750s.setOnClickListener(this.f5731B);
        this.f5754w.setOnClickListener(this.f5732C);
        this.f5749r.setOnClickListener(this.f5730A);
        m9422n();
    }

    private void m9422n() {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==map==Enter dialogContent()");
        if (C1483c.m6826a(getApplication(), "com.baidu.BaiduMap") || C1483c.m6826a(getApplication(), "com.autonavi.minimap")) {
            if (C1483c.m6826a(getApplication(), "com.baidu.BaiduMap")) {
                this.f5750s.setVisibility(0);
            } else {
                this.f5750s.setVisibility(8);
                this.f5751t.setVisibility(8);
            }
            if (C1483c.m6826a(getApplication(), "com.autonavi.minimap")) {
                this.f5749r.setVisibility(0);
                return;
            }
            this.f5749r.setVisibility(8);
            this.f5751t.setVisibility(8);
            return;
        }
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==map==Enter no map");
        this.f5751t.setVisibility(0);
        this.f5750s.setVisibility(8);
        this.f5749r.setVisibility(8);
        C1491k.m6895a(this.f5733b, "save_navigation_map", 5);
    }
}
