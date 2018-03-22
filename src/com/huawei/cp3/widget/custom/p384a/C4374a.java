package com.huawei.cp3.widget.custom.p384a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.cp3.C4366c;
import com.huawei.cp3.C4367d;
import com.huawei.cp3.widget.p382a.p383a.C4370a;

/* compiled from: HwDialogCustom */
public class C4374a extends Dialog implements C4370a {
    private TextView f16230a;
    private TextView f16231b;
    private Button f16232c;
    private Button f16233d;
    private Button f16234e;
    private LinearLayout f16235f;
    private ImageView f16236g;
    private LinearLayout f16237h;
    private LinearLayout f16238i;
    private LinearLayout f16239j;
    private boolean f16240k = false;
    private boolean f16241l = false;
    private boolean f16242m = false;
    private LayoutInflater f16243n;
    private Context f16244o;

    public C4374a(Context context, int i) {
        super(context, i);
        this.f16244o = context;
        this.f16243n = (LayoutInflater) context.getSystemService("layout_inflater");
        m21009b();
    }

    public C4370a mo4426a(View view) {
        if (this.f16238i != null) {
            this.f16238i.removeAllViews();
            this.f16238i.addView(view);
            this.f16238i.setVisibility(0);
        }
        return this;
    }

    private void m21009b() {
        requestWindowFeature(1);
        setContentView(C4367d.cp3_custom_dialog_layout);
        this.f16235f = (LinearLayout) findViewById(C4366c.dialog_layout);
        this.f16230a = (TextView) findViewById(C4366c.title);
        this.f16239j = (LinearLayout) findViewById(C4366c.titleView);
        this.f16238i = (LinearLayout) findViewById(C4366c.content);
        this.f16231b = (TextView) findViewById(C4366c.msg);
        this.f16237h = (LinearLayout) findViewById(C4366c.button_layout);
        this.f16232c = (Button) findViewById(C4366c.ok);
        this.f16233d = (Button) findViewById(C4366c.cancel);
        this.f16234e = (Button) findViewById(C4366c.neutral);
    }

    public C4370a mo4427a(CharSequence charSequence, OnClickListener onClickListener) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.f16235f.setPadding(0, 0, 0, 0);
        if (this.f16236g != null) {
            this.f16236g.setVisibility(0);
        }
        this.f16232c.setText(charSequence);
        this.f16237h.setVisibility(0);
        this.f16232c.setVisibility(0);
        this.f16232c.setOnClickListener(new C4375b(this, onClickListener));
        return this;
    }

    public C4370a mo4425a(int i, OnClickListener onClickListener) {
        return mo4427a(this.f16244o.getResources().getString(i), onClickListener);
    }

    public C4370a mo4430b(CharSequence charSequence, OnClickListener onClickListener) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.f16235f.setPadding(0, 0, 0, 0);
        if (this.f16236g != null) {
            this.f16236g.setVisibility(0);
        }
        this.f16233d.setText(charSequence);
        this.f16237h.setVisibility(0);
        this.f16233d.setVisibility(0);
        this.f16233d.setOnClickListener(new C4376c(this, onClickListener));
        return this;
    }

    public C4370a mo4429b(int i, OnClickListener onClickListener) {
        return mo4430b(this.f16244o.getResources().getString(i), onClickListener);
    }

    public C4370a mo4428a(String str) {
        if (this.f16230a != null) {
            this.f16230a.setVisibility(0);
            this.f16230a.setText(str);
        }
        return this;
    }

    public void setTitle(int i) {
        CharSequence string = this.f16244o.getResources().getString(i);
        if (this.f16230a != null) {
            this.f16230a.setVisibility(0);
            this.f16230a.setText(string);
        }
    }

    public C4370a mo4431b(String str) {
        if (this.f16231b != null) {
            this.f16231b.setVisibility(0);
            this.f16231b.setText(str);
        }
        return this;
    }

    public C4370a mo4424a(int i) {
        return mo4431b(this.f16244o.getResources().getString(i));
    }

    public View m21010a() {
        return this.f16238i;
    }

    public void setOnKeyListener(OnKeyListener onKeyListener) {
        super.setOnKeyListener(onKeyListener);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
    }

    public void onContentChanged() {
        super.onContentChanged();
        Window window = getWindow();
        if (window != null) {
            LayoutParams attributes = window.getAttributes();
            int a = C4379f.m21040a(getContext());
            int b = C4379f.m21041b(getContext());
            if (a > b) {
                attributes.width = (int) (((double) b) * 0.85d);
            } else {
                attributes.width = (int) (((double) a) * 0.85d);
            }
            window.setAttributes(attributes);
        }
    }

    public boolean onSearchRequested() {
        if (this.f16241l) {
            return this.f16242m;
        }
        return super.onSearchRequested();
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            Log.e("HwDialogCustom", "showDialog failed.", e);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable e) {
            Log.e("HwDialogCustom", "dismiss failed.", e);
        }
    }

    public void cancel() {
        try {
            super.cancel();
        } catch (Throwable e) {
            Log.e("HwDialogCustom", "cancel failed.", e);
        }
    }

    public void hide() {
        try {
            super.hide();
        } catch (Throwable e) {
            Log.e("HwDialogCustom", "hide failed.", e);
        }
    }
}
