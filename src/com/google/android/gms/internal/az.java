package com.google.android.gms.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.C0389b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0344b;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.util.C0456a;
import com.google.android.gms.common.util.C0467l;
import com.google.android.gms.p015b.C0358b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class az implements Callback {
    public static final Status f570a = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status f571b = new Status(4, "The user must be signed in to make this API call.");
    private static final Object f572f = new Object();
    private static az f573g;
    private long f574c = 5000;
    private long f575d = 120000;
    private long f576e = 10000;
    private final Context f577h;
    private final C0389b f578i;
    private int f579j = -1;
    private final AtomicInteger f580k = new AtomicInteger(1);
    private final AtomicInteger f581l = new AtomicInteger(0);
    private final Map<ez<?>, bb<?>> f582m = new ConcurrentHashMap(5, 0.75f, 1);
    private ad f583n = null;
    private final Set<ez<?>> f584o = new C0456a();
    private final Set<ez<?>> f585p = new C0456a();
    private final Handler f586q;

    private az(Context context, Looper looper, C0389b c0389b) {
        this.f577h = context;
        this.f586q = new Handler(looper, this);
        this.f578i = c0389b;
        this.f586q.sendMessage(this.f586q.obtainMessage(6));
    }

    public static az m1001a() {
        az azVar;
        synchronized (f572f) {
            C0424f.m650a(f573g, (Object) "Must guarantee manager is non-null before using getInstance");
            azVar = f573g;
        }
        return azVar;
    }

    public static az m1002a(Context context) {
        az azVar;
        synchronized (f572f) {
            if (f573g == null) {
                f573g = new az(context.getApplicationContext(), m1014f(), C0389b.m424a());
            }
            azVar = f573g;
        }
        return azVar;
    }

    @WorkerThread
    private void m1003a(int i, ConnectionResult connectionResult) {
        for (bb bbVar : this.f582m.values()) {
            if (bbVar.m1067l() == i) {
                break;
            }
        }
        bb bbVar2 = null;
        if (bbVar2 != null) {
            String valueOf = String.valueOf(this.f578i.mo1749c(connectionResult.getErrorCode()));
            String valueOf2 = String.valueOf(connectionResult.getErrorMessage());
            bbVar2.m1053a(new Status(17, new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(valueOf2).length()).append("Error resolution was canceled by the user, original error message: ").append(valueOf).append(": ").append(valueOf2).toString()));
            return;
        }
        Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
    }

    @WorkerThread
    private void m1004a(bt btVar) {
        bb bbVar = (bb) this.f582m.get(btVar.f630c.m344b());
        if (bbVar == null) {
            m1008b(btVar.f630c);
            bbVar = (bb) this.f582m.get(btVar.f630c.m344b());
        }
        if (!bbVar.m1066k() || this.f581l.get() == btVar.f629b) {
            bbVar.m1055a(btVar.f628a);
            return;
        }
        btVar.f628a.mo1876a(f570a);
        bbVar.m1048a();
    }

    @WorkerThread
    private void m1005a(C0497c c0497c) {
        for (ez ezVar : c0497c.m1131a()) {
            bb bbVar = (bb) this.f582m.get(ezVar);
            if (bbVar == null) {
                c0497c.m1132a(ezVar, new ConnectionResult(13));
                return;
            } else if (bbVar.m1065j()) {
                c0497c.m1132a(ezVar, ConnectionResult.zzayj);
            } else if (bbVar.m1060e() != null) {
                c0497c.m1132a(ezVar, bbVar.m1060e());
            } else {
                bbVar.m1054a(c0497c);
            }
        }
    }

    @WorkerThread
    private void m1006a(boolean z) {
        this.f576e = z ? 10000 : LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
        this.f586q.removeMessages(12);
        for (ez obtainMessage : this.f582m.keySet()) {
            this.f586q.sendMessageDelayed(this.f586q.obtainMessage(12, obtainMessage), this.f576e);
        }
    }

    @WorkerThread
    private void m1008b(ad<?> adVar) {
        ez b = adVar.m344b();
        bb bbVar = (bb) this.f582m.get(b);
        if (bbVar == null) {
            bbVar = new bb(this, adVar);
            this.f582m.put(b, bbVar);
        }
        if (bbVar.m1066k()) {
            this.f585p.add(b);
        }
        bbVar.m1064i();
    }

    private static Looper m1014f() {
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        return handlerThread.getLooper();
    }

    @WorkerThread
    private void m1017g() {
        C0467l.m825a();
        if (this.f577h.getApplicationContext() instanceof Application) {
            C0498d.m1184a((Application) this.f577h.getApplicationContext());
            C0498d.m1183a().m1186a(new ba(this));
            if (!C0498d.m1183a().m1187a(true)) {
                this.f576e = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
            }
        }
    }

    @WorkerThread
    private void m1019h() {
        for (bb bbVar : this.f582m.values()) {
            bbVar.m1059d();
            bbVar.m1064i();
        }
    }

    @WorkerThread
    private void m1021i() {
        for (ez remove : this.f585p) {
            ((bb) this.f582m.remove(remove)).m1048a();
        }
        this.f585p.clear();
    }

    PendingIntent m1023a(ez<?> ezVar, int i) {
        if (((bb) this.f582m.get(ezVar)) == null) {
            return null;
        }
        dk m = ((bb) this.f582m.get(ezVar)).m1068m();
        return m == null ? null : PendingIntent.getActivity(this.f577h, i, m.m367g(), HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }

    public C0358b<Void> m1024a(Iterable<? extends ad<?>> iterable) {
        C0497c c0497c = new C0497c(iterable);
        for (ad b : iterable) {
            bb bbVar = (bb) this.f582m.get(b.m344b());
            if (bbVar != null) {
                if (!bbVar.m1065j()) {
                }
            }
            this.f586q.sendMessage(this.f586q.obtainMessage(2, c0497c));
            return c0497c.m1133b();
        }
        c0497c.m1134c();
        return c0497c.m1133b();
    }

    public void m1025a(ad<?> adVar) {
        this.f586q.sendMessage(this.f586q.obtainMessage(7, adVar));
    }

    public <O extends C0344b> void m1026a(ad<O> adVar, int i, C0503g<? extends C0366w, C0370g> c0503g) {
        this.f586q.sendMessage(this.f586q.obtainMessage(4, new bt(new ew(i, c0503g), this.f581l.get(), adVar)));
    }

    public void m1027a(@NonNull ad adVar) {
        synchronized (f572f) {
            if (this.f583n != adVar) {
                this.f583n = adVar;
                this.f584o.clear();
                this.f584o.addAll(adVar.m891e());
            }
        }
    }

    boolean m1028a(ConnectionResult connectionResult, int i) {
        return this.f578i.m439a(this.f577h, connectionResult, i);
    }

    public int m1029b() {
        return this.f580k.getAndIncrement();
    }

    public void m1030b(ConnectionResult connectionResult, int i) {
        if (!m1028a(connectionResult, i)) {
            this.f586q.sendMessage(this.f586q.obtainMessage(5, i, 0, connectionResult));
        }
    }

    void m1031b(@NonNull ad adVar) {
        synchronized (f572f) {
            if (this.f583n == adVar) {
                this.f583n = null;
                this.f584o.clear();
            }
        }
    }

    public void m1032c() {
        this.f586q.sendMessage(this.f586q.obtainMessage(3));
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                m1006a(((Boolean) message.obj).booleanValue());
                break;
            case 2:
                m1005a((C0497c) message.obj);
                break;
            case 3:
                m1019h();
                break;
            case 4:
            case 8:
            case 13:
                m1004a((bt) message.obj);
                break;
            case 5:
                m1003a(message.arg1, (ConnectionResult) message.obj);
                break;
            case 6:
                m1017g();
                break;
            case 7:
                m1008b((ad) message.obj);
                break;
            case 9:
                if (this.f582m.containsKey(message.obj)) {
                    ((bb) this.f582m.get(message.obj)).m1061f();
                    break;
                }
                break;
            case 10:
                m1021i();
                break;
            case 11:
                if (this.f582m.containsKey(message.obj)) {
                    ((bb) this.f582m.get(message.obj)).m1062g();
                    break;
                }
                break;
            case 12:
                if (this.f582m.containsKey(message.obj)) {
                    ((bb) this.f582m.get(message.obj)).m1063h();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
