package com.huawei.hwid.update.p449a;

import com.huawei.hwid.p075d.C5207c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* compiled from: RandomFileOutputStream */
public class C5261g extends OutputStream {
    private RandomAccessFile f18927a;

    public C5261g(File file, int i) throws FileNotFoundException, IOException {
        try {
            this.f18927a = new RandomAccessFile(file, "rwd");
            this.f18927a.setLength((long) i);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e2) {
            C5207c.m25332a(this.f18927a);
            throw e2;
        }
    }

    public void close() throws IOException {
        this.f18927a.close();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f18927a.write(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void m25505a(long j) throws IOException {
        this.f18927a.seek(j);
    }
}
