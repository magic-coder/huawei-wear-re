package com.huawei.feedback.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.logupload.LogUpload;

/* compiled from: ProgressService */
class C0819h implements OnClickListener {
    final /* synthetic */ LogUpload f1290a;
    final /* synthetic */ long f1291b;
    final /* synthetic */ ProgressService f1292c;

    C0819h(ProgressService progressService, LogUpload logUpload, long j) {
        this.f1292c = progressService;
        this.f1290a = logUpload;
        this.f1291b = j;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1292c.m2849b(this.f1290a, this.f1291b);
    }
}
