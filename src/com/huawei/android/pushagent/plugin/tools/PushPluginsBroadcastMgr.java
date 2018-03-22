package com.huawei.android.pushagent.plugin.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.PushPlugins;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;

public class PushPluginsBroadcastMgr {
    private static String f15544a = "PushLogSC2712";

    public static void handleEvent(Context context, Intent intent) {
        try {
            if ("com.huawei.android.push.PLUGIN".equals(intent.getAction()) && intent.hasExtra("plusReport")) {
                Bundle bundleExtra = intent.getBundleExtra("plusReport");
                if (bundleExtra == null) {
                    e.b(f15544a, "plusReport not found in intent");
                    return;
                }
                int i = bundleExtra.getInt("plusType");
                int i2 = bundleExtra.getInt("operType");
                e.a(f15544a, "receive plugin broadcast, plusType:" + i + ",operType:" + i2);
                if (1 == i2) {
                    long j = bundleExtra.getLong(JoinConstants.CYCLE);
                    new PushPlugins(context).reportPlus(i, bundleExtra.getString("content"), j);
                }
            }
        } catch (Throwable e) {
            e.c(f15544a, e.getMessage(), e);
        }
    }
}
