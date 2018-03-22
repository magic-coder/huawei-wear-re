package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;

/* compiled from: CustomSingleChoiceDialog */
class C6018q extends BaseAdapter {
    private String[] f20732a;
    private LayoutInflater f20733b = ((LayoutInflater) this.f20734c.getSystemService("layout_inflater"));
    private Context f20734c;
    private boolean[] f20735d;
    private OnItemClickListener f20736e;

    public C6018q(Context context, String[] strArr, boolean[] zArr, OnItemClickListener onItemClickListener) {
        this.f20732a = strArr;
        this.f20735d = zArr;
        this.f20734c = context;
        this.f20736e = onItemClickListener;
    }

    public int getCount() {
        return this.f20732a.length;
    }

    public Object getItem(int i) {
        return this.f20732a[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C6020s c6020s;
        CharSequence charSequence = this.f20732a[i];
        if (view == null) {
            view = this.f20733b.inflate(C6031h.commonui_dialog_single_choice_item, null);
            c6020s = new C6020s();
            c6020s.f20740a = (TextView) view.findViewById(C6030g.contact_name);
            view.setTag(c6020s);
        } else {
            c6020s = (C6020s) view.getTag();
        }
        c6020s.f20740a.setText(charSequence);
        CheckBox checkBox = (CheckBox) view.findViewById(C6030g.chk_selectone);
        c6020s.f20741b = checkBox;
        c6020s.f20741b.setOnClickListener(new C6019r(this, i, checkBox));
        c6020s.f20741b.setChecked(this.f20735d[i]);
        return view;
    }
}
