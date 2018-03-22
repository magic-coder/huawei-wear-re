package com.p004c.p005a.p008b.p009a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.huawei.nfc.carrera.storage.db.DataModel.RFConfInfoColumns;
import com.unionpay.tsmservice.data.Constant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DeflaterOutputStream;

public final class C0313a {
    static final char[] f147a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static boolean f148b = true;
    private static Long f149c = Long.valueOf(30);
    private static Long f150d = Long.valueOf(86400);
    private static Long f151e = Long.valueOf(1000);
    private static Long f152f = Long.valueOf(1800);
    private static int f153g = Integer.MAX_VALUE;
    private static HandlerThread f154h;
    private static HandlerThread f155i;
    private static Handler f156j;
    private static Handler f157k;

    static {
        HandlerThread handlerThread = new HandlerThread("HiAnalytics_messageThread");
        f154h = handlerThread;
        handlerThread.start();
        handlerThread = new HandlerThread("HiAnalytics_sessionThread");
        f155i = handlerThread;
        handlerThread.start();
    }

    public static long m128a(String str) {
        long j = 0;
        try {
            Date parse = new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
            if (parse != null) {
                j = parse.getTime();
            }
        } catch (ParseException e) {
            e.toString();
        }
        return j / 1000;
    }

    public static Long m129a() {
        return f149c;
    }

    public static String m130a(Context context) {
        String obj;
        String str = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj2 = applicationInfo.metaData.get("APPKEY");
                if (obj2 != null) {
                    obj = obj2.toString();
                    return (obj != null || obj.trim().length() == 0) ? context.getPackageName() : obj;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        obj = str;
        if (obj != null) {
        }
    }

    public static void m131a(Long l) {
        f150d = l;
    }

    public static byte[] m132a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        DeflaterOutputStream deflaterOutputStream;
        Exception e;
        Throwable th;
        byte[] bArr2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
                try {
                    deflaterOutputStream.write(bArr);
                    deflaterOutputStream.close();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        deflaterOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (deflaterOutputStream != null) {
                            try {
                                deflaterOutputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return bArr2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (deflaterOutputStream != null) {
                            try {
                                deflaterOutputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                deflaterOutputStream = bArr2;
                e.printStackTrace();
                if (deflaterOutputStream != null) {
                    deflaterOutputStream.close();
                    byteArrayOutputStream.close();
                }
                return bArr2;
            } catch (Throwable th3) {
                deflaterOutputStream = bArr2;
                th = th3;
                if (deflaterOutputStream != null) {
                    deflaterOutputStream.close();
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            deflaterOutputStream = bArr2;
            byteArrayOutputStream = bArr2;
            e.printStackTrace();
            if (deflaterOutputStream != null) {
                deflaterOutputStream.close();
                byteArrayOutputStream.close();
            }
            return bArr2;
        } catch (Throwable th32) {
            deflaterOutputStream = bArr2;
            byteArrayOutputStream = bArr2;
            th = th32;
            if (deflaterOutputStream != null) {
                deflaterOutputStream.close();
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return bArr2;
    }

    public static Long m133b() {
        return f150d;
    }

    public static String m134b(Context context) {
        String str = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get(Constant.TARGET_CHANNEL);
                if (obj != null) {
                    str = obj.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String m135b(String str) {
        return (str == null || str.equals("")) ? "000000000000000" : str;
    }

    public static String m136b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(f147a[(b & 240) >> 4]).append(f147a[b & 15]);
        }
        return stringBuilder.toString();
    }

    public static Long m137c() {
        return f152f;
    }

    public static String[] m138c(Context context) {
        String[] strArr = new String[]{"Unknown", "Unknown"};
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            strArr[0] = "Unknown";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "Unknown";
            return strArr;
        } else if (connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        } else {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo.getState() != State.CONNECTED) {
                return strArr;
            }
            strArr[0] = "2G/3G/4G";
            strArr[1] = networkInfo.getSubtypeName();
            return strArr;
        }
    }

    public static int m139d() {
        return f153g;
    }

    public static boolean m140d(Context context) {
        if (f151e.longValue() < 0) {
            return false;
        }
        return new File(context.getFilesDir(), new StringBuilder("../shared_prefs/").append(new StringBuilder("hianalytics_state_").append(context.getPackageName()).append(".xml").toString()).toString()).length() > f151e.longValue();
    }

    public static String m141e(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            return "unknown";
        }
    }

    public static boolean m142e() {
        return f148b;
    }

    public static Handler m143f() {
        if (f156j == null) {
            Looper looper = f154h.getLooper();
            if (looper == null) {
                return null;
            }
            f156j = new Handler(looper);
        }
        return f156j;
    }

    public static boolean m144f(Context context) {
        SharedPreferences a = C0315c.m149a(context, "flag");
        String str = Build.DISPLAY;
        String string = a.getString(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, "");
        return "".equals(string) || !string.equals(str);
    }

    public static Handler m145g() {
        if (f157k == null) {
            Looper looper = f155i.getLooper();
            if (looper == null) {
                return null;
            }
            f157k = new Handler(looper);
        }
        return f157k;
    }

    public static void m146h() {
    }

    public static String m147i() {
        return "http://data.hicloud.com:8089/sdkv2";
    }
}
