package com.huawei.phoneserviceuni.common.p132d;

import com.huawei.phoneserviceuni.common.d.c;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* compiled from: RefectUtils */
public class C5768d {
    public static Object m26482a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Object invoke;
        Class cls = null;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            c.d("RefectUtilss", "invokeStaticFun 参数有误");
        } else {
            Class cls2;
            try {
                cls2 = Class.forName(str);
            } catch (Exception e) {
                C5768d.m26483a(e, "RefectUtilss");
                cls2 = cls;
            }
            if (cls2 != null) {
                Method declaredMethod;
                try {
                    declaredMethod = cls2.getDeclaredMethod(str2, clsArr);
                } catch (Exception e2) {
                    C5768d.m26483a(e2, "RefectUtilss");
                    Object obj = cls;
                }
                if (declaredMethod != null) {
                    try {
                        invoke = declaredMethod.invoke(cls2, objArr);
                    } catch (Exception e22) {
                        C5768d.m26483a(e22, "RefectUtilss");
                    } catch (Exception e222) {
                        C5768d.m26483a(e222, "RefectUtilss");
                    } catch (Exception e2222) {
                        C5768d.m26483a(e2222, "RefectUtilss");
                    }
                }
            }
        }
        return invoke;
    }

    public static Object m26481a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method method;
        Object invoke;
        Method method2 = null;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (Exception e) {
            C5768d.m26483a(e, "RefectUtilss");
            method = method2;
        }
        if (method != null) {
            try {
                invoke = method.invoke(obj, objArr);
            } catch (Exception e2) {
                C5768d.m26483a(e2, "RefectUtilss");
            } catch (Exception e22) {
                C5768d.m26483a(e22, "RefectUtilss");
            } catch (Exception e222) {
                C5768d.m26483a(e222, "RefectUtilss");
            }
        }
        return invoke;
    }

    public static boolean m26485a(String str, String str2, boolean z) {
        Class cls = null;
        try {
            cls = Class.forName(str);
        } catch (Exception e) {
            C5768d.m26483a(e, "RefectUtilss");
        }
        if (cls != null) {
            try {
                AccessibleObject declaredField = cls.getDeclaredField(str2);
                C5768d.m26484a(declaredField, true);
                z = declaredField.getBoolean(null);
            } catch (Exception e2) {
                C5768d.m26483a(e2, "RefectUtilss");
            } catch (Exception e22) {
                C5768d.m26483a(e22, "RefectUtilss");
            } catch (Exception e222) {
                C5768d.m26483a(e222, "RefectUtilss");
            }
        }
        return z;
    }

    public static int m26480a(String str, String str2, int i) {
        try {
            Class cls = Class.forName(str);
            AccessibleObject declaredField = cls.getDeclaredField(str2);
            C5768d.m26484a(declaredField, true);
            i = declaredField.getInt(cls);
        } catch (Exception e) {
            C5768d.m26483a(e, "RefectUtilss");
        } catch (Exception e2) {
            C5768d.m26483a(e2, "RefectUtilss");
        } catch (Exception e22) {
            C5768d.m26483a(e22, "RefectUtilss");
        } catch (Exception e222) {
            C5768d.m26483a(e222, "RefectUtilss");
        } catch (Exception e2222) {
            C5768d.m26483a(e2222, "RefectUtilss");
        }
        return i;
    }

    public static void m26484a(AccessibleObject accessibleObject, boolean z) {
        if (accessibleObject != null) {
            accessibleObject.setAccessible(z);
        }
    }

    private static void m26483a(Exception exception, String str) {
        if (exception != null && exception.getMessage() != null) {
            c.d(str, exception.getMessage());
        }
    }
}
