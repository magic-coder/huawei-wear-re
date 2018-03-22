package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.button.SlipButtonView;
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
import com.huawei.pluginkidwatch.plugin.menu.utils.C1886b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddPeroidActivity extends KidWatchBaseActivity implements OnClickListener {
    private static boolean f5467h;
    private final int f5468A = 3000;
    private final int f5469B = 7;
    private boolean[] f5470C = new boolean[]{false, true, true, true, true, true, false};
    private boolean[] f5471D = new boolean[]{false, true, true, true, true, true, false};
    private long f5472E = 0;
    private C1843n f5473F;
    private final String f5474G = "-";
    private final String f5475H = ".";
    private String f5476I = "0";
    private String f5477J = "00";
    private CustomTitle f5478K;
    private View f5479L;
    private TextView f5480M;
    private String f5481N = "";
    private String[] f5482O = new String[]{"", "", "", "", "", "", ""};
    private WaitingLineView f5483P;
    private AlarmItem f5484Q;
    private C1507h f5485R = null;
    private int f5486S = 4;
    C1507h f5487b;
    C1841l f5488c;
    private ImageButton f5489d = null;
    private C1605e f5490e = null;
    private C1605e f5491f = null;
    private C1413d f5492g;
    private List<AlarmItem> f5493i;
    private String f5494j = "12345";
    private TextView f5495k;
    private Gson f5496l;
    private boolean f5497m = false;
    private Context f5498n = null;
    private String f5499o = "12345";
    private LinearLayout f5500p;
    private RelativeLayout f5501q;
    private RelativeLayout f5502r;
    private SlipButtonView f5503s;
    private int f5504t = 8;
    private int f5505u = 0;
    private int f5506v = 16;
    private int f5507w = 30;
    private final int f5508x = 7;
    private int f5509y;
    private final int f5510z = 6;

    protected void mo2517a() {
        C2538c.m12674b("AddPeroidActivity", "=======Enter initView");
        setContentView(h.activity_add_peroid);
        this.f5498n = this;
        this.f5496l = new Gson();
        this.f5492g = C1417a.m6594a(getApplicationContext());
        this.f5483P = (WaitingLineView) findViewById(g.menu_add_peroid_wait_line);
        this.f5483P.setVisibility(8);
        this.f5478K = (CustomTitle) findViewById(g.setting_add_peroid_title);
        this.f5495k = (TextView) findViewById(g.setting_peroid_repeate_time);
        this.f5489d = (ImageButton) findViewById(g.peroid_btn_delete_peroid);
        this.f5500p = (LinearLayout) findViewById(g.setting_peroid_repeate_choose);
        this.f5501q = (RelativeLayout) findViewById(g.relative_menu_bottom_delete);
        this.f5489d.setOnClickListener(this);
        this.f5500p.setOnClickListener(this);
        this.f5479L = findViewById(g.setting_peroid_title_choose);
        this.f5479L.setOnClickListener(this);
        this.f5480M = (TextView) findViewById(g.setting_peroid_title_show);
        this.f5502r = (RelativeLayout) findViewById(g.setting_mute_disable_choose);
        this.f5503s = (SlipButtonView) findViewById(g.setting_mute_disable_switch);
        this.f5503s.setOnChangedListener(new al(this));
        if (C1490j.m6890a("ClassDisableSwitch")) {
            this.f5486S = 5;
            this.f5502r.setVisibility(0);
            this.f5503s.setChecked(true);
        } else {
            this.f5486S = 4;
            this.f5502r.setVisibility(8);
            this.f5503s.setChecked(false);
        }
        m9100g();
        Intent intent = super.getIntent();
        try {
            this.f5493i = (List) this.f5496l.fromJson(intent.getStringExtra("key_peroid_edit"), new am(this).getType());
        } catch (JsonSyntaxException e) {
            C2538c.m12674b("AddPeroidActivity", e.getMessage());
        }
        if (this.f5493i == null) {
            C2538c.m12674b("AddPeroidActivity", "======null == alarmList");
            this.f5493i = new ArrayList();
        }
        f5467h = intent.getBooleanExtra("from_add_button", false);
        if (f5467h) {
            this.f5478K.setTitleLabel("添加静音时段");
            m9078a(null);
            return;
        }
        this.f5478K.setTitleLabel("编辑静音时段");
        this.f5509y = intent.getIntExtra("indexofclicked", -1);
        if (this.f5493i.size() > this.f5509y) {
            this.f5494j = ((AlarmItem) this.f5493i.get(this.f5509y)).cycle;
            m9093c(this.f5494j);
            this.f5484Q = (AlarmItem) this.f5493i.get(this.f5509y);
            m9078a((AlarmItem) this.f5493i.get(this.f5509y));
        }
    }

    private void m9100g() {
        this.f5482O[0] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_sunday);
        this.f5482O[1] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_monday);
        this.f5482O[2] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_tuesday);
        this.f5482O[3] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_wednesday);
        this.f5482O[4] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_thursday);
        this.f5482O[5] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_friday);
        this.f5482O[6] = getResources().getString(C1680l.IDS_plugin_kidwatch_common_saturday);
    }

    private void m9083a(String str) {
        this.f5481N = str;
        if (str != null) {
            this.f5480M.setText(str);
        }
    }

    private void m9078a(AlarmItem alarmItem) {
        C2538c.m12674b("AddPeroidActivity", "=======Enter initUIData");
        if (alarmItem == null) {
            C2538c.m12674b("AddPeroidActivity", "=======  clock is null");
            m9077a(this.f5504t, this.f5505u, this.f5506v, this.f5507w);
            this.f5501q.setVisibility(8);
            return;
        }
        C2538c.m12674b("AddPeroidActivity", "=======  clock not null");
        if (C1492l.m6919c(alarmItem.startTime) && C1492l.m6919c(alarmItem.endTime)) {
            m9077a(C1492l.m6900a(C1492l.m6920d(alarmItem.startTime)), C1492l.m6914b(C1492l.m6920d(alarmItem.startTime)), C1492l.m6900a(C1492l.m6920d(alarmItem.endTime)), C1492l.m6914b(C1492l.m6920d(alarmItem.endTime)));
            this.f5494j = alarmItem.cycle;
            m9093c(this.f5494j);
            m9083a(alarmItem.label);
            this.f5481N = alarmItem.label;
            if (C1490j.m6890a("ClassDisableSwitch")) {
                this.f5486S = alarmItem.type;
                C2538c.m12674b("AddPeroidActivity", "======= CLASS_DISABLE_SWITCH clock peroid type = " + this.f5486S);
                if (5 == this.f5486S) {
                    this.f5503s.setChecked(true);
                    return;
                } else {
                    this.f5503s.setChecked(false);
                    return;
                }
            }
            C2538c.m12674b("AddPeroidActivity", "======= clock peroid type = " + this.f5486S);
            this.f5486S = 4;
            this.f5503s.setChecked(false);
        }
    }

    public void onSaveClick(View view) {
        C2538c.m12674b("AddPeroidActivity", "==========Enter onSaveClick()");
        if (this.f5497m) {
            C2538c.m12674b("AddPeroidActivity", "==========onSaveClick 当前正在保存，不能反复保存同一静音时段");
            return;
        }
        int d;
        int d2;
        int d3;
        int d4;
        if (C1492l.m6919c(this.f5490e.m7424a())) {
            d = C1492l.m6920d(this.f5490e.m7424a());
        } else {
            d = 0;
        }
        if (C1492l.m6919c(this.f5490e.m7429c())) {
            d2 = C1492l.m6920d(this.f5490e.m7429c());
        } else {
            d2 = 0;
        }
        if (C1492l.m6919c(this.f5491f.m7424a())) {
            d3 = C1492l.m6920d(this.f5491f.m7424a());
        } else {
            d3 = 0;
        }
        if (C1492l.m6919c(this.f5491f.m7429c())) {
            d4 = C1492l.m6920d(this.f5491f.m7429c());
        } else {
            d4 = 0;
        }
        if ((d * 100) + d2 != (d3 * 100) + d4) {
            String str;
            String str2;
            String str3 = "";
            str3 = "";
            if (d > 0 && d < 10) {
                str = this.f5476I + String.valueOf(d);
            } else if (d == 0) {
                str = this.f5477J;
            } else {
                str = String.valueOf(d);
            }
            if (d2 > 0 && d2 < 10) {
                str2 = str + this.f5476I + String.valueOf(d2);
            } else if (d2 == 0) {
                str2 = str + this.f5477J;
            } else {
                str2 = str + String.valueOf(d2);
            }
            if (d3 > 0 && d3 < 10) {
                str = this.f5476I + String.valueOf(d3);
            } else if (d3 == 0) {
                str = this.f5477J;
            } else {
                str = String.valueOf(d3);
            }
            if (d4 > 0 && d4 < 10) {
                str = str + this.f5476I + String.valueOf(d4);
            } else if (d4 == 0) {
                str = str + this.f5477J;
            } else {
                str = str + String.valueOf(d4);
            }
            if (this.f5494j == null || "".equals(this.f5494j) || this.f5494j.length() == 0) {
                C1483c.m6824a(getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_period_alarm_no_title);
                return;
            }
            if (!C1490j.m6890a("ClassDisableSwitch")) {
                this.f5486S = 4;
            }
            C2538c.m12674b("AddPeroidActivity", "======endAlarmTime = " + str);
            AlarmItem alarmItem = new AlarmItem();
            alarmItem.startTime = str2;
            alarmItem.endTime = str;
            alarmItem.cycle = this.f5494j;
            alarmItem.isActive = "1";
            alarmItem.type = this.f5486S;
            alarmItem.label = this.f5481N;
            C2538c.m12674b("AddPeroidActivity", "save===" + alarmItem.toString());
            SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
            setWatchSettingIOModel.deviceCode = C1462f.m6746j();
            Map hashMap = new HashMap();
            if (f5467h) {
                C2538c.m12674b("AddPeroidActivity", "======添加一个新的  ");
                this.f5493i.add(alarmItem);
            } else {
                C2538c.m12674b("AddPeroidActivity", "======添加一个新的2 ");
                this.f5493i.set(this.f5509y, alarmItem);
            }
            C2538c.m12674b("AddPeroidActivity", "======alarmList.size():" + this.f5493i.size());
            hashMap.put("mutePeirodList", this.f5493i);
            setWatchSettingIOModel.settingMap = hashMap;
            m9079a(setWatchSettingIOModel, false, null);
        } else if (System.currentTimeMillis() - this.f5472E > 3000) {
            this.f5472E = System.currentTimeMillis();
            C1483c.m6824a(this.f5498n, C1680l.IDS_plugin_kidwatch_menu_peroid_end_time_error);
        }
    }

    private void m9080a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public void mo2518d() {
        this.f5487b = new C1507h(this.f5498n, h.dialog_contact_delete, m.servicedialog, false);
        TextView textView = (TextView) this.f5487b.findViewById(g.menu_tv_contactdelete_content);
        ((TextView) this.f5487b.findViewById(g.menu_tv_contactdelete_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_peroid_delete));
        textView.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_peroid_delete_content));
        this.f5487b.show();
        ((TextView) this.f5487b.findViewById(g.menu_tv_contactcancle)).setOnClickListener(new an(this));
        ((TextView) this.f5487b.findViewById(g.menu_tv_suredeletecontact)).setOnClickListener(new ao(this));
    }

    private void m9102h() {
        C2538c.m12674b("AddPeroidActivity", "========Enter showSingleChoiceDialog ");
        m9090b(this.f5480M.getText().toString());
    }

    private void m9090b(String str) {
        C2538c.m12674b("AddPeroidActivity", "========Enter sendChangeThemeToCloud");
        if (this.f5485R == null) {
            this.f5485R = new C1507h(this.f5498n, h.dialog_selfdefine, m.servicedialog, false);
        }
        ((TextView) this.f5485R.findViewById(g.common_selfdefine_dialog_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_self_label));
        EditText editText = (EditText) this.f5485R.findViewById(g.common_selfdefine_dialog_content);
        editText.setHint(String.format(this.f5498n.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_poried_edit_info), new Object[]{Integer.valueOf(7), Integer.valueOf(12)}));
        editText.setFilters(new InputFilter[]{new LengthFilter(12)});
        C1886b.m9648a(editText);
        editText.setText(str);
        editText.setSelection(editText.getText().length());
        this.f5485R.show();
        this.f5485R.findViewById(g.common_selfdefine_dialog_cancle).setOnClickListener(new ap(this, str));
        this.f5485R.findViewById(g.common_selfdefine_dialog_sure).setOnClickListener(new aq(this, editText));
    }

    public void onClick(View view) {
        int i = 0;
        int id = view.getId();
        if (id == g.setting_peroid_title_choose) {
            m9102h();
        } else if (g.peroid_btn_delete_peroid == id) {
            mo2518d();
        } else if (g.setting_peroid_repeate_choose == id) {
            C2538c.m12674b("AddPeroidActivity", "==========选择重复日期");
            while (i < this.f5470C.length) {
                this.f5471D[i] = this.f5470C[i];
                i++;
            }
            mo2519e();
        }
    }

    private void m9079a(SetWatchSettingIOModel setWatchSettingIOModel, boolean z, AlarmItem alarmItem) {
        C2538c.m12674b("AddPeroidActivity", "==========Enter saveAlarmToCloud");
        if (this.f5497m) {
            C2538c.m12674b("AddPeroidActivity", "==========当前正在保存，不能反复保存同一静音时段");
            return;
        }
        this.f5497m = true;
        this.f5483P.setVisibility(0);
        this.f5483P.m7206a(true);
        this.f5492g.mo2496a(setWatchSettingIOModel, new ar(this, z, alarmItem));
    }

    private void m9077a(int i, int i2, int i3, int i4) {
        int i5;
        C2538c.m12674b("AddPeroidActivity", "=======Enter initAlarmPicker");
        C2538c.m12674b("AddPeroidActivity", "=======hour:", i + "\n=======min:" + i2);
        WheelView wheelView = (WheelView) findViewById(g.setting_peroid_number_picker3);
        WheelView wheelView2 = (WheelView) findViewById(g.setting_peroid_number_picker4);
        this.f5490e = new C1605e(this.f5498n, (WheelView) findViewById(g.setting_peroid_number_picker1), (WheelView) findViewById(g.setting_peroid_number_picker2));
        this.f5491f = new C1605e(this.f5498n, wheelView, wheelView2);
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
        this.f5490e.m7426a(strArr, i, true);
        this.f5490e.m7428b(strArr2, i2, true);
        this.f5491f.m7426a(strArr, i3, true);
        this.f5491f.m7428b(strArr2, i4, true);
        C2538c.m12674b("AddPeroidActivity", "=======initAlarmPicker leave");
    }

    public void mo2519e() {
        this.f5473F = new C1843n(this);
        this.f5473F.m8922a(false);
        this.f5488c = this.f5473F.m8919a(getResources().getString(C1680l.IDS_plugin_kidwatch_common_repeat)).m8921a(this.f5482O, this.f5470C, null, null, true).m8920a(getResources().getString(C1680l.IDS_plugin_kidwatch_common_cancel), new as(this)).m8925b(getResources().getString(C1680l.IDS_plugin_kidwatch_common_set), new at(this)).m8924b();
        this.f5488c.show();
    }

    private void m9093c(String str) {
        int i;
        CharSequence charSequence = "";
        for (i = 0; i < 7; i++) {
            this.f5470C[i] = false;
        }
        if ("".equals(str) || str.contains("-") || str.contains(".")) {
            C2538c.m12674b("AddPeroidActivity", "==============repeate is not effective");
            this.f5495k.setText("");
            return;
        }
        if (7 == str.length()) {
            charSequence = getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_everyday) + HwAccountConstants.BLANK;
            for (i = 0; i < 7; i++) {
                this.f5470C[i] = true;
            }
        } else if (str.equals(this.f5499o)) {
            charSequence = this.f5498n.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_workday) + HwAccountConstants.BLANK;
            for (i = 1; i < 6; i++) {
                this.f5470C[i] = true;
            }
        } else {
            for (i = 0; i < str.length(); i++) {
                switch (C1492l.m6920d(str.substring(i, i + 1))) {
                    case 1:
                        this.f5470C[1] = true;
                        charSequence = charSequence + this.f5498n.getString(C1680l.IDS_plugin_kidwatch_common_monday) + HwAccountConstants.BLANK;
                        break;
                    case 2:
                        this.f5470C[2] = true;
                        charSequence = charSequence + this.f5498n.getString(C1680l.IDS_plugin_kidwatch_common_tuesday) + HwAccountConstants.BLANK;
                        break;
                    case 3:
                        this.f5470C[3] = true;
                        charSequence = charSequence + this.f5498n.getString(C1680l.IDS_plugin_kidwatch_common_wednesday) + HwAccountConstants.BLANK;
                        break;
                    case 4:
                        this.f5470C[4] = true;
                        charSequence = charSequence + this.f5498n.getString(C1680l.IDS_plugin_kidwatch_common_thursday) + HwAccountConstants.BLANK;
                        break;
                    case 5:
                        this.f5470C[5] = true;
                        charSequence = charSequence + this.f5498n.getString(C1680l.IDS_plugin_kidwatch_common_friday) + HwAccountConstants.BLANK;
                        break;
                    case 6:
                        this.f5470C[6] = true;
                        charSequence = charSequence + this.f5498n.getString(C1680l.IDS_plugin_kidwatch_common_saturday) + HwAccountConstants.BLANK;
                        break;
                    case 7:
                        this.f5470C[0] = true;
                        charSequence = charSequence + this.f5498n.getString(C1680l.IDS_plugin_kidwatch_common_sunday) + HwAccountConstants.BLANK;
                        break;
                    default:
                        break;
                }
            }
        }
        if (charSequence.length() > 1) {
            charSequence = charSequence.substring(0, charSequence.length() - 1);
        }
        this.f5495k.setText(charSequence);
    }

    protected void onPause() {
        super.onPause();
        C2538c.m12674b("AddPeroidActivity", "*****AddPeroidActivity onPause*****");
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12674b("AddPeroidActivity", "*****AddPeroidActivity onResume*****");
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12674b("AddPeroidActivity", "*****AddPeroidActivity onDestroy*****");
    }

    protected void onStart() {
        super.onStart();
        C2538c.m12674b("AddPeroidActivity", "*****AddPeroidActivity onStart*****");
    }

    protected void onStop() {
        super.onStop();
        C2538c.m12674b("AddPeroidActivity", "*****AddPeroidActivity onStop*****");
    }
}
