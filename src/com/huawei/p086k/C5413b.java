package com.huawei.p086k;

import android.content.Context;
import com.huawei.p086k.p462a.C5406a;

/* compiled from: HsfSignBlackList */
class C5413b {
    private final Context f19228a;

    public C5413b(Context context) {
        C5406a.m25991a((Object) context, "context must not be null.");
        this.f19228a = context;
    }

    public boolean m26004a(String str) {
        if (str == null) {
            return false;
        }
        String[] strArr = new String[]{""};
        if (strArr == null) {
            return false;
        }
        for (Object equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
