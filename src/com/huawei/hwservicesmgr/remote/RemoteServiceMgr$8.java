package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.g;
import com.huawei.p190v.C2538c;

class RemoteServiceMgr$8 implements IBaseResponseCallback {
    final /* synthetic */ RemoteServiceMgr this$0;
    final /* synthetic */ g val$callback;

    RemoteServiceMgr$8(RemoteServiceMgr remoteServiceMgr, g gVar) {
        this.this$0 = remoteServiceMgr;
        this.val$callback = gVar;
    }

    public void onResponse(int i, Object obj) {
        try {
            this.val$callback.a(i);
        } catch (Exception e) {
            C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
        }
    }
}
