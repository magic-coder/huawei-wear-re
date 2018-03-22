package com.huawei.ui.homewear21.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p085j.C1089a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.C1990r;

public class AccountLoginReceiver extends BroadcastReceiver {
    private DeviceCapability f8258a = null;
    private C1990r f8259b;

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("AccountLoginReceiver", " == AccountLoginReceiver enter ");
        if (C0969i.m3482a(53) && intent != null) {
            C2538c.m12677c("AccountLoginReceiver", " == AccountLoginReceiver: intent = " + intent.getAction());
            this.f8259b = C1990r.m10400a(context);
            this.f8258a = this.f8259b.m10411a();
            if (this.f8258a == null || !this.f8258a.isSupportPay()) {
                C2538c.m12677c("AccountLoginReceiver", " == AccountLoginReceiver is not SupportPay : ");
                return;
            }
            String action = intent.getAction();
            String c = C1093a.m4739a(context).m4750c();
            C2538c.m12677c("AccountLoginReceiver", " == AccountLoginReceiver userID : " + c);
            if (c != null && !"".equals(c) && action != null) {
                if (action.equals("com.huawei.plugin.account.login")) {
                    C2538c.m12677c("AccountLoginReceiver", " == AccountLoginReceiver sendAccount ");
                    C1089a.m4692a().m4698a(c, null);
                } else if (action.equals("com.huawei.plugin.account.logout")) {
                    C2538c.m12677c("AccountLoginReceiver", " == AccountLoginReceiver logout sendAccount ");
                } else {
                    C2538c.m12677c("AccountLoginReceiver", " == AccountLoginReceiver receive unknown localBroadCast action =" + action);
                }
            }
        }
    }
}
