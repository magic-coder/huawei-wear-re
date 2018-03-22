package com.google.zxing;

import com.google.zxing.p278b.C3712a;
import com.google.zxing.p278b.C3717b;

/* compiled from: BinaryBitmap */
public final class C3740c {
    private final C3723b f14536a;
    private C3717b f14537b;

    public C3740c(C3723b c3723b) {
        if (c3723b == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f14536a = c3723b;
    }

    public int m18818a() {
        return this.f14536a.m18744c();
    }

    public int m18820b() {
        return this.f14536a.m18745d();
    }

    public C3712a m18819a(int i, C3712a c3712a) throws C3932i {
        return this.f14536a.mo4305a(i, c3712a);
    }

    public C3717b m18821c() throws C3932i {
        if (this.f14537b == null) {
            this.f14537b = this.f14536a.mo4307b();
        }
        return this.f14537b;
    }

    public boolean m18822d() {
        return this.f14536a.m18742a().m19084d();
    }

    public C3740c m18823e() {
        return new C3740c(this.f14536a.mo4306a(this.f14536a.m18742a().m19085e()));
    }
}
