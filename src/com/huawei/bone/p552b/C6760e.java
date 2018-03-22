package com.huawei.bone.p552b;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: MainInterators */
class C6760e implements Runnable {
    final /* synthetic */ C6756a f23177a;

    C6760e(C6756a c6756a) {
        this.f23177a = c6756a;
    }

    public void run() {
        boolean await;
        this.f23177a.f23136s = false;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Executors.newSingleThreadExecutor().execute(new C6761f(this, countDownLatch, this.f23177a.m30090e()));
        C2538c.c("MainInterators", new Object[]{"isTimeout:" + a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout")});
        try {
            await = countDownLatch.await(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C2538c.e("MainInterators", new Object[]{"InterruptedException e = ", e.getMessage()});
            await = false;
        }
        if (!await && "false".equals(r2)) {
            C2538c.e("MainInterators", new Object[]{"hwidLogined outtime:" + await});
            this.f23177a.f23136s = true;
            this.f23177a.f23126i.runOnUiThread(new C6765j(this));
        }
    }
}
