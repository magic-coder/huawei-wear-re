package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {

    final class C06041 extends UnsafeAllocator {
        final /* synthetic */ Method val$allocateInstance;
        final /* synthetic */ Object val$unsafe;

        C06041(Method method, Object obj) {
            this.val$allocateInstance = method;
            this.val$unsafe = obj;
        }

        public <T> T newInstance(Class<T> cls) throws Exception {
            return this.val$allocateInstance.invoke(this.val$unsafe, new Object[]{cls});
        }
    }

    final class C06052 extends UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ Method val$newInstance;

        C06052(Method method, int i) {
            this.val$newInstance = method;
            this.val$constructorId = i;
        }

        public <T> T newInstance(Class<T> cls) throws Exception {
            return this.val$newInstance.invoke(null, new Object[]{cls, Integer.valueOf(this.val$constructorId)});
        }
    }

    final class C06063 extends UnsafeAllocator {
        final /* synthetic */ Method val$newInstance;

        C06063(Method method) {
            this.val$newInstance = method;
        }

        public <T> T newInstance(Class<T> cls) throws Exception {
            return this.val$newInstance.invoke(null, new Object[]{cls, Object.class});
        }
    }

    final class C06074 extends UnsafeAllocator {
        C06074() {
        }

        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;

    public static UnsafeAllocator create() {
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new C06041(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get(null));
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new C06052(declaredMethod2, intValue);
            } catch (Exception e2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    return new C06063(declaredMethod3);
                } catch (Exception e3) {
                    return new C06074();
                }
            }
        }
    }
}
