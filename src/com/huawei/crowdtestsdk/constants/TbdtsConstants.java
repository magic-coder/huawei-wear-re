package com.huawei.crowdtestsdk.constants;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.db.DBConstants;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import com.huawei.uploadlog.p188c.C2515k;
import com.huawei.uploadlog.p188c.C2516l;
import java.io.File;

public class TbdtsConstants {
    private static String currentUserId;
    private static TbdtsConstants instance;

    private TbdtsConstants() {
    }

    public static TbdtsConstants getInstance() {
        if (instance == null) {
            instance = new TbdtsConstants();
        }
        return instance;
    }

    public static void setCurrentUserId(String str) {
        currentUserId = str;
    }

    public String getCurrentUserId() {
        if (StringUtils.isNullOrEmpty(currentUserId)) {
            setCurrentUserId(C2514j.m12519b());
        }
        return currentUserId;
    }

    public static void clearUserData() {
        currentUserId = null;
    }

    public static void cleanSdkData(Context context) {
        try {
            cleanInternalCache(context);
            cleanExternalCache(context);
            cleanDatabases(context);
            cleanSharedPreference(context);
            cleanFiles(context);
        } catch (Exception e) {
            C2511g.m12481b("BETACLUB_SDK", "[TbdtsConstants.cleanSdkData]clean SDK date error! ");
        }
    }

    private static void cleanInternalCache(Context context) {
        deleteFilesByDirectory(context.getCacheDir());
    }

    private static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            deleteFilesByDirectory(context.getExternalCacheDir());
        }
    }

    private static void cleanDatabases(Context context) {
        File dir = getDir(context, "databases");
        File file = new File(dir, DBConstants.DATABASE_NAME);
        File file2 = new File(dir, "logupload.db");
        if (file.delete()) {
            C2511g.m12477a("BETACLUB_SDK", "[TbdtsConstants.cleanDatabases]crowtestDb.delete success!");
        }
        if (file2.delete()) {
            C2511g.m12477a("BETACLUB_SDK", "[TbdtsConstants.cleanDatabases]uploadDb.delete success!");
        }
    }

    private static void cleanSharedPreference(Context context) {
        C2514j.m12533g();
        C2515k.m12541a(context);
        C2516l.m12558c();
    }

    private static void cleanFiles(Context context) {
        File file = new File(SdkConstants.getBetaTargetPathString(context));
        if (file != null && file.exists()) {
            FileUtils.deleteDir(file.getAbsolutePath());
        }
    }

    private static void deleteFilesByDirectory(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    if (delete.delete()) {
                        C2511g.m12481b("BETACLUB_SDK", "[TbdtsConstants.deleteFilesByDirectory] file delete is succeed!");
                    }
                }
            }
        }
    }

    private static File getDir(Context context, String str) {
        try {
            return new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir + "/" + str);
        } catch (NameNotFoundException e) {
            C2511g.m12484d("BETACLUB_SDK", "[TbdtsConstants.getDir]Error:");
            return null;
        }
    }
}
