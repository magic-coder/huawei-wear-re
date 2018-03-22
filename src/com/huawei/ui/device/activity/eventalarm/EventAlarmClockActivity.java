package com.huawei.ui.device.activity.eventalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.hwbasemgr.b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.a.a;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.ab;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.ui.commonui.dialog.z;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.commonui.wheelview21.WheelView;
import com.huawei.ui.commonui.wheelview21.c;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.p171b.C2183a;
import com.huawei.ui.device.views.p173b.C2190b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventAlarmClockActivity extends BaseActivity implements OnClickListener {
    private static String f7235h = null;
    String f7236a = "";
    private long f7237b = 0;
    private long f7238c = 0;
    private long f7239d = 0;
    private Button f7240e = null;
    private TextView f7241f = null;
    private RelativeLayout f7242g;
    private CustomTitleBar f7243i;
    private c f7244j = null;
    private boolean f7245k;
    private List<EventAlarmInfo> f7246l = new ArrayList();
    private List<EventAlarmInfo> f7247m = new ArrayList();
    private C1990r f7248n;
    private C2190b f7249o = null;
    private EventAlarmInfo f7250p = null;
    private Context f7251q = null;
    private TextView f7252r;
    private z f7253s;
    private int f7254t = 0;
    private String[] f7255u = new String[7];
    private C2183a f7256v;
    private ai f7257w;
    private ai f7258x;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7251q = BaseApplication.m2632b();
        C2538c.m12677c("EventAlarmClockActivity", "onCreate()");
        setContentView(f.activity_event_alarm_clock);
        this.f7248n = C1990r.m10400a(null);
        this.f7256v = C2183a.m11184a(null);
        m10741c();
    }

    private void m10741c() {
        C2538c.m12677c("EventAlarmClockActivity", "initView()");
        this.f7243i = (CustomTitleBar) d.a(this, e.setting_event_alarm_title_bar);
        this.f7243i.setRightButtonOnClickListener(new C2063a(this));
        this.f7243i.setLeftButtonOnClickListener(new C2071i(this));
        this.f7240e = (Button) d.a(this, e.clock_btn_delete);
        this.f7240e.setText(getString(i.IDS_settings_mult_alarm_clock_delete_title).toUpperCase());
        this.f7240e.setOnClickListener(this);
        this.f7241f = (TextView) d.a(this, e.smart_alarm_info);
        this.f7242g = (RelativeLayout) d.a(this, e.smart_alarm_clock_ll);
        this.f7242g.setOnClickListener(this);
        this.f7252r = (TextView) d.a(this, e.event_alarm_repeat);
        ((RelativeLayout) d.a(this, e.smart_alarm_repeat_ll)).setOnClickListener(this);
        if (b.a(BaseApplication.m2632b())) {
            d.a(this, e.settings_switch).setBackgroundResource(g.ic_goal_arrow_left);
            d.a(this, e.settings_alarm_name).setBackgroundResource(g.ic_goal_arrow_left);
        }
    }

    protected void onResume() {
        super.onResume();
        Intent intent = super.getIntent();
        this.f7245k = intent.getBooleanExtra("from_add_button", false);
        if (this.f7245k) {
            m10737a(null);
        } else {
            this.f7249o = (C2190b) intent.getSerializableExtra("from_list_item");
            if (this.f7249o != null) {
                this.f7254t = this.f7249o.m11241f();
                m10737a(this.f7249o);
            } else {
                C2538c.m12677c("EventAlarmClockActivity", "mEventAlarmItem is null!");
            }
        }
        C2538c.m12677c("EventAlarmClockActivity", "onResume()");
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.f7245k) {
            m10745e();
        }
        finish();
    }

    private void m10737a(C2190b c2190b) {
        C2538c.m12677c("EventAlarmClockActivity", "initUIData()");
        Calendar instance = Calendar.getInstance();
        if (c2190b == null) {
            C2538c.m12677c("EventAlarmClockActivity", "null == clock");
            m10734a(instance.get(11), instance.get(12));
            this.f7241f.setText(i.IDS_settings_prompt);
            f7235h = this.f7241f.getText().toString();
            this.f7240e.setVisibility(8);
            this.f7243i.setTitleText(getResources().getString(i.IDS_settings_mult_alarm_clock_add_clock));
            this.f7252r.setText(this.f7256v.m11194b(this.f7254t));
            return;
        }
        int b = c2190b.m11231b();
        C2538c.m12677c("EventAlarmClockActivity", "编辑闹钟 time = " + b);
        m10734a(b / 100, b % 100);
        if (TextUtils.isEmpty(c2190b.m11237d())) {
            this.f7241f.setText(i.IDS_settings_prompt);
            f7235h = this.f7241f.getText().toString();
        } else {
            this.f7241f.setText(c2190b.m11237d());
            f7235h = c2190b.m11237d();
        }
        this.f7252r.setText(this.f7249o.m11239e());
        this.f7243i.setTitleText(getResources().getString(i.IDS_settings_mult_alarm_clock_edit_title));
    }

    private void m10734a(int i, int i2) {
        C2538c.m12677c("EventAlarmClockActivity", "initAlarmPicker enter");
        WheelView wheelView = (WheelView) d.a(this, e.number_picker);
        WheelView wheelView2 = (WheelView) d.a(this, e.number_picker_unit);
        WheelView wheelView3 = (WheelView) d.a(this, e.morning_after_picker);
        WheelView wheelView4 = (WheelView) d.a(this, e.morning_after_picker_two);
        if (DateFormat.is24HourFormat(this.f7251q)) {
            this.f7244j = this.f7256v.m11190a(i, i2, wheelView3, wheelView, wheelView2, null);
        } else {
            this.f7244j = this.f7256v.m11189a(i, i2, wheelView3, wheelView4, wheelView, wheelView2, null);
        }
        C2538c.m12677c("EventAlarmClockActivity", "leave initAlarmPicker ");
    }

    protected void onDestroy() {
        C0977d.m3575n(this.f7251q);
        super.onDestroy();
    }

    public void onClick(View view) {
        C2538c.m12677c("EventAlarmClockActivity", "onClick()");
        int id = view.getId();
        long timeInMillis;
        if (id == e.clock_btn_delete) {
            timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.f7237b > 1000) {
                this.f7237b = timeInMillis;
                C2538c.m12677c("EventAlarmClockActivity", "onClick() id = clock_btn_delete");
                m10758l();
            }
        } else if (id == e.smart_alarm_repeat_ll) {
            timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.f7238c > 1000) {
                this.f7238c = timeInMillis;
                C2538c.m12677c("EventAlarmClockActivity", "onClick() id = smart_alarm_repeat_ll");
                m10743d();
            }
        } else if (id == e.smart_alarm_clock_ll) {
            timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.f7239d > 1000) {
                this.f7239d = timeInMillis;
                C2538c.m12677c("EventAlarmClockActivity", "onClick() id = smart_alarm_clock_ll");
                m10761a();
            }
        } else {
            C2538c.m12677c("EventAlarmClockActivity", "onClick() id = " + id);
        }
    }

    private void m10743d() {
        boolean z;
        String a = this.f7256v.m11191a(Integer.toBinaryString(this.f7254t), 7);
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
        this.f7255u = new String[]{this.f7251q.getString(i.IDS_monday), this.f7251q.getString(i.IDS_tuesday), this.f7251q.getString(i.IDS_wednesday), this.f7251q.getString(i.IDS_thursday), this.f7251q.getString(i.IDS_friday), this.f7251q.getString(i.IDS_saturday), this.f7251q.getString(i.IDS_sunday)};
        Object aVar = new a(this.f7251q, this.f7255u, zArr);
        View listView = new ListView(this.f7251q);
        listView.setDivider(null);
        listView.setAdapter(aVar);
        listView.setOnItemClickListener(new com.huawei.ui.commonui.a.c());
        this.f7253s = new ab(this).a(i.IDS_settings_repeat).a(listView).b(getResources().getString(i.IDS_settings_button_cancal).toUpperCase(), new C2073k(this)).a(getResources().getString(i.IDS_settings_button_ok).toUpperCase(), new C2072j(this, aVar)).a();
        this.f7253s.show();
    }

    private void m10745e() {
        setResult(11, new Intent());
        C2538c.m12677c("EventAlarmClockActivity", "setResultData()");
    }

    private void m10747f() {
        this.f7248n.m10433c(new C2074l(this));
    }

    private void m10748g() throws UnsupportedEncodingException {
        C2538c.m12677c("EventAlarmClockActivity", "saveClock()");
        if (TextUtils.isEmpty(this.f7241f.getText().toString().trim())) {
            this.f7241f.setText(i.IDS_settings_prompt);
            f7235h = this.f7241f.getText().toString();
        }
        if (this.f7245k) {
            m10755j();
        } else if (m10753i()) {
            finish();
        } else {
            m10757k();
        }
    }

    private void m10751h() {
        C2538c.m12677c("EventAlarmClockActivity", "clickCancelBtn()");
        if (m10753i()) {
            m10745e();
            finish();
            return;
        }
        m10735a((Context) this);
    }

    private boolean m10753i() {
        C2538c.m12677c("EventAlarmClockActivity", "isEqualDB()");
        if (this.f7244j == null || this.f7250p == null) {
            return false;
        }
        int a = this.f7256v.m11187a(this.f7244j);
        C2538c.m12677c("EventAlarmClockActivity", " isEqualDB() ---AlarmListItem" + this.f7249o.m11242g());
        String charSequence = this.f7241f.getText().toString();
        if (this.f7254t == this.f7249o.m11241f() && a == Integer.parseInt(this.f7249o.m11234c()) && charSequence.equals(this.f7249o.m11237d())) {
            return true;
        }
        return false;
    }

    private void m10755j() {
        C2538c.m12677c("EventAlarmClockActivity", "addAlarm()");
        this.f7247m.clear();
        this.f7248n.m10433c(new C2076n(this));
        int a = this.f7256v.m11187a(this.f7244j);
        EventAlarmInfo eventAlarmInfo = new EventAlarmInfo();
        eventAlarmInfo.setEventAlarmStartTime_hour(a / 100);
        eventAlarmInfo.setEventAlarmStartTime_mins(a % 100);
        eventAlarmInfo.setEventAlarmRepeat(this.f7254t);
        eventAlarmInfo.setEventAlarmName(this.f7241f.getText().toString());
        eventAlarmInfo.setEventAlarmEnable(1);
        this.f7247m.add(eventAlarmInfo);
        this.f7248n.m10419a(this.f7247m, new C2077o(this));
    }

    private void m10757k() {
        C2538c.m12677c("EventAlarmClockActivity", "updateEventAlarm()");
        this.f7247m.clear();
        int a = this.f7256v.m11187a(this.f7244j);
        this.f7248n.m10433c(new C2078p(this));
        EventAlarmInfo eventAlarmInfo = new EventAlarmInfo();
        eventAlarmInfo.setEventAlarmStartTime_hour(a / 100);
        eventAlarmInfo.setEventAlarmStartTime_mins(a % 100);
        eventAlarmInfo.setEventAlarmRepeat(this.f7254t);
        eventAlarmInfo.setEventAlarmName(this.f7241f.getText().toString());
        eventAlarmInfo.setEventAlarmEnable(1);
        this.f7247m.add(eventAlarmInfo);
        this.f7248n.m10419a(this.f7247m, new C2079q(this));
    }

    private void m10735a(Context context) {
        C2538c.m12677c("EventAlarmClockActivity", "showPromptSaveDialog()");
        ak akVar = new ak(this);
        akVar.a(i.IDS_alarm_settings_save_changes).a(getResources().getString(i.IDS_save).toUpperCase(), new C2065c(this)).b(getResources().getString(i.IDS_btn_discard).toUpperCase(), new C2064b(this));
        this.f7257w = akVar.a();
        this.f7257w.setCancelable(false);
        this.f7257w.show();
    }

    private void m10758l() {
        C2538c.m12677c("EventAlarmClockActivity", "showPromptSaveDialog()");
        ak akVar = new ak(this);
        akVar.a(i.IDS_alarm_settings_delete).a(getResources().getString(i.IDS_music_management_delete).toUpperCase(), com.huawei.ui.device.b.common_text_red_color, new C2067e(this)).b(getResources().getString(i.IDS_settings_button_cancal).toUpperCase(), new C2066d(this));
        this.f7258x = akVar.a();
        this.f7258x.setCancelable(false);
        this.f7258x.show();
    }

    public void m10761a() {
        C2538c.m12677c("EventAlarmClockActivity", "enter editName():");
        View inflate = LayoutInflater.from(this).inflate(f.activity_device_settings_eventalarm_edit_name_layout, null);
        EditText editText = (EditText) inflate.findViewById(e.event_alarm_layout_name);
        C2538c.m12677c("EventAlarmClockActivity", "enter editName() nameStr.length() = " + f7235h.length());
        editText.requestFocus();
        editText.setText(f7235h);
        editText.setHint(i.IDS_settings_prompt);
        editText.setTextColor(getResources().getColor(com.huawei.ui.device.b.common_white_90alpha));
        editText.setSelection(f7235h.length());
        editText.addTextChangedListener(new C2068f(this, editText));
        ab abVar = new ab(this);
        abVar.a(i.IDS_settings_mult_alarm_clock_name).a(inflate).b(getResources().getString(i.IDS_settings_button_cancal).toUpperCase(), new C2070h(this)).a(getResources().getString(i.IDS_settings_button_ok).toUpperCase(), new C2069g(this, editText));
        abVar.a().show();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        m10751h();
        return false;
    }
}
