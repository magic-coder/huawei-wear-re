package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.title.CustomTitle;
import com.huawei.pluginkidwatch.common.ui.view.WaitingLineView;
import com.huawei.pluginkidwatch.common.ui.wheelview.C1605e;
import com.huawei.pluginkidwatch.common.ui.wheelview.WheelView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1841l;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1843n;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1851v;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1853x;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1886b;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddAlarmActivity extends KidWatchBaseActivity implements OnClickListener {
    private static boolean f5340r;
    private final String f5341A = ".";
    private CustomTitle f5342B;
    private int f5343C;
    private Gson f5344D;
    private boolean f5345E = false;
    private LinearLayout f5346F;
    private LinearLayout f5347G;
    private TextView f5348H;
    private Context f5349I = null;
    private String[] f5350J = new String[]{"", "", "", "", "", "", ""};
    private boolean[] f5351K = new boolean[]{false, true, true, true, true, true, false};
    private boolean[] f5352L = new boolean[]{false, true, true, true, true, true, false};
    private String[] f5353M = new String[]{"", "", "", "", ""};
    private boolean[] f5354N = new boolean[]{true, false, false, false, false};
    private WaitingLineView f5355O;
    private AlarmItem f5356P;
    C1507h f5357b;
    C1841l f5358c;
    C1851v f5359d;
    OnItemClickListener f5360e = new C1860d(this);
    private ImageButton f5361f = null;
    private C1605e f5362g = null;
    private RelativeLayout f5363h;
    private C1843n f5364i;
    private C1853x f5365j;
    private final int f5366k = 7;
    private String f5367l = "0";
    private String f5368m = "00";
    private C1413d f5369n;
    private final int f5370o = 6;
    private int f5371p = 0;
    private String f5372q = "12345";
    private String f5373s = "1";
    private TextView f5374t;
    private String f5375u = "12345";
    private C1507h f5376v = null;
    private C1507h f5377w = null;
    private String f5378x = "";
    private List<AlarmItem> f5379y;
    private final String f5380z = "-";

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b("AddAlarmActivity", "=======Enter initView");
        setContentView(h.activity_add_alarm);
        this.f5349I = this;
        this.f5344D = new Gson();
        this.f5369n = C1417a.m6594a(getApplicationContext());
        m8962f();
        this.f5342B = (CustomTitle) findViewById(g.menu_elec_add_alarm_title);
        this.f5374t = (TextView) findViewById(g.setting_alarm_repeate_time);
        this.f5363h = (RelativeLayout) findViewById(g.relative_menu_bottom_delete);
        this.f5346F = (LinearLayout) findViewById(g.setting_alarm_repeate_choose);
        this.f5346F.setOnClickListener(this);
        this.f5347G = (LinearLayout) findViewById(g.setting_alarm_title_choose);
        this.f5347G.setOnClickListener(this);
        this.f5361f = (ImageButton) findViewById(g.alarm_btn_delete);
        this.f5361f.setOnClickListener(this);
        this.f5348H = (TextView) findViewById(g.setting_alarm_title_show);
        this.f5355O = (WaitingLineView) findViewById(g.menu_add_alarm_wait_line);
        Intent intent = super.getIntent();
        try {
            this.f5379y = (List) this.f5344D.fromJson(intent.getStringExtra("key_alarm_edit"), new C1856a(this).getType());
        } catch (JsonSyntaxException e) {
            C2538c.m12674b("AddAlarmActivity", e.getMessage());
        }
        f5340r = intent.getBooleanExtra("from_add_button", false);
        if (f5340r) {
            m8938a(null);
            this.f5378x = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_getup);
            m8953b(this.f5353M[0]);
            this.f5374t.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_workday));
            return;
        }
        this.f5342B.setTitleLabel(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_mult_alarm_clock_edit_title));
        this.f5343C = intent.getIntExtra("indexofclicked", -1);
        if (this.f5379y != null && this.f5379y.size() > this.f5343C) {
            this.f5356P = (AlarmItem) this.f5379y.get(this.f5343C);
            m8938a((AlarmItem) this.f5379y.get(this.f5343C));
        }
    }

    private void m8962f() {
        this.f5350J[0] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_sunday);
        this.f5350J[1] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_monday);
        this.f5350J[2] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_tuesday);
        this.f5350J[3] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_wednesday);
        this.f5350J[4] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_thursday);
        this.f5350J[5] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_friday);
        this.f5350J[6] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_saturday);
        this.f5353M[0] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_getup);
        this.f5353M[1] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_water);
        this.f5353M[2] = getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_sport);
        this.f5353M[3] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_sleep);
        this.f5353M[4] = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_self_definde);
    }

    private void m8938a(AlarmItem alarmItem) {
        C2538c.m12674b("AddAlarmActivity", "=======Enter initUIData");
        if (alarmItem == null) {
            C2538c.m12674b("AddAlarmActivity", "=======  clock is null");
            Calendar instance = Calendar.getInstance();
            m8951b(instance.get(11), instance.get(12));
            this.f5363h.setVisibility(8);
            return;
        }
        C2538c.m12674b("AddAlarmActivity", "=======  clock not null");
        if (C1492l.m6919c(alarmItem.startTime)) {
            m8951b(C1492l.m6900a(C1492l.m6920d(alarmItem.startTime)), C1492l.m6914b(C1492l.m6920d(alarmItem.startTime)));
            m8953b(alarmItem.label);
            m8944a(alarmItem.label);
            this.f5378x = alarmItem.label;
            this.f5375u = alarmItem.cycle;
            m8956c(this.f5375u);
            return;
        }
        C2538c.m12674b("AddAlarmActivity", "======= alarm.startTime is not int of string");
    }

    private void m8944a(String str) {
        C2538c.m12674b("AddAlarmActivity", "=========== Enter updateNameCycle");
        for (int i = 0; i < this.f5354N.length; i++) {
            this.f5354N[i] = false;
        }
        if (str.endsWith(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_getup))) {
            this.f5354N[0] = true;
            this.f5371p = 0;
        } else if (str.endsWith(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_water))) {
            this.f5354N[1] = true;
            this.f5371p = 1;
        } else if (str.endsWith(getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_sport))) {
            this.f5354N[2] = true;
            this.f5371p = 2;
        } else if (str.endsWith(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_sleep))) {
            this.f5354N[3] = true;
            this.f5371p = 3;
        } else {
            this.f5354N[4] = true;
            this.f5371p = 4;
        }
    }

    private void m8953b(String str) {
        C2538c.m12674b("AddAlarmActivity", "=========== Enter setTitleDescribe");
        if (str != null) {
            this.f5348H.setText(str);
        }
    }

    public void onSaveClick(View view) {
        C2538c.m12674b("AddAlarmActivity", "==========Enter onSaveClick()");
        if (this.f5345E) {
            C2538c.m12674b("AddAlarmActivity", "==========onSaveClick Saving alarm now, Cannot save again while it is saving");
            return;
        }
        int d;
        int d2;
        if (C1492l.m6919c(this.f5362g.m7424a())) {
            d = C1492l.m6920d(this.f5362g.m7424a());
        } else {
            d = 0;
        }
        if (C1492l.m6919c(this.f5362g.m7429c())) {
            d2 = C1492l.m6920d(this.f5362g.m7429c());
        } else {
            d2 = 0;
        }
        C2538c.m12674b("AddAlarmActivity", "======alarmTime = " + m8934a(d, d2));
        if (!m8964g()) {
            AlarmItem alarmItem = new AlarmItem();
            alarmItem.startTime = r0;
            alarmItem.cycle = this.f5375u;
            alarmItem.label = this.f5378x;
            alarmItem.isActive = this.f5373s;
            alarmItem.type = this.f5371p;
            m8939a(m8949b(alarmItem), false, null);
        }
    }

    private boolean m8964g() {
        if (this.f5375u != null && !"".equals(this.f5375u) && this.f5375u.length() != 0) {
            return false;
        }
        C1483c.m6824a(getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_period_alarm_no_title);
        return true;
    }

    @NonNull
    private SetWatchSettingIOModel m8949b(AlarmItem alarmItem) {
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        Map hashMap = new HashMap();
        if (f5340r) {
            this.f5379y.add(alarmItem);
        } else {
            this.f5379y.set(this.f5343C, alarmItem);
        }
        hashMap.put("alarmList", this.f5379y);
        setWatchSettingIOModel.settingMap = hashMap;
        return setWatchSettingIOModel;
    }

    @NonNull
    private String m8934a(int i, int i2) {
        String str = "";
        if (i > 0 && i < 10) {
            str = this.f5367l + String.valueOf(i);
        } else if (i == 0) {
            str = this.f5368m;
        } else {
            str = String.valueOf(i);
        }
        if (i2 > 0 && i2 < 10) {
            return str + this.f5367l + String.valueOf(i2);
        }
        if (i2 == 0) {
            return str + this.f5368m;
        }
        return str + String.valueOf(i2);
    }

    private void m8940a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public void mo2518d() {
        this.f5357b = new C1507h(this.f5349I, h.dialog_contact_delete, m.servicedialog, false);
        TextView textView = (TextView) this.f5357b.findViewById(g.menu_tv_contactdelete_content);
        ((TextView) this.f5357b.findViewById(g.menu_tv_contactdelete_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_alarm_delete));
        textView.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_alarm_delete_content));
        this.f5357b.show();
        ((TextView) this.f5357b.findViewById(g.menu_tv_contactcancle)).setOnClickListener(new C1858b(this));
        ((TextView) this.f5357b.findViewById(g.menu_tv_suredeletecontact)).setOnClickListener(new C1859c(this));
    }

    public void onClick(View view) {
        int i = 0;
        if (g.alarm_btn_delete == view.getId()) {
            mo2518d();
        } else if (g.setting_alarm_repeate_choose == view.getId()) {
            C2538c.m12674b("AddAlarmActivity", "========== press repeate");
            while (i < this.f5351K.length) {
                this.f5352L[i] = this.f5351K[i];
                i++;
            }
            m8966h();
        } else if (g.setting_alarm_title_choose == view.getId()) {
            m8967i();
        }
    }

    private void m8966h() {
        C2538c.m12674b("AddAlarmActivity", "========Enter showMultiChoiceDialog ");
        this.f5364i = new C1843n(this);
        this.f5364i.m8922a(false);
        this.f5358c = this.f5364i.m8919a(getResources().getString(C1680l.IDS_plugin_kidwatch_common_repeat)).m8921a(this.f5350J, this.f5351K, null, null, true).m8920a(getResources().getString(C1680l.IDS_plugin_kidwatch_common_cancel), new C1867i(this)).m8925b(getResources().getString(C1680l.IDS_plugin_kidwatch_common_set), new C1868j(this)).m8924b();
        this.f5358c.show();
    }

    private void m8967i() {
        C2538c.m12674b("AddAlarmActivity", "========Enter showSingleChoiceDialog ");
        this.f5365j = new C1853x(this);
        this.f5359d = this.f5365j.m8929a(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_label)).m8931a(this.f5353M, this.f5354N, null, this.f5360e, true).m8930a(getResources().getString(C1680l.IDS_plugin_kidwatch_common_cancel), null).m8928a();
        this.f5359d.show();
    }

    private void m8937a(int i, String str) {
        C2538c.m12674b("AddAlarmActivity", "========Enter showSelfDefineDialog");
        if (this.f5377w == null) {
            this.f5377w = new C1507h(this.f5349I, h.dialog_selfdefine, m.servicedialog, false);
        }
        ((TextView) this.f5377w.findViewById(g.common_selfdefine_dialog_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_self_label));
        EditText editText = (EditText) this.f5377w.findViewById(g.common_selfdefine_dialog_content);
        editText.setHint(String.format(this.f5349I.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_poried_edit_info), new Object[]{Integer.valueOf(7), Integer.valueOf(12)}));
        editText.setFilters(new InputFilter[]{new LengthFilter(12)});
        C1886b.m9648a(editText);
        this.f5377w.show();
        this.f5377w.findViewById(g.common_selfdefine_dialog_cancle).setOnClickListener(new C1862e(this, i, str));
        this.f5377w.findViewById(g.common_selfdefine_dialog_sure).setOnClickListener(new C1863f(this, editText));
    }

    private void m8956c(String str) {
        C2538c.m12674b("AddAlarmActivity", "=============Enter updateRepeatCycle,repeate:" + str);
        for (int i = 0; i < 7; i++) {
            this.f5351K[i] = false;
        }
        if ("".equals(str) || str.contains("-") || str.contains(".")) {
            C2538c.m12674b("AddAlarmActivity", "==============repeate is not effective");
            this.f5374t.setText("");
            return;
        }
        CharSequence charSequence = "";
        int i2;
        if (7 == str.length()) {
            charSequence = this.f5349I.getString(C1680l.IDS_plugin_kidwatch_menu_alarm_everyday) + HwAccountConstants.BLANK;
            for (i2 = 0; i2 < 7; i2++) {
                this.f5351K[i2] = true;
            }
        } else if (str.equals(this.f5372q)) {
            charSequence = this.f5349I.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_workday) + HwAccountConstants.BLANK;
            for (i2 = 1; i2 < 6; i2++) {
                this.f5351K[i2] = true;
            }
        } else {
            i2 = str.trim().length() < 1 ? 0 : 0;
            for (i2 = 0; i2 < str.trim().length(); i2++) {
                if (C1492l.m6919c(str.substring(i2, i2 + 1))) {
                    switch (C1492l.m6920d(str.substring(i2, i2 + 1))) {
                        case 1:
                            this.f5351K[1] = true;
                            charSequence = charSequence + this.f5349I.getString(C1680l.IDS_plugin_kidwatch_common_monday) + HwAccountConstants.BLANK;
                            break;
                        case 2:
                            this.f5351K[2] = true;
                            charSequence = charSequence + this.f5349I.getString(C1680l.IDS_plugin_kidwatch_common_tuesday) + HwAccountConstants.BLANK;
                            break;
                        case 3:
                            this.f5351K[3] = true;
                            charSequence = charSequence + this.f5349I.getString(C1680l.IDS_plugin_kidwatch_common_wednesday) + HwAccountConstants.BLANK;
                            break;
                        case 4:
                            this.f5351K[4] = true;
                            charSequence = charSequence + this.f5349I.getString(C1680l.IDS_plugin_kidwatch_common_thursday) + HwAccountConstants.BLANK;
                            break;
                        case 5:
                            this.f5351K[5] = true;
                            charSequence = charSequence + this.f5349I.getString(C1680l.IDS_plugin_kidwatch_common_friday) + HwAccountConstants.BLANK;
                            break;
                        case 6:
                            this.f5351K[6] = true;
                            charSequence = charSequence + this.f5349I.getString(C1680l.IDS_plugin_kidwatch_common_saturday) + HwAccountConstants.BLANK;
                            break;
                        case 7:
                            this.f5351K[0] = true;
                            charSequence = charSequence + this.f5349I.getString(C1680l.IDS_plugin_kidwatch_common_sunday) + HwAccountConstants.BLANK;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (charSequence.length() > 1) {
            charSequence = charSequence.substring(0, charSequence.length() - 1);
        }
        this.f5374t.setText(charSequence);
    }

    private void m8939a(SetWatchSettingIOModel setWatchSettingIOModel, boolean z, AlarmItem alarmItem) {
        C2538c.m12674b("AddAlarmActivity", "==========Enter saveAlarmToCloud");
        if (this.f5345E) {
            C2538c.m12674b("AddAlarmActivity", "========== Saving alarm now, Cannot save again while it is saving");
            return;
        }
        this.f5345E = true;
        this.f5355O.setVisibility(0);
        this.f5355O.m7206a(true);
        this.f5369n.mo2496a(setWatchSettingIOModel, new C1864g(this, z, alarmItem));
    }

    private void m8951b(int i, int i2) {
        int i3;
        C2538c.m12674b("AddAlarmActivity", "=======Enter initAlarmPicker");
        C2538c.m12674b("AddAlarmActivity", "=======hour:", i + "\n=======min:" + i2);
        this.f5362g = new C1605e(this.f5349I, (WheelView) findViewById(g.number_picker), (WheelView) findViewById(g.number_picker_unit));
        this.f5362g.m7425a(new C1866h(this));
        String[] strArr = new String[24];
        for (i3 = 0; i3 < 24; i3++) {
            if (i3 < 10) {
                strArr[i3] = this.f5367l + String.valueOf(i3);
            } else {
                strArr[i3] = String.valueOf(i3);
            }
        }
        String[] strArr2 = new String[60];
        for (i3 = 0; i3 < 60; i3++) {
            if (i3 < 10) {
                strArr2[i3] = this.f5367l + String.valueOf(i3);
            } else {
                strArr2[i3] = String.valueOf(i3);
            }
        }
        this.f5362g.m7426a(strArr, i, true);
        this.f5362g.m7428b(strArr2, i2, true);
        C2538c.m12674b("AddAlarmActivity", "=======initAlarmPicker leave");
    }
}
