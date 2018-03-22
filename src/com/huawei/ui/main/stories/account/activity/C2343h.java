package com.huawei.ui.main.stories.account.activity;

import com.huawei.hwcloudmodel.callback.a;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataReq;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataRsp;
import com.huawei.p190v.C2538c;

/* compiled from: ThirdPartyLoginActivity */
class C2343h implements a<MergeUserAllDataRsp> {
    final /* synthetic */ String f8493a;
    final /* synthetic */ String f8494b;
    final /* synthetic */ MergeUserAllDataReq f8495c;
    final /* synthetic */ ThirdPartyLoginActivity f8496d;

    C2343h(ThirdPartyLoginActivity thirdPartyLoginActivity, String str, String str2, MergeUserAllDataReq mergeUserAllDataReq) {
        this.f8496d = thirdPartyLoginActivity;
        this.f8493a = str;
        this.f8494b = str2;
        this.f8495c = mergeUserAllDataReq;
    }

    public void m11920a(MergeUserAllDataRsp mergeUserAllDataRsp, String str, boolean z) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "accountmigrate: sendMigrageDataToCloud mergeUserAllData back");
        this.f8496d.m11892a(mergeUserAllDataRsp, str, this.f8493a, this.f8494b, this.f8495c);
    }
}
