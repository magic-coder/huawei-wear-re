package com.huawei.crowdtestsdk.utils;

import android.text.TextUtils;
import com.huawei.crowdtestsdk.httpaccess.HttpResult;

public class OtherUtils {
    public static boolean isHttpResultCorrect(HttpResult httpResult) {
        if (httpResult == null || TextUtils.isEmpty(httpResult.content) || !httpResult.isResponseOK()) {
            return false;
        }
        return true;
    }
}
