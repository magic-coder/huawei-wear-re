package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1886b;

/* compiled from: AddPeroidActivity */
class aq implements OnClickListener {
    final /* synthetic */ EditText f5938a;
    final /* synthetic */ AddPeroidActivity f5939b;

    aq(AddPeroidActivity addPeroidActivity, EditText editText) {
        this.f5939b = addPeroidActivity;
        this.f5938a = editText;
    }

    public void onClick(View view) {
        String obj = this.f5938a.getText().toString();
        if (obj == null || "".equals(obj)) {
            C1483c.m6824a(this.f5939b.f5498n, C1680l.IDS_plugin_kidwatch_common_illegal_null);
        } else if (!C1492l.m6917b(obj)) {
            C1483c.m6824a(this.f5939b.getApplicationContext(), C1680l.IDS_plugin_kidwatch_common_illegal);
        } else if (!C1886b.m9650a(obj)) {
            C1483c.m6832c(this.f5939b.f5498n, String.format(this.f5939b.f5498n.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_poried_edit_info), new Object[]{Integer.valueOf(7), Integer.valueOf(12)}));
        } else if (!"".equals(obj)) {
            this.f5939b.f5485R.cancel();
            this.f5939b.f5485R = null;
            this.f5939b.f5481N = this.f5938a.getText().toString();
            this.f5939b.m9083a(this.f5939b.f5481N);
            this.f5939b.f5486S = 4;
        }
    }
}
