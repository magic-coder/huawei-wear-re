package com.huawei.hwcloudmodel.p061c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p404b.C4694a;
import com.huawei.up.p517a.C6108a;

/* compiled from: HWCloudUtils */
class C4695h implements C4694a {
    final /* synthetic */ UserInfomation f17127a;
    final /* synthetic */ C6108a f17128b;
    final /* synthetic */ Context f17129c;
    final /* synthetic */ C3957a f17130d;
    final /* synthetic */ C4689d f17131e;

    C4695h(C4689d c4689d, UserInfomation userInfomation, C6108a c6108a, Context context, C3957a c3957a) {
        this.f17131e = c4689d;
        this.f17127a = userInfomation;
        this.f17128b = c6108a;
        this.f17129c = context;
        this.f17130d = c3957a;
    }

    public void mo4558a(Bundle bundle) {
        C2538c.c("HWCloudUtils", new Object[]{"updateUserInfo onSuccess"});
        if (TextUtils.isEmpty(this.f17127a.getPicPath())) {
            C2538c.c("HWCloudUtils", new Object[]{"updateHeadPicture no need to updateHeadPicture"});
            this.f17130d.mo4330a(null, null, true);
            return;
        }
        C2538c.c("HWCloudUtils", new Object[]{"call updateHeadPicture"});
        this.f17128b.m27879a(this.f17129c, this.f17127a.getPicPath(), new C4696i(this));
    }

    public void mo4557a(int i) {
        C2538c.c("HWCloudUtils", new Object[]{"updateUserInfo onFail " + i});
        this.f17130d.mo4330a(null, "updateUserInfo onFail " + i, false);
    }
}
