package com.huawei.pluginaf500.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.fenda.hwbracelet.mode.Alarm;
import com.fenda.hwbracelet.mode.C3620c;
import com.fenda.p255a.p256a.C3565a;
import com.huawei.hwcommonmodel.d.d;
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
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class AlarmAddActivity extends AF500BaseActivity implements C5791c {
    C5834f f19675a;
    boolean f19676b = false;
    private String f19677c = "AlarmAddActivity";
    private int f19678d;
    private int f19679g;
    private CheckBox f19680h;
    private CheckBox f19681i;
    private CheckBox f19682j;
    private CheckBox f19683k;
    private CheckBox f19684l;
    private CheckBox f19685m;
    private CheckBox f19686n;
    private List<Alarm> f19687o;
    private List<Alarm> f19688p;
    private OnClickListener f19689q = new C5801j(this);
    private OnClickListener f19690r = new C5802k(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.alarm_add);
        m26632j();
        m26634l();
    }

    private void m26632j() {
        List k = m26633k();
        if (k == null || k.size() <= 0) {
            this.f19687o = new ArrayList();
        } else {
            this.f19687o = k;
        }
    }

    private List<Alarm> m26633k() {
        Collection a = new C3565a(this).m17898a();
        if (a != null) {
            this.f19688p = new ArrayList(a);
        } else {
            this.f19688p = new ArrayList();
        }
        return new C3565a(this).m17898a();
    }

    private void m26634l() {
        ((Button) findViewById(e.btn_delete)).setVisibility(8);
        this.f19680h = (CheckBox) findViewById(e.cb_week_1);
        this.f19681i = (CheckBox) findViewById(e.cb_week_2);
        this.f19682j = (CheckBox) findViewById(e.cb_week_3);
        this.f19683k = (CheckBox) findViewById(e.cb_week_4);
        this.f19684l = (CheckBox) findViewById(e.cb_week_5);
        this.f19685m = (CheckBox) findViewById(e.cb_week_6);
        this.f19686n = (CheckBox) findViewById(e.cb_week_7);
        WheelView wheelView = (WheelView) findViewById(e.hour);
        wheelView.m26967a((C5791c) this);
        WheelView wheelView2 = (WheelView) findViewById(e.minute);
        wheelView2.m26967a((C5791c) this);
        this.f19675a = new C5834f(this, wheelView, wheelView2, 0);
        Calendar instance = Calendar.getInstance();
        this.f19678d = instance.get(11);
        this.f19679g = instance.get(12);
        this.f19675a.m26982a(this.f19678d, this.f19679g);
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        int id = view.getId();
        if (id != e.btn_delete) {
            if (id == e.btn_ok) {
                m26635m();
                if (m26639q()) {
                    C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19689q, this.f19690r);
                } else {
                    finish();
                }
            } else if (id == e.btn_cancel) {
                finish();
            }
        }
    }

    private void m26635m() {
        String str;
        int i;
        int i2 = 1;
        Alarm alarm = new Alarm();
        alarm.setOnOff(1);
        EditText editText = (EditText) findViewById(e.alarm_name);
        alarm.setName(editText.getText() == null ? "手环闹钟" : editText.getText().toString());
        if (this.f19678d < 10) {
            str = "0" + this.f19678d;
        } else {
            str = this.f19678d + "";
        }
        if (this.f19679g < 10) {
            str = str + ":0" + this.f19679g;
        } else {
            str = str + ":" + this.f19679g;
        }
        alarm.setTime(str);
        if (this.f19680h.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setMon(i);
        if (this.f19681i.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setTue(i);
        if (this.f19682j.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setWed(i);
        if (this.f19683k.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setThu(i);
        if (this.f19684l.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setFri(i);
        if (this.f19685m.isChecked()) {
            i = 1;
        } else {
            i = 0;
        }
        alarm.setSta(i);
        if (!this.f19686n.isChecked()) {
            i2 = 0;
        }
        alarm.setSun(i2);
        this.f19687o.add(alarm);
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        if (wheelView.getId() == e.hour) {
            this.f19678d = i2;
        } else {
            this.f19679g = i2;
        }
    }

    public void mo5112a(Message message) {
        super.mo5112a(message);
        switch (message.what) {
            case 3:
                C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
                if (m26639q()) {
                    m26636n();
                    break;
                }
                break;
        }
        switch (C5803l.f19965a[C5793b.m26878a(message.what).ordinal()]) {
            case 1:
                m26638p();
                m26512c();
                m26640r();
                finish();
                return;
            case 2:
                m26512c();
                C5826i.m26921a(this, h.syn_title, h.syn_time_out, h.syn_sure, h.syn_cancel, this.f19689q, this.f19690r);
                return;
            default:
                return;
        }
    }

    private void m26636n() {
        this.f19676b = true;
        C3620c a = C5774a.m26501a(this.f19687o);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26629b(10);
    }

    private void m26637o() {
        this.f19676b = true;
        C3620c a = C5774a.m26501a(this.f19687o);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26629b(5);
    }

    private void m26629b(int i) {
        C5818a.m26894a().m26895a(C5820c.SYNC_ALARM, i, new C5800i(this));
    }

    private void m26638p() {
        C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
        this.f19676b = true;
    }

    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("com.fenda.hwbracelet.CONNECTION_STATE");
        intentFilter.addAction("com.fenda.hwbracelet.ALARM_SET_FAIL");
        intentFilter.addAction("com.fenda.hwbracelet.ALARM_SET_SUCCESS");
        m26508a(intentFilter);
    }

    protected void onDestroy() {
        m26638p();
        super.onDestroy();
        d.n(this);
    }

    public void onBackPressed() {
        if (m26639q()) {
            C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19689q, this.f19690r);
        } else {
            super.onBackPressed();
        }
    }

    private boolean m26639q() {
        if (this.f19688p.size() != this.f19687o.size()) {
            return true;
        }
        for (int i = 0; i < this.f19688p.size(); i++) {
            if (!((Alarm) this.f19688p.get(i)).getName().equals(((Alarm) this.f19687o.get(i)).getName())) {
                return true;
            }
            if (!((Alarm) this.f19688p.get(i)).getTime().equals(((Alarm) this.f19687o.get(i)).getTime())) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getSun() != ((Alarm) this.f19687o.get(i)).getSun()) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getMon() != ((Alarm) this.f19687o.get(i)).getMon()) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getTue() != ((Alarm) this.f19687o.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getWed() != ((Alarm) this.f19687o.get(i)).getWed()) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getTue() != ((Alarm) this.f19687o.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getFri() != ((Alarm) this.f19687o.get(i)).getFri()) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getSta() != ((Alarm) this.f19687o.get(i)).getSta()) {
                return true;
            }
            if (((Alarm) this.f19688p.get(i)).getOnOff() != ((Alarm) this.f19687o.get(i)).getOnOff()) {
                return true;
            }
        }
        return false;
    }

    private void m26640r() {
        new C3565a(this).m17901a(this.f19687o);
    }

    private void m26641s() {
        if (this.f19688p == null || this.f19688p.size() <= 0) {
            new C3565a(this).m17902b();
        } else {
            new C3565a(this).m17901a(this.f19688p);
        }
    }

    protected int mo5104a() {
        return f.act_add_alarm;
    }
}
