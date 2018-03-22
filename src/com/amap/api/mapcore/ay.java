package com.amap.api.mapcore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: MapOverlayViewGroup */
class ay extends ViewGroup {
    private aa f10746a;

    /* compiled from: MapOverlayViewGroup */
    public class C3237a extends LayoutParams {
        public FPoint f10950a = null;
        public int f10951b = 0;
        public int f10952c = 0;
        public int f10953d = 51;

        public C3237a(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.f10950a = fPoint;
            this.f10951b = i3;
            this.f10952c = i4;
            this.f10953d = i5;
        }

        public C3237a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3237a(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ay(Context context) {
        super(context);
    }

    public ay(Context context, aa aaVar) {
        super(context);
        this.f10746a = aaVar;
        setBackgroundColor(-1);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                if (childAt.getLayoutParams() instanceof C3237a) {
                    m14178a(childAt, (C3237a) childAt.getLayoutParams());
                } else {
                    m14177a(childAt, childAt.getLayoutParams());
                }
            }
        }
    }

    private void m14177a(View view, LayoutParams layoutParams) {
        int[] iArr = new int[2];
        m14176a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof aq) {
            m14175a(view, iArr[0], iArr[1], 20, (this.f10746a.mo3742I().y - 80) - iArr[1], 51);
            return;
        }
        m14175a(view, iArr[0], iArr[1], 0, 0, 51);
    }

    private void m14178a(View view, C3237a c3237a) {
        int[] iArr = new int[2];
        m14176a(view, c3237a.width, c3237a.height, iArr);
        if (view instanceof br) {
            m14175a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), c3237a.f10953d);
        } else if (view instanceof ar) {
            m14175a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], c3237a.f10953d);
        } else if (view instanceof C3262q) {
            m14175a(view, iArr[0], iArr[1], 0, 0, c3237a.f10953d);
        } else if (c3237a.f10950a != null) {
            IPoint iPoint = new IPoint();
            this.f10746a.mo3809c().map2Win(c3237a.f10950a.f13252x, c3237a.f10950a.f13253y, iPoint);
            iPoint.f13273x += c3237a.f10951b;
            iPoint.f13274y += c3237a.f10952c;
            m14175a(view, iArr[0], iArr[1], iPoint.f13273x, iPoint.f13274y, c3237a.f10953d);
            if (view.getVisibility() == 0) {
                mo3673a();
            }
        }
    }

    protected void mo3673a() {
    }

    private void m14176a(View view, int i, int i2, int[] iArr) {
        if (view instanceof ListView) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                iArr[0] = view2.getWidth();
                iArr[1] = view2.getHeight();
            }
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void m14175a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 & 7;
        int i7 = i5 & 112;
        if (i6 == 5) {
            i3 -= i;
        } else if (i6 == 1) {
            i3 -= i / 2;
        }
        if (i7 == 80) {
            i4 -= i2;
        } else if (i7 == 17) {
            i4 -= i2 / 2;
        } else if (i7 == 16) {
            i4 = (i4 / 2) - (i2 / 2);
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
    }
}
