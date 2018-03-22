package com.huawei.hms.update.p050e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.android.a.a.d;

/* compiled from: InstallConfirm */
public class C0930i extends C0917b {
    protected AlertDialog mo2276a() {
        int i = d.hms_update_message_new;
        int i2 = d.hms_install;
        Builder builder = new Builder(m3213f(), m3214g());
        builder.setMessage(m3213f().getString(i, new Object[]{m3213f().getString(d.hms_update_title)}));
        builder.setPositiveButton(i2, new C0931j(this));
        builder.setNegativeButton(d.hms_cancel, new C0932k(this));
        return builder.create();
    }
}
