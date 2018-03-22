package com.huawei.hwdatamigrate.common.p408a;

import java.util.Arrays;

/* compiled from: BaseNCodec */
class C4797c {
    int f17733a;
    long f17734b;
    byte[] f17735c;
    int f17736d;
    int f17737e;
    boolean f17738f;
    int f17739g;
    int f17740h;

    C4797c() {
    }

    public String toString() {
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{getClass().getSimpleName(), Arrays.toString(this.f17735c), Integer.valueOf(this.f17739g), Boolean.valueOf(this.f17738f), Integer.valueOf(this.f17733a), Long.valueOf(this.f17734b), Integer.valueOf(this.f17740h), Integer.valueOf(this.f17736d), Integer.valueOf(this.f17737e)});
    }
}
