package com.huawei.hwid.core.encrypt;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SHA256 */
public class C5204h {
    public static String m25323a(String str) {
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
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            C5165e.m24910d("SHA256", e.getMessage());
            return null;
        } catch (UnsupportedEncodingException e2) {
            C5165e.m24910d("SHA256", e2.getMessage());
            return null;
        } catch (Exception e3) {
            C5165e.m24910d("SHA256", e3.getMessage());
            return null;
        }
    }
}
