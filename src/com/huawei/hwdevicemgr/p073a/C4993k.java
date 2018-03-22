package com.huawei.hwdevicemgr.p073a;

import com.huawei.hwcommonmodel.datatypes.C4738c;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C4992a;
import com.huawei.p190v.C2538c;

/* compiled from: OTATransferFile */
class C4993k implements C4992a {
    final /* synthetic */ C4991j f18112a;

    C4993k(C4991j c4991j) {
        this.f18112a = c4991j;
    }

    public void mo4604a(Object obj) {
        C2538c.c("OTATransferFile", new Object[]{"otaStatusCallback is onSuccess"});
        this.f18112a.m23942a((C4738c) obj);
    }

    public void mo4603a(int i, String str) {
        C2538c.c("OTATransferFile", new Object[]{"otaStatusCallback  onFailure, err_code = " + i});
        if (this.f18112a.f18096k && this.f18112a.f18104s != null) {
            this.f18112a.f18104s.a(i, str);
            this.f18112a.f18095j = 0;
            this.f18112a.f18096k = false;
        }
    }
}
