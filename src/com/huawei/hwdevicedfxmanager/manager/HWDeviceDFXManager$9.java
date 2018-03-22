package com.huawei.hwdevicedfxmanager.manager;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.p190v.C2538c;

class HWDeviceDFXManager$9 implements IBaseResponseCallback {
    final /* synthetic */ HWDeviceDFXManager this$0;

    HWDeviceDFXManager$9(HWDeviceDFXManager hWDeviceDFXManager) {
        this.this$0 = hWDeviceDFXManager;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("HWDeviceDFXManager", new Object[]{"mFirmwareVersionCallback err_code = " + i + ",objData:" + obj});
        if (HWDeviceDFXManager.access$1000(this.this$0) != null) {
            HWDeviceDFXManager.access$1000(this.this$0).removeMessages(100);
        }
        if (i == 0) {
            HWDeviceDFXManager.access$500(this.this$0, (DataDeviceInfo) obj, HWDeviceDFXManager.access$1100(this.this$0));
            return;
        }
        HWDeviceDFXManager.access$802(this.this$0, false);
        if (HWDeviceDFXManager.access$900(this.this$0) != null) {
            IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback = (IDeviceDFXBaseResponseCallback) HWDeviceDFXManager.access$900(this.this$0).get();
            if (iDeviceDFXBaseResponseCallback != null) {
                iDeviceDFXBaseResponseCallback.onFailure(i, null);
                return;
            }
            C2538c.c("HWDeviceDFXManager", new Object[]{"mUIFirmwareVersionCallback() onFailure maintenanceCallback is null"});
            return;
        }
        C2538c.e("HWDeviceDFXManager", new Object[]{"onFailure null == mDFXResponseCallBack"});
    }
}
