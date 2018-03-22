package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1886b;

/* compiled from: EditCustomTimeActivity */
class db implements OnClickListener {
    final /* synthetic */ EditText f6024a;
    final /* synthetic */ cz f6025b;

    db(cz czVar, EditText editText) {
        this.f6025b = czVar;
        this.f6024a = editText;
    }

    public void onClick(View view) {
        String obj = this.f6024a.getText().toString();
        if (obj == null || "".equals(obj)) {
            C2538c.m12674b("EditCustomTimeActivity", "==ww==  aaaaaaaa name is kong or null");
            C1483c.m6824a(this.f6025b.f6019a.f5641c, C1680l.IDS_plugin_kidwatch_common_illegal_null);
        } else if (!C1492l.m6917b(obj) || obj.contains(HwAccountConstants.BLANK)) {
            C1483c.m6832c(this.f6025b.f6019a.f5641c, String.format(this.f6025b.f6019a.f5641c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_poried_edit_info), new Object[]{Integer.valueOf(7), Integer.valueOf(12)}));
        } else if (!C1886b.m9650a(obj)) {
            C1483c.m6832c(this.f6025b.f6019a.f5641c, String.format(this.f6025b.f6019a.f5641c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_poried_edit_info), new Object[]{Integer.valueOf(7), Integer.valueOf(12)}));
        } else if (!"".equals(obj)) {
            this.f6025b.f6019a.f5657s[3] = true;
            this.f6025b.f6019a.f5648j.cancel();
            this.f6025b.f6019a.f5648j = null;
            this.f6025b.f6019a.f5653o = this.f6024a.getText().toString();
            this.f6025b.f6019a.m9283a(this.f6025b.f6019a.f5653o);
        }
    }
}
