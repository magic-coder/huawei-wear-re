package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.utils.p129b.C1335c;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class C1363g {
    public static String m6072a(File file) {
        Throwable th;
        String str = null;
        Closeable fileInputStream;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                str = C1335c.m5881a(instance.digest());
                C1345b.m5935a(fileInputStream);
            } catch (FileNotFoundException e) {
                try {
                    C1336d.m5888c("Sha256Util", "fail to get file sha256, ");
                    C1345b.m5935a(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C1345b.m5935a(fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                C1336d.m5888c("Sha256Util", "fail to get file sha256, ");
                C1345b.m5935a(fileInputStream);
                return str;
            } catch (NoSuchAlgorithmException e3) {
                C1336d.m5888c("Sha256Util", "fail to get file sha256, ");
                C1345b.m5935a(fileInputStream);
                return str;
            }
        } catch (FileNotFoundException e4) {
            Object obj = str;
            C1336d.m5888c("Sha256Util", "fail to get file sha256, ");
            C1345b.m5935a(fileInputStream);
            return str;
        } catch (IOException e5) {
            fileInputStream = str;
            C1336d.m5888c("Sha256Util", "fail to get file sha256, ");
            C1345b.m5935a(fileInputStream);
            return str;
        } catch (NoSuchAlgorithmException e6) {
            fileInputStream = str;
            C1336d.m5888c("Sha256Util", "fail to get file sha256, ");
            C1345b.m5935a(fileInputStream);
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = str;
            th = th4;
            C1345b.m5935a(fileInputStream);
            throw th;
        }
        return str;
    }
}
