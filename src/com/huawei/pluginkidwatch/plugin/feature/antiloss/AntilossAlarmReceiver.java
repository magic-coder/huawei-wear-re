package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;

public class AntilossAlarmReceiver extends BroadcastReceiver {
    private Context f4908a;

    @SuppressLint({"NewApi"})
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C2538c.m12680e("AntilossAlarmReceiver", "onReceive(): intent is null!");
            return;
        }
        String action = intent.getAction();
        this.f4908a = context;
        C2538c.m12674b("AntilossAlarmReceiver", "action = " + action);
        C1773a.m8552a(this.f4908a).m8563g();
        if ("antiloss.popup.dialog.activity.destory.action".equals(action) || "cancel.antiloss.alarm".equals(action) || "antiloss.alarm.timeout".equals(action)) {
            if (C1773a.m8552a(this.f4908a) != null) {
                C1773a.m8552a(this.f4908a).m8561e();
            }
            C1495o.m6928a(context, 7);
            C1773a.m8552a(this.f4908a).m8557c();
            if ("antiloss.popup.dialog.activity.destory.action".equals(action)) {
                C2538c.m12674b("AntilossAlarmReceiver", "=========Not Close PDR 3");
            } else if ("cancel.antiloss.alarm".equals(action)) {
                C1773a.m8552a(this.f4908a).m8555a(this.f4908a, "com.huawei.pluginkidwatch.home.HomeActivity", null);
            }
        }
        if ("radar.antiloss.alarm".equals(action)) {
            C1773a.m8552a(this.f4908a).m8557c();
            C1495o.m6928a(context, 7);
        }
    }
}
