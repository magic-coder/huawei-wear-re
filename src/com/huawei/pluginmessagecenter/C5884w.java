package com.huawei.pluginmessagecenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import java.util.Locale;

/* compiled from: PluginMessageCenter */
class C5884w extends BroadcastReceiver {
    private C5884w() {
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            C5861g.m27024c("MessageCenterConfigChangedReceiver", "onReceive action=" + action);
            if ("android.intent.action.CONFIGURATION_CHANGED".equals(action)) {
                action = C5870i.m27067b(context);
                C5861g.m27024c("MessageCenterConfigChangedReceiver", "onReceive lastLan=" + action);
                String language = Locale.getDefault().getLanguage();
                C5861g.m27024c("MessageCenterConfigChangedReceiver", "onReceive currentLan=" + language);
                C5870i.m27068b(context, language);
                if (!action.equals(language)) {
                    j.a(context).d(null);
                }
            }
        }
    }
}
