package com.huawei.pluginaf500.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fenda.hwbracelet.connection.C3596n;
import com.fenda.hwbracelet.mode.C3627j;
import com.fenda.hwbracelet.mode.C3628k;
import com.fenda.p255a.p256a.C3568d;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.p498b.C5774a;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import com.huawei.pluginaf500.utils.C5821d;
import com.huawei.pluginaf500.utils.C5823f;
import com.huawei.pluginaf500.utils.C5826i;
import com.huawei.pluginaf500.utils.CustomDialog;
import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.C5836h;
import com.huawei.pluginaf500.view.wheel.C5838j;
import com.huawei.pluginaf500.view.wheel.WheelView;

public class SportRemindActivity extends AF500BaseActivity implements C5791c {
    private CheckBox f19842A;
    private int f19843B;
    private OnClickListener f19844C = new ci(this);
    private OnClickListener f19845D = new cj(this);
    C3627j f19846a;
    C5836h f19847b;
    C5838j f19848c;
    boolean f19849d = false;
    private String f19850g;
    private String f19851h;
    private String f19852i;
    private String f19853j;
    private String f19854k;
    private String f19855l;
    private String f19856m;
    private int f19857n = 0;
    private CustomDialog f19858o;
    private TextView f19859p;
    private TextView f19860q;
    private TextView f19861r;
    private TextView f19862s;
    private TextView f19863t;
    private CheckBox f19864u;
    private CheckBox f19865v;
    private CheckBox f19866w;
    private CheckBox f19867x;
    private CheckBox f19868y;
    private CheckBox f19869z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.sport_remind);
        this.f19846a = new C3627j();
        m26860j();
        IntentFilter intentFilter = new IntentFilter("com.fenda.hwbracelet.CONNECTION_STATE");
        intentFilter.addAction("com.fenda.hwbracelet.SPORT_REMIND_SET_FAIL");
        intentFilter.addAction("com.fenda.hwbracelet.SPORT_REMIND_SET_SUCCESS");
        m26508a(intentFilter);
    }

    private void m26860j() {
        int i;
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (SettingActivity.f19813a != null) {
            this.f19850g = SettingActivity.f19813a.m18171c();
            this.f19851h = SettingActivity.f19813a.m18174d();
            this.f19855l = SettingActivity.f19813a.m18177e();
            this.f19856m = SettingActivity.f19813a.m18180f();
            this.f19854k = SettingActivity.f19813a.m18168b() + "";
            this.f19843B = SettingActivity.f19813a.m18165a() == 1 ? 1 : 0;
            i = SettingActivity.f19813a.m18189i();
        } else {
            i = 0;
        }
        this.f19859p = (TextView) findViewById(e.am_start_time);
        if (this.f19850g == null || "".equals(this.f19850g) || this.f19850g.length() != 5) {
            this.f19850g = "08:00";
        } else if (Integer.parseInt(this.f19850g.substring(0, 2)) > 12) {
            this.f19850g = "08:00";
        }
        this.f19859p.setText(this.f19850g);
        this.f19860q = (TextView) findViewById(e.am_end_time);
        if (this.f19851h == null || "".equals(this.f19851h) || this.f19851h.length() != 5) {
            this.f19851h = "11:59";
        } else if (Integer.parseInt(this.f19851h.substring(0, 2)) > 11) {
            this.f19851h = "11:59";
        }
        this.f19860q.setText(this.f19851h);
        this.f19861r = (TextView) findViewById(e.pm_start_time);
        if (this.f19855l == null || "".equals(this.f19855l) || this.f19855l.length() != 5) {
            this.f19855l = "11:59";
        }
        this.f19861r.setText(this.f19855l);
        this.f19862s = (TextView) findViewById(e.pm_end_time);
        if (this.f19856m == null || "".equals(this.f19856m) || this.f19856m.length() != 5) {
            this.f19856m = "18:00";
        } else if (Integer.parseInt(this.f19856m.substring(0, 2)) < 12) {
            this.f19856m = "23:59";
        }
        this.f19862s.setText(this.f19856m);
        this.f19863t = (TextView) findViewById(e.sport_time);
        if (this.f19854k.equals("0") || this.f19854k.equals("")) {
            this.f19854k = "30";
        }
        this.f19863t.setText(this.f19854k + getString(h.minuter));
        CheckBox checkBox = (CheckBox) findViewById(e.cb_start_remind);
        if (this.f19843B == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBox.setChecked(z);
        checkBox.setTextSize((float) C5821d.m26898a((Context) this, 15.0f));
        checkBox.setOnCheckedChangeListener(new ca(this));
        this.f19864u = (CheckBox) findViewById(e.cb_week_1);
        this.f19865v = (CheckBox) findViewById(e.cb_week_2);
        this.f19866w = (CheckBox) findViewById(e.cb_week_3);
        this.f19867x = (CheckBox) findViewById(e.cb_week_4);
        this.f19868y = (CheckBox) findViewById(e.cb_week_5);
        this.f19869z = (CheckBox) findViewById(e.cb_week_6);
        this.f19842A = (CheckBox) findViewById(e.cb_week_7);
        this.f19842A.setChecked((i & 64) != 0);
        CheckBox checkBox2 = this.f19864u;
        if ((i & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkBox2.setChecked(z2);
        checkBox2 = this.f19865v;
        if ((i & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkBox2.setChecked(z2);
        checkBox2 = this.f19866w;
        if ((i & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkBox2.setChecked(z2);
        checkBox2 = this.f19867x;
        if ((i & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkBox2.setChecked(z2);
        checkBox2 = this.f19868y;
        if ((i & 16) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkBox2.setChecked(z2);
        checkBox = this.f19869z;
        if ((i & 32) == 0) {
            z3 = false;
        }
        checkBox.setChecked(z3);
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        int id = view.getId();
        if (id != e.btn_start_remind) {
            if (id == e.btn_remind_time) {
                m26862k();
            } else if (id == e.btn_am_start_time) {
                this.f19852i = this.f19850g;
                this.f19853j = this.f19851h;
                this.f19857n = 1;
                m26863l();
            } else if (id == e.btn_am_end_time) {
                this.f19852i = this.f19850g;
                this.f19853j = this.f19851h;
                this.f19857n = 2;
                m26863l();
            } else if (id == e.btn_pm_start_time) {
                this.f19852i = this.f19850g;
                this.f19853j = this.f19851h;
                this.f19857n = 3;
                m26863l();
            } else if (id == e.btn_pm_end_time) {
                this.f19852i = this.f19850g;
                this.f19853j = this.f19851h;
                this.f19857n = 4;
                m26863l();
            }
        }
    }

    private void m26841a(View view) {
        WheelView wheelView = (WheelView) view.findViewById(e.af500_number_picker);
        ((LinearLayout) view.findViewById(e.af500_number_picker_unit_layout)).setVisibility(8);
        wheelView.m26967a(new cc(this));
        this.f19847b = new C5836h(wheelView);
        if (SettingActivity.f19813a != null) {
            this.f19854k = SettingActivity.f19813a.m18168b() + "";
        }
        if (this.f19854k.equals("0") || this.f19854k.equals("")) {
            this.f19854k = "30";
        }
        this.f19847b.m26985a(this.f19854k);
    }

    private void m26862k() {
        C5823f c5823f = new C5823f(this);
        c5823f.m26915a(h.chose_span_time);
        View inflate = LayoutInflater.from(this).inflate(f.dialog_wheel_view, null);
        m26841a(inflate);
        c5823f.m26917a(inflate);
        c5823f.m26920b(h.sure, new cd(this));
        c5823f.m26916a(h.cancel, new ce(this));
        c5823f.m26914a().show();
    }

    private void m26845b(View view) {
        int parseInt;
        int i;
        int i2;
        int i3 = 0;
        WheelView wheelView = (WheelView) view.findViewById(e.af500_number_picker);
        wheelView.m26967a((C5791c) this);
        WheelView wheelView2 = (WheelView) view.findViewById(e.af500_number_picker_unit);
        wheelView2.m26967a((C5791c) this);
        int parseInt2;
        int parseInt3;
        if (this.f19857n == 1) {
            parseInt2 = Integer.parseInt(this.f19850g.split(":")[0]);
            parseInt3 = Integer.parseInt(this.f19850g.split(":")[1]);
            parseInt = Integer.parseInt(this.f19851h.split(":")[0]);
            i3 = Integer.parseInt(this.f19851h.split(":")[1]);
            i = parseInt3;
            i2 = parseInt2;
        } else if (this.f19857n == 2) {
            parseInt2 = Integer.parseInt(this.f19851h.split(":")[0]);
            parseInt3 = Integer.parseInt(this.f19851h.split(":")[1]);
            parseInt = Integer.parseInt(this.f19850g.split(":")[0]);
            i3 = Integer.parseInt(this.f19850g.split(":")[1]);
            i = parseInt3;
            i2 = parseInt2;
        } else if (this.f19857n == 3) {
            parseInt2 = Integer.parseInt(this.f19855l.split(":")[0]);
            parseInt3 = Integer.parseInt(this.f19855l.split(":")[1]);
            parseInt = Integer.parseInt(this.f19856m.split(":")[0]);
            i3 = Integer.parseInt(this.f19856m.split(":")[1]);
            i = parseInt3;
            i2 = parseInt2;
        } else if (this.f19857n == 4) {
            parseInt2 = Integer.parseInt(this.f19856m.split(":")[0]);
            parseInt3 = Integer.parseInt(this.f19856m.split(":")[1]);
            parseInt = Integer.parseInt(this.f19855l.split(":")[0]);
            i3 = Integer.parseInt(this.f19855l.split(":")[1]);
            i = parseInt3;
            i2 = parseInt2;
        } else {
            parseInt = 0;
            i = 0;
            i2 = 0;
        }
        this.f19848c = new C5838j(this, wheelView, wheelView2, this.f19857n, parseInt, i3);
        this.f19848c.m26997a(i2, i);
    }

    private void m26863l() {
        C5823f c5823f = new C5823f(this);
        View inflate = LayoutInflater.from(this).inflate(f.dialog_wheel_view, null);
        m26845b(inflate);
        c5823f.m26915a(h.chose_time);
        c5823f.m26917a(inflate);
        c5823f.m26920b(h.sure, new cf(this));
        c5823f.m26916a(h.cancel, new cg(this));
        this.f19858o = c5823f.m26914a();
        this.f19858o.show();
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        if (wheelView.getId() == e.spanTime) {
            this.f19854k = ((i2 + 1) * 15) + "";
        }
    }

    public void mo5112a(Message message) {
        super.mo5112a(message);
        switch (message.what) {
            case 3:
                C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
                if (m26872s()) {
                    m26865m();
                    break;
                }
                break;
        }
        switch (cb.f19949a[C5793b.m26878a(message.what).ordinal()]) {
            case 1:
                m26512c();
                C5826i.m26921a(this, h.syn_title, h.syn_time_out, h.syn_sure, h.syn_cancel, this.f19844C, this.f19845D);
                return;
            case 2:
                m26869p();
                m26870q();
                m26512c();
                finish();
                return;
            default:
                return;
        }
    }

    private void m26865m() {
        if (!this.f19849d) {
            this.f19849d = true;
            if (3 == C3596n.m18054a()) {
                C3628k b = C5774a.m26503b(m26868o());
                if (m26514e() != null) {
                    m26514e().m26559a(b.m18197a());
                }
            }
            m26844b(10);
        }
    }

    private void m26867n() {
        if (!this.f19849d) {
            this.f19849d = true;
            if (3 == C3596n.m18054a()) {
                C3628k b = C5774a.m26503b(m26868o());
                if (m26514e() != null) {
                    m26514e().m26559a(b.m18197a());
                }
            }
            m26844b(5);
        }
    }

    private C3627j m26868o() {
        C3627j c3627j = new C3627j();
        c3627j.m18166a(this.f19843B);
        c3627j.m18169b(Integer.parseInt(this.f19854k));
        c3627j.m18173c(this.f19855l);
        c3627j.m18176d(this.f19856m);
        c3627j.m18167a(this.f19850g);
        c3627j.m18170b(this.f19851h);
        c3627j.m18172c(m26871r());
        return c3627j;
    }

    private void m26844b(int i) {
        C5818a.m26894a().m26895a(C5820c.SYNC_SPORT_REMIND, i, new ch(this));
    }

    private void m26869p() {
        C5818a.m26894a().m26897b(C5820c.SYNC_SPORT_REMIND);
        this.f19849d = true;
    }

    public void onBackPressed() {
        if (m26872s()) {
            C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19844C, this.f19845D);
        } else {
            super.onBackPressed();
        }
    }

    protected void onDestroy() {
        m26869p();
        super.onDestroy();
        d.n(getApplicationContext());
    }

    private void m26870q() {
        if (SettingActivity.f19813a != null) {
            SettingActivity.f19813a.m18166a(this.f19843B);
            SettingActivity.f19813a.m18169b(Integer.parseInt(this.f19854k));
            SettingActivity.f19813a.m18167a(this.f19850g);
            SettingActivity.f19813a.m18170b(this.f19851h);
            SettingActivity.f19813a.m18173c(this.f19855l);
            SettingActivity.f19813a.m18176d(this.f19856m);
            SettingActivity.f19813a.m18172c(m26871r());
            new C3568d(this).m17916a(SettingActivity.f19813a);
        }
    }

    private int m26871r() {
        int i = 0;
        if (this.f19842A.isChecked()) {
            i = 64;
        }
        if (this.f19864u.isChecked()) {
            i |= 1;
        }
        if (this.f19865v.isChecked()) {
            i |= 2;
        }
        if (this.f19866w.isChecked()) {
            i |= 4;
        }
        if (this.f19867x.isChecked()) {
            i |= 8;
        }
        if (this.f19868y.isChecked()) {
            i |= 16;
        }
        if (this.f19869z.isChecked()) {
            return i | 32;
        }
        return i;
    }

    private boolean m26872s() {
        C3627j a = new C3568d(this).m17915a();
        if (a != null && a.m18189i() == m26871r() && this.f19850g.equals(a.m18171c()) && this.f19851h.equals(a.m18174d()) && this.f19855l.equals(a.m18177e()) && this.f19856m.equals(a.m18180f()) && a.m18168b() == Integer.parseInt(this.f19854k) && this.f19843B == a.m18165a()) {
            return false;
        }
        return true;
    }

    protected int mo5104a() {
        return f.act_sport_remind;
    }
}
