package com.huawei.android.pushagent.p018c.p027c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;

public class C4113a {
    private static String f15506a = "PushLogAC2712";

    public static boolean m20142a(Context context) {
        boolean a = new h(context, "canStartPush").a("startPush");
        e.a(f15506a, "get canStartPush Value is " + a);
        return a;
    }
}
