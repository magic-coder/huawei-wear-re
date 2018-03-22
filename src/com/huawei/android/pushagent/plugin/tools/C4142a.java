package com.huawei.android.pushagent.plugin.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.android.pushagent.PushManager;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.f;
import com.huawei.android.pushagent.plugin.p331a.C4125a;
import com.huawei.android.pushagent.plugin.p332b.C4131a;
import com.huawei.android.pushagent.plugin.receiver.PluginTokenReceiver;

public class C4142a {
    private static BroadcastReceiver f15548a;

    private static synchronized void m20228a(BroadcastReceiver broadcastReceiver) {
        synchronized (C4142a.class) {
            f15548a = broadcastReceiver;
        }
    }

    public static final synchronized void m20229a(Context context) {
        synchronized (C4142a.class) {
            try {
                if (f15548a != null) {
                    context.getApplicationContext().unregisterReceiver(f15548a);
                }
            } catch (Throwable e) {
                e.c("PushLogSC2712", e.getMessage(), e);
            }
            C4142a.m20228a(null);
        }
    }

    public static final synchronized void m20230a(Context context, C4131a c4131a) {
        synchronized (C4142a.class) {
            if (f15548a != null) {
                C4142a.m20229a(context);
            }
            PushManager.requestToken(context);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
            C4142a.m20228a(new PluginTokenReceiver(c4131a));
            context.getApplicationContext().registerReceiver(f15548a, intentFilter);
        }
    }

    public static String m20231b(Context context) {
        if (context == null) {
            return "";
        }
        Object a = f.a(context, "push_client_self_info", "token_info");
        return TextUtils.isEmpty(a) ? new C4125a(context).m20179d() : a;
    }
}
