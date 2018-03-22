package com.huawei.pluginkidwatch.common.lib.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: YearUtil */
public class C1498r {
    private static Map<Integer, String> f3506d = new HashMap();
    public int f3507a;
    public int f3508b;
    public int f3509c;

    static {
        f3506d.put(Integer.valueOf(1), "yyyy-MM-dd");
        f3506d.put(Integer.valueOf(2), "yyyy/MM/dd");
        f3506d.put(Integer.valueOf(3), "yyyy年MM月dd日");
    }

    public static String m6960a(Date date, String str) {
        if (f3506d.containsValue(str)) {
            return new SimpleDateFormat(str).format(date);
        }
        return null;
    }

    public String toString() {
        return "YearUtil [year=" + this.f3507a + ", month=" + this.f3508b + ", day=" + this.f3509c + "]";
    }
}
