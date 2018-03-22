package com.huawei.android.pushagent.p020b.p025f;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p020b.C0647a;
import com.huawei.android.pushagent.p020b.p021a.C0646a;

public class C0652a extends C0647a {
    private static String f1178a = "PushLogAC2712";
    private static boolean f1179b = false;

    public C0652a(Context context) {
    }

    public static void m2494a(Context context, boolean z, String str) {
        Intent intent = new Intent();
        C0657e.m2512a(f1178a, "sendStateBroadcast the current push state is: " + z);
        intent.setAction("com.huawei.intent.action.PUSH_STATE").putExtra("push_state", z).setFlags(32).setPackage(str);
        context.sendBroadcast(intent);
    }

    private static synchronized void m2495a(boolean z) {
        synchronized (C0652a.class) {
            f1179b = z;
        }
    }

    public void mo2116a(Context context, Intent intent) {
        C0657e.m2512a(f1178a, "enter ChannelRecorder:onReceive(intent:" + intent + " context:" + context);
        String action = intent.getAction();
        boolean a = C0646a.m2435e().a();
        C0657e.m2512a(f1178a, "PushState get action :" + action);
        if ("com.huawei.android.push.intent.GET_PUSH_STATE".equals(action)) {
            action = intent.getStringExtra("pkg_name");
            C0657e.m2512a(f1178a, "responseClinetGetPushState: get the client packageName: " + action);
            try {
                C0657e.m2512a(f1178a, "current program pkgName" + context.getPackageName());
                C0657e.m2512a(f1178a, "the current push curIsConnect:" + a);
                C0652a.m2494a(context, a, action);
            } catch (Exception e) {
                C0657e.m2512a(f1178a, "e:" + e.toString());
            }
        }
        if (f1179b != a) {
            C0652a.m2495a(a);
        }
    }
}
