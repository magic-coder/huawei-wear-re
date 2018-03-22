package com.huawei.ui.device.p170a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.n.a;
import com.huawei.n.b;
import com.huawei.s.j;
import com.huawei.ui.device.activity.adddevice.AddDeviceChildActivity;
import com.huawei.ui.device.views.p172a.C2187c;
import com.huawei.ui.device.views.p172a.C2188d;
import java.util.List;

/* compiled from: AddDeviceInteractor */
public class C1973a {
    public static List<String> m10284a() {
        return a.b();
    }

    public static List<b> m10288b() {
        return a.f();
    }

    public static List<String> m10289c() {
        return a.a();
    }

    public static List<b> m10290d() {
        return a.e();
    }

    public static List<String> m10291e() {
        return a.c();
    }

    public static List<b> m10292f() {
        return a.g();
    }

    public static List<String> m10293g() {
        return a.d();
    }

    public static List<b> m10294h() {
        return a.h();
    }

    public static b m10281a(int i) {
        return a.a(i);
    }

    public static void m10285a(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, AddDeviceChildActivity.class);
        if (str != null && str.equals("personalbasicinfosetting")) {
            intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
        }
        intent.putExtra("style", i);
        activity.startActivityForResult(intent, 1);
    }

    public static boolean m10286a(Activity activity, int i) {
        if (2 != i && 1 != i) {
            return false;
        }
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        if ((C0977d.m3534a() && 2 != i) || activity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        activity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 11);
        return false;
    }

    public static C2187c m10282a(int i, String str, String str2, int i2) {
        C2187c c2187c = new C2187c();
        c2187c.m11205a(str);
        c2187c.m11203a(i);
        c2187c.m11208b(str2);
        c2187c.m11207b(i2);
        return c2187c;
    }

    public static C2188d m10283a(int i, String str, String[] strArr, int i2) {
        C2188d c2188d = new C2188d();
        c2188d.m11213a(i);
        c2188d.m11215a(str);
        c2188d.m11216a(strArr);
        c2188d.m11218b(i2);
        return c2188d;
    }

    public static boolean m10287a(Context context) {
        if (VERSION.SDK_INT >= 23) {
            return j.a(context);
        }
        return true;
    }
}
