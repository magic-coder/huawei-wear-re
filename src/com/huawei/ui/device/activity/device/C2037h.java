package com.huawei.ui.device.activity.device;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;

/* compiled from: DeviceManagerListActivity */
class C2037h implements OnClickListener {
    final /* synthetic */ DeviceManagerListActivity f7143a;

    C2037h(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7143a = deviceManagerListActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DeviceManagerListActivity", "onClick,add new device mConnectting = " + this.f7143a.f7130t + ",synchronizing = " + C0996a.m3612a(this.f7143a.f7114c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG"));
        if (this.f7143a.f7130t) {
            this.f7143a.m10637d();
        } else if ("true".equals(r0)) {
            this.f7143a.m10643f();
        } else {
            this.f7143a.m10655l();
        }
    }
}
