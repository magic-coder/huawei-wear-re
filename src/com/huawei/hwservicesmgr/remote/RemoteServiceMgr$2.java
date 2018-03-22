package com.huawei.hwservicesmgr.remote;

import com.huawei.hihealth.data.p312b.C4553g;
import com.huawei.p190v.C2538c;

class RemoteServiceMgr$2 implements C4553g {
    final /* synthetic */ RemoteServiceMgr this$0;

    RemoteServiceMgr$2(RemoteServiceMgr remoteServiceMgr) {
        this.this$0 = remoteServiceMgr;
    }

    public void onResult(boolean z) {
        C2538c.c("RemoteServiceMgr", new Object[]{"mHiUnSubscribeListener onResult result = " + z});
    }
}
