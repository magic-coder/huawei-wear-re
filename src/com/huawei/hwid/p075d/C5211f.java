package com.huawei.hwid.p075d;

import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: Util */
public class C5211f {
    public static boolean m25346a() {
        Object a;
        String str = "";
        try {
            a = C5211f.m25345a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.region"});
            if (a != null) {
                a = (String) a;
                if (!TextUtils.isEmpty(a)) {
                    return HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(a);
                }
                a = C5211f.m25347b();
                if (TextUtils.isEmpty(a)) {
                    return a.contains(PayManagerSettingSwitchDialog.COUNTRY_CODE_CN);
                }
                return C5211f.m25348c();
            }
        } catch (Exception e) {
            C5165e.m24910d("Util", "can not get region: " + e.getMessage());
        }
        String str2 = str;
        if (!TextUtils.isEmpty(a)) {
            return HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(a);
        }
        a = C5211f.m25347b();
        if (TextUtils.isEmpty(a)) {
            return C5211f.m25348c();
        }
        return a.contains(PayManagerSettingSwitchDialog.COUNTRY_CODE_CN);
    }

    public static String m25347b() {
        String str = "";
        try {
            Object a = C5211f.m25345a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale"});
            if (a != null) {
                return (String) a;
            }
        } catch (Exception e) {
            C5165e.m24910d("Util", "can not get locale: " + e.getMessage());
        }
        return str;
    }

    public static boolean m25348c() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return false;
        }
        Object country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equalsIgnoreCase(locale.getLanguage());
        }
        return HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(country);
    }

    public static Object m25345a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Object invoke;
        Class cls = null;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C5165e.m24904a("Util", "invokeFun params invalid");
        } else {
            Object a = C5211f.m25344a(str);
            if (a != null) {
                Class cls2;
                Method method;
                try {
                    cls2 = Class.forName(str);
                } catch (ClassNotFoundException e) {
                    C5165e.m24910d("Util", "can not find class:" + str);
                    cls2 = cls;
                }
                if (cls2 != null) {
                    try {
                        method = cls2.getMethod(str2, clsArr);
                    } catch (NoSuchMethodException e2) {
                        C5165e.m24910d("Util", "can not find method:" + str2);
                    }
                    if (method != null) {
                        try {
                            invoke = method.invoke(a, objArr);
                        } catch (IllegalAccessException e3) {
                            C5165e.m24910d("Util", "method can not invoke:" + e3.getMessage());
                        } catch (IllegalArgumentException e4) {
                            C5165e.m24910d("Util", "method can not invoke:" + e4.getMessage());
                        } catch (InvocationTargetException e5) {
                            C5165e.m24910d("Util", "method can not invoke:" + e5.getMessage());
                        }
                    }
                }
                Object obj = cls;
                if (method != null) {
                    invoke = method.invoke(a, objArr);
                }
            }
        }
        return invoke;
    }

    public static Object m25344a(String str) {
        Class cls;
        Object newInstance;
        Class cls2 = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            C5165e.m24910d("Util", "can not find class:" + str);
            cls = cls2;
        }
        if (cls != null) {
            try {
                newInstance = cls.newInstance();
            } catch (InstantiationException e2) {
                C5165e.m24910d("Util", "class creat instance error :" + e2.getMessage());
            } catch (IllegalAccessException e3) {
                C5165e.m24910d("Util", "class creat instance error :" + e3.getMessage());
            }
        }
        return newInstance;
    }
}
