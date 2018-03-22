package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: AntilossPopupDialogActivity */
class C1803u extends BroadcastReceiver {
    final /* synthetic */ AntilossPopupDialogActivity f4965a;

    C1803u(AntilossPopupDialogActivity antilossPopupDialogActivity) {
        this.f4965a = antilossPopupDialogActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("AntilossPopupDialogActivity", "==========Enter PouDialogActivityReceiver ");
        if (!this.f4965a.isFinishing()) {
            if ("antiloss.popup.dialog.activity.destory.action".equals(intent.getAction())) {
                C2538c.m12674b("AntilossPopupDialogActivity", "========AntilossUtils.ANTILOSS_POPUP_DESTORY_ACTION");
                this.f4965a.finish();
            }
        }
    }
}
