package com.p230a.p231b.p232b.p233a.p236a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.p230a.p231b.p232b.p233a.C3117o;
import java.io.File;

public class C3097k {
    public static C3117o m13837a(Context context) {
        return C3097k.m13838a(context, null);
    }

    public static C3117o m13838a(Context context, C3091g c3091g) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName)).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (c3091g == null) {
            c3091g = VERSION.SDK_INT >= 9 ? new C3094h() : new C3092e(AndroidHttpClient.newInstance(str));
        }
        C3117o c3117o = new C3117o(new C3089c(file), new C3086a(c3091g));
        c3117o.m13898a();
        return c3117o;
    }
}
