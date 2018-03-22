package com.huawei.ui.device.views.selectcontact.dragsortlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.datatype.Contact;
import com.huawei.datatype.PhoneNumber;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DragListAdapter */
public class C2215a extends BaseAdapter {
    List<Contact> f7979a = null;
    private String f7980b = "DragListAdapter";
    private Context f7981c;
    private int f7982d = -1;
    private boolean f7983e = true;
    private boolean f7984f = false;
    private List<Contact> f7985g = new ArrayList();
    private int f7986h = -1;
    private int f7987i;

    public C2215a(Context context, List<Contact> list) {
        this.f7981c = context;
        this.f7979a = list;
    }

    public void m11381a(boolean z) {
        this.f7984f = z;
    }

    public void m11379a(int i) {
        this.f7982d = i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f7981c).inflate(f.activity_device_settings_contact_orderby_item_layout_black, null);
        Contact contact = (Contact) this.f7979a.get(i);
        m11376a(i, inflate);
        C2538c.m12677c(this.f7980b, "=========test=========mContactTables=" + this.f7979a);
        TextView textView = (TextView) d.a(inflate, e.content);
        textView.setText(contact.getName());
        TextView textView2 = (TextView) d.a(inflate, e.summary);
        textView2.setText(((PhoneNumber) contact.getPhoneNumbers().get(0)).getPhone_number());
        if (this.f7983e) {
            if (i == this.f7982d && !this.f7984f) {
                inflate.findViewById(e.drag_item_layout).setBackgroundColor(0);
                inflate.findViewById(e.drag_item_image).setVisibility(4);
                inflate.findViewById(e.imgView_icon).setVisibility(4);
                inflate.findViewById(e.drag_item_divider).setVisibility(4);
                textView.setVisibility(4);
                textView2.setVisibility(4);
            }
            if (this.f7986h != -1) {
                if (this.f7986h == 1) {
                    if (i > this.f7982d) {
                        inflate.startAnimation(m11377b(0, -this.f7987i));
                    }
                } else if (this.f7986h == 0 && i < this.f7982d) {
                    inflate.startAnimation(m11377b(0, this.f7987i));
                }
            }
        }
        return inflate;
    }

    private void m11376a(int i, View view) {
    }

    public void m11380a(int i, int i2) {
        Object b = m11382b(i);
        if (i < i2) {
            this.f7985g.add(i2 + 1, (Contact) b);
            this.f7985g.remove(i);
        } else {
            this.f7985g.add(i2, (Contact) b);
            this.f7985g.remove(i + 1);
        }
        this.f7983e = true;
    }

    public Object m11382b(int i) {
        return this.f7985g.get(i);
    }

    public int getCount() {
        return this.f7979a.size();
    }

    public Object getItem(int i) {
        return this.f7979a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void m11378a() {
        this.f7985g.clear();
        for (Contact add : this.f7979a) {
            this.f7985g.add(add);
        }
    }

    public void m11383b() {
        this.f7979a.clear();
        for (Contact add : this.f7985g) {
            this.f7979a.add(add);
        }
    }

    public void m11384c(int i) {
        this.f7986h = i;
    }

    public void m11385d(int i) {
        this.f7987i = i;
    }

    private Animation m11377b(int i, int i2) {
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 0, (float) i, 1, 0.0f, 0, (float) i2);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(100);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        return translateAnimation;
    }
}
