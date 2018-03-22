package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

/* compiled from: CustomMultiChoiceDialog */
class C1848s extends BaseAdapter {
    SparseArray<View> f5318a = new SparseArray();
    private String[] f5319b;
    private LayoutInflater f5320c;
    private Context f5321d;
    private boolean[] f5322e;

    public C1848s(Context context, String[] strArr, boolean[] zArr) {
        this.f5319b = strArr;
        this.f5322e = zArr;
        this.f5321d = context;
        this.f5320c = (LayoutInflater) this.f5321d.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f5319b.length;
    }

    public Object getItem(int i) {
        return this.f5319b[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean[] m8926a() {
        for (int i = 0; i < getCount(); i++) {
            this.f5322e[i] = ((CheckBox) getView(i, null, null).findViewById(g.chk_selectone)).isChecked();
        }
        return this.f5322e;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f5318a.get(i) != null) {
            return (View) this.f5318a.get(i);
        }
        View inflate = this.f5320c.inflate(h.dialog_multichoice_item, null);
        C1849t c1849t = new C1849t();
        c1849t.f5323a = (TextView) inflate.findViewById(g.contact_name);
        c1849t.f5324b = (CheckBox) inflate.findViewById(g.chk_selectone);
        this.f5318a.put(i, inflate);
        if (this.f5319b != null && this.f5319b.length > 0) {
            c1849t.f5323a.setText(this.f5319b[i]);
            if (this.f5322e != null) {
                c1849t.f5324b.setChecked(this.f5322e[i]);
            } else {
                c1849t.f5324b.setChecked(false);
            }
        }
        inflate.setTag(c1849t);
        return inflate;
    }
}
