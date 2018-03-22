package com.tencent.connect.p193b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.connect.b.a;
import com.tencent.connect.b.w;
import com.tencent.open.a.n;
import com.tencent.open.d.h;
import com.tencent.tauth.b;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public class C2672v {
    private a f9084a = new a(this.f9085b);
    private w f9085b;

    private C2672v(String str, Context context) {
        n.c("openSDK_LOG", "new QQAuth() --start");
        this.f9085b = new w(str);
        com.tencent.connect.a.a.c(context, this.f9085b);
        n.c("openSDK_LOG", "new QQAuth() --end");
    }

    public static C2672v m12772a(String str, Context context) {
        h.a(context.getApplicationContext());
        n.c("openSDK_LOG", "QQAuth -- createInstance() --start");
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            C2672v c2672v = new C2672v(str, context);
            n.c("openSDK_LOG", "QQAuth -- createInstance()  --end");
            return c2672v;
        } catch (Throwable e) {
            n.b("openSDK_LOG", "createInstance() error --end", e);
            Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
            return null;
        }
    }

    public int m12773a(Activity activity, String str, b bVar) {
        n.c("openSDK_LOG", "login()");
        return m12774a(activity, str, bVar, "");
    }

    public int m12774a(Activity activity, String str, b bVar, String str2) {
        n.c("openSDK_LOG", "-->login activity: " + activity);
        return m12771a(activity, null, str, bVar, str2);
    }

    private int m12771a(Activity activity, Fragment fragment, String str, b bVar, String str2) {
        String str3;
        String packageName = activity.getApplicationContext().getPackageName();
        for (ApplicationInfo applicationInfo : activity.getPackageManager().getInstalledApplications(128)) {
            if (packageName.equals(applicationInfo.packageName)) {
                str3 = applicationInfo.sourceDir;
                break;
            }
        }
        str3 = null;
        if (str3 != null) {
            try {
                String a = com.tencent.open.d.a.a(new File(str3));
                if (!TextUtils.isEmpty(a)) {
                    n.b("openSDK_LOG", "-->login channelId: " + a);
                    return m12775a(activity, str, bVar, a, a, "");
                }
            } catch (IOException e) {
                n.b("openSDK_LOG", "-->login get channel id exception." + e.getMessage());
                e.printStackTrace();
            }
        }
        n.b("openSDK_LOG", "-->login channelId is null ");
        com.tencent.connect.common.a.k = false;
        return this.f9084a.a(activity, str, bVar, false, fragment);
    }

    @Deprecated
    public int m12775a(Activity activity, String str, b bVar, String str2, String str3, String str4) {
        n.c("openSDK_LOG", "loginWithOEM");
        com.tencent.connect.common.a.k = true;
        if (str2.equals("")) {
            str2 = "null";
        }
        if (str3.equals("")) {
            str3 = "null";
        }
        if (str4.equals("")) {
            str4 = "null";
        }
        com.tencent.connect.common.a.i = str3;
        com.tencent.connect.common.a.h = str2;
        com.tencent.connect.common.a.j = str4;
        return this.f9084a.a(activity, str, bVar);
    }

    public w m12776a() {
        return this.f9085b;
    }
}
