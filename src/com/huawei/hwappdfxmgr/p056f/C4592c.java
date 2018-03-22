package com.huawei.hwappdfxmgr.p056f;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.huawei.ab.m;
import com.huawei.hwappdfxmgr.upload.EventLogUploadService;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.login.ui.login.a;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.p111o.C5704b;
import com.huawei.p111o.p479c.C5705a;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* compiled from: UploadLogUtil */
public final class C4592c {
    public static final String f16809a = (BaseApplication.b().getFilesDir().getAbsolutePath() + "/log/");
    public static final String f16810b = (BaseApplication.b().getFilesDir().getAbsolutePath() + "/bbb/");
    public static final String f16811c = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/huaweisystem/");
    private static final String f16812d = (BaseApplication.b().getFilesDir().getAbsolutePath() + "/log/com.huawei.bone/");
    private static Object f16813e = new Object();

    public static boolean m21871a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        int i = 0;
        while (i < allNetworkInfo.length) {
            if (allNetworkInfo[i].getTypeName().equals("WIFI") && allNetworkInfo[i].isConnected()) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void m21869a(File file) {
        String path = file.getPath();
        C2538c.b("UploadLogUtil", new Object[]{"encryfilePath" + path});
        if (path != null && !path.equals("")) {
            File file2 = new File(path);
            C2538c.b("UploadLogUtil", new Object[]{"encryfilePath" + file2.getAbsolutePath()});
            if (!file2.exists()) {
                C2538c.b("UploadLogUtil", new Object[]{"文件不存在 或者 出错！文件删除失败!"});
            } else if (file2.isDirectory()) {
                C4592c.m21870a(C4594e.m21886a(file2.getAbsolutePath()));
            } else if (file2.delete()) {
                C2538c.b("UploadLogUtil", new Object[]{"文件删除成功！"});
            } else {
                C2538c.b("UploadLogUtil", new Object[]{"文件删除失败！"});
            }
        }
    }

    public static int m21865a(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return -1;
        }
        File[] listFiles = file.listFiles();
        File file2 = new File(str2);
        if (!file2.exists() && file2.mkdirs()) {
            C2538c.b("UploadLogUtil", new Object[]{"创建目录成功"});
        }
        if (listFiles == null) {
            return -1;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                C4592c.m21865a(listFiles[i].getPath() + "/", str2 + listFiles[i].getName() + "/");
            } else {
                C4592c.m21874b(listFiles[i].getPath(), str2 + listFiles[i].getName());
            }
        }
        return 0;
    }

    public static void m21874b(String str, String str2) {
        InputStream fileInputStream;
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        OutputStream outputStream = null;
        OutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            C2538c.e("UploadLogUtil", new Object[]{"fos close Exception !!!", e.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e2) {
                                    C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e2.getMessage()});
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e3.getMessage()});
                                }
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e22.getMessage()});
                        }
                    }
                } catch (IOException e4) {
                    outputStream = fileOutputStream;
                    inputStream = fileInputStream;
                    try {
                        C2538c.e("UploadLogUtil", new Object[]{"IOException "});
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e32) {
                                C2538c.e("UploadLogUtil", new Object[]{"fos close Exception !!!", e32.getMessage()});
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                        return;
                                    } catch (IOException e222) {
                                        C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e222.getMessage()});
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th4) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e2222) {
                                        C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e2222.getMessage()});
                                    }
                                }
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (outputStream == null) {
                            try {
                                outputStream.close();
                            } catch (IOException e22222) {
                                C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e22222.getMessage()});
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = inputStream;
                        fileOutputStream = outputStream;
                        th2 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                C2538c.e("UploadLogUtil", new Object[]{"fos close Exception !!!", e5.getMessage()});
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e322) {
                                        C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e322.getMessage()});
                                    }
                                }
                            } catch (Throwable th6) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3222) {
                                        C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e3222.getMessage()});
                                    }
                                }
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e32222) {
                                C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e32222.getMessage()});
                            }
                        }
                        throw th2;
                    }
                } catch (RuntimeException e6) {
                    try {
                        C2538c.e("UploadLogUtil", new Object[]{"RuntimeException "});
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e222222) {
                                C2538c.e("UploadLogUtil", new Object[]{"fos close Exception !!!", e222222.getMessage()});
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e2222222) {
                                        C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e2222222.getMessage()});
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th7) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e322222) {
                                        C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e322222.getMessage()});
                                    }
                                }
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22222222) {
                                C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e22222222.getMessage()});
                            }
                        }
                    } catch (Throwable th8) {
                        th2 = th8;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th2;
                    }
                } catch (Exception e7) {
                    C2538c.e("UploadLogUtil", new Object[]{"Exception "});
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e222222222) {
                            C2538c.e("UploadLogUtil", new Object[]{"fos close Exception !!!", e222222222.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e2222222222) {
                                    C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e2222222222.getMessage()});
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th9) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3222222) {
                                    C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e3222222.getMessage()});
                                }
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22222222222) {
                            C2538c.e("UploadLogUtil", new Object[]{"fosto close Exception !!!", e22222222222.getMessage()});
                        }
                    }
                }
            } catch (IOException e8) {
                inputStream = fileInputStream;
                C2538c.e("UploadLogUtil", new Object[]{"IOException "});
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (RuntimeException e9) {
                fileOutputStream = null;
                C2538c.e("UploadLogUtil", new Object[]{"RuntimeException "});
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Exception e10) {
                fileOutputStream = null;
                C2538c.e("UploadLogUtil", new Object[]{"Exception "});
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th10) {
                th = th10;
                fileOutputStream = null;
                th2 = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th2;
            }
        } catch (IOException e11) {
            inputStream = null;
            C2538c.e("UploadLogUtil", new Object[]{"IOException "});
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (RuntimeException e12) {
            fileOutputStream = null;
            fileInputStream = null;
            C2538c.e("UploadLogUtil", new Object[]{"RuntimeException "});
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Exception e13) {
            fileOutputStream = null;
            fileInputStream = null;
            C2538c.e("UploadLogUtil", new Object[]{"Exception "});
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th102) {
            fileInputStream = null;
            th2 = th102;
            fileOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th2;
        }
    }

    private static void m21870a(List<File> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                C4592c.m21869a((File) list.get(i));
            }
        }
    }

    public static void m21873b(Context context) {
        C2538c.c("UploadLogUtil", new Object[]{"==ww== uploadLog"});
        boolean a = C4593d.m21885a();
        boolean c = m.a(context).c();
        boolean a2 = C4592c.m21871a(context);
        boolean d = C4592c.m21879d();
        c.c("UploadLogUtil", new Object[]{"==ww== isNoCloud=" + a + " ,isWifi=" + a2 + "  ,isHasEventLog=" + d + "  ,isHasCrash=" + false + " ,isTiyan=" + c + "isHasDeviceEventLog=" + C4592c.m21880e()});
        if (i.a(48) && c && !a) {
            if (r4) {
                C4592c.m21878d(context);
            }
            if (a2) {
                c.b("UploadLogUtil", new Object[]{"==ww== uploadLog 上传设备log文件"});
                C4592c.m21876c(context);
            }
        }
    }

    private static boolean m21879d() {
        int i = 0;
        File file = new File(BaseApplication.b().getFilesDir().getAbsolutePath() + "/bbb/");
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            C2538c.b("UploadLogUtil", new Object[]{"res:" + mkdirs});
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return false;
        }
        mkdirs = false;
        while (i < listFiles.length) {
            if (listFiles[i].getName().toLowerCase().contains("wearablebeta_event.log")) {
                mkdirs = true;
            }
            i++;
        }
        return mkdirs;
    }

    private static boolean m21880e() {
        File file = new File(f16812d + "MaintenanceLog");
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            C2538c.b("UploadLogUtil", new Object[]{"res:" + mkdirs});
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return false;
        }
        for (File name : listFiles) {
            if (name.getName().toLowerCase().contains("wearablebeta_event.log")) {
                return true;
            }
        }
        return false;
    }

    private static void m21876c(Context context) {
        C2538c.e("UploadLogUtil", new Object[]{"upLoadBandLog()"});
        String str = "";
        List a = C4592c.m21867a(f16810b);
        str = "";
        str = "";
        if (a != null && a.size() > 0) {
            for (int i = 0; i < a.size(); i++) {
                str = "";
                C2538c.c("UploadLogUtil", new Object[]{"targetPath " + (f16810b + ((File) a.get(i)).getName())});
                if (C4592c.m21871a(context)) {
                    C4592c.m21868a(context, str);
                }
            }
        }
    }

    private static List<File> m21867a(String str) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return linkedList;
        }
        String str2 = "";
        for (int i = 0; i < listFiles.length; i++) {
            C2538c.e("UploadLogUtil", new Object[]{"fileName " + listFiles[i].getName()});
            if (listFiles[i].getName().toLowerCase().contains("wearablebeta_event.log")) {
                linkedList.add(listFiles[i]);
            } else {
                C4592c.m21869a(listFiles[i]);
            }
        }
        return linkedList;
    }

    private static void m21868a(Context context, String str) {
        Intent intent = new Intent(context, EventLogUploadService.class);
        C2538c.c("UploadLogUtil", new Object[]{"huid is " + C4592c.m21866a()});
        intent.putExtra("x-huid", C4592c.m21866a());
        intent.putExtra("x-version", d.f(context));
        intent.putExtra("ts", new Date().getTime());
        intent.putExtra(HwAccountConstants.TOKEN_TYPE, 1);
        intent.putExtra(AppOpenOrDownHelper.APP_ID_PARAM, C5705a.m26330a(BaseApplication.b()));
        intent.putExtra("deviceId", d.h(context));
        C2538c.e("UploadLogUtil", new Object[]{"the siteID is " + a.a(BaseApplication.b()).e()});
        intent.putExtra("siteId", r1);
        intent.putExtra("iversion", 1);
        intent.putExtra("source", 2);
        intent.putExtra("filePath", str);
        context.startService(intent);
    }

    public static String m21866a() {
        String c = a.a(BaseApplication.b()).c();
        if (c == null) {
            return "";
        }
        return c;
    }

    private static void m21878d(Context context) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Exception exception;
        Throwable th;
        C2538c.c("UploadLogUtil", new Object[]{"encrypt event log"});
        String str = f16812d + "MaintenanceLog";
        String str2 = "";
        str2 = "";
        List a = C4592c.m21867a(str);
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        int i = 0;
        while (i < a.size()) {
            InputStream fileInputStream;
            str2 = "";
            File file = (File) a.get(i);
            String name = file.getName();
            try {
                fileInputStream = new FileInputStream(new File(str + "/" + name));
                try {
                    int available = fileInputStream.available();
                    C2538c.c("UploadLogUtil", new Object[]{"the filesize " + available});
                    byte[] bArr = new byte[(available + 4)];
                    System.arraycopy(C4592c.m21872a(available), 0, bArr, 0, 4);
                    Object obj = new byte[available];
                    if (-1 == fileInputStream.read(obj)) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e) {
                                C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + e.getMessage()});
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + e2.getMessage()});
                                fileOutputStream = fileOutputStream2;
                                inputStream = fileInputStream;
                            }
                        }
                        fileOutputStream = fileOutputStream2;
                        inputStream = fileInputStream;
                    } else {
                        System.arraycopy(obj, 0, bArr, 4, obj.length);
                        byte[] a2 = C5704b.m26317a(context).m26327a(2, bArr);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(new File(f16810b + name));
                        try {
                            fileOutputStream3.write(a2, 0, a2.length);
                            fileOutputStream3.flush();
                            C4592c.m21869a(file);
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (Exception e22) {
                                    C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + e22.getMessage()});
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e222) {
                                    C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + e222.getMessage()});
                                    fileOutputStream = fileOutputStream3;
                                    inputStream = fileInputStream;
                                }
                            }
                            fileOutputStream = fileOutputStream3;
                            inputStream = fileInputStream;
                        } catch (Exception e2222) {
                            inputStream = fileInputStream;
                            FileOutputStream fileOutputStream4 = fileOutputStream3;
                            exception = e2222;
                            fileOutputStream = fileOutputStream4;
                            C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + exception.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception exception2) {
                                    C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + exception2.getMessage()});
                                }
                            }
                            if (inputStream == null) {
                                try {
                                    inputStream.close();
                                } catch (Exception exception22) {
                                    C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + exception22.getMessage()});
                                }
                            }
                            i++;
                            inputStream2 = inputStream;
                            fileOutputStream2 = fileOutputStream;
                        } catch (OutOfMemoryError e3) {
                            fileOutputStream = fileOutputStream3;
                            inputStream = fileInputStream;
                            try {
                                C2538c.b("UploadLogUtil", new Object[]{"encryptEventLog OutOfMemoryError"});
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception exception222) {
                                        C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + exception222.getMessage()});
                                    }
                                }
                                if (inputStream == null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception exception2222) {
                                        C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + exception2222.getMessage()});
                                    }
                                }
                                i++;
                                inputStream2 = inputStream;
                                fileOutputStream2 = fileOutputStream;
                            } catch (Throwable th2) {
                                fileInputStream = inputStream;
                                fileOutputStream2 = fileOutputStream;
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream2 = fileOutputStream3;
                        }
                    }
                } catch (Exception e22222) {
                    exception2222 = e22222;
                    fileOutputStream = fileOutputStream2;
                    inputStream = fileInputStream;
                    C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + exception2222.getMessage()});
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (inputStream == null) {
                        inputStream.close();
                    }
                    i++;
                    inputStream2 = inputStream;
                    fileOutputStream2 = fileOutputStream;
                } catch (OutOfMemoryError e4) {
                    fileOutputStream = fileOutputStream2;
                    inputStream = fileInputStream;
                    C2538c.b("UploadLogUtil", new Object[]{"encryptEventLog OutOfMemoryError"});
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (inputStream == null) {
                        inputStream.close();
                    }
                    i++;
                    inputStream2 = inputStream;
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e222222) {
                Exception exception3 = e222222;
                fileOutputStream = fileOutputStream2;
                inputStream = inputStream2;
                exception2222 = exception3;
                C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + exception2222.getMessage()});
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
                i++;
                inputStream2 = inputStream;
                fileOutputStream2 = fileOutputStream;
            } catch (OutOfMemoryError e5) {
                fileOutputStream = fileOutputStream2;
                inputStream = inputStream2;
                C2538c.b("UploadLogUtil", new Object[]{"encryptEventLog OutOfMemoryError"});
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
                i++;
                inputStream2 = inputStream;
                fileOutputStream2 = fileOutputStream;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = inputStream2;
            }
            i++;
            inputStream2 = inputStream;
            fileOutputStream2 = fileOutputStream;
        }
        return;
        throw th;
        if (fileOutputStream2 != null) {
            try {
                fileOutputStream2.close();
            } catch (Exception e6) {
                C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + e6.getMessage()});
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception e62) {
                C2538c.e("UploadLogUtil", new Object[]{"encrypt file error " + e62.getMessage()});
            }
        }
        throw th;
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        throw th;
    }

    public static byte[] m21872a(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) ((i >> (24 - (i2 * 8))) & 255);
        }
        return bArr;
    }

    public static boolean m21875b() {
        File[] listFiles = new File(BaseApplication.b().getFilesDir().getAbsolutePath() + "/bbb/").listFiles();
        if (listFiles != null && listFiles.length > 0) {
            C2538c.b("UploadLogUtil", new Object[]{"file size: " + listFiles.length});
            int i = 0;
            while (i < listFiles.length) {
                C2538c.b("UploadLogUtil", new Object[]{"file name: " + listFiles[i].getName()});
                if (listFiles[i].getName().endsWith("WearAPPBeta.zip") || listFiles[i].getName().endsWith("WearableBeta.zip")) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean m21877c() {
        List a = C4594e.m21886a(f16812d + "/MaintenanceLog");
        List a2 = C4594e.m21886a(f16812d + "/MaintenanceLogTemp");
        if ((a == null || a.size() <= 0) && (a2 == null || a2.size() <= 0)) {
            return false;
        }
        return true;
    }
}
