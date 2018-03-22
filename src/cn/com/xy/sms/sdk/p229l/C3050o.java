package cn.com.xy.sms.sdk.p229l;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2952s;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;

public class C3050o {
    private static String f10297a = null;
    private static String f10298b = null;
    private static JSONObject f10299c = null;

    public static int m13663a(Context context) {
        return C3050o.m13664a(context, 1);
    }

    public static int m13664a(Context context, int i) {
        if (context == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            switch (i) {
                case 0:
                    return C3050o.m13684c(type) ? 0 : 1;
                case 1:
                    return C3041f.m13609b().m13092a(context) == 1 ? 1 : C3050o.m13681b(type) ? 0 : 1;
                case 2:
                    return (C3050o.m13681b(type) || C3050o.m13684c(type)) ? 0 : 1;
            }
        }
        return -1;
    }

    public static LineNumberReader m13665a(String str) {
        try {
            return new LineNumberReader(new StringReader(new String(C3050o.m13677a(C3055t.m13714e(str)), GameManager.DEFAULT_CHARSET)));
        } catch (Throwable th) {
            return null;
        }
    }

    public static String m13666a() {
        String b = C3041f.m13609b().m13102b(0);
        if (C3049n.m13653e(b)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) C2917a.m13105a().getSystemService("phone");
                if (!C3049n.m13653e(telephonyManager.getSimSerialNumber())) {
                    return telephonyManager.getSimSerialNumber();
                }
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", "getIccid: " + e.getMessage(), e);
            }
        }
        return b;
    }

    public static String m13667a(int i) {
        if (i == 1) {
            if (f10297a == null) {
                f10297a = C3047l.m13628a(i);
            }
            return f10297a;
        }
        if (f10298b == null) {
            f10298b = C3047l.m13628a(i);
        }
        return f10298b;
    }

    public static void m13668a(double d, double d2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lat", d);
        jSONObject.put("lng", d2);
        jSONObject.put("locationTime", System.currentTimeMillis());
        C2947n.m13274a("LOACTION", C3049n.m13654f(jSONObject.toString()));
        C3050o.m13675a(jSONObject);
    }

    public static void m13669a(C2904g c2904g, String str) {
        if (c2904g != null) {
            try {
                c2904g.execute(str);
            } catch (Throwable th) {
            }
        }
    }

    public static void m13670a(C2904g c2904g, Object... objArr) {
        if (c2904g != null) {
            try {
                c2904g.execute(objArr);
            } catch (Throwable th) {
            }
        }
    }

    public static void m13671a(File file, String str) {
        C3050o.m13672a(file, str, false, "", false);
    }

    public static void m13672a(File file, String str, boolean z, String str2, boolean z2) {
        Closeable closeable;
        Closeable inputStream;
        Throwable th;
        ZipFile zipFile;
        Closeable closeable2 = null;
        ZipFile zipFile2;
        try {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            zipFile2 = new ZipFile(file);
            try {
                Enumeration entries = zipFile2.entries();
                closeable = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        inputStream = zipFile2.getInputStream(zipEntry);
                        try {
                            if (C3049n.m13653e(zipEntry.getName())) {
                                closeable = inputStream;
                            } else {
                                String str3 = new String(zipEntry.getName().getBytes("8859_1"), "GB2312");
                                if (z2 && !C3049n.m13653e(str3) && str3.endsWith("jar")) {
                                    String replace = str3.replace(".jar", "");
                                    C2952s.m13292a(replace, str2, C2952s.m13293b(replace));
                                }
                                if (z && !C3049n.m13653e(str3) && str3.endsWith("jar")) {
                                    str3 = str3.replace(".jar", new StringBuilder(HwAccountConstants.SPLIIT_UNDERLINE).append(str2).append(".jar").toString()).replaceAll("\\.\\.", "");
                                }
                                str3 = new StringBuilder(String.valueOf(str)).append(File.separator).append(str3).toString();
                                if (C2982a.f10101a) {
                                    new StringBuilder("  upZipFile : ").append(str3).append(" folderPath: ").append(str).append(" entryName: ").append(zipEntry.getName());
                                }
                                file2 = new File(str3);
                                if (file2.exists()) {
                                    file2.delete();
                                } else {
                                    File parentFile = file2.getParentFile();
                                    if (!parentFile.exists()) {
                                        parentFile.mkdirs();
                                    }
                                    file2.createNewFile();
                                }
                                closeable = new FileOutputStream(file2);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        closeable.write(bArr, 0, read);
                                    }
                                    C3055t.m13696a(inputStream);
                                    C3055t.m13696a(closeable);
                                    closeable2 = closeable;
                                    closeable = inputStream;
                                } catch (Throwable th2) {
                                    th = th2;
                                    closeable2 = closeable;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = closeable;
                    }
                }
                C3055t.m13703a(zipFile2);
                C3055t.m13696a(closeable);
                C3055t.m13696a(closeable2);
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                C3055t.m13703a(zipFile2);
                C3055t.m13696a(inputStream);
                C3055t.m13696a(closeable2);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            zipFile2 = null;
            C3055t.m13703a(zipFile2);
            C3055t.m13696a(inputStream);
            C3055t.m13696a(closeable2);
            throw th;
        }
    }

    public static void m13673a(InputStream inputStream, String str, String str2) {
        C3050o.m13674a(inputStream, str, str2, false, "", false);
    }

    public static void m13674a(InputStream inputStream, String str, String str2, boolean z, String str3, boolean z2) {
        Throwable th;
        File file;
        Closeable closeable = null;
        try {
            File file2 = new File(new StringBuilder(String.valueOf(str2)).append(str).toString());
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                Closeable fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                    C3050o.m13672a(file2, str2, z, str3, z2);
                    file2.delete();
                    new StringBuilder("unZip: file: ").append(str).append("处理成功！");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    C3055t.m13696a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileOutputStream;
                    file = file2;
                }
            } catch (Throwable th3) {
                th = th3;
                file = file2;
                file.delete();
                C3055t.m13696a(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            file = null;
            if (file != null && file.exists()) {
                file.delete();
            }
            C3055t.m13696a(closeable);
            throw th;
        }
    }

    public static void m13675a(JSONObject jSONObject) {
        f10299c = jSONObject;
    }

    public static boolean m13676a(String str, String str2) {
        ZipFile zipFile;
        Closeable closeable;
        Throwable th;
        ZipFile zipFile2;
        Closeable closeable2 = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            zipFile = new ZipFile(new File(str));
            try {
                Enumeration entries = zipFile.entries();
                closeable = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (!C3049n.m13653e(zipEntry.getName())) {
                            closeable2 = zipFile.getInputStream(zipEntry);
                            File file2 = new File(new StringBuilder(String.valueOf(str2)).append(File.separator).append(new String(zipEntry.getName().getBytes("8859_1"), "GB2312").replace("\\.\\.", "")).toString());
                            if (file2.exists()) {
                                file2.delete();
                            } else {
                                file = file2.getParentFile();
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                file2.createNewFile();
                            }
                            Closeable fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = closeable2.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                C3055t.m13696a(closeable2);
                                C3055t.m13696a(fileOutputStream);
                                closeable = fileOutputStream;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileOutputStream;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                C3055t.m13703a(zipFile);
                C3055t.m13696a(closeable2);
                C3055t.m13696a(closeable);
                return true;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                C3055t.m13703a(zipFile);
                C3055t.m13696a(closeable2);
                C3055t.m13696a(closeable);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            zipFile = null;
            C3055t.m13703a(zipFile);
            C3055t.m13696a(closeable2);
            C3055t.m13696a(closeable);
            throw th;
        }
    }

    public static byte[] m13677a(byte[] bArr) {
        byte[] bArr2 = null;
        int i = 0;
        if (!(bArr == null || bArr.length == 0)) {
            bArr2 = new byte[0];
            Inflater inflater = new Inflater();
            inflater.reset();
            inflater.setInput(bArr);
            Closeable byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr3 = new byte[2560];
                long currentTimeMillis = System.currentTimeMillis();
                while (!inflater.finished() && !inflater.needsInput()) {
                    int inflate = inflater.inflate(bArr3);
                    if (inflate > 0) {
                        byteArrayOutputStream.write(bArr3, 0, inflate);
                    }
                    if (i % 200 == 1) {
                        Thread.sleep(1);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis > 10000) {
                        C2982a.m13415a("duoqu_test", "decompressBytes: > 5000", null);
                        break;
                    }
                    i++;
                }
                C2982a.m13415a("duoqu_test", "decompressBytes: cnt " + i, null);
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    inflater.reset();
                    C3055t.m13696a(byteArrayOutputStream);
                    inflater.end();
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "decompressBytes: " + th.getMessage(), th);
                }
            } catch (Throwable th2) {
                C2982a.m13415a("XIAOYUAN", "decompressBytes: " + th2.getMessage(), th2);
            }
        }
        return bArr2;
    }

    public static String m13678b(Context context) {
        if (context != null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    if (telephonyManager.getDeviceId() != null) {
                        return telephonyManager.getDeviceId();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return "360_DEFAULT_IMEI";
    }

    public static void m13679b() {
        C2947n.m13274a("areaCode", "");
    }

    public static void m13680b(String str, String str2) {
        try {
            if (!C3049n.m13653e(str2)) {
                Runtime.getRuntime().exec("chmod " + str + HwAccountConstants.BLANK + str2);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "chmod: " + th.getMessage(), th);
        }
    }

    private static boolean m13681b(int i) {
        return i == 1;
    }

    public static String m13682c(Context context) {
        return C3050o.m13678b(context) + ";" + C3050o.m13685d(context);
    }

    public static void m13683c(String str, String str2) {
        try {
            C2978a.f10090a.execute(new C3043h(str, str2));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "chmod: " + th.getMessage(), th);
        }
    }

    private static boolean m13684c(int i) {
        return i == 0 || i == 4 || i == 5 || i == 2 || i == 3;
    }

    public static String m13685d(Context context) {
        return Build.MODEL + "," + Build.BRAND;
    }
}
