package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6035l;
import com.huawei.p190v.C2538c;

/* compiled from: CommonDialog21 */
public class C6002a extends Dialog {
    private static C6002a f20615c;
    Context f20616a;
    private ImageView f20617b;
    private OnClickListener f20618d;
    private OnClickListener f20619e;
    private String f20620f;
    private String f20621g;
    private LinearLayout f20622h;

    public C6002a(Context context, int i) {
        super(context, i);
        this.f20616a = context;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static C6002a m27468a(Context context) {
        f20615c = new C6002a(context, C6035l.common_dialog21);
        f20615c.setContentView(C6031h.commonui_loading21);
        return f20615c;
    }

    public void m27476a(String str) {
        ((TextView) f20615c.findViewById(C6030g.BasicInfo_check_textView)).setText(str);
    }

    public void m27474a() {
        C2538c.c("test", new Object[]{"enter startAni"});
        super.show();
        this.f20617b = (ImageView) f20615c.findViewById(C6030g.BasicInfo_check_img);
        ((AnimationDrawable) this.f20617b.getDrawable()).start();
        f20615c.onWindowAttributesChanged(m27467a(f20615c));
        C2538c.c("test", new Object[]{"end startAni"});
    }

    public static C6002a m27469b(Context context) {
        f20615c = new C6002a(context, C6035l.common_dialog21);
        f20615c.setContentView(C6031h.commonui_notice21);
        return f20615c;
    }

    public static C6002a m27470c(Context context) {
        f20615c = new C6002a(context, C6035l.common_dialog21);
        f20615c.setContentView(C6031h.commonui_notice21_single);
        return f20615c;
    }

    public void m27479b(String str) {
        ((TextView) f20615c.findViewById(C6030g.notice_title)).setText(str);
    }

    public void m27482c(String str) {
        ((TextView) f20615c.findViewById(C6030g.notice_message)).setText(str);
    }

    public void m27477a(String str, OnClickListener onClickListener) {
        this.f20620f = str;
        this.f20618d = onClickListener;
    }

    public void m27480b(String str, OnClickListener onClickListener) {
        this.f20621g = str;
        this.f20619e = onClickListener;
    }

    public void m27478b() {
        Button button = (Button) f20615c.findViewById(C6030g.notice_button_left);
        Button button2 = (Button) f20615c.findViewById(C6030g.notice_button_right);
        if (button != null) {
            button.setText(this.f20621g);
        }
        if (button2 != null) {
            button2.setText(this.f20620f);
        }
        if (!(this.f20618d == null || button2 == null)) {
            button2.setOnClickListener(this.f20618d);
        }
        if (!(this.f20619e == null || button == null)) {
            button.setOnClickListener(this.f20619e);
        }
        f20615c.onWindowAttributesChanged(m27467a(f20615c));
        super.show();
    }

    private void m27472d() {
        Button button = (Button) f20615c.findViewById(C6030g.notice_button_left);
        Button button2 = (Button) f20615c.findViewById(C6030g.notice_button_right);
        button.setText(this.f20621g);
        button2.setText(this.f20620f);
        if (this.f20618d != null) {
            button2.setOnClickListener(this.f20618d);
        }
        if (this.f20619e != null) {
            button.setOnClickListener(this.f20619e);
        }
    }

    public static C6002a m27471d(Context context) {
        f20615c = new C6002a(context, C6035l.common_dialog21);
        f20615c.setContentView(C6031h.commonui_info21);
        return f20615c;
    }

    public void m27483d(String str) {
        if (str != null) {
            ((TextView) f20615c.findViewById(C6030g.basicInfo_notification_title)).setText(str);
        }
    }

    public void m27475a(View view) {
        this.f20622h = (LinearLayout) f20615c.findViewById(C6030g.person_info_add_view);
        this.f20622h.removeAllViews();
        this.f20622h.addView(view);
    }

    public void m27481c() {
        m27472d();
        f20615c.onWindowAttributesChanged(m27467a(f20615c));
        super.show();
    }

    private LayoutParams m27467a(C6002a c6002a) {
        Window window = c6002a.getWindow();
        window.setGravity(80);
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        return attributes;
    }

    public void cancel() {
        super.cancel();
        d.n(this.f20616a);
        this.f20616a = null;
        C6002a.m27473e();
    }

    public void dismiss() {
        super.dismiss();
        d.n(this.f20616a);
        this.f20616a = null;
        C6002a.m27473e();
    }

    private static void m27473e() {
        f20615c = null;
    }
}
