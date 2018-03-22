package com.huawei.hwdevicedfxmanager.manager;

import android.os.RemoteException;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.hwservicesmgr.s;
import com.huawei.p190v.C2538c;

class HWDeviceDFXManager$8 extends s {
    final /* synthetic */ HWDeviceDFXManager this$0;

    HWDeviceDFXManager$8(HWDeviceDFXManager hWDeviceDFXManager) {
        this.this$0 = hWDeviceDFXManager;
    }

    public void onSuccess(int i, String str, String str2) throws RemoteException {
        C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferDFXFileUICallback() onSuccess "});
        HWDeviceDFXManager.access$802(this.this$0, false);
        this.this$0.setMaintRetryResult(true);
        if (HWDeviceDFXManager.access$900(this.this$0) != null) {
            IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback = (IDeviceDFXBaseResponseCallback) HWDeviceDFXManager.access$900(this.this$0).get();
            if (iDeviceDFXBaseResponseCallback != null) {
                iDeviceDFXBaseResponseCallback.onSuccess(i, "");
                return;
            }
            C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferDFXFileUICallback() onSuccess maintenanceCallback is null"});
            return;
        }
        C2538c.e("HWDeviceDFXManager", new Object[]{"onSuccess null == mDFXResponseCallBack"});
    }

    public void onFailure(int i, String str) throws RemoteException {
        C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferSleepAndDFXFileCallback() onFailure err_msg = " + str});
        HWDeviceDFXManager.access$802(this.this$0, false);
        if (HWDeviceDFXManager.access$900(this.this$0) != null) {
            IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback = (IDeviceDFXBaseResponseCallback) HWDeviceDFXManager.access$900(this.this$0).get();
            if (iDeviceDFXBaseResponseCallback != null) {
                iDeviceDFXBaseResponseCallback.onFailure(i, str);
                return;
            }
            C2538c.c("HWDeviceDFXManager", new Object[]{"dfxITransferSleepAndDFXFileCallback() onFailure maintenanceCallback is null"});
            return;
        }
        C2538c.e("HWDeviceDFXManager", new Object[]{"onFailure null == mDFXResponseCallBack"});
    }
}
