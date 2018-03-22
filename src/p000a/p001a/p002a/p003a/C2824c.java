package p000a.p001a.p002a.p003a;

import a.a.a.a.c.d;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p001a.p002a.p003a.C2828e.C2827a;
import p000a.p001a.p002a.p003a.C2830f.C2829a;
import p000a.p001a.p002a.p003a.C2831g.C2809a;
import p000a.p001a.p002a.p003a.C2831g.C2809a.C2825a;
import p000a.p001a.p002a.p003a.C2836k.C2835a;
import p000a.p001a.p002a.p003a.C2838l.C2837a;
import p000a.p001a.p002a.p003a.C2848p.C2843a;

/* compiled from: NotificationCompat */
public class C2824c {
    private static final C2815f f9201a;

    /* compiled from: NotificationCompat */
    public class C2810a extends C2809a {
        public static final C2825a f9187d = new C2826d();
        public int f9188a;
        public CharSequence f9189b;
        public PendingIntent f9190c;
        private final Bundle f9191e;
        private final C2844m[] f9192f;

        public /* synthetic */ C2843a[] mo3333f() {
            return m12891e();
        }

        protected int mo3329a() {
            return this.f9188a;
        }

        protected CharSequence mo3330b() {
            return this.f9189b;
        }

        protected PendingIntent mo3331c() {
            return this.f9190c;
        }

        public Bundle mo3332d() {
            return this.f9191e;
        }

        public C2844m[] m12891e() {
            return this.f9192f;
        }
    }

    /* compiled from: NotificationCompat */
    public abstract class C2811o {
        CharSequence f9193d;
        CharSequence f9194e;
        boolean f9195f = false;
    }

    /* compiled from: NotificationCompat */
    public class C2812b extends C2811o {
        Bitmap f9196a;
        Bitmap f9197b;
        boolean f9198c;
    }

    /* compiled from: NotificationCompat */
    public class C2813c extends C2811o {
        CharSequence f9199a;
    }

    /* compiled from: NotificationCompat */
    public class C2814e extends C2811o {
        ArrayList<CharSequence> f9200a = new ArrayList();
    }

    /* compiled from: NotificationCompat */
    interface C2815f {
        Notification mo3334a(d dVar);
    }

    /* compiled from: NotificationCompat */
    class C2816i implements C2815f {
        C2816i() {
        }

        public Notification mo3334a(d dVar) {
            Notification notification = dVar.B;
            notification.setLatestEventInfo(dVar.a, dVar.b, dVar.c, dVar.d);
            if (dVar.j > 0) {
                notification.flags |= 128;
            }
            return notification;
        }
    }

    /* compiled from: NotificationCompat */
    class C2817m extends C2816i {
        C2817m() {
        }

        public Notification mo3334a(d dVar) {
            C2808b c2835a = new C2835a(dVar.a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.l, dVar.j, dVar.n, dVar.v, dVar.x, dVar.r, dVar.s, dVar.t);
            C2824c.m12905b((C2807a) c2835a, dVar.u);
            C2824c.m12906b(c2835a, dVar.m);
            return c2835a.m12919b();
        }
    }

    /* compiled from: NotificationCompat */
    class C2818n extends C2817m {
        C2818n() {
        }

        public Notification mo3334a(d dVar) {
            C2808b c2837a = new C2837a(dVar.a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.C, dVar.x, dVar.r, dVar.s, dVar.t);
            C2824c.m12905b((C2807a) c2837a, dVar.u);
            C2824c.m12906b(c2837a, dVar.m);
            return c2837a.m12928b();
        }
    }

    /* compiled from: NotificationCompat */
    class C2819g extends C2818n {
        C2819g() {
        }

        public Notification mo3334a(d dVar) {
            C2808b c2827a = new C2827a(dVar.a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.C, dVar.x, dVar.r, dVar.s, dVar.t);
            C2824c.m12905b((C2807a) c2827a, dVar.u);
            C2824c.m12906b(c2827a, dVar.m);
            return c2827a.m12909b();
        }
    }

    /* compiled from: NotificationCompat */
    class C2820h extends C2819g {
        C2820h() {
        }

        public Notification mo3334a(d dVar) {
            C2808b c2829a = new C2829a(dVar.a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.w, dVar.C, dVar.x, dVar.y, dVar.z, dVar.A, dVar.r, dVar.s, dVar.t);
            C2824c.m12905b((C2807a) c2829a, dVar.u);
            C2824c.m12906b(c2829a, dVar.m);
            return c2829a.m12913b();
        }
    }

    /* compiled from: NotificationCompat */
    class C2821j extends C2816i {
        C2821j() {
        }

        public Notification mo3334a(d dVar) {
            Notification notification = dVar.B;
            notification.setLatestEventInfo(dVar.a, dVar.b, dVar.c, dVar.d);
            notification = C2832h.m12914a(notification, dVar.a, dVar.b, dVar.c, dVar.d, dVar.e);
            if (dVar.j > 0) {
                notification.flags |= 128;
            }
            return notification;
        }
    }

    /* compiled from: NotificationCompat */
    class C2822k extends C2816i {
        C2822k() {
        }

        public Notification mo3334a(d dVar) {
            return C2833i.m12915a(dVar.a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g);
        }
    }

    /* compiled from: NotificationCompat */
    class C2823l extends C2816i {
        C2823l() {
        }

        public Notification mo3334a(d dVar) {
            return C2834j.m12916a(dVar.a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q);
        }
    }

    private static void m12905b(C2807a c2807a, ArrayList<C2810a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c2807a.mo3336a((C2810a) it.next());
        }
    }

    private static void m12906b(C2808b c2808b, C2811o c2811o) {
        if (c2811o == null) {
            return;
        }
        if (c2811o instanceof C2813c) {
            C2813c c2813c = (C2813c) c2811o;
            C2836k.m12924a(c2808b, c2813c.d, c2813c.f, c2813c.e, c2813c.f9199a);
        } else if (c2811o instanceof C2814e) {
            C2814e c2814e = (C2814e) c2811o;
            C2836k.m12925a(c2808b, c2814e.d, c2814e.f, c2814e.e, c2814e.f9200a);
        } else if (c2811o instanceof C2812b) {
            C2812b c2812b = (C2812b) c2811o;
            C2836k.m12923a(c2808b, c2812b.d, c2812b.f, c2812b.e, c2812b.f9196a, c2812b.f9197b, c2812b.f9198c);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f9201a = new C2820h();
        } else if (VERSION.SDK_INT >= 20) {
            f9201a = new C2819g();
        } else if (VERSION.SDK_INT >= 19) {
            f9201a = new C2818n();
        } else if (VERSION.SDK_INT >= 16) {
            f9201a = new C2817m();
        } else if (VERSION.SDK_INT >= 14) {
            f9201a = new C2823l();
        } else if (VERSION.SDK_INT >= 11) {
            f9201a = new C2822k();
        } else if (VERSION.SDK_INT >= 9) {
            f9201a = new C2821j();
        } else {
            f9201a = new C2816i();
        }
    }
}
