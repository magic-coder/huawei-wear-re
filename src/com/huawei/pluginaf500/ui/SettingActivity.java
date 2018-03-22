package com.huawei.pluginaf500.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.fenda.hwbracelet.connection.C3596n;
import com.fenda.hwbracelet.mode.Alarm;
import com.fenda.hwbracelet.mode.C3624g;
import com.fenda.hwbracelet.mode.C3625h;
import com.fenda.hwbracelet.mode.C3627j;
import com.fenda.p255a.p256a.C3565a;
import com.fenda.p255a.p256a.C3568d;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwcommonmodel.p064d.C4725b;
import com.huawei.hwcommonmodel.p064d.p406a.C4718b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginaf500.c;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.p497a.C5770a;
import com.huawei.pluginaf500.p497a.C5773d;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import com.huawei.pluginaf500.utils.C5823f;
import com.huawei.pluginaf500.view.C5827a;
import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AF500BaseActivity implements OnClickListener, OnCheckedChangeListener {
    public static final C3627j f19813a = new C3627j();
    IntentFilter f19814b;
    private CheckBox f19815c;
    private CheckBox f19816d;
    private CheckBox f19817g;
    private TextView f19818h;
    private TextView f19819i;
    private TextView f19820j;
    private TextView f19821k;
    private TextView f19822l;
    private TextView f19823m;
    private BluetoothAdapter f19824n;
    private C5770a f19825o;
    private C5827a f19826p = null;
    private Handler f19827q = new bk(this);
    private boolean f19828r = false;
    private boolean f19829s = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        }
        this.f19814b = new IntentFilter("com.fenda.hwbracelet.CONNECTION_STATE");
        this.f19814b.addAction("com.colorband.dispaly_state");
        this.f19814b.addAction("com.colorband.gesture_state");
        m26508a(this.f19814b);
        m26795j();
        this.f19824n = BluetoothAdapter.getDefaultAdapter();
        this.f19825o = new C5770a(this, this.f19827q, C5773d.NORMAL_SCAN);
    }

    @SuppressLint({"NewApi"})
    protected void onResume() {
        super.onResume();
        m26799n();
        if (VERSION.SDK_INT > 17 && getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            this.f19824n = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        }
    }

    private void m26795j() {
        this.f19818h = (TextView) findViewById(e.cb_sport);
        this.f19819i = (TextView) findViewById(e.cb_incoming);
        this.f19820j = (TextView) findViewById(e.sport_remind_tip);
        this.f19821k = (TextView) findViewById(e.sleep_remind_time);
        this.f19822l = (TextView) findViewById(e.incoming_remind_time);
        this.f19823m = (TextView) findViewById(e.alarm_remind_time);
        this.f19817g = (CheckBox) findViewById(e.cb_remote_lost);
        this.f19815c = (CheckBox) findViewById(e.cb_remote_light);
        this.f19816d = (CheckBox) findViewById(e.cb_remote_hand);
        this.f19817g.setOnCheckedChangeListener(this);
        this.f19816d.setOnClickListener(this);
        this.f19815c.setOnClickListener(this);
        m26796k();
        m26797l();
        m26798m();
    }

    private void m26796k() {
    }

    private void m26797l() {
        C3627j a = new C3568d(this).m17915a();
        if (a == null) {
            a = new C3627j();
            a.m18178e(0);
            a.m18188h("22:00");
            a.m18185g("08:00");
            a.m18175d(1);
            a.m18184g(1);
            a.m18181f(13);
            a.m18187h(1);
            a.m18182f("07:00");
            a.m18179e("22:30");
            a.m18166a(0);
            a.m18170b("11:59");
            a.m18167a("08:00");
            a.m18172c(31);
            a.m18176d("18:00");
            a.m18173c("14:00");
            a.m18169b(15);
        }
        f19813a.m18178e(a.m18193m());
        f19813a.m18188h(a.m18192l());
        f19813a.m18185g(a.m18191k());
        f19813a.m18175d(a.m18190j());
        f19813a.m18184g(a.m18195o());
        f19813a.m18181f(a.m18194n());
        f19813a.m18187h(a.m18196p());
        f19813a.m18182f(a.m18186h());
        f19813a.m18179e(a.m18183g());
        f19813a.m18166a(a.m18165a());
        f19813a.m18170b(a.m18174d());
        f19813a.m18167a(a.m18171c());
        f19813a.m18172c(a.m18189i());
        f19813a.m18176d(a.m18180f());
        f19813a.m18173c(a.m18177e());
        f19813a.m18169b(a.m18168b());
    }

    private void m26798m() {
        if (3 == C3596n.m18054a()) {
            findViewById(e.ble_state).setVisibility(0);
            findViewById(e.ble_lost_connect_state).setVisibility(8);
            findViewById(e.ble_connecting_state).setVisibility(8);
        } else {
            findViewById(e.ble_lost_connect_state).setVisibility(0);
            findViewById(e.ble_state).setVisibility(8);
            findViewById(e.ble_connecting_state).setVisibility(8);
        }
        this.f19820j.setText(f19813a.m18171c() + "-" + f19813a.m18174d() + ", " + f19813a.m18177e() + "-" + f19813a.m18180f() + "　" + getString(h.interval) + f19813a.m18168b() + getString(h.minuter));
        this.f19822l.setText(f19813a.m18191k() + "-" + f19813a.m18192l());
        this.f19821k.setText(f19813a.m18183g() + "-" + f19813a.m18186h());
        List a = new C3565a(this).m17898a();
        if (a == null) {
            a = new ArrayList();
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Alarm time : r0) {
            stringBuffer.append(time.getTime());
            stringBuffer.append(", ");
        }
        String stringBuffer2 = stringBuffer.toString();
        if ("".equals(stringBuffer2)) {
            this.f19823m.setText(h.no_alarm);
        } else {
            this.f19823m.setText(stringBuffer2.substring(0, stringBuffer2.length() - 2));
        }
    }

    private void m26799n() {
        boolean z = true;
        if (f19813a != null) {
            boolean z2;
            this.f19818h.setText(f19813a.m18165a() == 1 ? h.switch_on : h.switch_off);
            this.f19819i.setText(f19813a.m18190j() == 1 ? h.switch_on : h.switch_off);
            CheckBox checkBox = this.f19817g;
            if (f19813a.m18193m() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkBox.setChecked(z2);
            checkBox = this.f19815c;
            if (f19813a.m18195o() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkBox.setChecked(z2);
            CheckBox checkBox2 = this.f19816d;
            if (f19813a.m18196p() != 1) {
                z = false;
            }
            checkBox2.setChecked(z);
            m26798m();
        }
    }

    private void m26793b(int i) {
        C5818a.m26894a().m26895a(C5820c.BC_GESTURE_STATE, i, new bl(this));
    }

    private void m26800o() {
        m26805t();
        this.f.obtainMessage(C5793b.UPDATE_SETTING_VIEW.m26879a()).sendToTarget();
        C5818a.m26894a().m26897b(C5820c.BC_GESTURE_STATE);
    }

    private void m26794c(int i) {
        C5818a.m26894a().m26895a(C5820c.BC_DISPLAY_STATE, i, new bm(this));
    }

    private void m26801p() {
        m26805t();
        this.f.obtainMessage(C5793b.UPDATE_SETTING_VIEW.m26879a()).sendToTarget();
        C5818a.m26894a().m26897b(C5820c.BC_DISPLAY_STATE);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        d.n(this);
    }

    public void mo5112a(Message message) {
        boolean z = true;
        super.mo5112a(message);
        m26512c();
        switch (message.what) {
            case 0:
                findViewById(e.ble_lost_connect_state).setVisibility(0);
                findViewById(e.ble_state).setVisibility(8);
                findViewById(e.ble_connecting_state).setVisibility(8);
                break;
            case 2:
                findViewById(e.ble_connecting_state).setVisibility(0);
                findViewById(e.ble_state).setVisibility(8);
                findViewById(e.ble_lost_connect_state).setVisibility(8);
                break;
            case 3:
                findViewById(e.ble_state).setVisibility(0);
                findViewById(e.ble_lost_connect_state).setVisibility(8);
                findViewById(e.ble_connecting_state).setVisibility(8);
                break;
        }
        if (message.what == C5793b.BC_DISPLAY_STAE.m26879a()) {
            m26801p();
            if (this.f19815c.isChecked()) {
                f19813a.m18184g(1);
            } else {
                f19813a.m18184g(0);
            }
        } else if (message.what == C5793b.BC_GESTURE_STATE.m26879a()) {
            m26800o();
            if (this.f19816d.isChecked()) {
                f19813a.m18187h(1);
            } else {
                f19813a.m18187h(0);
            }
        } else if (message.what == C5793b.UPDATE_SETTING_VIEW.m26879a()) {
            boolean z2;
            CheckBox checkBox = this.f19815c;
            if (f19813a.m18195o() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkBox.setChecked(z2);
            CheckBox checkBox2 = this.f19816d;
            if (f19813a.m18196p() != 1) {
                z = false;
            }
            checkBox2.setChecked(z);
        } else if (message.what == C5793b.DISPLAY_GESTURE_SYN_FAIL.m26879a()) {
            Toast.makeText(this, getString(h.syn_out_time), 0).show();
        } else if (message.what == C5793b.BIND_SERVICE_SUCCESS.m26879a()) {
            m26798m();
        } else if (message.what == 101) {
            if (m26514e() != null) {
                m26514e().m26552a();
            }
            finish();
        } else if (message.what == 102) {
            m26803r();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2 && i2 == -1) {
            finish();
        }
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        int id = view.getId();
        if (id == e.ble_state) {
            if (m26514e() != null && 3 == C3596n.m18054a()) {
                m26514e().m26552a();
            }
        } else if (id == e.ble_lost_connect_state) {
            if (!this.f19824n.isEnabled()) {
                Toast.makeText(this, h.open_bt_first, 0).show();
            } else if (m26514e() != null && 3 != C3596n.m18054a()) {
                if (VERSION.SDK_INT < 19) {
                    this.f19825o.m26499a(2000);
                } else {
                    m26514e().m26562c();
                }
            }
        } else if (id == e.ble_connecting_state) {
            if (m26514e() != null && 2 == C3596n.m18054a()) {
                m26514e().m26552a();
            }
        } else if (id == e.sport_remind) {
            startActivity(new Intent(this, SportRemindActivity.class));
        } else if (id == e.sleep_remind) {
            startActivity(new Intent(this, SleepRemindActivity.class));
        } else if (id == e.alarm) {
            startActivity(new Intent(this, AlarmRemindActivity.class));
        } else if (id == e.incoming_remind) {
            startActivity(new Intent(this, IncomingRemindActivity.class));
        } else if (id == e.anti_lost_remind) {
        } else {
            if (id == e.find_phone) {
                startActivity(new Intent(this, FindPhoneGuideActivity.class));
            } else if (id == e.reset_setting) {
                startActivityForResult(new Intent(this, ResetBraceletActivity.class), 2);
            } else if (id == e.remote_photo) {
                if (C4725b.m22616a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"})) {
                    startActivity(new Intent(this, RemoteTakePictureActivity.class));
                    return;
                }
                C4725b.m22614a((Activity) this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"}, new bn(this));
            } else if (id == e.btn_disconncet) {
                m26802q();
            } else if (id == e.help) {
                startActivity(new Intent(this, HelpActivity.class));
            }
        }
    }

    private void m26802q() {
        C5823f c5823f = new C5823f(this);
        c5823f.m26915a(h.unbind_btn);
        c5823f.m26919b(h.unbind_tip);
        c5823f.m26920b(h.unbind_btn, new bo(this));
        c5823f.m26916a(h.cancel, new bp(this));
        c5823f.m26914a().show();
    }

    private void m26803r() {
        C5823f c5823f = new C5823f(this);
        c5823f.m26915a(h.unbind_fail);
        c5823f.m26919b(h.unbind_fail_tip);
        c5823f.m26916a(h.sure, new bq(this));
        c5823f.m26914a().show();
    }

    public void onBackPressed() {
        new C3568d(this).m17916a(f19813a);
        super.onBackPressed();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int i = 1;
        if (3 != C3596n.m18054a()) {
            boolean z2;
            CheckBox checkBox = this.f19817g;
            if (z) {
                z2 = false;
            }
            checkBox.setChecked(z2);
            Toast.makeText(this, h.please_connect_first, 0).show();
            return;
        }
        C3627j c3627j = f19813a;
        if (!z) {
            i = 0;
        }
        c3627j.m18178e(i);
        new C3568d(this).m17916a(f19813a);
        if (f19813a.m18193m() > 0) {
            sendBroadcast(new Intent("com.fenda.hwbracelet.INTENT_START_RSSI"), "com.af500.permission.MYBRODCAST");
        } else {
            sendBroadcast(new Intent("com.fenda.hwbracelet.INTENT_STOP_RSSI"), "com.af500.permission.MYBRODCAST");
        }
    }

    public void onClick(View view) {
        boolean z = false;
        boolean z2 = true;
        CheckBox checkBox;
        if (view.getId() == e.cb_remote_hand) {
            if (3 != C3596n.m18054a()) {
                Toast.makeText(this, getString(h.please_connect_first), 0).show();
                checkBox = this.f19816d;
                if (f19813a.m18196p() != 1) {
                    z2 = false;
                }
                checkBox.setChecked(z2);
                return;
            }
            if (f19813a.m18196p() != 1) {
                z = true;
            }
            this.f19829s = z;
            m26804s();
            if (m26514e() != null) {
                m26514e().m26559a(new C3625h(this.f19829s).m18163a());
            }
            m26793b(8);
        } else if (view.getId() != e.cb_remote_light) {
        } else {
            if (3 != C3596n.m18054a()) {
                Toast.makeText(this, getString(h.please_connect_first), 0).show();
                checkBox = this.f19815c;
                if (f19813a.m18195o() != 1) {
                    z2 = false;
                }
                checkBox.setChecked(z2);
                return;
            }
            if (f19813a.m18195o() != 1) {
                z = true;
            }
            this.f19828r = z;
            m26804s();
            if (m26514e() != null) {
                m26514e().m26559a(new C3624g(this.f19828r).m18162a());
            }
            m26794c(8);
        }
    }

    private void m26804s() {
        if (this.f19826p == null) {
            this.f19826p = C5827a.m26922a((Context) this);
            this.f19826p.setCanceledOnTouchOutside(false);
            this.f19826p.setOnKeyListener(new br(this));
            this.f19826p.m26923a(getString(h.please_waiting));
        }
        this.f19826p.show();
    }

    private void m26805t() {
        if (this.f19826p != null) {
            this.f19826p.dismiss();
        }
    }

    protected int mo5104a() {
        return f.act_setting;
    }

    protected int mo5114f() {
        return getResources().getDimensionPixelSize(c.setting_main_title_height);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C4718b.m22594a().m22602a(strArr, iArr);
    }
}
