package com.huawei.hwservicesmgr;

import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.pluginmessagecenter.service.MessageObserver;

/* compiled from: PhoneService */
class C1061v implements Runnable {
    final /* synthetic */ PhoneService f2082a;

    C1061v(PhoneService phoneService) {
        this.f2082a = phoneService;
    }

    public void run() {
        C0996a.m3611a(this.f2082a, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG", "false", null);
    }
}
