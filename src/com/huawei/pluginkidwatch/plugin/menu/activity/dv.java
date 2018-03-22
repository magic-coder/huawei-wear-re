package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;

/* compiled from: ElectronicFenceActivity */
class dv extends Handler {
    final /* synthetic */ ElectronicFenceActivity f6056a;

    dv(ElectronicFenceActivity electronicFenceActivity) {
        this.f6056a = electronicFenceActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message == null) {
            C2538c.m12674b("ElectronicFenceActivity", "message is  null");
        } else if (this.f6056a.isFinishing()) {
            C2538c.m12680e("ElectronicFenceActivity", "activity is  finishing");
        } else {
            switch (message.what) {
                case 5:
                    FenceItem fenceItem = (FenceItem) message.obj;
                    if (fenceItem.ismIsOn()) {
                        this.f6056a.m9346a(fenceItem, 1);
                        return;
                    } else {
                        this.f6056a.m9346a(fenceItem, 2);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
