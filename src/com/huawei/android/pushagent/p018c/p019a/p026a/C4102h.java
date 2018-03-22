package com.huawei.android.pushagent.p018c.p019a.p026a;

import com.huawei.android.pushagent.c.a.e;
import com.sina.weibo.sdk.component.GameManager;
import java.security.MessageDigest;

public class C4102h {
    public static String m20120a(String str) {
        try {
            String str2 = GameManager.DEFAULT_CHARSET;
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes(str2));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(40);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            e.a("PushLogSC2712", "getSHA256str:" + stringBuffer.toString());
            str = stringBuffer.toString();
        } catch (Throwable e) {
            e.c("PushLogSC2712", e.toString(), e);
        } catch (Throwable e2) {
            e.c("PushLogSC2712", e2.toString(), e2);
        } catch (Throwable e22) {
            e.c("PushLogSC2712", e22.toString(), e22);
        }
        return str;
    }
}
