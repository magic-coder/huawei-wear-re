package com.huawei.pluginkidwatch.home.p156b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: CheckNewVersionUtils */
class C1626f implements OnClickListener {
    final /* synthetic */ C1624d f4227a;

    C1626f(C1624d c1624d) {
        this.f4227a = c1624d;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4227a.m7731v();
        this.f4227a.m7727s();
        boolean booleanValue = C1491k.m6893a(this.f4227a.f4215n, C1462f.m6746j() + "isHaveChangeLog").booleanValue();
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww===value==强制升级 取消" + booleanValue);
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "exit App!!!");
        Intent intent = new Intent();
        intent.setAction("golbal_finish_all_kidwatch_activity");
        LocalBroadcastManager.getInstance(this.f4227a.f4215n).sendBroadcast(intent);
    }
}
