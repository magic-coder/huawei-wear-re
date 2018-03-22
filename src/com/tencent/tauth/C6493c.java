package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.connect.b.v;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
public class C6493c {
    private static C6493c f22555b;
    private final v f22556a;

    private C6493c(String str, Context context) {
        C6395h.m29185a(context.getApplicationContext());
        this.f22556a = v.a(str, context);
    }

    public static synchronized C6493c m29622a(String str, Context context) {
        C6493c c6493c;
        synchronized (C6493c.class) {
            C6367n.m29104a("openSDK_LOG", "createInstance()  -- start");
            if (f22555b == null) {
                f22555b = new C6493c(str, context);
            } else if (!str.equals(f22555b.m29625a())) {
                f22555b.m29626a(context);
                f22555b = new C6493c(str, context);
            }
            if (C6493c.m29623a(context, str)) {
                C6367n.m29104a("openSDK_LOG", "createInstance()  -- end");
                c6493c = f22555b;
            } else {
                c6493c = null;
            }
        }
        return c6493c;
    }

    private static boolean m29623a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (NameNotFoundException e) {
                StringBuilder stringBuilder = new StringBuilder();
                C6367n.m29112e("AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity", stringBuilder.append("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.").append("\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"portrait\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>").toString());
                return false;
            }
        } catch (NameNotFoundException e2) {
            String str2 = "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity";
            C6367n.m29112e(str2, ("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.open.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.util.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n     <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n" + "</intent-filter>\n" + "</activity>");
            return false;
        }
    }

    public int m29624a(Activity activity, String str, C6252b c6252b) {
        return this.f22556a.a(activity, str, c6252b);
    }

    public void m29626a(Context context) {
        this.f22556a.a().m28847a(null, "0");
        this.f22556a.a().m28850b(null);
    }

    public String m29625a() {
        return this.f22556a.a().m28849b();
    }

    public C6284w m29627b() {
        return this.f22556a.a();
    }
}
