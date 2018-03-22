package com.p230a.p231b.p232b.p233a;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class C3117o {
    private AtomicInteger f10455a;
    private final Map f10456b;
    private final Set f10457c;
    private final PriorityBlockingQueue f10458d;
    private final PriorityBlockingQueue f10459e;
    private final C3088b f10460f;
    private final C3085g f10461g;
    private final C3108s f10462h;
    private C3110h[] f10463i;
    private C3105d f10464j;

    public C3117o(C3088b c3088b, C3085g c3085g) {
        this(c3088b, c3085g, 4);
    }

    public C3117o(C3088b c3088b, C3085g c3085g, int i) {
        this(c3088b, c3085g, i, new C3109f(new Handler(Looper.getMainLooper())));
    }

    public C3117o(C3088b c3088b, C3085g c3085g, int i, C3108s c3108s) {
        this.f10455a = new AtomicInteger();
        this.f10456b = new HashMap();
        this.f10457c = new HashSet();
        this.f10458d = new PriorityBlockingQueue();
        this.f10459e = new PriorityBlockingQueue();
        this.f10460f = c3088b;
        this.f10461g = c3085g;
        this.f10463i = new C3110h[i];
        this.f10462h = c3108s;
    }

    public C3115m m13897a(C3115m c3115m) {
        c3115m.m13870a(this);
        synchronized (this.f10457c) {
            this.f10457c.add(c3115m);
        }
        c3115m.m13868a(m13901c());
        c3115m.m13873a("add-to-queue");
        if (c3115m.m13891p()) {
            synchronized (this.f10456b) {
                String g = c3115m.m13882g();
                if (this.f10456b.containsKey(g)) {
                    Queue queue = (Queue) this.f10456b.get(g);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(c3115m);
                    this.f10456b.put(g, queue);
                    if (C3121x.f10470b) {
                        C3121x.m13905a("Request for cacheKey=%s is in flight, putting on hold.", g);
                    }
                } else {
                    this.f10456b.put(g, null);
                    this.f10458d.add(c3115m);
                }
            }
        } else {
            this.f10459e.add(c3115m);
        }
        return c3115m;
    }

    public void m13898a() {
        m13899b();
        this.f10464j = new C3105d(this.f10458d, this.f10459e, this.f10460f, this.f10462h);
        this.f10464j.start();
        for (int i = 0; i < this.f10463i.length; i++) {
            C3110h c3110h = new C3110h(this.f10459e, this.f10461g, this.f10460f, this.f10462h);
            this.f10463i[i] = c3110h;
            c3110h.start();
        }
    }

    public void m13899b() {
        if (this.f10464j != null) {
            this.f10464j.m13847a();
        }
        for (int i = 0; i < this.f10463i.length; i++) {
            if (this.f10463i[i] != null) {
                this.f10463i[i].m13861a();
            }
        }
    }

    final void m13900b(C3115m c3115m) {
        synchronized (this.f10457c) {
            this.f10457c.remove(c3115m);
        }
        if (c3115m.m13891p()) {
            synchronized (this.f10456b) {
                Queue queue = (Queue) this.f10456b.remove(c3115m.m13882g());
                if (queue != null) {
                    if (C3121x.f10470b) {
                        C3121x.m13905a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f10458d.addAll(queue);
                }
            }
        }
    }

    public int m13901c() {
        return this.f10455a.incrementAndGet();
    }
}
