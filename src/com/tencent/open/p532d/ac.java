package com.tencent.open.p532d;

import android.support.v4.view.MotionEventCompat;

/* compiled from: ProGuard */
public final class ac implements Cloneable {
    private int f22217a;

    public ac(byte[] bArr) {
        this(bArr, 0);
    }

    public ac(byte[] bArr, int i) {
        this.f22217a = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f22217a += bArr[i] & 255;
    }

    public ac(int i) {
        this.f22217a = i;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ac) && this.f22217a == ((ac) obj).m29174b()) {
            return true;
        }
        return false;
    }

    public byte[] m29173a() {
        return new byte[]{(byte) (this.f22217a & 255), (byte) ((this.f22217a & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int m29174b() {
        return this.f22217a;
    }

    public int hashCode() {
        return this.f22217a;
    }
}
