package com.huawei.pluginkidwatch.home.p156b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: CheckNewVersionUtils */
class C1632l implements OnClickListener {
    final /* synthetic */ C1624d f4238a;

    C1632l(C1624d c1624d) {
        this.f4238a = c1624d;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "============发起升级=======");
        this.f4238a.m7718n();
        C1491k.m6897a(this.f4238a.f4215n, C1462f.m6746j() + "ruleAttr", "");
        C1491k.m6896a(this.f4238a.f4215n, C1462f.m6746j() + "isHaveChangeLog", Boolean.valueOf(false));
        boolean booleanValue = C1491k.m6893a(this.f4238a.f4215n, C1462f.m6746j() + "isHaveChangeLog").booleanValue();
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww===value==发起升级" + booleanValue);
        this.f4238a.f4204a.dismiss();
        this.f4238a.f4204a = null;
        this.f4238a.m7721p();
    }
}
