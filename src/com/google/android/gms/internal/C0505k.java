package com.google.android.gms.internal;

import android.support.annotation.MainThread;
import com.google.android.gms.common.api.GoogleApiActivity;

class C0505k implements Runnable {
    final /* synthetic */ C0492i f800a;

    private C0505k(C0492i c0492i) {
        this.f800a = c0492i;
    }

    @MainThread
    public void run() {
        if (!this.f800a.f508a) {
            return;
        }
        if (this.f800a.f511e.hasResolution()) {
            this.f800a.d.startActivityForResult(GoogleApiActivity.m331b(this.f800a.m857f(), this.f800a.f511e.getResolution(), this.f800a.f512f, false), 1);
        } else if (this.f800a.f510c.mo1745a(this.f800a.f511e.getErrorCode())) {
            this.f800a.f510c.m438a(this.f800a.m857f(), this.f800a.d, this.f800a.f511e.getErrorCode(), 2, this.f800a);
        } else if (this.f800a.f511e.getErrorCode() == 18) {
            this.f800a.f510c.m432a(this.f800a.m857f().getApplicationContext(), new C0506l(this, this.f800a.f510c.m427a(this.f800a.m857f(), this.f800a)));
        } else {
            this.f800a.mo1800a(this.f800a.f511e, this.f800a.f512f);
        }
    }
}
