package com.huawei.android.pushagent.p018c.p019a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONObject;

public class C4103b {
    private static final char[] f15493a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int m20121a() {
        int intValue;
        Class[] clsArr = new Class[]{String.class, Integer.TYPE};
        Object[] objArr = new Object[]{"ro.build.hw_emui_api_level", Integer.valueOf(0)};
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            intValue = ((Integer) cls.getDeclaredMethod("getInt", clsArr).invoke(cls, objArr)).intValue();
            try {
                e.a("PushLogSC2712", "getEmuiLevel:" + intValue);
            } catch (ClassNotFoundException e) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, ClassNotFoundException");
                return intValue;
            } catch (ExceptionInInitializerError e2) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, ExceptionInInitializerError");
                return intValue;
            } catch (LinkageError e3) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, LinkageError");
                return intValue;
            } catch (NoSuchMethodException e4) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, NoSuchMethodException");
                return intValue;
            } catch (NullPointerException e5) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, NullPointerException");
                return intValue;
            } catch (IllegalAccessException e6) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, IllegalAccessException");
                return intValue;
            } catch (IllegalArgumentException e7) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, IllegalArgumentException");
                return intValue;
            } catch (InvocationTargetException e8) {
                e.d("PushLogSC2712", " getEmuiLevel wrong, InvocationTargetException");
                return intValue;
            }
        } catch (ClassNotFoundException e9) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, ClassNotFoundException");
            return intValue;
        } catch (ExceptionInInitializerError e10) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, ExceptionInInitializerError");
            return intValue;
        } catch (LinkageError e11) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, LinkageError");
            return intValue;
        } catch (NoSuchMethodException e12) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, NoSuchMethodException");
            return intValue;
        } catch (NullPointerException e13) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, NullPointerException");
            return intValue;
        } catch (IllegalAccessException e14) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, IllegalAccessException");
            return intValue;
        } catch (IllegalArgumentException e15) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, IllegalArgumentException");
            return intValue;
        } catch (InvocationTargetException e16) {
            intValue = 0;
            e.d("PushLogSC2712", " getEmuiLevel wrong, InvocationTargetException");
            return intValue;
        }
        return intValue;
    }

    public static int m20122a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return -1;
        }
        for (int i = 0; i < allNetworkInfo.length; i++) {
            if (allNetworkInfo[i].getState() == State.CONNECTED) {
                return allNetworkInfo[i].getType();
            }
        }
        return -1;
    }

    public static String m20123a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[i * 2] = f15493a[(b & 240) >> 4];
            cArr[(i * 2) + 1] = f15493a[b & 15];
        }
        return new String(cArr);
    }

    public static JSONObject m20124a(String str) {
        if (TextUtils.isEmpty(str)) {
            e.a("PushLogSC2712", "jsonString is null");
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            e.c("PushLogSC2712", "cast jsonString to jsonObject error", e);
            return null;
        }
    }

    public static JSONArray m20125b(String str) {
        if (TextUtils.isEmpty(str)) {
            e.a("PushLogSC2712", "jsonString is null");
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (Throwable e) {
            e.c("PushLogSC2712", "cast jsonString to jsonArray error", e);
            return null;
        }
    }

    public static byte[] m20126c(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        try {
            byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (((byte) (Byte.decode("0x" + new String(new byte[]{bytes[i * 2]}, GameManager.DEFAULT_CHARSET)).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[(i * 2) + 1]}, GameManager.DEFAULT_CHARSET)).byteValue());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }
}
