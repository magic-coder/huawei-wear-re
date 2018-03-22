package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;

/* compiled from: HomeUtil */
public class C1642v {
    public static boolean m7777a(Context context) {
        boolean z;
        if (VERSION.SDK_INT < 19) {
            z = false;
        } else if (context == null || context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12674b("HomeUtil", "=======isSupportStartAntilossService startState:  " + z);
        return z;
    }

    public static void m7776a(Context context, C1413d c1413d) {
        C2538c.m12674b("HomeUtil", "==========Enter immediateRefreshBuletoothSettings");
        if (context != null) {
            String i = C1462f.m6744i();
            if ("".equals(i)) {
                i = C1093a.m4739a(context).m4750c();
                C2538c.m12674b("HomeUtil", "===immediateRefreshBuletoothSettings======= huid = " + i);
                C1462f.m6729c(i);
            }
            C1395k a = C1392h.m6269a(context, i, C1462f.m6746j());
            if (a.f3096p != null && c1413d != null) {
                C2538c.m12674b("HomeUtil", "deviceInfo = " + a.f3096p);
                c1413d.mo2508a(a.f3096p, C1462f.m6746j());
            }
        }
    }

    public static void m7778b(Context context, C1413d c1413d) {
        C2538c.m12677c("HomeUtil", "==========Enter remoteShutDownKidWatch");
        if (context == null || c1413d == null) {
            C2538c.m12680e("HomeUtil", "========== remoteShutDownKidWatch null == context || null == entity return!");
            return;
        }
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.data = "";
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 9;
        c1413d.mo2473a(commonRetOModel, new C1643w(context, c1413d));
    }
}
