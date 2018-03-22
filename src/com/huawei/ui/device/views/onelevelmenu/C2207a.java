package com.huawei.ui.device.views.onelevelmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.p170a.af;
import java.util.HashMap;
import java.util.List;

/* compiled from: OneLevelMenuAddListAdapter */
public class C2207a extends BaseAdapter {
    private static HashMap<Integer, Boolean> f7910b;
    private List<Integer> f7911a;
    private LayoutInflater f7912c;
    private Context f7913d;

    public C2207a(Context context, List<Integer> list) {
        this.f7911a = list;
        this.f7913d = context;
        m11333b();
        this.f7912c = LayoutInflater.from(context);
    }

    private void m11333b() {
        if (f7910b == null) {
            f7910b = new HashMap();
        }
        for (int i = 0; i < this.f7911a.size(); i++) {
            f7910b.put(Integer.valueOf(i), Boolean.valueOf(false));
        }
    }

    public int getCount() {
        return this.f7911a.size();
    }

    public Object getItem(int i) {
        return this.f7911a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            C2538c.m12677c("ContactDeleteListAdapter", "ContactDeleteListAdapter getView() vie=" + view + ", item=" + ((Integer) this.f7911a.get(i)).intValue());
            C2208b c2208b = new C2208b();
            View inflate = this.f7912c.inflate(f.activity_one_level_add_menu_item_layout, null);
            c2208b.f7914a = (TextView) d.a(inflate, e.summary);
            c2208b.f7915b = (CheckBox) d.a(inflate, e.isCheckBox);
            inflate.setTag(c2208b);
            c2208b.f7914a.setText(af.m10306a().m10308a(this.f7913d, r2));
            c2208b.f7915b.setChecked(((Boolean) f7910b.get(Integer.valueOf(i))).booleanValue());
            return inflate;
        } catch (IndexOutOfBoundsException e) {
            C2538c.m12680e("ContactDeleteListAdapter", e.getMessage());
            return null;
        }
    }

    public static HashMap<Integer, Boolean> m11332a() {
        return f7910b;
    }
}
