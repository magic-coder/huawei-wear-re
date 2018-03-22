package com.huawei.pluginaf500.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.fenda.p255a.p256a.C3568d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;

public class AntiLostRemindActivity extends AF500BaseActivity {
    OnSeekBarChangeListener f19726a = new ah(this);
    private SeekBar f19727b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.anti_lost_remind);
        m26703j();
    }

    private void m26703j() {
        boolean z = true;
        this.f19727b = (SeekBar) findViewById(e.sb_distance);
        this.f19727b.setMax(10);
        if (SettingActivity.f19813a != null) {
            int n = SettingActivity.f19813a.m18194n();
            if (n < 3) {
                SettingActivity.f19813a.m18181f(3);
            } else {
                SettingActivity.f19813a.m18181f(n);
            }
            this.f19727b.setProgress(SettingActivity.f19813a.m18194n() - 3);
            this.f19727b.setOnSeekBarChangeListener(this.f19726a);
            CheckBox checkBox = (CheckBox) findViewById(e.cb_start_remind);
            if (SettingActivity.f19813a.m18193m() != 1) {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setOnCheckedChangeListener(new ag(this));
        }
    }

    public void viewOnClick(View view) {
        int i = 13;
        super.viewOnClick(view);
        int id = view.getId();
        if (id == e.btn_add) {
            id = this.f19727b.getProgress() + 1;
            if (id <= 13) {
                i = id;
            }
            this.f19727b.setProgress(i);
            if (SettingActivity.f19813a != null) {
                SettingActivity.f19813a.m18181f(i + 3);
            }
        } else if (id == e.btn_minus) {
            i = this.f19727b.getProgress() - 1;
            if (i <= 0) {
                i = 0;
            }
            this.f19727b.setProgress(i);
            if (SettingActivity.f19813a != null) {
                SettingActivity.f19813a.m18181f(i + 3);
            }
        }
    }

    public void onBackPressed() {
        C3568d c3568d = new C3568d(this);
        if (SettingActivity.f19813a != null) {
            c3568d.m17916a(SettingActivity.f19813a);
            if (SettingActivity.f19813a.m18193m() > 0) {
                sendBroadcast(new Intent("com.fenda.hwbracelet.INTENT_START_RSSI"), "com.af500.permission.MYBRODCAST");
            } else {
                sendBroadcast(new Intent("com.fenda.hwbracelet.INTENT_STOP_RSSI"), "com.af500.permission.MYBRODCAST");
            }
        }
        super.onBackPressed();
    }

    protected int mo5104a() {
        return f.act_anti_lost_remind;
    }
}
