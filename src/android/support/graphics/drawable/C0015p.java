package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;

/* compiled from: VectorDrawableCompat */
class C0015p extends ConstantState {
    private final ConstantState f100a;

    public C0015p(ConstantState constantState) {
        this.f100a = constantState;
    }

    public Drawable newDrawable() {
        Drawable vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.f100a.newDrawable();
        return vectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources) {
        Drawable vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.f100a.newDrawable(resources);
        return vectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources, Theme theme) {
        Drawable vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.f100a.newDrawable(resources, theme);
        return vectorDrawableCompat;
    }

    public boolean canApplyTheme() {
        return this.f100a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.f100a.getChangingConfigurations();
    }
}
