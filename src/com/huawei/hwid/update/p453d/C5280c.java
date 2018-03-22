package com.huawei.hwid.update.p453d;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import com.huawei.hwid.core.p435d.C5180k;

/* compiled from: CheckProgress */
public class C5280c extends C5279b {
    public AlertDialog mo4663a() {
        AlertDialog progressDialog = new ProgressDialog(m25564f(), m25565g());
        progressDialog.setMessage(m25564f().getString(C5180k.m25027a(m25564f(), "cs_checking")));
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
