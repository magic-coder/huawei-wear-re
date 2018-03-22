package com.huawei.feedback.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.feedback.bean.C4410d;
import com.huawei.feedback.d;
import com.huawei.phoneserviceuni.common.d.a;
import com.huawei.phoneserviceuni.common.d.f;
import java.util.List;
import p000a.p001a.p002a.p202b.C2852a;

/* compiled from: FeedbackDetailAdapter */
public class C4458g extends BaseAdapter {
    LayoutInflater f16583a;
    private Context f16584b;
    private List<C4410d> f16585c;

    /* compiled from: FeedbackDetailAdapter */
    class C4457a {
        private TextView f16579a;
        private TextView f16580b;
        private ImageView f16581c;
        private ImageView f16582d;

        private C4457a() {
        }
    }

    public C4458g(Context context, List<C4410d> list) {
        this.f16584b = context;
        this.f16585c = list;
        this.f16583a = LayoutInflater.from(context);
    }

    public int getItemViewType(int i) {
        if (((C4410d) this.f16585c.get(i)).m21224o() == 1) {
            return 0;
        }
        return 1;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getCount() {
        return this.f16585c.size();
    }

    public Object getItem(int i) {
        return this.f16585c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4457a c4457a;
        C4410d c4410d = (C4410d) this.f16585c.get(i);
        if (view == null) {
            C4457a c4457a2;
            View view2;
            View inflate;
            if (c4410d.m21224o() == 1) {
                inflate = this.f16583a.inflate(d.c(this.f16584b, "feedback_detail_list_item_right"), null);
                c4457a = new C4457a();
                c4457a.f16579a = (TextView) inflate.findViewById(d.a(this.f16584b, "feedback_End_content"));
                c4457a.f16580b = (TextView) inflate.findViewById(d.a(this.f16584b, "feedback_End_date"));
                c4457a.f16581c = (ImageView) inflate.findViewById(d.a(this.f16584b, "feedback_End_img"));
                c4457a.f16582d = (ImageView) inflate.findViewById(d.a(this.f16584b, "smart_icon"));
                if (a.m()) {
                    c4457a2 = c4457a;
                    view2 = inflate;
                } else {
                    c4457a.f16582d.setImageResource(d.e(this.f16584b, "feedback_personlow"));
                    c4457a2 = c4457a;
                    view2 = inflate;
                }
            } else {
                inflate = this.f16583a.inflate(d.c(this.f16584b, "feedback_detail_list_item_left"), null);
                c4457a = new C4457a();
                c4457a.f16579a = (TextView) inflate.findViewById(d.a(this.f16584b, "feedback_Start_content"));
                c4457a.f16580b = (TextView) inflate.findViewById(d.a(this.f16584b, "feedback_Start_date"));
                c4457a.f16581c = (ImageView) inflate.findViewById(d.a(this.f16584b, "feedback_Start_img"));
                c4457a2 = c4457a;
                view2 = inflate;
            }
            view2.setTag(c4457a2);
            view = view2;
            c4457a = c4457a2;
        } else {
            c4457a = (C4457a) view.getTag();
        }
        if (c4410d.m21235x() == 0 && c4410d.m21224o() == 2) {
            LinearLayout linearLayout;
            LinearLayout linearLayout2;
            if (this.f16584b.getResources().getConfiguration().orientation == 2) {
                linearLayout2 = (LinearLayout) view.findViewById(d.a(this.f16584b, "feedback_reply_score_land"));
                view.findViewById(d.a(this.f16584b, "feedback_reply_score")).setVisibility(8);
                linearLayout = linearLayout2;
            } else {
                linearLayout2 = (LinearLayout) view.findViewById(d.a(this.f16584b, "feedback_reply_score"));
                view.findViewById(d.a(this.f16584b, "feedback_reply_score_land")).setVisibility(8);
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(0);
            if (a.m()) {
                linearLayout.findViewById(d.a(this.f16584b, "feedback_score_usefull_img")).setBackgroundResource(d.e(this.f16584b, "feedback_smarthelper_ic_good_blue"));
                linearLayout.findViewById(d.a(this.f16584b, "feedback_score_useless_img")).setBackgroundResource(d.e(this.f16584b, "feedback_smarthelper_ic_bad_blue"));
            } else {
                linearLayout.findViewById(d.a(this.f16584b, "feedback_score_usefull_img")).setBackgroundResource(d.e(this.f16584b, "feedback_smarthelper_ic_good"));
                linearLayout.findViewById(d.a(this.f16584b, "feedback_score_useless_img")).setBackgroundResource(d.e(this.f16584b, "feedback_smarthelper_ic_bad"));
            }
            ((LinearLayout) linearLayout.findViewById(d.a(this.f16584b, "feedback_replay_score_usefull"))).setOnClickListener(new C4459h(this, c4410d, linearLayout));
            ((LinearLayout) linearLayout.findViewById(d.a(this.f16584b, "feedback_replay_score_useless"))).setOnClickListener(new C4460i(this, c4410d, linearLayout));
        }
        c4457a.f16579a.setText(c4410d.m21226p());
        c4457a.f16580b.setText(c4410d.m21222n());
        m21472a(c4457a.f16581c, c4410d.m21228q(), c4410d);
        return view;
    }

    private void m21471a(int i, C4410d c4410d, LinearLayout linearLayout) {
        if (a.a(this.f16584b)) {
            c4410d.m21206f(i);
            linearLayout.setVisibility(8);
            f.a(this.f16584b, this.f16584b.getString(d.b(this.f16584b, "feedback_score_thankfulness")));
            com.huawei.feedback.logic.f.b(c4410d);
            com.huawei.feedback.logic.f.d(c4410d);
            C2852a.m12942a(this.f16584b).m12947a(new Intent("UpdateRecordListBroadcast"));
            return;
        }
        f.a(this.f16584b, this.f16584b.getString(d.b(this.f16584b, "feedback_no_network_connection_prompt")));
    }

    private void m21472a(ImageView imageView, String str, C4410d c4410d) {
        Bitmap a = f.a(c4410d.m21228q(), 0, 0);
        if (a != null) {
            imageView.setVisibility(0);
            imageView.setImageBitmap(a);
            imageView.setOnClickListener(new C4461j(this, str));
            return;
        }
        imageView.setVisibility(8);
    }
}
