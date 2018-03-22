package com.huawei.hwcloudmodel.p061c;

import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;
import com.unionpay.tsmservice.data.Constant;

/* compiled from: HWCloudUtils */
class C4696i implements C4694a {
    final /* synthetic */ C4695h f17132a;

    C4696i(C4695h c4695h) {
        this.f17132a = c4695h;
    }

    public void mo4558a(Bundle bundle) {
        C2538c.c("HWCloudUtils", new Object[]{"updateHeadPicture onSuccess"});
        if (bundle == null) {
            C2538c.c("HWCloudUtils", new Object[]{"updateHeadPicture bundle is null"});
            this.f17132a.f17130d.mo4330a(null, "bundle is null", false);
        } else if ("upLoadPhoto".equals(bundle.getString(Constant.KEY_METHOD, ""))) {
            C2538c.c("HWCloudUtils", new Object[]{"updateHeadPicture new url = " + bundle.getString("fileUrlB")});
            this.f17132a.f17130d.mo4330a(null, r0, true);
        } else {
            C2538c.c("HWCloudUtils", new Object[]{"updateHeadPicture bundle is not right"});
            this.f17132a.f17130d.mo4330a(null, "updateHeadPicture bundle is not right", false);
        }
    }

    public void mo4557a(int i) {
        C2538c.c("HWCloudUtils", new Object[]{"updateHeadPicture onFail " + i});
        this.f17132a.f17130d.mo4330a(null, "updateHeadPicture onFail " + i, false);
    }
}
