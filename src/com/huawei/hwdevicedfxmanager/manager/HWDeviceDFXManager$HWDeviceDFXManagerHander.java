package com.huawei.hwdevicedfxmanager.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.p190v.C2538c;

class HWDeviceDFXManager$HWDeviceDFXManagerHander extends Handler {
    final /* synthetic */ HWDeviceDFXManager this$0;

    HWDeviceDFXManager$HWDeviceDFXManagerHander(HWDeviceDFXManager hWDeviceDFXManager, Looper looper) {
        this.this$0 = hWDeviceDFXManager;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.b("HWDeviceDFXManager", new Object[]{"handleMessage = " + message.what});
        switch (message.what) {
            case 100:
                HWDeviceDFXManager.access$802(this.this$0, false);
                if (HWDeviceDFXManager.access$900(this.this$0) != null) {
                    IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback = (IDeviceDFXBaseResponseCallback) HWDeviceDFXManager.access$900(this.this$0).get();
                    if (iDeviceDFXBaseResponseCallback != null) {
                        iDeviceDFXBaseResponseCallback.onFailure(1, "");
                        return;
                    }
                    C2538c.c("HWDeviceDFXManager", new Object[]{"mHandler() onFailure maintenanceCallback is null"});
                    return;
                }
                C2538c.e("HWDeviceDFXManager", new Object[]{"onFailure null == mDFXResponseCallBack"});
                return;
            default:
                return;
        }
    }
}
