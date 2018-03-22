package com.huawei.account.aidl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: AccountAidlService */
class C0632b extends BroadcastReceiver {
    final /* synthetic */ AccountAidlService f1135a;

    C0632b(AccountAidlService accountAidlService) {
        this.f1135a = accountAidlService;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c(this.f1135a.f1128a, "Enter mAccountInfoReceiver");
        if (intent != null) {
            if (intent.getExtras() != null) {
                String stringExtra = intent.getStringExtra("value");
                C2538c.m12674b(this.f1135a.f1128a, "intent.getExtra() value:" + stringExtra);
                this.f1135a.f1131d = stringExtra;
            } else {
                C2538c.m12680e(this.f1135a.f1128a, "intent.getExtra() is null!");
            }
        }
        if (this.f1135a.f1130c != null) {
            C2538c.m12677c(this.f1135a.f1128a, "mAccountInfoReceiver countDown");
            this.f1135a.f1130c.countDown();
        }
    }
}
