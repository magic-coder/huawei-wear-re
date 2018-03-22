package com.huawei.ui.main.stories.messagecenter.interactors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoRsp;
import com.huawei.hwcloudmodel.model.userprofile.UserMergeInfo;
import com.huawei.hwdatamigrate.hihealth.p067c.be;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.a.g;
import java.util.List;

/* compiled from: AccountMigratePushReceiver */
class C2421d implements a<GetUserMergeInfoRsp> {
    final /* synthetic */ C2420c f8709a;

    C2421d(C2420c c2420c) {
        this.f8709a = c2420c;
    }

    public void m12164a(GetUserMergeInfoRsp getUserMergeInfoRsp, String str, boolean z) {
        g.c("AccountMigratePushReceiver", "getUserMergeInfo  isSuccess:" + z);
        if (z && getUserMergeInfoRsp != null) {
            g.c("AccountMigratePushReceiver", "processPushMsg  Error PushMsg is Empty");
            List<UserMergeInfo> userMergeInfos = getUserMergeInfoRsp.getUserMergeInfos();
            if (userMergeInfos != null) {
                for (UserMergeInfo userMergeInfo : userMergeInfos) {
                    String originalHuid = userMergeInfo.getOriginalHuid();
                    String c = C1093a.m4739a(this.f8709a.f8707a).m4750c();
                    switch (userMergeInfo.getStatus().intValue()) {
                        case 0:
                            C2538c.m12677c("AccountMigratePushReceiver", "Enter not begin");
                            break;
                        case 1:
                            be.m3648a().m3654c(originalHuid, c);
                            break;
                        case 2:
                            C2538c.m12677c("AccountMigratePushReceiver", "Enter default");
                            Bundle bundle = new Bundle();
                            bundle.putLong("error_code", -1);
                            C2538c.m12657a(907127009, "AccountMigratePushReceiver", bundle, false, "cloud migrate failure.originalHuid:" + originalHuid + " currentHuid:" + c);
                            be.m3648a().m3649a(originalHuid, c);
                            break;
                        default:
                            C2538c.m12677c("AccountMigratePushReceiver", "Enter default");
                            break;
                    }
                }
                Intent intent = new Intent();
                intent.setAction("com.huawei.migrate.action.migrate.success");
                if (LocalBroadcastManager.getInstance(this.f8709a.f8707a) != null) {
                    LocalBroadcastManager.getInstance(this.f8709a.f8707a).sendBroadcast(intent);
                    return;
                }
                return;
            }
            g.c("AccountMigratePushReceiver", "userMergeInfoList is null");
        }
    }
}
