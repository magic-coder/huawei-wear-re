package com.huawei.pluginkidwatch.common.ui.pulltorefreshview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.b;
import com.huawei.pluginkidwatch.g;

public class PullToRefreshLayout extends RelativeLayout {
    public float f3613a = 0.0f;
    public float f3614b = 8.0f;
    Handler f3615c = new C1534c(this);
    private int f3616d = 0;
    private C1531g f3617e;
    private float f3618f;
    private float f3619g;
    private float f3620h = 0.0f;
    private float f3621i = 200.0f;
    private C1537f f3622j;
    private boolean f3623k = false;
    private boolean f3624l = false;
    private float f3625m = 2.0f;
    private RotateAnimation f3626n;
    private RotateAnimation f3627o;
    private View f3628p;
    private View f3629q;
    private View f3630r;
    private View f3631s;
    private TextView f3632t;
    private View f3633u;
    private int f3634v;
    private boolean f3635w = true;
    private boolean f3636x = true;
    private boolean f3637y = false;

    public void setForbidden(boolean z) {
        this.f3637y = z;
    }

    public void setOnRefreshListener(C1531g c1531g) {
        this.f3617e = c1531g;
    }

    public PullToRefreshLayout(Context context) {
        super(context);
        m7047a(context);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7047a(context);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7047a(context);
    }

    private void m7047a(Context context) {
        this.f3622j = new C1537f(this.f3615c);
        this.f3626n = (RotateAnimation) AnimationUtils.loadAnimation(context, b.reverse_anim);
        this.f3627o = (RotateAnimation) AnimationUtils.loadAnimation(context, b.rotating);
        Interpolator linearInterpolator = new LinearInterpolator();
        this.f3626n.setInterpolator(linearInterpolator);
        this.f3627o.setInterpolator(linearInterpolator);
    }

    private void m7046a() {
        this.f3622j.m7067a(5);
    }

    public void m7059a(int i) {
        this.f3630r.clearAnimation();
        this.f3630r.setVisibility(8);
        switch (i) {
            case 0:
                this.f3631s.setVisibility(0);
                this.f3632t.setText(C1680l.IDS_plugin_kidwatch_chat_refresh_succeed);
                break;
            default:
                this.f3631s.setVisibility(0);
                this.f3632t.setText(C1680l.IDS_plugin_kidwatch_chat_refresh_fail);
                break;
        }
        if (this.f3613a > 0.0f) {
            new C1535d(this).sendEmptyMessageDelayed(0, 1000);
            return;
        }
        m7051b(5);
        m7046a();
    }

    private void m7051b(int i) {
        this.f3616d = i;
        switch (this.f3616d) {
            case 0:
                this.f3631s.setVisibility(8);
                this.f3632t.setText(C1680l.IDS_plugin_kidwatch_chat_pull_to_refresh);
                this.f3629q.clearAnimation();
                this.f3629q.setVisibility(0);
                return;
            case 1:
                this.f3632t.setText(C1680l.IDS_plugin_kidwatch_chat_release_to_refresh);
                this.f3629q.startAnimation(this.f3626n);
                return;
            case 2:
                this.f3629q.clearAnimation();
                this.f3630r.setVisibility(0);
                this.f3629q.setVisibility(4);
                this.f3630r.startAnimation(this.f3627o);
                this.f3632t.setText(C1680l.IDS_plugin_kidwatch_chat_refreshing);
                return;
            default:
                return;
        }
    }

    private void m7050b() {
        this.f3635w = true;
        this.f3636x = true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!(this.f3637y || this.f3616d == 2)) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.f3618f = motionEvent.getY();
                    this.f3619g = this.f3618f;
                    this.f3622j.m7066a();
                    this.f3634v = 0;
                    m7050b();
                    break;
                case 1:
                    if (this.f3616d == 1) {
                        m7051b(2);
                        if (this.f3617e != null) {
                            this.f3617e.mo2529a(this);
                        }
                    } else if (this.f3616d == 3) {
                        m7051b(4);
                    }
                    m7046a();
                    break;
                case 2:
                    m7048a(motionEvent);
                    break;
                case 5:
                case 6:
                    this.f3634v = -1;
                    break;
            }
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void m7048a(MotionEvent motionEvent) {
        if (this.f3634v != 0) {
            this.f3634v = 0;
        } else if (this.f3613a > 0.0f || (((C1530h) this.f3633u).mo2527a() && this.f3635w && this.f3616d != 4)) {
            this.f3613a += (motionEvent.getY() - this.f3619g) / this.f3625m;
            if (this.f3613a < 0.0f) {
                this.f3613a = 0.0f;
                this.f3635w = false;
                this.f3636x = true;
            }
            if (this.f3613a > ((float) getMeasuredHeight())) {
                this.f3613a = (float) getMeasuredHeight();
            }
            if (this.f3616d == 2) {
                this.f3624l = true;
            }
        } else if (this.f3620h < 0.0f || (((C1530h) this.f3633u).mo2528b() && this.f3636x && this.f3616d != 2)) {
            this.f3620h += (motionEvent.getY() - this.f3619g) / this.f3625m;
            if (this.f3620h > 0.0f) {
                this.f3620h = 0.0f;
                this.f3635w = true;
                this.f3636x = false;
            }
            if (this.f3620h < ((float) (-getMeasuredHeight()))) {
                this.f3620h = (float) (-getMeasuredHeight());
            }
            if (this.f3616d == 4) {
                this.f3624l = true;
            }
        } else {
            m7050b();
        }
        this.f3619g = motionEvent.getY();
        this.f3625m = (float) ((Math.tan((1.5707963267948966d / ((double) getMeasuredHeight())) * ((double) (this.f3613a + Math.abs(this.f3620h)))) * 2.0d) + 2.0d);
        if (this.f3613a > 0.0f || this.f3620h < 0.0f) {
            requestLayout();
        }
        if (this.f3613a > 0.0f) {
            if (this.f3613a <= this.f3621i && (this.f3616d == 1 || this.f3616d == 5)) {
                m7051b(0);
            }
            if (this.f3613a >= this.f3621i && this.f3616d == 0) {
                m7051b(1);
            }
        }
        if (this.f3613a + Math.abs(this.f3620h) > 8.0f) {
            motionEvent.setAction(3);
        }
    }

    private void m7054c() {
        this.f3629q = this.f3628p.findViewById(g.pull_icon);
        this.f3632t = (TextView) this.f3628p.findViewById(g.state_tv);
        this.f3630r = this.f3628p.findViewById(g.refreshing_icon);
        this.f3631s = this.f3628p.findViewById(g.state_iv);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Log.d("Test", "Test");
        if (!this.f3623k) {
            this.f3628p = getChildAt(0);
            this.f3633u = getChildAt(1);
            this.f3623k = true;
            m7054c();
            this.f3621i = (float) ((ViewGroup) this.f3628p).getChildAt(0).getMeasuredHeight();
        }
        this.f3628p.layout(0, ((int) (this.f3613a + this.f3620h)) - this.f3628p.getMeasuredHeight(), this.f3628p.getMeasuredWidth(), (int) (this.f3613a + this.f3620h));
        this.f3633u.layout(0, (int) (this.f3613a + this.f3620h), this.f3633u.getMeasuredWidth(), ((int) (this.f3613a + this.f3620h)) + this.f3633u.getMeasuredHeight());
    }
}
