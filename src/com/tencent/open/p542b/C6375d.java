package com.tencent.open.p542b;

import android.os.SystemClock;
import com.tencent.open.p532d.C6412y;
import org.apache.http.client.methods.HttpGet;

/* compiled from: ProGuard */
public class C6375d {
    protected static C6375d f22177a;

    protected C6375d() {
    }

    public static synchronized C6375d m29144a() {
        C6375d c6375d;
        synchronized (C6375d.class) {
            if (f22177a == null) {
                f22177a = new C6375d();
            }
            c6375d = f22177a;
        }
        return c6375d;
    }

    public void m29146a(String str, String str2, String str3, String str4, String str5, String str6) {
        C6378g.m29155a().m29157a(C6412y.m29237a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void m29147a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        C6378g.m29155a().m29157a(C6412y.m29239a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void m29148a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C6378g.m29155a().m29157a(C6412y.m29239a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public void m29145a(int i, String str, String str2, String str3, String str4, Long l, int i2, int i3, String str5) {
        long j;
        long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
        if (l.longValue() == 0 || elapsedRealtime < 0) {
            j = 0;
        } else {
            j = elapsedRealtime;
        }
        StringBuffer stringBuffer = new StringBuffer("http://c.isdspeed.qq.com/code.cgi");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(i).append("&code=").append(i2).append("&time=").append(j).append("&rate=").append(i3).append("&uin=").append(str2).append("&data=");
        C6378g.m29155a().m29160a(stringBuffer.toString(), HttpGet.METHOD_NAME, C6412y.m29238a(String.valueOf(i), String.valueOf(i2), String.valueOf(j), String.valueOf(i3), str, str2, str3, str4, str5), true);
    }
}
