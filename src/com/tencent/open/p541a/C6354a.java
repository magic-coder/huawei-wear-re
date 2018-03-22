package com.tencent.open.p541a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
public class C6354a extends C6353q implements Callback {
    private C6355b f22100a;
    private FileWriter f22101b;
    private File f22102c;
    private char[] f22103d;
    private volatile C6368o f22104e;
    private volatile C6368o f22105f;
    private volatile C6368o f22106g;
    private volatile C6368o f22107h;
    private volatile boolean f22108i;
    private HandlerThread f22109j;
    private Handler f22110k;

    public C6354a(C6355b c6355b) {
        this(C6359f.f22127b, true, C6369p.f22154a, c6355b);
    }

    public C6354a(int i, boolean z, C6369p c6369p, C6355b c6355b) {
        super(i, z, c6369p);
        this.f22108i = false;
        m29058a(c6355b);
        this.f22104e = new C6368o();
        this.f22105f = new C6368o();
        this.f22106g = this.f22104e;
        this.f22107h = this.f22105f;
        this.f22103d = new char[c6355b.m29084f()];
        c6355b.m29072b();
        m29053g();
        this.f22109j = new HandlerThread(c6355b.m29077c(), c6355b.m29086h());
        if (this.f22109j != null) {
            this.f22109j.start();
        }
        if (this.f22109j.isAlive() && this.f22109j.getLooper() != null) {
            this.f22110k = new Handler(this.f22109j.getLooper(), this);
        }
    }

    public void m29056a() {
        if (this.f22110k.hasMessages(1024)) {
            this.f22110k.removeMessages(1024);
        }
        this.f22110k.sendEmptyMessage(1024);
    }

    public void m29060b() {
        m29054h();
        this.f22109j.quit();
    }

    protected void mo5332a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        m29059a(m29051e().m29120a(i, thread, j, str, str2, th));
    }

    protected void m29059a(String str) {
        this.f22106g.m29116a(str);
        if (this.f22106g.m29115a() >= m29061c().m29084f()) {
            m29056a();
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1024:
                m29052f();
                break;
        }
        return true;
    }

    private void m29052f() {
        if (Thread.currentThread() == this.f22109j && !this.f22108i) {
            this.f22108i = true;
            m29055i();
            try {
                this.f22107h.m29117a(m29053g(), this.f22103d);
            } catch (IOException e) {
            } finally {
                this.f22107h.m29118b();
            }
            this.f22108i = false;
        }
    }

    private Writer m29053g() {
        File a = m29061c().m29067a();
        if (!(a == null || a.equals(this.f22102c))) {
            this.f22102c = a;
            m29054h();
            try {
                this.f22101b = new FileWriter(this.f22102c, true);
            } catch (IOException e) {
                return null;
            }
        }
        return this.f22101b;
    }

    private void m29054h() {
        try {
            if (this.f22101b != null) {
                this.f22101b.flush();
                this.f22101b.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void m29055i() {
        synchronized (this) {
            if (this.f22106g == this.f22104e) {
                this.f22106g = this.f22105f;
                this.f22107h = this.f22104e;
            } else {
                this.f22106g = this.f22104e;
                this.f22107h = this.f22105f;
            }
        }
    }

    public C6355b m29061c() {
        return this.f22100a;
    }

    public void m29058a(C6355b c6355b) {
        this.f22100a = c6355b;
    }
}
