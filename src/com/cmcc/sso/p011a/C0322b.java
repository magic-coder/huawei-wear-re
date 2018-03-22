package com.cmcc.sso.p011a;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class C0322b {
    private static PathClassLoader m168a() {
        return (PathClassLoader) C0322b.class.getClassLoader();
    }

    private static Object m169a(Object obj) {
        return C0324d.m179a(obj, obj.getClass(), "dexElements");
    }

    private static Object m170a(Object obj, Object obj2) {
        Class componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2) + length;
        Object newInstance = Array.newInstance(componentType, length2);
        for (int i = 0; i < length2; i++) {
            if (i < length) {
                Array.set(newInstance, i, Array.get(obj, i));
            } else {
                Array.set(newInstance, i, Array.get(obj2, i - length));
            }
        }
        return newInstance;
    }

    public static void m171a(String str, String str2) {
        DexClassLoader dexClassLoader = new DexClassLoader(str, str2, str, C0322b.m168a());
        Object a = C0322b.m170a(C0322b.m169a(C0322b.m172b(dexClassLoader)), C0322b.m169a(C0322b.m172b(C0322b.m168a())));
        Object b = C0322b.m172b(C0322b.m168a());
        Field declaredField = b.getClass().getDeclaredField("dexElements");
        declaredField.setAccessible(true);
        declaredField.set(b, a);
    }

    private static Object m172b(Object obj) {
        return C0324d.m179a(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }
}
