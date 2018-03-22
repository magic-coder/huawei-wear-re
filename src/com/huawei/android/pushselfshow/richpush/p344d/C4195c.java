package com.huawei.android.pushselfshow.richpush.p344d;

import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

public class C4195c {
    public static String m20382a(String str) {
        return ("application/zip".equals(str) || "application/zip_local".equals(str)) ? LightCloudConstants.ZIP_POSTFIX : "text/html".equals(str) ? ".html" : "image/jpeg".equals(str) ? ".jpg" : ".unknow";
    }
}
