package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.hwversionmgr.a.b;
import com.huawei.hwversionmgr.p079a.C5375d;
import com.huawei.hwversionmgr.utils.C5378a;
import com.huawei.hwversionmgr.utils.e;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: CheckNewVersionThreadUtil */
public class C5387j {
    public static String m25911a() {
        return Build.FINGERPRINT;
    }

    public static String m25915b() {
        return Build.MODEL;
    }

    public static String m25916c() {
        return "ro.build.display.id";
    }

    public static String m25912a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        return (language + '-' + configuration.locale.getCountry()).toLowerCase();
    }

    public static String m25917d() {
        return "Android " + VERSION.RELEASE;
    }

    public static String m25918e() {
        return "ro.product.CustCVersion";
    }

    public static String m25919f() {
        return "ro.product.CustDVersion";
    }

    public static String m25914a(String str, Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            C2538c.c("checkNewVersionThreadUtil", new Object[]{str + "does not found"});
            packageInfo = null;
        }
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionName);
        }
        return null;
    }

    public static String m25913a(String str) {
        C2538c.c("checkNewVersionThreadUtil", new Object[]{"getResponse url =" + com.huawei.hwversionmgr.utils.c.a()});
        return C5378a.m25856a(com.huawei.hwversionmgr.utils.c.a(), str);
    }

    public static C5375d m25909a(Context context, String str) {
        C5375d c5375d = new C5375d();
        c5375d.f19122a = C5387j.m25911a();
        c5375d.f19123b = C5387j.m25915b();
        c5375d.f19124c = C5387j.m25916c();
        c5375d.f19125d = "";
        c5375d.f19126e = com.huawei.hwversionmgr.utils.c.d(context);
        c5375d.f19127f = C5387j.m25912a(context);
        c5375d.f19128g = C5387j.m25917d();
        c5375d.f19129h = C5387j.m25918e();
        c5375d.f19130i = C5387j.m25919f();
        c5375d = C5387j.m25910a(context, str, c5375d);
        if (com.huawei.hwversionmgr.utils.c.a(context)) {
            c5375d.f19135n = "1.1.3";
        }
        return c5375d;
    }

    private static C5375d m25910a(Context context, String str, C5375d c5375d) {
        C2538c.c("checkNewVersionThreadUtil", new Object[]{"getComponent packageName=" + str + ",versionFilter =" + c5375d});
        try {
            if (WeChat.HEALTH_PACKAGE_NAME.equals(str)) {
                c5375d.f19131j = str;
                c5375d.f19132k = "20100000";
                c5375d.f19133l = "2.0.2.100";
            } else {
                String b = e.b(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toCharsString());
                c5375d.f19131j = str;
                c5375d.f19132k = com.huawei.hwversionmgr.utils.c.a(str, context);
                c5375d.f19133l = C5387j.m25914a(str, context);
                c5375d.f19134m = b;
            }
        } catch (NameNotFoundException e) {
            C2538c.c("checkNewVersionThreadUtil", new Object[]{"packageName=" + str + ",exception = NameNotFoundException"});
        } catch (Exception e2) {
            C2538c.c("checkNewVersionThreadUtil", new Object[]{"packageName=" + str + ",exception = " + e2.getMessage()});
        }
        return c5375d;
    }

    public static b m25908a(com.huawei.hwversionmgr.a.e eVar) {
        b bVar = new b();
        bVar.a = eVar.a;
        bVar.k = eVar.p;
        bVar.j = eVar.m;
        bVar.e = eVar.f;
        bVar.c = eVar.d;
        bVar.l = eVar.n;
        bVar.q = eVar.i;
        bVar.n = eVar.r;
        bVar.d = eVar.e;
        bVar.b = eVar.b;
        bVar.m = eVar.c;
        bVar.v = eVar.o;
        bVar.w = eVar.v;
        bVar.x = eVar.w;
        bVar.z = eVar.y;
        bVar.y = eVar.x;
        return bVar;
    }

    public static int m25907a(Context context, String str, OutputStream outputStream) throws IOException, RuntimeException {
        HttpClient defaultHttpClient = new DefaultHttpClient();
        Object httpGet = new HttpGet(str);
        com.huawei.hwversionmgr.utils.c.a(httpGet, defaultHttpClient, context);
        HttpParams params = httpGet.getParams();
        params.setIntParameter("http.socket.timeout", 20000);
        params.setIntParameter("http.connection.timeout", 20000);
        HttpProtocolParams.setUserAgent(params, com.huawei.hwversionmgr.utils.c.c());
        HttpResponse execute = defaultHttpClient.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (outputStream != null) {
            execute.getEntity().writeTo(outputStream);
        }
        httpGet.abort();
        return statusCode;
    }
}
