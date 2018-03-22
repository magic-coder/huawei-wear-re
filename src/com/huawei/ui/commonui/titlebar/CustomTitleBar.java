package com.huawei.ui.commonui.titlebar;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hwbasemgr.C4595b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6036m;
import com.huawei.ui.commonui.p514d.C5999c;

public class CustomTitleBar extends RelativeLayout {
    private Context f20784a;
    private int f20785b;
    private String f20786c;
    private Drawable f20787d;
    private Drawable f20788e;
    private Drawable f20789f;
    private int f20790g;
    private int f20791h;
    private int f20792i;
    private TextView f20793j;
    private TextView f20794k;
    private TextView f20795l;
    private TextView f20796m;
    private RelativeLayout f20797n;
    private RelativeLayout f20798o;
    private View f20799p;
    private ImageView f20800q;
    private ImageView f20801r;
    private ImageView f20802s;
    private ImageView f20803t;
    private RelativeLayout f20804u;
    private RelativeLayout f20805v;
    private View f20806w;

    public CustomTitleBar(Context context) {
        this(context, null);
        this.f20784a = context;
        m27616a();
    }

    public CustomTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20785b = -1;
        this.f20791h = -1;
        this.f20792i = -1;
        if (attributeSet != null) {
            this.f20784a = context;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6036m.custom_title_bar);
            if (obtainStyledAttributes != null) {
                this.f20785b = obtainStyledAttributes.getInteger(C6036m.custom_title_bar_custom_type, 1);
                this.f20786c = obtainStyledAttributes.getString(C6036m.custom_title_bar_titleBarText);
                this.f20787d = obtainStyledAttributes.getDrawable(C6036m.custom_title_bar_titleBarBg);
                this.f20791h = obtainStyledAttributes.getInteger(C6036m.custom_title_bar_leftSoftkey_visibility, 0);
                this.f20792i = obtainStyledAttributes.getInteger(C6036m.custom_title_bar_rightSoftkey_visibility, 0);
                this.f20788e = obtainStyledAttributes.getDrawable(C6036m.custom_title_bar_leftIcon);
                this.f20789f = obtainStyledAttributes.getDrawable(C6036m.custom_title_bar_rightIcon);
                this.f20790g = obtainStyledAttributes.getColor(C6036m.custom_title_bar_titleBarTextColor, ViewCompat.MEASURED_STATE_MASK);
                obtainStyledAttributes.recycle();
            }
            m27616a();
        }
    }

    private void m27616a() {
        ((LayoutInflater) this.f20784a.getSystemService("layout_inflater")).inflate(C6031h.commonui_custom_titlebar, this);
        this.f20797n = (RelativeLayout) findViewById(C6030g.custom_titlebar);
        this.f20798o = (RelativeLayout) findViewById(C6030g.titlebar_panel);
        this.f20799p = findViewById(C6030g.statusbar_panel);
        this.f20793j = (TextView) findViewById(C6030g.view_title);
        this.f20794k = (TextView) findViewById(C6030g.view_title_num);
        this.f20795l = (TextView) findViewById(C6030g.detail_title_text);
        this.f20796m = (TextView) findViewById(C6030g.normal_title_text);
        this.f20800q = (ImageView) findViewById(C6030g.btn_left);
        this.f20801r = (ImageView) findViewById(C6030g.btn_right);
        this.f20802s = (ImageView) findViewById(C6030g.btn_left_position);
        this.f20803t = (ImageView) findViewById(C6030g.btn_right_position);
        this.f20804u = (RelativeLayout) findViewById(C6030g.btn_left_layout);
        this.f20805v = (RelativeLayout) findViewById(C6030g.btn_right_layout);
        this.f20806w = findViewById(C6030g.titlebar_divider_line_height);
        this.f20799p.setLayoutParams(new LayoutParams(-1, C5999c.m27450a(this.f20784a)));
        this.f20794k.setVisibility(8);
        Theme theme = this.f20784a.getTheme();
        if (theme != null) {
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{C5996c.titleBarDividerColor});
            if (obtainStyledAttributes != null) {
                this.f20806w.setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                obtainStyledAttributes.recycle();
            }
        }
        if (this.f20787d != null) {
            this.f20797n.setBackgroundDrawable(this.f20787d);
        } else if (theme != null) {
            TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(new int[]{C5996c.titleBarBgColor});
            if (obtainStyledAttributes2 != null) {
                this.f20797n.setBackgroundColor(obtainStyledAttributes2.getColor(0, -1905167));
                obtainStyledAttributes2.recycle();
            }
        }
        this.f20795l.setTextColor(this.f20790g);
        this.f20793j.setTextColor(this.f20790g);
        this.f20796m.setTextColor(this.f20790g);
        switch (this.f20785b) {
            case 0:
                m27622g();
                return;
            case 2:
                m27617b();
                return;
            case 3:
                m27618c();
                return;
            default:
                m27623h();
                return;
        }
    }

    private void m27617b() {
        this.f20795l.setVisibility(0);
        this.f20796m.setVisibility(8);
        this.f20793j.setVisibility(8);
        this.f20804u.setVisibility(0);
        this.f20802s.setVisibility(0);
        this.f20805v.setVisibility(4);
        this.f20803t.setVisibility(4);
        if (this.f20786c != null) {
            this.f20795l.setText(this.f20786c);
        }
        if (this.f20788e != null) {
            this.f20800q.setImageDrawable(this.f20788e);
        } else {
            m27620e();
        }
        this.f20804u.setOnClickListener(new C6039a(this));
    }

    private void m27618c() {
        this.f20795l.setVisibility(0);
        this.f20796m.setVisibility(8);
        this.f20793j.setVisibility(8);
        this.f20804u.setVisibility(0);
        this.f20802s.setVisibility(0);
        this.f20805v.setVisibility(0);
        this.f20803t.setVisibility(0);
        if (this.f20786c != null) {
            this.f20795l.setText(this.f20786c);
        }
        switch (this.f20791h) {
            case 0:
                this.f20804u.setVisibility(0);
                this.f20802s.setVisibility(0);
                break;
            case 4:
                this.f20804u.setVisibility(4);
                this.f20802s.setVisibility(4);
                break;
            case 8:
                this.f20804u.setVisibility(8);
                this.f20802s.setVisibility(8);
                break;
        }
        if (this.f20788e != null) {
            this.f20800q.setImageDrawable(this.f20788e);
        } else {
            m27620e();
        }
        if (this.f20789f != null) {
            this.f20801r.setImageDrawable(this.f20789f);
        }
        this.f20804u.setOnClickListener(new C6040b(this));
    }

    private void m27619d() {
        Theme theme = this.f20784a.getTheme();
        if (theme != null) {
            C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (t != null)"});
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{C5996c.titleBarCrossIcon});
            if (obtainStyledAttributes != null) {
                C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (arrayLeft != null)"});
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                if (drawable != null) {
                    C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (drawableLeft != null)"});
                    this.f20800q.setImageDrawable(drawable);
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void m27620e() {
        Theme theme = this.f20784a.getTheme();
        if (theme != null) {
            TypedArray obtainStyledAttributes;
            C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (t != null)"});
            if (C4595b.m21889a(this.f20784a)) {
                C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (LanguageUtil.isRTLLanguage)"});
                obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{C5996c.titleBarRTLLanguageBackIcon});
            } else {
                C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (LanguageUtil.isRTLLanguage) ELSE"});
                obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{C5996c.titleBarBackIcon});
            }
            if (obtainStyledAttributes != null) {
                C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (arrayLeft != null)"});
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                if (drawable != null) {
                    C2538c.c("CustomTitleBar", new Object[]{"loadLeftCrossIconByThemeSet() if (drawableLeft != null)"});
                    this.f20800q.setImageDrawable(drawable);
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void m27621f() {
        Theme theme = this.f20784a.getTheme();
        if (theme != null) {
            C2538c.c("CustomTitleBar", new Object[]{"loadRightIconByThemeSet() if (t != null)"});
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{C5996c.titleBarTickIcon});
            if (obtainStyledAttributes != null) {
                C2538c.c("CustomTitleBar", new Object[]{"loadRightIconByThemeSet() if (arrayRight != null)"});
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                if (drawable != null) {
                    C2538c.c("CustomTitleBar", new Object[]{"loadRightIconByThemeSet() if (drawableRight == null)"});
                    this.f20801r.setImageDrawable(drawable);
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void m27622g() {
        C2538c.c("CustomTitleBar", new Object[]{"loadNormalTypeView()"});
        this.f20796m.setVisibility(0);
        this.f20795l.setVisibility(8);
        this.f20793j.setVisibility(8);
        this.f20804u.setVisibility(8);
        this.f20802s.setVisibility(8);
        this.f20805v.setVisibility(8);
        this.f20803t.setVisibility(8);
        if (this.f20786c != null) {
            this.f20796m.setText(this.f20786c);
        }
    }

    private void m27623h() {
        this.f20796m.setVisibility(8);
        this.f20795l.setVisibility(8);
        this.f20793j.setVisibility(0);
        if (this.f20786c != null) {
            this.f20793j.setText(this.f20786c);
        }
        switch (this.f20791h) {
            case 0:
                this.f20804u.setVisibility(0);
                this.f20802s.setVisibility(0);
                break;
            case 4:
                this.f20804u.setVisibility(4);
                this.f20802s.setVisibility(4);
                break;
            case 8:
                this.f20804u.setVisibility(8);
                this.f20802s.setVisibility(8);
                break;
        }
        switch (this.f20792i) {
            case 0:
                this.f20805v.setVisibility(0);
                this.f20803t.setVisibility(0);
                break;
            case 4:
                this.f20805v.setVisibility(4);
                this.f20803t.setVisibility(4);
                break;
            case 8:
                this.f20805v.setVisibility(8);
                this.f20803t.setVisibility(8);
                break;
        }
        if (this.f20788e != null) {
            this.f20800q.setImageDrawable(this.f20788e);
        } else {
            m27619d();
        }
        if (this.f20789f != null) {
            this.f20801r.setImageDrawable(this.f20789f);
        } else {
            m27621f();
        }
        this.f20804u.setOnClickListener(new C6041c(this));
    }

    public void setTitleText(String str) {
        this.f20793j.setText(str);
        this.f20795l.setText(str);
        this.f20796m.setText(str);
    }

    public void setTitleTextColor(int i) {
        this.f20793j.setTextColor(i);
        this.f20795l.setTextColor(i);
        this.f20796m.setTextColor(i);
    }

    public void setTitleTextSize(float f) {
        this.f20793j.setTextSize(f);
        this.f20795l.setTextSize(f);
        this.f20796m.setTextSize(f);
    }

    public void setLeftButtonOnClickListener(OnClickListener onClickListener) {
        if (this.f20804u != null) {
            this.f20804u.setOnClickListener(onClickListener);
        }
    }

    public void setRightButtonOnClickListener(OnClickListener onClickListener) {
        if (this.f20805v != null) {
            this.f20805v.setOnClickListener(onClickListener);
        }
    }

    public void setLeftButtonDrawable(Drawable drawable) {
        if (this.f20800q != null && drawable != null) {
            this.f20800q.setImageDrawable(drawable);
        }
    }

    public void setRightButtonDrawable(Drawable drawable) {
        if (this.f20801r != null && drawable != null) {
            this.f20801r.setImageDrawable(drawable);
        }
    }

    public void setRightButtonClickable(boolean z) {
        if (this.f20805v != null) {
            this.f20805v.setClickable(z);
        }
    }

    public void setLeftButtonClickable(boolean z) {
        if (this.f20804u != null) {
            this.f20804u.setClickable(z);
        }
    }

    public void setLeftButtonVisibility(int i) {
        if (this.f20804u != null) {
            this.f20804u.setVisibility(i);
            this.f20802s.setVisibility(i);
        }
    }

    public void setRightButtonVisibility(int i) {
        if (this.f20805v != null) {
            this.f20805v.setVisibility(i);
            this.f20803t.setVisibility(i);
        }
    }

    public void setCountNumVisibility(int i) {
        if (this.f20794k != null) {
            this.f20794k.setVisibility(i);
        }
    }

    public void setTitleCountNum(int i) {
        if (this.f20794k != null) {
            this.f20794k.setText(com.huawei.hwbasemgr.c.a((double) i, 1, 0));
        }
    }

    public void setTitleCountColor(int i) {
        if (this.f20794k != null) {
            this.f20794k.setTextColor(i);
        }
    }

    public void setTitleCountBg(Drawable drawable) {
        if (this.f20794k != null) {
            this.f20794k.setBackground(drawable);
        }
    }

    public void setTitleVisibility(int i) {
        if (this.f20798o != null) {
            this.f20798o.setVisibility(i);
        }
    }

    public TextView getmViewTitle() {
        return this.f20795l;
    }
}
