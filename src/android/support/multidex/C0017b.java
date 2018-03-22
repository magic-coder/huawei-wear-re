package android.support.multidex;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MultiDex */
final class C0017b {
    private static void m70b(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        MultiDex.expandFieldArray(obj, "dexElements", C0017b.m69a(obj, new ArrayList(list), file, arrayList));
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
            }
            Field access$300 = MultiDex.findField(classLoader, "dexElementsSuppressedExceptions");
            IOException[] iOExceptionArr = (IOException[]) access$300.get(classLoader);
            if (iOExceptionArr == null) {
                obj = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
            } else {
                Object obj2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                arrayList.toArray(obj2);
                System.arraycopy(iOExceptionArr, 0, obj2, arrayList.size(), iOExceptionArr.length);
                obj = obj2;
            }
            access$300.set(classLoader, obj);
        }
    }

    private static Object[] m69a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
    }
}
