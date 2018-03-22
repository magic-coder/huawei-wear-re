package com.huawei.hwid.core.p435d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.huawei.android.os.BuildEx;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.C5062a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.encrypt.C5204h;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.p432a.C5126a;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.core.p435d.p439c.C5168a;
import com.huawei.hwid.core.p435d.p439c.C5169b;
import com.huawei.hwid.p426b.C5114a;
import com.huawei.hwid.p428c.C5115a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: BaseUtil */
public class C5166b {
    public static boolean m24931a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            for (byte b : bytes) {
                int i = b & 255;
                if (i <= 31 || i >= 127) {
                    C5165e.m24906b("BaseUtil", "byte not printable");
                    return false;
                }
            }
        } catch (UnsupportedEncodingException e) {
            C5165e.m24906b("BaseUtil", "UnsupportedEncodingException");
        }
        return true;
    }

    public static String m24918a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        char[] cArr2 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[i * 2] = cArr2[(b & 240) >> 4];
            cArr[(i * 2) + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] m24935b(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        try {
            byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (((byte) (Byte.decode("0x" + new String(new byte[]{bytes[i * 2]}, GameManager.DEFAULT_CHARSET)).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[(i * 2) + 1]}, GameManager.DEFAULT_CHARSET)).byteValue());
            }
        } catch (UnsupportedEncodingException e) {
            C5165e.m24910d("BaseUtil", "hexString2ByteArray UnsupportedEncodingException");
        }
        return bArr;
    }

    public static boolean m24925a(Context context, int i) {
        int c;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (C5169b.m24971b()) {
            C5168a a = C5169b.m24969a();
            if (i == HwAccountConstants.NO_SUBID) {
                i = a.mo4642a();
            }
            c = a.mo4645c(i);
        } else if (telephonyManager != null) {
            c = telephonyManager.getSimState();
        } else {
            c = -1;
        }
        if (c == 5) {
            return true;
        }
        return false;
    }

    public static boolean m24924a(Context context) {
        C5165e.m24906b("BaseUtil", "enter networkIsAvaiable");
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null) {
            C5165e.m24906b("BaseUtil", "connectivity is null,so networkIsAvaiable is unaviable");
            return false;
        }
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        if (allNetworkInfo == null || allNetworkInfo.length == 0) {
            C5165e.m24906b("BaseUtil", "NetworkInfo is null,so networkIsAvaiable is unaviable");
            return false;
        }
        for (int i = 0; i < allNetworkInfo.length; i++) {
            if (allNetworkInfo[i] != null) {
                State state = allNetworkInfo[i].getState();
                C5165e.m24906b("BaseUtil", "NetworkInfo  state " + i + state);
                if (state == State.CONNECTED) {
                    C5165e.m24906b("BaseUtil", "NetworkInfo  state " + i + state + "is CONNECTED");
                    return true;
                }
            }
        }
        C5165e.m24906b("BaseUtil", "NetworkInfo  state is unaviable");
        return false;
    }

    public static String m24933b(Context context) {
        String[] strArr = new String[]{"Unknown", "Unknown"};
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            strArr[0] = "Unknown";
            return strArr[0];
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "Unknown";
            return strArr[0];
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 == null || networkInfo2.getState() != State.CONNECTED) {
                return strArr[0];
            }
            strArr[0] = "2G/3G/4G";
            strArr[1] = networkInfo2.getSubtypeName();
            return strArr[0] + strArr[1];
        }
        strArr[0] = "Wi-Fi";
        return strArr[0];
    }

    public static String m24915a() {
        return C5166b.m24951g("yyyyMMddHHmmssSSS");
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String m24917a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2).parse(str));
        } catch (Throwable e) {
            C5165e.m24907b("BaseUtil", e.getMessage(), e);
            return "";
        }
    }

    public static String m24937c(Context context) {
        return context.getPackageName();
    }

    public static String m24942d(Context context) {
        String toLowerCase = context.getResources().getConfiguration().locale.getLanguage().toLowerCase(Locale.getDefault());
        C5165e.m24906b("BaseUtil", "languageStr:" + toLowerCase);
        return toLowerCase;
    }

    public static String m24945e(Context context) {
        String toLowerCase = context.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.getDefault());
        C5165e.m24906b("BaseUtil", "countryStr:" + toLowerCase);
        return toLowerCase;
    }

    public static String m24948f(Context context) {
        return C5166b.m24942d(context) + "-" + C5166b.m24945e(context).toUpperCase(Locale.getDefault());
    }

    public static String m24938c(String str) {
        if (str == null) {
            return "0";
        }
        if (str.startsWith("+")) {
            str = str.replace("+", "00");
        }
        String str2 = "0";
        if (str.contains("@")) {
            str2 = "1";
        }
        if (C5181l.m25042c(str)) {
            return "2";
        }
        return str2;
    }

    public static int m24914a(Context context, String str) {
        HwAccount b = C5115a.m24641a(context).m24646b();
        if (b == null) {
            b = C5115a.m24641a(context).m24647c();
        }
        if (b != null) {
            return b.m25126e();
        }
        return 0;
    }

    public static String m24916a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            if ("com.huawei.hwid".equals(str2)) {
                stringBuffer.append(str);
            } else if (str.length() >= 20) {
                String substring = str.substring(0, 20);
                stringBuffer.append(substring).append(C5204h.m25323a(str + ":" + str2));
            }
        }
        return stringBuffer.toString();
    }

    public static boolean m24930a(HwAccount hwAccount) {
        if (hwAccount == null) {
            return false;
        }
        if (!TextUtils.isEmpty(hwAccount.m25120b()) && !TextUtils.isEmpty(hwAccount.m25124d()) && !TextUtils.isEmpty(hwAccount.m25122c()) && !TextUtils.isEmpty(hwAccount.m25130g())) {
            return true;
        }
        C5165e.m24904a("BaseUtil", "addHwAccount is invalid");
        return false;
    }

    public static boolean m24953g(Context context) {
        return context.getPackageName().equals("com.huawei.hwid");
    }

    public static boolean m24928a(Context context, String str, boolean z) {
        Object b = C5176g.m25017b(context, str);
        if (!TextUtils.isEmpty(b)) {
            try {
                z = Boolean.parseBoolean(b);
            } catch (Exception e) {
            }
        }
        return z;
    }

    public static boolean m24934b(Context context, String str) {
        return C5166b.m24927a(context, str, "com.huawei.hwid");
    }

    public static boolean m24927a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        List list = null;
        if (packageManager != null) {
            list = packageManager.queryIntentActivities(intent, 0);
        }
        if (list == null) {
            C5165e.m24906b("BaseUtil", "action " + str + " in HwID is no exist");
            return false;
        } else if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean m24939c(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage("com.huawei.hwid");
        List list = null;
        if (packageManager != null) {
            list = packageManager.queryIntentServices(intent, 0);
        }
        if (list == null) {
            C5165e.m24906b("BaseUtil", "action " + str + "in HwID is no exist");
            return false;
        } else if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static byte[] m24943d(String str) {
        if (TextUtils.isEmpty(str)) {
            C5165e.m24910d("BaseUtil", "getUTF8Bytes, str is empty");
            return new byte[0];
        }
        try {
            return str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            C5165e.m24911d("BaseUtil", "getBytes error", e);
            return new byte[0];
        }
    }

    public static boolean m24955h(Context context) {
        if (context == null) {
            return true;
        }
        List list = null;
        C5062a a = C5062a.m24355a();
        if (a.m24362b() == null) {
            try {
                list = C5166b.m24957i(context);
                a.m24361a(list);
            } catch (Exception e) {
                C5165e.m24910d("BaseUtil", "Exception");
            }
        } else {
            list = a.m24362b();
        }
        String packageName = context.getPackageName();
        if (list == null || !list.contains(packageName)) {
            return true;
        }
        return false;
    }

    public static List<String> m24957i(Context context) {
        String str = "package";
        List arrayList = new ArrayList();
        XmlResourceParser xml = context.getResources().getXml(C5180k.m25029b(context, "usesdk_packagename"));
        if (xml != null) {
            try {
                for (int eventType = xml.getEventType(); 1 != eventType; eventType = xml.next()) {
                    String name = xml.getName();
                    if (eventType == 2 && str.equals(name)) {
                        arrayList.add(xml.nextText());
                    }
                }
            } catch (Throwable e) {
                C5165e.m24911d("BaseUtil", "Parser xml exception: XmlPullParserException:" + e.getMessage(), e);
            } catch (Throwable e2) {
                C5165e.m24911d("BaseUtil", "Parser xml exception: IOException:" + e2.getMessage(), e2);
            }
        }
        return arrayList;
    }

    public static boolean m24958j(Context context) {
        try {
            if (context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128) != null) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static String m24959k(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            C5165e.m24906b("BaseUtil", "versionName " + str);
            return str;
        } catch (Throwable e) {
            C5165e.m24911d("BaseUtil", "getVersionTag error", e);
            return "";
        }
    }

    public static void m24920a(Context context, Intent intent, int i) {
        if (context == null || intent == null) {
            C5165e.m24910d("BaseUtil", "context or intent is null.");
            return;
        }
        if (!(context instanceof Activity)) {
            intent.setFlags((SQLiteDatabase.CREATE_IF_NECESSARY | i) | HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            C5165e.m24912e("BaseUtil", "not send Activity");
        } else if (i != 0) {
            intent.setFlags(i);
        }
        try {
            C5165e.m24912e("BaseUtil", "startActivity-->context = " + context.getClass().getName() + ", intent  ");
            context.startActivity(intent);
        } catch (Exception e) {
            C5165e.m24910d("BaseUtil", "can not start activity:" + e.getMessage());
        }
    }

    public static boolean m24929a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str, str2) == 0;
    }

    public static boolean m24947e(String str) {
        C5165e.m24906b("BaseUtil", "accountType" + str);
        if (TextUtils.isEmpty(str) || str.equals("0") || str.equals("1") || str.equals("2")) {
            return false;
        }
        return true;
    }

    public static HwAccount m24941d(Context context, String str) {
        if (context == null) {
            C5165e.m24906b("BaseUtil", "context is null");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            C5165e.m24912e("BaseUtil", "get account by userID failed, the userID is null!");
            return null;
        } else {
            List<HwAccount> a = C5114a.m24640a(context).mo4617a(context, C5166b.m24960l(context));
            if (!(a == null || a.isEmpty())) {
                for (HwAccount hwAccount : a) {
                    if (hwAccount != null && str.equalsIgnoreCase(hwAccount.m25124d())) {
                        C5165e.m24912e("BaseUtil", "get account by userID success!");
                        return hwAccount;
                    }
                }
            }
            C5165e.m24912e("BaseUtil", "get account by userID failed, there is no matching account!");
            return null;
        }
    }

    public static String m24960l(Context context) {
        String b = C5176g.m25017b(context, HwAccountConstants.TOKEN_TYPE);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        b = C5166b.m24937c(context);
        C5176g.m25009a(context, HwAccountConstants.TOKEN_TYPE, b);
        return b;
    }

    public static String m24961m(Context context) {
        if (context == null) {
            return "";
        }
        HwAccount hwAccount;
        C5165e.m24904a("BaseUtil", "TokenType" + C5203g.m25316a(C5166b.m24960l(context)));
        List a = C5114a.m24640a(context).mo4617a(context, C5166b.m24960l(context));
        if (a == null || a.size() <= 0) {
            hwAccount = null;
        } else {
            hwAccount = (HwAccount) a.get(0);
        }
        return hwAccount != null ? hwAccount.m25120b() : null;
    }

    public static void m24921a(Context context, String str, String str2, CloudRequestHandler cloudRequestHandler) {
        C5165e.m24906b("BaseUtil", "do getUserInfoReq in BaseUtil");
        if (context == null || cloudRequestHandler == null) {
            C5165e.m24906b("BaseUtil", "context or requestHandler is null");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            r2 = new ErrorStatus(1002, "userId  or queryRangeFlag is null");
            C5165e.m24912e("BaseUtil", "error: " + r2.toString());
            cloudRequestHandler.onError(r2);
        } else {
            HwAccount d = C5166b.m24941d(context, str);
            if (d == null) {
                r2 = new ErrorStatus(13, "no account by userId");
                C5165e.m24906b("BaseUtil", "error: " + r2.toString());
                cloudRequestHandler.onError(r2);
            } else if (C5166b.m24926a(context, "getUserInfo", 30000)) {
                String b = d.m25120b();
                C5125a c5126a = new C5126a(context, str, str2, null);
                c5126a.mo4627a(context, c5126a, b, cloudRequestHandler);
            } else {
                r2 = new ErrorStatus(25, "Too many recent requests have been made and last request hasn't callback");
                C5165e.m24906b("BaseUtil", "error: " + r2.toString());
                cloudRequestHandler.onError(r2);
            }
        }
    }

    public static boolean m24926a(Context context, String str, int i) {
        if ("com.huawei.hwid".equals(context.getPackageName())) {
            return true;
        }
        long a = C5062a.m24355a().m24356a(str);
        long currentTimeMillis = System.currentTimeMillis();
        boolean b = C5062a.m24355a().m24363b(str);
        int c = C5062a.m24355a().m24364c(str);
        if (0 == a || 0 == currentTimeMillis || ((long) i) < currentTimeMillis - a) {
            C5166b.m24922a(str, currentTimeMillis, c);
            C5165e.m24906b("BaseUtil", "last time or current time is zero, interval time is enough");
            return true;
        } else if (b) {
            C5166b.m24922a(str, currentTimeMillis, c);
            C5165e.m24906b("BaseUtil", "request has call back");
            return true;
        } else if (c < 5) {
            C5166b.m24922a(str, currentTimeMillis, c);
            C5165e.m24906b("BaseUtil", "request number is " + c);
            return true;
        } else {
            C5165e.m24906b("BaseUtil", "return error, key: " + str + " curTime: " + currentTimeMillis + " lastTime: " + a + " requestNum: " + c);
            return false;
        }
    }

    private static void m24922a(String str, long j, int i) {
        C5165e.m24906b("BaseUtil", "setStartRequestFlag key: " + str + " curTime: " + j + " requestNum: " + i);
        if (0 != j) {
            C5062a.m24355a().m24358a(str, j);
        }
        C5062a.m24355a().m24359a(str, false);
        C5062a.m24355a().m24357a(str, i + 1);
    }

    public static void m24949f(String str) {
        C5165e.m24906b("BaseUtil", str + " set true");
        int c = C5062a.m24355a().m24364c(str);
        if (c > 0) {
            C5062a.m24355a().m24357a(str, c - 1);
        }
        C5062a.m24355a().m24359a(str, true);
    }

    public static boolean m24962n(Context context) {
        int intValue;
        Object b = C5166b.m24932b();
        try {
            Object a = C5177h.m25022a("android.os.SystemProperties", "getInt", new Class[]{String.class, Integer.TYPE}, new Object[]{"ro.build.hw_emui_api_level", Integer.valueOf(0)});
            if (a != null) {
                intValue = ((Integer) a).intValue();
                if (!TextUtils.isEmpty(b)) {
                    b = b.toLowerCase(Locale.ENGLISH);
                }
                if (TextUtils.isEmpty(b) && b.contains("3.0") && r0 == 0) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            C5165e.m24908c("BaseUtil", e.getMessage());
        }
        intValue = 0;
        if (TextUtils.isEmpty(b)) {
            b = b.toLowerCase(Locale.ENGLISH);
        }
        return TextUtils.isEmpty(b) ? false : false;
    }

    public static String m24932b() {
        String str = "";
        try {
            Object a = C5177h.m25022a("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{"ro.build.version.emui", ""});
            if (a != null) {
                return (String) a;
            }
        } catch (Exception e) {
            C5165e.m24908c("BaseUtil", e.getMessage());
        }
        return str;
    }

    public static String m24951g(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static boolean m24956h(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            C5165e.m24910d("isExsit", "The class is not existing: " + str);
            return false;
        }
    }

    public static String m24936c() {
        return "B778D57C1D7C80E09C1FFDD68A2BCF74";
    }

    public static int m24940d() {
        int intValue;
        try {
            Object a = C5177h.m25022a("android.os.UserHandle", "myUserId", null, null);
            if (a != null) {
                intValue = ((Integer) a).intValue();
                C5165e.m24906b("BaseUtil", "getAndroidSystemUserId =" + intValue);
                return intValue;
            }
        } catch (Exception e) {
            C5165e.m24908c("BaseUtil", e.getMessage());
        }
        intValue = -1;
        C5165e.m24906b("BaseUtil", "getAndroidSystemUserId =" + intValue);
        return intValue;
    }

    public static boolean m24946e() {
        return C5166b.m24940d() == 0;
    }

    public static boolean m24950f() {
        return VERSION.SDK_INT > 22;
    }

    public static boolean m24952g() {
        if (!C5166b.m24956h("com.huawei.android.os.BuildEx") || BuildEx.VERSION.EMUI_SDK_INT < 9) {
            return false;
        }
        C5165e.m24906b("BaseUtil", "BuildEx.VERSION.EMUI_SDK_INT = " + BuildEx.VERSION.EMUI_SDK_INT);
        return true;
    }

    public static boolean m24954h() {
        return C5174e.m24995a();
    }

    public static void m24919a(Activity activity, boolean z) {
        if (VERSION.SDK_INT > 18) {
            Window window = activity.getWindow();
            LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.flags |= HwAccountConstants.FLAG_TRANSLUCENT_STATUS;
            } else {
                attributes.flags &= -67108865;
            }
            window.setAttributes(attributes);
        }
    }

    public static boolean m24923a(Activity activity, Boolean bool) {
        try {
            Window window = activity.getWindow();
            C5165e.m24906b("BaseUtil", "setHwFloating");
            C5177h.m25020a(window.getClass(), window, "setHwFloating", new Class[]{Boolean.TYPE}, new Object[]{bool});
            return true;
        } catch (Exception e) {
            C5165e.m24910d("BaseUtil", e.getMessage());
            return false;
        }
    }

    public static Builder m24944e(Context context, String str) {
        View inflate;
        C5165e.m24906b("BaseUtil", "createAppsDialog");
        LayoutInflater from = LayoutInflater.from(context);
        if (C5166b.m24962n(context)) {
            inflate = from.inflate(C5180k.m25031d(context, "cs_permission_list_3"), null);
        } else {
            inflate = from.inflate(C5180k.m25031d(context, "cs_permission_list"), null);
        }
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(C5180k.m25032e(context, "list_permission"));
            TextView textView2 = (TextView) inflate.findViewById(C5180k.m25032e(context, "text_exiting_apps"));
            if (textView2 != null) {
                textView2.setText(C5180k.m25027a(context, "CS_permission_warning_tip"));
            }
            if (textView != null) {
                String[] split = str.split(";");
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < split.length; i++) {
                    if (i == split.length - 1) {
                        stringBuilder.append(String.valueOf(i + 1)).append(". ").append(split[i]);
                    } else {
                        stringBuilder.append(String.valueOf(i + 1)).append(". ").append(split[i]).append("\n");
                    }
                }
                textView.setText(stringBuilder.toString());
            }
        }
        return new Builder(context, C5183n.m25066a(context)).setView(inflate);
    }

    public static String m24963o(Context context) {
        String str = "";
        if ("com.huawei.hwid".equals(context.getPackageName())) {
            return "HwID_" + C5166b.m24959k(context);
        }
        return "HwID_SDK_" + HwAccountConstants.SDK_VERSION;
    }
}
