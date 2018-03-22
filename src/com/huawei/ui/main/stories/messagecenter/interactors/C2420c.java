package com.huawei.ui.main.stories.messagecenter.interactors;

import android.content.Context;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoReq;

/* compiled from: AccountMigratePushReceiver */
class C2420c implements Runnable {
    final /* synthetic */ Context f8707a;
    final /* synthetic */ AccountMigratePushReceiver f8708b;

    C2420c(AccountMigratePushReceiver accountMigratePushReceiver, Context context) {
        this.f8708b = accountMigratePushReceiver;
        this.f8707a = context;
    }

    public void run() {
        a.a(this.f8707a.getApplicationContext()).a(new GetUserMergeInfoReq(), new C2421d(this));
    }
}
