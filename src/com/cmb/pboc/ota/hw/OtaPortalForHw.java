package com.cmb.pboc.ota.hw;

import com.cmb.pboc.httpclient.HttpsUtil;
import com.cmb.pboc.logger.PbocLog;
import java.util.HashMap;
import java.util.Map;

public class OtaPortalForHw {
    private static final String f13456a = OtaPortalForHw.class.getSimpleName();
    private static long f13457b;

    private OtaPortalForHw() {
    }

    public static String m17757a(int i, HashMap hashMap) {
        try {
            Map a = ParameterHw.m17764a(i, hashMap);
            f13457b = System.currentTimeMillis();
            String a2 = HttpsUtil.m17734a(OtaValueHw.f13469f ? OtaValueHw.f13464a + ";token=" + OtaValueHw.f13468e : OtaValueHw.f13464a, a);
            PbocLog.m17738a(f13456a, "Connection takes " + (System.currentTimeMillis() - f13457b) + " ms.");
            return a2;
        } catch (Exception e) {
            PbocLog.m17741d(f13456a, "Exception in post, Type: " + i + " ErrMsg: " + e.getMessage());
            return "result=0001&opcode=SHOWMSG&data=网络通信失败，请稍后重试&exception=" + e.getMessage();
        }
    }
}
