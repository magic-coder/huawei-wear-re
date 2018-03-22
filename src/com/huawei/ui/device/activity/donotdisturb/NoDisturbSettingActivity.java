package com.huawei.ui.device.activity.donotdisturb;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.hwcommonmodel.d.m;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.ab;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.commonui.wheelview21.WheelView;
import com.huawei.ui.commonui.wheelview21.c;
import com.huawei.ui.device.b;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.p171b.C2183a;
import java.util.List;

public class NoDisturbSettingActivity extends BaseActivity implements OnClickListener {
    private Dialog f7160A = null;
    private int f7161B = 0;
    private int f7162C = 0;
    private String f7163D = "";
    private String f7164E = "";
    private Handler f7165F = new C2056f(this, this);
    private Context f7166a;
    private C1990r f7167b;
    private C1988p f7168c;
    private DataDeviceAvoidDisturbInfo f7169d;
    private DeviceCapability f7170e = null;
    private boolean f7171f = false;
    private Switch f7172g;
    private Switch f7173h;
    private RelativeLayout f7174i;
    private RelativeLayout f7175j;
    private RelativeLayout f7176k;
    private LinearLayout f7177l;
    private CustomTitleBar f7178m;
    private TextView f7179n;
    private TextView f7180o;
    private TextView f7181p;
    private TextView f7182q;
    private TextView f7183r;
    private TextView f7184s;
    private ImageView f7185t;
    private ImageView f7186u;
    private c f7187v = null;
    private c f7188w = null;
    private RelativeLayout f7189x;
    private TextView f7190y;
    private Switch f7191z;

    protected void onDestroy() {
        C2538c.m12677c("NoDisturbSettingActivity", "onDestroy()");
        C0977d.m3575n(this.f7166a);
        super.onDestroy();
        setResult(0, null);
    }

    private void m10678a(Object obj) {
        C2538c.m12677c("NoDisturbSettingActivity", "handleWhenGetNoDisturbSuccess()!");
        List list = (List) obj;
        if (list == null || list.size() == 0) {
            C2538c.m12680e("NoDisturbSettingActivity", "ERROR list!");
            return;
        }
        this.f7169d = (DataDeviceAvoidDisturbInfo) list.get(0);
        C2538c.m12677c("NoDisturbSettingActivity", "mDataDeviceAvoidDisturbInfo=" + this.f7169d);
        m10688f();
        m10693h();
    }

    private void m10673a() {
        C2538c.m12677c("NoDisturbSettingActivity", "handleWhenGetNoDisturbFail()!");
        finish();
    }

    private void m10680b() {
        C2538c.m12677c("NoDisturbSettingActivity", "handleWhenSetNoDisturbSuccess()!");
        finish();
    }

    private void m10682c() {
        C2538c.m12677c("NoDisturbSettingActivity", "handleWhenSetNoDisturbFail()!");
        a.b(this.f7166a, i.IDS_settings_mult_alarm_clock_synchroFailed_dialog);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_device_settings_nodisturb);
        m10685d();
    }

    private void m10685d() {
        C2538c.m12677c("NoDisturbSettingActivity", "initData()");
        this.f7166a = getApplicationContext();
        this.f7167b = C1990r.m10400a(this.f7166a);
        this.f7168c = C1988p.m10381a(this.f7166a);
        if (this.f7167b == null || this.f7168c == null) {
            C2538c.m12679d("NoDisturbSettingActivity", "mDeviceSettingsInteractors == null || mDeviceInteractors ==null");
            return;
        }
        List b = this.f7167b.m10422b(this.f7166a);
        if (b == null || b.size() == 0) {
            C2538c.m12679d("NoDisturbSettingActivity", "initData() if (list == null)");
            return;
        }
        this.f7170e = this.f7167b.m10411a();
        m10686e();
        this.f7169d = (DataDeviceAvoidDisturbInfo) b.get(0);
        C2538c.m12677c("NoDisturbSettingActivity", "initData() mDataDeviceAvoidDisturbInfo=" + this.f7169d);
        this.f7161B = this.f7169d.getDevice_avoid_disturb_start_time();
        this.f7162C = this.f7169d.getDevice_avoid_disturb_end_time();
        m10691g();
        m10688f();
        m10693h();
    }

    private void m10686e() {
        if (this.f7170e.isSupportQueryAllowDisturbContent()) {
            if (20 == (this.f7168c.m10398h() & 20)) {
                this.f7171f = true;
            }
            C2538c.m12677c("NoDisturbSettingActivity", "requestDeviceAllowDisturbItem allowDisturbValue = " + r0 + "  mIsHaveAllowDisturbInfo = " + this.f7171f);
        }
    }

    private void m10688f() {
        C2538c.m12677c("NoDisturbSettingActivity", "initView()");
        this.f7179n = (TextView) d.a(this, e.device_settings_disturb_des);
        this.f7172g = (Switch) d.a(this, e.device_settings_nodisturb_start_switch_button);
        this.f7173h = (Switch) d.a(this, e.device_settings_nodisturb_scheduled_switch_button);
        this.f7174i = (RelativeLayout) d.a(this, e.device_settings_nodisturb_start_layout);
        this.f7175j = (RelativeLayout) d.a(this, e.device_settings_nodisturb_scheduled_layout);
        this.f7176k = (RelativeLayout) d.a(this, e.device_settings_nodisturb_start_time_layout);
        this.f7177l = (LinearLayout) d.a(this, e.device_settings_nodisturb_end_time_layout);
        this.f7178m = (CustomTitleBar) d.a(this, e.device_settings_nodisturb_title_bar);
        this.f7180o = (TextView) d.a(this, e.device_settings_nodisturb_scheduled_text);
        this.f7181p = (TextView) d.a(this, e.device_settings_nodisturb_start_time_title_tv);
        this.f7182q = (TextView) d.a(this, e.device_settings_nodisturb_end_time_title_tv);
        this.f7183r = (TextView) d.a(this, e.device_settings_nodisturb_start_time_tv);
        this.f7184s = (TextView) d.a(this, e.device_settings_nodisturb_end_time_tv);
        this.f7183r.setText(this.f7163D);
        this.f7184s.setText(this.f7164E);
        this.f7185t = (ImageView) d.a(this, e.device_settings_nodisturb_start_time_iv);
        this.f7186u = (ImageView) d.a(this, e.device_settings_nodisturb_end_time_iv);
        this.f7189x = (RelativeLayout) d.a(this, e.device_settings_disturb_up_layout);
        this.f7190y = (TextView) d.a(this, e.device_settings_can_disturb_tv);
        this.f7191z = (Switch) d.a(this, e.device_settings_disturb_up_switch_button);
        this.f7174i.setOnClickListener(this);
        this.f7175j.setOnClickListener(this);
        this.f7176k.setOnClickListener(this);
        this.f7177l.setOnClickListener(this);
        this.f7189x.setOnClickListener(this);
        if (!this.f7171f) {
            this.f7189x.setVisibility(8);
            this.f7190y.setVisibility(8);
        }
        this.f7178m.setRightButtonOnClickListener(new C2051a(this));
    }

    private void m10691g() {
        String a = m.a(this.f7161B);
        String a2 = m.a(this.f7162C);
        this.f7163D = this.f7167b.m10413a(a);
        if (this.f7161B > this.f7162C) {
            a = this.f7167b.m10413a(a2);
            this.f7164E = this.f7166a.getResources().getString(i.IDS_no_disturb_setting_next_day, new Object[]{a});
            return;
        }
        this.f7164E = this.f7167b.m10413a(a2);
    }

    @TargetApi(3)
    private void m10675a(View view, int i, String[] strArr) {
        WheelView wheelView = (WheelView) d.a(view, e.number_picker);
        WheelView wheelView2 = (WheelView) d.a(view, e.number_picker_unit);
        WheelView wheelView3 = (WheelView) d.a(view, e.ampm_left);
        WheelView wheelView4 = (WheelView) d.a(view, e.ampm_right);
        int parseInt = Integer.parseInt(strArr[0]);
        int parseInt2 = Integer.parseInt(strArr[1]);
        if (DateFormat.is24HourFormat(this.f7166a)) {
            if (i == 0) {
                this.f7187v = C2183a.m11184a(null).m11190a(parseInt, parseInt2, wheelView3, wheelView, wheelView2, null);
            } else if (1 == i) {
                this.f7188w = C2183a.m11184a(null).m11190a(parseInt, parseInt2, wheelView3, wheelView, wheelView2, null);
            }
        } else if (i == 0) {
            this.f7187v = C2183a.m11184a(null).m11189a(parseInt, parseInt2, wheelView3, wheelView4, wheelView, wheelView2, null);
        } else if (1 == i) {
            this.f7188w = C2183a.m11184a(null).m11189a(parseInt, parseInt2, wheelView3, wheelView4, wheelView, wheelView2, null);
        }
    }

    private void m10693h() {
        C2538c.m12677c("NoDisturbSettingActivity", "updataViewByDisturbData mDataDeviceAvoidDisturbInfo=" + this.f7169d);
        if (this.f7169d.getDevice_avoid_disturb_switch() == 1) {
            this.f7172g.setChecked(true);
            this.f7175j.setEnabled(false);
            this.f7173h.setEnabled(false);
            this.f7180o.setTextColor(getResources().getColor(b.common_white_20alpha));
            this.f7176k.setEnabled(false);
            this.f7177l.setEnabled(false);
            this.f7181p.setTextColor(getResources().getColor(b.common_white_20alpha));
            this.f7182q.setTextColor(getResources().getColor(b.common_white_20alpha));
            this.f7183r.setTextColor(getResources().getColor(b.common_white_20alpha));
            this.f7184s.setTextColor(getResources().getColor(b.common_white_20alpha));
            if (this.f7169d.getDevice_avoid_disturb_time_switch() == 1) {
                this.f7173h.setChecked(true);
            } else {
                this.f7173h.setChecked(false);
            }
        } else {
            this.f7172g.setChecked(false);
            this.f7175j.setEnabled(true);
            this.f7173h.setEnabled(true);
            this.f7180o.setTextColor(getResources().getColor(b.common_white_90alpha));
            if (this.f7169d.getDevice_avoid_disturb_time_switch() == 1) {
                this.f7173h.setChecked(true);
                this.f7176k.setEnabled(true);
                this.f7177l.setEnabled(true);
                this.f7181p.setTextColor(getResources().getColor(b.common_white_90alpha));
                this.f7182q.setTextColor(getResources().getColor(b.common_white_90alpha));
                this.f7183r.setTextColor(getResources().getColor(b.common_white_50alpha));
                this.f7184s.setTextColor(getResources().getColor(b.common_white_50alpha));
                if (com.huawei.hwbasemgr.b.a(this)) {
                    this.f7185t.setBackgroundResource(g.ic_return_nomal);
                    this.f7186u.setBackgroundResource(g.ic_return_nomal);
                } else {
                    this.f7185t.setBackgroundResource(g.ic_enter_nomal);
                    this.f7186u.setBackgroundResource(g.ic_enter_nomal);
                }
            } else {
                this.f7173h.setChecked(false);
                this.f7176k.setEnabled(false);
                this.f7177l.setEnabled(false);
                this.f7181p.setTextColor(getResources().getColor(b.common_white_20alpha));
                this.f7182q.setTextColor(getResources().getColor(b.common_white_20alpha));
                this.f7183r.setTextColor(getResources().getColor(b.common_white_20alpha));
                this.f7184s.setTextColor(getResources().getColor(b.common_white_20alpha));
                if (com.huawei.hwbasemgr.b.a(this)) {
                    this.f7185t.setBackgroundResource(g.ic_return_disable);
                    this.f7186u.setBackgroundResource(g.ic_return_disable);
                } else {
                    this.f7185t.setBackgroundResource(g.ic_enter_disable);
                    this.f7186u.setBackgroundResource(g.ic_enter_disable);
                }
            }
        }
        if (this.f7171f) {
            m10694i();
        }
    }

    private void m10694i() {
        if (!m10699k()) {
            this.f7189x.setVisibility(8);
            this.f7179n.setText(getResources().getString(i.IDS_setting_disturb_desc));
            this.f7191z.setChecked(false);
        } else if ((this.f7169d.getDevice_avoid_disturb_type() & 20) == 20) {
            this.f7179n.setText(getResources().getString(i.IDS_setting_disturb_desc_turn_on));
            this.f7191z.setChecked(true);
        } else {
            this.f7179n.setText(getResources().getString(i.IDS_setting_disturb_desc));
            this.f7191z.setChecked(false);
        }
        if (m10701l()) {
            this.f7190y.setVisibility(8);
        }
    }

    public void onClick(View view) {
        this.f7174i.setClickable(false);
        this.f7175j.setClickable(false);
        this.f7189x.setClickable(false);
        int id = view.getId();
        if (id == e.device_settings_nodisturb_scheduled_layout) {
            C2538c.m12677c("NoDisturbSettingActivity", "device_settings_nodisturb_scheduled_layout");
            if (this.f7173h.isChecked()) {
                this.f7169d.setDevice_avoid_disturb_time_switch(0);
            } else {
                this.f7169d.setDevice_avoid_disturb_time_switch(1);
            }
            m10693h();
        } else if (id == e.device_settings_nodisturb_start_layout) {
            C2538c.m12677c("NoDisturbSettingActivity", "device_settings_nodisturb_start_layout");
            if (this.f7172g.isChecked()) {
                this.f7169d.setDevice_avoid_disturb_switch(0);
            } else {
                this.f7169d.setDevice_avoid_disturb_switch(1);
            }
            m10693h();
        } else if (id == e.device_settings_nodisturb_start_time_layout) {
            m10674a(0);
        } else if (id == e.device_settings_nodisturb_end_time_layout) {
            m10674a(1);
        } else if (id == e.device_settings_disturb_up_layout) {
            m10697j();
        } else {
            C2538c.m12677c("NoDisturbSettingActivity", "i =" + id);
        }
        this.f7174i.setClickable(true);
        this.f7175j.setClickable(true);
        this.f7189x.setClickable(true);
    }

    private void m10697j() {
        if (this.f7191z.isChecked()) {
            this.f7169d.setDevice_avoid_disturb_type(0);
        } else {
            this.f7169d.setDevice_avoid_disturb_type(20);
        }
        m10693h();
    }

    private void m10674a(int i) {
        C2538c.m12677c("NoDisturbSettingActivity", "showTimeDialog() enter ");
        if (this.f7160A == null) {
            View inflate = LayoutInflater.from(this.f7166a).inflate(f.activity_device_settings_nodisturb_wheelview, null);
            if (i == 0) {
                m10675a(inflate, 0, m.a(this.f7161B).split(":"));
            } else {
                m10675a(inflate, 1, m.a(this.f7162C).split(":"));
            }
            this.f7160A = new ab(this).a(inflate).a(getResources().getString(i.IDS_settings_button_ok).toUpperCase(), new C2053c(this, i)).b(getResources().getString(i.IDS_settings_button_cancal).toUpperCase(), new C2052b(this)).a();
            this.f7160A.setOnDismissListener(new C2054d(this));
            this.f7160A.show();
            C2538c.m12677c("NoDisturbSettingActivity", "showTimeDialog() leave ");
        }
    }

    private boolean m10699k() {
        C2538c.m12677c("NoDisturbSettingActivity", "getRotateWakeScreem enter.");
        return this.f7167b.m10431b();
    }

    private boolean m10701l() {
        if (this.f7189x.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    private void m10703m() {
        C2538c.m12677c("NoDisturbSettingActivity", "showNoDeviceConnectedToast()");
        a.b(this.f7166a, i.IDS_connect_device_fail);
    }

    private void m10705n() {
        if (this.f7167b == null) {
            C2538c.m12680e("NoDisturbSettingActivity", "SendCommdToDevice cause null pointer!");
            return;
        }
        if (this.f7169d.getDevice_avoid_disturb_time_switch() == 1 && this.f7169d.getDevice_avoid_disturb_switch() == 0) {
            if (this.f7161B == this.f7162C) {
                a.b(this, i.IDS_no_disturb_time_cannot_be_same);
                return;
            } else {
                this.f7169d.setDevice_avoid_disturb_start_time(this.f7161B);
                this.f7169d.setDevice_avoid_disturb_end_time(this.f7162C);
            }
        }
        C2538c.m12677c("NoDisturbSettingActivity", "SendCommdToDevice() mDataDeviceAvoidDisturbInfo=" + this.f7169d);
        this.f7167b.m10414a(this.f7166a, this.f7169d, new C2055e(this));
    }
}
