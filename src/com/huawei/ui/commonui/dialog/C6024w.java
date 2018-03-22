package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6035l;
import com.huawei.ui.commonui.C6036m;
import com.huawei.p190v.C2538c;

/* compiled from: CustomTextAlertDialog */
public class C6024w {
    C6022u f20743a = null;
    private Context f20744b;
    private String f20745c;
    private String f20746d;
    private SpannableString f20747e;
    private String f20748f;
    private String f20749g;
    private int f20750h = 0;
    private int f20751i = 0;
    private OnClickListener f20752j;
    private OnClickListener f20753k;

    public C6024w(Context context) {
        this.f20744b = context;
    }

    public C6024w m27591a(int i) {
        this.f20745c = (String) this.f20744b.getText(i);
        return this;
    }

    public C6024w m27594a(String str) {
        this.f20745c = str;
        return this;
    }

    public C6024w m27596b(int i) {
        this.f20746d = (String) this.f20744b.getText(i);
        return this;
    }

    public C6024w m27598b(String str) {
        this.f20746d = str;
        return this;
    }

    public C6024w m27593a(int i, OnClickListener onClickListener) {
        this.f20748f = ((String) this.f20744b.getText(i)).toUpperCase();
        this.f20752j = onClickListener;
        return this;
    }

    public C6024w m27595a(String str, OnClickListener onClickListener) {
        this.f20748f = str.toUpperCase();
        this.f20752j = onClickListener;
        return this;
    }

    public C6024w m27592a(int i, int i2, OnClickListener onClickListener) {
        this.f20748f = ((String) this.f20744b.getText(i)).toUpperCase();
        this.f20750h = i2;
        this.f20752j = onClickListener;
        return this;
    }

    public C6024w m27597b(int i, OnClickListener onClickListener) {
        this.f20749g = ((String) this.f20744b.getText(i)).toUpperCase();
        this.f20753k = onClickListener;
        return this;
    }

    public C6024w m27599b(String str, OnClickListener onClickListener) {
        this.f20749g = str.toUpperCase();
        this.f20753k = onClickListener;
        return this;
    }

    public C6022u m27590a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f20744b.getSystemService("layout_inflater");
        this.f20743a = new C6022u(this.f20744b, C6035l.CustomDialog);
        View inflate = layoutInflater.inflate(C6031h.commonui_custom_text_alert_dialog, null);
        TextView textView = (TextView) inflate.findViewById(C6030g.dialog_text_alert_message);
        textView.setTextSize(1, (float) m27586b(inflate));
        if (this.f20747e != null) {
            textView.setText(this.f20747e);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setText(this.f20746d);
        }
        m27583a(inflate);
        return m27589c(inflate);
    }

    private void m27583a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C6030g.dialog_linearlayout1);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C6030g.dialog_linearlayout2);
        Button button = (Button) linearLayout.findViewById(C6030g.dialog_text_alert_btn_negative);
        Button button2 = (Button) linearLayout.findViewById(C6030g.dialog_text_alert_btn_positive);
        Button button3 = (Button) linearLayout2.findViewById(C6030g.dialog_one_text_alert_btn);
        if (this.f20748f != null && this.f20749g != null) {
            m27588b(linearLayout, linearLayout2, button, button2);
        } else if (this.f20748f == null && this.f20749g != null) {
            m27585a(linearLayout, linearLayout2, button, button3);
        } else if (this.f20748f == null || this.f20749g != null) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
        } else {
            m27584a(linearLayout, linearLayout2, button3);
        }
    }

    private void m27584a(LinearLayout linearLayout, LinearLayout linearLayout2, Button button) {
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        button.setText(this.f20748f);
        if (this.f20750h != 0) {
            button.setTextColor(this.f20744b.getResources().getColor(this.f20750h));
        }
        if (this.f20752j != null) {
            button.setOnClickListener(new C6026y(this));
        }
    }

    private void m27585a(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, Button button2) {
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        button2.setText(this.f20749g);
        if (this.f20751i != 0) {
            button.setTextColor(this.f20744b.getResources().getColor(this.f20751i));
        }
        if (this.f20753k != null) {
            button2.setOnClickListener(new C6025x(this));
        }
    }

    private void m27588b(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, Button button2) {
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        button2.setText(this.f20748f);
        if (this.f20750h != 0) {
            button2.setTextColor(this.f20744b.getResources().getColor(this.f20750h));
        }
        if (this.f20752j != null) {
            button2.setOnClickListener(new C6026y(this));
        }
        button.setText(this.f20749g);
        if (this.f20751i != 0) {
            button.setTextColor(this.f20744b.getResources().getColor(this.f20751i));
        }
        if (this.f20753k != null) {
            button.setOnClickListener(new C6025x(this));
        }
    }

    private int m27586b(View view) {
        TypedValue typedValue = new TypedValue();
        this.f20744b.getTheme().resolveAttribute(C5996c.customDialogStyleRefer, typedValue, true);
        TypedArray obtainStyledAttributes = this.f20744b.getTheme().obtainStyledAttributes(typedValue.resourceId, C6036m.customDialogDefinition);
        Drawable drawable = obtainStyledAttributes.getDrawable(C6036m.customDialogDefinition_dialogBackground);
        TypedValue typedValue2 = new TypedValue();
        TypedValue typedValue3 = new TypedValue();
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_titleTextSize, typedValue2);
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_contentTextSize, typedValue3);
        int complexToFloat = (int) TypedValue.complexToFloat(typedValue2.data);
        int complexToFloat2 = (int) TypedValue.complexToFloat(typedValue3.data);
        obtainStyledAttributes.recycle();
        view.setBackground(drawable);
        TextView textView = (TextView) view.findViewById(C6030g.custom_text_alert_dailog_title);
        textView.setTextSize(1, (float) complexToFloat);
        textView.setText(this.f20745c);
        C2538c.b("CustomTextAlertDialog", new Object[]{"content = " + this.f20746d});
        C2538c.b("CustomTextAlertDialog", new Object[]{"contentTextSize = " + complexToFloat2});
        return complexToFloat2;
    }

    private C6022u m27589c(View view) {
        this.f20743a.setContentView(view);
        Window window = this.f20743a.getWindow();
        window.setGravity(80);
        Display defaultDisplay = ((WindowManager) this.f20744b.getSystemService("window")).getDefaultDisplay();
        LayoutParams attributes = window.getAttributes();
        int a = C6022u.m27581a(this.f20744b, 8.0f);
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        C2538c.c("CustomTextAlertDialog", new Object[]{"screen width = " + width + ",height = " + height});
        if (width > height) {
            attributes.width = height - (a * 2);
        } else {
            attributes.width = width - (a * 2);
        }
        C2538c.c("CustomTextAlertDialog", new Object[]{"dialog width = " + attributes.width + ",height = " + a});
        attributes.y = a;
        window.setAttributes(attributes);
        window.setWindowAnimations(C6035l.track_dialog_anim);
        return this.f20743a;
    }
}
