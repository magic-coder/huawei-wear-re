package com.huawei.hwid.api.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: BindSafePhoneBroadcastReceiver */
class C5082c extends BroadcastReceiver {
    private Context f18336a;
    private CloudRequestHandler f18337b;
    private boolean f18338c = false;

    public C5082c(Context context, CloudRequestHandler cloudRequestHandler) {
        this.f18336a = context;
        this.f18337b = cloudRequestHandler;
    }

    public void onReceive(Context context, Intent intent) {
        if (!this.f18338c) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("BindSafePhoneBroadcastReceiver", true);
            C5088d.m24471a(this.f18336a, bundle);
            this.f18338c = true;
            C5165e.m24903a(context);
            if (intent != null) {
                try {
                    CharSequence action = intent.getAction();
                    C5165e.m24906b("BindSafePhoneBroadcastReceiver", "BindSafePhoneBroadcastReceiver receiver : " + this.f18336a);
                    if (TextUtils.isEmpty(action) || !"com.huawei.hwid.ACTION.BINDSAFEPHONE.SUCCESS".equals(action)) {
                        C5165e.m24906b("BindSafePhoneBroadcastReceiver", "BindSafePhoneBroadcastReceiver receiver not ACTION_BIND_SAFEPHONE");
                    } else if (intent.hasExtra("result")) {
                        String stringExtra = intent.getStringExtra("result");
                        Bundle bundle2 = new Bundle();
                        if ("1".equals(stringExtra)) {
                            bundle2.putString("result", stringExtra);
                            bundle2.putString("secrityPhoneOrsecrityEmail", intent.getStringExtra("secrityPhoneOrsecrityEmail"));
                            if (intent.hasExtra("accountName")) {
                                bundle2.putString("accountName", intent.getStringExtra("accountName"));
                            }
                        } else {
                            bundle2.putString("result", stringExtra);
                        }
                        this.f18337b.onFinish(bundle2);
                    } else {
                        this.f18337b.onError((ErrorStatus) intent.getParcelableExtra(HwAccountConstants.EXTRA_OPLOG_ERROR));
                    }
                } catch (RuntimeException e) {
                    C5165e.m24906b("BindSafePhoneBroadcastReceiver", "BroadcastReceiver components are not allowed to register to receive intents");
                }
            }
        }
    }
}
