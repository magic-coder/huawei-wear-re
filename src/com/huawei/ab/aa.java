package com.huawei.ab;

import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordRsp;

/* compiled from: UserProfileUtil */
final class aa implements C3957a<AddPrivacyRecordRsp> {
    final /* synthetic */ int f15179a;

    aa(int i) {
        this.f15179a = i;
    }

    public void m19667a(AddPrivacyRecordRsp addPrivacyRecordRsp, String str, boolean z) {
        if (z) {
            C3978v.m19702b("cloud_user_privacy_reupload" + this.f15179a, "", null);
            C3978v.m19702b("cloud_user_privacy_reupload_desp" + this.f15179a, "", null);
        }
    }
}
