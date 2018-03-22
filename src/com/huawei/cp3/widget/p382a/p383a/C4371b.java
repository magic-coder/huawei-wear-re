package com.huawei.cp3.widget.p382a.p383a;

import android.content.DialogInterface.OnCancelListener;
import android.view.Window;

/* compiled from: HwProgressDialogInterface */
public interface C4371b {
    void mo4438a(int i);

    void mo4439a(CharSequence charSequence);

    void dismiss();

    Window getWindow();

    boolean isShowing();

    void setCancelable(boolean z);

    void setCanceledOnTouchOutside(boolean z);

    void setOnCancelListener(OnCancelListener onCancelListener);

    void show();
}
