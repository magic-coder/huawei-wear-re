package com.amap.api.location.core;

import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.TypeParams;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.unionpay.tsmservice.data.Constant;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public class C3195g {
    private static final String[] f10711a = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, "r", "s", "t", "u", Constant.KEY_VERSION, "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", CardStatusQueryResponse.DEV_STATUS_LOCK, "A", "B", TypeParams.SEARCH_CODE, "D", "E", "F", "G", "H", "I", "J", TypeParams.SEARCH_KEYWORDS, "L", TypeParams.QUESTION_CHOOSE_MULTI, "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String m14164a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static String m14163a(String str) {
        MessageDigest instance;
        byte[] bArr = null;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            instance = null;
        }
        if (instance != null) {
            try {
                instance.update(str.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (instance != null) {
            bArr = instance.digest();
        }
        return C3195g.m14164a(bArr);
    }
}
