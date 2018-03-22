package android.support.multidex;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiDex */
final class C0016a {
    private static void m67b(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
        MultiDex.expandFieldArray(obj, "dexElements", C0016a.m66a(obj, new ArrayList(list), file));
    }

    private static Object[] m66a(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
    }
}
