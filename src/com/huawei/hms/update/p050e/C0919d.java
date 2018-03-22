package com.huawei.hms.update.p050e;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import com.huawei.android.a.a.d;

/* compiled from: CheckProgress */
public class C0919d extends C0917b {
    public AlertDialog mo2276a() {
        AlertDialog progressDialog = new ProgressDialog(m3213f(), m3214g());
        progressDialog.setMessage(m3213f().getString(d.hms_checking));
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
