package com.huawei.pluginaf500.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.pluginaf500.b;
import com.huawei.pluginaf500.c;
import com.huawei.pluginaf500.d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;

/* compiled from: CustomDialog */
public class C5823f {
    OnClickListener f20007a = new C5824g(this);
    private Context f20008b;
    private boolean f20009c;
    private C5825h f20010d;
    private String f20011e;
    private String f20012f;
    private String f20013g;
    private String f20014h;
    private View f20015i;
    private boolean f20016j;
    private DialogInterface.OnClickListener f20017k;
    private DialogInterface.OnClickListener f20018l;
    private Handler f20019m = null;
    private Message f20020n;
    private Message f20021o;

    public C5823f(Context context) {
        this.f20008b = context;
        this.f20010d = C5825h.NORMAL;
        this.f20016j = true;
        this.f20009c = false;
    }

    public C5823f m26915a(int i) {
        this.f20011e = this.f20008b.getString(i);
        return this;
    }

    public C5823f m26919b(int i) {
        this.f20012f = this.f20008b.getString(i);
        return this;
    }

    public C5823f m26918a(C5825h c5825h) {
        this.f20010d = c5825h;
        return this;
    }

    public C5823f m26917a(View view) {
        this.f20015i = view;
        return this;
    }

    public C5823f m26916a(int i, DialogInterface.OnClickListener onClickListener) {
        this.f20013g = (String) this.f20008b.getText(i);
        this.f20017k = onClickListener;
        return this;
    }

    public C5823f m26920b(int i, DialogInterface.OnClickListener onClickListener) {
        this.f20014h = (String) this.f20008b.getText(i);
        this.f20018l = onClickListener;
        return this;
    }

    public CustomDialog m26914a() {
        return m26912b();
    }

    private CustomDialog m26912b() {
        CustomDialog customDialog = new CustomDialog(this.f20008b);
        this.f20019m = new ButtonHandler(customDialog);
        View inflate = ((LayoutInflater) this.f20008b.getSystemService("layout_inflater")).inflate(this.f20008b.getResources().getLayout(f.custom_dialog), null);
        if (this.f20009c) {
            inflate.setBackgroundResource(b.common_ui_custom_dialog_transparent_bg);
        } else {
            inflate.setBackgroundResource(d.common_ui_popup_full_bright_emui);
        }
        customDialog.addContentView(inflate, new LayoutParams(-2, -2));
        TextView textView = (TextView) inflate.findViewById(e.dialog_title);
        if (TextUtils.isEmpty(this.f20011e)) {
            textView.setVisibility(8);
            ((ImageView) inflate.findViewById(e.title_divider)).setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(this.f20011e);
        }
        textView = (TextView) inflate.findViewById(e.dialog_message);
        Button button = (Button) inflate.findViewById(e.positive_btn);
        Button button2 = (Button) inflate.findViewById(e.negative_btn);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(e.dialog_content);
        textView.setMaxLines(12);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (this.f20010d == C5825h.NORMAL) {
            int i;
            if (this.f20012f != null) {
                textView.setText(this.f20012f);
                linearLayout.setMinimumWidth((int) this.f20008b.getResources().getDimension(c.custom_dialog_min_width));
            } else if (this.f20015i != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.f20015i, new LayoutParams((int) this.f20008b.getResources().getDimension(c.custom_dialog_min_width), -2));
            }
            if (TextUtils.isEmpty(this.f20013g)) {
                button.setVisibility(8);
                i = 0;
            } else {
                button.setVisibility(0);
                button.setText(this.f20013g);
                if (this.f20017k != null) {
                    this.f20020n = this.f20019m.obtainMessage(-1, this.f20017k);
                    button.setOnClickListener(this.f20007a);
                }
                i = 1;
            }
            if (TextUtils.isEmpty(this.f20014h)) {
                button2.setVisibility(8);
            } else {
                button2.setVisibility(0);
                button2.setText(this.f20014h);
                if (this.f20018l != null) {
                    this.f20021o = this.f20019m.obtainMessage(-2, this.f20018l);
                    button2.setOnClickListener(this.f20007a);
                }
                i |= 2;
            }
            if (i == 1 || i == 2) {
                ((ImageView) inflate.findViewById(e.btn_divider)).setVisibility(8);
            }
        } else {
            if (TextUtils.isEmpty(this.f20012f)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(this.f20012f);
                linearLayout.setMinimumWidth((int) this.f20008b.getResources().getDimension(c.custom_dialog_min_width));
            }
            ((ProgressBar) inflate.findViewById(e.dialog_progressbar)).setVisibility(0);
            button.setVisibility(8);
            button2.setVisibility(8);
            ((ImageView) inflate.findViewById(e.content_divider)).setVisibility(8);
        }
        customDialog.setContentView(inflate);
        customDialog.setCancelable(this.f20016j);
        return customDialog;
    }
}
