package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1832c;

/* compiled from: PeroidActivity */
class fk extends Handler {
    final /* synthetic */ PeroidActivity f6121a;

    fk(PeroidActivity peroidActivity) {
        this.f6121a = peroidActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message == null) {
            C2538c.m12674b("PeroidActivity", "message is  null");
        } else if (this.f6121a.isFinishing()) {
            C2538c.m12680e("PeroidActivity", "=============PeroidActivity is  finish. so return");
        } else {
            switch (message.what) {
                case 5:
                    C1832c c1832c = (C1832c) message.obj;
                    AlarmItem alarmItem = c1832c.f5262e;
                    if ("1".equals(alarmItem.isActive)) {
                        this.f6121a.m9474a(alarmItem, 2, c1832c.f5261d);
                        return;
                    } else {
                        this.f6121a.m9474a(alarmItem, 1, c1832c.f5261d);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
