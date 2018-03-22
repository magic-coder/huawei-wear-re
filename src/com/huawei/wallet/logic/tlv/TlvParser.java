package com.huawei.wallet.logic.tlv;

import java.util.ArrayList;
import java.util.List;

public class TlvParser {

    class ParseResult {
        private final Tlv f21297a;
        private final int f21298b;

        public ParseResult(Tlv tlv, int i) {
            this.f21297a = tlv;
            this.f21298b = i;
        }

        public String toString() {
            return "ParseResult{tlv=" + this.f21297a + ", offset=" + this.f21298b + '}';
        }
    }

    public Tlvs m28088a(byte[] bArr, int i, int i2) {
        List arrayList = new ArrayList();
        if (i2 == 0) {
            return new Tlvs(arrayList);
        }
        int i3 = i;
        for (int i4 = 0; i4 < 100; i4++) {
            ParseResult a = m28082a(0, bArr, i3, i2 - i3);
            arrayList.add(a.f21297a);
            if (a.f21298b >= i + i2) {
                break;
            }
            i3 = a.f21298b;
        }
        return new Tlvs(arrayList);
    }

    private ParseResult m28082a(int i, byte[] bArr, int i2, int i3) {
        String a = m28084a(i);
        if (i2 + i3 > bArr.length) {
            throw new IllegalStateException("Length is out of the range [offset=" + i2 + ",  len=" + i3 + ", array.length=" + bArr.length + ", level=" + i + "]");
        }
        int a2 = m28081a(bArr, i2);
        TlvTag a3 = m28083a(a, bArr, i2, a2);
        int c = m28087c(bArr, i2 + a2);
        int b = m28086b(bArr, i2 + a2);
        if (a3.m28094a()) {
            List arrayList = new ArrayList();
            m28085a(i, bArr, i2, a, a2, c, b, arrayList);
            return new ParseResult(new Tlv(a3, arrayList), ((i2 + a2) + c) + b);
        }
        byte[] bArr2 = new byte[b];
        System.arraycopy(bArr, (i2 + a2) + c, bArr2, 0, b);
        return new ParseResult(new Tlv(a3, bArr2), ((i2 + a2) + c) + b);
    }

    private void m28085a(int i, byte[] bArr, int i2, String str, int i3, int i4, int i5, ArrayList<Tlv> arrayList) {
        int i6 = (i2 + i3) + i4;
        int i7 = i5;
        while (i6 < i2 + i5) {
            ParseResult a = m28082a(i + 1, bArr, i6, i7);
            arrayList.add(a.f21297a);
            i6 = a.f21298b;
            i7 = i5 - i6;
        }
    }

    private String m28084a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i * 4; i2++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    private TlvTag m28083a(String str, byte[] bArr, int i, int i2) {
        return new TlvTag(bArr, i, i2);
    }

    private int m28081a(byte[] bArr, int i) {
        if ((bArr[i] & 31) != 31) {
            return 1;
        }
        int i2 = 2;
        int i3 = i + 1;
        while (i3 < i + 10 && (bArr[i3] & 128) == 128) {
            i3++;
            i2++;
        }
        return i2;
    }

    private int m28086b(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if ((i2 & 128) == 128) {
            int i3 = i2 & 127;
            if (i3 > 3) {
                throw new IllegalStateException(String.format("At position %d the len is more then 3 [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i3)}));
            }
            i2 = 0;
            int i4 = i + 1;
            while (i4 < (i + 1) + i3) {
                int i5 = (bArr[i4] & 255) + (i2 * 256);
                i4++;
                i2 = i5;
            }
        }
        return i2;
    }

    private static int m28087c(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if ((i2 & 128) == 128) {
            return (i2 & 127) + 1;
        }
        return 1;
    }
}
