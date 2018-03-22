package com.huawei.android.pushagent.p018c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;

final class C4119d implements Runnable {
    final /* synthetic */ Context f15511a;
    final /* synthetic */ String f15512b;
    final /* synthetic */ String f15513c;

    C4119d(Context context, String str, String str2) {
        this.f15511a = context;
        this.f15512b = str;
        this.f15513c = str2;
    }

    public void run() {
        try {
            if (this.f15511a != null) {
                e.b("PushLogAC2712", "run normal sendHiAnalytics");
                if (C4118c.m20162e(this.f15511a)) {
                    Class cls = Class.forName("com.c.a.c.a");
                    cls.getMethod("onEvent", new Class[]{Context.class, String.class, String.class}).invoke(cls, new Object[]{this.f15511a, this.f15512b, this.f15513c});
                    cls.getMethod("onReport", new Class[]{Context.class}).invoke(cls, new Object[]{this.f15511a});
                    e.a("PushLogAC2712", "send HiAnalytics msg,PS =" + this.f15512b);
                    return;
                }
                e.b("PushLogAC2712", "not allowed to sendHiAnalytics!");
                return;
            }
            e.d("PushLogAC2712", "context is null when sendHiAnalytics");
        } catch (Throwable e) {
            e.d("PushLogAC2712", "sendHiAnalytics IllegalAccessException ", e);
        } catch (Throwable e2) {
            e.d("PushLogAC2712", "sendHiAnalytics IllegalArgumentException ", e2);
        } catch (Throwable e22) {
            e.d("PushLogAC2712", "sendHiAnalytics InvocationTargetException", e22);
        } catch (Throwable e222) {
            e.d("PushLogAC2712", "sendHiAnalytics NoSuchMethodException", e222);
        } catch (Throwable e2222) {
            e.d("PushLogAC2712", "sendHiAnalytics ClassNotFoundException", e2222);
        } catch (Throwable e22222) {
            e.d("PushLogAC2712", "sendHiAnalytics Exception", e22222);
        }
    }
}
