package com.huawei.ui.main.stories.nps.views;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import java.util.HashMap;

/* compiled from: NpsAdapter */
public class C2457a extends BaseAdapter {
    String f8825a = "NpsAdapter";
    HashMap<String, Boolean> f8826b = new HashMap();
    private Context f8827c;
    private String[] f8828d;
    private Handler f8829e;

    public C2457a(Context context, String[] strArr, HashMap<String, Boolean> hashMap, Handler handler) {
        if (strArr != null && strArr.length > 0) {
            this.f8828d = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f8828d, 0, strArr.length);
        }
        this.f8827c = context;
        this.f8826b = hashMap;
        this.f8829e = handler;
    }

    public int getCount() {
        if (this.f8828d != null) {
            return this.f8828d.length;
        }
        return 0;
    }

    public Object getItem(int i) {
        if (this.f8828d != null) {
            return this.f8828d[i];
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2459c c2459c;
        boolean z;
        C2538c.m12677c(this.f8825a, "=======position:" + i);
        CharSequence charSequence = this.f8828d[i];
        LayoutInflater from = LayoutInflater.from(this.f8827c);
        if (view == null) {
            view = from.inflate(g.nps_single, null);
            c2459c = new C2459c();
            c2459c.f8832a = (TextView) view.findViewById(f.tv_device_name);
            view.setTag(c2459c);
        } else {
            c2459c = (C2459c) view.getTag();
        }
        c2459c.f8832a.setText(charSequence);
        c2459c.f8833b = (CheckBox) view.findViewById(f.rb_light);
        c2459c.f8833b.setOnClickListener(new C2458b(this, i));
        if (this.f8826b.get(String.valueOf(i)) == null || !((Boolean) this.f8826b.get(String.valueOf(i))).booleanValue()) {
            this.f8826b.put(String.valueOf(i), Boolean.valueOf(false));
            z = false;
        } else {
            z = true;
        }
        c2459c.f8833b.setChecked(z);
        return view;
    }
}
