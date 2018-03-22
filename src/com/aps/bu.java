package com.aps;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.widget.Toast;
import com.amap.api.location.core.C3191c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.params.HttpParams;

/* compiled from: Utils */
public class bu {
    public static void m17454a(Object... objArr) {
    }

    static void m17451a(Context context, String str) {
        int i;
        if (str == null) {
            str = "null";
        }
        if (C3191c.m14131j().indexOf("test") != -1) {
            i = 1;
        } else if (ax.f12974d.indexOf("test") != -1) {
            i = 1;
        } else {
            char[] cArr = null;
            if (C3191c.m14131j().length() > 0) {
                cArr = C3191c.m14131j().substring(7, 8).toCharArray();
            }
            if (cArr == null || !Character.isLetter(cArr[0])) {
                i = 1;
            } else {
                i = 0;
            }
        }
        if (i != 0 && context != null) {
            Toast.makeText(context, str, 0).show();
            m17454a(str);
        }
    }

    public static void m17452a(Throwable th) {
    }

    static boolean m17456a(ap apVar) {
        if (apVar == null || apVar.m17309j().equals("5") || apVar.m17309j().equals("6")) {
            return false;
        }
        double e = apVar.m17299e();
        double f = apVar.m17301f();
        float g = apVar.m17303g();
        if (e == 0.0d && f == 0.0d && ((double) g) == 0.0d) {
            return false;
        }
        return true;
    }

    static int m17448a(int i) {
        return (i * 2) - 113;
    }

    public static String[] m17459a(TelephonyManager telephonyManager) {
        int i = 1;
        int i2 = 0;
        String[] strArr = new String[]{"0", "0"};
        Object obj = null;
        if (telephonyManager != null) {
            try {
                obj = telephonyManager.getNetworkOperator();
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(obj)) {
            i = i2;
        } else if (!TextUtils.isDigitsOnly(obj)) {
            i = i2;
        } else if (obj.length() <= 4) {
            i = i2;
        }
        if (i != 0) {
            strArr[0] = obj.substring(0, 3);
            char[] toCharArray = obj.substring(3).toCharArray();
            i = i2;
            while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                i++;
            }
            strArr[1] = obj.substring(3, i + 3);
        }
        try {
            i2 = Integer.parseInt(strArr[0]);
        } catch (Exception e2) {
        }
        if (i2 == 0) {
            strArr[0] = "0";
        }
        return strArr;
    }

    static int m17449a(CellLocation cellLocation, Context context) {
        if (m17455a(context)) {
            m17454a("air plane mode on");
            return 9;
        } else if (cellLocation instanceof GsmCellLocation) {
            return 1;
        } else {
            try {
                Class.forName("android.telephony.cdma.CdmaCellLocation");
                return 2;
            } catch (Throwable th) {
                th.printStackTrace();
                return 9;
            }
        }
    }

    static long m17450a() {
        return System.currentTimeMillis();
    }

    static long m17460b() {
        return SystemClock.elapsedRealtime();
    }

    static boolean m17455a(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (m17463c() < 17) {
            try {
                if (System.getInt(contentResolver, "airplane_mode_on", 0) != 1) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        try {
            if (Global.getInt(contentResolver, "airplane_mode_on", 0) != 1) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    static float m17447a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    static Object m17462b(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getSystemService(str);
    }

    static void m17453a(HttpParams httpParams, int i) {
        httpParams.setIntParameter("http.connection.timeout", i);
        httpParams.setIntParameter("http.socket.timeout", i);
        httpParams.setLongParameter("http.conn-manager.timeout", (long) i);
    }

    static int m17463c() {
        int i = 0;
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            th.printStackTrace();
            m17452a(th);
            return i;
        }
    }

    public static byte[] m17458a(byte[] bArr) {
        byte[] toByteArray;
        Throwable th;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return toByteArray;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            toByteArray = null;
            th = th4;
            th.printStackTrace();
            return toByteArray;
        }
        return toByteArray;
    }

    static NetworkInfo m17461b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) m17462b(context, "connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException e) {
                return null;
            }
        }
        activeNetworkInfo = null;
        return activeNetworkInfo;
    }

    public static boolean m17457a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            return ",111,123,134,199,202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,560,598,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,665,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,850,901,".contains("," + str + ",");
        }
        return false;
    }
}
