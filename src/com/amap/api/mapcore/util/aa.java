package com.amap.api.mapcore.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: FileAccessI */
class aa {
    RandomAccessFile f11376a;

    public aa() throws IOException {
        this("", 0);
    }

    public aa(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable e) {
                ca.m15831a(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        this.f11376a = new RandomAccessFile(str, "rw");
        this.f11376a.seek(j);
    }

    public synchronized int m15389a(byte[] bArr) throws IOException {
        this.f11376a.write(bArr);
        return bArr.length;
    }

    public void m15390a() {
        if (this.f11376a != null) {
            try {
                this.f11376a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f11376a = null;
        }
    }
}
