package com.huawei.hwcloudmodel.mgr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.pushagent.PushReceiver;
import com.huawei.hwcloudmodel.callback.C0971c;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushReceiver;
import com.huawei.p190v.C2538c;
import java.util.HashMap;

public class DynamicPushReceiver extends PushReceiver {
    private static HashMap<String, C0971c> f1627a = new HashMap();

    public static void m3494a(String str, C0971c c0971c) {
        synchronized (f1627a) {
            f1627a.put(str, c0971c);
        }
    }

    public void onToken(Context context, String str) {
        Object[] objArr = new Object[1];
        objArr[0] = "===onToken===" + "获取token和belongId成功";
        C2538c.m12674b("DynamicPushReceiver", objArr);
        synchronized (f1627a) {
            for (C0971c c0971c : f1627a.values()) {
                if (c0971c != null) {
                    c0971c.mo2513a(context, str);
                }
            }
        }
        m3493a(context, str, null);
    }

    public void onToken(Context context, String str, Bundle bundle) {
        C2538c.m12674b("DynamicPushReceiver", "========onToken");
        C2538c.m12674b("DynamicPushReceiver", "================get token success");
        synchronized (f1627a) {
            for (C0971c c0971c : f1627a.values()) {
                if (c0971c != null) {
                    c0971c.mo2513a(context, str);
                }
            }
        }
        m3493a(context, str, bundle);
    }

    private void m3493a(Context context, String str, Bundle bundle) {
        C2538c.m12677c("DynamicPushReceiver", "== wallet push onPushToken ");
        C2538c.m12677c("DynamicPushReceiver", "== wallet push onPushToken  token : " + str);
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction(NFCPushReceiver.ACTION_RECEIVE_PUSH_TOKEN);
        intent.putExtra(NFCPushReceiver.EXTRA_PUSH_TOKEN, str);
        if (bundle != null) {
            C2538c.m12677c("DynamicPushReceiver", "== wallet push onPushToken  extras : " + bundle);
            intent.putExtra("com.huawei.wallet.push.extra.BUNDLE", bundle);
        }
        context.sendBroadcast(intent, C0976c.f1642a);
    }

    public void onPushState(Context context, boolean z) {
        super.onPushState(context, z);
        C2538c.m12674b("DynamicPushReceiver", "===pushstate:" + z);
    }
}
