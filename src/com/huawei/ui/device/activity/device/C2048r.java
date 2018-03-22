package com.huawei.ui.device.activity.device;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: DeviceManagerListActivity */
class C2048r extends Handler {
    WeakReference<DeviceManagerListActivity> f7155a;
    final /* synthetic */ DeviceManagerListActivity f7156b;

    C2048r(DeviceManagerListActivity deviceManagerListActivity, DeviceManagerListActivity deviceManagerListActivity2) {
        this.f7156b = deviceManagerListActivity;
        this.f7155a = new WeakReference(deviceManagerListActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((DeviceManagerListActivity) this.f7155a.get()) != null) {
            C2538c.m12677c("DeviceManagerListActivity", "Enter handleMessage():" + message.what);
            switch (message.what) {
                case 1:
                    C2538c.m12677c("DeviceManagerListActivity", "case REFRESH_ONE_ITEM_INFO");
                    this.f7156b.m10630b(message.arg1);
                    this.f7156b.m10646h();
                    return;
                case 2:
                    C2538c.m12677c("DeviceManagerListActivity", "case REFRESH_LIST_VIEW");
                    this.f7156b.m10627a(true);
                    return;
                case 3:
                    C2538c.m12677c("DeviceManagerListActivity", "case SHOW_DELETE_REMINDER_DIALOG");
                    DeviceManagerListActivity.f7111v.execute(new C2049s(this, message.obj));
                    c.a().a(BaseApplication.m2632b(), a.dg.a(), new HashMap(), 0);
                    return;
                case 4:
                    C2538c.m12677c("DeviceManagerListActivity", "case DISMISS_DATA_SYNCHNIZING_DIALOG");
                    this.f7156b.m10644g();
                    return;
                default:
                    return;
            }
        }
    }
}
