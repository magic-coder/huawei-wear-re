package com.huawei.ui.device.activity.device;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;

/* compiled from: DeviceManagerListActivity */
class C2038i implements OnClickListener {
    final /* synthetic */ DeviceManagerListActivity f7144a;

    C2038i(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7144a = deviceManagerListActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DeviceManagerListActivity", "tipListener onClick");
        C0996a.m3611a(this.f7144a.f7114c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "key_device_list_delete_tips", "true", null);
        this.f7144a.f7126p.setVisibility(8);
    }
}
