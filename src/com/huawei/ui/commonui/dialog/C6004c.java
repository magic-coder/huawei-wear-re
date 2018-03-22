package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6035l;
import com.huawei.ui.commonui.C6036m;

/* compiled from: CustomAlertDialog */
public class C6004c {
    private Context f20672a;
    private boolean f20673b = true;
    private OnCancelListener f20674c;
    private OnKeyListener f20675d;
    private CustomAlertDialog f20676e;
    private C6005d f20677f;

    public C6004c(Context context) {
        this.f20672a = context;
        this.f20676e = new CustomAlertDialog(context, C6035l.CustomDialog);
        this.f20677f = this.f20676e.m27466b();
        CustomAlertDialog.f20612a = new ButtonHandler(this.f20676e);
    }

    public C6004c m27540a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f20677f.m27553a(str);
        }
        return this;
    }

    public C6004c m27536a(int i) {
        String string = this.f20672a.getString(i);
        if (!TextUtils.isEmpty(string)) {
            this.f20677f.m27553a(string);
        }
        return this;
    }

    public C6004c m27542b(int i) {
        String string = this.f20672a.getString(i);
        if (!TextUtils.isEmpty(string)) {
            this.f20677f.m27555b(string);
        }
        return this;
    }

    public C6004c m27538a(View view) {
        this.f20677f.m27552a(view);
        return this;
    }

    public C6004c m27537a(int i, OnClickListener onClickListener) {
        String str = (String) this.f20672a.getText(i);
        if (!TextUtils.isEmpty(str)) {
            this.f20677f.m27554a(str, onClickListener);
        }
        return this;
    }

    public C6004c m27539a(CharSequence charSequence, OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f20677f.m27554a((String) charSequence, onClickListener);
        }
        return this;
    }

    public C6004c m27544b(CharSequence charSequence, OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f20677f.m27556b((String) charSequence, onClickListener);
        }
        return this;
    }

    public C6004c m27543b(int i, OnClickListener onClickListener) {
        String str = (String) this.f20672a.getText(i);
        if (!TextUtils.isEmpty(str)) {
            this.f20677f.m27557c(str, onClickListener);
        }
        return this;
    }

    public C6004c m27545c(CharSequence charSequence, OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f20677f.m27557c((String) charSequence, onClickListener);
        }
        return this;
    }

    public CustomAlertDialog m27535a() {
        return m27534b();
    }

    public C6004c m27541a(boolean z) {
        this.f20673b = z;
        return this;
    }

    private CustomAlertDialog m27534b() {
        TypedValue typedValue = new TypedValue();
        this.f20672a.getTheme().resolveAttribute(C5996c.customDialogStyleRefer, typedValue, true);
        TypedArray obtainStyledAttributes = this.f20672a.getTheme().obtainStyledAttributes(typedValue.resourceId, C6036m.customDialogDefinition);
        Drawable drawable = obtainStyledAttributes.getDrawable(C6036m.customDialogDefinition_dialogBackground);
        obtainStyledAttributes.recycle();
        this.f20677f.m27551a().setBackground(drawable);
        this.f20676e.addContentView(this.f20677f.m27551a(), new LayoutParams(-2, -2));
        this.f20676e.setContentView(this.f20677f.m27551a());
        this.f20676e.setCancelable(this.f20673b);
        this.f20676e.setOnCancelListener(this.f20674c);
        this.f20676e.setOnKeyListener(this.f20675d);
        Window window = this.f20676e.getWindow();
        window.setGravity(80);
        Display defaultDisplay = ((WindowManager) this.f20672a.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int a = CustomAlertDialog.m27462a(this.f20672a, 8.0f);
        attributes.width = defaultDisplay.getWidth() - (a * 2);
        attributes.y = a;
        window.setAttributes(attributes);
        window.setWindowAnimations(C6035l.track_dialog_anim);
        return this.f20676e;
    }
}
