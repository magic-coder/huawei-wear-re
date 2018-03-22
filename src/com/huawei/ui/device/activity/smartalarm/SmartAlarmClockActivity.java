package com.huawei.ui.device.activity.smartalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.ab;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.ui.commonui.dialog.j;
import com.huawei.ui.commonui.dialog.l;
import com.huawei.ui.commonui.dialog.z;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.commonui.wheelview21.WheelView;
import com.huawei.ui.commonui.wheelview21.a;
import com.huawei.ui.commonui.wheelview21.c;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.p171b.C2183a;
import java.util.ArrayList;
import java.util.List;

public class SmartAlarmClockActivity extends BaseActivity implements OnClickListener {
    private ai f7615A;
    private Handler f7616B = new C2166m(this, this);
    private boolean f7617C = false;
    private a f7618D = new C2165l(this);
    private OnItemClickListener f7619E = new C2156c(this);
    private TextView f7620a;
    private TextView f7621b;
    private C1990r f7622c;
    private C2183a f7623d;
    private List<SmartAlarmInfo> f7624e = new ArrayList();
    private RelativeLayout f7625f;
    private Context f7626g = null;
    private TextView f7627h;
    private c f7628i = null;
    private c f7629j = null;
    private z f7630k;
    private String[] f7631l = new String[7];
    private int f7632m = 31;
    private TextView f7633n;
    private CustomTitleBar f7634o;
    private int f7635p;
    private int f7636q;
    private int f7637r;
    private int f7638s;
    private int f7639t;
    private int f7640u;
    private j f7641v;
    private l f7642w;
    private String[] f7643x;
    private boolean[] f7644y = new boolean[]{false, false, true, false, false};
    private int f7645z = 2;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_alarm_smart_clock_black);
        this.f7626g = BaseApplication.m2632b();
        C2538c.m12677c("SmartAlarmClockActivity", "onCreate()");
        this.f7622c = C1990r.m10400a(null);
        this.f7623d = C2183a.m11184a(null);
        this.f7643x = new String[]{this.f7626g.getString(i.IDS_settings_about_huawei_cloud_service_action_turn_off), C0956c.m3344a(5.0d, 1, 0), C0956c.m3344a(10.0d, 1, 0), C0956c.m3344a(20.0d, 1, 0), C0956c.m3344a(30.0d, 1, 0)};
        m11054b();
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12677c("SmartAlarmClockActivity", "onResume()");
        m11046a();
        int intExtra = getIntent().getIntExtra("key_to_smart_alarm_activity", 0);
        m11048a(intExtra / 100, intExtra % 100);
        this.f7617C = true;
    }

    private void m11046a() {
        C2538c.m12677c("SmartAlarmClockActivity", "getSmartAlarm()");
        this.f7622c.m10437d(new C2154a(this));
    }

    private void m11054b() {
        this.f7634o = (CustomTitleBar) d.a(this, e.smart_alarm_title_bar);
        this.f7634o.setRightButtonOnClickListener(new C2157d(this));
        this.f7634o.setLeftButtonOnClickListener(new C2158e(this));
        if (b.a(BaseApplication.m2632b())) {
            ((ImageView) d.a(this, e.arrow)).setBackgroundResource(g.ic_goal_arrow_left);
            ((ImageView) d.a(this, e.settings_switch)).setBackgroundResource(g.ic_goal_arrow_left);
        }
        this.f7627h = (TextView) d.a(this, e.smart_alarm__prompt_description);
        this.f7620a = (TextView) d.a(this, e.smart_alarm_ahead_time);
        this.f7621b = (TextView) d.a(this, e.smart_alarm_ahead_time_unit);
        this.f7633n = (TextView) d.a(this, e.event_alarm_repeat);
        this.f7625f = (RelativeLayout) d.a(this, e.smart_alarm_ahead_time_ll);
        this.f7625f.setOnClickListener(this);
        ((RelativeLayout) d.a(this, e.smart_alarm_repeat_ll)).setOnClickListener(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void m11058c() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("smart_time", this.f7623d.m11187a(this.f7628i));
        bundle.putString("ahead_time", this.f7620a.getText().toString());
        bundle.putInt("week_day", this.f7632m);
        intent.putExtras(bundle);
        setResult(10, intent);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == e.smart_alarm_ahead_time_ll) {
            C2538c.m12677c("SmartAlarmClockActivity", "onClick() id=ahead_time");
            m11077j();
        } else if (id == e.smart_alarm_repeat_ll) {
            C2538c.m12677c("SmartAlarmClockActivity", "onClick() id=smart_repeat");
            m11064e();
        } else {
            C2538c.m12677c("SmartAlarmClockActivity", "i = " + id);
        }
    }

    private boolean m11061d() {
        int a = this.f7623d.m11187a(this.f7628i);
        C2538c.m12677c("SmartAlarmClockActivity", "isSmartClockChanged() aheadTime=" + m11071h());
        if (this.f7624e == null || this.f7624e.size() == 0) {
            return false;
        }
        SmartAlarmInfo smartAlarmInfo = (SmartAlarmInfo) this.f7624e.get(0);
        if (a == (smartAlarmInfo.getSmartAlarmStartTime_hour() * 100) + smartAlarmInfo.getSmartAlarmStartTime_mins() && this.f7632m == smartAlarmInfo.getSmartAlarmRepeat() && r4 == smartAlarmInfo.getSmartAlarmAheadTime()) {
            C2538c.m12677c("SmartAlarmClockActivity", "saveUIData() return with nothing changed!!!!");
            return false;
        }
        this.f7636q = 1;
        return true;
    }

    private void m11064e() {
        boolean z;
        String a = this.f7623d.m11191a(Integer.toBinaryString(this.f7632m), 7);
        boolean[] zArr = new boolean[7];
        zArr[0] = a.charAt(6) == '1';
        zArr[1] = a.charAt(5) == '1';
        if (a.charAt(4) == '1') {
            z = true;
        } else {
            z = false;
        }
        zArr[2] = z;
        zArr[3] = a.charAt(3) == '1';
        zArr[4] = a.charAt(2) == '1';
        zArr[5] = a.charAt(1) == '1';
        zArr[6] = a.charAt(0) == '1';
        this.f7631l = new String[]{this.f7626g.getString(i.IDS_monday), this.f7626g.getString(i.IDS_tuesday), this.f7626g.getString(i.IDS_wednesday), this.f7626g.getString(i.IDS_thursday), this.f7626g.getString(i.IDS_friday), this.f7626g.getString(i.IDS_saturday), this.f7626g.getString(i.IDS_sunday)};
        Object aVar = new com.huawei.ui.commonui.a.a(this.f7626g, this.f7631l, zArr);
        View listView = new ListView(this.f7626g);
        listView.setDivider(null);
        listView.setAdapter(aVar);
        listView.setOnItemClickListener(new com.huawei.ui.commonui.a.c());
        this.f7630k = new ab(this).a(i.IDS_settings_repeat).a(listView).a(getResources().getString(i.IDS_settings_button_ok).toUpperCase(), new C2160g(this, aVar)).b(getResources().getString(i.IDS_settings_button_cancal).toUpperCase(), new C2159f(this)).a();
        this.f7630k.show();
    }

    private void m11049a(Context context) {
        C2538c.m12677c("SmartAlarmClockActivity", "showPromptSaveDialog()");
        this.f7615A = new ak(context).a(i.IDS_alarm_settings_save_changes).a(i.IDS_save, new C2162i(this)).b(i.IDS_btn_discard, new C2161h(this)).a();
        this.f7615A.setCancelable(false);
        this.f7615A.show();
    }

    private void m11067f() {
        C2538c.m12677c("SmartAlarmClockActivity", "updateSmartAlarmUI() mSmartAlarmList.size()" + this.f7624e.size());
        if (this.f7624e.size() != 0) {
            SmartAlarmInfo smartAlarmInfo = (SmartAlarmInfo) this.f7624e.get(0);
            int smartAlarmStartTime_hour = (smartAlarmInfo.getSmartAlarmStartTime_hour() * 100) + smartAlarmInfo.getSmartAlarmStartTime_mins();
            int smartAlarmStartTime_hour2 = smartAlarmInfo.getSmartAlarmStartTime_hour();
            int smartAlarmStartTime_mins = smartAlarmInfo.getSmartAlarmStartTime_mins();
            C2183a c2183a = this.f7623d;
            String a = C2183a.m11185a(this.f7626g, smartAlarmStartTime_hour);
            CharSequence string = this.f7626g.getString(i.IDS_settings_about_huawei_cloud_service_action_turn_off);
            if (smartAlarmInfo.getSmartAlarmAheadTime() == 0) {
                this.f7620a.setText(string);
                this.f7621b.setVisibility(8);
            } else {
                this.f7620a.setText(String.valueOf(this.f7640u));
                this.f7621b.setVisibility(0);
            }
            int a2 = this.f7623d.m11186a(smartAlarmStartTime_hour2, smartAlarmStartTime_mins, smartAlarmInfo.getSmartAlarmAheadTime());
            C2183a c2183a2 = this.f7623d;
            String a3 = C2183a.m11185a(this.f7626g, a2);
            this.f7633n.setText(this.f7623d.m11194b(this.f7632m));
            if (m11071h() == 0) {
                this.f7627h.setText("");
                return;
            }
            this.f7627h.setText(String.format(this.f7626g.getString(i.IDS_settings_alarm_prompt_new), new Object[]{a3, a, this.f7622c.m10446j()}));
        }
    }

    private void m11069g() {
        C2538c.m12677c("SmartAlarmClockActivity", "saveUIData()");
        if (this.f7620a != null) {
            this.f7622c.m10437d(new C2163j(this));
        }
    }

    private int m11071h() {
        String string = this.f7626g.getString(i.IDS_settings_about_huawei_cloud_service_action_turn_off);
        Object charSequence = this.f7620a.getText().toString();
        C2538c.m12677c("SmartAlarmClockActivity", "getAheadTime() strAheadText=" + charSequence);
        if (TextUtils.isEmpty(charSequence) || string.equals(charSequence)) {
            return 0;
        }
        return Integer.parseInt(charSequence);
    }

    private void m11048a(int i, int i2) {
        C2538c.m12677c("SmartAlarmClockActivity", "initAlarmPicker enter");
        WheelView wheelView = (WheelView) d.a(this, e.number_picker);
        WheelView wheelView2 = (WheelView) d.a(this, e.number_picker_unit);
        WheelView wheelView3 = (WheelView) d.a(this, e.morning_after_picker);
        WheelView wheelView4 = (WheelView) d.a(this, e.morning_after_picker_two);
        if (DateFormat.is24HourFormat(this.f7626g)) {
            this.f7628i = this.f7623d.m11190a(i, i2, wheelView3, wheelView, wheelView2, this.f7618D);
        } else {
            this.f7628i = this.f7623d.m11189a(i, i2, wheelView3, wheelView4, wheelView, wheelView2, this.f7618D);
        }
        C2538c.m12677c("SmartAlarmClockActivity", "leave initAlarmPicker ");
    }

    private void m11076i() {
        int h = m11071h();
        C2538c.m12677c("SmartAlarmClockActivity", "modifyPrompt interval=" + h);
        int a = this.f7623d.m11187a(this.f7628i);
        C2183a c2183a = this.f7623d;
        String a2 = C2183a.m11185a(this.f7626g, a);
        a = this.f7623d.m11186a(a / 100, a % 100, h);
        C2183a c2183a2 = this.f7623d;
        String a3 = C2183a.m11185a(this.f7626g, a);
        if (h == 0) {
            this.f7627h.setText("");
            return;
        }
        this.f7627h.setText(String.format(this.f7626g.getString(i.IDS_settings_alarm_prompt_new), new Object[]{a3, a2, this.f7622c.m10446j()}));
    }

    private void m11077j() {
        if (!isFinishing()) {
            r1 = new String[5];
            r1[1] = getResources().getString(i.IDS_hw_show_set_target_sport_time_unit, new Object[]{C0956c.m3344a(5.0d, 1, 0)});
            r1[2] = getResources().getString(i.IDS_hw_show_set_target_sport_time_unit, new Object[]{C0956c.m3344a(10.0d, 1, 0)});
            r1[3] = getResources().getString(i.IDS_hw_show_set_target_sport_time_unit, new Object[]{C0956c.m3344a(20.0d, 1, 0)});
            r1[4] = getResources().getString(i.IDS_hw_show_set_target_sport_time_unit, new Object[]{C0956c.m3344a(30.0d, 1, 0)});
            if (this.f7641v == null) {
                this.f7642w = new l(this);
                this.f7642w.a(getString(i.IDS_settings_ahead_of_time));
                this.f7642w.a(r1, this.f7644y, null, this.f7619E, false);
                this.f7642w.a(getResources().getString(i.IDS_settings_button_cancal).toUpperCase(), new C2155b(this));
                this.f7641v = this.f7642w.b();
            }
            this.f7641v.show();
            C2538c.m12674b("SmartAlarmClockActivity", "showSamrtWakeDialog()");
        }
    }

    private void m11080k() {
        if (!isFinishing() && this.f7641v != null) {
            this.f7641v.cancel();
            this.f7641v = null;
            this.f7642w = null;
        }
    }

    private void m11047a(int i) {
        C2538c.m12674b("SmartAlarmClockActivity", "initAheadTime... aheadTime = ", Integer.valueOf(i));
        switch (i) {
            case 0:
                m11055b(0);
                return;
            case 5:
                m11055b(1);
                return;
            case 10:
                m11055b(2);
                return;
            case 20:
                m11055b(3);
                return;
            case 30:
                m11055b(4);
                return;
            default:
                m11055b(2);
                return;
        }
    }

    private void m11055b(int i) {
        for (int i2 = 0; i2 < this.f7644y.length; i2++) {
            this.f7644y[i2] = false;
        }
        this.f7644y[i] = true;
    }

    protected void onPause() {
        super.onPause();
        this.f7617C = false;
        C2538c.m12677c("SmartAlarmClockActivity", "onPause()");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (m11061d()) {
            m11049a((Context) this);
        } else {
            finish();
        }
        return false;
    }

    protected void onDestroy() {
        C0977d.m3575n(this.f7626g);
        super.onDestroy();
        if (this.f7616B != null) {
            this.f7616B.removeCallbacksAndMessages(null);
        }
    }
}
