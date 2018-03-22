package com.google.analytics.tracking.android;

import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: GAUsage */
class am {
    private static final am f14070d = new am();
    private SortedSet<an> f14071a = new TreeSet();
    private StringBuilder f14072b = new StringBuilder();
    private boolean f14073c = false;

    public static am m18240a() {
        return f14070d;
    }

    private am() {
    }

    public synchronized void m18242a(boolean z) {
        this.f14073c = z;
    }

    public synchronized void m18241a(an anVar) {
        if (!this.f14073c) {
            this.f14071a.add(anVar);
            this.f14072b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(anVar.ordinal()));
        }
    }

    public synchronized String m18243b() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.f14071a.size() > 0) {
            an anVar = (an) this.f14071a.first();
            this.f14071a.remove(anVar);
            int ordinal = anVar.ordinal();
            while (ordinal >= i) {
                stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (anVar.ordinal() % 6);
        }
        if (i2 > 0 || stringBuilder.length() == 0) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.f14071a.clear();
        return stringBuilder.toString();
    }

    public synchronized String m18244c() {
        String stringBuilder;
        if (this.f14072b.length() > 0) {
            this.f14072b.insert(0, ".");
        }
        stringBuilder = this.f14072b.toString();
        this.f14072b = new StringBuilder();
        return stringBuilder;
    }
}
