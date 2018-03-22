package com.huawei.appmarket.p348a.p352d;

public class C4229l {
    protected static int f15866a = -1;
    private static int f15867b = -1;

    public static int m20501a(int i) {
        int i2 = 1;
        int i3 = 0;
        boolean a = C4229l.m20502a();
        if (2 == i || 4 == i) {
            return 0;
        }
        if (i == 1) {
            return 256;
        }
        if (i == 3) {
            if (!a) {
                i2 = 0;
            }
            return (0 | i2) | 0;
        }
        if (a) {
            i3 = 1;
        }
        return (i3 | 256) | 0;
    }

    private static boolean m20502a() {
        f15867b = 1;
        return f15867b == 1;
    }
}
