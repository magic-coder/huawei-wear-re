package com.huawei.ui.homewear21.card.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.n.a;
import com.huawei.n.b;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.homewear21.c;
import com.huawei.ui.homewear21.f;
import com.huawei.ui.homewear21.g;
import com.huawei.ui.homewear21.h;
import java.util.List;

/* compiled from: DeviceSwitchAdapter */
public class C2260a extends BaseAdapter {
    private List<C2262c> f8231a;
    private Context f8232b;

    public C2260a(Context context, List<C2262c> list) {
        this.f8232b = context;
        this.f8231a = list;
    }

    public void m11694a(List<C2262c> list) {
        this.f8231a = list;
    }

    public int getCount() {
        return this.f8231a.size();
    }

    public Object getItem(int i) {
        return this.f8231a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f8232b).inflate(g.paired_device_item_layout_21, null);
        C2261b c2261b = new C2261b();
        if (inflate != null) {
            inflate.setTag(c2261b);
            c2261b.f8233a = (TextView) inflate.findViewById(f.device_name);
            c2261b.f8234b = (ImageView) inflate.findViewById(f.device_type_icon);
            c2261b.f8235c = inflate.findViewById(f.divider_line_item);
        }
        CharSequence d = ((C2262c) this.f8231a.get(i)).m11705d();
        if (TextUtils.isEmpty(d)) {
            c2261b.f8233a.setText(C1988p.m10381a(this.f8232b).m10391b(((C2262c) this.f8231a.get(i)).m11699b()));
        } else {
            c2261b.f8233a.setText(d);
        }
        m11690a(i, c2261b);
        return inflate;
    }

    private void m11690a(int i, C2261b c2261b) {
        boolean z;
        int b = ((C2262c) this.f8231a.get(i)).m11699b();
        int color = this.f8232b.getResources().getColor(c.popwindow_listitem_device_name_select);
        if (2 == ((C2262c) this.f8231a.get(i)).m11703c()) {
            z = true;
        } else {
            z = false;
        }
        if (b == 10010) {
            m11691a(c2261b);
        } else if (b == -2) {
            m11692a(c2261b, z);
        } else {
            b a = a.a(b);
            if (a.b() != 0) {
                m11693a(c2261b, z, color);
                c2261b.f8234b.setImageResource(a.b());
            }
        }
    }

    private void m11693a(C2261b c2261b, boolean z, int i) {
        if (z) {
            c2261b.f8233a.setTextColor(i);
        }
    }

    private void m11691a(C2261b c2261b) {
        c2261b.f8234b.setImageResource(h.ic_devicespinner_add);
        c2261b.f8235c.setVisibility(8);
    }

    private void m11692a(C2261b c2261b, boolean z) {
        if (z) {
            c2261b.f8233a.setTextColor(this.f8232b.getResources().getColor(c.popwindow_listitem_device_name_select));
        }
        c2261b.f8234b.setImageResource(h.ic_spinner_talkband);
    }
}
