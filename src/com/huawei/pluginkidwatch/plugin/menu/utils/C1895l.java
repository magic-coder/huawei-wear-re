package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;

/* compiled from: FreshBuletoothUtil */
public class C1895l {
    public static void m9663a(Context context, C1413d c1413d) {
        C2538c.m12674b("FreshBuletoothUtil", "==========Enter freshBuletooth");
        C1395k a = C1392h.m6269a(context, C1462f.m6744i(), C1462f.m6746j());
        if (a != null) {
            try {
                if (a.f3096p != null) {
                    C2538c.m12674b("FreshBuletoothUtil", "deviceInfo = " + a.f3096p);
                    c1413d.mo2508a(a.f3096p, C1462f.m6746j());
                }
            } catch (Exception e) {
                C2538c.m12674b("FreshBuletoothUtil", "==========FreshBuletoothUtil ERROR!!!");
            }
        }
    }
}
