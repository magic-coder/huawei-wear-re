package com.fenda.hwbracelet.p263f;

import android.util.Log;

/* compiled from: Utils */
public class C3608d {
    public static String m18110a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            if ((b & 255) < 16) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(b & 255));
        }
        return stringBuilder.toString().toLowerCase();
    }

    public static int m18109a(String str) {
        int i = 0;
        try {
            String[] split = str.split(":");
            return Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
        } catch (Exception e) {
            Log.i("Utils", "Exception");
            return i;
        }
    }
}
