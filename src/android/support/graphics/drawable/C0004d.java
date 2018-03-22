package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: AnimatedVectorDrawableCompat */
class C0004d extends ConstantState {
    private final ConstantState f40a;

    public C0004d(ConstantState constantState) {
        this.f40a = constantState;
    }

    public Drawable newDrawable() {
        Drawable animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        animatedVectorDrawableCompat.mDelegateDrawable = this.f40a.newDrawable();
        animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources) {
        Drawable animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        animatedVectorDrawableCompat.mDelegateDrawable = this.f40a.newDrawable(resources);
        animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources, Theme theme) {
        Drawable animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        animatedVectorDrawableCompat.mDelegateDrawable = this.f40a.newDrawable(resources, theme);
        animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }

    public boolean canApplyTheme() {
        return this.f40a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.f40a.getChangingConfigurations();
    }
}
