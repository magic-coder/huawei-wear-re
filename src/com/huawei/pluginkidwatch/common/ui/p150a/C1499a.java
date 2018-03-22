package com.huawei.pluginkidwatch.common.ui.p150a;

import java.util.Date;

/* compiled from: CalendarCache */
public class C1499a {
    private static Date f3510a = null;

    public static Date m6961a() {
        return f3510a == null ? null : (Date) f3510a.clone();
    }

    public static void m6962a(Date date) {
        f3510a = date == null ? null : (Date) date.clone();
    }
}
