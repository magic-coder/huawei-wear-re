package com.google.tagmanager;

import java.util.Arrays;

/* compiled from: DataLayerPersistentStoreImpl */
class C3693s {
    final String f14354a;
    final byte[] f14355b;

    C3693s(String str, byte[] bArr) {
        this.f14354a = str;
        this.f14355b = bArr;
    }

    public String toString() {
        return "KeyAndSerialized: key = " + this.f14354a + " serialized hash = " + Arrays.hashCode(this.f14355b);
    }
}
