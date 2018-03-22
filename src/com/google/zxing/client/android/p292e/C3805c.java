package com.google.zxing.client.android.p292e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.google.zxing.C3922o;
import com.google.zxing.client.android.p286a.C3775e;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: ViewfinderView */
public final class C3805c extends View {
    private static final int[] f14804a;
    private C3775e f14805b;
    private final Paint f14806c;
    private Bitmap f14807d;
    private final int f14808e;
    private final int f14809f;
    private final int f14810g;
    private List<C3922o> f14811h;
    private boolean f14812i;

    static {
        int[] iArr = new int[8];
        iArr[1] = 64;
        iArr[2] = 128;
        iArr[3] = 192;
        iArr[4] = 255;
        iArr[5] = 192;
        iArr[6] = 128;
        iArr[7] = 64;
        f14804a = iArr;
    }

    public void setCameraManager(C3775e c3775e) {
        this.f14805b = c3775e;
    }

    public void setHidenFrame(boolean z) {
        this.f14812i = z;
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        if (this.f14805b != null) {
            Rect e = this.f14805b.m18997e();
            if (e != null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                this.f14806c.setColor(this.f14807d != null ? this.f14809f : this.f14808e);
                canvas.drawRect(0.0f, 0.0f, (float) width, (float) e.top, this.f14806c);
                canvas.drawRect(0.0f, (float) e.top, (float) e.left, (float) (e.bottom + 1), this.f14806c);
                canvas.drawRect((float) (e.right + 1), (float) e.top, (float) width, (float) (e.bottom + 1), this.f14806c);
                canvas.drawRect(0.0f, (float) (e.bottom + 1), (float) width, (float) height, this.f14806c);
                if (this.f14807d != null) {
                    this.f14806c.setAlpha(SyslogAppender.LOG_LOCAL4);
                    canvas.drawBitmap(this.f14807d, (float) e.left, (float) e.top, this.f14806c);
                } else if (!this.f14812i) {
                    this.f14806c.setColor(this.f14810g);
                    canvas.drawRect((float) (e.left - 6), (float) (e.top - 6), (float) ((e.left + 6) - 6), (float) ((e.top + 50) - 6), this.f14806c);
                    canvas.drawRect((float) (e.left - 6), (float) (e.top - 6), (float) ((e.left + 50) - 6), (float) ((e.top + 6) - 6), this.f14806c);
                    canvas.drawRect((float) ((e.right - 6) + 6), (float) (e.top - 6), (float) ((e.right + 1) + 6), (float) ((e.top + 50) - 6), this.f14806c);
                    canvas.drawRect((float) ((e.right - 50) + 6), (float) (e.top - 6), (float) (e.right + 6), (float) ((e.top + 6) - 6), this.f14806c);
                    canvas.drawRect((float) (e.left - 6), (float) ((e.bottom - 49) + 6), (float) ((e.left + 6) - 6), (float) ((e.bottom + 1) + 6), this.f14806c);
                    canvas.drawRect((float) (e.left - 6), (float) ((e.bottom - 6) + 6), (float) ((e.left + 50) - 6), (float) ((e.bottom + 1) + 6), this.f14806c);
                    canvas.drawRect((float) ((e.right - 6) + 6), (float) ((e.bottom - 49) + 6), (float) ((e.right + 1) + 6), (float) ((e.bottom + 1) + 6), this.f14806c);
                    canvas.drawRect((float) ((e.right - 50) + 6), (float) ((e.bottom - 6) + 6), (float) (e.right + 6), (float) ((e.bottom + 1) + 6), this.f14806c);
                }
            }
        }
    }

    public void m19047a() {
        Bitmap bitmap = this.f14807d;
        this.f14807d = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public void m19048a(Bitmap bitmap) {
        this.f14807d = bitmap;
        invalidate();
    }

    public void m19049a(C3922o c3922o) {
        List list = this.f14811h;
        synchronized (list) {
            list.add(c3922o);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}
