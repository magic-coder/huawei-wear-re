package com.huawei.pluginkidwatch.common.ui.p150a;

import android.app.Activity;
import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.C1596w;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;

/* compiled from: CustomDialogUtil */
public class C1506g {
    private static CustomDialog f3518a = null;

    public static CustomDialog m6977a() {
        return f3518a;
    }

    public static void m6978a(Context context, String str, boolean z) {
        if (((Activity) context).isFinishing()) {
            C2538c.m12674b("CustomDialogUtil", "showWaitingDialog: isFinishing...");
        } else if (f3518a == null) {
            C1595v c1595v = new C1595v(context);
            c1595v.m7344a(C1596w.PROGRESS);
            if ("".equals(str)) {
                c1595v.m7348b(C1680l.IDS_plugin_kidwatch_common_loading);
            } else {
                c1595v.m7351b(str);
            }
            c1595v.m7347a(z);
            f3518a = c1595v.m7338a();
            f3518a.show();
        }
    }

    public static void m6979b() {
        if (f3518a != null && f3518a.isShowing()) {
            f3518a.dismiss();
            f3518a = null;
        }
    }
}
