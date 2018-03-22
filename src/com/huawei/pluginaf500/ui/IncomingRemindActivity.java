package com.huawei.pluginaf500.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.fenda.p255a.p256a.C3568d;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.utils.C5823f;
import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.C5834f;
import com.huawei.pluginaf500.view.wheel.WheelView;

public class IncomingRemindActivity extends AF500BaseActivity implements C5791c {
    C5834f f19760a;
    private String f19761b;
    private String f19762c;
    private String f19763d;
    private String f19764g;
    private int f19765h = 0;
    private TextView f19766i;
    private TextView f19767j;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.incoming_remind);
        m26736j();
    }

    private void m26736j() {
        boolean z = true;
        if (SettingActivity.f19813a != null) {
            this.f19766i = (TextView) findViewById(e.start_time);
            this.f19761b = SettingActivity.f19813a.m18191k();
            if (this.f19761b == null || "".equals(this.f19761b) || this.f19761b.length() != 5) {
                this.f19761b = "08:00";
            }
            this.f19766i.setText(this.f19761b);
            this.f19767j = (TextView) findViewById(e.end_time);
            this.f19762c = SettingActivity.f19813a.m18192l();
            if (this.f19762c == null || "".equals(this.f19762c) || this.f19762c.length() != 5) {
                this.f19762c = "22:00";
            }
            this.f19767j.setText(this.f19762c);
            CheckBox checkBox = (CheckBox) findViewById(e.cb_start_remind);
            if (SettingActivity.f19813a.m18190j() != 1) {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setOnCheckedChangeListener(new ao(this));
        }
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        int id = view.getId();
        if (id != e.btn_start_remind) {
            if (id == e.btn_start_time) {
                this.f19763d = this.f19761b;
                this.f19764g = this.f19762c;
                this.f19765h = 1;
                if (SettingActivity.f19813a != null) {
                    m26737k();
                }
            } else if (id == e.btn_end_time) {
                this.f19763d = this.f19761b;
                this.f19764g = this.f19762c;
                this.f19765h = 2;
                if (SettingActivity.f19813a != null) {
                    m26737k();
                }
            }
        }
    }

    private void m26726a(View view) {
        WheelView wheelView = (WheelView) view.findViewById(e.af500_number_picker);
        wheelView.m26967a(new ap(this));
        WheelView wheelView2 = (WheelView) view.findViewById(e.af500_number_picker_unit);
        wheelView2.m26967a(new aq(this));
        this.f19760a = new C5834f(this, wheelView, wheelView2, 0);
        if (this.f19765h == 1) {
            this.f19760a.m26982a(Integer.parseInt(this.f19761b.split(":")[0]), Integer.parseInt(this.f19761b.split(":")[1]));
            return;
        }
        this.f19760a.m26982a(Integer.parseInt(this.f19762c.split(":")[0]), Integer.parseInt(this.f19762c.split(":")[1]));
    }

    private void m26737k() {
        C5823f c5823f = new C5823f(this);
        c5823f.m26915a(h.chose_time);
        View inflate = LayoutInflater.from(this).inflate(f.dialog_wheel_view, null);
        m26726a(inflate);
        c5823f.m26917a(inflate);
        c5823f.m26916a(h.cancel, new ar(this));
        c5823f.m26920b(h.sure, new as(this));
        c5823f.m26914a().show();
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        int id = wheelView.getId();
        if (id == e.hour) {
            if (this.f19765h == 1) {
                this.f19763d = m26725a(this.f19763d, i2);
            } else if (this.f19765h == 2) {
                this.f19764g = m26725a(this.f19764g, i2);
            }
        } else if (id == e.minute) {
            String valueOf = String.valueOf(i2);
            if (i2 < 10) {
                valueOf = "0" + valueOf;
            }
            if (this.f19765h == 1) {
                this.f19763d = this.f19763d.substring(0, 3) + valueOf;
            } else {
                this.f19764g = this.f19764g.substring(0, 3) + valueOf;
            }
        }
    }

    private String m26725a(String str, int i) {
        String valueOf = String.valueOf(i);
        if (i < 10) {
            valueOf = "0" + valueOf;
        }
        return valueOf + str.substring(2, str.length());
    }

    public void onBackPressed() {
        if (SettingActivity.f19813a != null) {
            SettingActivity.f19813a.m18185g(this.f19761b);
            SettingActivity.f19813a.m18188h(this.f19762c);
            new C3568d(this).m17916a(SettingActivity.f19813a);
        }
        super.onBackPressed();
    }

    protected int mo5104a() {
        return f.act_incoming_remind;
    }

    protected void onDestroy() {
        d.n(this);
        super.onDestroy();
    }
}
