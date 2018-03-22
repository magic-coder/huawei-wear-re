package com.huawei.androidcommon.utils;

import android.os.SystemProperties;
import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyUtils {
    public static void writeProperties(String str, String str2, String str3) {
        Properties properties = new Properties();
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            InputStream fileInputStream = new FileInputStream(str);
            properties.load(fileInputStream);
            fileInputStream.close();
            OutputStream fileOutputStream = new FileOutputStream(str);
            properties.setProperty(str2, str3);
            properties.store(fileOutputStream, str2);
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e(AC.TAG, "[PropertyUtils.writeProperties]Visit " + str + " for updating " + str2 + " value error");
        }
    }

    public static String readValue(String str, String str2) {
        Closeable bufferedInputStream;
        Throwable e;
        Throwable th;
        String str3 = null;
        Properties properties = new Properties();
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                properties.load(bufferedInputStream);
                str3 = properties.getProperty(str2);
                IOUtils.close(bufferedInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.e(AC.TAG, "[PropertyUtils.readValue]Error:", e);
                    IOUtils.close(bufferedInputStream);
                    return str3;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.close(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = str3;
            Log.e(AC.TAG, "[PropertyUtils.readValue]Error:", e);
            IOUtils.close(bufferedInputStream);
            return str3;
        } catch (Throwable e4) {
            bufferedInputStream = str3;
            th = e4;
            IOUtils.close(bufferedInputStream);
            throw th;
        }
        return str3;
    }

    public static synchronized String getPropertyFromFile(String str, String str2) {
        String string;
        synchronized (PropertyUtils.class) {
            string = ResourceBundle.getBundle(str).getString(str2);
            if (string == null) {
                string = "";
            } else {
                string = string.trim();
            }
        }
        return string;
    }

    public static String getSystemProperty(String str) {
        String str2 = SystemProperties.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }
}
