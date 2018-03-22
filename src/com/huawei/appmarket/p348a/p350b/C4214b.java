package com.huawei.appmarket.p348a.p350b;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.WeakHashMap;

public class C4214b {
    private static WeakHashMap<String, SoftReference<String>> f15833a = new WeakHashMap();

    public static String m20475a(BufferedReader bufferedReader, int i) throws IOException {
        if (bufferedReader == null || i < 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(1024);
        while (true) {
            int read = bufferedReader.read();
            if (read == -1) {
                return stringBuilder.toString();
            }
            if (!(read == 13 || read == 10)) {
                stringBuilder.append((char) read);
                if (stringBuilder.length() >= i) {
                    C4241a.m20532b("Utils", "readStringByOneChar -> the read chars counts is reached the maxAllowChars = " + i + "sb.length = " + stringBuilder.length());
                    return stringBuilder.toString();
                }
            }
        }
    }
}
