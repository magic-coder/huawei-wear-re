package com.huawei.wallet.utils;

import android.text.TextUtils;
import com.huawei.wallet.utils.log.LogC;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static Class<?> m28470a(String str) {
        Class<?> cls = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e) {
                LogC.m28532c("className not found:" + str, false);
            }
        }
        return cls;
    }

    public static Object m28472a(Object obj, Method method, Object... objArr) throws UnsupportedOperationException {
        Object obj2 = null;
        if (method != null) {
            try {
                obj2 = method.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                LogC.m28532c("Exception in invoke: " + e.getClass().getSimpleName(), false);
            } catch (IllegalArgumentException e2) {
                LogC.m28532c("Exception in invoke: " + e2.getClass().getSimpleName(), false);
            } catch (InvocationTargetException e3) {
                LogC.m28532c("Exception in invoke: " + e3.getClass().getSimpleName(), false);
            }
        }
        return obj2;
    }

    public static Method m28474a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        if (cls == null || str == null) {
            LogC.m28532c("targetClass is  null pr name is null:", false);
        } else {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (SecurityException e) {
                LogC.m28532c("SecurityException ：", false);
            } catch (NoSuchMethodException e2) {
                LogC.m28532c(str + ", not such method.", false);
            }
        }
        return method;
    }

    public static Object m28471a(Object obj, String str, Object... objArr) {
        Class[] clsArr;
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        } else {
            clsArr = null;
        }
        if (obj == null) {
            LogC.m28534d("receiveObj is null.", false);
            return null;
        }
        Method a = m28474a(obj.getClass(), str, clsArr);
        if (a != null) {
            return m28472a(obj, a, objArr);
        }
        return null;
    }

    public static Object m28473a(String str, String str2) {
        Object obj = null;
        Class a = m28470a(str);
        if (!(a == null || str2 == null)) {
            try {
                AccessibleObject.setAccessible(new Field[]{a.getDeclaredField(str2)}, true);
                obj = r2.get(a);
            } catch (IllegalAccessException e) {
                LogC.m28532c("Exception in getFieldObj :: IllegalAccessException", false);
            } catch (IllegalArgumentException e2) {
                LogC.m28532c("Exception in getFieldObj :: IllegalArgumentException", false);
            } catch (NoSuchFieldException e3) {
                LogC.m28532c("Exception in getFieldObj :: NoSuchFieldException", false);
            } catch (SecurityException e4) {
                LogC.m28530b("not security int method getStaticFieldObj", false);
            }
        }
        return obj;
    }
}
