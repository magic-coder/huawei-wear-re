package com.huawei.hwid.openapi.p441b;

import android.os.Bundle;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.auth.C5214a;
import com.huawei.hwid.openapi.auth.C5215b;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.p440a.C5212a;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5244a;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.C5251f;

public class C5227a {
    private static final String f18850a = C5213b.f18818a;

    public static void m25370a(C5212a c5212a) {
        if (c5212a == null) {
            C5248c.m25450d(f18850a, "when call authorize authTokenParam is null");
            return;
        }
        C5248c.m25444a(c5212a.f18805a);
        C5248c.m25445a(f18850a, "enter HwIDEntity::authorize(authTokenParam:" + c5212a.m25350b());
        c5212a.m25351c();
        if (!c5212a.m25349a()) {
            C5248c.m25450d(f18850a, "valid param failed!! " + c5212a.m25350b());
            if (c5212a.f18806b != null) {
                c5212a.f18806b.finish(OutReturn.creatParamErrRet("valid param failed"));
            }
        } else if (!C5251f.m25466e(c5212a.f18805a)) {
            C5248c.m25447b(f18850a, "no network");
            c5212a.f18806b.finish(OutReturn.creatRunTimeErrRet("check env failed!"));
        } else if (C5244a.m25427a(c5212a.f18805a)) {
            C5248c.m25445a(f18850a, "HwAccount apk is installed!");
            C5215b.m25357b(c5212a);
        } else {
            C5214a.m25354a(c5212a);
        }
    }

    public static boolean m25371a(Bundle bundle) {
        C5248c.m25445a(f18850a, "enter isNeedReAuth()!");
        if (bundle == null || C5251f.m25457a(bundle, HwAccountConstants.EXTRA_OPLOG_ERROR, 0) != 1202) {
            return false;
        }
        C5248c.m25447b(f18850a, "need reAuth!");
        return true;
    }
}
