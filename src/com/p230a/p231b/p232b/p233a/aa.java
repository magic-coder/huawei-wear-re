package com.p230a.p231b.p232b.p233a;

final class aa implements Runnable {
    private final C3115m f10398a;
    private final C3118p f10399b;
    private final Runnable f10400c;

    public aa(C3115m c3115m, C3118p c3118p, Runnable runnable) {
        this.f10398a = c3115m;
        this.f10399b = c3118p;
        this.f10400c = runnable;
    }

    public final void run() {
        if (this.f10398a.m13884i()) {
            this.f10398a.m13877b("canceled-at-delivery");
            return;
        }
        if (this.f10399b.m13904a()) {
            this.f10398a.mo3664a(this.f10399b.f10465a);
        } else {
            this.f10398a.m13876b(this.f10399b.f10467c);
        }
        if (this.f10399b.f10468d) {
            this.f10398a.m13873a("intermediate-response");
        } else {
            this.f10398a.m13877b("done");
        }
        if (this.f10400c != null) {
            this.f10400c.run();
        }
    }
}
