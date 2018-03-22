package com.huawei.pluginaf500.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.i;

/* compiled from: CustomProgressDialog */
public class C5827a extends Dialog {
    private static C5827a f20026a = null;

    public C5827a(Context context, int i) {
        super(context, i);
    }

    public static C5827a m26922a(Context context) {
        f20026a = new C5827a(context, i.CustomProgressDialog);
        f20026a.setContentView(f.customprogressdialog);
        f20026a.getWindow().getAttributes().gravity = 17;
        return f20026a;
    }

    public void onWindowFocusChanged(boolean z) {
        if (f20026a != null) {
            ((AnimationDrawable) ((ImageView) f20026a.findViewById(e.loadingImageView)).getBackground()).start();
        }
    }

    public C5827a m26923a(String str) {
        TextView textView = (TextView) f20026a.findViewById(e.id_tv_loadingmsg);
        if (textView != null) {
            textView.setText(str);
        }
        return f20026a;
    }
}
