package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.C0388h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0377o;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzf<T extends IInterface> {
    public static final String[] f364d = new String[]{"service_esmobile", "service_googleme"};
    final Handler f365a;
    protected C0434r f366b;
    protected AtomicInteger f367c = new AtomicInteger(0);
    private int f368e;
    private long f369f;
    private long f370g;
    private int f371h;
    private long f372i;
    private final Context f373j;
    private final Looper f374k;
    private final aj f375l;
    private final C0388h f376m;
    private final Object f377n = new Object();
    private final Object f378o = new Object();
    private ax f379p;
    private T f380q;
    private final ArrayList<C0432q<?>> f381r = new ArrayList();
    private C0439t f382s;
    private int f383t = 1;
    private final C0418o f384u;
    private final C0419p f385v;
    private final int f386w;
    private final String f387x;

    final class zzd extends Handler {
        final /* synthetic */ zzf f460a;

        public zzd(zzf com_google_android_gms_common_internal_zzf, Looper looper) {
            this.f460a = com_google_android_gms_common_internal_zzf;
            super(looper);
        }

        private void m774a(Message message) {
            ((C0432q) message.obj).m684c();
        }

        private boolean m775b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.f460a.f367c.get() != message.arg1) {
                if (m775b(message)) {
                    m774a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.f460a.m551c()) {
                m774a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.f460a.f366b.mo1777a(connectionResult);
                this.f460a.m544a(connectionResult);
            } else if (message.what == 4) {
                this.f460a.m529a(4, null);
                if (this.f460a.f384u != null) {
                    this.f460a.f384u.mo1762a(message.arg2);
                }
                this.f460a.m540a(message.arg2);
                this.f460a.m531a(4, 1, null);
            } else if (message.what == 2 && !this.f460a.m550b()) {
                m774a(message);
            } else if (m775b(message)) {
                ((C0432q) message.obj).m683b();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    protected zzf(Context context, Looper looper, aj ajVar, C0388h c0388h, int i, C0418o c0418o, C0419p c0419p, String str) {
        this.f373j = (Context) C0424f.m650a((Object) context, (Object) "Context must not be null");
        this.f374k = (Looper) C0424f.m650a((Object) looper, (Object) "Looper must not be null");
        this.f375l = (aj) C0424f.m650a((Object) ajVar, (Object) "Supervisor must not be null");
        this.f376m = (C0388h) C0424f.m650a((Object) c0388h, (Object) "API availability must not be null");
        this.f365a = new zzd(this, looper);
        this.f386w = i;
        this.f384u = c0418o;
        this.f385v = c0419p;
        this.f387x = str;
    }

    private void m529a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        C0424f.m657b(z);
        synchronized (this.f377n) {
            this.f383t = i;
            this.f380q = t;
            switch (i) {
                case 1:
                    m537x();
                    break;
                case 2:
                    mo1775k();
                    break;
                case 3:
                    m543a((IInterface) t);
                    break;
            }
        }
    }

    private boolean m531a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f377n) {
            if (this.f383t != i) {
                z = false;
            } else {
                m529a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private void mo1775k() {
        if (this.f382s != null) {
            String valueOf = String.valueOf(mo1773i());
            String valueOf2 = String.valueOf(f_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f375l.m597b(mo1773i(), f_(), this.f382s, m559m());
            this.f367c.incrementAndGet();
        }
        this.f382s = new C0439t(this, this.f367c.get());
        if (!this.f375l.m595a(mo1773i(), f_(), this.f382s, m559m())) {
            valueOf = String.valueOf(mo1773i());
            valueOf2 = String.valueOf(f_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            m541a(16, null, this.f367c.get());
        }
    }

    private void m537x() {
        if (this.f382s != null) {
            this.f375l.m597b(mo1773i(), f_(), this.f382s, m559m());
            this.f382s = null;
        }
    }

    @Nullable
    protected abstract T mo1772a(IBinder iBinder);

    public void m539a() {
        this.f367c.incrementAndGet();
        synchronized (this.f381r) {
            int size = this.f381r.size();
            for (int i = 0; i < size; i++) {
                ((C0432q) this.f381r.get(i)).m685d();
            }
            this.f381r.clear();
        }
        synchronized (this.f378o) {
            this.f379p = null;
        }
        m529a(1, null);
    }

    @CallSuper
    protected void m540a(int i) {
        this.f368e = i;
        this.f369f = System.currentTimeMillis();
    }

    protected void m541a(int i, @Nullable Bundle bundle, int i2) {
        this.f365a.sendMessage(this.f365a.obtainMessage(5, i2, -1, new C0442w(this, i, bundle)));
    }

    protected void mo2009a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f365a.sendMessage(this.f365a.obtainMessage(1, i2, -1, new C0441v(this, i, iBinder, bundle)));
    }

    @CallSuper
    protected void m543a(@NonNull T t) {
        this.f370g = System.currentTimeMillis();
    }

    @CallSuper
    protected void m544a(ConnectionResult connectionResult) {
        this.f371h = connectionResult.getErrorCode();
        this.f372i = System.currentTimeMillis();
    }

    @WorkerThread
    public void m545a(ao aoVar, Set<Scope> set) {
        Throwable e;
        zzj zzp = new zzj(this.f386w).zzdm(this.f373j.getPackageName()).zzp(mo1870r());
        if (set != null) {
            zzp.zzf((Collection) set);
        }
        if (mo1868d()) {
            zzp.zzf(m563q()).zzb(aoVar);
        } else if (m568v()) {
            zzp.zzf(mo1759o());
        }
        zzp.zza(mo1760p());
        try {
            synchronized (this.f378o) {
                if (this.f379p != null) {
                    this.f379p.mo1770a(new C0435s(this, this.f367c.get()), zzp);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (Throwable e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            m549b(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException e4) {
            e2 = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            mo2009a(8, null, null, this.f367c.get());
        } catch (RuntimeException e5) {
            e2 = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            mo2009a(8, null, null, this.f367c.get());
        }
    }

    public void mo2010a(@NonNull C0434r c0434r) {
        this.f366b = (C0434r) C0424f.m650a((Object) c0434r, (Object) "Connection progress callbacks cannot be null.");
        m529a(2, null);
    }

    public void m547a(@NonNull C0434r c0434r, int i, @Nullable PendingIntent pendingIntent) {
        this.f366b = (C0434r) C0424f.m650a((Object) c0434r, (Object) "Connection progress callbacks cannot be null.");
        this.f365a.sendMessage(this.f365a.obtainMessage(3, this.f367c.get(), i, pendingIntent));
    }

    public void m548a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f377n) {
            int i = this.f383t;
            IInterface iInterface = this.f380q;
        }
        synchronized (this.f378o) {
            ax axVar = this.f379p;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(mo1774j()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (axVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(axVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f370g > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f370g;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f370g)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(HwAccountConstants.BLANK).append(valueOf).toString());
        }
        if (this.f369f > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f368e) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f368e));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.f369f;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f369f)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(HwAccountConstants.BLANK).append(valueOf).toString());
        }
        if (this.f372i > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(C0377o.m372a(this.f371h));
            append = printWriter.append(" lastFailedTime=");
            j = this.f372i;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f372i)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(HwAccountConstants.BLANK).append(valueOf2).toString());
        }
    }

    public void m549b(int i) {
        this.f365a.sendMessage(this.f365a.obtainMessage(4, this.f367c.get(), i));
    }

    public boolean m550b() {
        boolean z;
        synchronized (this.f377n) {
            z = this.f383t == 3;
        }
        return z;
    }

    public boolean m551c() {
        boolean z;
        synchronized (this.f377n) {
            z = this.f383t == 2;
        }
        return z;
    }

    public boolean mo1868d() {
        return false;
    }

    public boolean mo2011e() {
        return true;
    }

    public boolean m554f() {
        return false;
    }

    protected String f_() {
        return "com.google.android.gms";
    }

    public Intent m555g() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @Nullable
    public IBinder m556h() {
        IBinder iBinder;
        synchronized (this.f378o) {
            if (this.f379p == null) {
                iBinder = null;
            } else {
                iBinder = this.f379p.asBinder();
            }
        }
        return iBinder;
    }

    @NonNull
    protected abstract String mo1773i();

    @NonNull
    protected abstract String mo1774j();

    @Nullable
    protected final String m559m() {
        return this.f387x == null ? this.f373j.getClass().getName() : this.f387x;
    }

    public final Context m560n() {
        return this.f373j;
    }

    public Account mo1759o() {
        return null;
    }

    public zzc[] mo1760p() {
        return new zzc[0];
    }

    public final Account m563q() {
        return mo1759o() != null ? mo1759o() : new Account("<<default account>>", "com.google");
    }

    protected Bundle mo1870r() {
        return new Bundle();
    }

    protected final void m565s() {
        if (!m550b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle m566t() {
        return null;
    }

    public final T m567u() throws DeadObjectException {
        T t;
        synchronized (this.f377n) {
            if (this.f383t == 4) {
                throw new DeadObjectException();
            }
            m565s();
            C0424f.m655a(this.f380q != null, (Object) "Client is connected but service is null");
            t = this.f380q;
        }
        return t;
    }

    public boolean m568v() {
        return false;
    }

    protected Set<Scope> mo1761w() {
        return Collections.EMPTY_SET;
    }
}
