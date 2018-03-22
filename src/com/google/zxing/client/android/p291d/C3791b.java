package com.google.zxing.client.android.p291d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

/* compiled from: ResultHandler */
class C3791b implements OnClickListener {
    final /* synthetic */ C3790a f14747a;

    C3791b(C3790a c3790a) {
        this.f14747a = c3790a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14747a.m19022b(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.shopper&referrer=utm_source%3Dbarcodescanner%26utm_medium%3Dapps%26utm_campaign%3Dscan")));
    }
}
