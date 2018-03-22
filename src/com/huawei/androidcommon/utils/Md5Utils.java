package com.huawei.androidcommon.utils;

import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class Md5Utils {
    public static synchronized long getFileMD5(File file) {
        long j = -1;
        synchronized (Md5Utils.class) {
            if (file.isFile()) {
                String path = file.getPath();
                try {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(path.getBytes());
                    BigInteger bigInteger = new BigInteger(1, instance.digest());
                    Log.i(AC.TAG, "File Name=" + file.getName() + ",MD5=" + bigInteger.longValue());
                    j = bigInteger.longValue();
                } catch (Throwable e) {
                    Log.i(AC.TAG, "getFileMD5 Error:", e);
                }
            }
        }
        return j;
    }

    public static synchronized long getMD5(String str) {
        long fileMD5;
        synchronized (Md5Utils.class) {
            File file = new File(str);
            if (file.exists()) {
                fileMD5 = getFileMD5(file);
            } else {
                fileMD5 = -1;
            }
        }
        return fileMD5;
    }

    public static synchronized Map<Long, File> getDirMD5(File file) {
        Map<Long, File> map;
        synchronized (Md5Utils.class) {
            if (file != null) {
                if (file.isDirectory()) {
                    Map<Long, File> hashMap = new HashMap();
                    for (File file2 : file.listFiles()) {
                        Log.d(AC.TAG, "fileOrPathName = " + file2.getName());
                        if (file2.isDirectory()) {
                            hashMap.putAll(getDirMD5(file2));
                        } else {
                            Long valueOf = Long.valueOf(getFileMD5(file2));
                            Log.d(AC.TAG, "md5 = " + valueOf + "f = " + file2.getName());
                            if (valueOf.longValue() != -1) {
                                File file3 = (File) hashMap.put(valueOf, file2);
                                if (file3 != null) {
                                    Log.e(AC.TAG, "same file: oldValue = " + file3.getPath() + "newValue = " + file2.getPath());
                                }
                            }
                        }
                    }
                    map = hashMap;
                }
            }
            Log.w(AC.TAG, "input File is not a directory");
            map = null;
        }
        return map;
    }

    public static synchronized Map<Long, File> getDirsMD5(String[] strArr) {
        Map hashMap;
        synchronized (Md5Utils.class) {
            hashMap = new HashMap();
            for (String file : strArr) {
                File file2 = new File(file);
                if (!file2.exists() || !file2.isDirectory()) {
                    Log.e(AC.TAG, "input File is not a directory");
                    break;
                }
                hashMap.putAll(getDirMD5(file2));
            }
        }
        return hashMap;
    }

    public static String getMD5ShortForString(String str) {
        return getMD5ForString(str).substring(8, 24);
    }

    public static String getMD5ForString(String str) {
        int i = 0;
        byte[] bytes = StringUtils.convertEmptyStr(str).getBytes();
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Throwable e) {
            Log.e(AC.TAG, "[Md5Utils.getMD5ForString]Error:", e);
            return null;
        }
    }
}
