package com.amap.api.mapcore.util;

import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;

/* compiled from: Util */
class dd {
    dd() {
    }

    static String m16001a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        String a = br.m15748a(bytes);
        return ((char) ((a.length() % 26) + 65)) + a;
    }

    static String m16002b(String str) {
        if (str.length() < 2) {
            return "";
        }
        return br.m15747a(str.substring(1));
    }
}
