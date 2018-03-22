package com.tencent.mm.sdk.p537a.p538a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.p539b.C6342a;
import com.tencent.mm.sdk.p539b.C6346e;

public final class C6338a {

    public final class C6337a {
        public String f22077m;
        public Bundle f22078n;
        public String f22079o;
        public String f22080p;
    }

    public static boolean m29021a(Context context, C6337a c6337a) {
        if (context == null || c6337a == null) {
            C6342a.m29029a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (C6346e.m29043j(c6337a.f22080p)) {
            C6342a.m29029a("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = null;
            if (!C6346e.m29043j(c6337a.f22079o)) {
                str = c6337a.f22079o + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c6337a.f22080p);
            if (c6337a.f22078n != null) {
                intent.putExtras(c6337a.f22078n);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 570490883);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c6337a.f22077m);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C6339b.m29022a(c6337a.f22077m, 570490883, packageName));
            context.sendBroadcast(intent, str);
            C6342a.m29033d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
