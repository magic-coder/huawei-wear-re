package com.huawei.ui.device.views.onelevelmenu.dragonelevelsortlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.p170a.af;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MenuDragListAdapter */
public class C2209a extends BaseAdapter {
    List<Integer> f7937a = null;
    private String f7938b = "MenuDragListAdapter";
    private Context f7939c;
    private int f7940d = -1;
    private boolean f7941e = true;
    private boolean f7942f = false;
    private int f7943g = -1;
    private int f7944h;
    private C2104c f7945i = null;
    private List<Integer> f7946j = new ArrayList();

    public C2209a(Context context, List<Integer> list, C2104c c2104c) {
        this.f7939c = context;
        this.f7937a = list;
        this.f7945i = c2104c;
    }

    public void m11353a(List<Integer> list) {
        this.f7937a = list;
    }

    public void m11354a(boolean z) {
        this.f7942f = z;
    }

    public void m11351a(int i) {
        this.f7940d = i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f7939c).inflate(f.activity_one_level_menu_item_layout, null);
        int intValue = ((Integer) this.f7937a.get(i)).intValue();
        C2538c.m12677c(this.f7938b, "=========test=========mContactTables=" + this.f7937a);
        TextView textView = (TextView) d.a(inflate, e.itemText);
        textView.setText(af.m10306a().m10308a(this.f7939c, intValue));
        ((ImageView) d.a(inflate, e.itemSwitch)).setOnClickListener(new C2210b(this, i));
        if (this.f7941e) {
            if (i == this.f7940d && !this.f7942f) {
                inflate.findViewById(e.activity_one_level_menu_layout).setBackgroundColor(0);
                inflate.findViewById(e.itemhandle).setVisibility(4);
                inflate.findViewById(e.itemSwitch).setVisibility(4);
                textView.setVisibility(4);
            }
            if (this.f7943g != -1) {
                if (this.f7943g == 1) {
                    if (i > this.f7940d) {
                        inflate.startAnimation(m11349b(0, -this.f7944h));
                    }
                } else if (this.f7943g == 0 && i < this.f7940d) {
                    inflate.startAnimation(m11349b(0, this.f7944h));
                }
            }
        }
        return inflate;
    }

    public void m11352a(int i, int i2) {
        Object b = m11355b(i);
        if (i < i2) {
            this.f7946j.add(i2 + 1, (Integer) b);
            this.f7946j.remove(i);
        } else {
            this.f7946j.add(i2, (Integer) b);
            this.f7946j.remove(i + 1);
        }
        this.f7941e = true;
    }

    public Object m11355b(int i) {
        return this.f7946j.get(i);
    }

    public int getCount() {
        return this.f7937a.size();
    }

    public Object getItem(int i) {
        return this.f7937a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void m11350a() {
        this.f7946j.clear();
        for (Integer add : this.f7937a) {
            this.f7946j.add(add);
        }
    }

    public void m11356b() {
        this.f7937a.clear();
        for (Integer add : this.f7946j) {
            this.f7937a.add(add);
        }
    }

    public void m11357c(int i) {
        this.f7943g = i;
    }

    public void m11358d(int i) {
        this.f7944h = i;
    }

    private Animation m11349b(int i, int i2) {
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 0, (float) i, 1, 0.0f, 0, (float) i2);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(100);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        return translateAnimation;
    }
}
