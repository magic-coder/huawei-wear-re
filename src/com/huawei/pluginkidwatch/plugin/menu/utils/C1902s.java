package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.model.ConfirmBindIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeleteWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;

/* compiled from: MenuUtils */
public class C1902s {
    private static C1669v f6225a;

    public static void m9683a(Context context, C1401q c1401q, C1669v c1669v) {
        if (c1401q != null && -1 != c1401q.f3145a) {
            f6225a = c1669v;
            C1413d a = C1417a.m6594a(context);
            ConfirmBindIOEntityModel confirmBindIOEntityModel = new ConfirmBindIOEntityModel();
            confirmBindIOEntityModel.recordId = c1401q.f3152h;
            confirmBindIOEntityModel.result = String.valueOf(c1401q.f3151g);
            a.mo2475a(confirmBindIOEntityModel, new C1903t(context, c1401q, a));
        }
    }

    public static void m9684b(Context context, C1401q c1401q, C1669v c1669v) {
        if (c1401q != null && -1 != c1401q.f3145a) {
            f6225a = c1669v;
            C1413d a = C1417a.m6594a(context);
            if (2 == c1401q.f3151g) {
                DeleteWatchContactIOEntityModel deleteWatchContactIOEntityModel = new DeleteWatchContactIOEntityModel();
                deleteWatchContactIOEntityModel.deviceCode = c1401q.f3147c;
                C2538c.m12674b("MenuUtils", "=====================================" + c1401q.f3153i);
                if (!("".equals(c1401q.f3153i) || c1401q.f3153i == null)) {
                    deleteWatchContactIOEntityModel.id = C1492l.m6920d(c1401q.f3153i);
                }
                a.mo2476a(deleteWatchContactIOEntityModel, new C1904u(context, c1401q, a));
                return;
            }
            f6225a.mo2563a(0);
            C1392h.m6307d(context, c1401q);
        }
    }
}
