package com.huawei.wallet.utils;

import android.text.TextUtils;
import com.huawei.wallet.utils.log.LogC;
import com.huawei.wallet.utils.log.LogErrorConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_256 {
    public static String m28475a(String str, String str2) {
        String str3 = null;
        try {
            byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "SHA-256";
                }
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(bytes);
                str3 = m28476a(instance.digest());
            } catch (NoSuchAlgorithmException e) {
                LogC.m28522a("no algorith", 907118114, LogErrorConstant.m28535a("SHA_256.encrypt", str2), false);
            }
        } catch (UnsupportedEncodingException e2) {
            LogC.m28534d("encrypt error.", false);
        }
        return str3;
    }

    public static String m28476a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString();
    }
}
