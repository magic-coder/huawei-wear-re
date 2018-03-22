package com.huawei.bone.p552b;

import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataReq;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: MainInterators */
class ai implements Runnable {
    final /* synthetic */ MergeUserAllDataReq f23162a;
    final /* synthetic */ Context f23163b;
    final /* synthetic */ IBaseResponseCallback f23164c;
    final /* synthetic */ CountDownLatch f23165d;
    final /* synthetic */ C6756a f23166e;

    ai(C6756a c6756a, MergeUserAllDataReq mergeUserAllDataReq, Context context, IBaseResponseCallback iBaseResponseCallback, CountDownLatch countDownLatch) {
        this.f23166e = c6756a;
        this.f23162a = mergeUserAllDataReq;
        this.f23163b = context;
        this.f23164c = iBaseResponseCallback;
        this.f23165d = countDownLatch;
    }

    public void run() {
        boolean await;
        a.a(BaseApplication.b()).a(this.f23162a, new aj(this));
        try {
            await = this.f23165d.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C2538c.e("MainInterators", new Object[]{"InterruptedException e = ", e.getMessage()});
            await = false;
        }
        if (!await) {
            C2538c.e("MainInterators", new Object[]{"sendMigrateDataToCloud outtime:" + await});
            this.f23166e.f23135r = true;
            this.f23164c.onResponse(10, "");
        }
        C2538c.c("MainInterators", new Object[]{"sendMigrateDataToCloud leave"});
    }
}
