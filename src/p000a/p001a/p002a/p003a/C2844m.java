package p000a.p001a.p002a.p003a;

import android.os.Build.VERSION;
import android.os.Bundle;
import p000a.p001a.p002a.p003a.C2848p.C2843a;
import p000a.p001a.p002a.p003a.C2848p.C2843a.C2845a;

/* compiled from: RemoteInput */
public class C2844m extends C2843a {
    public static final C2845a f9215a = new C2846n();
    private static final C2839a f9216g;
    private final String f9217b;
    private final CharSequence f9218c;
    private final CharSequence[] f9219d;
    private final boolean f9220e;
    private final Bundle f9221f;

    /* compiled from: RemoteInput */
    interface C2839a {
    }

    /* compiled from: RemoteInput */
    class C2840b implements C2839a {
        C2840b() {
        }
    }

    /* compiled from: RemoteInput */
    class C2841c implements C2839a {
        C2841c() {
        }
    }

    /* compiled from: RemoteInput */
    class C2842d implements C2839a {
        C2842d() {
        }
    }

    public String mo3337a() {
        return this.f9217b;
    }

    public CharSequence mo3338b() {
        return this.f9218c;
    }

    public CharSequence[] mo3339c() {
        return this.f9219d;
    }

    public boolean mo3340d() {
        return this.f9220e;
    }

    public Bundle mo3341e() {
        return this.f9221f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f9216g = new C2840b();
        } else if (VERSION.SDK_INT >= 16) {
            f9216g = new C2842d();
        } else {
            f9216g = new C2841c();
        }
    }
}
