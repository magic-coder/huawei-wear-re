package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class ab extends aa {
    final /* synthetic */ Intent f358a;
    final /* synthetic */ Activity f359b;
    final /* synthetic */ int f360c;

    ab(Intent intent, Activity activity, int i) {
        this.f358a = intent;
        this.f359b = activity;
        this.f360c = i;
    }

    public void mo1758a() {
        if (this.f358a != null) {
            this.f359b.startActivityForResult(this.f358a, this.f360c);
        }
    }
}
