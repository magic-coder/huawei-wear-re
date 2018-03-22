package com.huawei.multisimsdk.p096a.p097a;

import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.multisimservice.model.SimInfo;
import java.util.List;

/* compiled from: AttachedDeviceMgrCommonResult */
public class C1116b {
    private int f2361a = -1;
    private int f2362b = 2;
    private MultiSimDeviceInfo f2363c = null;
    private List<SimInfo> f2364d = null;

    public C1116b(int i, MultiSimDeviceInfo multiSimDeviceInfo) {
        this.f2361a = i;
        this.f2363c = multiSimDeviceInfo;
        if (multiSimDeviceInfo == null) {
            C1183h.m5286d("AttachedDeviceMgrCommonResult", "multiSimDeviceInfo is null");
            this.f2362b = -6;
            return;
        }
        this.f2362b = multiSimDeviceInfo.getResultCode();
    }
}
