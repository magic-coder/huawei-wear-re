package com.cmcc.sso.sdk.p012a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.cmcc.sso.p011a.C0324d;
import com.cmcc.sso.sdk.p013b.C0330d;
import java.io.File;

public class C0325a {
    public static final C0326b f175a = C0326b.RELEASE;
    public static final String f176b = ("ANDIDMP-ANDROIDV2.8.1.0_SDK_" + f175a);

    public static String m194a() {
        return "2.8.1.0";
    }

    public static String m195a(Context context) {
        return C0325a.m196a(context.getFilesDir().getPath());
    }

    public static String m196a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        String c = C0325a.m199c();
        File file = new File(str + "cmcc_sso_download");
        if (!file.exists()) {
            file.mkdir();
        }
        return C0326b.RELEASE.toString().equalsIgnoreCase(c) ? str + "cmcc_sso_download" : str + "cmcc_sso_download/" + C0330d.m212a(c);
    }

    public static String m197b() {
        return C0324d.m192b() ? C0325a.m196a(Environment.getExternalStorageDirectory().getPath()) : null;
    }

    public static String m198b(Context context) {
        return C0324d.m192b() ? Environment.getExternalStorageDirectory().getPath() + "/cmcc_sso_config.dat" : context.getFilesDir().getPath() + "/cmcc_sso_config.dat";
    }

    private static String m199c() {
        return f175a.toString();
    }
}
