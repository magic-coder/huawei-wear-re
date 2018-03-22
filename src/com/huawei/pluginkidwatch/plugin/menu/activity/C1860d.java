package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.g;

/* compiled from: AddAlarmActivity */
class C1860d implements OnItemClickListener {
    final /* synthetic */ AddAlarmActivity f6020a;

    C1860d(AddAlarmActivity addAlarmActivity) {
        this.f6020a = addAlarmActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12674b("AddAlarmActivity", "==========Enter mOnItemClickListener");
        String str = "";
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f6020a.f5354N.length) {
            String charSequence;
            int i4;
            if (this.f6020a.f5354N[i2]) {
                charSequence = this.f6020a.f5348H.getText().toString();
                i4 = i2;
            } else {
                charSequence = str;
                i4 = i3;
            }
            this.f6020a.f5354N[i2] = false;
            i2++;
            i3 = i4;
            str = charSequence;
        }
        CheckBox checkBox = (CheckBox) view.findViewById(g.chk_selectone);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        } else {
            checkBox.setChecked(true);
        }
        switch (i) {
            case 0:
                this.f6020a.f5354N[0] = true;
                this.f6020a.f5378x = this.f6020a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_getup);
                this.f6020a.m8953b(this.f6020a.f5378x);
                break;
            case 1:
                this.f6020a.f5354N[1] = true;
                this.f6020a.f5378x = this.f6020a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_water);
                this.f6020a.m8953b(this.f6020a.f5378x);
                break;
            case 2:
                this.f6020a.f5354N[2] = true;
                this.f6020a.f5378x = this.f6020a.getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_sport);
                this.f6020a.m8953b(this.f6020a.f5378x);
                break;
            case 3:
                this.f6020a.f5354N[3] = true;
                this.f6020a.f5378x = this.f6020a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_sleep);
                this.f6020a.m8953b(this.f6020a.f5378x);
                break;
            case 4:
                this.f6020a.m8937a(i3, str);
                break;
            default:
                this.f6020a.m8953b("");
                break;
        }
        this.f6020a.f5371p = i;
        if (this.f6020a.f5359d != null) {
            this.f6020a.f5359d.dismiss();
            this.f6020a.f5359d = null;
        }
    }
}
