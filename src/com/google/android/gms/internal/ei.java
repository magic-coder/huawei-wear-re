package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class ei {
    private final ByteBuffer f743a;

    private ei(ByteBuffer byteBuffer) {
        this.f743a = byteBuffer;
        this.f743a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private ei(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m1346a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += m1347a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m1347a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m1348a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static ei m1349a(byte[] bArr) {
        return m1350a(bArr, 0, bArr.length);
    }

    public static ei m1350a(byte[] bArr, int i, int i2) {
        return new ei(bArr, i, i2);
    }

    private static void m1351a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m1348a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m1361b(charSequence, byteBuffer);
        }
    }

    public static int m1352b(int i, double d) {
        return m1371f(i) + 8;
    }

    public static int m1353b(int i, float f) {
        return m1371f(i) + 4;
    }

    public static int m1354b(int i, long j) {
        return m1371f(i) + m1359b(j);
    }

    public static int m1355b(int i, eq eqVar) {
        return (m1371f(i) * 2) + m1365c(eqVar);
    }

    public static int m1356b(int i, String str) {
        return m1371f(i) + m1360b(str);
    }

    public static int m1357b(int i, boolean z) {
        return m1371f(i) + 1;
    }

    public static int m1358b(int i, byte[] bArr) {
        return m1371f(i) + m1366c(bArr);
    }

    public static int m1359b(long j) {
        return m1369d(j);
    }

    public static int m1360b(String str) {
        int a = m1346a((CharSequence) str);
        return a + m1372h(a);
    }

    private static void m1361b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m1362c(int i) {
        return i >= 0 ? m1372h(i) : 10;
    }

    public static int m1363c(int i, int i2) {
        return m1371f(i) + m1362c(i2);
    }

    public static int m1364c(int i, eq eqVar) {
        return m1371f(i) + m1370d(eqVar);
    }

    public static int m1365c(eq eqVar) {
        return eqVar.m1287g();
    }

    public static int m1366c(byte[] bArr) {
        return m1372h(bArr.length) + bArr.length;
    }

    public static int m1367d(int i) {
        return m1372h(m1373j(i));
    }

    public static int m1368d(int i, int i2) {
        return m1371f(i) + m1367d(i2);
    }

    public static int m1369d(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static int m1370d(eq eqVar) {
        int g = eqVar.m1287g();
        return g + m1372h(g);
    }

    public static int m1371f(int i) {
        return m1372h(et.m1449a(i, 0));
    }

    public static int m1372h(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m1373j(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public int m1374a() {
        return this.f743a.remaining();
    }

    public void m1375a(byte b) throws IOException {
        if (this.f743a.hasRemaining()) {
            this.f743a.put(b);
            return;
        }
        throw new ej(this.f743a.position(), this.f743a.limit());
    }

    public void m1376a(double d) throws IOException {
        m1401e(Double.doubleToLongBits(d));
    }

    public void m1377a(float f) throws IOException {
        m1403i(Float.floatToIntBits(f));
    }

    public void m1378a(int i) throws IOException {
        if (i >= 0) {
            m1402g(i);
        } else {
            m1397c((long) i);
        }
    }

    public void m1379a(int i, double d) throws IOException {
        m1400e(i, 1);
        m1376a(d);
    }

    public void m1380a(int i, float f) throws IOException {
        m1400e(i, 5);
        m1377a(f);
    }

    public void m1381a(int i, int i2) throws IOException {
        m1400e(i, 0);
        m1378a(i2);
    }

    public void m1382a(int i, long j) throws IOException {
        m1400e(i, 0);
        m1387a(j);
    }

    public void m1383a(int i, eq eqVar) throws IOException {
        m1400e(i, 2);
        m1394b(eqVar);
    }

    public void m1384a(int i, String str) throws IOException {
        m1400e(i, 2);
        m1389a(str);
    }

    public void m1385a(int i, boolean z) throws IOException {
        m1400e(i, 0);
        m1390a(z);
    }

    public void m1386a(int i, byte[] bArr) throws IOException {
        m1400e(i, 2);
        m1395b(bArr);
    }

    public void m1387a(long j) throws IOException {
        m1397c(j);
    }

    public void m1388a(eq eqVar) throws IOException {
        eqVar.mo1871a(this);
    }

    public void m1389a(String str) throws IOException {
        try {
            int h = m1372h(str.length());
            if (h == m1372h(str.length() * 3)) {
                int position = this.f743a.position();
                if (this.f743a.remaining() < h) {
                    throw new ej(h + position, this.f743a.limit());
                }
                this.f743a.position(position + h);
                m1351a((CharSequence) str, this.f743a);
                int position2 = this.f743a.position();
                this.f743a.position(position);
                m1402g((position2 - position) - h);
                this.f743a.position(position2);
                return;
            }
            m1402g(m1346a((CharSequence) str));
            m1351a((CharSequence) str, this.f743a);
        } catch (Throwable e) {
            ej ejVar = new ej(this.f743a.position(), this.f743a.limit());
            ejVar.initCause(e);
            throw ejVar;
        }
    }

    public void m1390a(boolean z) throws IOException {
        m1399e(z ? 1 : 0);
    }

    public void m1391b() {
        if (m1374a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m1392b(int i) throws IOException {
        m1402g(m1373j(i));
    }

    public void m1393b(int i, int i2) throws IOException {
        m1400e(i, 0);
        m1392b(i2);
    }

    public void m1394b(eq eqVar) throws IOException {
        m1402g(eqVar.m1286f());
        eqVar.mo1871a(this);
    }

    public void m1395b(byte[] bArr) throws IOException {
        m1402g(bArr.length);
        m1398d(bArr);
    }

    public void m1396b(byte[] bArr, int i, int i2) throws IOException {
        if (this.f743a.remaining() >= i2) {
            this.f743a.put(bArr, i, i2);
            return;
        }
        throw new ej(this.f743a.position(), this.f743a.limit());
    }

    public void m1397c(long j) throws IOException {
        while ((-128 & j) != 0) {
            m1399e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m1399e((int) j);
    }

    public void m1398d(byte[] bArr) throws IOException {
        m1396b(bArr, 0, bArr.length);
    }

    public void m1399e(int i) throws IOException {
        m1375a((byte) i);
    }

    public void m1400e(int i, int i2) throws IOException {
        m1402g(et.m1449a(i, i2));
    }

    public void m1401e(long j) throws IOException {
        if (this.f743a.remaining() < 8) {
            throw new ej(this.f743a.position(), this.f743a.limit());
        }
        this.f743a.putLong(j);
    }

    public void m1402g(int i) throws IOException {
        while ((i & -128) != 0) {
            m1399e((i & 127) | 128);
            i >>>= 7;
        }
        m1399e(i);
    }

    public void m1403i(int i) throws IOException {
        if (this.f743a.remaining() < 4) {
            throw new ej(this.f743a.position(), this.f743a.limit());
        }
        this.f743a.putInt(i);
    }
}
