package com.huawei.hwid.openapi.auth;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.auth.dump.OpenDumpActivity;
import com.huawei.hwid.openapi.p440a.C5212a;
import com.huawei.hwid.openapi.p440a.C5213b;

public class C5215b extends C5214a {
    private static final String f18820a = C5213b.f18818a;

    private static boolean m25356a(int i) {
        return i > 1;
    }

    public static void m25357b(C5212a c5212a) {
        if (TextUtils.isEmpty(c5212a.f18814j) || C5215b.m25356a(c5212a.f18817m)) {
            C5215b.m25358c(c5212a);
            Intent intent = new Intent();
            intent.setClassName(c5212a.f18805a, OpenDumpActivity.class.getName());
            intent.putExtra(HwAccountConstants.TOKEN_TYPE, c5212a.f18805a.getPackageName());
            if (c5212a.f18807c != null) {
                intent.putExtra(CloudAccount.KEY_NEEDAUTH, c5212a.f18807c.getBoolean(CloudAccount.KEY_NEEDAUTH));
            }
            intent.putExtra("chooseAccount", C5215b.m25356a(c5212a.f18817m));
            c5212a.f18805a.startActivity(intent);
            return;
        }
        C5214a.m25354a(c5212a);
    }

    private static void m25358c(C5212a c5212a) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.cloudserive.getSTSuccess");
        intentFilter.addAction("com.huawei.cloudserive.getSTCancel");
        c5212a.f18805a.registerReceiver(new C5216c(c5212a), intentFilter);
    }
}
