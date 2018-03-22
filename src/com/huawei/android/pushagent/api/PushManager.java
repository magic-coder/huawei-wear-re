package com.huawei.android.pushagent.api;

import android.content.Context;
import com.huawei.android.pushagent.PushReceiver;

public class PushManager extends com.huawei.android.pushagent.PushManager {
    public static void requestPushState(Context context) {
        PushReceiver.getPushState(context);
    }

    public static void requestToken(Context context) {
        PushReceiver.getToken(context);
    }
}
