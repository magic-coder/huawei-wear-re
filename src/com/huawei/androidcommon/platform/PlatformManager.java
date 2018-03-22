package com.huawei.androidcommon.platform;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.huawei.androidcommon.storage.SdcardManager;

public class PlatformManager {
    public static final int HISI_PLATFORM = 1;
    private static final String HISI_PLATFORM_KEY = "ro.product.platform.pseudonym";
    private static final String HISI_PLATFORM_VALUE = "1ARB9CV";
    public static final int MSM_PLATFORM = 0;
    private static final String MTK_EXTERNAL_VALUE = "external_sd";
    private static final String MTK_INTERNAL_VALUE = "internal_sd";
    public static final int MTK_PLATFORM = 2;
    private static final String MTK_PLATFORM_KEY = "ro.config.hw_ChipPlatform";
    private static final String MTK_PLATFORM_VALUE = "MTK_Platform";
    private static final String MTK_SDCARD_KEY = "persist.mtklog.log2sd.path";
    private static final String PLATFORM_KEY = "ro.board.platform";
    private static final String PLATFORM_VALUE_HISI = "hi";
    private static final String PLATFORM_VALUE_QCOM = "msm";
    private static final String QCOM_PLATFORM_KEY = "ro.hardware";
    private static final String QCOM_PLATFORM_VALUE = "qcom";
    private static final String QCOM_PLATFORM_VALUE2 = "angler";
    public static final int UNKNOW_PLATFORM = 3;
    private static PlatformManager pm = new PlatformManager();

    public static PlatformManager getInstance() {
        if (pm == null) {
            pm = new PlatformManager();
        }
        return pm;
    }

    public int getPlatform() {
        if (isHisiPlatform()) {
            return 1;
        }
        if (isMTKPlatform()) {
            return 2;
        }
        if (isMSMPlatform()) {
            return 0;
        }
        return 3;
    }

    public boolean isHisiPlatform() {
        boolean equals = HISI_PLATFORM_VALUE.equals(SystemProperties.get(HISI_PLATFORM_KEY));
        if (equals) {
            return equals;
        }
        Object obj = SystemProperties.get(PLATFORM_KEY);
        if (TextUtils.isEmpty(obj)) {
            return equals;
        }
        return obj.startsWith(PLATFORM_VALUE_HISI);
    }

    public boolean isMTKPlatform() {
        return MTK_PLATFORM_VALUE.equals(SystemProperties.get(MTK_PLATFORM_KEY));
    }

    public boolean isMSMPlatform() {
        String str = SystemProperties.get(QCOM_PLATFORM_KEY);
        boolean z = QCOM_PLATFORM_VALUE.equals(str) || QCOM_PLATFORM_VALUE2.equals(str);
        if (z) {
            return z;
        }
        Object obj = SystemProperties.get(PLATFORM_KEY);
        if (TextUtils.isEmpty(obj)) {
            return z;
        }
        return obj.startsWith(PLATFORM_VALUE_QCOM);
    }

    public String getMtkPath(Context context) {
        String str = SystemProperties.get(MTK_SDCARD_KEY);
        if (MTK_EXTERNAL_VALUE.equals(str)) {
            return SdcardManager.getInstance().getExternalStoragePath(context);
        }
        if (MTK_INTERNAL_VALUE.equals(str)) {
            return SdcardManager.getInstance().getInternalStoragePath();
        }
        return null;
    }
}
