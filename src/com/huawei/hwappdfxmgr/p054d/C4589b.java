package com.huawei.hwappdfxmgr.p054d;

import com.huawei.hwappdfxmgr.d.a;
import com.huawei.p190v.C2538c;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

/* compiled from: PRNGFixes */
public class C4589b extends SecureRandomSpi {
    private static final File f16803a = new File("/dev/urandom");
    private static final Object f16804b = new Object();
    private static DataInputStream f16805c;
    private static OutputStream f16806d;
    private boolean f16807e;

    protected void engineSetSeed(byte[] bArr) {
        OutputStream outputStream = null;
        try {
            synchronized (f16804b) {
                outputStream = m21864b();
            }
            outputStream.write(bArr);
            outputStream.flush();
            this.f16807e = true;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e2) {
            try {
                C2538c.e(a.class.getSimpleName(), new Object[]{"engineSetSeed Failed to mix seed into " + f16803a});
                this.f16807e = true;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                this.f16807e = true;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }
    }

    protected void engineNextBytes(byte[] bArr) {
        if (!this.f16807e) {
            engineSetSeed(a.b());
        }
        try {
            DataInputStream a;
            synchronized (f16804b) {
                a = m21863a();
            }
            synchronized (a) {
                a.readFully(bArr);
            }
        } catch (Throwable e) {
            throw new SecurityException("Failed to read from " + f16803a, e);
        }
    }

    protected byte[] engineGenerateSeed(int i) {
        byte[] bArr = new byte[i];
        engineNextBytes(bArr);
        return bArr;
    }

    private DataInputStream m21863a() {
        DataInputStream dataInputStream;
        synchronized (f16804b) {
            if (f16805c == null) {
                try {
                    f16805c = new DataInputStream(new FileInputStream(f16803a));
                } catch (Throwable e) {
                    throw new SecurityException("Failed to open " + f16803a + " for reading", e);
                }
            }
            dataInputStream = f16805c;
        }
        return dataInputStream;
    }

    private OutputStream m21864b() throws IOException {
        OutputStream outputStream;
        synchronized (f16804b) {
            if (f16806d == null) {
                f16806d = new FileOutputStream(f16803a);
            }
            outputStream = f16806d;
        }
        return outputStream;
    }
}
