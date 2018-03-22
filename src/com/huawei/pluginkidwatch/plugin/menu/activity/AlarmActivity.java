package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.TextImgButton;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1830a;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1901r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlarmActivity extends KidWatchBaseActivity implements OnClickListener, OnItemClickListener {
    C1507h f5511b;
    C1507h f5512c;
    protected Handler f5513d = new ax(this);
    private C1413d f5514e;
    private Context f5515f = null;
    private List<AlarmItem> f5516g = new ArrayList();
    private C1830a f5517h = null;
    private ListView f5518i = null;
    private TextImgButton f5519j = null;
    private Gson f5520k;
    private TextView f5521l;
    private View f5522m;
    private Button f5523n;
    private boolean f5524o = false;
    private View f5525p;
    private OnClickListener f5526q = new au(this);
    private OnItemLongClickListener f5527r = new ba(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b("AlarmActivity", "========== Enter initData");
        this.f5515f = this;
        this.f5520k = new Gson();
        setContentView(h.activity_alarm_kidwatch);
        this.f5519j = (TextImgButton) findViewById(g.settings_smart_alarm_add_button);
        this.f5519j.setOnClickListener(this);
        this.f5521l = (TextView) findViewById(g.menu_elec_alert_get_alarm_now);
        this.f5522m = findViewById(g.menu_alart_net_panel);
        this.f5523n = (Button) findViewById(g.menu_alarm_net_restart);
        this.f5523n.setOnClickListener(this.f5526q);
        this.f5525p = findViewById(g.setting_alarm_no_data);
        this.f5518i = (ListView) findViewById(g.settings_smart_alarm_listview);
        this.f5518i.addFooterView(LayoutInflater.from(this).inflate(h.alarm_list_footer, null), null, false);
        this.f5518i.setFooterDividersEnabled(false);
        this.f5518i.setOnItemClickListener(this);
        this.f5517h = new C1830a(this);
        this.f5517h.m8812a(this.f5513d);
        this.f5518i.setAdapter(this.f5517h);
        this.f5518i.setOnItemLongClickListener(this.f5527r);
        this.f5521l.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_settings_mult_alarm_loading));
        m9131d();
    }

    private void m9131d() {
        C2538c.m12674b("AlarmActivity", "========== Enter initData");
        this.f5514e = C1417a.m6594a(getApplicationContext());
        m9133e();
    }

    private void m9122a(boolean z) {
        int i;
        int i2 = 8;
        View view = this.f5522m;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        Button button = this.f5523n;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        button.setVisibility(i);
        TextView textView = this.f5521l;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        ListView listView = this.f5518i;
        if (!z) {
            i2 = 0;
        }
        listView.setVisibility(i2);
    }

    private void m9133e() {
        C2538c.m12674b("AlarmActivity", "========== Enter getAlarmListFromCloud");
        if (C1483c.m6831b(C1462f.m6746j())) {
            this.f5524o = false;
            GetWatchSettingModel getWatchSettingModel = new GetWatchSettingModel();
            getWatchSettingModel.deviceCode = C1462f.m6746j();
            getWatchSettingModel.settingType = "alarmList";
            this.f5514e.mo2487a(getWatchSettingModel, new av(this));
            return;
        }
        C2538c.m12677c("AlarmActivity", "=========== getAlarmListFromCloud deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
    }

    public void onClick(View view) {
        C2538c.m12674b("AlarmActivity", "========== Enter onClick");
        if (g.settings_smart_alarm_add_button == view.getId()) {
            C2538c.m12674b("AlarmActivity", "========== Create a new Alarm");
            if (!this.f5524o) {
                return;
            }
            if (this.f5516g == null || this.f5516g.size() >= 10) {
                C1483c.m6832c(this.f5515f, String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_settings_mult_alarm_clock_reach_limited), new Object[]{Integer.valueOf(10)}));
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this, AddAlarmActivity.class);
            intent.putExtra("from_add_button", true);
            intent.putExtra("key_alarm_edit", this.f5520k.toJson(this.f5516g));
            startActivity(intent);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12674b("AlarmActivity", "========== Enter onItemClick");
        Intent intent = new Intent();
        intent.putExtra("indexofclicked", i);
        intent.putExtra("key_alarm_edit", this.f5520k.toJson(this.f5516g));
        intent.setClass(this, AddAlarmActivity.class);
        intent.putExtra("from_add_button", false);
        startActivity(intent);
    }

    private void m9121a(List<AlarmItem> list) {
        boolean z = false;
        C2538c.m12674b("AlarmActivity", "=======Enter updateShowingFenceList");
        if (list != null) {
            AlarmItem.sort(list);
            List arrayList = new ArrayList(list.size());
            arrayList.addAll(list);
            this.f5517h.m8813a(arrayList);
        }
        if (list == null || list.size() == 0) {
            z = true;
        }
        m9127b(z);
    }

    private void m9127b(boolean z) {
        int i;
        int i2 = 0;
        View view = this.f5525p;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        ListView listView = this.f5518i;
        if (z) {
            i2 = 8;
        }
        listView.setVisibility(i2);
    }

    private void m9114a(AlarmItem alarmItem, int i, int i2) {
        C2538c.m12674b("AlarmActivity", "=========Enter changeFenceState    position:" + i2);
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        Map hashMap = new HashMap();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        hashMap.put("alarmList", this.f5516g);
        setWatchSettingIOModel.settingMap = hashMap;
        m9115a(setWatchSettingIOModel, i, i2);
    }

    private void m9115a(SetWatchSettingIOModel setWatchSettingIOModel, int i, int i2) {
        C2538c.m12674b("AlarmActivity", "==========Enter saveAlarmToCloud");
        this.f5514e.mo2496a(setWatchSettingIOModel, new ay(this, i2, i));
    }

    protected void onResume() {
        super.onResume();
        if (C1901r.m9680b()) {
            C1901r.m9678a(false);
            m9133e();
        }
    }

    private void m9113a(int i) {
        if (this.f5516g != null && i < this.f5516g.size() && i >= 0) {
            SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
            setWatchSettingIOModel.deviceCode = C1462f.m6746j();
            Map hashMap = new HashMap();
            this.f5516g.remove(i);
            hashMap.put("alarmList", this.f5516g);
            setWatchSettingIOModel.settingMap = hashMap;
            this.f5514e.mo2496a(setWatchSettingIOModel, new az(this));
        }
    }

    private void m9124b(int i) {
        this.f5512c = new C1507h(this.f5515f, h.dialog_contact_delete, m.servicedialog, false);
        TextView textView = (TextView) this.f5512c.findViewById(g.menu_tv_contactdelete_content);
        ((TextView) this.f5512c.findViewById(g.menu_tv_contactdelete_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_alarm_delete));
        textView.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_alarm_delete_content));
        this.f5512c.show();
        ((TextView) this.f5512c.findViewById(g.menu_tv_contactcancle)).setOnClickListener(new bc(this));
        ((TextView) this.f5512c.findViewById(g.menu_tv_suredeletecontact)).setOnClickListener(new bd(this, i));
    }

    private void m9116a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }
}
