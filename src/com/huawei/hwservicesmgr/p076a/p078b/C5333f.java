package com.huawei.hwservicesmgr.p076a.p078b;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.hwservicesmgr.datetype.C5363e;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskManager */
class C5333f implements IBaseResponseCallback {
    final /* synthetic */ d f19074a;

    C5333f(d dVar) {
        this.f19074a = dVar;
    }

    public void onResponse(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        if (bArr == null) {
            C2538c.c("HWFileTransferTaskManager", new Object[]{"applyWearAssetfileCallback onResponse info is null return!"});
            return;
        }
        C5363e c5363e = new C5363e();
        c5363e.m25833a(0);
        c5363e.m25834a(bArr);
        if (8 == bArr.length && TagName.ELECTRONIC_PUBLISH_START_TIME == bArr[2]) {
            C2538c.e("HWFileTransferTaskManager", new Object[]{"applyWearAssetfileCallback() onResponse error = " + C0973a.a(bArr)});
            return;
        }
        if (d.a(this.f19074a) != null) {
            d.a(this.f19074a).removeMessages(15);
        }
        d.a(this.f19074a, c5363e, 1);
    }
}
