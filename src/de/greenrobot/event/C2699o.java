package de.greenrobot.event;

/* compiled from: Subscription */
final class C2699o {
    final Object f9153a;
    final C2697m f9154b;
    volatile boolean f9155c = true;

    C2699o(Object obj, C2697m c2697m) {
        this.f9153a = obj;
        this.f9154b = c2697m;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2699o)) {
            return false;
        }
        C2699o c2699o = (C2699o) obj;
        if (this.f9153a == c2699o.f9153a && this.f9154b.equals(c2699o.f9154b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f9153a.hashCode() + this.f9154b.f9150d.hashCode();
    }
}
