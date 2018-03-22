package com.huawei.ui.device.views.selectcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import java.util.HashMap;
import java.util.List;

/* compiled from: ContactSelectNumberListAdapter */
public class C2214d extends BaseAdapter {
    private static HashMap<Integer, Boolean> f7957b;
    private List<String> f7958a;
    private LayoutInflater f7959c;

    public C2214d(Context context, List<String> list) {
        this.f7958a = list;
        m11363b();
        this.f7959c = LayoutInflater.from(context);
    }

    private void m11363b() {
        int i = 1;
        if (f7957b == null) {
            f7957b = new HashMap();
        }
        f7957b.put(Integer.valueOf(0), Boolean.valueOf(true));
        while (i < this.f7958a.size()) {
            f7957b.put(Integer.valueOf(i), Boolean.valueOf(false));
            i++;
        }
    }

    public int getCount() {
        return this.f7958a.size();
    }

    public Object getItem(int i) {
        return this.f7958a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2216e c2216e = new C2216e();
        View inflate = this.f7959c.inflate(f.activity_device_settings_contact_select_number_item_layout_black, null);
        c2216e.f7988a = (TextView) inflate.findViewById(e.summary);
        c2216e.f7989b = (RadioButton) inflate.findViewById(e.isCheckedRB);
        inflate.setTag(c2216e);
        c2216e.f7988a.setText((CharSequence) this.f7958a.get(i));
        c2216e.f7989b.setChecked(((Boolean) f7957b.get(Integer.valueOf(i))).booleanValue());
        return inflate;
    }

    public static HashMap<Integer, Boolean> m11362a() {
        return f7957b;
    }
}
