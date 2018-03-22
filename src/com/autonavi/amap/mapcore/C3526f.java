package com.autonavi.amap.mapcore;

/* compiled from: VTMCDataCache */
class C3526f {
    byte[] f13288a;
    String f13289b;
    int f13290c;
    String f13291d;
    int f13292e;

    public C3526f(byte[] bArr) {
        try {
            this.f13290c = (int) (System.currentTimeMillis() / 1000);
            byte b = bArr[4];
            this.f13289b = new String(bArr, 5, b);
            int i = b + 5;
            int i2 = i + 1;
            b = bArr[i];
            this.f13291d = new String(bArr, i2, b);
            i = b + i2;
            this.f13292e = Convert.getInt(bArr, i);
            i += 4;
            this.f13288a = bArr;
        } catch (Exception e) {
            this.f13288a = null;
        }
    }

    public void m17638a(int i) {
        if (this.f13288a != null) {
            this.f13290c = (int) (System.currentTimeMillis() / 1000);
            int i2 = this.f13288a[4] + 5;
            Convert.writeInt(this.f13288a, this.f13288a[i2] + (i2 + 1), i);
            this.f13292e = i;
        }
    }
}
