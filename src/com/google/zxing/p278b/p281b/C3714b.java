package com.google.zxing.p278b.p281b;

/* compiled from: GenericGFPoly */
final class C3714b {
    private final C3713a f14432a;
    private final int[] f14433b;

    C3714b(C3713a c3713a, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f14432a = c3713a;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f14433b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f14433b = c3713a.m18690a().f14433b;
            return;
        }
        this.f14433b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f14433b, 0, this.f14433b.length);
    }

    int m18698a() {
        return this.f14433b.length - 1;
    }

    boolean m18704b() {
        return this.f14433b[0] == 0;
    }

    int m18699a(int i) {
        return this.f14433b[(this.f14433b.length - 1) - i];
    }

    int m18702b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m18699a(0);
        }
        int length = this.f14433b.length;
        int i3;
        if (i == 1) {
            int[] iArr = this.f14433b;
            int length2 = iArr.length;
            i3 = 0;
            while (i2 < length2) {
                int b = C3713a.m18686b(i3, iArr[i2]);
                i2++;
                i3 = b;
            }
            return i3;
        }
        i3 = this.f14433b[0];
        i2 = 1;
        while (i2 < length) {
            b = C3713a.m18686b(this.f14432a.m18696c(i, i3), this.f14433b[i2]);
            i2++;
            i3 = b;
        }
        return i3;
    }

    C3714b m18701a(C3714b c3714b) {
        if (!this.f14432a.equals(c3714b.f14432a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m18704b()) {
            return c3714b;
        } else {
            if (c3714b.m18704b()) {
                return this;
            }
            Object obj = this.f14433b;
            Object obj2 = c3714b.f14433b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = C3713a.m18686b(r1[i - length], obj[i]);
            }
            return new C3714b(this.f14432a, obj4);
        }
    }

    C3714b m18703b(C3714b c3714b) {
        if (!this.f14432a.equals(c3714b.f14432a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m18704b() || c3714b.m18704b()) {
            return this.f14432a.m18690a();
        } else {
            int[] iArr = this.f14433b;
            int length = iArr.length;
            int[] iArr2 = c3714b.f14433b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = C3713a.m18686b(iArr3[i + i3], this.f14432a.m18696c(i2, iArr2[i3]));
                }
            }
            return new C3714b(this.f14432a, iArr3);
        }
    }

    C3714b m18705c(int i) {
        if (i == 0) {
            return this.f14432a.m18690a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f14433b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f14432a.m18696c(this.f14433b[i2], i);
        }
        return new C3714b(this.f14432a, iArr);
    }

    C3714b m18700a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f14432a.m18690a();
        } else {
            int length = this.f14433b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f14432a.m18696c(this.f14433b[i3], i2);
            }
            return new C3714b(this.f14432a, iArr);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m18698a() * 8);
        for (int a = m18698a(); a >= 0; a--) {
            int a2 = m18699a(a);
            if (a2 != 0) {
                if (a2 < 0) {
                    stringBuilder.append(" - ");
                    a2 = -a2;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (a == 0 || a2 != 1) {
                    a2 = this.f14432a.m18692b(a2);
                    if (a2 == 0) {
                        stringBuilder.append('1');
                    } else if (a2 == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a2);
                    }
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
