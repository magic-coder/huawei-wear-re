package com.huawei.sim.esim.view.p507a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.sim.esim.p505b.C5902c;
import com.huawei.sim.f;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.ui.commonui.p514d.C5999c;
import java.util.ArrayList;

/* compiled from: WirelessAdapter */
public class C5922c extends BaseAdapter {
    private ArrayList<C5902c> f20416a;
    private LayoutInflater f20417b;
    private Context f20418c;

    public C5922c(ArrayList<C5902c> arrayList, Context context) {
        this.f20416a = (ArrayList) arrayList.clone();
        this.f20417b = LayoutInflater.from(context);
        this.f20418c = context;
    }

    public int getCount() {
        return this.f20416a.size();
    }

    public Object getItem(int i) {
        return this.f20416a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C5923d c5923d;
        C5902c c5902c = (C5902c) this.f20416a.get(i);
        if (view == null) {
            C5923d c5923d2 = new C5923d();
            view = this.f20417b.inflate(h.wireless_item_activity, null);
            c5923d2.f20419a = (TextView) view.findViewById(g.open_esim);
            c5923d2.f20420b = (TextView) view.findViewById(g.open_esim_tips);
            ImageView imageView = (ImageView) view.findViewById(g.set_tips_image);
            if (C5999c.m27456e(this.f20418c)) {
                imageView.setImageResource(f.sim_direction_left_tip_image);
            }
            view.setTag(c5923d2);
            c5923d = c5923d2;
        } else {
            c5923d = (C5923d) view.getTag();
        }
        view.setOnClickListener(c5902c.m27128b());
        c5923d.f20419a.setText(c5902c.m27125a());
        c5923d.f20420b.setText(c5902c.m27130c());
        return view;
    }
}
