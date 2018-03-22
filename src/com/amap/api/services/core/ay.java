package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: SDKLogHandler */
public class ay implements UncaughtExceptionHandler {
    private static ay f12383a;
    private static ExecutorService f12384e;
    private UncaughtExceptionHandler f12385b;
    private Context f12386c;
    private boolean f12387d = true;

    /* compiled from: SDKLogHandler */
    class C3393a implements br {
        private Context f12382a;

        C3393a(Context context) {
            this.f12382a = context;
        }

        public void mo4110a() {
            try {
                bf.m16785b(this.f12382a);
            } catch (Throwable th) {
                ay.m16709a(th, "LogNetListener", "onNetCompleted");
                th.printStackTrace();
            }
        }
    }

    static synchronized ExecutorService m16706a() {
        ExecutorService executorService;
        synchronized (ay.class) {
            try {
                if (f12384e == null || f12384e.isShutdown()) {
                    f12384e = Executors.newSingleThreadExecutor();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = f12384e;
        }
        return executorService;
    }

    public static synchronized ay m16705a(Context context, ad adVar) throws C3433v {
        ay ayVar;
        synchronized (ay.class) {
            if (adVar == null) {
                throw new C3433v("sdk info is null");
            } else if (adVar.m16613a() == null || "".equals(adVar.m16613a())) {
                throw new C3433v("sdk name is invalid");
            } else {
                try {
                    if (f12383a == null) {
                        f12383a = new ay(context, adVar);
                    } else {
                        f12383a.f12387d = false;
                    }
                    f12383a.m16707a(context, adVar, f12383a.f12387d);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                ayVar = f12383a;
            }
        }
        return ayVar;
    }

    public static synchronized ay m16710b() {
        ay ayVar;
        synchronized (ay.class) {
            ayVar = f12383a;
        }
        return ayVar;
    }

    public static void m16709a(Throwable th, String str, String str2) {
        if (f12383a != null) {
            f12383a.m16708a(th, 1, str, str2);
        }
    }

    private ay(Context context, ad adVar) {
        this.f12386c = context;
        bq.m16850a(new C3393a(context));
        m16711c();
    }

    private void m16711c() {
        try {
            this.f12385b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f12385b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f12387d = true;
            } else if (this.f12385b.toString().indexOf("com.amap.api") != -1) {
                this.f12387d = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f12387d = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            m16708a(th, 0, null, null);
            if (this.f12385b != null) {
                this.f12385b.uncaughtException(thread, th);
            }
        }
    }

    public void m16712b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                m16708a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void m16708a(Throwable th, int i, String str, String str2) {
        bf.m16784a(this.f12386c, th, i, str, str2);
    }

    private void m16707a(final Context context, final ad adVar, final boolean z) {
        try {
            ExecutorService a = m16706a();
            if (a != null && !a.isShutdown()) {
                a.submit(new Runnable(this) {
                    final /* synthetic */ ay f12381d;

                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new an(context).m16666a(adVar);
                            }
                            if (z) {
                                synchronized (Looper.getMainLooper()) {
                                    aq aqVar = new aq(context);
                                    as asVar = new as();
                                    asVar.m16690c(true);
                                    asVar.m16686a(true);
                                    asVar.m16688b(true);
                                    aqVar.m16679a(asVar);
                                }
                                bf.m16783a(this.f12381d.f12386c);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
