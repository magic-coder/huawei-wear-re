package com.huawei.hwid.update.p453d;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.hwid.core.p435d.C5180k;

/* compiled from: ConfirmDialogs */
public final class C5287d {

    /* compiled from: ConfirmDialogs */
    abstract class C5284a extends C5279b {

        /* compiled from: ConfirmDialogs */
        class C52821 implements OnClickListener {
            final /* synthetic */ C5284a f18964a;

            C52821(C5284a c5284a) {
                this.f18964a = c5284a;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f18964a.m25563e();
            }
        }

        /* compiled from: ConfirmDialogs */
        class C52832 implements OnClickListener {
            final /* synthetic */ C5284a f18965a;

            C52832(C5284a c5284a) {
                this.f18965a = c5284a;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f18965a.m25560b();
            }
        }

        protected abstract int mo4664h();

        protected abstract int mo4665i();

        protected abstract int mo4666j();

        private C5284a() {
        }

        public AlertDialog mo4663a() {
            Builder builder = new Builder(m25564f(), m25565g());
            builder.setMessage(mo4664h());
            builder.setPositiveButton(mo4665i(), new C52821(this));
            builder.setNegativeButton(mo4666j(), new C52832(this));
            return builder.create();
        }
    }

    /* compiled from: ConfirmDialogs */
    public class C5285b extends C5284a {
        public C5285b() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo4663a() {
            return super.mo4663a();
        }

        protected int mo4664h() {
            return C5180k.m25027a(m25564f(), "cs_download_retry");
        }

        protected int mo4665i() {
            return C5180k.m25027a(m25564f(), "CS_retry");
        }

        protected int mo4666j() {
            return C5180k.m25027a(m25564f(), "cs_cancel");
        }
    }

    /* compiled from: ConfirmDialogs */
    public class C5286c extends C5284a {
        public C5286c() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo4663a() {
            return super.mo4663a();
        }

        protected int mo4664h() {
            return C5180k.m25027a(m25564f(), "CS_update_stop");
        }

        protected int mo4665i() {
            return C5180k.m25027a(m25564f(), "CS_terminate");
        }

        protected int mo4666j() {
            return C5180k.m25027a(m25564f(), "cs_cancel");
        }
    }
}
