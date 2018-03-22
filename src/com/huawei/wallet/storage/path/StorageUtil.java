package com.huawei.wallet.storage.path;

import android.content.Context;
import android.os.Environment;
import com.huawei.wallet.utils.log.LogC;
import java.io.File;

public class StorageUtil {
    protected static String m28130e(Context context, String str) {
        if (context == null) {
            return "";
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return m28131f(context, str);
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath() + str;
        }
        LogC.m28534d("StorageUtil getFilesDirPath   exception", false);
        return "";
    }

    protected static String m28131f(Context context, String str) {
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath() + str;
        }
        LogC.m28534d("StorageUtil getDataFilesDirPath  exception", false);
        return "";
    }
}
