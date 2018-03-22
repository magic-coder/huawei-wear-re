package com.tencent.connect.share;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.open.p532d.C6295g;
import com.tencent.tauth.C6252b;
import java.util.ArrayList;

/* compiled from: ProGuard */
class C6299e implements C6295g {
    final /* synthetic */ Bundle f21898a;
    final /* synthetic */ Activity f21899b;
    final /* synthetic */ C6252b f21900c;
    final /* synthetic */ C6298d f21901d;

    C6299e(C6298d c6298d, Bundle bundle, Activity activity, C6252b c6252b) {
        this.f21901d = c6298d;
        this.f21898a = bundle;
        this.f21899b = activity;
        this.f21900c = c6252b;
    }

    public void mo5300a(int i, String str) {
    }

    public void mo5301a(int i, ArrayList<String> arrayList) {
        if (i == 0) {
            this.f21898a.putStringArrayList("imageUrl", arrayList);
        }
        this.f21901d.m28894b(this.f21899b, this.f21898a, this.f21900c);
    }
}
