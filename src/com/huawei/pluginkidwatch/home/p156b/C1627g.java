package com.huawei.pluginkidwatch.home.p156b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: CheckNewVersionUtils */
class C1627g implements OnClickListener {
    final /* synthetic */ C1624d f4228a;

    C1627g(C1624d c1624d) {
        this.f4228a = c1624d;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "============发起强制升级=======");
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===www===mForcedUpdate=beforedismiss" + this.f4228a.f4214m);
        this.f4228a.m7731v();
        this.f4228a.m7726r();
        C1491k.m6897a(this.f4228a.f4215n, C1462f.m6746j() + "ruleAttr", "");
        boolean booleanValue = C1491k.m6893a(this.f4228a.f4215n, C1462f.m6746j() + "isHaveChangeLog").booleanValue();
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww===value==强制升级 开始" + booleanValue);
        C1491k.m6896a(this.f4228a.f4215n, C1462f.m6746j() + "isHaveChangeLog", Boolean.valueOf(false));
    }
}
