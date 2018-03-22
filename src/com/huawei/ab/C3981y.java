package com.huawei.ab;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordRsp;

/* compiled from: UserProfileUtil */
final class C3981y implements C3957a<AddPrivacyRecordRsp> {
    final /* synthetic */ IBaseResponseCallback f15222a;
    final /* synthetic */ int f15223b;
    final /* synthetic */ boolean f15224c;
    final /* synthetic */ String f15225d;

    C3981y(IBaseResponseCallback iBaseResponseCallback, int i, boolean z, String str) {
        this.f15222a = iBaseResponseCallback;
        this.f15223b = i;
        this.f15224c = z;
        this.f15225d = str;
    }

    public void m19714a(AddPrivacyRecordRsp addPrivacyRecordRsp, String str, boolean z) {
        if (z) {
            if (this.f15222a != null && this.f15223b < 6) {
                this.f15222a.onResponse(0, null);
            }
            C3978v.m19702b("cloud_user_privacy_reupload" + this.f15223b, "", null);
            C3978v.m19702b("cloud_user_privacy_reupload_desp" + this.f15223b, "", null);
            return;
        }
        if (this.f15222a != null && this.f15223b < 6) {
            this.f15222a.onResponse(300099, null);
        }
        C3978v.m19702b("cloud_user_privacy_reupload" + this.f15223b, String.valueOf(this.f15224c), null);
        C3978v.m19702b("cloud_user_privacy_reupload_desp" + this.f15223b, this.f15225d, null);
    }
}
