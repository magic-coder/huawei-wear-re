package android.support.multidex;

import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;
import org.apache.http.cookie.ClientCookie;

/* compiled from: MultiDex */
final class C0018c {
    private static void m72b(ClassLoader classLoader, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
        int size = list.size();
        Field access$300 = MultiDex.findField(classLoader, ClientCookie.PATH_ATTR);
        StringBuilder stringBuilder = new StringBuilder((String) access$300.get(classLoader));
        String[] strArr = new String[size];
        File[] fileArr = new File[size];
        ZipFile[] zipFileArr = new ZipFile[size];
        DexFile[] dexFileArr = new DexFile[size];
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            File file = (File) listIterator.next();
            String absolutePath = file.getAbsolutePath();
            stringBuilder.append(':').append(absolutePath);
            int previousIndex = listIterator.previousIndex();
            strArr[previousIndex] = absolutePath;
            fileArr[previousIndex] = file;
            zipFileArr[previousIndex] = new ZipFile(file);
            dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
        }
        access$300.set(classLoader, stringBuilder.toString());
        MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
        MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
        MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
        MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
    }
}
