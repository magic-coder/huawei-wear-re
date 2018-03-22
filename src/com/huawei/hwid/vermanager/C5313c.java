package com.huawei.hwid.vermanager;

import android.content.Context;
import android.webkit.WebViewClient;
import com.huawei.cloudservice.C4335a;

/* compiled from: HwVersionManagerBuilder */
public abstract class C5313c {
    public static C5310d m25694a() {
        return VersionManager.m25682e();
    }

    public static WebViewClient m25693a(Context context, C4335a c4335a) {
        return new C5311a(context, c4335a);
    }
}
