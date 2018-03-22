package com.huawei.p111o.p479c;

import android.content.Context;
import android.content.Intent;
import com.huawei.common.util.CommonLibUtil;
import com.huawei.p190v.C2538c;

/* compiled from: CommonLibUtil */
public class C5705a {
    public static String m26330a(Context context) {
        String packageName = context.getPackageName();
        C2538c.c(CommonLibUtil.TAG, new Object[]{"getUsedPackageName:" + context});
        return packageName;
    }

    public static void m26331b(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        C2538c.c(CommonLibUtil.TAG, new Object[]{"reboot: i = " + launchIntentForPackage});
        launchIntentForPackage.addFlags(268468224);
        context.startActivity(launchIntentForPackage);
        C2538c.b(CommonLibUtil.TAG, new Object[]{"exit App!!! "});
        System.exit(0);
    }
}
