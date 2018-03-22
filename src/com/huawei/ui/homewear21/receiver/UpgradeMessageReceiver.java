package com.huawei.ui.homewear21.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.ah;

public class UpgradeMessageReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("UpgradeMessageReceiver", " == UpgradeMessageReceiver enter ");
        if (intent == null || context == null) {
            C2538c.m12677c("UpgradeMessageReceiver", " == UpgradeMessageReceiver null == intent  return!");
            return;
        }
        String action = intent.getAction();
        if (action != null) {
            C2538c.m12677c("UpgradeMessageReceiver", " == UpgradeMessageReceiver action = " + action);
            Intent intent2;
            if (action.equals("com.huawei.dbhelper.database.upgrade")) {
                C2538c.m12677c("UpgradeMessageReceiver", " == UpgradeMessageReceiver startService UpgradeDBWorkerService!a");
                intent2 = new Intent(context, UpgradeDBWorkerService.class);
                intent2.setAction("com.huawei.upgrade.start.Upgrade.Service");
                Bundle bundle = new Bundle();
                bundle.putInt("BUNDLE_WORK_TASK_UPGRADE", 1);
                intent2.putExtras(bundle);
                context.startService(intent2);
            } else if (action.equals("com.huawei.bone.action.UPDATE_DEVICE")) {
                C2538c.m12677c("UpgradeMessageReceiver", " == UpgradeMessageReceiver startService UpdateDeviceService!a");
                intent2 = new Intent(context, UpdateDeviceService.class);
                intent2.setAction("com.huawei.update.device.version");
                context.startService(intent2);
            } else if (action.equals("com.huawei.delete.device.clearmessage")) {
                C2538c.m12677c("UpgradeMessageReceiver", " == UpgradeMessageReceiver enter clear message");
                ah.m10316a(context.getApplicationContext()).m10350q();
            }
        }
    }
}
