package com.huawei.pluginkidwatch.home.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.huawei.p190v.C2538c;

public class CircleGetPushMessageReceiver extends BroadcastReceiver {
    private static int f4366a = 0;

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"com.huawei.intent.action.PUSH_STATE".equals(intent.getAction())) {
            C2538c.m12674b("CircleGetPushMessageReceiver", "===========onReceive-->else");
            return;
        }
        C2538c.m12674b("CircleGetPushMessageReceiver", "===========CircleGetPushMessageReceiver==" + intent.getAction() + "   pid:  " + Process.myPid());
        C2538c.m12674b("CircleGetPushMessageReceiver", "===========pushState:" + intent.getBooleanExtra("push_state", false));
        if (intent.getBooleanExtra("push_state", false)) {
            C2538c.m12674b("CircleGetPushMessageReceiver", "===========push Connected");
            m7831a(0);
            return;
        }
        C2538c.m12674b("CircleGetPushMessageReceiver", "===========push Disconnected");
        m7830a();
        C2538c.m12674b("CircleGetPushMessageReceiver", "===========falseNum:" + f4366a);
        if (f4366a >= 5) {
            m7831a(0);
            C2538c.m12674b("CircleGetPushMessageReceiver", "===========重新进行getToken");
            Intent intent2 = new Intent();
            intent2.setClassName(context, "com.huawei.pluginkidwatch.home.K1PushService");
            intent2.setPackage(context.getPackageName());
            context.startService(intent2);
            return;
        }
        m7832a(context);
    }

    private void m7832a(Context context) {
        if (context != null) {
            C2538c.m12674b("CircleGetPushMessageReceiver", "==========connectServer --> refresh");
            Intent intent = new Intent("com.huawei.android.push.intent.REFRESH_PUSH_CHANNEL");
            intent.setPackage(context.getPackageName());
            intent.setFlags(32);
            C2538c.m12674b("CircleGetPushMessageReceiver", "sendBroadcast the acrion is :" + "com.huawei.android.push.intent.REFRESH_PUSH_CHANNEL");
            context.sendBroadcast(intent);
            return;
        }
        C2538c.m12674b("CircleGetPushMessageReceiver", "========connectServer -- >mContext is null");
    }

    private static void m7831a(int i) {
        f4366a = i;
    }

    private static void m7830a() {
        f4366a++;
    }
}
