package com.huawei.hwcloudmodel.p061c;

import android.content.Context;
import com.huawei.hihealth.p036a.C0823a;
import com.huawei.hihealth.p036a.C0824b;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.application.C0975b;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.nio.charset.Charset;

/* compiled from: Utils */
public class C0970w {
    private static final Charset f1625a = Charset.forName(GameManager.DEFAULT_CHARSET);
    private static int f1626b = 3;

    public static void m3487a(int i) {
        f1626b = i;
    }

    public static int m3484a() {
        return f1626b;
    }

    public static String m3486a(byte[] bArr) {
        return bArr == null ? null : new String(bArr, f1625a);
    }

    public static String m3485a(Context context) {
        File file = new File(context.getFilesDir() + File.separator + "photos" + File.separator + "avater");
        if (!(file.exists() || file.mkdirs())) {
            C2538c.m12674b("Utils", "getHeadPhotosPath Creat mkdirs failure");
        }
        return file.getAbsolutePath();
    }

    public static boolean m3489b() {
        if (BaseApplication.m2633c() == C0975b.HEALTH) {
            C2538c.m12677c("Utils", "Health APP isNoCloudVersion = false");
            return false;
        }
        boolean z;
        if (2 == C0969i.m3481a()) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12677c("Utils", "isNoCloudVersion = ", Boolean.valueOf(z));
        return z;
    }

    public static int m3490c() {
        return C1093a.m4739a(BaseApplication.m2632b()).m4752e();
    }

    public static boolean m3491d() {
        if (-1 == C0970w.m3490c()) {
            return false;
        }
        return true;
    }

    public static boolean m3488a(String str) {
        C0823a a = C0824b.m2914a(BaseApplication.m2632b());
        C2538c.m12677c("Utils", "isHiHealthLogin checkHiHealthLogin = " + a.m2913b(str) + ",isNoCloudVersion = " + C0970w.m3489b() + ",checkHiHealthServiceExist = " + a.m2910a() + ",isLogin = " + C0970w.m3491d());
        if (a.m2913b(str) || (a.m2910a() && C0970w.m3489b() && !r3)) {
            return true;
        }
        return false;
    }
}
