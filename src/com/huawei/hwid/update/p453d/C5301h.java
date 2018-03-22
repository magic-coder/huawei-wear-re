package com.huawei.hwid.update.p453d;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.hwid.core.p435d.C5180k;

/* compiled from: PromptDialogs */
public final class C5301h {

    /* compiled from: PromptDialogs */
    abstract class C5297a extends C5279b {

        /* compiled from: PromptDialogs */
        class C52961 implements OnClickListener {
            final /* synthetic */ C5297a f18975a;

            C52961(C5297a c5297a) {
                this.f18975a = c5297a;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f18975a.m25563e();
            }
        }

        protected abstract int mo4675h();

        private C5297a() {
        }

        public AlertDialog mo4663a() {
            Builder builder = new Builder(m25564f(), m25565g());
            builder.setMessage(mo4675h());
            builder.setPositiveButton(m25600i(), new C52961(this));
            return builder.create();
        }

        protected int m25600i() {
            return C5180k.m25027a(m25564f(), "cs_confirm");
        }
    }

    /* compiled from: PromptDialogs */
    public class C5298b extends C5297a {
        public C5298b() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo4663a() {
            return super.mo4663a();
        }

        protected int mo4675h() {
            return C5180k.m25027a(m25564f(), "cs_check_failure");
        }
    }

    /* compiled from: PromptDialogs */
    public class C5299c extends C5297a {
        public C5299c() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo4663a() {
            return super.mo4663a();
        }

        protected int mo4675h() {
            return C5180k.m25027a(m25564f(), "cs_download_failure");
        }
    }

    /* compiled from: PromptDialogs */
    public class C5300d extends C5297a {
        public C5300d() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog mo4663a() {
            return super.mo4663a();
        }

        protected int mo4675h() {
            return C5180k.m25027a(m25564f(), "cs_download_no_space");
        }
    }
}
