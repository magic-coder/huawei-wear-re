package com.huawei.hwid.update.p453d;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.hwid.core.p435d.C5180k;

/* compiled from: InstallConfirm */
public class C5294g extends C5279b {

    /* compiled from: InstallConfirm */
    class C52921 implements OnClickListener {
        final /* synthetic */ C5294g f18973a;

        C52921(C5294g c5294g) {
            this.f18973a = c5294g;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18973a.m25563e();
        }
    }

    /* compiled from: InstallConfirm */
    class C52932 implements OnClickListener {
        final /* synthetic */ C5294g f18974a;

        C52932(C5294g c5294g) {
            this.f18974a = c5294g;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18974a.m25560b();
        }
    }

    protected AlertDialog mo4663a() {
        int a = C5180k.m25027a(m25564f(), "cs_update_message_new");
        int a2 = C5180k.m25027a(m25564f(), "CS_install");
        Builder builder = new Builder(m25564f(), m25565g());
        builder.setMessage(m25564f().getString(a, new Object[]{m25564f().getString(C5180k.m25027a(m25564f(), "cs_update_title"))}));
        builder.setPositiveButton(a2, new C52921(this));
        builder.setNegativeButton(C5180k.m25027a(m25564f(), "cs_cancel"), new C52932(this));
        return builder.create();
    }
}
