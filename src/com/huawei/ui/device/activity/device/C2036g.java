package com.huawei.ui.device.activity.device;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import java.util.HashMap;

/* compiled from: DeviceManagerListActivity */
class C2036g implements OnClickListener {
    final /* synthetic */ DeviceManagerListActivity f7142a;

    C2036g(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7142a = deviceManagerListActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DeviceManagerListActivity", "onClick,add new device mConnectting = " + this.f7142a.f7130t + ",synchronizing = " + C0996a.m3612a(this.f7142a.f7114c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG"));
        if (this.f7142a.f7130t) {
            this.f7142a.m10637d();
        } else if ("true".equals(r0)) {
            this.f7142a.m10643f();
        } else {
            this.f7142a.m10655l();
        }
        c.a().a(BaseApplication.m2632b(), a.df.a(), new HashMap(), 0);
    }
}
