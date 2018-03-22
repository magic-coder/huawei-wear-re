package com.huawei.login.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.login.p087a.C1092a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;

public class LoginStatusReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            C2538c.m12677c("LoginStatusReceiver", "no context or intent");
            return;
        }
        String action = intent.getAction();
        if ("com.huawei.hwid.ACTION_REMOVE_ACCOUNT".equals(action)) {
            C2538c.m12677c("LoginStatusReceiver", "receive account removed broadcast");
            try {
                action = intent.getStringExtra("userId");
                C2538c.m12677c("LoginStatusReceiver", "receive account removed broadcast, userId:", action);
                if (action == null) {
                    C2538c.m12680e("LoginStatusReceiver", "logout userId is null!");
                    return;
                }
                String c = C1093a.m4739a(context).m4750c();
                if (!C1092a.m4721c(context) && action.equals(c)) {
                    C2538c.m12674b("LoginStatusReceiver", "logout successful");
                    C1093a.m4739a(context).m4756i();
                }
            } catch (BadParcelableException e) {
                C2538c.m12680e("LoginStatusReceiver", " BadParcelableException e : " + e.getMessage());
            } catch (Exception e2) {
                C2538c.m12680e("LoginStatusReceiver", "receive Exception e : " + e2.getMessage());
            }
        } else if ("com.huawei.RECEIVE_A_LOGOUT".equals(action)) {
            C2538c.m12677c("LoginStatusReceiver", "get logout broadcast receiver form health:" + C0996a.m3612a(context, String.valueOf(20007), "migrate_provide_login_infomation"));
            if ("migrate_support".equals(C0996a.m3612a(context, String.valueOf(20007), "migrate_provide_login_infomation"))) {
                C1093a.m4739a(context.getApplicationContext()).m4756i();
            }
        }
    }
}
