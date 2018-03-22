package com.huawei.crowdtestsdk.widgets;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.uploadlog.p188c.C2511g;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;

public class ActionBarTabEx {
    private String TAG = "HwViewPagerImpl";
    private ActionBar mActionBar;
    private Context mContext;
    private float mQuarterWidth;
    private Method mgetTabContainerMethod = null;

    public ActionBarTabEx(Context context) {
        this.mQuarterWidth = 0.3333333f * ((float) context.getResources().getDisplayMetrics().widthPixels);
        createTabScrollingMethod(context);
        this.mContext = context;
    }

    private Interpolator createCubicBezierInterpolator(Context context) {
        try {
            Interpolator interpolator;
            Class loadClass = new PathClassLoader("/system/framework/hwEmui.jar", context.getClassLoader()).loadClass("com.huawei.hwanimation.CubicBezierInterpolator");
            if (loadClass != null) {
                interpolator = (Interpolator) loadClass.getConstructor(new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE}).newInstance(new Object[]{Float.valueOf(0.325f), Float.valueOf(0.63f), Float.valueOf(0.05f), Float.valueOf(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)});
            } else {
                interpolator = null;
            }
            return interpolator;
        } catch (Throwable e) {
            C2511g.m12482b(this.TAG, "create Cubic Bezier Interpolator catch ClassNotFoundException", e);
            return null;
        } catch (Throwable e2) {
            C2511g.m12482b(this.TAG, "create Cubic Bezier Interpolator catch NoSuchMethodException", e2);
            return null;
        } catch (Throwable e22) {
            C2511g.m12482b(this.TAG, "create Cubic Bezier Interpolator catch IllegalArgumentException", e22);
            return null;
        } catch (Throwable e222) {
            C2511g.m12482b(this.TAG, "create Cubic Bezier Interpolator catch InstantiationException", e222);
            return null;
        } catch (Throwable e2222) {
            C2511g.m12482b(this.TAG, "create Cubic Bezier Interpolator catch IllegalAccessException", e2222);
            return null;
        } catch (Throwable e22222) {
            C2511g.m12482b(this.TAG, "create Cubic Bezier Interpolator catch InvocationTargetException", e22222);
            return null;
        }
    }

    private void createTabScrollingMethod(Context context) {
        try {
            Class loadClass = new PathClassLoader("/system/framework/hwframework.jar", context.getClassLoader()).loadClass("com.huawei.android.app.ActionBarEx");
            if (loadClass != null) {
                this.mgetTabContainerMethod = loadClass.getDeclaredMethod("setTabScrollingOffsets", new Class[]{ActionBar.class, Integer.TYPE, Float.TYPE});
            }
        } catch (ClassNotFoundException e) {
            C2511g.m12483c(this.TAG, "create Tab Scrolling Method catch ClassNotFoundException");
        } catch (NoSuchMethodException e2) {
            C2511g.m12483c(this.TAG, "create Tab Scrolling Method catch NoSuchMethodException");
        }
    }

    private ActionBar getActionBar() {
        Context context = this.mContext;
        Activity activity = null;
        while (activity == null && context != null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else if (context instanceof ContextWrapper) {
            }
        }
        if (activity == null) {
            return null;
        }
        return activity.getActionBar();
    }

    public Scroller createScroller(Context context) {
        return new Scroller(context, createCubicBezierInterpolator(context));
    }

    public float scrollEdgeBound(boolean z, float f, float f2, float f3) {
        float f4 = (0.3333333f * f2) + f;
        if (z) {
            return Math.max(f4, f3 - this.mQuarterWidth);
        }
        return Math.min(f4, this.mQuarterWidth + f3);
    }

    public void tabScrollerFollowed(int i, float f) {
        if (this.mActionBar == null) {
            this.mActionBar = getActionBar();
        }
        if (this.mActionBar == null || f < 0.0f || this.mgetTabContainerMethod != null) {
        }
        try {
            this.mgetTabContainerMethod.invoke(null, new Object[]{this.mActionBar, Integer.valueOf(i), Float.valueOf(f)});
        } catch (Throwable e) {
            C2511g.m12482b(this.TAG, "mgetTabContainerMethod invoke catch IllegalArgumentException", e);
        } catch (Throwable e2) {
            C2511g.m12482b(this.TAG, "mgetTabContainerMethod invoke catch IllegalAccessException", e2);
        } catch (Throwable e22) {
            C2511g.m12482b(this.TAG, "mgetTabContainerMethod invoke catch InvocationTargetException", e22);
        }
    }
}
