package com.google.zxing.p299f.p300a.p301a;

/* compiled from: ModulusPoly */
final class C3883c {
    private final C3882b f14986a;
    private final int[] f14987b;

    C3883c(C3882b c3882b, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f14986a = c3882b;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f14987b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f14987b = c3882b.m19319a().f14987b;
            return;
        }
        this.f14987b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f14987b, 0, this.f14987b.length);
    }

    int m19328a() {
        return this.f14987b.length - 1;
    }

    boolean m19334b() {
        return this.f14987b[0] == 0;
    }

    int m19329a(int i) {
        return this.f14987b[(this.f14987b.length - 1) - i];
    }

    int m19332b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m19329a(0);
        }
        int length = this.f14987b.length;
        int i3;
        if (i == 1) {
            int[] iArr = this.f14987b;
            int length2 = iArr.length;
            i3 = 0;
            while (i2 < length2) {
                i2++;
                i3 = this.f14986a.m19322b(i3, iArr[i2]);
            }
            return i3;
        }
        i3 = this.f14987b[0];
        i2 = 1;
        while (i2 < length) {
            int b = this.f14986a.m19322b(this.f14986a.m19327d(i, i3), this.f14987b[i2]);
            i2++;
            i3 = b;
        }
        return i3;
    }

    C3883c m19331a(C3883c c3883c) {
        if (!this.f14986a.equals(c3883c.f14986a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (m19334b()) {
            return c3883c;
        } else {
            if (c3883c.m19334b()) {
                return this;
            }
            Object obj = this.f14987b;
            Object obj2 = c3883c.f14987b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = this.f14986a.m19322b(r1[i - length], obj[i]);
            }
            return new C3883c(this.f14986a, obj4);
        }
    }

    C3883c m19333b(C3883c c3883c) {
        if (this.f14986a.equals(c3883c.f14986a)) {
            return c3883c.m19334b() ? this : m19331a(c3883c.m19335c());
        } else {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
    }

    C3883c m19337c(C3883c c3883c) {
        if (!this.f14986a.equals(c3883c.f14986a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (m19334b() || c3883c.m19334b()) {
            return this.f14986a.m19319a();
        } else {
            int[] iArr = this.f14987b;
            int length = iArr.length;
            int[] iArr2 = c3883c.f14987b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = this.f14986a.m19322b(iArr3[i + i3], this.f14986a.m19327d(i2, iArr2[i3]));
                }
            }
            return new C3883c(this.f14986a, iArr3);
        }
    }

    C3883c m19335c() {
        int length = this.f14987b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f14986a.m19326c(0, this.f14987b[i]);
        }
        return new C3883c(this.f14986a, iArr);
    }

    C3883c m19336c(int i) {
        if (i == 0) {
            return this.f14986a.m19319a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f14987b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f14986a.m19327d(this.f14987b[i2], i);
        }
        return new C3883c(this.f14986a, iArr);
    }

    C3883c m19330a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f14986a.m19319a();
        } else {
            int length = this.f14987b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f14986a.m19327d(this.f14987b[i3], i2);
            }
            return new C3883c(this.f14986a, iArr);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m19328a() * 8);
        for (int a = m19328a(); a >= 0; a--) {
            int a2 = m19329a(a);
            if (a2 != 0) {
                if (a2 < 0) {
                    stringBuilder.append(" - ");
                    a2 = -a2;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (a == 0 || a2 != 1) {
                    stringBuilder.append(a2);
                }
                if (a != 0) {
                    if (a == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(a);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
