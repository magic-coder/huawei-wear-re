package com.huawei.hwcommonmodel.p064d;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Uitls */
public class C4729g {
    public static String m22632a(Context context, String str) {
        try {
            byte[] bArr = new byte[0];
            try {
                bArr = MessageDigest.getInstance("MD5").digest(str.getBytes(GameManager.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                C2538c.e("MD5Uitls", new Object[]{"Exception e = " + e.getMessage()});
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : r2) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            C2538c.e("MD5Uitls", new Object[]{"Exception e = " + e2.getMessage()});
            return "";
        }
    }
}
