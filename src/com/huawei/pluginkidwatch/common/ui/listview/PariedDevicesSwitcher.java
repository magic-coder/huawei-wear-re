package com.huawei.pluginkidwatch.common.ui.listview;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public class PariedDevicesSwitcher extends AbsoluteLayout {
    private TextView f3586a;
    private ImageView f3587b;
    private ImageView f3588c;
    private ImageView f3589d;
    private boolean f3590e = true;
    private PopupWindow f3591f = null;
    private Context f3592g;
    private ListView f3593h = null;
    private C1529i f3594i = null;
    private View f3595j = null;
    private Animation f3596k;
    private Animation f3597l;
    private Handler f3598m = new Handler();
    private OnClickListener f3599n = new C1523c(this);
    private OnClickListener f3600o = new C1524d(this);

    public PariedDevicesSwitcher(Context context) {
        super(context);
        this.f3592g = context;
        m7019a(context);
    }

    public PariedDevicesSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3592g = context;
        m7019a(context);
    }

    public void setOnSwitcherClickListener(C1529i c1529i) {
        this.f3594i = c1529i;
    }

    public void setFocus(boolean z) {
        this.f3590e = z;
    }

    private boolean getFocus() {
        return this.f3590e;
    }

    private void m7019a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(h.commonui_paire_devices_switcher_layout, null);
        this.f3595j = ((LayoutInflater) this.f3592g.getSystemService("layout_inflater")).inflate(h.commonui_band_popwindow, null);
        this.f3588c = (ImageView) this.f3595j.findViewById(g.pop_null_title_space);
        this.f3589d = (ImageView) this.f3595j.findViewById(g.pop_null_content_space);
        this.f3593h = (ListView) this.f3595j.findViewById(g.deviceslist);
        this.f3586a = (TextView) inflate.findViewById(g.deviceName);
        this.f3587b = (ImageView) inflate.findViewById(g.switchPopDown);
        inflate.setOnClickListener(this.f3599n);
        addView(inflate);
    }

    private void m7020a(View view) {
        if (this.f3591f == null && this.f3595j != null) {
            this.f3588c.setOnClickListener(this.f3600o);
            this.f3589d.setOnClickListener(this.f3600o);
            this.f3591f = new PopupWindow(this.f3595j, -1, -1);
        }
        if (this.f3591f != null) {
            this.f3591f.setFocusable(true);
            this.f3591f.setBackgroundDrawable(new BitmapDrawable());
            this.f3591f.setOnDismissListener(new C1525e(this));
            this.f3591f.update();
            this.f3591f.showAtLocation(view, 49, 0, 0);
            m7018a();
        }
    }

    public ListView getListView() {
        return this.f3593h;
    }

    public void setDeviceName(String str) {
        this.f3586a.setText(str);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !getFocus()) {
            this.f3587b.setImageResource(C1617f.commonui_down_botton_list);
            m7024b();
            setFocus(true);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void m7029a(boolean z) {
        if (z) {
            m7024b();
        } else if (this.f3591f != null) {
            this.f3598m.post(new C1526f(this));
        }
        setFocus(true);
    }

    private void m7018a() {
        C2538c.m12674b("PariedDevicesSwitcher", "=====Enter showAnimation");
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, GroundOverlayOptions.NO_DIMENSION, 1, 0.0f);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setDuration(200);
        this.f3596k = animationSet;
        this.f3593h.startAnimation(this.f3596k);
    }

    private void m7024b() {
        C2538c.m12674b("PariedDevicesSwitcher", "=====Enter exitAnimation");
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, GroundOverlayOptions.NO_DIMENSION);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setDuration(200);
        this.f3597l = animationSet;
        this.f3597l.setAnimationListener(new C1527g(this));
        this.f3593h.startAnimation(this.f3597l);
    }
}
