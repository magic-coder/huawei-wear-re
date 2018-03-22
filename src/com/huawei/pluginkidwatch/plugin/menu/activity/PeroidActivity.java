package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1830a;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1901r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeroidActivity extends KidWatchBaseActivity implements OnClickListener, OnItemClickListener {
    C1507h f5796b;
    C1507h f5797c;
    protected Handler f5798d = new fk(this);
    private C1413d f5799e;
    private Context f5800f = null;
    private List<AlarmItem> f5801g = new ArrayList();
    private TextView f5802h;
    private View f5803i;
    private Button f5804j;
    private C1830a f5805k = null;
    private ListView f5806l = null;
    private TextView f5807m;
    private ImageButton f5808n = null;
    private Gson f5809o;
    private boolean f5810p = false;
    private View f5811q;
    private OnClickListener f5812r = new fh(this);
    private OnItemLongClickListener f5813s = new fn(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b("PeroidActivity", "========== Enter initData");
        this.f5800f = this;
        this.f5809o = new Gson();
        setContentView(h.activity_peroid);
        this.f5808n = (ImageButton) findViewById(g.settings_peroid_add_button);
        this.f5802h = (TextView) findViewById(g.settings_proid_update);
        this.f5803i = findViewById(g.menu_peroid_net_panel);
        this.f5804j = (Button) findViewById(g.menu_peroid_net_restart);
        this.f5804j.setOnClickListener(this.f5812r);
        this.f5808n.setOnClickListener(this);
        this.f5811q = findViewById(g.setting_period_no_data);
        this.f5806l = (ListView) findViewById(g.settings_proid_listview);
        this.f5807m = (TextView) findViewById(g.settings_smart_peroid_tishi);
        this.f5806l.setOnItemClickListener(this);
        this.f5805k = new C1830a(this, true);
        this.f5805k.m8812a(this.f5798d);
        this.f5805k.m8814a(false);
        this.f5806l.setAdapter(this.f5805k);
        this.f5806l.setOnItemLongClickListener(this.f5813s);
        m9491d();
    }

    private void m9491d() {
        C2538c.m12674b("PeroidActivity", "========== Enter initData");
        if (C1490j.m6890a("ClassDisableSwitch")) {
            this.f5807m.setText(C1680l.IDS_plugin_kidwatch_mute_setting_content);
        } else {
            this.f5807m.setText(C1680l.IDS_plugin_kidwatch_menu_period_tishi_str);
        }
        this.f5799e = C1417a.m6594a(getApplicationContext());
        m9493e();
    }

    private void m9482a(boolean z) {
        int i;
        int i2 = 8;
        this.f5803i.setVisibility(z ? 0 : 8);
        Button button = this.f5804j;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        button.setVisibility(i);
        TextView textView = this.f5802h;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        ListView listView = this.f5806l;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        listView.setVisibility(i);
        TextView textView2 = this.f5807m;
        if (!z) {
            i2 = 0;
        }
        textView2.setVisibility(i2);
    }

    private void m9493e() {
        C2538c.m12674b("PeroidActivity", "========== Enter getPeroidListFromCloud");
        if (C1483c.m6831b(C1462f.m6746j())) {
            GetWatchSettingModel getWatchSettingModel = new GetWatchSettingModel();
            getWatchSettingModel.deviceCode = C1462f.m6746j();
            getWatchSettingModel.settingType = "mutePeirodList";
            this.f5810p = false;
            this.f5799e.mo2487a(getWatchSettingModel, new fi(this));
            return;
        }
        C2538c.m12677c("PeroidActivity", "=========== getPeroidListFromCloud deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
    }

    public void onClick(View view) {
        C2538c.m12674b("PeroidActivity", "========== Enter onClick");
        if (view.getId() == g.settings_peroid_add_button && this.f5810p) {
            C2538c.m12674b("PeroidActivity", "========== Create a new Peroid");
            if (this.f5801g == null || this.f5801g.size() >= 3) {
                C1483c.m6832c(this.f5800f, String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_settings_mult_peroid_limited), new Object[]{Integer.valueOf(3)}));
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this, AddPeroidActivity.class);
            intent.putExtra("from_add_button", true);
            intent.putExtra("key_peroid_edit", this.f5809o.toJson(this.f5801g));
            startActivity(intent);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12674b("PeroidActivity", "========== Enter onItemClick");
        Intent intent = new Intent();
        intent.putExtra("indexofclicked", i);
        intent.putExtra("key_peroid_edit", this.f5809o.toJson(this.f5801g));
        intent.setClass(this, AddPeroidActivity.class);
        intent.putExtra("from_add_button", false);
        startActivity(intent);
    }

    private void m9481a(List<AlarmItem> list) {
        boolean z = true;
        C2538c.m12674b("PeroidActivity", "=======Enter updateShowingFenceList");
        if (list == null) {
            C2538c.m12680e("PeroidActivity", "======= updateShowingFenceList is null");
            return;
        }
        AlarmItem.sort(this.f5801g);
        List arrayList = new ArrayList(list.size());
        arrayList.addAll(this.f5801g);
        this.f5805k.m8813a(arrayList);
        if (list.size() != 0) {
            z = false;
        }
        m9487b(z);
    }

    private void m9487b(boolean z) {
        int i;
        int i2 = 0;
        View view = this.f5811q;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        ListView listView = this.f5806l;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        listView.setVisibility(i);
        TextView textView = this.f5807m;
        if (z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    private void m9474a(AlarmItem alarmItem, int i, int i2) {
        C2538c.m12674b("PeroidActivity", "=========Enter changeFenceState    position:" + i2);
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        Map hashMap = new HashMap();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        hashMap.put("mutePeirodList", this.f5801g);
        setWatchSettingIOModel.settingMap = hashMap;
        m9475a(setWatchSettingIOModel, i, i2);
    }

    private void m9475a(SetWatchSettingIOModel setWatchSettingIOModel, int i, int i2) {
        C2538c.m12674b("PeroidActivity", "==========Enter saveAlarmToCloud");
        this.f5799e.mo2496a(setWatchSettingIOModel, new fl(this, i2, i));
    }

    protected void onResume() {
        super.onResume();
        if (C1901r.m9680b()) {
            C1901r.m9678a(false);
            m9493e();
        }
    }

    private void m9473a(int i) {
        if (this.f5801g != null && i < this.f5801g.size() && i >= 0) {
            SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
            setWatchSettingIOModel.deviceCode = C1462f.m6746j();
            Map hashMap = new HashMap();
            this.f5801g.remove(i);
            hashMap.put("mutePeirodList", this.f5801g);
            setWatchSettingIOModel.settingMap = hashMap;
            this.f5799e.mo2496a(setWatchSettingIOModel, new fm(this));
        }
    }

    private void m9484b(int i) {
        this.f5797c = new C1507h(this.f5800f, h.dialog_contact_delete, m.servicedialog, false);
        TextView textView = (TextView) this.f5797c.findViewById(g.menu_tv_contactdelete_content);
        ((TextView) this.f5797c.findViewById(g.menu_tv_contactdelete_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_peroid_delete));
        textView.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_peroid_delete_content));
        this.f5797c.show();
        ((TextView) this.f5797c.findViewById(g.menu_tv_contactcancle)).setOnClickListener(new fp(this));
        ((TextView) this.f5797c.findViewById(g.menu_tv_suredeletecontact)).setOnClickListener(new fq(this, i));
    }

    private void m9476a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }
}
