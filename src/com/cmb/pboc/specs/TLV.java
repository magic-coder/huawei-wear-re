package com.cmb.pboc.specs;

import java.util.Enumeration;
import java.util.Vector;

public class TLV {
    private int f13519a;
    private int f13520b;
    private int f13521c;
    private byte[] f13522d;
    private Vector f13523e = new Vector();
    private int f13524f;

    public TLV(byte[] bArr, int i) {
        int length = bArr.length;
        this.f13520b = 1;
        if (i < length) {
            int i2;
            int i3;
            int i4 = i + 1;
            this.f13519a = bArr[i] & 255;
            if (32 == (bArr[i4 - 1] & 32)) {
                this.f13520b = 0;
            }
            if (31 == (bArr[i4 - 1] & 31)) {
                this.f13519a <<= 8;
                i2 = i4 + 1;
                this.f13519a = (bArr[i4] & 255) + this.f13519a;
            } else {
                i2 = i4;
            }
            i4 = i2 + 1;
            i2 = bArr[i2] & 255;
            if (-128 == (bArr[i4 - 1] & -128)) {
                int i5 = bArr[i4 - 1] & 127;
                i2 = 0;
                i3 = 0;
                while (i3 < i5) {
                    i2 = (i2 << 8) + (bArr[i4] & 255);
                    i3++;
                    i4++;
                }
            }
            i3 = i4;
            i4 = i2;
            if (i3 + i4 <= length) {
                this.f13521c = i4;
                this.f13522d = new byte[i4];
                for (i2 = 0; i2 < i4; i2++) {
                    this.f13522d[i2] = bArr[i3 + i2];
                }
                this.f13524f = (i3 + i4) - i;
                if (this.f13520b == 0) {
                    i2 = 0;
                    while (i2 < this.f13522d.length) {
                        TLV tlv = new TLV(this.f13522d, i2);
                        this.f13523e.addElement(tlv);
                        i2 += tlv.f13524f;
                    }
                }
            }
        }
    }

    public final TLV m17794a(int i) {
        Enumeration elements = this.f13523e.elements();
        while (elements.hasMoreElements()) {
            TLV tlv = (TLV) elements.nextElement();
            if (tlv != null) {
                if (i == tlv.f13519a) {
                    return tlv;
                }
                if (this.f13520b == 0) {
                    tlv = tlv.m17794a(i);
                    if (tlv != null) {
                        return tlv;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final byte[] m17795a() {
        return this.f13522d;
    }
}
