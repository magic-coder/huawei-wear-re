package com.huawei.feedback;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.feedback.d.a;
import com.huawei.feedback.p033a.p035b.C0808a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ReflectUtils */
public class C0820d {
    public static final int m2873a(Context context, a aVar, String str) {
        try {
            String l = C0808a.m2700a().m2731l(context);
            if (TextUtils.isEmpty(l)) {
                l = context.getPackageName();
            }
            Field field = Class.forName(l + ".R$" + aVar.toString()).getField(str);
            return Integer.parseInt(field.get(field.getName()).toString());
        } catch (ClassNotFoundException e) {
            C1373c.m6141d("ReflectUtils", "reflect ClassNotFoundException! resourceType=" + aVar + "--resourceName=" + str);
            return 0;
        } catch (Exception e2) {
            C1373c.m6141d("ReflectUtils", "reflect Exception! resourceType=" + aVar + "--resourceName=" + str);
            return 0;
        }
    }

    public static final int m2874a(Context context, String str) {
        return C0820d.m2873a(context, a.a, str);
    }

    public static final int m2875b(Context context, String str) {
        return C0820d.m2873a(context, a.c, str);
    }

    public static final int m2876c(Context context, String str) {
        return C0820d.m2873a(context, a.b, str);
    }

    public static final int m2877d(Context context, String str) {
        return C0820d.m2873a(context, a.f, str);
    }

    public static final int m2878e(Context context, String str) {
        return C0820d.m2873a(context, a.d, str);
    }

    public static final int m2879f(Context context, String str) {
        return C0820d.m2873a(context, a.g, str);
    }

    public static final int m2880g(Context context, String str) {
        return C0820d.m2873a(context, a.h, str);
    }

    public static final int m2881h(Context context, String str) {
        return C0820d.m2873a(context, a.i, str);
    }

    public static void m2882i(Context context, String str) {
        try {
            Class cls = Class.forName("com.huawei.phoneservice.logic.hianalytics.PhoneServiceHiAnalytics");
            cls.getMethod(str, new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (ClassNotFoundException e) {
            C1373c.m6141d("ReflectUtils", "report ClassNotFoundException");
        } catch (NoSuchMethodException e2) {
            C1373c.m6141d("ReflectUtils", "report NoSuchMethodException");
        } catch (IllegalArgumentException e3) {
            C1373c.m6141d("ReflectUtils", "report IllegalArgumentException");
        } catch (IllegalAccessException e4) {
            C1373c.m6141d("ReflectUtils", "report IllegalAccessException");
        } catch (InvocationTargetException e5) {
            C1373c.m6141d("ReflectUtils", "report InvocationTargetException");
        }
    }
}
