package com.huawei.wallet.ui.carddisplay;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hwcommonmodel.p064d.C0978h;

public class CardHolderLayout extends CardLayout {
    private int f21425q;
    private int f21426r;

    public CardHolderLayout(Context context) {
        this(context, null);
    }

    public CardHolderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardHolderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTopCardsCount(int i) {
        this.f21425q = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setInitBottomCardY(int i) {
        this.f21426r = i;
    }

    protected void mo5159a(int i) {
        View childAt = getChildAt(i);
        ObjectAnimator objectAnimator = null;
        if (this.a < this.f21425q) {
            if (i < this.f21425q) {
                objectAnimator = AnimUtil.m28148a(childAt, childAt.getY(), (float) (this.p + (this.m * this.a)), 50);
                this.a = i;
            }
        } else if (i >= this.f21425q) {
            int i2 = this.a - this.f21425q;
            objectAnimator = AnimUtil.m28148a(childAt, childAt.getY(), (float) ((i2 * this.m) + this.f21426r), 50);
            this.a = i;
        }
        if (objectAnimator != null) {
            objectAnimator.setInterpolator(this.o);
            objectAnimator.start();
        }
    }

    protected void mo5158a() {
        View childAt = getChildAt(this.a);
        if (childAt != null) {
            ObjectAnimator a;
            if (this.a < this.f21425q) {
                a = AnimUtil.m28148a(childAt, (float) (this.g - this.j), (float) (this.p + (this.a * this.m)), 50);
                a.setInterpolator(this.o);
                a.start();
                return;
            }
            int i = this.a - this.f21425q;
            a = AnimUtil.m28148a(childAt, (float) (this.g - this.j), (float) ((i * this.m) + this.f21426r), 50);
            a.setInterpolator(this.o);
            a.start();
        }
    }

    protected int mo5157a(int i, int i2, int i3) {
        int i4 = 0;
        while (i4 < i) {
            View childAt = getChildAt(i4);
            int height;
            if (i4 == i - 1 || i4 == this.f21425q - 1) {
                height = childAt.getHeight();
            } else {
                height = this.m;
            }
            if (childAt.getVisibility() == 0 && m28255a(childAt, i2, i3, r0)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    protected void mo5160b(int i) {
        int i2;
        View childAt;
        ObjectAnimator a;
        if (this.n == MoveDirection.DOWM_DIRECTION) {
            i2 = i + 1;
            if (i2 < getChildCount()) {
                childAt = getChildAt(i);
                if (this.a < this.f21425q) {
                    a = AnimUtil.m28148a(childAt, childAt.getY(), (float) (this.p + (this.a * this.m)), 50);
                } else {
                    a = AnimUtil.m28148a(childAt, childAt.getY(), (float) (this.f21426r + ((this.a - this.f21425q) * this.m)), 50);
                }
                a.addListener(new SwapAnimatorListener(this, i2));
                a.setInterpolator(this.o);
                a.start();
                return;
            }
            return;
        }
        i2 = i - 1;
        if (i2 >= 0) {
            childAt = getChildAt(i);
            if (this.a < this.f21425q) {
                a = AnimUtil.m28148a(childAt, childAt.getY(), (float) (this.p + (this.a * this.m)), 50);
            } else {
                a = AnimUtil.m28148a(childAt, childAt.getY(), (float) (this.f21426r + ((this.a - this.f21425q) * this.m)), 50);
            }
            a.addListener(new SwapAnimatorListener(this, i2));
            a.start();
        }
    }
}
