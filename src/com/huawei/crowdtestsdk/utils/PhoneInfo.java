package com.huawei.crowdtestsdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import com.huawei.androidcommon.utils.AndroidUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.uploadlog.p188c.C2509e;
import org.apache.log4j.helpers.DateLayout;

public class PhoneInfo {
    private static String mDeviceFullVersion = null;
    private static String mDeviceId = null;
    private static String mDeviceModel = null;
    private static String mDeviceVersion = null;
    private static String mSeriesNumber = "unknown";

    public static String getDeviceId(Context context) {
        if (mDeviceId == null) {
            mDeviceId = C2509e.m12472a(context);
        }
        return mDeviceId;
    }

    public static String getDeviceVersion() {
        if (mDeviceVersion == null) {
            mDeviceVersion = AndroidUtils.getDeviceVersion();
        }
        return mDeviceVersion;
    }

    public static String getDeviceModel() {
        if (mDeviceModel == null) {
            mDeviceModel = AndroidUtils.getDeviceModel();
        }
        return mDeviceModel;
    }

    public static String getDeviceFullVersion() {
        if (mDeviceFullVersion == null) {
            mDeviceFullVersion = AndroidUtils.getDeviceFullVersion();
        }
        if (StringUtils.isNullOrEmpty(mDeviceFullVersion)) {
            return DateLayout.NULL_DATE_FORMAT;
        }
        return mDeviceFullVersion;
    }

    public static String getSerialNumber() {
        int i = 0;
        if ("unknown".equals(mSeriesNumber)) {
            if (SdkConstants.isEmui5()) {
                mSeriesNumber = Build.SERIAL;
            } else {
                String[] strArr = new String[]{SystemProperties.get("ro.serialno", "unknown"), SystemProperties.get("ro.boot.serialno", "unknown")};
                int length = strArr.length;
                while (i < length) {
                    String str = strArr[i];
                    if (!"unknown".equals(str)) {
                        mSeriesNumber = str;
                        break;
                    }
                    i++;
                }
            }
        }
        return mSeriesNumber;
    }
}
