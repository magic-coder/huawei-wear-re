package com.huawei.hwid.api.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.huawei.cloudservice.C4336b;
import com.huawei.cloudservice.C4336b.C4338a;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AIDLClientManager */
public final class C5073a implements ServiceConnection {
    private static C5073a f18303b;
    private static final AtomicInteger f18304e = new AtomicInteger();
    private static final ExecutorService f18305g = Executors.newFixedThreadPool(3);
    AtomicInteger f18306a = new AtomicInteger(0);
    private C4336b f18307c;
    private Context f18308d;
    private final Queue<C5081b> f18309f = new LinkedBlockingQueue();
    private Handler f18310h = new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ C5073a f18297a;

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 3001) {
                C5165e.m24906b("AIDLClientManager", "msg.what=MSG_ADD_TASK");
                if (this.f18297a.f18306a.get() == 2) {
                    this.f18297a.m24401c();
                } else if (this.f18297a.f18306a.get() == 0) {
                    this.f18297a.m24403d();
                }
            } else if (message.what == 3002) {
                this.f18297a.f18306a.set(2);
                this.f18297a.m24401c();
            } else if (message.what == 3003) {
                this.f18297a.f18306a.set(0);
                this.f18297a.m24413j();
            } else if (message.what == 3004) {
                C5165e.m24906b("AIDLClientManager", "MSG_FINISH_TASK, unbind");
                this.f18297a.m24412i();
                this.f18297a.f18306a.set(0);
            } else if (message.what == IOmaService.RETURN_APDU_EXCUTE_TRANSMIT_NULLPOINTEREXCEPTION) {
                C5165e.m24906b("AIDLClientManager", "MSG_START_SERVICE_FAILED all login return failed");
                this.f18297a.f18306a.set(0);
                this.f18297a.m24411h();
            }
        }
    };
    private CountDownLatch f18311i = null;
    private final AtomicBoolean f18312j = new AtomicBoolean(false);
    private int f18313k = 0;

    /* compiled from: AIDLClientManager */
    class C50682 implements Runnable {
        final /* synthetic */ C5073a f18298a;

        C50682(C5073a c5073a) {
            this.f18298a = c5073a;
        }

        public void run() {
            try {
                boolean await = this.f18298a.f18311i.await(2000, TimeUnit.MILLISECONDS);
                C5165e.m24906b("AIDLClientManager", "startService await=" + await);
                if (!await) {
                    this.f18298a.m24409g();
                }
            } catch (InterruptedException e) {
                C5165e.m24906b("AIDLClientManager", "serviceStartDownLatch InterruptedException");
                this.f18298a.m24409g();
            }
        }
    }

    public static C5073a m24398a(Context context) {
        if (context == null) {
            return null;
        }
        C5073a c5073a;
        synchronized (C5073a.class) {
            if (f18303b == null) {
                C5165e.m24906b("AIDLClientManager", "AIDLClientManager init");
                f18303b = new C5073a(context);
            }
            c5073a = f18303b;
        }
        return c5073a;
    }

    private C5073a(Context context) {
        this.f18308d = context.getApplicationContext();
    }

    public final C4336b m24414a() {
        return this.f18307c;
    }

    public void m24416b() {
        C5165e.m24906b("AIDLClientManager", "sendTaskFinishMsg");
        synchronized (this.f18309f) {
            C5165e.m24906b("AIDLClientManager", "refCount=" + f18304e.get());
            if (f18304e.decrementAndGet() == 0) {
                this.f18310h.sendEmptyMessage(3004);
            }
        }
    }

    public void m24415a(C5081b c5081b) {
        C5165e.m24906b("AIDLClientManager", "addTask:" + c5081b);
        synchronized (this.f18309f) {
            f18304e.incrementAndGet();
            this.f18309f.add(c5081b);
        }
        this.f18310h.sendEmptyMessage(3001);
    }

    private void m24401c() {
        C5165e.m24906b("AIDLClientManager", "doTask");
        synchronized (this.f18309f) {
            while (true) {
                C5081b c5081b = (C5081b) this.f18309f.poll();
                if (c5081b != null) {
                    try {
                        f18305g.submit(c5081b);
                    } catch (RejectedExecutionException e) {
                        C5165e.m24910d("AIDLClientManager", "Execute submit task failed!");
                    }
                }
            }
        }
    }

    private void m24403d() {
        C5165e.m24906b("AIDLClientManager", "startService");
        this.f18306a.set(1);
        m24405e();
        m24408f();
    }

    private void m24405e() {
        C5165e.m24904a("AIDLClientManager", "begin to bindService");
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.ICloudService");
        intent.setPackage("com.huawei.hwid");
        try {
            if (!this.f18308d.bindService(intent, this, 1)) {
                C5165e.m24910d("AIDLClientManager", "bind service failed");
            }
        } catch (Exception e) {
            C5165e.m24906b("AIDLClientManager", "bind service exception");
        }
    }

    private void m24408f() {
        this.f18312j.set(false);
        this.f18311i = new CountDownLatch(1);
        new Thread(new C50682(this)).start();
    }

    private void m24409g() {
        C5165e.m24906b("AIDLClientManager", "onServiceConnectedTimeout:" + this.f18312j.get() + 1);
        if (!this.f18312j.get()) {
            m24412i();
            C5165e.m24906b("AIDLClientManager", "The " + this.f18313k + " to try to start service");
            if (this.f18313k < 3) {
                this.f18313k++;
                m24403d();
                return;
            }
            this.f18312j.set(true);
            this.f18310h.sendEmptyMessage(IOmaService.RETURN_APDU_EXCUTE_TRANSMIT_NULLPOINTEREXCEPTION);
        }
    }

    private void m24411h() {
        C5165e.m24906b("AIDLClientManager", "onBindServiceFailed");
        synchronized (this.f18309f) {
            while (true) {
                C5081b c5081b = (C5081b) this.f18309f.poll();
                if (c5081b != null) {
                    f18304e.decrementAndGet();
                    c5081b.mo4613a(new ErrorStatus(40, "start APK service ERROR"));
                }
            }
        }
    }

    private void m24412i() {
        C5165e.m24906b("AIDLClientManager", "unbind Service");
        try {
            this.f18308d.unbindService(this);
        } catch (Exception e) {
            C5165e.m24906b("AIDLClientManager", "unbind service error");
        }
        m24413j();
    }

    private void m24413j() {
        synchronized (this.f18309f) {
            this.f18307c = null;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C5165e.m24906b("AIDLClientManager", "onServiceConnected");
        this.f18313k = 0;
        this.f18307c = C4338a.m20873a(iBinder);
        this.f18311i.countDown();
        this.f18312j.set(true);
        this.f18310h.sendEmptyMessage(3002);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C5165e.m24906b("AIDLClientManager", "onServiceDisconnected");
        this.f18313k = 0;
        this.f18310h.sendEmptyMessage(3003);
    }
}
