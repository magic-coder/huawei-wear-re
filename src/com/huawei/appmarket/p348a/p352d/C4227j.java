package com.huawei.appmarket.p348a.p352d;

import android.content.Context;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

public class C4227j implements Runnable {
    private C4220c f15863a;
    private Context f15864b;

    public C4227j(Context context, C4220c c4220c) {
        this.f15864b = context;
        this.f15863a = c4220c;
    }

    public void run() {
        C4241a.m20529a("PackageManagerRunnable", "PackageManagerRunnable run!!!!" + this.f15863a.toString());
        switch (C4228k.f15865a[this.f15863a.f15844h.ordinal()]) {
            case 1:
                C4219b.m20487a(this.f15864b, this.f15863a);
                return;
            default:
                return;
        }
    }
}
