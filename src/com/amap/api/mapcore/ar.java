package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.LatLng;

/* compiled from: LocationView */
class ar extends LinearLayout {
    Bitmap f10916a;
    Bitmap f10917b;
    Bitmap f10918c;
    Bitmap f10919d;
    Bitmap f10920e;
    Bitmap f10921f;
    ImageView f10922g;
    aa f10923h;
    boolean f10924i = false;

    /* compiled from: LocationView */
    class C32351 implements OnTouchListener {
        final /* synthetic */ ar f10915a;

        C32351(ar arVar) {
            this.f10915a = arVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f10915a.f10924i) {
                if (motionEvent.getAction() == 0) {
                    this.f10915a.f10922g.setImageBitmap(this.f10915a.f10917b);
                } else if (motionEvent.getAction() == 1) {
                    try {
                        this.f10915a.f10922g.setImageBitmap(this.f10915a.f10916a);
                        this.f10915a.f10923h.mo3828k(true);
                        Location y = this.f10915a.f10923h.mo3842y();
                        if (y != null) {
                            LatLng latLng = new LatLng(y.getLatitude(), y.getLongitude());
                            this.f10915a.f10923h.mo3774a(y);
                            this.f10915a.f10923h.mo3776a(C3259o.m15330a(latLng, this.f10915a.f10923h.mo3740E()));
                        }
                    } catch (Throwable th) {
                        ca.m15831a(th, "LocationView", "onTouch");
                        th.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    public void m14827a() {
        try {
            if (this.f10916a != null) {
                this.f10916a.recycle();
            }
            if (this.f10917b != null) {
                this.f10917b.recycle();
            }
            if (this.f10917b != null) {
                this.f10918c.recycle();
            }
            this.f10916a = null;
            this.f10917b = null;
            this.f10918c = null;
            if (this.f10919d != null) {
                this.f10919d.recycle();
                this.f10919d = null;
            }
            if (this.f10920e != null) {
                this.f10920e.recycle();
                this.f10920e = null;
            }
            if (this.f10921f != null) {
                this.f10921f.recycle();
                this.f10921f = null;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public ar(Context context) {
        super(context);
    }

    public ar(Context context, au auVar, aa aaVar) {
        super(context);
        this.f10923h = aaVar;
        try {
            this.f10919d = bk.m15648a(context, "location_selected.png");
            this.f10916a = bk.m15649a(this.f10919d, C3264r.f11365a);
            this.f10920e = bk.m15648a(context, "location_pressed.png");
            this.f10917b = bk.m15649a(this.f10920e, C3264r.f11365a);
            this.f10921f = bk.m15648a(context, "location_unselected.png");
            this.f10918c = bk.m15649a(this.f10921f, C3264r.f11365a);
        } catch (Throwable th) {
            ca.m15831a(th, "LocationView", "create");
            th.printStackTrace();
        }
        this.f10922g = new ImageView(context);
        this.f10922g.setImageBitmap(this.f10916a);
        this.f10922g.setClickable(true);
        this.f10922g.setPadding(0, 20, 20, 0);
        this.f10922g.setOnTouchListener(new C32351(this));
        addView(this.f10922g);
    }

    public void m14828a(boolean z) {
        this.f10924i = z;
        if (z) {
            this.f10922g.setImageBitmap(this.f10916a);
        } else {
            this.f10922g.setImageBitmap(this.f10918c);
        }
        this.f10922g.invalidate();
    }
}
