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

/* compiled from: CustomSingleChoiceDialog */
class aa extends BaseAdapter {
    SparseArray<View> f5152a = new SparseArray();
    private String[] f5153b;
    private LayoutInflater f5154c;
    private Context f5155d;
    private boolean[] f5156e;

    public aa(Context context, String[] strArr, boolean[] zArr) {
        this.f5153b = strArr;
        this.f5156e = zArr;
        this.f5155d = context;
        this.f5154c = (LayoutInflater) this.f5155d.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f5153b.length;
    }

    public Object getItem(int i) {
        return this.f5153b[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f5152a.get(i) != null) {
            return (View) this.f5152a.get(i);
        }
        View inflate = this.f5154c.inflate(h.dialog_singlechoice_item, null);
        ab abVar = new ab();
        abVar.f5157a = (TextView) inflate.findViewById(g.contact_name);
        abVar.f5158b = (CheckBox) inflate.findViewById(g.chk_selectone);
        this.f5152a.put(i, inflate);
        if (this.f5153b != null && this.f5153b.length > 0) {
            abVar.f5157a.setText(this.f5153b[i]);
            if (this.f5156e != null) {
                abVar.f5158b.setChecked(this.f5156e[i]);
            } else {
                abVar.f5158b.setChecked(false);
            }
        }
        inflate.setTag(abVar);
        return inflate;
    }
}
