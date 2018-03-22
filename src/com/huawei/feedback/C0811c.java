package com.huawei.feedback;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ContentUris;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.feedback.p033a.p035b.C0808a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.phoneserviceuni.common.b.a;
import com.huawei.phoneserviceuni.common.d.b;
import com.huawei.phoneserviceuni.common.p132d.C1372a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import com.huawei.phoneserviceuni.common.p132d.p133a.p135b.p136a.C1370a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;

/* compiled from: FeedbackUtils */
public class C0811c {
    private static long f1248a = 0;
    private static int f1249b;

    public static boolean m2771a(Context context) {
        if (C0811c.m2806m(context)) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "getAllowUploadFlag true! hasPhoneService false");
            return false;
        } else if (C0811c.m2807n(context)) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "getImmediateUploadFlag true! hasPhoneService false");
            return false;
        } else if (C0811c.m2785b(context, "com.huawei.phoneservice") && C0811c.m2773a(context, "com.huawei.phoneservice.FEEDBACK") && C0811c.m2816w(context)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean m2773a(Context context, String str) {
        return context.getPackageManager().queryIntentActivities(new Intent(str), 65536).size() > 0;
    }

    public static boolean m2785b(Context context, String str) {
        if (context == null || str == null) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "packageInstalled null==context fail!");
            return false;
        }
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo packageInfo : installedPackages) {
                if (str.equals(packageInfo.packageName)) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "packageInstalled true!");
                    return true;
                }
            }
        }
        C1373c.m6141d("AppLogApi/FeedbackUtils", "packageInstalled false!");
        return false;
    }

    public static boolean m2772a(Context context, int i) {
        Object b = C0811c.m2782b(context, i);
        String str = "3082035130820239a00302010202047ed727ed300d06092a864886f70d01010b05003058310b300906035504061302636e310b300906035504081302737a310b300906035504071302737a310f300d060355040a1306687561776569310f300d060355040b1306687561776569310d300b0603550403130479616e673020170d3135303630313032353835355a180f32303730303330343032353835355a3058310b300906035504061302636e310b300906035504081302737a310b300906035504071302737a310f300d060355040a1306687561776569310f300d060355040b1306687561776569310d300b0603550403130479616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008cda6628bd8bae0a2a2d287415dcfe51b4a9641194c633ece4906d688547bd839204b31dc3a3f9de953db89001e25cb671f31dee489a292cfd317bc546daad98e5524fcef69debe98ba87564087315aba08be05e625c455a0ae87b95b7e211205e24be0161494fb9516d42c520bb938f52adcc60908b5c90bd6c92377d8f9642475b86cf49dea1ab02ae87d12130f9874a82f24f4857bb7b149185f3cdbe1fbde0e12543bfaac1a24e7ecec0f3353f3bcb1c92558a41362503a405ceccd9808bdb3b9f07dabb45057d713fa31ef378dd082fa653e7e795eb158a09b9cbe662098dbea0d8f4b02ddcd4b706bad8741b0c2668cb19b12d7c6a3c0365bf8109cb350203010001a321301f301d0603551d0e04160414721c126a361e4c8513b6b45cf248efe58b808751300d06092a864886f70d01010b050003820101006ca0c1f0dee72bcf8f8a0f288b4ca05d9a250ac66c63560abaa2bcd8559afa20e8597adc9b7cde1981e1c436f945b08fc995a44c6c1390dc30f000f76a27b663f869adff8fb588b5084dfb002acd754d8b95e8611b96d159df9ee5db8de6b631e4fb89e547da98f604fe9e71cbdef560d264e694172b35ad553ad2bf3a3ea856e6ebd27211b8abc9d386c1820a254def48dfdfb9ed74653f6e38cc38f5e2cb3d02a2ad3cd3f33d074db235d2b9429411d40e247dd0c6e6114a625d2edac3604be60888c5148061b25bf6eda3e5cd6b036fa4ee5233c53d623072d88f7513d450a8902a4a75b3e0d91c6f33c565d555d05fdf291f23475a7b10cc8baf3603b49b";
        PackageManager packageManager = context.getPackageManager();
        try {
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(b, 64);
            if (packageInfo == null) {
                return false;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return false;
            }
            for (Signature toCharsString : signatureArr) {
                if ("3082035130820239a00302010202047ed727ed300d06092a864886f70d01010b05003058310b300906035504061302636e310b300906035504081302737a310b300906035504071302737a310f300d060355040a1306687561776569310f300d060355040b1306687561776569310d300b0603550403130479616e673020170d3135303630313032353835355a180f32303730303330343032353835355a3058310b300906035504061302636e310b300906035504081302737a310b300906035504071302737a310f300d060355040a1306687561776569310f300d060355040b1306687561776569310d300b0603550403130479616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008cda6628bd8bae0a2a2d287415dcfe51b4a9641194c633ece4906d688547bd839204b31dc3a3f9de953db89001e25cb671f31dee489a292cfd317bc546daad98e5524fcef69debe98ba87564087315aba08be05e625c455a0ae87b95b7e211205e24be0161494fb9516d42c520bb938f52adcc60908b5c90bd6c92377d8f9642475b86cf49dea1ab02ae87d12130f9874a82f24f4857bb7b149185f3cdbe1fbde0e12543bfaac1a24e7ecec0f3353f3bcb1c92558a41362503a405ceccd9808bdb3b9f07dabb45057d713fa31ef378dd082fa653e7e795eb158a09b9cbe662098dbea0d8f4b02ddcd4b706bad8741b0c2668cb19b12d7c6a3c0365bf8109cb350203010001a321301f301d0603551d0e04160414721c126a361e4c8513b6b45cf248efe58b808751300d06092a864886f70d01010b050003820101006ca0c1f0dee72bcf8f8a0f288b4ca05d9a250ac66c63560abaa2bcd8559afa20e8597adc9b7cde1981e1c436f945b08fc995a44c6c1390dc30f000f76a27b663f869adff8fb588b5084dfb002acd754d8b95e8611b96d159df9ee5db8de6b631e4fb89e547da98f604fe9e71cbdef560d264e694172b35ad553ad2bf3a3ea856e6ebd27211b8abc9d386c1820a254def48dfdfb9ed74653f6e38cc38f5e2cb3d02a2ad3cd3f33d074db235d2b9429411d40e247dd0c6e6114a625d2edac3604be60888c5148061b25bf6eda3e5cd6b036fa4ee5233c53d623072d88f7513d450a8902a4a75b3e0d91c6f33c565d555d05fdf291f23475a7b10cc8baf3603b49b".equals(toCharsString.toCharsString())) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static String m2781b(Context context) {
        String str;
        String str2 = "";
        try {
            Class cls = Class.forName("com.huawei.cloudservice.CloudAccount");
            Method declaredMethod = cls.getDeclaredMethod("getCurrLoginUserName", new Class[]{Context.class});
            Method declaredMethod2 = cls.getDeclaredMethod("hasAlreadyLogin", new Class[]{Context.class, String.class});
            str = (String) declaredMethod.invoke(cls, new Object[]{context});
            try {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                if (((Boolean) declaredMethod2.invoke(cls, new Object[]{context, str})).booleanValue()) {
                    return str;
                }
                return "";
            } catch (ClassNotFoundException e) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "getCurrentAccountByReflect ClassNotFoundException");
                return str;
            } catch (NoSuchMethodException e2) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "getCurrentAccountByReflect NoSuchMethodException");
                return str;
            } catch (Exception e3) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "getCurrentAccountByReflect Exception");
                return str;
            }
        } catch (ClassNotFoundException e4) {
            str = str2;
            C1373c.m6141d("AppLogApi/FeedbackUtils", "getCurrentAccountByReflect ClassNotFoundException");
            return str;
        } catch (NoSuchMethodException e5) {
            str = str2;
            C1373c.m6141d("AppLogApi/FeedbackUtils", "getCurrentAccountByReflect NoSuchMethodException");
            return str;
        } catch (Exception e6) {
            str = str2;
            C1373c.m6141d("AppLogApi/FeedbackUtils", "getCurrentAccountByReflect Exception");
            return str;
        }
    }

    private static boolean m2816w(Context context) {
        if (Integer.parseInt(C1372a.m6107a("com.huawei.phoneservice", context)) >= Integer.parseInt("20005000")) {
            return true;
        }
        return false;
    }

    public static void m2766a(String str, String str2) {
        String[] list = new File(str).list();
        if (list != null) {
            int length = list.length;
            for (int i = 0; i < length; i++) {
                if (list[i].endsWith(HwAccountConstants.SPLIIT_UNDERLINE + str2 + LightCloudConstants.ZIP_POSTFIX)) {
                    File file = new File(str + "/" + list[i]);
                    if (file.exists()) {
                        int i2 = 0;
                        while (i2 < 2) {
                            if (file.delete()) {
                                C1373c.m6139b("AppLogApi/FeedbackUtils", "resultZipFile delete sccess!");
                                break;
                            } else {
                                C1373c.m6139b("AppLogApi/FeedbackUtils", " resultZipFile delete fail!");
                                i2++;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void m2768a(String str, String str2, String str3) {
        String[] list = new File(str).list();
        if (list != null) {
            int length = list.length;
            int i = 0;
            while (i < length) {
                if (list[i].endsWith(HwAccountConstants.SPLIIT_UNDERLINE + str2 + LightCloudConstants.ZIP_POSTFIX) && !str3.contains(list[i])) {
                    File file = new File(str + "/" + list[i]);
                    if (file.exists()) {
                        int i2 = 0;
                        while (i2 < 2) {
                            if (file.delete()) {
                                C1373c.m6139b("AppLogApi/FeedbackUtils", "deleteZipfiles sdcardpath delete sccess!");
                                break;
                            } else {
                                C1373c.m6139b("AppLogApi/FeedbackUtils", " deleteZipfiles sdcardpath delete fail!");
                                i2++;
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    public static String[] m2776a(String str) {
        String[] list = new File(str).list();
        List arrayList = new ArrayList();
        if (list != null) {
            int length = list.length;
            int i = 0;
            while (i < length) {
                if (list[i].endsWith(".log") || list[i].endsWith(".txt")) {
                    File file = new File(str + "/" + list[i]);
                    if (file.exists()) {
                        arrayList.add(file.getPath());
                    }
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] m2777a(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return new String[0];
        }
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C1373c.m6139b("AppLogApi/FeedbackUtils", "pathlist " + str);
            String[] a = C0811c.m2776a(str);
            if (a != null) {
                for (Object add : a) {
                    arrayList2.add(add);
                }
            }
        }
        return (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    public static int m2787c(Context context) {
        if (!C1372a.m6123h()) {
            return context.getResources().getColor(C0820d.m2877d(context, "feedback_blue"));
        }
        if (C1372a.m6128m()) {
            return context.getResources().getColor(C0820d.m2877d(context, "feedback_highlight_color"));
        }
        return context.getResources().getColor(C0820d.m2877d(context, "feedback_highlight_color_old"));
    }

    public static String m2793d(Context context) {
        String str = null;
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.lcagent", 0).versionName;
        } catch (NameNotFoundException e) {
            C1373c.m6141d("getLogColServiceVersion", " NameNotFoundException .. ");
            return str;
        }
    }

    public static boolean m2797e(Context context) {
        String d = C0811c.m2793d(context);
        if (d == null || d.length() <= 3) {
            return false;
        }
        C1373c.m6138a("getLogColServiceVersion", "---versionName --->> " + d);
        d = d.substring(0, 3);
        C1373c.m6138a("getLogColServiceVersion", "---versionNum --->>  " + d);
        if ("1.1".equals(d)) {
            return false;
        }
        return true;
    }

    public static int m2798f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.getState() == State.CONNECTED) {
            return 1;
        }
        if (networkInfo2 == null || networkInfo2.getState() != State.CONNECTED) {
            return -1;
        }
        return 2;
    }

    public static boolean m2775a(File[] fileArr, File file, Context context) {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (fileArr == null || fileArr.length > 51) {
            return false;
        }
        byte[] bArr = new byte[1024];
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            int i = 0;
            while (i < fileArr.length) {
                try {
                    boolean j = C0808a.m2700a().m2729j(context);
                    C1373c.m6140c("AppLogApi/FeedbackUtils", "zipFiles isUnLimitSize===" + j);
                    if (fileArr[i] != null && (fileArr[i].length() <= 5242880 || j)) {
                        try {
                            C1373c.m6139b("AppLogApi/FeedbackUtils", i + "--zip--name==" + fileArr[i].getName());
                            C1373c.m6141d("AppLogApi/FeedbackUtils", "srcfile[" + i + "]" + fileArr[i].toString());
                            fileInputStream = new FileInputStream(fileArr[i]);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(fileArr[i].getName()));
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                zipOutputStream.closeEntry();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException two...");
                                    }
                                } else {
                                    continue;
                                }
                            } catch (FileNotFoundException e2) {
                            } catch (IOException e3) {
                                fileInputStream2 = fileInputStream;
                            }
                        } catch (FileNotFoundException e4) {
                            fileInputStream = null;
                        } catch (IOException e5) {
                        }
                    }
                    i++;
                } catch (FileNotFoundException e6) {
                    r2 = zipOutputStream;
                } catch (Throwable th) {
                    th = th;
                }
            }
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e7) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException three...");
                }
            }
            return true;
        } catch (FileNotFoundException e8) {
            ZipOutputStream zipOutputStream2;
            if (zipOutputStream2 == null) {
                return false;
            }
            try {
                zipOutputStream2.close();
                return false;
            } catch (IOException e9) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException three...");
                return false;
            }
        } catch (Throwable th2) {
            Throwable th3;
            th3 = th2;
            zipOutputStream = null;
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e10) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException three...");
                }
            }
            throw th3;
        }
        try {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException one...");
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e11) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException two...");
                }
            }
            if (zipOutputStream != null) {
                return false;
            }
            try {
                zipOutputStream.close();
                return false;
            } catch (IOException e12) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException three...");
                return false;
            }
        } catch (Throwable th4) {
            Throwable th5 = th4;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e13) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException two...");
                }
            }
            throw th5;
        }
        if (zipOutputStream != null) {
            return false;
        }
        try {
            zipOutputStream.close();
            return false;
        } catch (IOException e14) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException three...");
            return false;
        }
        try {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "FileNotFoundException ...");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e15) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "IOException two...");
                }
            }
            if (zipOutputStream != null) {
                return false;
            }
            zipOutputStream.close();
            return false;
        } catch (Throwable th6) {
            Throwable th7 = th6;
            fileInputStream2 = fileInputStream;
            th5 = th7;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th5;
        }
        if (zipOutputStream != null) {
            return false;
        }
        zipOutputStream.close();
        return false;
    }

    public static int m2778b(String str) {
        FileInputStream fileInputStream = new FileInputStream(str);
        int i = 0;
        try {
            i = fileInputStream.available();
        } catch (IOException e) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "getFileSize IOException");
        } finally {
            b.a(fileInputStream, "AppLogApi/FeedbackUtils");
        }
        return i;
    }

    public static String m2757a() {
        if (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return null;
    }

    public static String m2780b() {
        new Time().setToNow();
        return String.format(Locale.getDefault(), "%04d%02d%02d%02d%02d%02d", new Object[]{Integer.valueOf(r0.year), Integer.valueOf(r0.month + 1), Integer.valueOf(r0.monthDay), Integer.valueOf(r0.hour), Integer.valueOf(r0.minute), Integer.valueOf(r0.second)});
    }

    public static String m2800g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (NameNotFoundException e) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "applicationInfo = null");
            return "";
        }
    }

    public static boolean m2801h(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        List<RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (runningServices == null || runningServices.size() == 0) {
            return false;
        }
        boolean z;
        for (RunningServiceInfo runningServiceInfo : runningServices) {
            if ("com.huawei.feedback.component.ProgressService".equals(runningServiceInfo.service.getClassName()) && context.getPackageName().equals(runningServiceInfo.service.getPackageName())) {
                C1373c.m6138a("AppLogApi/FeedbackUtils", runningServiceInfo.service.getClassName());
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public static HttpsURLConnection m2788c(String str) {
        try {
            URL url = new URL(str);
            a.a();
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setConnectTimeout(SdkConstants.TIME_OUT);
                    httpsURLConnection.setReadTimeout(SdkConstants.TIME_OUT);
                    httpsURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
                    try {
                        httpsURLConnection.connect();
                        return httpsURLConnection;
                    } catch (IOException e) {
                        C1373c.m6141d("AppLogApi/FeedbackUtils", "initHttpsConnection IOException");
                        return null;
                    }
                } catch (ProtocolException e2) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "initHttpsConnection ProtocolException");
                    return null;
                } catch (Exception e3) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "initHttpsConnection Exception");
                    return null;
                }
            } catch (IOException e4) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "initHttpsConnection IOException");
                return null;
            }
        } catch (MalformedURLException e5) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "getFileSize IOException");
            return null;
        }
    }

    public static boolean m2789c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - f1248a) < 800) {
            return true;
        }
        f1248a = currentTimeMillis;
        return false;
    }

    public static String m2761a(HttpsURLConnection httpsURLConnection) {
        String str;
        Throwable th;
        String str2 = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream;
        InputStream b;
        try {
            inputStream = httpsURLConnection.getInputStream();
            try {
                b = b.b(inputStream);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = b.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), GameManager.DEFAULT_CHARSET);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        C1373c.m6141d("AppLogApi/FeedbackUtils", "close stream error");
                    }
                    b.a(b, "AppLogApi/FeedbackUtils");
                    b.a(inputStream, "AppLogApi/FeedbackUtils");
                } catch (IOException e2) {
                } catch (Exception e3) {
                }
            } catch (IOException e4) {
                b = null;
                try {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "readInputStream IOException");
                    str = "";
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        C1373c.m6141d("AppLogApi/FeedbackUtils", "close stream error");
                    }
                    b.a(b, "AppLogApi/FeedbackUtils");
                    b.a(inputStream, "AppLogApi/FeedbackUtils");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        C1373c.m6141d("AppLogApi/FeedbackUtils", "close stream error");
                    }
                    b.a(b, "AppLogApi/FeedbackUtils");
                    b.a(inputStream, "AppLogApi/FeedbackUtils");
                    throw th;
                }
            } catch (Exception e7) {
                b = null;
                C1373c.m6141d("AppLogApi/FeedbackUtils", "readInputStream Exception");
                str = "";
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e8) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "close stream error");
                }
                b.a(b, "AppLogApi/FeedbackUtils");
                b.a(inputStream, "AppLogApi/FeedbackUtils");
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                b = null;
                th = th4;
                byteArrayOutputStream.close();
                b.a(b, "AppLogApi/FeedbackUtils");
                b.a(inputStream, "AppLogApi/FeedbackUtils");
                throw th;
            }
        } catch (IOException e9) {
            b = null;
            inputStream = null;
            C1373c.m6141d("AppLogApi/FeedbackUtils", "readInputStream IOException");
            str = "";
            byteArrayOutputStream.close();
            b.a(b, "AppLogApi/FeedbackUtils");
            b.a(inputStream, "AppLogApi/FeedbackUtils");
            return str;
        } catch (Exception e10) {
            b = null;
            inputStream = null;
            C1373c.m6141d("AppLogApi/FeedbackUtils", "readInputStream Exception");
            str = "";
            byteArrayOutputStream.close();
            b.a(b, "AppLogApi/FeedbackUtils");
            b.a(inputStream, "AppLogApi/FeedbackUtils");
            return str;
        } catch (Throwable th32) {
            inputStream = null;
            th = th32;
            b = null;
            byteArrayOutputStream.close();
            b.a(b, "AppLogApi/FeedbackUtils");
            b.a(inputStream, "AppLogApi/FeedbackUtils");
            throw th;
        }
        return str;
    }

    public static void m2784b(String str, String str2) {
        byte[] bArr = new byte[1024];
        File file = new File(str);
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                OutputStream fileOutputStream = new FileOutputStream(str2);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                } catch (IOException e) {
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "zipFile IOException");
                } finally {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e2) {
                        C1373c.m6141d("AppLogApi/FeedbackUtils", "zipFile close stream: IOException");
                    }
                    b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                    b.a(fileInputStream, "AppLogApi/FeedbackUtils");
                }
            } catch (FileNotFoundException e3) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "zipFile FileNotFoundException");
                b.a(fileInputStream, "AppLogApi/FeedbackUtils");
            }
        } catch (FileNotFoundException e4) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "zipFile FileInputStream");
        }
    }

    public static void m2763a(Activity activity, int i) {
        try {
            activity.startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), i);
        } catch (Exception e) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT", null);
            intent.setType("image/*");
            activity.startActivityForResult(intent, i);
        }
    }

    public static String m2759a(ContextWrapper contextWrapper, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        if (!uri.getScheme().equals("content")) {
            return uri.getPath();
        }
        Cursor query = contextWrapper.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.moveToFirst()) {
            str = query.getString(query.getColumnIndex("_data"));
        }
        query.close();
        return str;
    }

    public static String m2760a(Uri uri, Context context) {
        Uri uri2 = null;
        if ((VERSION.SDK_INT >= 19 ? 1 : 0) == 0 || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return C0811c.m2758a(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        } else if (C0811c.m2774a(uri)) {
            r1 = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(r1[0])) {
                return Environment.getExternalStorageDirectory() + "/" + r1[1];
            }
            if (TextUtils.isEmpty(C0811c.m2802i(context))) {
                return null;
            }
            return C0811c.m2802i(context) + "/" + r1[1];
        } else if (C0811c.m2786b(uri)) {
            return C0811c.m2758a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), null, null);
        } else if (!C0811c.m2791c(uri)) {
            return null;
        } else {
            Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
            if (WBConstants.GAME_PARAMS_GAME_IMAGE_URL.equals(obj)) {
                uri2 = Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(obj)) {
                uri2 = Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(obj)) {
                uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
            }
            String str = "_id=?";
            return C0811c.m2758a(context, uri2, "_id=?", new String[]{r1[1]});
        }
    }

    public static String m2802i(Context context) {
        String str = "";
        Object obj = null;
        String str2 = "";
        for (Entry entry : System.getenv().entrySet()) {
            String str3 = (String) entry.getValue();
            String str4 = (String) entry.getKey();
            if ("SECONDARY_STORAGE".equals(str4)) {
                obj = 1;
                str2 = str3;
            }
            if (!"EXTERNAL_STORAGE".equals(str4)) {
                str3 = str;
            }
            str = str3;
        }
        return obj != null ? str2 : str;
    }

    public static String m2758a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        String str2 = "_data";
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query == null) {
                            return str2;
                        }
                        query.close();
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean m2774a(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean m2786b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean m2791c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean m2794d(String str) {
        if (str == null) {
            return false;
        }
        try {
            String substring = str.substring(str.length() - 4);
            String substring2 = str.substring(str.length() - 5);
            if (".jpg".equalsIgnoreCase(substring) || ".jpeg".equalsIgnoreCase(substring2) || ".png".equalsIgnoreCase(substring) || ".bmp".equalsIgnoreCase(substring) || ".gif".equalsIgnoreCase(substring)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static int m2792d() {
        return f1249b;
    }

    public static void m2762a(int i) {
        f1249b = i;
    }

    public static void m2795e(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            C1373c.m6139b("AppLogApi/FeedbackUtils", "waitUploadZipfile = " + file);
            if (file.exists()) {
                int i = 0;
                while (i < 2) {
                    if (file.delete()) {
                        C1373c.m6139b("AppLogApi/FeedbackUtils", "waitUploadZipfile delete sccess!");
                        return;
                    } else {
                        C1373c.m6139b("AppLogApi/FeedbackUtils", " waitUploadZipfile delete fail!");
                        i++;
                    }
                }
            }
        }
    }

    public static void m2765a(File file) {
        if (file.isFile()) {
            if (file.delete()) {
                C1373c.m6139b("AppLogApi/FeedbackUtils", "delete sdcard/phoneservice/image suc!");
                return;
            }
            C1373c.m6139b("AppLogApi/FeedbackUtils", "delete sdcard/phoneservice/image failure!");
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File a : listFiles) {
                    C0811c.m2765a(a);
                }
            }
        }
    }

    public static boolean m2770a(Activity activity, String str, int i) {
        if (VERSION.SDK_INT <= 22 || activity == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (activity.checkSelfPermission(str) == 0) {
            return false;
        }
        C1373c.m6141d("AppLogApi/FeedbackUtils", str + " is not granted!");
        activity.requestPermissions(new String[]{str}, i);
        return true;
    }

    public static boolean m2803j(Context context) {
        return C0811c.m2785b(context, "com.huawei.imonitor") || C0811c.m2797e(context);
    }

    public static boolean m2804k(Context context) {
        return C0811c.m2785b(context, "com.huawei.imonitor") || C0811c.m2785b(context, "com.huawei.lcagent");
    }

    public static boolean m2805l(Context context) {
        if (C0811c.m2806m(context)) {
            return true;
        }
        if (C0811c.m2808o(context) && C0811c.m2796e()) {
            return true;
        }
        return false;
    }

    public static boolean m2806m(Context context) {
        return C0808a.m2700a().m2728i(context);
    }

    public static boolean m2807n(Context context) {
        return C0808a.m2700a().m2730k(context);
    }

    public static boolean m2796e() {
        String str;
        String str2;
        String str3 = "";
        String str4 = "";
        try {
            Object a = C0811c.m2756a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.language"});
            Object a2 = C0811c.m2756a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.region"});
            if (a != null) {
                str3 = (String) a;
            }
            if (a2 != null) {
                str = (String) a2;
            } else {
                str = str4;
            }
            str2 = str3;
        } catch (Exception e) {
            Exception exception = e;
            str = str3;
            C1373c.m6141d("AppLogApi/FeedbackUtils", "isChinaROM Exception!" + exception.getMessage());
            str2 = str;
            str = str4;
        }
        if (PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equalsIgnoreCase(str2) && HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(r1)) {
            return true;
        }
        return false;
    }

    public static File m2754a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "moveLogtoData fail!");
            return null;
        }
        C1373c.m6141d("AppLogApi/FeedbackUtils", "小包从sd路径移动至data/data目录" + str);
        File file = new File(str);
        String str3 = context.getFilesDir().getPath() + File.separator + "temp_" + file.getName();
        File file2 = new File(str3);
        String str4 = context.getFilesDir().getPath() + File.separator + file.getName();
        C0811c.m2767a(str, str3, context);
        C0811c.m2783b(file);
        file = C1370a.m6097a(file2, str2, str4);
        C0811c.m2783b(file2);
        return file;
    }

    public static void m2767a(String str, String str2, Context context) {
        FileInputStream fileInputStream;
        IOException iOException;
        IOException iOException2;
        Throwable th;
        Exception exception;
        Exception exception2;
        Throwable th2;
        FileInputStream fileInputStream2 = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.endsWith(LightCloudConstants.ZIP_POSTFIX)) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", "copyFile " + str + " to " + str2);
            File file = new File(str);
            boolean j = C0808a.m2700a().m2729j(context);
            if (j || file.length() <= 819200) {
                FileOutputStream fileOutputStream;
                try {
                    FileOutputStream fileOutputStream2;
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(str);
                        try {
                            fileOutputStream = new FileOutputStream(str2);
                        } catch (IOException e) {
                            iOException = e;
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            iOException2 = iOException;
                            try {
                                C1373c.m6141d("AppLogApi/FeedbackUtils", "copyFile failed IOException!" + iOException2.getMessage());
                                b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                                b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                                return;
                            } catch (Throwable th3) {
                                th = th3;
                                b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                                b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                                throw th;
                            }
                        } catch (Exception e2) {
                            exception = e2;
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            exception2 = exception;
                            C1373c.m6141d("AppLogApi/FeedbackUtils", "copyFile failed!" + exception2.getMessage());
                            b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                            b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                            return;
                        } catch (Throwable th4) {
                            th2 = th4;
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            th = th2;
                            b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                            b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                            throw th;
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream2 = fileOutputStream;
                        } catch (IOException e3) {
                            iOException = e3;
                            fileInputStream2 = fileInputStream;
                            iOException2 = iOException;
                            C1373c.m6141d("AppLogApi/FeedbackUtils", "copyFile failed IOException!" + iOException2.getMessage());
                            b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                            b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                            return;
                        } catch (Exception e4) {
                            exception = e4;
                            fileInputStream2 = fileInputStream;
                            exception2 = exception;
                            C1373c.m6141d("AppLogApi/FeedbackUtils", "copyFile failed!" + exception2.getMessage());
                            b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                            b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                            return;
                        } catch (Throwable th5) {
                            th2 = th5;
                            fileInputStream2 = fileInputStream;
                            th = th2;
                            b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                            b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                            throw th;
                        }
                    }
                    fileInputStream = null;
                    b.a(fileInputStream, "AppLogApi/FeedbackUtils");
                    b.a(fileOutputStream2, "AppLogApi/FeedbackUtils");
                    return;
                } catch (IOException e5) {
                    iOException2 = e5;
                    fileOutputStream = null;
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "copyFile failed IOException!" + iOException2.getMessage());
                    b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                    b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                    return;
                } catch (Exception e6) {
                    exception2 = e6;
                    fileOutputStream = null;
                    C1373c.m6141d("AppLogApi/FeedbackUtils", "copyFile failed!" + exception2.getMessage());
                    b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                    b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                    b.a(fileInputStream2, "AppLogApi/FeedbackUtils");
                    b.a(fileOutputStream, "AppLogApi/FeedbackUtils");
                    throw th;
                }
            }
            C1373c.m6141d("AppLogApi/FeedbackUtils", "isUnLimitSize==" + j + "---oldfile too large!");
        }
    }

    public static void m2783b(File file) {
        if (file != null && file.exists()) {
            int i = 0;
            while (i < 2) {
                if (file.delete()) {
                    C1373c.m6139b("AppLogApi/FeedbackUtils", "deleteZipfile sccess!" + file.toString());
                    return;
                } else {
                    C1373c.m6139b("AppLogApi/FeedbackUtils", " deleteZipfile fail!" + file.toString());
                    i++;
                }
            }
        }
    }

    public static boolean m2808o(Context context) {
        boolean z = true;
        if (context == null) {
            C1373c.m6140c("AppLogApi/FeedbackUtils", " isallowReprot false!");
            return false;
        }
        if (Secure.getInt(context.getContentResolver(), "user_experience_involved", -1) != 1) {
            z = false;
        }
        return z;
    }

    public static Object m2756a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C1373c.m6139b("AppLogApi/FeedbackUtils", "invokeFun params invalid");
            return null;
        }
        Class cls;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            C1373c.m6139b("AppLogApi/FeedbackUtils", " staticFun ClassNotFoundException!");
            cls = null;
        }
        if (cls != null) {
            return C0811c.m2755a(cls, str2, (Class[]) clsArr, objArr);
        }
        return null;
    }

    public static Object m2755a(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        Method method;
        Object invoke;
        Method method2 = null;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            C1373c.m6139b("AppLogApi/FeedbackUtils", " staticFun NoSuchMethodException!");
            method = method2;
        }
        if (method != null) {
            try {
                invoke = method.invoke(null, objArr);
            } catch (IllegalAccessException e2) {
                C1373c.m6139b("AppLogApi/FeedbackUtils", " staticFun IllegalAccessException!");
            } catch (IllegalArgumentException e3) {
                C1373c.m6139b("AppLogApi/FeedbackUtils", " staticFun IllegalArgumentException!");
            } catch (InvocationTargetException e4) {
                C1373c.m6139b("AppLogApi/FeedbackUtils", " staticFun InvocationTargetException!");
            }
        }
        return invoke;
    }

    public static boolean m2809p(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable();
    }

    public static String m2810q(Context context) {
        if (com.huawei.phoneserviceuni.common.c.a.a.a().c() == null) {
            com.huawei.phoneserviceuni.common.c.a.a.a().a(context);
        }
        return com.huawei.phoneserviceuni.common.a.a.c();
    }

    private static String m2782b(Context context, int i) {
        String str = "";
        if (context == null) {
            return str;
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        List list = null;
        if (packagesForUid != null) {
            list = Arrays.asList(packagesForUid);
        }
        if (list != null && list.contains("com.huawei.deveco.crowdtest")) {
            return "com.huawei.deveco.crowdtest";
        }
        C1373c.m6141d("AppLogApi/FeedbackUtils", "packageName is not crowdtest");
        return str;
    }

    public static String m2799f(String str) {
        if (str == null) {
            return "";
        }
        String str2 = str;
        for (CharSequence charSequence : new String[]{"\"", "|"}) {
            if (str2.contains(charSequence)) {
                str2 = str2.replace(charSequence, "-");
            }
        }
        return str2;
    }

    public static boolean m2769a(Activity activity) {
        if (VERSION.SDK_INT < 24 || activity == null) {
            return false;
        }
        if (activity.checkSelfPermission("android.permission.WRITE_MEDIA_STORAGE") != 0) {
            C1373c.m6141d("AppLogApi/FeedbackUtils", " is not have android.permission.WRITE_MEDIA_STORAGE");
            return false;
        }
        C1373c.m6141d("AppLogApi/FeedbackUtils", "have android.permission.WRITE_MEDIA_STORAGE");
        return true;
    }

    public static Bitmap m2753a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i <= 0) {
            i = 225;
        }
        if (i2 <= 0) {
            i2 = 225;
        }
        int i3;
        if ((width * i2) / height > i) {
            i3 = (height * i) / i2;
            createBitmap = Bitmap.createBitmap(bitmap, (width - i3) / 2, 0, i3, height);
        } else if ((width * i2) / height < i) {
            i3 = (width * i2) / i;
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height - i3) / 2, width, i3);
        } else {
            createBitmap = bitmap;
        }
        float width2 = ((float) i) / ((float) createBitmap.getWidth());
        float height2 = ((float) i2) / ((float) createBitmap.getHeight());
        if (i == createBitmap.getWidth() && i2 == createBitmap.getHeight()) {
            return createBitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(width2, height2);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
    }

    public static Bitmap m2752a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap m2779b(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
        paint.setAntiAlias(true);
        paint.setColor(637534208);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        canvas.drawRoundRect(rectF, f, f, paint);
        return bitmap;
    }

    public static boolean m2790c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Set<CharSequence> m = C0808a.m2700a().m2732m(context);
        if (m == null) {
            C1373c.m6139b("AppLogApi/FeedbackUtils", "getDomain null , false");
            return false;
        } else if (m.size() == 0) {
            C1373c.m6139b("AppLogApi/FeedbackUtils", "getDomain empty ,true");
            return true;
        } else {
            for (CharSequence contains : m) {
                String group;
                Matcher matcher = Pattern.compile("(?<=://|)(([A-Za-z0-9_-])+\\.)+[A-Za-z0-9_-]+").matcher(str);
                String str2 = "";
                if (matcher.find()) {
                    group = matcher.group();
                } else {
                    try {
                        group = "";
                    } catch (IllegalStateException e) {
                        return false;
                    }
                }
                if ((group == null ? "" : group.toLowerCase(Locale.getDefault())).contains(contains)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void m2764a(WebView webView) {
        if (webView != null) {
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
    }

    public static int m2811r(Context context) {
        if (!C1372a.m6123h()) {
            return context.getResources().getColor(C0820d.m2877d(context, "feedback_blue_disable"));
        }
        if (C1372a.m6128m()) {
            return context.getResources().getColor(C0820d.m2877d(context, "feedback_highlight_color_disable"));
        }
        return context.getResources().getColor(C0820d.m2877d(context, "feedback_highlight_color_disable_old"));
    }

    public static int m2812s(Context context) {
        return C0811c.m2813t(context).widthPixels;
    }

    public static DisplayMetrics m2813t(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static int m2751a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static boolean m2814u(Context context) {
        int i = context.getResources().getConfiguration().smallestScreenWidthDp;
        C1373c.m6139b("AppLogApi/FeedbackUtils", "isPad::smallSW=" + i);
        return i >= 530;
    }

    public static String m2815v(Context context) {
        if (context != null) {
            if (VERSION.SDK_INT >= 26) {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "is o version");
                if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                    return Build.getSerial();
                }
                C1373c.m6141d("AppLogApi/FeedbackUtils", "is o version,but have not permission");
            } else {
                C1373c.m6141d("AppLogApi/FeedbackUtils", "is not o version");
                String l = C1372a.m6127l();
                if (!TextUtils.isEmpty(l)) {
                    return l;
                }
            }
        }
        return "000000000000000";
    }
}
