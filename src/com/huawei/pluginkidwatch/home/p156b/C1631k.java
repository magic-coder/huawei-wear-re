package com.huawei.pluginkidwatch.home.p156b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: CheckNewVersionUtils */
class C1631k implements OnClickListener {
    final /* synthetic */ C1624d f4237a;

    C1631k(C1624d c1624d) {
        this.f4237a = c1624d;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww======取消升级 ");
        this.f4237a.m7723q();
        this.f4237a.m7727s();
        boolean booleanValue = C1491k.m6893a(this.f4237a.f4215n, C1462f.m6746j() + "isHaveChangeLog").booleanValue();
        boolean equals = C1491k.m6899b(this.f4237a.f4215n, C1462f.m6746j() + "ruleAttr", "").equals("true");
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww===value==取消升级" + booleanValue);
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww==forceUpdate cancel" + C1491k.m6899b(this.f4237a.f4215n, C1462f.m6746j() + "ruleAttr", ""));
        if (equals) {
            this.f4237a.m7720o();
            this.f4237a.m7744g();
        } else {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "K1 is not forcedUpdate!");
            this.f4237a.m7718n();
        }
        this.f4237a.f4204a.dismiss();
        this.f4237a.f4204a = null;
    }
}
