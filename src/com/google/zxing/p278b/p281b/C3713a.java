package com.google.zxing.p278b.p281b;

import com.unionpay.tsmservice.data.Constant;

/* compiled from: GenericGF */
public final class C3713a {
    public static final C3713a f14416a = new C3713a(4201, 4096, 1);
    public static final C3713a f14417b = new C3713a(Constant.CALLBACK_GET_ACTIVE_CODE, 1024, 1);
    public static final C3713a f14418c = new C3713a(67, 64, 1);
    public static final C3713a f14419d = new C3713a(19, 16, 1);
    public static final C3713a f14420e = new C3713a(285, 256, 0);
    public static final C3713a f14421f = new C3713a(301, 256, 1);
    public static final C3713a f14422g = f14421f;
    public static final C3713a f14423h = f14418c;
    private int[] f14424i;
    private int[] f14425j;
    private C3714b f14426k;
    private C3714b f14427l;
    private final int f14428m;
    private final int f14429n;
    private final int f14430o;
    private boolean f14431p = false;

    public C3713a(int i, int i2, int i3) {
        this.f14429n = i;
        this.f14428m = i2;
        this.f14430o = i3;
        if (i2 <= 0) {
            m18687e();
        }
    }

    private void m18687e() {
        int i;
        this.f14424i = new int[this.f14428m];
        this.f14425j = new int[this.f14428m];
        int i2 = 1;
        for (i = 0; i < this.f14428m; i++) {
            this.f14424i[i] = i2;
            i2 <<= 1;
            if (i2 >= this.f14428m) {
                i2 = (i2 ^ this.f14429n) & (this.f14428m - 1);
            }
        }
        for (i = 0; i < this.f14428m - 1; i++) {
            this.f14425j[this.f14424i[i]] = i;
        }
        this.f14426k = new C3714b(this, new int[1]);
        this.f14427l = new C3714b(this, new int[]{1});
        this.f14431p = true;
    }

    private void m18688f() {
        if (!this.f14431p) {
            m18687e();
        }
    }

    C3714b m18690a() {
        m18688f();
        return this.f14426k;
    }

    C3714b m18693b() {
        m18688f();
        return this.f14427l;
    }

    C3714b m18691a(int i, int i2) {
        m18688f();
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f14426k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C3714b(this, iArr);
        }
    }

    static int m18686b(int i, int i2) {
        return i ^ i2;
    }

    int m18689a(int i) {
        m18688f();
        return this.f14424i[i];
    }

    int m18692b(int i) {
        m18688f();
        if (i != 0) {
            return this.f14425j[i];
        }
        throw new IllegalArgumentException();
    }

    int m18695c(int i) {
        m18688f();
        if (i != 0) {
            return this.f14424i[(this.f14428m - this.f14425j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int m18696c(int i, int i2) {
        m18688f();
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f14424i[(this.f14425j[i] + this.f14425j[i2]) % (this.f14428m - 1)];
    }

    public int m18694c() {
        return this.f14428m;
    }

    public int m18697d() {
        return this.f14430o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f14429n) + ',' + this.f14428m + ')';
    }
}
