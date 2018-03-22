package android.support.graphics.drawable;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

/* compiled from: AnimatedVectorDrawableCompat */
class C0003c extends ConstantState {
    int f36a;
    VectorDrawableCompat f37b;
    ArrayList<Animator> f38c;
    ArrayMap<Animator, String> f39d;

    public C0003c(Context context, C0003c c0003c, Callback callback, Resources resources) {
        int i = 0;
        if (c0003c != null) {
            this.f36a = c0003c.f36a;
            if (c0003c.f37b != null) {
                ConstantState constantState = c0003c.f37b.getConstantState();
                if (resources != null) {
                    this.f37b = (VectorDrawableCompat) constantState.newDrawable(resources);
                } else {
                    this.f37b = (VectorDrawableCompat) constantState.newDrawable();
                }
                this.f37b = (VectorDrawableCompat) this.f37b.mutate();
                this.f37b.setCallback(callback);
                this.f37b.setBounds(c0003c.f37b.getBounds());
                this.f37b.setAllowCaching(false);
            }
            if (c0003c.f38c != null) {
                int size = c0003c.f38c.size();
                this.f38c = new ArrayList(size);
                this.f39d = new ArrayMap(size);
                while (i < size) {
                    Animator animator = (Animator) c0003c.f38c.get(i);
                    Animator clone = animator.clone();
                    String str = (String) c0003c.f39d.get(animator);
                    clone.setTarget(this.f37b.getTargetByName(str));
                    this.f38c.add(clone);
                    this.f39d.put(clone, str);
                    i++;
                }
            }
        }
    }

    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public int getChangingConfigurations() {
        return this.f36a;
    }
}
