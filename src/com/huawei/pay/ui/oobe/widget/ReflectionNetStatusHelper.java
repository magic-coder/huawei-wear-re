package com.huawei.pay.ui.oobe.widget;

import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pay.e.c.a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionNetStatusHelper {
    private static final String TAG = "ReflectionUtils";

    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            a.b(TAG, "className not found:" + str, false);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        if (!(cls == null || str == null)) {
            try {
                method = cls.getMethod(str, clsArr);
            } catch (SecurityException e) {
                a.b(TAG, HwAccountConstants.BLANK + e.getCause(), false);
            } catch (NoSuchMethodException e2) {
                a.b(TAG, str + ", not such method.", false);
            }
        }
        return method;
    }

    public static Object invoke(Object obj, Method method, Object... objArr) throws UnsupportedOperationException {
        if (method == null) {
            throw new UnsupportedOperationException("the invoke method is null");
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e) {
            a.b(TAG, "Exception in invoke: " + e.getClass().getSimpleName(), false);
            if ("com.huawei.android.util.NoExtAPIException".equals(e.getClass().getName())) {
                throw new UnsupportedOperationException("com.huawei.android.util.NoExtAPIException");
            }
            throw new UnsupportedOperationException("com.huawei.android.util.NoExtAPIException");
        } catch (IllegalAccessException e2) {
            a.b(TAG, "Exception in invoke: " + e2.getCause() + "; method=" + method.getName(), false);
            throw new UnsupportedOperationException("com.huawei.android.util.NoExtAPIException");
        } catch (InvocationTargetException e3) {
            a.b(TAG, "Exception in invoke: " + e3.getCause() + "; method=" + method.getName(), false);
            throw new UnsupportedOperationException("com.huawei.android.util.NoExtAPIException");
        }
    }

    public static int getFieldInt(Class<?> cls, String str) {
        int i = -1;
        if (!(cls == null || str == null)) {
            AccessibleObject[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            try {
                for (Field field : declaredFields) {
                    if (str.equals(field.getName())) {
                        i = field.getInt(cls);
                    }
                }
            } catch (IllegalAccessException e) {
                a.c("IllegalAccessException", false);
            } catch (IllegalArgumentException e2) {
                a.c("IllegalArgumentException", false);
            } catch (SecurityException e3) {
                a.c("no security int method getFieldInt", false);
            }
        }
        return i;
    }

    public static String getFieldString(Class<?> cls, String str) {
        String str2 = null;
        if (!(cls == null || str == null)) {
            AccessibleObject[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            try {
                int length = declaredFields.length;
                int i = 0;
                while (i < length) {
                    String str3;
                    Field field = declaredFields[i];
                    if (str.equals(field.getName())) {
                        str3 = (String) field.get(cls);
                    } else {
                        str3 = str2;
                    }
                    i++;
                    str2 = str3;
                }
            } catch (IllegalAccessException e) {
                a.c("IllegalAccessException", false);
            } catch (IllegalArgumentException e2) {
                a.c("IllegalArgumentException", false);
            } catch (SecurityException e3) {
                a.c("no security int method getFieldString", false);
            }
        }
        return str2;
    }
}
