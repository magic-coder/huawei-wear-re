package com.huawei.hwdevicedfxmanager.manager;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

class HWDeviceDFXManager$4 implements IBaseResponseCallback {
    final /* synthetic */ HWDeviceDFXManager this$0;

    HWDeviceDFXManager$4(HWDeviceDFXManager hWDeviceDFXManager) {
        this.this$0 = hWDeviceDFXManager;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("HWDeviceDFXManager", new Object[]{"getCrowdFirmwareVersion err_code = " + i});
        if (i == 0) {
            DataDeviceInfo dataDeviceInfo = (DataDeviceInfo) obj;
            if (dataDeviceInfo != null) {
                HWDeviceDFXManager.access$202(this.this$0, dataDeviceInfo.getDevice_soft_version());
                C2538c.b("HWDeviceDFXManager", new Object[]{"getCrowdFirmwareVersion deviceVersion = " + HWDeviceDFXManager.access$200(this.this$0)});
                HWDeviceDFXManager.access$300(this.this$0);
            }
        }
    }
}
