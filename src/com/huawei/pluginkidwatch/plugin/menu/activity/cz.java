package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1886b;

/* compiled from: EditCustomTimeActivity */
class cz implements OnItemClickListener {
    final /* synthetic */ EditCustomTimeActivity f6019a;

    cz(EditCustomTimeActivity editCustomTimeActivity) {
        this.f6019a = editCustomTimeActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12674b("EditCustomTimeActivity", "==========Enter mOnItemClickListener");
        String str = "";
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f6019a.f5657s.length) {
            String charSequence;
            int i4;
            if (this.f6019a.f5657s[i2]) {
                charSequence = this.f6019a.f5643e.getText().toString();
                i4 = i2;
            } else {
                charSequence = str;
                i4 = i3;
            }
            this.f6019a.f5657s[i2] = false;
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
                this.f6019a.f5657s[0] = true;
                this.f6019a.f5653o = this.f6019a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotoschool);
                this.f6019a.m9283a(this.f6019a.f5653o);
                break;
            case 1:
                this.f6019a.f5657s[1] = true;
                this.f6019a.f5653o = this.f6019a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotohome);
                this.f6019a.m9283a(this.f6019a.f5653o);
                break;
            case 2:
                this.f6019a.f5657s[2] = true;
                this.f6019a.f5653o = this.f6019a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_location_gotobed);
                this.f6019a.m9283a(this.f6019a.f5653o);
                break;
            case 3:
                m9596a(i3, str);
                break;
        }
        this.f6019a.f5645g = i;
        if (this.f6019a.f5659u != null) {
            this.f6019a.f5659u.dismiss();
            this.f6019a.f5659u = null;
        }
    }

    private void m9596a(int i, String str) {
        C2538c.m12674b("EditCustomTimeActivity", "========Enter sendChangeThemeToCloud");
        if (this.f6019a.f5648j == null) {
            this.f6019a.f5648j = new C1507h(this.f6019a.f5641c, h.dialog_selfdefine, m.servicedialog, false);
        }
        ((TextView) this.f6019a.f5648j.findViewById(g.common_selfdefine_dialog_title)).setText(this.f6019a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_self_label));
        EditText editText = (EditText) this.f6019a.f5648j.findViewById(g.common_selfdefine_dialog_content);
        editText.setHint(String.format(this.f6019a.f5641c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_poried_edit_info), new Object[]{Integer.valueOf(7), Integer.valueOf(12)}));
        editText.setFilters(new InputFilter[]{new LengthFilter(12)});
        C1886b.m9648a(editText);
        this.f6019a.f5648j.show();
        this.f6019a.f5648j.findViewById(g.common_selfdefine_dialog_cancle).setOnClickListener(new da(this, i, str));
        this.f6019a.f5648j.findViewById(g.common_selfdefine_dialog_sure).setOnClickListener(new db(this, editText));
    }
}
