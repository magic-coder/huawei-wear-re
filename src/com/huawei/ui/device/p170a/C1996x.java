package com.huawei.ui.device.p170a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.n.a;
import com.huawei.ui.device.g;
import java.util.HashMap;
import java.util.List;

/* compiled from: DeviceSupportUtil */
public class C1996x {
    private static final HashMap<Integer, String> f6962a = new C1997y();

    public static List<String> m10456a(int i) {
        return a.b(i);
    }

    public static String m10459b(int i) {
        return !f6962a.containsKey(Integer.valueOf(i)) ? "Unknown" : (String) f6962a.get(Integer.valueOf(i));
    }

    public static Drawable m10455a(int i, Context context) {
        if (i <= 0) {
            return context.getResources().getDrawable(g.ic_device_battery_0);
        }
        if (i <= 10) {
            return context.getResources().getDrawable(g.ic_device_battery_5);
        }
        if (i < 20) {
            return context.getResources().getDrawable(g.ic_device_battery_10);
        }
        if (i < 30) {
            return context.getResources().getDrawable(g.ic_device_battery_20);
        }
        if (i < 40) {
            return context.getResources().getDrawable(g.ic_device_battery_30);
        }
        if (i < 50) {
            return context.getResources().getDrawable(g.ic_device_battery_40);
        }
        if (i < 60) {
            return context.getResources().getDrawable(g.ic_device_battery_50);
        }
        if (i <= 70) {
            return context.getResources().getDrawable(g.ic_device_battery_60);
        }
        if (i < 80) {
            return context.getResources().getDrawable(g.ic_device_battery_70);
        }
        if (i < 90) {
            return context.getResources().getDrawable(g.ic_device_battery_80);
        }
        if (i < 100) {
            return context.getResources().getDrawable(g.ic_device_battery_90);
        }
        return context.getResources().getDrawable(g.ic_device_battery_100);
    }

    public static Drawable m10458b(int i, Context context) {
        if (i <= 0) {
            return context.getResources().getDrawable(g.ic_battery_0);
        }
        if (i <= 10) {
            return context.getResources().getDrawable(g.ic_battery_5);
        }
        if (i < 20) {
            return context.getResources().getDrawable(g.ic_battery_10);
        }
        if (i < 30) {
            return context.getResources().getDrawable(g.ic_battery_20);
        }
        if (i < 40) {
            return context.getResources().getDrawable(g.ic_battery_30);
        }
        if (i < 50) {
            return context.getResources().getDrawable(g.ic_battery_40);
        }
        if (i < 60) {
            return context.getResources().getDrawable(g.ic_battery_50);
        }
        if (i <= 70) {
            return context.getResources().getDrawable(g.ic_battery_60);
        }
        if (i < 80) {
            return context.getResources().getDrawable(g.ic_battery_70);
        }
        if (i < 90) {
            return context.getResources().getDrawable(g.ic_battery_80);
        }
        if (i < 100) {
            return context.getResources().getDrawable(g.ic_battery_90);
        }
        return context.getResources().getDrawable(g.ic_battery_100);
    }

    public static boolean m10457a(Context context) {
        return C0969i.m3482a(1) && C0977d.m3535a(context);
    }
}
