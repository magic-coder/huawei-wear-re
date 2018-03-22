package com.tencent.open.p532d;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
public final class C6389a {
    private static final ab f22211a = new ab(101010256);
    private static final ac f22212b = new ac(38651);

    public static String m29169a(File file, String str) throws IOException {
        Throwable th;
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] a = C6389a.m29170a(randomAccessFile);
                if (a != null) {
                    C6391c c6391c = new C6391c();
                    c6391c.m29175a(a);
                    str2 = c6391c.f22218a.getProperty(str);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } else if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            randomAccessFile = null;
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String m29168a(File file) throws IOException {
        return C6389a.m29169a(file, "channelNo");
    }

    private static byte[] m29170a(RandomAccessFile randomAccessFile) throws IOException {
        int i = 1;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a = f22211a.m29171a();
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == a[0] && randomAccessFile.read() == a[1] && randomAccessFile.read() == a[2] && randomAccessFile.read() == a[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((16 + length) + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        i = new ac(bArr).m29174b();
        if (i == 0) {
            return null;
        }
        bArr = new byte[i];
        randomAccessFile.read(bArr);
        return bArr;
    }
}
