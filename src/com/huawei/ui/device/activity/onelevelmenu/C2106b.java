package com.huawei.ui.device.activity.onelevelmenu;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.views.onelevelmenu.C2207a;
import com.huawei.ui.device.views.onelevelmenu.C2208b;

/* compiled from: OneLevelMenuAddActivity */
class C2106b implements OnItemClickListener {
    final /* synthetic */ OneLevelMenuAddActivity f7458a;

    C2106b(OneLevelMenuAddActivity oneLevelMenuAddActivity) {
        this.f7458a = oneLevelMenuAddActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2208b c2208b = (C2208b) view.getTag();
        if (c2208b == null) {
            C2538c.m12680e(this.f7458a.f7421a, "holder == null");
            return;
        }
        c2208b.f7915b.toggle();
        C2207a.m11332a().put(Integer.valueOf(i), Boolean.valueOf(c2208b.f7915b.isChecked()));
        C2538c.m12677c(this.f7458a.f7421a, "arg2 = " + i + "checkBox.isChecked() = " + c2208b.f7915b.isChecked());
        C2538c.m12677c(this.f7458a.f7421a, "ContactDeleteListAdapter map = " + C2207a.m11332a());
    }
}
