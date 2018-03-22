package com.cmcc.sso.p011a;

import android.content.Context;
import com.cmcc.sso.sdk.p013b.C0327a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C0321a {
    public static String m166a(Context context, String str, File file) {
        Closeable fileOutputStream;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                Closeable open = context.getAssets().open(str);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    closeable = open;
                    try {
                        C0327a.m206d("copy " + str + " failed");
                        e.printStackTrace();
                        C0324d.m184a(closeable);
                        C0324d.m184a(fileOutputStream);
                        return file2.getPath();
                    } catch (Throwable th2) {
                        th = th2;
                        C0324d.m184a(closeable);
                        C0324d.m184a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    closeable = open;
                    C0324d.m184a(closeable);
                    C0324d.m184a(fileOutputStream);
                    throw th;
                }
                try {
                    C0321a.m167a(open, fileOutputStream);
                    C0324d.m184a(open);
                    C0324d.m184a(fileOutputStream);
                } catch (Exception e3) {
                    e = e3;
                    closeable = open;
                    C0327a.m206d("copy " + str + " failed");
                    e.printStackTrace();
                    C0324d.m184a(closeable);
                    C0324d.m184a(fileOutputStream);
                    return file2.getPath();
                } catch (Throwable th4) {
                    th = th4;
                    closeable = open;
                    C0324d.m184a(closeable);
                    C0324d.m184a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                C0327a.m206d("copy " + str + " failed");
                e.printStackTrace();
                C0324d.m184a(closeable);
                C0324d.m184a(fileOutputStream);
                return file2.getPath();
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                C0324d.m184a(closeable);
                C0324d.m184a(fileOutputStream);
                throw th;
            }
        }
        return file2.getPath();
    }

    private static void m167a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
