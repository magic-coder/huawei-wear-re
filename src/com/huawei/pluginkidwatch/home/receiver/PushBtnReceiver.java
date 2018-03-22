package com.huawei.pluginkidwatch.home.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1902s;

public class PushBtnReceiver extends BroadcastReceiver {
    private final String f4367a = "pushBtnBroadcast";

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                C2538c.m12674b("pushBtnBroadcast", "===pushBtnReceiver=onReceive==" + intent.getAction());
                String action = intent.getAction();
                int intExtra;
                C1401q c1401q;
                if ("com.huawei.push.confirmBind".equals(action)) {
                    intExtra = intent.getIntExtra("bind_db_id", -1);
                    c1401q = new C1401q();
                    c1401q.f3145a = intExtra;
                    C1392h.m6303c(context, c1401q);
                    c1401q.f3151g = intent.getIntExtra("bind_process_result", -1);
                    C2538c.m12674b("pushBtnBroadcast", "=====DBdata:" + c1401q.toString());
                    C1495o.m6928a(context, 0);
                    C1902s.m9683a(context, c1401q, new C1670b(this));
                } else if ("com.huawei.push.addContact".equals(action)) {
                    intExtra = intent.getIntExtra("add_db_id", -1);
                    c1401q = new C1401q();
                    c1401q.f3145a = intExtra;
                    C1392h.m6303c(context, c1401q);
                    c1401q.f3151g = intent.getIntExtra("add_process_result", -1);
                    C2538c.m12674b("pushBtnBroadcast", "=====DBdata:" + c1401q.toString());
                    C1495o.m6928a(context, 0);
                    C1902s.m9684b(context, c1401q, new C1671c(this));
                }
            } catch (Exception e) {
                C2538c.m12674b("pushBtnBroadcast", "===pushBtnReceiver=onReceive exception ==" + e.getMessage());
            }
        }
    }
}
