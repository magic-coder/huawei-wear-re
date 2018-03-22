package com.huawei.hwid.api.common.p425b;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.api.common.C5093f;

/* compiled from: SDKCloudAccountImpl */
public class C5080a {
    public static AlertDialog m24455a(Activity activity, String str, Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        return new C5093f(activity, str, bundle, cloudRequestHandler).show();
    }
}
