package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1886b;

/* compiled from: AddAlarmActivity */
class C1863f implements OnClickListener {
    final /* synthetic */ EditText f6109a;
    final /* synthetic */ AddAlarmActivity f6110b;

    C1863f(AddAlarmActivity addAlarmActivity, EditText editText) {
        this.f6110b = addAlarmActivity;
        this.f6109a = editText;
    }

    public void onClick(View view) {
        String obj = this.f6109a.getText().toString();
        if (obj == null || "".equals(obj)) {
            C1483c.m6824a(this.f6110b.f5349I, C1680l.IDS_plugin_kidwatch_common_illegal_null);
            return;
        }
        C2538c.m12674b("AddAlarmActivity", "========howSelfDefineDialog changeThemeDialog sure onClick!!!");
        if (!C1492l.m6917b(obj)) {
            C1483c.m6824a(this.f6110b.getApplicationContext(), C1680l.IDS_plugin_kidwatch_common_illegal);
        } else if (!C1886b.m9650a(obj)) {
            C1483c.m6832c(this.f6110b.f5349I, String.format(this.f6110b.f5349I.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_poried_edit_info), new Object[]{Integer.valueOf(7), Integer.valueOf(12)}));
            C2538c.m12674b("AddAlarmActivity", "========howSelfDefineDialog changeThemeDialog sure onClick  Non isRegexStr return!!!");
        } else if ("".equals(obj)) {
            C2538c.m12674b("AddAlarmActivity", "========howSelfDefineDialog changeThemeDialog sure onClick!!!");
        } else {
            this.f6110b.f5354N[4] = true;
            this.f6110b.f5377w.cancel();
            this.f6110b.f5377w = null;
            this.f6110b.f5378x = this.f6109a.getText().toString();
            this.f6110b.m8953b(this.f6110b.f5378x);
        }
    }
}
