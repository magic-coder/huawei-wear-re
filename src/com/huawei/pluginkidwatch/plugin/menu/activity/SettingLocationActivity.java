package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.google.gson.Gson;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.PositioningFrequency;
import com.huawei.pluginkidwatch.common.entity.model.PositioningStrategy;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.button.SlipButtonView;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.common.ui.view.WaitingLineView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingLocationActivity extends KidWatchBaseActivity implements OnClickListener {
    private SlipButtonView f5843b;
    private RelativeLayout f5844c;
    private RelativeLayout f5845d;
    private RelativeLayout f5846e = null;
    private RelativeLayout f5847f = null;
    private Context f5848g;
    private LinearLayout f5849h;
    private ImageView f5850i;
    private C1413d f5851j = null;
    private LinearLayout f5852k;
    private LinearLayout f5853l;
    private View f5854m;
    private View f5855n;
    private View f5856o;
    private Button f5857p;
    private CheckBox f5858q;
    private CheckBox f5859r;
    private CheckBox f5860s;
    private TextView f5861t;
    private int f5862u = 1;
    private Gson f5863v;
    private WaitingLineView f5864w;
    private CustomDialog f5865x = null;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_location);
        m9510d();
    }

    private void m9510d() {
        this.f5848g = this;
        this.f5863v = new Gson();
        this.f5851j = C1417a.m6594a(getApplicationContext());
        this.f5852k = (LinearLayout) findViewById(g.menu_location_retry);
        this.f5843b = (SlipButtonView) findViewById(g.menu_location_switch);
        this.f5843b.setVisibility(8);
        this.f5844c = (RelativeLayout) findViewById(g.menu_location_define);
        this.f5845d = (RelativeLayout) findViewById(g.menu_location_moren_pannel);
        this.f5853l = (LinearLayout) findViewById(g.menu_location_moren_lly);
        this.f5853l.setVisibility(0);
        this.f5849h = (LinearLayout) findViewById(g.menu_location_lly);
        this.f5850i = (ImageView) findViewById(g.menu_location_cancle);
        this.f5864w = (WaitingLineView) findViewById(g.menu_add_location_wait_line);
        this.f5864w.setVisibility(8);
        this.f5856o = findViewById(g.view_custom);
        this.f5857p = (Button) findViewById(g.menu_location_net_restart);
        this.f5846e = (RelativeLayout) findViewById(g.menu_saving_frequency_pannel);
        this.f5846e.setOnClickListener(this);
        this.f5847f = (RelativeLayout) findViewById(g.menu_custom_frequency_pannel);
        this.f5847f.setOnClickListener(this);
        this.f5854m = findViewById(g.view_saving);
        this.f5855n = findViewById(g.view_location);
        this.f5858q = (CheckBox) findViewById(g.menu_saving_frequency_radio);
        this.f5859r = (CheckBox) findViewById(g.menu_location_radio);
        this.f5860s = (CheckBox) findViewById(g.menu_custom_frequency_radio);
        this.f5861t = (TextView) findViewById(g.tv_saving_description);
        this.f5861t.setText(String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_power_saving_frequency_detail_description2), new Object[]{"40%"}));
        this.f5845d.setOnClickListener(this);
        this.f5850i.setOnClickListener(this);
        this.f5844c.setOnClickListener(this);
        this.f5857p.setOnClickListener(this);
        if (C1492l.m6916b(this.f5848g)) {
            C1506g.m6978a(this.f5848g, this.f5848g.getResources().getString(C1680l.IDS_plugin_kidwatch_common_loading), false);
            m9522j();
            return;
        }
        m9506a(false);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (g.menu_location_define == id) {
            Intent intent = new Intent();
            intent.setClass(this.f5848g, CustomLocationActivity.class);
            startActivity(intent);
        } else if (g.menu_location_cancle == id) {
            finish();
        } else if (g.menu_location_net_restart == id) {
            C1506g.m6978a(this.f5848g, this.f5848g.getResources().getString(C1680l.IDS_plugin_kidwatch_common_loading), false);
            m9522j();
        } else if (g.menu_saving_frequency_pannel == id) {
            if (this.f5862u != 0) {
                m9513e();
            }
        } else if (g.menu_location_moren_pannel == id) {
            if (1 != this.f5862u) {
                m9516g();
            }
        } else if (g.menu_custom_frequency_pannel == id && 2 != this.f5862u) {
            m9519h();
        }
    }

    private void m9506a(boolean z) {
        if (z) {
            this.f5845d.setVisibility(0);
            this.f5844c.setVisibility(0);
            this.f5852k.setVisibility(8);
            this.f5856o.setVisibility(0);
            this.f5846e.setVisibility(0);
            this.f5847f.setVisibility(0);
            this.f5854m.setVisibility(0);
            this.f5855n.setVisibility(0);
        } else {
            this.f5845d.setVisibility(8);
            this.f5844c.setVisibility(8);
            this.f5852k.setVisibility(0);
            this.f5856o.setVisibility(8);
            this.f5846e.setVisibility(8);
            this.f5847f.setVisibility(8);
            this.f5854m.setVisibility(8);
            this.f5855n.setVisibility(8);
        }
        if (!C1490j.m6890a("LCS_PowerSaveMode")) {
            this.f5846e.setVisibility(8);
            this.f5854m.setVisibility(8);
        }
    }

    private void m9503a(int i) {
        C1462f.m6715a(i);
        switch (i) {
            case 0:
                this.f5858q.setChecked(true);
                this.f5859r.setChecked(false);
                this.f5860s.setChecked(false);
                return;
            case 1:
                this.f5858q.setChecked(false);
                this.f5859r.setChecked(true);
                this.f5860s.setChecked(false);
                return;
            case 2:
                this.f5858q.setChecked(false);
                this.f5859r.setChecked(false);
                this.f5860s.setChecked(true);
                C1462f.m6747j("");
                C1462f.m6749k("");
                C1462f.m6751l("");
                m9524l();
                return;
            default:
                return;
        }
    }

    private void m9513e() {
        C2538c.m12677c("SettingLocationActivity", "=======Enter showStartSavingFrequencyDialog");
        if (this.f5865x == null || !this.f5865x.isShowing()) {
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_power_saving_frequency_start2);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_power_saving_frequency_start_description2);
            c1595v.m7347a(false);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_power_start, new fx(this));
            c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new fy(this));
            this.f5865x = c1595v.m7338a();
            this.f5865x.show();
            C2538c.m12677c("SettingLocationActivity", "=======Leave showStartSavingFrequencyDialog");
            return;
        }
        C2538c.m12677c("SettingLocationActivity", "=======Leave showStartSavingFrequencyDialog 1111");
    }

    private void m9515f() {
        C2538c.m12674b("SettingLocationActivity", "Enter openSavingFrequency");
        this.f5864w.setVisibility(0);
        this.f5864w.m7206a(true);
        C1462f.f3374c = true;
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        Map hashMap = new HashMap();
        PositioningStrategy positioningStrategy = new PositioningStrategy();
        positioningStrategy.setPositioningMode(0);
        positioningStrategy.setPositioningFrequencyList(null);
        hashMap.put("PositioningStrategy", positioningStrategy);
        setWatchSettingIOModel.settingMap = hashMap;
        this.f5851j.mo2496a(setWatchSettingIOModel, new fz(this));
        C2538c.m12674b("SettingLocationActivity", "Leave openSavingFrequency");
    }

    private void m9516g() {
        C2538c.m12674b("SettingLocationActivity", "Enter openIntelligentFrequency");
        this.f5864w.setVisibility(0);
        this.f5864w.m7206a(true);
        C1462f.f3374c = true;
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        Map hashMap = new HashMap();
        PositioningStrategy positioningStrategy = new PositioningStrategy();
        positioningStrategy.setPositioningMode(1);
        positioningStrategy.setPositioningFrequencyList(null);
        hashMap.put("PositioningStrategy", positioningStrategy);
        setWatchSettingIOModel.settingMap = hashMap;
        this.f5851j.mo2496a(setWatchSettingIOModel, new ga(this));
        C2538c.m12674b("SettingLocationActivity", "Leave openIntelligentFrequency");
    }

    private void m9519h() {
        C2538c.m12674b("SettingLocationActivity", "Enter closeIntelligentFrequency");
        this.f5864w.setVisibility(0);
        this.f5864w.m7206a(true);
        C1462f.f3374c = false;
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        List i = m9520i();
        Map hashMap = new HashMap();
        PositioningStrategy positioningStrategy = new PositioningStrategy();
        positioningStrategy.setPositioningMode(2);
        hashMap.put("PositioningStrategy", positioningStrategy);
        positioningStrategy.setPositioningFrequencyList(i);
        setWatchSettingIOModel.settingMap = hashMap;
        this.f5851j.mo2496a(setWatchSettingIOModel, new gb(this));
        C2538c.m12674b("SettingLocationActivity", "Leave closeIntelligentFrequency");
    }

    private List<PositioningFrequency> m9520i() {
        List<PositioningFrequency> arrayList = new ArrayList();
        PositioningFrequency positioningFrequency = new PositioningFrequency();
        positioningFrequency.cycle = "1234567";
        positioningFrequency.endTime = "0800";
        positioningFrequency.startTime = "0700";
        positioningFrequency.strategyType = 1;
        positioningFrequency.label = this.f5848g.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotoschool);
        PositioningFrequency positioningFrequency2 = new PositioningFrequency();
        positioningFrequency2.cycle = "1234567";
        positioningFrequency2.endTime = "1700";
        positioningFrequency2.startTime = "1600";
        positioningFrequency2.strategyType = 1;
        positioningFrequency2.label = this.f5848g.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotohome);
        PositioningFrequency positioningFrequency3 = new PositioningFrequency();
        positioningFrequency3.cycle = "1234567";
        positioningFrequency3.endTime = "0600";
        positioningFrequency3.startTime = "0000";
        positioningFrequency3.strategyType = 2;
        positioningFrequency3.label = this.f5848g.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotobed);
        arrayList.add(positioningFrequency);
        arrayList.add(positioningFrequency2);
        arrayList.add(positioningFrequency3);
        return arrayList;
    }

    private void m9522j() {
        if (C1483c.m6831b(C1462f.m6746j())) {
            this.f5864w.setVisibility(0);
            this.f5864w.m7206a(true);
            GetWatchSettingModel getWatchSettingModel = new GetWatchSettingModel();
            getWatchSettingModel.deviceCode = C1462f.m6746j();
            getWatchSettingModel.settingType = "PositioningStrategy";
            this.f5851j.mo2487a(getWatchSettingModel, new gc(this));
            return;
        }
        C2538c.m12677c("SettingLocationActivity", "=========== getWatchSetting deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
    }

    private void m9523k() {
        this.f5849h.setAlpha(NFCBaseActivity.PERCENT_MARGIN_30);
        this.f5844c.setAlpha(NFCBaseActivity.PERCENT_MARGIN_30);
        this.f5844c.setEnabled(false);
        this.f5844c.setClickable(false);
    }

    private void m9524l() {
        this.f5849h.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f5844c.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f5844c.setEnabled(true);
        this.f5844c.setClickable(true);
    }
}
