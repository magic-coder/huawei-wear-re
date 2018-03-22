package com.p230a.p231b.p232b.p233a;

final class C3122y implements Runnable {
    private /* synthetic */ C3105d f10471a;
    private final /* synthetic */ C3115m f10472b;

    C3122y(C3105d c3105d, C3115m c3115m) {
        this.f10471a = c3105d;
        this.f10472b = c3115m;
    }

    public final void run() {
        try {
            this.f10471a.f10418c.put(this.f10472b);
        } catch (InterruptedException e) {
        }
    }
}
