package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;

/* compiled from: ZoomControllerView */
class br extends LinearLayout {
    private Bitmap f11206a;
    private Bitmap f11207b;
    private Bitmap f11208c;
    private Bitmap f11209d;
    private Bitmap f11210e;
    private Bitmap f11211f;
    private Bitmap f11212g;
    private Bitmap f11213h;
    private Bitmap f11214i;
    private Bitmap f11215j;
    private Bitmap f11216k;
    private Bitmap f11217l;
    private ImageView f11218m;
    private ImageView f11219n;
    private aa f11220o;

    /* compiled from: ZoomControllerView */
    class C32431 implements OnTouchListener {
        final /* synthetic */ br f11204a;

        C32431(br brVar) {
            this.f11204a = brVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f11204a.f11220o.mo3740E() < this.f11204a.f11220o.mo3835r() && this.f11204a.f11220o.mo3749R()) {
                if (motionEvent.getAction() == 0) {
                    this.f11204a.f11218m.setImageBitmap(this.f11204a.f11210e);
                } else if (motionEvent.getAction() == 1) {
                    this.f11204a.f11218m.setImageBitmap(this.f11204a.f11206a);
                    try {
                        this.f11204a.f11220o.mo3806b(C3259o.m15336b());
                    } catch (Throwable e) {
                        ca.m15831a(e, "ZoomControllerView", "zoomin ontouch");
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: ZoomControllerView */
    class C32442 implements OnTouchListener {
        final /* synthetic */ br f11205a;

        C32442(br brVar) {
            this.f11205a = brVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f11205a.f11220o.mo3740E() > this.f11205a.f11220o.mo3836s() && this.f11205a.f11220o.mo3749R()) {
                if (motionEvent.getAction() == 0) {
                    this.f11205a.f11219n.setImageBitmap(this.f11205a.f11211f);
                } else if (motionEvent.getAction() == 1) {
                    this.f11205a.f11219n.setImageBitmap(this.f11205a.f11208c);
                    try {
                        this.f11205a.f11220o.mo3806b(C3259o.m15338c());
                    } catch (Throwable e) {
                        ca.m15831a(e, "ZoomControllerView", "zoomout ontouch");
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    public void m15263a() {
        try {
            this.f11206a.recycle();
            this.f11207b.recycle();
            this.f11208c.recycle();
            this.f11209d.recycle();
            this.f11210e.recycle();
            this.f11211f.recycle();
            this.f11206a = null;
            this.f11207b = null;
            this.f11208c = null;
            this.f11209d = null;
            this.f11210e = null;
            this.f11211f = null;
            if (this.f11212g != null) {
                this.f11212g.recycle();
                this.f11212g = null;
            }
            if (this.f11213h != null) {
                this.f11213h.recycle();
                this.f11213h = null;
            }
            if (this.f11214i != null) {
                this.f11214i.recycle();
                this.f11214i = null;
            }
            if (this.f11215j != null) {
                this.f11215j.recycle();
                this.f11212g = null;
            }
            if (this.f11216k != null) {
                this.f11216k.recycle();
                this.f11216k = null;
            }
            if (this.f11217l != null) {
                this.f11217l.recycle();
                this.f11217l = null;
            }
            removeAllViews();
            this.f11218m = null;
            this.f11219n = null;
        } catch (Throwable th) {
            ca.m15831a(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public br(Context context) {
        super(context);
    }

    public br(Context context, aa aaVar) {
        super(context);
        this.f11220o = aaVar;
        try {
            this.f11212g = bk.m15648a(context, "zoomin_selected.png");
            this.f11206a = bk.m15649a(this.f11212g, C3264r.f11365a);
            this.f11213h = bk.m15648a(context, "zoomin_unselected.png");
            this.f11207b = bk.m15649a(this.f11213h, C3264r.f11365a);
            this.f11214i = bk.m15648a(context, "zoomout_selected.png");
            this.f11208c = bk.m15649a(this.f11214i, C3264r.f11365a);
            this.f11215j = bk.m15648a(context, "zoomout_unselected.png");
            this.f11209d = bk.m15649a(this.f11215j, C3264r.f11365a);
            this.f11216k = bk.m15648a(context, "zoomin_pressed.png");
            this.f11210e = bk.m15649a(this.f11216k, C3264r.f11365a);
            this.f11217l = bk.m15648a(context, "zoomout_pressed.png");
            this.f11211f = bk.m15649a(this.f11217l, C3264r.f11365a);
            this.f11218m = new ImageView(context);
            this.f11218m.setImageBitmap(this.f11206a);
            this.f11218m.setClickable(true);
            this.f11219n = new ImageView(context);
            this.f11219n.setImageBitmap(this.f11208c);
            this.f11219n.setClickable(true);
        } catch (Throwable th) {
            ca.m15831a(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
        this.f11218m.setOnTouchListener(new C32431(this));
        this.f11219n.setOnTouchListener(new C32442(this));
        this.f11218m.setPadding(0, 0, 20, -2);
        this.f11219n.setPadding(0, 0, 20, 20);
        setOrientation(1);
        addView(this.f11218m);
        addView(this.f11219n);
    }

    public void m15264a(float f) {
        if (f < this.f11220o.mo3835r() && f > this.f11220o.mo3836s()) {
            this.f11218m.setImageBitmap(this.f11206a);
            this.f11219n.setImageBitmap(this.f11208c);
        } else if (f == this.f11220o.mo3836s()) {
            this.f11219n.setImageBitmap(this.f11209d);
            this.f11218m.setImageBitmap(this.f11206a);
        } else if (f == this.f11220o.mo3835r()) {
            this.f11218m.setImageBitmap(this.f11207b);
            this.f11219n.setImageBitmap(this.f11208c);
        }
    }
}
