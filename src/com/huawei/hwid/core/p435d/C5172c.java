package com.huawei.hwid.core.p435d;

import android.content.Context;
import android.content.Intent;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: BroadcastUtil */
public class C5172c {
    public static void m24989a(Context context, Intent intent) {
        if (intent != null && context != null) {
            intent.setAction(HwAccountConstants.ACTION_LOGIN_SUCCESS);
            C5165e.m24912e("BroadcastUtil", "sendLoginSuccessBroadcast-->context = " + context.getClass().getName() + ", intent ");
            context.sendBroadcast(intent);
        }
    }

    public static void m24990b(Context context, Intent intent) {
        if (intent != null && context != null) {
            intent.setAction(HwAccountConstants.ACTION_LOGIN_FAILED);
            C5165e.m24912e("BroadcastUtil", "sendLoginFailedBroadcast-->context = " + context.getClass().getName());
            context.sendBroadcast(intent);
        }
    }
}
