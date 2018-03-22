package android.support.multidex;

import java.io.File;
import java.io.FileFilter;

/* compiled from: MultiDexExtractor */
final class C0020e implements FileFilter {
    final /* synthetic */ String f102a;

    C0020e(String str) {
        this.f102a = str;
    }

    public boolean accept(File file) {
        return !file.getName().startsWith(this.f102a);
    }
}
