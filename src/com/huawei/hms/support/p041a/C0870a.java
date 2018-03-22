package com.huawei.hms.support.p041a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: GenericTypeReflector */
public final class C0870a {
    public static Class<?> m3057a(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            if (typeVariable.getBounds().length == 0) {
                return Object.class;
            }
            return C0870a.m3057a(typeVariable.getBounds()[0]);
        }
        throw new IllegalArgumentException("not supported: " + type.getClass());
    }
}
