package com.huawei.ui.device.views.device;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DeviceListAdapter */
public class C2198d extends Adapter<ViewHolder> implements C2197c {
    private Context f7862a;
    private List<C2202h> f7863b;
    private LayoutInflater f7864c;
    private C2039k f7865d;
    private RecyclerView f7866e;
    private Handler f7867f;
    private C2195a f7868g = null;

    public C2198d(Context context, ArrayList<C2202h> arrayList, Handler handler) {
        this.f7863b = arrayList;
        this.f7862a = context;
        this.f7867f = handler;
        this.f7864c = LayoutInflater.from(context);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C2201g(this, this.f7864c.inflate(f.fragment_main_device_list_item_info_black, viewGroup, false));
    }

    public int getItemViewType(int i) {
        return i;
    }

    public long getItemId(int i) {
        return super.getItemId(i);
    }

    public int getItemCount() {
        if (this.f7863b == null) {
            return 0;
        }
        C2538c.m12677c("DeviceListAdapter", "getItemCount(): mList is null!");
        return this.f7863b.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C2201g c2201g = (C2201g) viewHolder;
        if (this.f7863b == null) {
            C2538c.m12677c("DeviceListAdapter", "onBindViewHolder(): mList is null!");
            return;
        }
        C2538c.m12677c("DeviceListAdapter", "position = " + i + ",mList.size() = " + this.f7863b.size());
        if (i < this.f7863b.size()) {
            C2202h c2202h = (C2202h) this.f7863b.get(i);
            if (c2202h == null) {
                C2538c.m12680e("DeviceListAdapter", "onBindViewHolder(): mDeviceListItem is null, return null!");
                return;
            }
            C2538c.m12677c("DeviceListAdapter", "onBindViewHolder(): position = " + i);
            c2201g.f7888p.setOnClickListener(new C2199e(this, i));
            switch (c2202h.m11325d()) {
                case 1:
                    C2538c.m12677c("DeviceListAdapter", "onBindViewHolder():Device CONNECTING");
                    c2201g.m11313c(c2201g, c2202h);
                    break;
                case 2:
                    C2538c.m12677c("DeviceListAdapter", "onBindViewHolder():Device Connected");
                    c2201g.m11311b(c2201g, c2202h);
                    break;
                case 3:
                    C2538c.m12677c("DeviceListAdapter", "onBindViewHolder():Device DisConnected");
                    c2201g.m11308a(c2201g, c2202h);
                    break;
                case 5:
                    C2538c.m12677c("DeviceListAdapter", "onBindViewHolder():Device kidwatch");
                    c2201g.m11315d(c2201g, c2202h);
                    break;
            }
            c2201g.f7891s.setOnClickListener(new C2200f(this, i));
        }
    }

    public void m11304a(C2039k c2039k) {
        this.f7865d = c2039k;
    }

    public ViewHolder mo2639a(View view) {
        return this.f7866e.getChildViewHolder(view);
    }

    public int mo2641b(View view) {
        return this.f7866e.getChildPosition(view);
    }

    public View mo2640a(float f, float f2) {
        return this.f7866e.findChildViewUnder(f, f2);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f7866e = recyclerView;
        this.f7868g = new C2195a(this.f7866e.getContext().getApplicationContext(), this, this.f7863b);
        this.f7866e.addOnItemTouchListener(this.f7868g);
    }

    public int mo2638a(ViewHolder viewHolder) {
        ViewGroup viewGroup = (ViewGroup) viewHolder.itemView;
        if (viewGroup.getChildCount() == 2) {
            return viewGroup.getChildAt(1).getLayoutParams().width;
        }
        return 0;
    }
}
