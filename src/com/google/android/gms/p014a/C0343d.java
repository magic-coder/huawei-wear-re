package com.google.android.gms.p014a;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class C0343d<T> extends C0341b {
    private final T f233a;

    private C0343d(T t) {
        this.f233a = t;
    }

    public static <T> C0340a m276a(T t) {
        return new C0343d(t);
    }

    public static <T> T m277a(C0340a c0340a) {
        int i = 0;
        if (c0340a instanceof C0343d) {
            return ((C0343d) c0340a).f233a;
        }
        IBinder asBinder = c0340a.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field2 = declaredFields[i2];
            if (field2.isSynthetic()) {
                field2 = field;
            } else {
                i++;
            }
            i2++;
            field = field2;
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        }
    }
}
