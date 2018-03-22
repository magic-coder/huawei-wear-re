package com.huawei.appmarket.p348a.p352d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.appmarket.p348a.p351c.C4215a;
import com.huawei.appmarket.p348a.p351c.C4216b;
import com.huawei.appmarket.p348a.p351c.C4217c;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;
import java.lang.reflect.Method;
import net.sqlcipher.database.SQLiteDatabase;

public class C4219b {
    private static int m20485a() {
        C4217c a = C4216b.m20481a("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm get-install-location", false, true);
        if (a.f15834a == 0 && a.f15835b != null && a.f15835b.length() > 0) {
            try {
                switch (Integer.parseInt(a.f15835b.substring(0, 1))) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                }
            } catch (Throwable e) {
                C4241a.m20530a("InstallProcess", "pm get-install-location error", e);
            }
        }
        return 0;
    }

    private static Intent m20486a(String str) {
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    protected static void m20487a(Context context, C4220c c4220c) {
        C4219b.m20488a(context, c4220c.f15843g);
        if ((c4220c.f15840d & 1) == 1) {
            c4220c.f15838b = C4223f.INSTALLING;
            if (C4219b.m20489a(context, c4220c, context.getPackageName().equals(c4220c.f15842f))) {
                C4230m.m20506a(3, 2);
                return;
            }
            if (context.getPackageName().equals(c4220c.f15842f)) {
                C4215a.m20477a();
            }
            c4220c.f15838b = C4223f.NOT_HANDLER;
            if ((c4220c.f15840d & 256) == 256) {
                c4220c.f15847k = true;
                C4219b.m20493b(context, c4220c);
                return;
            }
            C4230m.m20506a(4, 2);
        } else if ((c4220c.f15840d & 16) == 16) {
            c4220c.f15838b = C4223f.INSTALLING;
            if (C4219b.m20490a(c4220c)) {
                C4230m.m20506a(3, 1);
                return;
            }
            c4220c.f15838b = C4223f.NOT_HANDLER;
            if ((c4220c.f15840d & 256) == 256) {
                c4220c.f15847k = true;
                C4219b.m20493b(context, c4220c);
                return;
            }
            C4230m.m20506a(4, 3);
        } else if ((c4220c.f15840d & 256) == 256) {
            C4219b.m20493b(context, c4220c);
        }
    }

    private static void m20488a(Context context, String str) {
        String parent = context.getFilesDir().getParent();
        if (parent != null && str.startsWith(parent)) {
            C4216b.m20484a("chmod 775 " + new File(str).getParent());
            C4216b.m20484a("chmod 666 " + str);
        }
    }

    private static boolean m20489a(Context context, C4220c c4220c, boolean z) {
        C4241a.m20529a("InstallProcess", "innerInstall begin!!!task:" + c4220c.toString());
        c4220c.f15846j = 1;
        C4221d c4221d = new C4221d(c4220c);
        Uri fromFile = Uri.fromFile(new File(c4220c.f15843g));
        PackageManager packageManager = context.getPackageManager();
        try {
            Method method = PackageManager.class.getMethod("installPackage", new Class[]{Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class});
            if (z) {
                C4215a.m20479b();
                C4215a.m20480b(context);
                Thread.sleep(1000);
            }
            method.invoke(packageManager, new Object[]{fromFile, c4221d, Integer.valueOf(2), c4220c.f15842f});
            C4241a.m20529a("InstallProcess", " inner install end!" + c4220c.toString());
            return true;
        } catch (Throwable e) {
            C4241a.m20530a("InstallProcess", "installPackage NoSuchMethodException ", e);
            C4241a.m20532b("InstallProcess", " inner install failed!!!!");
            return false;
        } catch (Throwable e2) {
            C4241a.m20530a("InstallProcess", "installPackage IllegalAccessException ", e2);
            C4241a.m20532b("InstallProcess", " inner install failed!!!!");
            return false;
        } catch (Throwable e22) {
            C4241a.m20530a("InstallProcess", "installPackage IllegalArgumentException ", e22);
            C4241a.m20532b("InstallProcess", " inner install failed!!!!");
            return false;
        } catch (Throwable e222) {
            C4241a.m20530a("InstallProcess", "installPackage InvocationTargetException ", e222);
            C4241a.m20532b("InstallProcess", " inner install failed!!!!");
            return false;
        } catch (Throwable e2222) {
            C4241a.m20530a("InstallProcess", "inner install exception: ", e2222);
            C4241a.m20532b("InstallProcess", " inner install failed!!!!");
            return false;
        }
    }

    private static boolean m20490a(C4220c c4220c) {
        C4241a.m20529a("InstallProcess", "rootInstall begin!!!task:" + c4220c.toString());
        int b = C4219b.m20491b(c4220c);
        if (b == 1) {
            return true;
        }
        if (b <= -111) {
            return false;
        }
        c4220c.f15838b = C4223f.NOT_HANDLER;
        return true;
    }

    private static int m20491b(C4220c c4220c) {
        c4220c.f15846j = 16;
        if (TextUtils.isEmpty(c4220c.f15843g)) {
            return -3;
        }
        String str = c4220c.f15843g;
        File file = new File(str);
        if (file == null || !file.isFile() || !file.exists() || file.length() <= 0) {
            return -3;
        }
        str = "LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r " + C4219b.m20492b() + HwAccountConstants.BLANK + str.replace(HwAccountConstants.BLANK, "\\ ");
        C4241a.m20529a("InstallProcess", " beging to root install:" + str);
        C4217c a = C4216b.m20481a(str, true, true);
        if (a.f15834a == 0) {
            if (!TextUtils.isEmpty(a.f15835b) && (a.f15835b.contains("Success") || a.f15835b.contains(LightCloudConstants.RESPONSE_RESULT_SUCCESS))) {
                C4241a.m20529a("InstallProcess", "root install success!!!");
                return 1;
            } else if (!TextUtils.isEmpty(a.f15836c)) {
                if (a.f15836c.contains("INSTALL_FAILED_ALREADY_EXISTS")) {
                    return -1;
                }
                if (a.f15836c.contains("INSTALL_FAILED_INVALID_APK")) {
                    return -2;
                }
                if (a.f15836c.contains("INSTALL_FAILED_INVALID_URI")) {
                    return -3;
                }
                if (a.f15836c.contains("INSTALL_FAILED_INSUFFICIENT_STORAGE")) {
                    return -4;
                }
                if (a.f15836c.contains("INSTALL_FAILED_DUPLICATE_PACKAGE")) {
                    return -5;
                }
                if (a.f15836c.contains("INSTALL_FAILED_NO_SHARED_USER")) {
                    return -6;
                }
                if (a.f15836c.contains("INSTALL_FAILED_UPDATE_INCOMPATIBLE")) {
                    return -7;
                }
                if (a.f15836c.contains("INSTALL_FAILED_SHARED_USER_INCOMPATIBLE")) {
                    return -8;
                }
                if (a.f15836c.contains("INSTALL_FAILED_MISSING_SHARED_LIBRARY")) {
                    return -9;
                }
                if (a.f15836c.contains("INSTALL_FAILED_REPLACE_COULDNT_DELETE")) {
                    return -10;
                }
                if (a.f15836c.contains("INSTALL_FAILED_DEXOPT")) {
                    return -11;
                }
                if (a.f15836c.contains("INSTALL_FAILED_OLDER_SDK")) {
                    return -12;
                }
                if (a.f15836c.contains("INSTALL_FAILED_CONFLICTING_PROVIDER")) {
                    return -13;
                }
                if (a.f15836c.contains("INSTALL_FAILED_NEWER_SDK")) {
                    return -14;
                }
                if (a.f15836c.contains("INSTALL_FAILED_TEST_ONLY")) {
                    return -15;
                }
                if (a.f15836c.contains("INSTALL_FAILED_CPU_ABI_INCOMPATIBLE")) {
                    return -16;
                }
                if (a.f15836c.contains("INSTALL_FAILED_MISSING_FEATURE")) {
                    return -17;
                }
                if (a.f15836c.contains("INSTALL_FAILED_CONTAINER_ERROR")) {
                    return -18;
                }
                if (a.f15836c.contains("INSTALL_FAILED_INVALID_INSTALL_LOCATION")) {
                    return -19;
                }
                if (a.f15836c.contains("INSTALL_FAILED_MEDIA_UNAVAILABLE")) {
                    return -20;
                }
                if (a.f15836c.contains("INSTALL_FAILED_VERIFICATION_TIMEOUT")) {
                    return -21;
                }
                if (a.f15836c.contains("INSTALL_FAILED_VERIFICATION_FAILURE")) {
                    return -22;
                }
                if (a.f15836c.contains("INSTALL_FAILED_PACKAGE_CHANGED")) {
                    return -23;
                }
                if (a.f15836c.contains("INSTALL_FAILED_UID_CHANGED")) {
                    return -24;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_NOT_APK")) {
                    return -100;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_BAD_MANIFEST")) {
                    return -101;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION")) {
                    return SdkConstants.STAT_LOGIN_FAIL_PASSWD_EXPIRED;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_NO_CERTIFICATES")) {
                    return SdkConstants.STAT_LOGIN_FAIL_OTHER_REASON;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES")) {
                    return -104;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING")) {
                    return -105;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME")) {
                    return -106;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID")) {
                    return -107;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_MANIFEST_MALFORMED")) {
                    return -108;
                }
                if (a.f15836c.contains("INSTALL_PARSE_FAILED_MANIFEST_EMPTY")) {
                    return -109;
                }
                if (a.f15836c.contains("INSTALL_FAILED_INTERNAL_ERROR")) {
                    return -110;
                }
                if (a.f15836c.contains("Permission denied") || a.f15836c.contains("Operation not permitted")) {
                    return -111;
                }
            }
        }
        return -1000000;
    }

    private static String m20492b() {
        switch (C4219b.m20485a()) {
            case 1:
                return "-f";
            case 2:
                return "-s";
            default:
                return "";
        }
    }

    private static void m20493b(Context context, C4220c c4220c) {
        if (c4220c == null) {
            C4241a.m20532b("InstallProcess", "system install failed,task is null");
            return;
        }
        C4241a.m20529a("InstallProcess", "systemInstall begin!!!task:" + c4220c.toString());
        c4220c.f15838b = C4223f.NOT_HANDLER;
        c4220c.f15846j = 256;
        C4230m.m20506a(3, 1);
        File file = new File(c4220c.f15843g);
        if (file == null || !file.exists() || !file.isFile() || file.length() <= 0) {
            C4241a.m20532b("InstallProcess", "system install failed,file not existed filePath:" + c4220c.f15843g);
        } else {
            context.startActivity(C4219b.m20486a(c4220c.f15843g));
        }
    }
}
