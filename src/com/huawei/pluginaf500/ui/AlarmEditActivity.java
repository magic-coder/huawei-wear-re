package com.huawei.pluginaf500.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.fenda.hwbracelet.mode.Alarm;
import com.fenda.hwbracelet.mode.C3620c;
import com.fenda.p255a.p256a.C3565a;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.p498b.C5774a;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import com.huawei.pluginaf500.utils.C5826i;
import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.C5834f;
import com.huawei.pluginaf500.view.wheel.WheelView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AlarmEditActivity extends AF500BaseActivity implements C5791c {
    EditText f19691a;
    C5834f f19692b;
    boolean f19693c = false;
    private String f19694d = "AlarmEditActivity";
    private int f19695g;
    private int f19696h;
    private CheckBox f19697i;
    private CheckBox f19698j;
    private CheckBox f19699k;
    private CheckBox f19700l;
    private CheckBox f19701m;
    private CheckBox f19702n;
    private CheckBox f19703o;
    private Alarm f19704p;
    private List<Alarm> f19705q;
    private List<Alarm> f19706r;
    private OnClickListener f19707s = new C5805n(this);
    private OnClickListener f19708t = new C5806o(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.alarm_edit);
        m26650j();
        this.f19704p = (Alarm) getIntent().getParcelableExtra("alarm");
        if (this.f19704p != null) {
            if (this.f19705q != null) {
                for (int i = 0; i < this.f19705q.size(); i++) {
                    if (((Alarm) this.f19705q.get(i)).getId() == this.f19704p.getId()) {
                        this.f19704p = (Alarm) this.f19705q.get(i);
                    }
                }
            }
            m26652l();
        }
    }

    private void m26650j() {
        List k = m26651k();
        if (k == null || k.size() <= 0) {
            this.f19705q = new ArrayList();
        } else {
            this.f19705q = k;
        }
    }

    private List<Alarm> m26651k() {
        Collection a = new C3565a(this).m17898a();
        if (a != null) {
            this.f19706r = new ArrayList(a);
        } else {
            this.f19706r = new ArrayList();
        }
        return new C3565a(this).m17898a();
    }

    private void m26652l() {
        boolean z;
        this.f19697i = (CheckBox) findViewById(e.cb_week_1);
        this.f19697i.setChecked(this.f19704p.getMon() == 1);
        this.f19698j = (CheckBox) findViewById(e.cb_week_2);
        CheckBox checkBox = this.f19698j;
        if (this.f19704p.getTue() == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        this.f19699k = (CheckBox) findViewById(e.cb_week_3);
        checkBox = this.f19699k;
        if (this.f19704p.getWed() == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        this.f19700l = (CheckBox) findViewById(e.cb_week_4);
        checkBox = this.f19700l;
        if (this.f19704p.getThu() == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        this.f19701m = (CheckBox) findViewById(e.cb_week_5);
        checkBox = this.f19701m;
        if (this.f19704p.getFri() == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        this.f19702n = (CheckBox) findViewById(e.cb_week_6);
        checkBox = this.f19702n;
        if (this.f19704p.getSta() == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        this.f19703o = (CheckBox) findViewById(e.cb_week_7);
        checkBox = this.f19703o;
        if (this.f19704p.getSun() == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        this.f19691a = (EditText) findViewById(e.alarm_name);
        this.f19691a.setText(this.f19704p.getName());
        WheelView wheelView = (WheelView) findViewById(e.hour);
        wheelView.m26967a((C5791c) this);
        WheelView wheelView2 = (WheelView) findViewById(e.minute);
        wheelView2.m26967a((C5791c) this);
        this.f19692b = new C5834f(this, wheelView, wheelView2, 0);
        this.f19695g = Integer.parseInt(this.f19704p.getTime().split(":")[0]);
        this.f19696h = Integer.parseInt(this.f19704p.getTime().split(":")[1]);
        this.f19692b.m26982a(this.f19695g, this.f19696h);
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        int id = view.getId();
        if (id == e.btn_delete) {
            finish();
        } else if (id == e.btn_ok) {
            if (this.f19704p != null) {
                m26653m();
                if (m26657q()) {
                    C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19707s, this.f19708t);
                } else {
                    finish();
                }
            }
        } else if (id == e.btn_cancel) {
            finish();
        }
    }

    private void m26653m() {
        String str;
        int i;
        int i2 = 1;
        EditText editText = (EditText) findViewById(e.alarm_name);
        this.f19704p.setName(editText.getText() == null ? "�ֻ�����" : editText.getText().toString());
        if (this.f19695g < 10) {
            str = "0" + this.f19695g;
        } else {
            str = this.f19695g + "";
        }
        if (this.f19696h < 10) {
            str = str + ":0" + this.f19696h;
        } else {
            str = str + ":" + this.f19696h;
        }
        this.f19704p.setTime(str);
        Alarm alarm = this.f19704p;
        if (this.f19697i.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setMon(i);
        alarm = this.f19704p;
        if (this.f19698j.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setTue(i);
        alarm = this.f19704p;
        if (this.f19699k.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setWed(i);
        alarm = this.f19704p;
        if (this.f19700l.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setThu(i);
        alarm = this.f19704p;
        if (this.f19701m.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setFri(i);
        alarm = this.f19704p;
        if (this.f19702n.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setSta(i);
        Alarm alarm2 = this.f19704p;
        if (!this.f19703o.isChecked()) {
            i2 = 0;
        }
        alarm2.setSun(i2);
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        int id = wheelView.getId();
        if (id == e.hour) {
            this.f19695g = i2;
        } else if (id == e.minute) {
            this.f19696h = i2;
        }
    }

    public void mo5112a(Message message) {
        super.mo5112a(message);
        switch (message.what) {
            case 3:
                C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
                if (m26657q()) {
                    m26654n();
                    break;
                }
                break;
        }
        switch (C5807p.f19969a[C5793b.m26878a(message.what).ordinal()]) {
            case 1:
                m26656p();
                m26512c();
                m26658r();
                finish();
                return;
            case 2:
                m26512c();
                C5826i.m26921a(this, h.syn_title, h.syn_time_out, h.syn_sure, h.syn_cancel, this.f19707s, this.f19708t);
                return;
            default:
                return;
        }
    }

    private void m26654n() {
        this.f19693c = true;
        C3620c a = C5774a.m26501a(this.f19705q);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26647b(10);
    }

    private void m26655o() {
        this.f19693c = true;
        C3620c a = C5774a.m26501a(this.f19705q);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26647b(5);
    }

    private void m26647b(int i) {
        C5818a.m26894a().m26895a(C5820c.SYNC_ALARM, i, new C5804m(this));
    }

    private void m26656p() {
        C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
        this.f19693c = true;
    }

    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("com.fenda.hwbracelet.CONNECTION_STATE");
        intentFilter.addAction("com.fenda.hwbracelet.ALARM_SET_FAIL");
        intentFilter.addAction("com.fenda.hwbracelet.ALARM_SET_SUCCESS");
        m26508a(intentFilter);
    }

    protected void onDestroy() {
        m26656p();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (m26657q()) {
            C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19707s, this.f19708t);
        } else {
            super.onBackPressed();
        }
    }

    private boolean m26657q() {
        if (this.f19706r.size() != this.f19705q.size()) {
            return true;
        }
        for (int i = 0; i < this.f19706r.size(); i++) {
            if (!((Alarm) this.f19706r.get(i)).getName().equals(((Alarm) this.f19705q.get(i)).getName())) {
                return true;
            }
            if (!((Alarm) this.f19706r.get(i)).getTime().equals(((Alarm) this.f19705q.get(i)).getTime())) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getSun() != ((Alarm) this.f19705q.get(i)).getSun()) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getMon() != ((Alarm) this.f19705q.get(i)).getMon()) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getTue() != ((Alarm) this.f19705q.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getWed() != ((Alarm) this.f19705q.get(i)).getWed()) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getTue() != ((Alarm) this.f19705q.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getFri() != ((Alarm) this.f19705q.get(i)).getFri()) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getSta() != ((Alarm) this.f19705q.get(i)).getSta()) {
                return true;
            }
            if (((Alarm) this.f19706r.get(i)).getOnOff() != ((Alarm) this.f19705q.get(i)).getOnOff()) {
                return true;
            }
        }
        return false;
    }

    private void m26658r() {
        new C3565a(this).m17901a(this.f19705q);
    }

    private void m26659s() {
        if (this.f19706r == null || this.f19706r.size() <= 0) {
            new C3565a(this).m17902b();
        } else {
            new C3565a(this).m17901a(this.f19706r);
        }
    }

    protected int mo5104a() {
        return f.act_add_alarm;
    }
}
