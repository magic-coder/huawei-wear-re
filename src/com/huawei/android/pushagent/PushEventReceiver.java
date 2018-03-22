package com.huawei.android.pushagent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p018c.p019a.C0659h;
import com.huawei.android.pushagent.p018c.p027c.C0661b;

public class PushEventReceiver extends BroadcastReceiver {
    private static void m2342a(Context context, Intent intent) {
        try {
            if (!"com.huawei.android.pushagent".equals(context.getPackageName())) {
                C0657e.m2512a("PushLogAC2712", "run invokePluginReport");
                Class cls = Class.forName("com.huawei.android.pushagent.plugin.tools.PushPluginsBroadcastMgr");
                cls.getMethod("handleEvent", new Class[]{Context.class, Intent.class}).invoke(cls, new Object[]{context, intent});
            }
        } catch (ClassNotFoundException e) {
            C0657e.m2512a("PushLogAC2712", "ClassNotFoundException:" + e.toString());
        } catch (Throwable e2) {
            C0657e.m2521c("PushLogAC2712", e2.toString(), e2);
        } catch (Throwable e22) {
            C0657e.m2521c("PushLogAC2712", e22.toString(), e22);
        } catch (Throwable e222) {
            C0657e.m2521c("PushLogAC2712", e222.toString(), e222);
        } catch (Throwable e2222) {
            C0657e.m2521c("PushLogAC2712", e2222.toString(), e2222);
        }
    }

    private static void m2343b(Context context, Intent intent) {
        boolean a = new C0659h(context, "push_switch").m2537a("notify_msg_enable");
        C0657e.m2512a("PushLogAC2712", "closePush_Notify:" + a);
        if (!a) {
            try {
                C0657e.m2517b("PushLogAC2712", "run push selfshow");
                Class cls = Class.forName("com.huawei.android.pushselfshow.a");
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                cls.getDeclaredMethod("onReceive", new Class[]{Context.class, Intent.class}).invoke(newInstance, new Object[]{context, intent});
            } catch (ClassNotFoundException e) {
                C0657e.m2517b("PushLogAC2712", "ClassNotFoundException:" + e.toString());
            } catch (Throwable e2) {
                C0657e.m2521c("PushLogAC2712", e2.toString(), e2);
            } catch (Throwable e22) {
                C0657e.m2521c("PushLogAC2712", e22.toString(), e22);
            } catch (Throwable e222) {
                C0657e.m2521c("PushLogAC2712", e222.toString(), e222);
            } catch (Throwable e2222) {
                C0657e.m2521c("PushLogAC2712", e2222.toString(), e2222);
            } catch (Throwable e22222) {
                C0657e.m2521c("PushLogAC2712", e22222.toString(), e22222);
            }
        }
    }

    private static void m2344c(Context context, Intent intent) {
        try {
            C0657e.m2512a("PushLogAC2712", "run PushProxy.handleEvent ");
            C0661b.m2606a(context, intent);
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", e.toString(), e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            C0657e.m2512a("PushLogAC2712", "context== null or intent == null");
            return;
        }
        C0657e.m2511a(context);
        String action = intent.getAction();
        C0657e.m2517b("PushLogAC2712", "action is " + action);
        if (("com.huawei.intent.action.PUSH".equals(action) && intent.hasExtra("selfshow_info")) || "android.intent.action.PACKAGE_ADDED".equals(action)) {
            m2343b(context, intent);
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                m2344c(context, intent);
            }
        } else if ("com.huawei.android.push.PLUGIN".equals(action)) {
            m2342a(context, intent);
        } else {
            m2344c(context, intent);
        }
    }
}
