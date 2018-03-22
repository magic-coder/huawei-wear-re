package com.amap.api.mapcore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: FileCopy */
public class ab {

    /* compiled from: FileCopy */
    public interface C3270a {
        void mo4047a(String str, String str2);

        void mo4048a(String str, String str2, float f);

        void mo4049a(String str, String str2, int i);

        void mo4050b(String str, String str2);
    }

    public long m15396a(File file, File file2, long j, long j2, C3270a c3270a) {
        Exception e;
        if (j == 0) {
            System.err.println("sizeOfDirectory is the total Size,  must be a positive number");
            if (c3270a != null) {
                c3270a.mo4049a("", "", -1);
            }
            return 0;
        }
        long j3;
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        try {
            if (!file.isDirectory()) {
                File parentFile = file2.getParentFile();
                if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                    if (c3270a != null && j <= 0) {
                        c3270a.mo4047a(absolutePath, absolutePath2);
                    }
                    InputStream fileInputStream = new FileInputStream(file);
                    OutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    j3 = j;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        j = j3 + ((long) read);
                        if (c3270a != null) {
                            c3270a.mo4048a(absolutePath, absolutePath2, m15395a(j, j2));
                            j3 = j;
                        } else {
                            j3 = j;
                        }
                    }
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (c3270a == null || j3 < j2 - 1) {
                        return j3;
                    }
                    c3270a.mo4050b(absolutePath, absolutePath2);
                    return j3;
                }
                throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
            } else if (file2.exists() || file2.mkdirs()) {
                String[] list = file.list();
                if (list == null) {
                    return j;
                }
                int i = 0;
                j3 = j;
                while (i < list.length) {
                    try {
                        j3 = m15396a(new File(file, list[i]), new File(file2, list[i]), j3, j2, c3270a);
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                return j3;
            } else {
                throw new IOException("Cannot create dir " + file2.getAbsolutePath());
            }
        } catch (Exception e3) {
            e = e3;
            j3 = j;
        }
        e.printStackTrace();
        if (c3270a == null) {
            return j3;
        }
        c3270a.mo4049a(absolutePath, absolutePath2, -1);
        return j3;
    }

    private float m15395a(long j, long j2) {
        return (((float) j) / ((float) j2)) * 100.0f;
    }
}
