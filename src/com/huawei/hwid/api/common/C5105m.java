package com.huawei.hwid.api.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.C5154a;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p428c.C5115a;

/* compiled from: OpenLoginBroadcastReceiver */
class C5105m extends BroadcastReceiver {
    private Context f18407a;
    private LoginHandler f18408b;
    private boolean f18409c = false;
    private String f18410d;

    public C5105m(Context context, LoginHandler loginHandler, String str) {
        this.f18407a = context;
        this.f18408b = loginHandler;
        this.f18410d = str;
    }

    public void onReceive(Context context, Intent intent) {
        if (!this.f18409c) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("OpenLoginBroadcastReceiver", true);
                C5088d.m24471a(this.f18407a, bundle);
            } catch (Throwable e) {
                C5165e.m24909c("OpenLoginBroadcastReceiver", e.getMessage(), e);
            }
            this.f18409c = true;
            if (intent != null) {
                m24580a(context, intent);
            }
        }
    }

    private void m24580a(Context context, Intent intent) {
        C5165e.m24906b("OpenLoginBroadcastReceiver", "handleOpenLoginBroadcast");
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if (action != null) {
            try {
                if (action.equals("com.huawei.hwid.opensdk.smsauth.success") || action.equals("com.huawei.hwid.opensdk.smsauth.quicklogin.SUCCESS")) {
                    if (extras != null) {
                        if ("com.huawei.hwid".equals(this.f18410d)) {
                            extras.putString("serviceToken", C5166b.m24916a(extras.getString("serviceToken"), this.f18407a.getPackageName()));
                        }
                        extras.putString("accountType", "2");
                        HwAccount a = C5106n.m24582a(this.f18407a, extras);
                        C5115a.m24641a(this.f18407a).m24644a(a);
                        CloudAccount[] a2 = C5088d.m24489a(context);
                        action = "";
                        if (!TextUtils.isEmpty(a.m25120b())) {
                            action = a.m25120b();
                        }
                        this.f18408b.onLogin(a2, C5088d.m24463a(a2, action));
                        C5106n.m24585a(context, action);
                    }
                } else if (action.equals("com.huawei.hwid.opensdk.switch.other")) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(CloudAccount.KEY_LOGIN_CHANNEL, Integer.parseInt(C5154a.m24846a(context, C5166b.m24937c(context))));
                    C5088d.m24476a(context, C5166b.m24937c(context), bundle, this.f18408b);
                } else if (action.equals("com.huawei.hwid.opensdk.smsauth.quicklogin.fail")) {
                    this.f18408b.onError(new ErrorStatus(3002, "press back key"));
                }
            } catch (RuntimeException e) {
                C5165e.m24906b("OpenLoginBroadcastReceiver", "BroadcastReceiver components are not allowed to register to receive intents");
            }
        }
    }
}
