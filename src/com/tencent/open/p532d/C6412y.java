package com.tencent.open.p532d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p542b.C6372a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6412y {
    private static final String f22262a = ("openSDK_LOG." + C6412y.class.getName());
    private static String f22263b = "";
    private static String f22264c = "";
    private static String f22265d = "";
    private static String f22266e = "";
    private static int f22267f = -1;
    private static String f22268g;
    private static boolean f22269h = true;
    private static String f22270i = "0123456789ABCDEF";

    public static String m29241a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            Object obj2 = bundle.get(str);
            if ((obj2 instanceof String) || (obj2 instanceof String[])) {
                Object obj3;
                if (obj2 instanceof String[]) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(SNBConstant.FILTER);
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                stringBuilder.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                stringBuilder.append(URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                    }
                    obj3 = obj;
                } else {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(SNBConstant.FILTER);
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                    obj3 = obj;
                }
                obj = obj3;
            }
        }
        return stringBuilder.toString();
    }

    public static Bundle m29236a(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String split : str.split(SNBConstant.FILTER)) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            return bundle;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject m29244a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String split : str.split(SNBConstant.FILTER)) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    try {
                        jSONObject.put(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                    } catch (JSONException e) {
                        C6367n.m29112e(f22262a, "decodeUrlToJson has exception: " + e.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Bundle m29250b(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle a = C6412y.m29236a(url.getQuery());
            a.putAll(C6412y.m29236a(url.getRef()));
            return a;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static JSONObject m29256c(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject a = C6412y.m29244a(null, url.getQuery());
            C6412y.m29244a(a, url.getRef());
            return a;
        } catch (MalformedURLException e) {
            return new JSONObject();
        }
    }

    public static JSONObject m29260d(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static void m29247a(String str, String str2) {
        if (f22269h) {
            C6367n.m29107b(str, str2);
        }
    }

    public static String m29240a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            C6412y.m29247a("Tencent-Util", e.toString());
        }
        return "";
    }

    public static boolean m29263e(String str) {
        return str == null || str.length() == 0;
    }

    private static boolean m29262e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (C6406s.m29217a(str, "4.3") < 0 || str.startsWith("4.4")) {
                return false;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return false;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(signatureArr[0].toByteArray());
                String a = C6412y.m29243a(instance.digest());
                instance.reset();
                str = "d8391a394d4a179e6fe7bdb8a301258b";
                if (a.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                    return true;
                }
                return false;
            } catch (NoSuchAlgorithmException e) {
                C6367n.m29112e(f22262a, "isQQBrowerAvailable has exception: " + e.getMessage());
                return false;
            }
        } catch (NameNotFoundException e2) {
            return false;
        }
    }

    public static boolean m29249a(Context context, String str) {
        boolean e;
        try {
            e = C6412y.m29262e(context);
            if (e) {
                try {
                    C6412y.m29246a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } catch (Exception e2) {
                    if (e) {
                        try {
                            C6412y.m29246a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                        } catch (Exception e3) {
                            try {
                                C6412y.m29246a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                            } catch (Exception e4) {
                                try {
                                    C6412y.m29246a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                                } catch (Exception e5) {
                                    return false;
                                }
                            }
                        }
                    }
                    try {
                        C6412y.m29246a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    } catch (Exception e6) {
                        try {
                            C6412y.m29246a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        } catch (Exception e7) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            C6412y.m29246a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
        } catch (Exception e8) {
            e = false;
            if (e) {
                C6412y.m29246a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
            } else {
                C6412y.m29246a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
            }
            return true;
        }
        return true;
    }

    private static void m29246a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean m29248a(Context context) {
        try {
            if (C6406s.m29217a(context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName, "4.1") >= 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            C6367n.m29107b("checkMobileQQ", HwAccountConstants.EXTRA_OPLOG_ERROR);
            return false;
        }
    }

    public static String m29264f(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(C6412y.m29269k(str));
            byte[] digest = instance.digest();
            if (digest != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i : digest) {
                    stringBuilder.append(C6412y.m29234a(i >>> 4));
                    stringBuilder.append(C6412y.m29234a(i));
                }
                str = stringBuilder.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            C6367n.m29112e(f22262a, "encrypt has exception: " + e.getMessage());
        }
        return str;
    }

    private static char m29234a(int i) {
        int i2 = i & 15;
        if (i2 < 10) {
            return (char) (i2 + 48);
        }
        return (char) ((i2 - 10) + 97);
    }

    public static void m29245a(Context context, String str, long j, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", "2.9.1");
        if (j != 0) {
            bundle.putLong("elt", j);
        }
        new C6413z(context, bundle).start();
    }

    public static boolean m29253b() {
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = Environment.getExternalStorageDirectory();
        }
        if (file != null) {
            return true;
        }
        return false;
    }

    public static String m29243a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static final String m29251b(Context context) {
        if (context != null) {
            CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            if (applicationLabel != null) {
                return applicationLabel.toString();
            }
        }
        return null;
    }

    public static final boolean m29265g(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return true;
        }
        return false;
    }

    public static final boolean m29266h(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean m29267i(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    public static final String m29242a(String str, int i, String str2, String str3) {
        Exception exception;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str4 = GameManager.DEFAULT_CHARSET;
        if (TextUtils.isEmpty(str2)) {
            str2 = str4;
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i3 = 0;
            while (i2 < str.length()) {
                int length = str.substring(i2, i2 + 1).getBytes(str2).length;
                if (i3 + length > i) {
                    String substring = str.substring(0, i2);
                    try {
                        if (!TextUtils.isEmpty(str3)) {
                            substring = substring + str3;
                        }
                        return substring;
                    } catch (Exception e) {
                        str = substring;
                        exception = e;
                        System.out.println("StructMsg sSubString error : " + exception.getMessage());
                        return str;
                    }
                }
                i3 += length;
                i2++;
            }
            return str;
        } catch (Exception e2) {
            exception = e2;
            System.out.println("StructMsg sSubString error : " + exception.getMessage());
            return str;
        }
    }

    public static int m29268j(String str) {
        return C6412y.m29235a(str, 0);
    }

    public static int m29235a(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return i;
    }

    public static boolean m29257c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo isConnectedOrConnecting : allNetworkInfo) {
            if (isConnectedOrConnecting.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }

    public static Bundle m29237a(String str, String str2, String str3, String str4, String str5, String str6) {
        return C6412y.m29239a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle m29239a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        return bundle;
    }

    public static Bundle m29238a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString(LogBuilder.KEY_PLATFORM, "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", VERSION.RELEASE);
        bundle.putString(LocationManagerProxy.NETWORK_PROVIDER, C6372a.m29132a(C6395h.m29184a()));
        bundle.putString("apn", C6372a.m29133b(C6395h.m29184a()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", "2.9.1");
        bundle.putString("packagename", C6395h.m29186b());
        bundle.putString("app_ver", C6412y.m29259d(C6395h.m29184a(), C6395h.m29186b()));
        return bundle;
    }

    public static String m29258d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation == null) {
                    return "";
                }
                double latitude = lastKnownLocation.getLatitude();
                f22268g = latitude + "*" + lastKnownLocation.getLongitude();
                return f22268g;
            }
        } catch (Throwable e) {
            C6367n.m29108b("getLocation", "getLocation>>>", e);
        }
        return "";
    }

    public static void m29252b(Context context, String str) {
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                f22264c = packageInfo.versionName;
                f22263b = f22264c.substring(0, f22264c.lastIndexOf(46));
                f22266e = f22264c.substring(f22264c.lastIndexOf(46) + 1, f22264c.length());
                f22267f = packageInfo.versionCode;
            } catch (NameNotFoundException e) {
                C6367n.m29112e(f22262a, "getPackageInfo has exception: " + e.getMessage());
            } catch (Exception e2) {
                C6367n.m29112e(f22262a, "getPackageInfo has exception: " + e2.getMessage());
            }
        }
    }

    public static String m29255c(Context context, String str) {
        if (context == null) {
            return "";
        }
        C6412y.m29252b(context, str);
        return f22264c;
    }

    public static String m29259d(Context context, String str) {
        if (context == null) {
            return "";
        }
        C6412y.m29252b(context, str);
        return f22263b;
    }

    public static String m29261e(Context context, String str) {
        if (context == null) {
            return "";
        }
        f22265d = C6412y.m29259d(context, str);
        return f22265d;
    }

    public static byte[] m29269k(String str) {
        try {
            return str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
