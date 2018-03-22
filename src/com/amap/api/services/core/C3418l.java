package com.amap.api.services.core;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: ManifestConfig */
public class C3418l {
    public static ad f12485a;
    private static C3418l f12486b;
    private static Context f12487c;
    private C3417a f12488d;
    private HandlerThread f12489e = new C3419m(this, "manifestThread");

    /* compiled from: ManifestConfig */
    class C3417a extends Handler {
        String f12483a = "handleMessage";
        final /* synthetic */ C3418l f12484b;

        public C3417a(C3418l c3418l, Looper looper) {
            this.f12484b = c3418l;
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message != null) {
                switch (message.what) {
                    case 3:
                        try {
                            C3421o c3421o = (C3421o) message.obj;
                            if (c3421o == null) {
                                c3421o = new C3421o(false, false);
                            }
                            ay.m16705a(C3418l.f12487c, C3408c.m16873a(c3421o.m16968a()));
                            C3418l.f12485a = C3408c.m16873a(c3421o.m16968a());
                            return;
                        } catch (Throwable th) {
                            C3409d.m16881a(th, "ManifestConfig", this.f12483a);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private C3418l(Context context) {
        f12487c = context;
        f12485a = C3408c.m16873a(false);
        try {
            this.f12489e.start();
            this.f12488d = new C3417a(this, Looper.getMainLooper());
        } catch (Throwable th) {
            C3409d.m16881a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static C3418l m16960a(Context context) {
        if (f12486b == null) {
            f12486b = new C3418l(context);
        }
        return f12486b;
    }
}
