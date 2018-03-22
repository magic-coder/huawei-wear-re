package com.huawei.bone.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C1025h;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.p190v.C2538c;

public class PromptReceiver extends BroadcastReceiver {
    private Boolean f1208a = Boolean.valueOf(false);
    private C1035a f1209b;

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C2538c.m12680e("PromptReceiver", "intent is null");
            return;
        }
        try {
            C2538c.m12677c("PromptReceiver", "Notification intent.getAction() = " + intent.getAction());
            if ("com.huawei.intelligent.action.NOTIFY_MSG".equalsIgnoreCase(intent.getAction())) {
                if (this.f1208a.booleanValue()) {
                    C2538c.m12677c("PromptReceiver", "PromptReceiver, is forbidden! ");
                    return;
                }
                Object stringExtra = intent.getStringExtra("type");
                Object stringExtra2 = intent.getStringExtra("message_short");
                C2538c.m12677c("PromptReceiver", "type = " + stringExtra + ", message_short = " + stringExtra2);
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                    C2538c.m12680e("PromptReceiver", "type or message_short is null!");
                } else {
                    this.f1209b = C1035a.m4176b();
                    if (this.f1209b == null) {
                        C2538c.m12680e("PromptReceiver", "mHWNotificationMgr is null");
                        return;
                    }
                    C2538c.m12677c("PromptReceiver", "mHWNotificationMgr  isAuthorizeEnabled=" + this.f1209b.m4187c());
                    if (this.f1209b.m4187c() && this.f1209b.m4177a("com.huawei.intelligent") == 1 && C1025h.m4003a()) {
                        C2538c.m12677c("PromptReceiver", "have device so start PhoneService!");
                        Intent intent2 = new Intent(context, PhoneService.class);
                        intent2.setAction("com.huawei.intelligent.action.NOTIFY_MSG");
                        intent2.putExtra("type", stringExtra);
                        intent2.putExtra("message_short", stringExtra2);
                        context.startService(intent2);
                    }
                }
            }
            if (intent.getAction() != null && TextUtils.equals(intent.getAction(), "com.huawei.midware_prompt_flag")) {
                this.f1208a = Boolean.valueOf(intent.getBooleanExtra("prompt_flag", false));
                C2538c.m12677c("PromptReceiver", "isForbiden = " + this.f1208a);
            }
        } catch (Exception e) {
            C2538c.m12680e("PromptReceiver", "Exception e = " + e.getMessage());
        }
    }
}
