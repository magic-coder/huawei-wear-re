package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1832c;

/* compiled from: AlarmActivity */
class ax extends Handler {
    final /* synthetic */ AlarmActivity f5948a;

    ax(AlarmActivity alarmActivity) {
        this.f5948a = alarmActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message == null) {
            C2538c.m12674b("AlarmActivity", "message is  null");
        } else if (this.f5948a.isFinishing()) {
            C2538c.m12680e("AlarmActivity", "=============AlarmActivity is  finish. so return");
        } else {
            switch (message.what) {
                case 5:
                    C1832c c1832c = (C1832c) message.obj;
                    AlarmItem alarmItem = c1832c.f5262e;
                    if ("1".equals(alarmItem.isActive)) {
                        this.f5948a.m9114a(alarmItem, 2, c1832c.f5261d);
                        return;
                    } else {
                        this.f5948a.m9114a(alarmItem, 1, c1832c.f5261d);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
