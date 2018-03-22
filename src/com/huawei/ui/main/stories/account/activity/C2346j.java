package com.huawei.ui.main.stories.account.activity;

import android.os.Message;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.C2353b;

/* compiled from: ThirdPartyLoginActivity */
class C2346j implements Runnable {
    final /* synthetic */ Object f8498a;
    final /* synthetic */ C2345i f8499b;

    C2346j(C2345i c2345i, Object obj) {
        this.f8499b = c2345i;
        this.f8498a = obj;
    }

    public void run() {
        C2353b c2353b = (C2353b) this.f8498a;
        String e = c2353b.m11942e();
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "accountmigrate: account check success");
        C2538c.m12674b(ThirdPartyLoginActivity.f8465h, "accountmigrate: account check success,accountContext1 = ", c2353b);
        if (e.equals(C1093a.m4739a(this.f8499b.f8497a.f8473g).m4750c())) {
            C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "accountmigrate: account is same");
            this.f8499b.f8497a.f8475j.sendEmptyMessage(10);
            return;
        }
        this.f8499b.f8497a.f8475j.sendEmptyMessage(11);
        Message message = new Message();
        message.what = 12;
        message.obj = c2353b;
        this.f8499b.f8497a.f8475j.sendMessageDelayed(message, 3000);
        this.f8499b.f8497a.m11906c(c2353b);
    }
}
