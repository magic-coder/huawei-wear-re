package com.tencent.mm.sdk.p537a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.p537a.p538a.C6339b;
import com.tencent.mm.sdk.p539b.C6342a;
import com.tencent.mm.sdk.p539b.C6346e;
import net.sqlcipher.database.SQLiteDatabase;

public final class C6340a {

    public final class C6336a {
        public int flags = -1;
        public String f22073k;
        public String f22074l;
        public String f22075m;
        public Bundle f22076n;
    }

    public static boolean m29023a(Context context, C6336a c6336a) {
        if (context == null || c6336a == null) {
            C6342a.m29029a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (C6346e.m29043j(c6336a.f22073k)) {
            C6342a.m29029a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c6336a.f22073k);
            return false;
        } else {
            if (C6346e.m29043j(c6336a.f22074l)) {
                c6336a.f22074l = c6336a.f22073k + ".wxapi.WXEntryActivity";
            }
            C6342a.m29033d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c6336a.f22073k + ", targetClassName = " + c6336a.f22074l);
            Intent intent = new Intent();
            intent.setClassName(c6336a.f22073k, c6336a.f22074l);
            if (c6336a.f22076n != null) {
                intent.putExtras(c6336a.f22076n);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 570490883);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c6336a.f22075m);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C6339b.m29022a(c6336a.f22075m, 570490883, packageName));
            if (c6336a.flags == -1) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
            } else {
                intent.setFlags(c6336a.flags);
            }
            try {
                context.startActivity(intent);
                C6342a.m29033d("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e) {
                C6342a.m29030a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
