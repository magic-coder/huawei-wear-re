package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.p514d.C6000d;

/* compiled from: CustomLoadingDialog */
class C6010i {
    private View f20709a;
    private LinearLayout f20710b;
    private TextView f20711c;
    private ImageView f20712d;

    public C6010i(Context context, Boolean bool) {
        m27565a(context, bool);
    }

    private void m27565a(Context context, Boolean bool) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (bool.booleanValue()) {
            this.f20709a = layoutInflater.inflate(C6031h.commonui_vertical_loading_dialog, null);
        } else {
            this.f20709a = layoutInflater.inflate(C6031h.commonui_loading_dialog, null);
        }
        this.f20710b = (LinearLayout) C6000d.m27461a(this.f20709a, C6030g.dialog_rlyt_content);
        this.f20711c = (TextView) C6000d.m27461a(this.f20709a, C6030g.dialog_tv_message);
        this.f20712d = (ImageView) C6000d.m27461a(this.f20709a, C6030g.dialog_pb_progressbar);
        ((AnimationDrawable) this.f20712d.getDrawable()).start();
    }

    public View m27566a() {
        return this.f20709a;
    }

    public void m27568b() {
        this.f20710b.setVisibility(0);
        this.f20712d.setVisibility(0);
    }

    public void m27567a(String str) {
        this.f20710b.setVisibility(0);
        this.f20711c.setVisibility(0);
        this.f20711c.setText(str);
    }
}
