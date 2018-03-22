package com.huawei.android.pushagent.plugin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.p331a.C4125a;
import com.huawei.android.pushagent.plugin.p332b.C4131a;
import com.sina.weibo.sdk.component.GameManager;

public class PluginTokenReceiver extends BroadcastReceiver {
    private static C4131a f15543a;

    class C4139a extends Thread {
        private C4139a() {
        }

        public void run() {
            PluginTokenReceiver.f15543a.mo4384a();
        }
    }

    public PluginTokenReceiver(C4131a c4131a) {
        m20217a(c4131a);
    }

    private static void m20217a(C4131a c4131a) {
        f15543a = c4131a;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            e.a("PushLogSC2712", "enter PushMsgReceiver:onReceive(Intent:" + intent.getAction() + " pkgName:" + context.getPackageName() + ")");
            if ("com.huawei.android.push.intent.REGISTRATION".equals(intent.getAction()) && intent.hasExtra("device_token")) {
                String str = new String(intent.getByteArrayExtra("device_token"), GameManager.DEFAULT_CHARSET);
                e.a("PushLogSC2712", "get deviceToken success");
                new C4125a(context).m20175b(str);
                new C4139a().start();
            }
        } catch (Throwable e) {
            e.c("PushLogSC2712", "call onReceive(intent:" + intent + ") cause:" + e.toString(), e);
        }
    }
}
