package com.huawei.hwservicesmgr.remote;

import com.huawei.p190v.C2538c;

class RemoteServiceMgr$6 implements Runnable {
    final /* synthetic */ RemoteServiceMgr this$0;

    RemoteServiceMgr$6(RemoteServiceMgr remoteServiceMgr) {
        this.this$0 = remoteServiceMgr;
    }

    public void run() {
        if (RemoteServiceMgr.access$1900(this.this$0)) {
            RemoteServiceMgr.access$2000(this.this$0);
            if (RemoteServiceMgr.access$100() == null) {
                RemoteServiceMgr.access$2200(this.this$0).postDelayed(this, RemoteServiceMgr.access$2100(this.this$0));
                return;
            } else {
                RemoteServiceMgr.access$2302(this.this$0, 1000);
                return;
            }
        }
        C2538c.e("RemoteServiceMgr", new Object[]{"can't find health app, uninstalled?"});
    }
}
