package com.huawei.pluginkidwatch.common.ui.title;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.button.C1512a;
import com.huawei.pluginkidwatch.common.ui.button.C1520i;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.e;
import com.huawei.pluginkidwatch.n;
import java.lang.reflect.InvocationTargetException;

public class CustomTitle extends RelativeLayout {
    private String f3754A;
    private String f3755B;
    private String f3756C;
    private float f3757D;
    private float f3758E;
    private String f3759F;
    private String f3760G;
    LayoutParams f3761a;
    LayoutParams f3762b;
    LayoutParams f3763c;
    public OnClickListener f3764d;
    private Context f3765e;
    private C1520i f3766f;
    private C1520i f3767g;
    private C1520i f3768h;
    private C1512a f3769i;
    private C1512a f3770j;
    private TextView f3771k;
    private Drawable f3772l;
    private Drawable f3773m;
    private Drawable f3774n;
    private Drawable f3775o;
    private Drawable f3776p;
    private Drawable f3777q;
    private float f3778r;
    private float f3779s;
    private int f3780t;
    private boolean f3781u;
    private boolean f3782v;
    private boolean f3783w;
    private boolean f3784x;
    private int f3785y;
    private String f3786z;

    public CustomTitle(Context context) {
        this(context, null);
    }

    public CustomTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3771k = null;
        this.f3781u = true;
        this.f3782v = true;
        this.f3783w = true;
        this.f3784x = false;
        this.f3785y = 0;
        this.f3786z = null;
        this.f3754A = null;
        this.f3755B = null;
        this.f3759F = null;
        this.f3760G = null;
        this.f3764d = new C1564a(this);
        if (attributeSet != null) {
            this.f3765e = context;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.custom_title);
            this.f3772l = obtainStyledAttributes.getDrawable(n.custom_title_backBackground);
            this.f3773m = obtainStyledAttributes.getDrawable(n.custom_title_menuBackground);
            this.f3774n = obtainStyledAttributes.getDrawable(n.custom_title_secMenuBackground);
            this.f3786z = obtainStyledAttributes.getString(n.custom_title_backMethod);
            this.f3754A = obtainStyledAttributes.getString(n.custom_title_menuMethod);
            this.f3755B = obtainStyledAttributes.getString(n.custom_title_secMenuMethod);
            this.f3775o = obtainStyledAttributes.getDrawable(n.custom_title_backIcon);
            this.f3776p = obtainStyledAttributes.getDrawable(n.custom_title_menuIcon);
            this.f3777q = obtainStyledAttributes.getDrawable(n.custom_title_secMenuIcon);
            this.f3781u = obtainStyledAttributes.getBoolean(n.custom_title_backVisible, true);
            this.f3782v = obtainStyledAttributes.getBoolean(n.custom_title_menuVisible, true);
            this.f3783w = obtainStyledAttributes.getBoolean(n.custom_title_secMenuVisible, false);
            this.f3780t = obtainStyledAttributes.getColor(n.custom_title_titleColor, -1);
            this.f3756C = obtainStyledAttributes.getString(n.custom_title_titleText);
            this.f3759F = obtainStyledAttributes.getString(n.custom_title_backText);
            this.f3760G = obtainStyledAttributes.getString(n.custom_title_menuText);
            this.f3779s = obtainStyledAttributes.getDimension(n.custom_title_btnpading, 0.0f);
            try {
                this.f3778r = (float) obtainStyledAttributes.getDimensionPixelSize(n.custom_title_titleSize, this.f3765e.getResources().getDimensionPixelSize(e.title_text_size));
                this.f3757D = obtainStyledAttributes.getDimension(n.custom_title_backLeftSpace, (float) this.f3765e.getResources().getDimensionPixelOffset(e.back_btn_left_space));
                this.f3758E = obtainStyledAttributes.getDimension(n.custom_title_menuRightSpace, (float) this.f3765e.getResources().getDimensionPixelOffset(e.menu_btn_right_space));
            } catch (NotFoundException e) {
                C2538c.m12680e("CustomTitle", e.getMessage());
                this.f3778r = 18.0f;
                this.f3757D = 10.0f;
                this.f3758E = 10.0f;
            }
            obtainStyledAttributes.recycle();
            m7188a();
        }
    }

    public void m7188a() {
        int i;
        NotFoundException notFoundException;
        setBackgroundDrawable(this.f3765e.getResources().getDrawable(C1617f.kw_titlebar));
        this.f3780t = this.f3780t == 0 ? -1 : this.f3780t;
        this.f3770j = new C1512a(this.f3765e, 10);
        int dimension = (int) getResources().getDimension(e.title_height);
        this.f3762b = new LayoutParams(dimension, dimension);
        this.f3761a = new LayoutParams(dimension, dimension);
        this.f3763c = new LayoutParams(dimension, dimension);
        if (this.f3766f == null) {
            this.f3766f = new C1520i(this.f3765e);
        }
        this.f3766f.setId(1);
        this.f3766f.setTag(this.f3786z);
        this.f3766f.setBackgroundDra(this.f3772l);
        this.f3766f.setIcon(this.f3775o);
        this.f3766f.setPadding((int) this.f3779s, 0, (int) this.f3779s, 0);
        if (this.f3759F != null) {
            this.f3766f.setTextVisibility(0);
            this.f3766f.setText(this.f3759F);
            this.f3766f.setTextColor(this.f3780t);
        } else {
            this.f3766f.setTextVisibility(8);
        }
        this.f3766f.setOnClickListener(this.f3764d);
        this.f3762b.addRule(9);
        this.f3762b.addRule(15);
        this.f3762b.leftMargin = (int) this.f3757D;
        removeView(this.f3766f);
        addView(this.f3766f, this.f3762b);
        setBackBtnVisible(this.f3781u);
        this.f3767g = new C1520i(this.f3765e);
        this.f3767g.setId(3);
        this.f3767g.setTag(this.f3754A);
        this.f3767g.setBackgroundDra(this.f3773m);
        this.f3767g.setIcon(this.f3776p);
        this.f3767g.setGravity(17);
        this.f3767g.setPadding((int) this.f3779s, 0, (int) this.f3779s, 0);
        if (this.f3760G != null) {
            this.f3767g.setTextVisibility(0);
            this.f3767g.setText(this.f3760G);
            this.f3767g.setTextColor(this.f3780t);
        } else {
            this.f3767g.setTextVisibility(8);
        }
        this.f3767g.setOnClickListener(this.f3764d);
        this.f3761a.addRule(11);
        this.f3761a.addRule(15);
        this.f3761a.rightMargin = (int) this.f3758E;
        removeView(this.f3767g);
        addView(this.f3767g, this.f3761a);
        setMenuBtnVisible(this.f3782v);
        this.f3768h = new C1520i(this.f3765e);
        this.f3768h.setId(4);
        this.f3768h.setTag(this.f3755B);
        this.f3768h.setBackgroundDra(this.f3774n);
        this.f3768h.setIcon(this.f3777q);
        this.f3768h.setGravity(17);
        this.f3768h.setPadding((int) this.f3779s, 0, (int) this.f3779s, 0);
        this.f3768h.setOnClickListener(this.f3764d);
        this.f3763c.addRule(0, 5);
        this.f3763c.addRule(15);
        addView(this.f3768h, this.f3763c);
        setSecMenuVisible(this.f3783w);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.f3765e).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (this.f3783w) {
                C2538c.m12674b("CustomTitle", "----height----" + dimension);
                i = (displayMetrics.widthPixels - (dimension * 4)) + ((int) (15.0f * displayMetrics.density));
                try {
                    View view = new View(this.f3765e);
                    view.setBackgroundColor(getResources().getColor(d.kw_color_white_30alpha));
                    view.setId(5);
                    ViewGroup.LayoutParams layoutParams = new LayoutParams(1, (int) (0.5d * ((double) getResources().getDimension(e.title_btn_height))));
                    layoutParams.addRule(15);
                    layoutParams.addRule(0, 3);
                    addView(view, layoutParams);
                    this.f3769i = new C1512a(this.f3765e, 10);
                    ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, C1492l.m6901a(this.f3765e, 10.0f));
                    layoutParams2.addRule(1, 4);
                    layoutParams2.addRule(12);
                    layoutParams2.bottomMargin = (int) (0.25d * ((double) getResources().getDimension(e.title_btn_height)));
                    layoutParams2.leftMargin = -((int) (HeatmapTileProvider.DEFAULT_OPACITY * ((double) getResources().getDimension(e.title_btn_height))));
                    addView(this.f3769i, layoutParams2);
                } catch (NotFoundException e) {
                    NotFoundException notFoundException2 = e;
                    dimension = i;
                    notFoundException = notFoundException2;
                    C2538c.m12680e("CustomTitle", "----get screen width failed.", notFoundException.getMessage());
                    i = dimension;
                    if (i <= 0) {
                        i = 200;
                    }
                    if (this.f3784x) {
                        C2538c.m12680e("CustomTitle", "----yh get deleteFlag flase");
                        this.f3762b = new LayoutParams(i, -2);
                    } else {
                        C2538c.m12680e("CustomTitle", "----yh get deleteFlag true");
                        this.f3762b = new LayoutParams(-2, -2);
                    }
                    if (this.f3771k == null) {
                        this.f3771k = new TextView(this.f3765e);
                    }
                    this.f3771k.setId(2);
                    this.f3771k.setTextColor(this.f3780t);
                    this.f3771k.setText(this.f3756C);
                    this.f3771k.setSingleLine(true);
                    this.f3771k.setFocusable(true);
                    this.f3771k.setFocusableInTouchMode(true);
                    this.f3771k.setEllipsize(TruncateAt.END);
                    this.f3771k.setTextSize(0, this.f3778r);
                    this.f3771k.setGravity(17);
                    this.f3762b.addRule(14);
                    this.f3762b.addRule(15);
                    removeView(this.f3771k);
                    addView(this.f3771k, this.f3762b);
                }
            }
            i = displayMetrics.widthPixels - (dimension * 2);
        } catch (NotFoundException e2) {
            notFoundException = e2;
            dimension = 0;
            C2538c.m12680e("CustomTitle", "----get screen width failed.", notFoundException.getMessage());
            i = dimension;
            if (i <= 0) {
                i = 200;
            }
            if (this.f3784x) {
                C2538c.m12680e("CustomTitle", "----yh get deleteFlag true");
                this.f3762b = new LayoutParams(-2, -2);
            } else {
                C2538c.m12680e("CustomTitle", "----yh get deleteFlag flase");
                this.f3762b = new LayoutParams(i, -2);
            }
            if (this.f3771k == null) {
                this.f3771k = new TextView(this.f3765e);
            }
            this.f3771k.setId(2);
            this.f3771k.setTextColor(this.f3780t);
            this.f3771k.setText(this.f3756C);
            this.f3771k.setSingleLine(true);
            this.f3771k.setFocusable(true);
            this.f3771k.setFocusableInTouchMode(true);
            this.f3771k.setEllipsize(TruncateAt.END);
            this.f3771k.setTextSize(0, this.f3778r);
            this.f3771k.setGravity(17);
            this.f3762b.addRule(14);
            this.f3762b.addRule(15);
            removeView(this.f3771k);
            addView(this.f3771k, this.f3762b);
        }
        if (i <= 0) {
            i = 200;
        }
        if (this.f3784x) {
            C2538c.m12680e("CustomTitle", "----yh get deleteFlag true");
            this.f3762b = new LayoutParams(-2, -2);
        } else {
            C2538c.m12680e("CustomTitle", "----yh get deleteFlag flase");
            this.f3762b = new LayoutParams(i, -2);
        }
        if (this.f3771k == null) {
            this.f3771k = new TextView(this.f3765e);
        }
        this.f3771k.setId(2);
        this.f3771k.setTextColor(this.f3780t);
        this.f3771k.setText(this.f3756C);
        this.f3771k.setSingleLine(true);
        this.f3771k.setFocusable(true);
        this.f3771k.setFocusableInTouchMode(true);
        this.f3771k.setEllipsize(TruncateAt.END);
        this.f3771k.setTextSize(0, this.f3778r);
        this.f3771k.setGravity(17);
        this.f3762b.addRule(14);
        this.f3762b.addRule(15);
        removeView(this.f3771k);
        addView(this.f3771k, this.f3762b);
    }

    public void setDeviceVisible(boolean z) {
        if (z) {
            this.f3769i.setVisibility(0);
            this.f3769i.setEnabled(true);
            return;
        }
        this.f3769i.setVisibility(4);
        this.f3769i.setEnabled(false);
    }

    public void m7189a(Context context, String str, View view) {
        Class cls = context.getClass();
        if (str != null && !"".equals(str)) {
            try {
                try {
                    cls.getMethod(str, new Class[]{View.class}).invoke(context, new Object[]{view});
                } catch (IllegalArgumentException e) {
                    C2538c.m12680e("CustomTitle", "Exception e = " + e.getMessage());
                } catch (IllegalAccessException e2) {
                    C2538c.m12680e("CustomTitle", "Exception e = " + e2.getMessage());
                } catch (InvocationTargetException e3) {
                    C2538c.m12680e("CustomTitle", "Exception e = " + e3.getMessage());
                }
            } catch (NoSuchMethodException e4) {
                C2538c.m12680e("CustomTitle", "NoSuchMethodException e = " + e4.getMessage());
            }
        }
    }

    public void setBackBtnVisible(boolean z) {
        if (z) {
            this.f3766f.setVisibility(0);
            this.f3766f.setEnabled(true);
            return;
        }
        this.f3766f.setVisibility(4);
        this.f3766f.setEnabled(false);
    }

    public void setMenuBtnVisible(boolean z) {
        if (z) {
            this.f3767g.setVisibility(0);
            this.f3767g.setEnabled(true);
            return;
        }
        this.f3767g.setVisibility(4);
        this.f3767g.setEnabled(false);
    }

    public void setSecMenuVisible(boolean z) {
        if (z) {
            this.f3768h.setVisibility(0);
            this.f3768h.setEnabled(true);
            return;
        }
        this.f3768h.setVisibility(4);
        this.f3768h.setEnabled(false);
    }

    public void setMenuBtnEnable(boolean z) {
        if (z) {
            this.f3767g.setEnabled(true);
        } else {
            this.f3767g.setEnabled(false);
        }
    }

    public void setBackBtnBackground(Drawable drawable) {
        this.f3766f.setBackgroundDrawable(drawable);
    }

    public void setBackBtnBackgroundResource(int i) {
        this.f3766f.setBackgroundResource(i);
    }

    public void setBackBtnIcon(Drawable drawable) {
        this.f3766f.setIcon(drawable);
    }

    public void setBackBtnIcon(int i) {
        this.f3766f.setIcon(i);
    }

    public void setMenuBtnText(String str) {
        this.f3767g.setText(str);
    }

    public void setMenuBtnText(int i) {
        this.f3767g.setText(i);
    }

    public void setBackBtnText(String str) {
        this.f3766f.setText(str);
    }

    public void setBackBtnText(int i) {
        this.f3766f.setText(i);
    }

    public void setMenuBtnBackground(Drawable drawable) {
        this.f3767g.setBackgroundDrawable(drawable);
    }

    public void setMenuBtnBackgroundResource(int i) {
        removeView(this.f3767g);
        int dimension = (int) getResources().getDimension(e.title_height);
        this.f3761a = new LayoutParams(dimension, dimension);
        this.f3767g.setBackgroundResource(i);
        this.f3767g.setOnClickListener(this.f3764d);
        this.f3767g.setPadding((int) this.f3779s, 0, (int) this.f3779s, 0);
        this.f3761a.addRule(11);
        this.f3761a.addRule(15);
        this.f3761a.rightMargin = (int) this.f3758E;
        addView(this.f3767g, this.f3761a);
    }

    public void setMenuBtnIcon(Drawable drawable) {
        this.f3767g.setIcon(drawable);
    }

    public void setMenuBtnIcon(int i) {
        this.f3767g.setIcon(i);
    }

    public void setTitleLabel(String str) {
        this.f3771k.setText(str);
    }

    public void setTitleLabel(int i) {
        this.f3771k.setText(this.f3765e.getResources().getText(i));
    }

    public void setTitleSize(float f) {
        this.f3771k.setTextSize(f);
    }

    public C1520i getBackBt() {
        return this.f3766f;
    }

    public void setBackBt(C1520i c1520i) {
        this.f3766f = c1520i;
    }

    public C1520i getMenuBt() {
        return (C1520i) C1489i.m6887a(this.f3767g);
    }

    public void setMenuBt(C1520i c1520i) {
        this.f3767g = c1520i;
    }

    public TextView getTextView() {
        return this.f3767g.getTextView();
    }

    public String getTitleLabel() {
        return this.f3771k.getText().toString();
    }

    public TextView getTitleTextView() {
        return this.f3771k;
    }

    public void setDeleteFlag(boolean z) {
        this.f3784x = z;
    }

    public int getDeleteNumber() {
        return this.f3785y;
    }

    public void setDeleteNumber(int i) {
        this.f3785y = i;
    }

    public void setBackGround(int i) {
        setBackgroundDrawable(this.f3765e.getResources().getDrawable(i));
    }
}
