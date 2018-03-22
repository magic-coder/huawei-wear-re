package com.huawei.cp3.widget.p382a.p383a;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.View;
import android.view.Window;

/* compiled from: HwDialogInterface */
public interface C4370a {
    C4370a mo4424a(int i);

    C4370a mo4425a(int i, OnClickListener onClickListener);

    C4370a mo4426a(View view);

    C4370a mo4427a(CharSequence charSequence, OnClickListener onClickListener);

    C4370a mo4428a(String str);

    C4370a mo4429b(int i, OnClickListener onClickListener);

    C4370a mo4430b(CharSequence charSequence, OnClickListener onClickListener);

    C4370a mo4431b(String str);

    void dismiss();

    Window getWindow();

    boolean isShowing();

    void setCancelable(boolean z);

    void setCanceledOnTouchOutside(boolean z);

    void setOnKeyListener(OnKeyListener onKeyListener);

    void setTitle(int i);

    void show();
}
