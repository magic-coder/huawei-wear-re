package com.huawei.pluginaf500.connect_ble;

import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* compiled from: ScannerServiceParser */
public class C5788n {
    private static final String f19630a = "ScannerServiceParser".toString();
    private static C5788n f19631e;
    private static final Object f19632f = new Object();
    private int f19633b = 0;
    private boolean f19634c = false;
    private String f19635d;

    public static C5788n m26581a() {
        C5788n c5788n;
        synchronized (f19632f) {
            if (f19631e == null) {
                f19631e = new C5788n();
            }
            c5788n = f19631e;
        }
        return c5788n;
    }

    public boolean m26588b() {
        return this.f19634c;
    }

    public void m26587a(byte[] bArr, UUID uuid) throws Exception {
        int i = 0;
        this.f19634c = false;
        this.f19635d = uuid.toString();
        if (bArr != null) {
            this.f19633b = bArr.length;
            while (i < this.f19633b) {
                byte b = bArr[i];
                if (b != (byte) 0) {
                    int i2 = i + 1;
                    byte b2 = bArr[i2];
                    if (b2 == (byte) 2 || b2 == (byte) 3) {
                        for (i = i2 + 1; i < (i2 + b) - 1; i += 2) {
                            m26584b(bArr, i, 2);
                        }
                    } else if (b2 == (byte) 4 || b2 == (byte) 5) {
                        for (i = i2 + 1; i < (i2 + b) - 1; i += 4) {
                            m26585c(bArr, i, 4);
                        }
                    } else if (b2 == (byte) 6 || b2 == (byte) 7) {
                        for (i = i2 + 1; i < (i2 + b) - 1; i += 16) {
                            m26586d(bArr, i, 16);
                        }
                    }
                    i = ((b - 1) + i2) + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void m26584b(byte[] bArr, int i, int i2) throws Exception {
        if (Integer.toHexString(m26580a(bArr, i)).equals(this.f19635d.substring(4, 8))) {
            this.f19634c = true;
        }
    }

    private void m26585c(byte[] bArr, int i, int i2) throws Exception {
        if (Integer.toHexString(m26580a(bArr, (i + i2) - 4)).equals(this.f19635d.substring(4, 8))) {
            this.f19634c = true;
        }
    }

    private void m26586d(byte[] bArr, int i, int i2) throws Exception {
        if (Integer.toHexString(m26580a(bArr, (i + i2) - 4)).equals(this.f19635d.substring(4, 8))) {
            this.f19634c = true;
        }
    }

    private int m26580a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 0) | ((bArr[i + 1] & 255) << 8);
    }

    public static String m26582a(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            if (b == (byte) 0) {
                return null;
            }
            i++;
            byte b2 = bArr[i];
            if (b2 == (byte) 9 || b2 == (byte) 8) {
                return C5788n.m26583a(bArr, i + 1, b - 1);
            }
            i = (i + (b - 1)) + 1;
        }
        return null;
    }

    public static String m26583a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (IndexOutOfBoundsException e2) {
            return null;
        }
    }
}
