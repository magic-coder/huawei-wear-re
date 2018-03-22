package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.api.C0384v;
import com.google.android.gms.common.api.C0385x;
import com.google.android.gms.common.api.C0386y;
import com.google.android.gms.common.api.C0387z;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.aa;
import com.google.android.gms.common.internal.C0424f;
import java.lang.ref.WeakReference;

public class zzabx<R extends C0366w> extends aa<R> implements C0385x<R> {
    private C0387z<? super R, ? extends C0366w> f896a;
    private zzabx<? extends C0366w> f897b;
    private volatile C0386y<? super R> f898c;
    private C0382t<R> f899d;
    private final Object f900e;
    private Status f901f;
    private final WeakReference<C0378p> f902g;
    private final zza f903h;
    private boolean f904i;

    final class zza extends Handler {
        final /* synthetic */ zzabx f895a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C0382t c0382t = (C0382t) message.obj;
                    synchronized (this.f895a.f900e) {
                        if (c0382t == null) {
                            this.f895a.f897b.m1640a(new Status(13, "Transform returned null"));
                        } else if (c0382t instanceof bx) {
                            this.f895a.f897b.m1640a(((bx) c0382t).m1120b());
                        } else {
                            this.f895a.f897b.m1652a(c0382t);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                    return;
            }
        }
    }

    private void m1640a(Status status) {
        synchronized (this.f900e) {
            this.f901f = status;
            m1645b(this.f901f);
        }
    }

    private void m1644b() {
        if (this.f896a != null || this.f898c != null) {
            C0378p c0378p = (C0378p) this.f902g.get();
            if (!(this.f904i || this.f896a == null || c0378p == null)) {
                c0378p.mo1840a(this);
                this.f904i = true;
            }
            if (this.f901f != null) {
                m1645b(this.f901f);
            } else if (this.f899d != null) {
                this.f899d.mo1849a((C0385x) this);
            }
        }
    }

    private void m1645b(Status status) {
        synchronized (this.f900e) {
            if (this.f896a != null) {
                Status a = this.f896a.m411a(status);
                C0424f.m650a((Object) a, (Object) "onFailure must not return null");
                this.f897b.m1640a(a);
            } else if (m1648c()) {
                this.f898c.m409a(status);
            }
        }
    }

    private void m1646b(C0366w c0366w) {
        if (c0366w instanceof C0384v) {
            try {
                ((C0384v) c0366w).mo1750a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c0366w);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean m1648c() {
        return (this.f898c == null || ((C0378p) this.f902g.get()) == null) ? false : true;
    }

    void m1651a() {
        this.f898c = null;
    }

    public void m1652a(C0382t<?> c0382t) {
        synchronized (this.f900e) {
            this.f899d = c0382t;
            m1644b();
        }
    }

    public void mo1899a(R r) {
        synchronized (this.f900e) {
            if (!r.getStatus().isSuccess()) {
                m1640a(r.getStatus());
                m1646b((C0366w) r);
            } else if (this.f896a != null) {
                bw.m1115a().submit(new cf(this, r));
            } else if (m1648c()) {
                this.f898c.m410b(r);
            }
        }
    }
}
