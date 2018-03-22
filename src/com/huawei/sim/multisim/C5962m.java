package com.huawei.sim.multisim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.sim.g;
import com.huawei.sim.h;

/* compiled from: MultiSimConfigActivity */
class C5962m extends BaseAdapter {
    private String[] f20535a;
    private LayoutInflater f20536b = ((LayoutInflater) this.f20537c.getSystemService("layout_inflater"));
    private Context f20537c;
    private boolean[] f20538d;
    private OnItemClickListener f20539e;

    public C5962m(Context context, String[] strArr, boolean[] zArr, OnItemClickListener onItemClickListener) {
        this.f20535a = strArr;
        this.f20538d = zArr;
        this.f20537c = context;
        this.f20539e = onItemClickListener;
    }

    public int getCount() {
        return this.f20535a.length;
    }

    private String m27360a(String str) {
        String a = C5969t.m27378a(str);
        return a.substring(0, 3) + "****" + a.substring(7);
    }

    public Object getItem(int i) {
        return this.f20535a[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C5964o c5964o;
        String str = this.f20535a[i];
        if (view == null) {
            view = this.f20536b.inflate(h.commonui_dialog_single_choice_item, null);
            c5964o = new C5964o();
            c5964o.f20543a = (TextView) view.findViewById(g.contact_name);
            view.setTag(c5964o);
        } else {
            c5964o = (C5964o) view.getTag();
        }
        c5964o.f20543a.setText(m27360a(str));
        CheckBox checkBox = (CheckBox) view.findViewById(g.chk_selectone);
        c5964o.f20544b = checkBox;
        c5964o.f20544b.setOnClickListener(new C5963n(this, i, checkBox));
        c5964o.f20544b.setChecked(this.f20538d[i]);
        return view;
    }
}
