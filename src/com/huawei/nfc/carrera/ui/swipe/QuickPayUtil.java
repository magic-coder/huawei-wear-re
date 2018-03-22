package com.huawei.nfc.carrera.ui.swipe;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;
import java.util.List;

final class QuickPayUtil {
    public static final int ALI_VERSION = 100;
    private static final String APP_LOCK_ACTIVITY = "{com.huawei.systemmanager/com.huawei.systemmanager.applock.password.AuthLaunchLockedAppActivity}";
    private static final String APP_LOCK_PKG = "com.huawei.systemmanager";
    public static final String SCAN_ACTION = "com.huawei.oto.intent.action.QUICKPAY2";
    public static final String SOURCE_PKG = "com.huawei.wallet";
    public static final String STR_SOURCE_PKG_PARAM = "appName";
    private static QuickPayUtil instance = new QuickPayUtil();
    private List<Activity> activityStack;

    public boolean isAppLock(Context context) {
        if (!isSystemApp(context)) {
            return false;
        }
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null) {
            LogX.i(((RunningTaskInfo) runningTasks.get(0)).topActivity.toShortString());
            if (APP_LOCK_ACTIVITY.equals(((RunningTaskInfo) runningTasks.get(0)).topActivity.toShortString())) {
                return true;
            }
        }
        return false;
    }

    private boolean isSystemApp(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageManager.getPackageInfo(APP_LOCK_PKG, 0).applicationInfo.flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            LogX.e("can not get lockapp info!");
            return false;
        }
    }

    private QuickPayUtil() {
    }

    public static QuickPayUtil getInstance() {
        return instance;
    }

    public void push(Activity activity) {
        if (this.activityStack == null) {
            this.activityStack = new ArrayList();
        }
        if (!this.activityStack.contains(activity)) {
            this.activityStack.add(activity);
        }
    }

    public void pop() {
        if (this.activityStack != null && !this.activityStack.isEmpty()) {
            this.activityStack.remove((Activity) this.activityStack.get(this.activityStack.size() - 1));
        }
    }

    public void finishMiddleActivity() {
        if (this.activityStack != null && !this.activityStack.isEmpty()) {
            int i = 0;
            while (i < this.activityStack.size()) {
                Activity activity = (Activity) this.activityStack.get(i);
                if (activity instanceof ScanPayMiddleActivity) {
                    this.activityStack.remove(activity);
                    ((ScanPayMiddleActivity) activity).finish();
                    i--;
                }
                i++;
            }
        }
    }
}
