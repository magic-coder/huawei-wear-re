package com.snowballtech.common.util;

import com.snowballtech.common.log.LogUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtil {
    public static <P> Map<String, Object> fetchProperties(Class<?> cls, P p) {
        Exception exception;
        Exception exception2;
        Object obj;
        Map<String, Object> hashMap = new HashMap();
        Object obj2 = null;
        Object obj3 = (cls == null || cls.getName().endsWith("Object") || p == null) ? null : 1;
        if (obj3 != null) {
            try {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    int length = declaredFields.length;
                    int i = 0;
                    while (i < length) {
                        try {
                            Field field = declaredFields[i];
                            if (field != null) {
                                field.setAccessible(true);
                                obj2 = field.get(p);
                                field.setAccessible(false);
                                hashMap.put(field.getName(), obj2);
                            }
                            i++;
                        } catch (Exception e) {
                            exception = e;
                            obj3 = obj2;
                            exception2 = exception;
                        }
                    }
                }
                obj3 = obj2;
            } catch (Exception e2) {
                exception = e2;
                obj3 = null;
                exception2 = exception;
                exception2.printStackTrace();
                if (cls != null) {
                }
                obj2 = null;
                obj = obj3;
                Map fetchProperties = fetchProperties(cls.getSuperclass(), p);
                hashMap.putAll(fetchProperties);
                return hashMap;
            }
            if (cls != null || cls.getName().endsWith("Object") || p == null) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            obj = obj3;
        } else {
            obj = null;
            obj2 = obj3;
        }
        if (obj == null && r0 != null) {
            Map fetchProperties2 = fetchProperties(cls.getSuperclass(), p);
            if (fetchProperties2 != null && fetchProperties2.size() > 0) {
                hashMap.putAll(fetchProperties2);
            }
        }
        return hashMap;
    }

    public static <P> Map<String, Object> fetchPropertiesFromFinalClass(Class<?> cls) {
        int i = 0;
        Map<String, Object> hashMap = new HashMap();
        int i2 = (cls == null || cls.getName().endsWith("Object")) ? 0 : 1;
        if (i2 != 0) {
            try {
                Field[] fields = cls.getFields();
                if (fields != null && fields.length > 0) {
                    int length = fields.length;
                    while (i < length) {
                        Field field = fields[i];
                        if (field != null && field.getType().getName().endsWith("String")) {
                            Object obj = field.get(cls);
                            hashMap.put(field.getName(), obj);
                            LogUtil.log("fetchPropertiesFromFinalClass field = " + field.getName() + " val =" + obj);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static <T> void updateAllValueOfBean(T t, T t2, String... strArr) {
        if (t != null && t2 != null) {
            Field[] declaredFields = t.getClass().getDeclaredFields();
            Field[] declaredFields2 = t2.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                Field field2 = declaredFields2[i];
                field.setAccessible(true);
                field2.setAccessible(true);
                if (strArr != null) {
                    try {
                        if (strArr.length > 0) {
                            for (String equalsIgnoreCase : strArr) {
                                if (equalsIgnoreCase.equalsIgnoreCase(field.getName())) {
                                    break;
                                }
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    }
                }
                if (field.getType().getName().endsWith("List") || field.getType().getName().endsWith("Map") || !field.getType().isInterface()) {
                    field.set(t, field2.get(t2));
                }
                field.setAccessible(false);
                field2.setAccessible(false);
            }
        }
    }
}
