package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6035l;
import com.huawei.ui.commonui.C6036m;
import com.huawei.p190v.C2538c;

/* compiled from: NoTitleCustomAlertDialog */
public class ak {
    ai f20642a = null;
    private Context f20643b;
    private String f20644c;
    private String f20645d;
    private String f20646e;
    private String f20647f;
    private int f20648g = 0;
    private int f20649h = 0;
    private OnClickListener f20650i;
    private OnClickListener f20651j;

    public ak(Context context) {
        this.f20643b = context;
    }

    public ak m27511a(int i) {
        this.f20644c = (String) this.f20643b.getText(i);
        return this;
    }

    public ak m27513a(String str) {
        this.f20644c = str;
        return this;
    }

    public ak m27517b(String str) {
        this.f20645d = str;
        return this;
    }

    public ak m27512a(int i, OnClickListener onClickListener) {
        this.f20646e = (String) this.f20643b.getText(i);
        this.f20650i = onClickListener;
        return this;
    }

    public ak m27515a(String str, OnClickListener onClickListener) {
        this.f20646e = str;
        this.f20650i = onClickListener;
        return this;
    }

    public ak m27514a(String str, int i, OnClickListener onClickListener) {
        this.f20646e = str;
        this.f20648g = i;
        this.f20650i = onClickListener;
        return this;
    }

    public ak m27516b(int i, OnClickListener onClickListener) {
        this.f20647f = (String) this.f20643b.getText(i);
        this.f20651j = onClickListener;
        return this;
    }

    public ak m27518b(String str, OnClickListener onClickListener) {
        this.f20647f = str;
        this.f20651j = onClickListener;
        return this;
    }

    public ai m27510a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f20643b.getSystemService("layout_inflater");
        this.f20642a = new ai(this.f20643b, C6035l.CustomDialog);
        View inflate = layoutInflater.inflate(C6031h.commonui_no_title_custom_dialog, null);
        this.f20642a.setContentView(inflate);
        m27503a(inflate, m27501a(inflate));
        m27506b(inflate);
        m27508c(inflate);
        return this.f20642a;
    }

    private int m27501a(View view) {
        TypedValue typedValue = new TypedValue();
        this.f20643b.getTheme().resolveAttribute(C5996c.customDialogStyleRefer, typedValue, true);
        TypedArray obtainStyledAttributes = this.f20643b.getTheme().obtainStyledAttributes(typedValue.resourceId, C6036m.customDialogDefinition);
        Drawable drawable = obtainStyledAttributes.getDrawable(C6036m.customDialogDefinition_dialogBackground);
        TypedValue typedValue2 = new TypedValue();
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_contentTextSize, typedValue2);
        int complexToFloat = (int) TypedValue.complexToFloat(typedValue2.data);
        obtainStyledAttributes.recycle();
        view.setBackground(drawable);
        return complexToFloat;
    }

    private void m27503a(View view, int i) {
        TextView textView = (TextView) view.findViewById(C6030g.dialog_no_title_tv_message);
        if (((float) i) != GroundOverlayOptions.NO_DIMENSION) {
            textView.setTextSize(1, (float) i);
        }
        textView.setText(this.f20644c);
        TextView textView2 = (TextView) view.findViewById(C6030g.dialog_no_title_tv_info);
        if (this.f20645d == null || this.f20645d.isEmpty()) {
            textView2.setVisibility(8);
            ((LayoutParams) textView.getLayoutParams()).addRule(13);
            return;
        }
        textView2.setVisibility(0);
        textView2.setText(this.f20645d);
    }

    private void m27506b(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C6030g.dialog_linearlayout1);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C6030g.dialog_linearlayout2);
        Button button = (Button) linearLayout.findViewById(C6030g.dialog_no_title_btn_negative);
        Button button2 = (Button) linearLayout.findViewById(C6030g.dialog_no_title_btn_positive);
        Button button3 = (Button) linearLayout2.findViewById(C6030g.dialog_one_no_title_btn);
        C2538c.b("NoTitleCustomAlertDialog", new Object[]{"negativeButtonText = ", this.f20647f});
        if (this.f20646e != null && this.f20647f != null) {
            m27509c(linearLayout, linearLayout2, button, button2);
        } else if (this.f20646e == null && this.f20647f != null) {
            m27507b(linearLayout, linearLayout2, button, button3);
        } else if (this.f20646e == null || this.f20647f != null) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
        } else {
            m27504a(linearLayout, linearLayout2, button2, button3);
        }
    }

    private void m27504a(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, Button button2) {
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        button2.setText(this.f20646e);
        if (this.f20648g != 0) {
            button.setTextColor(this.f20643b.getResources().getColor(this.f20648g));
        }
        if (this.f20650i != null) {
            button2.setOnClickListener(new am(this));
        }
    }

    private void m27507b(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, Button button2) {
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        button2.setText(this.f20647f);
        if (this.f20649h != 0) {
            button.setTextColor(this.f20643b.getResources().getColor(this.f20649h));
        }
        if (this.f20651j != null) {
            button2.setOnClickListener(new al(this));
        }
    }

    private void m27509c(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, Button button2) {
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        button2.setText(this.f20646e);
        if (this.f20648g != 0) {
            button2.setTextColor(this.f20643b.getResources().getColor(this.f20648g));
        }
        if (this.f20650i != null) {
            button2.setOnClickListener(new am(this));
        }
        button.setText(this.f20647f);
        if (this.f20649h != 0) {
            button.setTextColor(this.f20643b.getResources().getColor(this.f20649h));
        }
        if (this.f20651j != null) {
            button.setOnClickListener(new al(this));
        }
    }

    private void m27508c(View view) {
        this.f20642a.setContentView(view);
        Window window = this.f20642a.getWindow();
        window.setGravity(80);
        Display defaultDisplay = ((WindowManager) this.f20643b.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int a = ai.m27500a(this.f20643b, 8.0f);
        attributes.width = defaultDisplay.getWidth() - (a * 2);
        attributes.y = a;
        window.setAttributes(attributes);
        window.setWindowAnimations(C6035l.track_dialog_anim);
    }
}
