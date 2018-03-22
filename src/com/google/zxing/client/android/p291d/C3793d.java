package com.google.zxing.client.android.p291d;

import android.app.Activity;
import com.google.zxing.C3934m;
import com.google.zxing.client.android.C3817n;
import com.google.zxing.client.p285a.C3743q;

/* compiled from: TextResultHandler */
public final class C3793d extends C3790a {
    private int[] f14749a = null;
    private C3817n f14750b = null;

    public C3793d(Activity activity, C3743q c3743q, C3934m c3934m) {
        super(activity, c3743q, c3934m);
        this.f14750b = new C3817n(activity);
        this.f14749a = new int[]{this.f14750b.m19057a("sns_sweep"), this.f14750b.m19057a("sns_sweep"), this.f14750b.m19057a("sns_sweep"), this.f14750b.m19057a("sns_sweep")};
    }
}
