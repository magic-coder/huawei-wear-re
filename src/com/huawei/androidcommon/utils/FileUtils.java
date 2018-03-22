package com.huawei.androidcommon.utils;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

@TargetApi(19)
public class FileUtils {
    public static String getContentFromPath(String str) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        String str2 = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine).append("\n");
                }
                str2 = stringBuilder.toString();
                IOUtils.close(bufferedReader);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            try {
                Log.e(AC.TAG, "[FileUtils.getContentFromPath]Error:", e);
                IOUtils.close(bufferedReader);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.close(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            IOUtils.close(bufferedReader);
            throw th;
        }
        return str2;
    }

    public static String getContentFromAssets(Context context, String str) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        Closeable closeable = null;
        String str2 = "";
        try {
            Closeable inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(str));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine);
                    }
                    str2 = stringBuilder.toString();
                    IOUtils.close(inputStreamReader);
                    IOUtils.close(bufferedReader);
                } catch (Exception e2) {
                    e = e2;
                    closeable = inputStreamReader;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = inputStreamReader;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                closeable = inputStreamReader;
                try {
                    Log.e(AC.TAG, "[FileUtils.getContentFromAssets]Error:", e);
                    IOUtils.close(closeable);
                    IOUtils.close(bufferedReader);
                    return str2;
                } catch (Throwable th3) {
                    th = th3;
                    IOUtils.close(closeable);
                    IOUtils.close(bufferedReader);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                closeable = inputStreamReader;
                IOUtils.close(closeable);
                IOUtils.close(bufferedReader);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            Log.e(AC.TAG, "[FileUtils.getContentFromAssets]Error:", e);
            IOUtils.close(closeable);
            IOUtils.close(bufferedReader);
            return str2;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            IOUtils.close(closeable);
            IOUtils.close(bufferedReader);
            throw th;
        }
        return str2;
    }

    public static String getFileNameByPath(String str) {
        File file = new File(str.trim());
        if (file.exists()) {
            return file.getName();
        }
        return null;
    }

    public static String getSuffixByPath(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    public static boolean isFileExists(String str) {
        return new File(str).exists();
    }

    public static boolean isDirectoryEmpty(String str) {
        File file = new File(str);
        return file.exists() && file.isDirectory() && file.list().length == 0;
    }

    public static boolean createDir(String str) {
        Log.d(AC.TAG, "[FileUtils.createDir] start...");
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static File createFileByPath(String str) {
        return new File(str);
    }

    public static boolean createFile(String str) {
        File file = new File(str);
        if (file.exists() || str.endsWith("/")) {
            return false;
        }
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            return false;
        }
        try {
            if (file.createNewFile()) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Log.e(AC.TAG, "[FileUtils.createFile]Error:", e);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r17, java.lang.String r18) {
        /*
        r2 = "AndroidCommon";
        r3 = "[FileUtils.copyFile]step1";
        android.util.Log.d(r2, r3);
        r2 = isFileExists(r17);
        if (r2 != 0) goto L_0x0016;
    L_0x000d:
        r2 = "AndroidCommon";
        r3 = "[FileUtils.copyFile]step2";
        android.util.Log.d(r2, r3);
        r2 = 0;
    L_0x0015:
        return r2;
    L_0x0016:
        r2 = "AndroidCommon";
        r3 = "[FileUtils.copyFile]step3";
        android.util.Log.d(r2, r3);
        r10 = new java.io.File;
        r0 = r17;
        r10.<init>(r0);
        r2 = r10.isDirectory();
        if (r2 == 0) goto L_0x003c;
    L_0x002a:
        r2 = "AndroidCommon";
        r3 = "[FileUtils.copyFile]step4";
        android.util.Log.d(r2, r3);	 Catch:{ Exception -> 0x00d2 }
        createDir(r18);	 Catch:{ Exception -> 0x00d2 }
        r3 = r10.listFiles();	 Catch:{ Exception -> 0x00d2 }
        r4 = r3.length;	 Catch:{ Exception -> 0x00d2 }
        r2 = 0;
    L_0x003a:
        if (r2 < r4) goto L_0x00a3;
    L_0x003c:
        r2 = "AndroidCommon";
        r3 = "[FileUtils.copyFile]step6";
        android.util.Log.d(r2, r3);
        r2 = isFileExists(r18);
        if (r2 != 0) goto L_0x0129;
    L_0x0049:
        r6 = 0;
        r5 = 0;
        r3 = 0;
        r4 = 0;
        r2 = "AndroidCommon";
        r7 = "[FileUtils.copyFile]step7";
        android.util.Log.d(r2, r7);	 Catch:{ Exception -> 0x00f2, all -> 0x010e }
        createFile(r18);	 Catch:{ Exception -> 0x00f2, all -> 0x010e }
        r11 = new java.io.File;	 Catch:{ Exception -> 0x00f2, all -> 0x010e }
        r0 = r18;
        r11.<init>(r0);	 Catch:{ Exception -> 0x00f2, all -> 0x010e }
        r9 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00f2, all -> 0x010e }
        r9.<init>(r10);	 Catch:{ Exception -> 0x00f2, all -> 0x010e }
        r8 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0141, all -> 0x012c }
        r8.<init>(r11);	 Catch:{ Exception -> 0x0141, all -> 0x012c }
        r3 = r9.getChannel();	 Catch:{ Exception -> 0x0149, all -> 0x012e }
        r2 = r8.getChannel();	 Catch:{ Exception -> 0x0152, all -> 0x012e }
        r12 = r3.size();	 Catch:{ Exception -> 0x015b, all -> 0x0131 }
        r4 = 0;
    L_0x0076:
        r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r6 < 0) goto L_0x00dd;
    L_0x007a:
        r4 = "AndroidCommon";
        r5 = "[FileUtils.copyFile]step8";
        android.util.Log.d(r4, r5);	 Catch:{ Exception -> 0x015b, all -> 0x0131 }
        r4 = r10.length();	 Catch:{ Exception -> 0x015b, all -> 0x0131 }
        r6 = r11.length();	 Catch:{ Exception -> 0x015b, all -> 0x0131 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x011d;
    L_0x008d:
        r4 = "AndroidCommon";
        r5 = "[FileUtils.copyFile]copy file failed!";
        android.util.Log.d(r4, r5);	 Catch:{ Exception -> 0x015b, all -> 0x0131 }
        com.huawei.androidcommon.utils.IOUtils.close(r2);
        com.huawei.androidcommon.utils.IOUtils.close(r8);
        com.huawei.androidcommon.utils.IOUtils.close(r3);
        com.huawei.androidcommon.utils.IOUtils.close(r9);
        r2 = 0;
        goto L_0x0015;
    L_0x00a3:
        r5 = r3[r2];	 Catch:{ Exception -> 0x00d2 }
        r6 = "AndroidCommon";
        r7 = "[FileUtils.copyFile]step5";
        android.util.Log.d(r6, r7);	 Catch:{ Exception -> 0x00d2 }
        r6 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x00d2 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d2 }
        r8 = java.lang.String.valueOf(r18);	 Catch:{ Exception -> 0x00d2 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x00d2 }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00d2 }
        r5 = r5.getName();	 Catch:{ Exception -> 0x00d2 }
        r5 = r7.append(r5);	 Catch:{ Exception -> 0x00d2 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00d2 }
        copyFile(r6, r5);	 Catch:{ Exception -> 0x00d2 }
        r2 = r2 + 1;
        goto L_0x003a;
    L_0x00d2:
        r2 = move-exception;
        r3 = "AndroidCommon";
        r4 = "[FileUtils.copyFile]Error:";
        android.util.Log.e(r3, r4, r2);
        r2 = 0;
        goto L_0x0015;
    L_0x00dd:
        r6 = r12 - r4;
        r14 = 31457280; // 0x1e00000 float:8.2284605E-38 double:1.55419614E-316;
        r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
        if (r6 <= 0) goto L_0x00ef;
    L_0x00e6:
        r6 = 31457280; // 0x1e00000 float:8.2284605E-38 double:1.55419614E-316;
    L_0x00e9:
        r6 = r2.transferFrom(r3, r4, r6);	 Catch:{ Exception -> 0x015b, all -> 0x0131 }
        r4 = r4 + r6;
        goto L_0x0076;
    L_0x00ef:
        r6 = r12 - r4;
        goto L_0x00e9;
    L_0x00f2:
        r2 = move-exception;
        r16 = r4;
        r4 = r3;
        r3 = r16;
    L_0x00f8:
        r7 = "AndroidCommon";
        r8 = "[FileUtils.copyFile]Error:";
        android.util.Log.e(r7, r8, r2);	 Catch:{ all -> 0x0139 }
        com.huawei.androidcommon.utils.IOUtils.close(r3);
        com.huawei.androidcommon.utils.IOUtils.close(r5);
        com.huawei.androidcommon.utils.IOUtils.close(r4);
        com.huawei.androidcommon.utils.IOUtils.close(r6);
        r2 = 0;
        goto L_0x0015;
    L_0x010e:
        r2 = move-exception;
        r9 = r6;
    L_0x0110:
        com.huawei.androidcommon.utils.IOUtils.close(r4);
        com.huawei.androidcommon.utils.IOUtils.close(r5);
        com.huawei.androidcommon.utils.IOUtils.close(r3);
        com.huawei.androidcommon.utils.IOUtils.close(r9);
        throw r2;
    L_0x011d:
        com.huawei.androidcommon.utils.IOUtils.close(r2);
        com.huawei.androidcommon.utils.IOUtils.close(r8);
        com.huawei.androidcommon.utils.IOUtils.close(r3);
        com.huawei.androidcommon.utils.IOUtils.close(r9);
    L_0x0129:
        r2 = 1;
        goto L_0x0015;
    L_0x012c:
        r2 = move-exception;
        goto L_0x0110;
    L_0x012e:
        r2 = move-exception;
        r5 = r8;
        goto L_0x0110;
    L_0x0131:
        r4 = move-exception;
        r5 = r8;
        r16 = r2;
        r2 = r4;
        r4 = r16;
        goto L_0x0110;
    L_0x0139:
        r2 = move-exception;
        r9 = r6;
        r16 = r4;
        r4 = r3;
        r3 = r16;
        goto L_0x0110;
    L_0x0141:
        r2 = move-exception;
        r6 = r9;
        r16 = r3;
        r3 = r4;
        r4 = r16;
        goto L_0x00f8;
    L_0x0149:
        r2 = move-exception;
        r5 = r8;
        r6 = r9;
        r16 = r4;
        r4 = r3;
        r3 = r16;
        goto L_0x00f8;
    L_0x0152:
        r2 = move-exception;
        r5 = r8;
        r6 = r9;
        r16 = r4;
        r4 = r3;
        r3 = r16;
        goto L_0x00f8;
    L_0x015b:
        r4 = move-exception;
        r5 = r8;
        r6 = r9;
        r16 = r3;
        r3 = r2;
        r2 = r4;
        r4 = r16;
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.androidcommon.utils.FileUtils.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static void copyFolder(String str, String str2) {
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i = 0; i < list.length; i++) {
                File file;
                if (str.endsWith("/")) {
                    file = new File(new StringBuilder(String.valueOf(str)).append(list[i]).toString());
                } else {
                    file = new File(new StringBuilder(String.valueOf(str)).append("/").append(list[i]).toString());
                }
                if (file.isFile()) {
                    copyFile(new FileInputStream(file), new FileOutputStream(new StringBuilder(String.valueOf(str2)).append("/").append(file.getName().toString()).toString()));
                }
                if (file.isDirectory()) {
                    copyFolder(new StringBuilder(String.valueOf(str)).append("/").append(list[i]).toString(), new StringBuilder(String.valueOf(str2)).append("/").append(list[i]).toString());
                }
            }
        } catch (Throwable e) {
            Log.e(AC.TAG, HwAccountConstants.EXTRA_OPLOG_ERROR, e);
        }
    }

    public static boolean copyFile(File file, File file2) {
        Closeable fileInputStream;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        if (file == null || file2 == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                Closeable fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            IOUtils.close(fileInputStream);
                            IOUtils.close(fileOutputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    closeable = fileOutputStream;
                    closeable2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = fileOutputStream;
                }
            } catch (IOException e2) {
                closeable = null;
                closeable2 = fileInputStream;
                try {
                    Log.e(AC.TAG, "failed to copy file: from=" + absolutePath + ", to=" + absolutePath2);
                    IOUtils.close(closeable2);
                    IOUtils.close(closeable);
                    return false;
                } catch (Throwable th3) {
                    fileInputStream = closeable2;
                    closeable2 = closeable;
                    th = th3;
                    IOUtils.close(fileInputStream);
                    IOUtils.close(closeable2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                IOUtils.close(fileInputStream);
                IOUtils.close(closeable2);
                throw th;
            }
        } catch (IOException e3) {
            closeable = null;
            Log.e(AC.TAG, "failed to copy file: from=" + absolutePath + ", to=" + absolutePath2);
            IOUtils.close(closeable2);
            IOUtils.close(closeable);
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            IOUtils.close(fileInputStream);
            IOUtils.close(closeable2);
            throw th;
        }
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            try {
                outputStream.write(bArr, 0, read);
                outputStream.flush();
            } catch (Throwable e) {
                Log.e(AC.TAG, HwAccountConstants.EXTRA_OPLOG_ERROR, e);
                return false;
            } finally {
                IOUtils.close((Closeable) inputStream);
                IOUtils.close((Closeable) outputStream);
            }
        }
        return true;
    }

    public static void fileChannelCopy(Context context, Uri uri, File file) {
        Closeable fileOutputStream;
        Throwable e;
        Closeable closeable;
        Closeable closeable2;
        Closeable closeable3;
        Closeable closeable4 = null;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor());
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e2) {
                e = e2;
                closeable = null;
                closeable2 = null;
                closeable3 = fileInputStream;
                try {
                    Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
                    IOUtils.close(closeable3);
                    IOUtils.close(closeable);
                    IOUtils.close(closeable2);
                    IOUtils.close(closeable4);
                } catch (Throwable th) {
                    e = th;
                    fileOutputStream = closeable2;
                    fileInputStream = closeable3;
                    IOUtils.close(fileInputStream);
                    IOUtils.close(closeable);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(closeable4);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                closeable = null;
                fileOutputStream = null;
                IOUtils.close(fileInputStream);
                IOUtils.close(closeable);
                IOUtils.close(fileOutputStream);
                IOUtils.close(closeable4);
                throw e;
            }
            try {
                closeable = fileInputStream.getChannel();
                try {
                    closeable4 = fileOutputStream.getChannel();
                    closeable.transferTo(0, closeable.size(), closeable4);
                    IOUtils.close(fileInputStream);
                    IOUtils.close(closeable);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(closeable4);
                } catch (IOException e3) {
                    e = e3;
                    closeable2 = fileOutputStream;
                    closeable3 = fileInputStream;
                    Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
                    IOUtils.close(closeable3);
                    IOUtils.close(closeable);
                    IOUtils.close(closeable2);
                    IOUtils.close(closeable4);
                } catch (Throwable th3) {
                    e = th3;
                    IOUtils.close(fileInputStream);
                    IOUtils.close(closeable);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(closeable4);
                    throw e;
                }
            } catch (IOException e4) {
                e = e4;
                closeable = null;
                closeable2 = fileOutputStream;
                closeable3 = fileInputStream;
                Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
                IOUtils.close(closeable3);
                IOUtils.close(closeable);
                IOUtils.close(closeable2);
                IOUtils.close(closeable4);
            } catch (Throwable th4) {
                e = th4;
                closeable = null;
                IOUtils.close(fileInputStream);
                IOUtils.close(closeable);
                IOUtils.close(fileOutputStream);
                IOUtils.close(closeable4);
                throw e;
            }
        } catch (IOException e5) {
            e = e5;
            closeable = null;
            closeable2 = null;
            closeable3 = null;
            Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
            IOUtils.close(closeable3);
            IOUtils.close(closeable);
            IOUtils.close(closeable2);
            IOUtils.close(closeable4);
        } catch (Throwable th5) {
            e = th5;
            closeable = null;
            fileOutputStream = null;
            fileInputStream = null;
            IOUtils.close(fileInputStream);
            IOUtils.close(closeable);
            IOUtils.close(fileOutputStream);
            IOUtils.close(closeable4);
            throw e;
        }
    }

    public static boolean fileChannelCopy(File file, File file2) {
        Closeable fileInputStream;
        Closeable fileOutputStream;
        Throwable e;
        Closeable closeable;
        Closeable closeable2;
        Closeable closeable3;
        Closeable closeable4 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e2) {
                e = e2;
                closeable = null;
                closeable2 = null;
                closeable3 = fileInputStream;
                try {
                    Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
                    IOUtils.close(closeable3);
                    IOUtils.close(closeable);
                    IOUtils.close(closeable2);
                    IOUtils.close(closeable4);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    fileOutputStream = closeable2;
                    fileInputStream = closeable3;
                    IOUtils.close(fileInputStream);
                    IOUtils.close(closeable);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(closeable4);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                closeable = null;
                fileOutputStream = null;
                IOUtils.close(fileInputStream);
                IOUtils.close(closeable);
                IOUtils.close(fileOutputStream);
                IOUtils.close(closeable4);
                throw e;
            }
            try {
                closeable = fileInputStream.getChannel();
                try {
                    closeable4 = fileOutputStream.getChannel();
                    closeable.transferTo(0, closeable.size(), closeable4);
                    IOUtils.close(fileInputStream);
                    IOUtils.close(closeable);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(closeable4);
                    return true;
                } catch (IOException e3) {
                    e = e3;
                    closeable2 = fileOutputStream;
                    closeable3 = fileInputStream;
                    Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
                    IOUtils.close(closeable3);
                    IOUtils.close(closeable);
                    IOUtils.close(closeable2);
                    IOUtils.close(closeable4);
                    return false;
                } catch (Throwable th3) {
                    e = th3;
                    IOUtils.close(fileInputStream);
                    IOUtils.close(closeable);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(closeable4);
                    throw e;
                }
            } catch (IOException e4) {
                e = e4;
                closeable = null;
                closeable2 = fileOutputStream;
                closeable3 = fileInputStream;
                Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
                IOUtils.close(closeable3);
                IOUtils.close(closeable);
                IOUtils.close(closeable2);
                IOUtils.close(closeable4);
                return false;
            } catch (Throwable th4) {
                e = th4;
                closeable = null;
                IOUtils.close(fileInputStream);
                IOUtils.close(closeable);
                IOUtils.close(fileOutputStream);
                IOUtils.close(closeable4);
                throw e;
            }
        } catch (IOException e5) {
            e = e5;
            closeable = null;
            closeable2 = null;
            closeable3 = null;
            Log.e(AC.TAG, "[FileUtils.fileChannelCopy]error!", e);
            IOUtils.close(closeable3);
            IOUtils.close(closeable);
            IOUtils.close(closeable2);
            IOUtils.close(closeable4);
            return false;
        } catch (Throwable th5) {
            e = th5;
            closeable = null;
            fileOutputStream = null;
            fileInputStream = null;
            IOUtils.close(fileInputStream);
            IOUtils.close(closeable);
            IOUtils.close(fileOutputStream);
            IOUtils.close(closeable4);
            throw e;
        }
    }

    public static boolean moveFile(String str, String str2) {
        if (str.equals(str2)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            return false;
        }
        if (file2.getParentFile().exists()) {
            return file.renameTo(file2);
        }
        if (createDir(file2.getParent())) {
            return file.renameTo(file2);
        }
        return false;
    }

    public static boolean moveFileToDir(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!copyFile(str, new StringBuilder(String.valueOf(str2)).append(file.getName()).toString())) {
            return false;
        }
        deleteFile(str);
        return true;
    }

    public static boolean moveFileForce(String str, String str2) {
        Log.i(AC.TAG, "移动:" + str + " => " + str2);
        if (str.equals(str2)) {
            Log.e(AC.TAG, "源文件与目标文件相同：" + str);
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            File file2 = new File(str2);
            if (file2.exists()) {
                Log.e(AC.TAG, "目标文件已存在：" + str2);
                file2.delete();
            }
            if (createFile(str2)) {
                return fileChannelCopy(file, file2);
            }
            Log.e(AC.TAG, "创建目标目录失败：" + str2);
            return false;
        }
        Log.e(AC.TAG, "源文件不存在：" + str);
        return false;
    }

    public static void deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
        }
    }

    public static void deleteFiles(String[] strArr) {
        if (strArr != null) {
            for (String deleteFile : strArr) {
                deleteFile(deleteFile);
            }
        }
    }

    public static void deleteDir(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File absolutePath : listFiles) {
                deleteDir(absolutePath.getAbsolutePath());
            }
        }
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
    }

    public static boolean writeTextFile(File file, String str, boolean z) {
        Closeable fileOutputStream;
        Closeable outputStreamWriter;
        Throwable e;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z);
            try {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, GameManager.DEFAULT_CHARSET);
            } catch (Exception e2) {
                e = e2;
                closeable = null;
                Closeable closeable3 = fileOutputStream;
                fileOutputStream = null;
                closeable2 = closeable3;
                try {
                    Log.e(AC.TAG, "[FileUtils.writeTextFile]Error :", e);
                    IOUtils.close(closeable2);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(closeable);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamWriter = fileOutputStream;
                    fileOutputStream = closeable2;
                    closeable2 = closeable;
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(outputStreamWriter);
                    IOUtils.close(closeable2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
                IOUtils.close(fileOutputStream);
                IOUtils.close(outputStreamWriter);
                IOUtils.close(closeable2);
                throw th;
            }
            try {
                closeable = new BufferedWriter(outputStreamWriter);
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                closeable2 = fileOutputStream;
                fileOutputStream = outputStreamWriter;
                Log.e(AC.TAG, "[FileUtils.writeTextFile]Error :", e);
                IOUtils.close(closeable2);
                IOUtils.close(fileOutputStream);
                IOUtils.close(closeable);
                return false;
            } catch (Throwable th4) {
                th = th4;
                IOUtils.close(fileOutputStream);
                IOUtils.close(outputStreamWriter);
                IOUtils.close(closeable2);
                throw th;
            }
            try {
                closeable.write(str);
                closeable.flush();
                IOUtils.close(fileOutputStream);
                IOUtils.close(outputStreamWriter);
                IOUtils.close(closeable);
                return true;
            } catch (Exception e4) {
                e = e4;
                closeable2 = fileOutputStream;
                fileOutputStream = outputStreamWriter;
                Log.e(AC.TAG, "[FileUtils.writeTextFile]Error :", e);
                IOUtils.close(closeable2);
                IOUtils.close(fileOutputStream);
                IOUtils.close(closeable);
                return false;
            } catch (Throwable th5) {
                th = th5;
                closeable2 = closeable;
                IOUtils.close(fileOutputStream);
                IOUtils.close(outputStreamWriter);
                IOUtils.close(closeable2);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            closeable = null;
            fileOutputStream = null;
            Log.e(AC.TAG, "[FileUtils.writeTextFile]Error :", e);
            IOUtils.close(closeable2);
            IOUtils.close(fileOutputStream);
            IOUtils.close(closeable);
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            outputStreamWriter = null;
            IOUtils.close(fileOutputStream);
            IOUtils.close(outputStreamWriter);
            IOUtils.close(closeable2);
            throw th;
        }
    }

    public static boolean writeTextFile(File file, String str) {
        return writeTextFile(file, str, false);
    }

    public static boolean writeTextFile(String str, String str2) {
        return writeTextFile(str, str2, false);
    }

    public static boolean writeTextFile(String str, String str2, boolean z) {
        Closeable fileWriter;
        Throwable e;
        Throwable th;
        if (str2.isEmpty()) {
            return false;
        }
        try {
            createFile(str);
            fileWriter = new FileWriter(str, z);
            try {
                fileWriter.write(str2);
                fileWriter.close();
                IOUtils.close(fileWriter);
                return true;
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e(AC.TAG, "[FileUtils.writeTextFile]Error :", e);
                    IOUtils.close(fileWriter);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.close(fileWriter);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileWriter = null;
            Log.e(AC.TAG, "[FileUtils.writeTextFile]Error :", e);
            IOUtils.close(fileWriter);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
            IOUtils.close(fileWriter);
            throw th;
        }
    }

    public static boolean appendTextToFile(String str, String str2) {
        return writeTextFile(new File(str), str2, true);
    }

    public static String getFileSizeStr(String str) {
        return getFileSizeStr(new File(str));
    }

    public static String getFileSizeStr(File file) {
        String str = "";
        if (!file.exists() || file.isDirectory()) {
            return str;
        }
        return getFileSizeStr(file.length());
    }

    public static String getFileSizeStr(long j) {
        String str = "";
        if (((float) j) / 1024.0f >= 1048576.0f) {
            str = Float.valueOf(((((float) j) / 1024.0f) / 1024.0f) / 1024.0f).toString();
            str = str.substring(0, str.indexOf(".") + 2) + "GB";
        }
        if (((float) j) / 1024.0f < 1048576.0f && j / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            str = Float.valueOf((((float) j) / 1024.0f) / 1024.0f).toString();
            return str.substring(0, str.indexOf(".") + 2) + "MB";
        } else if (((float) j) / 1024.0f < 1024.0f && j >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            str = Float.valueOf(((float) j) / 1024.0f).toString();
            return str.substring(0, str.indexOf(".") + 2) + "KB";
        } else if (j < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return String.valueOf(j) + "B";
        } else {
            return str;
        }
    }

    public static long getFileSize(String str) {
        if (isFileExists(str)) {
            return new File(str).length();
        }
        return 0;
    }

    public static long getDirSize(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return 0;
        }
        return getDirSize(new File(str));
    }

    public static long getDirSize(File file) {
        long j = 0;
        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0;
            }
            int i = 0;
            while (i < listFiles.length) {
                long dirSize = getDirSize(listFiles[i]) + j;
                i++;
                j = dirSize;
            }
            return j;
        } else if (file.isFile()) {
            return file.length();
        } else {
            return 0;
        }
    }

    public static boolean isImageFormatByFileName(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".png") || str.endsWith(".bmp")) {
            return true;
        }
        return false;
    }

    public static boolean isVideoFormatByFileName(String str) {
        if (str != null && str.endsWith(".mp4")) {
            return true;
        }
        return false;
    }

    public static boolean isAudioFormatByFileName(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith(".amr") || str.endsWith(".mp3")) {
            return true;
        }
        return false;
    }

    public static boolean isCompressedFormatByFileName(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith(LightCloudConstants.ZIP_POSTFIX) || str.endsWith(".rar") || str.endsWith(".gz") || str.endsWith(".7z") || str.endsWith(".tar")) {
            return true;
        }
        return false;
    }

    public static String getFilePathFromUri(Context context, Uri uri) {
        Uri uri2 = null;
        if ((VERSION.SDK_INT >= 19 ? 1 : 0) == 0 || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        } else if (isExternalStorageDocument(uri)) {
            r1 = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(r1[0])) {
                return Environment.getExternalStorageDirectory() + "/" + r1[1];
            }
            return null;
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if (!isMediaDocument(uri)) {
            return null;
        } else {
            Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
            if (WBConstants.GAME_PARAMS_GAME_IMAGE_URL.equals(obj)) {
                uri2 = Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(obj)) {
                uri2 = Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(obj)) {
                uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
            }
            String str = "_id=?";
            return getDataColumn(context, uri2, "_id=?", new String[]{r1[1]});
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        String str2 = "_data";
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndexOrThrow("_data"));
                        IOUtils.close(query);
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    IOUtils.close(cursor);
                    throw th;
                }
            }
            IOUtils.close(query);
            return null;
        } catch (Throwable th3) {
            th = th3;
            IOUtils.close(cursor);
            throw th;
        }
    }
}
