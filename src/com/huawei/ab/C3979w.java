package com.huawei.ab;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.userprofile.GetPrivacyRecordRsp;
import com.huawei.hwcloudmodel.model.userprofile.PrivacyRecord;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;

import java.util.List;

/* compiled from: UserProfileUtil */
final class C3979w implements C3957a<GetPrivacyRecordRsp> {
    final /* synthetic */ C4694a f15221a;

    C3979w(C4694a c4694a) {
        this.f15221a = c4694a;
    }

    public void m19712a(GetPrivacyRecordRsp getPrivacyRecordRsp, String str, boolean z) {
        C2538c.c("UserProfileUtil", new Object[]{"downloadUserPrivacy result is " + z});
        if (z) {
            List<PrivacyRecord> privacyRecords = getPrivacyRecordRsp.getPrivacyRecords();
            if (privacyRecords != null) {
                for (PrivacyRecord privacyRecord : privacyRecords) {
                    if (1 != privacyRecord.getPrivacyId().intValue() || TextUtils.isEmpty(C3978v.m19708c("cloud_user_privacy" + privacyRecord.getPrivacyId()))) {
                        boolean z2;
                        String str2 = "cloud_user_privacy" + privacyRecord.getPrivacyId();
                        if (privacyRecord.getOpinion().intValue() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        C3978v.m19702b(str2, String.valueOf(z2), null);
                        C3978v.m19707b(true);
                    }
                }
            }
            if (this.f15221a != null) {
                this.f15221a.mo4558a(new Bundle());
                return;
            }
            return;
        }
        C2538c.c("UserProfileUtil", new Object[]{"getPrivacyRecord fail " + str});
        if (this.f15221a != null) {
            this.f15221a.mo4557a(-1);
        }
    }
}
