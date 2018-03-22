package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class C1362f {
    public static Class m6069a(Field field) {
        return Map.class.isAssignableFrom(field.getType()) ? C1362f.m6070a(field, 1) : List.class.isAssignableFrom(field.getType()) ? C1362f.m6070a(field, 0) : null;
    }

    private static Class m6070a(Field field, int i) {
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > i) {
                try {
                    if (actualTypeArguments[i] instanceof Class) {
                        return (Class) actualTypeArguments[i];
                    }
                    String obj = actualTypeArguments[i].toString();
                    int indexOf = obj.indexOf("class ");
                    int i2 = indexOf < 0 ? 0 : indexOf;
                    indexOf = obj.indexOf("<");
                    if (indexOf < 0) {
                        indexOf = obj.length();
                    }
                    return Class.forName(obj.substring(i2, indexOf));
                } catch (Throwable e) {
                    C1336d.m5883a("ReflectAPI", "Exception", e);
                }
            }
        }
        return null;
    }

    public static Field[] m6071a(Class cls) {
        Object obj = null;
        if (cls.getSuperclass() != null) {
            obj = C1362f.m6071a(cls.getSuperclass());
        }
        Object declaredFields = cls.getDeclaredFields();
        if (obj == null || obj.length <= 0) {
            return declaredFields;
        }
        Object obj2 = new Field[(declaredFields.length + obj.length)];
        System.arraycopy(obj, 0, obj2, 0, obj.length);
        System.arraycopy(declaredFields, 0, obj2, obj.length, declaredFields.length);
        return obj2;
    }
}
