package com.huawei.hwcommonmodel.p064d;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.huawei.hwcommonmodel.p064d.p406a.C4718b;
import com.huawei.hwcommonmodel.p064d.p406a.C4719c;
import com.huawei.p190v.C2538c;

import java.util.Arrays;

/* compiled from: CheckAndRequestPermissionUtil */
public class C4725b {
    public static boolean m22616a(Context context, String[] strArr) {
        for (String a : strArr) {
            C2538c.c("CheckAndRequestPermissionUtil", new Object[]{"permissions = " + strArr[r0] + "， hasPermission = " + C4718b.m22594a().m22603a(context, a)});
            if (!C4718b.m22594a().m22603a(context, a)) {
                return false;
            }
        }
        return true;
    }

    public static void m22614a(Activity activity, String[] strArr, C4719c c4719c) {
        C2538c.c("CheckAndRequestPermissionUtil", new Object[]{"enter requestPermission(): activity = " + activity + ",permissions" + Arrays.toString(strArr) + ",action = " + c4719c});
        C4718b.m22594a().m22600a(activity, strArr, c4719c);
    }

    public static void m22615a(Fragment fragment, String[] strArr, C4719c c4719c) {
        C2538c.c("CheckAndRequestPermissionUtil", new Object[]{"enter requestPermission(): fragment = " + fragment + ",permissions" + Arrays.toString(strArr) + ",action = " + c4719c});
        C4718b.m22594a().m22601a(fragment, strArr, c4719c);
    }
}
