package com.huawei.crowdtestsdk.constants;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.SystemProperties;
import android.support.v4.view.ViewCompat;
import android.view.Window;
import com.huawei.androidcommon.storage.SdcardManager;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.uploadlog.p188c.C2511g;

public class SdkConstants {
    public static final String ACTION_BIND_FEEDBACK_SERVICE = "com.huawei.crowdtestsdk.ACTION_BIND_FEEDBACK_SERVICE";
    public static final String ACTION_GOTO_FEEDBACK = "com.huawei.crowdtestsdk.GOTO_FEEDBACK_ACTIVITY";
    public static final String ACTION_LOG_COLLECT_COMPLETED = "com.huawei.crowdtestsdk.LOG_COLLECT_COMPLETED";
    public static final String ACTION_LOG_UPLOAD_RESULT = "com.huawei.crowdtestsdk.LOG_UPLOAD_RESULT";
    public static final String ACTION_REFRESH_HISTORY = "com.huawei.crowdtestsdk.REFRESH_HISTORY";
    public static final String ACTION_SHOW_ATTACH = "com.huawei.crowdtestsdk.SHOW_ATTACH";
    public static final String ACTION_STOP_FEEDBACK_SERVICE = "com.huawei.crowdtestsdk.STOP_FEEDBACK_SERVICE";
    public static final String ACTION_UPLOAD_REQUEST_INTENT = "com.huawei.crowdtestsdk.UPLOAD_REQUEST";
    public static final String APP_VERSION_NAME = "APP_VERSION_NAME";
    public static final int APR_BETACLUB_CHANNEL_ID = 5;
    public static final int BETA_VERSION = 3;
    public static final int BUG_TYPE_ID_OTHER = 100;
    public static final boolean DEBUG = false;
    public static final String DESCRIPTION_SEPARATOR = "---------------------------------------------------------------------";
    public static final String DEVICE_INFO = "device_info";
    private static final String EMUI_KEYWORD = "EmotionUI_";
    public static final String FEEDBACK_PARAMS = "FEEDBACK_PARAMS";
    public static final boolean LICENSE_SWITCH_TOGGLE = true;
    public static final int LOGIN_SUCCESS = 1;
    public static final int LOGIN_TIMEOUT = 2;
    public static final int LOG_COLLECT_FAILED = 201;
    public static final String LOG_COLLECT_PATH = "log_collect_path";
    public static final String LOG_COLLECT_STATUS = "log_collect_status";
    public static final int LOG_COLLECT_SUCCESS = 200;
    public static final String LOG_TBDST_NO = "logTbdtsNo";
    public static final int LOG_UPLOAD_FAILED = 17;
    public static final String LOG_UPLOAD_FILENAME = "logUploadFilePath";
    public static final String LOG_UPLOAD_RESULT = "logUploadResult";
    public static final int LOG_UPLOAD_SUCCESS = 16;
    public static final long OCCURRENCE_TIME_DEFAULT_VALUE = -1;
    public static final int REQUEST_CAMERA_PHOTO = 323;
    public static final int REQUEST_CAMERA_VIDEO = 324;
    public static final int REQUEST_GALLERY = 321;
    public static final int REQUEST_PERMISSION_CAMERA_CODE = 1;
    public static final int REQUEST_PERMISSION_FILE_CODE = 4;
    public static final int REQUEST_PERMISSION_GALLERY_CODE = 3;
    public static final int REQUEST_PERMISSION_VIDEO_CODE = 2;
    public static final int REQUEST_PHOTOS = 330;
    public static final String SDK_APP_PACKAGE_NAME = "com.huawei.crowdtestsdk";
    public static final String SDK_VERSION = "1.1";
    public static final int STAT_LOGIN_FAIL = -100;
    public static final int STAT_LOGIN_FAILED_MAX_TIME = -93;
    public static final int STAT_LOGIN_FAIL_OTHER_REASON = -103;
    public static final int STAT_LOGIN_FAIL_PASSWD_EXPIRED = -102;
    public static final int STAT_OK = 999;
    public static final int STAT_SERVER_ERROR = -98;
    public static final int STAT_USER_INFO_INCORRECT = -97;
    public static final int STAT_VERIFY_CODE_ERROR = -96;
    public static final String TAG = "BETACLUB_SDK";
    public static final String TAG_HTTP = "BETACLUB_SDK_HTTP";
    public static final int TIME_OUT = 120000;
    public static final String UNKNOWN = "unknown";
    public static final int UPDATE_INTERVAL_TIME = 600000;
    public static final String UPDATE_ISSUE_LIST = "com.huawei.crowdtestsdk.UPDATE_ISSUE_LIST";
    public static final String USE_CROWDTESTSDK_PERMISSION = "com.huawei.crowdtestsdk.permission.ACCESS";
    private static final String iMonitorPkgName = "com.huawei.imonitor";
    private static Boolean isEmui3 = null;
    private static Boolean isEmui4 = null;
    private static Boolean isEmui5 = null;

    public static int getCommercialVersion() {
        return 3;
    }

    private static String getRootPath(Context context) {
        return SdcardManager.getInstance().getCurrentStoragePath(context);
    }

    public static void setStatusBarColor(Activity activity, String str) {
        if (VERSION.SDK_INT >= 21 && isEmui4()) {
            Window window = activity.getWindow();
            if (StringUtils.isNullOrEmpty(str)) {
                str = "#1A93D2";
            }
            int parseColor = Color.parseColor(str);
            if (parseColor == ViewCompat.MEASURED_STATE_MASK && window.getNavigationBarColor() == ViewCompat.MEASURED_STATE_MASK) {
                window.clearFlags(Integer.MIN_VALUE);
            } else {
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setStatusBarColor(parseColor);
        }
    }

    public static boolean isEmui4() {
        if (isEmui4 != null) {
            return isEmui4.booleanValue();
        }
        return isEmui4Version();
    }

    public static boolean isEmui4Version() {
        boolean z = false;
        try {
            String str = SystemProperties.get("ro.build.version.emui");
            if (!(str == null || str.trim().indexOf("EmotionUI_4".trim()) == -1)) {
                isEmui4 = Boolean.valueOf(true);
                z = isEmui4.booleanValue();
            }
        } catch (Exception e) {
        }
        return z;
    }

    public static boolean isEmui3() {
        if (isEmui3 != null) {
            return isEmui3.booleanValue();
        }
        return isEmui3Version();
    }

    private static boolean isEmui3Version() {
        boolean z = false;
        try {
            String str = SystemProperties.get("ro.build.version.emui");
            if (!(str == null || str.trim().indexOf("EmotionUI_3".trim()) == -1)) {
                isEmui3 = Boolean.valueOf(true);
                z = isEmui3.booleanValue();
            }
        } catch (Exception e) {
        }
        return z;
    }

    public static boolean isEmui5() {
        if (isEmui5 == null) {
            isEmui5 = Boolean.valueOf(isEmui5Version());
        }
        return isEmui5.booleanValue();
    }

    private static boolean isEmui5Version() {
        return VERSION.SDK_INT >= 24 || checkHwImonitorExist();
    }

    private static boolean checkHwImonitorExist() {
        PackageInfo packageInfo;
        try {
            packageInfo = AppContext.getInstance().getApplicationContext().getPackageManager().getPackageInfo(iMonitorPkgName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    public static String getTempTargetLogPath(Context context) {
        return getRootPath(context) + "/BetaClub/Temp/";
    }

    public static String getMyOwnLogPathDirectory(Context context) {
        return getTargetLogPathString(context) + "ownlog";
    }

    public static String getTargetLogPathString(Context context) {
        return getRootPath(context) + "/BetaClub/Log/";
    }

    public static String getTargetUploadPathString(Context context) {
        return getRootPath(context) + "/BetaClub/Upload/";
    }

    public static String getTargetEncPathString(Context context) {
        return getRootPath(context) + "/BetaClub/Enc";
    }

    static String getBetaTargetPathString(Context context) {
        return getRootPath(context) + "/BetaClub/";
    }

    public static String getEmuiVersion() {
        String str = "unknown";
        try {
            String str2 = SystemProperties.get("ro.build.version.emui");
            if (str2 != null && str2.contains(EMUI_KEYWORD)) {
                str = str2.charAt(str2.indexOf(EMUI_KEYWORD) + 10) + "";
            }
        } catch (Exception e) {
            C2511g.m12484d("BETACLUB_SDK", "[SdkConstants.getEmuiVersion] error : " + e);
        }
        return str;
    }
}
