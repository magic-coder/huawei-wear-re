package com.amap.api.mapcore.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Utils */
public class cm {
    static String m15910a(Throwable th) {
        String a = bw.m15799a(th);
        if (a != null) {
            return a.replaceAll("\n", "<br/>");
        }
        return null;
    }

    public static String m15909a(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS").format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }
}
