package com.huawei.hwid.update.p449a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hwid.d.a;
import com.huawei.hwid.update.p449a.p450a.C5252a;
import com.huawei.hwid.update.p449a.p450a.C5253b;
import com.huawei.hwid.update.p449a.p450a.C5254c;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ThreadWrapper */
public class C5269h implements C5252a {
    private static final Executor f18951b = Executors.newSingleThreadExecutor();
    private final C5252a f18952a;

    /* compiled from: ThreadWrapper */
    final class C52683 implements C5253b {
        final /* synthetic */ C5253b f18950a;

        C52683(C5253b c5253b) {
            this.f18950a = c5253b;
        }

        public void mo4657a(final int i, final C5254c c5254c) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ C52683 f18944c;

                public void run() {
                    this.f18944c.f18950a.mo4657a(i, c5254c);
                }
            });
        }

        public void mo4656a(int i, int i2, int i3, File file) {
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final File file2 = file;
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ C52683 f18949e;

                public void run() {
                    this.f18949e.f18950a.mo4656a(i4, i5, i6, file2);
                }
            });
        }
    }

    public C5269h(C5252a c5252a) {
        a.a(c5252a, "update must not be null.");
        this.f18952a = c5252a;
    }

    public Context mo4651a() {
        return this.f18952a.mo4651a();
    }

    public void mo4654b() {
        this.f18952a.mo4654b();
    }

    public void mo4652a(final C5253b c5253b) {
        f18951b.execute(new Runnable(this) {
            final /* synthetic */ C5269h f18938b;

            public void run() {
                this.f18938b.f18952a.mo4652a(C5269h.m25522c(c5253b));
            }
        });
    }

    public void mo4653a(final C5253b c5253b, final C5254c c5254c) {
        f18951b.execute(new Runnable(this) {
            final /* synthetic */ C5269h f18941c;

            public void run() {
                this.f18941c.f18952a.mo4653a(C5269h.m25522c(c5253b), c5254c);
            }
        });
    }

    private static C5253b m25522c(C5253b c5253b) {
        return new C52683(c5253b);
    }
}
