package com.huawei.ui.homewear21.card.views;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: PariedDevicesSwitcher */
class C2263d extends Handler {
    final /* synthetic */ PariedDevicesSwitcher f8245a;

    C2263d(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f8245a = pariedDevicesSwitcher;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 5:
                C2538c.m12677c(PariedDevicesSwitcher.f8209b, "case SHOW_DELETE_REMINDER_DIALOG");
                Intent intent = new Intent();
                intent.setAction("parieddevicesswitcher_wait_dialog_broadcast");
                this.f8245a.f8227s.sendBroadcast(intent);
                break;
            default:
                C2538c.m12677c(PariedDevicesSwitcher.f8209b, "case default");
                break;
        }
        super.handleMessage(message);
    }
}
