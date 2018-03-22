package com.huawei.ui.device.activity.device;

import com.huawei.hwbasemgr.b;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.device.i;

/* compiled from: DeviceManagerListActivity */
class C2045o implements Runnable {
    final /* synthetic */ C2041k f7151a;

    C2045o(C2041k c2041k) {
        this.f7151a = c2041k;
    }

    public void run() {
        this.f7151a.f7147b.f7121j.setVisibility(8);
        if (this.f7151a.f7147b.f7116e.size() > 0) {
            if ("true".equals(C0996a.m3612a(this.f7151a.f7147b.f7114c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "key_device_list_delete_tips"))) {
                this.f7151a.f7147b.f7126p.setVisibility(8);
                return;
            }
            this.f7151a.f7147b.f7126p.setVisibility(0);
            if (b.a(this.f7151a.f7147b.f7114c)) {
                this.f7151a.f7147b.f7127q.setText(this.f7151a.f7147b.f7114c.getResources().getString(i.IDS_device_list_right_tips));
                return;
            } else {
                this.f7151a.f7147b.f7127q.setText(this.f7151a.f7147b.f7114c.getResources().getString(i.IDS_device_list_left_tips));
                return;
            }
        }
        this.f7151a.f7147b.f7126p.setVisibility(8);
    }
}
