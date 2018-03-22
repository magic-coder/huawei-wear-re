package com.huawei.pluginkidwatch.common.entity;

import android.content.Context;
import com.huawei.pluginkidwatch.common.entity.p139a.C1414c;

/* compiled from: Entity */
public class C1417a {
    private static C1453c f3232a = C1453c.KID;
    private static C1413d f3233b = null;

    public static C1413d m6594a(Context context) {
        if (f3233b != null) {
            return f3233b;
        }
        switch (C1445b.f3325a[f3232a.ordinal()]) {
            case 1:
                f3233b = C1414c.m6542a(context);
                break;
            default:
                f3233b = C1414c.m6542a(context);
                break;
        }
        return f3233b;
    }
}
