package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.PositioningFrequency;
import com.huawei.pluginkidwatch.common.entity.model.PositioningStrategy;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.WaitingLineView;
import com.huawei.pluginkidwatch.common.ui.wheelview.C1605e;
import com.huawei.pluginkidwatch.common.ui.wheelview.WheelView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1851v;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1853x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditCustomTimeActivity extends KidWatchBaseActivity implements OnClickListener {
    OnItemClickListener f5640b = new cz(this);
    private Context f5641c;
    private C1413d f5642d = null;
    private TextView f5643e;
    private RelativeLayout f5644f;
    private int f5645g = 0;
    private C1605e f5646h = null;
    private C1605e f5647i = null;
    private C1507h f5648j = null;
    private int f5649k = 8;
    private int f5650l = 0;
    private int f5651m = 16;
    private int f5652n = 30;
    private String f5653o = "";
    private String f5654p;
    private String f5655q;
    private String[] f5656r = new String[]{"", "", "", ""};
    private boolean[] f5657s = new boolean[]{true, false, false, false};
    private C1853x f5658t;
    private C1851v f5659u;
    private WaitingLineView f5660v;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_edit_time);
        m9291d();
    }

    private void m9291d() {
        this.f5641c = this;
        this.f5642d = C1417a.m6594a(getApplicationContext());
        this.f5654p = getIntent().getStringExtra("edittime");
        C1462f.m6745i(this.f5654p);
        this.f5643e = (TextView) findViewById(g.menu_Tv_location_custom_place11);
        this.f5644f = (RelativeLayout) findViewById(g.menu_location_info_lable);
        this.f5660v = (WaitingLineView) findViewById(g.menu_add_location_wait_line);
        this.f5644f.setOnClickListener(this);
        this.f5656r[0] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotoschool);
        this.f5656r[1] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotohome);
        this.f5656r[2] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotobed);
        this.f5656r[3] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_self_label);
        List s = C1462f.m6759s();
        if (s != null && this.f5654p != null) {
            PositioningFrequency positioningFrequency;
            if (this.f5654p.equals("hione")) {
                positioningFrequency = (PositioningFrequency) s.get(0);
                if (positioningFrequency != null) {
                    m9281a(positioningFrequency);
                }
            } else if (this.f5654p.equals("hitwo")) {
                positioningFrequency = (PositioningFrequency) s.get(1);
                if (positioningFrequency != null) {
                    m9281a(positioningFrequency);
                }
            } else if (this.f5654p.equals("low")) {
                positioningFrequency = (PositioningFrequency) s.get(2);
                if (positioningFrequency != null) {
                    m9281a(positioningFrequency);
                }
            }
            m9280a(this.f5649k, this.f5650l, this.f5651m, this.f5652n);
            C1462f.m6747j(this.f5649k + ":" + this.f5650l);
            C1462f.m6749k(this.f5651m + ":" + this.f5652n);
            C1462f.m6751l(this.f5655q);
            this.f5653o = this.f5655q;
            this.f5643e.setText(this.f5655q);
            m9288b(this.f5655q);
        }
    }

    private void m9281a(PositioningFrequency positioningFrequency) {
        this.f5649k = C1483c.m6821a(String.valueOf(positioningFrequency.getStartTime()).substring(0, 2));
        this.f5650l = C1483c.m6821a(String.valueOf(positioningFrequency.getStartTime()).substring(2, 4));
        this.f5651m = C1483c.m6821a(String.valueOf(positioningFrequency.getEndTime()).substring(0, 2));
        this.f5652n = C1483c.m6821a(String.valueOf(positioningFrequency.getEndTime()).substring(2, 4));
        this.f5655q = String.valueOf(positioningFrequency.getLabel());
    }

    public void onClick(View view) {
        if (g.menu_location_info_lable == view.getId()) {
            m9295f();
        }
    }

    public void onSaveClick(View view) {
        if (C1492l.m6916b(this.f5641c)) {
            int d;
            int d2;
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (C1492l.m6919c(this.f5646h.m7424a())) {
                d = C1492l.m6920d(this.f5646h.m7424a());
                if (d < 10) {
                    str = "0" + d;
                } else {
                    str = String.valueOf(d);
                }
            }
            if (C1492l.m6919c(this.f5646h.m7429c())) {
                d2 = C1492l.m6920d(this.f5646h.m7429c());
                if (d2 < 10) {
                    str2 = "0" + d2;
                } else {
                    str2 = String.valueOf(d2);
                }
            }
            C1462f.m6747j(str + ":" + str2);
            if (C1492l.m6919c(this.f5647i.m7424a())) {
                d = C1492l.m6920d(this.f5647i.m7424a());
                if (d < 10) {
                    str = "0" + d;
                } else {
                    str = String.valueOf(d);
                }
            } else {
                str = str3;
            }
            if (C1492l.m6919c(this.f5647i.m7429c())) {
                d2 = C1492l.m6920d(this.f5647i.m7429c());
                if (d2 < 10) {
                    str2 = "0" + d2;
                } else {
                    str2 = String.valueOf(d2);
                }
            } else {
                str2 = str4;
            }
            C1462f.m6749k(str + ":" + str2);
            if (C1462f.m6763w().equals(C1462f.m6762v())) {
                C1483c.m6824a(this.f5641c, C1680l.IDS_plugin_kidwatch_menu_love_location_time_diff);
                return;
            } else {
                m9293e();
                return;
            }
        }
        C1483c.m6824a(this.f5641c, C1680l.IDS_plugin_kidwatch_common_network_disable);
    }

    private void m9280a(int i, int i2, int i3, int i4) {
        int i5;
        WheelView wheelView = (WheelView) findViewById(g.menu_location_time_pick_star_start);
        WheelView wheelView2 = (WheelView) findViewById(g.menu_location_time_pick_star_end);
        wheelView.m7405a(true, false);
        wheelView.setUseDefaultTextColur(false);
        wheelView2.m7405a(true, false);
        wheelView2.setUseDefaultTextColur(false);
        WheelView wheelView3 = (WheelView) findViewById(g.menu_location_time_pick_end_start);
        WheelView wheelView4 = (WheelView) findViewById(g.menu_location_time_pick_end_end);
        wheelView3.m7405a(true, false);
        wheelView3.setUseDefaultTextColur(false);
        wheelView4.m7405a(true, false);
        wheelView4.setUseDefaultTextColur(false);
        this.f5646h = new C1605e(this.f5641c, wheelView, wheelView2);
        this.f5647i = new C1605e(this.f5641c, wheelView3, wheelView4);
        String[] strArr = new String[24];
        for (i5 = 0; i5 < 24; i5++) {
            if (i5 < 10) {
                strArr[i5] = "0" + String.valueOf(i5);
            } else {
                strArr[i5] = String.valueOf(i5);
            }
        }
        String[] strArr2 = new String[60];
        for (i5 = 0; i5 < 60; i5++) {
            if (i5 < 10) {
                strArr2[i5] = "0" + String.valueOf(i5);
            } else {
                strArr2[i5] = String.valueOf(i5);
            }
        }
        this.f5646h.m7426a(strArr, i, true);
        this.f5646h.m7428b(strArr2, i2, true);
        this.f5647i.m7426a(strArr, i3, true);
        this.f5647i.m7428b(strArr2, i4, true);
    }

    public void onBackClick(View view) {
        C1462f.m6727b(false);
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        C1462f.m6727b(false);
    }

    private void m9293e() {
        C1506g.m6978a(this.f5641c, this.f5641c.getResources().getString(C1680l.IDS_plugin_kidwatch_common_saving), false);
        this.f5660v.setVisibility(0);
        this.f5660v.m7206a(true);
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        List s = C1462f.m6759s();
        if (s != null) {
            m9284a(s);
        }
        m9282a(setWatchSettingIOModel, s);
    }

    private void m9282a(SetWatchSettingIOModel setWatchSettingIOModel, List<PositioningFrequency> list) {
        Map hashMap = new HashMap();
        PositioningStrategy positioningStrategy = new PositioningStrategy();
        positioningStrategy.setPositioningMode(2);
        positioningStrategy.setPositioningFrequencyList(list);
        hashMap.put("PositioningStrategy", positioningStrategy);
        setWatchSettingIOModel.settingMap = hashMap;
        this.f5642d.mo2496a(setWatchSettingIOModel, new cy(this));
    }

    private void m9284a(List<PositioningFrequency> list) {
        if (this.f5654p.equals("hione")) {
            m9285a(list, 0, this.f5653o);
        } else if (this.f5654p.equals("hitwo")) {
            m9285a(list, 1, this.f5653o);
        } else if (this.f5654p.equals("low")) {
            m9285a(list, 2, this.f5653o);
        }
    }

    private void m9285a(List<PositioningFrequency> list, int i, String str) {
        PositioningFrequency positioningFrequency = (PositioningFrequency) list.get(i);
        if (positioningFrequency != null) {
            if (!"".equals(C1462f.m6762v())) {
                positioningFrequency.setStartTime(C1462f.m6762v().replace(":", "").trim());
            }
            if (!"".equals(str)) {
                positioningFrequency.setLabel(str);
            }
            if (!"".equals(C1462f.m6763w())) {
                positioningFrequency.setEndTime(C1462f.m6763w().replace(":", "").trim());
            }
        }
    }

    private void m9295f() {
        C2538c.m12674b("EditCustomTimeActivity", "========Enter showSingleChoiceDialog ");
        this.f5658t = new C1853x(this);
        this.f5659u = this.f5658t.m8929a(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_label)).m8931a(this.f5656r, this.f5657s, null, this.f5640b, true).m8930a(getResources().getString(C1680l.IDS_plugin_kidwatch_common_cancel), null).m8928a();
        this.f5659u.show();
    }

    private void m9283a(String str) {
        if (str != null) {
            this.f5643e.setText(str);
        }
    }

    private void m9288b(String str) {
        C2538c.m12674b("EditCustomTimeActivity", "=========== Enter updateNameCycle");
        for (int i = 0; i < this.f5657s.length; i++) {
            this.f5657s[i] = false;
        }
        if (str.endsWith(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotoschool))) {
            this.f5657s[0] = true;
            this.f5645g = 0;
        } else if (str.endsWith(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotohome))) {
            this.f5657s[1] = true;
            this.f5645g = 1;
        } else if (str.endsWith(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotobed))) {
            this.f5657s[2] = true;
            this.f5645g = 2;
        } else {
            this.f5657s[3] = true;
            this.f5645g = 3;
        }
    }

    protected void onResume() {
        super.onResume();
        this.f5643e.setText(this.f5653o);
    }
}
