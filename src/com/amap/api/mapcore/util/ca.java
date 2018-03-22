package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: SDKLogHandler */
public class ca extends cd implements UncaughtExceptionHandler {
    private static ExecutorService f11583e;
    private Context f11584d;

    /* compiled from: SDKLogHandler */
    class C3302a implements dn {
        private Context f11579a;

        C3302a(Context context) {
            this.f11579a = context;
        }

        public void mo4017a() {
            try {
                ci.m15904b(this.f11579a);
            } catch (Throwable th) {
                ca.m15831a(th, "LogNetListener", "onNetCompleted");
                th.printStackTrace();
            }
        }
    }

    static synchronized ExecutorService m15830a() {
        ExecutorService executorService;
        synchronized (ca.class) {
            try {
                if (f11583e == null || f11583e.isShutdown()) {
                    f11583e = Executors.newSingleThreadExecutor();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = f11583e;
        }
        return executorService;
    }

    public static synchronized ca m15829a(Context context, bv bvVar) throws bl {
        ca caVar;
        synchronized (ca.class) {
            if (bvVar == null) {
                throw new bl("sdk info is null");
            } else if (bvVar.m15791a() == null || "".equals(bvVar.m15791a())) {
                throw new bl("sdk name is invalid");
            } else {
                try {
                    if (cd.f11580a == null) {
                        cd.f11580a = new ca(context, bvVar);
                    } else {
                        cd.f11580a.f11582c = false;
                    }
                    cd.f11580a.mo4018a(context, bvVar, cd.f11580a.f11582c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                caVar = (ca) cd.f11580a;
            }
        }
        return caVar;
    }

    public static synchronized ca m15832b() {
        ca caVar;
        synchronized (ca.class) {
            caVar = (ca) cd.f11580a;
        }
        return caVar;
    }

    public static void m15831a(Throwable th, String str, String str2) {
        if (cd.f11580a != null) {
            cd.f11580a.mo4019a(th, 1, str, str2);
        }
    }

    public static synchronized void m15833c() {
        synchronized (ca.class) {
            try {
                if (f11583e != null) {
                    f11583e.shutdown();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(cd.f11580a == null || Thread.getDefaultUncaughtExceptionHandler() != cd.f11580a || cd.f11580a.f11581b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(cd.f11580a.f11581b);
                }
                cd.f11580a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private ca(Context context, bv bvVar) {
        this.f11584d = context;
        dm.m16068a(new C3302a(context));
        m15834d();
    }

    private void m15834d() {
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
            } else if (this.b.toString().indexOf("com.amap.api") != -1) {
                this.c = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            mo4019a(th, 0, null, null);
            if (this.b != null) {
                this.b.uncaughtException(thread, th);
            }
        }
    }

    public void m15837b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                mo4019a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    protected void mo4019a(Throwable th, int i, String str, String str2) {
        ci.m15903a(this.f11584d, th, i, str, str2);
    }

    protected void mo4018a(final Context context, final bv bvVar, final boolean z) {
        try {
            ExecutorService a = m15830a();
            if (a != null && !a.isShutdown()) {
                a.submit(new Runnable(this) {
                    final /* synthetic */ ca f11578d;

                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new cy(context, true).m15966a(bvVar);
                            }
                            if (z) {
                                synchronized (Looper.getMainLooper()) {
                                    da daVar = new da(context);
                                    dc dcVar = new dc();
                                    dcVar.m15999c(true);
                                    dcVar.m15995a(true);
                                    dcVar.m15997b(true);
                                    daVar.m15988a(dcVar);
                                }
                                ci.m15902a(this.f11578d.f11584d);
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
