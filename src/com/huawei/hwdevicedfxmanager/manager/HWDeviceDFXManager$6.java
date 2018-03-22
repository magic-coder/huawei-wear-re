package com.huawei.hwdevicedfxmanager.manager;

import android.os.RemoteException;
import com.huawei.hwservicesmgr.s;
import com.huawei.p190v.C2538c;

class HWDeviceDFXManager$6 extends s {
    final /* synthetic */ HWDeviceDFXManager this$0;

    HWDeviceDFXManager$6(HWDeviceDFXManager hWDeviceDFXManager) {
        this.this$0 = hWDeviceDFXManager;
    }

    public void onSuccess(int i, String str, String str2) throws RemoteException {
        C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferSleepAndDFXFileCallback() onSuccess "});
        this.this$0.setMaintRetryResult(true);
        if (HWDeviceDFXManager.access$600(this.this$0) != null) {
            HWDeviceDFXManager.access$600(this.this$0).onSuccess(i, "");
            return;
        }
        C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferSleepAndDFXFileCallback() onSuccess maintenanceCallback is null"});
    }

    public void onFailure(int i, String str) throws RemoteException {
        C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferSleepAndDFXFileCallback() onFailure err_msg = " + str});
        if (HWDeviceDFXManager.access$600(this.this$0) != null) {
            HWDeviceDFXManager.access$600(this.this$0).onFailure(i, str);
            return;
        }
        C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferSleepAndDFXFileCallback() onFailure maintenanceCallback is null"});
    }
}
