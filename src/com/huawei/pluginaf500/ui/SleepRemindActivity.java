package com.huawei.pluginaf500.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fenda.hwbracelet.mode.C3621d;
import com.fenda.hwbracelet.mode.C3627j;
import com.fenda.p255a.p256a.C3568d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.p498b.C5774a;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import com.huawei.pluginaf500.utils.C5823f;
import com.huawei.pluginaf500.utils.C5826i;
import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.C5834f;
import com.huawei.pluginaf500.view.wheel.WheelView;

public class SleepRemindActivity extends AF500BaseActivity implements C5791c {
    C3627j f19830a;
    C5834f f19831b;
    boolean f19832c = false;
    private String f19833d;
    private String f19834g;
    private String f19835h;
    private String f19836i;
    private int f19837j = 0;
    private TextView f19838k;
    private TextView f19839l;
    private OnClickListener f19840m = new bw(this);
    private OnClickListener f19841n = new bx(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.sleep_remind);
        this.f19830a = new C3627j();
        m26827j();
        IntentFilter intentFilter = new IntentFilter("com.fenda.hwbracelet.CONNECTION_STATE");
        intentFilter.addAction("com.fenda.hwbracelet.SLEEP_REMIND_SET_SUCCESS");
        intentFilter.addAction("com.fenda.hwbracelet.SLEEP_REMIND_SET_FAIL");
        m26508a(intentFilter);
    }

    private void m26827j() {
        this.f19838k = (TextView) findViewById(e.start_time);
        if (SettingActivity.f19813a != null) {
            this.f19833d = SettingActivity.f19813a.m18183g();
            this.f19834g = SettingActivity.f19813a.m18186h();
        }
        if (this.f19833d == null || "".equals(this.f19833d) || this.f19833d.length() != 5) {
            this.f19833d = "22:30";
        }
        this.f19838k.setText(this.f19833d);
        this.f19839l = (TextView) findViewById(e.end_time);
        if (this.f19834g == null || "".equals(this.f19834g) || this.f19834g.length() != 5) {
            this.f19834g = "07:00";
        }
        this.f19839l.setText(this.f19834g);
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        int id = view.getId();
        if (id != e.btn_start_remind) {
            if (id == e.btn_start_time) {
                this.f19835h = this.f19833d;
                this.f19836i = this.f19834g;
                this.f19837j = 1;
                m26829k();
            } else if (id == e.btn_end_time) {
                this.f19835h = this.f19833d;
                this.f19836i = this.f19834g;
                this.f19837j = 2;
                m26829k();
            }
        }
    }

    private void m26813a(View view) {
        WheelView wheelView = (WheelView) view.findViewById(e.af500_number_picker);
        wheelView.m26967a(new bs(this));
        WheelView wheelView2 = (WheelView) view.findViewById(e.af500_number_picker_unit);
        wheelView2.m26967a(new bt(this));
        this.f19831b = new C5834f(this, wheelView, wheelView2, 0);
        if (this.f19837j == 1) {
            this.f19831b.m26982a(Integer.parseInt(this.f19833d.split(":")[0]), Integer.parseInt(this.f19833d.split(":")[1]));
            return;
        }
        this.f19831b.m26982a(Integer.parseInt(this.f19834g.split(":")[0]), Integer.parseInt(this.f19834g.split(":")[1]));
    }

    private void m26829k() {
        C5823f c5823f = new C5823f(this);
        c5823f.m26915a(h.chose_time);
        View inflate = LayoutInflater.from(this).inflate(f.dialog_wheel_view, null);
        m26813a(inflate);
        c5823f.m26917a(inflate);
        c5823f.m26920b(h.sure, new bu(this));
        c5823f.m26916a(h.cancel, new bv(this));
        c5823f.m26914a().show();
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        int id = wheelView.getId();
        if (id == e.hour) {
            if (this.f19837j == 1) {
                this.f19835h = m26812a(this.f19835h, i2);
            } else if (this.f19837j == 2) {
                this.f19836i = m26812a(this.f19836i, i2);
            }
        } else if (id == e.minute) {
            String valueOf = String.valueOf(i2);
            if (i2 < 10) {
                valueOf = "0" + valueOf;
            }
            if (this.f19837j == 1) {
                this.f19835h = this.f19835h.substring(0, 3) + valueOf;
            } else {
                this.f19836i = this.f19836i.substring(0, 3) + valueOf;
            }
        }
    }

    private String m26812a(String str, int i) {
        String valueOf = String.valueOf(i);
        if (i < 10) {
            valueOf = "0" + valueOf;
        }
        return valueOf + str.substring(2, str.length());
    }

    public void mo5112a(Message message) {
        super.mo5112a(message);
        switch (message.what) {
            case 3:
                C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
                if (m26834p()) {
                    m26830l();
                    break;
                }
                break;
        }
        switch (bz.f19946a[C5793b.m26878a(message.what).ordinal()]) {
            case 1:
                m26832n();
                m26512c();
                m26833o();
                super.onBackPressed();
                return;
            case 2:
                m26512c();
                C5826i.m26921a(this, h.syn_title, h.syn_time_out, h.syn_sure, h.syn_cancel, this.f19840m, this.f19841n);
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        if (m26834p()) {
            C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19840m, this.f19841n);
        } else {
            super.onBackPressed();
        }
    }

    protected void onDestroy() {
        m26832n();
        super.onDestroy();
    }

    private void m26830l() {
        this.f19832c = true;
        this.f19830a.m18182f(this.f19834g);
        this.f19830a.m18179e(this.f19833d);
        C3621d a = C5774a.m26502a(this.f19830a);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18152a());
        }
        m26817b(10);
    }

    private void m26831m() {
        this.f19832c = true;
        this.f19830a.m18182f(this.f19834g);
        this.f19830a.m18179e(this.f19833d);
        C3621d a = C5774a.m26502a(this.f19830a);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18152a());
        }
        m26817b(5);
    }

    private void m26817b(int i) {
        C5818a.m26894a().m26895a(C5820c.SYNC_SLEEP_REMIND, i, new by(this));
    }

    private void m26832n() {
        C5818a.m26894a().m26897b(C5820c.SYNC_SLEEP_REMIND);
        this.f19832c = true;
    }

    private void m26833o() {
        if (SettingActivity.f19813a != null) {
            SettingActivity.f19813a.m18179e(this.f19833d);
            SettingActivity.f19813a.m18182f(this.f19834g);
            new C3568d(this).m17916a(SettingActivity.f19813a);
        }
    }

    private boolean m26834p() {
        C3627j a = new C3568d(this).m17915a();
        if (a != null && this.f19833d.equals(a.m18183g()) && this.f19834g.equals(a.m18186h())) {
            return false;
        }
        return true;
    }

    protected int mo5104a() {
        return f.act_sleep_remind;
    }
}
