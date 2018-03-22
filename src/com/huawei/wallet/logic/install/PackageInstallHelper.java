package com.huawei.wallet.logic.install;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.wallet.utils.log.LogC;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import net.sqlcipher.database.SQLiteDatabase;

public class PackageInstallHelper {
    public boolean m28057a(Context context) {
        if (context == null) {
            LogC.m28534d("isAppHasInstallPermission context null", false);
            return false;
        }
        int checkPermission = context.getPackageManager().checkPermission("android.permission.INSTALL_PACKAGES", context.getPackageName());
        LogC.m28530b("permisstionGranted is 0 ?:" + checkPermission, false);
        if (checkPermission == 0) {
            return true;
        }
        return false;
    }

    public boolean m28058a(Context context, Handler handler, String str, String str2) {
        if (context == null) {
            LogC.m28530b("install error, context is null.", false);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            LogC.m28530b("install error, install path is valid.", false);
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            LogC.m28530b("install error, package name is null.", false);
            return false;
        } else if (m28057a(context)) {
            return m28060b(context, handler, str, str2);
        } else {
            return m28059a(context, str);
        }
    }

    public boolean m28059a(Context context, String str) {
        if (context == null) {
            LogC.m28530b("install error, context is null.", false);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            LogC.m28530b("install error, install path is valid.", false);
            return false;
        } else {
            Intent intent = new Intent("android.intent.action.VIEW");
            File file = new File(str);
            if (!file.exists() || !file.isFile() || file.length() <= 0) {
                return false;
            }
            LogC.m28530b("execute installNormal. ", false);
            intent.setDataAndType(Uri.parse("file://" + str), "application/vnd.android.package-archive");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            return true;
        }
    }

    public boolean m28060b(Context context, Handler handler, String str, String str2) {
        if (context == null) {
            LogC.m28530b("install error, context is null.", false);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            LogC.m28530b("install error, install file path is valid.", false);
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            LogC.m28530b("install error, package name is null.", false);
            return false;
        } else {
            Uri fromFile = Uri.fromFile(new File(str));
            PackageManager packageManager = context.getPackageManager();
            PackageInstallObserver packageInstallObserver = new PackageInstallObserver(handler, str2);
            try {
                PackageManager.class.getMethod("installPackage", new Class[]{Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class}).invoke(packageManager, new Object[]{fromFile, packageInstallObserver, Integer.valueOf(2), str2});
                LogC.m28530b("start install.", false);
                return true;
            } catch (NoSuchMethodException e) {
                LogC.m28534d("installSilent, occur no such method exception.", false);
                handler.sendEmptyMessage(-2001);
                return false;
            } catch (InvocationTargetException e2) {
                LogC.m28534d("installSilent, occur invocation target exception.", false);
                handler.sendEmptyMessage(-2001);
                return false;
            } catch (IllegalAccessException e3) {
                LogC.m28534d("installSilent, occur illegal access exception.", false);
                handler.sendEmptyMessage(-2001);
                return false;
            }
        }
    }
}
