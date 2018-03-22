package com.huawei.logupload.p090c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.lcagent.client.MetricConstant;
import com.huawei.logupload.C1109f;
import com.huawei.logupload.C1110k;
import com.huawei.logupload.LogUpload;
import com.huawei.logupload.LogUploadReceive;
import com.huawei.logupload.LogUploadService;
import com.huawei.logupload.UploadReceiver;
import com.huawei.logupload.c.a;
import com.huawei.logupload.c.d;
import com.huawei.logupload.c.e;
import com.huawei.logupload.c.g;
import com.huawei.logupload.c.i;
import com.huawei.logupload.h;
import com.huawei.logupload.p089b.C1099a;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.AccessibleObject;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Utils */
public final class C1105h {
    private static String f2283a = "SyyMUlxd0y0G/pBHzj6yO9h1PA8CZWjD4xmMbOM4owxPTaU/zmsxEluA1GZ01i3ocnUlfQcQKBgBAR/qvKtUs21v7dj+jcC3d6hzoKt91GV9GzPseUxSetwOXONgMdVhv6jmTdiwtbmg39RXO4DhJTLxvTxV3UB/Ir8BtaEKT6AqVDra9ahgCgyoLpNcCUuYgjlKHdPwJ1+0c32+j/OD4gmEH+ga";

    /* compiled from: Utils */
    public class C1104a extends Handler {
        public C1104a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            LogUpload logUpload;
            switch (message.what) {
                case 0:
                    if (!C1110k.m4924a()) {
                        C1105h.m4910e();
                        C1103f.m4878b("feedback_upload_Utils", "收到子线程消息");
                        C1103f.m4878b("feedback_upload_Utils", "自杀进程 :myPid: " + Process.myPid());
                        if (C1102c.m4875i() != 1) {
                            Intent intent = new Intent();
                            intent.setAction("com.example.logupload.progress");
                            if (message.getData() != null) {
                                intent.setPackage(message.getData().getString("packagename"));
                            }
                            intent.putExtra(JoinConstants.EXCEPTION, "1");
                            C1103f.m4876a(JoinConstants.EXCEPTION, "1");
                            C1101b.m4858a().m4860b().sendBroadcast(intent);
                        }
                        C1102c.m4867c().clear();
                        C1102c.m4862a(0);
                        C1102c.m4868c(-1);
                        C1102c.m4866b(0);
                        UploadReceiver.a(-100);
                        C1101b.m4858a().m4860b().stopService(new Intent(C1101b.m4858a().m4860b(), LogUploadReceive.class));
                        C1101b.m4858a().m4860b().stopService(new Intent(C1101b.m4858a().m4860b(), LogUploadService.class));
                        return;
                    }
                    return;
                case 1:
                    C1103f.m4878b("feedback_upload_Utils", "service 启动");
                    logUpload = (LogUpload) message.obj;
                    if (logUpload != null) {
                        C1103f.m4880d("feedback_upload_Utils", "taskId:" + logUpload.m4791f());
                        LogUploadService.m4829a(logUpload);
                        return;
                    }
                    return;
                case 2:
                    C1103f.m4878b("feedback_upload_Utils", "亮屏");
                    C1099a.m4851a().m4852a(new C1109f((LogUpload) message.obj, message.arg1));
                    return;
                case 3:
                    C1103f.m4878b("feedback_upload_Utils", "网络变更");
                    Context a = UploadReceiver.a();
                    logUpload = (LogUpload) message.obj;
                    if (logUpload == null || 4 == logUpload.m4763F()) {
                        C1103f.m4880d("feedback_upload_Utils", "问题反馈日志网络变更不重传！");
                        return;
                    }
                    Intent intent2 = new Intent(a, LogUploadReceive.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("LogUpload", logUpload);
                    intent2.putExtras(bundle);
                    a.startService(intent2);
                    return;
                default:
                    return;
            }
        }
    }

    public static String m4885a() {
        return f2283a;
    }

    public static String m4886a(Context context) {
        String deviceId;
        String str = "";
        try {
            if (C1105h.m4896a(context, true)) {
                deviceId = ((TelephonyManager) C1101b.m4858a().m4860b().getSystemService("phone")).getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                C1103f.m4880d("feedback_upload_Utils", "imei empty!");
                if (C1105h.m4906c(context)) {
                    C1103f.m4880d("feedback_upload_Utils", "not WifiOnly!");
                    return "000000000000000";
                }
                C1103f.m4880d("feedback_upload_Utils", "isWifiOnly!");
                return C1105h.m4916h(context);
            }
        } catch (Exception e) {
            C1103f.m4880d("feedback_upload_Utils", "get imei error");
        }
        deviceId = str;
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        C1103f.m4880d("feedback_upload_Utils", "imei empty!");
        if (C1105h.m4906c(context)) {
            C1103f.m4880d("feedback_upload_Utils", "not WifiOnly!");
            return "000000000000000";
        }
        C1103f.m4880d("feedback_upload_Utils", "isWifiOnly!");
        return C1105h.m4916h(context);
    }

    public static String m4900b(Context context) {
        String str = "";
        try {
            if (C1105h.m4896a(context, false)) {
                return ((TelephonyManager) C1101b.m4858a().m4860b().getSystemService("phone")).getSubscriberId();
            }
        } catch (Exception e) {
            C1103f.m4880d("feedback_upload_Utils", "get imei error");
        }
        return str;
    }

    public static String m4899b() {
        String str = "";
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.serialno"});
        } catch (Exception e) {
            C1105h.m4893a(e, "feedback_upload_Utils");
            return str;
        } catch (Exception e2) {
            C1105h.m4893a(e2, "feedback_upload_Utils");
            return str;
        } catch (Exception e22) {
            C1105h.m4893a(e22, "feedback_upload_Utils");
            return str;
        } catch (Exception e222) {
            C1105h.m4893a(e222, "feedback_upload_Utils");
            return str;
        } catch (Exception e2222) {
            C1105h.m4893a(e2222, "feedback_upload_Utils");
            return str;
        }
    }

    public static boolean m4906c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            return !((Boolean) connectivityManager.getClass().getMethod("isNetworkSupported", new Class[]{Integer.TYPE}).invoke(connectivityManager, new Object[]{Integer.valueOf(0)})).booleanValue();
        } catch (Exception e) {
            C1105h.m4893a(e, "feedback_upload_Utils");
            return false;
        } catch (Exception e2) {
            C1105h.m4893a(e2, "feedback_upload_Utils");
            return false;
        } catch (Exception e22) {
            C1105h.m4893a(e22, "feedback_upload_Utils");
            return false;
        } catch (Exception e222) {
            C1105h.m4893a(e222, "feedback_upload_Utils");
            return false;
        }
    }

    public static int m4883a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (1 == type) {
                return 1;
            }
            if (type == 0) {
                switch (C1105h.m4882a(networkInfo.getSubtype())) {
                    case 0:
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 4;
                    default:
                        return 2;
                }
            } else if (9 == type) {
                return 1;
            } else {
                if (6 == type) {
                    return 4;
                }
            }
        }
        return 0;
    }

    public static int m4882a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    public static NetworkInfo m4907d(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static int m4898b(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 4;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    public static void m4892a(OutputStream outputStream, String str) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                if (TextUtils.isEmpty(str)) {
                    if (C1103f.m4877a(4)) {
                        C1103f.m4880d("feedback_upload_Utils", e.getMessage());
                    }
                } else if (C1103f.m4877a(4)) {
                    C1103f.m4880d(str, e.getMessage());
                }
            }
        }
    }

    public static void m4893a(Exception exception, String str) {
        if (C1103f.m4877a(4) && exception != null && exception.getMessage() != null) {
            C1103f.m4880d(str, exception.getMessage());
        }
    }

    public static void m4891a(InputStream inputStream, String str) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                if (TextUtils.isEmpty(str)) {
                    if (C1103f.m4877a(4)) {
                        C1103f.m4880d("feedback_upload_Utils", e.getMessage());
                    }
                } else if (C1103f.m4877a(4)) {
                    C1103f.m4880d(str, e.getMessage());
                }
            }
        }
    }

    public static void m4890a(DataOutputStream dataOutputStream, String str) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                if (TextUtils.isEmpty(str)) {
                    if (C1103f.m4877a(4)) {
                        C1103f.m4880d("feedback_upload_Utils", e.getMessage());
                    }
                } else if (C1103f.m4877a(4)) {
                    C1103f.m4880d(str, e.getMessage());
                }
            }
        }
    }

    public static void m4888a(Context context, LogUpload logUpload, boolean z) {
        Intent intent = new Intent(MetricConstant.ACTION_UPLOAD_RESULT_INTENT);
        intent.setClassName(logUpload.m4760C(), logUpload.m4761D());
        intent.putExtra("logId", logUpload.m4800i());
        String m = logUpload.m4808m();
        if (!(m == null || m.equals(""))) {
            C1103f.m4878b("feedback_upload_Utils", "policy存在，将policy信息发送给服务器 =" + m);
            intent.putExtra("serverCommand", m);
        }
        if (z) {
            C1103f.m4880d("feedback_upload_Utils", "Upload successfully! The file is deleting... ");
            intent.putExtra("uploadResult", 0);
        } else {
            C1103f.m4880d("feedback_upload_Utils", "Upload failed!");
            intent.putExtra("uploadResult", 1);
        }
        intent.putExtra("submitFlag", logUpload.m4806l());
        C1103f.m4880d("feedback_upload_Utils", "submitFlag" + logUpload.m4806l());
        int b = C1105h.m4898b(C1105h.m4883a(C1105h.m4907d(context)));
        intent.putExtra("resultFlag", b);
        C1103f.m4878b("feedback_upload_Utils", "resultFlag" + b);
        C1103f.m4878b("feedback_upload_Utils", "Upload sendBroadcast to " + logUpload.m4760C() + logUpload.m4761D());
        context.sendBroadcast(intent);
    }

    public static void m4889a(LogUpload logUpload) {
        String x = logUpload.m4824x();
        if (x != null && !x.equals("")) {
            File file = new File(x);
            if (file.exists() && file.delete()) {
                C1103f.m4878b("feedback_upload_Utils", "文件删除成功！");
            } else {
                C1103f.m4878b("feedback_upload_Utils", "文件不存在 或者 出错！文件删除失败!");
            }
        }
    }

    public static int m4909e(Context context) {
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

    public static void m4905c() {
        SSLSocketFactory hVar;
        try {
            hVar = new h();
        } catch (Exception e) {
            C1103f.m4878b("feedback_upload_Utils", "Utils:initHttpsURLConnection Exception");
            hVar = null;
        }
        if (hVar != null) {
            HttpsURLConnection.setDefaultSSLSocketFactory(hVar);
        }
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        } catch (Exception e2) {
            d.a(e2, "Fail to set DefaultHostnameVerifier!");
        }
    }

    public static int m4884a(String str) {
        Integer num = (Integer) C1102c.m4867c().get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static void m4903b(String str) {
        C1103f.m4880d("feedback_upload_Utils", "removeTaskStatus id: " + str);
        C1102c.m4867c().remove(str);
    }

    public static void m4894a(String str, int i) {
        C1103f.m4880d("feedback_upload_Utils", "setTaskStatus id: " + str);
        C1102c.m4867c().put(str, Integer.valueOf(i));
    }

    public static void m4911f(Context context) {
        C1103f.m4880d("feedback_upload_Utils", "lockCreate");
        if (C1102c.m4869d() == null) {
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "phoneservice_logupload_wakelock");
            newWakeLock.setReferenceCounted(true);
            C1102c.m4864a(newWakeLock);
        }
        if (C1102c.m4871e() == null) {
            WifiLock createWifiLock = ((WifiManager) context.getSystemService("wifi")).createWifiLock("phoneservice_logupload_wifilock");
            createWifiLock.setReferenceCounted(true);
            C1102c.m4863a(createWifiLock);
        }
    }

    public static void m4908d() {
        C1103f.m4880d("feedback_upload_Utils", "acquire: get wake and wifi lock!");
        if (!(C1102c.m4869d() == null || C1105h.m4913g())) {
            C1102c.m4869d().acquire();
        }
        if (C1102c.m4871e() != null && !C1105h.m4912f()) {
            C1102c.m4871e().acquire();
        }
    }

    public static void m4910e() {
        C1103f.m4880d("feedback_upload_Utils", "release: release wake and wifi lock!");
        if (C1105h.m4913g()) {
            C1103f.m4880d("feedback_upload_Utils", "release: have holden the wake lock");
            try {
                C1102c.m4869d().release();
            } catch (Exception e) {
                C1103f.m4880d("feedback_upload_Utils", "release wake lock exception");
            }
        }
        if (C1105h.m4912f()) {
            C1103f.m4880d("feedback_upload_Utils", "release: have holden the wifi lock");
            try {
                C1102c.m4871e().release();
            } catch (Exception e2) {
                C1103f.m4880d("feedback_upload_Utils", "release wifi lock exception");
            }
        }
    }

    public static boolean m4912f() {
        if (C1102c.m4871e() != null) {
            return C1102c.m4871e().isHeld();
        }
        return false;
    }

    public static boolean m4913g() {
        if (C1102c.m4869d() != null) {
            return C1102c.m4869d().isHeld();
        }
        return false;
    }

    public static String m4887a(String str, String str2) {
        byte[] decode = Base64.decode(str2, 2);
        byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        Key generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decode));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePrivate);
        return Base64.encodeToString(instance.doFinal(bytes), 2);
    }

    public static String m4904c(String str) {
        int i = 0;
        char[] cArr = new char[str.length()];
        for (int length = str.length() - 1; i <= length; length--) {
            cArr[i] = str.charAt(length);
            cArr[length] = str.charAt(i);
            i++;
        }
        return String.valueOf(cArr);
    }

    public static String m4901b(String str, int i) {
        if (i == 0) {
            return str;
        }
        if (i > 0) {
            int length = i % str.length();
            String c = C1105h.m4904c(str.substring(0, length));
            return C1105h.m4904c(new StringBuilder(String.valueOf(c)).append(C1105h.m4904c(str.substring(length))).toString());
        }
        return C1105h.m4901b(str, str.length() - ((-i) % str.length()));
    }

    public static String m4915h() {
        String str = null;
        try {
            int nextInt = new SecureRandom().nextInt(900000) + 100000;
            str = "osgforandroid" + ":" + nextInt + ":" + C1105h.m4887a(String.valueOf(nextInt), C1105h.m4917i()).trim();
        } catch (Exception e) {
            C1103f.m4880d("feedback_upload_Utils", "encrypt By Private Key error ....");
        }
        return str;
    }

    public static String m4917i() {
        return new StringBuilder(String.valueOf(C1105h.m4901b(C1102c.m4861a(), -3))).append(d.a()).append(C1105h.m4901b(e.a(), -3)).append(g.a()).append(C1105h.m4901b(C1105h.m4885a(), -3)).append(a.a()).toString();
    }

    public static void m4902b(LogUpload logUpload) {
        C1103f.m4878b("feedback_upload_Utils", "finish");
        if (!logUpload.m4759B() && !C1110k.m4924a()) {
            if (logUpload.m4763F() == 1) {
                C1103f.m4878b("feedback_upload_Utils", "*****Beta Log End Upload******");
            } else if (logUpload.m4763F() == 2) {
                C1103f.m4878b("feedback_upload_Utils", "*****Fans Log End Upload******");
            } else if (logUpload.m4763F() == 3) {
                C1103f.m4878b("feedback_upload_Utils", "*****Dev Log End Upload******");
            } else if (logUpload.m4763F() == 4) {
                C1103f.m4878b("feedback_upload_Utils", "*****FEEDBACK Log End Upload******");
            }
            new i(logUpload).start();
        }
    }

    public static boolean m4897a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str, str2) == 0;
    }

    private static boolean m4918j() {
        try {
            Class cls = Class.forName("android.telephony.HwTelephonyManager");
            if (cls == null) {
                return false;
            }
            AccessibleObject declaredField = cls.getDeclaredField("SUPPORT_SYSTEMAPP_GET_DEVICEID");
            C1105h.m4895a(declaredField);
            int i = declaredField.getInt(cls);
            C1103f.m4879c("feedback_upload_Utils", "supportNewPermissionCheck value=" + i);
            if (i == 1) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            C1103f.m4880d("feedback_upload_Utils", "ClassNotFoundException");
            C1103f.m4879c("feedback_upload_Utils", "not support New Permission");
            return false;
        } catch (NoSuchFieldException e2) {
            C1103f.m4880d("feedback_upload_Utils", "NoSuchFieldException");
            C1103f.m4879c("feedback_upload_Utils", "not support New Permission");
            return false;
        } catch (IllegalAccessException e3) {
            C1103f.m4880d("feedback_upload_Utils", "IllegalAccessException");
            C1103f.m4879c("feedback_upload_Utils", "not support New Permission");
            return false;
        } catch (IllegalArgumentException e4) {
            C1103f.m4880d("feedback_upload_Utils", "IllegalArgumentException");
            C1103f.m4879c("feedback_upload_Utils", "not support New Permission");
            return false;
        } catch (Exception e5) {
            C1103f.m4880d("feedback_upload_Utils", "Exception ");
            C1103f.m4879c("feedback_upload_Utils", "not support New Permission");
            return false;
        }
    }

    public static boolean m4914g(Context context) {
        if (context == null) {
            return false;
        }
        Object packageName = context.getPackageName();
        try {
            if (TextUtils.isEmpty(packageName) || (context.getPackageManager().getApplicationInfo(packageName, 0).flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            C1103f.m4880d("feedback_upload_Utils", "isSystemApp NameNotFoundException");
            return false;
        }
    }

    public static boolean m4896a(Context context, boolean z) {
        if (context == null) {
            return false;
        }
        if (z && C1105h.m4914g(context) && C1105h.m4918j()) {
            C1103f.m4880d("feedback_upload_Utils", "supportNewPermission");
            return true;
        } else if (VERSION.SDK_INT <= 22 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            C1103f.m4880d("feedback_upload_Utils", "have READ_PHONE_STATE permission");
            return true;
        } else {
            C1103f.m4880d("feedback_upload_Utils", "no have READ_PHONE_STATE Permission");
            return false;
        }
    }

    private static void m4895a(AccessibleObject accessibleObject) {
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
    }

    public static String m4916h(Context context) {
        if (context != null) {
            if (VERSION.SDK_INT >= 26) {
                C1103f.m4880d("feedback_upload_Utils", "is o version");
                if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                    return Build.getSerial();
                }
                C1103f.m4880d("feedback_upload_Utils", "is o version,but have not permission");
            } else {
                C1103f.m4880d("feedback_upload_Utils", "is not o version");
                String b = C1105h.m4899b();
                if (!TextUtils.isEmpty(b)) {
                    return b;
                }
            }
        }
        return "000000000000000";
    }
}
