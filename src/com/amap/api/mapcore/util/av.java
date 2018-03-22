package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AsyncTask */
public abstract class av<Params, Progress, Result> {
    private static final ThreadFactory f11142a = new aw();
    public static final Executor f11143b = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f11146e, f11142a, new DiscardOldestPolicy());
    public static final Executor f11144c;
    public static final Executor f11145d = Executors.newFixedThreadPool(2, f11142a);
    private static final BlockingQueue<Runnable> f11146e = new LinkedBlockingQueue(10);
    private static final C3282b f11147f = new C3282b();
    private static volatile Executor f11148g = f11144c;
    private final C3278e<Params, Result> f11149h = new C32791(this);
    private final FutureTask<Result> f11150i = new FutureTask<Result>(this, this.f11149h) {
        final /* synthetic */ av f11426a;

        protected void done() {
            try {
                this.f11426a.m15170c(this.f11426a.f11150i.get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f11426a.m15170c(null);
            }
        }
    };
    private volatile C3285d f11151j = C3285d.PENDING;
    private final AtomicBoolean f11152k = new AtomicBoolean();
    private final AtomicBoolean f11153l = new AtomicBoolean();

    /* compiled from: AsyncTask */
    abstract class C3278e<Params, Result> implements Callable<Result> {
        Params[] f11424b;

        private C3278e() {
        }
    }

    /* compiled from: AsyncTask */
    class C32791 extends C3278e<Params, Result> {
        final /* synthetic */ av f11425a;

        C32791(av avVar) {
            this.f11425a = avVar;
            super();
        }

        public Result call() throws Exception {
            this.f11425a.f11153l.set(true);
            Process.setThreadPriority(10);
            return this.f11425a.m15171d(this.f11425a.mo3936a(this.b));
        }
    }

    /* compiled from: AsyncTask */
    class C3281a<Data> {
        final av f11427a;
        final Data[] f11428b;

        C3281a(av avVar, Data... dataArr) {
            this.f11427a = avVar;
            this.f11428b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    class C3282b extends Handler {
        private C3282b() {
        }

        public void handleMessage(Message message) {
            C3281a c3281a = (C3281a) message.obj;
            switch (message.what) {
                case 1:
                    c3281a.f11427a.m15172e(c3281a.f11428b[0]);
                    return;
                case 2:
                    c3281a.f11427a.m15180b(c3281a.f11428b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask */
    class C3284c implements Executor {
        final ArrayDeque<Runnable> f11431a;
        Runnable f11432b;

        private C3284c() {
            this.f11431a = new ArrayDeque();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f11431a.offer(new Runnable(this) {
                final /* synthetic */ C3284c f11430b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f11430b.m15524a();
                    }
                }
            });
            if (this.f11432b == null) {
                m15524a();
            }
        }

        protected synchronized void m15524a() {
            Runnable runnable = (Runnable) this.f11431a.poll();
            this.f11432b = runnable;
            if (runnable != null) {
                av.f11143b.execute(this.f11432b);
            }
        }
    }

    /* compiled from: AsyncTask */
    public enum C3285d {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result mo3936a(Params... paramsArr);

    static {
        Executor c3284c;
        if (bk.m15678c()) {
            c3284c = new C3284c();
        } else {
            c3284c = Executors.newSingleThreadExecutor(f11142a);
        }
        f11144c = c3284c;
    }

    private void m15170c(Result result) {
        if (!this.f11153l.get()) {
            m15171d(result);
        }
    }

    private Result m15171d(Result result) {
        f11147f.obtainMessage(1, new C3281a(this, result)).sendToTarget();
        return result;
    }

    public final C3285d m15173a() {
        return this.f11151j;
    }

    protected void m15178b() {
    }

    protected void mo3937a(Result result) {
    }

    protected void m15180b(Progress... progressArr) {
    }

    protected void mo4016b(Result result) {
        m15182c();
    }

    protected void m15182c() {
    }

    public final boolean m15183d() {
        return this.f11152k.get();
    }

    public final boolean m15177a(boolean z) {
        this.f11152k.set(true);
        return this.f11150i.cancel(z);
    }

    public final av<Params, Progress, Result> m15181c(Params... paramsArr) {
        return m15174a(f11148g, (Object[]) paramsArr);
    }

    public final av<Params, Progress, Result> m15174a(Executor executor, Params... paramsArr) {
        if (this.f11151j != C3285d.PENDING) {
            switch (ax.f11438a[this.f11151j.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f11151j = C3285d.RUNNING;
        m15178b();
        this.f11149h.f11424b = paramsArr;
        executor.execute(this.f11150i);
        return this;
    }

    private void m15172e(Result result) {
        if (m15183d()) {
            mo4016b((Object) result);
        } else {
            mo3937a((Object) result);
        }
        this.f11151j = C3285d.FINISHED;
    }
}
