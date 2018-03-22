package com.huawei.hwdevicedfxmanager.manager;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

class HWDeviceDFXManager$5 implements IBaseResponseCallback {
    final /* synthetic */ HWDeviceDFXManager this$0;

    HWDeviceDFXManager$5(HWDeviceDFXManager hWDeviceDFXManager) {
        this.this$0 = hWDeviceDFXManager;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("HWDeviceDFXManager", new Object[]{"mFirmwareVersionCallback err_code = " + i + ",objData:" + obj});
        if (i == 0) {
            HWDeviceDFXManager.access$500(this.this$0, (DataDeviceInfo) obj, HWDeviceDFXManager.access$400(this.this$0));
        }
    }
}
