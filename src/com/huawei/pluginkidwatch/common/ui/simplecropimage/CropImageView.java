package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.android.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView extends C1539q {
    ArrayList<C1554o> f3685a = new ArrayList();
    C1554o f3686b = null;
    float f3687c;
    float f3688d;
    int f3689e;
    private Context f3690q;

    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public /* bridge */ /* synthetic */ void setRecycler(C1558t c1558t) {
        super.setRecycler(c1558t);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.h.m7171b() != null) {
            Iterator it = this.f3685a.iterator();
            while (it.hasNext()) {
                C1554o c1554o = (C1554o) it.next();
                c1554o.f3721f.set(getImageMatrix());
                c1554o.m7157c();
                if (c1554o.f3717b) {
                    m7122c(c1554o);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3690q = context;
    }

    protected void mo2534a(float f, float f2, float f3) {
        super.mo2534a(f, f2, f3);
        Iterator it = this.f3685a.iterator();
        while (it.hasNext()) {
            C1554o c1554o = (C1554o) it.next();
            c1554o.f3721f.set(getImageMatrix());
            c1554o.m7157c();
        }
    }

    protected void mo2533a(float f, float f2) {
        super.mo2533a(f, f2);
        for (int i = 0; i < this.f3685a.size(); i++) {
            C1554o c1554o = (C1554o) this.f3685a.get(i);
            c1554o.f3721f.postTranslate(f, f2);
            c1554o.m7157c();
        }
    }

    private void m7115a(MotionEvent motionEvent) {
        int i = 0;
        for (int i2 = 0; i2 < this.f3685a.size(); i2++) {
            C1554o c1554o = (C1554o) this.f3685a.get(i2);
            c1554o.m7152a(false);
            c1554o.m7157c();
        }
        while (i < this.f3685a.size()) {
            c1554o = (C1554o) this.f3685a.get(i);
            if (c1554o.m7147a(motionEvent.getX(), motionEvent.getY()) != 1) {
                if (!c1554o.m7153a()) {
                    c1554o.m7152a(true);
                    c1554o.m7157c();
                }
                invalidate();
            }
            i++;
        }
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        CropImage cropImage = (CropImage) this.f3690q;
        if (cropImage.f3651b) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m7119b(motionEvent, cropImage);
                break;
            case 1:
                if (m7117a(cropImage)) {
                    return true;
                }
                break;
            case 2:
                m7116a(motionEvent, cropImage);
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                m7113a(true, true);
                break;
            case 2:
                if (getScale() == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                    m7113a(true, true);
                    break;
                }
                break;
        }
        return true;
    }

    private void m7116a(MotionEvent motionEvent, CropImage cropImage) {
        if (cropImage.f3650a) {
            m7115a(motionEvent);
        } else if (this.f3686b != null) {
            this.f3686b.m7148a(this.f3689e, motionEvent.getX() - this.f3687c, motionEvent.getY() - this.f3688d);
            this.f3687c = motionEvent.getX();
            this.f3688d = motionEvent.getY();
            m7120b(this.f3686b);
        }
    }

    private boolean m7117a(CropImage cropImage) {
        if (cropImage.f3650a) {
            if (m7121b(cropImage)) {
                return true;
            }
        } else if (this.f3686b != null) {
            m7122c(this.f3686b);
            this.f3686b.m7151a(C1555p.None);
        }
        this.f3686b = null;
        return false;
    }

    private boolean m7121b(CropImage cropImage) {
        for (int i = 0; i < this.f3685a.size(); i++) {
            C1554o c1554o = (C1554o) this.f3685a.get(i);
            if (c1554o.m7153a()) {
                return m7118a(cropImage, i, c1554o);
            }
        }
        return false;
    }

    private boolean m7118a(CropImage cropImage, int i, C1554o c1554o) {
        cropImage.f3652c = c1554o;
        for (int i2 = 0; i2 < this.f3685a.size(); i2++) {
            if (i2 != i) {
                ((C1554o) this.f3685a.get(i2)).m7156b(true);
            }
        }
        m7122c(c1554o);
        ((CropImage) this.f3690q).f3650a = false;
        return true;
    }

    private void m7119b(MotionEvent motionEvent, CropImage cropImage) {
        if (cropImage.f3650a) {
            m7115a(motionEvent);
            return;
        }
        for (int i = 0; i < this.f3685a.size(); i++) {
            C1554o c1554o = (C1554o) this.f3685a.get(i);
            int a = c1554o.m7147a(motionEvent.getX(), motionEvent.getY());
            if (a != 1) {
                this.f3689e = a;
                this.f3686b = c1554o;
                this.f3687c = motionEvent.getX();
                this.f3688d = motionEvent.getY();
                this.f3686b.m7151a(a == 32 ? C1555p.Move : C1555p.Grow);
                return;
            }
        }
    }

    private void m7120b(C1554o c1554o) {
        Rect rect = c1554o.f3719d;
        int max = Math.max(0, this.l - rect.left);
        int min = Math.min(0, this.m - rect.right);
        int max2 = Math.max(0, this.n - rect.top);
        int min2 = Math.min(0, this.o - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max != 0 || max2 != 0) {
            m7114b((float) max, (float) max2);
        }
    }

    private void m7122c(C1554o c1554o) {
        Rect rect = c1554o.f3719d;
        float width = (float) getWidth();
        float max = Math.max(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, Math.min((width / ((float) rect.width())) * 0.6f, (((float) getHeight()) / ((float) rect.height())) * 0.6f) * getScale());
        if (((double) (Math.abs(max - getScale()) / max)) > 0.1d) {
            float[] fArr = new float[]{c1554o.f3720e.centerX(), c1554o.f3720e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m7110a(max, fArr[0], fArr[1], BitmapDescriptorFactory.HUE_MAGENTA);
        }
        m7120b(c1554o);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f3685a.size(); i++) {
            ((C1554o) this.f3685a.get(i)).m7149a(canvas);
        }
    }

    public void m7126a(C1554o c1554o) {
        this.f3685a.add(c1554o);
        invalidate();
    }
}
