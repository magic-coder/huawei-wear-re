package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.p190v.C2538c;

class HWHeartRateManager$9 implements IBaseResponseCallback {
    final /* synthetic */ HWHeartRateManager this$0;

    HWHeartRateManager$9(HWHeartRateManager hWHeartRateManager) {
        this.this$0 = hWHeartRateManager;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWHeartRateManager", new Object[]{"stressAlgorithmCallback onResponse"});
        if (obj != null) {
            synchronized (HWHeartRateManager.access$100().getClass()) {
                if (HWHeartRateManager.access$100().size() != 0) {
                    C2538c.c("HWHeartRateManager", new Object[]{"stressAlgorithmCallback onResponse mDeviceStressCallbackList back,objdata = " + obj.toString()});
                    ((IBaseResponseCallback) HWHeartRateManager.access$100().get(0)).onResponse(100000, RemoteUtils.generateRetMap(obj, "notificationStressInfo"));
                }
            }
        }
    }
}
