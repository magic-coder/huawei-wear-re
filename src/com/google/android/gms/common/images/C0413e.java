package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.C0430l;
import com.google.android.gms.internal.ck;

public abstract class C0413e {
    final C0414f f354a;
    protected int f355b;

    private Drawable m509a(Context context, ck ckVar, int i) {
        return context.getResources().getDrawable(i);
    }

    void m510a(Context context, Bitmap bitmap, boolean z) {
        C0430l.m676a((Object) bitmap);
        mo1757a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void m511a(Context context, ck ckVar, boolean z) {
        Drawable drawable = null;
        if (this.f355b != 0) {
            drawable = m509a(context, ckVar, this.f355b);
        }
        mo1757a(drawable, z, false, false);
    }

    protected abstract void mo1757a(Drawable drawable, boolean z, boolean z2, boolean z3);
}
