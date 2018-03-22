package com.huawei.ui.device.p170a;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.device.p171b.C2184b;

/* compiled from: AlarmInteractor */
public class C1974b {
    private static C1974b f6900b;
    private Context f6901a;

    private C1974b(Context context) {
        this.f6901a = context;
    }

    public static C1974b m10364a(Context context) {
        if (f6900b == null) {
            f6900b = new C1974b(BaseApplication.m2632b());
        }
        return f6900b;
    }

    public String m10366a(int i) {
        if (this.f6901a == null) {
            return "";
        }
        return C2184b.m11195a(i, this.f6901a);
    }

    public static String m10365a(Context context, int i) {
        return C2184b.m11196a(context, i);
    }
}
