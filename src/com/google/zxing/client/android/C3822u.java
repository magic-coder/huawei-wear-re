package com.google.zxing.client.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.KeyEvent;

/* compiled from: QRProgressDialog */
class C3822u extends ProgressDialog {
    private boolean f14835a;
    private C3809t f14836b;

    public C3822u(Context context, boolean z, C3809t c3809t) {
        super(context);
        this.f14835a = z;
        this.f14836b = c3809t;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 4) {
                if (this.f14836b != null) {
                    this.f14836b.mo4314a();
                }
                if (!this.f14835a) {
                    return true;
                }
            } else if (keyEvent.getKeyCode() != 3) {
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
