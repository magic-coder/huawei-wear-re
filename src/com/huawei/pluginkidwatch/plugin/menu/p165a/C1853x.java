package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: CustomSingleChoiceDialog */
public class C1853x {
    private Context f5325a;
    private String f5326b;
    private String f5327c;
    private String f5328d;
    private View f5329e;
    private ListView f5330f;
    private OnClickListener f5331g;
    private OnItemClickListener f5332h;
    private String[] f5333i;
    private boolean[] f5334j;
    private boolean f5335k = false;

    public C1853x(Context context) {
        this.f5325a = context;
    }

    public C1853x m8929a(String str) {
        this.f5326b = str;
        return this;
    }

    public C1853x m8930a(String str, OnClickListener onClickListener) {
        this.f5328d = str;
        this.f5331g = onClickListener;
        return this;
    }

    public C1853x m8931a(String[] strArr, boolean[] zArr, int[] iArr, OnItemClickListener onItemClickListener, boolean z) {
        this.f5335k = true;
        if (strArr != null && strArr.length > 0) {
            this.f5333i = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f5333i, 0, strArr.length);
        }
        if (zArr != null) {
            this.f5334j = new boolean[zArr.length];
            System.arraycopy(zArr, 0, this.f5334j, 0, zArr.length);
        } else if (strArr != null) {
            this.f5334j = new boolean[strArr.length];
        }
        this.f5332h = onItemClickListener;
        return this;
    }

    public C1851v m8928a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f5325a.getSystemService("layout_inflater");
        C1851v c1851v = new C1851v(this.f5325a, m.Dialog);
        View inflate = layoutInflater.inflate(h.dialog_single_choice_layout, null);
        ((TextView) inflate.findViewById(g.custom_singel_choic_title)).setText(this.f5326b);
        Button button = (Button) inflate.findViewById(g.negativeButton);
        this.f5330f = (ListView) inflate.findViewById(g.multichoiceList);
        c1851v.addContentView(inflate, new LayoutParams(-2, -2));
        if (this.f5328d != null) {
            button.setText(this.f5328d);
            if (this.f5331g != null) {
                button.setOnClickListener(new C1854y(this, c1851v));
            } else {
                button.setOnClickListener(new C1855z(this, c1851v));
            }
        } else {
            button.setVisibility(8);
        }
        if (this.f5335k) {
            this.f5330f.setAdapter(new aa(this.f5325a, this.f5333i, this.f5334j));
            if (this.f5332h != null) {
                this.f5330f.setOnItemClickListener(this.f5332h);
            } else {
                this.f5330f.setOnItemClickListener(new ac());
            }
        }
        if (this.f5327c == null && this.f5329e != null) {
            ((LinearLayout) inflate.findViewById(g.content)).removeAllViews();
            ((LinearLayout) inflate.findViewById(g.content)).addView(this.f5329e, new LayoutParams(-2, -2));
        }
        c1851v.setContentView(inflate);
        return c1851v;
    }
}
