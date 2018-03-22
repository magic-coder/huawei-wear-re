package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.p514d.C6000d;

/* compiled from: CustomAlertDialog */
class C6005d {
    OnClickListener f20678a = new C6006e(this);
    final /* synthetic */ CustomAlertDialog f20679b;
    private View f20680c;
    private LinearLayout f20681d;
    private LinearLayout f20682e;
    private LinearLayout f20683f;
    private LinearLayout f20684g;
    private LinearLayout f20685h;
    private RelativeLayout f20686i;
    private TextView f20687j;
    private TextView f20688k;
    private Button f20689l;
    private Button f20690m;
    private Button f20691n;
    private ImageView f20692o;
    private Message f20693p;
    private Message f20694q;
    private Message f20695r;
    private EditText f20696s;
    private ImageButton f20697t;
    private ImageButton f20698u;
    private View f20699v;

    public C6005d(CustomAlertDialog customAlertDialog, Context context) {
        this.f20679b = customAlertDialog;
        m27547a(context);
    }

    private void m27547a(Context context) {
        this.f20680c = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C6031h.commonui_custom_dialog, null);
        this.f20683f = (LinearLayout) this.f20680c.findViewById(C6030g.dialog_rlyt_title);
        this.f20681d = (LinearLayout) this.f20680c.findViewById(C6030g.dialog_llyt_btn_panel);
        this.f20686i = (RelativeLayout) this.f20680c.findViewById(C6030g.dialog_rlyt_content);
        this.f20682e = (LinearLayout) this.f20680c.findViewById(C6030g.dialog_llyt_message);
        this.f20684g = (LinearLayout) this.f20680c.findViewById(C6030g.dialog_llyt_editText);
        this.f20685h = (LinearLayout) C6000d.m27461a(this.f20680c, C6030g.dialog_llyt_gender_select);
        this.f20687j = (TextView) this.f20680c.findViewById(C6030g.dialog_tv_title);
        this.f20692o = (ImageView) this.f20680c.findViewById(C6030g.dialog_iv_title);
        this.f20688k = (TextView) this.f20680c.findViewById(C6030g.dialog_tv_message);
        this.f20689l = (Button) this.f20680c.findViewById(C6030g.dialog_btn_positive);
        this.f20690m = (Button) this.f20680c.findViewById(C6030g.dialog_btn_neutral);
        this.f20691n = (Button) this.f20680c.findViewById(C6030g.dialog_btn_negative);
        this.f20696s = (EditText) C6000d.m27461a(this.f20680c, C6030g.dialog_edit_text);
        this.f20699v = this.f20680c.findViewById(C6030g.dialog_v_title_view);
        this.f20697t = (ImageButton) this.f20680c.findViewById(C6030g.gender_select_male_btn);
        this.f20698u = (ImageButton) this.f20680c.findViewById(C6030g.gender_select_female_btn);
    }

    public void m27553a(String str) {
        this.f20683f.setVisibility(0);
        this.f20687j.setVisibility(0);
        this.f20687j.setText(str);
        this.f20699v.setVisibility(0);
    }

    public void m27555b(String str) {
        this.f20686i.setVisibility(0);
        this.f20682e.setVisibility(0);
        this.f20688k.setVisibility(0);
        this.f20688k.setText(str);
        if (m27549b()) {
            this.f20688k.setGravity(19);
        } else {
            this.f20688k.setGravity(17);
        }
    }

    private boolean m27549b() {
        if (this.f20687j.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void m27552a(View view) {
        this.f20686i.setVisibility(0);
        this.f20686i.removeAllViews();
        this.f20686i.addView(view, new LayoutParams(-1, -2));
    }

    public View m27551a() {
        return this.f20680c;
    }

    public void m27554a(String str, DialogInterface.OnClickListener onClickListener) {
        this.f20681d.setVisibility(0);
        this.f20689l.setVisibility(0);
        this.f20689l.setText(str);
        if (onClickListener != null) {
            this.f20693p = CustomAlertDialog.f20612a.obtainMessage(-1, onClickListener);
            this.f20689l.setOnClickListener(this.f20678a);
        }
    }

    public void m27556b(String str, DialogInterface.OnClickListener onClickListener) {
        this.f20681d.setVisibility(0);
        this.f20690m.setVisibility(0);
        this.f20690m.setText(str);
        if (onClickListener != null) {
            this.f20694q = CustomAlertDialog.f20612a.obtainMessage(-3, onClickListener);
            this.f20690m.setOnClickListener(this.f20678a);
        }
    }

    public void m27557c(String str, DialogInterface.OnClickListener onClickListener) {
        this.f20681d.setVisibility(0);
        this.f20691n.setVisibility(0);
        this.f20691n.setText(str);
        if (onClickListener != null) {
            this.f20695r = CustomAlertDialog.f20612a.obtainMessage(-2, onClickListener);
            this.f20691n.setOnClickListener(this.f20678a);
        }
    }
}
