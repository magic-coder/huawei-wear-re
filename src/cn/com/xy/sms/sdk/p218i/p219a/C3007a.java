package cn.com.xy.sms.sdk.p218i.p219a;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p229l.C3055t;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class C3007a {
    public static List<File> m13528a(String str) {
        return C3055t.m13713e(C2917a.m13107a("duoqu_temp"), new StringBuilder(String.valueOf(str)).append(HwAccountConstants.SPLIIT_UNDERLINE).toString(), LightCloudConstants.ZIP_POSTFIX);
    }

    public static void m13529a(String str, String str2) {
        List a = C3007a.m13528a(str);
        if (a != null && !a.isEmpty()) {
            Iterator it = a.iterator();
            while (it != null && it.hasNext()) {
                File file = (File) it.next();
                if (new StringBuilder(String.valueOf(str)).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str2).append(HwAccountConstants.SPLIIT_UNDERLINE).toString().compareTo(file.getName()) >= 0) {
                    file.delete();
                    new StringBuilder("deleteFile=").append(file.getAbsolutePath());
                } else {
                    it.remove();
                    new StringBuilder("不删除").append(file.getAbsolutePath());
                }
            }
        }
    }

    public static boolean m13530a(int i) {
        try {
            int c = C2947n.m13283c(C2917a.m13105a(), "ONLINE_UPDATE_RES_PERIOD");
            if (c <= 0) {
                c = 2;
            }
            if (System.currentTimeMillis() > C2973a.m13350a(9, 86400000 * ((long) c)) + C2947n.m13273a("LastCheckResourseTime_" + i, 0, C2917a.m13105a())) {
                return true;
            }
        } catch (Throwable th) {
        }
        return false;
    }
}
