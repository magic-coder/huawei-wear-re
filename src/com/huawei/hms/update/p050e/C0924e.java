package com.huawei.hms.update.p050e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.android.a.a.d;

/* compiled from: ConfirmDialogs */
public final class C0924e {

    /* compiled from: ConfirmDialogs */
    abstract class C0921a extends C0917b {
        protected abstract int mo2277h();

        protected abstract int mo2278i();

        protected abstract int mo2279j();

        private C0921a() {
        }

        public AlertDialog mo2276a() {
            Builder builder = new Builder(m3213f(), m3214g());
            builder.setMessage(mo2277h());
            builder.setPositiveButton(mo2278i(), new C0925f(this));
            builder.setNegativeButton(mo2279j(), new C0926g(this));
            return builder.create();
        }
    }

    /* compiled from: ConfirmDialogs */
    public class C0922b extends C0921a {
        public C0922b() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo2276a() {
            return super.mo2276a();
        }

        protected int mo2277h() {
            return d.hms_download_retry;
        }

        protected int mo2278i() {
            return d.hms_retry;
        }

        protected int mo2279j() {
            return d.hms_cancel;
        }
    }

    /* compiled from: ConfirmDialogs */
    public class C0923c extends C0921a {
        public C0923c() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo2276a() {
            return super.mo2276a();
        }

        protected int mo2277h() {
            return d.hms_abort_message;
        }

        protected int mo2278i() {
            return d.hms_abort;
        }

        protected int mo2279j() {
            return d.hms_cancel;
        }
    }
}
