package com.huawei.hms.update.p050e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.android.a.a.d;

/* compiled from: PromptDialogs */
public final class C0941m {

    /* compiled from: PromptDialogs */
    abstract class C0937a extends C0917b {
        protected abstract int mo2280h();

        private C0937a() {
        }

        public AlertDialog mo2276a() {
            Builder builder = new Builder(m3213f(), m3214g());
            builder.setMessage(mo2280h());
            builder.setPositiveButton(m3235i(), new C0942n(this));
            return builder.create();
        }

        protected int m3235i() {
            return d.hms_confirm;
        }
    }

    /* compiled from: PromptDialogs */
    public class C0938b extends C0937a {
        public C0938b() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo2276a() {
            return super.mo2276a();
        }

        protected int mo2280h() {
            return d.hms_check_failure;
        }
    }

    /* compiled from: PromptDialogs */
    public class C0939c extends C0937a {
        public C0939c() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo2276a() {
            return super.mo2276a();
        }

        protected int mo2280h() {
            return d.hms_download_failure;
        }
    }

    /* compiled from: PromptDialogs */
    public class C0940d extends C0937a {
        public C0940d() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo2276a() {
            return super.mo2276a();
        }

        protected int mo2280h() {
            return d.hms_download_no_space;
        }
    }
}
