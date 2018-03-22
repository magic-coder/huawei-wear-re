package com.huawei.appmarket.p348a.p350b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.huawei.appmarket.C4234a;
import com.huawei.appmarket.p348a.p353e.C4233b;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.C4288e;
import com.huawei.appmarket.service.p378b.C4324c;
import com.huawei.appmarket.service.p378b.C4325d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C4213a {
    private static String f15832a = "appstoreLog.zip";

    public static String m20467a(Context context) {
        String b = C4233b.m20517a().m20516b("StoragePathKey", "");
        C4241a.m20529a("StorageManage", "getAppStoragePath, storagePath = " + b);
        if (!C4288e.m20696b(b)) {
            return b;
        }
        b = C4213a.m20473f(context).m20828a();
        C4213a.m20468a(b);
        return b;
    }

    public static void m20468a(String str) {
        C4233b.m20517a().m20515a("StoragePathKey", str);
        C4241a.m20529a("StorageManage", "setAppStoragePath, storagePath = " + str);
    }

    public static C4324c m20469b(Context context) {
        C4324c c4324c;
        String a = C4213a.m20467a(context);
        List d = C4213a.m20471d(context);
        int size = d.size();
        for (int i = 0; i < size; i++) {
            c4324c = (C4324c) d.get(i);
            if (a.equals(c4324c.m20828a())) {
                if (c4324c.m20832b() == 0) {
                    c4324c = C4213a.m20473f(context);
                    C4213a.m20468a(c4324c.m20828a());
                }
                if (c4324c == null) {
                    c4324c = C4213a.m20473f(context);
                    C4213a.m20468a(c4324c.m20828a());
                }
                C4241a.m20529a("StorageManage", "getAppStorageInfo, retStorageInfo = " + c4324c.toString());
                return c4324c;
            }
        }
        c4324c = null;
        if (c4324c == null) {
            c4324c = C4213a.m20473f(context);
            C4213a.m20468a(c4324c.m20828a());
        }
        C4241a.m20529a("StorageManage", "getAppStorageInfo, retStorageInfo = " + c4324c.toString());
        return c4324c;
    }

    public static List<C4324c> m20470c(Context context) {
        List<C4324c> arrayList = new ArrayList();
        if (context != null) {
            try {
                StorageManager storageManager = (StorageManager) context.getSystemService("storage");
                Object[] objArr = (Object[]) storageManager.getClass().getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
                for (Object obj : objArr) {
                    String str = (String) obj.getClass().getMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
                    File file = new File(str);
                    if (file.getTotalSpace() > 0 && file.canWrite()) {
                        C4324c c4324c = new C4324c();
                        boolean booleanValue = ((Boolean) obj.getClass().getMethod("isRemovable", new Class[0]).invoke(obj, new Object[0])).booleanValue();
                        if (booleanValue) {
                            if (VERSION.SDK_INT >= 23) {
                                String str2 = (String) obj.getClass().getMethod("getUuid", new Class[0]).invoke(obj, new Object[0]);
                                Object invoke = storageManager.getClass().getMethod("findVolumeByUuid", new Class[]{String.class}).invoke(storageManager, new Object[]{str2});
                                invoke = invoke.getClass().getMethod("getDisk", new Class[0]).invoke(invoke, new Object[0]);
                                if (((Boolean) invoke.getClass().getMethod("isUsb", new Class[0]).invoke(invoke, new Object[0])).booleanValue()) {
                                    C4241a.m20532b("StorageManage", "getVolumeList, isUsb, filePath: " + str);
                                }
                            } else if (file.getAbsolutePath().contains("usb")) {
                                C4241a.m20532b("StorageManage", "getVolumeList, contains usb, filePath: " + str);
                            }
                            context.getExternalFilesDir(null);
                            c4324c.m20830a(C4325d.EXTERNAL_SDCARD);
                        } else {
                            c4324c.m20830a(C4325d.INNER_SDCARD);
                        }
                        c4324c.m20833b(file.getFreeSpace());
                        c4324c.m20829a(file.getTotalSpace());
                        c4324c.m20831a(file.getAbsolutePath() + "/Android/data/" + context.getPackageName());
                        arrayList.add(c4324c);
                        C4241a.m20529a("StorageManage", "getVolumeList, storageInfo = " + c4324c.toString() + ", pathFile: canWrite, canRead, canExecute, usableSpace = " + file.canWrite() + ", " + file.canRead() + ", " + file.canExecute() + ", " + file.getUsableSpace() + ", isRemovable = " + booleanValue);
                    }
                }
            } catch (Throwable e) {
                arrayList.clear();
                arrayList.add(C4213a.m20474g(C4234a.m20519a().m20523b()));
                C4241a.m20530a("StorageManage", "getVolumeList error: ", e);
            }
        } else {
            arrayList.clear();
            C4241a.m20532b("StorageManage", "getVolumeList, context == null");
        }
        Collections.sort(arrayList, new C4324c());
        return arrayList;
    }

    public static List<C4324c> m20471d(Context context) {
        List<C4324c> arrayList = new ArrayList();
        if (context != null) {
            arrayList.addAll(C4213a.m20470c(context));
            arrayList.add(C4213a.m20472e(context));
            Collections.sort(arrayList, new C4324c());
        }
        return arrayList;
    }

    public static C4324c m20472e(Context context) {
        File filesDir = context.getFilesDir();
        C4324c c4324c = new C4324c();
        c4324c.m20833b(filesDir.getFreeSpace());
        c4324c.m20829a(filesDir.getTotalSpace());
        c4324c.m20831a(filesDir.getAbsolutePath());
        c4324c.m20830a(C4325d.SYSTEM_STORAGE);
        return c4324c;
    }

    private static C4324c m20473f(Context context) {
        List c = C4213a.m20470c(context);
        int size = c.size();
        return size > 0 ? (C4324c) c.get(size - 1) : C4213a.m20472e(context);
    }

    private static C4324c m20474g(Context context) {
        if (context == null) {
            C4241a.m20532b("StorageManage", "getDefaultSdcard error, context = null");
            return new C4324c();
        }
        context.getExternalFilesDir(null);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        C4324c c4324c = new C4324c();
        c4324c.m20833b(externalStorageDirectory.getFreeSpace());
        c4324c.m20829a(externalStorageDirectory.getTotalSpace());
        c4324c.m20831a(externalStorageDirectory.getAbsolutePath() + "/Android/data/" + context.getPackageName());
        c4324c.m20830a(C4325d.UNKNOWN_TYPE);
        C4241a.m20529a("StorageManage", "getDefaultSdcard, storageInfo = " + c4324c.toString());
        return c4324c;
    }
}
