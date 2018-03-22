package com.huawei.uploadlog.p188c;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.uploadlog.C2525h;
import com.huawei.uploadlog.C2529l;
import com.huawei.uploadlog.LogUpload;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.p198a.p199a.p200a.p201a.C2765a;

/* compiled from: Utils */
public final class C2517m {
    private static String f9000a = "oslkg25DPlFZMMhRLOw1hPBUSmiTlOsoHzz5gzlc7q1KxBut0X7ECfGgyrjAkEAi4+xZuWwsbc26mYLKi5woq0VoH9xhGFYRJQRxaYdtfRd017f2lJRrxalunIFPFoV899XUWGMVcRLJrfa";

    public static String m12564a() {
        return f9000a;
    }

    public static boolean m12573a(String str, String str2) {
        if (str == null) {
            return true;
        }
        try {
            return str.replaceAll(str2, "").isEmpty();
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[StringUtils.isAll] error:", e);
            return false;
        }
    }

    public static String m12577b() {
        String str = "";
        try {
            return ((TelephonyManager) AppContext.getInstance().getApplication().getSystemService("phone")).getSubscriberId();
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[Utils.getIMSI] get imsi error:", e);
            return str;
        }
    }

    public static int m12561a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (1 == type) {
                return 1;
            }
            if (type == 0) {
                switch (C2517m.m12559a(networkInfo.getSubtype())) {
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

    public static int m12559a(int i) {
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

    public static NetworkInfo m12562a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static int m12574b(int i) {
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

    public static FileInputStream m12563a(String str) {
        try {
            return new FileInputStream(str);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[Utils.open] error:", e);
            return null;
        }
    }

    public static void m12572a(Exception exception, String str) {
        C2511g.m12484d(str, "[Utils.logException]error" + exception);
    }

    public static void m12571a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                if (StringUtils.isNullOrEmpty(str)) {
                    str = "BETACLUB_SDK";
                }
                C2511g.m12482b(str, "[Utils.close] error:", e);
            }
        }
    }

    public static void m12566a(Context context, LogUpload logUpload, boolean z) {
        Intent intent = new Intent("com.huawei.crowdtestsdk.UPLOAD_RESULT");
        intent.setClassName(logUpload.getFeedBackPackageName(), logUpload.getFeedBackClassName());
        intent.putExtra("logId", logUpload.getId());
        intent.putExtra("filepath", logUpload.getFilePath());
        String policy = logUpload.getPolicy();
        if (!StringUtils.isNullOrEmpty(policy)) {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.sendResultBroadcast] policy存在，将policy信息发送给服务器 =" + policy);
            intent.putExtra("serverCommand", policy);
        }
        if (z) {
            C2511g.m12484d("BETACLUB_SDK", "[Utils.sendResultBroadcast] Upload successfully! The file is deleting... ");
            intent.putExtra("uploadResult", 0);
        } else {
            C2511g.m12484d("BETACLUB_SDK", "[Utils.sendResultBroadcast] Upload failed!");
            intent.putExtra("uploadResult", 1);
        }
        intent.putExtra("submitFlag", logUpload.getFlags());
        C2511g.m12484d("BETACLUB_SDK", "[Utils.sendResultBroadcast] submitFlag" + logUpload.getFlags());
        int b = C2517m.m12574b(C2517m.m12561a(C2517m.m12562a(context)));
        intent.putExtra("resultFlag", b);
        C2511g.m12481b("BETACLUB_SDK", "[Utils.sendResultBroadcast] resultFlag" + b);
        C2511g.m12481b("BETACLUB_SDK", "[Utils.sendResultBroadcast] Upload sendBroadcast to " + logUpload.getFeedBackPackageName() + "/" + logUpload.getFeedBackClassName());
        context.sendBroadcast(intent);
    }

    public static void m12569a(LogUpload logUpload) {
        String encryptedFile = logUpload.getEncryptedFile();
        C2511g.m12481b("BETACLUB_SDK", "[Utils.deleteEncryptedFile] encryptedFilePath=" + encryptedFile);
        if (!StringUtils.isNullOrEmpty(encryptedFile)) {
            File file = new File(encryptedFile);
            C2511g.m12481b("BETACLUB_SDK", "[Utils.deleteEncryptedFile] encryptedFilePath=" + file.getAbsolutePath());
            if (file.exists() && file.delete()) {
                C2511g.m12481b("BETACLUB_SDK", "[Utils.deleteEncryptedFile] 文件删除成功！");
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[Utils.deleteEncryptedFile] 文件不存在 或者 出错！文件删除失败!");
            }
        }
    }

    public static int m12575b(Context context) {
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

    public static void m12580c() {
        SSLSocketFactory c2525h;
        try {
            c2525h = new C2525h();
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[Utils.initHttpsURLConnection] Exception", e);
            c2525h = null;
        }
        if (c2525h != null) {
            HttpsURLConnection.setDefaultSSLSocketFactory(c2525h);
        }
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        } catch (Exception e2) {
            C2508d.m12470a(e2, "[Utils.initHttpsURLConnection] Fail to set DefaultHostnameVerifier!");
        }
    }

    public static int m12576b(LogUpload logUpload) {
        if (logUpload == null) {
            return 0;
        }
        C2511g.m12484d("BETACLUB_SDK", "[Utils.getTaskStatus] getTaskStatus id: " + logUpload.getId());
        int intValue = ((Integer) C2507c.m12462c().get(logUpload.getId(), Integer.valueOf(0))).intValue();
        C2511g.m12484d("BETACLUB_SDK", "[Utils.getTaskStatus] status: " + intValue);
        return intValue;
    }

    public static void m12582c(LogUpload logUpload) {
        long id = logUpload.getId();
        C2511g.m12484d("BETACLUB_SDK", "[Utils.removeTaskStatus] removeTaskStatus id: " + id);
        C2507c.m12462c().remove(id);
        C2529l.m12609b(logUpload);
    }

    public static void m12570a(LogUpload logUpload, int i) {
        long id = logUpload.getId();
        C2511g.m12484d("BETACLUB_SDK", "[Utils.removeTaskStatus] setTaskStatus id: " + id);
        C2529l.m12605a(logUpload);
        C2507c.m12462c().put(id, Integer.valueOf(i));
    }

    public static void m12581c(Context context) {
        C2511g.m12484d("BETACLUB_SDK", "[Utils.lockCreate] <>");
        if (C2507c.m12464d() == null) {
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "betaclub_logupload_wakelock");
            newWakeLock.setReferenceCounted(true);
            C2507c.m12459a(newWakeLock);
        }
        if (C2507c.m12465e() == null) {
            WifiLock createWifiLock = ((WifiManager) context.getSystemService("wifi")).createWifiLock("betaclub_logupload_wifilock");
            createWifiLock.setReferenceCounted(true);
            C2507c.m12458a(createWifiLock);
        }
    }

    public static void m12584d() {
        C2511g.m12484d("BETACLUB_SDK", "[Utils.acquire] get wake and wifi lock!");
        if (!(C2507c.m12464d() == null || C2517m.m12587g())) {
            C2507c.m12464d().acquire();
        }
        if (C2507c.m12465e() != null && !C2517m.m12586f()) {
            C2507c.m12465e().acquire();
        }
    }

    public static void m12585e() {
        C2511g.m12484d("BETACLUB_SDK", "[Utils.release] release wake and wifi lock!");
        if (C2517m.m12587g()) {
            C2511g.m12484d("BETACLUB_SDK", "[Utils.release] have holden the wake lock");
            C2507c.m12464d().release();
        }
        if (C2517m.m12586f()) {
            C2511g.m12484d("BETACLUB_SDK", "[Utils.release] have holden the wifi lock");
            C2507c.m12465e().release();
        }
    }

    public static boolean m12586f() {
        if (C2507c.m12465e() != null) {
            return C2507c.m12465e().isHeld();
        }
        return false;
    }

    public static boolean m12587g() {
        if (C2507c.m12464d() != null) {
            return C2507c.m12464d().isHeld();
        }
        return false;
    }

    public static String m12579b(String str, String str2) throws Exception {
        byte[] a = C2765a.m12868a(str2);
        byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        Key generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(a));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePrivate);
        return C2765a.m12867a(instance.doFinal(bytes));
    }

    public static String m12578b(String str) {
        int i = 0;
        char[] cArr = new char[str.length()];
        for (int length = str.length() - 1; i <= length; length--) {
            cArr[i] = str.charAt(length);
            cArr[length] = str.charAt(i);
            i++;
        }
        return String.valueOf(cArr);
    }

    public static String m12565a(String str, int i) {
        if (i == 0) {
            return str;
        }
        if (i > 0) {
            int length = i % str.length();
            String b = C2517m.m12578b(str.substring(0, length));
            return C2517m.m12578b(b + C2517m.m12578b(str.substring(length)));
        }
        return C2517m.m12565a(str, str.length() - ((-i) % str.length()));
    }

    public static String m12588h() {
        String str = null;
        try {
            int nextInt = new SecureRandom().nextInt(900000) + 100000;
            String b = C2517m.m12579b(String.valueOf(nextInt), C2517m.m12589i());
            str = "osgforandroid" + ":" + nextInt + ":" + b.trim();
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "encrypt By Private Key error ....", e);
        }
        return str;
    }

    public static String m12589i() {
        return C2517m.m12565a(C2507c.m12456a(), -3) + C2508d.m12469a() + C2517m.m12565a(C2510f.m12473a(), -3) + C2512h.m12485a() + C2517m.m12565a(C2517m.m12564a(), -3) + C2505a.m12447a();
    }

    public static int m12560a(long j) {
        if (j >= 104857600 && j < 314572800) {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.getUploadTimeoutValue]HTTP client timeout:50000");
            return 50000;
        } else if (j >= 314572800 && j < 524288000) {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.getUploadTimeoutValue]HTTP client timeout:70000");
            return 70000;
        } else if (j >= 524288000 && j < 838860800) {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.getUploadTimeoutValue]HTTP client timeout:90000");
            return 90000;
        } else if (j >= 838860800) {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.getUploadTimeoutValue]HTTP client timeout:120000");
            return SdkConstants.TIME_OUT;
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.getUploadTimeoutValue]HTTP client timeout:30000");
            return 30000;
        }
    }

    public static void m12567a(Context context, String str, String str2, boolean z) {
        if (context != null) {
            C2517m.m12568a(context, str2, z);
        }
    }

    private static void m12568a(Context context, String str, boolean z) {
        Intent intent = new Intent(SdkConstants.ACTION_LOG_UPLOAD_RESULT);
        String fileNameByPath = FileUtils.getFileNameByPath(str);
        C2511g.m12481b("BETACLUB_SDK", "[Utils.sendResultBroadcastInWearChannel] fileName " + fileNameByPath);
        if (z) {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.sendResultBroadcastInWearChannel] Upload successfully! ");
            C2517m.m12583c(str);
            C2511g.m12481b("BETACLUB_SDK", "[Utils.sendResultBroadcastInWearChannel] dropLog successfully! ");
            intent.putExtra(SdkConstants.LOG_UPLOAD_RESULT, 16);
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[Utils.sendResultBroadcastInWearChannel] Upload failed!");
            intent.putExtra(SdkConstants.LOG_UPLOAD_RESULT, 17);
        }
        intent.putExtra(SdkConstants.LOG_UPLOAD_FILENAME, fileNameByPath);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public static void m12583c(String str) {
        new Thread(new C2518n(str)).start();
    }
}
