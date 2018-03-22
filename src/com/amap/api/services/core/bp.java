package com.amap.api.services.core;

import com.sina.weibo.sdk.component.GameManager;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Util */
public final class bp {
    public static final Charset f12461a = Charset.forName("US-ASCII");
    static final Charset f12462b = Charset.forName(GameManager.DEFAULT_CHARSET);

    private bp() {
    }

    static void m16846a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                m16846a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    static void m16845a(Closeable closeable) {
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
