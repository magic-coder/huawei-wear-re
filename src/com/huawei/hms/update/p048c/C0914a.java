package com.huawei.hms.update.p048c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.p039c.C0857e;
import com.huawei.hms.update.p050e.C0944o;
import com.huawei.hms.update.p050e.C0946q;

/* compiled from: UpdateManager */
public class C0914a {
    private static int f1507a;
    private static Class<?> f1508b = null;

    public static void m3196a(Activity activity, int i) {
        if (f1508b == null) {
            C0914a.m3195a(activity);
            if (C0914a.m3198a((Context) activity)) {
                C0914a.m3200b(activity, i);
            } else {
                C0914a.m3201c(activity, i);
            }
        }
    }

    private static void m3200b(Activity activity, int i) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, C0944o.class.getName());
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_EX_NAME, C0946q.class.getName());
        C0914a.m3197a(C0944o.class);
        activity.startActivityForResult(intent, i);
    }

    private static void m3201c(Activity activity, int i) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, C0946q.class.getName());
        C0914a.m3197a(C0946q.class);
        activity.startActivityForResult(intent, i);
    }

    private static boolean m3198a(Context context) {
        if (((long) new C0857e(context).m3018b("com.huawei.appmarket")) >= 70203000) {
            return true;
        }
        return false;
    }

    public static int m3194a() {
        return f1507a;
    }

    public static void m3195a(Activity activity) {
        f1507a = new C0857e(activity).m3018b("com.huawei.hwid");
    }

    public static String m3199b() {
        return "core.connnect";
    }

    public static void m3197a(Class<?> cls) {
        f1508b = cls;
    }
}
