package com.huawei.ui.device.p170a;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiGoldMemberInteractors */
class aa implements IBaseResponseCallback {
    final /* synthetic */ C1998z f6856a;

    aa(C1998z c1998z) {
        this.f6856a = c1998z;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("HuaweiGoldMemberInteractors", "mGetFirmwareVersionCallback回来了: err_code = " + i + ",objData = " + obj);
        this.f6856a.f6969c = (DataDeviceInfo) obj;
        if (this.f6856a.f6969c != null) {
            C2538c.m12677c("HuaweiGoldMemberInteractors", "mGetFirmwareVersionCallback:" + this.f6856a.f6969c.toString());
            this.f6856a.m10467b(this.f6856a.f6969c.getDevice_sn());
            this.f6856a.m10465a(this.f6856a.f6969c.getDevice_emmc_id());
            return;
        }
        C2538c.m12677c("HuaweiGoldMemberInteractors", "mDataDeviceInfo is null!");
    }
}
