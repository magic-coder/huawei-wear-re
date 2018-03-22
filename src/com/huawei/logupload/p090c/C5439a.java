package com.huawei.logupload.p090c;

import android.os.Environment;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.logupload.c.f;
import com.huawei.logupload.c.h;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES */
public class C5439a {
    private static final byte[] f19271a = new byte[]{TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102};
    private static String f19272b = "+kTSSQbOlEBvQA3jZLxRfydVaWGS5AoGADS0p/+hWnuXHS78YJOX47VRNq86bU6CAR4q3jv7ihMkEJvtQQxA0/eLwILKBNBA1ar1bkDxsoZCTJE7zM3II2DbiaWQOvPZ1p+VPRJ3vnpnP14JbRr7glCV1ZjU6gL55EGb6v+Oid+xmg9QSkrJzCaByOEaCZ24Izxjg80HhrRY=";

    public static String m26085a() {
        return f19272b;
    }

    public static File m26084a(File file, String str) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable th;
        File file2 = null;
        if (!(file == null || str == null)) {
            String stringBuilder = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath())).append("/phoneservice/").toString();
            f.b("LogUpload Service", "filePath" + stringBuilder);
            File file3 = new File(stringBuilder);
            if (!file3.exists()) {
                f.b("LogUpload Service", "文件夹不存在，创建文件夹");
                if (!file3.mkdirs()) {
                    f.b("LogUpload Service", "文件夹不存在，创建文件夹失败");
                }
            }
            stringBuilder = file3.getAbsolutePath() + "/" + file.getName();
            f.b("LogUpload Service", "local_file" + stringBuilder);
            File file4 = new File(stringBuilder);
            if (file4.exists()) {
                f.b("LogUpload Service", "创建文件失败，需要创建的文件已存在");
                if (file4.delete()) {
                    f.b("LogUpload Service", "encrypfile is deleted successfully!");
                } else {
                    f.b("LogUpload Service", "encrypfile is deleted failed!");
                }
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    f.b("LogUpload Service", "encrypfile" + file4.getAbsolutePath());
                    fileOutputStream = new FileOutputStream(file4);
                    try {
                        byte[] bArr = new byte[1024];
                        while (fileInputStream.read(bArr) > 0) {
                            byte[] a = C5439a.m26088a(bArr, str);
                            if (a != null) {
                                fileOutputStream.write(a, 0, a.length);
                            }
                        }
                        h.a(fileInputStream, "LogUpload Service");
                        h.a(fileOutputStream, "LogUpload Service");
                        file2 = file4;
                    } catch (FileNotFoundException e) {
                    } catch (IOException e2) {
                    }
                } catch (FileNotFoundException e3) {
                    fileOutputStream = null;
                    try {
                        f.b("LogUpload Service", "FileNotFound");
                        h.a(fileInputStream, "LogUpload Service");
                        h.a(fileOutputStream, "LogUpload Service");
                        if (file2 != null) {
                            f.b("LogUpload Service", "encryptFile" + file2.getAbsolutePath());
                        }
                        return file2;
                    } catch (Throwable th2) {
                        th = th2;
                        h.a(fileInputStream, "LogUpload Service");
                        h.a(fileOutputStream, "LogUpload Service");
                        throw th;
                    }
                } catch (IOException e4) {
                    fileOutputStream = null;
                    f.b("LogUpload Service", "IOException");
                    h.a(fileInputStream, "LogUpload Service");
                    h.a(fileOutputStream, "LogUpload Service");
                    if (file2 != null) {
                        f.b("LogUpload Service", "encryptFile" + file2.getAbsolutePath());
                    }
                    return file2;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    fileOutputStream = null;
                    th = th4;
                    h.a(fileInputStream, "LogUpload Service");
                    h.a(fileOutputStream, "LogUpload Service");
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                fileOutputStream = null;
                fileInputStream = null;
                f.b("LogUpload Service", "FileNotFound");
                h.a(fileInputStream, "LogUpload Service");
                h.a(fileOutputStream, "LogUpload Service");
                if (file2 != null) {
                    f.b("LogUpload Service", "encryptFile" + file2.getAbsolutePath());
                }
                return file2;
            } catch (IOException e6) {
                fileOutputStream = null;
                fileInputStream = null;
                f.b("LogUpload Service", "IOException");
                h.a(fileInputStream, "LogUpload Service");
                h.a(fileOutputStream, "LogUpload Service");
                if (file2 != null) {
                    f.b("LogUpload Service", "encryptFile" + file2.getAbsolutePath());
                }
                return file2;
            } catch (Throwable th32) {
                fileInputStream = null;
                th = th32;
                fileOutputStream = null;
                h.a(fileInputStream, "LogUpload Service");
                h.a(fileOutputStream, "LogUpload Service");
                throw th;
            }
            if (file2 != null) {
                f.b("LogUpload Service", "encryptFile" + file2.getAbsolutePath());
            }
        }
        return file2;
    }

    public static byte[] m26088a(byte[] bArr, String str) {
        try {
            return C5439a.m26086a(1, str).doFinal(bArr);
        } catch (Exception e) {
            f.b("LogUpload Service", "AES:encrypt Exception");
            return new byte[0];
        }
    }

    private static Cipher m26086a(int i, String str) {
        Cipher instance = Cipher.getInstance("AES/CFB/NoPadding");
        instance.init(i, C5439a.m26087a(str), new IvParameterSpec(f19271a));
        return instance;
    }

    private static SecretKeySpec m26087a(String str) {
        byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < bytes.length && i < bArr.length) {
            bArr[i] = bytes[i];
            i++;
        }
        return new SecretKeySpec(bArr, "AES");
    }
}
