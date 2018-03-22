package com.huawei.bone.root;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoRsp;
import com.huawei.hwcloudmodel.model.userprofile.UserMergeInfo;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.c.be;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: MainActivity */
class C6783b implements a<GetUserMergeInfoRsp> {
    final /* synthetic */ MainActivity f23321a;

    C6783b(MainActivity mainActivity) {
        this.f23321a = mainActivity;
    }

    public void m30209a(GetUserMergeInfoRsp getUserMergeInfoRsp, String str, boolean z) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"getUserMergeInfo  isSuccess:" + z});
        if (z && getUserMergeInfoRsp != null) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"processPushMsg  Error PushMsg is Empty"});
            List<UserMergeInfo> userMergeInfos = getUserMergeInfoRsp.getUserMergeInfos();
            if (userMergeInfos != null) {
                for (UserMergeInfo userMergeInfo : userMergeInfos) {
                    C2538c.a("MainUI", 0, "MainActivity", new Object[]{"processPushMsg  info:" + userMergeInfo.toString()});
                    String originalHuid = userMergeInfo.getOriginalHuid();
                    String c = com.huawei.login.ui.login.a.a(this.f23321a.f23220k).c();
                    switch (userMergeInfo.getStatus().intValue()) {
                        case 0:
                            c.a("MainUI", 0, "MainActivity", new Object[]{"Enter not begin"});
                            break;
                        case 1:
                            be.a().c(originalHuid, c);
                            break;
                        case 2:
                            c.a("MainUI", 0, "MainActivity", new Object[]{"Enter default"});
                            Bundle bundle = new Bundle();
                            bundle.putLong("error_code", -1);
                            c.a(907127009, "MainActivity", bundle, false, new Object[]{"cloud migrate failure.originalHuid:" + originalHuid + " currentHuid:" + c});
                            be.a().a(originalHuid, c);
                            break;
                        default:
                            c.a("MainUI", 0, "MainActivity", new Object[]{"Enter default"});
                            break;
                    }
                }
                Intent intent = new Intent();
                intent.setAction("com.huawei.migrate.action.migrate.success");
                if (LocalBroadcastManager.getInstance(BaseApplication.b()) != null) {
                    LocalBroadcastManager.getInstance(BaseApplication.b()).sendBroadcast(intent);
                    return;
                }
                return;
            }
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"userMergeInfoList is null"});
        }
    }
}
