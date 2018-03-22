package com.huawei.pluginkidwatch.plugin.menu.utils;

import com.amap.api.services.core.PoiItem;
import java.util.List;

/* compiled from: MenuCache */
public class C1901r {
    private static boolean f6222a = false;
    private static List<PoiItem> f6223b;
    private static boolean f6224c = false;

    public static List<PoiItem> m9676a() {
        return f6223b;
    }

    public static void m9677a(List<PoiItem> list) {
        f6223b = list;
    }

    public static boolean m9680b() {
        return f6224c;
    }

    public static void m9678a(boolean z) {
        f6224c = z;
    }

    public static boolean m9681c() {
        return f6222a;
    }

    public static void m9679b(boolean z) {
        f6222a = z;
    }
}
