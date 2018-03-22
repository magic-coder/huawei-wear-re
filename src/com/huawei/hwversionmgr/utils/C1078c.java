package com.huawei.hwversionmgr.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.huawei.hwversionmgr.p079a.C1069e;
import com.huawei.hwversionmgr.utils.b.a;
import com.huawei.p190v.C2538c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.params.HttpParams;

/* compiled from: HwSelfUpdateUtility */
public class C1078c {
    private static String f2163a = null;
    private static String f2164b = null;
    private static String f2165c = null;
    private static C1069e f2166d = new C1069e();
    private static C1069e f2167e = new C1069e();
    private static String f2168f = "https://query.hicloud.com/Ring/v2/CheckEx.action?ruleAttr=true";
    private static String f2169g = "https://query.hicloud.com/Ring/v2/UpdateReport.action";
    private static int f2170h = -1;
    private static int f2171i = 0;
    private static long f2172j = -1;
    private static boolean f2173k = false;

    public static String m4556a() {
        return f2168f;
    }

    public static void m4563a(String str) {
        f2168f = str;
    }

    public static String m4567b() {
        return f2169g;
    }

    public static String m4573c() {
        return f2165c;
    }

    public static long m4575d() {
        return f2172j;
    }

    public static void m4559a(long j) {
        f2172j = j;
    }

    public static boolean m4580e() {
        return f2173k;
    }

    public static void m4565a(boolean z) {
        f2173k = z;
    }

    public static int m4581f() {
        return f2170h;
    }

    public static void m4558a(int i) {
        f2170h = i;
    }

    public static int m4584g() {
        return f2171i;
    }

    public static void m4568b(int i) {
        f2171i = i;
    }

    public static void m4561a(Context context, String str, String str2) {
        String str3 = "chmod -R 777 " + context.getFilesDir();
        String str4 = "chmod -R 777 " + str;
        C1078c.m4579e(str3);
        C1078c.m4579e(str4);
        new Thread(new a(context, str, str2)).start();
    }

    private static void m4579e(String str) {
        try {
            C2538c.m12677c("HwSelfUpdateUtility", "get Permission begin");
            if (Runtime.getRuntime().exec(str) != null) {
                C2538c.m12677c("HwSelfUpdateUtility", "process is not null");
            }
            C2538c.m12677c("HwSelfUpdateUtility", "filePermission end");
        } catch (IOException e) {
            C2538c.m12677c("HwSelfUpdateUtility", "modify permission fail: IOException");
        }
    }

    private static String m4578e(Context context) {
        String str = context.getApplicationInfo().dataDir + "/files";
        if (C1078c.m4583f(str) || new File(str).mkdirs()) {
        }
        return str + "/libbspatchforselfupdate.so";
    }

    private static boolean m4583f(String str) {
        return new File(str).exists();
    }

    private static void m4582f(Context context) {
        InputStream open;
        SecurityException e;
        InputStream inputStream;
        Throwable th;
        IOException e2;
        OutputStream outputStream = null;
        OutputStream fileOutputStream;
        try {
            open = context.getResources().getAssets().open("libbspatchforselfupdate.so", 3);
            try {
                fileOutputStream = new FileOutputStream(new File(f2163a));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = open.read(bArr, 0, 8192);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (SecurityException e5) {
                    e = e5;
                    inputStream = open;
                    try {
                        C2538c.m12680e("HwSelfUpdateUtility", "copySOFile, SecurityException : " + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (inputStream == null) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        open = inputStream;
                        outputStream = fileOutputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e9) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    e2 = e10;
                    outputStream = fileOutputStream;
                    try {
                        C2538c.m12680e("HwSelfUpdateUtility", "copySOFile, IOException : " + e2.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e11) {
                            }
                        }
                        if (open == null) {
                            try {
                                open.close();
                            } catch (IOException e12) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (open != null) {
                            open.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = fileOutputStream;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (open != null) {
                        open.close();
                    }
                    throw th;
                }
            } catch (SecurityException e13) {
                e = e13;
                fileOutputStream = null;
                inputStream = open;
                C2538c.m12680e("HwSelfUpdateUtility", "copySOFile, SecurityException : " + e.getMessage());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (IOException e14) {
                e2 = e14;
                C2538c.m12680e("HwSelfUpdateUtility", "copySOFile, IOException : " + e2.getMessage());
                if (outputStream != null) {
                    outputStream.close();
                }
                if (open == null) {
                    open.close();
                }
            }
        } catch (SecurityException e15) {
            e = e15;
            fileOutputStream = null;
            C2538c.m12680e("HwSelfUpdateUtility", "copySOFile, SecurityException : " + e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream == null) {
                inputStream.close();
            }
        } catch (IOException e16) {
            e2 = e16;
            open = null;
            C2538c.m12680e("HwSelfUpdateUtility", "copySOFile, IOException : " + e2.getMessage());
            if (outputStream != null) {
                outputStream.close();
            }
            if (open == null) {
                open.close();
            }
        } catch (Throwable th5) {
            th = th5;
            open = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    public static boolean m4566a(Context context) {
        if (C1078c.m4583f(context.getApplicationInfo().dataDir + "/files/libbspatchforselfupdate.so")) {
            return true;
        }
        return false;
    }

    public static void m4560a(Context context, String str) {
        f2164b = str;
        try {
            f2163a = C1078c.m4578e(context);
            if (!C1078c.m4583f(f2163a)) {
                C1078c.m4582f(context);
            }
            System.load(f2163a);
        } catch (Exception e) {
        }
    }

    public int m4589a(Context context, String str, String str2, String str3) {
        return C1078c.m4566a(context) ? -1 : -1;
    }

    public static String m4586h() {
        return f2164b;
    }

    public static void m4570b(String str) {
        f2164b = str;
    }

    public static long m4572c(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }

    public static boolean m4577d(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.delete()) {
            return true;
        }
        return false;
    }

    public static boolean m4571b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static void m4564a(HttpRequest httpRequest, HttpClient httpClient, Context context) {
        String host = Proxy.getHost(context);
        int port = Proxy.getPort(context);
        NetworkInfo g = C1078c.m4585g(context);
        if ((g == null || g.getType() != 1) && host != null && host.length() > 0 && port != -1) {
            HttpParams params = httpClient.getParams();
            ConnRouteParams.setDefaultProxy(params, new HttpHost(host, port));
            httpRequest.setParams(params);
        }
    }

    private static NetworkInfo m4585g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
    }

    public static C1069e m4587i() {
        return f2166d;
    }

    public static void m4562a(C1069e c1069e) {
        f2166d = c1069e;
    }

    public static C1069e m4588j() {
        return f2167e;
    }

    public static void m4569b(C1069e c1069e) {
        f2167e = c1069e;
    }

    public static String m4574c(Context context) {
        String str = "";
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            C2538c.m12677c("HwSelfUpdateUtility", "getIMEI() Exception");
            return str;
        }
    }

    public static String m4576d(Context context) {
        String str = "";
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            C2538c.m12677c("HwSelfUpdateUtility", "getIMEI() Exception");
            return "";
        }
    }

    public static String m4557a(String str, Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return null;
    }
}
