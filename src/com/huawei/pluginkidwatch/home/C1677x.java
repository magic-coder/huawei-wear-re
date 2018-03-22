package com.huawei.pluginkidwatch.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.ui.listview.C1522b;

/* compiled from: HomeActivity */
class C1677x implements OnItemClickListener {
    final /* synthetic */ HomeActivity f4377a;

    C1677x(HomeActivity homeActivity) {
        this.f4377a = homeActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C1522b c1522b = (C1522b) this.f4377a.f4148u.get(i);
        if (c1522b == null) {
            return;
        }
        if (c1522b.m7038b() == 98) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============HUAWEI_NEWDEVICE");
            this.f4377a.m7479M();
        } else if (c1522b.m7038b() == 5) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============HUAWEIWATCH_K1");
            C1467b.m6786b(this.f4377a, 5);
            this.f4377a.m7572c(i);
        } else if (c1522b.m7038b() == 7) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============HUAWEIWATCH_K2");
            C1467b.m6786b(this.f4377a, 7);
            this.f4377a.m7572c(i);
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============OtherDevice");
            this.f4377a.m7532a(c1522b);
        }
    }
}
