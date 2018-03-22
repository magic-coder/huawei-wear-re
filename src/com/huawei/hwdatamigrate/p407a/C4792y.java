package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;

/* compiled from: MBOneDBUtil */
public class C4792y {
    public static void m22919a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "default_userid";
        }
        bc bcVar = new bc(context);
        bd a = bcVar.m22834a();
        if (a == null) {
            a = new bd();
            a.f17556a = -1;
            a.f17557b = str;
            C2538c.b("BOneDBUtil", new Object[]{"resetUserIDFromDB() --insert"});
            bcVar.m22833a(a);
            return;
        }
        a.f17557b = str;
        C2538c.b("BOneDBUtil", new Object[]{"resetUserIDFromDB() --update"});
        bcVar.m22835b(a);
    }
}
