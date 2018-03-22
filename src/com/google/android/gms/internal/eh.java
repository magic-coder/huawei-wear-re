package com.google.android.gms.internal;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.IOException;

public final class eh {
    private final byte[] f733a;
    private int f734b;
    private int f735c;
    private int f736d;
    private int f737e;
    private int f738f;
    private int f739g = Integer.MAX_VALUE;
    private int f740h;
    private int f741i = 64;
    private int f742j = HwAccountConstants.FLAG_TRANSLUCENT_STATUS;

    private eh(byte[] bArr, int i, int i2) {
        this.f733a = bArr;
        this.f734b = i;
        this.f735c = i + i2;
        this.f737e = i;
    }

    public static eh m1317a(byte[] bArr, int i, int i2) {
        return new eh(bArr, i, i2);
    }

    public static int m1318c(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    private void m1319s() {
        this.f735c += this.f736d;
        int i = this.f735c;
        if (i > this.f739g) {
            this.f736d = i - this.f739g;
            this.f735c -= this.f736d;
            return;
        }
        this.f736d = 0;
    }

    public int m1320a() throws IOException {
        if (m1343p()) {
            this.f738f = 0;
            return 0;
        }
        this.f738f = m1338k();
        if (this.f738f != 0) {
            return this.f738f;
        }
        throw ep.m1436d();
    }

    public void m1321a(int i) throws ep {
        if (this.f738f != i) {
            throw ep.m1437e();
        }
    }

    public void m1322a(eq eqVar) throws IOException {
        int k = m1338k();
        if (this.f740h >= this.f741i) {
            throw ep.m1439g();
        }
        k = m1328d(k);
        this.f740h++;
        eqVar.mo1875b(this);
        m1321a(0);
        this.f740h--;
        m1330e(k);
    }

    public byte[] m1323a(int i, int i2) {
        if (i2 == 0) {
            return et.f772l;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f733a, this.f734b + i, obj, 0, i2);
        return obj;
    }

    public void m1324b() throws IOException {
        int a;
        do {
            a = m1320a();
            if (a == 0) {
                return;
            }
        } while (m1325b(a));
    }

    public boolean m1325b(int i) throws IOException {
        switch (et.m1448a(i)) {
            case 0:
                m1331f();
                return true;
            case 1:
                m1341n();
                return true;
            case 2:
                m1333g(m1338k());
                return true;
            case 3:
                m1324b();
                m1321a(et.m1449a(et.m1451b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m1340m();
                return true;
            default:
                throw ep.m1438f();
        }
    }

    public double m1326c() throws IOException {
        return Double.longBitsToDouble(m1341n());
    }

    public float m1327d() throws IOException {
        return Float.intBitsToFloat(m1340m());
    }

    public int m1328d(int i) throws ep {
        if (i < 0) {
            throw ep.m1434b();
        }
        int i2 = this.f737e + i;
        int i3 = this.f739g;
        if (i2 > i3) {
            throw ep.m1433a();
        }
        this.f739g = i2;
        m1319s();
        return i3;
    }

    public long m1329e() throws IOException {
        return m1339l();
    }

    public void m1330e(int i) {
        this.f739g = i;
        m1319s();
    }

    public int m1331f() throws IOException {
        return m1338k();
    }

    public void m1332f(int i) {
        if (i > this.f737e - this.f734b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f737e - this.f734b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f737e = this.f734b + i;
        }
    }

    public void m1333g(int i) throws IOException {
        if (i < 0) {
            throw ep.m1434b();
        } else if (this.f737e + i > this.f739g) {
            m1333g(this.f739g - this.f737e);
            throw ep.m1433a();
        } else if (i <= this.f735c - this.f737e) {
            this.f737e += i;
        } else {
            throw ep.m1433a();
        }
    }

    public boolean m1334g() throws IOException {
        return m1338k() != 0;
    }

    public String m1335h() throws IOException {
        int k = m1338k();
        if (k < 0) {
            throw ep.m1434b();
        } else if (k > this.f735c - this.f737e) {
            throw ep.m1433a();
        } else {
            String str = new String(this.f733a, this.f737e, k, eo.f756a);
            this.f737e = k + this.f737e;
            return str;
        }
    }

    public byte[] m1336i() throws IOException {
        int k = m1338k();
        if (k < 0) {
            throw ep.m1434b();
        } else if (k == 0) {
            return et.f772l;
        } else {
            if (k > this.f735c - this.f737e) {
                throw ep.m1433a();
            }
            Object obj = new byte[k];
            System.arraycopy(this.f733a, this.f737e, obj, 0, k);
            this.f737e = k + this.f737e;
            return obj;
        }
    }

    public int m1337j() throws IOException {
        return m1318c(m1338k());
    }

    public int m1338k() throws IOException {
        byte r = m1345r();
        if (r >= (byte) 0) {
            return r;
        }
        int i = r & 127;
        byte r2 = m1345r();
        if (r2 >= (byte) 0) {
            return i | (r2 << 7);
        }
        i |= (r2 & 127) << 7;
        r2 = m1345r();
        if (r2 >= (byte) 0) {
            return i | (r2 << 14);
        }
        i |= (r2 & 127) << 14;
        r2 = m1345r();
        if (r2 >= (byte) 0) {
            return i | (r2 << 21);
        }
        i |= (r2 & 127) << 21;
        r2 = m1345r();
        i |= r2 << 28;
        if (r2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m1345r() >= (byte) 0) {
                return i;
            }
        }
        throw ep.m1435c();
    }

    public long m1339l() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte r = m1345r();
            j |= ((long) (r & 127)) << i;
            if ((r & 128) == 0) {
                return j;
            }
        }
        throw ep.m1435c();
    }

    public int m1340m() throws IOException {
        return (((m1345r() & 255) | ((m1345r() & 255) << 8)) | ((m1345r() & 255) << 16)) | ((m1345r() & 255) << 24);
    }

    public long m1341n() throws IOException {
        byte r = m1345r();
        byte r2 = m1345r();
        return ((((((((((long) r2) & 255) << 8) | (((long) r) & 255)) | ((((long) m1345r()) & 255) << 16)) | ((((long) m1345r()) & 255) << 24)) | ((((long) m1345r()) & 255) << 32)) | ((((long) m1345r()) & 255) << 40)) | ((((long) m1345r()) & 255) << 48)) | ((((long) m1345r()) & 255) << 56);
    }

    public int m1342o() {
        if (this.f739g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f739g - this.f737e;
    }

    public boolean m1343p() {
        return this.f737e == this.f735c;
    }

    public int m1344q() {
        return this.f737e - this.f734b;
    }

    public byte m1345r() throws IOException {
        if (this.f737e == this.f735c) {
            throw ep.m1433a();
        }
        byte[] bArr = this.f733a;
        int i = this.f737e;
        this.f737e = i + 1;
        return bArr[i];
    }
}
