package de.greenrobot.event;

/* compiled from: AsyncPoster */
class C2685a implements Runnable {
    private final C2695k f9110a = new C2695k();
    private final C2687c f9111b;

    C2685a(C2687c c2687c) {
        this.f9111b = c2687c;
    }

    public void m12829a(C2699o c2699o, Object obj) {
        this.f9110a.m12850a(C2694j.m12846a(c2699o, obj));
        C2687c.f9115a.execute(this);
    }

    public void run() {
        C2694j a = this.f9110a.m12848a();
        if (a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f9111b.m12839a(a);
    }
}
