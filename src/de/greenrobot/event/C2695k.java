package de.greenrobot.event;

/* compiled from: PendingPostQueue */
final class C2695k {
    private C2694j f9141a;
    private C2694j f9142b;

    C2695k() {
    }

    synchronized void m12850a(C2694j c2694j) {
        if (c2694j == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (this.f9142b != null) {
            this.f9142b.f9140c = c2694j;
            this.f9142b = c2694j;
        } else if (this.f9141a == null) {
            this.f9142b = c2694j;
            this.f9141a = c2694j;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }

    synchronized C2694j m12848a() {
        C2694j c2694j;
        c2694j = this.f9141a;
        if (this.f9141a != null) {
            this.f9141a = this.f9141a.f9140c;
            if (this.f9141a == null) {
                this.f9142b = null;
            }
        }
        return c2694j;
    }

    synchronized C2694j m12849a(int i) throws InterruptedException {
        if (this.f9141a == null) {
            wait((long) i);
        }
        return m12848a();
    }
}
