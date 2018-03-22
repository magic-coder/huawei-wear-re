package com.huawei.sim.esim.view.p507a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.sim.esim.p505b.C5900a;
import com.huawei.sim.g;
import com.huawei.sim.h;
import java.util.ArrayList;

/* compiled from: EsimProfileAdapter */
public class C5920a extends BaseAdapter {
    private ArrayList<C5900a> f20410a;
    private LayoutInflater f20411b = LayoutInflater.from(this.f20412c);
    private Context f20412c;

    public C5920a(ArrayList<C5900a> arrayList, Context context) {
        this.f20410a = (ArrayList) arrayList.clone();
        this.f20412c = context;
    }

    public Object getItem(int i) {
        return this.f20410a.get(i);
    }

    public int getCount() {
        return this.f20410a.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C5921b c5921b;
        View view2;
        C5900a c5900a = (C5900a) this.f20410a.get(i);
        C5921b c5921b2;
        View inflate;
        if (c5900a.m27112b() == 0) {
            c5921b2 = new C5921b();
            inflate = this.f20411b.inflate(h.profile_item_normal, null);
            c5921b2.f20413a = (TextView) inflate.findViewById(g.profile_title_tips);
            c5921b2.f20414b = (TextView) inflate.findViewById(g.profile_title);
            c5921b = c5921b2;
            view2 = inflate;
        } else {
            c5921b2 = new C5921b();
            inflate = this.f20411b.inflate(h.profile_item_image, null);
            c5921b2.f20413a = (TextView) inflate.findViewById(g.profile_title_tips);
            c5921b2.f20414b = (TextView) inflate.findViewById(g.profile_title);
            c5921b2.f20415c = (ImageView) inflate.findViewById(g.profile_image);
            c5921b = c5921b2;
            view2 = inflate;
        }
        if (c5900a.m27112b() == 0) {
            c5921b.f20413a.setText(c5900a.m27108a());
            c5921b.f20414b.setText(c5900a.m27114c());
        } else {
            c5921b.f20413a.setText(c5900a.m27108a());
            c5921b.f20414b.setText(c5900a.m27114c());
            c5921b.f20415c.setImageBitmap(m27262a(c5900a.m27115d()));
        }
        return view2;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int i) {
        return ((C5900a) this.f20410a.get(i)).m27112b();
    }

    public Bitmap m27262a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }
}
