package p000a.p001a.p002a.p003a;

import a.a.a.a.c;
import a.a.a.a.c.a;
import a.a.a.a.c.o;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: NotificationCompat */
public class c$d {
    Notification f0A;
    Notification f1B = new Notification();
    public ArrayList<String> f2C;
    Context f3a;
    CharSequence f4b;
    CharSequence f5c;
    PendingIntent f6d;
    PendingIntent f7e;
    RemoteViews f8f;
    Bitmap f9g;
    CharSequence f10h;
    int f11i;
    int f12j;
    boolean f13k = true;
    boolean f14l;
    o f15m;
    CharSequence f16n;
    int f17o;
    int f18p;
    boolean f19q;
    String f20r;
    boolean f21s;
    String f22t;
    ArrayList<a> f23u = new ArrayList();
    boolean f24v = false;
    String f25w;
    Bundle f26x;
    int f27y = 0;
    int f28z = 0;

    public c$d(Context context) {
        this.f3a = context;
        this.f1B.when = System.currentTimeMillis();
        this.f1B.audioStreamType = -1;
        this.f12j = 0;
        this.f2C = new ArrayList();
    }

    public c$d m2a(int i) {
        this.f1B.icon = i;
        return this;
    }

    public c$d m4a(CharSequence charSequence) {
        this.f4b = c$d.m1d(charSequence);
        return this;
    }

    public c$d m7b(CharSequence charSequence) {
        this.f5c = c$d.m1d(charSequence);
        return this;
    }

    public c$d m8c(CharSequence charSequence) {
        this.f1B.tickerText = c$d.m1d(charSequence);
        return this;
    }

    public c$d m3a(Bitmap bitmap) {
        this.f9g = bitmap;
        return this;
    }

    public c$d m5a(boolean z) {
        m0a(2, z);
        return this;
    }

    private void m0a(int i, boolean z) {
        if (z) {
            Notification notification = this.f1B;
            notification.flags |= i;
            return;
        }
        notification = this.f1B;
        notification.flags &= i ^ -1;
    }

    public Notification m6a() {
        return c.a().a(this);
    }

    protected static CharSequence m1d(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }
}
