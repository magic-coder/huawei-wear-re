package com.huawei.nfc.carrera.ui.util;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.p190v.C2538c;

public class PaySecurityManagerSettingUtils {
    public static final String TAG = PaySecurityManagerSettingUtils.class.getSimpleName();

    public static void gotoSetting(Context context) {
        try {
            processHuawei(context);
        } catch (SecurityException e) {
            C2538c.c(TAG, new Object[]{"SecurityException when opening security manager"});
            processSystemSetting(context);
        } catch (Exception e2) {
            C2538c.e(TAG, new Object[]{"Unknown exception occurred when opening security manager " + e2.getMessage()});
        }
    }

    public static void processHuawei(Context context) {
        try {
            C2538c.b(TAG, new Object[]{"Enter huawei"});
            ComponentName componentName = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C2538c.c(TAG, new Object[]{"not XIAOMI, start meizu process"});
            processXIAOMI(context);
        }
    }

    public static void processXIAOMI(Context context) {
        try {
            C2538c.b(TAG, new Object[]{"Enter xiaomi"});
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C2538c.c(TAG, new Object[]{"not XIAOMI, start meizu process"});
            processMEIZU(context);
        }
    }

    public static void processMEIZU(Context context) {
        try {
            C2538c.b(TAG, new Object[]{"Enter meizu"});
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.meizu.safe"));
        } catch (ActivityNotFoundException e) {
            C2538c.c(TAG, new Object[]{"not MEIZU, start oppo process"});
            processOPPO(context);
        } catch (Exception e2) {
            processOPPO(context);
        }
    }

    public static void processOPPO(Context context) {
        try {
            C2538c.b(TAG, new Object[]{"Enter oppo"});
            ComponentName componentName = new ComponentName("com.coloros.safecenter", "com.coloros.privacypermissionsentry.PermissionTopActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C2538c.c(TAG, new Object[]{"not oppo, start system setting process"});
            processVIVO(context);
        }
    }

    public static void processVIVO(Context context) {
        try {
            C2538c.b(TAG, new Object[]{"Enter vivo"});
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure"));
        } catch (ActivityNotFoundException e) {
            C2538c.c(TAG, new Object[]{"not vivo, start system setting process"});
            processLETV(context);
        } catch (Exception e2) {
            processLETV(context);
        }
    }

    public static void processLETV(Context context) {
        try {
            C2538c.b(TAG, new Object[]{"Enter letv"});
            ComponentName componentName = new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            processSystemSetting(context);
        }
    }

    public static void processSystemSetting(Context context) {
        try {
            C2538c.b(TAG, new Object[]{"Enter setting"});
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.unionpay.tsmbleuniteservice"));
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C2538c.e(TAG, new Object[]{"can't open system setting page. ingnored!!"});
        }
    }
}
