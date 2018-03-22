package com.amap.api.mapcore.util;

import com.sina.weibo.sdk.component.GameManager;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Util */
public final class dj {
    public static final Charset f11719a = Charset.forName("US-ASCII");
    static final Charset f11720b = Charset.forName(GameManager.DEFAULT_CHARSET);

    private dj() {
    }

    static void m16058a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                m16058a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    static void m16057a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }
}
