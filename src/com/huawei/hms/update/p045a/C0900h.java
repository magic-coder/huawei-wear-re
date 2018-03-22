package com.huawei.hms.update.p045a;

import com.huawei.hms.p039c.C0854c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* compiled from: RandomFileOutputStream */
public class C0900h extends OutputStream {
    private RandomAccessFile f1478a;

    public C0900h(File file, int i) throws FileNotFoundException, IOException {
        try {
            this.f1478a = new RandomAccessFile(file, "rwd");
            this.f1478a.setLength((long) i);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e2) {
            C0854c.m3008a(this.f1478a);
            throw e2;
        }
    }

    public void close() throws IOException {
        this.f1478a.close();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f1478a.write(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void m3162a(long j) throws IOException {
        this.f1478a.seek(j);
    }
}
