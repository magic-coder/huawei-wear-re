package com.huawei.android.pushselfshow.richpush.p340b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.C4211e;
import com.huawei.android.pushselfshow.utils.p345a.C4201c;
import java.util.List;

public class C4165c extends BaseAdapter {
    private Context f15651a;
    private boolean f15652b;
    private boolean f15653c;
    private List f15654d;

    public C4170h m20326a(int i) {
        return (C4170h) this.f15654d.get(i);
    }

    public List m20327a() {
        return this.f15654d;
    }

    public void m20328a(int i, C4170h c4170h) {
        try {
            if (this.f15654d.size() >= i) {
                this.f15654d.set(i, c4170h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m20329a(boolean z) {
        this.f15652b = z;
        notifyDataSetChanged();
    }

    public void m20330b() {
        this.f15654d = C4201c.m20402a(this.f15651a, null);
    }

    public int getCount() {
        return this.f15654d.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return m20326a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4167e c4167e;
        View inflate;
        if (view == null) {
            try {
                c4167e = new C4167e();
                inflate = ((LayoutInflater) this.f15651a.getSystemService("layout_inflater")).inflate(C4211e.m20462b(this.f15651a, "hwpush_collection_item"), null);
                try {
                    c4167e.f15655a = (ImageView) inflate.findViewById(C4211e.m20463c(this.f15651a, "hwpush_favicon"));
                    c4167e.f15656b = (TextView) inflate.findViewById(C4211e.m20463c(this.f15651a, "hwpush_selfshowmsg_title"));
                    c4167e.f15657c = (TextView) inflate.findViewById(C4211e.m20463c(this.f15651a, "hwpush_selfshowmsg_content"));
                    c4167e.f15658d = (CheckBox) inflate.findViewById(C4211e.m20463c(this.f15651a, "hwpush_delCheck"));
                    inflate.setTag(c4167e);
                } catch (Exception e) {
                    Exception exception = e;
                    r0 = inflate;
                    r1 = exception;
                    e.b("PushSelfShowLog", r1.toString());
                    return r0;
                }
            } catch (Exception e2) {
                View view2;
                Exception exception2;
                exception2 = e2;
                view2 = view;
                e.b("PushSelfShowLog", exception2.toString());
                return view2;
            }
        }
        c4167e = (C4167e) view.getTag();
        inflate = view;
        Bitmap c = ((C4170h) this.f15654d.get(i)).m20342c();
        if (c == null) {
            c = BitmapFactory.decodeResource(this.f15651a.getResources(), C4211e.m20465e(this.f15651a, "hwpush_list_icon"));
        }
        c4167e.f15655a.setBackgroundDrawable(new BitmapDrawable(this.f15651a.getResources(), c));
        CharSequence charSequence = ((C4170h) this.f15654d.get(i)).m20341b().f15596r;
        if (charSequence != null && charSequence.length() > 0) {
            c4167e.f15656b.setText(charSequence);
        }
        charSequence = ((C4170h) this.f15654d.get(i)).m20341b().f15594p;
        if (charSequence != null && charSequence.length() > 0) {
            c4167e.f15657c.setText(charSequence);
        }
        if (this.f15652b) {
            c4167e.f15658d.setVisibility(4);
        } else {
            c4167e.f15658d.setVisibility(0);
            if (this.f15653c || ((C4170h) this.f15654d.get(i)).m20340a()) {
                c4167e.f15658d.setChecked(true);
            } else {
                c4167e.f15658d.setChecked(false);
            }
        }
        return inflate;
    }
}
