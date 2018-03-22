package com.huawei.p086k;

import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.k.a.a;
import com.huawei.k.c;
import com.huawei.p190v.C2538c;

/* compiled from: AuthUtils */
public class C1090a {
    public static boolean m4699a(Context context, String str) {
        C2538c.m12677c("AuthUtils", "Enter verifyHsfSignature packageName:" + str);
        a.a(context, "context must not be null.");
        if (TextUtils.isEmpty(str)) {
            C2538c.m12677c("AuthUtils", "getServiceBinder packageName empty:");
            return false;
        } else if (C1090a.m4700b(context, str)) {
            return new c(context).a(str);
        } else {
            C2538c.m12677c("AuthUtils", "Enter verifyPackageNameByUid false");
            return false;
        }
    }

    private static boolean m4700b(Context context, String str) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packagesForUid != null) {
            for (Object equals : packagesForUid) {
                if (str.equals(equals)) {
                    C2538c.m12677c("AuthUtils", "Enter verifyPackageNameByUid true");
                    return true;
                }
            }
        }
        C2538c.m12677c("AuthUtils", "Enter verifyPackageNameByUid false");
        return false;
    }
}
