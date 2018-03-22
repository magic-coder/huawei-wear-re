package com.huawei.android.pushselfshow.richpush.p339a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.C4203a;

public class C4158b {
    private static C4158b f15631a;

    private C4158b() {
    }

    private C4157a m20303a(Context context) {
        if (C4203a.m20437d(context)) {
            e.a("PushSelfShowLog", "operate apk self database");
            return new C4160e();
        } else if (!C4203a.m20438e(context)) {
            e.a("PushSelfShowLog", "operate sdk self database");
            return new C4160e();
        } else if (C4203a.m20439f(context)) {
            e.a("PushSelfShowLog", "operate apk provider database");
            return new C4159c();
        } else {
            e.a("PushSelfShowLog", "operate sdcard database");
            return new C4161d(context);
        }
    }

    public static synchronized C4158b m20304a() {
        C4158b c4158b;
        synchronized (C4158b.class) {
            if (f15631a == null) {
                f15631a = new C4158b();
            }
            c4158b = f15631a;
        }
        return c4158b;
    }

    public Cursor m20305a(Context context, Uri uri, String str, String[] strArr) throws Exception {
        return m20303a(context).mo4385a(context, uri, str, strArr);
    }
}
