package com.huawei.uploadlog.p188c;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES */
public class C2505a {
    private static final byte[] f8980a = new byte[]{TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102};
    private static String f8981b = "BzFiTFdHwJAZUTiC2Y3Hm7B1CJpAxyc0yjeWWXGRIH5hAgCpXmnBbkaTK7/Iq3feAqXf8GQ+VO/nSsuUIuCMtC5RWUYYoseCg==";

    public static String m12447a() {
        return f8981b;
    }

    public static File m12446a(File file, String str) {
        Throwable th;
        Closeable closeable = null;
        if (file == null || str == null) {
            return null;
        }
        String targetEncPathString = SdkConstants.getTargetEncPathString(AppContext.getInstance().getApplicationContext());
        C2511g.m12481b("LogUpload Service", "filePath" + targetEncPathString);
        File file2 = new File(targetEncPathString);
        if (!file2.exists()) {
            C2511g.m12481b("LogUpload Service", "文件夹不存在，创建文件夹");
            if (!file2.mkdirs()) {
                C2511g.m12481b("LogUpload Service", "文件夹不存在，创建文件夹失败");
                return null;
            }
        }
        String str2 = file2.getAbsolutePath() + "/" + file.getName();
        C2511g.m12481b("LogUpload Service", "local_file" + str2);
        File file3 = new File(str2);
        if (file3.exists()) {
            C2511g.m12481b("LogUpload Service", "创建文件失败，删除加密文件");
            if (file3.delete()) {
                C2511g.m12481b("LogUpload Service", "encrypFile is deleted successfully!");
            } else {
                C2511g.m12481b("LogUpload Service", "encrypFile is deleted failed!");
            }
        }
        Closeable fileInputStream;
        Closeable fileOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                C2511g.m12481b("LogUpload Service", "encrypfile" + file3.getAbsolutePath());
                fileOutputStream = new FileOutputStream(file3);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byte[] a = C2505a.m12450a(bArr, str, read);
                        if (a != null) {
                            fileOutputStream.write(a, 0, a.length);
                        }
                    }
                    C2517m.m12571a(fileInputStream, "LogUpload Service");
                    C2517m.m12571a(fileOutputStream, "LogUpload Service");
                } catch (FileNotFoundException e) {
                    closeable = fileOutputStream;
                    fileOutputStream = fileInputStream;
                    try {
                        C2511g.m12481b("LogUpload Service", "FileNotFound");
                        C2517m.m12571a(fileOutputStream, "LogUpload Service");
                        C2517m.m12571a(closeable, "LogUpload Service");
                        C2511g.m12481b("LogUpload Service", "encryptFile" + file3.getAbsolutePath());
                        return file3;
                    } catch (Throwable th2) {
                        fileInputStream = fileOutputStream;
                        fileOutputStream = closeable;
                        th = th2;
                        C2517m.m12571a(fileInputStream, "LogUpload Service");
                        C2517m.m12571a(fileOutputStream, "LogUpload Service");
                        throw th;
                    }
                } catch (IOException e2) {
                    closeable = fileOutputStream;
                    try {
                        C2511g.m12481b("LogUpload Service", "IOException");
                        C2517m.m12571a(fileInputStream, "LogUpload Service");
                        C2517m.m12571a(closeable, "LogUpload Service");
                        C2511g.m12481b("LogUpload Service", "encryptFile" + file3.getAbsolutePath());
                        return file3;
                    } catch (Throwable th22) {
                        fileOutputStream = closeable;
                        th = th22;
                        C2517m.m12571a(fileInputStream, "LogUpload Service");
                        C2517m.m12571a(fileOutputStream, "LogUpload Service");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    C2517m.m12571a(fileInputStream, "LogUpload Service");
                    C2517m.m12571a(fileOutputStream, "LogUpload Service");
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                fileOutputStream = fileInputStream;
                C2511g.m12481b("LogUpload Service", "FileNotFound");
                C2517m.m12571a(fileOutputStream, "LogUpload Service");
                C2517m.m12571a(closeable, "LogUpload Service");
                C2511g.m12481b("LogUpload Service", "encryptFile" + file3.getAbsolutePath());
                return file3;
            } catch (IOException e4) {
                C2511g.m12481b("LogUpload Service", "IOException");
                C2517m.m12571a(fileInputStream, "LogUpload Service");
                C2517m.m12571a(closeable, "LogUpload Service");
                C2511g.m12481b("LogUpload Service", "encryptFile" + file3.getAbsolutePath());
                return file3;
            } catch (Throwable th222) {
                fileOutputStream = null;
                th = th222;
                C2517m.m12571a(fileInputStream, "LogUpload Service");
                C2517m.m12571a(fileOutputStream, "LogUpload Service");
                throw th;
            }
        } catch (FileNotFoundException e5) {
            fileOutputStream = null;
            C2511g.m12481b("LogUpload Service", "FileNotFound");
            C2517m.m12571a(fileOutputStream, "LogUpload Service");
            C2517m.m12571a(closeable, "LogUpload Service");
            C2511g.m12481b("LogUpload Service", "encryptFile" + file3.getAbsolutePath());
            return file3;
        } catch (IOException e6) {
            fileInputStream = null;
            C2511g.m12481b("LogUpload Service", "IOException");
            C2517m.m12571a(fileInputStream, "LogUpload Service");
            C2517m.m12571a(closeable, "LogUpload Service");
            C2511g.m12481b("LogUpload Service", "encryptFile" + file3.getAbsolutePath());
            return file3;
        } catch (Throwable th2222) {
            fileOutputStream = null;
            fileInputStream = null;
            th = th2222;
            C2517m.m12571a(fileInputStream, "LogUpload Service");
            C2517m.m12571a(fileOutputStream, "LogUpload Service");
            throw th;
        }
        C2511g.m12481b("LogUpload Service", "encryptFile" + file3.getAbsolutePath());
        return file3;
    }

    public static byte[] m12450a(byte[] bArr, String str, int i) {
        try {
            return C2505a.m12448a(1, str).doFinal(bArr, 0, i);
        } catch (Exception e) {
            C2511g.m12481b("LogUpload Service", "AES:encrypt Exception");
            return new byte[0];
        }
    }

    private static Cipher m12448a(int i, String str) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CFB/NoPadding");
        instance.init(i, C2505a.m12449a(str), new IvParameterSpec(f8980a));
        return instance;
    }

    private static SecretKeySpec m12449a(String str) throws Exception {
        return new SecretKeySpec(C2505a.m12451b(str), "AES");
    }

    private static byte[] m12451b(String str) throws Exception {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes(GameManager.DEFAULT_CHARSET));
        return instance.digest();
    }
}
