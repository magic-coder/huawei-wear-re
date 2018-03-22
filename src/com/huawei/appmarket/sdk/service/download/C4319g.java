package com.huawei.appmarket.sdk.service.download;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class C4319g extends RandomAccessFile {
    public C4319g(File file, String str) throws FileNotFoundException {
        super(file, str);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            super.write(bArr, i, i2);
        } catch (Exception e) {
            throw new C4320h(this, e);
        }
    }
}
