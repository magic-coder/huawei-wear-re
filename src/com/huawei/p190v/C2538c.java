package com.huawei.p190v;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.huawei.common.applog.AppLogApi;
import com.huawei.feedback.bean.MetadataBundle;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.main.stories.nps.interactors.mode.TypeParams;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: LogUtil */
public class C2538c {
    private static String f9036a = "UNSETTED";
    private static String f9037b = "UNSETTED_ID";
    private static C2540e f9038c = new C2540e();
    private static String f9039d = null;
    private static String f9040e = (f9036a + "|");
    private static StringBuffer f9041f = new StringBuffer();
    private static Handler f9042g;
    private static String f9043h = (f9036a + ",");
    private static StringBuffer f9044i = new StringBuffer();
    private static Executor f9045j = Executors.newSingleThreadExecutor();
    private static StringBuffer f9046k = new StringBuffer();
    private static int f9047l = 0;
    private static SimpleDateFormat f9048m = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.ENGLISH);
    private static boolean f9049n = false;
    private static Context f9050o = null;
    private static List<C2541f> f9051p = new ArrayList();

    static {
        if (f9042g == null) {
            HandlerThread handlerThread = new HandlerThread("logfile_thread");
            handlerThread.start();
            f9042g = new C2537b(handlerThread.getLooper());
        }
    }

    public static String m12655a() {
        return f9039d;
    }

    public static void m12659a(Context context, String str) {
        try {
            f9050o = context;
            Class cls = Class.forName(str + ".BuildConfig");
            f9036a = Integer.toString(((Integer) cls.getField("VERSION_CODE").get(null)).intValue());
            f9037b = (String) cls.getField("APPLICATION_ID").get(null);
            f9040e = f9036a + "|";
            f9039d = (String) cls.getField("BUILD_TYPE").get(null);
            f9038c.m12691a(f9039d.equals("release"));
            synchronized (C2538c.class) {
                if (f9039d.equals("release")) {
                    f9042g.sendEmptyMessage(1002);
                } else {
                    f9042g.sendEmptyMessage(1003);
                }
            }
            C2538c.m12668a(true, true, C2542g.f9058c, "LogUtil", "APP_VERSION:" + f9036a);
            C2538c.m12668a(true, true, C2542g.f9058c, "LogUtil", "BUILD_TYPE:releaseBUILD_TYPE:" + f9039d);
        } catch (ClassNotFoundException e) {
            C2538c.m12668a(true, false, C2542g.f9060e, "LogUtil", "class not found :" + str + ".BuildConfig");
        } catch (NoSuchFieldException e2) {
            C2538c.m12668a(true, false, C2542g.f9060e, "LogUtil", "NoSuchFieldException :" + str + ".BuildConfig");
        } catch (IllegalAccessException e3) {
            C2538c.m12668a(true, false, C2542g.f9060e, "LogUtil", "IllegalAccessException :" + str + ".BuildConfig");
        }
        C2538c.m12675c();
    }

    public static void m12664a(String str, Object... objArr) {
        C2538c.m12668a(true, true, C2542g.f9056a, str, objArr);
    }

    public static void m12674b(String str, Object... objArr) {
        C2538c.m12668a(true, true, C2542g.f9057b, str, objArr);
    }

    @Deprecated
    public static void m12666a(boolean z, String str, Object... objArr) {
    }

    public static void m12677c(String str, Object... objArr) {
        C2538c.m12668a(true, true, C2542g.f9058c, str, objArr);
    }

    private static void m12668a(boolean z, boolean z2, int i, String str, Object... objArr) {
        if (!z) {
            return;
        }
        if (!z2 || f9038c.m12692a(i, str)) {
            String a = C2538c.m12656a(objArr, f9040e);
            if (a != null) {
                String str2 = "";
                int length = a.length();
                while (length != 0) {
                    if (length > 1000) {
                        str2 = a.substring(0, 1000);
                        a = a.substring(1000);
                    } else {
                        String str3 = a;
                        a = "";
                        str2 = str3;
                    }
                    C2538c.m12658a(i, str, str2);
                    C2538c.m12662a(str, str2);
                    length = a.length();
                }
            }
        }
    }

    public static void m12679d(String str, Object... objArr) {
        C2538c.m12668a(true, true, C2542g.f9059d, str, objArr);
    }

    public static void m12680e(String str, Object... objArr) {
        C2538c.m12668a(true, true, C2542g.f9060e, str, objArr);
    }

    public static void m12657a(int i, String str, Bundle bundle, boolean z, Object... objArr) {
        C2538c.m12680e(str, objArr);
        MetadataBundle metadataBundle = new MetadataBundle(i, f9037b, f9036a);
        for (String str2 : bundle.keySet()) {
            metadataBundle.putData(str2, bundle.get(str2).toString());
        }
        String str22 = metadataBundle.toString();
        Bundle bundle2 = new Bundle();
        bundle2.putString("MetaData", str22);
        if (z) {
            bundle2.putString("logwritePath", C2537b.m12648b());
        }
        AppLogApi.m2656e(str, String.valueOf(i), bundle2, Boolean.valueOf(z), null, f9050o);
    }

    private static void m12658a(int i, String str, String str2) {
        if (!"release".equals(C2538c.m12655a())) {
            boolean e = C2538c.m12681e();
            if ("beta".equals(C2538c.m12655a()) && !e) {
                return;
            }
            if (i == C2542g.f9058c) {
                Log.i(str, str2);
            } else if (i == C2542g.f9059d) {
                Log.w(str, str2);
            } else if (i == C2542g.f9057b) {
                Log.d(str, str2);
            } else if (i == C2542g.f9056a) {
                Log.v(str, str2);
            } else if (i == C2542g.f9060e) {
                Log.e(str, str2);
            }
        }
    }

    private static String m12656a(Object[] objArr, String... strArr) {
        int i = 0;
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!(strArr == null || strArr[0] == null)) {
            for (String append : strArr) {
                stringBuilder.append(append);
            }
        }
        int length = objArr.length;
        while (i < length) {
            stringBuilder.append(objArr[i]);
            i++;
        }
        return stringBuilder.toString();
    }

    private static String m12684h() {
        return new SimpleDateFormat("yyyyMMdd-HH:mm:ss:SSS|", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
    }

    private static void m12662a(String str, String str2) {
        Object obj = 1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C2538c.m12684h());
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(str2);
            if (f9041f == null) {
                Log.e("LogUtil", "logFileBuffer null");
                return;
            }
            f9041f.append(stringBuilder.toString() + "\n");
            if ((f9041f.length() >= 65536 ? 1 : null) != null) {
                synchronized (C2538c.class) {
                    if (f9041f.length() < 65536) {
                        obj = null;
                    }
                    if (obj != null) {
                        Message obtainMessage = f9042g.obtainMessage(1000);
                        String stringBuffer = f9041f.toString();
                        f9041f.delete(0, stringBuffer.length());
                        obtainMessage.obj = stringBuffer;
                        f9042g.sendMessage(obtainMessage);
                    }
                }
            }
        } catch (OutOfMemoryError e) {
            Log.e("LogUtil", "logFileBuffer outofmemoryerror");
        }
    }

    public static void m12671b() {
        if (f9041f == null) {
            Log.e("LogUtil", "logFileBuffer null");
        } else if (f9041f.length() != 0) {
            synchronized (C2538c.class) {
                if (f9041f.length() != 0) {
                    Message obtainMessage = f9042g.obtainMessage(1000);
                    String stringBuffer = f9041f.toString();
                    f9041f.delete(0, stringBuffer.length());
                    obtainMessage.obj = stringBuffer;
                    f9042g.sendMessage(obtainMessage);
                }
            }
        }
    }

    private static void m12685i() {
        try {
            String canonicalPath = Environment.getExternalStorageDirectory().getCanonicalPath();
            String str = canonicalPath + File.separator + "huawei" + File.separator + "com.huawei.bone";
            String[] strArr = new String[]{"log.0", "log.1", "log.2", "log.3", "log.4"};
            f9051p.add(new C2541f(new File(str + File.separator + "com.huawei.bone"), strArr));
            strArr = new String[]{"log.0", "log.1", "log.2", "log.3", "log.4"};
            f9051p.add(new C2541f(new File(str + File.separator + "com.huawei.bone_leakcanary"), strArr));
            strArr = new String[]{"log.0", "log.1", "log.2", "log.3", "log.4"};
            f9051p.add(new C2541f(new File(str + File.separator + "com.huawei.bone_pushservice"), strArr));
            strArr = new String[]{"log.0", "log.1", "log.2", "log.3", "log.4"};
            f9051p.add(new C2541f(new File(str + File.separator + "com.huawei.bone_PhoneService"), strArr));
            String str2 = str + File.separator + "MaintenanceLog";
            f9051p.add(new C2541f(new File(str2), C2538c.m12670a(str2, null, null)));
            str2 = str + File.separator + "MaintenanceLogTemp";
            f9051p.add(new C2541f(new File(str2), C2538c.m12670a(str2, null, null)));
            f9051p.add(new C2541f(new File(str), new String[]{"huawei_crashLog_0.txt", "huawei_crashLog_1.txt", "huawei_crashLog_2.txt", "leak.txt"}));
            String[] strArr2 = new String[]{"api1.log", "api2.log", "log1.txt", "log2.txt"};
            f9051p.add(new C2541f(new File(canonicalPath + File.separator + "BOneLog"), strArr2));
            str = canonicalPath + File.separator + "BOneLog";
            f9051p.add(new C2541f(new File(str), C2538c.m12670a(str, "app_crashLog_", ".txt")));
            str = canonicalPath + File.separator + "BOneLog" + File.separator + "sportdata";
            f9051p.add(new C2541f(new File(str), C2538c.m12670a(str, null, ".txt")));
            canonicalPath = canonicalPath + File.separator + "BOneLog" + File.separator + "MaintenanceLog";
            f9051p.add(new C2541f(new File(canonicalPath), C2538c.m12670a(canonicalPath, null, null)));
        } catch (IOException e) {
        }
    }

    private static String[] m12670a(String str, String str2, String str3) {
        int i = 0;
        File[] a = C2538c.m12669a(str);
        if (a == null || a.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : a) {
            String name = file.getName();
            if (!(file.isDirectory() || name == null || ((str2 != null && !name.startsWith(str2)) || (str3 != null && !name.endsWith(str3))))) {
                arrayList.add(file.getName());
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        String[] strArr = new String[size];
        while (i < size) {
            strArr[i] = (String) arrayList.get(i);
            i++;
        }
        return strArr;
    }

    private static File[] m12669a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    private static void m12686j() {
        for (int i = 0; i < f9051p.size(); i++) {
            C2538c.m12660a((C2541f) f9051p.get(i));
        }
    }

    private static void m12660a(C2541f c2541f) {
        if (c2541f != null && c2541f.f9054a != null) {
            C2538c.m12674b("LogUtil", c2541f.f9054a + " check");
            if (c2541f.f9054a.exists()) {
                int i;
                C2538c.m12674b("LogUtil", c2541f.f9054a + " exist");
                if (c2541f.f9055b != null) {
                    for (String str : c2541f.f9055b) {
                        File file = new File(c2541f.f9054a + File.separator + str);
                        if (file.exists() && !file.delete()) {
                            C2538c.m12679d("LogUtil", "file delte failed:", file);
                        }
                    }
                }
                String[] list = c2541f.f9054a.list();
                if (list == null) {
                    C2538c.m12679d("LogUtil", "fileDeleteList.dir.list ret null");
                    return;
                }
                for (i = 0; i < list.length; i++) {
                    C2538c.m12679d("LogUtil", "exist:", list[i]);
                }
                if (list.length == 0 && !c2541f.f9054a.delete()) {
                    C2538c.m12679d("LogUtil", "file delte failed:", c2541f.f9054a);
                }
            }
        }
    }

    public static void m12675c() {
        f9045j.execute(new C2539d());
    }

    public static void m12678d() {
        if (f9044i == null) {
            Log.e("LogUtil", "logFileBuffer null");
        } else if (f9044i.length() != 0) {
            synchronized (C2538c.class) {
                if (f9044i.length() != 0) {
                    Message obtainMessage = f9042g.obtainMessage(2000);
                    String stringBuffer = f9044i.toString();
                    f9044i.delete(0, stringBuffer.length());
                    obtainMessage.obj = stringBuffer;
                    f9042g.sendMessage(obtainMessage);
                }
            }
        }
    }

    private static void m12667a(boolean z, boolean z2, int i, String str, String str2) {
        if (z && str2 != null) {
            String str3 = "";
            int length = str2.length();
            String str4 = str2;
            while (length != 0) {
                if (length > 1000) {
                    str3 = str4.substring(0, 1000);
                    str4 = str4.substring(1000);
                } else {
                    String str5 = str4;
                    str4 = "";
                    str3 = str5;
                }
                C2538c.m12658a(i, str, str3);
                C2538c.m12673b(Integer.toString(i), str3);
                length = str4.length();
            }
        }
    }

    private static String m12687k() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS,", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
    }

    private static void m12673b(String str, String str2) {
        Object obj = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C2538c.m12687k());
        stringBuilder.append(str);
        stringBuilder.append(",");
        stringBuilder.append(str2);
        if (f9044i == null) {
            Log.e("LogUtil", "logFileBuffer null");
            return;
        }
        f9044i.append(stringBuilder.toString() + "\n");
        if ((f9044i.length() >= 65536 ? 1 : null) != null) {
            synchronized (C2538c.class) {
                if (f9044i.length() < 65536) {
                    obj = null;
                }
                if (obj != null) {
                    Message obtainMessage = f9042g.obtainMessage(2000);
                    String stringBuffer = f9044i.toString();
                    f9044i.delete(0, stringBuffer.length());
                    obtainMessage.obj = stringBuffer;
                    f9042g.sendMessage(obtainMessage);
                }
            }
        }
    }

    public static void m12663a(String str, String str2, int i, String str3, Object... objArr) {
        C2543h c2543h = new C2543h(f9037b, f9036a, str3);
        c2543h.m12693a(TypeParams.QUESTION_CHOOSE_MULTI, Arrays.toString(objArr));
        String c2543h2 = c2543h.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(",");
        stringBuilder.append("ExecptEvtID:");
        stringBuilder.append(str);
        stringBuilder.append(",");
        stringBuilder.append("cont:");
        stringBuilder.append(c2543h2);
        if (!f9038c.f9053b) {
            C2538c.m12667a(true, true, C2542g.f9060e, str3, stringBuilder.toString());
        } else if (f9038c.f9053b && i == 1) {
            C2538c.m12667a(true, true, C2542g.f9060e, str3, stringBuilder.toString());
        }
    }

    public static void m12661a(String str, int i, String str2, Object... objArr) {
        C2543h c2543h = new C2543h(f9037b, f9036a, str2);
        c2543h.m12693a(TypeParams.QUESTION_CHOOSE_MULTI, Arrays.toString(objArr));
        String c2543h2 = c2543h.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        stringBuilder.append("cont:");
        stringBuilder.append(c2543h2);
        if (!f9038c.f9053b) {
            C2538c.m12667a(true, true, C2542g.f9058c, str2, stringBuilder.toString());
        } else if (f9038c.f9053b && i == 1) {
            C2538c.m12667a(true, true, C2542g.f9058c, str2, stringBuilder.toString());
        }
    }

    public static void m12672b(String str, int i, String str2, Object... objArr) {
        C2543h c2543h = new C2543h(f9037b, f9036a, str2);
        c2543h.m12693a(TypeParams.QUESTION_CHOOSE_MULTI, Arrays.toString(objArr));
        String c2543h2 = c2543h.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        stringBuilder.append("cont:");
        stringBuilder.append(c2543h2);
        if (!f9038c.f9053b) {
            C2538c.m12667a(true, true, C2542g.f9059d, str2, stringBuilder.toString());
        } else if (f9038c.f9053b && i == 1) {
            C2538c.m12667a(true, true, C2542g.f9059d, str2, stringBuilder.toString());
        }
    }

    public static void m12676c(String str, int i, String str2, Object... objArr) {
        C2543h c2543h = new C2543h(f9037b, f9036a, str2);
        c2543h.m12693a(TypeParams.QUESTION_CHOOSE_MULTI, Arrays.toString(objArr));
        String c2543h2 = c2543h.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        stringBuilder.append("cont:");
        stringBuilder.append(c2543h2);
        if (!f9038c.f9053b) {
            C2538c.m12667a(true, true, C2542g.f9057b, str2, stringBuilder.toString());
        } else if (f9038c.f9053b && i == 1) {
            C2538c.m12667a(true, true, C2542g.f9057b, str2, stringBuilder.toString());
        }
    }

    public static void m12665a(boolean z) {
        Editor edit = BaseApplication.m2632b().getSharedPreferences("LOG2CAT_FLAG", 0).edit();
        edit.putBoolean("log2cat", z);
        edit.commit();
    }

    public static boolean m12681e() {
        return BaseApplication.m2632b().getSharedPreferences("LOG2CAT_FLAG", 0).getBoolean("log2cat", false);
    }

    public static void a(final String s, final int i, final String btDeviceBLEService, final Object... objects) {}

    public static void a(final String s, final String s1, final int i, final String btDeviceBLEService, final Object... objects) {}

    public static void b(final String s, final int i, final String btDeviceBLEService, final Object... objects) {

    }
}
