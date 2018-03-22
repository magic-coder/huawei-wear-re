package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class eg extends ek<eg> {
    public byte[] f719a;
    public String f720b;
    public double f721c;
    public float f722d;
    public long f723e;
    public int f724f;
    public int f725g;
    public boolean f726h;
    public ee[] f727i;
    public ef[] f728j;
    public String[] f729k;
    public long[] f730l;
    public float[] f731m;
    public long f732n;

    public eg() {
        m1312a();
    }

    public eg m1312a() {
        this.f719a = et.f772l;
        this.f720b = "";
        this.f721c = 0.0d;
        this.f722d = 0.0f;
        this.f723e = 0;
        this.f724f = 0;
        this.f725g = 0;
        this.f726h = false;
        this.f727i = ee.m1300a();
        this.f728j = ef.m1306a();
        this.f729k = et.f770j;
        this.f730l = et.f766f;
        this.f731m = et.f767g;
        this.f732n = 0;
        this.o = null;
        this.p = -1;
        return this;
    }

    public eg m1313a(eh ehVar) throws IOException {
        while (true) {
            int a = ehVar.m1320a();
            int a2;
            Object obj;
            int d;
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.f719a = ehVar.m1336i();
                    continue;
                case 18:
                    this.f720b = ehVar.m1335h();
                    continue;
                case 25:
                    this.f721c = ehVar.m1326c();
                    continue;
                case 37:
                    this.f722d = ehVar.m1327d();
                    continue;
                case 40:
                    this.f723e = ehVar.m1329e();
                    continue;
                case 48:
                    this.f724f = ehVar.m1331f();
                    continue;
                case 56:
                    this.f725g = ehVar.m1337j();
                    continue;
                case 64:
                    this.f726h = ehVar.m1334g();
                    continue;
                case 74:
                    a2 = et.m1450a(ehVar, 74);
                    a = this.f727i == null ? 0 : this.f727i.length;
                    obj = new ee[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.f727i, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new ee();
                        ehVar.m1322a(obj[a]);
                        ehVar.m1320a();
                        a++;
                    }
                    obj[a] = new ee();
                    ehVar.m1322a(obj[a]);
                    this.f727i = obj;
                    continue;
                case 82:
                    a2 = et.m1450a(ehVar, 82);
                    a = this.f728j == null ? 0 : this.f728j.length;
                    obj = new ef[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.f728j, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new ef();
                        ehVar.m1322a(obj[a]);
                        ehVar.m1320a();
                        a++;
                    }
                    obj[a] = new ef();
                    ehVar.m1322a(obj[a]);
                    this.f728j = obj;
                    continue;
                case 90:
                    a2 = et.m1450a(ehVar, 90);
                    a = this.f729k == null ? 0 : this.f729k.length;
                    obj = new String[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.f729k, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = ehVar.m1335h();
                        ehVar.m1320a();
                        a++;
                    }
                    obj[a] = ehVar.m1335h();
                    this.f729k = obj;
                    continue;
                case 96:
                    a2 = et.m1450a(ehVar, 96);
                    a = this.f730l == null ? 0 : this.f730l.length;
                    obj = new long[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.f730l, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = ehVar.m1329e();
                        ehVar.m1320a();
                        a++;
                    }
                    obj[a] = ehVar.m1329e();
                    this.f730l = obj;
                    continue;
                case 98:
                    d = ehVar.m1328d(ehVar.m1338k());
                    a2 = ehVar.m1344q();
                    a = 0;
                    while (ehVar.m1342o() > 0) {
                        ehVar.m1329e();
                        a++;
                    }
                    ehVar.m1332f(a2);
                    a2 = this.f730l == null ? 0 : this.f730l.length;
                    Object obj2 = new long[(a + a2)];
                    if (a2 != 0) {
                        System.arraycopy(this.f730l, 0, obj2, 0, a2);
                    }
                    while (a2 < obj2.length) {
                        obj2[a2] = ehVar.m1329e();
                        a2++;
                    }
                    this.f730l = obj2;
                    ehVar.m1330e(d);
                    continue;
                case 104:
                    this.f732n = ehVar.m1329e();
                    continue;
                case 114:
                    a = ehVar.m1338k();
                    a2 = ehVar.m1328d(a);
                    d = a / 4;
                    a = this.f731m == null ? 0 : this.f731m.length;
                    Object obj3 = new float[(d + a)];
                    if (a != 0) {
                        System.arraycopy(this.f731m, 0, obj3, 0, a);
                    }
                    while (a < obj3.length) {
                        obj3[a] = ehVar.m1327d();
                        a++;
                    }
                    this.f731m = obj3;
                    ehVar.m1330e(a2);
                    continue;
                case 117:
                    a2 = et.m1450a(ehVar, 117);
                    a = this.f731m == null ? 0 : this.f731m.length;
                    obj = new float[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.f731m, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = ehVar.m1327d();
                        ehVar.m1320a();
                        a++;
                    }
                    obj[a] = ehVar.m1327d();
                    this.f731m = obj;
                    continue;
                default:
                    if (!super.m1290a(ehVar, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void mo1871a(ei eiVar) throws IOException {
        int i = 0;
        if (!Arrays.equals(this.f719a, et.f772l)) {
            eiVar.m1386a(1, this.f719a);
        }
        if (!(this.f720b == null || this.f720b.equals(""))) {
            eiVar.m1384a(2, this.f720b);
        }
        if (Double.doubleToLongBits(this.f721c) != Double.doubleToLongBits(0.0d)) {
            eiVar.m1379a(3, this.f721c);
        }
        if (Float.floatToIntBits(this.f722d) != Float.floatToIntBits(0.0f)) {
            eiVar.m1380a(4, this.f722d);
        }
        if (this.f723e != 0) {
            eiVar.m1382a(5, this.f723e);
        }
        if (this.f724f != 0) {
            eiVar.m1381a(6, this.f724f);
        }
        if (this.f725g != 0) {
            eiVar.m1393b(7, this.f725g);
        }
        if (this.f726h) {
            eiVar.m1385a(8, this.f726h);
        }
        if (this.f727i != null && this.f727i.length > 0) {
            for (eq eqVar : this.f727i) {
                if (eqVar != null) {
                    eiVar.m1383a(9, eqVar);
                }
            }
        }
        if (this.f728j != null && this.f728j.length > 0) {
            for (eq eqVar2 : this.f728j) {
                if (eqVar2 != null) {
                    eiVar.m1383a(10, eqVar2);
                }
            }
        }
        if (this.f729k != null && this.f729k.length > 0) {
            for (String str : this.f729k) {
                if (str != null) {
                    eiVar.m1384a(11, str);
                }
            }
        }
        if (this.f730l != null && this.f730l.length > 0) {
            for (long a : this.f730l) {
                eiVar.m1382a(12, a);
            }
        }
        if (this.f732n != 0) {
            eiVar.m1382a(13, this.f732n);
        }
        if (this.f731m != null && this.f731m.length > 0) {
            while (i < this.f731m.length) {
                eiVar.m1380a(14, this.f731m[i]);
                i++;
            }
        }
        super.mo1871a(eiVar);
    }

    protected int mo1872b() {
        int i;
        int i2 = 0;
        int b = super.mo1872b();
        if (!Arrays.equals(this.f719a, et.f772l)) {
            b += ei.m1358b(1, this.f719a);
        }
        if (!(this.f720b == null || this.f720b.equals(""))) {
            b += ei.m1356b(2, this.f720b);
        }
        if (Double.doubleToLongBits(this.f721c) != Double.doubleToLongBits(0.0d)) {
            b += ei.m1352b(3, this.f721c);
        }
        if (Float.floatToIntBits(this.f722d) != Float.floatToIntBits(0.0f)) {
            b += ei.m1353b(4, this.f722d);
        }
        if (this.f723e != 0) {
            b += ei.m1354b(5, this.f723e);
        }
        if (this.f724f != 0) {
            b += ei.m1363c(6, this.f724f);
        }
        if (this.f725g != 0) {
            b += ei.m1368d(7, this.f725g);
        }
        if (this.f726h) {
            b += ei.m1357b(8, this.f726h);
        }
        if (this.f727i != null && this.f727i.length > 0) {
            i = b;
            for (eq eqVar : this.f727i) {
                if (eqVar != null) {
                    i += ei.m1364c(9, eqVar);
                }
            }
            b = i;
        }
        if (this.f728j != null && this.f728j.length > 0) {
            i = b;
            for (eq eqVar2 : this.f728j) {
                if (eqVar2 != null) {
                    i += ei.m1364c(10, eqVar2);
                }
            }
            b = i;
        }
        if (this.f729k != null && this.f729k.length > 0) {
            int i3 = 0;
            int i4 = 0;
            for (String str : this.f729k) {
                if (str != null) {
                    i4++;
                    i3 += ei.m1360b(str);
                }
            }
            b = (b + i3) + (i4 * 1);
        }
        if (this.f730l != null && this.f730l.length > 0) {
            i = 0;
            while (i2 < this.f730l.length) {
                i += ei.m1359b(this.f730l[i2]);
                i2++;
            }
            b = (b + i) + (this.f730l.length * 1);
        }
        if (this.f732n != 0) {
            b += ei.m1354b(13, this.f732n);
        }
        return (this.f731m == null || this.f731m.length <= 0) ? b : (b + (this.f731m.length * 4)) + (this.f731m.length * 1);
    }

    public /* synthetic */ eq mo1875b(eh ehVar) throws IOException {
        return m1313a(ehVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eg)) {
            return false;
        }
        eg egVar = (eg) obj;
        if (!Arrays.equals(this.f719a, egVar.f719a)) {
            return false;
        }
        if (this.f720b == null) {
            if (egVar.f720b != null) {
                return false;
            }
        } else if (!this.f720b.equals(egVar.f720b)) {
            return false;
        }
        return (Double.doubleToLongBits(this.f721c) == Double.doubleToLongBits(egVar.f721c) && Float.floatToIntBits(this.f722d) == Float.floatToIntBits(egVar.f722d) && this.f723e == egVar.f723e && this.f724f == egVar.f724f && this.f725g == egVar.f725g && this.f726h == egVar.f726h && eo.m1432a(this.f727i, egVar.f727i) && eo.m1432a(this.f728j, egVar.f728j) && eo.m1432a(this.f729k, egVar.f729k) && eo.m1431a(this.f730l, egVar.f730l) && eo.m1430a(this.f731m, egVar.f731m) && this.f732n == egVar.f732n) ? (this.o == null || this.o.m1419b()) ? egVar.o == null || egVar.o.m1419b() : this.o.equals(egVar.o) : false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f720b == null ? 0 : this.f720b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f719a)) * 31);
        long doubleToLongBits = Double.doubleToLongBits(this.f721c);
        hashCode = ((((((((((((((this.f726h ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.f722d)) * 31) + ((int) (this.f723e ^ (this.f723e >>> 32)))) * 31) + this.f724f) * 31) + this.f725g) * 31)) * 31) + eo.m1428a(this.f727i)) * 31) + eo.m1428a(this.f728j)) * 31) + eo.m1428a(this.f729k)) * 31) + eo.m1427a(this.f730l)) * 31) + eo.m1426a(this.f731m)) * 31) + ((int) (this.f732n ^ (this.f732n >>> 32)))) * 31;
        if (!(this.o == null || this.o.m1419b())) {
            i = this.o.hashCode();
        }
        return hashCode + i;
    }
}
