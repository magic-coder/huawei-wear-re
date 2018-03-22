package com.huawei.bone.p552b;

import com.huawei.hwcloudmodel.callback.a;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataRsp;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class aj implements a<MergeUserAllDataRsp> {
    final /* synthetic */ ai f23167a;

    aj(ai aiVar) {
        this.f23167a = aiVar;
    }

    public void m30103a(MergeUserAllDataRsp mergeUserAllDataRsp, String str, boolean z) {
        C2538c.c("MainInterators", new Object[]{"showForceMigrateDialog operationResult error:" + str});
        if (this.f23167a.f23166e.f23135r) {
            C2538c.c("MainInterators", new Object[]{"showForceMigrateDialog sendMigrateCommondTimeout is true return"});
            return;
        }
        if (mergeUserAllDataRsp == null) {
            long b = this.f23167a.f23166e.m30082b(str);
            C2538c.c("MainInterators", new Object[]{"accountmigrate: showDataMigrateDialog cancel var1 = null:" + b});
            if (999 == b) {
                C2538c.c("MainInterators", new Object[]{"accountmigrate: sendMigrageDataToCloud but cloud return faild ：999"});
                this.f23167a.f23164c.onResponse(999, "");
            } else {
                this.f23167a.f23166e.m30078a(this.f23167a.f23163b, this.f23167a.f23162a);
                this.f23167a.f23164c.onResponse(0, "");
            }
            this.f23167a.f23166e.m30075a(b);
        } else if (mergeUserAllDataRsp.getResultCode() == 0) {
            this.f23167a.f23166e.m30036a(this.f23167a.f23162a.getOriginalHuid(), this.f23167a.f23162a.getOriginalST(), com.huawei.login.ui.login.a.a(BaseApplication.b()).c());
            C2538c.c("MainInterators", new Object[]{"accountmigrate: sendMigrageDataToCloud rerurn success"});
            this.f23167a.f23166e.m30078a(this.f23167a.f23163b, this.f23167a.f23162a);
            this.f23167a.f23164c.onResponse(0, "");
        }
        this.f23167a.f23165d.countDown();
    }
}
