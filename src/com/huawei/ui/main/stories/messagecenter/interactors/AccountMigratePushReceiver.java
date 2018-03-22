package com.huawei.ui.main.stories.messagecenter.interactors;

import android.content.Context;
import com.huawei.hwcloudmodel.callback.C0971c;
import com.huawei.hwcloudmodel.callback.IPushBase;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.a.g;
import java.util.concurrent.Executors;

public class AccountMigratePushReceiver implements IPushBase, C0971c {
    public void processPushMsg(Context context, String str) {
        g.a("AccountMigratePushReceiver", "accountmigrate: processPushMsg():msg=" + str);
        if (str == null || "".equals(str) || str.length() < 1) {
            g.b("AccountMigratePushReceiver", "processPushMsg  Error PushMsg is Empty");
        } else {
            Executors.newSingleThreadExecutor().execute(new C2420c(this, context));
        }
    }

    public void mo2513a(Context context, String str) {
        C2538c.m12674b("AccountMigratePushReceiver", "token = " + str);
    }
}
