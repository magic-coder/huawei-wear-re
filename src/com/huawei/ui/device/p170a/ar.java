package com.huawei.ui.device.p170a;

import android.content.Context;
import com.huawei.hwappdfxmgr.a;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager;
import com.huawei.p190v.C2538c;

/* compiled from: UploadMaintLogInteractor */
public class ar {
    private a f6898a;
    private HWDeviceDFXManager f6899b;

    public ar(Context context) {
        this.f6898a = a.a(context);
        this.f6899b = HWDeviceDFXManager.getInstance(context);
    }

    public void m10363a(boolean z) {
        C2538c.m12674b("UploadMaintLogInteractor", "startUploadLogFile()");
        this.f6898a.a(z);
    }

    public void m10362a(IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback) {
        C2538c.m12674b("UploadMaintLogInteractor", "getMaintenanceFile()");
        this.f6899b.getMaintenanceFile(0, iDeviceDFXBaseResponseCallback);
    }
}
