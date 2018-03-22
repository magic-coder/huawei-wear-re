package com.huawei.android.pushselfshow.richpush.p340b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import com.huawei.android.pushselfshow.utils.C4211e;
import java.util.List;

class C4164b implements OnItemClickListener {
    final /* synthetic */ C4163a f15649a;
    private Context f15650b;

    private C4164b(C4163a c4163a, Context context) {
        this.f15649a = c4163a;
        this.f15650b = context;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        CheckBox checkBox = (CheckBox) view.findViewById(C4211e.m20463c(this.f15650b, "hwpush_delCheck"));
        C4170h a = this.f15649a.f15641i.m20326a(i);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            a.m20339a(false);
        } else {
            checkBox.setChecked(true);
            a.m20339a(true);
        }
        this.f15649a.f15641i.m20328a(i, a);
        List<C4170h> a2 = this.f15649a.f15641i.m20327a();
        int i2 = 0;
        for (C4170h a3 : a2) {
            i2 = a3.m20340a() ? i2 + 1 : i2;
        }
        if (i2 > 0) {
            this.f15649a.f15637e.setVisibility(0);
            this.f15649a.f15637e.setText(String.valueOf(i2));
            this.f15649a.f15638f.m20335b(this.f15649a.f15642j);
            if (i2 == a2.size()) {
                this.f15649a.m20314a(this.f15650b, true);
                return;
            } else {
                this.f15649a.m20314a(this.f15650b, false);
                return;
            }
        }
        this.f15649a.f15637e.setVisibility(8);
        this.f15649a.f15637e.setText("");
        this.f15649a.f15638f.m20334a(this.f15649a.f15642j);
        this.f15649a.m20314a(this.f15650b, false);
    }
}
