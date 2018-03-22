package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.pluginkidwatch.e;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

/* compiled from: CustomDialog */
public class C1597x {
    OnClickListener f3988a = new C1598y(this);
    final /* synthetic */ CustomDialog f3989b;
    private C1596w f3990c;
    private View f3991d;
    private LinearLayout f3992e;
    private LinearLayout f3993f;
    private RelativeLayout f3994g;
    private RelativeLayout f3995h;
    private TextView f3996i;
    private TextView f3997j;
    private Button f3998k;
    private Button f3999l;
    private Button f4000m;
    private ListView f4001n;
    private ProgressBar f4002o;
    private ImageView f4003p;
    private Message f4004q;
    private Message f4005r;
    private Message f4006s;
    private boolean f4007t = true;

    public C1597x(CustomDialog customDialog, Context context) {
        this.f3989b = customDialog;
        m7353a(context);
    }

    private void m7353a(Context context) {
        this.f3991d = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(h.k1_commonui_custom_dialog, null);
        this.f3994g = (RelativeLayout) this.f3991d.findViewById(g.k1_dialog_rlyt_title);
        this.f3992e = (LinearLayout) this.f3991d.findViewById(g.k1_dialog_llyt_btn_panel);
        this.f3995h = (RelativeLayout) this.f3991d.findViewById(g.k1_dialog_rlyt_content);
        this.f3993f = (LinearLayout) this.f3991d.findViewById(g.k1_dialog_llyt_message);
        this.f3996i = (TextView) this.f3991d.findViewById(g.k1_dialog_tv_title);
        this.f4003p = (ImageView) this.f3991d.findViewById(g.k1_dialog_iv_title);
        this.f3997j = (TextView) this.f3991d.findViewById(g.k1_dialog_tv_message);
        this.f3998k = (Button) this.f3991d.findViewById(g.k1_dialog_btn_positive);
        this.f3999l = (Button) this.f3991d.findViewById(g.k1_dialog_btn_neutral);
        this.f4000m = (Button) this.f3991d.findViewById(g.k1_dialog_btn_negative);
        this.f4001n = (ListView) this.f3991d.findViewById(g.k1_dialog_lv_content);
        this.f4002o = (ProgressBar) this.f3991d.findViewById(g.k1_dialog_pb_progressbar);
    }

    public void m7360a(C1596w c1596w) {
        this.f3990c = c1596w;
        if (C1596w.PROGRESS == c1596w) {
            this.f3995h.setVisibility(0);
            this.f4002o.setVisibility(0);
            this.f3997j.setGravity(19);
        }
    }

    public void m7361a(String str) {
        this.f3994g.setVisibility(0);
        this.f3996i.setVisibility(0);
        this.f3996i.setText(str);
    }

    public void m7363b(String str) {
        this.f3995h.setVisibility(0);
        this.f3993f.setVisibility(0);
        this.f3997j.setVisibility(0);
        this.f3997j.setText(str);
        if (m7355b()) {
            this.f3997j.setGravity(19);
        } else {
            this.f3997j.setGravity(17);
        }
    }

    private boolean m7355b() {
        if (C1596w.PROGRESS == this.f3990c || this.f3996i.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void m7359a(View view) {
        this.f3995h.setVisibility(0);
        this.f3995h.removeAllViews();
        this.f3995h.addView(view, new LayoutParams((int) this.f3989b.f3802c.getResources().getDimension(e.custom_dialog_min_width), -2));
    }

    public View m7358a() {
        return this.f3991d;
    }

    public void m7362a(String str, DialogInterface.OnClickListener onClickListener) {
        this.f3992e.setVisibility(0);
        this.f3998k.setVisibility(0);
        this.f3998k.setText(str);
        if (onClickListener != null) {
            this.f4004q = CustomDialog.f3800a.obtainMessage(-1, onClickListener);
            this.f3998k.setOnClickListener(this.f3988a);
        }
    }

    public void m7364b(String str, DialogInterface.OnClickListener onClickListener) {
        this.f3992e.setVisibility(0);
        this.f4000m.setVisibility(0);
        this.f4000m.setText(str);
        if (onClickListener != null) {
            this.f4006s = CustomDialog.f3800a.obtainMessage(-2, onClickListener);
            this.f4000m.setOnClickListener(this.f3988a);
        }
    }
}
