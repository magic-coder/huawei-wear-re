package com.huawei.hwid.core.p435d;

import android.content.Context;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.hwid.core.datatype.SiteCountryInfo;
import com.huawei.hwid.core.datatype.SiteListInfo;
import com.huawei.hwid.core.p434c.C5147a;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.util.HashMap;

/* compiled from: IpCountryUtil */
public class C5178i {
    private static CharSequence[] f18647a = null;
    private static CharSequence[] f18648b = null;
    private static HashMap<CharSequence, CharSequence> f18649c = new HashMap();
    private static SiteCountryInfo f18650d = null;
    private static SMSKeyInfo f18651e = null;
    private static SiteListInfo f18652f = null;
    private static boolean f18653g = false;

    public static int m25024a(Context context) {
        int i = 0;
        try {
            i = C5147a.m24824a(context).m24825a("ip_countrySiteID", 0);
        } catch (Exception e) {
            C5165e.m24910d("IpCountryUtil", "siteID in prefrence maybe err");
        }
        return i;
    }
}
