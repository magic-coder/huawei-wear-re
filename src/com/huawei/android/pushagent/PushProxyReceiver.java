package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p027c.C4113a;

public class PushProxyReceiver extends PushEventReceiver {
    private static String f15333a = "PushLogAC2712";

    public void onReceive(Context context, Intent intent) {
        if (C4113a.m20142a(context)) {
            super.onReceive(context, intent);
        } else {
            e.a(f15333a, "app push is closed, need not to process intent");
        }
    }
}
