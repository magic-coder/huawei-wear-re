package com.huawei.hwappdfxmgr.p056f;

import android.annotation.SuppressLint;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.p190v.C2538c;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@SuppressLint({"UseValueOf"})
/* compiled from: Utils */
public final class C4593d {
    private static char[] f16814a = new char[]{'0', '1', '2', '3', '4', '5'};

    public static FileInputStream m21881a(String str) {
        try {
            return new FileInputStream(str);
        } catch (FileNotFoundException e) {
            C2538c.e("Utils", new Object[]{"exception e = " + e.getMessage()});
            return null;
        }
    }

    public static void m21884a(Exception exception, String str) {
    }

    public static void m21883a(InputStream inputStream, String str) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                C2538c.e("Utils", new Object[]{"exception e = " + e.getMessage()});
            }
        }
    }

    public static void m21882a(DataOutputStream dataOutputStream, String str) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                C2538c.e("Utils", new Object[]{"exception e = " + e.getMessage()});
            }
        }
    }

    public static boolean m21885a() {
        return w.b();
    }
}
