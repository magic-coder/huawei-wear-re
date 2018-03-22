package com.huawei.pluginkidwatch.plugin.setting.qrcode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.o;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a.C1947d;
import java.util.Collection;
import java.util.HashSet;

public final class ViewfinderView extends View {
    private final Paint f6828a = new Paint();
    private final int f6829b;
    private final int f6830c;
    private int f6831d = 0;
    private Collection<o> f6832e;
    private Collection<o> f6833f;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f6829b = resources.getColor(d.qrcode_result_view);
        this.f6830c = resources.getColor(d.qrcode_possible_result_points);
        this.f6832e = new HashSet(5);
    }

    public void onDraw(Canvas canvas) {
        Rect f = C1947d.m10193a().m10203f();
        if (f != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f6828a.setColor(this.f6829b);
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) (f.top + 50), this.f6828a);
            canvas.drawRect(0.0f, (float) (f.top + 50), (float) (f.left + 50), (float) (f.bottom - 50), this.f6828a);
            canvas.drawRect((float) (f.right - 50), (float) (f.top + 50), (float) width, (float) (f.bottom - 50), this.f6828a);
            canvas.drawRect(0.0f, (float) (f.bottom - 50), (float) width, (float) height, this.f6828a);
            Rect rect = new Rect(f.left + 50, f.top + 50, f.right - 50, f.bottom - 50);
            Bitmap decodeStream = BitmapFactory.decodeStream(getResources().openRawResource(C1617f.kw_pic_qrcode_codemask));
            if (decodeStream != null) {
                canvas.drawBitmap(decodeStream, null, rect, this.f6828a);
                decodeStream.setHasAlpha(true);
            }
            int i = (f.top + 50) + this.f6831d;
            Bitmap decodeStream2 = BitmapFactory.decodeStream(getResources().openRawResource(C1617f.qrcode_scan));
            Rect rect2 = new Rect(f.left - 5, i - 6, f.right + 5, i + 35);
            if (decodeStream2 != null) {
                canvas.drawBitmap(decodeStream2, null, rect2, this.f6828a);
            }
            this.f6831d += 6;
            if (i > (f.bottom - 50) - 25) {
                this.f6831d = 0;
            }
            Collection<o> collection = this.f6832e;
            Collection<o> collection2 = this.f6833f;
            if (collection.isEmpty()) {
                this.f6833f = null;
            } else {
                this.f6832e = new HashSet(5);
                this.f6833f = collection;
                this.f6828a.setAlpha(255);
                this.f6828a.setColor(this.f6830c);
                for (o oVar : collection) {
                    canvas.drawCircle(((float) f.left) + oVar.a(), oVar.b() + ((float) f.top), 6.0f, this.f6828a);
                }
            }
            if (collection2 != null) {
                this.f6828a.setAlpha(127);
                this.f6828a.setColor(this.f6830c);
                for (o oVar2 : collection2) {
                    canvas.drawCircle(((float) f.left) + oVar2.a(), oVar2.b() + ((float) f.top), 3.0f, this.f6828a);
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

    public void m10232a() {
        invalidate();
    }

    public void m10233a(o oVar) {
        this.f6832e.add(oVar);
    }
}
