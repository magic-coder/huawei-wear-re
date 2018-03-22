package com.aps;

/* compiled from: Fence */
public class bf {
    public double f13018a = 0.0d;
    public double f13019b = 0.0d;
    public float f13020c = 0.0f;
    int f13021d = -1;
    private long f13022e = -1;

    public long m17405a() {
        return this.f13022e;
    }

    public void m17406a(long j) {
        if (j >= 0) {
            this.f13022e = bu.m17460b() + j;
        } else {
            this.f13022e = j;
        }
    }

    public String m17407b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f13018a).append("#").append(this.f13019b).append("#").append(this.f13020c);
        return stringBuilder.toString();
    }
}
