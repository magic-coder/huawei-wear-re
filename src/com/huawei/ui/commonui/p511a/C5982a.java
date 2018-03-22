package com.huawei.ui.commonui.p511a;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;

/* compiled from: CheckAdapter */
public class C5982a extends BaseAdapter {
    SparseArray<View> f20585a = new SparseArray();
    private String[] f20586b;
    private LayoutInflater f20587c;
    private Context f20588d;
    private boolean[] f20589e;

    public C5982a(Context context, String[] strArr, boolean[] zArr) {
        this.f20586b = (String[]) strArr.clone();
        this.f20589e = (boolean[]) zArr.clone();
        this.f20588d = context;
        this.f20587c = (LayoutInflater) this.f20588d.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f20586b.length;
    }

    public Object getItem(int i) {
        return this.f20586b[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean[] m27413a() {
        for (int i = 0; i < getCount(); i++) {
            this.f20589e[i] = ((CheckBox) getView(i, null, null).findViewById(C6030g.chk_selectone)).isChecked();
        }
        return (boolean[]) this.f20589e.clone();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f20585a.get(i) != null) {
            return (View) this.f20585a.get(i);
        }
        View inflate = this.f20587c.inflate(C6031h.commonui_dialog_multi_choice_item, null);
        C5985d c5985d = new C5985d();
        c5985d.f20590a = (TextView) inflate.findViewById(C6030g.contact_name);
        c5985d.f20591b = (CheckBox) inflate.findViewById(C6030g.chk_selectone);
        this.f20585a.put(i, inflate);
        if (this.f20586b != null && this.f20586b.length > 0) {
            c5985d.f20590a.setText(this.f20586b[i]);
            if (this.f20589e != null) {
                c5985d.f20591b.setChecked(this.f20589e[i]);
            } else {
                c5985d.f20591b.setChecked(false);
            }
        }
        inflate.setTag(c5985d);
        return inflate;
    }
}
