package com.huawei.android.pushselfshow.utils;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;

final class C4208b implements Runnable {
    final /* synthetic */ Context f15825a;
    final /* synthetic */ String f15826b;
    final /* synthetic */ String f15827c;
    final /* synthetic */ String f15828d;

    C4208b(Context context, String str, String str2, String str3) {
        this.f15825a = context;
        this.f15826b = str;
        this.f15827c = str2;
        this.f15828d = str3;
    }

    public void run() {
        try {
            if (C4203a.m20443j(this.f15825a)) {
                String str = "PUSH_PS";
                String stringBuffer = new StringBuffer(String.valueOf(C4203a.m20414a())).append("|").append("PS").append("|").append(C4203a.m20428b(this.f15825a)).append("|").append(this.f15826b).append("|").append(this.f15827c).append("|").append(C4203a.m20415a(this.f15825a)).append("|").append(this.f15828d).toString();
                if (this.f15825a != null) {
                    e.b("PushSelfShowLog", "run normal sendHiAnalytics");
                    Class cls = Class.forName("com.c.a.c.a");
                    cls.getMethod("onEvent", new Class[]{Context.class, String.class, String.class}).invoke(cls, new Object[]{this.f15825a, str, stringBuffer});
                    cls.getMethod("onReport", new Class[]{Context.class}).invoke(cls, new Object[]{this.f15825a});
                    e.a("PushSelfShowLog", "send HiAnalytics msg, report cmd =" + this.f15828d + ", msgid = " + this.f15826b + ", eventId = " + this.f15827c);
                    return;
                }
                e.a("PushSelfShowLog", "send HiAnalytics msg, report cmd =" + this.f15828d + ",context = " + this.f15825a);
                return;
            }
            e.a("PushSelfShowLog", "not allowed to sendHiAnalytics!");
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "sendHiAnalytics IllegalAccessException ", e);
        } catch (Throwable e2) {
            e.d("PushSelfShowLog", "sendHiAnalytics IllegalArgumentException ", e2);
        } catch (Throwable e22) {
            e.d("PushSelfShowLog", "sendHiAnalytics InvocationTargetException", e22);
        } catch (Throwable e222) {
            e.d("PushSelfShowLog", "sendHiAnalytics NoSuchMethodException", e222);
        } catch (Throwable e2222) {
            e.d("PushSelfShowLog", "sendHiAnalytics ClassNotFoundException", e2222);
        }
    }
}
