package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.internal.bn;

final class ac extends aa {
    final /* synthetic */ Intent f361a;
    final /* synthetic */ bn f362b;
    final /* synthetic */ int f363c;

    ac(Intent intent, bn bnVar, int i) {
        this.f361a = intent;
        this.f362b = bnVar;
        this.f363c = i;
    }

    public void mo1758a() {
        if (this.f361a != null) {
            this.f362b.startActivityForResult(this.f361a, this.f363c);
        }
    }
}
