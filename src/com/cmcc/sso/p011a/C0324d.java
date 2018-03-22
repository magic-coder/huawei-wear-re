package com.cmcc.sso.p011a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.cmcc.sso.sdk.p012a.C0325a;
import com.cmcc.sso.sdk.p013b.C0327a;
import com.cmcc.sso.sdk.p013b.C0328b;
import com.cmcc.sso.sdk.p013b.C0329c;
import com.cmcc.sso.sdk.p013b.C0330d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.channels.FileLock;
import org.json.JSONArray;
import org.json.JSONException;

public class C0324d {
    private Context f174a;

    public C0324d(Context context) {
        this.f174a = context;
    }

    public static Object m179a(Object obj, Class cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static String m180a() {
        String str;
        String str2;
        Class cls = Build.class;
        if (VERSION.SDK_INT >= 21) {
            try {
                str = ((String[]) cls.getDeclaredField("SUPPORTED_ABIS").get(null))[0];
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                    C0327a.m206d("can't get CPU_ABI... " + str);
                    return null;
                }
            }
            if ("arm64-v8a".equals(str2)) {
                return "arm64";
            }
            if ("armeabi".equals(str2)) {
                return "arm32";
            }
            if ("armeabi-v7a".equals(str2)) {
                return "arm32";
            }
            if ("mips".equals(str2)) {
                return "mips32";
            }
            if ("mips64".equals(str2)) {
                return "mips64";
            }
            if ("x86".equals(str2)) {
                return "x8632";
            }
            if ("x86_64".equals(str2)) {
                return "x8664";
            }
            C0327a.m206d("can't get CPU_ABI... " + str2);
            return null;
        }
        str = null;
        str2 = !TextUtils.isEmpty(str) ? str : (String) cls.getDeclaredField("CPU_ABI").get(null);
        if ("arm64-v8a".equals(str2)) {
            return "arm64";
        }
        if ("armeabi".equals(str2)) {
            return "arm32";
        }
        if ("armeabi-v7a".equals(str2)) {
            return "arm32";
        }
        if ("mips".equals(str2)) {
            return "mips32";
        }
        if ("mips64".equals(str2)) {
            return "mips64";
        }
        if ("x86".equals(str2)) {
            return "x8632";
        }
        if ("x86_64".equals(str2)) {
            return "x8664";
        }
        C0327a.m206d("can't get CPU_ABI... " + str2);
        return null;
    }

    public static void m181a(Context context) {
        Object b = C0324d.m189b(context);
        C0327a.m200a("sd hash: " + b);
        if (!TextUtils.isEmpty(b)) {
            try {
                JSONArray jSONArray = new JSONArray(b);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.getJSONObject(i).optString("FILE_HASH");
                    if (!TextUtils.isEmpty(optString) && optString.contains("___")) {
                        String[] split = optString.split("___");
                        if (split != null && split.length == 2) {
                            C0328b.m208a(context, split[0], split[1]);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m182a(Context context, String str) {
        if (context == null) {
            C0327a.m206d("context is null");
        } else if (new File(str).exists()) {
            try {
                C0322b.m171a(str, C0325a.m195a(context));
            } catch (Exception e) {
                C0327a.m206d("inject " + str + " failed");
                e.printStackTrace();
            }
        } else {
            C0327a.m206d(str + " is null");
        }
    }

    public static void m183a(Context context, String str, String str2) {
        Closeable fileOutputStream;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        Closeable fileInputStream;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileOutputStream;
                    try {
                        e.printStackTrace();
                        C0324d.m184a(fileInputStream);
                        C0324d.m184a(closeable);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileInputStream;
                        C0324d.m184a(fileOutputStream);
                        C0324d.m184a(closeable);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    C0324d.m184a(fileOutputStream);
                    C0324d.m184a(closeable);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[2014];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            C0324d.m191b(context, new File(str2));
                            C0327a.m200a("copy from [" + str + "], to [" + str2 + "]");
                            C0324d.m184a(fileOutputStream);
                            C0324d.m184a(fileInputStream);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    closeable = fileInputStream;
                    fileInputStream = fileOutputStream;
                    e.printStackTrace();
                    C0324d.m184a(fileInputStream);
                    C0324d.m184a(closeable);
                } catch (Throwable th4) {
                    th = th4;
                    closeable = fileInputStream;
                    C0324d.m184a(fileOutputStream);
                    C0324d.m184a(closeable);
                    throw th;
                }
            }
            C0327a.m200a("copy file " + str + "failed, src file don't exist");
            C0324d.m184a(null);
            C0324d.m184a(null);
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            e.printStackTrace();
            C0324d.m184a(fileInputStream);
            C0324d.m184a(closeable);
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            C0324d.m184a(fileOutputStream);
            C0324d.m184a(closeable);
            throw th;
        }
    }

    public static void m184a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m185a(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File a : listFiles) {
                C0324d.m185a(a);
            }
            file.delete();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m186a(java.lang.String r10, java.lang.String r11) {
        /*
        r1 = 0;
        r9 = -1;
        r4 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0154, all -> 0x013c }
        r4.<init>(r10);	 Catch:{ IOException -> 0x0154, all -> 0x013c }
        r5 = r4.entries();	 Catch:{ IOException -> 0x0122, all -> 0x014f }
        r0 = new java.io.File;	 Catch:{ IOException -> 0x0122, all -> 0x014f }
        r0.<init>(r11);	 Catch:{ IOException -> 0x0122, all -> 0x014f }
        r0.mkdirs();	 Catch:{ IOException -> 0x0122, all -> 0x014f }
    L_0x0013:
        r0 = r5.hasMoreElements();	 Catch:{ IOException -> 0x0122, all -> 0x014f }
        if (r0 == 0) goto L_0x0136;
    L_0x0019:
        r0 = r5.nextElement();	 Catch:{ IOException -> 0x0122, all -> 0x014f }
        r0 = (java.util.zip.ZipEntry) r0;	 Catch:{ IOException -> 0x0122, all -> 0x014f }
        r2 = r0.getName();	 Catch:{ IOException -> 0x0122, all -> 0x014f }
        r3 = r0.isDirectory();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        if (r3 == 0) goto L_0x0066;
    L_0x0029:
        r0 = r0.getName();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = 0;
        r3 = r0.length();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = r3 + -1;
        r0 = r0.substring(r2, r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = new java.io.File;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3.<init>();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = r3.append(r11);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r6 = java.io.File.separator;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = r3.append(r6);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r0 = r3.append(r0);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2.mkdirs();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = r1;
        r3 = r1;
    L_0x0059:
        if (r3 == 0) goto L_0x005e;
    L_0x005b:
        r3.close();	 Catch:{ IOException -> 0x0144, all -> 0x014f }
    L_0x005e:
        if (r2 == 0) goto L_0x0013;
    L_0x0060:
        r2.close();	 Catch:{ IOException -> 0x0064, all -> 0x014f }
        goto L_0x0013;
    L_0x0064:
        r0 = move-exception;
        goto L_0x0013;
    L_0x0066:
        r3 = "\\";
        r3 = r2.lastIndexOf(r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        if (r3 == r9) goto L_0x0092;
    L_0x006e:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7.<init>();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7 = r7.append(r11);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r8 = java.io.File.separator;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7 = r7.append(r8);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r8 = 0;
        r3 = r2.substring(r8, r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = r7.append(r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r6.<init>(r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r6.mkdirs();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
    L_0x0092:
        r3 = "/";
        r3 = r2.lastIndexOf(r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        if (r3 == r9) goto L_0x00be;
    L_0x009a:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7.<init>();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7 = r7.append(r11);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r8 = java.io.File.separator;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r7 = r7.append(r8);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r8 = 0;
        r2 = r2.substring(r8, r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = r7.append(r2);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r6.<init>(r2);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r6.mkdirs();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
    L_0x00be:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2.<init>();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = r2.append(r11);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = java.io.File.separator;	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = r0.getName();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r6.<init>(r2);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r3 = r4.getInputStream(r0);	 Catch:{ IOException -> 0x015c, all -> 0x0156 }
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x015f, all -> 0x0159 }
        r2.<init>(r6);	 Catch:{ IOException -> 0x015f, all -> 0x0159 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ IOException -> 0x00f6, all -> 0x0132 }
    L_0x00eb:
        r6 = r3.read(r0);	 Catch:{ IOException -> 0x00f6, all -> 0x0132 }
        if (r6 == r9) goto L_0x012d;
    L_0x00f1:
        r7 = 0;
        r2.write(r0, r7, r6);	 Catch:{ IOException -> 0x00f6, all -> 0x0132 }
        goto L_0x00eb;
    L_0x00f6:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
    L_0x00f9:
        r0.printStackTrace();	 Catch:{ all -> 0x0116 }
        r3 = new java.io.IOException;	 Catch:{ all -> 0x0116 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0116 }
        r6 = "解压失败：";
        r5.<init>(r6);	 Catch:{ all -> 0x0116 }
        r0 = r0.toString();	 Catch:{ all -> 0x0116 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x0116 }
        r0 = r0.toString();	 Catch:{ all -> 0x0116 }
        r3.<init>(r0);	 Catch:{ all -> 0x0116 }
        throw r3;	 Catch:{ all -> 0x0116 }
    L_0x0116:
        r0 = move-exception;
    L_0x0117:
        if (r2 == 0) goto L_0x011c;
    L_0x0119:
        r2.close();	 Catch:{ IOException -> 0x0147, all -> 0x014f }
    L_0x011c:
        if (r1 == 0) goto L_0x0121;
    L_0x011e:
        r1.close();	 Catch:{ IOException -> 0x0149, all -> 0x014f }
    L_0x0121:
        throw r0;	 Catch:{ IOException -> 0x0122, all -> 0x014f }
    L_0x0122:
        r0 = move-exception;
        r1 = r4;
    L_0x0124:
        r0.printStackTrace();	 Catch:{ all -> 0x0151 }
        if (r1 == 0) goto L_0x012c;
    L_0x0129:
        r1.close();	 Catch:{ IOException -> 0x014b }
    L_0x012c:
        return;
    L_0x012d:
        r2.flush();	 Catch:{ IOException -> 0x00f6, all -> 0x0132 }
        goto L_0x0059;
    L_0x0132:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0117;
    L_0x0136:
        r4.close();	 Catch:{ IOException -> 0x013a }
        goto L_0x012c;
    L_0x013a:
        r0 = move-exception;
        goto L_0x012c;
    L_0x013c:
        r0 = move-exception;
        r4 = r1;
    L_0x013e:
        if (r4 == 0) goto L_0x0143;
    L_0x0140:
        r4.close();	 Catch:{ IOException -> 0x014d }
    L_0x0143:
        throw r0;
    L_0x0144:
        r0 = move-exception;
        goto L_0x005e;
    L_0x0147:
        r2 = move-exception;
        goto L_0x011c;
    L_0x0149:
        r1 = move-exception;
        goto L_0x0121;
    L_0x014b:
        r0 = move-exception;
        goto L_0x012c;
    L_0x014d:
        r1 = move-exception;
        goto L_0x0143;
    L_0x014f:
        r0 = move-exception;
        goto L_0x013e;
    L_0x0151:
        r0 = move-exception;
        r4 = r1;
        goto L_0x013e;
    L_0x0154:
        r0 = move-exception;
        goto L_0x0124;
    L_0x0156:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0117;
    L_0x0159:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0117;
    L_0x015c:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00f9;
    L_0x015f:
        r0 = move-exception;
        r2 = r3;
        goto L_0x00f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmcc.sso.a.d.a(java.lang.String, java.lang.String):void");
    }

    public static void m187a(FileLock fileLock) {
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean m188a(Context context, File file) {
        try {
            Object b = C0328b.m209b(context, C0329c.m210a(file.getPath().getBytes("utf-8")), "");
            return !TextUtils.isEmpty(b) && file.exists() && C0330d.m211a(file).equalsIgnoreCase(b);
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String m189b(android.content.Context r10) {
        /*
        r0 = 0;
        r6 = com.cmcc.sso.p011a.C0324d.class;
        monitor-enter(r6);
        r7 = new java.io.File;	 Catch:{ all -> 0x0023 }
        r1 = com.cmcc.sso.sdk.p012a.C0325a.m198b(r10);	 Catch:{ all -> 0x0023 }
        r7.<init>(r1);	 Catch:{ all -> 0x0023 }
        r1 = r7.exists();	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x0016;
    L_0x0013:
        r7.createNewFile();	 Catch:{ IOException -> 0x001e }
    L_0x0016:
        r1 = r7.exists();	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x0026;
    L_0x001c:
        monitor-exit(r6);
        return r0;
    L_0x001e:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0023 }
        goto L_0x001c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0026:
        r5 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x009c, all -> 0x00b5 }
        r1 = "rw";
        r5.<init>(r7, r1);	 Catch:{ Exception -> 0x009c, all -> 0x00b5 }
        r4 = r5.getChannel();	 Catch:{ Exception -> 0x00dc, all -> 0x00cb }
        r1 = 0;
    L_0x0032:
        r2 = r1 + 1;
        r3 = 20;
        if (r1 <= r3) goto L_0x0056;
    L_0x0038:
        r1 = "file is using by other process";
        com.cmcc.sso.sdk.p013b.C0327a.m206d(r1);	 Catch:{ Exception -> 0x0080, all -> 0x00d1 }
        com.cmcc.sso.p011a.C0324d.m184a(r4);	 Catch:{ Exception -> 0x0080, all -> 0x00d1 }
        com.cmcc.sso.p011a.C0324d.m184a(r5);	 Catch:{ Exception -> 0x0080, all -> 0x00d1 }
        r1 = 0;
        com.cmcc.sso.p011a.C0324d.m184a(r1);	 Catch:{ all -> 0x0023 }
        r1 = 0;
        com.cmcc.sso.p011a.C0324d.m187a(r1);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r4);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r5);	 Catch:{ all -> 0x0023 }
        r1 = 0;
        com.cmcc.sso.p011a.C0324d.m184a(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x001c;
    L_0x0056:
        r3 = r4.tryLock();	 Catch:{ Exception -> 0x0080, all -> 0x00d1 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00e5, all -> 0x00d6 }
        r1 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00e5, all -> 0x00d6 }
        r8 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00e5, all -> 0x00d6 }
        r8.<init>(r7);	 Catch:{ Exception -> 0x00e5, all -> 0x00d6 }
        r7 = "utf-8";
        r1.<init>(r8, r7);	 Catch:{ Exception -> 0x00e5, all -> 0x00d6 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x00e5, all -> 0x00d6 }
        r0 = r2.readLine();	 Catch:{ Exception -> 0x008e }
    L_0x0070:
        com.cmcc.sso.p011a.C0324d.m184a(r2);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m187a(r3);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r4);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r5);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x001c;
    L_0x0080:
        r1 = move-exception;
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        java.lang.Thread.sleep(r8);	 Catch:{ InterruptedException -> 0x0088 }
        r1 = r2;
        goto L_0x0032;
    L_0x0088:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x00e1, all -> 0x00d1 }
        r1 = r2;
        goto L_0x0032;
    L_0x008e:
        r1 = move-exception;
        r1 = "file lock is released mannally for xml parser";
        com.cmcc.sso.sdk.p013b.C0327a.m204c(r1);	 Catch:{ Exception -> 0x00e8 }
        r3.release();	 Catch:{ Exception -> 0x00e8 }
        r0 = r2.readLine();	 Catch:{ Exception -> 0x00e8 }
        goto L_0x0070;
    L_0x009c:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        r4 = r0;
        r5 = r0;
    L_0x00a1:
        r1.printStackTrace();	 Catch:{ all -> 0x00da }
        com.cmcc.sso.p011a.C0324d.m184a(r2);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m187a(r3);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r4);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r5);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x001c;
    L_0x00b5:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        r4 = r0;
        r5 = r0;
        r0 = r1;
    L_0x00bb:
        com.cmcc.sso.p011a.C0324d.m184a(r2);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m187a(r3);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r4);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r5);	 Catch:{ all -> 0x0023 }
        com.cmcc.sso.p011a.C0324d.m184a(r2);	 Catch:{ all -> 0x0023 }
        throw r0;	 Catch:{ all -> 0x0023 }
    L_0x00cb:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        r4 = r0;
        r0 = r1;
        goto L_0x00bb;
    L_0x00d1:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        r0 = r1;
        goto L_0x00bb;
    L_0x00d6:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x00bb;
    L_0x00da:
        r0 = move-exception;
        goto L_0x00bb;
    L_0x00dc:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        r4 = r0;
        goto L_0x00a1;
    L_0x00e1:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        goto L_0x00a1;
    L_0x00e5:
        r1 = move-exception;
        r2 = r0;
        goto L_0x00a1;
    L_0x00e8:
        r1 = move-exception;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmcc.sso.a.d.b(android.content.Context):java.lang.String");
    }

    public static String m190b(Context context, String str) {
        return "libkh_" + C0324d.m180a() + "-" + str + ".so";
    }

    public static void m191b(Context context, File file) {
        if (file.exists()) {
            Object a = C0330d.m211a(file);
            if (TextUtils.isEmpty(a)) {
                C0327a.m204c("get file hash failed: " + file.getPath());
                return;
            }
            try {
                C0328b.m208a(context, C0329c.m210a(file.getPath().getBytes("utf-8")), a);
                return;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return;
            }
        }
        C0327a.m204c("save file hash to sp failed, file don't exist.");
    }

    public static boolean m192b() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists()) {
            return false;
        }
        File file = new File(externalStorageDirectory.getPath() + "/" + System.currentTimeMillis());
        if (file.exists()) {
            file.delete();
            if (file.exists()) {
                return false;
            }
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        if (!file.exists()) {
            return false;
        }
        if (file.exists()) {
            file.delete();
        }
        file = new File(externalStorageDirectory.getPath() + "/cmcc_sso_download");
        return file.exists() ? true : file.mkdir() && file.exists();
    }

    public void m193c() {
        C0327a.m202b("start current app sso service : " + this.f174a.getPackageName());
        Intent intent = new Intent();
        intent.setClassName(this.f174a.getPackageName(), "com.cmcc.sso.service.SsoService");
        try {
            this.f174a.getApplicationContext().startService(intent);
        } catch (Exception e) {
            C0327a.m204c("start service failed ... ");
        }
    }
}
