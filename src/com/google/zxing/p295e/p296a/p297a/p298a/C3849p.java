package com.google.zxing.p295e.p296a.p297a.p298a;

/* compiled from: DecodedInformation */
final class C3849p extends C3847r {
    private final String f14865a;
    private final int f14866b;
    private final boolean f14867c;

    C3849p(int i, String str) {
        super(i);
        this.f14865a = str;
        this.f14867c = false;
        this.f14866b = 0;
    }

    C3849p(int i, String str, int i2) {
        super(i);
        this.f14867c = true;
        this.f14866b = i2;
        this.f14865a = str;
    }

    String m19145a() {
        return this.f14865a;
    }

    boolean m19146b() {
        return this.f14867c;
    }

    int m19147c() {
        return this.f14866b;
    }
}
