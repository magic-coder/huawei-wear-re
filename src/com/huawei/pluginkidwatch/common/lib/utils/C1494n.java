package com.huawei.pluginkidwatch.common.lib.utils;

import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Uitls */
public class C1494n {
    public static String m6927a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[0];
            if (str == null) {
                return "";
            }
            try {
                bArr = instance.digest(str.getBytes(GameManager.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                C2538c.m12680e("MD5Utils", "Exception e = " + e.getMessage());
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
            C2538c.m12680e("MD5Utils", "Exception e = " + e2.getMessage());
            return "";
        }
    }
}
