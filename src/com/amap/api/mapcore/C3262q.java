package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.CameraPosition;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.MapProjection;

/* compiled from: CompassView */
class C3262q extends LinearLayout {
    Bitmap f11355a;
    Bitmap f11356b;
    Bitmap f11357c;
    ImageView f11358d;
    aa f11359e;

    /* compiled from: CompassView */
    class C32611 implements OnTouchListener {
        final /* synthetic */ C3262q f11354a;

        C32611(C3262q c3262q) {
            this.f11354a = c3262q;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (this.f11354a.f11359e.mo3749R()) {
                    if (motionEvent.getAction() == 0) {
                        this.f11354a.f11358d.setImageBitmap(this.f11354a.f11356b);
                    } else if (motionEvent.getAction() == 1) {
                        this.f11354a.f11358d.setImageBitmap(this.f11354a.f11355a);
                        CameraPosition q = this.f11354a.f11359e.mo3834q();
                        this.f11354a.f11359e.mo3806b(C3259o.m15328a(new CameraPosition(q.target, q.zoom, 0.0f, 0.0f)));
                    }
                }
            } catch (Throwable th) {
                ca.m15831a(th, "CompassView", "onTouch");
                th.printStackTrace();
            }
            return false;
        }
    }

    public void m15368a() {
        try {
            if (this.f11355a != null) {
                this.f11355a.recycle();
            }
            if (this.f11356b != null) {
                this.f11356b.recycle();
            }
            if (this.f11357c != null) {
                this.f11357c.recycle();
            }
            this.f11357c = null;
            this.f11355a = null;
            this.f11356b = null;
        } catch (Throwable th) {
            ca.m15831a(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public C3262q(Context context) {
        super(context);
    }

    public C3262q(Context context, au auVar, aa aaVar) {
        super(context);
        this.f11359e = aaVar;
        try {
            this.f11357c = bk.m15648a(context, "maps_dav_compass_needle_large.png");
            this.f11356b = bk.m15649a(this.f11357c, C3264r.f11365a * 0.8f);
            this.f11357c = bk.m15649a(this.f11357c, C3264r.f11365a * 0.7f);
            this.f11355a = Bitmap.createBitmap(this.f11356b.getWidth(), this.f11356b.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f11355a);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(this.f11357c, ((float) (this.f11356b.getWidth() - this.f11357c.getWidth())) / 2.0f, ((float) (this.f11356b.getHeight() - this.f11357c.getHeight())) / 2.0f, paint);
            this.f11358d = new ImageView(context);
            this.f11358d.setScaleType(ScaleType.MATRIX);
            this.f11358d.setImageBitmap(this.f11355a);
            this.f11358d.setClickable(true);
            m15369b();
            this.f11358d.setOnTouchListener(new C32611(this));
            addView(this.f11358d);
        } catch (Throwable th) {
            ca.m15831a(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public void m15369b() {
        try {
            MapProjection c = this.f11359e.mo3809c();
            float mapAngle = c.getMapAngle();
            float cameraHeaderAngle = c.getCameraHeaderAngle();
            Matrix matrix = new Matrix();
            matrix.postRotate(-mapAngle, ((float) this.f11358d.getDrawable().getBounds().width()) / 2.0f, ((float) this.f11358d.getDrawable().getBounds().height()) / 2.0f);
            matrix.postScale(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) Math.cos((((double) cameraHeaderAngle) * 3.141592653589793d) / 180.0d), ((float) this.f11358d.getDrawable().getBounds().width()) / 2.0f, ((float) this.f11358d.getDrawable().getBounds().height()) / 2.0f);
            this.f11358d.setImageMatrix(matrix);
        } catch (Throwable th) {
            ca.m15831a(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
