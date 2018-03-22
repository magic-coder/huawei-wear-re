package com.huawei.androidcommon.utils;

import android.database.Cursor;
import java.io.Closeable;

public class IOUtils {
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void close(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
            }
        }
    }
}
