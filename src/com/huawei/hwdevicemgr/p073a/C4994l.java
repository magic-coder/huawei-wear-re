package com.huawei.hwdevicemgr.p073a;

import com.huawei.hwdevicemgr.dmsdatatype.p074a.C4992a;
import com.huawei.p190v.C2538c;

/* compiled from: OTATransferFile */
class C4994l implements C4992a {
    final /* synthetic */ C4991j f18113a;

    C4994l(C4991j c4991j) {
        this.f18113a = c4991j;
    }

    public void mo4604a(Object obj) {
        if (this.f18113a.f18097l.size() <= 0) {
            this.f18113a.m23940a(this.f18113a.f18098m + 1, false);
        } else if (1 == this.f18113a.f18097l.size()) {
            this.f18113a.m23940a(((Integer) this.f18113a.f18097l.get(0)).intValue(), true);
            this.f18113a.f18097l.remove(0);
        } else {
            C2538c.e("OTATransferFile", new Object[]{"mIsStartOtaCallback,mErrorPackages.size != 0 , mErrorPackages.size= " + this.f18113a.f18097l.size()});
            int intValue = ((Integer) this.f18113a.f18097l.get(0)).intValue();
            this.f18113a.f18097l.remove(0);
            this.f18113a.m23940a(intValue, false);
        }
    }

    public void mo4603a(int i, String str) {
        if (this.f18113a.f18096k && this.f18113a.f18104s != null) {
            this.f18113a.f18104s.a(i, str);
            this.f18113a.f18095j = 0;
            this.f18113a.f18096k = false;
        }
    }
}
