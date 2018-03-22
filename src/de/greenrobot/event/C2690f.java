package de.greenrobot.event;

/* compiled from: EventBus */
/* synthetic */ class C2690f {
    static final /* synthetic */ int[] f9133a = new int[C2700p.values().length];

    static {
        try {
            f9133a[C2700p.PostThread.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9133a[C2700p.MainThread.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9133a[C2700p.BackgroundThread.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9133a[C2700p.Async.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
