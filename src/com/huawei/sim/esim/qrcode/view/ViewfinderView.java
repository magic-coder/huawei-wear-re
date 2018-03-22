package com.huawei.sim.esim.qrcode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.C3922o;
import com.huawei.sim.e;
import com.huawei.sim.esim.qrcode.p506a.C5905c;
import com.huawei.sim.f;
import java.util.Collection;
import java.util.HashSet;

public final class ViewfinderView extends View {
    private final Paint f20284a = new Paint();
    private final int f20285b;
    private final int f20286c;
    private int f20287d = 0;
    private Collection<C3922o> f20288e;
    private Collection<C3922o> f20289f;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f20286c = resources.getColor(e.sim_qrcode_result_view);
        this.f20285b = resources.getColor(e.sim_qrcode_possible_result_points);
        this.f20289f = new HashSet(5);
    }

    public void onDraw(Canvas canvas) {
        Rect f = C5905c.m27159a().m27169f();
        if (f != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f20284a.setColor(this.f20286c);
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) (f.top + 50), this.f20284a);
            canvas.drawRect(0.0f, (float) (f.top + 50), (float) (f.left + 50), (float) (f.bottom - 50), this.f20284a);
            canvas.drawRect((float) (f.right - 50), (float) (f.top + 50), (float) width, (float) (f.bottom - 50), this.f20284a);
            canvas.drawRect(0.0f, (float) (f.bottom - 50), (float) width, (float) height, this.f20284a);
            Rect rect = new Rect(f.left + 50, f.top + 50, f.right - 50, f.bottom - 50);
            Bitmap decodeStream = BitmapFactory.decodeStream(getResources().openRawResource(f.kw_pic_qrcode_codemask));
            if (decodeStream != null) {
                canvas.drawBitmap(decodeStream, null, rect, this.f20284a);
                decodeStream.setHasAlpha(true);
            }
            int i = (f.top + 50) + this.f20287d;
            Bitmap decodeStream2 = BitmapFactory.decodeStream(getResources().openRawResource(f.qrcode_scan));
            Rect rect2 = new Rect(f.left - 5, i - 6, f.right + 5, i + 35);
            if (decodeStream2 != null) {
                canvas.drawBitmap(decodeStream2, null, rect2, this.f20284a);
            }
            this.f20287d += 6;
            if (i > (f.bottom - 50) - 25) {
                this.f20287d = 0;
            }
            Collection<C3922o> collection = this.f20289f;
            Collection<C3922o> collection2 = this.f20288e;
            if (collection.isEmpty()) {
                this.f20288e = null;
            } else {
                this.f20289f = new HashSet(5);
                this.f20288e = collection;
                this.f20284a.setAlpha(255);
                this.f20284a.setColor(this.f20285b);
                for (C3922o c3922o : collection) {
                    canvas.drawCircle(((float) f.left) + c3922o.m19522a(), c3922o.m19523b() + ((float) f.top), 6.0f, this.f20284a);
                }
            }
            if (collection2 != null) {
                this.f20284a.setAlpha(127);
                this.f20284a.setColor(this.f20285b);
                for (C3922o c3922o2 : collection2) {
                    canvas.drawCircle(((float) f.left) + c3922o2.m19522a(), c3922o2.m19523b() + ((float) f.top), 3.0f, this.f20284a);
                }
            }
            if (decodeStream2 != null) {
                decodeStream2.recycle();
            }
            if (decodeStream != null) {
                decodeStream.recycle();
            }
            postInvalidateDelayed(20, f.left, f.top, f.right, f.bottom);
        }
    }

    public void m27184a(C3922o c3922o) {
        this.f20289f.add(c3922o);
    }

    public void m27183a() {
        invalidate();
    }
}
