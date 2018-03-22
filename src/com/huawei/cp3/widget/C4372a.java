package com.huawei.cp3.widget;

import android.content.Context;
import com.huawei.android.os.BuildEx.VERSION;
import com.huawei.cp3.widget.custom.C4380a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import com.huawei.cp3.widget.p382a.p383a.C4371b;

/* compiled from: WidgetBuilder */
public class C4372a {
    private static final boolean f16226a;
    private static final boolean f16227b;
    private static final boolean f16228c;
    private static C4373b f16229d;

    static {
        boolean z = true;
        boolean z2 = C4372a.m21000a("huawei.android.widget.TimeAxisWidget") && C4372a.m21000a("com.huawei.android.app.WallpaperManagerEx") && C4372a.m21000a("com.huawei.android.app.ActionBarEx") && C4372a.m21000a("huawei.android.widget.SubTabWidget");
        f16226a = z2;
        if (C4372a.m21004d() && VERSION.EMUI_SDK_INT >= 9 && C4372a.m21000a("com.huawei.android.immersion.ImmersionStyle")) {
            z2 = true;
        } else {
            z2 = false;
        }
        f16227b = z2;
        if (!C4372a.m21004d() || VERSION.EMUI_SDK_INT < 11) {
            z = false;
        }
        f16228c = z;
        if (f16226a) {
            C4372a.m21000a("com.huawei.cp3.widget.hw.BuilderHw");
        } else if (!C4372a.m21000a("com.huawei.cp3.widget.custom.BuilderCustom")) {
            C4372a.m21000a("com.huawei.cp3.widget.hw.DefaultBuilder");
        }
    }

    public static void m20998a(C4373b c4373b) {
        f16229d = c4373b;
    }

    public static boolean m20999a() {
        return f16226a;
    }

    public static boolean m21002b() {
        return f16227b;
    }

    public static boolean m21003c() {
        return f16228c;
    }

    private static boolean m21004d() {
        return C4372a.m21000a("com.huawei.android.os.BuildEx");
    }

    public static C4370a m20997a(Context context) {
        return C4372a.m21005e().mo4443a(context);
    }

    public static C4371b m21001b(Context context) {
        return C4372a.m21005e().mo4444b(context);
    }

    private static boolean m21000a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static C4373b m21005e() {
        if (f16229d == null) {
            C4372a.m20998a(new C4380a());
        }
        return f16229d;
    }
}
