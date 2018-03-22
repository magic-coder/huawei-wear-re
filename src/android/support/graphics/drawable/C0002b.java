package android.support.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: AnimatedVectorDrawableCompat */
class C0002b implements Callback {
    final /* synthetic */ AnimatedVectorDrawableCompat f35a;

    C0002b(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.f35a = animatedVectorDrawableCompat;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f35a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f35a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f35a.unscheduleSelf(runnable);
    }
}
