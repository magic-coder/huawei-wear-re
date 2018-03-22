package com.huawei.ui.device.views.p172a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import java.util.List;

/* compiled from: SelectDeviceListAdapter */
public class C2185a extends BaseAdapter {
    private List<C2187c> f7773a;
    private LayoutInflater f7774b;

    public C2185a(Context context, List<C2187c> list) {
        this.f7773a = list;
        this.f7774b = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.f7773a.size();
    }

    public Object getItem(int i) {
        return this.f7773a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            C2187c c2187c = (C2187c) this.f7773a.get(i);
            if (view == null) {
                view = this.f7774b.inflate(f.activity_select_device_list_item_info_black, null);
            }
            m11200a(view, c2187c);
            return view;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private void m11200a(View view, C2187c c2187c) {
        TextView textView = (TextView) view.findViewById(e.select_device_content);
        TextView textView2 = (TextView) view.findViewById(e.select_device_summary);
        ImageView imageView = (ImageView) view.findViewById(e.select_device_icon);
        if (c2187c.m11206b() != null) {
            textView.setText(c2187c.m11206b());
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (c2187c.m11209c() != null) {
            textView2.setText(c2187c.m11209c());
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (-1 != c2187c.m11210d()) {
            imageView.setBackgroundResource(c2187c.m11210d());
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (c2187c.m11211e() != null) {
            view.setOnClickListener(c2187c.m11211e());
        }
    }
}
