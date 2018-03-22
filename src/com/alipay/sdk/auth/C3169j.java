package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.p247d.C3176a;

public final class C3169j {
    private static C3176a f10571a = null;
    private static String f10572b = null;

    public static void m14010a(Activity activity, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }
}
