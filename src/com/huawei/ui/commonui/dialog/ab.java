package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6035l;
import com.huawei.ui.commonui.C6036m;

/* compiled from: CustomViewDialog */
public class ab {
    C6027z f20623a = null;
    private Context f20624b;
    private String f20625c;
    private View f20626d;
    private String f20627e;
    private String f20628f;
    private OnClickListener f20629g;
    private OnClickListener f20630h;

    public ab(Context context) {
        this.f20624b = context;
    }

    public ab m27486a(int i) {
        this.f20625c = (String) this.f20624b.getText(i);
        return this;
    }

    public ab m27489a(String str) {
        this.f20625c = str;
        return this;
    }

    public ab m27488a(View view) {
        this.f20626d = view;
        return this;
    }

    public ab m27487a(int i, OnClickListener onClickListener) {
        this.f20627e = (String) this.f20624b.getText(i);
        this.f20629g = onClickListener;
        return this;
    }

    public ab m27490a(String str, OnClickListener onClickListener) {
        this.f20627e = str;
        this.f20629g = onClickListener;
        return this;
    }

    public ab m27492b(String str, OnClickListener onClickListener) {
        this.f20628f = str;
        this.f20630h = onClickListener;
        return this;
    }

    public C6027z m27491a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f20624b.getSystemService("layout_inflater");
        this.f20623a = new C6027z(this.f20624b, C6035l.CustomDialog);
        View inflate = layoutInflater.inflate(C6031h.commonui_custom_view_dialog, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C6030g.custom_view_dialog_title_layout);
        TypedValue typedValue = new TypedValue();
        this.f20624b.getTheme().resolveAttribute(C5996c.customDialogStyleRefer, typedValue, true);
        TypedArray obtainStyledAttributes = this.f20624b.getTheme().obtainStyledAttributes(typedValue.resourceId, C6036m.customDialogDefinition);
        Drawable drawable = obtainStyledAttributes.getDrawable(C6036m.customDialogDefinition_dialogBackground);
        TypedValue typedValue2 = new TypedValue();
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_titleTextSize, typedValue2);
        int complexToFloat = (int) TypedValue.complexToFloat(typedValue2.data);
        obtainStyledAttributes.recycle();
        inflate.setBackground(drawable);
        if (this.f20625c == null) {
            linearLayout.setVisibility(8);
        } else {
            TextView textView = (TextView) inflate.findViewById(C6030g.custom_view_dailog_title);
            textView.setTextSize(1, (float) complexToFloat);
            textView.setText(this.f20625c);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(C6030g.dialog_rlyt_content);
        if (this.f20626d != null) {
            relativeLayout.removeAllViews();
            relativeLayout.addView(this.f20626d, new LayoutParams(-2, -2));
        }
        linearLayout = (LinearLayout) inflate.findViewById(C6030g.dialog_linearlayout1);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(C6030g.dialog_linearlayout2);
        Button button = (Button) linearLayout.findViewById(C6030g.dialog_view_btn_negative);
        Button button2 = (Button) linearLayout.findViewById(C6030g.dialog_view_btn_positive);
        Button button3 = (Button) linearLayout2.findViewById(C6030g.dialog_one_view_btn);
        if (this.f20627e != null && this.f20628f != null) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            button2.setText(this.f20627e);
            if (this.f20629g != null) {
                button2.setOnClickListener(new ad(this));
            }
            button.setText(this.f20628f);
            if (this.f20630h != null) {
                button.setOnClickListener(new ac(this));
            }
        } else if (this.f20627e == null && this.f20628f != null) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            button3.setText(this.f20628f);
            if (this.f20630h != null) {
                button3.setOnClickListener(new ac(this));
            }
        } else if (this.f20627e == null || this.f20628f != null) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
        } else {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            button3.setText(this.f20627e);
            if (this.f20629g != null) {
                button3.setOnClickListener(new ad(this));
            }
        }
        this.f20623a.setContentView(inflate);
        Window window = this.f20623a.getWindow();
        window.setGravity(80);
        Display defaultDisplay = ((WindowManager) this.f20624b.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        complexToFloat = C6027z.m27600a(this.f20624b, 8.0f);
        attributes.width = defaultDisplay.getWidth() - (complexToFloat * 2);
        attributes.y = complexToFloat;
        window.setAttributes(attributes);
        window.setWindowAnimations(C6035l.track_dialog_anim);
        return this.f20623a;
    }
}
