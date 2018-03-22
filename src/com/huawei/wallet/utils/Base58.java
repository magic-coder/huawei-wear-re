package com.huawei.wallet.utils;

public class Base58 {
    private static final char[] f21595a = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
    private static final int f21596b = f21595a.length;
    private static final int[] f21597c = new int[128];

    static {
        int i = 0;
        for (int i2 = 0; i2 < f21597c.length; i2++) {
            f21597c[i2] = -1;
        }
        while (i < f21595a.length) {
            f21597c[f21595a[i]] = i;
            i++;
        }
    }
}
