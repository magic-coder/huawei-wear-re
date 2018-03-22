package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Button;

/* compiled from: ProGuard */
class C6257j extends View {
    final /* synthetic */ ImageActivity f21767a;

    public C6257j(ImageActivity imageActivity, Context context) {
        this.f21767a = imageActivity;
        super(context);
    }

    public void m28764a(Button button) {
        Drawable stateListDrawable = new StateListDrawable();
        Drawable a = this.f21767a.m28729b("com.tencent.plus.blue_normal.png");
        Drawable a2 = this.f21767a.m28729b("com.tencent.plus.blue_down.png");
        Drawable a3 = this.f21767a.m28729b("com.tencent.plus.blue_disable.png");
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, a2);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, a);
        stateListDrawable.addState(View.ENABLED_STATE_SET, a);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, a);
        stateListDrawable.addState(View.EMPTY_STATE_SET, a3);
        button.setBackgroundDrawable(stateListDrawable);
    }

    public void m28765b(Button button) {
        Drawable stateListDrawable = new StateListDrawable();
        Drawable a = this.f21767a.m28729b("com.tencent.plus.gray_normal.png");
        Drawable a2 = this.f21767a.m28729b("com.tencent.plus.gray_down.png");
        Drawable a3 = this.f21767a.m28729b("com.tencent.plus.gray_disable.png");
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, a2);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, a);
        stateListDrawable.addState(View.ENABLED_STATE_SET, a);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, a);
        stateListDrawable.addState(View.EMPTY_STATE_SET, a3);
        button.setBackgroundDrawable(stateListDrawable);
    }
}
