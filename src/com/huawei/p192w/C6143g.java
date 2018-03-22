package com.huawei.p192w;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.w.c;

/* compiled from: HWMultiSimMgr */
class C6143g implements IBaseResponseCallback {
    final /* synthetic */ c f21193a;

    C6143g(c cVar) {
        this.f21193a = cVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWMultiSimMgr", new Object[]{" getLocalDeviceInfo  onResponse errCode", Integer.valueOf(i)});
        if (i == 0 && obj != null && (obj instanceof MultiSimDeviceInfo)) {
            this.f21193a.b = true;
            this.f21193a.a = (MultiSimDeviceInfo) obj;
            C2538c.c("HWMultiSimMgr", new Object[]{" getLocalDeviceInfo "});
            C2538c.c("HWMultiSimMgr", new Object[]{" type ", Integer.valueOf(this.f21193a.a.getDeviceType())});
            C2538c.c("HWMultiSimMgr", new Object[]{" name ", this.f21193a.a.getProductName()});
            C2538c.c("HWMultiSimMgr", new Object[]{" imie ", this.f21193a.a.getDeviceIMEI()});
            C2538c.c("HWMultiSimMgr", new Object[]{" sn ", this.f21193a.a.getDeviceSerialNumber()});
            C2538c.c("HWMultiSimMgr", new Object[]{" simInfo ", this.f21193a.a.getActiveSimProfileInfo()});
            if (this.f21193a.a.getActiveSimProfileInfo() != null) {
                C2538c.c("HWMultiSimMgr", new Object[]{" imsi ", this.f21193a.a.getActiveSimProfileInfo().getIMSI()});
                C2538c.c("HWMultiSimMgr", new Object[]{" iccid ", this.f21193a.a.getActiveSimProfileInfo().getICCID()});
            }
            this.f21193a.a = (MultiSimDeviceInfo) obj;
            if (this.f21193a.d != null) {
                this.f21193a.d.sendToTarget();
            }
        }
    }
}
