package com.p230a.p231b.p237c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.p230a.p231b.p235a.C3084d;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.UUID;

public class C3131d {
    public static String m13939a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static final String m13940a(Context context) {
        String str = "device_id.xml";
        String str2 = SNBConstant.FIELD_DEVICE_ID;
        try {
            UUID fromString;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            str = sharedPreferences.getString(str2, null);
            if (str != null) {
                fromString = UUID.fromString(str);
            } else {
                str = Secure.getString(context.getContentResolver(), "android_id");
                if ("9774d56d682e549c".equals(str)) {
                    str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    fromString = str != null ? UUID.nameUUIDFromBytes(str.getBytes("utf8")) : UUID.randomUUID();
                } else {
                    fromString = UUID.nameUUIDFromBytes(str.getBytes("utf8"));
                }
                sharedPreferences.edit().putString(str2, fromString.toString()).commit();
            }
            return fromString.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String m13941b(Context context) {
        String line1Number = ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        return C3132e.m13953a(line1Number) ? "" : line1Number;
    }

    public static String m13942c(Context context) {
        String str = "";
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            try {
                return C3132e.m13953a(simSerialNumber) ? "" : simSerialNumber;
            } catch (Exception e) {
                return simSerialNumber;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    public static String m13943d(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    public static String m13944e(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return "";
        }
    }

    public static String m13945f(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final String m13946g(Context context) {
        Exception e;
        String str = "";
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str2 != null) {
                try {
                    if (str2.length() > 0) {
                        return str2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str2;
                }
            }
            return "";
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str;
            e = exception;
            e.printStackTrace();
            return str2;
        }
    }

    public static int m13947h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static final String m13948i(Context context) {
        String str;
        Exception e;
        String str2 = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.packageName;
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        return str;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str;
                }
            }
            return "";
        } catch (Exception e3) {
            Exception exception = e3;
            str = str2;
            e = exception;
            e.printStackTrace();
            return str;
        }
    }

    public static String m13949j(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C3084d.f10362p);
        stringBuilder.append(";");
        stringBuilder.append("Product Model: " + Build.MODEL + "," + VERSION.SDK + "," + VERSION.RELEASE + ";");
        stringBuilder.append("#*#");
        stringBuilder.append(C3131d.m13950k(context));
        return stringBuilder.toString();
    }

    private static String m13950k(Context context) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = "null";
            stringBuilder.append(C3132e.m13951a(C3131d.m13943d(context), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getSubscriberId(), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getDeviceId(), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getSimCountryIso(), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getSimOperator(), str));
            stringBuilder.append("||" + C3132e.m13951a(URLEncoder.encode(telephonyManager.getSimOperatorName(), "utf-8"), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getSimSerialNumber(), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getNetworkCountryIso(), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getNetworkOperator(), str));
            stringBuilder.append("||" + C3132e.m13951a(URLEncoder.encode(telephonyManager.getNetworkOperatorName(), "utf-8"), str));
            stringBuilder.append("||" + C3132e.m13951a(telephonyManager.getLine1Number(), str));
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
