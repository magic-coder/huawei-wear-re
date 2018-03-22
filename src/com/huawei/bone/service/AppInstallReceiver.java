package com.huawei.bone.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;

public class AppInstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String packageName = context.getPackageName();
        C2538c.c("AppInstallReceiver", new Object[]{"curPkgName = " + packageName});
        if (intent != null && "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) {
            if ("com.huawei.bone".equals(intent.getData().getSchemeSpecificPart())) {
                a.a(context, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG", "false", null);
            }
        }
    }
}
